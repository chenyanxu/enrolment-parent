DELETE FROM public.enrolment_dict;
INSERT INTO public.enrolment_dict (id, createby, creationdate, updateby, updatedate, description, label, type, value, version_) VALUES (1, 'admin', '2018-09-13 09:14:46.699000', 'admin', '2018-09-13 09:14:46.699000', '', '文学类', '类别', '1', 1);
INSERT INTO public.enrolment_dict (id, createby, creationdate, updateby, updatedate, description, label, type, value, version_) VALUES (2, 'admin', '2018-09-13 09:15:07.697000', 'admin', '2018-09-13 09:15:07.697000', '', '戏剧与影视类', '类别', '2', 1);

INSERT INTO public.enrolment_dict (id, createby, creationdate, updateby, updatedate, description, label, type, value, version_) VALUES (3, 'admin', '2018-09-13 09:14:46.699000', 'admin', '2018-09-13 09:14:46.699000', '', '未审核', '审核状态', '0', 1);
INSERT INTO public.enrolment_dict (id, createby, creationdate, updateby, updatedate, description, label, type, value, version_) VALUES (4, 'admin', '2018-09-13 09:15:07.697000', 'admin', '2018-09-13 09:15:07.697000', '', '已通过', '审核状态', '1', 1);
INSERT INTO public.enrolment_dict (id, createby, creationdate, updateby, updatedate, description, label, type, value, version_) VALUES (5, 'admin', '2018-09-13 09:15:07.697000', 'admin', '2018-09-13 09:15:07.697000', '', '未通过', '审核状态', '2', 1);
