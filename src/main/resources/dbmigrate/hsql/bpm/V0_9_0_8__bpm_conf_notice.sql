
CREATE TABLE BPM_CONF_NOTICE(
	ID BIGINT NOT NULL,
	TYPE INT,
	RECEIVER VARCHAR(200),
	DUE_DATE VARCHAR(50),
	NODE_ID BIGINT,
	TEMPLATE_ID BIGINT,
        CONSTRAINT PK_BPM_CONF_NOTICE PRIMARY KEY(ID),
        CONSTRAINT FK_BPM_CONF_NOTICE_NODE FOREIGN KEY(NODE_ID) REFERENCES BPM_CONF_NODE(ID),
        CONSTRAINT FK_BPM_CONF_NOTICE_TEMPLATE FOREIGN KEY(TEMPLATE_ID) REFERENCES BPM_MAIL_TEMPLATE(ID)
);

COMMENT ON TABLE BPM_CONF_NOTICE IS '配置提醒';
COMMENT ON COLUMN BPM_CONF_NOTICE.ID IS '主键';
COMMENT ON COLUMN BPM_CONF_NOTICE.TYPE IS '分类';
COMMENT ON COLUMN BPM_CONF_NOTICE.RECEIVER IS '接收人';
COMMENT ON COLUMN BPM_CONF_NOTICE.DUE_DATE IS '持续时间';
COMMENT ON COLUMN BPM_CONF_NOTICE.NODE_ID IS '外键，配置节点';
COMMENT ON COLUMN BPM_CONF_NOTICE.TEMPLATE_ID IS '外键，模板';

