
DELETE FROM public.enrolment_question_setting;

INSERT INTO "public"."enrolment_question_setting" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "available", "version_", "cilinsimilarity", "morphosimilarity", "phrasesimilarity", "questionclosetime", "questionstarttime", "similarity", "repeated", "compare", "comparechoice", "comparecompletion", "compareinterview", "comparemusic", "comparesubject", "compareverse")
  VALUES ('1', '系统管理员', '-1', '2018-10-26 08:29:23', '系统管理员', '-1', '2018-10-26 08:29:28', 't', '1', '0.5', '0.5', '0.5', NULL, NULL, '0.8', 't', 'f', 'f', 'f', 'f', 'f', 'f', 'f');
