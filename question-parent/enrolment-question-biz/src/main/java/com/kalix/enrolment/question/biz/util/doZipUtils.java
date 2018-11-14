package com.kalix.enrolment.question.biz.util;

import com.kalix.middleware.attachment.entities.AttachmentBean;
import com.training.commons.file.FileUtils;
import net.lingala.zip4j.exception.ZipException;
import nochump.util.extend.ZipOutput;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
//import java.util.zip.ZipEntry;
//
//import java.util.zip.ZipOutputStream;

/**
 * Created by Administrator_ on 2018/11/9.
 */
public class doZipUtils {
    private String zipFileName;      // 目的地Zip文件
    private String sourceFileName;   //源文件（带压缩的文件或文件夹）

//    public doZipUtils(String zipFileName,String sourceFileName)
//    {
//        this.zipFileName=zipFileName;
//        this.sourceFileName=sourceFileName;
//    }



//    public void compress(ZipOutputStream out,BufferedOutputStream bos, AttachmentBean attachmentBean) throws IOException
//    {
//        HttpURLConnection httpUrl = null;
//        BufferedInputStream bis=null;
//        URL urlfile = null;
//        try {
//
//            urlfile = new URL(attachmentBean.getAttachmentPath());
//
//            httpUrl = (HttpURLConnection) urlfile.openConnection();
//            httpUrl.connect();
//            out.putNextEntry(new ZipEntry(attachmentBean.getAttachmentName()) );
//            //        FileInputStream fos = new FileInputStream(httpUrl.getInputStream());
//            bis = new BufferedInputStream(httpUrl.getInputStream());
//            //创建缓冲输出流
//            int tag;
//            byte[] buffer = new byte[1024];
//            //将源文件写入到zip文件中
//            while((tag=bis.read(buffer))!=-1)
//            {
//                bos.write(buffer, 0, tag);
//                bos.flush();
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if (bis != null) bis.close();
//            if (httpUrl != null) httpUrl.disconnect();
//        }
//
//    }
//
//
//    public void doZip(List list, ZipOutputStream out) throws IOException, ZipException {
//
//        BufferedOutputStream bos=null;
//        try {
//        //如果路径为目录（文件夹）
//        if(list!=null&&list.size()>0)
//        {
//
//            bos = new BufferedOutputStream(out);
//            for(int i=0;i<list.size();i++)
//            {
//                AttachmentBean attachmentBean = (AttachmentBean)list.get(i);
//
//                    compress(out,bos,attachmentBean);
//
//            }
//
//        }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if (bos != null) bos.close();
//        }
//
//
//
//
//
//    }

    public String doZip(List list,String path,String filename) throws IOException, ZipException {

        String rtnUrl="";
        HttpURLConnection httpUrl = null;
        URL urlfile = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
       // parameters.setSourceExternalStream(true);
        try {
            //如果路径为目录（文件夹）
            if(list!=null&&list.size()>0)
            {
                for(int i=0;i<list.size();i++)
                {
                    AttachmentBean attachmentBean = (AttachmentBean)list.get(i);
                    urlfile = new URL(attachmentBean.getAttachmentPath());

                    httpUrl = (HttpURLConnection) urlfile.openConnection();
                    httpUrl.connect();
                    File file = new File(path+File.separatorChar+filename);
                    creatFile(path+File.separatorChar+filename+File.separatorChar,attachmentBean.getAttachmentName());
                    bis = new BufferedInputStream(httpUrl.getInputStream());
                    bos = new BufferedOutputStream(new FileOutputStream(path+File.separatorChar+filename+File.separatorChar+attachmentBean.getAttachmentName()));
                    int len = 2048;
                    byte[] b = new byte[len];
                    while ((len = bis.read(b)) != -1) {
                        bos.write(b, 0, len);
                    }
                    bos.flush();
                }
                rtnUrl=path+File.separatorChar+filename;
                File file = new File(rtnUrl+File.separatorChar);
                if(file.exists()&&file.isDirectory())
                {
                    byte[] zipByte= ZipOutput.getEncryptZipByte(file.listFiles(),"123");
                    FileUtils.writeByteFile(zipByte, new File(rtnUrl+".zip"));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bis != null) bis.close();
            if (bos != null) bos.close();
            if (httpUrl != null) httpUrl.disconnect();
            httpUrl.disconnect();
            delFolder(path+File.separatorChar+filename);

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



