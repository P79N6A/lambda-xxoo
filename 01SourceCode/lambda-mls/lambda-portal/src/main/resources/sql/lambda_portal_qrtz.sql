/*
Navicat MySQL Data Transfer

Source Server         : 111.230.157.133_3306
Source Server Version : 50721
Source Host           : 111.230.157.133:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-01-28 10:30:38
*/

DROP TABLE IF EXISTS QRTZ_FIRED_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_PAUSED_TRIGGER_GRPS;
DROP TABLE IF EXISTS QRTZ_SCHEDULER_STATE;
DROP TABLE IF EXISTS QRTZ_LOCKS;
DROP TABLE IF EXISTS QRTZ_SIMPLE_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_SIMPROP_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_CRON_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_BLOB_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_JOB_DETAILS;
DROP TABLE IF EXISTS QRTZ_CALENDARS;


CREATE TABLE QRTZ_JOB_DETAILS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    JOB_NAME  VARCHAR(200) NOT NULL,
    JOB_GROUP VARCHAR(200) NOT NULL,
    DESCRIPTION VARCHAR(250) NULL,
    JOB_CLASS_NAME   VARCHAR(250) NOT NULL,
    IS_DURABLE VARCHAR(1) NOT NULL,
    IS_NONCONCURRENT VARCHAR(1) NOT NULL,
    IS_UPDATE_DATA VARCHAR(1) NOT NULL,
    REQUESTS_RECOVERY VARCHAR(1) NOT NULL,
    JOB_DATA BLOB NULL,
    PRIMARY KEY (SCHED_NAME,JOB_NAME,JOB_GROUP)
);

CREATE TABLE QRTZ_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    JOB_NAME  VARCHAR(200) NOT NULL,
    JOB_GROUP VARCHAR(200) NOT NULL,
    DESCRIPTION VARCHAR(250) NULL,
    NEXT_FIRE_TIME BIGINT(13) NULL,
    PREV_FIRE_TIME BIGINT(13) NULL,
    PRIORITY INTEGER NULL,
    TRIGGER_STATE VARCHAR(16) NOT NULL,
    TRIGGER_TYPE VARCHAR(8) NOT NULL,
    START_TIME BIGINT(13) NOT NULL,
    END_TIME BIGINT(13) NULL,
    CALENDAR_NAME VARCHAR(200) NULL,
    MISFIRE_INSTR SMALLINT(2) NULL,
    JOB_DATA BLOB NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,JOB_NAME,JOB_GROUP)
        REFERENCES QRTZ_JOB_DETAILS(SCHED_NAME,JOB_NAME,JOB_GROUP)
);

CREATE TABLE QRTZ_SIMPLE_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    REPEAT_COUNT BIGINT(7) NOT NULL,
    REPEAT_INTERVAL BIGINT(12) NOT NULL,
    TIMES_TRIGGERED BIGINT(10) NOT NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
        REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);

CREATE TABLE QRTZ_CRON_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    CRON_EXPRESSION VARCHAR(200) NOT NULL,
    TIME_ZONE_ID VARCHAR(80),
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
        REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);

CREATE TABLE QRTZ_SIMPROP_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    STR_PROP_1 VARCHAR(512) NULL,
    STR_PROP_2 VARCHAR(512) NULL,
    STR_PROP_3 VARCHAR(512) NULL,
    INT_PROP_1 INT NULL,
    INT_PROP_2 INT NULL,
    LONG_PROP_1 BIGINT NULL,
    LONG_PROP_2 BIGINT NULL,
    DEC_PROP_1 NUMERIC(13,4) NULL,
    DEC_PROP_2 NUMERIC(13,4) NULL,
    BOOL_PROP_1 VARCHAR(1) NULL,
    BOOL_PROP_2 VARCHAR(1) NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
    REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);

CREATE TABLE QRTZ_BLOB_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    BLOB_DATA BLOB NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
        REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);

CREATE TABLE QRTZ_CALENDARS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    CALENDAR_NAME  VARCHAR(200) NOT NULL,
    CALENDAR BLOB NOT NULL,
    PRIMARY KEY (SCHED_NAME,CALENDAR_NAME)
);

CREATE TABLE QRTZ_PAUSED_TRIGGER_GRPS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_GROUP  VARCHAR(200) NOT NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_GROUP)
);

