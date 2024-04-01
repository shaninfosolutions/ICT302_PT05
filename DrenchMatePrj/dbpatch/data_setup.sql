INSERT INTO TB_RULE_CODE VALUES (SEQ_RULE_CODE_ID.nextval,'WEATHER','Weather','Weather',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_RULE_CODE VALUES (SEQ_RULE_CODE_ID.nextval,'WORM_COUNT','Worm Count','Worm Count',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_RULE_CODE VALUES (SEQ_RULE_CODE_ID.nextval,'TREATMENT','Treatment','Treatment',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_RULE_CODE VALUES (SEQ_RULE_CODE_ID.nextval,'WATER_CONSUMPTION_LEVEL','Water Consumption Level','Water Consumption Level',0,sysdate,'dbpatch',sysdate,'dbpatch');

INSERT INTO TB_RULE_CODE_VALUE  VALUES (SEQ_RULE_CODE_VALUE_ID.nextval,(SELECT A.RuleCodeId FROM TB_RULE_CODE A WHERE A.Code='WEATHER'),'SUMMER','Summer',5,'Summer',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_RULE_CODE_VALUE  VALUES (SEQ_RULE_CODE_VALUE_ID.nextval,(SELECT A.RuleCodeId FROM TB_RULE_CODE A WHERE A.Code='WEATHER'),'WINTER','Winter',10,'Winter',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_RULE_CODE_VALUE  VALUES (SEQ_RULE_CODE_VALUE_ID.nextval,(SELECT A.RuleCodeId FROM TB_RULE_CODE A WHERE A.Code='WEATHER'),'AUTHUMN','Authumn',15,'Authumn',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_RULE_CODE_VALUE  VALUES (SEQ_RULE_CODE_VALUE_ID.nextval,(SELECT A.RuleCodeId FROM TB_RULE_CODE A WHERE A.Code='WEATHER'),'SPRING','Spring',15,'Spring',0,sysdate,'dbpatch',sysdate,'dbpatch');

INSERT INTO TB_RULE_CODE_VALUE  VALUES (SEQ_RULE_CODE_VALUE_ID.nextval,(SELECT A.RuleCodeId FROM TB_RULE_CODE A WHERE A.Code='WORM_COUNT'),'MORE_THAN_200','More Than 200',10,'Summer',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_RULE_CODE_VALUE  VALUES (SEQ_RULE_CODE_VALUE_ID.nextval,(SELECT A.RuleCodeId FROM TB_RULE_CODE A WHERE A.Code='WORM_COUNT'),'BETWEEN_50_150','Between 50 and 150',20,'Summer',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_RULE_CODE_VALUE  VALUES (SEQ_RULE_CODE_VALUE_ID.nextval,(SELECT A.RuleCodeId FROM TB_RULE_CODE A WHERE A.Code='WORM_COUNT'),'BELOW_50','Below 50',50,'Summer',0,sysdate,'dbpatch',sysdate,'dbpatch');


INSERT INTO TB_RULE_CODE_VALUE  VALUES (SEQ_RULE_CODE_VALUE_ID.nextval,(SELECT A.RuleCodeId FROM TB_RULE_CODE A WHERE A.Code='TREATMENT'),'IMPROVE_HEALTH','Improve Health',20,'Summer',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_RULE_CODE_VALUE  VALUES (SEQ_RULE_CODE_VALUE_ID.nextval,(SELECT A.RuleCodeId FROM TB_RULE_CODE A WHERE A.Code='TREATMENT'),'WORSTEN_HEALTH','Worsten Health',-10,'Summer',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_RULE_CODE_VALUE  VALUES (SEQ_RULE_CODE_VALUE_ID.nextval,(SELECT A.RuleCodeId FROM TB_RULE_CODE A WHERE A.Code='TREATMENT'),'NO_CHANGE','NO Change',-5,'Summer',0,sysdate,'dbpatch',sysdate,'dbpatch');

INSERT INTO TB_RULE_CODE_VALUE  VALUES (SEQ_RULE_CODE_VALUE_ID.nextval,(SELECT A.RuleCodeId FROM TB_RULE_CODE A WHERE A.Code='WATER_CONSUMPTION_LEVEL'),'OVER_INCREASE','Over Increase',5,'Summer',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_RULE_CODE_VALUE  VALUES (SEQ_RULE_CODE_VALUE_ID.nextval,(SELECT A.RuleCodeId FROM TB_RULE_CODE A WHERE A.Code='WATER_CONSUMPTION_LEVEL'),'INCREASE','Increase',30,'Summer',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_RULE_CODE_VALUE  VALUES (SEQ_RULE_CODE_VALUE_ID.nextval,(SELECT A.RuleCodeId FROM TB_RULE_CODE A WHERE A.Code='WATER_CONSUMPTION_LEVEL'),'MODERATION','Moderation',50,'Summer',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_RULE_CODE_VALUE  VALUES (SEQ_RULE_CODE_VALUE_ID.nextval,(SELECT A.RuleCodeId FROM TB_RULE_CODE A WHERE A.Code='WATER_CONSUMPTION_LEVEL'),'DECREASE','Decrease',30,'Summer',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_RULE_CODE_VALUE  VALUES (SEQ_RULE_CODE_VALUE_ID.nextval,(SELECT A.RuleCodeId FROM TB_RULE_CODE A WHERE A.Code='WATER_CONSUMPTION_LEVEL'),'OVER_DECREASE','Over Decrease',5,'Summer',0,sysdate,'dbpatch',sysdate,'dbpatch');




INSERT INTO TB_EMAIL_TEMPLATE 
VALUES (SEQ_EMAIL_TEMPLATE_ID.nextval,'Dear Farmer,

Welcome to [PT05]! We are thrilled to have you join our community of farmers dedicated to optimizing farm management and efficiency.

To complete your registration and unlock the full potential of our system, please follow these simple steps:
1. *Complete Your Profile:*
   Provide essential details about your farm, such as location, type of livestock, crops grown, and any other relevant information.
2. *Explore the Features:*
   Take some time to navigate through the app and discover the various features designed to streamline farm management tasks, optimize workflows, and enhance productivity.
3. *Get Started:*
   Once your profile is complete, you are all set to start using Farm App Name to simplify your farming operations and maximize your yields.
If you encounter any issues during the registration process or have any questions about using the app, please do not hesitate to reach out to our customer support team at [Support Email Address].
Thank you for choosing [Farm App Name]. We look forward to being part of your farming journey and helping you achieve success.

Best regards,
TeamPT05
', 'REGISTRATION', 1,0,sysdate,'dbpatch',sysdate,'dbpatch');

INSERT INTO TB_EMAIL_TEMPLATE 
VALUES (SEQ_EMAIL_TEMPLATE_ID.nextval,'Dear $name$,

This is a friendly reminder that you have $noofdays$ days left to administer medication to the sheep in Zone [$zone$]. Ensuring the timely administration of medication is crucial for maintaining the health and well-being of your flock.

Please make sure to allocate the necessary resources and schedule the medication administration accordingly to avoid any delays.

If you have any questions or need assistance, feel free to reach out.

Best regards,
TeamPT05
', 'NOTINOTE', 1,0,sysdate,'dbpatch',sysdate,'dbpatch');


INSERT INTO TB_EMAIL_TEMPLATE 
VALUES (SEQ_EMAIL_TEMPLATE_ID.nextval,'Dear $name$,

Notification: Reminder to Feed Medication

Just a gentle reminder to administer medication to your livestock.

Best regards,
TeamPT05
', 'NOTINOTE', 1,0,sysdate,'dbpatch',sysdate,'dbpatch');


INSERT INTO TB_FARM_HOUSE  VALUES (SEQ_FARM_HOUSE_ID.nextval,1026,'My FarmHouse Zone 1','Melbone',1000,'All my sheep healthy and happy',0,sysdate,'dbpatch',sysdate,'dbpatch'),
INSERT INTO TB_FARM_HOUSE  VALUES (SEQ_FARM_HOUSE_ID.nextval,1026,'My FarmHouse Zone 2','Melbone',1000,'All my sheep healthy and happy',0,sysdate,'dbpatch',sysdate,'dbpatch'),
INSERT INTO TB_FARM_HOUSE  VALUES (SEQ_FARM_HOUSE_ID.nextval,1026,'My FarmHouse Zone 3','Melbone',1000,'All my sheep healthy and happy',0,sysdate,'dbpatch',sysdate,'dbpatch');

INSERT INTO TB_FARM_HOUSE values (SEQ_FARM_HOUSE_ID.nextval,1024,'Green House Zone 1','Melbone',800,'All my sheep healthy and happy',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_FARM_HOUSE values (SEQ_FARM_HOUSE_ID.nextval,1024,'Green House Zone 2','Melbone',700,'All my sheep healthy and happy',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_FARM_HOUSE values (SEQ_FARM_HOUSE_ID.nextval,1024,'Green House Zone 3','Melbone',800,'All my sheep healthy and happy',0,sysdate,'dbpatch',sysdate,'dbpatch');


INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1000,'SHEEP','Dolly001',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1000,'SHEEP','Dolly002',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1000,'SHEEP','Dolly003',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1000,'SHEEP','Dolly004',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1000,'SHEEP','Dolly005',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1000,'SHEEP','Dolly006',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');



INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1000,'SHEEP','Dolly007',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1000,'SHEEP','Dolly008',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1000,'SHEEP','Dolly009',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1000,'SHEEP','Dolly010',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');

INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1001,'SHEEP','Jolly001',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1001,'SHEEP','Jolly002',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1001,'SHEEP','Jolly003',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1001,'SHEEP','Jolly004',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1001,'SHEEP','Jolly005',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1001,'SHEEP','Jolly006',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1001,'SHEEP','Jolly007',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1001,'SHEEP','Jolly008',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1001,'SHEEP','Jolly009',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1001,'SHEEP','Jolly010',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');


INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1004,'SHEEP','May001',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1004,'SHEEP','May002',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1004,'SHEEP','May003',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1004,'SHEEP','May004',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1004,'SHEEP','May005',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1004,'SHEEP','May006',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1004,'SHEEP','May007',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1004,'SHEEP','May008',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1004,'SHEEP','May009',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_ANIMAL VALUES (SEQ_ANIMAL_ID.nextval,1004,'SHEEP','May010',1,10,'Austria Sheep Type A',0,sysdate,'dbpatch',sysdate,'dbpatch');


INSERT INTO TB_Note VALUES (SEQ_NOTE_ID.nextval,1026,1000,'Zone 1 - Sheep','Daily Activity','Open','My Daily Notes',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_Note VALUES (SEQ_NOTE_ID.nextval,1026,1000,'Zone 2 - Sheep','Daily Activity','Open','My Daily Notes',0,sysdate,'dbpatch',sysdate,'dbpatch');


INSERT INTO TB_NOTIFICATION_SETTING VALUES (SEQ_NOTIFICATION_SETTING_ID.nextval,1026,'Y','catguy.aws1@gmail.com',5,0,sysdate,'dbpatch',sysdate,'dbpatch');


INSERT INTO TB_USER_NOTE_RULE VALUES (SEQ_USER_NOTE_RULE_ID.nextval,1004,1000,5,'The weather is extremely hot',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_USER_NOTE_RULE VALUES (SEQ_USER_NOTE_RULE_ID.nextval,1004,1004,10,'Warm Count more than 200 !!!! Alert',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_USER_NOTE_RULE VALUES (SEQ_USER_NOTE_RULE_ID.nextval,1004,1009,5,'The weather is extremely hot',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_USER_NOTE_RULE VALUES (SEQ_USER_NOTE_RULE_ID.nextval,1004,1014,5,'The weather is extremely hot',0,sysdate,'dbpatch',sysdate,'dbpatch');


INSERT INTO TB_USER_NOTE_RULE VALUES (SEQ_USER_NOTE_RULE_ID.nextval,1010,1000,5,'The weather is extremely hot',0,sysdate-3,'dbpatch',sysdate-3,'dbpatch');
INSERT INTO TB_USER_NOTE_RULE VALUES (SEQ_USER_NOTE_RULE_ID.nextval,1010,1004,10,'Warm Count more than 200 !!!! Alert',0,sysdate-3,'dbpatch',sysdate-3,'dbpatch');
INSERT INTO TB_USER_NOTE_RULE VALUES (SEQ_USER_NOTE_RULE_ID.nextval,1010,1009,5,'The weather is extremely hot',0,sysdate-3,'dbpatch',sysdate-3,'dbpatch');
INSERT INTO TB_USER_NOTE_RULE VALUES (SEQ_USER_NOTE_RULE_ID.nextval,1010,1014,5,'The weather is extremely hot',0,sysdate-3,'dbpatch',sysdate-3,'dbpatch');


INSERT INTO TB_USER_NOTE_RULE VALUES (SEQ_USER_NOTE_RULE_ID.nextval,1005,1000,5,'The weather is extremely hot',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_USER_NOTE_RULE VALUES (SEQ_USER_NOTE_RULE_ID.nextval,1005,1004,10,'Warm Count more than 200 !!!! Alert',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_USER_NOTE_RULE VALUES (SEQ_USER_NOTE_RULE_ID.nextval,1005,1009,5,'The weather is extremely hot',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_USER_NOTE_RULE VALUES (SEQ_USER_NOTE_RULE_ID.nextval,1005,1014,5,'The weather is extremely hot',0,sysdate,'dbpatch',sysdate,'dbpatch');


INSERT INTO TB_TASK VALUES (SEQ_TASK_ID.nextval,1026,1000,'TREATMENT - DRENCH LEVEL 1',0,sysdate,sysdate,'To prevent increasing worm count',0,sysdate,'dbpatch',sysdate,'dbpatch');
INSERT INTO TB_TASK VALUES (SEQ_TASK_ID.nextval,1024,1003,'HEALTH CHECK',0,sysdate,sysdate,'Health check',0,sysdate,'dbpatch',sysdate,'dbpatch');

















