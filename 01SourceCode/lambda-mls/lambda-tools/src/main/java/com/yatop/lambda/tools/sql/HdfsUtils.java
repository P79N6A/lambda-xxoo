package com.yatop.lambda.tools.sql;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class HdfsUtils {
    private static Logger logger = LoggerFactory.getLogger(HdfsUtils.class);

    private FileSystem fileSystem;

    public HdfsUtils(String hdfsURI, String hdfsUser) throws IOException, InterruptedException, URISyntaxException {
        Configuration configuration = new Configuration();
        this.fileSystem = FileSystem.get(new URI(hdfsURI), configuration, hdfsUser);
    }

    public HdfsUtils() throws IOException, InterruptedException, URISyntaxException {
        InputStream inputStream = HdfsUtils.class.getClassLoader().getResourceAsStream("lambda-mls.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        URI hdfsURI = new URI(properties.getProperty("hdfs.URI"));
        String hdfsUser = properties.getProperty("hdfs.user");
        Configuration configuration = new Configuration();
        this.fileSystem = FileSystem.get(hdfsURI, configuration, hdfsUser);
    }




    /**
     * @param hdfsFile 文件路径
     * @return byte
     * @throws Exception 异常
     */
    public byte[] getBytes(String hdfsFile) throws Exception {
        if (hdfsFile == null) {
            logger.error("file is null");
            throw new Exception("file is null");
        }
        FSDataInputStream is = null;
        byte[] buffer;
        try {
            Path path = new Path(hdfsFile);
            if (this.fileSystem == null || !this.fileSystem.exists(path)) {
                logger.error("{} do not contains any files!", path);
                throw new Exception(path + " do not contain any files!");
            }
            is = this.fileSystem.open(path);
            FileStatus stat = this.fileSystem.getFileStatus(path);
            buffer = new byte[Integer.parseInt(String.valueOf(stat.getLen()))];
            is.readFully(0, buffer);
            return buffer;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * 读取hdfs文件
     *
     * @param hdfsFile 文件路径
     * @return 文件内容
     * @throws Exception 异常
     */
    public String readFile(String hdfsFile) throws Exception {
        return new String(getBytes(hdfsFile));
    }


    /**
     *  写hdfs文件
     * @param content 写的内容
     * @param hdfsFile 写的路径, 指定到文件名
     * @param overwrite 是否覆盖
     * @throws IOException 异常
     */
    public void writeFile(String content, String hdfsFile, boolean overwrite) throws IOException {
        FSDataOutputStream fsDataOutputStream = this.fileSystem.create(new Path(hdfsFile), overwrite);
        fsDataOutputStream.write(content.getBytes(StandardCharsets.UTF_8));
        fsDataOutputStream.hflush();
        fsDataOutputStream.hsync();
        fsDataOutputStream.close();

    }

    /**
     * 从指定路径获取Json文件，并以JsonObject形式返回
     *
     * @return 返回 JsonObject 对象
     * @throws Exception 异常
     */
    public JSONObject getJsonObject(String hdfsFile) throws Exception {
        if (hdfsFile == null) {
            logger.error("file is null");
            throw new Exception("file is null");
        }
        try {
            String jsonString;
            hdfsFile = hdfsFile.trim();
            jsonString = new String(getBytes(hdfsFile), StandardCharsets.UTF_8);
            return JSONObject.parseObject(jsonString);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }
    }


    /**
     * @param hdfsFile 获取文件输入流
     * @return 输入流
     * @throws Exception 异常
     */
    public InputStream getInputStream(String hdfsFile) throws Exception {
        if (hdfsFile == null) {
            logger.error("file is null");
            throw new Exception("file is null");
        }
        return this.fileSystem.open(new Path(hdfsFile));
    }

    /**
     *  是否为目录
     * @param hdfsDir hdfs路径
     * @return 是否
     * @throws IOException 异常
     */
    public boolean isDir(String hdfsDir) throws IOException {
        return this.fileSystem.isDirectory(new Path(hdfsDir));
    }

    /**
     * 创建hdfs目录
     * @param hdfsDir hdfs 目录路径
     * @return 是否创建成功
     * @throws IOException 异常
     */
    public boolean createDir(String hdfsDir) throws IOException {
        return this.fileSystem.mkdirs(new Path(hdfsDir));
    }

    /**
     * 判断目录或文件是否存在
     * @param hdfsFile  hdfs路径
     * @return 是否
     * @throws IOException 异常
     */
    public boolean checkExists(String hdfsFile) throws IOException {
        return this.fileSystem.exists(new Path(hdfsFile));
    }

    /**
     * 获取目录下的所有文件名
     *
     * @param hdfsDir hdfs目录
     * @return 文件名列表
     * @throws Exception 异常
     */
    public List<String> listAllFiles(String hdfsDir) throws Exception {
        if (!isDir(hdfsDir)) {
            logger.error("path is not a hdfs directory");
            throw new Exception("path is not a hdfs directory");
        }
        FileStatus[] fileStatus = this.fileSystem.listStatus(new Path(hdfsDir));
        ArrayList<String> arrayList = new ArrayList<>();
        for (Path p : FileUtil.stat2Paths(fileStatus)) {
            arrayList.add(p.getName());
        }
        return arrayList;
    }

    /**
     * 下载目录到本地
     *
     * @param hdfsDir   hdfs 路径
     * @param localDir  本地路径
     * @param overwrite 是否覆盖
     * @throws Exception 异常
     */
    public void downloadDir(String hdfsDir, String localDir, Boolean overwrite) throws Exception {
        Path hdfsPath = new Path(hdfsDir);

        if (!this.fileSystem.exists(hdfsPath)) {
            logger.error("path is not exists");
            throw new Exception("path is not exists");
        }
        File localFile = new File(localDir);
        if (!localFile.isDirectory()) {
            localFile.mkdirs();
        }
        if (overwrite) {
            File actualLocalDir = new File(localFile.getAbsolutePath() + File.separator + new Path(hdfsDir).getName());
            if (actualLocalDir.exists()) {
                if (actualLocalDir.isFile()) {
                    actualLocalDir.delete();
                } else {
                    File[] files = actualLocalDir.listFiles();
                    if (files != null && files.length > 0) {
                        for (File f : files) {
                            f.delete();
                        }
                        actualLocalDir.delete();
                    } else {
                        actualLocalDir.delete();
                    }

                }

            }
        }
        this.fileSystem.copyToLocalFile(hdfsPath, new Path(localDir));
    }


    /**
     * 上传目录到HDFS
     *
     * @param localDir  本地路径
     * @param hdfsDir   hdfs 路径
     * @param overwrite 是否覆盖
     * @throws Exception 异常
     */
    public void uploadDir(String localDir, String hdfsDir, Boolean overwrite) throws Exception {
        File localFile = new File(localDir);
        if (!localFile.exists()) {
            logger.error("path is not exists");
            throw new Exception("path is not exists");
        }
        Path hdfsPath = new Path(hdfsDir);
        Path actualHdfsPath = new Path(hdfsPath.toString() + Path.SEPARATOR);


        if (!this.fileSystem.exists(actualHdfsPath)) {
//            System.out.println(actualHdfsPath.toString());
            createDir(actualHdfsPath.toString());
        }

        this.fileSystem.copyFromLocalFile(false, overwrite, new Path(localDir), new Path(hdfsDir));
    }




}