CREATE TABLE QRTZ_FIRED_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    ENTRY_ID VARCHAR(95) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    INSTANCE_NAME VARCHAR(200) NOT NULL,
    FIRED_TIME BIGINT(13) NOT NULL,
    SCHED_TIME BIGINT(13) NOT NULL,
    PRIORITY INTEGER NOT NULL,
    STATE VARCHAR(16) NOT NULL,
    JOB_NAME VARCHAR(200) NULL,
    JOB_GROUP VARCHAR(200) NULL,
    IS_NONCONCURRENT VARCHAR(1) NULL,
    REQUESTS_RECOVERY VARCHAR(1) NULL,
    PRIMARY KEY (SCHED_NAME,ENTRY_ID)
);

CREATE TABLE QRTZ_SCHEDULER_STATE
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    INSTANCE_NAME VARCHAR(200) NOT NULL,
    LAST_CHECKIN_TIME BIGINT(13) NOT NULL,
    CHECKIN_INTERVAL BIGINT(13) NOT NULL,
    PRIMARY KEY (SCHED_NAME,INSTANCE_NAME)
);

CREATE TABLE QRTZ_LOCKS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    LOCK_NAME  VARCHAR(40) NOT NULL,
    PRIMARY KEY (SCHED_NAME,LOCK_NAME)
);

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Records of t_job
-- ----------------------------
INSERT INTO `t_job` VALUES ('1', 'testTask', 'test', 'admin', '0/1 * * * * ?1', '1', '有参任务调度测试', '2018-02-24 16:26:14');
INSERT INTO `t_job` VALUES ('2', 'testTask', 'test1', null, '0/10 * * * * ?', '1', '无参任务调度测试', '2018-02-24 17:06:23');
INSERT INTO `t_job` VALUES ('3', 'testTask', 'test', 'hello world', '0/1 * * * * ?', '1', '有参任务调度测试,每隔一秒触发', '2018-02-26 09:28:26');
INSERT INTO `t_job` VALUES ('11', 'testTask', 'test2', null, '0/5 * * * * ?', '1', '测试异常', '2018-02-26 11:15:30');

