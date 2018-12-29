package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.*;
import com.kalix.enrolment.question.biz.util.PassWordCreate;
import com.kalix.enrolment.question.biz.util.doZipUtils;
import com.kalix.enrolment.question.dto.model.BatchDeleteDTO;
import com.kalix.enrolment.question.dto.model.QuestionDTO;
import com.kalix.enrolment.question.dto.model.RuleDto;
import com.kalix.enrolment.question.entities.BaseQuestionEntity;
import com.kalix.enrolment.question.entities.PaperBean;
import com.kalix.enrolment.question.entities.PaperQuesBean;
import com.kalix.enrolment.question.entities.PasswordBean;
import com.kalix.enrolment.system.dict.api.biz.IEnrolmentDictBeanService;
import com.kalix.enrolment.system.dict.entities.EnrolmentDictBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.util.*;
import com.kalix.middleware.attachment.api.biz.IAttachmentBeanService;
import com.kalix.middleware.attachment.entities.AttachmentBean;
import com.kalix.middleware.couchdb.api.biz.ICouchdbService;
import com.kalix.middleware.websocket.api.biz.IWebsocketService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.json.JSONObject;
import org.lightcouch.Response;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator_ on 2018/9/17.
 */
public class QuestionCommonBizServiceImpl implements IQuestionCommonBizService, IWebsocketService {

    protected static String DICT_QUESTIONTYPE = "题型";
    protected static String DICT_TYPE = "类别";
    protected static String DICT_KSKM = "考试科目";
    protected static String DICT_MSTLX = "面试题类型";
    protected static String DICT_ZGTLX = "主观题类型";
    private IEnrolmentDictBeanService enrolmentDictBeanService;
    private ICouchdbService couchdbService;
    private IAttachmentBeanService attachmentBeanService;
    private IPaperBeanService paperBeanService;
    private IRuleBeanService ruleBeanService;
    private IPaperQuesBeanService paperQuesBeanService;
    private IQuestionRepeatedBeanService questionRepeatedBeanService;
    private IRepeatedService repeatedService;
    private IQuestionService questionService;

