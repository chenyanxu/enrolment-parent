//package com.kalix.enrolment.question.biz;
//
//import com.kalix.enrolment.question.api.biz.IChoiceBeanService;
//import com.kalix.enrolment.question.api.biz.IFreemarkerService;
//import com.kalix.enrolment.question.api.dao.IChoiceBeanDao;
//import com.kalix.enrolment.question.entities.ChoiceBean;
//import com.kalix.framework.core.api.biz.IDownloadService;
//import com.kalix.framework.core.api.persistence.JsonData;
//import com.kalix.framework.core.api.persistence.JsonStatus;
//import com.kalix.framework.core.util.ConfigUtil;
//import com.kalix.framework.core.util.StringUtils;
//import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;
//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import org.osgi.framework.BundleContext;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.StringWriter;
//import java.util.Map;
//
///**
// * Created by angyanming at 2018-09-13
// */
//public  abstract  class FreemarkerServiceImpl  implements IFreemarkerService {
//
//
//    @Override
//    public String createDoc(String fileName,Map tempMap)
//    {
//        String htmlStr="";
//
//        Configuration configuration = new Configuration();
////        Map dataMap = new HashMap();
////        dataMap.put("stem","关关雎鸠，在河之洲。窈窕淑女，君子好逑”这一名句出自哪里？（）");
////        dataMap.put("answerA","《诗经》");
////        dataMap.put("answerB","《古诗十九首》");
////        dataMap.put("answerC","《尚书》");
////        dataMap.put("answerD","《论语》");
////
////        // List question = new ArrayList();
////        //  question.add(dataMap);
////        tempMap = new HashMap<>();
////        tempMap.put("title","选择题");
////        tempMap.put("question",dataMap);
//
//        //dataMap 要填入模本的数据文件
//        //设置模本装置方法和路径,
//        Template t=null;
//        try {
//
//            String realPath = (String) ConfigUtil.getConfigProp("word.review.realpath", "ConfigOpenOffice");
//            if (realPath.charAt(realPath.length() - 1) != '/') {
//                realPath += "/";
//            }
//            String reviewBaseDir = realPath + "questionfiles";
//            configuration.setDirectoryForTemplateLoading(new File(reviewBaseDir));
//            //test.ftl为要装载的模板
//            t = configuration.getTemplate("verse.ftl","utf-8");
//            //输出文档路径及名称
////            File outFile = new File("d:\\ddd.doc");
////            Writer out = null;
////            FileOutputStream fos=null;
////            fos = new FileOutputStream(outFile);
////            OutputStreamWriter oWriter = new OutputStreamWriter(fos,"UTF-8");
////            //这个地方对流的编码不可或缺，使用main（）单独调用时，应该可以，但是如果是web请求导出时导出后word文档就会打不开，并且包XML文件错误。主要是编码格式不正确，无法解析。
////            //out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
////            out = new BufferedWriter(oWriter);
////            t.process(tempMap, out);
////            out.close();
////            fos.close();
//            StringWriter stringWriter = new StringWriter();
//            BufferedWriter writer = new BufferedWriter(stringWriter);
//            t.setEncoding("UTF-8");
//            t.process(tempMap, writer);
//            htmlStr = stringWriter.toString();
//
////            htmlStr = htmlStr.replace("'", "&apos;");//替换单引号
////            htmlStr = htmlStr.replaceAll("&", "&amp;");//替换&
////            htmlStr = htmlStr.replace("\"", "&quot;"); // 替换双引号
////            htmlStr = htmlStr.replace("\t", "&nbsp;&nbsp;");// 替换跳格
////            htmlStr = htmlStr.replace(" ", "&nbsp;");// 替换空格
////            htmlStr = htmlStr.replace("<", "&lt;");//替换左尖括号
//
//            writer.flush();
//            writer.close();
//
//        } catch (Exception e) {
//            //logger.error("导出出错", e);
//            e.printStackTrace();
//            // throw new BusinessException(CommonResultEnum.COMMON_ERROR_637);
//        }
//        return htmlStr;
//    }
//}