-- ----------------------------
-- Table structure for t_job_log
-- ----------------------------
DROP TABLE IF EXISTS `t_job_log`;
CREATE TABLE `t_job_log` (
  `LOG_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `JOB_ID` bigint(20) NOT NULL COMMENT '任务id',
  `BEAN_NAME` varchar(100) NOT NULL COMMENT 'spring bean名称',
  `METHOD_NAME` varchar(100) NOT NULL COMMENT '方法名',
  `PARAMS` varchar(200) DEFAULT NULL COMMENT '参数',
  `STATUS` char(2) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `ERROR` text COMMENT '失败信息',
  `TIMES` decimal(11,0) DEFAULT NULL COMMENT '耗时(单位：毫秒)',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`LOG_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2502 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_job_log
-- ----------------------------
INSERT INTO `t_job_log` VALUES ('2450', '3', 'testTask', 'test', 'hello world', '0', null, '2', '2018-03-20 15:31:52');
INSERT INTO `t_job_log` VALUES ('2451', '3', 'testTask', 'test', 'hello world', '0', null, '0', '2018-03-20 15:31:53');
INSERT INTO `t_job_log` VALUES ('2452', '3', 'testTask', 'test', 'hello world', '0', null, '2', '2018-03-20 15:31:54');
INSERT INTO `t_job_log` VALUES ('2453', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:31:55');
INSERT INTO `t_job_log` VALUES ('2454', '3', 'testTask', 'test', 'hello world', '0', null, '0', '2018-03-20 15:31:56');
INSERT INTO `t_job_log` VALUES ('2455', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:31:57');
INSERT INTO `t_job_log` VALUES ('2456', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:31:59');
INSERT INTO `t_job_log` VALUES ('2457', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:31:59');
INSERT INTO `t_job_log` VALUES ('2458', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:32:00');
INSERT INTO `t_job_log` VALUES ('2459', '3', 'testTask', 'test', 'hello world', '0', null, '0', '2018-03-20 15:32:01');
INSERT INTO `t_job_log` VALUES ('2460', '3', 'testTask', 'test', 'hello world', '0', null, '5', '2018-03-20 15:32:02');
INSERT INTO `t_job_log` VALUES ('2461', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:32:03');
INSERT INTO `t_job_log` VALUES ('2462', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:32:04');
INSERT INTO `t_job_log` VALUES ('2463', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:32:05');
INSERT INTO `t_job_log` VALUES ('2464', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:32:06');
INSERT INTO `t_job_log` VALUES ('2465', '11', 'testTask', 'test2', null, '1', 'java.lang.NoSuchMethodException: com.yatop.lambda.portal.job.task.TestTask.test2()', '0', '2018-03-20 15:32:26');
INSERT INTO `t_job_log` VALUES ('2466', '2', 'testTask', 'test1', null, '0', null, '1', '2018-04-02 15:26:40');
INSERT INTO `t_job_log` VALUES ('2467', '2', 'testTask', 'test1', null, '0', null, '1', '2018-04-02 15:26:50');
INSERT INTO `t_job_log` VALUES ('2468', '2', 'testTask', 'test1', null, '0', null, '1', '2018-04-02 15:27:20');
INSERT INTO `t_job_log` VALUES ('2469', '2', 'testTask', 'test1', null, '0', null, '3', '2018-04-02 17:29:20');
INSERT INTO `t_job_log` VALUES ('2476', '1', 'testTask', 'test', 'admin', '0', null, '1', '2019-01-06 08:25:00');
INSERT INTO `t_job_log` VALUES ('2477', '11', 'testTask', 'test2', null, '1', 'java.lang.NoSuchMethodException: com.yatop.lambda.portal.job.task.TestTask.test2()', '0', '2019-01-06 08:25:25');
INSERT INTO `t_job_log` VALUES ('2478', '1', 'testTask', 'test', 'admin', '0', null, '1', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2479', '1', 'testTask', 'test', 'admin', '0', null, '1', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2480', '1', 'testTask', 'test', 'admin', '0', null, '1', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2481', '1', 'testTask', 'test', 'admin', '0', null, '1', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2482', '1', 'testTask', 'test', 'admin', '0', null, '0', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2483', '1', 'testTask', 'test', 'admin', '0', null, '1', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2484', '1', 'testTask', 'test', 'admin', '0', null, '0', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2485', '1', 'testTask', 'test', 'admin', '0', null, '0', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2486', '1', 'testTask', 'test', 'admin', '0', null, '0', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2487', '1', 'testTask', 'test', 'admin', '0', null, '0', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2488', '1', 'testTask', 'test', 'admin', '0', null, '1', '2019-01-06 08:40:16');
INSERT INTO `t_job_log` VALUES ('2489', '1', 'testTask', 'test', 'admin', '0', null, '0', '2019-01-06 08:40:17');
INSERT INTO `t_job_log` VALUES ('2490', '1', 'testTask', 'test', 'admin', '0', null, '1', '2019-01-06 08:40:18');
INSERT INTO `t_job_log` VALUES ('2491', '1', 'testTask', 'test', 'admin', '0', null, '0', '2019-01-06 08:40:19');
INSERT INTO `t_job_log` VALUES ('2492', '1', 'testTask', 'test', 'admin', '0', null, '1', '2019-01-06 08:40:20');
INSERT INTO `t_job_log` VALUES ('2493', '1', 'testTask', 'test', 'admin', '0', null, '0', '2019-01-06 08:40:21');
INSERT INTO `t_job_log` VALUES ('2494', '1', 'testTask', 'test', 'admin', '0', null, '0', '2019-01-06 08:40:22');
INSERT INTO `t_job_log` VALUES ('2495', '11', 'testTask', 'test2', null, '1', 'java.lang.NoSuchMethodException: com.yatop.lambda.portal.job.task.TestTask.test2()', '2', '2019-01-06 08:40:36');
INSERT INTO `t_job_log` VALUES ('2496', '11', 'testTask', 'test2', null, '1', 'java.lang.NoSuchMethodException: com.yatop.lambda.portal.job.task.TestTask.test2()', '0', '2019-01-06 08:40:36');
INSERT INTO `t_job_log` VALUES ('2497', '11', 'testTask', 'test2', null, '1', 'java.lang.NoSuchMethodException: com.yatop.lambda.portal.job.task.TestTask.test2()', '1', '2019-01-06 08:40:40');
INSERT INTO `t_job_log` VALUES ('2498', '2', 'testTask', 'test1', null, '0', null, '1', '2019-01-06 11:36:20');
INSERT INTO `t_job_log` VALUES ('2499', '1', 'testTask', 'test', 'admin', '0', null, '30', '2019-01-22 05:41:01');
INSERT INTO `t_job_log` VALUES ('2500', '1', 'testTask', 'test', 'admin', '0', null, '9', '2019-01-23 06:28:58');
INSERT INTO `t_job_log` VALUES ('2501', '1', 'testTask', 'test', 'admin', '0', null, '12', '2019-01-24 05:39:59');


set global sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
set session sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
