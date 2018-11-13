package com.kalix.enrolment.question.biz.util;

import com.kalix.middleware.attachment.entities.AttachmentBean;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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



    public void compress(ZipOutputStream out,BufferedOutputStream bos, AttachmentBean attachmentBean) throws IOException
    {
        HttpURLConnection httpUrl = null;
        BufferedInputStream bis=null;
        URL urlfile = null;
        try {

            urlfile = new URL(attachmentBean.getAttachmentPath());

            httpUrl = (HttpURLConnection) urlfile.openConnection();
            httpUrl.connect();
            out.putNextEntry(new ZipEntry(attachmentBean.getAttachmentName()) );
            //        FileInputStream fos = new FileInputStream(httpUrl.getInputStream());
            bis = new BufferedInputStream(httpUrl.getInputStream());
            //创建缓冲输出流
            int tag;
            byte[] buffer = new byte[1024];
            //将源文件写入到zip文件中
            while((tag=bis.read(buffer))!=-1)
            {
                bos.write(buffer, 0, tag);
                bos.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bis != null) bis.close();
            if (httpUrl != null) httpUrl.disconnect();
        }

    }


    public void doZip(List list, ZipOutputStream out) throws IOException {

        BufferedOutputStream bos=null;
        try {
        //如果路径为目录（文件夹）
        if(list!=null&&list.size()>0)
        {
            bos = new BufferedOutputStream(out);
            for(int i=0;i<list.size();i++)
            {
                AttachmentBean attachmentBean = (AttachmentBean)list.get(i);

                    compress(out,bos,attachmentBean);

            }

        }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bos != null) bos.close();
        }





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



