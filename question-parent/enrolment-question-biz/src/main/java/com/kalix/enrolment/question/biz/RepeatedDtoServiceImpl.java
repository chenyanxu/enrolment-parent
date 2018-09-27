package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IRepeatedBeanService;
import com.kalix.enrolment.question.api.dao.IChoiceBeanDao;
import com.kalix.enrolment.question.api.dao.ICompletionBeanDao;
import com.kalix.enrolment.question.api.dao.IVerseBeanDao;
import com.kalix.enrolment.question.dto.model.RepeatedCountDTO;
import com.kalix.enrolment.question.dto.model.RepeatedDTO;
import com.kalix.enrolment.question.entities.ChoiceBean;
import com.kalix.enrolment.question.entities.CompletionBean;
import com.kalix.enrolment.question.entities.VerseBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.security.IShiroService;
import org.apache.commons.lang.StringUtils;
import org.xm.Similarity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator_ on 2018/9/17.
 */
public class RepeatedDtoServiceImpl implements IRepeatedBeanService {
    private IShiroService shiroService;
    private IVerseBeanDao verseBeanDao;
    private IChoiceBeanDao choiceBeanDao;
    private ICompletionBeanDao completionBeanDao;

    public void setShiroService(IShiroService shiroService) {
        this.shiroService = shiroService;
    }

    public void setVerseBeanDao(IVerseBeanDao verseBeanDao) {
        this.verseBeanDao = verseBeanDao;
    }

    public void setChoiceBeanDao(IChoiceBeanDao choiceBeanDao) {
        this.choiceBeanDao = choiceBeanDao;
    }

    public void setCompletionBeanDao(ICompletionBeanDao completionBeanDao) {
        this.completionBeanDao = completionBeanDao;
    }

    @Override
    public JsonData doRepeateCompletion() {
        JsonData jsondata = new JsonData();
        List<RepeatedCountDTO> repeateList = new ArrayList<RepeatedCountDTO>();
        List<Object> referenceList = new ArrayList<Object>();
        //List<CompletionBean> completionlist = completionBeanDao.getAll();
        String hql = "select c from CompletionBean c where c.repeatedFlag='0' and c.delFlag='0'";
        List<CompletionBean> completionlist = (List<CompletionBean>) completionBeanDao.find(hql);
        referenceList.addAll(completionlist);
        String stem = "";
        String completionIds = "";
        int count = 1;
        for (int i = 0; i < referenceList.size(); i++) {

            String repeaFlag = "";
            RepeatedCountDTO repeatedCountDTO = new RepeatedCountDTO();

            CompletionBean completion = (CompletionBean) referenceList.get(i);
            List<RepeatedDTO> dtoList = new ArrayList<RepeatedDTO>();
            stem = completion.getStem();
            for (int j = 0; j < referenceList.size(); j++) {
                CompletionBean completion_child = (CompletionBean) referenceList.get(j);
                if (completion_child.getId() != completion.getId()) {
                    String comStem = completion_child.getStem();
                    //短语相似度
                    double result1 = Similarity.phraseSimilarity(stem, comStem);
                    //词形词序句子相似度值
                    // double morphoSimilarityResult = Similarity.morphoSimilarity(stem, comStem);
                    //词林相似度
                    double result = Similarity.cilinSimilarity(stem, comStem);
                    if (result > 0.5 || result1 > 0.5) {
                        repeaFlag = "0";
                        // completionlist.remove(referenceList.get(i));
                        if (StringUtils.isNotBlank(completionIds)) {
                            if (completionIds.indexOf(String.valueOf(completion.getId())) < 0) {
                                RepeatedDTO repeatedDTO = new RepeatedDTO();
                                repeatedDTO.setQuestionId(completion.getId());
                                repeatedDTO.setStem(completion.getStem());
                                repeatedDTO.setSimilarity("短语相似度-->" + new DecimalFormat("0.00").format(result1) + "；词林相似度" + new DecimalFormat("0.00").format(result));
                                repeatedDTO.setQuestionType("CompletionBean");
                                dtoList.add(repeatedDTO);
                                completionIds += completion.getId() + ",";
                            }
                        } else {
                            RepeatedDTO repeatedDTO = new RepeatedDTO();
                            repeatedDTO.setQuestionId(completion.getId());
                            repeatedDTO.setStem(completion.getStem());
                            repeatedDTO.setSimilarity("短语相似度-->" + new DecimalFormat("0.00").format(result1) + "；词林相似度" + new DecimalFormat("0.00").format(result));
                            repeatedDTO.setQuestionType("CompletionBean");
                            dtoList.add(repeatedDTO);
                            completionIds += completion.getId() + ",";
                        }

                        RepeatedDTO repeatedDTO = new RepeatedDTO();
                        repeatedDTO.setQuestionId(completion_child.getId());
                        repeatedDTO.setStem(completion_child.getStem());
                        repeatedDTO.setSimilarity("短语相似度-->" + new DecimalFormat("0.00").format(result1) + "；词林相似度" + new DecimalFormat("0.00").format(result));
                        repeatedDTO.setQuestionType("CompletionBean");
                        dtoList.add(repeatedDTO);

                        referenceList.remove(completion_child);
                    }
                }
            }
            if (dtoList != null && dtoList.size() > 0) {
                repeatedCountDTO.setName("题目" + (count++));
                repeatedCountDTO.setRepeateList(dtoList);
                repeateList.add(repeatedCountDTO);
            }

            if (StringUtils.isBlank(repeaFlag)) {
                completion.setRepeatedFlag("1");
                completionBeanDao.save(completion);
            }
            referenceList.remove(completion);
            // completionlist.remove(completion);
        }
        jsondata.setData(repeateList);
        return jsondata;
    }

