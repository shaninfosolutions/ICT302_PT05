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
VALUES (SEQ_EMAIL_TEMPLATE_ID.nextval,'<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n<title>Page Title</title>\n<meta charset=\"UTF-8\">\n <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n<style>\n* {\nbox-sizing: border-box;\n }\n\n/* Style the body */\nbody {\nfont-family: Arial, Helvetica, sans-serif;\nmargin: 0;\n \n\n/* Header/logo Title */\n .header {\n padding: 80px;\ntext-align: center;\n background: #1abc9c;\ncolor: white;\n}\n\n/* Increase the font size of the heading */\n.header h1 {\n font-size: 40px;\n }\n\n/* Style the top navigation bar */\n        .navbar {\n            overflow: hidden;\n background-color: #333;\n}\n\n/* Style the navigation bar links */\n.navbar a {\nfloat: left;\ndisplay: block;\n            color: white;\n text-align: center;\n            padding: 14px 20px;\ntext-decoration: none;\n}\n\n /* Right-aligned link */\n.navbar a.right {\n  float: right;\n        }\n\n /* Change color on hover */\n.navbar a:hover {\n background-color: #ddd;\n color: black;\n}\n\n/* Column container */\n        .row {\n display: -ms-flexbox; /* IE10 */\n            display: flex;\n -ms-flex-wrap: wrap; /* IE10 */\nflex-wrap: wrap;\n  }\n\n  /* Create two unequal columns that sits next to each other */\n        /* Sidebar/left column */\n.side {\n-ms-flex: 30%; /* IE10 */\nflex: 30%;\n background-color: #f1f1f1;\n padding: 20px;\n        }\n\n /* Main column */\n        .main {\n-ms-flex: 70%; /* IE10 */\n flex: 70%;\n  background-color: white;\npadding: 20px;\n }\n\n  /* Fake image, just for this example */\n        .fakeimg {\n background-color: #aaa;\n            width: 100%;\npadding: 20px;\n }\n\n        /* Footer */\n.footer {\n padding: 20px;\ntext-align: center;\n            background: #ddd;\n        }\n\n        /* Responsive layout - when the screen is less than 700px wide, make the two columns stack on top of each other instead of next to each other */\n        @media screen and (max-width: 700px) {\n .row {\n flex-direction: column;\n }\n }\n\n /* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */\n        @media screen and (max-width: 400px) {\n            .navbar a {\n float: none;\n                width: 100%;\n}\n        }\n    </style>\n</head>\n<body>\n\n<div class=\"header\">\n    <h1>My Website</h1>\n    <p>A website created by me.</p>\n</div>\n\n<div class=\"navbar\">\n    <a href=\"#\">Link</a>\n    <a href=\"#\">Link</a>\n    <a href=\"#\">Link</a>\n    <a href=\"#\" class=\"right\">Link</a>\n</div>\n\n<div class=\"row\">\n    <div class=\"side\">\n        <h2>About Me</h2>\n        <h5>Photo of me:</h5>\n <div class=\"fakeimg\" style=\"height:200px;\">Image</div>\n<p>Some text about me in culpa qui officia deserunt mollit anim..</p>\n<h3>More Text</h3>\n<p>Lorem ipsum dolor sit ame.</p>\n        <div class=\"fakeimg\" style=\"height:60px;\">Image</div><br>\n        <div class=\"fakeimg\" style=\"height:60px;\">Image</div><br>\n<div class=\"fakeimg\" style=\"height:60px;\">Image</div>\n</div>\n    <div class=\"main\">\n <h2>TITLE HEADING</h2>\n <h5>Title description, Dec 7, 2017</h5>\n        <div class=\"fakeimg\" style=\"height:200px;\">Image</div>\n        <p>Some text..</p>\n        <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>\n   <br>\n        <h2>TITLE HEADING</h2>\n        <h5>Title description, Sep 2, 2017</h5>\n        <div class=\"fakeimg\" style=\"height:200px;\">Image</div>\n        <p>Some text..</p>\n        <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>\n</div>\n</div>\n\n<div class=\"footer\">\n<h2>Footer</h2>\n</div>\n\n</body>\n</html>', 'Template name', 1,0,sysdate,'dbpatch',sysdate,'dbpatch');



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

















