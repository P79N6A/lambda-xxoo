import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.tools.sql.HdfsUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class HdfsUtilsTest {

    @Test
    public void getBytes() throws Exception {
        HdfsUtils hdfsUtil = new HdfsUtils("hdfs://192.168.20.41:8020", "root");
        byte[] bytes = hdfsUtil.getBytes("/tmp/aaaa.txt");
        System.out.println(new String(bytes));
    }

    @Test
    public void getJsonObject() throws Exception {
        HdfsUtils hdfsUtil = new HdfsUtils("hdfs://192.168.20.41:8020", "root");
        JSONObject jsonObject = hdfsUtil.getJsonObject("hdfs://192.168.20.41/tmp/TaskSubmitTemplate2.json");
        System.out.println(jsonObject.get("currentJob").toString());
    }

    @Test
    public void readFile() throws Exception {
        HdfsUtils hdfsUtil = new HdfsUtils("hdfs://192.168.20.41:8020", "root");
        String s = hdfsUtil.readFile("/tmp/aaaa.txt");
        System.out.println(s);
    }

    @Test
    public void getInputStream() throws Exception {
        HdfsUtils hdfsUtil = new HdfsUtils("hdfs://192.168.20.41:8020", "root");
        InputStream inputStream = hdfsUtil.getInputStream("/tmp/aaaa.txt");
        byte[] b = new byte[1024];
        int len;
        while ((len = inputStream.read(b)) != -1) {
            System.out.println(len);
            String str = new String(b);
            System.out.println(str);
        }

    }

    @Test
    public void listAllFiles() throws Exception {
        HdfsUtils hdfsUtil = new HdfsUtils("hdfs://192.168.20.41:8020", "root");
        List<String> list= hdfsUtil.listAllFiles("/tmp");
        for(String s: list){
            System.out.println(s);
        }

    }

    @Test
    public void downloadDir() throws Exception {
        HdfsUtils hdfsUtil = new HdfsUtils("hdfs://192.168.20.41:8020", "root");

        // 测试目录
        hdfsUtil.downloadDir("/tmp/crh_test_1", "F:\\yatop\\projects\\yatop-ai\\yatop-ai3" +
                "\\lambda-mls-component\\lambda-component\\src\\main\\java\\com\\yatop\\lambda\\component\\utils\\test",
                true);

        // 测试文件
        hdfsUtil.downloadDir("/tmp/aaaa.txt", "F:\\yatop\\projects\\yatop-ai\\yatop-ai3" +
                "\\lambda-mls-component\\lambda-component\\src\\main\\java\\com\\yatop\\lambda\\component\\utils\\test2",
                true);

    }

    @Test
    public void uploadDir() throws Exception {
        HdfsUtils hdfsUtil = new HdfsUtils("hdfs://192.168.20.41:8020", "root");

        // 测试文件
        hdfsUtil.uploadDir("F:\\yatop\\projects\\yatop-ai\\yatop-ai3\\lambda-mls-component\\lambda-component" +
                "\\src\\main\\java\\com\\yatop\\lambda\\component\\utils\\test2\\aaaa.txt",
                "/tmp/crh/crh/crh", true);

        //测试目录
        hdfsUtil.uploadDir("F:\\yatop\\projects\\yatop-ai\\yatop-ai3\\lambda-mls-component\\lambda-component" +
                "\\src\\main\\java\\com\\yatop\\lambda\\component\\utils\\test\\crh_test_1",
                "/tmp/crh/crh3/crh3/", false);
    }

    @Test
    public void createDir() throws IOException, URISyntaxException, InterruptedException {
        HdfsUtils hdfsUtil = new HdfsUtils("hdfs://192.168.20.41:8020", "root");
        hdfsUtil.createDir("/tmp/crh/crh3/crh3");
    }

    @Test
    public void writeFile() throws InterruptedException, IOException, URISyntaxException {
        HdfsUtils hdfsUtil = new HdfsUtils("hdfs://192.168.20.41:8020", "root");
        hdfsUtil.writeFile("测试", "/tmp/crh3/crh/crh3/test.txt", true);
    }

    @Test
    public void readParquet() throws InterruptedException, IOException, URISyntaxException {
//        Map<String, List<String[]>> parquetInfo = HdfsUtils.readParquet("file:\\F:\\yatop\\projects\\yatop-ai\\yatop-ai3\\lambda-mls-component\\lambda-component\\src\\main\\testDataSet\\yatop_train", 2);
//        for (String[] cols: parquetInfo.get("head")){
//            for(String col: cols){
//                System.out.println(col);
//            }
//        }
//
//        for (String[] cols: parquetInfo.get("data")){
//            for(String col: cols){
//                System.out.println(col);
//            }
//        }

        Map<String, Object> parquetInfo2 = HdfsUtils.readParquet("hdfs://192.168.20.41:8020/tmp/test/yatop_train22", 2);
//        for (String[] cols: (List<String[]>) parquetInfo2.get("head")){
//            for(String col: cols){
//                System.out.println(col);
//            }
//        }
//
//        for (Map<String, String> colMap: (List<Map<String, String>>) parquetInfo2.get("records")){
//            for(String col: colMap.keySet()){
//                System.out.println(col);
//            }
//            for(String value: colMap.values()){
//                System.out.println(value);
//            }
//
//        }

        System.out.println(JSONObject.toJSONString(parquetInfo2));

    }

}