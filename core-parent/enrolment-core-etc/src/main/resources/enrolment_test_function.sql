
-- add 为招生管理角色application授权
DROP SEQUENCE IF EXISTS "public"."sys_role_application_id_seq";
CREATE SEQUENCE "public"."sys_role_application_id_seq"
 START 1;
select setval('sys_role_application_id_seq', max(id)) from sys_role_application;

-- INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
--   SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
--        '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
--        id AS applicationid, '800' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '801' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '802' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '803' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '804' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '805' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '806' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '807' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '808' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '809' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '810' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '811' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '812' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '813' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '814' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '815' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '816' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '817' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '818' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '819' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '820' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '821' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '822' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '823' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '824' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '825' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '826' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '827' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '828' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '829' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '830' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '831' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '832' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '833' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '834' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '835' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '836' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '837' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '838' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '839' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '840' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '841' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '842' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '843' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '844' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30.22' AS updatedate,
       id AS applicationid, '845' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';
INSERT INTO "public"."sys_role_application" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "applicationid", "roleid", "version_")
  SELECT nextval('sys_role_application_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10.215' AS updatedate,
       id AS applicationid, '846' AS roleid, '1' AS version_ FROM sys_application WHERE NAME = '招生管理';



--add 为招生管理角色function授权
DROP SEQUENCE IF EXISTS "public"."sys_role_function_id_seq";
CREATE SEQUENCE "public"."sys_role_function_id_seq"
 START 1;
select setval('sys_role_function_id_seq', max(id)) from sys_role_function;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10' AS updatedate,
       a.functionid, '801' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='completion'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='completion'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='completion'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='completion')

-- UNION
-- select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='company'
-- UNION
-- select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='company'
-- UNION
-- select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='company'
-- UNION
-- select t.id from sys_function t where t.parentid in (
-- 	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='company')

) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '802' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='choice'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='choice'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='choice'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='choice')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '803' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='verse'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='verse'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='verse'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='verse')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '804' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='music'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='music'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='music'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='music')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '805' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='shortanswer'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='shortanswer'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='shortanswer'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='shortanswer')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '806' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='discussion'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='discussion'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='discussion'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='discussion')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '807' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='commentary'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='commentary'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='commentary'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='commentary')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '808' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='storywriting'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='storywriting'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='storywriting'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='storywriting')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '809' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='storyrenew'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='storyrenew'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='storyrenew'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='storyrenew')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '810' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='microfiction'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='microfiction'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='microfiction'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='microfiction')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '811' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='photography'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='photography'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='photography'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='photography')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '812' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='filmsound'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='filmsound'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='filmsound'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='filmsound')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '813' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='imagework'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='imagework'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='imagework'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='imagework')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '814' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='newsarticle'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='newsarticle'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='newsarticle'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='newsarticle')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '815' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='topicdiscussion'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='topicdiscussion'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='topicdiscussion'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='topicdiscussion')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '816' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='propositionalstory'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='propositionalstory'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='propositionalstory'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='propositionalstory')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '817' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='doubleshortsketch'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='doubleshortsketch'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='doubleshortsketch'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='doubleshortsketch')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '818' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='englishstudy'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='englishstudy'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='englishstudy'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='englishstudy')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '819' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='dramaliterature'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='dramaliterature'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='dramaliterature'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='dramaliterature')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '820' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='dramadirector'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='dramadirector'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='dramadirector'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='dramadirector')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '821' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='filmproduction'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='filmproduction'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='filmproduction'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='filmproduction')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '822' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='flightservice'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='flightservice'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='flightservice'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='flightservice')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '823' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='extemporereview'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='extemporereview'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='extemporereview'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='extemporereview')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:10' AS updatedate,
       a.functionid, '824' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='completioncheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='completioncheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='completioncheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='completioncheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '825' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='choicecheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='choicecheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='choicecheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='choicecheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '826' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='versecheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='versecheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='versecheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='versecheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '827' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='musiccheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='musiccheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='musiccheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='musiccheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '828' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='shortanswercheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='shortanswercheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='shortanswercheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='shortanswercheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '829' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='discussioncheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='discussioncheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='discussioncheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='discussioncheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '830' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='commentarycheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='commentarycheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='commentarycheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='commentarycheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '831' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='storywritingcheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='storywritingcheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='storywritingcheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='storywritingcheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '832' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='storyrenewcheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='storyrenewcheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='storyrenewcheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='storyrenewcheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '833' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='microfictioncheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='microfictioncheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='microfictioncheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='microfictioncheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '834' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='photographycheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='photographycheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='photographycheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='photographycheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '835' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='filmsoundcheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='filmsoundcheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='filmsoundcheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='filmsoundcheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '836' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='imageworkcheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='imageworkcheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='imageworkcheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='imageworkcheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '837' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='newsarticlecheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='newsarticlecheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='newsarticlecheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='newsarticlecheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '838' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='topicdiscussioncheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='topicdiscussioncheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='topicdiscussioncheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='topicdiscussioncheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '839' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='propositionalstorycheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='propositionalstorycheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='propositionalstorycheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='propositionalstorycheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '840' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='doubleshortsketchcheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='doubleshortsketchcheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='doubleshortsketchcheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='doubleshortsketchcheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '841' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='englishstudycheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='englishstudycheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='englishstudycheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='englishstudycheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '842' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='dramaliteraturecheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='dramaliteraturecheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='dramaliteraturecheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='dramaliteraturecheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '843' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='dramadirectorcheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='dramadirectorcheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='dramadirectorcheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='dramadirectorcheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '844' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='filmproductioncheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='filmproductioncheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='filmproductioncheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='filmproductioncheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '845' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='flightservicecheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='flightservicecheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='flightservicecheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='flightservicecheck')
) s order by s.functionid) a;

INSERT INTO "public"."sys_role_function" ("id", "createby", "createbyid", "creationdate", "updateby", "updatebyid", "updatedate", "functionid", "roleid", "version_")
SELECT nextval('sys_role_function_id_seq') AS id, '管理员' AS createby, -1 AS createbyid, NULL AS creationdate,
       '管理员' AS updateby, -1 AS updatebyid, '2018-03-16 14:26:30' AS updatedate,
       a.functionid, '846' AS roleid, '1' AS version_
FROM
(select DISTINCT s.functionid from (
select fun.applicationid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='extemporereviewcheck'
UNION
select fun.parentid as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='extemporereviewcheck'
UNION
select fun.id as functionid FROM sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='extemporereviewcheck'
UNION
select t.id as functionid from sys_function t where t.parentid in (
	select fun.id from sys_function fun, sys_application app WHERE fun.applicationid=app.id and app.name = '招生管理' and fun.datapermissionkey='extemporereviewcheck')
) s order by s.functionid) a;
