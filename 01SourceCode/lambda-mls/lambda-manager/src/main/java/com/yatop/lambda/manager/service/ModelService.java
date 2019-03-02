package com.yatop.lambda.manager.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.core.enums.ModelTypeEnum;
import com.yatop.lambda.core.mgr.model.ModelMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.manager.api.request.project.ModelRequest;
import com.yatop.lambda.portal.common.utils.PortalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * 模型
 *
 * @author huangyu
 * @create 2019-02-28-14:31
 */
@Service
public class ModelService {
    @Autowired
    private ModelMgr modelMgr;

    public Object query(ModelRequest vo) {
        return modelMgr.queryModel(vo.getOwnerMwId(), ModelTypeEnum.CACHED, vo.getKeyword(), vo);
    }

    public int delete(List<Long> modelIds) {
        for (Long c : modelIds) {
            modelMgr.deleteModel(c, PortalUtil.getCurrentUser().getUsername());
        }
        return modelIds.size();
    }

    public Object queryModelInfo(ModelRequest vo) {
        try {

            File file = new File(vo.getFilePath());
            String context = this.jsonRead(file);
            JSONObject  array = JSONObject.parseObject(context);
            return array;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String jsonRead(File file) {
        StringBuffer sb = new StringBuffer();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file, "utf-8");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
        String content = sb.toString();
        if (DataUtil.isEmpty(content)) {
            return "文件内容为空！";
        } else {
            return sb.toString();
        }
    }
}
