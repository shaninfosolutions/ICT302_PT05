--Before run the impdp command, make sure db user has been removed and created again.
--C:\oracle\dbhomeXE\bin
sqlplus / as sysdba
show con_name
SQL> alter session set container=XEPDB1;
SQL> drop user drenchmate cascade;

ALTER DATABASE DATAFILE 'C:\Drenchmate\data\cm_data02.dbf' OFFLINE DROP;

SQL> CREATE TABLESPACE dm_data DATAFILE 'C:\Drenchmate\data\dm_data01.dbf' SIZE 128 M AUTOEXTEND ON NEXT 128 M MAXSIZE 256 M,'C:\Drenchmate\data\dm_data02.dbf' SIZE 128 M NOLOGGING ONLINE PERMANENT EXTENT MANAGEMENT LOCAL UNIFORM SIZE 1 M;

SQL> CREATE TABLESPACE dm_index DATAFILE 'C:\Drenchmate\data\dm_index01.dbf' SIZE 128 M AUTOEXTEND ON NEXT 128 M MAXSIZE 256 M, 'C:\Drenchmate\data\dm_index02.dbf' SIZE 128 M NOLOGGING ONLINE PERMANENT EXTENT MANAGEMENT LOCAL UNIFORM SIZE 1 M;

SQL> CREATE temporary TABLESPACE DM_TEMP TEMPFILE 'C:\Drenchmate\data\dm_temp1.dbf' SIZE 128 M AUTOEXTEND ON NEXT 128 M MAXSIZE 256 M EXTENT MANAGEMENT LOCAL;

SQL> alter session set "_ORACLE_SCRIPT"=true;
SQL> create user drenchmate identified by drenchmate default tablespace dm_data temporary tablespace dm_temp quota unlimited on dm_data quota unlimited on dm_index;
SQL> grant dba TO drenchmate;
SQL> create or replace directory ora_dir as 'C:\Drenchmate\data';
SQL> 

---
DROP SEQUENCE SEQ_RULE_CODE_ID; 
DROP SEQUENCE SEQ_RULE_CODE_VALUE_ID; 
DROP SEQUENCE SEQ_USER_ID; 
DROP SEQUENCE SEQ_USER_PROFILE_ID; 
DROP SEQUENCE SEQ_PARTNER_ID;
DROP SEQUENCE SEQ_NOTIFICATION_SETTING_ID;
DROP SEQUENCE SEQ_FARM_HOUSE_ID;
DROP SEQUENCE SEQ_ANIMAL_ID;
DROP SEQUENCE SEQ_TASK_ID;
DROP SEQUENCE SEQ_NOTE_ID;
DROP SEQUENCE SEQ_USER_NOTE_RULE_ID;
DROP SEQUENCE SEQ_NOTIFICATION_ID;
DROP SEQUENCE SEQ_EMAIL_TEMPLATE_ID;

DROP TABLE 	TB_RULE_CODE;
DROP TABLE  TB_NOTIFICATION_SETTING;
DROP TABLE 	TB_TASK;
DROP TABLE 	TB_NOTE;
DROP TABLE 	TB_USER_NOTE_RULE;
DROP TABLE 	TB_NOTIFICATION;
DROP TABLE 	TB_ANIMAL;
DROP TABLE  TB_FARM_HOUSE;
DROP TABLE 	TB_PARTNER;
DROP TABLE  TB_USER_PROFILE;
DROP TABLE  TB_USER;
DROP TABLE 	TB_RULE_CODE_VALUE;
DROP TABLE 	TB_RULE_CODE;
DROP TABLE TB_EMAIL_TEMPLATE;

CREATE SEQUENCE SEQ_RULE_CODE_ID START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE TABLE TB_RULE_CODE (
	RuleCodeId			Number(19)		DEFAULT SEQ_RULE_CODE_ID.nextval,
	Code				Varchar2(255) 	NOT NULL,
	CodeDesc			Varchar2(255) 	NOT NULL,
	Remarks				Varchar2(2000) 		NULL,
	VerNo				Number(19)		NOT NULL,
	CreatedDate			TIMESTAMP 		DEFAULT CURRENT_TIMESTAMP,
	CreatedBy 			Varchar2(255) 	NULL,
	LastUpdatedDate 	TIMESTAMP 		DEFAULT CURRENT_TIMESTAMP,
	LastedUpdatedBy 	Varchar2(255) 	NULL,
	CONSTRAINT 	PK_RuleCodeId	PRIMARY KEY (RuleCodeId)
)
/


