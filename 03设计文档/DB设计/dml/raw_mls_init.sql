/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50724
Source Host           : 127.0.0.1:3306
Source Database       : raw_mls

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-11-16 19:00:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dw_data_table
-- ----------------------------
DROP TABLE IF EXISTS `dw_data_table`;
CREATE TABLE `dw_data_table` (
  `TABLE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据表ID',
  `TABLE_NAME` varchar(200) NOT NULL COMMENT '数据表名',
  `TABLE_TYPE` int(11) NOT NULL COMMENT '数据表类型\r\n            0：静态数据表，通过API接口进行创建和删除\r\n            1：动态数据表（预留）\r\n            2：临时数据表，存在于项目数据库中，跟<计算输出数据集的各类节点>一起创建删除，表名为tmp_<node_code>_<nodeInstance_id>_<portChar_code>',
  `DW_ID` bigint(20) NOT NULL COMMENT '数据库ID',
  `NODE_INSTANCE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '节点实例ID，静态数据表设为-1',
  `COLUMNS` bigint(20) DEFAULT NULL COMMENT '列数',
  `ROWS` bigint(20) DEFAULT NULL COMMENT '行数',
  `FILE_SIZE` bigint(20) DEFAULT NULL COMMENT '文件大小，单位为字节',
  `FILE_PATH` varchar(800) DEFAULT NULL COMMENT '数据文件路径，例子如下：\r\n            ${dw_home_dir}/<table_id>.parquet\r\n            ${dw_home_dir}/tmp/<experiment_id>/<table_id>.parquet',
  `MODIFY_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '内容修改时间',
  `STORAGE_TYPE` int(11) DEFAULT NULL COMMENT '存储类型\r\n            0：Parquet ',
  `TABLE_DESC` varchar(800) DEFAULT NULL COMMENT '数据表描述',
  `STATUS` int(11) NOT NULL COMMENT '数据表状态\r\n            0：正常\r\n            1：空表',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`TABLE_ID`),
  UNIQUE KEY `Index_1` (`DW_ID`,`TABLE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据信息表';

-- ----------------------------
-- Records of dw_data_table
-- ----------------------------

-- ----------------------------
-- Table structure for dw_data_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `dw_data_warehouse`;
CREATE TABLE `dw_data_warehouse` (
  `DW_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库ID',
  `DW_NAME` varchar(200) NOT NULL COMMENT '数据库名',
  `DW_TYPE` int(11) NOT NULL COMMENT '数据库类型\r\n            0：公共数据库（暂不支持）\r\n            1：项目数据库，项目数据库随项目一起创建删除，数据库名为项目代码',
  `PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID，数据库类型为公共数据库时设为空',
  `DW_HOME_DIR` varchar(800) NOT NULL COMMENT '数据库数据文件目录，例子如下：\r\n            hdfs://namenode_host:port/user/mls/dw_data/<dw_id>',
  `DW_DESC` varchar(800) DEFAULT NULL COMMENT '数据库描述',
  `STATUS` int(11) NOT NULL COMMENT '数据库状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`DW_ID`),
  UNIQUE KEY `Index_1` (`DW_NAME`,`STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据库信息表';

-- ----------------------------
-- Records of dw_data_warehouse
-- ----------------------------

-- ----------------------------
-- Table structure for mw_model
-- ----------------------------
DROP TABLE IF EXISTS `mw_model`;
CREATE TABLE `mw_model` (
  `MODEL_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '模型ID',
  `MODEL_NAME` varchar(200) NOT NULL COMMENT '模型名称',
  `MODEL_TYPE` int(11) NOT NULL COMMENT '模型类型\r\n            0：静态模型，通过API接口进行创建和删除\r\n            1：动态模型（预留）\r\n            2：临时模型，存在于项目模型库中，跟<机器学习算法节点>一起创建删除，模型名称为tmp_<node_code>_<nodeInstance_id>_<portChar_code>',
  `MW_ID` bigint(20) NOT NULL COMMENT '模型库ID',
  `NODE_INSTANCE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '节点实例ID，静态模型设为-1',
  `ALG_ID` bigint(20) NOT NULL COMMENT '算法ID',
  `FILE_SIZE` bigint(20) DEFAULT NULL COMMENT '文件大小，单位为字节',
  `FILE_PATH` varchar(800) DEFAULT NULL COMMENT '模型文件路径，例子如下：\r\n            ${mw_home_dir}/<model_id>.model\r\n            ${mw_home_dir}/tmp/<experiment_id>/}/<model_id>.model',
  `MODIFY_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '内容修改时间',
  `REPORT_ID` bigint(20) DEFAULT NULL COMMENT '分析报告ID，模型评估报告',
  `MODEL_DESC` varchar(800) DEFAULT NULL COMMENT '模型描述',
  `STATUS` int(11) NOT NULL COMMENT '模型状态\r\n            0：正常\r\n            1：空模型',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`MODEL_ID`),
  UNIQUE KEY `Index_1` (`MW_ID`,`MODEL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模型信息表';

-- ----------------------------
-- Records of mw_model
-- ----------------------------

-- ----------------------------
-- Table structure for mw_model_detail
-- ----------------------------
DROP TABLE IF EXISTS `mw_model_detail`;
CREATE TABLE `mw_model_detail` (
  `MODEL_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '模型ID',
  `ALG_PARAMS` mediumblob COMMENT '算法参数，一个json数组的字符串格式，例如：\r\n            [\r\n            	{\r\n            		"param_code":"alg_name",\r\n            		"param_name":"算法名称",\r\n            		"param_value":"逻辑回归",\r\n            	},\r\n            	{\r\n            		"param_code":"alg_function_type",\r\n            		"param_name":"算法功能类型",\r\n            		"param_value":"二分类算法",\r\n            	},\r\n            	{\r\n            		"param_code":"alg_mode",\r\n            		"param_name":"算法模式",\r\n            		"param_value":"speed_priority",\r\n            	},\r\n            	{\r\n            		"param_code":"learning_rate_coef_alpha",\r\n            		"param_name":"学习率alpha系数",\r\n            		"param_value":"0.1",\r\n            	},\r\n            	{\r\n            		"param_code":"max_training_epochs",\r\n            		"param_name":"最大训练轮数",\r\n            		"param_value":"2",\r\n            	}\r\n            ]',
  `TRAIN_TABLE_ID` bigint(20) DEFAULT NULL COMMENT '训练集数据表ID\r\n            ',
  `TRAIN_PROCESS_SUMMARY` mediumblob COMMENT '训练过程概要，一个json对象，比如二分类算法模型保存：\r\n            {\r\n            	"LogLoss":[...],\r\n            	"AUC":[...]\r\n            }',
  `TRAIN_COST_TIME` bigint(20) DEFAULT NULL COMMENT '训练运行时间，单位毫秒',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`MODEL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模型详情表';

-- ----------------------------
-- Records of mw_model_detail
-- ----------------------------

-- ----------------------------
-- Table structure for mw_model_report
-- ----------------------------
DROP TABLE IF EXISTS `mw_model_report`;
CREATE TABLE `mw_model_report` (
  `REPORT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评估报告ID',
  `REPORT_NAME` varchar(200) NOT NULL COMMENT '评估报告名称',
  `MODEL_ID` bigint(20) NOT NULL COMMENT '模型ID',
  `STORAGE_LOCATION` int(11) NOT NULL COMMENT '存储位置\r\n            0：JSON_DATA字段\r\n            1：HDFS文件系统',
  `REPORT_DATA` mediumblob COMMENT '评估报告数据',
  `FILE_PATH` varchar(800) DEFAULT NULL COMMENT '评估报告文件路径\r\n            ${mw_home_dir}/report_data/report_<model_id>_<report_id>.json',
  `MODIFY_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '内容修改时间',
  `STATUS` int(11) NOT NULL COMMENT '评估报告状态\r\n            0：正常\r\n            1：空评估报告',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`REPORT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模型评估报告信息表';

-- ----------------------------
-- Records of mw_model_report
-- ----------------------------

-- ----------------------------
-- Table structure for mw_model_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `mw_model_warehouse`;
CREATE TABLE `mw_model_warehouse` (
  `MW_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库ID',
  `MW_NAME` varchar(200) NOT NULL COMMENT '数据库名',
  `MW_TYPE` int(11) NOT NULL COMMENT '数据库类型\r\n            0：公共数据库（暂不支持）\r\n            1：项目数据库，项目模型库随项目一起创建删除，模型库名为项目代码',
  `PROJECT_ID` bigint(20) DEFAULT NULL COMMENT '所属项目ID，模型库类型为公共模型库时设为空',
  `MW_HOME_DIR` varchar(800) NOT NULL COMMENT '模型库模型文件目录，例子如下：\r\n            hdfs://namenode_host:port/user/mls/mw_file/<mw_id>',
  `MW_DESC` varchar(800) DEFAULT NULL COMMENT '模型库描述',
  `STATUS` int(11) NOT NULL COMMENT '模型库状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`MW_ID`),
  UNIQUE KEY `Index_1` (`MW_NAME`,`STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模型库信息表';

-- ----------------------------
-- Records of mw_model_warehouse
-- ----------------------------

-- ----------------------------
-- Table structure for pcf_algorithm_def
-- ----------------------------
DROP TABLE IF EXISTS `pcf_algorithm_def`;
CREATE TABLE `pcf_algorithm_def` (
  `ALG_ID` bigint(20) NOT NULL COMMENT '算法ID',
  `ALG_CODE` varchar(200) NOT NULL COMMENT '算法代码',
  `ALG_NAME` varchar(200) NOT NULL COMMENT '算法名称',
  `ALG_LABELS` varchar(800) DEFAULT NULL COMMENT '算法标签列表（预留）',
  `ALG_LEARNING_MODE` int(11) NOT NULL COMMENT '算法学习方式（预留）\r\n            0：Supervised Learning，有监督学习\r\n            1：Unsupervised Learning，无监督学习\r\n            2：Semi-Supervised Learning，半监督学习',
  `ALG_FITTING_MODE` int(11) NOT NULL COMMENT '算法拟合方式（预留）\r\n            0：Full-batch Learning，全批量学习\r\n            1：Mini-batch Learning，小批量学习\r\n            2：Online Learning，在线学习',
  `ALG_FUNCTION_TYPE` int(11) NOT NULL COMMENT '算法功能类型（预留）\r\n            0：Classification，分类算法\r\n            1：Clustering，聚类算法\r\n            2：Regression，回归算法\r\n            3：Association Rules，关联规则算法\r\n            4：Collaborative filtering，协同过滤算法',
  `ALG_DESC` varchar(800) DEFAULT NULL COMMENT '算法描述',
  `STATUS` int(11) NOT NULL COMMENT '算法状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`ALG_ID`),
  UNIQUE KEY `Index_1` (`ALG_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='算法定义表';

-- ----------------------------
-- Records of pcf_algorithm_def
-- ----------------------------
INSERT INTO `pcf_algorithm_def` VALUES ('1', 'LogisticRegressionBinaryClassification', '逻辑回归二分类', null, '0', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `pcf_algorithm_def` VALUES ('2', 'LogisticRegressionMultipleClassification', '逻辑回归多分类', null, '0', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `pcf_algorithm_def` VALUES ('3', 'RandomForestClassification', '随机森林分类', null, '0', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `pcf_algorithm_def` VALUES ('4', 'GradientBoostingDecisionTreeBinaryClassification', 'GBDT二分类', null, '0', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `pcf_algorithm_def` VALUES ('5', 'LinearSupportVectorMachineBinaryClassification', '线性支持向量机二分类', null, '0', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `pcf_algorithm_def` VALUES ('6', 'NaiveBayesianMultipleClassification', '朴素贝叶斯多分类', null, '0', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `pcf_algorithm_def` VALUES ('7', 'KNearestNeighborsMultipleClassification', 'K近邻多分类', null, '0', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `pcf_algorithm_def` VALUES ('100', 'KMeansClustering', 'K均值聚类', null, '1', '0', '1', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `pcf_algorithm_def` VALUES ('200', 'LinearRegression', '线性回归', null, '0', '0', '2', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `pcf_algorithm_def` VALUES ('201', 'GradientBoostingDecisionTreeRegression', 'GBDT回归', null, '0', '0', '2', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `pcf_algorithm_def` VALUES ('300', 'AprioriAssociationRules', 'Apriori关联规则', null, '1', '0', '3', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `pcf_algorithm_def` VALUES ('301', 'FrequentPatternGrowthAssociationRules', 'FP-Growth关联规则', null, '1', '0', '3', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `pcf_algorithm_def` VALUES ('400', 'AlternatingLeastSquaresCollaborativeFiltering', 'ALS协同过滤', null, '1', '0', '4', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `pcf_algorithm_def` VALUES ('401', 'LatentFactorModelCollaborativeFiltering', 'LFM协同过滤', null, '1', '0', '4', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');

-- ----------------------------
-- Table structure for pcf_cmpt_char_value
-- ----------------------------
DROP TABLE IF EXISTS `pcf_cmpt_char_value`;
CREATE TABLE `pcf_cmpt_char_value` (
  `CMPT_ID` bigint(20) NOT NULL COMMENT '组件ID',
  `CHAR_ID` bigint(20) NOT NULL COMMENT '组件规格特征ID',
  `IS_SYSTEM_PARAM` int(11) NOT NULL COMMENT '特征值内容是否为系统参数\r\n            0：否\r\n            1：是',
  `CHAR_VALUE` varchar(2000) DEFAULT NULL COMMENT '特征值',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CMPT_ID`,`CHAR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组件特征值设置表';

-- ----------------------------
-- Records of pcf_cmpt_char_value
-- ----------------------------
INSERT INTO `pcf_cmpt_char_value` VALUES ('1000', '20101', '0', 'decision-maker-mgr-framework-2.0.0.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('1000', '20102', '0', 'cn.com.bsfit.dm.component.SparkSqlTask', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5001', '20101', '0', 'PcfCmptLib_ML.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5001', '20102', '0', 'com.bsfit.mls.pcf.xxxCmpt.LogisticRegressionBinaryClassification', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5001', '40000', '0', '1', '2017-05-25 19:06:52', 'admin', '2017-05-25 19:06:52', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5002', '20101', '0', 'PcfCmptLib_ML.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5002', '20102', '0', 'com.bsfit.mls.pcf.xxxCmpt.LogisticRegressionMultipleClassification', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5002', '40000', '0', '2', '2017-05-25 19:06:52', 'admin', '2017-05-25 19:06:52', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5003', '20101', '0', 'PcfCmptLib_ML.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5003', '20102', '0', 'com.bsfit.mls.pcf.xxxCmpt.RandomForestClassification', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5003', '40000', '0', '3', '2017-05-25 19:06:52', 'admin', '2017-05-25 19:06:52', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5004', '20101', '0', 'PcfCmptLib_ML.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5004', '20102', '0', 'com.bsfit.mls.pcf.xxxCmpt.GradientBoostingDecisionTreeBinaryClassification', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5004', '40000', '0', '4', '2017-05-25 19:06:52', 'admin', '2017-05-25 19:06:52', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5005', '20101', '0', 'PcfCmptLib_ML.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5005', '20102', '0', 'com.bsfit.mls.pcf.xxxCmpt.LinearSupportVectorMachineBinaryClassification', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5005', '40000', '0', '5', '2017-05-25 19:06:52', 'admin', '2017-05-25 19:06:52', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5006', '20101', '0', 'PcfCmptLib_ML.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5006', '20102', '0', 'com.bsfit.mls.pcf.xxxCmpt.NaiveBayesianMultipleClassification', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5006', '40000', '0', '6', '2017-05-25 19:06:52', 'admin', '2017-05-25 19:06:52', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5007', '20101', '0', 'PcfCmptLib_ML.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5007', '20102', '0', 'com.bsfit.mls.pcf.xxxCmpt.KNearestNeighborsMultipleClassification', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5007', '40000', '0', '7', '2017-05-25 19:06:52', 'admin', '2017-05-25 19:06:52', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5100', '20101', '0', 'PcfCmptLib_ML.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5100', '20102', '0', 'com.bsfit.mls.pcf.xxxCmpt.KMeansClustering', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5100', '40000', '0', '100', '2017-05-25 19:06:52', 'admin', '2017-05-25 19:06:52', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5200', '20101', '0', 'PcfCmptLib_ML.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5200', '20102', '0', 'com.bsfit.mls.pcf.xxxCmpt.LinearRegression', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5200', '40000', '0', '200', '2017-05-25 19:06:52', 'admin', '2017-05-25 19:06:52', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5201', '20101', '0', 'PcfCmptLib_ML.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5201', '20102', '0', 'com.bsfit.mls.pcf.xxxCmpt.GradientBoostingDecisionTreeRegression', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5201', '40000', '0', '201', '2017-05-25 19:06:52', 'admin', '2017-05-25 19:06:52', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5900', '20101', '0', 'PcfCmptLib_ML.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5900', '20102', '0', 'com.bsfit.mls.pcf.xxxCmpt.Prediction', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5901', '20101', '0', 'PcfCmptLib_ML.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5901', '20102', '0', 'com.bsfit.mls.pcf.xxxCmpt.BinaryClassificationEvaluation', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5902', '20101', '0', 'PcfCmptLib_ML.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5902', '20102', '0', 'com.bsfit.mls.pcf.xxxCmpt.MultipleClassificationEvaluation', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5903', '20101', '0', 'PcfCmptLib_ML.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5903', '20102', '0', 'com.bsfit.mls.pcf.xxxCmpt.ClusteringEvaluation', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5904', '20101', '0', 'PcfCmptLib_ML.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5904', '20102', '0', 'com.bsfit.mls.pcf.xxxCmpt.RegressionEvaluation', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5998', '20101', '0', 'PcfCmptLib_ML.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5998', '20102', '0', 'com.bsfit.mls.pcf.xxxCmpt.AutoTuning', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5999', '20101', '0', 'PcfCmptLib_ML.jar', '2017-05-25 19:05:45', 'admin', '2017-05-25 19:05:45', 'admin');
INSERT INTO `pcf_cmpt_char_value` VALUES ('5999', '20102', '0', 'com.bsfit.mls.pcf.xxxCmpt.SmartRules', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');

-- ----------------------------
-- Table structure for pcf_cmpt_def
-- ----------------------------
DROP TABLE IF EXISTS `pcf_cmpt_def`;
CREATE TABLE `pcf_cmpt_def` (
  `CMPT_ID` bigint(20) NOT NULL COMMENT '组件ID\r\n            组件ID值组成：两位组件类型 + 三位组件序列号',
  `CMPT_CODE` varchar(200) NOT NULL COMMENT '组件代码',
  `CMPT_NAME` varchar(200) NOT NULL COMMENT '组件名称',
  `CMPT_TYPE` int(11) NOT NULL COMMENT '组件种类\r\n            0：输入输出组件\r\n            1：脚本工具组件\r\n            2：数据预处理组件\r\n            3：特征工程组件\r\n            4：统计分析组件\r\n            5：机器学习组件\r\n            6：深度学习组件\r\n            7：文本分析组件\r\n            8：网络分析组件\r\n            9：流式处理组件',
  `ALG_ID` bigint(20) NOT NULL COMMENT '算法ID，非算法组件设为-1',
  `CMPT_DESC` varchar(800) DEFAULT NULL COMMENT '组件描述',
  `STATUS` int(11) NOT NULL COMMENT '组件状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CMPT_ID`),
  KEY `Index_1` (`CMPT_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组件定义表';

-- ----------------------------
-- Records of pcf_cmpt_def
-- ----------------------------
INSERT INTO `pcf_cmpt_def` VALUES ('1', 'ReadDataTable', '输入输出 | 读数据表', '0', '-1', null, '0', '2017-05-16 17:52:14', 'admin', '2017-05-16 17:52:14', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('2', 'ReadModel', '输入输出 | 读模型', '0', '-1', null, '0', '2017-05-16 17:55:43', 'admin', '2017-05-16 17:55:43', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('3', 'WriteDataTable', '输入输出 | 写数据表', '0', '-1', null, '0', '2017-05-16 17:52:14', 'admin', '2017-05-16 17:52:14', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('1000', 'SqlScript', '脚本工具 | SQL脚本', '1', '-1', null, '0', '2017-05-16 17:57:49', 'admin', '2017-05-16 17:57:49', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('1001', 'PythonScript', '脚本工具 | Python脚本（待定）', '1', '-1', null, '1', '2017-05-16 17:57:49', 'admin', '2017-05-16 17:57:49', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('1002', 'RScript', '脚本工具 | R脚本（待定）', '1', '-1', null, '1', '2017-05-16 17:57:49', 'admin', '2017-05-16 17:57:49', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('2000', '#DataPreprocessing', '数据预处理 | #数据预处理', '2', '-1', null, '-1', '2017-05-27 16:28:04', 'admin', '2017-05-27 16:28:04', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('3000', '#FeatureEngineering', '特征工程 | #特征工程', '3', '-1', null, '-1', '2017-05-27 16:28:50', 'admin', '2017-05-27 16:28:50', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('4000', '#StatisticalAnalysis', '统计分析 | #统计分析', '4', '-1', null, '-1', '2017-05-27 16:29:34', 'admin', '2017-05-27 16:29:34', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5001', 'LogisticRegressionBinaryClassification', '机器学习 | 逻辑回归二分类', '5', '1', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5002', 'LogisticRegressionMultipleClassification', '机器学习 | 逻辑回归多分类', '5', '2', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5003', 'RandomForestClassification', '机器学习 | 随机森林分类', '5', '3', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5004', 'GradientBoostingDecisionTreeBinaryClassification', '机器学习 | GBDT二分类', '5', '4', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5005', 'LinearSupportVectorMachineBinaryClassification', '机器学习 | 线性支持向量机二分类', '5', '5', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5006', 'NaiveBayesianMultipleClassification', '机器学习 | 朴素贝叶斯多分类', '5', '6', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5007', 'KNearestNeighborsMultipleClassification', '机器学习 | K近邻多分类', '5', '7', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5100', 'KMeansClustering', '机器学习 | K均值聚类', '5', '100', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5200', 'LinearRegression', '机器学习 | 线性回归', '5', '200', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5201', 'GradientBoostingDecisionTreeRegression', '机器学习 | GBDT回归', '5', '201', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5300', 'AprioriAssociationRules', '机器学习 | Apriori关联规则（待定）', '5', '300', null, '1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5301', 'FrequentPatternGrowthAssociationRules', '机器学习 | FP-Growth关联规则（待定）', '5', '301', null, '1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5400', 'AlternatingLeastSquaresCollaborativeFiltering', '机器学习 | ALS协同过滤（待定）', '5', '400', null, '1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5401', 'LatentFactorModelCollaborativeFiltering', '机器学习 | LFM协同过滤（待定）', '5', '401', null, '1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5900', 'Prediction', '机器学习 | 预测', '5', '-1', null, '0', '2017-05-17 13:48:44', 'admin', '2017-05-17 13:48:44', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5901', 'BinaryClassificationEvaluation', '机器学习 | 二分类评估', '5', '-1', null, '0', '2017-05-17 13:40:58', 'admin', '2017-05-17 13:40:58', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5902', 'MultipleClassificationEvaluation', '机器学习 | 多分类评估', '5', '-1', null, '0', '2017-05-17 13:41:51', 'admin', '2017-05-17 13:41:59', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5903', 'ClusteringEvaluation', '机器学习 | 聚类模型评估', '5', '-1', null, '0', '2017-05-17 13:42:37', 'admin', '2017-05-17 13:42:37', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5904', 'RegressionEvaluation', '机器学习 | 回归模型评估', '5', '-1', null, '0', '2017-05-17 13:43:11', 'admin', '2017-05-17 13:43:11', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5905', 'AssociationRulesEvaluation', '机器学习 | 关联规则评估（待定）', '5', '-1', null, '1', '2017-05-17 13:44:29', 'admin', '2017-05-17 13:44:29', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5906', 'CollaborativeFilteringEvaluation', '机器学习 | 协同过滤评估（待定）', '5', '-1', null, '1', '2017-05-17 13:45:07', 'admin', '2017-05-17 13:45:07', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5998', 'AutoTuning', '机器学习 | 自动调参（GridSearchCV）（待定）', '5', '-1', null, '1', '2017-05-17 13:53:37', 'admin', '2017-05-17 13:53:46', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('5999', 'SmartRules', '机器学习 | 智能规则（待定）', '5', '-1', null, '1', '2017-05-17 12:34:44', 'admin', '2017-05-17 12:34:44', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('6000', '#DeepLearning', '深度学习 | #深度学习', '6', '-1', null, '-1', '2017-05-27 17:46:41', 'admin', '2017-05-27 17:46:41', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('7000', '#TextAnalysis', '文本分析 | #文本分析', '7', '-1', null, '-1', '2017-05-27 17:47:09', 'admin', '2017-05-27 17:47:09', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('8000', '#NetworkAnalysis', '网络分析 | #网络分析', '8', '-1', null, '-1', '2017-05-27 17:47:34', 'admin', '2017-05-27 17:47:34', 'admin');
INSERT INTO `pcf_cmpt_def` VALUES ('9000', '#StreamProcessing', '流式处理 | #流式处理', '9', '-1', null, '-1', '2017-05-27 17:48:05', 'admin', '2017-05-27 17:48:05', 'admin');

-- ----------------------------
-- Table structure for pcf_cmpt_spec_char_def
-- ----------------------------
DROP TABLE IF EXISTS `pcf_cmpt_spec_char_def`;
CREATE TABLE `pcf_cmpt_spec_char_def` (
  `CHAR_ID` bigint(20) NOT NULL COMMENT '特征ID\r\n            输入内容规格类型\r\n            特征ID范围：0 ~ 9999\r\n            \r\n            输出内容规格类型\r\n            特征ID范围：10000 ~ 19999\r\n            \r\n            调用执行规格类型\r\n            特征ID范围：20000 ~ 29999\r\n            \r\n            执行调优参数规格类型\r\n            特征ID范围：30000 ~ 39999\r\n            \r\n            组件参数规格类型\r\n            通用特征ID范围：40000 ~ 49999\r\n            专用特征ID值组成：六位规格ID + 两位特征序列号',
  `CHAR_CODE` varchar(200) NOT NULL COMMENT '特征代码',
  `CHAR_NAME` varchar(200) NOT NULL COMMENT '特征名称',
  `CHAR_ALIAS` varchar(200) DEFAULT NULL COMMENT '特征别名，非空时，使用特征别名替代特征代码作为参数名',
  `SPEC_TYPE` int(11) NOT NULL COMMENT '适用规格类型\r\n            0：input，输入内容规格\r\n            1：output，输出内容规格\r\n            2：execution，调用执行规格\r\n            3：execution_optimize，执行调优参数规格\r\n            4：parameter，组件参数规格',
  `CHAR_TYPE_ID` int(11) NOT NULL COMMENT '特征类型ID',
  `VALUE_SRC` int(11) NOT NULL COMMENT '特征值来源\r\n            0：组件规格配置\r\n            1：组件配置\r\n            2：外部配置',
  `IS_REQUIRED` int(11) NOT NULL COMMENT '特征值是否必须设置\r\n            0：否\r\n            1：是',
  `IS_LIMITED` int(11) NOT NULL COMMENT '特征值是否受限定\r\n            0：否\r\n            1：开区间方式限定，限数值和日期类型\r\n            2：闭区间方式限定，限数值和日期类型\r\n            3：枚举方式限定',
  `STEP_SIZE` varchar(2000) DEFAULT NULL COMMENT '特征值步长，限数值和日期类型，日期以天为单位，时间以秒为单位',
  `MIN_VALUE` varchar(2000) DEFAULT NULL COMMENT '最大特征值，未设置表示无穷小',
  `MAX_VALUE` varchar(2000) DEFAULT NULL COMMENT '最大特征值，未设置表示无穷大',
  `DEFAULT_VALUE` varchar(2000) DEFAULT NULL COMMENT '默认特征值',
  `CHAR_DESC` varchar(800) DEFAULT NULL COMMENT '组件规格特征描述',
  `STATUS` int(11) NOT NULL COMMENT '组件规格特征状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CHAR_ID`),
  KEY `Index_1` (`SPEC_TYPE`,`CHAR_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组件规格特征定义表，即组件相关的一系列参数要求配置表';

-- ----------------------------
-- Records of pcf_cmpt_spec_char_def
-- ----------------------------
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('1', 't1', '输入内容 | 数据表t1', null, '0', '101', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('2', 't2', '输入内容 | 数据表t2', null, '0', '101', '2', '0', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('3', 't3', '输入内容 | 数据表t3', null, '0', '101', '2', '0', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('4', 't4', '输入内容 | 数据表t4', null, '0', '101', '2', '0', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('5', 't5', '输入内容 | 数据表t5', null, '0', '101', '2', '0', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('6', 't6', '输入内容 | 数据表t6', null, '0', '101', '2', '0', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('11', 'm1', '输入内容 | 模型m1', null, '0', '102', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('10001', 'r1', '输出内容 | 数据表r1', null, '1', '101', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('10002', 'r2', '输出内容 | 数据表t2', null, '1', '101', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('10003', 'r3', '输出内容 | 数据表r3', null, '1', '101', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('10004', 'r4', '输出内容 | 数据表r4', null, '1', '101', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('10005', 'r5', '输出内容 | 数据表r5', null, '1', '101', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('10006', 'r6', '输出内容 | 数据表r6', null, '1', '101', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('10011', 'm1', '输出内容 | 模型m1', null, '1', '102', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('10021', 'report', '输出内容 | 统计分析报告report', null, '1', '1000', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('10022', 'report', '输出内容 | 模型评估报告report', null, '1', '1001', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('10023', 'rules', '输出内容 | 智能规则rules', null, '1', '1002', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('20000', 'engineType', '调用执行 | 计算引擎类型', null, '2', '3', '0', '1', '3', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('20001', 'hadoopYarnRmIp', '调用执行 | hadoop.yarn资源管理器IP', 'yarn.resourcemanager.address.ip', '2', '7', '0', '1', '0', null, null, null, '10.100.1.210', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('20002', 'hadoopYarnRmPort', '调用执行 | hadoop.yarn资源管理器端口', 'yarn.resourcemanager.address.port', '2', '7', '0', '1', '0', null, null, null, '8032', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('20100', 'sparkCmptJarDir', '调用执行 | spark组件jar库目录', '--jarDir', '2', '7', '0', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('20101', 'sparkCmptJarFile', '调用执行 | spark组件jar包文件名', '--jarFile', '2', '7', '1', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('20102', 'sparkCmptClassPath', '调用执行 | spark组件class类路径', '--class', '2', '7', '1', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('20103', 'sparkCmptPythonPath', '调用执行 | spark组件python脚本路径（待定）', null, '2', '7', '1', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('20104', 'sparkCmptRPath', '调用执行 | spark组件R脚本路径（待定）', null, '2', '7', '1', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('30000', 'sparkExecutorNumber', '执行调优 | spark.executor.number', 'spark.executor.number', '3', '7', '2', '0', '0', '1', '0', null, '1', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('30001', 'sparkExecutorCores', '执行调优 | spark.executor.cores', 'spark.executor.cores', '3', '7', '2', '0', '0', '1', '0', null, '8', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('30002', 'sparkExecutorMemory', '执行调优 | spark.executor.memory', 'spark.executor.memory', '3', '7', '2', '0', '0', null, null, null, '1G', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('30003', 'sparkExtraConfiguration', '执行调优 | spark.extra.configuration', 'spark.extra.configuration', '3', '7', '2', '0', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40000', 'algorithm', '通用组件参数 | 机器学习 | 算法', null, '4', '100', '1', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40001', 'labelColumnName', '通用组件参数 | 机器学习 | 标签列列名', null, '4', '7', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40002', 'positiveLabel', '通用组件参数 | 机器学习 | 正样本标签值', null, '4', '7', '2', '1', '0', null, null, null, '0', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40003', 'weightColumnName', '通用组件参数 | 机器学习 | 权重列列名', null, '4', '7', '2', '0', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40004', 'groupColumnName', '通用组件参数 | 机器学习 | 分组列列名', null, '4', '7', '2', '0', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40010', 'predictResultColumnName', '通用组件参数 | 机器学习 | 预测结果输出列列名', null, '4', '7', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40011', 'predictScoreColumnName', '通用组件参数 | 机器学习 | 预测分数输出列列名', null, '4', '7', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40012', 'predictDetailColumnName', '通用组件参数 | 机器学习 | 预测详细输出列列名', null, '4', '7', '2', '0', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40020', 'featureColumnNames', '通用组件参数 | 机器学习 | 特征列列名列表（选择特征）', null, '4', '9999', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40021', 'forceDiscreteColumnNames', '通用组件参数 | 机器学习 | 离散列列名列表（强制转换）', null, '4', '9999', '2', '0', '0', null, null, null, null, 'feature默认解析规则： string、boolean、date、datetime类型的列解析为离散类型。 整数和浮点数类型的列解析为连续类型，若有将bigint解析为categorical/nominal的情况，通过参数cmptParam_ml_forceDiscreteColumnNames指定。', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40022', 'reverseColumnNames', '通用组件参数 | 机器学习 | 保留列列名列表（附加特征）', null, '4', '9999', '2', '0', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40023', 'excludedColumnNames', '通用组件参数 | 机器学习 | 排除列列名列表（排除特征）', null, '4', '9999', '2', '0', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40030', 'maxIteration', '通用组件参数 | 机器学习 | 最大iter迭代次数', null, '4', '3', '2', '1', '2', '1', '1', '10000', '1', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40031', 'eta', '通用组件参数 | 机器学习 | 学习速率eta', null, '4', '5', '2', '1', '1', '0.01', '0', '1.0', '0.05', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40032', 'epsilon', '通用组件参数 | 机器学习 | 收敛系数eplison（最小收敛误差）', null, '4', '5', '2', '0', '0', '0.01', null, null, '0.000001', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40033', 'randSeed', '通用组件参数 | 机器学习 | 随机数种子', null, '4', '3', '2', '0', '2', '1', '0', '10', '0', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40034', 'regularizedType', '通用组件参数 | 机器学习 | 正则项类型', null, '4', '7', '2', '0', '3', null, null, null, 'None', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40035', 'regularizedCoef', '通用组件参数 | 机器学习 | 正则系数', null, '4', '5', '2', '0', '0', '0.1', null, null, '1', '可选，正则类型为None时此值无效', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40000000', 'inputTableName', '专用组件参数 | 输入输出 | 读数据表 | 输入数据表名', null, '4', '7', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40000100', 'inputModelId', '专用组件参数 | 输入输出 | 读模型 | 输入模型ID', null, '4', '4', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40000200', 'ouputTableName', '专用组件参数 | 输入输出 | 写数据表 | 输出数据表名', null, '4', '7', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40100000', 'sqlScript', '专用组件参数 | 脚本工具 | SQL脚本', null, '4', '200', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40100100', 'pythonScript', '专用组件参数 | 脚本工具 | Python脚本', null, '4', '201', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40100200', 'rScript', '专用组件参数 | 脚本工具 | R脚本', null, '4', '202', '2', '1', '0', null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500300', 'treeNumber', '专用组件参数 | 机器学习 | 随机森林 | 森林中树的数目', null, '4', '3', '2', '1', '2', '1', '1', '1000', '100', null, '0', '2017-05-17 18:00:30', 'admin', '2017-05-17 18:00:30', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500301', 'algorithmDistribution', '专用组件参数 | 机器学习 | 随机森林 | 森林中树的算法分布', null, '4', '7', '2', '0', '0', null, null, null, null, '如果有则长度为2.比如有n棵树，algorithmTypes=a,b  则[0,a) 是 id3, [a,b) 是cart， [b,n) 是c4.5。例如：在一个拥有5棵树的森林中，[2, 4]表示0，1为id3算法，2, 3为cart算法，4为c4.5算法。如果输入为None，则算法在森林中均分。', '0', '2017-05-17 19:07:52', 'admin', '2017-05-17 19:08:01', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500302', 'randomFeatureNumber', '专用组件参数 | 机器学习 | 随机森林 | 单颗树输入随机特征的个数', null, '4', '3', '2', '0', '2', '1', '1', null, null, '范围 [1, N]，N为feature数，默认log2N', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500303', 'minInstsPerNode', '专用组件参数 | 机器学习 | 随机森林 | 叶节点数据的最小个数', null, '4', '3', '2', '0', '2', '1', '1', null, '2', null, '0', '2017-05-17 19:28:46', 'admin', '2017-05-17 19:28:46', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500304', 'maxDepth', '专用组件参数 | 机器学习 | 随机森林 | 单颗树的最大深度', null, '4', '3', '2', '0', '2', '1', '1', null, null, '默认无穷大', '0', '2017-05-17 19:45:05', 'admin', '2017-05-17 19:45:05', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500305', 'randomInstsNumber', '专用组件参数 | 机器学习 | 随机森林 | 单颗树输入随机数据的个数（待定）', null, '4', '3', '2', '0', '2', '1', '1000', '1000000', '100000', null, '0', '2017-05-17 19:57:08', 'admin', '2017-05-17 19:57:08', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500400', 'treeNumber', '专用组件参数 | 机器学习 | GBDT二分类 | 树的数目', null, '4', '3', '2', '1', '2', '1', '1', '10000', '500', null, '0', '2017-05-17 20:05:17', 'admin', '2017-05-17 20:05:17', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500401', 'featureRatio', '专用组件参数 | 机器学习 | GBDT二分类 | 训练特征采样比', null, '4', '5', '2', '0', '1', '0.01', '0', '1.0', '0.6', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500402', 'sampleRatio', '专用组件参数 | 机器学习 | GBDT二分类 | 训练样本采样比', null, '4', '5', '2', '0', '1', '0.01', '0', '1.0', '0.6', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500403', 'testRatio', '专用组件参数 | 机器学习 | GBDT二分类 | 测试样本采样比', null, '4', '5', '2', '0', '1', '0.01', '0', '1.0', '0.6', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500404', 'maxLeafCount', '专用组件参数 | 机器学习 | GBDT二分类 | 最大叶子节点数', null, '4', '3', '2', '0', '2', '1', '1', '1000', '32', null, '0', '2017-05-17 20:11:09', 'admin', '2017-05-17 20:11:09', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500405', 'maxDepth', '专用组件参数 | 机器学习 | GBDT二分类 | 树的最大深度', null, '4', '3', '2', '0', '2', '1', '1', '100', '10', null, '0', '2017-05-17 20:14:25', 'admin', '2017-05-17 20:14:25', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500406', 'metricType', '专用组件参数 | 机器学习 | GBDT二分类 | 指标类型', null, '4', '3', '2', '1', '3', null, null, null, '0', null, '0', '2017-05-18 11:33:43', 'admin', '2017-05-18 11:33:43', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500407', 'shrinkage', '专用组件参数 | 机器学习 | GBDT二分类 | 学习速率', null, '4', '3', '2', '1', '1', '0.01', '0', '1', '0.05', null, '0', '2017-05-18 12:56:41', 'admin', '2017-05-18 12:56:41', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500408', 'minLeafSampleCount', '专用组件参数 | 机器学习 | GBDT二分类 | 叶子节点最少样本数', null, '4', '3', '2', '0', '2', '1', '1', '1000', '500', null, '0', '2017-05-18 13:05:35', 'admin', '2017-05-18 13:05:35', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500409', 'featureSplitValueMaxSize', '专用组件参数 | 机器学习 | GBDT二分类 | 一个特征分裂的最大数量', null, '4', '3', '2', '0', '2', '1', '1', '1000', '500', null, '0', '2017-05-18 13:07:24', 'admin', '2017-05-18 13:07:24', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500500', 'positiveCost', '专用组件参数 | 机器学习 | 线性支持向量机 | 正例惩罚因子', null, '4', '5', '2', '0', '1', null, '0', null, '1.0', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500501', 'negativeCost', '专用组件参数 | 机器学习 | 线性支持向量机 | 负例惩罚因子', null, '4', '5', '2', '0', '1', null, '0', null, '1.0', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40500700', 'kNumber', '专用组件参数 | 机器学习 | KNN | 近邻个数', null, '4', '3', '2', '1', '2', '1', '1', '1000', '100', null, '0', '2017-05-17 20:41:30', 'admin', '2017-05-17 20:41:30', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40510000', 'centerNumber', '专用组件参数 | 机器学习 | KMeans | 聚类数', null, '4', '3', '2', '1', '2', '1', '1', '1000', '10', null, '0', '2017-05-17 21:00:00', 'admin', '2017-05-17 21:00:00', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40510001', 'distanceMeasureType', '专用组件参数 | 机器学习 | KMeans | 距离度量方式', null, '4', '7', '2', '1', '3', null, null, null, 'euclidean', null, '0', '2017-05-17 21:02:55', 'admin', '2017-05-17 21:02:55', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40510002', 'centerInitMethod', '专用组件参数 | 机器学习 | KMeans | 质心初始化方法', null, '4', '7', '2', '1', '3', null, null, null, 'random', null, '0', '2017-05-17 21:11:06', 'admin', '2017-05-17 21:11:06', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40520100', 'lossFunctionType', '专用组件参数 | 机器学习 | GBDT回归 | 损失函数类型', null, '4', '3', '2', '1', '3', null, null, null, '0', null, '0', '2017-05-18 11:49:55', 'admin', '2017-05-18 11:50:03', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40520101', 'gbrankLossTau', '专用组件参数 | 机器学习 | GBDT回归 | gbrank loss中的Tau参数', null, '4', '5', '2', '0', '2', '0.1', '0', '1', '0.6', null, '0', '2017-05-18 11:57:20', 'admin', '2017-05-18 11:57:20', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40520102', 'bottomNumber', '专用组件参数 | 机器学习 | GBDT回归 | gbrank loss/regression loss中的指数底数', null, '4', '3', '2', '0', '2', '1', '1', '10', '1', null, '0', '2017-05-18 12:36:25', 'admin', '2017-05-18 12:36:25', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40520103', 'metricType', '专用组件参数 | 机器学习 | GBDT回归 | 指标类型', null, '4', '3', '2', '1', '3', null, null, null, '0', null, '0', '2017-05-18 12:42:43', 'admin', '2017-05-18 12:42:43', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40520104', 'treeNumber', '专用组件参数 | 机器学习 | GBDT回归 | 树的数目', null, '4', '3', '2', '1', '2', '1', '1', '10000', '500', null, '0', '2017-05-18 12:45:58', 'admin', '2017-05-18 12:45:58', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40520105', 'shrinkage', '专用组件参数 | 机器学习 | GBDT回归 | 学习速率', null, '4', '3', '2', '1', '1', '0.01', '0', '1', '0.05', null, '0', '2017-05-18 12:55:46', 'admin', '2017-05-18 12:55:46', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40520106', 'maxLeafCount', '专用组件参数 | 机器学习 | GBDT回归 | 最大叶子节点数', null, '4', '3', '2', '0', '2', '1', '1', '1000', '32', null, '0', '2017-05-18 12:58:05', 'admin', '2017-05-18 12:58:05', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40520107', 'maxDepth', '专用组件参数 | 机器学习 | GBDT回归 | 树的最大深度', null, '4', '3', '2', '0', '2', '1', '1', '100', '10', null, '0', '2017-05-18 13:00:28', 'admin', '2017-05-18 13:00:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40520108', 'minLeafSampleCount', '专用组件参数 | 机器学习 | GBDT回归 | 叶子节点最少样本数', null, '4', '3', '2', '0', '2', '1', '1', '1000', '500', null, '0', '2017-05-18 13:04:32', 'admin', '2017-05-18 13:04:32', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40520109', 'featureSplitValueMaxSize', '专用组件参数 | 机器学习 | GBDT回归 | 一个特征分裂的最大数量', null, '4', '3', '2', '0', '2', '1', '1', '1000', '500', null, '0', '2017-05-18 13:08:11', 'admin', '2017-05-18 13:08:11', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40520110', 'featureRatio', '专用组件参数 | 机器学习 | GBDT回归 | 训练特征采样比', null, '4', '5', '2', '0', '1', '0.01', '0', '1.0', '0.6', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40520111', 'sampleRatio', '专用组件参数 | 机器学习 | GBDT回归 | 训练样本采样比', null, '4', '5', '2', '0', '1', '0.01', '0', '1.0', '0.6', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40520112', 'testRatio', '专用组件参数 | 机器学习 | GBDT回归 | 测试样本采样比', null, '4', '5', '2', '0', '1', '0.01', '0', '1.0', '0.6', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40520113', 'useNewtonStep', '专用组件参数 | 机器学习 | GBDT回归 | 是否使用牛顿迭代方法', null, '4', '3', '2', '0', '3', null, null, null, '1', null, '0', '2017-05-18 13:12:31', 'admin', '2017-05-18 13:12:31', 'admin');
INSERT INTO `pcf_cmpt_spec_char_def` VALUES ('40590100', 'binCount', '专用组件参数 | 机器学习 | 预测 | 计算评价指标时阈值按等频/等宽分成多少个桶', null, '4', '3', '2', '1', '2', '1000', '1000', null, '1000', null, '0', '2017-05-18 17:20:21', 'admin', '2017-05-18 17:20:21', 'admin');

-- ----------------------------
-- Table structure for pcf_cmpt_spec_char_enum
-- ----------------------------
DROP TABLE IF EXISTS `pcf_cmpt_spec_char_enum`;
CREATE TABLE `pcf_cmpt_spec_char_enum` (
  `CHAR_ID` bigint(20) NOT NULL COMMENT '特征ID',
  `ENUM_NAME` varchar(200) NOT NULL COMMENT '枚举值名称',
  `ENUM_VALUE` varchar(2000) NOT NULL COMMENT '枚举值',
  `SEQUENCE` int(11) NOT NULL COMMENT '排序序号',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  UNIQUE KEY `Index_1` (`CHAR_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组件规格特征枚举值表';

-- ----------------------------
-- Records of pcf_cmpt_spec_char_enum
-- ----------------------------
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('20000', '调用执行 | 计算引擎类型 | spark on yarn', '0', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('20000', '调用执行 | 计算引擎类型 | power on yarn（for example）', '1', '1', '2017-05-17 15:25:50', 'admin', '2017-05-17 15:25:50', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40034', '组件参数 | 机器学习 | 正则项类型 | None', 'None', '0', '2017-05-12 02:06:11', 'admin', '2017-05-12 02:06:11', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40034', '组件参数 | 机器学习 | 正则项类型 | L1', 'L1', '1', '2017-05-12 02:07:04', 'admin', '2017-05-12 02:07:04', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40034', '组件参数 | 机器学习 | 正则项类型 | L2', 'L2', '2', '2017-05-12 02:07:39', 'admin', '2017-05-12 02:07:39', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40500406', '专用组件参数 | 机器学习 | GBDT二分类 | 指标类型 | NDCG', '0', '0', '2017-05-18 11:34:23', 'admin', '2017-05-18 11:34:23', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40500406', '专用组件参数 | 机器学习 | GBDT二分类 | 指标类型 | DCG', '1', '1', '2017-05-18 11:34:47', 'admin', '2017-05-18 11:34:47', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40510001', '专用组件参数 | 机器学习 | KMeans | 距离度量方式 | Euclidean', 'euclidean', '0', '2017-05-17 21:03:39', 'admin', '2017-05-17 21:03:48', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40510001', '专用组件参数 | 机器学习 | KMeans | 距离度量方式 | Cosine', 'cosine', '1', '2017-05-17 21:04:16', 'admin', '2017-05-17 21:04:16', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40510001', '专用组件参数 | 机器学习 | KMeans | 距离度量方式 | Cityblock', 'cityblock', '2', '2017-05-17 21:05:03', 'admin', '2017-05-17 21:05:03', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40510002', '专用组件参数 | 机器学习 | KMeans | 质心初始化方法 | Random', 'random', '0', '2017-05-17 21:13:49', 'admin', '2017-05-17 21:13:49', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40510002', '专用组件参数 | 机器学习 | KMeans | 质心初始化方法 | Top-K', 'topk', '1', '2017-05-17 21:14:51', 'admin', '2017-05-17 21:14:51', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40510002', '专用组件参数 | 机器学习 | KMeans | 质心初始化方法 | Uniform', 'uniform', '2', '2017-05-17 21:15:12', 'admin', '2017-05-17 21:15:12', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40510002', '专用组件参数 | 机器学习 | KMeans | 质心初始化方法 | K-Means++', 'kmpp', '3', '2017-05-17 21:15:55', 'admin', '2017-05-17 21:15:55', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40510002', '专用组件参数 | 机器学习 | KMeans | 质心初始化方法 | 使用初始质心表', 'external', '4', '2017-05-17 21:16:46', 'admin', '2017-05-17 21:16:46', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40520100', '专用组件参数 | 机器学习 | GBDT回归 | 损失函数类型 | gbrank loss', '0', '0', '2017-05-18 11:50:28', 'admin', '2017-05-18 11:50:28', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40520100', '专用组件参数 | 机器学习 | GBDT回归 | 损失函数类型 | lambdamart dcg loss', '1', '1', '2017-05-18 11:50:57', 'admin', '2017-05-18 11:50:57', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40520100', '专用组件参数 | 机器学习 | GBDT回归 | 损失函数类型 | lambdamart ndcg loss', '2', '2', '2017-05-18 11:51:26', 'admin', '2017-05-18 11:51:26', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40520100', '专用组件参数 | 机器学习 | GBDT回归 | 损失函数类型 | regression loss', '3', '3', '2017-05-18 11:52:04', 'admin', '2017-05-18 11:52:04', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40520103', '专用组件参数 | 机器学习 | GBDT回归 | 指标类型 | NDCG', '0', '0', '2017-05-18 11:34:23', 'admin', '2017-05-18 11:34:23', 'admin');
INSERT INTO `pcf_cmpt_spec_char_enum` VALUES ('40520103', '专用组件参数 | 机器学习 | GBDT回归 | 指标类型 | DCG', '1', '1', '2017-05-18 11:34:47', 'admin', '2017-05-18 11:34:47', 'admin');

-- ----------------------------
-- Table structure for pcf_cmpt_spec_char_type_def
-- ----------------------------
DROP TABLE IF EXISTS `pcf_cmpt_spec_char_type_def`;
CREATE TABLE `pcf_cmpt_spec_char_type_def` (
  `CHAR_TYPE_ID` int(11) NOT NULL COMMENT '特征类型ID\r\n            \r\n            0：SmallInt，16位整数\r\n            1：Int，32为整数\r\n            2：BigInt，64位整数\r\n            3：Float，单精度浮点数\r\n            4：Double，双精度浮点数\r\n            5：String，字符串\r\n            6：Date，日期，为“yyyy-mm-dd”格式字符串\r\n            7：DateTime，日期时间，为“yyyy-mm-dd hh24:mi:ss”格式字符串\r\n            \r\n            ------------------------ 以下是业务对象数据类型 ------------------------ \r\n            \r\n            100：Algorithm，算法，特征值为算法ID字符串\r\n            101：Data Table，数据表，特征值为数据表ID字符串\r\n            102：Model，模型，特征值为模型ID字符串\r\n            200：SQL Script，SQL脚本，特征值为脚本ID字符串\r\n            201：Python Script，Python脚本，特征值为脚本ID字符串\r\n            202：RScript，R脚本，特征值为脚本ID字符串\r\n            203：Feature Preprocess Script，特征预处理脚本，特征值为脚本ID字符串\r\n            1000：Statistics Analysis Report，统计分析报告，特征值为JSON数据ID字符串\r\n            1001：Model Evaluation Report，模型评估报告，特征值为JSON数据ID字符串\r\n            1002：Smart Rules，智能规则，特征值为JSON数据ID字符串\r\n            9999：Json Data，json数据，特征值为JSON数据ID字符串',
  `CHAR_TYPE_CODE` varchar(200) NOT NULL COMMENT '特征类型代码',
  `CHAR_TYPE_NAME` varchar(200) NOT NULL COMMENT '特征类型名称',
  `CHAR_TYPE_DESC` varchar(800) DEFAULT NULL COMMENT '特征类型描述',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CHAR_TYPE_ID`),
  UNIQUE KEY `Index_1` (`CHAR_TYPE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组件规格特征类型定义表';

-- ----------------------------
-- Records of pcf_cmpt_spec_char_type_def
-- ----------------------------
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('1', 'Boolean', '布尔值', '特征值为true/false字符串', '2017-05-12 00:42:11', 'admin', '2017-05-12 00:42:11', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('2', 'SmallInt', '16位整数', null, '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('3', 'Int', '32为整数', null, '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('4', 'BigInt', '64位整数', null, '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('5', 'Float', '单精度浮点数', null, '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('6', 'Double', '双精度浮点数', null, '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('7', 'String', '字符串', null, '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('8', 'Date', '日期', '特征值为“yyyy-mm-dd”格式字符串', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('9', 'DateTime', '日期时间', '特征值为“yyyy-mm-dd hh24:mi:ss”格式字符串', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('100', 'Algorithm', '算法', '特征值为算法ID字符串', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('101', 'Data Table', '数据表', '特征值为数据表ID字符串', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('102', 'Trained Model', '已训练模型', '特征值为模型ID字符串', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('200', 'SQL Script', 'SQL脚本', '特征值为脚本ID字符串', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('201', 'Python Script', 'Python脚本', '特征值为脚本ID字符串', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('202', 'RScript', 'R脚本', '特征值为脚本ID字符串', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('1000', 'Statistics Analysis Report', '统计分析报告', '特征值为JSON数据ID字符串', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('1001', 'Model Evaluation Report', '模型评估报告', '特征值为JSON数据ID字符串', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('1002', 'Smart Rules', '智能规则', '特征值为JSON数据ID字符串', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `pcf_cmpt_spec_char_type_def` VALUES ('9999', 'Json Data', 'json数据', '特征值为JSON数据ID字符串', '2017-05-12 00:31:39', 'admin', '2017-05-12 00:31:39', 'admin');

-- ----------------------------
-- Table structure for pcf_cmpt_spec_char_use
-- ----------------------------
DROP TABLE IF EXISTS `pcf_cmpt_spec_char_use`;
CREATE TABLE `pcf_cmpt_spec_char_use` (
  `SPEC_ID` bigint(20) NOT NULL COMMENT '组件规格ID',
  `CHAR_ID` bigint(20) NOT NULL COMMENT '特征ID',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SPEC_ID`,`CHAR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组件规格使用特征表，要求同一规格下特征代码和特征别名唯一';

-- ----------------------------
-- Records of pcf_cmpt_spec_char_use
-- ----------------------------
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1', '1', '2017-05-18 17:42:55', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('2', '1', '2017-05-18 17:42:51', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('2', '2', '2017-05-18 17:42:51', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('3', '1', '2017-05-18 17:42:47', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('3', '2', '2017-05-18 17:42:47', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('3', '3', '2017-05-18 17:42:47', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('4', '1', '2017-05-18 17:42:42', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('4', '2', '2017-05-18 17:42:42', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('4', '3', '2017-05-18 17:42:42', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('4', '4', '2017-05-18 17:42:42', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('5', '1', '2017-05-18 17:42:37', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('5', '2', '2017-05-18 17:42:37', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('5', '3', '2017-05-18 17:42:37', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('5', '4', '2017-05-18 17:42:37', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('5', '5', '2017-05-18 17:42:37', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('6', '1', '2017-05-18 17:42:27', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('6', '2', '2017-05-18 17:42:27', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('6', '3', '2017-05-18 17:42:27', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('6', '4', '2017-05-18 17:42:27', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('6', '5', '2017-05-18 17:42:27', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('6', '6', '2017-05-18 17:42:27', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('11', '11', '2017-05-18 17:45:03', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('21', '1', '2017-05-18 17:45:36', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('21', '11', '2017-05-18 17:45:42', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1001', '10001', '2017-05-18 17:46:54', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1002', '10001', '2017-05-18 17:46:59', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1002', '10002', '2017-05-18 17:46:59', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1003', '10001', '2017-05-18 17:47:03', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1003', '10002', '2017-05-18 17:47:03', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1003', '10003', '2017-05-18 17:47:03', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1004', '10001', '2017-05-18 17:47:09', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1004', '10002', '2017-05-18 17:47:09', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1004', '10003', '2017-05-18 17:47:09', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1004', '10004', '2017-05-18 17:47:09', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1005', '10001', '2017-05-18 17:47:14', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1005', '10002', '2017-05-18 17:47:14', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1005', '10003', '2017-05-18 17:47:14', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1005', '10004', '2017-05-18 17:47:14', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1005', '10005', '2017-05-18 17:47:14', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1006', '10001', '2017-05-18 17:47:19', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1006', '10002', '2017-05-18 17:47:19', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1006', '10003', '2017-05-18 17:47:19', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1006', '10004', '2017-05-18 17:47:19', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1006', '10005', '2017-05-18 17:47:19', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1006', '10006', '2017-05-18 17:47:19', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1011', '10011', '2017-05-18 17:48:20', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1021', '10021', '2017-05-18 17:49:02', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1022', '10022', '2017-05-18 17:49:22', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('1023', '10023', '2017-05-18 17:49:39', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('2000', '20000', '2017-05-18 17:51:05', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('2000', '20001', '2017-05-18 17:51:05', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('2000', '20002', '2017-05-18 17:51:05', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('2000', '20100', '2017-05-18 17:51:05', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('2000', '20101', '2017-05-18 17:51:05', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('2000', '20102', '2017-05-18 17:51:05', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('3000', '30000', '2017-05-18 17:52:07', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('3000', '30001', '2017-05-18 17:52:07', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('3000', '30002', '2017-05-18 17:52:07', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('3000', '30003', '2017-05-18 17:52:07', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('400000', '40000000', '2017-05-18 17:55:02', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('400001', '40000100', '2017-05-18 17:55:24', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('400002', '40000200', '2017-06-06 17:19:41', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('401000', '40100000', '2017-05-18 17:55:55', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('401001', '40100100', '2017-05-18 17:56:20', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('401002', '40100200', '2017-05-18 17:57:24', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405001', '40000', '2017-05-19 19:24:23', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405001', '40001', '2017-05-18 18:16:25', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405001', '40002', '2017-05-18 18:16:25', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405001', '40020', '2017-05-18 18:16:25', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405001', '40030', '2017-05-18 18:16:25', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405001', '40032', '2017-05-18 18:16:25', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405001', '40034', '2017-05-18 18:16:25', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405001', '40035', '2017-05-18 18:16:25', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405002', '40000', '2017-05-19 19:24:23', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405002', '40001', '2017-05-18 19:36:15', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405002', '40020', '2017-05-18 19:36:15', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405002', '40030', '2017-05-18 19:36:15', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405002', '40032', '2017-05-18 19:36:15', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405002', '40034', '2017-05-18 19:36:15', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405002', '40035', '2017-05-18 19:36:15', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405003', '40000', '2017-05-19 19:24:23', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405003', '40001', '2017-05-18 20:28:04', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405003', '40003', '2017-05-18 20:28:04', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405003', '40020', '2017-05-18 20:28:04', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405003', '40021', '2017-05-18 20:28:04', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405003', '40023', '2017-05-18 20:28:04', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405003', '40500300', '2017-05-18 20:28:04', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405003', '40500301', '2017-05-18 20:28:04', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405003', '40500302', '2017-05-18 20:28:04', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405003', '40500303', '2017-05-18 20:28:04', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405003', '40500304', '2017-05-18 20:28:04', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405003', '40500305', '2017-05-18 20:28:04', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405004', '40000', '2017-05-19 19:24:23', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405004', '40001', '2017-05-18 20:35:59', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405004', '40004', '2017-05-18 20:35:59', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405004', '40020', '2017-05-18 20:35:59', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405004', '40033', '2017-05-18 20:35:59', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405004', '40500400', '2017-05-18 20:35:59', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405004', '40500401', '2017-05-18 20:35:59', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405004', '40500402', '2017-05-18 20:35:59', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405004', '40500403', '2017-05-18 20:35:59', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405004', '40500404', '2017-05-18 20:35:59', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405004', '40500405', '2017-05-18 20:35:59', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405004', '40500406', '2017-05-18 20:35:59', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405004', '40500407', '2017-05-18 20:35:59', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405004', '40500408', '2017-05-18 20:35:59', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405004', '40500409', '2017-05-18 20:35:59', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405005', '40000', '2017-05-19 19:24:23', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405005', '40001', '2017-05-18 20:38:44', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405005', '40002', '2017-05-18 20:38:44', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405005', '40020', '2017-05-18 20:38:44', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405005', '40032', '2017-05-18 20:38:44', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405005', '40500500', '2017-05-18 20:38:44', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405005', '40500501', '2017-05-18 20:38:44', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405006', '40000', '2017-05-19 19:24:23', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405006', '40001', '2017-05-18 20:41:07', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405006', '40020', '2017-05-18 20:41:07', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405006', '40021', '2017-05-18 20:41:07', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405006', '40023', '2017-05-18 20:41:07', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405007', '40000', '2017-05-19 19:24:23', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405007', '40001', '2017-05-18 20:51:39', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405007', '40020', '2017-05-18 20:51:39', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405007', '40022', '2017-05-18 20:51:39', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405007', '40500700', '2017-05-18 20:51:39', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405100', '40000', '2017-05-19 19:24:23', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405100', '40020', '2017-05-18 20:54:44', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405100', '40022', '2017-05-18 20:54:44', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405100', '40030', '2017-05-18 20:54:44', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405100', '40032', '2017-05-18 20:55:48', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405100', '40033', '2017-05-18 20:54:44', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405100', '40510000', '2017-05-18 20:54:44', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405100', '40510001', '2017-05-18 20:54:44', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405100', '40510002', '2017-05-18 20:54:44', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405200', '40000', '2017-05-19 19:24:23', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405200', '40001', '2017-05-18 20:59:11', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405200', '40020', '2017-05-18 20:59:11', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405200', '40030', '2017-05-18 20:59:11', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405200', '40032', '2017-05-18 20:59:11', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405200', '40034', '2017-05-18 20:59:11', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405200', '40035', '2017-05-18 20:59:11', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40000', '2017-05-19 19:24:23', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40001', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40004', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40020', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40033', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40520100', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40520101', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40520102', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40520103', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40520104', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40520105', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40520106', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40520107', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40520108', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40520109', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40520110', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40520111', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40520112', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405201', '40520113', '2017-05-18 21:01:56', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405300', '40000', '2017-05-19 19:24:23', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405301', '40000', '2017-05-19 19:24:23', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405400', '40000', '2017-05-19 19:24:23', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405401', '40000', '2017-05-19 19:24:23', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405900', '40010', '2017-05-18 21:05:32', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405900', '40011', '2017-05-18 21:05:32', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405900', '40012', '2017-05-18 21:05:32', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405900', '40020', '2017-05-18 21:05:32', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405900', '40022', '2017-05-18 21:05:32', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405901', '40001', '2017-05-18 21:08:57', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405901', '40002', '2017-05-18 21:08:57', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405901', '40004', '2017-05-18 21:08:57', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405901', '40011', '2017-05-18 21:08:57', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405901', '40012', '2017-05-18 21:08:57', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405901', '40590100', '2017-05-18 21:08:57', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405902', '40001', '2017-05-18 21:10:58', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405902', '40010', '2017-05-18 21:10:58', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405902', '40012', '2017-05-18 21:10:58', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405903', '40001', '2017-05-18 21:18:35', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405903', '40011', '2017-05-18 21:18:35', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405903', '40020', '2017-05-18 21:17:51', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405904', '40001', '2017-05-24 20:03:14', 'admin');
INSERT INTO `pcf_cmpt_spec_char_use` VALUES ('405904', '40011', '2017-05-24 20:03:26', 'admin');

-- ----------------------------
-- Table structure for pcf_cmpt_spec_char_value
-- ----------------------------
DROP TABLE IF EXISTS `pcf_cmpt_spec_char_value`;
CREATE TABLE `pcf_cmpt_spec_char_value` (
  `SPEC_ID` bigint(20) NOT NULL COMMENT '组件规格ID',
  `CHAR_ID` bigint(20) NOT NULL COMMENT '特征ID',
  `IS_SYSTEM_PARAM` int(11) NOT NULL COMMENT '特征值内容是否为系统参数\r\n            0：否\r\n            1：是',
  `CHAR_VALUE` varchar(2000) DEFAULT NULL COMMENT '特征值',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SPEC_ID`,`CHAR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组件规格特征值设置表';

-- ----------------------------
-- Records of pcf_cmpt_spec_char_value
-- ----------------------------
INSERT INTO `pcf_cmpt_spec_char_value` VALUES ('2000', '20000', '0', '0', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `pcf_cmpt_spec_char_value` VALUES ('2000', '20001', '1', 'HADOOP_YARN_RM_HOSTNAME', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `pcf_cmpt_spec_char_value` VALUES ('2000', '20002', '1', 'HADOOP_YARN_RM_SCHEDULER_PORT', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `pcf_cmpt_spec_char_value` VALUES ('2000', '20100', '1', 'PCF_HDFS_JAR_DIR', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');

-- ----------------------------
-- Table structure for pcf_cmpt_spec_def
-- ----------------------------
DROP TABLE IF EXISTS `pcf_cmpt_spec_def`;
CREATE TABLE `pcf_cmpt_spec_def` (
  `SPEC_ID` bigint(20) NOT NULL COMMENT '组件规格ID\r\n            \r\n            输入内容规格\r\n            规格ID范围：0 ~ 999\r\n            \r\n            输出内容规格\r\n            规格ID范围：1000 ~ 1999\r\n            \r\n            调用执行规格\r\n            规格ID范围：2000 ~ 2999\r\n            \r\n            执行调优参数规格\r\n            规格ID范围：3000 ~ 3999\r\n            \r\n            组件参数规格\r\n            规格ID值组成：4 + 五位组件ID',
  `SPEC_NAME` varchar(200) NOT NULL COMMENT '组件规格名称',
  `SPEC_TYPE` int(11) NOT NULL COMMENT '组件规格类型\r\n            0：input，输入内容规格（无此类规格代表无输入内容）\r\n            1：output，输出内容规格（无此类规格代表无输出内容）\r\n            2：execution，调用执行规格（无此类规格代表无需执行）\r\n            3：execution_optimize，执行调优参数规格（无此类规格代表无执行调优参数）\r\n            4：parameter，组件参数规格（无此类规格代表无需组件参数配置）',
  `SPEC_DESC` varchar(800) DEFAULT NULL COMMENT '组件规格描述',
  `STATUS` int(11) NOT NULL COMMENT '组件规格状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SPEC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组件规格定义表';

-- ----------------------------
-- Records of pcf_cmpt_spec_def
-- ----------------------------
INSERT INTO `pcf_cmpt_spec_def` VALUES ('1', '输入内容 | 一个数据表t1<M>', '0', null, '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('2', '输入内容 | 二个数据表t1<M>,t2<C>', '0', null, '0', '2017-05-17 14:26:05', 'admin', '2017-05-17 14:26:05', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('3', '输入内容 | 三个数据表t1<M>,t2<C>,t3<C>', '0', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('4', '输入内容 | 四个数据表t1<M>,t2<C>,t3<C>,t4<C>', '0', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('5', '输入内容 | 五个数据表t1<M>,t2<C>,t3<C>,t4<C>,t5<C>', '0', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('6', '输入内容 | 六个数据表t1<M>,t2<C>,t3<C>,t4<C>,t5<C>,t6<C>', '0', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('11', '输入内容 | 一个模型m1<M>', '0', null, '0', '2017-05-17 14:33:20', 'admin', '2017-05-17 14:33:20', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('21', '输入内容 | 一个模型m1<M> + 一个数据表t1<M>', '0', null, '0', '2017-05-17 14:44:42', 'admin', '2017-05-17 14:44:42', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('1001', '输出内容 | 一个数据表t1<M>', '1', null, '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('1002', '输出内容 | 二个数据表t1<M>,t2<M>', '1', null, '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('1003', '输出内容 | 三个数据表t1<M>,t2<M>,t3<M>', '1', null, '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('1004', '输出内容 | 四个数据表t1<M>,t2<M>,t3<M>,t4<M>', '1', null, '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('1005', '输出内容 | 五个数据表t1<M>,t2<M>,t3<M>,t4<M>,t5<M>', '1', null, '0', '2017-05-17 14:58:17', 'admin', '2017-05-17 14:58:17', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('1006', '输出内容 | 六个数据表t1<M>,t2<M>,t3<M>,t4<M>,t5<M>,t6<M>', '1', null, '0', '2017-05-17 14:58:17', 'admin', '2017-05-17 14:58:17', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('1011', '输出内容 | 一个模型m1<M>', '1', null, '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('1021', '输出内容 | 统计分析报告report', '1', null, '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('1022', '输出内容 | 模型评估报告report', '1', null, '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('1023', '输出内容 | 智能规则rules', '1', null, '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('2000', '调用执行 | spark on yarn', '2', null, '0', '2017-05-17 15:08:09', 'admin', '2017-05-17 15:08:09', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('3000', '执行调优 | spark optimize configuration', '3', null, '0', '2017-05-17 15:10:21', 'admin', '2017-05-17 15:10:21', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('400000', '组件参数 | 输入输出 | 读数据表', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('400001', '组件参数 | 输入输出 | 读模型', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('400002', '组件参数 | 输入输出 | 写数据表', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('401000', '组件参数 | 脚本工具 | SQL脚本', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('401001', '组件参数 | 脚本工具 | Python脚本（待定）', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('401002', '组件参数 | 脚本工具 | R脚本（待定）', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405001', '组件参数 | 机器学习 | 逻辑回归二分类', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405002', '组件参数 | 机器学习 | 逻辑回归多分类', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405003', '组件参数 | 机器学习 | 随机森林分类', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405004', '组件参数 | 机器学习 | GBDT二分类', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405005', '组件参数 | 机器学习 | 线性支持向量机二分类', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405006', '组件参数 | 机器学习 | 朴素贝叶斯多分类', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405007', '组件参数 | 机器学习 | K近邻多分类', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405100', '组件参数 | 机器学习 | K均值聚类', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405200', '组件参数 | 机器学习 | 线性回归', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405201', '组件参数 | 机器学习 | GBDT回归', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405300', '组件参数 | 机器学习 | Apriori关联规则（待定）', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405301', '组件参数 | 机器学习 | FP-Growth关联规则（待定）', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405400', '组件参数 | 机器学习 | ALS协同过滤（待定）', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405401', '组件参数 | 机器学习 | LFM协同过滤（待定）', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405900', '组件参数 | 机器学习 | 预测', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405901', '组件参数 | 机器学习 | 二分类评估', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405902', '组件参数 | 机器学习 | 多分类评估', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405903', '组件参数 | 机器学习 | 聚类模型评估', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405904', '组件参数 | 机器学习 | 回归模型评估', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405905', '组件参数 | 机器学习 | 关联规则评估（待定）', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405906', '组件参数 | 机器学习 | 协同过滤评估（待定）', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405998', '组件参数 | 机器学习 | 自动调参（GridSearchCV）（待定）', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `pcf_cmpt_spec_def` VALUES ('405999', '组件参数 | 机器学习 | 智能规则（待定）', '4', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');

-- ----------------------------
-- Table structure for pcf_cmpt_spec_use
-- ----------------------------
DROP TABLE IF EXISTS `pcf_cmpt_spec_use`;
CREATE TABLE `pcf_cmpt_spec_use` (
  `CMPT_ID` bigint(20) NOT NULL COMMENT '组件ID',
  `SPEC_ID` bigint(20) NOT NULL COMMENT '组件规格ID',
  `SPEC_TYPE` int(11) NOT NULL COMMENT '组件规格类型\r\n            0：input，输入内容规格\r\n            1：output，输出内容规格\r\n            2：execution，调用执行规格\r\n            3：execution_optimize，执行调优参数规格\r\n            4：parameter，组件参数规格',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CMPT_ID`,`SPEC_TYPE`),
  UNIQUE KEY `Index_1` (`CMPT_ID`,`SPEC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组件使用规格表';

-- ----------------------------
-- Records of pcf_cmpt_spec_use
-- ----------------------------
INSERT INTO `pcf_cmpt_spec_use` VALUES ('1', '1001', '1', '2017-05-24 18:08:12', 'admin', '2017-05-24 18:08:12', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('1', '400000', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('2', '1011', '1', '2017-05-24 18:08:37', 'admin', '2017-05-24 18:08:37', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('2', '400001', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('3', '1', '0', '2017-06-06 17:36:11', 'admin', '2017-06-06 17:36:11', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('3', '1001', '1', '2017-06-06 17:36:32', 'admin', '2017-06-06 17:36:32', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('3', '400002', '4', '2017-06-06 17:37:11', 'admin', '2017-06-06 17:37:11', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('1000', '6', '0', '2017-05-24 18:09:15', 'admin', '2017-05-24 18:09:15', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('1000', '1001', '1', '2017-05-24 18:09:43', 'admin', '2017-05-24 18:09:43', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('1000', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('1000', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('1000', '401000', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5001', '1', '0', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5001', '1011', '1', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5001', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5001', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5001', '405001', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5002', '1', '0', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5002', '1011', '1', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5002', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5002', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5002', '405002', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5003', '1', '0', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5003', '1011', '1', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5003', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5003', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5003', '405003', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5004', '1', '0', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5004', '1011', '1', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5004', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5004', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5004', '405004', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5005', '1', '0', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5005', '1011', '1', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5005', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5005', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5005', '405005', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5006', '1', '0', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5006', '1011', '1', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5006', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5006', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5006', '405006', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5007', '1', '0', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5007', '1011', '1', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5007', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5007', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5007', '405007', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5100', '1', '0', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5100', '1011', '1', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5100', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5100', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5100', '405100', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5200', '1', '0', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5200', '1011', '1', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5200', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5200', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5200', '405200', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5201', '1', '0', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5201', '1011', '1', '2017-05-24 18:40:39', 'admin', '2017-05-24 18:40:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5201', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5201', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5201', '405201', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5900', '21', '0', '2017-05-24 18:41:31', 'admin', '2017-05-24 18:41:31', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5900', '1001', '1', '2017-05-24 18:41:54', 'admin', '2017-05-24 18:41:54', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5900', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5900', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5900', '405900', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5901', '1', '0', '2017-05-24 18:44:25', 'admin', '2017-05-24 18:44:25', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5901', '1022', '1', '2017-05-24 18:45:10', 'admin', '2017-05-24 18:45:10', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5901', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5901', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5901', '405901', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5902', '1', '0', '2017-05-24 18:44:25', 'admin', '2017-05-24 18:44:25', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5902', '1022', '1', '2017-05-24 18:45:10', 'admin', '2017-05-24 18:45:10', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5902', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5902', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5902', '405902', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5903', '1', '0', '2017-05-24 18:44:25', 'admin', '2017-05-24 18:44:25', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5903', '1022', '1', '2017-05-24 18:45:10', 'admin', '2017-05-24 18:45:10', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5903', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5903', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5903', '405903', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5904', '1', '0', '2017-05-24 18:44:25', 'admin', '2017-05-24 18:44:25', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5904', '1022', '1', '2017-05-24 18:45:10', 'admin', '2017-05-24 18:45:10', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5904', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5904', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5904', '405904', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5998', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5998', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5998', '405998', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5999', '2000', '2', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5999', '3000', '3', '2017-05-24 18:15:39', 'admin', '2017-05-24 18:15:39', 'admin');
INSERT INTO `pcf_cmpt_spec_use` VALUES ('5999', '405999', '4', '2017-05-24 18:06:50', 'admin', '2017-05-24 18:06:50', 'admin');

-- ----------------------------
-- Table structure for pr_experiment
-- ----------------------------
DROP TABLE IF EXISTS `pr_experiment`;
CREATE TABLE `pr_experiment` (
  `EXPERIMENT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '实验ID',
  `EXPERIMENT_NAME` varchar(200) NOT NULL COMMENT '实验名称',
  `EXPERIMENT_TYPE` varchar(200) NOT NULL DEFAULT '0' COMMENT '实验类型（预留）\r\n            0：默认',
  `PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `FLOW_ID` bigint(20) NOT NULL COMMENT '实验主版本流程图ID',
  `SEQUENCE` int(11) NOT NULL COMMENT '实验序号',
  `LAST_EXECUTION_ID` bigint(20) DEFAULT NULL COMMENT '最后任务运行ID',
  `EXPERIMENT_DESC` varchar(800) DEFAULT NULL COMMENT '实验描述',
  `STATUS` int(11) NOT NULL COMMENT '实验状态\r\n            0：正常\r\n            1：失效\r\n            \r\n            实验运行状态，结合任务运行状态和节点实例状态确定：\r\n            0：default，非运行状态\r\n            1：preparing，准备中\r\n            2：running，运行中',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`EXPERIMENT_ID`),
  UNIQUE KEY `Index_1` (`PROJECT_ID`,`EXPERIMENT_NAME`),
  KEY `Index_2` (`PROJECT_ID`,`SEQUENCE`),
  KEY `Index_3` (`PROJECT_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实验信息表';

-- ----------------------------
-- Records of pr_experiment
-- ----------------------------

-- ----------------------------
-- Table structure for pr_experiment_version
-- ----------------------------
DROP TABLE IF EXISTS `pr_experiment_version`;
CREATE TABLE `pr_experiment_version` (
  `VERSION_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '实验版本ID',
  `VERSION_NAME` varchar(200) NOT NULL COMMENT '实验版本名称',
  `EXPERIMENT_ID` bigint(20) NOT NULL COMMENT '所属实验ID',
  `VERSION` int(11) NOT NULL COMMENT '实验版本序号',
  `FLOW_ID` bigint(20) NOT NULL COMMENT '实验版本流程图ID',
  `VERSION_DESC` varchar(800) DEFAULT NULL COMMENT '实验版本描述',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`VERSION_ID`),
  UNIQUE KEY `Index_1` (`EXPERIMENT_ID`,`VERSION_NAME`),
  KEY `Index_2` (`EXPERIMENT_ID`,`VERSION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实验版本信息表';

-- ----------------------------
-- Records of pr_experiment_version
-- ----------------------------

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
  `PROJECT_DESC` varchar(800) DEFAULT NULL COMMENT '项目描述',
  `STATUS` int(11) NOT NULL COMMENT '项目状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PROJECT_ID`),
  UNIQUE KEY `Index_1` (`PROJECT_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目信息表';

-- ----------------------------
-- Records of pr_project
-- ----------------------------

-- ----------------------------
-- Table structure for pr_project_member
-- ----------------------------
DROP TABLE IF EXISTS `pr_project_member`;
CREATE TABLE `pr_project_member` (
  `PROJECT_ID` bigint(20) NOT NULL COMMENT '项目ID',
  `IS_OWNER` int(11) DEFAULT '0' COMMENT '是否为项目所有者\r\n            0：否\r\n            1：是',
  `MEMBER_USER` varchar(100) NOT NULL COMMENT '项目成员用户名',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PROJECT_ID`,`MEMBER_USER`),
  KEY `Index_1` (`MEMBER_USER`),
  KEY `Index_2` (`PROJECT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目成员表';

-- ----------------------------
-- Records of pr_project_member
-- ----------------------------

-- ----------------------------
-- Table structure for sys_parameter
-- ----------------------------
DROP TABLE IF EXISTS `sys_parameter`;
CREATE TABLE `sys_parameter` (
  `PARAM_ID` bigint(20) NOT NULL COMMENT '参数ID',
  `PARAM_CODE` varchar(200) NOT NULL COMMENT '参数代码',
  `PARAM_NAME` varchar(200) NOT NULL COMMENT '参数名称',
  `PARAM_CLASS` int(11) NOT NULL COMMENT '参数类别，按系统模块划分',
  `SUB_CLASS` int(11) NOT NULL COMMENT '参数子类别，按系统模块下的功能模块划分',
  `PARAM_VALUE` varchar(400) NOT NULL COMMENT '参数值',
  `PARAM_DESC` varchar(800) DEFAULT NULL COMMENT '参数描述',
  `STATUS` int(11) NOT NULL COMMENT '参数状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PARAM_ID`),
  UNIQUE KEY `Index_1` (`PARAM_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数表';

-- ----------------------------
-- Records of sys_parameter
-- ----------------------------
INSERT INTO `sys_parameter` VALUES ('0', 'HADOOP_YARN_RM_HOSTNAME', 'hadoop.yarn.resourcemanager主机名', '-1', '-1', '10.100.1.210', 'hadoop.yarn.resourcemanager主机名（IP/主机名/域名）', '0', '2017-05-19 15:03:31', 'admin', '2017-05-19 15:03:31', 'admin');
INSERT INTO `sys_parameter` VALUES ('1', 'HADOOP_YARN_RM_SCHEDULER_PORT', 'hadoop.yarn.resourcemanager调度端口', '-1', '-1', '8030', 'hadoop.yarn.resourcemanager调度端口', '0', '2017-05-19 15:09:42', 'admin', '2017-05-19 15:09:42', 'admin');
INSERT INTO `sys_parameter` VALUES ('2', 'HADOOP_HDFS_NAMENODE_HOSTNAME', 'hadoop.hdfs.namenode主机名', '-1', '-1', '10.100.1.210', 'hadoop.hdfs.namenode主机名（IP/主机名/域名）', '0', '2017-05-19 15:12:23', 'admin', '2017-05-19 15:12:23', 'admin');
INSERT INTO `sys_parameter` VALUES ('3', 'HADOOP_HDFS_NAMENODE_PORT', 'hadoop.hdfs.namenode端口', '-1', '-1', '9000', 'hadoop.hdfs.namenode端口', '0', '2017-05-19 15:16:44', 'admin', '2017-05-19 15:16:44', 'admin');
INSERT INTO `sys_parameter` VALUES ('10000', 'PCF_HDFS_BASE_DIR', 'POWER计算框架HDFS工作目录', '-1', '-1', '/user/mls/', 'POWER计算框架HDFS工作目录', '0', '2017-05-19 15:26:23', 'admin', '2017-05-19 15:26:23', 'admin');
INSERT INTO `sys_parameter` VALUES ('10001', 'PCF_HDFS_EXEC_DIR', 'POWER计算框架HDFS运行目录', '-1', '-1', '/user/mls/proc', 'POWER计算框架HDFS运行目录', '0', '2017-05-19 15:42:06', 'admin', '2017-05-19 15:42:06', 'admin');
INSERT INTO `sys_parameter` VALUES ('10002', 'PCF_HDFS_JSON_DIR', 'POWER计算框架HDFS json数据目录', '-1', '-1', '/user/mls/json_data', 'POWER计算框架HDFS json数据目录', '0', '2017-05-19 15:46:12', 'admin', '2017-05-19 15:46:12', 'admin');
INSERT INTO `sys_parameter` VALUES ('10003', 'PCF_HDFS_DW_DIR', 'POWER计算框架HDFS数据仓库目录', '-1', '-1', '/user/mls/dw_data', 'POWER计算框架HDFS数据仓库目录', '0', '2017-05-19 15:48:43', 'admin', '2017-05-19 15:48:43', 'admin');
INSERT INTO `sys_parameter` VALUES ('10004', 'PCF_HDFS_MW_DIR', 'POWER计算框架HDFS模型仓库目录', '-1', '-1', '/user/mls/mw_data', 'POWER计算框架HDFS模型仓库目录', '0', '2017-05-19 15:49:41', 'admin', '2017-05-19 15:49:41', 'admin');
INSERT INTO `sys_parameter` VALUES ('10005', 'PCF_HDFS_JAR_DIR', 'POWER计算框架HDFS jar库目录', '-1', '-1', '/user/mls/lib', 'POWER计算框架HDFS jar库目录', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');

-- ----------------------------
-- Table structure for wf_code_script
-- ----------------------------
DROP TABLE IF EXISTS `wf_code_script`;
CREATE TABLE `wf_code_script` (
  `SCRIPT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '脚本ID',
  `SCRIPT_NAME` varchar(200) NOT NULL COMMENT '脚本名称\r\n            script_<node_code>_<node_instance_id>',
  `SCRIPT_CONTENT` mediumblob COMMENT '脚本内容',
  `MODIFY_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '内容修改时间',
  `STATUS` int(11) NOT NULL COMMENT '脚本状态\r\n            0：正常\r\n            1：空脚本',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SCRIPT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代码脚本表';

-- ----------------------------
-- Records of wf_code_script
-- ----------------------------

-- ----------------------------
-- Table structure for wf_execution
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution`;
CREATE TABLE `wf_execution` (
  `EXECUTION_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务运行ID',
  `EXECUTION_TYPE` int(11) NOT NULL COMMENT '任务运行类型\r\n            0：全部运行\r\n            1：从此处开始运行\r\n            2：执行到此处\r\n            3：执行该节点\r\n            99：非实验中的实例节点运行（预留）',
  `PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `EXPERIMENT_ID` bigint(20) NOT NULL COMMENT '实验ID，无关联实验设为-1',
  `NODE_INSTANCE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '节点实例ID',
  `EXECUTION_HOME_DIR` varchar(800) NOT NULL COMMENT '任务运行工作目录\r\n            hdfs://namenode_host:port/user/mls/proc/<project_id>/<experiment_id>/<execution_id>\r\n            hdfs://namenode_host:port/user/mls/proc/<project_id>/other/<execution_id>',
  `EXECUTION_DESC` varchar(800) NOT NULL COMMENT '任务运行描述',
  `STATUS` int(11) NOT NULL COMMENT '任务运行状态\r\n            0：queuing，排队中\r\n            1：preparing，准备中\r\n            2：running，运行中\r\n            3：complete，运行完成\r\n            4：terminate，用户停止',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`EXECUTION_ID`),
  KEY `Index_1` (`EXPERIMENT_ID`,`CREATE_TIME`),
  KEY `Index_2` (`EXPERIMENT_ID`,`STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务运行信息表';

-- ----------------------------
-- Records of wf_execution
-- ----------------------------

-- ----------------------------
-- Table structure for wf_execution_node
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution_node`;
CREATE TABLE `wf_execution_node` (
  `EXECUTION_NODE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '运行节点ID',
  `EXECUTION_ID` bigint(20) NOT NULL COMMENT '所属任务运行ID',
  `EXECUTION_PATH_ID` bigint(20) NOT NULL COMMENT '运行路径ID',
  `SEQUENCE` int(11) NOT NULL COMMENT '排序序号',
  `NODE_INSTANCE_ID` bigint(20) NOT NULL COMMENT '所属节点实例ID',
  `ENGINE_TYPE` varchar(200) NOT NULL DEFAULT '0' COMMENT '计算引擎类型（预留）',
  `EXTERNAL_ID` varchar(800) NOT NULL DEFAULT 'unknown' COMMENT '外部运行ID，比如yarn的application id，默认unknown',
  `SUBMIT_FILE_PATH` varchar(800) NOT NULL COMMENT '提交文件路径\r\n            ${execution_home_dir}/submit_<node_code>_<nodeInstance_id>.json',
  `RETURN_FILE_PATH` varchar(800) NOT NULL COMMENT '返回文件路径\r\n            ${execution_home_dir}/return_<node_code>_<nodeInstance_id>.json',
  `LOG_FILE_PATH` varchar(800) NOT NULL COMMENT '日志文件路径\r\n            ${execution_home_dir}/log_<node_code>_<nodeInstance_id>.log',
  `COST_TIME` bigint(20) NOT NULL DEFAULT '-1' COMMENT '运行时间，单位毫秒，默认为-1',
  `EXECUTION_NODE_DESC` varchar(800) NOT NULL COMMENT '任务运行节点描述',
  `STATUS` int(11) NOT NULL COMMENT '运行节点状态\r\n            0：ready，已就绪\r\n            1：preparing，准备中\r\n            2：running，运行中\r\n            3：success，运行成功\r\n            4：error，运行出错\r\n            5：terminate，运行停止',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`EXECUTION_NODE_ID`),
  UNIQUE KEY `Index_1` (`EXECUTION_ID`,`NODE_INSTANCE_ID`),
  KEY `Index_2` (`EXECUTION_PATH_ID`,`SEQUENCE`),
  KEY `Index_3` (`EXECUTION_ID`,`STATUS`),
  KEY `Index_4` (`EXECUTION_PATH_ID`,`STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务运行节点表';

-- ----------------------------
-- Records of wf_execution_node
-- ----------------------------

-- ----------------------------
-- Table structure for wf_execution_path
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution_path`;
CREATE TABLE `wf_execution_path` (
  `EXECUTION_PATH_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '运行路径ID',
  `EXECUTION_ID` bigint(20) NOT NULL COMMENT '任务运行ID',
  `PARENT_EXECUTION_PATHS` varchar(2000) DEFAULT NULL COMMENT '父运行路径ID列表，逗号分隔，没有填写空',
  `CHILD_EXECUTION_PATHS` varchar(2000) DEFAULT NULL COMMENT '子运行路径ID列表，逗号分隔，没有填写空',
  `CUR_EXECUTION_PATH` char(10) DEFAULT NULL,
  `PRIORITY` char(10) DEFAULT NULL,
  `START_NODE_INSTANCE_ID` bigint(20) NOT NULL COMMENT '运行路径起始节点',
  `CUR_NODE_INSTANCE_ID` bigint(20) NOT NULL COMMENT '运行路径当前节点',
  `END_NODE_INSTANCE_ID` bigint(20) NOT NULL COMMENT '运行路径结束节点',
  `STATUS` int(11) NOT NULL COMMENT '运行路径状态\r\n            0：wait parents\r\n            1：on the way\r\n            2：complete\r\n            3：error terminate\r\n            4：user terminate',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`EXECUTION_PATH_ID`),
  UNIQUE KEY `Index_2` (`EXECUTION_ID`,`CUR_NODE_INSTANCE_ID`),
  KEY `Index_1` (`EXECUTION_ID`,`STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务运行路径表，配合队列表找出DAG图中在运行路径和在运行节点';

-- ----------------------------
-- Records of wf_execution_path
-- ----------------------------

-- ----------------------------
-- Table structure for wf_execution_queue
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution_queue`;
CREATE TABLE `wf_execution_queue` (
  `EXECUTION_ID` bigint(20) NOT NULL COMMENT '任务运行ID',
  `STATUS` int(11) NOT NULL COMMENT '任务处理状态\r\n            0：waiting，等待处理\r\n            1：processing，处理中',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`EXECUTION_ID`),
  KEY `Index_1` (`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务运行队列表，运行退出后移除';

-- ----------------------------
-- Records of wf_execution_queue
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow`;
CREATE TABLE `wf_flow` (
  `FLOW_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流程图ID',
  `PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `EXPERIMENT_ID` bigint(20) NOT NULL COMMENT '所属实验ID',
  `LOCK_STATUS` int(11) NOT NULL COMMENT '流程图加锁状态，有以下状态：\r\n            0：未加锁\r\n            1：已加锁',
  `LOCK_MSG` varchar(800) DEFAULT NULL COMMENT '流程图加锁消息',
  `FLOW_DESC` varchar(800) DEFAULT NULL COMMENT '流程图描述',
  `STATUS` int(11) NOT NULL COMMENT '流程图状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`FLOW_ID`),
  KEY `Index_1` (`EXPERIMENT_ID`,`STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程图信息表';

-- ----------------------------
-- Records of wf_flow
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_link
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_link`;
CREATE TABLE `wf_flow_link` (
  `FLOW_LINK_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流程图链路ID',
  `FLOW_ID` bigint(20) NOT NULL,
  `SRC_PORT_ID` bigint(20) NOT NULL COMMENT '流程图节点端口ID，输入端口',
  `DST_PORT_ID` bigint(20) NOT NULL COMMENT '流程图节点端口ID，输出端口',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` bigint(20) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`FLOW_LINK_ID`),
  UNIQUE KEY `Index_2` (`DST_PORT_ID`),
  KEY `Index_1` (`SRC_PORT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程图链路信息表';

-- ----------------------------
-- Records of wf_flow_link
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_node
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node`;
CREATE TABLE `wf_flow_node` (
  `FLOW_NODE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流程图节点ID',
  `FLOW_NODE_NAME` varchar(200) NOT NULL COMMENT '流程图节点名',
  `FLOW_ID` bigint(20) NOT NULL COMMENT '所属流程图ID',
  `NODE_ID` bigint(20) NOT NULL COMMENT '节点ID',
  `NODE_INSTANCE_ID` bigint(20) NOT NULL COMMENT '节点实例ID',
  `POSITION_X` bigint(20) NOT NULL COMMENT '流程图节点X轴坐标',
  `POSITION_Y` bigint(20) NOT NULL COMMENT '流程图节点Y轴坐标',
  `SEQUENCE` int(11) NOT NULL COMMENT '节点序号',
  `FLOW_NODE_DESC` varchar(800) NOT NULL COMMENT '流程图节点描述',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`FLOW_NODE_ID`),
  UNIQUE KEY `Index_2` (`NODE_INSTANCE_ID`),
  KEY `Index_1` (`FLOW_ID`,`NODE_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程图节点信息表';

-- ----------------------------
-- Records of wf_flow_node
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_node_his
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_his`;
CREATE TABLE `wf_flow_node_his` (
  `FLOW_NODE_ID` bigint(20) NOT NULL COMMENT '流程图节点ID',
  `FLOW_NODE_NAME` varchar(200) NOT NULL COMMENT '流程图节点名',
  `FLOW_ID` bigint(20) NOT NULL COMMENT '所属流程图ID',
  `NODE_ID` bigint(20) NOT NULL COMMENT '节点ID',
  `POSITION_X` bigint(20) NOT NULL COMMENT '节点在流程图上的X轴坐标',
  `POSITION_Y` bigint(20) NOT NULL COMMENT '节点在流程图上的Y轴坐标',
  `SEQUENCE` int(11) NOT NULL COMMENT '节点序号',
  `FLOW_NODE_DESC` varchar(800) NOT NULL COMMENT '流程图节点描述',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`FLOW_NODE_ID`),
  KEY `Index_1` (`FLOW_ID`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程图节点历史信息表';

-- ----------------------------
-- Records of wf_flow_node_his
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_node_port
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_port`;
CREATE TABLE `wf_flow_node_port` (
  `FLOW_NODE_PORT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流程图节点端口ID',
  `FLOW_NODE_ID` bigint(20) NOT NULL COMMENT '所属流程图节点ID',
  `NODE_PORT_ID` bigint(20) NOT NULL COMMENT '节点端口ID',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`FLOW_NODE_PORT_ID`),
  UNIQUE KEY `Index_1` (`FLOW_NODE_ID`,`NODE_PORT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程图节点端口信息表';

-- ----------------------------
-- Records of wf_flow_node_port
-- ----------------------------

-- ----------------------------
-- Table structure for wf_json_data
-- ----------------------------
DROP TABLE IF EXISTS `wf_json_data`;
CREATE TABLE `wf_json_data` (
  `JSON_DATA_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'JSON数据ID',
  `JSON_DATA_NAME` varchar(200) NOT NULL COMMENT 'JSON数据名称\r\n            \r\n            字段列表\r\n            schema_<node_code>_<nodeInstance_id>\r\n            \r\n            输出内容\r\n            output_<node_code>_<nodeInstance_id>_<char_code>\r\n            \r\n            节点参数\r\n            param_<node_code>_<nodeInstance_id>_<char_code>',
  `NODE_INSTANCE_ID` bigint(20) NOT NULL COMMENT '节点实例ID',
  `STORAGE_LOCATION` int(11) NOT NULL COMMENT '存储位置\r\n            0：JSON_DATA字段\r\n            1：HDFS文件系统',
  `JSON_DATA` mediumblob COMMENT 'JSON数据',
  `FILE_PATH` varchar(800) DEFAULT NULL COMMENT 'JSON文件路径\r\n            hdfs://namenode_host:port/user/mls/json_data/<project_id>/<experiment_id>/<json_data_name>.json',
  `MODIFY_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '内容修改时间',
  `STATUS` int(11) NOT NULL COMMENT 'JSON数据状态\r\n            0：正常\r\n            1：空JSON数据',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`JSON_DATA_ID`),
  KEY `Index_1` (`NODE_INSTANCE_ID`,`STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='JSON数据信息表';

-- ----------------------------
-- Records of wf_json_data
-- ----------------------------

-- ----------------------------
-- Table structure for wf_node_category
-- ----------------------------
DROP TABLE IF EXISTS `wf_node_category`;
CREATE TABLE `wf_node_category` (
  `CATEGORY_ID` bigint(20) NOT NULL COMMENT '节点目录ID',
  `CATEGORY_CODE` varchar(200) NOT NULL COMMENT '节点目录代码',
  `CATEGORY_NAME` varchar(200) NOT NULL COMMENT '节点目录名称',
  `PARENT_CATEGORY_ID` bigint(20) NOT NULL COMMENT '上级节点目录ID，用于定义节点目录结构，一级节点目录设为0',
  `SEQUENCE` int(11) NOT NULL COMMENT '排序序号',
  `ICON_TYPE` int(11) NOT NULL COMMENT '节点目录图标类型',
  `CATEGORY` varchar(200) DEFAULT NULL COMMENT '节点目录类别（预留），自定义类别',
  `CATEGORY_DESC` varchar(800) DEFAULT NULL COMMENT '节点目录描述',
  `STATUS` int(11) NOT NULL COMMENT '节点目录状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CATEGORY_ID`),
  UNIQUE KEY `Index_1` (`CATEGORY_CODE`),
  KEY `Index_2` (`PARENT_CATEGORY_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='节点目录表';

-- ----------------------------
-- Records of wf_node_category
-- ----------------------------
INSERT INTO `wf_node_category` VALUES ('0', 'RootCategory', '根目录', '-1', '0', '0', 'menu', '节点目录根目录', '0', '2017-06-06 16:09:16', 'admin', '2017-06-06 16:09:16', 'admin');
INSERT INTO `wf_node_category` VALUES ('1', 'SourceDestination', '源 / 目标', '0', '0', '0', 'source_destination', '数据表的输入源和输出目标', '0', '2017-05-27 15:08:17', 'admin', '2017-05-27 15:08:17', 'admin');
INSERT INTO `wf_node_category` VALUES ('2', 'UserCode', '脚本工具', '0', '1', '0', 'user_code', 'SQL、Python、R等多种脚本支持', '0', '2017-05-27 15:18:10', 'admin', '2017-05-27 15:18:03', 'admin');
INSERT INTO `wf_node_category` VALUES ('3', 'DataPreprocessing', '数据预处理', '0', '2', '0', 'process', '数据预处理', '-1', '2017-05-27 15:25:40', 'admin', '2017-05-27 15:25:40', 'admin');
INSERT INTO `wf_node_category` VALUES ('4', 'FeatureEngineering', '特征工程', '0', '3', '0', 'process', '特征工程', '-1', '2017-05-27 15:27:10', 'admin', '2017-05-27 15:27:10', 'admin');
INSERT INTO `wf_node_category` VALUES ('5', 'Analytics', '统计分析', '0', '4', '0', 'analytics', '统计分析', '-1', '2017-05-27 15:28:10', 'admin', '2017-05-27 15:28:10', 'admin');
INSERT INTO `wf_node_category` VALUES ('6', 'MachineLearning', '机器学习', '0', '5', '0', 'training', '算法建模', '0', '2017-05-27 17:55:44', 'admin', '2017-05-27 17:55:41', 'admin');
INSERT INTO `wf_node_category` VALUES ('7', 'DeepLearning', '深度学习', '0', '6', '0', 'process', '深度学习', '-1', '2017-05-27 17:56:16', 'admin', '2017-05-27 17:56:16', 'admin');
INSERT INTO `wf_node_category` VALUES ('8', 'NaturalLanguageProcessing', '文本分析', '0', '7', '0', 'process', '文本分析', '-1', '2017-05-27 17:56:55', 'admin', '2017-05-27 17:56:55', 'admin');
INSERT INTO `wf_node_category` VALUES ('9', 'NetworkAnalysis', '网络分析', '0', '8', '0', 'process', '网络分析', '-1', '2017-05-27 17:57:23', 'admin', '2017-05-27 17:57:23', 'admin');
INSERT INTO `wf_node_category` VALUES ('10', 'StreamProcessing', '流式处理', '0', '9', '0', 'process', '流式处理', '-1', '2017-05-27 17:57:53', 'admin', '2017-05-27 17:57:53', 'admin');
INSERT INTO `wf_node_category` VALUES ('11', 'BinaryClassification', '二分类', '6', '0', '0', 'training', '二分类算法', '0', '2017-05-31 14:32:08', 'admin', '2017-05-31 14:32:08', 'admin');
INSERT INTO `wf_node_category` VALUES ('12', 'MultipleClassification', '多分类', '6', '1', '0', 'training', '多分类算法', '0', '2017-05-31 14:33:41', 'admin', '2017-05-31 14:33:41', 'admin');
INSERT INTO `wf_node_category` VALUES ('13', 'Clustering', '聚类', '6', '2', '0', 'training', '聚类算法', '0', '2017-05-31 14:34:41', 'admin', '2017-05-31 14:34:41', 'admin');
INSERT INTO `wf_node_category` VALUES ('14', 'Regression', '回归', '6', '3', '0', 'training', '回归算法', '0', '2017-05-31 14:58:30', 'admin', '2017-05-31 14:58:30', 'admin');
INSERT INTO `wf_node_category` VALUES ('15', 'AssociationRules', '关联规则', '6', '4', '0', 'process', '关联规则算法', '0', '2017-05-31 15:05:25', 'admin', '2017-05-31 15:05:25', 'admin');
INSERT INTO `wf_node_category` VALUES ('16', 'CollaborativeFiltering', '协同过滤', '6', '5', '0', 'training', '协同过滤算法', '0', '2017-05-31 15:06:19', 'admin', '2017-05-31 15:06:19', 'admin');
INSERT INTO `wf_node_category` VALUES ('17', 'Evaluation', '评估', '6', '6', '0', 'evaluation', '评估模型效果', '0', '2017-05-31 15:14:49', 'admin', '2017-05-31 15:14:49', 'admin');

-- ----------------------------
-- Table structure for wf_node_def
-- ----------------------------
DROP TABLE IF EXISTS `wf_node_def`;
CREATE TABLE `wf_node_def` (
  `NODE_ID` bigint(20) NOT NULL COMMENT '节点ID',
  `NODE_CODE` varchar(200) NOT NULL COMMENT '节点代码',
  `NODE_NAME` varchar(200) NOT NULL COMMENT '节点名称',
  `NODE_TYPE` int(11) NOT NULL COMMENT '节点类型，同组件类型',
  `CATEGORY_ID` bigint(20) NOT NULL COMMENT '所属节点目录ID，不进节点目录设为-1',
  `SEQUENCE` int(11) NOT NULL COMMENT '排序序号',
  `CATEGORY` varchar(200) DEFAULT NULL COMMENT '节点类别（预留），自定义类别',
  `ICON_TYPE` int(11) NOT NULL COMMENT '节点图标类型',
  `CLASS_PATH` varchar(200) NOT NULL COMMENT '节点业务类路径，用于动态创建类对象，调用节点对象方法',
  `CMPT_ID` bigint(20) NOT NULL COMMENT '组件ID',
  `NODE_DESC` varchar(800) DEFAULT NULL COMMENT '节点描述',
  `STATUS` int(11) NOT NULL COMMENT '节点状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_ID`),
  UNIQUE KEY `Index_1` (`NODE_CODE`),
  KEY `Index_2` (`CATEGORY_ID`,`SEQUENCE`),
  KEY `Index_3` (`CMPT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='节点定义表';

-- ----------------------------
-- Records of wf_node_def
-- ----------------------------
INSERT INTO `wf_node_def` VALUES ('1', 'ReadDataTable', '读数据表', '0', '1', '0', 'source', '0', 'ReadDataTable.class', '1', null, '0', '2017-05-27 16:11:04', 'admin', '2017-05-27 16:11:04', 'admin');
INSERT INTO `wf_node_def` VALUES ('2', 'ReadModel', '读模型', '0', '1', '1', 'source', '0', 'ReadModel.class', '2', null, '0', '2017-05-27 16:13:58', 'admin', '2017-05-27 16:13:58', 'admin');
INSERT INTO `wf_node_def` VALUES ('3', 'WriteDataTable', '写数据表', '0', '1', '2', 'destination', '0', 'WriteDataTable.class', '3', null, '0', '2017-05-27 16:11:04', 'admin', '2017-05-27 16:11:04', 'admin');
INSERT INTO `wf_node_def` VALUES ('4', 'SqlScript', 'SQL脚本', '1', '2', '0', 'user_code', '0', 'SqlScript.class', '1000', null, '0', '2017-05-27 16:18:13', 'admin', '2017-05-27 16:18:13', 'admin');
INSERT INTO `wf_node_def` VALUES ('5', 'LogisticRegression_Binary', '逻辑回归二分类', '5', '11', '0', 'training', '0', 'LogisticRegressionBinaryClassification.class', '5001', null, '0', '2017-05-27 16:43:05', 'admin', '2017-05-27 16:43:05', 'admin');
INSERT INTO `wf_node_def` VALUES ('6', 'RandomForest_Binary', '随机森林二分类', '5', '11', '1', 'training', '0', 'RandomForestClassification.class', '5003', null, '0', '2017-05-27 16:49:30', 'admin', '2017-05-27 16:49:30', 'admin');
INSERT INTO `wf_node_def` VALUES ('7', 'GBDT_Binary', 'GBDT二分类', '5', '11', '2', 'training', '0', 'GradientBoostingDecisionTreeBinaryClassification.class', '5004', null, '0', '2017-05-27 16:50:15', 'admin', '2017-05-27 16:50:15', 'admin');
INSERT INTO `wf_node_def` VALUES ('8', 'LinearSVM', '线性支持向量机', '5', '11', '3', 'training', '0', 'LinearSupportVectorMachineBinaryClassification.class', '5005', null, '0', '2017-05-27 16:51:14', 'admin', '2017-05-27 16:51:14', 'admin');
INSERT INTO `wf_node_def` VALUES ('9', 'LogisticRegression_Multiple', '逻辑回归多分类', '5', '12', '4', 'training', '0', 'LogisticRegressionMultipleClassification.class', '5002', null, '0', '2017-05-27 16:44:06', 'admin', '2017-05-27 16:44:06', 'admin');
INSERT INTO `wf_node_def` VALUES ('10', 'RandomForest_Multiple', '随机森林多分类', '5', '12', '1', 'training', '0', 'RandomForestClassification.class', '5003', null, '0', '2017-05-27 16:49:30', 'admin', '2017-05-27 16:49:30', 'admin');
INSERT INTO `wf_node_def` VALUES ('11', 'NaiveBayesian', '朴素贝叶斯', '5', '12', '2', 'training', '0', 'NaiveBayesianMultipleClassification.class', '5006', null, '0', '2017-05-27 16:52:06', 'admin', '2017-05-27 16:52:06', 'admin');
INSERT INTO `wf_node_def` VALUES ('12', 'KNN', 'K近邻（无模型保存，直接预测）', '5', '12', '3', 'training', '0', 'KNearestNeighborsMultipleClassification.class', '5007', null, '-1', '2017-05-27 16:53:28', 'admin', '2017-05-27 16:53:28', 'admin');
INSERT INTO `wf_node_def` VALUES ('13', 'KMeans', 'K均值（输入输出项待定）', '5', '13', '0', 'training', '0', 'KMeansClustering.class', '5100', null, '-1', '2017-05-27 17:25:18', 'admin', '2017-05-27 17:25:18', 'admin');
INSERT INTO `wf_node_def` VALUES ('14', 'Linear_Regression', '线性回归', '5', '14', '0', 'training', '0', 'LinearRegression.class', '5200', null, '0', '2017-05-27 17:26:08', 'admin', '2017-05-27 17:26:08', 'admin');
INSERT INTO `wf_node_def` VALUES ('15', 'GBDT_Regression', 'GBDT回归', '5', '14', '1', 'training', '0', 'GradientBoostingDecisionTreeRegression.class', '5201', null, '0', '2017-05-27 17:27:30', 'admin', '2017-05-27 17:27:30', 'admin');
INSERT INTO `wf_node_def` VALUES ('16', 'BinaryClassificationEvaluation', '二分类评估', '5', '17', '0', 'evaluation', '0', 'BinaryClassificationEvaluation', '5901', null, '0', '2017-05-27 17:38:00', 'admin', '2017-05-27 17:38:00', 'admin');
INSERT INTO `wf_node_def` VALUES ('17', 'MultipleClassificationEvaluation', '多分类评估', '5', '17', '1', 'evaluation', '0', 'MultipleClassificationEvaluation', '5902', null, '0', '2017-05-27 17:38:38', 'admin', '2017-05-27 17:38:38', 'admin');
INSERT INTO `wf_node_def` VALUES ('18', 'ClusteringEvaluation', '聚类模型评估', '5', '17', '2', 'evaluation', '0', 'ClusteringEvaluation', '5903', null, '0', '2017-05-27 17:39:13', 'admin', '2017-05-27 17:39:13', 'admin');
INSERT INTO `wf_node_def` VALUES ('19', 'RegressionEvaluation', '回归模型评估', '5', '17', '3', 'evaluation', '0', 'RegressionEvaluation', '5904', null, '0', '2017-05-27 17:39:48', 'admin', '2017-05-27 17:39:48', 'admin');
INSERT INTO `wf_node_def` VALUES ('20', 'Prediction', '预测', '5', '6', '0', 'prediction', '0', 'Prediction', '5900', null, '0', '2017-05-27 17:37:12', 'admin', '2017-05-27 17:37:12', 'admin');
INSERT INTO `wf_node_def` VALUES ('21', 'SmartRules', '智能规则', '5', '6', '1', '0', '0', 'SmartRules', '5999', null, '0', '2017-05-27 17:42:51', 'admin', '2017-05-27 17:42:51', 'admin');

-- ----------------------------
-- Table structure for wf_node_instance
-- ----------------------------
DROP TABLE IF EXISTS `wf_node_instance`;
CREATE TABLE `wf_node_instance` (
  `NODE_INSTANCE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '节点实例ID',
  `NODE_INSTANCE_NAME` varchar(200) NOT NULL COMMENT '节点实例名称',
  `PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `EXPERIMENT_ID` bigint(20) NOT NULL COMMENT '实验ID，无关联实验设为-1',
  `NODE_ID` bigint(20) NOT NULL COMMENT '节点ID',
  `LAST_EXECUTION_NODE_ID` bigint(20) DEFAULT NULL COMMENT '最后任务运行节点ID',
  `NODE_INSTANCE_DESC` varchar(800) NOT NULL COMMENT '节点实例描述',
  `STATUS` int(11) NOT NULL COMMENT '节点实例状态\r\n            0：not ready，未就绪\r\n            1：ready，已就绪\r\n            2：preparing，准备中\r\n            3：running，运行中\r\n            4：success，运行成功\r\n            5：error，运行出错',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_INSTANCE_ID`),
  KEY `Index_1` (`EXPERIMENT_ID`,`NODE_ID`),
  KEY `Index_2` (`EXPERIMENT_ID`,`STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='节点实例表';

-- ----------------------------
-- Records of wf_node_instance
-- ----------------------------

-- ----------------------------
-- Table structure for wf_node_instance_char_value
-- ----------------------------
DROP TABLE IF EXISTS `wf_node_instance_char_value`;
CREATE TABLE `wf_node_instance_char_value` (
  `NODE_INSTANCE_ID` bigint(20) NOT NULL COMMENT '节点实例ID',
  `CHAR_ID` bigint(20) NOT NULL COMMENT '组件规格特征ID',
  `IS_SYSTEM_PARAM` int(11) NOT NULL COMMENT '特征值内容是否为系统参数\r\n            0：否\r\n            1：是',
  `CHAR_VALUE` varchar(2000) DEFAULT NULL COMMENT '特征值',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_INSTANCE_ID`,`CHAR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='节点实例特征值设置表';

-- ----------------------------
-- Records of wf_node_instance_char_value
-- ----------------------------

-- ----------------------------
-- Table structure for wf_node_instance_schema
-- ----------------------------
DROP TABLE IF EXISTS `wf_node_instance_schema`;
CREATE TABLE `wf_node_instance_schema` (
  `NODE_INSTANCE_ID` bigint(20) NOT NULL COMMENT '节点实例ID',
  `NODE_PORT_ID` bigint(20) NOT NULL COMMENT '节点输出端口ID',
  `JSON_DATA_ID` bigint(20) DEFAULT NULL COMMENT 'json数据ID',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_INSTANCE_ID`,`NODE_PORT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='节点实例字段信息表，记录每个节点实例中输出端口为数据表类型的字段信息';

-- ----------------------------
-- Records of wf_node_instance_schema
-- ----------------------------

-- ----------------------------
-- Table structure for wf_node_port_def
-- ----------------------------
DROP TABLE IF EXISTS `wf_node_port_def`;
CREATE TABLE `wf_node_port_def` (
  `NODE_PORT_ID` bigint(20) NOT NULL COMMENT '节点端口ID\r\n            节点端口ID值组成：节点ID + 一位节点端口类型 + 一位节点端口序列号',
  `NODE_PORT_NAME` varchar(200) NOT NULL COMMENT '节点端口名',
  `NODE_PORT_TYPE` int(11) NOT NULL COMMENT '节点端口类型\r\n            0：输入端口\r\n            1：输出端口',
  `NODE_ID` bigint(20) NOT NULL COMMENT '所属节点ID',
  `CHAR_ID` bigint(20) NOT NULL COMMENT '绑定组件规格特征ID',
  `SEQUENCE` int(11) NOT NULL COMMENT '端口序号',
  `NODE_PORT_DESC` varchar(800) NOT NULL COMMENT '节点端口描述',
  `STATUS` int(11) NOT NULL COMMENT '节点端口状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_PORT_ID`),
  UNIQUE KEY `Index_2` (`NODE_ID`,`CHAR_ID`),
  KEY `Index_1` (`NODE_ID`,`NODE_PORT_TYPE`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='节点端口定义表，映射组件输入输出内容规格特征到节点端口上';

-- ----------------------------
-- Records of wf_node_port_def
-- ----------------------------
INSERT INTO `wf_node_port_def` VALUES ('110', '读数据表的输出', '1', '1', '10001', '0', '数据输出', '0', '2017-05-27 20:12:15', 'admin', '2017-05-27 20:12:15', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('210', '读模型的输出', '1', '2', '10011', '0', '模型输出', '0', '2017-05-27 20:21:59', 'admin', '2017-05-27 20:21:59', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('300', '写数据表的输入', '0', '3', '1', '0', '数据输入', '0', '2017-06-06 17:53:42', 'admin', '2017-06-06 17:53:42', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('310', '写数据表的输出', '1', '3', '10001', '0', '数据输出', '0', '2017-06-06 17:53:42', 'admin', '2017-06-06 17:53:42', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('400', 'SQL脚本的输入t1', '0', '4', '1', '0', 'SQL脚本的输入', '0', '2017-05-27 20:44:40', 'admin', '2017-05-27 20:44:40', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('401', 'SQL脚本的输入t2', '0', '4', '2', '1', 'SQL脚本的输入', '0', '2017-05-27 20:48:13', 'admin', '2017-05-27 20:48:13', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('402', 'SQL脚本的输入t3', '0', '4', '3', '2', 'SQL脚本的输入', '0', '2017-05-27 20:48:51', 'admin', '2017-05-27 20:48:51', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('403', 'SQL脚本的输入t4', '0', '4', '4', '3', 'SQL脚本的输入', '0', '2017-05-27 20:49:21', 'admin', '2017-05-27 20:49:21', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('404', 'SQL脚本的输入t5', '0', '4', '5', '4', 'SQL脚本的输入', '0', '2017-05-27 20:49:51', 'admin', '2017-05-27 20:49:51', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('405', 'SQL脚本的输入t6', '0', '4', '6', '5', 'SQL脚本的输入', '0', '2017-05-27 20:50:12', 'admin', '2017-05-27 20:50:12', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('410', 'SQL脚本的输出', '1', '4', '10001', '0', 'SQL脚本的输出', '0', '2017-05-27 20:55:27', 'admin', '2017-05-27 20:55:27', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('500', '逻辑回归二分类的输入', '0', '5', '1', '0', '训练数据输入', '0', '2017-05-31 15:03:21', 'admin', '2017-05-31 15:03:21', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('510', '逻辑回归二分类的输出', '1', '5', '10011', '0', '模型输出', '0', '2017-05-31 15:09:31', 'admin', '2017-05-31 15:09:31', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('600', '随机森林二分类的输入', '0', '6', '1', '0', '训练数据输入', '0', '2017-05-31 15:27:23', 'admin', '2017-05-31 15:27:23', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('610', '随机森林二分类的输出', '1', '6', '10011', '0', '模型输出', '0', '2017-05-31 15:28:16', 'admin', '2017-05-31 15:28:16', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('700', 'GBDT二分类的输入', '0', '7', '1', '0', '训练数据输入', '0', '2017-05-31 15:28:49', 'admin', '2017-05-31 15:28:49', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('710', 'GBDT二分类的输出', '1', '7', '10011', '0', '模型输出', '0', '2017-05-31 15:29:46', 'admin', '2017-05-31 15:29:46', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('800', '线性支持向量机二分类的输入', '0', '8', '1', '0', '训练数据输入', '0', '2017-05-31 15:30:14', 'admin', '2017-05-31 15:30:14', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('810', '线性支持向量机二分类的输出', '1', '8', '10011', '0', '模型输出', '0', '2017-05-31 15:30:46', 'admin', '2017-05-31 15:30:46', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('900', '逻辑回归多分类的输入', '0', '9', '1', '0', '训练数据输入', '0', '2017-05-31 15:21:20', 'admin', '2017-05-31 15:21:20', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('910', '逻辑回归多分类的输出', '1', '9', '10011', '0', '模型输出', '0', '2017-05-31 15:22:14', 'admin', '2017-05-31 15:22:14', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('1000', '随机森林多分类的输入', '0', '10', '1', '0', '训练数据输入', '0', '2017-05-31 15:27:23', 'admin', '2017-05-31 15:27:23', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('1010', '随机森林多分类的输出', '1', '10', '10011', '0', '模型输出', '0', '2017-05-31 15:28:16', 'admin', '2017-05-31 15:28:16', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('1100', '朴素贝叶斯多分类的输入', '0', '11', '1', '0', '训练数据输入', '0', '2017-05-31 15:31:54', 'admin', '2017-05-31 15:31:54', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('1110', '朴素贝叶斯多分类的输出', '1', '11', '10011', '0', '模型输出', '0', '2017-05-31 15:32:40', 'admin', '2017-05-31 15:32:40', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('1200', 'K近邻多分类的输入（*）', '0', '12', '1', '0', '训练数据输入', '0', '2017-05-31 15:33:42', 'admin', '2017-05-31 15:33:42', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('1210', 'K近邻多分类的输出（*）', '1', '12', '10011', '0', '模型输出', '0', '2017-05-31 15:34:12', 'admin', '2017-05-31 15:34:12', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('1300', 'K均值聚类的输入（*）', '0', '13', '1', '0', '训练数据输入', '0', '2017-05-31 15:34:48', 'admin', '2017-05-31 15:34:48', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('1310', 'K均值聚类的输出（*）', '1', '13', '10011', '0', '模型输出', '0', '2017-05-31 15:35:54', 'admin', '2017-05-31 15:35:54', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('1400', '线性回归的输入', '0', '14', '1', '0', '训练数据输入', '0', '2017-05-31 15:36:24', 'admin', '2017-05-31 15:36:24', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('1410', '线性回归的输出', '1', '14', '10011', '0', '模型输出', '0', '2017-05-31 15:36:48', 'admin', '2017-05-31 15:36:48', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('1500', 'GBDT回归的输入', '0', '15', '1', '0', '训练数据输入', '0', '2017-05-31 15:37:43', 'admin', '2017-05-31 15:37:43', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('1510', 'GBDT回归的输出', '1', '15', '10011', '0', '模型输出', '0', '2017-05-31 15:38:08', 'admin', '2017-05-31 15:38:08', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('1600', '二分类评估的输入', '0', '16', '1', '0', '预测结果输入', '0', '2017-05-31 15:39:42', 'admin', '2017-05-31 15:39:42', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('1610', '二分类评估的输出', '1', '16', '10011', '1', '评估输出', '0', '2017-06-21 12:01:30', 'admin', '2017-06-21 12:01:30', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('1700', '多分类评估的输入', '0', '17', '1', '0', '预测结果输入', '0', '2017-05-31 15:49:06', 'admin', '2017-05-31 15:49:06', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('1800', '聚类模型评估的输入', '0', '18', '1', '0', '预测结果输入', '0', '2017-05-31 15:54:04', 'admin', '2017-05-31 15:54:04', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('1900', '回归模型评估的输入', '0', '19', '1', '0', '预测结果输入', '0', '2017-05-31 15:55:05', 'admin', '2017-05-31 15:55:05', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('2000', '预测的输入m1', '0', '20', '11', '0', '模型输入', '0', '2017-05-31 15:38:49', 'admin', '2017-05-31 15:38:49', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('2001', '预测的输入t1', '0', '20', '1', '1', '测试数据输入', '0', '2017-05-31 15:38:49', 'admin', '2017-05-31 15:38:49', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('2010', '预测的输出', '1', '20', '10001', '0', '预测结果输出', '0', '2017-05-31 15:39:14', 'admin', '2017-05-31 15:39:14', 'admin');
INSERT INTO `wf_node_port_def` VALUES ('2100', '智能规则的输入（*）', '0', '21', '1', '0', '训练数据输入', '0', '2017-05-31 15:57:35', 'admin', '2017-05-31 15:57:35', 'admin');

-- ----------------------------
-- Table structure for wf_node_prop_control_def
-- ----------------------------
DROP TABLE IF EXISTS `wf_node_prop_control_def`;
CREATE TABLE `wf_node_prop_control_def` (
  `CONTROL_ID` bigint(20) NOT NULL COMMENT '控件ID\r\n            控件ID值组成：选项卡ID + 两位控件序号',
  `CONTROL_NAME` varchar(200) NOT NULL COMMENT '控件名称',
  `CONTROL_LABEL` varchar(200) NOT NULL COMMENT '控件描述',
  `CONTROL_TYPE` varchar(200) NOT NULL COMMENT '控件类型',
  `TAB_ID` bigint(20) NOT NULL COMMENT '所属选项卡ID',
  `MAPPING_CHAR_ID` bigint(20) DEFAULT NULL COMMENT '映射组件规格特征ID，若控件无值则设为NULL',
  `SEQUENCE` int(11) NOT NULL COMMENT '控件序号',
  `TOOLTIP` varchar(800) DEFAULT NULL COMMENT '提示信息',
  `LONG_TOOLTIP` varchar(2000) DEFAULT NULL COMMENT '长提示信息',
  `PLACE_HOLDER` varchar(800) DEFAULT NULL COMMENT '输入框占位提示信息',
  `IS_INDENTED` int(11) NOT NULL DEFAULT '0' COMMENT '是否缩进\r\n            0：否\r\n            1：是',
  `IS_DISABLED` int(11) NOT NULL DEFAULT '0' COMMENT '是否禁用\r\n            0：否\r\n            1：是',
  `STATUS` int(11) NOT NULL COMMENT '控件状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CONTROL_ID`),
  KEY `Index_1` (`TAB_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='节点属性页控件定义表';

-- ----------------------------
-- Records of wf_node_prop_control_def
-- ----------------------------

-- ----------------------------
-- Table structure for wf_node_prop_control_onchange
-- ----------------------------
DROP TABLE IF EXISTS `wf_node_prop_control_onchange`;
CREATE TABLE `wf_node_prop_control_onchange` (
  `CONTROL_ID` bigint(20) NOT NULL COMMENT '控件ID',
  `CONDITION_VALUE` varchar(2000) DEFAULT NULL COMMENT '触发条件值，通配为NULL',
  `TARGET_CONTROL_ID` bigint(20) NOT NULL COMMENT '目标控件ID，要求为同一属性页下的其他控件',
  `TAKE_ACTION` varchar(200) NOT NULL COMMENT '执行动作，例如：hide，show，reload',
  `STATUS` int(11) NOT NULL COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  KEY `Index_1` (`CONTROL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='节点属性页控件onchange表';

-- ----------------------------
-- Records of wf_node_prop_control_onchange
-- ----------------------------

-- ----------------------------
-- Table structure for wf_node_prop_page_def
-- ----------------------------
DROP TABLE IF EXISTS `wf_node_prop_page_def`;
CREATE TABLE `wf_node_prop_page_def` (
  `PAGE_ID` bigint(20) NOT NULL COMMENT '属性页ID，ID值同节点ID',
  `NODE_ID` bigint(20) NOT NULL COMMENT '所属节点ID',
  `DESCRIPTION` varchar(2000) NOT NULL COMMENT '组件使用说明描述',
  `STATUS` int(11) NOT NULL COMMENT '属性页状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PAGE_ID`),
  UNIQUE KEY `Index_1` (`NODE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='节点属性页定义表';

-- ----------------------------
-- Records of wf_node_prop_page_def
-- ----------------------------

-- ----------------------------
-- Table structure for wf_node_prop_tab_def
-- ----------------------------
DROP TABLE IF EXISTS `wf_node_prop_tab_def`;
CREATE TABLE `wf_node_prop_tab_def` (
  `TAB_ID` bigint(20) NOT NULL COMMENT '选项卡ID\r\n            选项卡ID值组成：属性页ID + 一位选项卡序号',
  `TAB_NAME` varchar(200) NOT NULL COMMENT '选项卡名称',
  `PAGE_ID` bigint(20) NOT NULL COMMENT '所属属性页ID',
  `SEQUENCE` int(11) NOT NULL COMMENT '选项卡序号',
  `TAB_DESC` varchar(800) NOT NULL COMMENT '选项卡描述',
  `STATUS` int(11) NOT NULL COMMENT '选项卡状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`TAB_ID`),
  KEY `Index_1` (`PAGE_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='节点属性页选项卡定义表';

-- ----------------------------
-- Records of wf_node_prop_tab_def
-- ----------------------------