    @Override
    public JsonData doRepeateChoiceBean() {
        JsonData jsondata = new JsonData();
        List<RepeatedCountDTO> repeateList = new ArrayList<RepeatedCountDTO>();
        List<ChoiceBean> referenceList = new ArrayList<ChoiceBean>();
        //List<CompletionBean> completionlist =completionBeanDao.getAll();
        String hql = "select c from ChoiceBean c where c.repeatedFlag='0' and c.delFlag='0'";
        List<ChoiceBean> completionlist = (List<ChoiceBean>) choiceBeanDao.find(hql);
        referenceList.addAll(completionlist);
        String stem = "";
        String choiceIds = "";
        int count = 1;
        for (int i = 0; i < referenceList.size(); i++) {

            String repeaFlag = "";
            RepeatedCountDTO repeatedCountDTO = new RepeatedCountDTO();

            ChoiceBean choice = (ChoiceBean) referenceList.get(i);
            List<RepeatedDTO> dtoList = new ArrayList<RepeatedDTO>();
            stem = choice.getStem();
            for (int j = 0; j < referenceList.size(); j++) {
                ChoiceBean choice_child = (ChoiceBean) referenceList.get(j);
                if (choice_child.getId() != choice.getId()) {
                    String comStem = choice_child.getStem();
                    //短语相似度
                    double result1 = Similarity.phraseSimilarity(stem, comStem);
                    //词形词序句子相似度值
                    // double morphoSimilarityResult = Similarity.morphoSimilarity(stem, comStem);
                    //词林相似度
                    double result = Similarity.cilinSimilarity(stem, comStem);
                    if (result > 0.5 || result1 > 0.5) {
                        repeaFlag = "0";
                        if (StringUtils.isNotBlank(choiceIds)) {
                            if (choiceIds.indexOf(String.valueOf(choice.getId())) < 0) {
                                RepeatedDTO repeatedDTO = new RepeatedDTO();
                                repeatedDTO.setQuestionId(choice.getId());
                                repeatedDTO.setStem(choice.getStem());
                                repeatedDTO.setSimilarity("短语相似度-->" + new DecimalFormat("0.00").format(result1) + "；词林相似度" + new DecimalFormat("0.00").format(result));
                                repeatedDTO.setQuestionType("ChoiceBean");
                                dtoList.add(repeatedDTO);
                                choiceIds += choice.getId() + ",";
                            }
                        } else {
                            RepeatedDTO repeatedDTO = new RepeatedDTO();
                            repeatedDTO.setQuestionId(choice.getId());
                            repeatedDTO.setStem(choice.getStem());
                            repeatedDTO.setSimilarity("短语相似度-->" + new DecimalFormat("0.00").format(result1) + "；词林相似度" + new DecimalFormat("0.00").format(result));
                            repeatedDTO.setQuestionType("ChoiceBean");
                            dtoList.add(repeatedDTO);
                            choiceIds += choice.getId() + ",";
                        }

                        RepeatedDTO repeatedDTO = new RepeatedDTO();
                        repeatedDTO.setQuestionId(choice_child.getId());
                        repeatedDTO.setStem(choice_child.getStem());
                        repeatedDTO.setSimilarity("短语相似度-->" + new DecimalFormat("0.00").format(result1) + "；词林相似度" + new DecimalFormat("0.00").format(result));
                        repeatedDTO.setQuestionType("ChoiceBean");
                        dtoList.add(repeatedDTO);

                        referenceList.remove(choice_child);
                    }
                }
            }
            if (dtoList != null && dtoList.size() > 0) {
                repeatedCountDTO.setName("题目" + (count++));
                repeatedCountDTO.setRepeateList(dtoList);
                repeateList.add(repeatedCountDTO);
            }

            if (StringUtils.isBlank(repeaFlag)) {
                choice.setRepeatedFlag("1");
                choiceBeanDao.save(choice);
            }
            referenceList.remove(choice);
            // completionlist.remove(completion);
        }
        jsondata.setData(repeateList);
        return jsondata;
    }


