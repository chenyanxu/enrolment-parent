package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IPaperBeanService;
import com.kalix.enrolment.question.biz.util.doZipUtils;
import com.kalix.enrolment.question.entities.PaperBean;
import com.kalix.framework.core.api.biz.IDownloadService;
import com.kalix.framework.core.impl.biz.CustomServlet;
import com.kalix.framework.core.util.ConfigUtil;
import com.kalix.framework.core.util.JNDIHelper;
import com.kalix.framework.core.util.StringUtils;
import com.kalix.middleware.attachment.api.biz.IAttachmentBeanService;
import com.kalix.middleware.attachment.entities.AttachmentBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * Created by hqj on 2018/10/22.
 * servlet基类服务，根据资源路径下载文件
 * 请求地址custom-servlet.xml配置: "/camel/rest/custom/servlet"
 * 请求参数: "?classname=DownloadFromResServlet&foldername=&filename=xxx&filetype=image"
 */
public class DownloadPaperServlet extends CustomServlet {
    private IPaperBeanService paperBeanService;
    private IAttachmentBeanService attachmentBeanService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream  out_zip=null;
        FileInputStream zipInputStream=null;
        File zipFile=null;
        try {
            String fileName="";
            List list=null;
            // 预览文件类型
            String fileType = req.getParameter("filetype") == null ? "" : req.getParameter("filetype");
            // 预览文件目录
            String ids = req.getParameter("ids") == null ? "" : req.getParameter("ids");
            // 预览文件名称
            String paperId = req.getParameter("paperId") == null ? "" : req.getParameter("paperId");
            paperBeanService = JNDIHelper.getJNDIServiceForName(IPaperBeanService.class.getName());
            PaperBean paperBean=paperBeanService.getEntity(Long.parseLong(paperId));
            fileName= paperBean.getTitle();
// 预览文件真实路径地址
            String realPath = (String) ConfigUtil.getConfigProp("word.review.realpath", "ConfigOpenOffice");
            if (realPath.charAt(realPath.length() - 1) != '/') {
                realPath += "/";
            }
            // 设置默认预览文件地址
            String reviewBaseDir = realPath + "reviewfiles";
            switch (fileType.toLowerCase()) {
                case "zip":
                    String fileName_str = fileName+".zip";
                    String xlsPath = "";
                    resp.setHeader("Access-Control-Allow-Origin", "*");
                    resp.setHeader("Access-Control-Allow-Credentials", "true");
                    resp.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
                    resp.setContentType("application/octet-stream; charset=utf-8");
                    resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName_str, "UTF-8"));
                   //  out_zip = new ZipOutputStream(resp.getOutputStream());
                    attachmentBeanService = JNDIHelper.getJNDIServiceForName(IAttachmentBeanService.class.getName());
                    doZipUtils doZipUtils = new doZipUtils();
                    if(!StringUtils.isEmpty(ids)){
                        list=new ArrayList();
                        if(ids.indexOf(",")>-1){
                            String [] str =ids.split(",");
                            for(String id: str){
                                AttachmentBean attachmentBean= attachmentBeanService.getEntity(Long.parseLong(id));
                                list.add(attachmentBean);
                            }

                        }else {
                            AttachmentBean attachmentBean= attachmentBeanService.getEntity(Long.parseLong(ids));
                            list.add(attachmentBean);
                        }
                    }
                    String path=doZipUtils.doZip(list,reviewBaseDir,fileName);
                     zipFile = new File(path);
                    zipInputStream = new FileInputStream(zipFile);
                    out_zip = resp.getOutputStream();
                    BufferedOutputStream zipBos = new BufferedOutputStream(out_zip);
                    int xlsLen = 2048;
                    byte[] xlsB = new byte[xlsLen];
                    while ((xlsLen = zipInputStream.read(xlsB)) != -1) {
                        zipBos.write(xlsB, 0, xlsLen);
                    }
                    zipBos.flush();
                    resp.flushBuffer();
                    default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if(zipInputStream!=null)
            {
                zipInputStream.close();
            }
            if (out_zip != null) {
                out_zip.close();
            }
            if(zipFile.exists()){
                zipFile.delete();
            }
        }
    }

    /**
     * 初始化预览文件夹
     * 不存在则创建文件夹
     *
     * @param reviewBaseDir
     * @param fileTypeFolder
     * @param folderName
     * @return
     */
    private void initReviewDir(String reviewBaseDir, String fileTypeFolder, String folderName) {
        String fileTypePath = reviewBaseDir + "/" + fileTypeFolder;
        String filePath = "";
        if (folderName.equals("")) {
            filePath = fileTypePath;
        } else {
            filePath = fileTypePath + "/" + folderName;
        }
        File fileBaseDir = new File(reviewBaseDir);
        if (!fileBaseDir.exists()) {
            fileBaseDir.mkdir();
        }
        File fileTypeDir = new File(fileTypePath);
        if (!fileTypeDir.exists()) {
            fileTypeDir.mkdir();
        }
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
    }
}
