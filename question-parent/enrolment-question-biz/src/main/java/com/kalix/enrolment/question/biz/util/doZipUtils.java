package com.kalix.enrolment.question.biz.util;

import com.kalix.framework.core.util.StringUtils;
import com.kalix.middleware.attachment.entities.AttachmentBean;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator_ on 2018/11/9.
 */
public class doZipUtils {

    public String doZip(List list,Map map) throws IOException {
        ArrayList filesToAdd = new ArrayList();
        String rtnUrl="";
        HttpURLConnection httpUrl = null;
        URL urlfile = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        String path=map.get("path").toString();
        String filename=map.get("filename").toString();
        String password=map.get("password").toString();
        rtnUrl=path+File.separatorChar+filename;
       // parameters.setSourceExternalStream(true);
        try {
            //如果路径为目录（文件夹）
            if(list!=null&&list.size()>0)
            {

                ZipFile zipFile = new ZipFile(rtnUrl+".zip");
                ZipParameters parameters = new ZipParameters();
                // 压缩方式
                parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
                // 压缩级别
                parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
                parameters.setSourceExternalStream(true);
                if(!StringUtils.isEmpty(password)){
                    parameters.setEncryptFiles(true);
                    parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
                    //parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
                    parameters.setPassword(password);
                }

                for(int i=0;i<list.size();i++)
                {
                    AttachmentBean attachmentBean = (AttachmentBean)list.get(i);
                    urlfile = new URL(attachmentBean.getAttachmentPath());

                    httpUrl = (HttpURLConnection) urlfile.openConnection();
                    httpUrl.connect();
                    parameters.setFileNameInZip(attachmentBean.getAttachmentName());
                    zipFile.addStream(httpUrl.getInputStream(), parameters);

                }
//                rtnUrl=path+File.separatorChar+filename;
//                File file = new File(rtnUrl+File.separatorChar);
//                if(file.exists()&&file.isDirectory())
//                {
//                    ZipFile zipFile = new ZipFile(rtnUrl+".zip");
//                    ZipParameters parameters = new ZipParameters();
//                    // 压缩方式
//                    parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
//                    // 压缩级别
//                    parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
//                    if(!StringUtils.isEmpty(password)){
//                        parameters.setEncryptFiles(true);
//                        parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
//                        //parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
//                        parameters.setPassword(password);
//                    }
//                    // 要打包的文件夹
//                    File[] fs = file.listFiles();
//                    // 遍历test文件夹下所有的文件、文件夹
//                    for (File f : fs) {
//                        if (f.isDirectory()) {
//                          //  zipFile.addFolder(f.getPath(), parameters);
//                        } else {
//                           // zipFile.addFile(f, parameters);
//                            filesToAdd.add(f);
//                        }
//                    }
//                    zipFile.addFiles(filesToAdd, parameters);
//
//                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ZipException e) {
            e.printStackTrace();
        } finally {

//            if (bis != null) bis.close();
//            if (bos != null) bos.close();
            if (httpUrl != null) httpUrl.disconnect();
          //  delFolder(path+File.separatorChar+filename);

        }
        return rtnUrl+".zip";
    }

    public static void creatFile(String filePath, String fileName) {
        File folder = new File(filePath);
        //文件夹路径不存在
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
        } else {

        }

        // 如果文件不存在就创建
        File file = new File(filePath + fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件已存在，文件为:" + filePath + fileName);
        }
    }

    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); //删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            java.io.File myFilePath = new java.io.File(filePath);
            myFilePath.delete(); //删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除指定文件夹下所有文件
//param path 文件夹完整绝对路径
    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);//再删除空文件夹
                flag = true;
            }
        }
        return flag;
    }


//    public static void main(String[] args)
//    {
//        doZipUtils zipCom = new doZipUtils("D:\\电影.zip","F:\\电影");
//        try
//        {
//            zipCom.doZip("http://localhost:5984/kalix/1f0058f450d2470783842aa8f4ebd3f7/20181109084600.doc","");
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//    }

}