    @Override
    public JsonData doRepeateVerseBean() {
        JsonData jsondata = new JsonData();
        List<RepeatedCountDTO> repeateList = new ArrayList<RepeatedCountDTO>();
        List<VerseBean> referenceList = new ArrayList<VerseBean>();
        //List<CompletionBean> completionlist =completionBeanDao.getAll();
        String hql = "select c from VerseBean c where c.repeatedFlag='0' and c.delFlag='0'";
        List<VerseBean> completionlist = (List<VerseBean>) completionBeanDao.find(hql);
        referenceList.addAll(completionlist);
        String stem = "";
        String completionIds = "";
        int count = 1;
        for (int i = 0; i < referenceList.size(); i++) {

            String repeaFlag = "";
            RepeatedCountDTO repeatedCountDTO = new RepeatedCountDTO();

            VerseBean verse = (VerseBean) referenceList.get(i);
            List<RepeatedDTO> dtoList = new ArrayList<RepeatedDTO>();
            stem = verse.getStem();
            for (int j = 0; j < referenceList.size(); j++) {
                VerseBean verse_child = (VerseBean) referenceList.get(j);
                if (verse_child.getId() != verse.getId()) {
                    String comStem = verse_child.getStem();
                    //短语相似度
                    double result1 = Similarity.phraseSimilarity(stem, comStem);
                    //词形词序句子相似度值
                    double morphoSimilarityResult = Similarity.morphoSimilarity(stem, comStem);
                    //词林相似度
                    double result = Similarity.cilinSimilarity(stem, comStem);
                    if (result > 0.5 || result1 > 0.5) {
                        repeaFlag = "0";
                        // completionlist.remove(referenceList.get(i));
                        if (StringUtils.isNotBlank(completionIds)) {
                            if (completionIds.indexOf(String.valueOf(verse.getId())) < 0) {
                                RepeatedDTO repeatedDTO = new RepeatedDTO();
                                repeatedDTO.setQuestionId(verse.getId());
                                repeatedDTO.setStem(verse.getStem());
                                repeatedDTO.setSimilarity("短语相似度-->" + new DecimalFormat("0.00").format(result1) + "；词林相似度" + new DecimalFormat("0.00").format(result));
                                repeatedDTO.setQuestionType("VerseBean");
                                dtoList.add(repeatedDTO);
                                completionIds += verse.getId() + ",";
                            }
                        } else {
                            RepeatedDTO repeatedDTO = new RepeatedDTO();
                            repeatedDTO.setQuestionId(verse.getId());
                            repeatedDTO.setStem(verse.getStem());
                            repeatedDTO.setSimilarity("短语相似度-->" + new DecimalFormat("0.00").format(result1) + "；词林相似度" + new DecimalFormat("0.00").format(result));
                            repeatedDTO.setQuestionType("VerseBean");
                            dtoList.add(repeatedDTO);
                            completionIds += verse.getId() + ",";
                        }

                        RepeatedDTO repeatedDTO = new RepeatedDTO();
                        repeatedDTO.setQuestionId(verse_child.getId());
                        repeatedDTO.setStem(verse_child.getStem());
                        repeatedDTO.setSimilarity("短语相似度-->" + new DecimalFormat("0.00").format(result1) + "；词林相似度" + new DecimalFormat("0.00").format(result));
                        repeatedDTO.setQuestionType("VerseBean");
                        dtoList.add(repeatedDTO);

                        referenceList.remove(verse_child);
                    }
                }
            }
            if (dtoList != null && dtoList.size() > 0) {
                repeatedCountDTO.setName("题目" + (count++));
                repeatedCountDTO.setRepeateList(dtoList);
                repeateList.add(repeatedCountDTO);
            }

            if (StringUtils.isBlank(repeaFlag)) {
                verse.setRepeatedFlag("1");
                verseBeanDao.save(verse);
            }
            referenceList.remove(verse);
        }
        jsondata.setData(repeateList);
        return jsondata;
    }

