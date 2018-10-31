package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IRepeatedService;
import com.kalix.enrolment.question.api.dao.IChoiceBeanDao;
import com.kalix.enrolment.question.api.dao.ICompletionBeanDao;
import com.kalix.enrolment.question.api.dao.IVerseBeanDao;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.security.IShiroService;

/**
 * Created by Administrator_ on 2018/9/17.
 */
public class RepeatedDtoServiceImpl implements IRepeatedService {
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
    public JsonData getSingleRepeates(String subType) {
        return null;
    }

    @Override
    public JsonStatus doSaveRepeate(Long questionId) {
        return null;
    }

    @Override
    public JsonStatus doDeleteRepeate(Long questionId) {
        return null;
    }


//    @Override
//    public JsonData doRepeate(RepeatedDTO c_repeatedDTO) {
//        String stem = c_repeatedDTO.getStem();
//        String type = c_repeatedDTO.getQuestionType();
//        Long questionid = c_repeatedDTO.getQuestionId();
//        JsonData jsondata = new JsonData();
//        List<RepeatedCountDTO> repeateList = new ArrayList<RepeatedCountDTO>();
//        List<Object> referenceList = new ArrayList<Object>();
//        List<Object> completionlist = null;
//        String hql = "";
//        //List<CompletionBean> completionlist = completionBeanDao.getAll();
//        if ("CompletionBean".equals(type)) {
//            if (questionid != null && questionid > 0) {
//                hql = "select c from CompletionBean c where c.delFlag='0' and id<>" + questionid;
//            } else {
//                hql = "select c from CompletionBean c where c.delFlag='0'";
//            }
//
//            completionlist = (List<Object>) completionBeanDao.find(hql);
//        } else if ("ChoiceBean".equals(type)) {
//            if (questionid != null && questionid > 0) {
//                hql = "select c from ChoiceBean c where c.delFlag='0' and id<>" + questionid;
//            } else {
//                hql = "select c from ChoiceBean c where c.delFlag='0'";
//            }
//            completionlist = (List<Object>) choiceBeanDao.find(hql);
//        } else {
//            if (questionid != null && questionid > 0) {
//                hql = "select c from VerseBean c where c.delFlag='0' and id<>" + questionid;
//            } else {
//                hql = "select c from VerseBean c where c.delFlag='0'";
//            }
//            completionlist = (List<Object>) verseBeanDao.find(hql);
//        }
//
//        referenceList.addAll(completionlist);
//        int count = 1;
//        RepeatedCountDTO repeatedCountDTO = new RepeatedCountDTO();
//        List<RepeatedDTO> dtoList = new ArrayList<RepeatedDTO>();
//        String str_stem = "";
//        Long questionId = null;
//        for (int j = 0; j < referenceList.size(); j++) {
//            if (referenceList.get(j) instanceof CompletionBean) {
//                CompletionBean completionBean = (CompletionBean) referenceList.get(j);
//                str_stem = completionBean.getStem();
//                questionId = completionBean.getId();
//            }
//            if (referenceList.get(j) instanceof ChoiceBean) {
//                ChoiceBean choiceBean = (ChoiceBean) referenceList.get(j);
//                str_stem = choiceBean.getStem();
//                questionId = choiceBean.getId();
//            }
//            if (referenceList.get(j) instanceof VerseBean) {
//                VerseBean verseBean = (VerseBean) referenceList.get(j);
//                str_stem = verseBean.getStem();
//                questionId = verseBean.getId();
//            }
//
//            //短语相似度
//            double result1 = Similarity.phraseSimilarity(stem, str_stem);
//            //词形词序句子相似度值
//            // double morphoSimilarityResult = Similarity.morphoSimilarity(stem, str_stem);
//            //词林相似度
//            double result = Similarity.cilinSimilarity(stem, str_stem);
//            if (result > 0.5 || result1 > 0.5) {
//                RepeatedDTO repeatedDTO = new RepeatedDTO();
//                repeatedDTO.setQuestionId(questionId);
//                repeatedDTO.setStem(str_stem);
//                repeatedDTO.setSimilarity("短语相似度-->" + new DecimalFormat("0.00").format(result1) + "；词林相似度" + new DecimalFormat("0.00").format(result));
//                repeatedDTO.setQuestionType(type);
//                dtoList.add(repeatedDTO);
//            }
//        }
//        if (dtoList != null && dtoList.size() > 0) {
//            repeatedCountDTO.setName("题目" + (count++));
//            repeatedCountDTO.setRepeateList(dtoList);
//            repeateList.add(repeatedCountDTO);
//        }
//
//        jsondata.setData(repeateList);
//        return jsondata;
//    }

//    @Override
//    public JsonData doRepeate(String type) {
//        JsonData jsondata = new JsonData();
//
//        if ("CompletionBean".equals(type)) {
//            return this.doRepeateCompletion();
//        } else if ("VerseBean".equals(type)) {
//
//            return this.doRepeateVerseBean();
//        } else if ("ChoiceBean".equals(type)) {
//
//            return this.doRepeateChoiceBean();
//        } else {
//            JsonData completion = this.doRepeateCompletion();
//            JsonData verseBean = this.doRepeateVerseBean();
//            JsonData choiceBean = this.doRepeateChoiceBean();
//
//            List list = new ArrayList();
//
//            list.addAll(completion.getData());
//            list.addAll(verseBean.getData());
//            list.addAll(choiceBean.getData());
//            jsondata.setData(list);
//            return jsondata;
//
//        }
//        //JsonData jsondata = new JsonData();
//
//    }


//    public static void main(String[] args) {
//        double result = Similarity.cilinSimilarity("教师", "教授");
//        System.out.println(result);
//    }
}
