package com.yatop.lambda.manager.service;

import com.yatop.lambda.base.model.DwDataTable;
import com.yatop.lambda.base.model.DwDataWarehouse;
import com.yatop.lambda.base.model.PrProject;
import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.table.DataWarehouseMgr;
import com.yatop.lambda.core.utils.DataTableFileUtil;
import com.yatop.lambda.manager.exception.InternalServerException;
import com.yatop.lambda.manager.exception.ResourceNotFoundException;
import com.yatop.lambda.core.mgr.table.DataTableMgr;
import com.yatop.lambda.manager.api.request.dataTable.*;
import com.yatop.lambda.portal.common.utils.PortalUtil;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xiaom on 2019/2/27.
 */
@Service
public class DataTableService {

    @Autowired
    private DataTableMgr dataTableMgr;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private DataWarehouseMgr dataWarehouseMgr;

    @Value("${lambda-manager.dataTableService.uploadFileDir:./uploadFile/}")
    private String uploadFileDir;

    public List<DwDataTable> getDataTableList(TableRequest request) {
        //判断项目是否存在
        PrProject prProject = projectService.queryProject(request.getProjectId());
        return dataTableMgr.queryDataTable(prProject.getDwId(), request.getKeyword(), DataTableTypeEnum.GENERAL, DataTableStateEnum.NORMAL, request);
    }

    @Transactional
    public int deleteDataTable(DeleteTableRequest request) {
        int count = 0;
        String username = PortalUtil.getCurrentUserName();
        for (Long tableId : request.getTableIdList()) {
            DwDataTable dwDataTable = dataTableMgr.queryDataTable(tableId);
            if(dwDataTable.getTableState() != DataTableStateEnum.EMPTY.getState()){
                //TODO 清理相关的文件 根据 dfs 和 本地 路径清理文件
//                dwDataTable.getDataFile();
//                dwDataTable.getSummaryDfsFile();
//                dwDataTable.getSummaryLocalFile();
                //TODO 封装一个工具类 清理文件
            }
            count += dataTableMgr.deleteDataTable(tableId, username);
        }
        return count;
    }