    @Override
    public JsonData doRepeate(RepeatedDTO c_repeatedDTO) {
        String stem = c_repeatedDTO.getStem();
        String type = c_repeatedDTO.getQuestionType();
        Long questionid = c_repeatedDTO.getQuestionId();
        JsonData jsondata = new JsonData();
        List<RepeatedCountDTO> repeateList = new ArrayList<RepeatedCountDTO>();
        List<Object> referenceList = new ArrayList<Object>();
        List<Object> completionlist = null;
        String hql = "";
        //List<CompletionBean> completionlist = completionBeanDao.getAll();
        if ("CompletionBean".equals(type)) {
            if (questionid != null && questionid > 0) {
                hql = "select c from CompletionBean c where c.delFlag='0' and id<>" + questionid;
            } else {
                hql = "select c from CompletionBean c where c.delFlag='0'";
            }

            completionlist = (List<Object>) completionBeanDao.find(hql);
        } else if ("ChoiceBean".equals(type)) {
            if (questionid != null && questionid > 0) {
                hql = "select c from ChoiceBean c where c.delFlag='0' and id<>" + questionid;
            } else {
                hql = "select c from ChoiceBean c where c.delFlag='0'";
            }
            completionlist = (List<Object>) choiceBeanDao.find(hql);
        } else {
            if (questionid != null && questionid > 0) {
                hql = "select c from VerseBean c where c.delFlag='0' and id<>" + questionid;
            } else {
                hql = "select c from VerseBean c where c.delFlag='0'";
            }
            completionlist = (List<Object>) verseBeanDao.find(hql);
        }

        referenceList.addAll(completionlist);
        int count = 1;
        RepeatedCountDTO repeatedCountDTO = new RepeatedCountDTO();
        List<RepeatedDTO> dtoList = new ArrayList<RepeatedDTO>();
        String str_stem = "";
        Long questionId = null;
        for (int j = 0; j < referenceList.size(); j++) {
            if (referenceList.get(j) instanceof CompletionBean) {
                CompletionBean completionBean = (CompletionBean) referenceList.get(j);
                str_stem = completionBean.getStem();
                questionId = completionBean.getId();
            }
            if (referenceList.get(j) instanceof ChoiceBean) {
                ChoiceBean choiceBean = (ChoiceBean) referenceList.get(j);
                str_stem = choiceBean.getStem();
                questionId = choiceBean.getId();
            }
            if (referenceList.get(j) instanceof VerseBean) {
                VerseBean verseBean = (VerseBean) referenceList.get(j);
                str_stem = verseBean.getStem();
                questionId = verseBean.getId();
            }

            //短语相似度
            double result1 = Similarity.phraseSimilarity(stem, str_stem);
            //词形词序句子相似度值
            // double morphoSimilarityResult = Similarity.morphoSimilarity(stem, str_stem);
            //词林相似度
            double result = Similarity.cilinSimilarity(stem, str_stem);
            if (result > 0.5 || result1 > 0.5) {
                RepeatedDTO repeatedDTO = new RepeatedDTO();
                repeatedDTO.setQuestionId(questionId);
                repeatedDTO.setStem(str_stem);
                repeatedDTO.setSimilarity("短语相似度-->" + new DecimalFormat("0.00").format(result1) + "；词林相似度" + new DecimalFormat("0.00").format(result));
                repeatedDTO.setQuestionType(type);
                dtoList.add(repeatedDTO);
            }
        }
        if (dtoList != null && dtoList.size() > 0) {
            repeatedCountDTO.setName("题目" + (count++));
            repeatedCountDTO.setRepeateList(dtoList);
            repeateList.add(repeatedCountDTO);
        }

        jsondata.setData(repeateList);
        return jsondata;
    }