    /**
     * 查询试题排重比对情况
     *
     * @param page
     * @param limit
     * @param jsonStr
     * @param sort
     * @return
     */
    @Override
    public JsonData getAllQuestionRepeateds(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        try {
            Map queryMap = SerializeUtil.json2Map(jsonStr);
            String questionType = (String) queryMap.get("questionType");
            if (StringUtils.isEmpty(questionType)) {
                return jsonData;
            }
            EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_QUESTIONTYPE, questionType);
            String beanName = enrolmentDictBean.getDescription();
            Map<String, String> map = new HashMap<String, String>();
            map.put("beanName", beanName);
            repeatedService = JNDIHelper.getJNDIServiceForName(IRepeatedService.class.getName(), map);
            jsonData = repeatedService.getAllQuestionRepeateds(page, limit, jsonStr, sort);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    /**
     * 获取比对后有重复的试题
     *
     * @param page
     * @param limit
     * @param jsonStr
     * @param sort
     * @return
     */
    @Override
    public JsonData getFirstQuestions(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        try {
            Map queryMap = SerializeUtil.json2Map(jsonStr);
            String questionType = (String) queryMap.get("questionType");
            if (StringUtils.isEmpty(questionType)) {
                return jsonData;
            }
            queryMap.remove("questionType");
            jsonStr = SerializeUtil.serializeJson(queryMap);
            EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_QUESTIONTYPE, questionType);
            String beanName = enrolmentDictBean.getDescription();
            Map<String, String> map = new HashMap<String, String>();
            map.put("beanName", beanName);
            repeatedService = JNDIHelper.getJNDIServiceForName(IRepeatedService.class.getName(), map);
            jsonData = repeatedService.getFirstQuestions(page, limit, jsonStr, sort);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    /**
     * 选择一道试题后，获取和该试题重复的所有试题
     *
     * @param page
     * @param limit
     * @param jsonStr
     * @param sort
     * @return
     */
    @Override
    public JsonData getSecondQuestions(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        try {
            Map queryMap = SerializeUtil.json2Map(jsonStr);
            String questionType = (String) queryMap.get("questionType");
            if (StringUtils.isEmpty(questionType)) {
                return jsonData;
            }
            EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_QUESTIONTYPE, questionType);
            String beanName = enrolmentDictBean.getDescription();
            Map<String, String> map = new HashMap<String, String>();
            map.put("beanName", beanName);
            repeatedService = JNDIHelper.getJNDIServiceForName(IRepeatedService.class.getName(), map);
            jsonData = repeatedService.getSecondQuestions(page, limit, jsonStr, sort);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    @Override
    public JsonData getAllQuestionTestings(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        List list = new ArrayList<>();
        try {
            // 解析并处理参数
            Map queryMap = SerializeUtil.json2Map(jsonStr);
            String questionType = (String) queryMap.get("questionType");
            if (StringUtils.isEmpty(questionType)) {
                return jsonData;
            }
            queryMap.remove("questionType");
            //queryMap.put("delFlag", "0");
            //queryMap.put("checkFlag:in", "0,1");
            jsonStr = SerializeUtil.serializeJson(queryMap);
            // 默认排序
            if (StringUtils.isEmpty(sort)) {
                sort = "[{'property': 'subType', 'direction': 'ASC'},{'property': 'type', 'direction': 'ASC'},{'property': 'creationDate', 'direction': 'DESC'}]";
            }
            EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_QUESTIONTYPE, questionType);
            String questionTypeName = enrolmentDictBean.getLabel();
            String questionBeans = enrolmentDictBean.getDescription() == null ? "" :
                    enrolmentDictBean.getDescription().toLowerCase() + "s";
            String subTypeDictType = enrolmentDictBean.getSubType();
            String beanName = enrolmentDictBean.getDescription();
            Map<String, String> map = new HashMap<String, String>();
            map.put("beanName", beanName);
            questionService = JNDIHelper.getJNDIServiceForName(IQuestionService.class.getName(), map);
            JsonData resultData = questionService.getAllEntityByQuery(page, limit, jsonStr, sort);
            // 转换结果
            List resultList = resultData.getData();
            if (resultList != null && resultList.size() > 0) {
                for (int i = 0; i < resultList.size(); i++) {
                    BaseQuestionEntity entity = (BaseQuestionEntity) resultList.get(i);
                    QuestionDTO questionDTO = new QuestionDTO();
                    questionDTO.setId(entity.getId());
                    questionDTO.setQuestionType(questionType);
                    questionDTO.setQuestionTypeName(questionTypeName);
                    questionDTO.setQuestionBeans(questionBeans);
                    if (StringUtils.isNotEmpty(subTypeDictType)) {
                        String dictValue = entity.getSubType();
                        EnrolmentDictBean subDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(subTypeDictType, dictValue);
                        questionDTO.setSubType(dictValue);
                        questionDTO.setSubTypeName(subDictBean.getLabel());
                    }
                    String typeDictValue = entity.getType();
                    EnrolmentDictBean typeDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_TYPE, typeDictValue);
                    questionDTO.setType(typeDictValue);
                    if (typeDictBean != null) {
                        questionDTO.setTypeName(typeDictBean.getLabel());
                    }
                    questionDTO.setQuestionId(entity.getId());
                    questionDTO.setStem(entity.getStem());
                    questionDTO.setAnalysis(entity.getAnalysis());
                    questionDTO.setCheckFlag(entity.getCheckFlag());
                    questionDTO.setCheckerId(entity.getCheckerId());
                    questionDTO.setChecker(entity.getChecker());
                    questionDTO.setCheckDate(entity.getCheckDate());
                    questionDTO.setCheckReason(entity.getCheckReason());
                    questionDTO.setRepeatedFlag(entity.getRepeatedFlag());
                    questionDTO.setDelFlag(entity.getDelFlag());
                    questionDTO.setReason(entity.getReason());
                    questionDTO.setCompareFlag(entity.getCompareFlag());
                    questionDTO.setCreateBy(entity.getCreateBy());
                    questionDTO.setCreationDate(entity.getCreationDate());
                    questionDTO.setUpdateBy(entity.getUpdateBy());
                    questionDTO.setUpdateDate(entity.getUpdateDate());
                    questionDTO.setOpFlag(entity.getOpFlag());
                    list.add(questionDTO);
                }
            }
            jsonData.setData(list);
            jsonData.setTotalCount(resultData.getTotalCount());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    /**
     * 获取题干相同的试题
     *
     * @return
     */
    @Override
    public JsonData getTheSameStem(String jsonStr) {
        JsonData jsonData = new JsonData();
        try {
            Map queryMap = SerializeUtil.json2Map(jsonStr);
            String questionType = (String) queryMap.get("questionType");
            if (StringUtils.isEmpty(questionType)) {
                return jsonData;
            }
            EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_QUESTIONTYPE, questionType);
            String beanName = enrolmentDictBean.getDescription();
            Map<String, String> map = new HashMap<String, String>();
            map.put("beanName", beanName);
            repeatedService = JNDIHelper.getJNDIServiceForName(IRepeatedService.class.getName(), map);
            jsonData = repeatedService.getTheSameStem(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    @Override
    public JsonStatus autoCreateTestPaper(Long paperId) {
        JsonStatus jsonStatus = new JsonStatus();
        String uuid_str = "";
        String uuid="";
        List interview=null;
        File outFile=null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        try {
            int copies = 1;
            int total = 0;
            String type = "";
            //成卷结果
            String doPaperRes = "T";
            List<Map> quesList = null;
            Map tempMap = new HashMap<>();
            PaperBean paperBean = paperBeanService.getEntity(paperId);
            String tempName = paperBean.getTempName();
            Date year = paperBean.getYear();
            String year_str = simpleDateFormat.format(year);
            int paperTotal = paperBean.getTotalMark();
            String kskmValue = paperBean.getKskm();
            EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_KSKM, kskmValue);
            String kskm = enrolmentDictBean.getLabel();
            List<RuleDto> list_rule = ruleBeanService.findByPaperId(paperId);
            for (RuleDto rule1Bean : list_rule) {
                total += rule1Bean.getQuesTotalscore();
            }
            if (total == paperTotal || "3".equals(tempName)) {
                if (paperBean.getCopies() > 1) {
                    copies = paperBean.getCopies();
                }
                if("3".equals(tempName)){
                    interview=new ArrayList();
                }
                for (int j = 0; j < copies; j++) {
                     uuid = UUID.randomUUID().toString();
                    uuid_str += uuid + ",";
                    quesList = new ArrayList<Map>();
                    if (list_rule != null && list_rule.size() > 0) {
                        for (int i = 0; i < list_rule.size(); i++) {
                            RuleDto ruleBean = (RuleDto) list_rule.get(i);
                            Map paper_map = new HashMap();
                            paper_map.put("year", year);
                            paper_map.put("score", ruleBean.getQuesScore());
                            paper_map.put("totalscore", ruleBean.getQuesTotalscore());
                            paper_map.put("titlenum", ruleBean.getTitleNum());
                            paper_map.put("paperid", ruleBean.getPaperId());
                            paper_map.put("questype", ruleBean.getQuesType());
                            paper_map.put("quesdesc", ruleBean.getQuesDesc());
                            paper_map.put("subtype", ruleBean.getSubType());
                            paper_map.put("questypename", ruleBean.getQuesTypeName());
                            paper_map.put("typeCount", ruleBean.getTypeCount());
                            paper_map.put("quesRange", ruleBean.getQuesRange());
                            paper_map.put("uuid", uuid);
                            type = ruleBean.getQuesTypeName();
                            String beanName = ruleBean.getQuesTypeDesc();
                            Map<String, String> map = new HashMap<String, String>();
                            map.put("beanName", beanName);
                            questionService = JNDIHelper.getJNDIServiceForName(IQuestionService.class.getName(), map);
                            Map singleTestPaper = questionService.createSingleTestPaper(paper_map);
                            List list_ques = (List) singleTestPaper.get("question");
                            if (list_ques == null || list_ques.size() == 0) {
                                doPaperRes = "F";
                                break;
                            }
                            quesList.add(singleTestPaper);
                        }
                    } else {
                        Map paper_map = new HashMap();
                        paper_map.put("year", year);
                        paper_map.put("uuid", uuid);
                        paper_map.put("paperid", paperId);
                        paper_map.put("subtype", kskmValue);
                        paper_map.put("quesRange", paperBean.getQuesRange());
                        EnrolmentDictBean enrolmentDictBean_mst = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_MSTLX, kskmValue);
                        String kskm_xmt = enrolmentDictBean_mst.getLabel();
                        paper_map.put("kskm", kskm_xmt);
                        Map<String, String> map = new HashMap<String, String>();
                        map.put("beanName", "InterviewIssue");
                        questionService = JNDIHelper.getJNDIServiceForName(IQuestionService.class.getName(), map);
                        Map singleTestPaper = questionService.createSingleTestPaper(paper_map);
                        List list_ques = (List) singleTestPaper.get("question");
                        if (list_ques == null || list_ques.size() == 0) {
                            doPaperRes = "F";
                            //break;
                        }
                        quesList.add(singleTestPaper);
                    }

                    if ("F".equals(doPaperRes)) {

                        paperQuesBeanService.deleteByUuid(uuid);
                        jsonStatus.setSuccess(false);
                        jsonStatus.setMsg(type + "数量不足，成卷失败，已生成" + j + "套卷!");
                        break;
                    } else {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                        String testPaperName = sdf.format(new Date());
                        String tmp = "";
                        tempMap.put("year", year_str);
                        tempMap.put("quesList", quesList);
                        tempMap.put("uuid", uuid);
                        tempMap.put("testPaperName", testPaperName);
                        if ("1".equals(tempName)) {

                            tempMap.put("kskm", kskm);
                            tmp = "testPaper.ftl";
                            jsonStatus = produceTestPaper(tmp, tempMap, paperId, j);
                        } else if ("2".equals(tempName)) {
                            EnrolmentDictBean enrolmentDictBean_zgt = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_ZGTLX, kskmValue);
                            //String kskm_zgt = enrolmentDictBean_zgt.getLabel();
                            String kskm_zgt = enrolmentDictBean_zgt.getDescription();
                            if (StringUtils.isEmpty(kskm_zgt)) {
                                kskm_zgt = enrolmentDictBean_zgt.getLabel();
                            }
                            tempMap.put("kskm", kskm_zgt);
                            tmp = "subject.ftl";
                            jsonStatus = produceTestPaper(tmp, tempMap, paperId, j);
                        } else {

                            if ("7".equals(kskmValue) || "8".equals(kskmValue) || "9".equals(kskmValue)|| "13".equals(kskmValue)) {
                                tmp = "Interview_subtype.ftl";
                            } else if("1".equals(kskmValue)) {
                                tmp = "Interview_bobao.ftl";
                            }else {
                                tmp = "Interview.ftl";
                            }

                            EnrolmentDictBean enrolmentDictBean_mst = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_MSTLX, kskmValue);
                            //String kskm_xmt = enrolmentDictBean_mst.getLabel();
                            String kskm_xmt = enrolmentDictBean_mst.getDescription();
                            if (StringUtils.isEmpty(kskm_xmt)) {
                                kskm_xmt = enrolmentDictBean_mst.getLabel();
                            }
                            tempMap.put("kskm", kskm_xmt);
//                            System.out.print(((Map)((List)quesList.get(0).get("question")).get(0)).get("stem"));
//                            System.out.print(",");
//                            System.out.print(((Map)((List)quesList.get(0).get("question")).get(1)).get("stem"));
//                            System.out.println("-----");
                            Thread.sleep(1000);
                            jsonStatus = produceTestPaper(interview, tmp, tempMap);
                        }
                    }
                }
                if("3".equals(tempName)){
                    // 设置默认预览文件地址
                    // 预览文件真实路径地址
                    String realPath = (String) ConfigUtil.getConfigProp("word.review.realpath", "ConfigOpenOffice");
                    if (realPath.charAt(realPath.length() - 1) != '/') {
                        realPath += "/";
                    }
                    String reviewBaseDir = realPath + "reviewfiles";
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                    String testPaperName = sdf.format(new Date());
                    Map<String, String> map_str = new HashMap<>();
                    map_str.put("path", reviewBaseDir);
                    map_str.put("filename", paperBean.getTitle() + "_" + testPaperName);
                    map_str.put("password", "");
                    doZipUtils doZipUtils = new doZipUtils();

                    String path = doZipUtils.doZip_inStream(interview, map_str);
                     outFile = new File(path);
                    if (outFile.exists()) {
                        InputStream input = new FileInputStream(outFile);
                        Response  response = couchdbService.addAttachment(input,
                                testPaperName  +  ".zip", "application/vnd.ms-word");

                        AttachmentBean attachmentBean = new AttachmentBean();
                        attachmentBean.setAttachmentId(uuid);
                        attachmentBean.setAttachmentName(testPaperName + ".zip");
                        attachmentBean.setAttachmentPath(couchdbService.getDBUrl() + response.getId() + "/" + testPaperName  + ".zip");
                        attachmentBean.setAttachmentRev(response.getRev());
                        attachmentBean.setMainId(paperId);
                        attachmentBeanService.saveEntity(attachmentBean);

                    }
                    jsonStatus.setSuccess(true);
                    jsonStatus.setMsg("试卷生成成功!");
                }
            } else {
                jsonStatus.setSuccess(false);
                jsonStatus.setMsg("试卷分数与参数分数不符，请核对后重新提交！");
            }
        } catch (IOException e) {
            if (!StringUtils.isEmpty(uuid_str)) {
                if (uuid_str.indexOf(",") > -1) {
                    String[] str = uuid_str.split(",");
                    for (String uuid1 : str) {
                        paperQuesBeanService.deleteByUuid(uuid1);
                    }
                } else {
                    paperQuesBeanService.deleteByUuid(uuid_str);
                }
            }

            e.printStackTrace();
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg(e.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(outFile!=null){
                outFile.delete();
            }
        }
        return jsonStatus;
    }

    private JsonStatus produceTestPaper(String fileName, Map tempMap, Long paperId, int j) throws IOException {
        JsonStatus jsonStatus = new JsonStatus();

        Configuration configuration = new Configuration();
        File outFile = null;
        File outFile_answer = null;
        //dataMap 要填入模本的数据文件
        //设置模本装置方法和路径,
        Template t = null;
        Template t_answer = null;
        Writer out = null;
        Writer out_answer = null;
        FileOutputStream fos = null;
        FileOutputStream fos_answer = null;
        Response response = null;
        String uuid = null;
        Long paperFj_id=0L;
        try {
            String realPath = (String) ConfigUtil.getConfigProp("word.review.realpath", "ConfigOpenOffice");
            if (realPath.charAt(realPath.length() - 1) != '/') {
                realPath += "/";
            }
            String reviewBaseDir = realPath + "reviewfiles" + File.separatorChar + "ftl";
            configuration.setDirectoryForTemplateLoading(new File(reviewBaseDir));
            //test.ftl为要装载的模板
            t = configuration.getTemplate(fileName, "utf-8");
            t_answer= configuration.getTemplate("answer.ftl", "utf-8");
            //输出文档路径及名称
            String testPaperName=tempMap.get("tempMap").toString();
            outFile = new File(reviewBaseDir + "\\" + testPaperName+"_"+j + ".doc");
            outFile_answer = new File(reviewBaseDir + "\\" + testPaperName+"_"+j+"_answer.doc");

            fos = new FileOutputStream(outFile);
            fos_answer = new FileOutputStream(outFile_answer);
            OutputStreamWriter oWriter = new OutputStreamWriter(fos, "UTF-8");
            OutputStreamWriter oWriter_answer = new OutputStreamWriter(fos_answer, "UTF-8");
            //这个地方对流的编码不可或缺，使用main（）单独调用时，应该可以，但是如果是web请求导出时导出后word文档就会打不开，并且包XML文件错误。主要是编码格式不正确，无法解析。
            //out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
            out = new BufferedWriter(oWriter);
            out_answer = new BufferedWriter(oWriter_answer);
            t.process(tempMap, out);
            t_answer.process(tempMap, out_answer);
            uuid = tempMap.get("uuid").toString();
            jsonStatus.setSuccess(true);
            jsonStatus.setMsg("试卷生成成功!");
            if (outFile.exists()) {
                InputStream input = new FileInputStream(outFile);
                response = couchdbService.addAttachment(input,
                        testPaperName +"_"+j +  ".doc", "application/vnd.ms-word");

                AttachmentBean attachmentBean = new AttachmentBean();
                attachmentBean.setAttachmentId(uuid);
                attachmentBean.setAttachmentName(testPaperName +"_"+j + ".doc");
                attachmentBean.setAttachmentPath(couchdbService.getDBUrl() + response.getId() + "/" + testPaperName +"_"+j + ".doc");
                attachmentBean.setAttachmentRev(response.getRev());
                attachmentBean.setMainId(paperId);
                attachmentBeanService.saveEntity(attachmentBean);
                paperFj_id=attachmentBean.getId();
            }
            if (outFile_answer.exists()) {
                InputStream input = new FileInputStream(outFile_answer);
                response = couchdbService.addAttachment(input,
                        testPaperName+"_"+j+"_answer.doc", "application/vnd.ms-word");

                AttachmentBean attachmentBean = new AttachmentBean();
                attachmentBean.setAttachmentId(uuid);
                attachmentBean.setAttachmentName(testPaperName+"_"+j+"_answer.doc");
                attachmentBean.setAttachmentPath(couchdbService.getDBUrl() + response.getId() + "/" + testPaperName +"_"+j+"_answer.doc");
                attachmentBean.setAttachmentRev(response.getRev());
                attachmentBean.setMainId(paperFj_id);
                attachmentBeanService.saveEntity(attachmentBean);
            }
        } catch (Exception e) {
            //logger.error("导出出错", e);
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg("试卷生成失败!");
            e.printStackTrace();
            paperQuesBeanService.deleteByUuid(uuid);
            // throw new BusinessException(CommonResultEnum.COMMON_ERROR_637);
        } finally {
            if(out!=null){
                out.close();
            }
            if(fos!=null) {
                fos.close();
            }
            if(out_answer!=null) {
                out_answer.close();
            }
            if(fos_answer!=null) {
                fos_answer.close();
            }
            if(outFile!=null) {
                outFile.delete();
            }
            if(outFile_answer!=null) {
                outFile_answer.delete();
            }
        }
        return jsonStatus;
    }

    private JsonStatus produceTestPaper(List list,String fileName, Map tempMap) throws IOException {
        JsonStatus jsonStatus = new JsonStatus();

        Configuration configuration = new Configuration();
        File outFile = null;
        //dataMap 要填入模本的数据文件
        //设置模本装置方法和路径,
        Template t = null;
        Response response = null;
        Writer out = null;
        FileOutputStream fos = null;
        String uuid = null;
        try {
            String realPath = (String) ConfigUtil.getConfigProp("word.review.realpath", "ConfigOpenOffice");
            if (realPath.charAt(realPath.length() - 1) != '/') {
                realPath += "/";
            }
            String reviewBaseDir = realPath + "reviewfiles" + File.separatorChar + "ftl";
            configuration.setDirectoryForTemplateLoading(new File(reviewBaseDir));
            //test.ftl为要装载的模板
            t = configuration.getTemplate(fileName, "utf-8");

            //输出文档路径及名称
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String testPaperName = sdf.format(new Date());
            outFile = new File(reviewBaseDir + "\\" + testPaperName + ".doc");
            fos = new FileOutputStream(outFile);
            OutputStreamWriter oWriter = new OutputStreamWriter(fos, "UTF-8");
            //这个地方对流的编码不可或缺，使用main（）单独调用时，应该可以，但是如果是web请求导出时导出后word文档就会打不开，并且包XML文件错误。主要是编码格式不正确，无法解析。
            //out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
            out = new BufferedWriter(oWriter);
            t.process(tempMap, out);
            uuid = tempMap.get("uuid").toString();
//            jsonStatus.setSuccess(true);
//            jsonStatus.setMsg("试卷生成成功!");
            if (outFile.exists()) {
                InputStream input = new FileInputStream(outFile);

                ByteArrayOutputStream out_in = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = input.read(buffer)) > -1 ) {
                    out_in.write(buffer, 0, len);
                }
                out_in.flush();
                out_in.close();
                input.close();
                byte[] byteArray = out_in.toByteArray();
                InputStream inputStream1 = new ByteArrayInputStream(byteArray);
                list.add(inputStream1);
            }

        } catch (Exception e) {
            //logger.error("导出出错", e);
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg("试卷生成失败!");
            e.printStackTrace();
            paperQuesBeanService.deleteByUuid(uuid);
            // throw new BusinessException(CommonResultEnum.COMMON_ERROR_637);
        } finally {
            if(out!=null){
                out.close();
            }
            if(fos!=null) {
                fos.close();
            }

            if(outFile!=null) {
                outFile.delete();
            }


        }
        return jsonStatus;
    }

