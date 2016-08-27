

-------------------------------------------------------------------------------
--  meeting info
-------------------------------------------------------------------------------
use lemon;
CREATE TABLE MEETING_INFO(
        ID BIGINT NOT NULL,
	SUBJECT VARCHAR(200),
	CONTENT VARCHAR(200),
	CREATE_TIME DATETIME,
	START_TIME DATETIME,
	END_TIME DATETIME,
	ORGANIZER VARCHAR(64),
	MEETING_TIMEZONE VARCHAR(50),
	TYPE VARCHAR(50),
	CATALOG VARCHAR(50),
	STATUS VARCHAR(50),
	MEETING_ROOM_ID BIGINT,
	TENANT_ID VARCHAR(64),
        CONSTRAINT PK_MEETING_INFO PRIMARY KEY(ID),
        CONSTRAINT FK_MEETING_INFO_ROOM FOREIGN KEY(MEETING_ROOM_ID) REFERENCES MEETING_ROOM(ID)
) ENGINE=INNODB CHARSET=UTF8;