CREATE SEQUENCE SEQ_RULE_CODE_VALUE_ID START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE TABLE TB_RULE_CODE_VALUE (
	RuleCodeValueId			Number(19)			DEFAULT SEQ_RULE_CODE_VALUE_ID.nextval,
	RuleCodeId				Number(19)			NOT NULL,
	Code					Varchar2(255) 		NOT NULL,
	CodeDesc				Varchar2(255) 		NOT NULL,
	CodeValue				Number(19,2)		DEFAULT 0,
	Remarks					Varchar2(2000) 			 NULL,
	VerNo					Number(19)		NOT NULL,
	CreatedDate				TIMESTAMP 		DEFAULT CURRENT_TIMESTAMP,
	CreatedBy 				Varchar2(255) 	NULL,
	LastUpdatedDate 		TIMESTAMP 		DEFAULT CURRENT_TIMESTAMP,
	LastedUpdatedBy 		Varchar2(255) 	NULL,
	CONSTRAINT 	PK_RuleCodeValueId	PRIMARY KEY (RuleCodeValueId),
	CONSTRAINT 	FK_RuleCodeId FOREIGN KEY (RuleCodeId) REFERENCES TB_RULE_CODE(RuleCodeId) ON DELETE CASCADE
)
/


CREATE SEQUENCE SEQ_USER_ID START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE TABLE TB_USER (
  UserId			Number(19)		DEFAULT SEQ_USER_ID.nextval,
  Name				Varchar2(255) 	NULL,
  Email				Varchar2(255) 	NULL,
  Password 			Varchar2(255) 	NULL,
  Roles				Varchar2(255) 	NULL,
  VerNo				Number(19)		NOT NULL,
  CreatedDate		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CreatedBy 		Varchar2(255) 	NULL,
  LastUpdatedDate 	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  LastedUpdatedBy 	Varchar2(255) 	NULL,
  CONSTRAINT 		PK_UserId	PRIMARY KEY (UserId)
)
/

INSERT INTO TB_USER VALUES (SEQ_USER_ID.nextval,'John KM','john.km@pt05.com.sg','password',1, CURRENT_TIMESTAMP,'System',CURRENT_TIMESTAMP,'System' )


CREATE SEQUENCE SEQ_USER_PROFILE_ID START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE TABLE TB_USER_PROFILE ( 
	UserId					Number(19)		DEFAULT SEQ_USER_PROFILE_ID.nextval,
	DisplayName 			Varchar2(255) 	NULL,
	Avator					Varchar2(255) 	NULL,
	PhoneNo					Number(19)		NULL,
	FacebookLink			Varchar2(255) 	NULL,
	TwitterLink				Varchar2(255) 	NULL,
	Remarks					Varchar2(2000) 	NULL,
	VerNo					Number(19)		NOT NULL,
	CreatedDate				TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CreatedBy 				Varchar2(255) 	NULL,
	LastUpdatedDate 		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	LastedUpdatedBy 		Varchar2(255) 	NULL,
	CONSTRAINT 	PK_UserProfileId	PRIMARY KEY (UserId),
	CONSTRAINT 	FK_User_Profile_UserId FOREIGN KEY (UserId) REFERENCES TB_USER(UserId) ON DELETE CASCADE
)
/


CREATE SEQUENCE SEQ_PARTNER_ID START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE TABLE TB_PARTNER (
	PartnerId				Number(19)		DEFAULT SEQ_PARTNER_ID.nextval,
	PartnerFromId			Number(19)		NOT NULL,
	PartnerToId				Number(19)		NOT NULL,
	Acceptance				Varchar2(5) 	DEFAULT 'NA', 
	VerNo					Number(19)		NOT NULL,
	CreatedDate				TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CreatedBy 				Varchar2(255) 	NULL,
	LastUpdatedDate 		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	LastedUpdatedBy 		Varchar2(255) 	NULL,
	CONSTRAINT 	PK_PartnerId	PRIMARY KEY (PartnerId),
	CONSTRAINT 	FK_PartnerFromId FOREIGN KEY (PartnerFromId) REFERENCES TB_USER(UserId) ON DELETE CASCADE,
	CONSTRAINT 	FK_PartnerToId FOREIGN KEY (PartnerToId) REFERENCES TB_USER(UserId) ON DELETE CASCADE
)
/


CREATE SEQUENCE SEQ_NOTIFICATION_SETTING_ID START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE TABLE TB_NOTIFICATION_SETTING (
  NotiSettingId		Number(19)		DEFAULT SEQ_NOTIFICATION_SETTING_ID.nextval,
  UserId			Number(19)		NOT NULL,
  ToReceiveNotification char(1)		 DEFAULT 'N',
  Email				Varchar2(255) 	NULL,
  NoOfDays			Number(19)		DEFAULT 0,
  VerNo				Number(19)		NOT NULL,
  CreatedDate		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CreatedBy 		Varchar2(255) 	NULL,
  LastUpdatedDate 	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  LastedUpdatedBy 	Varchar2(255) 	NULL,
  CONSTRAINT 	PK_NotiSettingId	PRIMARY KEY (NotiSettingId),
  CONSTRAINT 	FK_Noti_Setting_UserId FOREIGN KEY (UserId) REFERENCES TB_USER(UserId) ON DELETE CASCADE
 )