    @Override
    public JsonData doRepeate(String type) {
        //JsonData jsondata = new JsonData();
        return this.doRepeateCompletion();
    }

    @Override
    public JsonStatus doSave(Long questionId, String questionType) {
        JsonStatus jsonStatus = new JsonStatus();

        if ("CompletionBean".equals(questionType)) {
            CompletionBean completionBean = completionBeanDao.get(questionId);
            completionBean.setRepeatedFlag("1");
            completionBeanDao.save(completionBean);
        }
        if ("VerseBean".equals(questionType)) {
            VerseBean verseBean = verseBeanDao.get(questionId);
            verseBean.setRepeatedFlag("1");
            verseBeanDao.save(verseBean);
        }
        if ("ChoiceBean".equals(questionType)) {
            ChoiceBean choiceBean = choiceBeanDao.get(questionId);
            choiceBean.setRepeatedFlag("1");
            choiceBeanDao.save(choiceBean);
        }
        jsonStatus.setSuccess(true);
        jsonStatus.setMsg("保留成功！");

        return jsonStatus;

    }

    @Override
    public JsonStatus doDelete(Long questionId, String questionType) {
        JsonStatus jsonStatus = new JsonStatus();
        String userName = shiroService.getCurrentUserLoginName();
        if ("CompletionBean".equals(questionType)) {
            CompletionBean completionBean = completionBeanDao.get(questionId);
            completionBean.setDelFlag("1");
            completionBean.setRepeatedFlag("1");
            completionBean.setUpdateBy(userName);
            completionBean.setUpdateById(shiroService.getCurrentUserId());
            // completionBean.setUpdateDate();
            completionBeanDao.save(completionBean);
        }
        if ("VerseBean".equals(questionType)) {
            VerseBean verseBeanBean = verseBeanDao.get(questionId);
            verseBeanBean.setDelFlag("1");
            verseBeanBean.setRepeatedFlag("1");
            verseBeanBean.setUpdateBy(userName);
            verseBeanBean.setUpdateById(shiroService.getCurrentUserId());
            // completionBean.setUpdateDate();
            verseBeanDao.save(verseBeanBean);
        }
        if ("ChoiceBean".equals(questionType)) {
            ChoiceBean choiceBean = choiceBeanDao.get(questionId);
            choiceBean.setDelFlag("1");
            choiceBean.setRepeatedFlag("1");
            choiceBean.setUpdateBy(userName);
            choiceBean.setUpdateById(shiroService.getCurrentUserId());
            // completionBean.setUpdateDate();
            choiceBeanDao.save(choiceBean);
        }
        jsonStatus.setSuccess(true);
        jsonStatus.setMsg("删除成功！");

        return jsonStatus;
    }

//    public static void main(String[] args) {
//        double result = Similarity.cilinSimilarity("教师", "教授");
//        System.out.println(result);
//    }
}
