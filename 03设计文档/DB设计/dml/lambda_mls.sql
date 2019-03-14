/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50724
Source Host           : 127.0.0.1:3306
Source Database       : lambda_mls

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-03-14 09:54:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dw_data_table
-- ----------------------------
DROP TABLE IF EXISTS `dw_data_table`;
CREATE TABLE `dw_data_table` (
  `TABLE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据表ID',
  `TABLE_NAME` varchar(200) NOT NULL COMMENT '数据表名\r\n            \r\n            普通数据表：由英文字符、数字和下划线组成，起始字符不能为下划线\r\n            临时数据表：tmp$<flow_id>_<node_id>_<char_id>',
  `TABLE_TYPE` int(11) NOT NULL COMMENT '数据表类型\r\n            0：普通数据表\r\n            1：临时数据表',
  `OWNER_DW_ID` bigint(20) NOT NULL COMMENT '所属数据库ID',
  `REL_FLOW_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联工作流ID，无关联实验设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联节点ID，创建数据表的工作流节点，无关联则设为-1',
  `REL_CHAR_ID` varchar(200) NOT NULL DEFAULT '-1' COMMENT '关联特征ID，创建数据表的工作流节点输出特征，无关联则设为-1',
  `TABLE_COLUMNS` bigint(20) DEFAULT NULL COMMENT '列数',
  `TABLE_ROWS` bigint(20) DEFAULT NULL COMMENT '行数',
  `DATA_FILE_TYPE` int(11) NOT NULL DEFAULT '1' COMMENT '数据文件类型\r\n            1：Parquet文件格式 ',
  `DATA_FILE_SIZE` bigint(20) DEFAULT NULL COMMENT '文件大小，单位为字节',
  `DATA_FILE` varchar(800) DEFAULT NULL COMMENT '数据文件名，普通数据表存放于数据目录下，临时数据表存放于作业目录下\r\n            \r\n            普通数据表：${DATA_DIR}/table_<table_id>.dat\r\n            临时数据表：${FLOW_DIR}/table_<flow_id>_<table_id>.dat',
  `SUMMARY_DFS_FILE` varchar(800) DEFAULT NULL COMMENT 'DFS数据概要文件名，普通数据表存放于数据目录下，临时数据表存放于作业目录下\r\n            \r\n            普通数据表：${DATA_DIR}/table_summary_<table_id>.json\r\n            临时数据表：${FLOW_DIR}/table_summary_<node_id>_<table_id>.json',
  `SUMMARY_LOCAL_FILE` varchar(800) DEFAULT NULL COMMENT '本地数据概要文件名，普通数据表存放于数据目录下，临时数据表存放于作业目录下\r\n            \r\n            普通数据表：${DATA_DIR}/table_summary_<table_id>.json\r\n            临时数据表：${FLOW_DIR}/table_summary_<node_id>_<table_id>.json',
  `TABLE_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '数据表状态\r\n            0：空表\r\n            1：正常',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`TABLE_ID`),
  KEY `Index_1` (`OWNER_DW_ID`,`TABLE_TYPE`,`TABLE_NAME`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_DW_ID`,`TABLE_TYPE`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`OWNER_DW_ID`,`TABLE_STATE`,`STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据表\r\n\r\n逻辑删除，同一库下正常状态的表名唯一';

-- ----------------------------
-- Records of dw_data_table
-- ----------------------------

-- ----------------------------
-- Table structure for dw_data_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `dw_data_warehouse`;
CREATE TABLE `dw_data_warehouse` (
  `DW_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库ID',
  `DW_CODE` varchar(100) NOT NULL COMMENT '数据库代码\r\n            \r\n            公共数据库：由英文字符、数字和下划线组成，起始字符不能为下划线\r\n            项目数据库：$符号前缀 + 项目代码',
  `DW_NAME` varchar(200) NOT NULL COMMENT '数据库名',
  `DW_TYPE` int(11) NOT NULL COMMENT '数据库类型\r\n            0：公共数据库，仅有一个，用于存放实验模版所预置的数据表\r\n            1：项目数据库，随项目创建同时生成，存放项目中产生的数据表',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID，数据库类型为公共数据库时设为-1',
  `DATA_DFS_DIR` varchar(800) DEFAULT NULL COMMENT 'DFS数据目录，存放普通数据表的数据文件和数据概要文件\r\n            \r\n            ${HDFS_SITE}/${DFS_WORK_ROOT}/dw_data/<dw_code>',
  `DATA_LOCAL_DIR` varchar(800) DEFAULT NULL COMMENT '本地数据目录，缓存普通数据表的数据概要文件\r\n            \r\n            ${LOCAL_WORK_ROOT}/dw_data/<dw_code>',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`DW_ID`),
  KEY `Index_1` (`DW_CODE`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`DW_TYPE`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`DW_NAME`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='数据库表，对数据表做分组，辅助项目权限隔离\r\n\r\n逻辑删除，正常状态的代码唯一和名称唯一';

-- ----------------------------
-- Records of dw_data_warehouse
-- ----------------------------
INSERT INTO `dw_data_warehouse` VALUES ('10000', 'public_data', '公共数据库', '0', '10000', '${HDFS_SITE}/${DFS_WORK_ROOT}/dw_data/10000', '${LOCAL_WORK_ROOT}/dw_data/10000', '平台内置公共数据库，唯一', '0', '2018-11-25 18:16:40', 'admin', '2018-11-25 18:16:40', 'admin');

-- ----------------------------
-- Table structure for em_experiment
-- ----------------------------
DROP TABLE IF EXISTS `em_experiment`;
CREATE TABLE `em_experiment` (
  `EXPERIMENT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '实验ID',
  `EXPERIMENT_NAME` varchar(200) NOT NULL COMMENT '实验名称',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `SUMMARY` varchar(256) DEFAULT NULL COMMENT '摘要',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`EXPERIMENT_ID`),
  KEY `Index_1` (`OWNER_PROJECT_ID`,`EXPERIMENT_NAME`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_PROJECT_ID`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实验表，实验是工作流的外壳主体\r\n\r\n逻辑删除，主实验正常状态的预测实验唯一';

-- ----------------------------
-- Records of em_experiment
-- ----------------------------

-- ----------------------------
-- Table structure for em_experiment_template
-- ----------------------------
DROP TABLE IF EXISTS `em_experiment_template`;
CREATE TABLE `em_experiment_template` (
  `TEMPLATE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '模版ID',
  `TEMPLATE_NAME` varchar(200) NOT NULL COMMENT '模版名称',
  `SEQUENCE` int(11) NOT NULL COMMENT '模版序号，排序用',
  `TEMPLATE_CONTENT` longtext COMMENT '模版内容',
  `TEMPLATE_COUNT` bigint(20) NOT NULL DEFAULT '1000' COMMENT '模版使用计数',
  `SUMMARY` varchar(256) DEFAULT NULL COMMENT '摘要',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`TEMPLATE_ID`),
  KEY `Index_1` (`SEQUENCE`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`TEMPLATE_NAME`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实验模版表';

-- ----------------------------
-- Records of em_experiment_template
-- ----------------------------

-- ----------------------------
-- Table structure for mw_model
-- ----------------------------
DROP TABLE IF EXISTS `mw_model`;
CREATE TABLE `mw_model` (
  `MODEL_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '模型ID',
  `MODEL_NAME` varchar(200) NOT NULL COMMENT '模型名称\r\n            \r\n            普通模型：由字符和数字组成，无特殊字符\r\n            临时模型：组件名称 - 同组件节点序号 - Model [ - 评估指标 - 排名序号]',
  `MODEL_TYPE` int(11) NOT NULL COMMENT '模型类型\r\n            0：普通模型\r\n            1：临时模型',
  `OWNER_MW_ID` bigint(20) NOT NULL COMMENT '所属模型库ID',
  `REL_FLOW_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联工作流ID，无关联实验设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联节点ID，创建模型的工作流节点，无关联则设为-1',
  `REL_CHAR_ID` varchar(200) NOT NULL DEFAULT '-1' COMMENT '关联特征ID，创建模型的工作流节点输出特征，无关联则设为-1',
  `REF_ALGORITHM_ID` bigint(20) NOT NULL COMMENT '引用算法ID',
  `MODEL_FILE_SIZE` bigint(20) DEFAULT NULL COMMENT '模型文件大小，单位为字节',
  `MODEL_FILE` varchar(800) DEFAULT NULL COMMENT '模型文件名，普通模型存放于模型目录下，临时模型存放于作业目录下\r\n            \r\n            普通模型：${MODEL_DIR}/model_<model_id>.dat\r\n            临时模型：${FLOW_DIR}/model_<node_id>_<model_id>.dat',
  `SUMMARY_DFS_FILE` varchar(800) DEFAULT NULL COMMENT 'DFS模型概要文件名，普通模型存放于模型目录下，临时模型存放于作业目录下，记录训练算法参数，训练收敛过程（e.g. LogLoss，AUC），以及其他模型训练相关可以收集到的所有信息\r\n            \r\n            普通模型：${MODEL_DIR}/model_summary_<model_id>.json\r\n            临时模型：${FLOW_DIR}/model_summary_<node_id>_<model_id>.json',
  `SUMMARY_LOCAL_FILE` varchar(800) DEFAULT NULL COMMENT '本地模型概要文件名，普通模型存放于模型目录下，临时模型存放于作业目录下，记录训练算法参数，训练收敛过程（e.g. LogLoss，AUC），以及其他模型训练相关可以收集到的所有信息\r\n            \r\n            普通模型：${MODEL_DIR}/model_summary_<model_id>.json\r\n            临时模型：${FLOW_DIR}/model_summary_<node_id>_<model_id>.json',
  `MODEL_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '模型状态\r\n            0：空模型\r\n            1：正常',
  `TRAIN_COST_TIME` bigint(20) DEFAULT NULL COMMENT '训练运行时间，单位毫秒',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`MODEL_ID`),
  KEY `Index_1` (`OWNER_MW_ID`,`MODEL_TYPE`,`MODEL_NAME`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_MW_ID`,`MODEL_TYPE`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`OWNER_MW_ID`,`MODEL_STATE`,`STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模型表，导入外部模型待暂不考虑\r\n\r\n逻辑删除';

-- ----------------------------
-- Records of mw_model
-- ----------------------------

-- ----------------------------
-- Table structure for mw_model_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `mw_model_warehouse`;
CREATE TABLE `mw_model_warehouse` (
  `MW_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库ID',
  `MW_CODE` varchar(100) NOT NULL COMMENT '模型库代码\r\n            \r\n            公共模型库：由英文字符、数字和下划线组成，起始字符不能为下划线\r\n            项目模型库：$符号前缀 + 项目代码',
  `MW_NAME` varchar(200) NOT NULL COMMENT '模型库名',
  `MW_TYPE` int(11) NOT NULL COMMENT '数据库类型\r\n            0：公共模型库（长期建议不支持）\r\n            1：项目模型库，随项目创建同时生成，存放项目中产生的模型',
  `OWNER_PROJECT_ID` bigint(20) DEFAULT NULL COMMENT '所属项目ID，模型库类型为公共模型库时设为-1',
  `MODEL_DFS_DIR` varchar(800) DEFAULT NULL COMMENT 'DFS模型目录，存放普通模型的模型文件和模型概要文件\r\n            \r\n            ${HDFS_SITE}/${DFS_WORK_ROOT}/mw_model/<mw_code>',
  `MODEL_LOCAL_DIR` varchar(800) DEFAULT NULL COMMENT '本地模型目录，缓存普通模型的模型概要文件\r\n            \r\n            ${LOCAL_WORK_ROOT}/mw_model/<mw_code>',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`MW_ID`),
  UNIQUE KEY `Index_1` (`MW_NAME`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`MW_TYPE`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`MW_CODE`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='模型库表，对模型做分组，辅助项目权限隔离\r\n\r\n逻辑删除，正常状态的代码唯一和名称唯一';

-- ----------------------------
-- Records of mw_model_warehouse
-- ----------------------------
INSERT INTO `mw_model_warehouse` VALUES ('10000', 'public_model', '公共模型库', '0', '10000', '${HDFS_SITE}/${DFS_WORK_ROOT}/mw_data/10000', '${LOCAL_WORK_ROOT}/mw_data/10000', '平台内置公共模型库，唯一', '0', '2018-11-25 18:16:40', 'admin', '2018-11-25 18:16:40', 'admin');

-- ----------------------------
-- Table structure for pr_project
-- ----------------------------
DROP TABLE IF EXISTS `pr_project`;
CREATE TABLE `pr_project` (
  `PROJECT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '项目ID',
  `PROJECT_CODE` varchar(100) NOT NULL COMMENT '项目代码',
  `PROJECT_NAME` varchar(200) NOT NULL COMMENT '项目名称',
  `DW_ID` bigint(20) NOT NULL COMMENT '项目数据库ID',
  `MW_ID` bigint(20) NOT NULL COMMENT '项目模型库ID',
  `CACHE_EXPIRE_DAYS` int(11) NOT NULL DEFAULT '14' COMMENT '临时数据表过期天数，每天2点扫描清理，另外提供主动清理接口，不做自动清理可配置为-1',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PROJECT_ID`),
  KEY `Index_1` (`PROJECT_CODE`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`PROJECT_NAME`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB AUTO_INCREMENT=100093 DEFAULT CHARSET=utf8 COMMENT='项目表\r\n\r\n逻辑删除，正常状态的代码唯一和名称唯一';

-- ----------------------------
-- Records of pr_project
-- ----------------------------
INSERT INTO `pr_project` VALUES ('10000', 'BuiltIn_Project', '平台内置项目', '10000', '10000', '-1', '平台内置项目', '0', '2018-11-25 18:16:40', 'admin', '2018-11-25 18:16:40', 'admin');

-- ----------------------------
-- Table structure for pr_project_member
-- ----------------------------
DROP TABLE IF EXISTS `pr_project_member`;
CREATE TABLE `pr_project_member` (
  `PROJECT_ID` bigint(20) NOT NULL COMMENT '项目ID',
  `PROJECT_ROLE` int(11) NOT NULL COMMENT '项目角色\r\n0：所有者（only one）\r\n1：维护者（multiple）\r\n2：开发者（multiple）',
  `MEMBER_USER` varchar(100) NOT NULL COMMENT '项目成员用户名',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  KEY `Index_1` (`MEMBER_USER`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`PROJECT_ID`,`MEMBER_USER`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目成员表\r\n\r\n逻辑删除，正常状态的项目和用户唯一';

-- ----------------------------
-- Records of pr_project_member
-- ----------------------------
INSERT INTO `pr_project_member` VALUES ('10000', '0', 'admin', '平台内置项目所有者admin', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');

-- ----------------------------
-- Table structure for sys_parameter
-- ----------------------------
DROP TABLE IF EXISTS `sys_parameter`;
CREATE TABLE `sys_parameter` (
  `PARAM_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '参数ID',
  `PARAM_CODE` varchar(200) NOT NULL COMMENT '参数代码',
  `PARAM_NAME` varchar(200) NOT NULL COMMENT '参数名称',
  `PARAM_CLASS` int(11) NOT NULL COMMENT '参数类别，按系统模块划分\r\n\r\n1：系统业务\r\n2：项目业务\r\n3：实验业务\r\n4：数据业务\r\n5：模型业务\r\n6：工作流业务\r\n7：计算框架业务\r\n8：开放服务业务\r\n9：预测服务业务',
  `PARAM_SUB_CLASS` int(11) NOT NULL COMMENT '参数子类别（预留），按系统模块下的功能模块划分',
  `PARAM_VALUE` varchar(2000) DEFAULT NULL COMMENT '参数值',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '参数状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PARAM_ID`),
  UNIQUE KEY `Index_1` (`PARAM_CODE`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB AUTO_INCREMENT=7018 DEFAULT CHARSET=utf8 COMMENT='系统参数表\r\n\r\n逻辑删除，正常状态的代码唯一';

-- ----------------------------
-- Records of sys_parameter
-- ----------------------------
INSERT INTO `sys_parameter` VALUES ('2001', 'PR_CACHE_DATA_EXPIRE_DAYS', '项目管理 | 临时缓存数据表过期天数', '2', '-1', '21', '系统级默认过期天数配置，不做自动清理可配置为-1', '0', '2017-05-19 15:09:42', 'admin', '2017-05-19 15:09:42', 'admin');
INSERT INTO `sys_parameter` VALUES ('6001', 'WK_FLOW_MAX_NODES', '工作流引擎 | 工作流正常节点最大数量', '6', '-1', '512', '超过上限，限制新增节点', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('6002', 'WK_FLOW_SCHEMA_MAX_FIELDS', '工作流引擎 | 工作流数据表最大字段数量', '6', '-1', '1024', '超过上限，中断schema分析，以及数据文件导入报错', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7001', 'CF_HDFS_SITE_defaultFS', '计算框架 | HDFS默认文件系统', '7', '-1', 'hdfs://127.0.0.1:9000', 'namenode单点部署设为hdfs://IP:PORT，HA部署设为hdfs://CLUSTER_NAME', '0', '2017-05-19 15:09:42', 'admin', '2017-05-19 15:09:42', 'admin');
INSERT INTO `sys_parameter` VALUES ('7002', 'CF_HDFS_WORK_ROOT', '计算框架 | HDFS工作根目录', '7', '-1', '/user/lambda_mls', '根据hdfs用户名调整，完整拼接路径 e.g. ${HDFS_SITE}/user/lambda_mls', '0', '2017-05-19 15:26:23', 'admin', '2017-05-19 15:26:23', 'admin');
INSERT INTO `sys_parameter` VALUES ('7003', 'CF_LOCAL_WORK_ROOT', '计算框架 | 本地工作根目录', '7', '-1', '/opt/lambda_mls', '根据实际磁盘挂载调整', '0', '2017-05-19 15:26:23', 'admin', '2017-05-19 15:26:23', 'admin');
INSERT INTO `sys_parameter` VALUES ('7004', 'CF_JOB_FILE_DIR_NAME', '计算框架 | 作业文件存放目录名', '7', '-1', 'proc', '切勿随意调整，完整拼接路径e.g. ${WORK_ROOT}/proc', '0', '2017-05-19 15:42:06', 'admin', '2017-05-19 15:42:06', 'admin');
INSERT INTO `sys_parameter` VALUES ('7005', 'CF_DATA_FILE_DIR_NAME', '计算框架 | 数据文件存放目录名', '7', '-1', 'dw_data', '切勿随意调整，完整拼接路径e.g. ${WORK_ROOT}/dw_data', '0', '2017-05-19 15:48:43', 'admin', '2017-05-19 15:48:43', 'admin');
INSERT INTO `sys_parameter` VALUES ('7006', 'CF_MODEL_FILE_DIR_NAME', '计算框架 | 模型文件存放目录名', '7', '-1', 'mw_data', '切勿随意调整，完整拼接路径e.g. ${WORK_ROOT}/mw_data', '0', '2017-05-19 15:49:41', 'admin', '2017-05-19 15:49:41', 'admin');
INSERT INTO `sys_parameter` VALUES ('7007', 'CF_FLOW_FILE_DIR_NAME', '计算框架 | 工作流文件存放目录名', '7', '-1', 'flow_data', '切勿随意调整，完整拼接路径e.g. ${WORK_ROOT}/flow_data，目前仅本地', '0', '2017-05-19 15:46:12', 'admin', '2017-05-19 15:46:12', 'admin');
INSERT INTO `sys_parameter` VALUES ('7008', 'CF_LIB_FILE_DIR_NAME', '计算框架 | 库文件存放目录名', '7', '-1', 'lib', '切勿随意调整，完整拼接路径e.g. ${WORK_ROOT}/lib，启动时自动同步本地到hdfs上，先清理再上传', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7010', 'CF_HDFS_COMPONENT_JAR_DIR', '计算框架 | hdfs scala组件jar包目录', '7', '-1', '/user/lambda_mls/lib/spark', '根据hdfs用户名调整，完整拼接路径 e.g. ${HDFS_SITE}/user/lambda/lib/scala', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7011', 'CF_HDFS_COMPONENT_JAR_FILE', '计算框架 | hdfs scala组件jar包文件名', '7', '-1', 'lambda-component-1.0.0.jar', 'scala组件暂时只打成一个jar包，后续有需要再拆分', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7012', 'CF_SPARK_EXECUTOR_NUMBER', '计算框架 | spark executor数量', '7', '-1', '2', '灵活调整组件规格默认配置，覆盖组件特征上的默认值', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7013', 'CF_SPARK_EXECUTOR_CORES', '计算框架 | spark executor线程数量', '7', '-1', '8', '灵活调整组件规格默认配置，覆盖组件特征上的默认值', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7014', 'CF_SPARK_EXECUTOR_MEMORY', '计算框架 | spark executor内存大小', '7', '-1', '2048', '灵活调整组件规格默认配置，覆盖组件特征上的默认值', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7015', 'CF_SPARK_DRIVER_CORES', '计算框架 | spark driver线程数量', '7', '-1', '8', '灵活调整组件规格默认配置，覆盖组件特征上的默认值', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7016', 'CF_SPARK_DRIVER_MEMORY', '计算框架 | spark driver内存大小', '7', '-1', '2048', '灵活调整组件规格默认配置，覆盖组件特征上的默认值', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7017', 'CF_SPARK_EXTRA_CONFIGURATION', '计算框架 | spark 额外配置', '7', '-1', '预留', '灵活调整组件规格默认配置，覆盖组件特征上的默认值', '-1', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');

-- ----------------------------
-- Table structure for wf_cfg_algorithm
-- ----------------------------
DROP TABLE IF EXISTS `wf_cfg_algorithm`;
CREATE TABLE `wf_cfg_algorithm` (
  `ALGORITHM_ID` bigint(20) NOT NULL COMMENT '算法ID',
  `ALGORITHM_CODE` varchar(200) NOT NULL COMMENT '算法代码',
  `ALGORITHM_NAME` varchar(200) NOT NULL COMMENT '算法名称',
  `ALGORITHM_TYPE` int(11) NOT NULL COMMENT '算法类型\r\n1：One Class Classfication(Anomaly Detection)，异常检测算法\r\n2：Binary Class Classification，二分类算法\r\n3：Multiple Class Classification，多分类算法\r\n4：Clustering，聚类算法\r\n5：Regression，回归算法\r\n6：Association Rules，关联规则算法\r\n7：Collaborative filtering，协同过滤算法\r\n\r\n//更多算法类型在后续组件开发中确定',
  `ALGORITHM_LABELS` varchar(800) NOT NULL COMMENT '算法标签列表（预留），标签之间用‘|’符号分隔',
  `LEARNING_MODE` int(11) NOT NULL COMMENT '算法学习方式（预留）\r\n            1：Supervised Learning，有监督学习\r\n            2：Unsupervised Learning，无监督学习\r\n            3：Semi-Supervised Learning，半监督学习',
  `OPTIMIZE_METHOD` int(11) NOT NULL COMMENT '算法最优化方法（预留）\r\n0：unknown\r\n1：批量梯度下降法\r\n2：随机梯度下降法\r\n3：mini-batch梯度下降法\r\n4：牛顿法\r\n5：拟牛顿法\r\n6：共轭梯度法\r\n7：启发式优化方法\r\n8：拉格朗日乘数法',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`ALGORITHM_ID`),
  UNIQUE KEY `Index_1` (`ALGORITHM_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='算法表';

-- ----------------------------
-- Records of wf_cfg_algorithm
-- ----------------------------
INSERT INTO `wf_cfg_algorithm` VALUES ('2001', 'Binary Logistic Regression', '逻辑回归二分类', '2', '二分类|逻辑回归', '1', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `wf_cfg_algorithm` VALUES ('2002', 'Binary Random Forest', '随机森林二分类', '2', '二分类|随机森林', '1', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `wf_cfg_algorithm` VALUES ('2003', 'Binary Gradient Boost Decision Tree', '梯度提升树二分类', '2', '二分类|梯度提升树', '1', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `wf_cfg_algorithm` VALUES ('2004', 'Binary Linear Support Vector Machine', '线性支持向量机二分类', '2', '二分类|支持向量机', '1', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `wf_cfg_algorithm` VALUES ('3001', 'Multiple Logistic Regression', '逻辑回归多分类', '3', '多分类|逻辑回归', '1', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `wf_cfg_algorithm` VALUES ('3002', 'Multiple Random Forest', '随机森林多分类', '3', '多分类|随机森林', '1', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `wf_cfg_algorithm` VALUES ('3003', 'Multiple Naive Bayesian', '朴素贝叶斯多分类', '3', '多分类|朴素贝叶斯', '1', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `wf_cfg_algorithm` VALUES ('3004', 'K-Nearest Neighbor', 'K最近邻多分类', '3', '多分类|K最近邻', '1', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `wf_cfg_algorithm` VALUES ('4001', 'K-Means', 'K均值聚类', '4', '聚类|K均值', '2', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `wf_cfg_algorithm` VALUES ('5001', 'Linear Regression', '线性回归', '5', '回归|线性回归', '1', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `wf_cfg_algorithm` VALUES ('5002', 'Gradient Boost Decision Tree Regression', '梯度提升树回归', '5', '回归|梯度提升树', '1', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');

-- ----------------------------
-- Table structure for wf_cfg_characteristic
-- ----------------------------
DROP TABLE IF EXISTS `wf_cfg_characteristic`;
CREATE TABLE `wf_cfg_characteristic` (
  `CHAR_ID` varchar(200) NOT NULL COMMENT '特征ID',
  `CHAR_CODE` varchar(200) NOT NULL COMMENT '特征代码',
  `CHAR_NAME` varchar(200) NOT NULL COMMENT '特征名称',
  `CHAR_ALIAS` varchar(200) DEFAULT NULL COMMENT '特征别名',
  `DISPLAY_NAME` varchar(200) NOT NULL COMMENT '显示名称',
  `SPEC_TYPE` int(11) NOT NULL COMMENT '适用规格类型',
  `CHAR_TYPE` int(11) NOT NULL COMMENT '特征类型ID',
  `SRC_LEVEL` int(11) NOT NULL COMMENT '特征值来源级别\r\n1：计算组件规格\r\n2：计算组件\r\n3：工作流节点（仅限组件参数、执行调优、输入输出）\r\n\r\n注意，仅限在小于来源级别的地方做特征值设置有效，否则无效\r\n说明，特征值选用次序工作流节点 > 计算组件 > 计算组件规格 > 特征默认值',
  `IS_REQUIRED` int(11) NOT NULL COMMENT '特征值是否必须设置\r\n            0：否\r\n            1：是',
  `IS_LIMITED` int(11) NOT NULL COMMENT '特征值是否受限定\r\n0：否\r\n1：开区间方式限定，限数值和日期类型，结合最大值和最小值构成区间范围\r\n2：闭区间方式限定，限数值和日期类型，结合最大值和最小值构成区间范围\r\n3：左开右闭方式限定，限数值和日期类型，结合最大值和最小值构成区间范围\r\n4：左闭右开方式限定，限数值和日期类型，结合最大值和最小值构成区间范围\r\n5：枚举方式限定',
  `MAX_LENGTH` int(11) DEFAULT NULL COMMENT '最大长度\r\n            \r\n            字符串类型：限制字符串最大长度\r\n            JSON列表类型：限制列表最大长度\r\n            调参类型，限制自定义用户列表最大长度',
  `STEP_SIZE` varchar(2000) DEFAULT NULL COMMENT '特征值步长，限数值和日期类型，日期以天为单位，时间以秒为单位',
  `MIN_VALUE` varchar(2000) DEFAULT NULL COMMENT '最大特征值，未设置表示无穷小',
  `MAX_VALUE` varchar(2000) DEFAULT NULL COMMENT '最大特征值，未设置表示无穷大',
  `DEFAULT_VALUE` varchar(2000) DEFAULT NULL COMMENT '默认特征值',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CHAR_ID`),
  UNIQUE KEY `Index_2` (`CHAR_NAME`) USING BTREE,
  KEY `Index_1` (`CHAR_CODE`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件特征表，配置组件相关的一系列特征参数项';

-- ----------------------------
-- Records of wf_cfg_characteristic
-- ----------------------------
INSERT INTO `wf_cfg_characteristic` VALUES ('com-exec.char.engine.$001', 'engineType', '调用执行 | 计算引擎 | 引擎类型', null, '计算引擎', '2', '7', '1', '1', '5', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-exec.char.spark.0001', 'jarDir', '调用执行 | Spark | spark组件jar库目录', null, 'spark组件jar库目录', '2', '7', '2', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-exec.char.spark.0002', 'jarFile', '调用执行 | Spark | spark组件jar包文件名', null, 'spark组件jar包文件名', '2', '7', '2', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-exec.char.spark.0003', 'Class', '调用执行 | Spark | spark组件类', null, 'spark组件类', '2', '7', '2', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.dp.sample.0001.01', 't1', '输入内容 | 数据预处理 | 随机采样 | 采样输入t1', null, '采样输入t1', '0', '1000', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.dp.sample.0002.01', 't1', '输入内容 | 数据预处理 | 加权采样 | 采样输入t1', null, '采样输入t1', '0', '1000', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.dp.sample.0003.01', 't1', '输入内容 | 数据预处理 | 均衡采样 | 采样输入t1', null, '采样输入t1', '0', '1000', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.dp.sample.0004.01', 't1', '输入内容 | 数据预处理 | 分层采样 | 采样输入t1', null, '采样输入t1', '0', '1000', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.dp.split.0001.01', 't1', '输入内容 | 数据预处理 | 数据拆分 | 拆分输入t1', null, '拆分输入t1', '0', '1000', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.dp.transform.0001.01', 't1', '输入内容 | 数据预处理 | 类型转换 | 转换输入t1', null, '转换输入t1', '0', '1000', '3', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.io.write.0001.01', 't1', '输入内容 | 输入输出 | 数据表写入 | 输入数据表t1', null, '输入数据表t1', '0', '1000', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.ml.cross-validate.0001.01', 'a1', '输入内容 | 机器学习 | 模型交叉验证 | 未训练模型a1', null, '未训练模型a1', '0', '4007', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.ml.cross-validate.0001.02', 't1', '输入内容 | 机器学习 | 模型交叉验证 | 样本数据集t1', null, '样本数据集t1', '0', '1000', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.ml.evaluate.0001.01', 't1', '输入内容 | 机器学习 | 模型评估 - 二分类 | 预测结果集t1', null, '预测结果集t1', '0', '1000', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.ml.evaluate.0002.01', 't1', '输入内容 | 机器学习 | 模型评估 - 多分类 | 预测结果集t1', null, '预测结果集t1', '0', '1000', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.ml.evaluate.0003.01', 'm1', '输入内容 | 机器学习 | 模型评估 - 聚类 | 已训练聚类模型m1', null, '已训练聚类模型m1', '0', '2005', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.ml.evaluate.0003.02', 't1', '输入内容 | 机器学习 | 模型评估 - 聚类 | 评估数据集t1', null, '评估数据集t1', '0', '1000', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.ml.evaluate.0004.01', 't1', '输入内容 | 机器学习 | 模型评估 - 回归 | 预测结果集t1', null, '预测结果集t1', '0', '1000', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.ml.predict.0001.01', 'm1', '输入内容 | 机器学习 | 模型预测 | 已训练模型m1', null, '已训练模型m1', '0', '2008', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.ml.predict.0001.02', 't1', '输入内容 | 机器学习 | 模型预测 | 预测数据集t1', null, '预测数据集t1', '0', '1000', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.ml.train.0001.01', 'a1', '输入内容 | 机器学习 | 模型训练 | 未训练模型a1', null, '未训练模型a1', '0', '4007', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.ml.train.0001.02', 't1', '输入内容 | 机器学习 | 模型训练 | 训练数据集t1', null, '训练数据集t1', '0', '1000', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.ml.tune.0001.01', 'a1', '输入内容 | 机器学习 | 模型自动调参 | 未训练模型a1', null, '未训练模型a1', '0', '4007', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.ml.tune.0001.02', 't1', '输入内容 | 机器学习 | 模型自动调参 | 训练数据集t1', null, '训练数据集t1', '0', '1000', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.ml.tune.0001.03', 't2', '输入内容 | 机器学习 | 模型自动调参 | 验证数据集t2', null, '验证数据集t2', '0', '1000', '3', '0', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.st.sql.0001.01', 't1', '输入内容 | 脚本工具 | SQL脚本 | 数据表t1', null, 'SQL脚本输入t1', '0', '1000', '3', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.st.sql.0001.02', 't2', '输入内容 | 脚本工具 | SQL脚本 | 数据表t2', null, 'SQL脚本输入t2', '0', '1000', '3', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.st.sql.0001.03', 't3', '输入内容 | 脚本工具 | SQL脚本 | 数据表t3', null, 'SQL脚本输入t3', '0', '1000', '3', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-input.char.st.sql.0001.04', 't4', '输入内容 | 脚本工具 | SQL脚本 | 数据表t4', null, 'SQL脚本输入t4', '0', '1000', '3', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-o-exec.char.spark.0001', 'spark.executor.number', '执行调优 | Spark | spark.executor.number', null, 'spark.executor.number', '3', '4', '3', '0', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-o-exec.char.spark.0002', 'spark.executor.cores', '执行调优 | Spark | spark.executor.cores', null, 'spark.executor.cores', '3', '4', '3', '0', '0', null, '1', '1', '128', '8', null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-o-exec.char.spark.0003', 'spark.executor.memory', '执行调优 | Spark | spark.executor.memory', null, 'spark.executor.memory', '3', '4', '3', '0', '0', null, '1', '512', '65536', '2048', '内存单位MB，最多64GB', '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-o-exec.char.spark.0004', 'spark.driver.cores', '执行调优 | Spark | spark.driver.cores', null, 'spark.driver.cores', '3', '4', '3', '0', '0', null, '1', '1', '256', '8', null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-o-exec.char.spark.0005', 'spark.driver.memory', '执行调优 | Spark | spark.driver.memory', null, 'spark.driver.memory', '3', '4', '3', '0', '0', null, '1', '512', '65536', '1024', '内存单位MB，最多64GB', '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-o-exec.char.spark.0006', 'spark.extra.configuration', '执行调优 | Spark | spark.extra.configuration（待定）', null, 'spark.extra.configuration', '3', '7', '3', '0', '0', null, null, null, null, null, null, '-1', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.dp.sample.0001.01', 't1', '输出内容 | 数据预处理 | 随机采样 | 采样输出t1', null, '采样输出t1', '1', '1001', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.dp.sample.0002.01', 't1', '输出内容 | 数据预处理 | 加权采样 | 采样输出t1', null, '采样输出t1', '1', '1001', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.dp.sample.0003.01', 't1', '输出内容 | 数据预处理 | 均衡采样 | 采样输出t1', null, '采样输出t1', '1', '1001', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.dp.sample.0004.01', 't1', '输出内容 | 数据预处理 | 分层采样 | 采样输出t1', null, '采样输出t1', '1', '1001', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.dp.split.0001.01', 't1', '输出内容 | 数据预处理 | 数据拆分 | 拆分输出t1', null, '拆分输出t1', '1', '1001', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.dp.split.0001.02', 't2', '输出内容 | 数据预处理 | 数据拆分 | 拆分输出t2', null, '拆分输出t2', '1', '1001', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.dp.transform.0001.01', 't1', '输出内容 | 数据预处理 | 类型转换 | 转换输出t1', null, '转换输出t1', '1', '1001', '3', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.io.import.0001.01', 't1', '输出内容 | 输入输出 | 数据文件导入 | 目标数据表t1', null, '目标数据表t1', '1', '1001', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.io.read.0001.01', 't1', '输出内容 | 输入输出 | 数据表读取 | 输出数据表t1', null, '输出数据表t1', '1', '1001', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.io.read.0002.01', 'm1', '输出内容 | 输入输出 | 模型读取 | 输出模型m1', null, '输出模型m1', '1', '2008', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.ml.algorithm.0001.01', 'a1', '输出内容 | 机器学习 | 算法 - 逻辑回归二分类 |  输出二分类算法a1', null, '输出二分类算法a1', '1', '4002', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.ml.algorithm.0002.01', 'a1', '输出内容 | 机器学习 | 算法 - 随机森林二分类 |  输出二分类算法a1', null, '输出二分类算法a1', '1', '4002', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.ml.algorithm.0003.01', 'a1', '输出内容 | 机器学习 | 算法 - GBDT二分类 |  输出二分类算法a1', null, '输出二分类算法a1', '1', '4002', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.ml.algorithm.0004.01', 'a1', '输出内容 | 机器学习 | 算法 - 线性SVM二分类 |  输出二分类算法a1', null, '输出二分类算法a1', '1', '4002', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.ml.algorithm.0005.01', 'a1', '输出内容 | 机器学习 | 算法 - 线性回归 |  输出回归算法a1', null, '输出回归算法a1', '1', '4006', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.ml.algorithm.0006.01', 'a1', '输出内容 | 机器学习 | 算法 - GBDT回归 |  输出回归算法a1', null, '输出回归算法a1', '1', '4006', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.ml.cross-validate.0001.01', 'r1', '输出内容 | 机器学习 | 模型交叉验证 | 交叉验证报告r1', null, '交叉验证报告r1', '1', '5003', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.ml.evaluate.0001.01', 'r1', '输出内容 | 机器学习 | 模型评估 - 二分类 | 评估报告r1', null, '评估报告r1', '1', '5001', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.ml.evaluate.0002.01', 'r1', '输出内容 | 机器学习 | 模型评估 - 多分类 | 评估报告r1', null, '评估报告r1', '1', '5001', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.ml.evaluate.0003.01', 'r1', '输出内容 | 机器学习 | 模型评估 - 聚类 | 评估报告r1', null, '评估报告r1', '1', '5001', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.ml.evaluate.0004.01', 'r1', '输出内容 | 机器学习 | 模型评估 - 回归 | 评估报告r1', null, '评估报告r1', '1', '5001', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.ml.predict.0001.01', 't1', '输出内容 | 机器学习 | 模型预测 | 预测结果集t1', null, '预测结果集t1', '1', '1001', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.ml.train.0001.01', 'm1', '输出内容 | 机器学习 | 模型训练 | 已训练模型m1', null, '已训练模型m1', '1', '2007', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.ml.tune.0001.01', 'm1', '输出内容 | 机器学习 | 模型自动调参 | 最优模型m1', null, '最优模型m1', '1', '2007', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.ml.tune.0001.02', 'r1', '输出内容 | 机器学习 | 模型自动调参 | 调参报告r1', null, '调参报告r1', '1', '5004', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-output.char.st.sql.0001.01', 't1', '输出内容 | 脚本工具 | SQL脚本 | 数据表t1', null, 'SQL脚本输出t1', '1', '1001', '3', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.$001', 'sampleMode', '组件参数 | 数据预处理 | 采样 | 采样方式', null, '采样方式', '4', '7', '3', '1', '5', null, null, null, null, 'Ratio', null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0001.01', 'sampleSize', '组件参数 | 数据预处理 | 随机采样 | 采样个数', null, '采样个数', '4', '4', '3', '0', '1', null, null, '0', null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0001.02', 'sampleRate', '组件参数 | 数据预处理 | 随机采样 | 采样比例', null, '采样比例', '4', '6', '3', '0', '1', null, null, '0.0', '1.0', '0.8', null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0001.03', 'isWithReplacement', '组件参数 | 数据预处理 | 随机采样 | 是否放回采样', null, '是否放回采样', '4', '1', '3', '0', '0', null, null, null, null, 'false', null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0001.04', 'randomSeed', '组件参数 | 数据预处理 | 随机采样 | 随机数种子', null, '随机数种子', '4', '4', '3', '0', '2', null, null, '0', null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0002.01', 'sampleSize', '组件参数 | 数据预处理 | 加权采样 | 采样个数', null, '采样个数', '4', '4', '3', '0', '1', null, null, '0', null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0002.02', 'sampleRate', '组件参数 | 数据预处理 | 加权采样 | 采样比例', null, '采样比例', '4', '6', '3', '0', '1', null, null, '0.0', '1.0', '0.8', null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0002.03', 'isWithReplacement', '组件参数 | 数据预处理 | 加权采样 | 是否放回采样', null, '是否放回采样', '4', '1', '3', '0', '0', null, null, null, null, 'false', null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0002.04', 'randomSeed', '组件参数 | 数据预处理 | 加权采样 | 随机数种子', null, '随机数种子', '4', '4', '3', '0', '2', null, null, '0', null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0002.05', 'weightColumnName', '组件参数 | 数据预处理 | 加权采样 | 权重列名', null, '权重列名', '4', '7', '3', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0003.01', 'sampleSize', '组件参数 | 数据预处理 | 均衡采样 | 采样个数', null, '采样个数', '4', '4', '3', '0', '1', null, null, '0', null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0003.02', 'sampleRate', '组件参数 | 数据预处理 | 均衡采样 | 采样比例', null, '采样比例', '4', '6', '3', '0', '1', null, null, '0.0', '1.0', '0.8', null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0003.03', 'targetColumnName', '组件参数 | 数据预处理 | 均衡采样 | 目标列名', null, '目标列名', '4', '7', '3', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0003.04', 'randomSeed', '组件参数 | 数据预处理 | 均衡采样 | 随机数种子', null, '随机数种子', '4', '4', '3', '0', '2', null, '1', '0', null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0004.01', 'sampleSize', '组件参数 | 数据预处理 | 分层采样 | 采样个数', null, '采样个数', '4', '4', '3', '0', '1', null, null, '0', null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0004.02', 'sampleRate', '组件参数 | 数据预处理 | 分层采样 | 采样比例', null, '采样比例', '4', '6', '3', '0', '1', null, null, '0.0', '1.0', '0.8', null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0004.03', 'isWithReplacement', '组件参数 | 数据预处理 | 分层采样 | 是否放回采样', null, '是否放回采样', '4', '1', '3', '0', '0', null, null, null, null, 'false', null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0004.04', 'groupColumnName', '组件参数 | 数据预处理 | 分层采样 | 分组列名', null, '分组列名', '4', '7', '3', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.sample.0004.05', 'randomSeed', '组件参数 | 数据预处理 | 分层采样 | 随机数种子', null, '随机数种子', '4', '4', '3', '0', '2', null, '1', '0', null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.split.0001.01', 'splitMode', '组件参数 | 数据预处理 | 数据拆分 | 拆分方式', null, '拆分方式', '4', '7', '3', '1', '5', null, null, null, null, 'Ratio', null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.split.0001.02', 'splitRate', '组件参数 | 数据预处理 | 数据拆分 | 拆分比例', null, '拆分比例', '4', '6', '3', '0', '1', null, null, '0.0', '1.0', '0.8', null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.split.0001.03', 'splitThreshold', '组件参数 | 数据预处理 | 数据拆分 | 拆分阈值', null, '拆分阈值', '4', '6', '3', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.split.0001.04', 'thresholdColumnName', '组件参数 | 数据预处理 | 数据拆分 | 阈值列名', null, '阈值列名', '4', '7', '3', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.split.0001.05', 'randomSeed', '组件参数 | 数据预处理 | 数据拆分 | 随机数种子', null, '随机数种子', '4', '4', '3', '0', '2', null, '1', '0', null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.transform.0001.01', 'defaultDoubleValue', '组件参数 | 数据预处理 | 类型转换 | 默认double填充值', null, '默认double填充值', '4', '6', '3', '1', '0', null, null, null, null, '0.0', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.transform.0001.02', 'defaultLongValue', '组件参数 | 数据预处理 | 类型转换 | 默认long填充值', null, '默认long填充值', '4', '4', '3', '1', '0', null, null, null, null, '0', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.transform.0001.03', 'defaultStringValue', '组件参数 | 数据预处理 | 类型转换 | 默认string填充值', null, '默认string填充值', '4', '7', '3', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.transform.0001.04', 'toDoubleColumnNames', '组件参数 | 数据预处理 | 类型转换 | 转换为double类型列', null, '转换为double类型列', '4', '9001', '3', '0', '0', '255', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.transform.0001.05', 'toLongColumnNames', '组件参数 | 数据预处理 | 类型转换 | 转换为long类型列', null, '转换为long类型列', '4', '9001', '3', '0', '0', '255', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.transform.0001.06', 'toStringColumnNames', '组件参数 | 数据预处理 | 类型转换 | 转换为string类型列', null, '转换为string类型列', '4', '9001', '3', '0', '0', '255', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.dp.transform.0001.07', 'isReserveOriginalColumns', '组件参数 | 数据预处理 | 类型转换 | 是否保留原始列', null, '是否保留原始列', '4', '1', '3', '0', '0', null, null, null, null, 'false', null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.io.import.0001.01', 'fileType', '组件参数 | 输入输出 | 数据文件导入 | 文件类型', null, '文件类型', '4', '7', '3', '1', '5', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.io.import.0001.02', 'filePath', '组件参数 | 输入输出 | 数据文件导入 | 文件路径', null, '文件路径', '4', '7', '3', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.io.import.0001.03', 'columnDelimiter', '组件参数 | 输入输出 | 数据文件导入 | 列分隔符', null, '列分隔符', '4', '7', '3', '0', '0', null, null, null, null, '0x2C', '列分隔符，内容填写相应符号的ASCII码十六进制值，例如CSV默认为逗号（0x2C），TSV默认为制表符（0x09），TXT默认为空格（0x20）', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.io.import.0001.04', 'lineDelimiter', '组件参数 | 输入输出 | 数据文件导入 | 行分隔符', null, '行分隔符', '4', '7', '3', '0', '0', null, null, null, null, '0x0A', '行分隔符，内容填写相应符号的ASCII码十六进制值，例如Window默认为回车符换行符（0x0D0x0A），MacOS默认为回车符（0xD），Unix/Linux默认为换行符（0x0A）', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.io.import.0001.05', 'characterEncoding', '组件参数 | 输入输出 | 数据文件导入 | 字符编码', null, '字符编码', '4', '7', '3', '1', '5', null, null, null, null, 'UTF-8', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.io.import.0001.06', 'existsHeader', '组件参数 | 输入输出 | 数据文件导入 | 首行是否为字段标题', null, '首行是否为字段标题', '4', '1', '3', '0', '0', null, null, null, null, 'false', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.io.import.0001.07', 'schema', '组件参数 | 输入输出 | 数据文件导入 | 字段描述列表', null, '字段描述列表', '4', '9001', '3', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.io.import.0001.08', 'typeException', '组件参数 | 输入输出 | 数据文件导入 | 字段类型异常处理', null, '字段类型异常处理', '4', '7', '3', '0', '5', null, null, null, null, 'Missing Value', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.io.import.0001.09', 'columnsException', '组件参数 | 输入输出 | 数据文件导入 | 列数异常处理', null, '列数异常处理', '4', '7', '3', '0', '5', null, null, null, null, 'Discard Row', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.io.import.0001.10', 'tableName', '组件参数 | 输入输出 | 数据文件导入 | 数据表名', null, '数据表名', '4', '7', '3', '1', '0', '200', null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.io.read.0001.01', 'tableName', '组件参数 | 输入输出 | 数据表读取 | 数据表名', null, '数据表名', '4', '7', '3', '1', '0', '200', null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.io.read.0002.01', 'modelId', '组件参数 | 输入输出 | 模型读取 | 模型ID', null, '模型ID', '4', '4', '3', '1', '0', null, null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.io.write.0001.01', 'tableName', '组件参数 | 输入输出 | 数据表写入 | 数据表名', null, '数据表名', '4', '7', '3', '1', '0', '200', null, null, null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.$0000#', 'centerNumber', '组件参数 | 机器学习 | K-Means | 聚类数', null, '聚类数', '4', '4', '3', '1', '2', null, '1', '1', '1000', '10', null, '-1', '2017-05-17 21:00:00', 'admin', '2017-05-17 21:00:00', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.$0001#', 'distanceMeasureType', '组件参数 | 机器学习 | K-Means | 距离度量方式', null, '距离度量方式', '4', '7', '3', '1', '5', null, null, null, null, 'Euclidean', null, '-1', '2017-05-17 21:02:55', 'admin', '2017-05-17 21:02:55', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.$0002#', 'centerInitMethod', '组件参数 | 机器学习 | K-Means | 质心初始化方法', null, '质心初始化方法', '4', '7', '3', '1', '5', null, null, null, null, 'Random', null, '-1', '2017-05-17 21:11:06', 'admin', '2017-05-17 21:11:06', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.$001', 'regularizedType', '组件参数 | 机器学习 | 正则项', null, '正则项', '4', '7', '3', '1', '5', null, null, null, null, 'None', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0001.01', 'maxIterNum', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类 | 最大迭代次数', null, '最大迭代次数', '4', '104', '3', '1', '2', '10', '1', '1', '10000', '{\r\n	\"value\": 100,\r\n	\"tune_range\": {\r\n		\"start\": 100,\r\n		\"end\": 1000\r\n	},\r\n	\"tune_udps\": [50, 100, 200, 1000]\r\n}', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0001.02', 'epsilon', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类 | 最小收敛误差', null, '最小收敛误差', '4', '106', '3', '1', '1', '10', '0.01', '0', '0.1', '{\n	\"value\": \"0.0000001\",\n	\"tune_range\": {\n		\"start\": \"0.00000001\",\n		\"end\": \"0.001\"\n	},\n	\"tune_udps\": [\"0.0001\", \"0.0000001\"]\n}', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0001.03', 'regularizedL1Coef', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类 | 正则L1系数', null, '正则L1系数', '4', '106', '3', '1', '2', '10', '0.1', '0', '1', '{\r\n	\"value\": \"1.0\",\r\n	\"tune_range\": {\r\n		\"start\": \"0.1\",\r\n		\"end\": \"0.9\"\r\n	},\r\n	\"tune_udps\": [\"0.0\", \"0.01\", \"0.1\", \"1.0\"]\r\n}', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0001.04', 'regularizedL2Coef', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类 | 正则L2系数', null, '正则L2系数', '4', '106', '3', '1', '2', '10', '0.1', '0', '1', '{\r\n	\"value\": \"1.0\",\r\n	\"tune_range\": {\r\n		\"start\": \"0.1\",\r\n		\"end\": \"0.9\"\r\n	},\r\n	\"tune_udps\": [\"0.01\", \"0.1\", \"1.0\"]\r\n}', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0001.05', 'positiveValue', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类 | 正样本标签值', null, '正样本标签值', '4', '7', '3', '1', '0', null, null, null, null, '1', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0002.01', 'treeNum', '组件参数 | 机器学习 | 算法 - 随机森林二分类 | 森林中树的个数', null, '森林中树的个数', '4', '104', '3', '1', '2', '10', null, '1', '1000', '{\r\n	\"value\": 100,\r\n	\"tune_range\": {\r\n		\"start\": 20,\r\n		\"end\": 100\r\n	},\r\n	\"tune_udps\": [32, 64, 128]\r\n}', null, '0', '2017-05-17 18:00:30', 'admin', '2017-05-17 18:00:30', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0002.02', 'randomFeatureNum', '组件参数 | 机器学习 | 算法 - 随机森林二分类 | 单颗树的随机特征数', null, '单颗树的随机特征数', '4', '7', '3', '0', '0', null, null, null, null, null, '可填写sqrt，onethird，log2，(0, 1]，(1, N]，分类默认sqrt，回归默认onethird', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0002.03', 'minInstancePerNode', '组件参数 | 机器学习 | 算法 - 随机森林二分类 | 叶节点最少记录数', null, '叶节点最少记录数', '4', '104', '3', '0', '2', '10', '1', '2', '100', '{\r\n	\"value\": 2,\r\n	\"tune_range\": {\r\n		\"start\": 2,\r\n		\"end\": 100\r\n	},\r\n	\"tune_udps\": [2, 4, 16]\r\n}', null, '0', '2017-05-17 19:28:46', 'admin', '2017-05-17 19:28:46', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0002.04', 'maxTreeDepth', '组件参数 | 机器学习 | 算法 - 随机森林二分类 | 单颗树的最大深度', null, '单颗树的最大深度', '4', '104', '3', '0', '2', '10', null, '1', null, '{\r\n	\"value\": 32,\r\n	\"tune_range\": {\r\n		\"start\": 1,\r\n		\"end\": 1000\r\n	},\r\n	\"tune_udps\": [4, 16, 64]\r\n}', null, '0', '2017-05-17 19:45:05', 'admin', '2017-05-17 19:45:05', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0002.05', 'subsamplingRate', '组件参数 | 机器学习 | 算法 - 随机森林二分类 | 单颗树的采样率', null, '单颗树的采样率', '4', '106', '3', '0', '3', '10', '0.1', '0', '1', '{\r\n	\"value\": \"1.0\",\r\n	\"tune_range\": {\r\n		\"start\": \"0.6\",\r\n		\"end\": \"1.0\"\r\n	},\r\n	\"tune_udps\": [\"0.7\", \"0.8\", \"1.0\"]\r\n}', null, '0', '2017-05-17 19:45:05', 'admin', '2017-05-17 19:45:05', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0002.06', 'positiveValue', '组件参数 | 机器学习 | 算法 - 随机森林二分类 | 正样本标签值', null, '正样本标签值', '4', '7', '3', '1', '0', null, null, null, null, '1', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0003.01', 'maxIterNum', '组件参数 | 机器学习 | 算法 - GBDT二分类 | 最大迭代次数', null, '最大迭代次数', '4', '104', '3', '1', '2', '10', null, '1', '1000', '{\r\n	\"value\": 100,\r\n	\"tune_range\": {\r\n		\"start\": 100,\r\n		\"end\": 1000\r\n	},\r\n	\"tune_udps\": [50, 100, 200]\r\n}', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0003.02', 'shrinkage', '组件参数 | 机器学习 | 算法 - GBDT二分类 | 学习速率', null, '学习速率', '4', '106', '3', '1', '1', '10', '0.1', '0', '1', '{\r\n	\"value\": \"0.1\",\r\n	\"tune_range\": {\r\n		\"start\": \"0.01\",\r\n		\"end\": \"0.9\"\r\n	},\r\n	\"tune_udps\": [\"0.025\", \"0.05\", \"0.1\", \"0.2\", \"0.4\"]\r\n}', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0003.03', 'minInstancePerNode', '组件参数 | 机器学习 | 算法 - GBDT二分类 | 叶节点最少记录数', null, '叶节点最少记录数', '4', '104', '3', '0', '2', '10', '1', '2', '100', '{\r\n	\"value\": 2,\r\n	\"tune_range\": {\r\n		\"start\": 2,\r\n		\"end\": 100\r\n	},\r\n	\"tune_udps\": [2, 4, 16]\r\n}', null, '0', '2017-05-17 19:28:46', 'admin', '2017-05-17 19:28:46', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0003.04', 'maxTreeDepth', '组件参数 | 机器学习 | 算法 - GBDT二分类 | 单颗树的最大深度', null, '单颗树的最大深度', '4', '104', '3', '0', '2', '10', null, '1', null, '{\r\n	\"value\": 32,\r\n	\"tune_range\": {\r\n		\"start\": 1,\r\n		\"end\": 1000\r\n	},\r\n	\"tune_udps\": [4, 16, 64]\r\n}', null, '0', '2017-05-17 19:45:05', 'admin', '2017-05-17 19:45:05', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0003.05', 'subsamplingRate', '组件参数 | 机器学习 | 算法 - GBDT二分类 | 单颗树的采样率', null, '单颗树的采样率', '4', '106', '3', '0', '3', '10', '0.1', '0', '1', '{\r\n	\"value\": \"1.0\",\r\n	\"tune_range\": {\r\n		\"start\": \"0.6\",\r\n		\"end\": \"1.0\"\r\n	},\r\n	\"tune_udps\": [\"0.7\", \"0.8\", \"1.0\"]\r\n}', null, '0', '2017-05-17 19:45:05', 'admin', '2017-05-17 19:45:05', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0003.06', 'positiveValue', '组件参数 | 机器学习 | 算法 - GBDT二分类 | 正样本标签值', null, '正样本标签值', '4', '7', '3', '1', '0', null, null, null, null, '1', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0005.01', 'maxIterNum', '组件参数 | 机器学习 | 算法 - 线性回归 | 最大迭代次数', null, '最大迭代次数', '4', '104', '3', '1', '2', '10', '1', '1', '10000', '{\r\n	\"value\": 100,\r\n	\"tune_range\": {\r\n		\"start\": 100,\r\n		\"end\": 1000\r\n	},\r\n	\"tune_udps\": [50, 100, 200, 1000]\r\n}', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0005.02', 'epsilon', '组件参数 | 机器学习 | 算法 - 线性回归 | 最小收敛误差', null, '最小收敛误差', '4', '106', '3', '1', '1', '10', '0.01', '0', '0.1', '{\n	\"value\": \"0.0000001\",\n	\"tune_range\": {\n		\"start\": \"0.00000001\",\n		\"end\": \"0.001\"\n	},\n	\"tune_udps\": [\"0.0001\", \"0.0000001\"]\n}', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0005.03', 'regularizedL1Coef', '组件参数 | 机器学习 | 算法 - 线性回归 | 正则L1系数', null, '正则L1系数', '4', '106', '3', '1', '2', '10', '0.1', '0', '1', '{\r\n	\"value\": \"1.0\",\r\n	\"tune_range\": {\r\n		\"start\": \"0.1\",\r\n		\"end\": \"0.9\"\r\n	},\r\n	\"tune_udps\": [\"0.0\", \"0.01\", \"0.1\", \"1.0\"]\r\n}', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0005.04', 'regularizedL2Coef', '组件参数 | 机器学习 | 算法 - 线性回归 | 正则L2系数', null, '正则L2系数', '4', '106', '3', '1', '2', '10', '0.1', '0', '1', '{\r\n	\"value\": \"1.0\",\r\n	\"tune_range\": {\r\n		\"start\": \"0.1\",\r\n		\"end\": \"0.9\"\r\n	},\r\n	\"tune_udps\": [\"0.01\", \"0.1\", \"1.0\"]\r\n}', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0006.01', 'lossType', '组件参数 | 机器学习 | 算法 - GBDT回归 | 损失函数类型', null, '损失函数类型', '4', '7', '3', '1', '5', null, null, null, null, 'Squared Loss', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0006.02', 'maxIterNum', '组件参数 | 机器学习 | 算法 - GBDT回归 | 最大迭代次数', null, '最大迭代次数', '4', '104', '3', '1', '2', '10', null, '1', '1000', '{\r\n	\"value\": 100,\r\n	\"tune_range\": {\r\n		\"start\": 100,\r\n		\"end\": 1000\r\n	},\r\n	\"tune_udps\": [50, 100, 200]\r\n}', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0006.03', 'shrinkage', '组件参数 | 机器学习 | 算法 - GBDT回归 | 学习速率', null, '学习速率', '4', '106', '3', '1', '1', '10', '0.1', '0', '1', '{\r\n	\"value\": \"0.1\",\r\n	\"tune_range\": {\r\n		\"start\": \"0.01\",\r\n		\"end\": \"0.9\"\r\n	},\r\n	\"tune_udps\": [\"0.025\", \"0.05\", \"0.1\", \"0.2\", \"0.4\"]\r\n}', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0006.04', 'minInstancePerNode', '组件参数 | 机器学习 | 算法 - GBDT回归 | 叶节点最少记录数', null, '叶节点最少记录数', '4', '104', '3', '0', '2', '10', '1', '2', '100', '{\r\n	\"value\": 2,\r\n	\"tune_range\": {\r\n		\"start\": 2,\r\n		\"end\": 100\r\n	},\r\n	\"tune_udps\": [2, 4, 16]\r\n}', null, '0', '2017-05-17 19:28:46', 'admin', '2017-05-17 19:28:46', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0006.05', 'maxTreeDepth', '组件参数 | 机器学习 | 算法 - GBDT回归 | 单颗树的最大深度', null, '单颗树的最大深度', '4', '104', '3', '0', '2', '10', null, '1', null, '{\r\n	\"value\": 32,\r\n	\"tune_range\": {\r\n		\"start\": 1,\r\n		\"end\": 1000\r\n	},\r\n	\"tune_udps\": [4, 16, 64]\r\n}', null, '0', '2017-05-17 19:45:05', 'admin', '2017-05-17 19:45:05', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.algorithm.0006.06', 'subsamplingRate', '组件参数 | 机器学习 | 算法 - GBDT回归 | 单颗树的采样率', null, '单颗树的采样率', '4', '106', '3', '0', '3', '10', '0.1', '0', '1', '{\r\n	\"value\": \"1.0\",\r\n	\"tune_range\": {\r\n		\"start\": \"0.6\",\r\n		\"end\": \"1.0\"\r\n	},\r\n	\"tune_udps\": [\"0.7\", \"0.8\", \"1.0\"]\r\n}', null, '0', '2017-05-17 19:45:05', 'admin', '2017-05-17 19:45:05', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.evaluate.0001.01', 'labelColumnName', '组件参数 | 机器学习 | 模型评估 - 二分类 | 原始标签列名', null, '原始标签列名', '4', '7', '3', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.evaluate.0001.02', 'positiveValue', '组件参数 | 机器学习 | 模型评估 - 二分类 | 正样本标签值', null, '正样本标签值', '4', '7', '3', '1', '0', null, null, null, null, '1', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.evaluate.0001.03', 'scoreColumnName', '组件参数 | 机器学习 | 模型评估 - 二分类 | 预测分数列名', null, '预测分数列名', '4', '7', '3', '1', '0', null, null, null, null, 'prediction_score', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.evaluate.0001.04', 'binCount', '组件参数 | 机器学习 | 模型评估 - 二分类 | 分段统计分箱数量', null, '分段统计分箱数量', '4', '4', '3', '1', '2', null, null, '2', '1000', '10', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.evaluate.0002.01', 'labelColumnName', '组件参数 | 机器学习 | 模型评估 - 多分类 | 标签列名', null, '标签列名', '4', '7', '3', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.evaluate.0002.02', 'resultColumnName', '组件参数 | 机器学习 | 模型评估 - 多分类 | 预测结果列名', null, '预测结果列名', '4', '7', '3', '1', '0', null, null, null, null, 'prediction_result', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.evaluate.0002.03', 'detailColumnName', '组件参数 | 机器学习 | 模型评估 - 多分类 | 预测详情列名', null, '预测详情列名', '4', '7', '3', '1', '0', null, null, null, null, 'prediction_detail', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.evaluate.0004.01', 'yColumnName', '组件参数 | 机器学习 | 模型评估 - 回归 | 原回归值列名', null, '原回归值列名', '4', '7', '3', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.evaluate.0004.02', 'scoreColumnName', '组件参数 | 机器学习 | 模型评估 - 回归 | 预测分数列名', null, '预测分数列名', '4', '7', '3', '1', '0', null, null, null, null, 'prediction_score', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.predict.0001.01', 'appendColumnNames', '组件参数 | 机器学习 | 模型预测 | 原样输出列', null, '原样输出列', '4', '9001', '3', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.predict.0001.02', 'resultColumnName', '组件参数 | 机器学习 | 模型预测 | 预测结果列名', null, '预测结果列名', '4', '7', '3', '1', '0', null, null, null, null, 'prediction_result', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.predict.0001.03', 'scoreColumnName', '组件参数 | 机器学习 | 模型预测 | 预测分数列名', null, '预测分数列名', '4', '7', '3', '1', '0', null, null, null, null, 'prediction_score', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.predict.0001.04', 'detailColumnName', '组件参数 | 机器学习 | 模型预测 | 预测详情列名', null, '预测详情列名', '4', '7', '3', '1', '0', null, null, null, null, 'prediction_detail', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.train.0001.01', 'featureColumnNames', '组件参数 | 机器学习 | 模型训练 | 选择特征列', null, '选择特征列', '4', '9001', '3', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.train.0001.02', 'excludedColumnNames', '组件参数 | 机器学习 | 模型训练 | 排除特征列', null, '排除特征列', '4', '9001', '3', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.train.0001.03', 'forceDiscreteColumnNames', '组件参数 | 机器学习 | 模型训练 | 强制转换列', null, '强制转换列', '4', '9001', '3', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.train.0001.04', 'weightColumnName', '组件参数 | 机器学习 | 模型训练 | 权重列名', null, '权重列名', '4', '7', '3', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.train.0001.05', 'labelColumnName', '组件参数 | 机器学习 | 模型训练 | 标签列名', null, '标签列名', '4', '7', '3', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.train.0001.06', 'randomSeed', '组件参数 | 机器学习 | 模型训练 | 随机数种子', null, '随机数种子', '4', '4', '3', '0', '2', null, '1', '0', null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.tune.$001', 'tuneType', '组件参数 | 机器学习 | 调参 | 调参类型', null, '调参类型', '4', '7', '3', '1', '5', null, null, null, null, 'Customize Parameter', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.tune.$002', 'iterNum', '组件参数 | 机器学习 | 调参 | 迭代次数', null, '迭代次数', '4', '4', '3', '1', '2', null, '1', '2', '100', '10', '随机搜索用', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.tune.$003', 'splitNum', '组件参数 | 机器学习 | 调参 | 网格拆分数', null, '网格拆分数', '4', '4', '3', '1', '2', null, '1', '2', '10', '2', '网格搜索用', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.tune.$004', 'searchSize', '组件参数 | 机器学习 | 调参 | 搜索样本数', null, '搜索样本数', '4', '4', '3', '1', '2', null, '1', '2', '100', '10', '启发式搜索用', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.tune.$005', 'searchTimes', '组件参数 | 机器学习 | 调参 | 搜索次数', null, '搜索次数', '4', '4', '3', '1', '2', null, '1', '2', '10', '2', '启发式搜索用', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.tune.$006', 'searchCoef', '组件参数 | 机器学习 | 调参 | 收敛系数', null, '收敛系数', '4', '6', '3', '1', '2', null, '0.1', '0.1', '1', '0.1', '启发式搜索用', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.tune.0001.01', 'featureColumnNames', '组件参数 | 机器学习 | 模型自动调参 | 选择特征列', null, '选择特征列', '4', '9001', '3', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.tune.0001.02', 'excludedColumnNames', '组件参数 | 机器学习 | 模型自动调参 | 排除特征列', null, '排除特征列', '4', '9001', '3', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.tune.0001.03', 'forceDiscreteColumnNames', '组件参数 | 机器学习 | 模型自动调参 | 强制转换列', null, '强制转换列', '4', '9001', '3', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.tune.0001.04', 'weightColumnName', '组件参数 | 机器学习 | 模型自动调参 | 权重列名', null, '权重列名', '4', '7', '3', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.tune.0001.05', 'labelColumnName', '组件参数 | 机器学习 | 模型自动调参 | 标签列名', null, '标签列名', '4', '7', '3', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.tune.0001.06', 'splitRate', '组件参数 | 机器学习 | 模型自动调参 | 数据拆分比例', null, '拆分比例', '4', '6', '3', '0', '1', null, null, '0.0', '1.0', '0.8', null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.tune.0001.07', 'randomSeed', '组件参数 | 机器学习 | 模型自动调参 | 随机数种子', null, '随机数种子', '4', '4', '3', '0', '2', null, '1', '0', null, null, null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.tune.0001.08', 'classificationEvaluationType', '组件参数 | 机器学习 | 模型自动调参 | 分类评估标准', null, '分类评估标准', '4', '7', '3', '1', '5', null, null, null, null, 'AUC', null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.ml.tune.0001.09', 'regressionEvaluationType', '组件参数 | 机器学习 | 模型自动调参 | 回归评估标准', null, '回归评估标准', '4', '7', '3', '1', '5', null, null, null, null, 'MAE', null, '0', '2019-03-07 16:11:58', 'admin', '2019-03-07 16:11:58', 'admin');
INSERT INTO `wf_cfg_characteristic` VALUES ('com-param.char.st.sql.0001.01', 'sqlScript', '组件参数 | 脚本工具 | SQL脚本 | SQL脚本', null, 'SQL脚本', '4', '3001', '3', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');

-- ----------------------------
-- Table structure for wf_cfg_char_enum
-- ----------------------------
DROP TABLE IF EXISTS `wf_cfg_char_enum`;
CREATE TABLE `wf_cfg_char_enum` (
  `CHAR_ID` varchar(200) NOT NULL COMMENT '特征ID',
  `ENUM_NAME` varchar(200) NOT NULL COMMENT '枚举值名称',
  `ENUM_VALUE` varchar(2000) NOT NULL COMMENT '枚举值',
  `ENUM_LABEL` varchar(200) DEFAULT NULL COMMENT '枚举值标签，用于下拉框显示用，NULL时使用ENUM_VALUE填充',
  `SEQUENCE` int(11) NOT NULL COMMENT '排序序号',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CHAR_ID`,`ENUM_NAME`),
  UNIQUE KEY `Index_1` (`CHAR_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件特征枚举表，配置受枚举方式限定的组件特征，其所有预置的枚举项';

-- ----------------------------
-- Records of wf_cfg_char_enum
-- ----------------------------
INSERT INTO `wf_cfg_char_enum` VALUES ('com-exec.char.engine.$001', '调用执行 | 计算引擎 | 引擎类型 | Spark On Yarn', 'Spark On Yarn', null, '0', null, '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.dp.sample.$001', '输入内容 | 数据预处理 | 采样 | 采样方式 | Rate', 'Rate', '按比例采样', '0', null, '0', '2019-03-08 02:18:22', 'admin', '2019-03-08 02:18:22', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.dp.sample.$001', '输入内容 | 数据预处理 | 采样 | 采样方式 | Size', 'Size', '按个数采样', '1', null, '0', '2019-03-08 02:18:22', 'admin', '2019-03-08 02:18:22', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.dp.split.0001.01', '输入内容 | 数据预处理 | 拆分 | 拆分方式 | Rate', 'Rate', '按比例拆分', '0', null, '0', '2019-03-08 02:18:22', 'admin', '2019-03-08 02:18:22', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.dp.split.0001.01', '输入内容 | 数据预处理 | 拆分 | 拆分方式 | Threshold', 'Threshold', '按阈值拆分', '1', null, '0', '2019-03-08 02:18:22', 'admin', '2019-03-08 02:18:22', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.io.import.0001.01', '组件参数 | 输入输出 | 数据文件导入 | 文件类型 | CSV', 'CSV', null, '0', '字段逗号分隔', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.io.import.0001.01', '组件参数 | 输入输出 | 数据文件导入 | 文件类型 | Parquet', 'Parquet', null, '3', 'Parquet列式存储文件格式', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.io.import.0001.01', '组件参数 | 输入输出 | 数据文件导入 | 文件类型 | TSV', 'TSV', null, '1', '字段TAB分割', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.io.import.0001.01', '组件参数 | 输入输出 | 数据文件导入 | 文件类型 | TXT', 'TXT', null, '2', '字段空格分隔', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.io.import.0001.05', '组件参数 | 输入输出 | 数据文件导入 | 字符编码 | UTF-8', 'UTF-8', null, '0', null, '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.io.import.0001.08', '组件参数 | 输入输出 | 数据文件导入 | 字段类型异常处理 | Discard Row', 'Discard Row', '丢弃异常行', '1', null, '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.io.import.0001.08', '组件参数 | 输入输出 | 数据文件导入 | 字段类型异常处理 | Missing Value', 'Missing Value', '值设置为缺失', '0', null, '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.io.import.0001.08', '组件参数 | 输入输出 | 数据文件导入 | 字段类型异常处理 | Return Failed', 'Return Failed', '返回失败', '2', null, '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.io.import.0001.09', '组件参数 | 输入输出 | 数据文件导入 | 列数异常处理 | Discard Row', 'Discard Row', '丢弃异常行', '0', null, '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.io.import.0001.09', '组件参数 | 输入输出 | 数据文件导入 | 列数异常处理 | Return Failed', 'Return Failed', '返回失败', '1', null, '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.$.0001', '组件参数 | 机器学习 | K-Means | 距离度量方式 | City Block', 'City Block', null, '2', null, '-1', '2017-05-17 21:05:03', 'admin', '2017-05-17 21:05:03', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.$.0001', '组件参数 | 机器学习 | K-Means | 距离度量方式 | Cosine', 'Cosine', null, '1', null, '-1', '2017-05-17 21:04:16', 'admin', '2017-05-17 21:04:16', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.$.0001', '组件参数 | 机器学习 | K-Means | 距离度量方式 | Euclidean', 'Euclidean', null, '0', null, '-1', '2017-05-17 21:03:39', 'admin', '2017-05-17 21:03:48', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.$.0002', '组件参数 | 机器学习 | K-Means | 质心初始化方法 | External', 'External', null, '4', null, '-1', '2017-05-17 21:16:46', 'admin', '2017-05-17 21:16:46', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.$.0002', '组件参数 | 机器学习 | K-Means | 质心初始化方法 | KMPP', 'KMPP', null, '3', null, '-1', '2017-05-17 21:15:55', 'admin', '2017-05-17 21:15:55', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.$.0002', '组件参数 | 机器学习 | K-Means | 质心初始化方法 | Random', 'Random', null, '0', null, '-1', '2017-05-17 21:13:49', 'admin', '2017-05-17 21:13:49', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.$.0002', '组件参数 | 机器学习 | K-Means | 质心初始化方法 | Top K', 'Top K', null, '1', null, '-1', '2017-05-17 21:14:51', 'admin', '2017-05-17 21:14:51', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.$.0002', '组件参数 | 机器学习 | K-Means | 质心初始化方法 | Uniform', 'Uniform', null, '2', null, '-1', '2017-05-17 21:15:12', 'admin', '2017-05-17 21:15:12', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.algorithm.$001', '组件参数 | 机器学习 | 正则项类型 | L1', 'L1', null, '1', null, '0', '2017-05-12 02:07:04', 'admin', '2017-05-12 02:07:04', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.algorithm.$001', '组件参数 | 机器学习 | 正则项类型 | L2', 'L2', null, '2', null, '0', '2017-05-12 02:07:39', 'admin', '2017-05-12 02:07:39', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.algorithm.$001', '组件参数 | 机器学习 | 正则项类型 | Mixed L1/L2', 'Mixed L1/L2', null, '3', null, '0', '2017-05-12 02:06:11', 'admin', '2017-05-12 02:06:11', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.algorithm.$001', '组件参数 | 机器学习 | 正则项类型 | None', 'None', null, '0', null, '0', '2017-05-12 02:06:11', 'admin', '2017-05-12 02:06:11', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.algorithm.0006.01', '组件参数 | 机器学习 | 算法 - GBDT回归 | 损失函数类型 | Absolute Loss', 'Absolute Loss', null, '0', null, '0', '2017-05-12 02:06:11', 'admin', '2017-05-12 02:06:11', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.algorithm.0006.01', '组件参数 | 机器学习 | 算法 - GBDT回归 | 损失函数类型 | Squared Loss', 'Squared Loss', null, '1', null, '0', '2017-05-12 02:07:04', 'admin', '2017-05-12 02:07:04', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.tune.$001', '组件参数 | 机器学习 | 调参 | 调参类型 | Customize Parameter', 'Customize Parameter', '自定义参数', '0', null, '0', '2017-05-17 21:16:46', 'admin', '2017-05-17 21:16:46', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.tune.$001', '组件参数 | 机器学习 | 调参 | 调参类型 | Grid Search', 'Grid Search', '网格搜索', '2', null, '0', '2017-05-17 21:13:49', 'admin', '2017-05-17 21:13:49', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.tune.$001', '组件参数 | 机器学习 | 调参 | 调参类型 | Heuristic Search', 'Heuristic Search', '启发式搜索', '3', null, '0', '2017-05-17 21:14:51', 'admin', '2017-05-17 21:14:51', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.tune.$001', '组件参数 | 机器学习 | 调参 | 调参类型 | Random Search', 'Random Search', '随机搜索', '1', null, '0', '2017-05-17 21:15:55', 'admin', '2017-05-17 21:15:55', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.tune.0001.08', '组件参数 | 机器学习 | 模型自动调参 | 分类评估标准 | Accuracy', 'Accuracy', null, '1', null, '0', '2017-05-17 21:15:55', 'admin', '2017-05-17 21:15:55', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.tune.0001.08', '组件参数 | 机器学习 | 模型自动调参 | 分类评估标准 | AUC', 'AUC', null, '0', null, '0', '2017-05-17 21:16:46', 'admin', '2017-05-17 21:16:46', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.tune.0001.08', '组件参数 | 机器学习 | 模型自动调参 | 分类评估标准 | F1-Score', 'F1-Score', null, '4', null, '0', '2017-05-17 21:15:12', 'admin', '2017-05-17 21:15:12', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.tune.0001.08', '组件参数 | 机器学习 | 模型自动调参 | 分类评估标准 | Precision', 'Precision', null, '2', null, '0', '2017-05-17 21:13:49', 'admin', '2017-05-17 21:13:49', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.tune.0001.08', '组件参数 | 机器学习 | 模型自动调参 | 分类评估标准 | Recall', 'Recall', null, '3', null, '0', '2017-05-17 21:14:51', 'admin', '2017-05-17 21:14:51', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.tune.0001.09', '组件参数 | 机器学习 | 模型自动调参 | 回归评估标准 | MAE', 'MAE', '平均绝对误差', '0', null, '0', '2017-05-17 21:16:46', 'admin', '2017-05-17 21:16:46', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.tune.0001.09', '组件参数 | 机器学习 | 模型自动调参 | 回归评估标准 | R-Square', 'R-Square', '确定系数', '4', null, '0', '2017-05-17 21:15:12', 'admin', '2017-05-17 21:15:12', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.tune.0001.09', '组件参数 | 机器学习 | 模型自动调参 | 回归评估标准 | RAE', 'RAE', '相对绝对误差', '2', null, '0', '2017-05-17 21:13:49', 'admin', '2017-05-17 21:13:49', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.tune.0001.09', '组件参数 | 机器学习 | 模型自动调参 | 回归评估标准 | RMSE', 'RMSE', '均方根误差', '1', null, '0', '2017-05-17 21:15:55', 'admin', '2017-05-17 21:15:55', 'admin');
INSERT INTO `wf_cfg_char_enum` VALUES ('com-param.char.ml.tune.0001.09', '组件参数 | 机器学习 | 模型自动调参 | 回归评估标准 | RSE', 'RSE', '相对平方误差', '3', null, '0', '2017-05-17 21:14:51', 'admin', '2017-05-17 21:14:51', 'admin');

-- ----------------------------
-- Table structure for wf_cfg_char_type
-- ----------------------------
DROP TABLE IF EXISTS `wf_cfg_char_type`;
CREATE TABLE `wf_cfg_char_type` (
  `CHAR_TYPE_ID` int(11) NOT NULL COMMENT '特征类型ID',
  `CHAR_TYPE_CODE` varchar(200) NOT NULL COMMENT '特征类型代码',
  `CHAR_TYPE_NAME` varchar(200) NOT NULL COMMENT '特征类型名称',
  `IS_WILDTYPE` int(11) NOT NULL DEFAULT '0' COMMENT '是否为通配类型\r\n0：否\r\n1：是',
  `SPEC_MASK` int(11) NOT NULL DEFAULT '0' COMMENT '适用规格类型二进制掩码（预留）\r\n\r\n0：不支持作为对应规格的特征类型使用\r\n1：支持作为对应规格的特征类型使用\r\n\r\n第一位，输入内容规格，开关位0x01：数据表、模型、算法参数\r\n第二位，输出内容规格，开关位0x02：数据表、模型、算法参数\r\n第三位，调用执行规格，开关位0x04：基本类型\r\n第四位，执行调优规格，开关位0x08：基本类型\r\n第五位，组件参数规格，开关位0x10：基本类型、调参类型、代码脚本、Json Object、Json Array\r\n',
  `CLAZZ_PATH` varchar(200) NOT NULL DEFAULT 'unkown' COMMENT '特征类型java类class path',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CHAR_TYPE_ID`),
  UNIQUE KEY `Index_1` (`CHAR_TYPE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件特征类型表（仅查询用），相关定义辅助于数据校验和画布连线输入输出类型匹配校验\r\n\r\n特征值的读写行为由特征类型控制';

-- ----------------------------
-- Records of wf_cfg_char_type
-- ----------------------------
INSERT INTO `wf_cfg_char_type` VALUES ('1', 'Boolean', '布尔值', '0', '28', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.basic.BasicBoolean', 'true/false字符串', '0', '2017-05-12 00:42:11', 'admin', '2017-05-12 00:42:11', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('4', 'Long', '64位整数', '0', '28', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.basic.BasicLong', null, '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('6', 'Double', '双精度浮点数', '0', '28', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.basic.BasicDouble', null, '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('7', 'String', '字符串', '0', '28', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.basic.BasicString', null, '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('8', 'Date', '日期', '0', '28', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.basic.BasicDate', '“yyyy-mm-dd”格式字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('9', 'DateTime', '日期时间', '0', '28', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.basic.BasicDateTime', '“yyyy-mm-dd hh24:mi:ss”格式字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('104', 'Tuning-Parameter<Long>', '64位整数调参类型', '0', '16', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.tune.TuneLong', '可调参数据', '0', '2018-11-16 21:31:15', 'admin', '2018-11-16 21:31:15', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('106', 'Tuning-Parameter<Double>', '双精度浮点数调参类型', '0', '16', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.tune.TuneDouble', '可调参数据', '0', '2018-11-16 21:31:15', 'admin', '2018-11-16 21:31:15', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('1000', 'Data Table<?>', '通配任何数据表', '1', '1', '#only-for-input', '数据表', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('1001', 'Data Table<Parquet>', 'Parquet数据表', '0', '3', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.table.TableParquet', '数据表', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('2000', 'Trained Model<?>', '通配任何模型', '1', '1', '#only-for-input', '已训练模型', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('2001', 'Trained Model<OneClass-Classification>', '单分类模型', '0', '3', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.model.ModelOneClassification', '已训练模型', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('2002', 'Trained Model<TwoClass-Classification>', '二分类模型', '0', '3', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.model.ModelTwoClassification', '已训练模型', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('2003', 'Trained Model<MultipleClass-Classification>', '多分类模型', '0', '3', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.model.ModelMultipleClassification', '已训练模型', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('2004', 'Trained Model<Classification>', '通配分类模型', '1', '3', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.model.ModelClassification', '已训练模型', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('2005', 'Trained Model<Clustering>', '聚类模型', '0', '3', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.model.ModelClustering', '已训练模型', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('2006', 'Trained Model<Regression>', '回归模型', '0', '3', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.model.ModelRegression', '已训练模型', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('2007', 'Trained Model<Classification,Regression>', '通配分类和回归模型', '1', '3', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.model.ModelClassification$Regression', '已训练模型', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('2008', 'Trained Model<Classification,Clustering,Regression>', '通配分类，聚类和回归模型', '1', '3', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.model.ModelClassification$Clustering$Regression', '已训练模型', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('3001', 'SQL Script', 'SQL脚本', '0', '16', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.script.ScriptSQL', 'SQL脚本', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('4001', 'Algorithm Parameters<OneClass-Classification>', '单分类算法（未训练模型）', '0', '3', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.algorithm.AlgorithmOneClassification', '未训练模型', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('4002', 'Algorithm Parameters<TwoClass-Classification>', '二分类算法（未训练模型）', '0', '3', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.algorithm.AlgorithmTwoClassification', '未训练模型', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('4003', 'Algorithm Parameters<MultipleClass-Classification>', '多分类算法（未训练模型）', '0', '3', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.algorithm.AlgorithmMultipleClassification', '未训练模型', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('4004', 'Algorithm Parameters<Classification>', '通配分类算法（未训练模型）', '1', '1', '#only-for-input', '未训练模型', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('4005', 'Algorithm Parameters<Clustering>', '聚类算法（未训练模型）', '0', '3', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.algorithm.AlgorithmClustering', '未训练模型', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('4006', 'Algorithm Parameters<Regression>', '回归算法（未训练模型）', '0', '3', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.algorithm.AlgorithmRegression', '未训练模型', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('4007', 'Algorithm Parameters<Classification,Regression>', '通配分类和回归算法（未训练模型）', '1', '1', '#only-for-input', '未训练模型', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('5001', 'Model Evaluation Report', '模型评估报告', '0', '2', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.report.ReportModelEvaluation', '输出报告', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('5002', 'Statistical Analytics Report', '统计分析报告', '0', '2', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.report.ReportStatisticalAnalytics', '输出报告', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('5003', 'Cross Validation Report', '交叉验证报告', '0', '2', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.report.ReportCrossValidation', '输出报告', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('5004', 'Tune Parameters Report', '自动调参报告', '0', '2', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.report.ReportTuneParameters', '输出报告', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('5005', 'Generate Rules Report', '生成规则报告', '0', '2', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.report.ReportGenerateRules', '输出报告', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('9000', 'Json Object Data', 'json对象数据', '0', '16', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.json.JsonObject', '普通JSON数据', '0', '2017-05-12 00:31:39', 'admin', '2017-05-12 00:31:39', 'admin');
INSERT INTO `wf_cfg_char_type` VALUES ('9001', 'Json Array Data', 'json数组数据', '0', '16', 'com.yatop.lambda.workflow.core.framework.chartype.clazz.json.JsonArray', '普通JSON数据', '0', '2017-05-12 00:31:39', 'admin', '2017-05-12 00:31:39', 'admin');

-- ----------------------------
-- Table structure for wf_cfg_char_type_wild
-- ----------------------------
DROP TABLE IF EXISTS `wf_cfg_char_type_wild`;
CREATE TABLE `wf_cfg_char_type_wild` (
  `DST_CHAR_TYPE_ID` int(11) NOT NULL COMMENT '目标特征类型ID',
  `SRC_CHAR_TYPE_ID` int(11) NOT NULL COMMENT '来源特征类型ID',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`DST_CHAR_TYPE_ID`,`SRC_CHAR_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件端口特征类型通配表（仅查询用），配置目标端口特征类型和来源端口特征类型的匹配关系';

-- ----------------------------
-- Records of wf_cfg_char_type_wild
-- ----------------------------
INSERT INTO `wf_cfg_char_type_wild` VALUES ('1000', '1001', '通配任何数据表 | Parquet数据表', '0', '2018-11-21 16:44:59', 'admin', '2018-11-21 16:44:59', 'admin');
INSERT INTO `wf_cfg_char_type_wild` VALUES ('2000', '2005', '通配任何模型 | 通配分类，聚类和回归模型', '0', '2018-11-21 16:44:59', 'admin', '2018-11-21 16:44:59', 'admin');
INSERT INTO `wf_cfg_char_type_wild` VALUES ('2004', '2001', '通配分类模型 | 单分类模型', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `wf_cfg_char_type_wild` VALUES ('2004', '2002', '通配分类模型 | 二分类模型', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `wf_cfg_char_type_wild` VALUES ('2004', '2003', '通配分类模型 | 多分类模型', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `wf_cfg_char_type_wild` VALUES ('2007', '2004', '通配分类和回归模型 | 通配分类模型', '0', '2018-11-18 19:14:59', 'admin', '2018-11-18 19:14:59', 'admin');
INSERT INTO `wf_cfg_char_type_wild` VALUES ('2007', '2006', '通配分类和回归模型 | 回归模型', '0', '2018-11-18 19:14:59', 'admin', '2018-11-18 19:14:59', 'admin');
INSERT INTO `wf_cfg_char_type_wild` VALUES ('2008', '2005', '通配分类，聚类和回归模型 | 聚类模型', '0', '2018-11-18 19:14:59', 'admin', '2018-11-18 19:14:59', 'admin');
INSERT INTO `wf_cfg_char_type_wild` VALUES ('2008', '2007', '通配分类，聚类和回归模型 | 通配分类和回归模型', '0', '2018-11-18 19:14:59', 'admin', '2018-11-18 19:14:59', 'admin');
INSERT INTO `wf_cfg_char_type_wild` VALUES ('4004', '4001', '通配分类算法 | 单分类算法', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `wf_cfg_char_type_wild` VALUES ('4004', '4002', '通配分类算法 | 二分类算法', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `wf_cfg_char_type_wild` VALUES ('4004', '4003', '通配分类算法 | 多分类算法', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `wf_cfg_char_type_wild` VALUES ('4007', '4004', '通配分类和回归算法 | 通配分类算法', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `wf_cfg_char_type_wild` VALUES ('4007', '4006', '通配分类和回归算法 | 回归算法', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');

-- ----------------------------
-- Table structure for wf_cfg_cmpt_char_value
-- ----------------------------
DROP TABLE IF EXISTS `wf_cfg_cmpt_char_value`;
CREATE TABLE `wf_cfg_cmpt_char_value` (
  `CMPT_ID` varchar(200) NOT NULL COMMENT '组件ID',
  `CHAR_ID` varchar(200) NOT NULL COMMENT '特征ID',
  `IS_SYSTEM_PARAM` int(11) NOT NULL COMMENT '特征值是否为系统参数\r\n            0：否\r\n            1：是',
  `CHAR_VALUE` varchar(2000) DEFAULT NULL COMMENT '特征值',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CMPT_ID`,`CHAR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件配置特征值表，预置在组件上的组件特征值设定';

-- ----------------------------
-- Records of wf_cfg_cmpt_char_value
-- ----------------------------
INSERT INTO `wf_cfg_cmpt_char_value` VALUES ('com.dp.sample.0001', 'com-exec.char.spark.0003', '0', 'Random Sample', '', '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `wf_cfg_cmpt_char_value` VALUES ('com.dp.sample.0002', 'com-exec.char.spark.0003', '0', 'Weighted Sample', '', '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `wf_cfg_cmpt_char_value` VALUES ('com.dp.sample.0003', 'com-exec.char.spark.0003', '0', 'Balanced Sample', '', '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `wf_cfg_cmpt_char_value` VALUES ('com.dp.sample.0004', 'com-exec.char.spark.0003', '0', 'Stratified Sample', '', '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `wf_cfg_cmpt_char_value` VALUES ('com.dp.split.0001', 'com-exec.char.spark.0003', '0', 'Data Split', '', '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `wf_cfg_cmpt_char_value` VALUES ('com.dp.transform.0001', 'com-exec.char.spark.0003', '0', 'Type Transform', '', '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `wf_cfg_cmpt_char_value` VALUES ('com.io.import.0001', 'com-exec.char.spark.0003', '0', 'Import Data File', '', '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `wf_cfg_cmpt_char_value` VALUES ('com.ml.cross-validate.0001', 'com-exec.char.spark.0003', '0', 'Cross Validate Model', '', '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `wf_cfg_cmpt_char_value` VALUES ('com.ml.evaluate.0001', 'com-exec.char.spark.0003', '0', 'Evaluate Model - Binary Classification', '', '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `wf_cfg_cmpt_char_value` VALUES ('com.ml.evaluate.0002', 'com-exec.char.spark.0003', '0', 'Evaluate Model - Multiple Classification', '', '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `wf_cfg_cmpt_char_value` VALUES ('com.ml.evaluate.0003', 'com-exec.char.spark.0003', '0', 'Evaluate Model - Clustering', '', '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `wf_cfg_cmpt_char_value` VALUES ('com.ml.evaluate.0004', 'com-exec.char.spark.0003', '0', 'Evaluate Model - Regression', '', '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `wf_cfg_cmpt_char_value` VALUES ('com.ml.predict.0001', 'com-exec.char.spark.0003', '0', 'Predict Model', '', '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `wf_cfg_cmpt_char_value` VALUES ('com.ml.train.0001', 'com-exec.char.spark.0003', '0', 'Train Model', '', '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `wf_cfg_cmpt_char_value` VALUES ('com.ml.tune.0001', 'com-exec.char.spark.0003', '0', 'Tune Model Hyperparameter', '', '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `wf_cfg_cmpt_char_value` VALUES ('com.st.sql.0001', 'com-exec.char.spark.0003', '0', 'Sql Script', '', '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');

-- ----------------------------
-- Table structure for wf_cfg_cmpt_spec_rel
-- ----------------------------
DROP TABLE IF EXISTS `wf_cfg_cmpt_spec_rel`;
CREATE TABLE `wf_cfg_cmpt_spec_rel` (
  `CMPT_ID` varchar(200) NOT NULL COMMENT '组件ID',
  `SPEC_ID` varchar(200) NOT NULL COMMENT '规格ID',
  `SPEC_TYPE` int(11) NOT NULL COMMENT '组件规格类型',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CMPT_ID`,`SPEC_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件使用规格表，要求同一组件下组件参数与执行调优的特征代码唯一';

-- ----------------------------
-- Records of wf_cfg_cmpt_spec_rel
-- ----------------------------
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0001', 'com-input.spec.dp.sample.0001', '0', '数据预处理 | 随机采样，输入内容', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0001', 'com-output.spec.dp.sample.0001', '1', '数据预处理 | 随机采样，输出内容', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0001', 'com-exec.spec.spark.0001', '2', '数据预处理 | 随机采样，调用执行', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0001', 'com-o-exec.spec.spark.0001', '3', '数据预处理 | 随机采样，执行调优', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0001', 'com-param.spec.dp.sample.0001', '4', '数据预处理 | 随机采样，组件参数', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0002', 'com-input.spec.dp.sample.0002', '0', '数据预处理 | 加权采样，输入内容', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0002', 'com-output.spec.dp.sample.0002', '1', '数据预处理 | 加权采样，输出内容', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0002', 'com-exec.spec.spark.0001', '2', '数据预处理 | 加权采样，调用执行', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0002', 'com-o-exec.spec.spark.0001', '3', '数据预处理 | 加权采样，执行调优', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0002', 'com-param.spec.dp.sample.0002', '4', '数据预处理 | 加权采样，组件参数', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0003', 'com-input.spec.dp.sample.0003', '0', '数据预处理 | 均衡采样，输入内容', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0003', 'com-output.spec.dp.sample.0003', '1', '数据预处理 | 均衡采样，输出内容', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0003', 'com-exec.spec.spark.0001', '2', '数据预处理 | 均衡采样，调用执行', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0003', 'com-o-exec.spec.spark.0001', '3', '数据预处理 | 均衡采样，执行调优', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0003', 'com-param.spec.dp.sample.0003', '4', '数据预处理 | 均衡采样，组件参数', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0004', 'com-input.spec.dp.sample.0004', '0', '数据预处理 | 分层采样，输入内容', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0004', 'com-output.spec.dp.sample.0004', '1', '数据预处理 | 分层采样，输出内容', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0004', 'com-exec.spec.spark.0001', '2', '数据预处理 | 分层采样，调用执行', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0004', 'com-o-exec.spec.spark.0001', '3', '数据预处理 | 分层采样，执行调优', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.sample.0004', 'com-param.spec.dp.sample.0004', '4', '数据预处理 | 分层采样，组件参数', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.split.0001', 'com-input.spec.dp.split.0001', '0', '数据预处理 | 数据拆分，输入内容', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.split.0001', 'com-output.spec.dp.split.0001', '1', '数据预处理 | 数据拆分，输出内容', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.split.0001', 'com-exec.spec.spark.0001', '2', '数据预处理 | 数据拆分，调用执行', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.split.0001', 'com-o-exec.spec.spark.0001', '3', '数据预处理 | 数据拆分，执行调优', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.split.0001', 'com-param.spec.dp.split.0001', '4', '数据预处理 | 数据拆分，组件参数', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.transform.0001', 'com-input.spec.dp.transform.0001', '0', '数据预处理 | 类型转换，输入内容', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.transform.0001', 'com-output.spec.dp.transform.0001', '1', '数据预处理 | 类型转换，输出内容', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.transform.0001', 'com-exec.spec.spark.0001', '2', '数据预处理 | 类型转换，调用执行', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.transform.0001', 'com-o-exec.spec.spark.0001', '3', '数据预处理 | 类型转换，执行调优', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.dp.transform.0001', 'com-param.spec.dp.transform.0001', '4', '数据预处理 | 类型转换，组件参数', '0', '2019-03-07 15:16:36', 'admin', '2019-03-07 15:16:36', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.io.import.0001', 'com-output.spec.io.import.0001', '1', '输入输出 | 数据文件导入，输出内容', '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.io.import.0001', 'com-exec.spec.spark.0001', '2', '输入输出 | 数据文件导入，调用执行', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.io.import.0001', 'com-o-exec.spec.spark.0001', '3', '输入输出 | 数据文件导入，执行调优', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.io.import.0001', 'com-param.spec.io.import.0001', '4', '输入输出 | 数据文件导入，组件参数', '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.io.read.0001', 'com-output.spec.io.read.0001', '1', '输入输出 | 数据表读取，输出内容', '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.io.read.0001', 'com-param.spec.io.read.0001', '4', '输入输出 | 数据表读取，组件参数', '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.io.read.0002', 'com-output.spec.io.read.0002', '1', '输入输出 | 模型读取，输出内容', '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.io.read.0002', 'com-param.spec.io.read.0002', '4', '输入输出 | 模型读取，组件参数', '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.io.write.0001', 'com-input.spec.io.write.0001', '0', '输入输出 | 数据表写入，输入内容', '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.io.write.0001', 'com-param.spec.io.write.0001', '4', '输入输出 | 数据表写入，组件参数', '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.algorithm.0001', 'com-output.spec.ml.algorithm.0001', '1', '机器学习 | 算法 - 逻辑回归二分类，输出内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.algorithm.0001', 'com-param.spec.ml.algorithm.0001', '4', '机器学习 | 算法 - 逻辑回归二分类，组件参数', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.algorithm.0002', 'com-output.spec.ml.algorithm.0002', '1', '机器学习 | 算法 - 随机森林二分类，输出内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.algorithm.0002', 'com-param.spec.ml.algorithm.0002', '4', '机器学习 | 算法 - 随机森林二分类，组件参数', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.algorithm.0003', 'com-output.spec.ml.algorithm.0003', '1', '机器学习 | 算法 - GBDT二分类，输出内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.algorithm.0003', 'com-param.spec.ml.algorithm.0003', '4', '机器学习 | 算法 - GBDT二分类，组件参数', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.algorithm.0004', 'com-output.spec.ml.algorithm.0004', '1', '机器学习 | 算法 - 线性SVM二分类，输出内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.algorithm.0004', 'com-param.spec.ml.algorithm.0004', '4', '机器学习 | 算法 - 线性SVM二分类，组件参数', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.algorithm.0005', 'com-output.spec.ml.algorithm.0005', '1', '机器学习 | 算法 - 线性回归，输出内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.algorithm.0005', 'com-param.spec.ml.algorithm.0005', '4', '机器学习 | 算法 - 线性回归，组件参数', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.algorithm.0006', 'com-output.spec.ml.algorithm.0006', '1', '机器学习 | 算法 - GBDT回归，输出内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.algorithm.0006', 'com-param.spec.ml.algorithm.0006', '4', '机器学习 | 算法 - GBDT回归，组件参数', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.cross-validate.0001', 'com-input.spec.ml.cross-validate.0001', '0', '机器学习 | 模型交叉验证，输入内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.cross-validate.0001', 'com-output.spec.ml.cross-validate.0001', '1', '机器学习 | 模型交叉验证，输出内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.cross-validate.0001', 'com-exec.spec.spark.0001', '2', '机器学习 | 模型交叉验证，调用执行', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.cross-validate.0001', 'com-o-exec.spec.spark.0001', '3', '机器学习 | 模型交叉验证，执行调优', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.cross-validate.0001', 'com-param.spec.ml.cross-validate.0001', '4', '机器学习 | 模型交叉验证，组件参数', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0001', 'com-input.spec.ml.evaluate.0001', '0', '机器学习 | 模型评估 - 二分类，输入内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0001', 'com-output.spec.ml.evaluate.0001', '1', '机器学习 | 模型评估 - 二分类，输出内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0001', 'com-exec.spec.spark.0001', '2', '机器学习 | 模型评估 - 二分类，调用执行', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0001', 'com-o-exec.spec.spark.0001', '3', '机器学习 | 模型评估 - 二分类，执行调优', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0001', 'com-param.spec.ml.evaluate.0001', '4', '机器学习 | 模型评估 - 二分类，组件参数', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0002', 'com-input.spec.ml.evaluate.0002', '0', '机器学习 | 模型评估 - 多分类，输入内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0002', 'com-output.spec.ml.evaluate.0002', '1', '机器学习 | 模型评估 - 多分类，输出内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0002', 'com-exec.spec.spark.0001', '2', '机器学习 | 模型评估 - 多分类，调用执行', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0002', 'com-o-exec.spec.spark.0001', '3', '机器学习 | 模型评估 - 多分类，执行调优', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0002', 'com-param.spec.ml.evaluate.0002', '4', '机器学习 | 模型评估 - 多分类，组件参数', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0003', 'com-input.spec.ml.evaluate.0003', '0', '机器学习 | 模型评估 - 聚类，输入内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0003', 'com-output.spec.ml.evaluate.0003', '1', '机器学习 | 模型评估 - 聚类，输出内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0003', 'com-exec.spec.spark.0001', '2', '机器学习 | 模型评估 - 聚类，调用执行', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0003', 'com-o-exec.spec.spark.0001', '3', '机器学习 | 模型评估 - 聚类，执行调优', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0003', 'com-param.spec.ml.evaluate.0003', '4', '机器学习 | 模型评估 - 聚类，组件参数', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0004', 'com-input.spec.ml.evaluate.0004', '0', '机器学习 | 模型评估 - 回归，输入内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0004', 'com-output.spec.ml.evaluate.0004', '1', '机器学习 | 模型评估 - 回归，输出内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0004', 'com-exec.spec.spark.0001', '2', '机器学习 | 模型评估 - 回归，调用执行', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0004', 'com-o-exec.spec.spark.0001', '3', '机器学习 | 模型评估 - 回归，执行调优', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.evaluate.0004', 'com-param.spec.ml.evaluate.0004', '4', '机器学习 | 模型评估 - 回归，组件参数', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.predict.0001', 'com-input.spec.ml.predict.0001', '0', '机器学习 | 模型预测，输入内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.predict.0001', 'com-output.spec.ml.predict.0001', '1', '机器学习 | 模型预测，输出内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.predict.0001', 'com-exec.spec.spark.0001', '2', '机器学习 | 模型预测，调用执行', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.predict.0001', 'com-o-exec.spec.spark.0001', '3', '机器学习 | 模型预测，执行调优', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.predict.0001', 'com-param.spec.ml.predict.0001', '4', '机器学习 | 模型预测，组件参数', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.train.0001', 'com-input.spec.ml.train.0001', '0', '机器学习 | 模型训练，输入内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.train.0001', 'com-output.spec.ml.train.0001', '1', '机器学习 | 模型训练，输出内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.train.0001', 'com-exec.spec.spark.0001', '2', '机器学习 | 模型训练，调用执行', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.train.0001', 'com-o-exec.spec.spark.0001', '3', '机器学习 | 模型训练，执行调优', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.train.0001', 'com-param.spec.ml.train.0001', '4', '机器学习 | 模型训练，组件参数', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.tune.0001', 'com-input.spec.ml.tune.0001', '0', '机器学习 | 模型自动调参，输入内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.tune.0001', 'com-output.spec.ml.tune.0001', '1', '机器学习 | 模型自动调参，输出内容', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.tune.0001', 'com-exec.spec.spark.0001', '2', '机器学习 | 模型自动调参，调用执行', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.tune.0001', 'com-o-exec.spec.spark.0001', '3', '机器学习 | 模型自动调参，执行调优', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.ml.tune.0001', 'com-param.spec.ml.tune.0001', '4', '机器学习 | 模型自动调参，组件参数', '0', '2019-03-07 14:58:38', 'admin', '2019-03-07 14:58:38', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.st.sql.0001', 'com-input.spec.st.sql.0001', '0', '脚本工具 | SQL脚本，输入内容', '0', '2019-03-07 15:02:26', 'admin', '2019-03-07 15:02:26', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.st.sql.0001', 'com-output.spec.st.sql.0001', '1', '脚本工具 | SQL脚本，输出内容', '0', '2019-03-07 15:02:26', 'admin', '2019-03-07 15:02:26', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.st.sql.0001', 'com-exec.spec.spark.0001', '2', '脚本工具 | SQL脚本，调用执行', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.st.sql.0001', 'com-o-exec.spec.spark.0001', '3', '脚本工具 | SQL脚本，执行调优', '0', '2019-03-07 15:20:39', 'admin', '2019-03-07 15:20:39', 'admin');
INSERT INTO `wf_cfg_cmpt_spec_rel` VALUES ('com.st.sql.0001', 'com-param.spec.st.sql.0001', '4', '脚本工具 | SQL脚本，组件参数', '0', '2019-03-07 15:02:26', 'admin', '2019-03-07 15:02:26', 'admin');

-- ----------------------------
-- Table structure for wf_cfg_component
-- ----------------------------
DROP TABLE IF EXISTS `wf_cfg_component`;
CREATE TABLE `wf_cfg_component` (
  `CMPT_ID` varchar(200) NOT NULL COMMENT '组件ID',
  `CMPT_CODE` varchar(200) NOT NULL COMMENT '组件代码',
  `CMPT_NAME` varchar(200) NOT NULL COMMENT '组件名称',
  `CMPT_TYPE` int(11) NOT NULL COMMENT '组件种类\r\n            0：输入输出组件\r\n            1：脚本工具组件\r\n            2：数据预处理组件\r\n            3：特征工程组件\r\n            4：统计分析组件\r\n            5：机器学习组件\r\n            6：深度学习组件\r\n            7：文本分析组件\r\n            8：网络分析组件\r\n            9：时间序列组件\r\n            10：业务场景组件',
  `REL_ALGORITHM_ID` bigint(20) NOT NULL COMMENT '关联算法ID，非算法组件设为-1',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CMPT_ID`),
  UNIQUE KEY `Index_1` (`CMPT_CODE`),
  UNIQUE KEY `Index_2` (`CMPT_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件表';

-- ----------------------------
-- Records of wf_cfg_component
-- ----------------------------
INSERT INTO `wf_cfg_component` VALUES ('#com.bs', 'Business Scenario', '业务场景 | 业务场景', '10', '-1', null, '-1', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('#com.dl', 'Deep Learning', '深度学习 | 深度学习', '6', '-1', null, '-1', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('#com.dp', 'Data Preprocessing', '数据预处理 | 数据预处理', '2', '-1', null, '-1', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('#com.fe', 'Feature Engineering', '特征工程 | 特征工程', '3', '-1', null, '-1', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('#com.io', 'Input Output', '输入输出 | 输入输出', '0', '-1', null, '-1', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('#com.ml', 'Machine Learning', '机器学习 | 机器学习', '5', '-1', null, '-1', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('#com.na', 'Network Analytics', '网络分析 | 网络分析', '8', '-1', null, '-1', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('#com.sa', 'Statistical Analytics', '统计分析 | 统计分析', '4', '-1', null, '-1', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('#com.st', 'Script Tools', '脚本工具 | 脚本工具', '1', '-1', null, '-1', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('#com.ta', 'Text Analysis', '文本分析 | 文本分析', '7', '-1', null, '-1', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('#com.ts', 'Time Series', '时间序列 | 时间序列', '8', '-1', null, '-1', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.dp.sample.0001', 'Random Sample', '数据预处理 | 随机采样', '2', '-1', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.dp.sample.0002', 'Weighted Sample', '数据预处理 | 加权采样', '2', '-1', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.dp.sample.0003', 'Balanced Sample', '数据预处理 | 均衡采样', '2', '-1', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.dp.sample.0004', 'Stratified Sample', '数据预处理 | 分层采样', '2', '-1', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.dp.split.0001', 'Data Split', '数据预处理 | 数据拆分', '2', '-1', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.dp.transform.0001', 'Type Transform', '数据预处理 | 类型转换', '2', '-1', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.io.import.0001', 'Import Data File', '输入输出 | 数据文件导入', '0', '-1', '用于HDFS数据文件和上传数据文件的导入', '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.io.read.0001', 'Read Data Table', '输入输出 | 数据表读取', '0', '-1', '工作流中对数据表引入', '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.io.read.0002', 'Read Model', '输入输出 | 模型读取', '0', '-1', '工作流中对模型表引入，支持对回归，聚类和分类模型读取', '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.io.write.0001', 'Write Data Table', '输入输出 | 数据表写入', '0', '-1', '更新到指定数据表名，表不存在自动创建', '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.ml.algorithm.0001', 'Algorithm - Binary Logistic Regression', '机器学习 | 算法 - 逻辑回归二分类', '5', '2001', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.ml.algorithm.0002', 'Algorithm - Binary Random Forest', '机器学习 | 算法 - 随机森林二分类', '5', '2002', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.ml.algorithm.0003', 'Algorithm - Binary Gradient Boost Decision', '机器学习 | 算法 - GBDT二分类', '5', '2003', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.ml.algorithm.0004', 'Algorithm - Binary Linear Support Vector Machine', '机器学习 | 算法 - 线性SVM二分类（暂未实现）', '5', '2004', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.ml.algorithm.0005', 'Algorithm - Linear Regression', '机器学习 | 算法 - 线性回归', '5', '5001', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.ml.algorithm.0006', 'Algorithm - Gradient Boost Decision Tree Regression', '机器学习 | 算法 - GBDT回归', '5', '5002', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.ml.cross-validate.0001', 'Cross Validate Model', '机器学习 | 模型交叉验证（暂未实现）', '5', '-1', '支持对回归和分类算法进行交叉验证', '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.ml.evaluate.0001', 'Evaluate Model - Binary Classification', '机器学习 | 模型评估 - 二分类', '5', '-1', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.ml.evaluate.0002', 'Evaluate Model - Multiple Classification', '机器学习 | 模型评估 - 多分类（暂未实现）', '5', '-1', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.ml.evaluate.0003', 'Evaluate Model - Clustering', '机器学习 | 模型评估 - 聚类（暂未实现）', '5', '-1', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.ml.evaluate.0004', 'Evaluate Model - Regression', '机器学习 | 模型评估 - 回归', '5', '-1', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.ml.predict.0001', 'Predict Model', '机器学习 | 模型预测', '5', '-1', '支持对回归，聚类和分类模型进行模型预测', '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.ml.train.0001', 'Train Model', '机器学习 | 模型训练', '5', '-1', '支持对回归和分类算法进行模型训练', '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.ml.train.0002', 'Train Model - K-Means', '机器学习 | 模型训练 - K均值聚类（暂未实现）', '5', '4001', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.ml.tune.0001', 'Tune Model Hyperparameter', '机器学习 | 模型自动调参（暂未实现）', '5', '-1', '支持对回归和分类算法进行超参数调参', '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');
INSERT INTO `wf_cfg_component` VALUES ('com.st.sql.0001', 'Sql Script', '脚本工具 | SQL脚本', '1', '-1', null, '0', '2019-03-07 14:55:50', 'admin', '2019-03-07 14:55:50', 'admin');

-- ----------------------------
-- Table structure for wf_cfg_module
-- ----------------------------
DROP TABLE IF EXISTS `wf_cfg_module`;
CREATE TABLE `wf_cfg_module` (
  `MODULE_ID` bigint(20) NOT NULL COMMENT '组件ID',
  `MODULE_CODE` varchar(200) NOT NULL COMMENT '组件代码',
  `MODULE_NAME` varchar(200) NOT NULL COMMENT '组件名称',
  `MODULE_TYPE` int(11) NOT NULL COMMENT '组件类型\r\n0：普通工作流组件（可拖拽到画布中）\r\n1：不进工作流组件（不可托到画布中，封装的计算组件无输入内容，无输出端口）',
  `CATALOG_ID` bigint(20) NOT NULL DEFAULT '0' COMMENT '所属目录ID，不进目录设为-1',
  `SEQUENCE` int(11) NOT NULL COMMENT '排序序号',
  `CATEGORY` varchar(200) DEFAULT NULL COMMENT '组件类别（预留），自定义类别',
  `ICON_TYPE` int(11) NOT NULL COMMENT '图标类型',
  `CLAZZ_PATH` varchar(200) NOT NULL COMMENT '组件java类class path',
  `PKG_CMPT_ID` varchar(200) NOT NULL COMMENT '所封装的计算组件ID',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`MODULE_ID`),
  UNIQUE KEY `Index_1` (`MODULE_CODE`),
  KEY `Index_2` (`CATALOG_ID`,`SEQUENCE`),
  KEY `Index_3` (`PKG_CMPT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流组件表';

-- ----------------------------
-- Records of wf_cfg_module
-- ----------------------------
INSERT INTO `wf_cfg_module` VALUES ('0', 'ImportDataFile', '导入数据文件', '1', '-1', '-1', 'process', '0', 'com.yatop.lambda.workflow.module.clazz.input_output.ImportDataFile', 'com.io.import.0001', '用于HDFS数据文件和上传数据文件的导入', '0', '2017-05-27 17:39:48', 'admin', '2017-05-27 17:39:48', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('1', 'ReadDataTable', '读数据表', '0', '1', '0', 'source', '0', 'com.yatop.lambda.workflow.module.clazz.input_output.ReadDataTable', 'com.io.read.0001', '工作流中对数据表引入', '0', '2017-05-27 16:11:04', 'admin', '2017-05-27 16:11:04', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('2', 'ReadModel', '读模型', '0', '1', '1', 'source', '0', 'com.yatop.lambda.workflow.module.clazz.input_output.ReadModel', 'com.io.read.0002', '工作流中对模型表引入，支持对回归，聚类和分类模型读取', '0', '2017-05-27 16:13:58', 'admin', '2017-05-27 16:13:58', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('3', 'WriteDataTable', '写数据表', '0', '1', '2', 'destination', '0', 'com.yatop.lambda.workflow.module.clazz.input_output.WriteDataTable', 'com.io.write.0001', '更新到指定数据表名，表不存在自动创建', '0', '2017-05-27 16:11:04', 'admin', '2017-05-27 16:11:04', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('4', 'SqlScript', 'SQL脚本', '0', '2', '0', 'user_code', '0', 'com.yatop.lambda.workflow.module.clazz.script_tools.SqlScript', 'com.st.sql.0001', null, '0', '2017-05-27 16:18:13', 'admin', '2017-05-27 16:18:13', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('5', 'BinaryLogisticRegression', '逻辑回归二分类', '0', '10', '0', 'training', '0', 'com.yatop.lambda.workflow.module.clazz.machine_learning.classification.BinaryLogisticRegression', 'com.ml.algorithm.0001', null, '0', '2017-05-27 16:43:05', 'admin', '2017-05-27 16:43:05', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('6', 'BinaryRandomForest', '随机森林二分类', '0', '10', '1', 'training', '0', 'com.yatop.lambda.workflow.module.clazz.machine_learning.classification.BinaryRandomForest', 'com.ml.algorithm.0002', null, '0', '2017-05-27 16:49:30', 'admin', '2017-05-27 16:49:30', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('7', 'BinaryGBDT', 'GBDT二分类', '0', '10', '2', 'training', '0', 'com.yatop.lambda.workflow.module.clazz.machine_learning.classification.BinaryGBDT', 'com.ml.algorithm.0003', null, '0', '2017-05-27 16:50:15', 'admin', '2017-05-27 16:50:15', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('8', 'LinearRegression', '线性回归', '0', '12', '0', 'training', '0', 'com.yatop.lambda.workflow.module.clazz.machine_learning.regression.LinearRegression', 'com.ml.algorithm.0005', null, '0', '2017-05-27 17:26:08', 'admin', '2017-05-27 17:26:08', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('9', 'GBDTRegression', 'GBDT回归', '0', '12', '1', 'training', '0', 'com.yatop.lambda.workflow.module.clazz.machine_learning.regression.GBDTRegression', 'com.ml.algorithm.0006', null, '0', '2017-05-27 17:27:30', 'admin', '2017-05-27 17:27:30', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('10', 'Train', '训练', '0', '15', '0', 'prediction', '0', 'com.yatop.lambda.workflow.module.clazz.machine_learning.training.Train', 'com.ml.train.0001', '支持对回归和分类算法进行模型训练', '0', '2017-05-27 17:37:12', 'admin', '2017-05-27 17:37:12', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('11', 'Predict', '预测', '0', '16', '0', 'prediction', '0', 'com.yatop.lambda.workflow.module.clazz.machine_learning.prediction.Predict', 'com.ml.predict.0001', '支持对回归，聚类和分类模型进行模型预测', '0', '2017-05-27 17:37:12', 'admin', '2017-05-27 17:37:12', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('12', 'BinaryClassificationEvaluate', '二分类评估', '0', '17', '0', 'evaluation', '0', 'com.yatop.lambda.workflow.module.clazz.machine_learning.evaluation.BinaryEvaluate', 'com.ml.evaluate.0001', null, '0', '2017-05-27 17:38:00', 'admin', '2017-05-27 17:38:00', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('13', 'RegressionEvaluate', '回归模型评估', '0', '17', '3', 'evaluation', '0', 'com.yatop.lambda.workflow.module.clazz.machine_learning.evaluation.RegressionEvaluate', 'com.ml.evaluate.0004', null, '0', '2017-05-27 17:39:48', 'admin', '2017-05-27 17:39:48', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('14', 'RandomSample', '随机采样', '0', '18', '0', 'process', '0', 'com.yatop.lambda.workflow.module.clazz.data_preprocessing.sample.RandomSample', 'com.dp.sample.0001', null, '0', '2017-05-27 17:26:08', 'admin', '2017-05-27 17:26:08', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('15', 'WeightedSample', '加权采样', '0', '18', '1', 'process', '0', 'com.yatop.lambda.workflow.module.clazz.data_preprocessing.sample.WeightedSample', 'com.dp.sample.0002', null, '0', '2017-05-27 17:27:30', 'admin', '2017-05-27 17:27:30', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('16', 'BalancedSample', '均衡采样', '0', '18', '2', 'process', '0', 'com.yatop.lambda.workflow.module.clazz.data_preprocessing.sample.BalancedSample', 'com.dp.sample.0003', null, '0', '2017-05-27 17:37:12', 'admin', '2017-05-27 17:37:12', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('17', 'StratifiedSample', '分层采样', '0', '18', '3', 'process', '0', 'com.yatop.lambda.workflow.module.clazz.data_preprocessing.sample.StratifiedSample', 'com.dp.sample.0004', null, '0', '2017-05-27 17:37:12', 'admin', '2017-05-27 17:37:12', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('18', 'TypeTransform', '类型转换', '0', '3', '0', 'process', '0', 'com.yatop.lambda.workflow.module.clazz.data_preprocessing.TypeTransform', 'com.dp.transform.0001', null, '0', '2017-05-27 17:39:48', 'admin', '2017-05-27 17:39:48', 'admin');
INSERT INTO `wf_cfg_module` VALUES ('19', 'DataSplit', '数据拆分', '0', '3', '1', 'process', '0', 'com.yatop.lambda.workflow.module.clazz.data_preprocessing.DataSplit', 'com.dp.split.0001', null, '0', '2017-05-27 17:38:00', 'admin', '2017-05-27 17:38:00', 'admin');

-- ----------------------------
-- Table structure for wf_cfg_module_catalog
-- ----------------------------
DROP TABLE IF EXISTS `wf_cfg_module_catalog`;
CREATE TABLE `wf_cfg_module_catalog` (
  `CATALOG_ID` bigint(20) NOT NULL COMMENT '目录ID',
  `CATALOG_CODE` varchar(200) NOT NULL COMMENT '目录代码',
  `CATALOG_NAME` varchar(200) NOT NULL COMMENT '目录名称',
  `PARENT_CATALOG_ID` bigint(20) NOT NULL COMMENT '上级目录ID，一级目录设为0',
  `SEQUENCE` int(11) NOT NULL COMMENT '排序序号',
  `ICON_TYPE` int(11) NOT NULL COMMENT '图标类型',
  `CATEGORY` varchar(200) DEFAULT NULL COMMENT '组件类别（预留），自定义类别',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CATALOG_ID`),
  UNIQUE KEY `Index_1` (`CATALOG_CODE`),
  KEY `Index_2` (`PARENT_CATALOG_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流组件目录表，用于定义工作流组件目录结构';

-- ----------------------------
-- Records of wf_cfg_module_catalog
-- ----------------------------
INSERT INTO `wf_cfg_module_catalog` VALUES ('0', 'RootCategory', '根目录', '-1', '0', '0', null, '根目录', '0', '2017-06-06 16:09:16', 'admin', '2017-06-06 16:09:16', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('1', 'SourceDestination', '源 / 目标', '0', '0', '0', 'read-write', '数据表读写', '0', '2017-05-27 15:08:17', 'admin', '2017-05-27 15:08:17', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('2', 'ScriptTools', '脚本工具', '0', '1', '0', 'user-code', 'SQL、Python、R等多种脚本支持', '0', '2017-05-27 15:18:10', 'admin', '2017-05-27 15:18:03', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('3', 'DataPreprocessing', '数据预处理', '0', '2', '0', 'process', '数据预处理', '0', '2017-05-27 15:25:40', 'admin', '2017-05-27 15:25:40', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('4', 'FeatureEngineering', '特征工程', '0', '3', '0', 'process', '特征工程', '-1', '2017-05-27 15:27:10', 'admin', '2017-05-27 15:27:10', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('5', 'StatisticalAnalytics', '统计分析', '0', '4', '0', 'analysis', '统计分析', '-1', '2017-05-27 15:28:10', 'admin', '2017-05-27 15:28:10', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('6', 'MachineLearning', '机器学习', '0', '5', '0', 'training', '算法建模', '0', '2017-05-27 17:55:44', 'admin', '2017-05-27 17:55:41', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('7', 'DeepLearning', '深度学习', '0', '6', '0', 'process', '深度学习', '-1', '2017-05-27 17:56:16', 'admin', '2017-05-27 17:56:16', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('8', 'TextAnalytics', '文本分析', '0', '7', '0', 'process', '文本分析', '-1', '2017-05-27 17:56:55', 'admin', '2017-05-27 17:56:55', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('9', 'NetworkAnalytics', '网络分析', '0', '8', '0', 'process', '网络分析', '-1', '2017-05-27 17:57:23', 'admin', '2017-05-27 17:57:23', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('10', 'BinaryClassification', '二分类', '6', '0', '0', 'algorithm', '二分类算法', '0', '2017-05-31 14:32:08', 'admin', '2017-05-31 14:32:08', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('11', 'MultipleClassification', '多分类', '6', '1', '0', 'algorithm', '多分类算法', '-1', '2017-05-31 14:33:41', 'admin', '2017-05-31 14:33:41', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('12', 'Regression', '回归', '6', '2', '0', 'algorithm', '回归算法', '0', '2017-05-31 14:58:30', 'admin', '2017-05-31 14:58:30', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('13', 'Clustering', '聚类', '6', '3', '0', 'training', '聚类训练', '-1', '2017-05-31 14:34:41', 'admin', '2017-05-31 14:34:41', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('14', 'AssociateRecommendation', '关联推荐', '6', '4', '0', 'training', '关联推荐训练', '-1', '2017-05-31 15:05:25', 'admin', '2017-05-31 15:05:25', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('15', 'Training', '训练', '6', '5', '0', 'training', '模型训练', '0', '2017-05-31 15:14:49', 'admin', '2017-05-31 15:14:49', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('16', 'Predition', '预测', '6', '6', '0', 'predition', '模型预测', '0', '2017-05-31 15:14:49', 'admin', '2017-05-31 15:14:49', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('17', 'Evaluation', '评估', '6', '7', '0', 'evaluation', '模型评估', '0', '2017-05-31 15:14:49', 'admin', '2017-05-31 15:14:49', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('18', 'DataSampling', '数据采样', '3', '0', '0', 'process', '数据采样', '0', '2017-05-31 15:14:49', 'admin', '2017-05-31 15:14:49', 'admin');
INSERT INTO `wf_cfg_module_catalog` VALUES ('19', 'DataMerging', '数据合并', '3', '1', '0', 'process', '数据合并', '-1', '2017-05-31 15:14:49', 'admin', '2017-05-31 15:14:49', 'admin');

-- ----------------------------
-- Table structure for wf_cfg_module_port
-- ----------------------------
DROP TABLE IF EXISTS `wf_cfg_module_port`;
CREATE TABLE `wf_cfg_module_port` (
  `PORT_ID` bigint(20) NOT NULL COMMENT '端口ID，组件的同一类型端口数最多6个\r\n            端口ID值组成：工作流组件ID * 100 + 一位节点端口类型 * 10 + 一位端口序号',
  `PORT_NAME` varchar(200) NOT NULL COMMENT '端口名称',
  `PORT_TYPE` int(11) NOT NULL COMMENT '端口类型\r\n            1：输入端口\r\n            2：输出端口',
  `OWNER_MODULE_ID` bigint(20) NOT NULL COMMENT '所属工作流组件ID',
  `BIND_CHAR_ID` varchar(200) NOT NULL COMMENT '绑定计算组件输入输出特征ID',
  `SEQUENCE` int(11) NOT NULL COMMENT '端口序号',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '端口状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PORT_ID`),
  UNIQUE KEY `Index_2` (`OWNER_MODULE_ID`,`BIND_CHAR_ID`),
  KEY `Index_1` (`OWNER_MODULE_ID`,`PORT_TYPE`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流组件端口表，映射计算组件输入输出内容到工作流组件端口上';

-- ----------------------------
-- Records of wf_cfg_module_port
-- ----------------------------
INSERT INTO `wf_cfg_module_port` VALUES ('110', '数据输出', '1', '1', 'com-output.char.io.read.0001.01', '0', null, '0', '2017-05-27 20:12:15', 'admin', '2017-05-27 20:12:15', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('210', '已训练输出', '1', '2', 'com-output.char.io.read.0002.01', '0', null, '0', '2017-05-27 20:21:59', 'admin', '2017-05-27 20:21:59', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('300', '数据输入', '0', '3', 'com-input.char.io.write.0001.01', '0', null, '0', '2017-06-06 17:53:42', 'admin', '2017-06-06 17:53:42', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('400', 'SQL脚本输入t1', '0', '4', 'com-input.char.st.sql.0001.01', '0', null, '0', '2017-05-27 20:44:40', 'admin', '2017-05-27 20:44:40', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('401', 'SQL脚本输入t2', '0', '4', 'com-input.char.st.sql.0001.02', '1', null, '0', '2017-05-27 20:48:13', 'admin', '2017-05-27 20:48:13', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('402', 'SQL脚本输入t3', '0', '4', 'com-input.char.st.sql.0001.03', '2', null, '0', '2017-05-27 20:48:51', 'admin', '2017-05-27 20:48:51', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('403', 'SQL脚本输入t4', '0', '4', 'com-input.char.st.sql.0001.04', '3', null, '0', '2017-05-27 20:49:21', 'admin', '2017-05-27 20:49:21', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('410', 'SQL脚本输出', '1', '4', 'com-output.char.st.sql.0001.01', '0', null, '0', '2017-05-27 20:55:27', 'admin', '2017-05-27 20:55:27', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('510', '未训练模型输出（二分类）', '1', '5', 'com-output.char.ml.algorithm.0001.01', '0', null, '0', '2017-05-31 15:09:31', 'admin', '2017-05-31 15:09:31', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('610', '未训练模型输出（二分类）', '1', '6', 'com-output.char.ml.algorithm.0002.01', '0', null, '0', '2017-05-31 15:28:16', 'admin', '2017-05-31 15:28:16', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('710', '未训练模型输出（二分类）', '1', '7', 'com-output.char.ml.algorithm.0003.01', '0', null, '0', '2017-05-31 15:29:46', 'admin', '2017-05-31 15:29:46', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('810', '未训练模型输出（回归模型）', '1', '8', 'com-output.char.ml.algorithm.0005.01', '0', null, '0', '2017-05-31 15:36:48', 'admin', '2017-05-31 15:36:48', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('910', '未训练模型输出（回归模型）', '1', '9', 'com-output.char.ml.algorithm.0006.01', '0', null, '0', '2017-05-31 15:38:08', 'admin', '2017-05-31 15:38:08', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1000', '未训练模型输入', '0', '10', 'com-input.char.ml.train.0001.01', '0', null, '0', '2017-05-31 15:38:49', 'admin', '2017-05-31 15:38:49', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1001', '训练数据输入', '0', '10', 'com-input.char.ml.train.0001.02', '1', null, '0', '2017-05-31 15:38:49', 'admin', '2017-05-31 15:38:49', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1010', '已训练模型输出', '1', '10', 'com-output.char.ml.train.0001.01', '0', null, '0', '2017-05-31 15:39:14', 'admin', '2017-05-31 15:39:14', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1100', '已训练模型输入', '0', '11', 'com-input.char.ml.predict.0001.01', '0', null, '0', '2017-05-31 15:38:49', 'admin', '2017-05-31 15:38:49', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1101', '预测数据输入', '0', '11', 'com-input.char.ml.predict.0001.02', '1', null, '0', '2017-05-31 15:38:49', 'admin', '2017-05-31 15:38:49', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1110', '预测结果输出', '1', '11', 'com-output.char.ml.predict.0001.01', '0', null, '0', '2017-05-31 15:39:14', 'admin', '2017-05-31 15:39:14', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1200', '预测结果输入（二分类）', '0', '12', 'com-input.char.ml.evaluate.0001.01', '0', null, '0', '2017-05-31 15:39:42', 'admin', '2017-05-31 15:39:42', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1300', '预测结果输入（回归模型）', '0', '13', 'com-input.char.ml.evaluate.0004.01', '0', null, '0', '2017-05-31 15:55:05', 'admin', '2017-05-31 15:55:05', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1400', '数据输入', '0', '14', 'com-input.char.dp.sample.0001.01', '0', null, '0', '2017-05-27 20:44:40', 'admin', '2017-05-27 20:44:40', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1410', '数据输出', '1', '14', 'com-output.char.dp.sample.0001.01', '0', null, '0', '2017-05-27 20:55:27', 'admin', '2017-05-27 20:55:27', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1500', '数据输入', '0', '15', 'com-input.char.dp.sample.0002.01', '0', null, '0', '2017-05-27 20:44:40', 'admin', '2017-05-27 20:44:40', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1510', '数据输出', '1', '15', 'com-output.char.dp.sample.0002.01', '0', null, '0', '2017-05-27 20:55:27', 'admin', '2017-05-27 20:55:27', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1600', '数据输入', '0', '16', 'com-input.char.dp.sample.0003.01', '0', null, '0', '2017-05-27 20:44:40', 'admin', '2017-05-27 20:44:40', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1610', '数据输出', '1', '16', 'com-output.char.dp.sample.0003.01', '0', null, '0', '2017-05-27 20:55:27', 'admin', '2017-05-27 20:55:27', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1700', '数据输入', '0', '17', 'com-input.char.dp.sample.0004.01', '0', null, '0', '2017-05-27 20:44:40', 'admin', '2017-05-27 20:44:40', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1710', '数据输出', '1', '17', 'com-output.char.dp.sample.0004.01', '0', null, '0', '2017-05-27 20:55:27', 'admin', '2017-05-27 20:55:27', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1800', '数据输入', '0', '18', 'com-input.char.dp.transform.0001.01', '0', null, '0', '2017-05-27 20:44:40', 'admin', '2017-05-27 20:44:40', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1810', '数据输出', '1', '18', 'com-output.char.dp.transform.0001.01', '0', null, '0', '2017-05-27 20:55:27', 'admin', '2017-05-27 20:55:27', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1900', '数据输入', '0', '19', 'com-input.char.dp.split.0001.01', '0', null, '0', '2017-05-27 20:44:40', 'admin', '2017-05-27 20:44:40', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1910', '数据输出', '1', '19', 'com-output.char.dp.split.0001.01', '0', null, '0', '2017-05-27 20:55:27', 'admin', '2017-05-27 20:55:27', 'admin');
INSERT INTO `wf_cfg_module_port` VALUES ('1911', '数据输出', '1', '19', 'com-output.char.dp.split.0001.02', '0', null, '0', '2017-05-27 20:55:27', 'admin', '2017-05-27 20:55:27', 'admin');

-- ----------------------------
-- Table structure for wf_cfg_specification
-- ----------------------------
DROP TABLE IF EXISTS `wf_cfg_specification`;
CREATE TABLE `wf_cfg_specification` (
  `SPEC_ID` varchar(200) NOT NULL COMMENT '规格ID',
  `SPEC_NAME` varchar(200) NOT NULL COMMENT '规格名称',
  `SPEC_TYPE` int(11) NOT NULL COMMENT '规格类型\r\n            0：input，输入内容规格（无此类规格代表无输入内容）\r\n            1：output，输出内容规格（无此类规格代表无输出内容）\r\n            2：execution，调用执行规格（无此类规格代表无需执行）\r\n            3：optimize execution，执行调优参数规格（无此类规格代表无执行调优参数）\r\n            4：parameter，组件参数规格（无此类规格代表组件参数）',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SPEC_ID`),
  UNIQUE KEY `Index_2` (`SPEC_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件规格表，同一组件规格下组件特征代码不能冲突';

-- ----------------------------
-- Records of wf_cfg_specification
-- ----------------------------
INSERT INTO `wf_cfg_specification` VALUES ('com-exec.spec.spark.0001', '调用执行 | Spark | Spark On Yarn', '2', '基于Spark计算框架的组件调用执行规格', '0', '2017-05-17 15:08:09', 'admin', '2017-05-17 15:08:09', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-input.spec.dp.sample.0001', '输入内容 | 数据预处理 | 随机采样', '0', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-input.spec.dp.sample.0002', '输入内容 | 数据预处理 | 加权采样', '0', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-input.spec.dp.sample.0003', '输入内容 | 数据预处理 | 均衡采样', '0', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-input.spec.dp.sample.0004', '输入内容 | 数据预处理 | 分层采样', '0', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-input.spec.dp.split.0001', '输入内容 | 数据预处理 | 数据拆分', '0', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-input.spec.dp.transform.0001', '输入内容 | 数据预处理 | 类型转换', '0', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-input.spec.io.write.0001', '输入内容 | 输入输出 | 数据表写入', '0', null, '0', '2019-03-07 14:48:04', 'admin', '2019-03-07 14:48:04', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-input.spec.ml.cross-validate.0001', '输入内容 | 机器学习 | 模型交叉验证', '0', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-input.spec.ml.evaluate.0001', '输入内容 | 机器学习 | 模型评估 - 二分类', '0', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-input.spec.ml.evaluate.0002', '输入内容 | 机器学习 | 模型评估 - 多分类', '0', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-input.spec.ml.evaluate.0003', '输入内容 | 机器学习 | 模型评估 - 聚类', '0', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-input.spec.ml.evaluate.0004', '输入内容 | 机器学习 | 模型评估 - 回归', '0', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-input.spec.ml.predict.0001', '输入内容 | 机器学习 | 模型预测', '0', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-input.spec.ml.train.0001', '输入内容 | 机器学习 | 模型训练', '0', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-input.spec.ml.tune.0001', '输入内容 | 机器学习 | 模型自动调参', '0', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-input.spec.st.sql.0001', '输入内容 | 脚本工具 | SQL脚本', '0', null, '0', '2019-03-07 15:01:39', 'admin', '2019-03-07 15:01:39', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-o-exec.spec.spark.0001', '执行调优 | Spark | Spark执行优化', '3', '基于Spark计算框架的组件执行调优规格', '0', '2017-05-17 15:10:21', 'admin', '2017-05-17 15:10:21', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.dp.sample.0001', '输出内容 | 数据预处理 | 随机采样', '1', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.dp.sample.0002', '输出内容 | 数据预处理 | 加权采样', '1', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.dp.sample.0003', '输出内容 | 数据预处理 | 均衡采样', '1', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.dp.sample.0004', '输出内容 | 数据预处理 | 分层采样', '1', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.dp.split.0001', '输出内容 | 数据预处理 | 数据拆分', '1', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.dp.transform.0001', '输出内容 | 数据预处理 | 类型转换', '1', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.io.import.0001', '输出内容 | 输入输出 | 数据文件导入', '1', null, '0', '2019-03-07 14:48:04', 'admin', '2019-03-07 14:48:04', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.io.read.0001', '输出内容 | 输入输出 | 数据表读取', '1', null, '0', '2019-03-07 14:48:04', 'admin', '2019-03-07 14:48:04', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.io.read.0002', '输出内容 | 输入输出 | 模型读取', '1', null, '0', '2019-03-07 14:48:04', 'admin', '2019-03-07 14:48:04', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.ml.algorithm.0001', '输出内容 | 机器学习 | 算法 - 逻辑回归二分类', '1', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.ml.algorithm.0002', '输出内容 | 机器学习 | 算法 - 随机森林二分类', '1', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.ml.algorithm.0003', '输出内容 | 机器学习 | 算法 - GBDT二分类', '1', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.ml.algorithm.0004', '输出内容 | 机器学习 | 算法 - 线性SVM二分类', '1', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.ml.algorithm.0005', '输出内容 | 机器学习 | 算法 - 线性回归', '1', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.ml.algorithm.0006', '输出内容 | 机器学习 | 算法 - GBDT回归', '1', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.ml.cross-validate.0001', '输出内容 | 机器学习 | 模型交叉验证', '1', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.ml.evaluate.0001', '输出内容 | 机器学习 | 模型评估 - 二分类', '1', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.ml.evaluate.0002', '输出内容 | 机器学习 | 模型评估 - 多分类', '1', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.ml.evaluate.0003', '输出内容 | 机器学习 | 模型评估 - 聚类', '1', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.ml.evaluate.0004', '输出内容 | 机器学习 | 模型评估 - 回归', '1', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.ml.predict.0001', '输出内容 | 机器学习 | 模型预测', '1', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.ml.train.0001', '输出内容 | 机器学习 | 模型训练', '1', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.ml.tune.0001', '输出内容 | 机器学习 | 模型自动调参', '1', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-output.spec.st.sql.0001', '输出内容 | 脚本工具 | SQL脚本', '1', null, '0', '2019-03-07 15:01:39', 'admin', '2019-03-07 15:01:39', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.dp.sample.0001', '组件参数 | 数据预处理 | 随机采样', '4', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.dp.sample.0002', '组件参数 | 数据预处理 | 加权采样', '4', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.dp.sample.0003', '组件参数 | 数据预处理 | 均衡采样', '4', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.dp.sample.0004', '组件参数 | 数据预处理 | 分层采样', '4', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.dp.split.0001', '组件参数 | 数据预处理 | 数据拆分', '4', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.dp.transform.0001', '组件参数 | 数据预处理 | 类型转换', '4', null, '0', '2019-03-07 15:16:44', 'admin', '2019-03-07 15:16:44', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.io.import.0001', '组件参数 | 输入输出 | 数据文件导入', '4', null, '0', '2019-03-07 14:48:04', 'admin', '2019-03-07 14:48:04', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.io.read.0001', '组件参数 | 输入输出 | 数据表读取', '4', null, '0', '2019-03-07 14:48:04', 'admin', '2019-03-07 14:48:04', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.io.read.0002', '组件参数 | 输入输出 | 模型读取', '4', null, '0', '2019-03-07 14:48:04', 'admin', '2019-03-07 14:48:04', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.io.write.0001', '组件参数 | 输入输出 | 数据表写入', '4', null, '0', '2019-03-07 14:48:04', 'admin', '2019-03-07 14:48:04', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.ml.algorithm.0001', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类', '4', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.ml.algorithm.0002', '组件参数 | 机器学习 | 算法 - 随机森林二分类', '4', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.ml.algorithm.0003', '组件参数 | 机器学习 | 算法 - GBDT二分类', '4', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.ml.algorithm.0004', '组件参数 | 机器学习 | 算法 - 线性SVM二分类', '4', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.ml.algorithm.0005', '组件参数 | 机器学习 | 算法 - 线性回归', '4', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.ml.algorithm.0006', '组件参数 | 机器学习 | 算法 - GBDT回归', '4', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.ml.cross-validate.0001', '组件参数 | 机器学习 | 模型交叉验证', '4', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.ml.evaluate.0001', '组件参数 | 机器学习 | 模型评估 - 二分类', '4', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.ml.evaluate.0002', '组件参数 | 机器学习 | 模型评估 - 多分类', '4', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.ml.evaluate.0003', '组件参数 | 机器学习 | 模型评估 - 聚类', '4', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.ml.evaluate.0004', '组件参数 | 机器学习 | 模型评估 - 回归', '4', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.ml.predict.0001', '组件参数 | 机器学习 | 模型预测', '4', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.ml.train.0001', '组件参数 | 机器学习 | 模型训练', '4', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.ml.tune.0001', '组件参数 | 机器学习 | 模型自动调参', '4', null, '0', '2019-03-07 14:50:46', 'admin', '2019-03-07 14:50:46', 'admin');
INSERT INTO `wf_cfg_specification` VALUES ('com-param.spec.st.sql.0001', '组件参数 | 脚本工具 | SQL脚本', '4', null, '0', '2019-03-07 15:01:39', 'admin', '2019-03-07 15:01:39', 'admin');

-- ----------------------------
-- Table structure for wf_cfg_spec_char_rel
-- ----------------------------
DROP TABLE IF EXISTS `wf_cfg_spec_char_rel`;
CREATE TABLE `wf_cfg_spec_char_rel` (
  `SPEC_ID` varchar(200) NOT NULL COMMENT '规格ID',
  `CHAR_ID` varchar(200) NOT NULL COMMENT '特征ID',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SPEC_ID`,`CHAR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件规格使用特征表，要求同一规格下特征代码唯一';

-- ----------------------------
-- Records of wf_cfg_spec_char_rel
-- ----------------------------
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-exec.spec.spark.0001', 'com-exec.char.engine.$001', '调用执行 | Spark | Spark On Yarn，引擎类型', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-exec.spec.spark.0001', 'com-exec.char.spark.0001', '调用执行 | Spark | Spark On Yarn，spark组件jar库目录', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-exec.spec.spark.0001', 'com-exec.char.spark.0002', '调用执行 | Spark | Spark On Yarn，spark组件jar包文件名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-exec.spec.spark.0001', 'com-exec.char.spark.0003', '调用执行 | Spark | Spark On Yarn，spark组件类', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.dp.sample.0001', 'com-input.char.dp.sample.0001.01', '输入内容 | 数据预处理 | 随机采样，采样输入t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.dp.sample.0002', 'com-input.char.dp.sample.0002.01', '输入内容 | 数据预处理 | 加权采样，采样输入t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.dp.sample.0003', 'com-input.char.dp.sample.0003.01', '输入内容 | 数据预处理 | 均衡采样，采样输入t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.dp.sample.0004', 'com-input.char.dp.sample.0004.01', '输入内容 | 数据预处理 | 分层采样，采样输入t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.dp.split.0001', 'com-input.char.dp.split.0001.01', '输入内容 | 数据预处理 | 数据拆分，拆分输入t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.dp.transform.0001', 'com-input.char.dp.transform.0001.01', '输入内容 | 数据预处理 | 类型转换，转换输入t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.io.write.0001', 'com-input.char.io.write.0001.01', '输入内容 | 输入输出 | 数据表写入，输入数据表t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.ml.cross-validate.0001', 'com-input.char.ml.cross-validate.0001.01', '输入内容 | 机器学习 | 模型交叉验证，未训练模型a1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.ml.cross-validate.0001', 'com-input.char.ml.cross-validate.0001.02', '输入内容 | 机器学习 | 模型交叉验证，样本数据集t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.ml.evaluate.0001', 'com-input.char.ml.evaluate.0001.01', '输入内容 | 机器学习 | 模型评估 - 二分类，预测结果集t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.ml.evaluate.0002', 'com-input.char.ml.evaluate.0002.01', '输入内容 | 机器学习 | 模型评估 - 多分类，预测结果集t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.ml.evaluate.0003', 'com-input.char.ml.evaluate.0003.01', '输入内容 | 机器学习 | 模型评估 - 聚类，已训练聚类模型m1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.ml.evaluate.0003', 'com-input.char.ml.evaluate.0003.02', '输入内容 | 机器学习 | 模型评估 - 聚类，评估数据集t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.ml.evaluate.0004', 'com-input.char.ml.evaluate.0004.01', '输入内容 | 机器学习 | 模型评估 - 回归，预测结果集t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.ml.predict.0001', 'com-input.char.ml.predict.0001.01', '输入内容 | 机器学习 | 模型预测，已训练模型m1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.ml.predict.0001', 'com-input.char.ml.predict.0001.02', '输出内容 | 机器学习 | 模型预测，预测数据集t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.ml.train.0001', 'com-input.char.ml.train.0001.01', '输入内容 | 机器学习 | 模型训练，未训练模型a1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.ml.train.0001', 'com-input.char.ml.train.0001.02', '输入内容 | 机器学习 | 模型训练，训练数据集t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.ml.tune.0001', 'com-input.char.ml.tune.0001.01', '输入内容 | 机器学习 | 模型自动调参，未训练模型a1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.ml.tune.0001', 'com-input.char.ml.tune.0001.02', '输入内容 | 机器学习 | 模型自动调参，训练数据集t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.ml.tune.0001', 'com-input.char.ml.tune.0001.03', '输入内容 | 机器学习 | 模型自动调参，验证数据集t2', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.st.sql.0001', 'com-input.char.st.sql.0001.01', '输入内容 | 脚本工具 | SQL脚本，数据表t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.st.sql.0001', 'com-input.char.st.sql.0001.02', '输入内容 | 脚本工具 | SQL脚本，数据表t2', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.st.sql.0001', 'com-input.char.st.sql.0001.03', '输入内容 | 脚本工具 | SQL脚本，数据表t3', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-input.spec.st.sql.0001', 'com-input.char.st.sql.0001.04', '输入内容 | 脚本工具 | SQL脚本，数据表t4', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-o-exec.spec.spark.0001', 'com-o-exec.char.spark.0001', '执行调优 | Spark | Spark执行优化，spark.executor.number', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-o-exec.spec.spark.0001', 'com-o-exec.char.spark.0002', '执行调优 | Spark | Spark执行优化，spark.executor.cores', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-o-exec.spec.spark.0001', 'com-o-exec.char.spark.0003', '执行调优 | Spark | Spark执行优化，spark.executor.memory', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-o-exec.spec.spark.0001', 'com-o-exec.char.spark.0004', '执行调优 | Spark | Spark执行优化，spark.driver.cores', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-o-exec.spec.spark.0001', 'com-o-exec.char.spark.0005', '执行调优 | Spark | Spark执行优化，spark.driver.memory', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.dp.sample.0001', 'com-output.char.dp.sample.0001.01', '输出内容 | 数据预处理 | 随机采样，采样输出t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.dp.sample.0002', 'com-output.char.dp.sample.0002.01', '输出内容 | 数据预处理 | 加权采样，采样输出t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.dp.sample.0003', 'com-output.char.dp.sample.0003.01', '输出内容 | 数据预处理 | 均衡采样，采样输出t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.dp.sample.0004', 'com-output.char.dp.sample.0004.01', '输出内容 | 数据预处理 | 分层采样，采样输出t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.dp.split.0001', 'com-output.char.dp.split.0001.01', '输出内容 | 数据预处理 | 数据拆分，拆分输出t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.dp.split.0001', 'com-output.char.dp.split.0001.02', '输出内容 | 数据预处理 | 数据拆分，拆分输出t2', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.dp.transform.0001', 'com-output.char.dp.transform.0001.01', '输出内容 | 数据预处理 | 类型转换，转换输出t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.io.import.0001', 'com-output.char.io.import.0001.01', '输出内容 | 输入输出 | 数据文件导入，目标数据表t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.io.read.0001', 'com-output.char.io.read.0001.01', '输出内容 | 输入输出 | 数据表读取，输出数据表t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.io.read.0002', 'com-output.char.io.read.0002.01', '输出内容 | 输入输出 | 模型读取，输出模型m1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.ml.algorithm.0001', 'com-output.char.ml.algorithm.0001.01', '输出内容 | 机器学习 | 算法 - 逻辑回归二分类， 输出二分类算法a1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.ml.algorithm.0002', 'com-output.char.ml.algorithm.0002.01', '输出内容 | 机器学习 | 算法 - 随机森林二分类， 输出二分类算法a1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.ml.algorithm.0003', 'com-output.char.ml.algorithm.0003.01', '输出内容 | 机器学习 | 算法 - GBDT二分类， 输出二分类算法a1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.ml.algorithm.0004', 'com-output.char.ml.algorithm.0004.01', '输出内容 | 机器学习 | 算法 - 线性SVM二分类， 输出二分类算法a1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.ml.algorithm.0005', 'com-output.char.ml.algorithm.0005.01', '输出内容 | 机器学习 | 算法 - 线性回归， 输出回归算法a1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.ml.algorithm.0006', 'com-output.char.ml.algorithm.0006.01', '输出内容 | 机器学习 | 算法 - GBDT回归， 输出回归算法a1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.ml.cross-validate.0001', 'com-output.char.ml.cross-validate.0001.01', '组件参数 | 机器学习 | 模型交叉验证，交叉验证报告r1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.ml.evaluate.0001', 'com-output.char.ml.evaluate.0001.01', '输出内容 | 机器学习 | 模型评估 - 二分类，评估报告r1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.ml.evaluate.0002', 'com-output.char.ml.evaluate.0002.01', '输出内容 | 机器学习 | 模型评估 - 多分类，评估报告r1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.ml.evaluate.0003', 'com-output.char.ml.evaluate.0003.01', '输出内容 | 机器学习 | 模型评估 - 聚类，评估报告r1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.ml.evaluate.0004', 'com-output.char.ml.evaluate.0004.01', '输出内容 | 机器学习 | 模型评估 - 回归，评估报告r1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.ml.predict.0001', 'com-output.char.ml.predict.0001.01', '组件参数 | 机器学习 | 模型预测，预测结果集t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.ml.train.0001', 'com-output.char.ml.train.0001.01', '输出内容 | 机器学习 | 模型训练，已训练模型m1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.ml.tune.0001', 'com-output.char.ml.tune.0001.01', '输出内容 | 机器学习 | 模型自动调参，最优模型m1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.ml.tune.0001', 'com-output.char.ml.tune.0001.02', '输出内容 | 机器学习 | 模型自动调参，调参报告r1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-output.spec.st.sql.0001', 'com-output.char.st.sql.0001.01', '输出内容 | 脚本工具 | SQL脚本，数据表t1', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0001', 'com-param.char.dp.sample.$001', '组件参数 | 数据预处理 | 随机采样，采样方式', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0001', 'com-param.char.dp.sample.0001.01', '组件参数 | 数据预处理 | 随机采样，采样个数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0001', 'com-param.char.dp.sample.0001.02', '组件参数 | 数据预处理 | 随机采样，采样比例', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0001', 'com-param.char.dp.sample.0001.03', '组件参数 | 数据预处理 | 随机采样，是否放回采样', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0001', 'com-param.char.dp.sample.0001.04', '组件参数 | 数据预处理 | 随机采样，随机数种子', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0002', 'com-param.char.dp.sample.$001', '组件参数 | 数据预处理 | 加权采样，采样方式', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0002', 'com-param.char.dp.sample.0002.01', '组件参数 | 数据预处理 | 加权采样，采样个数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0002', 'com-param.char.dp.sample.0002.02', '组件参数 | 数据预处理 | 加权采样，采样比例', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0002', 'com-param.char.dp.sample.0002.03', '组件参数 | 数据预处理 | 加权采样，是否放回采样', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0002', 'com-param.char.dp.sample.0002.04', '组件参数 | 数据预处理 | 加权采样，随机数种子', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0002', 'com-param.char.dp.sample.0002.05', '组件参数 | 数据预处理 | 加权采样，权重列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0003', 'com-param.char.dp.sample.$001', '组件参数 | 数据预处理 | 均衡采样，采样方式', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0003', 'com-param.char.dp.sample.0003.01', '组件参数 | 数据预处理 | 均衡采样，采样个数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0003', 'com-param.char.dp.sample.0003.02', '组件参数 | 数据预处理 | 均衡采样，采样比例', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0003', 'com-param.char.dp.sample.0003.03', '组件参数 | 数据预处理 | 均衡采样，目标列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0003', 'com-param.char.dp.sample.0003.04', '组件参数 | 数据预处理 | 均衡采样，随机数种子', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0004', 'com-param.char.dp.sample.$001', '组件参数 | 数据预处理 | 分层采样，采样方式', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0004', 'com-param.char.dp.sample.0004.01', '组件参数 | 数据预处理 | 分层采样，采样个数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0004', 'com-param.char.dp.sample.0004.02', '组件参数 | 数据预处理 | 分层采样，采样比例', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0004', 'com-param.char.dp.sample.0004.03', '组件参数 | 数据预处理 | 分层采样，是否放回采样', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0004', 'com-param.char.dp.sample.0004.04', '组件参数 | 数据预处理 | 分层采样，分组列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.sample.0004', 'com-param.char.dp.sample.0004.05', '组件参数 | 数据预处理 | 分层采样，随机数种子', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.split.0001', 'com-param.char.dp.split.0001.01', '组件参数 | 数据预处理 | 数据拆分，拆分方式', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.split.0001', 'com-param.char.dp.split.0001.02', '组件参数 | 数据预处理 | 数据拆分，拆分比例', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.split.0001', 'com-param.char.dp.split.0001.03', '组件参数 | 数据预处理 | 数据拆分，拆分阈值', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.split.0001', 'com-param.char.dp.split.0001.04', '组件参数 | 数据预处理 | 数据拆分，阈值列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.split.0001', 'com-param.char.dp.split.0001.05', '组件参数 | 数据预处理 | 数据拆分，随机数种子', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.transform.0001', 'com-param.char.dp.transform.0001.01', '组件参数 | 数据预处理 | 类型转换，默认double填充值', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.transform.0001', 'com-param.char.dp.transform.0001.02', '组件参数 | 数据预处理 | 类型转换，默认long填充值', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.transform.0001', 'com-param.char.dp.transform.0001.03', '组件参数 | 数据预处理 | 类型转换，默认string填充值', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.transform.0001', 'com-param.char.dp.transform.0001.04', '组件参数 | 数据预处理 | 类型转换，转换为double类型列', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.transform.0001', 'com-param.char.dp.transform.0001.05', '组件参数 | 数据预处理 | 类型转换，转换为long类型列', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.transform.0001', 'com-param.char.dp.transform.0001.06', '组件参数 | 数据预处理 | 类型转换，转换为string类型列', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.dp.transform.0001', 'com-param.char.dp.transform.0001.07', '组件参数 | 数据预处理 | 类型转换，是否保留原始列', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.io.import.0001', 'com-param.char.io.import.0001.01', '组件参数 | 输入输出 | 数据文件导入，文件类型', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.io.import.0001', 'com-param.char.io.import.0001.02', '组件参数 | 输入输出 | 数据文件导入，文件路径', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.io.import.0001', 'com-param.char.io.import.0001.03', '组件参数 | 输入输出 | 数据文件导入，列分隔符', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.io.import.0001', 'com-param.char.io.import.0001.04', '组件参数 | 输入输出 | 数据文件导入，行分隔符', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.io.import.0001', 'com-param.char.io.import.0001.05', '组件参数 | 输入输出 | 数据文件导入，字符编码', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.io.import.0001', 'com-param.char.io.import.0001.06', '组件参数 | 输入输出 | 数据文件导入，首行是否为字段标题', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.io.import.0001', 'com-param.char.io.import.0001.07', '组件参数 | 输入输出 | 数据文件导入，字段描述列表', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.io.import.0001', 'com-param.char.io.import.0001.08', '组件参数 | 输入输出 | 数据文件导入，字段类型异常处理', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.io.import.0001', 'com-param.char.io.import.0001.09', '组件参数 | 输入输出 | 数据文件导入，列数异常处理', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.io.import.0001', 'com-param.char.io.import.0001.10', '组件参数 | 输入输出 | 数据文件导入，数据表名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.io.read.0001', 'com-param.char.io.read.0001.01', '组件参数 | 输入输出 | 数据表读取，数据表名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.io.read.0002', 'com-param.char.io.read.0002.01', '组件参数 | 输入输出 | 模型读取，模型ID', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.io.write.0001', 'com-param.char.io.write.0001.01', '组件参数 | 输入输出 | 数据表写入，数据表名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0001', 'com-param.char.ml.algorithm.$001', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类，正则项', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0001', 'com-param.char.ml.algorithm.0001.01', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类，最大迭代次数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0001', 'com-param.char.ml.algorithm.0001.02', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类，最小收敛误差', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0001', 'com-param.char.ml.algorithm.0001.03', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类，正则L1系数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0001', 'com-param.char.ml.algorithm.0001.04', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类，正则L2系数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0001', 'com-param.char.ml.algorithm.0001.05', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类，正样本标签值', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0001', 'com-param.char.ml.tune.$001', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类，调参类型', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0001', 'com-param.char.ml.tune.$002', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类，迭代次数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0001', 'com-param.char.ml.tune.$003', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类，网格拆分数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0001', 'com-param.char.ml.tune.$004', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类，搜索样本数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0001', 'com-param.char.ml.tune.$005', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类，搜索次数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0001', 'com-param.char.ml.tune.$006', '组件参数 | 机器学习 | 算法 - 逻辑回归二分类，收敛系数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0002', 'com-param.char.ml.algorithm.0002.01', '组件参数 | 机器学习 | 算法 - 随机森林二分类，森林中树的个数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0002', 'com-param.char.ml.algorithm.0002.02', '组件参数 | 机器学习 | 算法 - 随机森林二分类，单颗树的随机特征数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0002', 'com-param.char.ml.algorithm.0002.03', '组件参数 | 机器学习 | 算法 - 随机森林二分类，叶节点最少记录数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0002', 'com-param.char.ml.algorithm.0002.04', '组件参数 | 机器学习 | 算法 - 随机森林二分类，单颗树的最大深度', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0002', 'com-param.char.ml.algorithm.0002.05', '组件参数 | 机器学习 | 算法 - 随机森林二分类，单颗树的采样率', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0002', 'com-param.char.ml.algorithm.0002.06', '组件参数 | 机器学习 | 算法 - 随机森林二分类，正样本标签值', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0002', 'com-param.char.ml.tune.$001', '组件参数 | 机器学习 | 算法 - 随机森林二分类，调参类型', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0002', 'com-param.char.ml.tune.$002', '组件参数 | 机器学习 | 算法 - 随机森林二分类，迭代次数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0002', 'com-param.char.ml.tune.$003', '组件参数 | 机器学习 | 算法 - 随机森林二分类，网格拆分数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0002', 'com-param.char.ml.tune.$004', '组件参数 | 机器学习 | 算法 - 随机森林二分类，搜索样本数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0002', 'com-param.char.ml.tune.$005', '组件参数 | 机器学习 | 算法 - 随机森林二分类，搜索次数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0002', 'com-param.char.ml.tune.$006', '组件参数 | 机器学习 | 算法 - 随机森林二分类，收敛系数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0003', 'com-param.char.ml.algorithm.0003.01', '组件参数 | 机器学习 | 算法 - GBDT二分类，最大迭代次数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0003', 'com-param.char.ml.algorithm.0003.02', '组件参数 | 机器学习 | 算法 - GBDT二分类，学习速率', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0003', 'com-param.char.ml.algorithm.0003.03', '组件参数 | 机器学习 | 算法 - GBDT二分类，叶节点最少记录数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0003', 'com-param.char.ml.algorithm.0003.04', '组件参数 | 机器学习 | 算法 - GBDT二分类，单颗树的最大深度', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0003', 'com-param.char.ml.algorithm.0003.05', '组件参数 | 机器学习 | 算法 - GBDT二分类，单颗树的采样率', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0003', 'com-param.char.ml.algorithm.0003.06', '组件参数 | 机器学习 | 算法 - GBDT二分类，正样本标签值', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0003', 'com-param.char.ml.tune.$001', '组件参数 | 机器学习 | 算法 - GBDT二分类，调参类型', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0003', 'com-param.char.ml.tune.$002', '组件参数 | 机器学习 | 算法 - GBDT二分类，迭代次数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0003', 'com-param.char.ml.tune.$003', '组件参数 | 机器学习 | 算法 - GBDT二分类，网格拆分数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0003', 'com-param.char.ml.tune.$004', '组件参数 | 机器学习 | 算法 - GBDT二分类，搜索样本数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0003', 'com-param.char.ml.tune.$005', '组件参数 | 机器学习 | 算法 - GBDT二分类，搜索次数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0003', 'com-param.char.ml.tune.$006', '组件参数 | 机器学习 | 算法 - GBDT二分类，收敛系数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0005', 'com-param.char.ml.algorithm.$001', '组件参数 | 机器学习 | 算法 - 线性回归，正则项', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0005', 'com-param.char.ml.algorithm.0005.01', '组件参数 | 机器学习 | 算法 - 线性回归，最大迭代次数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0005', 'com-param.char.ml.algorithm.0005.02', '组件参数 | 机器学习 | 算法 - 线性回归，最小收敛误差', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0005', 'com-param.char.ml.algorithm.0005.03', '组件参数 | 机器学习 | 算法 - 线性回归，正则L1系数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0005', 'com-param.char.ml.algorithm.0005.04', '组件参数 | 机器学习 | 算法 - 线性回归，正则L2系数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0005', 'com-param.char.ml.tune.$001', '组件参数 | 机器学习 | 算法 - 线性回归，调参类型', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0005', 'com-param.char.ml.tune.$002', '组件参数 | 机器学习 | 算法 - 线性回归，迭代次数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0005', 'com-param.char.ml.tune.$003', '组件参数 | 机器学习 | 算法 - 线性回归，网格拆分数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0005', 'com-param.char.ml.tune.$004', '组件参数 | 机器学习 | 算法 - 线性回归，搜索样本数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0005', 'com-param.char.ml.tune.$005', '组件参数 | 机器学习 | 算法 - 线性回归，搜索次数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0005', 'com-param.char.ml.tune.$006', '组件参数 | 机器学习 | 算法 - 线性回归，收敛系数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0006', 'com-param.char.ml.algorithm.0006.01', '组件参数 | 机器学习 | 算法 - GBDT回归，损失函数类型', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0006', 'com-param.char.ml.algorithm.0006.02', '组件参数 | 机器学习 | 算法 - GBDT回归，最大迭代次数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0006', 'com-param.char.ml.algorithm.0006.03', '组件参数 | 机器学习 | 算法 - GBDT回归，学习速率', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0006', 'com-param.char.ml.algorithm.0006.04', '组件参数 | 机器学习 | 算法 - GBDT回归，叶节点最少记录数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0006', 'com-param.char.ml.algorithm.0006.05', '组件参数 | 机器学习 | 算法 - GBDT回归，单颗树的最大深度', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0006', 'com-param.char.ml.algorithm.0006.06', '组件参数 | 机器学习 | 算法 - GBDT回归，单颗树的采样率', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0006', 'com-param.char.ml.tune.$001', '组件参数 | 机器学习 | 算法 - GBDT回归，调参类型', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0006', 'com-param.char.ml.tune.$002', '组件参数 | 机器学习 | 算法 - GBDT回归，迭代次数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0006', 'com-param.char.ml.tune.$003', '组件参数 | 机器学习 | 算法 - GBDT回归，网格拆分数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0006', 'com-param.char.ml.tune.$004', '组件参数 | 机器学习 | 算法 - GBDT回归，搜索样本数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0006', 'com-param.char.ml.tune.$005', '组件参数 | 机器学习 | 算法 - GBDT回归，搜索次数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.algorithm.0006', 'com-param.char.ml.tune.$006', '组件参数 | 机器学习 | 算法 - GBDT回归，收敛系数', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.evaluate.0001', 'com-param.char.ml.evaluate.0001.01', '组件参数 | 机器学习 | 模型评估 - 二分类，原始标签列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.evaluate.0001', 'com-param.char.ml.evaluate.0001.02', '组件参数 | 机器学习 | 模型评估 - 二分类，正样本标签值', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.evaluate.0001', 'com-param.char.ml.evaluate.0001.03', '组件参数 | 机器学习 | 模型评估 - 二分类，预测分数列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.evaluate.0001', 'com-param.char.ml.evaluate.0001.04', '组件参数 | 机器学习 | 模型评估 - 二分类，分段统计分箱数量', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.evaluate.0002', 'com-param.char.ml.evaluate.0002.01', '组件参数 | 机器学习 | 模型评估 - 多分类，标签列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.evaluate.0002', 'com-param.char.ml.evaluate.0002.02', '组件参数 | 机器学习 | 模型评估 - 多分类，预测结果列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.evaluate.0002', 'com-param.char.ml.evaluate.0002.03', '组件参数 | 机器学习 | 模型评估 - 多分类，预测详情列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.evaluate.0004', 'com-param.char.ml.evaluate.0004.01', '组件参数 | 机器学习 | 模型评估 - 回归，原回归值列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.evaluate.0004', 'com-param.char.ml.evaluate.0004.02', '组件参数 | 机器学习 | 模型评估 - 回归，预测分数列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.predict.0001', 'com-param.char.ml.predict.0001.01', '组件参数 | 机器学习 | 模型预测，原样输出列', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.predict.0001', 'com-param.char.ml.predict.0001.02', '组件参数 | 机器学习 | 模型预测，预测结果列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.predict.0001', 'com-param.char.ml.predict.0001.03', '组件参数 | 机器学习 | 模型预测，预测分数列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.predict.0001', 'com-param.char.ml.predict.0001.04', '组件参数 | 机器学习 | 模型预测，预测详情列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.train.0001', 'com-param.char.ml.train.0001.01', '组件参数 | 机器学习 | 模型训练，选择特征列', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.train.0001', 'com-param.char.ml.train.0001.02', '组件参数 | 机器学习 | 模型训练，排除特征列', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.train.0001', 'com-param.char.ml.train.0001.03', '组件参数 | 机器学习 | 模型训练，强制转换列', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.train.0001', 'com-param.char.ml.train.0001.04', '组件参数 | 机器学习 | 模型训练，权重列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.train.0001', 'com-param.char.ml.train.0001.05', '组件参数 | 机器学习 | 模型训练，标签列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.train.0001', 'com-param.char.ml.train.0001.06', '组件参数 | 机器学习 | 模型训练，随机数种子', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.tune.0001', 'com-param.char.ml.tune.0001.01', '组件参数 | 机器学习 | 模型自动调参，选择特征列', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.tune.0001', 'com-param.char.ml.tune.0001.02', '组件参数 | 机器学习 | 模型自动调参，排除特征列', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.tune.0001', 'com-param.char.ml.tune.0001.03', '组件参数 | 机器学习 | 模型自动调参，强制转换列', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.tune.0001', 'com-param.char.ml.tune.0001.04', '组件参数 | 机器学习 | 模型自动调参，权重列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.tune.0001', 'com-param.char.ml.tune.0001.05', '组件参数 | 机器学习 | 模型自动调参，标签列名', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.tune.0001', 'com-param.char.ml.tune.0001.06', '组件参数 | 机器学习 | 模型自动调参，数据拆分比例', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.tune.0001', 'com-param.char.ml.tune.0001.07', '组件参数 | 机器学习 | 模型自动调参，随机数种子', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.tune.0001', 'com-param.char.ml.tune.0001.08', '组件参数 | 机器学习 | 模型自动调参，分类评估标准', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.ml.tune.0001', 'com-param.char.ml.tune.0001.09', '组件参数 | 机器学习 | 模型自动调参，回归评估标准', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');
INSERT INTO `wf_cfg_spec_char_rel` VALUES ('com-param.spec.st.sql.0001', 'com-param.char.st.sql.0001.01', '组件参数 | 脚本工具 | SQL脚本，SQL脚本', '0', '2019-03-09 03:38:31', 'admin', '2019-03-09 03:38:31', 'admin');

-- ----------------------------
-- Table structure for wf_cfg_spec_char_value
-- ----------------------------
DROP TABLE IF EXISTS `wf_cfg_spec_char_value`;
CREATE TABLE `wf_cfg_spec_char_value` (
  `SPEC_ID` varchar(200) NOT NULL COMMENT '规格ID',
  `CHAR_ID` varchar(200) NOT NULL COMMENT '特征ID',
  `IS_SYSTEM_PARAM` int(11) NOT NULL COMMENT '特征值是否为系统参数\r\n            0：否\r\n            1：是',
  `CHAR_VALUE` varchar(2000) DEFAULT NULL COMMENT '特征值',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SPEC_ID`,`CHAR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件规格配置特征值表，预置在组件规格上的组件特征值设定';

-- ----------------------------
-- Records of wf_cfg_spec_char_value
-- ----------------------------
INSERT INTO `wf_cfg_spec_char_value` VALUES ('com-exec.spec.spark.0001', 'com-exec.char.engine.$001', '0', 'Spark On Yarn', 'e.g. spark on yarn', '0', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `wf_cfg_spec_char_value` VALUES ('com-exec.spec.spark.0001', 'com-exec.char.spark.0001', '1', 'CF_HDFS_COMPONENT_JAR_DIR', 'e.g. /user/lambda_mls/lib/scala', '0', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `wf_cfg_spec_char_value` VALUES ('com-exec.spec.spark.0001', 'com-exec.char.spark.0002', '1', 'CF_HDFS_COMPONENT_JAR_FILE', 'e.g. lambda-component-1.0.0.jar', '0', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `wf_cfg_spec_char_value` VALUES ('com-o-exec.spec.spark.0001', 'com-o-exec.char.spark.0001', '1', 'CF_SPARK_EXECUTOR_NUMBER', 'e.g. 2', '0', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `wf_cfg_spec_char_value` VALUES ('com-o-exec.spec.spark.0001', 'com-o-exec.char.spark.0002', '1', 'CF_SPARK_EXECUTOR_CORES', 'e.g. 8', '0', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `wf_cfg_spec_char_value` VALUES ('com-o-exec.spec.spark.0001', 'com-o-exec.char.spark.0003', '1', 'CF_SPARK_EXECUTOR_MEMORY', 'e.g. 2048', '0', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `wf_cfg_spec_char_value` VALUES ('com-o-exec.spec.spark.0001', 'com-o-exec.char.spark.0004', '1', 'CF_SPARK_DRIVER_CORES', 'e.g. 8', '0', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `wf_cfg_spec_char_value` VALUES ('com-o-exec.spec.spark.0001', 'com-o-exec.char.spark.0005', '1', 'CF_SPARK_DRIVER_MEMORY', 'e.g. 1024', '0', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `wf_cfg_spec_char_value` VALUES ('com-o-exec.spec.spark.0001', 'com-o-exec.char.spark.0006', '1', 'CC_SPARK_EXTRA_CONFIGURATION', '预留', '-1', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');

-- ----------------------------
-- Table structure for wf_code_script
-- ----------------------------
DROP TABLE IF EXISTS `wf_code_script`;
CREATE TABLE `wf_code_script` (
  `SCRIPT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '脚本ID',
  `SCRIPT_NAME` varchar(200) NOT NULL COMMENT '脚本名称\r\n            \r\n            由工作流创建：<prefix>_<node_id>_<char_id>',
  `SCRIPT_TYPE` int(11) NOT NULL COMMENT '脚本类型\r\n            1：SQL脚本\r\n            2：Python脚本（预留）\r\n            3：R脚本（预留）\r\n            4：特征抽取脚本（预留）',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `REL_FLOW_ID` bigint(20) NOT NULL COMMENT '关联工作流ID，无关联工作流设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联节点ID，创建脚本的工作流节点，无关联则设为-1',
  `REL_CHAR_ID` varchar(200) NOT NULL DEFAULT '-1' COMMENT '关联特征ID，创建脚本的工作流节点输出特征，无关联则设为-1',
  `SCRIPT_CONTENT` mediumtext COMMENT '脚本内容',
  `SCRIPT_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '脚本状态\r\n            0：空脚本\r\n            1：正常',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SCRIPT_ID`),
  KEY `Index_1` (`OWNER_PROJECT_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_PROJECT_ID`,`SCRIPT_TYPE`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代码脚本表';

-- ----------------------------
-- Records of wf_code_script
-- ----------------------------

-- ----------------------------
-- Table structure for wf_execution_job
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution_job`;
CREATE TABLE `wf_execution_job` (
  `JOB_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '作业ID',
  `JOB_NAME` varchar(200) NOT NULL COMMENT '作业名称，自动生成',
  `JOB_TYPE` int(11) NOT NULL COMMENT '作业类型\r\n            0：全部运行\r\n            1：从此处开始运行\r\n            2：运行到此处\r\n            3：运行该节点\r\n            10：全部运行（小数据试运行）\r\n            11：从此处开始运行（小数据试运行）\r\n            12：运行到此处（小数据试运行）\r\n            13：运行该节点（小数据试运行）\r\n            100：定时调度运行\r\n            101：在线调度运行\r\n            200：数据文件导入',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `REL_FLOW_ID` bigint(20) NOT NULL COMMENT '关联工作流ID，无关联设为-1',
  `REL_SNAPSHOT_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联快照ID',
  `REL_NODE_ID` bigint(20) NOT NULL COMMENT '关联节点ID，填写与触发运行相关的节点ID，无关联则设为-1',
  `JOB_CONTENT` mediumtext COMMENT '作业内容',
  `JOB_DFS_DIR` varchar(800) DEFAULT NULL COMMENT 'DFS作业目录\r\n            \r\n            实验作业：${HDFS_SITE}/${DFS_WORK_ROOT}/proc/<project_id>/<workflow_id>/<job_id>\r\n            其他作业：${HDFS_SITE}/${DFS_WORK_ROOT}/proc/<project_id>/other/<job_id>',
  `JOB_LOCAL_DIR` varchar(800) DEFAULT NULL COMMENT '本地作业目录（预留）\r\n            \r\n            实验作业：${LOCAL_WORK_ROOT}/proc/<project_id>/<workflow_id>/<job_id>\r\n            其他作业：${LOCAL_WORK_ROOT}/proc/<project_id>/other/<job_id>',
  `NEXT_TASK_SEQUENCE` bigint(20) NOT NULL DEFAULT '1' COMMENT '下一任务序号',
  `JOB_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作业时间，指定作业开始处理时间',
  `JOB_START_TIME` datetime DEFAULT NULL COMMENT '作业开始时间',
  `JOB_END_TIME` datetime DEFAULT NULL COMMENT '作业结束时间',
  `JOB_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '作业状态\r\n            0：preparing，准备中\r\n            1：queueing，排队中\r\n            2：running，运行中\r\n            3：success，运行成功\r\n            4：error terminated，出错终止\r\n            5：user terminated，用户终止',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`JOB_ID`),
  KEY `Index_1` (`OWNER_PROJECT_ID`,`REL_FLOW_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_PROJECT_ID`,`JOB_TYPE`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流运行作业表，实验粒度的运行任务，由工作流引擎将其分解为以节点为粒度的运行任务';

-- ----------------------------
-- Records of wf_execution_job
-- ----------------------------

-- ----------------------------
-- Table structure for wf_execution_job_queue
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution_job_queue`;
CREATE TABLE `wf_execution_job_queue` (
  `JOB_ID` bigint(20) NOT NULL COMMENT '作业ID',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `JOB_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作业时间\r\n            \r\n            指定作业的开始处理时间，值来自作业创建时确定和继续执行时更新',
  `JOB_SIGNAL` int(11) NOT NULL DEFAULT '0' COMMENT '作业信号\r\n            0：SIG_NORMAL，正常作业信号\r\n            1：SIG_KILL，终止作业信号\r\n            2：SIG_PAUSE，暂停执行信号\r\n            3：SIG_CONT，继续执行信号',
  `JOB_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '作业状态\r\n            1：queueing，排队中\r\n            2：running，运行中',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`JOB_ID`),
  KEY `Index_1` (`JOB_STATE`,`JOB_SIGNAL`,`JOB_TIME`),
  KEY `Index_2` (`OWNER_PROJECT_ID`,`JOB_STATE`,`CREATE_TIME`),
  KEY `Index_3` (`JOB_STATE`,`JOB_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流运行作业队列表，结束运行后移除';

-- ----------------------------
-- Records of wf_execution_job_queue
-- ----------------------------

-- ----------------------------
-- Table structure for wf_execution_task
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution_task`;
CREATE TABLE `wf_execution_task` (
  `TASK_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `TASK_NAME` varchar(200) NOT NULL COMMENT '任务名称，自动生成',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `OWNER_JOB_ID` bigint(20) NOT NULL COMMENT '所属作业ID',
  `SEQUENCE` bigint(20) NOT NULL DEFAULT '0' COMMENT '作业中任务序号',
  `REL_NODE_ID` bigint(20) NOT NULL COMMENT '关联节点ID',
  `ENGINE_TYPE` varchar(200) DEFAULT 'unknown' COMMENT '计算引擎',
  `EXTERNAL_ID` varchar(800) DEFAULT NULL COMMENT '外部任务ID，比如yarn的application id',
  `TASK_CONTENT` mediumtext COMMENT '任务内容',
  `SUBMIT_FILE` varchar(800) DEFAULT NULL COMMENT '提交文件名，存放在运行目录下\r\n            \r\n            ${JOB_DIR}/submit_<job_id>_<task_id>.json',
  `RETURN_FILE` varchar(800) DEFAULT NULL COMMENT '返回文件名，存放在运行目录下\r\n            \r\n            ${JOB_DIR}/return_<job_id>_<task_id>.json',
  `LOG_FILE` varchar(800) DEFAULT NULL COMMENT '日志文件名，存放在运行目录下\r\n            \r\n            ${JOB_DIR}/log_<job_id>_<task_id>.log',
  `COST_TIME` bigint(20) DEFAULT NULL COMMENT '运行耗时，单位毫秒',
  `TASK_START_TIME` datetime DEFAULT NULL COMMENT '任务开始时间',
  `TASK_END_TIME` datetime DEFAULT NULL COMMENT '任务结束时间',
  `TASK_PROGRESS` int(11) NOT NULL DEFAULT '0' COMMENT '任务进度，百分比数值0到100',
  `WARNING_MSG` varchar(2048) DEFAULT NULL COMMENT '警告消息',
  `TASK_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '任务状态\r\n            0：preparing，准备中\r\n            1：ready，已就绪\r\n            2：running，运行中\r\n            3：success，运行成功\r\n            4：error terminated，出错终止\r\n            5：user terminated，用户终止',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`TASK_ID`),
  UNIQUE KEY `Index_1` (`OWNER_JOB_ID`,`REL_NODE_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_JOB_ID`,`TASK_STATE`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`OWNER_PROJECT_ID`,`TASK_STATE`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流运行任务表';

-- ----------------------------
-- Records of wf_execution_task
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow`;
CREATE TABLE `wf_flow` (
  `FLOW_ID` bigint(20) NOT NULL COMMENT '工作流ID，同实验ID值',
  `FLOW_NAME` varchar(200) NOT NULL COMMENT '工作流名称，自动生成',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `SHARE_LOCK_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '共享锁状态，实验运行和快照期间加锁\r\n            \r\n            0：未加锁\r\n            1：已加锁',
  `SHARE_LOCK_MSG` varchar(512) DEFAULT NULL COMMENT '共享锁消息',
  `NEXT_SNAPSHOT_VERSION` bigint(20) NOT NULL DEFAULT '1' COMMENT '下一快照版本',
  `NODE_COUNT` bigint(20) NOT NULL DEFAULT '0' COMMENT '正常节点计数，超出最大上限后，禁止新增节点',
  `NEXT_DELETE_SEQUENCE` bigint(20) NOT NULL DEFAULT '0' COMMENT '下一删除序号，在0到31之间循环，删除前进，撤销删除后退',
  `LAST_JOB_ID` bigint(20) DEFAULT NULL COMMENT '最后作业ID',
  `FLOW_DFS_DIR` varchar(800) DEFAULT NULL COMMENT 'DFS工作流目录\r\n            \r\n            ${HDFS_SITE}/${DFS_WORK_ROOT}/flow_data/<project_id>/<flow_id>',
  `FLOW_LOCAL_DIR` varchar(800) DEFAULT NULL COMMENT '本地工作流目录\r\n            \r\n            ${LOCAL_WORK_ROOT}/flow_data/<project_id>/<flow_id>',
  `FLOW_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '工作流状态\r\n            0：draft，草稿\r\n            1：preparing，准备中\r\n            2：running，运行中\r\n            3：finished，运行结束',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  `VERSION` bigint(20) NOT NULL DEFAULT '1' COMMENT '版本号，解决同一实验多用户编辑问题',
  PRIMARY KEY (`FLOW_ID`),
  KEY `Index_1` (`OWNER_PROJECT_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_PROJECT_ID`,`FLOW_STATE`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流表，记录实验的工作流内容，由一系列子表记录实验画布上节点和边的图形信息，以及节点参数内容和输出内容';

-- ----------------------------
-- Records of wf_flow
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_accumulate
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_accumulate`;
CREATE TABLE `wf_flow_accumulate` (
  `FLOW_ID` bigint(20) NOT NULL COMMENT '工作流ID',
  `MODULE_ID` bigint(20) NOT NULL COMMENT '工作流组件ID',
  `USAGE_COUNT` bigint(20) NOT NULL DEFAULT '0' COMMENT '使用计数',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  KEY `Index_1` (`FLOW_ID`,`MODULE_ID`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流累计表，记录每个flow使用过的module计数';

-- ----------------------------
-- Records of wf_flow_accumulate
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_node
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node`;
CREATE TABLE `wf_flow_node` (
  `NODE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '节点ID',
  `NODE_NAME` varchar(200) NOT NULL COMMENT '节点名称，自动生成，可编辑',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `OWNER_FLOW_ID` bigint(20) NOT NULL COMMENT '所属工作流ID',
  `REF_MODULE_ID` bigint(20) NOT NULL COMMENT '引用工作流组件ID',
  `SEQUENCE` bigint(20) NOT NULL DEFAULT '0' COMMENT '序号',
  `POSITION_X` bigint(20) NOT NULL DEFAULT '0' COMMENT '流程图节点X轴坐标',
  `POSITION_Y` bigint(20) NOT NULL DEFAULT '0' COMMENT '流程图节点Y轴坐标',
  `LAST_TASK_ID` bigint(20) DEFAULT NULL COMMENT '最后任务ID',
  `WARNING_MSG` varchar(8096) DEFAULT NULL COMMENT '警告消息',
  `NODE_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '节点状态\r\n            0：not ready，未就绪\r\n            1：ready，已就绪\r\n            2：preparing，准备中\r\n            3：running，运行中\r\n            4：success，运行成功\r\n            5：error，运行出错',
  `COMMENT` varchar(800) DEFAULT NULL COMMENT '备注，人工编辑',
  `SUMMARY` varchar(800) DEFAULT NULL COMMENT '概要，自动生成',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_ID`),
  KEY `Index_1` (`OWNER_PROJECT_ID`,`REF_MODULE_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_FLOW_ID`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点表';

-- ----------------------------
-- Records of wf_flow_node
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_node_delete_queue
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_delete_queue`;
CREATE TABLE `wf_flow_node_delete_queue` (
  `FLOW_ID` bigint(20) NOT NULL COMMENT '工作流ID',
  `NODE_ID` bigint(20) NOT NULL COMMENT '节点ID',
  `SEQUENCE` bigint(20) NOT NULL COMMENT '删除序号',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  UNIQUE KEY `Index_2` (`FLOW_ID`,`NODE_ID`),
  KEY `Index_1` (`FLOW_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点删除队列表，一次删除序号可以有多个删除节点，撤销后从队列移除\r\n\r\n每个工作流的删除队列大';

-- ----------------------------
-- Records of wf_flow_node_delete_queue
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_node_link
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_link`;
CREATE TABLE `wf_flow_node_link` (
  `LINK_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '链接ID',
  `LINK_NAME` varchar(400) NOT NULL COMMENT '链接名称，自动生成',
  `OWNER_FLOW_ID` bigint(20) NOT NULL COMMENT '所属工作流ID',
  `SRC_NODE_ID` bigint(20) NOT NULL COMMENT '流出节点ID',
  `SRC_PORT_ID` bigint(20) NOT NULL COMMENT '流出节点端口ID',
  `DST_NODE_ID` bigint(20) NOT NULL COMMENT '流入节点ID',
  `DST_PORT_ID` bigint(20) NOT NULL COMMENT '流入节点端口ID',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`LINK_ID`),
  KEY `Index_1` (`OWNER_FLOW_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`SRC_NODE_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`DST_NODE_ID`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点链接表\r\n\r\n逻辑删除，同一节点流入端口下正常状态的普通组件流出节点端口唯一和web服务组';

-- ----------------------------
-- Records of wf_flow_node_link
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_node_output
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_output`;
CREATE TABLE `wf_flow_node_output` (
  `NODE_ID` bigint(20) NOT NULL COMMENT '节点ID',
  `CHAR_ID` varchar(200) NOT NULL COMMENT '组件特征ID',
  `CHAR_VALUE` varchar(2000) DEFAULT NULL COMMENT '特征值',
  `WARNING_MSG` varchar(512) DEFAULT NULL COMMENT '警告消息',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  KEY `Index_1` (`NODE_ID`,`CHAR_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`NODE_ID`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点输出表，记录输出内容的特征值';

-- ----------------------------
-- Records of wf_flow_node_output
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_node_parameter
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_parameter`;
CREATE TABLE `wf_flow_node_parameter` (
  `NODE_ID` bigint(20) NOT NULL COMMENT '节点ID',
  `SPEC_TYPE` int(11) NOT NULL COMMENT '规格类型，说明参考CF_SPECIFICATION.SPEC_TYPE\r\n            节点上只设置组件参数和调优执行',
  `CHAR_ID` varchar(200) NOT NULL COMMENT '组件特征ID',
  `CHAR_VALUE` varchar(2000) DEFAULT NULL COMMENT '特征值',
  `WARNING_MSG` varchar(512) DEFAULT NULL COMMENT '警告消息',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  KEY `Index_1` (`NODE_ID`,`CHAR_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`NODE_ID`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点设置特征值表，记录组件参数和调优参数的特征值';

-- ----------------------------
-- Records of wf_flow_node_parameter
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_node_port
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_port`;
CREATE TABLE `wf_flow_node_port` (
  `NODE_PORT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '节点端口ID',
  `NODE_PORT_NAME` varchar(200) NOT NULL COMMENT '节点端口名称，自动生成',
  `OWNER_NODE_ID` bigint(20) NOT NULL COMMENT '所属节点ID',
  `REF_PORT_ID` bigint(20) NOT NULL COMMENT '引用组件端口ID',
  `REF_CHAR_ID` varchar(200) NOT NULL COMMENT '引用组件端口ID',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_PORT_ID`),
  UNIQUE KEY `Index_1` (`OWNER_NODE_ID`,`REF_PORT_ID`,`STATUS`,`CREATE_TIME`),
  UNIQUE KEY `Index_2` (`OWNER_NODE_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`OWNER_NODE_ID`,`REF_CHAR_ID`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点端口表';

-- ----------------------------
-- Records of wf_flow_node_port
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_node_schema
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_schema`;
CREATE TABLE `wf_flow_node_schema` (
  `NODE_PORT_ID` bigint(20) NOT NULL COMMENT '节点输出端口ID',
  `SCHEMA_NAME` varchar(200) NOT NULL COMMENT 'schema名称，自动生成',
  `OWNER_NODE_ID` bigint(20) NOT NULL COMMENT '所属节点ID',
  `SCHEMA_CONTENT` mediumtext COMMENT 'schema内容',
  `SCHEMA_STATE` int(11) NOT NULL DEFAULT '0' COMMENT 'schema状态\r\n            0：空schema\r\n            1：正常\r\n            2：不支持\r\n            3：超限中断',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_PORT_ID`),
  KEY `Index_1` (`OWNER_NODE_ID`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点schema表，缓存节点输出端口内容为数据表的字段结构';

-- ----------------------------
-- Records of wf_flow_node_schema
-- ----------------------------

-- ----------------------------
-- Table structure for wf_json_object
-- ----------------------------
DROP TABLE IF EXISTS `wf_json_object`;
CREATE TABLE `wf_json_object` (
  `OBJECT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '对象ID',
  `OBJECT_NAME` varchar(200) NOT NULL COMMENT '对象名称\r\n            \r\n            普通对象：general_<node_id>_<char_id> \r\n            算法参数：algorithm_parameters_<node_id>_<char_id>\r\n            模型评估报告：model_evaluation_report_<node_id>_<char_id>\r\n            统计分析报告：statistical_analysis_report_<node_id>_<char_id>\r\n            自动调参报告：tune_parameters_report_<node_id>_<char_id>\r\n            生成规则报告：generate_rules_report_<node_id>_<char_id>',
  `OBJECT_TYPE` int(11) NOT NULL COMMENT '对象类型\r\n            0：JsonObject&JsonArray（组件参数，仅存放于OBJECT_DATA）\r\n            1：算法参数（输出内容，仅存放于OBJECT_DATA）\r\n            2：模型评估报告（输出内容，存放于文件系统）\r\n            3：交叉验证报告（输出内容，存放于文件系统）\r\n            4：统计分析报告（输出内容，存放于文件系统）\r\n            5：自动调参报告（输出内容，存放于文件系统）\r\n            6：生成规则报告（输出内容，存放于文件系统）',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `REL_FLOW_ID` bigint(20) NOT NULL COMMENT '关联工作流ID，无关联工作流设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联节点ID，创建脚本的工作流节点，无关联则设为-1',
  `REL_CHAR_ID` varchar(200) NOT NULL DEFAULT '-1' COMMENT '关联特征ID，创建脚本的工作流节点输出特征，无关联则设为-1',
  `STORAGE_LOCATION` int(11) NOT NULL DEFAULT '0' COMMENT '存储位置\r\n            \r\n            0：OBJECT_CONTENT字段\r\n            1：文件系统',
  `OBJECT_CONTENT` mediumtext COMMENT '对象内容',
  `OBJECT_DFS_FILE` varchar(800) DEFAULT NULL COMMENT 'DFS对象文件名\r\n            \r\n            模型评估报告：${FLOW_DIR}/model_evaluation_report_<node_id>_<json_id>.json\r\n            统计分析报告：${FLOW_DIR}/statistical_analysis_report_<node_id>_<json_id>.json\r\n            自动调参报告：${FLOW_DIR}/tune_parameters_report_<node_id>_<json_id>.json\r\n            生成规则报告：${FLOW_DIR}/generate_rules_report_<node_id>_<json_id>.json',
  `OBJECT_LOCAL_FILE` varchar(800) DEFAULT NULL COMMENT '本地对象文件名\r\n            \r\n            模型评估报告：${FLOW_DIR}/model_evaluation_report_<node_id>_<json_id>.json\r\n            统计分析报告：${FLOW_DIR}/statistical_analysis_report_<node_id>_<json_id>.json\r\n            自动调参报告：${FLOW_DIR}/tune_parameters_report_<node_id>_<json_id>.json\r\n            生成规则报告：${FLOW_DIR}/generate_rules_report_<node_id>_<json_id>.json',
  `OBJECT_STATE` int(11) NOT NULL DEFAULT '0' COMMENT 'JSON数据状态\r\n            0：空对象\r\n            1：正常',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`OBJECT_ID`),
  KEY `Index_1` (`OWNER_PROJECT_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_PROJECT_ID`,`OBJECT_TYPE`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='JSON对象表';

-- ----------------------------
-- Records of wf_json_object
-- ----------------------------

-- ----------------------------
-- Table structure for wf_snapshot
-- ----------------------------
DROP TABLE IF EXISTS `wf_snapshot`;
CREATE TABLE `wf_snapshot` (
  `SNAPSHOT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '快照ID',
  `SNAPSHOT_NAME` varchar(200) NOT NULL COMMENT '快照名称',
  `SNAPSHOT_TYPE` int(11) NOT NULL COMMENT '快照类型\r\n            0：运行快照\r\n            1：副本快照\r\n            2：删除快照',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `OWNER_FLOW_ID` bigint(20) NOT NULL COMMENT '所属流程图ID，无关联设为-1',
  `SNAPSHOT_CONTENT` longtext COMMENT '快照内容',
  `SNAPSHOT_VERSION` bigint(20) NOT NULL COMMENT '快照版本',
  `SNAPSHOT_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '快照状态\r\n            0：generating，快照生成中\r\n            1：finished，快照完成',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SNAPSHOT_ID`),
  KEY `Index_1` (`OWNER_PROJECT_ID`,`OWNER_FLOW_ID`,`SNAPSHOT_TYPE`,`SNAPSHOT_VERSION`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_PROJECT_ID`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流快照表，在实验工作台创建副本和运行实验都会触发快照创建，由此实现类似checkpoint功能\r\n\r\n                                -&';

-- ----------------------------
-- Records of wf_snapshot
-- ----------------------------

-- ----------------------------
-- Table structure for wf_user_favorite_module
-- ----------------------------
DROP TABLE IF EXISTS `wf_user_favorite_module`;
CREATE TABLE `wf_user_favorite_module` (
  `PROJECT_ID` bigint(20) NOT NULL COMMENT '项目ID',
  `OPER_ID` varchar(100) NOT NULL COMMENT '用户ID',
  `MODULE_ID` bigint(20) NOT NULL COMMENT '组件ID',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  KEY `Index_1` (`PROJECT_ID`,`OPER_ID`,`MODULE_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`PROJECT_ID`,`OPER_ID`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户收藏组件\r\n\r\n逻辑删除，同一项目和用户下正常状态的组件唯一';

-- ----------------------------
-- Records of wf_user_favorite_module
-- ----------------------------

-- ----------------------------
-- Table structure for wf_user_favorite_table
-- ----------------------------
DROP TABLE IF EXISTS `wf_user_favorite_table`;
CREATE TABLE `wf_user_favorite_table` (
  `PROJECT_ID` bigint(20) NOT NULL COMMENT '项目ID',
  `OPER_ID` varchar(100) NOT NULL COMMENT '用户ID',
  `TABLE_ID` bigint(20) NOT NULL COMMENT '数据表ID',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  KEY `Index_1` (`PROJECT_ID`,`OPER_ID`,`TABLE_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`PROJECT_ID`,`OPER_ID`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户收藏数据表\r\n\r\n逻辑删除，同一项目和用户下正常状态的数据表唯一';

-- ----------------------------
-- Records of wf_user_favorite_table
-- ----------------------------