    @Override
    public JsonStatus deletePaper(BatchDeleteDTO batchDeleteDTO) {
        JsonStatus jsonStatus = new JsonStatus();
        String ids = batchDeleteDTO.getIds();
        if (StringUtils.isEmpty(ids)) {
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg("无效参数，删除失败，未删除任何有效数据！");
            return jsonStatus;
        }

        if (ids.indexOf(":") > -1) {
            String[] str = ids.split(":");
            for (String idStr : str) {
                AttachmentBean attachmentBean = attachmentBeanService.getEntity(Long.parseLong(idStr));
                paperQuesBeanService.deleteByUuid(attachmentBean.getAttachmentId());
                attachmentBeanService.deleteEntity(Long.parseLong(idStr));
            }
        } else {
            AttachmentBean attachmentBean = attachmentBeanService.getEntity(Long.parseLong(ids));
            paperQuesBeanService.deleteByUuid(attachmentBean.getAttachmentId());
            attachmentBeanService.deleteEntity(Long.parseLong(ids));
        }
        jsonStatus.setMsg("删除成功！");
        jsonStatus.setSuccess(true);
        return jsonStatus;
    }

    @Override
    public JsonStatus reductionPaper(String id) {
        JsonStatus jsonStatus = new JsonStatus();

        if (!StringUtils.isEmpty(id)) {
            if (id.indexOf(":") > -1) {
                String[] str = id.split(":");
                for (String idStr : str) {
                    AttachmentBean attachmentBean = attachmentBeanService.getEntity(Long.parseLong(idStr));
                    paperQuesBeanService.deleteByUuid(attachmentBean.getAttachmentId());
                    attachmentBeanService.deleteEntity(Long.parseLong(idStr));
                }

            } else {
                AttachmentBean attachmentBean = attachmentBeanService.getEntity(Long.parseLong(id));
                paperQuesBeanService.deleteByUuid(attachmentBean.getAttachmentId());
                attachmentBeanService.deleteEntity(Long.parseLong(id));
            }
        }
        jsonStatus.setMsg("还原成功！");
        jsonStatus.setSuccess(true);
        return jsonStatus;
    }

