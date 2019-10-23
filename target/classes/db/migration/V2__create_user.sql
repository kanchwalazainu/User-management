CREATE TABLE PCCWUSER(
	user_id int AUTO_INCREMENT,
	user_firstname VARCHAR(200),
	user_lastname VARCHAR(200),
	emailid VARCHAR(200),
	deleted_flag boolean

);


CREATE TABLE PCCWMAILLIST(
	user_id int ,
	EMAILID VARCHAR(200),
	MAILSUBJECT VARCHAR(200),
	MAILBODY VARCHAR(200),
	
);