    public DwTableUpload uploadTable(MultipartFile file) throws Throwable {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = format.format(new Date()) + "-" + file.getOriginalFilename();
        File dir = new File(uploadFileDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file1 = new File(uploadFileDir + fileName);
        FileUtils.writeByteArrayToFile(file1, file.getBytes());
        DwTableUpload dwTableUploadDto = new DwTableUpload();
        dwTableUploadDto.setFileName(fileName);
        dwTableUploadDto.setFilePath(file1.getAbsolutePath());
        return dwTableUploadDto;
    }


    public DwTablePreview previewTableFromExt(String filePath, Integer fileType, Integer encodingFormat,
                                              Boolean existsHeader, Integer limit) throws Throwable {
        int idx = 0;
        LineIterator it = null;
        File csvFile = new File(filePath);
        if (!csvFile.exists()) {
            throw new ResourceNotFoundException("The file does not exist , please checkParam your filePath");
        }
        DwTablePreview tablePreviewDto = new DwTablePreview();
        List<DwTableSchema> schema = new ArrayList<>();
        List<List<Object>> records = new ArrayList<>();
        Long csvFileSize = Files.size(Paths.get(filePath));
        try {
            if (encodingFormat == 0) {
                it = FileUtils.lineIterator(csvFile, "UTF-8");
            } else if (encodingFormat == 1) {
                it = FileUtils.lineIterator(csvFile, "GBK");
            }
            while (it.hasNext()) {
                String line = it.nextLine();
                readTextFile(line, schema, records, idx, limit, existsHeader, fileType);
                if (existsHeader) {
                    if (idx >= limit) {
                        break;
                    }
                } else {
                    if (idx >= limit - 1) {
                        break;
                    }
                }
                idx++;
            }
        } catch (Throwable e) {
            throw new InternalServerException("error", "error", e);
        } finally {
            LineIterator.closeQuietly(it);
        }
        tablePreviewDto.setSchema(schema);
        tablePreviewDto.setRecords(records);
        tablePreviewDto.setBaseinfo(schema.size(), csvFileSize);
        return tablePreviewDto;
    }



    private void readTextFile(String line, List<DwTableSchema> schema, List<List<Object>> records, Integer idx,
                              Integer limit, Boolean existsHeader, Integer fileType) throws IOException {
        StringReader in = null;
        CSVParser parser = null;
        try {

            in = new StringReader(line);
            if (fileType == 1) {
                parser = CSVFormat.DEFAULT.parse(in);
            } else if (fileType == 2) {
                CSVFormat formater = CSVFormat.newFormat('\t');// 制表符
                parser = formater.parse(in);
            } else {
                throw new InternalServerException("Unsupported fileType =" + fileType);
            }

            if (idx == 0) {
                if (existsHeader) {
                    CSVRecord record = parser.getRecords().get(0);
                    for (int i = 0; i < record.size(); i++) {
                        DwTableSchema dataSchemaDto = new DwTableSchema();
                        String colName = record.get(i);
                        if (colName.equals("")) {
                            colName = "col_" + i;
                        }
                        dataSchemaDto.setName(colName);
                        schema.add(dataSchemaDto);
                    }
                } else {
                    CSVRecord record = parser.getRecords().get(0);
                    List<Object> list = new ArrayList<>();
                    for (int j = 0; j < record.size(); j++) {
                        DwTableSchema dataSchemaDto = new DwTableSchema();
                        dataSchemaDto.setName("col_" + j);
                        dataSchemaDto.setType(getRecordType(record.get(j)));
                        schema.add(dataSchemaDto);
                        list.add(record.get(j));
                    }
                    records.add(list);
                }
            } else {
                CSVRecord record = parser.getRecords().get(0);
                List<Object> list = new ArrayList<>();
                for (int i = 0; i < record.size(); i++) {
                    list.add(record.get(i));
                    if (schema.size() == record.size()) {
                        schema.get(i).setType(getPriorType(schema.get(i).getType(), getRecordType(record.get(i))));
                    }
                }
                records.add(list);
            }
        } catch (Throwable e) {
        } finally {
            if (in != null) {
                in.close();
            }
            if (parser != null) {
                parser.close();
            }
        }
    }

    private String getRecordType(String obj) {
        if (obj == null || "".equals(obj)) {
            return null;
        }
        try {
            if (obj.length() <= 19 &&
                    (obj.matches("^\\+{0,1}[1-9]\\d*|^0$") || obj.matches("^-[1-9]\\d*$"))) {
                Long temp = Long.parseLong(obj);
                if (temp > 2147483647 || temp < -2147483648) {
                    return FieldDataTypeEnum.LONG.toString();
                } else {
                    return FieldDataTypeEnum.INTEGER.toString();
                }
            } else if (obj.matches("\\+{0,1}[0]\\.\\d*|^\\+{0,1}[1-9]\\d*\\.\\d*$")
                    || obj.matches("^-[0]\\.\\d*|^-[1-9]\\d*\\.\\d*$")) {
                Double temp = Double.parseDouble(obj);
                if (temp > 3.4028235E38 || temp < 1.4E-45) {
                    return FieldDataTypeEnum.DOUBLE.toString();
                } else {
                    return FieldDataTypeEnum.FLOAT.toString();
                }
            } else if (obj.equals("true") || obj.equals("false") || obj.equals("TRUE") || obj.equals("FALSE")) {
                return FieldDataTypeEnum.BOOLEAN.toString();
            } else {
                return FieldDataTypeEnum.STRING.toString();
            }
        } catch (Exception e) {
            return FieldDataTypeEnum.STRING.toString();
        }
    }


    private String getPriorType(String oldType, String newType) {
        if (oldType == null) {
            return newType;
        }
        if (newType == null) {
            return oldType;
        }
        int oldKey = FieldDataTypeEnum.valueOf(oldType).getType();
        int newKey = FieldDataTypeEnum.valueOf(newType).getType();
        if (oldKey > newKey) {
            return oldType;
        } else {
            return newType;
        }
    }

    @Transactional
    public DwDataTable saveTempTable(TableRequest request) {
        PrProject prProject = projectService.queryProject(request.getProjectId());
        DwDataWarehouse dataWarehouse = dataWarehouseMgr.queryDataWarehouse(prProject.getDwId());
        DwDataTable tempTable = dataTableMgr.queryDataTable(request.getTableId());

        if(tempTable.getTableState() == DataTableStateEnum.EMPTY.getState()) {
            throw new LambdaException(LambdaExceptionEnum.D_DATA_DEFAULT_ERROR, "Insert node info failed -- invalid insert data.", "无效插入数据");
        }

        DwDataTable dataTable = new DwDataTable();
        dataTable.setTableName(request.getTableName());
        dataTable.setOwnerDwId(dataWarehouse.getDwId());
        dataTable.setRelFlowId(-1L);
        dataTable.setRelNodeId(-1L);
        dataTable.setRelCharId("-1");
        dataTable.setDataFileType(tempTable.getDataFileType());
        dataTable.setTableState(tempTable.getTableState());
        dataTable.setTableRows(tempTable.getTableRows());
        dataTable.setTableColumns(tempTable.getTableColumns());
        dataTable.setDataFileSize(tempTable.getDataFileSize());
        dataTable = dataTableMgr.insertDataTable(dataTable, PortalUtil.getCurrentUserName());

        String dataWarehouseDfsDir = dataWarehouse.getDataDfsDir();
        String dataWarehouseLocalDir = dataWarehouse.getDataLocalDir();
        dataTable.setDataFile(DataTableFileUtil.getFilePath4General(dataWarehouseDfsDir, dataTable.getTableId()));
        dataTable.setSummaryDfsFile(DataTableFileUtil.getSummaryFilePath4General(dataWarehouseDfsDir, dataTable.getTableId()));
        dataTable.setSummaryLocalFile(DataTableFileUtil.getSummaryFilePath4General(dataWarehouseLocalDir, dataTable.getTableId()));
        dataTableMgr.updateDataTable(dataTable, PortalUtil.getCurrentUserName());

        // copy file from temp table to destination table
        //tempTable.getDataFile() copy to dataTable.getDataFile();
//                dwDataTable.getDataFile();
//                dwDataTable.getSummaryDfsFile();
//                dwDataTable.getSummaryLocalFile();

        return dataTable;
    }
}
