package com.yatop.lambda.manager.controller;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.manager.api.request.dataTable.*;
import com.yatop.lambda.manager.api.response.JsonResponse;
import com.yatop.lambda.manager.api.response.PagerResponse;
import com.yatop.lambda.manager.service.DataTableService;
import com.yatop.lambda.portal.common.annotation.Log;
import com.yatop.lambda.portal.common.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by xiaom on 2019/2/27.
 */
@Api(value="数据表管理管理")
@RestController
public class DataTableController extends BaseController {

    @Autowired
    private DataTableService dataTableService;

    @Log("数据表分页查询")
    @RequestMapping("dataTable/list")
    @RequiresPermissions("project:operate")
    public JsonResponse getDataTableList(@RequestBody TableRequest vo) {
        return PagerResponse.build(dataTableService.getDataTableList(vo), vo);
    }

    @Log("删除数据表")
    @RequestMapping("dataTable/delete")
    @RequiresPermissions("project:operate")
    public JsonResponse deleteDataTable(@RequestBody DeleteTableRequest vo) {
        return JsonResponse.build(dataTableService.deleteDataTable(vo));
    }

    @Log("上传数据表文件")
    @RequestMapping("dataTable/upload")
    @RequiresPermissions("project:operate")
    public JsonResponse uploadTable(@RequestParam MultipartFile file) throws Throwable {
        if (file.getSize() > 500 * 1024 * 1024) {
            throw new LambdaException(LambdaExceptionEnum.D_DATA_DEFAULT_ERROR, "The file can't be larger than 500Mb", "文件大小不能超过500Mb");
        }
        String fileName = file.getOriginalFilename();
        String[] tmp = fileName.split("\\.");
        String fileFormat = tmp[tmp.length - 1];
        if (!(fileFormat.endsWith("csv") || fileFormat.endsWith("tsv") || fileFormat.endsWith("parquet"))) {
            throw new LambdaException(LambdaExceptionEnum.D_DATA_DEFAULT_ERROR,
                    "File format must csv or tsv or parquet , please input correct fileName extension,including{csv ," +
                            "tsv,parquet}",
                    "目前只支持csv、tsv、parquet格式的文件");
        }
        DwTableUpload dwTableUpload = dataTableService.uploadTable(file);
        if (fileFormat.equalsIgnoreCase("csv")) {
            dwTableUpload.setFileType(1);
        } else if (fileFormat.equalsIgnoreCase("tsv")) {
            dwTableUpload.setFileType(2);
        } else if (fileFormat.equalsIgnoreCase("parquet")) {
            dwTableUpload.setFileType(0);
        }
        return JsonResponse.build(dwTableUpload);
    }

    @Log("预览表数据")
    @RequestMapping("dataTable/preview")
    @RequiresPermissions("project:operate")
    public JsonResponse previewTable(@RequestBody DwTablePreviewRequest request) throws Throwable {
        DwTablePreview tablePreview = dataTableService.previewTableFromExt(request.getFilePath(), request.getFileType(),
                request.getEncodingFormat(), request.getExistsHeader(),request.getLimit());
        return JsonResponse.build(tablePreview);
    }

}