/


CREATE SEQUENCE SEQ_FARM_HOUSE_ID START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE TABLE TB_FARM_HOUSE (
  FarmHouseId		Number(19)		DEFAULT SEQ_FARM_HOUSE_ID.nextval,
  UserId			Number(19)		NOT NULL,
  FarmHouseName		Varchar2(255) 	NULL,
  Location			Varchar2(255) 	NULL,
  Capacity			Number(19)		NOT NULL,  
  Remarks 			Varchar2(2000) 	NULL,
  VerNo				Number(19)		NOT NULL,
  CreatedDate		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CreatedBy 		Varchar2(255) 	NULL,
  LastUpdatedDate 	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  LastedUpdatedBy 	Varchar2(255) 	NULL,
  CONSTRAINT 	PK_FarmHouseId	PRIMARY KEY (FarmHouseId),
  CONSTRAINT 	FK_Farm_House_UserId FOREIGN KEY (UserId) REFERENCES TB_USER(UserId) ON DELETE CASCADE
);
/


CREATE SEQUENCE SEQ_ANIMAL_ID START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE TABLE TB_ANIMAL (
  AnimalId			Number(19)		DEFAULT SEQ_ANIMAL_ID.nextval,
  FarmHouseId		Number(19)		NOT NULL,
  AnimalType		Varchar2(255) 	NULL,
  Name				Varchar2(255) 	NULL,
  Age				Number(19)		NOT NULL,
  Weight			Number(5,2)		NOT NULL,  -- KG
  Remarks 			Varchar2(2000) 	NULL,
  VerNo				Number(19)		NOT NULL,
  CreatedDate		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CreatedBy 		Varchar2(255) 	NULL,
  LastUpdatedDate 	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  LastedUpdatedBy 	Varchar2(255) 	NULL,
  CONSTRAINT 	PK_AnimalId	PRIMARY KEY (AnimalId),
  CONSTRAINT 	FK_FarmHouseId FOREIGN KEY (FarmHouseId) REFERENCES TB_FARM_HOUSE(FarmHouseId) ON DELETE CASCADE
);
/

CREATE SEQUENCE SEQ_TASK_ID START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE TABLE TB_TASK (
	TaskId 				Number(19)		DEFAULT SEQ_TASK_ID.nextval,
	UserId 				Number(19)		NOT NULL,
	FarmHouseId 		Number(19)		NOT NULL,
	TaskTitle			Varchar2(255) 	NOT NULL,
	TaskType			Number(19)		NOT NULL,
	StartDate 			TIMESTAMP 		DEFAULT CURRENT_TIMESTAMP,
	EndDate				TIMESTAMP 		DEFAULT CURRENT_TIMESTAMP,
	Remarks 			Varchar2(2000) 	NULL,
	Status				Varchar2(255) 	NULL,	
	VerNo				Number(19)		NOT NULL,
	CreatedDate			TIMESTAMP 		DEFAULT CURRENT_TIMESTAMP,
	CreatedBy 			Varchar2(255) 	NULL,
	LastUpdatedDate 	TIMESTAMP 		DEFAULT CURRENT_TIMESTAMP,
	LastedUpdatedBy 	Varchar2(255) 	NULL,
	CONSTRAINT 	PK_TaskId	PRIMARY KEY (TaskId),
	CONSTRAINT 	FK_Task_UserId FOREIGN KEY (UserId) REFERENCES TB_USER(UserId) ON DELETE CASCADE,
	CONSTRAINT 	FK_Task_FarmHouseId FOREIGN KEY (FarmHouseId) REFERENCES TB_FARM_HOUSE(FarmHouseId) ON DELETE CASCADE
)
/


