

-------------------------------------------------------------------------------
--  cms article
-------------------------------------------------------------------------------
CREATE TABLE CMS_ARTICLE(
        ID BIGINT NOT NULL,
	TITLE VARCHAR(200),
	SHORT_TITLE VARCHAR(200),
	SUB_TITLE VARCHAR(200),
	CONTENT TEXT,
	SUMMARY VARCHAR(200),
	LOGO VARCHAR(200),
	KEYWORD VARCHAR(200),
	TAGS VARCHAR(200),
	SOURCE VARCHAR(200),
	ALLOW_COMMENT INT,
	STATUS INT,
	PUBLISH_TIME TIMESTAMP NULL,
	CLOSE_TIME TIMESTAMP NULL,
	TYPE INT,
	TOP INT,
	WEIGHT INT,
	CREATE_TIME TIMESTAMP NULL,
	TEMPLATE VARCHAR(200),
	VIEW_COUNT INT,
	RECOMMEND_ID BIGINT,
	RECOMMEND_STATUS INT,
	USER_ID VARCHAR(200),
	CATALOG_ID BIGINT,
        CONSTRAINT PK_CMS_ARTICLE PRIMARY KEY(ID),
	CONSTRAINT FK_CMS_ARTICLE_CATALOG FOREIGN KEY(CATALOG_ID) REFERENCES CMS_CATALOG(ID)
) ENGINE=INNODB CHARSET=UTF8;