    public void setPaperQuesBeanService(IPaperQuesBeanService paperQuesBeanService) {
        this.paperQuesBeanService = paperQuesBeanService;
    }

    public void setEnrolmentDictBeanService(IEnrolmentDictBeanService enrolmentDictBeanService) {
        this.enrolmentDictBeanService = enrolmentDictBeanService;
    }

    public void setCouchdbService(ICouchdbService couchdbService) {
        this.couchdbService = couchdbService;
    }

    public void setAttachmentBeanService(IAttachmentBeanService attachmentBeanService) {
        this.attachmentBeanService = attachmentBeanService;
    }

    public void setPaperBeanService(IPaperBeanService paperBeanService) {
        this.paperBeanService = paperBeanService;
    }

    public void setRuleBeanService(IRuleBeanService ruleBeanService) {
        this.ruleBeanService = ruleBeanService;
    }

    public void setQuestionRepeatedBeanService(IQuestionRepeatedBeanService questionRepeatedBeanService) {
        this.questionRepeatedBeanService = questionRepeatedBeanService;
    }

    @Override
    public JSONObject getData(String key) {
        JSONObject jsonObject = new JSONObject();
        List countList = null;
        if (countList != null) {
            jsonObject.put("msgCount", countList.size());
        }
        jsonObject.put("msgTag", "{'title':'aaa','content':'bbb'}");
        return jsonObject;
    }
}
