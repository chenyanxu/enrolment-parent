
DELETE FROM public.enrolment_question_setting;

INSERT INTO "public"."enrolment_question_setting" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "available", "version_", "similarity", "cilinsimilarity", "morphosimilarity", "phrasesimilarity", "questionclosetime", "questionstarttime", "repeated")
  VALUES ('1', '系统管理员', '-1', '2018-10-26 08:29:23', '系统管理员', '-1', '2018-10-26 08:29:28', 't', '1', '0.8', '0.5', '0.5', '0.5', NULL, NULL, 'f');