CREATE SEQUENCE SEQ_NOTE_ID START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE TABLE TB_NOTE (
	NoteId 				Number(19)		DEFAULT SEQ_NOTE_ID.nextval,
	UserId 				Number(19)		NOT NULL,
	FarmHouseId 		Number(19)		NOT NULL,
	NoteTitle			Varchar2(255) 	NOT NULL,
	NoteType			Varchar2(255)	NOT NULL,
	Status				Varchar2(255) 	NULL,			
	Remarks 			Varchar2(2000) 	NULL,
	VerNo				Number(19)		NOT NULL,
	CreatedDate			TIMESTAMP 		DEFAULT CURRENT_TIMESTAMP,
	CreatedBy 			Varchar2(255) 	NULL,
	LastUpdatedDate 	TIMESTAMP 		DEFAULT CURRENT_TIMESTAMP,
	LASTEDUPDATEDBY		Varchar2(255) 	NULL
	CONSTRAINT 	NoteId	PRIMARY KEY (NoteId),
	CONSTRAINT 	FK_Note_UserId FOREIGN KEY (UserId) REFERENCES TB_USER(UserId) ON DELETE CASCADE,
	CONSTRAINT 	FK_Note_FarmHouseId FOREIGN KEY (FarmHouseId) REFERENCES TB_FARM_HOUSE(FarmHouseId) ON DELETE CASCADE
)
/


CREATE SEQUENCE SEQ_USER_NOTE_RULE_ID START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE TABLE TB_USER_NOTE_RULE(
	NoteRuleId			Number(19)		DEFAULT SEQ_USER_NOTE_RULE_ID.nextval,
	NoteId				Number(19)		NOT NULL,
	RuleCodeValueId		Number(19)		NOT NULL,
	RuleValue			Number(19)		DEFAULT 0,
	Remarks 			Varchar2(2000) 	NULL,
	VerNo				Number(19)		NOT NULL,
	CreatedDate			TIMESTAMP 		DEFAULT CURRENT_TIMESTAMP,
	CreatedBy 			Varchar2(255) 	NULL,
	LastUpdatedDate 	TIMESTAMP 		DEFAULT CURRENT_TIMESTAMP,
	LastedUpdatedBy 	Varchar2(255) 	NULL,
	CONSTRAINT 	PK_NoteRuleId	PRIMARY KEY (NoteRuleId),
	CONSTRAINT 	FK_Note_Rule_NoteId FOREIGN KEY (NoteId) REFERENCES TB_NOTE(NoteId) ON DELETE CASCADE,
	CONSTRAINT 	FK_Note_Rule_RuleCodeValueId FOREIGN KEY (RuleCodeValueId) REFERENCES TB_Rule_Code_Value(RuleCodeValueId) ON DELETE CASCADE
)
/


CREATE SEQUENCE SEQ_NOTIFICATION_ID START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE TABLE TB_NOTIFICATION(
	NotificationId 		Number(19)			DEFAULT SEQ_NOTIFICATION_ID.nextval,
	UserId 				Number(19)			NOT NULL,
	NoteId				Number(19)		 	NULL,
	TaskId				Number(19)			 NULL,
	Message				Varchar2(2000) 		 	NULL,
	NotiType			Varchar2(255) 		 	NULL,
	Status				Varchar2(255) 		 	NULL, -- Open -> Active /Closed 
	Remarks 			Varchar2(2000) 		 	NULL,
	DateOfNotification  TIMESTAMP			DEFAULT CURRENT_TIMESTAMP,
	FARMHOUSEID			Number(19)			 NULL,
	VerNo				Number(19)			NOT NULL,
	CreatedDate			TIMESTAMP 			DEFAULT CURRENT_TIMESTAMP,
	CreatedBy 			Varchar2(255) 		NULL,
	LastUpdatedDate 	TIMESTAMP 			DEFAULT CURRENT_TIMESTAMP,
	LastedUpdatedBy 	Varchar2(255) 		NULL,
	CONSTRAINT 	PK_NotificationId	PRIMARY KEY (NotificationId),
	CONSTRAINT 	FK_Notification_UserId FOREIGN KEY (UserId) REFERENCES TB_User(UserId) ON DELETE CASCADE
	
)
/


CREATE SEQUENCE SEQ_EMAIL_TEMPLATE_ID START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE TABLE TB_EMAIL_TEMPLATE(
		EmailTemplateId 		Number(19)			DEFAULT SEQ_EMAIL_TEMPLATE_ID.nextval,
		EmailTemplate			CLOB		 		NULL,
		TemplateName			Varchar2(255) 		 	NULL,
		TemplateNumber			NUMBER(19)				NULL,
		VerNo				Number(19)			NOT NULL,
		CreatedDate			TIMESTAMP 			DEFAULT CURRENT_TIMESTAMP,
		CreatedBy 			Varchar2(255) 		NULL,
		LastUpdatedDate 	TIMESTAMP 			DEFAULT CURRENT_TIMESTAMP,
		LastedUpdatedBy 	Varchar2(255) 		NULL,
		CONSTRAINT 	PK_EmailTemplateId	PRIMARY KEY (EmailTemplateId)
)

/




/*
CREATE TABLE TB_Code (
)

CREATE TABLE TB_Code_Value(

)*/











