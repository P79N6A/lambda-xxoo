/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50724
Source Host           : 127.0.0.1:3306
Source Database       : lambda_mls

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-11-24 23:13:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cf_cmpt_algorithm
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_algorithm`;
CREATE TABLE `cf_cmpt_algorithm` (
  `ALGORITHM_ID` bigint(20) NOT NULL COMMENT '算法ID',
  `ALGORITHM_CODE` varchar(200) NOT NULL COMMENT '算法代码',
  `ALGORITHM_NAME` varchar(200) NOT NULL COMMENT '算法名称',
  `ALGORITHM_TYPE` int(11) NOT NULL COMMENT '算法类型\r\n1：One Class Classfication(Anomaly Detection)，异常检测算法\r\n2：Binary Class Classification，二分类算法\r\n3：Multiple Class Classification，多分类算法\r\n4：Clustering，聚类算法\r\n5：Regression，回归算法\r\n6：Association Rules，关联规则算法\r\n7：Collaborative filtering，协同过滤算法\r\n\r\n//更多算法类型在后续组件开发中确定',
  `ALGORITHM_LABELS` varchar(800) DEFAULT NULL COMMENT '算法标签列表（预留），标签之间用‘|’符号分隔',
  `LEARNING_MODE` int(11) NOT NULL COMMENT '算法学习方式（预留）\r\n            1：Supervised Learning，有监督学习\r\n            2：Unsupervised Learning，无监督学习\r\n            3：Semi-Supervised Learning，半监督学习',
  `OPTIMIZE_METHOD` int(11) NOT NULL COMMENT '算法最优化方法（预留）\r\n0：unknown\r\n1：批量梯度下降法\r\n2：随机梯度下降法\r\n3：mini-batch梯度下降法\r\n4：牛顿法\r\n5：拟牛顿法\r\n6：共轭梯度法\r\n7：启发式优化方法\r\n8：拉格朗日乘数法',
  `IS_TUNABLE` int(11) NOT NULL COMMENT '是否可调参\r\n            0：否\r\n            1：是',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`ALGORITHM_ID`),
  UNIQUE KEY `Index_1` (`ALGORITHM_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='算法表';

-- ----------------------------
-- Records of cf_cmpt_algorithm
-- ----------------------------
INSERT INTO `cf_cmpt_algorithm` VALUES ('1001', 'OneClass-SVM', '单分类支持向量机', '1', '', '2', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('1002', 'PCA-Based-AnomalyDetection', '基于PCA异常检测', '1', '', '2', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('2001', 'LR-TwoClassClassification', '逻辑回归二分类', '2', '', '1', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('2002', 'RF-TwoClassClassification', '随机森林二分类', '2', '', '1', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('2003', 'GBDT-TwoClassClassification', 'GBDT二分类', '2', '', '1', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('2004', 'LinearSVM-TwoClassClassification', '线性支持向量机二分类', '2', '', '1', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('2005', 'XGBoost-TwoClassClassification', 'XGBoost二分类', '2', '', '1', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('3001', 'LR-MultipleClassClassification', '逻辑回归多分类', '3', '', '1', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('3002', 'RF-MultipleClassClassification', '随机森林多分类', '3', '', '1', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('3003', 'XGBoost-MultipleClassClassification', 'XGBoost多分类', '3', '', '1', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('3004', 'NaiveBayesian-MultipleClassClassification', '朴素贝叶斯多分类', '3', '', '1', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('3005', 'KNN-MultipleClassClassification', 'K近邻多分类', '3', '', '1', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('4001', 'KMeans-Clustering', 'K均值聚类', '4', '', '2', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('5001', 'Linear-Regression', '线性回归', '5', '', '1', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('5002', 'GBDT-Regression', 'GBDT回归', '5', '', '1', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('5003', 'XGBoost-Regression', 'XGBoost回归', '5', '', '1', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('6001', 'Apriori-AssociationRules', 'Apriori关联规则', '6', '', '2', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('6002', 'FPG-AssociationRules', 'FP-Growth关联规则', '6', '', '2', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('7001', 'ALS-CollaborativeFiltering', 'ALS协同过滤', '7', '', '2', '0', '0', '', '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');

-- ----------------------------
-- Table structure for cf_cmpt_char
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_char`;
CREATE TABLE `cf_cmpt_char` (
  `CHAR_ID` varchar(64) NOT NULL COMMENT '特征ID\r\n\r\n输入内容规格类型\r\n特征ID范围：IN@C-[0000 ~ 9999]\r\n\r\n输出内容规格类型\r\n特征ID范围：OUT@C[0000 ~ 9999]\r\n\r\n调用执行规格类型\r\n特征ID范围：EX@C-[0000 ~ 9999]\r\n\r\n执行调优参数规格类型\r\n特征ID范围：OEX@C-[0000 ~ 9999]\r\n\r\n组件参数规格类型\r\n所有组件通用特征ID范围：CCP@C-ALL@COM-[0000 ~ 9999]\r\n同类组件通用特征ID范围：CCP@C-[XX]@COM-[0000 ~ 9999]\r\n单个组件专用特征ID值组成：SCP@C-${CMPT-ID}-[00~99]',
  `CHAR_CODE` varchar(200) NOT NULL COMMENT '特征代码',
  `CHAR_NAME` varchar(200) NOT NULL COMMENT '特征名称',
  `CHAR_ALIAS` varchar(200) DEFAULT NULL COMMENT '特征别名，非空时，使用特征别名替代特征代码作为参数名',
  `SPEC_TYPE` int(11) NOT NULL COMMENT '适用规格类型，说明参考CF_CMPT_SPEC.SPEC_TYPE',
  `CHAR_TYPE` int(11) NOT NULL COMMENT '特征类型ID，说明参考CF_CMPT_CHAR_TYPE.CHAR_TYPE_ID',
  `SRC_LEVEL` int(11) NOT NULL COMMENT '特征值来源级别\r\n1：计算组件规格\r\n2：计算组件\r\n3：工作流节点（仅限组件参数、执行调优、输入输出）\r\n\r\n注意，仅限在小于来源级别的地方做特征值设置有效，否则无效\r\n说明，特征值选用次序工作流节点 > 计算组件 > 计算组件规格 > 特征默认值',
  `ALLOW_GLOBAL` int(11) NOT NULL DEFAULT '0' COMMENT '允许设置为全局变量\r\n            0：否\r\n            1：是',
  `IS_REQUIRED` int(11) NOT NULL COMMENT '特征值是否必须设置\r\n            0：否\r\n            1：是',
  `IS_LIMITED` int(11) NOT NULL COMMENT '特征值是否受限定\r\n0：否\r\n1：开区间方式限定，限数值和日期类型，结合最大值和最小值构成区间范围\r\n2：闭区间方式限定，限数值和日期类型，结合最大值和最小值构成区间范围\r\n3：左开右闭方式限定，限数值和日期类型，结合最大值和最小值构成区间范围\r\n4：左闭右开方式限定，限数值和日期类型，结合最大值和最小值构成区间范围\r\n5：枚举方式限定',
  `MAX_LENGTH` int(11) DEFAULT NULL COMMENT '最大长度\r\n            \r\n            字符串类型：限制字符串最大长度\r\n            JSON列表类型：限制列表最大长度\r\n            调参类型，限制自定义用户列表最大长度',
  `STEP_SIZE` varchar(2000) DEFAULT NULL COMMENT '特征值步长，限数值和日期类型，日期以天为单位，时间以秒为单位',
  `MIN_VALUE` varchar(2000) DEFAULT NULL COMMENT '最大特征值，未设置表示无穷小',
  `MAX_VALUE` varchar(2000) DEFAULT NULL COMMENT '最大特征值，未设置表示无穷大',
  `DEFAULT_VALUE` varchar(2000) DEFAULT NULL COMMENT '默认特征值',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CHAR_ID`),
  UNIQUE KEY `Index_1` (`CHAR_CODE`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件特征表，配置组件相关的一系列特征参数项';

-- ----------------------------
-- Records of cf_cmpt_char
-- ----------------------------
INSERT INTO `cf_cmpt_char` VALUES ('10030', 'maxIteration', '通用参数 | 机器学习 | 最大iter迭代次数', '', '5', '3', '3', '0', '1', '2', null, '1', '1', '10000', '1', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('10031', 'eta', '通用参数 | 机器学习 | 学习速率eta', '', '5', '5', '3', '0', '1', '1', null, '0.01', '0', '1.0', '0.05', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('10032', 'epsilon', '通用参数 | 机器学习 | 收敛系数eplison（最小收敛误差）', '', '5', '5', '3', '0', '0', '0', null, '0.01', '', '', '0.000001', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('10034', 'regularizedType', '通用参数 | 机器学习 | 正则项类型', '', '5', '7', '3', '0', '0', '5', null, '', '', '', 'None', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('10035', 'regularizedCoef', '通用参数 | 机器学习 | 正则系数', '', '5', '5', '3', '0', '0', '0', null, '0.1', '', '', '1', '可选，正则类型为None时此值无效', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40100000', 'sqlScript', '专用参数 | 脚本工具 | SQL脚本', '', '5', '200', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40100100', 'pythonScript', '专用参数 | 脚本工具 | Python脚本', '', '5', '201', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40100200', 'rScript', '专用参数 | 脚本工具 | R脚本', '', '5', '202', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500300', 'treeNumber', '专用参数 | 机器学习 | 随机森林 | 森林中树的数目', '', '5', '3', '3', '0', '1', '2', null, '1', '1', '1000', '100', '', '0', '2017-05-17 18:00:30', 'admin', '2017-05-17 18:00:30', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500301', 'algorithmDistribution', '专用参数 | 机器学习 | 随机森林 | 森林中树的算法分布', '', '5', '7', '3', '0', '0', '0', null, '', '', '', '', '如果有则长度为2.比如有n棵树，algorithmTypes=a,b  则[0,a) 是 id3, [a,b) 是cart， [b,n) 是c4.5。例如：在一个拥有5棵树的森林中，[2, 4]表示0，1为id3算法，2, 3为cart算法，4为c4.5算法。如果输入为None，则算法在森林中均分。', '0', '2017-05-17 19:07:52', 'admin', '2017-05-17 19:08:01', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500302', 'randomFeatureNumber', '专用参数 | 机器学习 | 随机森林 | 单颗树输入随机特征的个数', '', '5', '3', '3', '0', '0', '2', null, '1', '1', '', '', '范围 [1, N]，N为feature数，默认log2N', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500303', 'minInstsPerNode', '专用参数 | 机器学习 | 随机森林 | 叶节点数据的最小个数', '', '5', '3', '3', '0', '0', '2', null, '1', '1', '', '2', '', '0', '2017-05-17 19:28:46', 'admin', '2017-05-17 19:28:46', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500304', 'maxDepth1', '专用参数 | 机器学习 | 随机森林 | 单颗树的最大深度', '', '5', '3', '3', '0', '0', '2', null, '1', '1', '', '', '默认无穷大', '0', '2017-05-17 19:45:05', 'admin', '2017-05-17 19:45:05', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500305', 'randomInstsNumber', '专用参数 | 机器学习 | 随机森林 | 单颗树输入随机数据的个数（待定）', '', '5', '3', '3', '0', '0', '2', null, '1', '1000', '1000000', '100000', '', '0', '2017-05-17 19:57:08', 'admin', '2017-05-17 19:57:08', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500400', 'treeNumber1', '专用参数 | 机器学习 | GBDT二分类 | 树的数目', '', '5', '3', '3', '0', '1', '2', null, '1', '1', '10000', '500', '', '0', '2017-05-17 20:05:17', 'admin', '2017-05-17 20:05:17', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500401', 'featureRatio', '专用参数 | 机器学习 | GBDT二分类 | 训练特征采样比', '', '5', '5', '3', '0', '0', '1', null, '0.01', '0', '1.0', '0.6', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500402', 'sampleRatio', '专用参数 | 机器学习 | GBDT二分类 | 训练样本采样比', '', '5', '5', '3', '0', '0', '1', null, '0.01', '0', '1.0', '0.6', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500403', 'testRatio', '专用参数 | 机器学习 | GBDT二分类 | 测试样本采样比', '', '5', '5', '3', '0', '0', '1', null, '0.01', '0', '1.0', '0.6', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500404', 'maxLeafCount', '专用参数 | 机器学习 | GBDT二分类 | 最大叶子节点数', '', '5', '3', '3', '0', '0', '2', null, '1', '1', '1000', '32', '', '0', '2017-05-17 20:11:09', 'admin', '2017-05-17 20:11:09', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500405', 'maxDepth', '专用参数 | 机器学习 | GBDT二分类 | 树的最大深度', '', '5', '3', '3', '0', '0', '2', null, '1', '1', '100', '10', '', '0', '2017-05-17 20:14:25', 'admin', '2017-05-17 20:14:25', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500406', 'metricType1', '专用参数 | 机器学习 | GBDT二分类 | 指标类型', '', '5', '3', '3', '0', '1', '5', null, '', '', '', '0', '', '0', '2017-05-18 11:33:43', 'admin', '2017-05-18 11:33:43', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500407', 'shrinkage', '专用参数 | 机器学习 | GBDT二分类 | 学习速率', '', '5', '3', '3', '0', '1', '1', null, '0.01', '0', '1', '0.05', '', '0', '2017-05-18 12:56:41', 'admin', '2017-05-18 12:56:41', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500408', 'minLeafSampleCount', '专用参数 | 机器学习 | GBDT二分类 | 叶子节点最少样本数', '', '5', '3', '3', '0', '0', '2', null, '1', '1', '1000', '500', '', '0', '2017-05-18 13:05:35', 'admin', '2017-05-18 13:05:35', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500409', 'featureSplitValueMaxSize', '专用参数 | 机器学习 | GBDT二分类 | 一个特征分裂的最大数量', '', '5', '3', '3', '0', '0', '2', null, '1', '1', '1000', '500', '', '0', '2017-05-18 13:07:24', 'admin', '2017-05-18 13:07:24', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500500', 'positiveCost', '专用参数 | 机器学习 | 线性支持向量机 | 正例惩罚因子', '', '5', '5', '3', '0', '0', '1', null, '', '0', '', '1.0', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500501', 'negativeCost', '专用参数 | 机器学习 | 线性支持向量机 | 负例惩罚因子', '', '5', '5', '3', '0', '0', '1', null, '', '0', '', '1.0', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500700', 'kNumber', '专用参数 | 机器学习 | KNN | 近邻个数', '', '5', '3', '3', '0', '1', '2', null, '1', '1', '1000', '100', '', '0', '2017-05-17 20:41:30', 'admin', '2017-05-17 20:41:30', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40510000', 'centerNumber', '专用参数 | 机器学习 | KMeans | 聚类数', '', '5', '3', '3', '0', '1', '2', null, '1', '1', '1000', '10', '', '0', '2017-05-17 21:00:00', 'admin', '2017-05-17 21:00:00', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40510001', 'distanceMeasureType', '专用参数 | 机器学习 | KMeans | 距离度量方式', '', '5', '7', '3', '0', '1', '5', null, '', '', '', 'euclidean', '', '0', '2017-05-17 21:02:55', 'admin', '2017-05-17 21:02:55', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40510002', 'centerInitMethod', '专用参数 | 机器学习 | KMeans | 质心初始化方法', '', '5', '7', '3', '0', '1', '5', null, '', '', '', 'random', '', '0', '2017-05-17 21:11:06', 'admin', '2017-05-17 21:11:06', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40520100', 'lossFunctionType', '专用参数 | 机器学习 | GBDT回归 | 损失函数类型', '', '5', '3', '3', '0', '1', '5', null, '', '', '', '0', '', '0', '2017-05-18 11:49:55', 'admin', '2017-05-18 11:50:03', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40520101', 'gbrankLossTau', '专用参数 | 机器学习 | GBDT回归 | gbrank loss中的Tau参数', '', '5', '5', '3', '0', '0', '2', null, '0.1', '0', '1', '0.6', '', '0', '2017-05-18 11:57:20', 'admin', '2017-05-18 11:57:20', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40520102', 'bottomNumber', '专用参数 | 机器学习 | GBDT回归 | gbrank loss/regression loss中的指数底数', '', '5', '3', '3', '0', '0', '2', null, '1', '1', '10', '1', '', '0', '2017-05-18 12:36:25', 'admin', '2017-05-18 12:36:25', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40520113', 'useNewtonStep', '专用参数 | 机器学习 | GBDT回归 | 是否使用牛顿迭代方法', '', '5', '3', '3', '0', '0', '5', null, '', '', '', '1', '', '0', '2017-05-18 13:12:31', 'admin', '2017-05-18 13:12:31', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40590100', 'binCount', '专用参数 | 机器学习 | 预测 | 计算评价指标时阈值按等频/等宽分成多少个桶', '', '5', '3', '3', '0', '1', '2', null, '1000', '1000', '', '1000', '', '0', '2017-05-18 17:20:21', 'admin', '2017-05-18 17:20:21', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0000', 'CCP@#Common-Component-Parameter', '通用参数 | #通用参数', '', '5', '-1', '-1', '-1', '-1', '-1', null, '', '', '', '', '', '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0001', 'CCP@LabelColumnName', '通用参数 | 标签列的列名', 'labelColumnName', '5', '7', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0002', 'CCP@PositiveLabel', '通用参数 | 正样本标签（二分类）', 'positiveLabel', '5', '7', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0003', 'CCP@WeightColumnName', '通用参数 | 权重列的列名', 'weightColumnName', '5', '7', '3', '0', '0', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0004', 'CCP@GroupColumnName', '通用参数 | 分组列的列名', 'groupColumnName', '5', '7', '3', '0', '0', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0005', 'CCP@PredicationResultlColumnName', '通用参数 | 预测输出结果列的列名', 'predicationResultColumnName', '5', '7', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0006', 'CCP@PredicationScoreColumnName', '通用参数 | 预测输出分数列的列名', 'predicationScoreColumnName', '5', '7', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0007', 'CCP@PredicationDetailColumnName', '通用参数 | 预测输出详情列的列名', 'predicationDetailColumnName', '5', '7', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0008', 'CCP@FeatureColumnNames', '通用参数 | 特征列的列名列表（选择特征）（不建议）', 'featureColumnNames', '5', '9001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0009', 'CCP@ForceDiscreteColumnNames', '通用参数 | 离散列的列名列表（强制转换）（不建议）', 'forceDiscreteColumnNames', '5', '9000', '3', '0', '0', '0', null, '', '', '', '', 'feature默认解析规则： string、boolean、date、datetime类型的列解析为离散类型。 整数和浮点数类型的列解析为连续类型，若有将bigint解析为categorical/nominal的情况，通过参数cmptParam_ml_forceDiscreteColumnNames指定。', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0010', 'CCP@ReverseColumnNames', '通用参数 | 保留列的列名列表（附加特征）（不建议）', 'reverseColumnNames', '5', '9000', '3', '0', '0', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0011', 'CCP@ExcludedColumnNames', '通用参数 | 排除列的列名列表（排除特征）（不建议）', 'excludedColumnNames', '5', '9000', '3', '0', '0', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-IO@COM-0013', 'CCP@IO-TableName', '通用参数 | 输入输出 | 数据表名', 'tableName', '5', '7', '3', '0', '1', '0', null, '', '', '', '', '用于数据表读取系列的表名值存放', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-IO@COM-0014', 'CCP@IO-ModelID', '通用参数 | 输入输出 | 模型ID', 'modelID', '5', '4', '3', '0', '1', '0', null, '', '', '', '', '用于模型读取系列组件的模型ID值存放', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-ML@COM-0001', 'CCP@ML-RandSeed', '通用参数 | 机器学习 | 随机数种子', 'randomSeed', '5', '3', '3', '0', '0', '2', null, '1', '0', '10', '0', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-0000', 'EX@#Execution', '调用执行 | #调用执行', '', '3', '-1', '-1', '-1', '-1', '-1', null, '', '', '', '', '', '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-0001', 'EX@Engine-Type', '调用执行 | 计算引擎', 'engineType', '3', '7', '1', '0', '1', '5', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-0002', 'EX@Spark-Cmpt-Jar-Dir', '调用执行 | spark组件jar库目录', 'jarDir', '3', '7', '1', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-0003', 'EX@Spark-Cmpt-Jar-File', '调用执行 | spark组件jar包文件名', 'jarFile', '3', '7', '2', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-0004', 'EX@Spark-Cmpt-Class-Path', '调用执行 | spark组件class路径', 'class', '3', '7', '2', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-0005', 'EX@Spark-Cmpt-Python-Pkg-Dir', '调用执行 | spark组件python包目录', 'pythonPkgDir', '3', '7', '2', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-0006', 'EX@Spark-Cmpt-Python-File', '调用执行 | spark组件python文件名', 'pythonFile', '3', '7', '2', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-0007', 'EX@Spark-Cmpt-R-Pkg-Dir', '调用执行 | spark组件R包目录', 'rPkgDir', '3', '7', '2', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-0008', 'EX@Spark-Cmpt-R-File', '调用执行 | spark组件R文件名', 'rFile', '3', '7', '2', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0000', 'IN@#Input-Content', '输入内容 | #输入内容', '', '1', '-1', '-1', '-1', '-1', '-1', null, '', '', '', '', '', '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0001', 'IN@DataTable-t1<M>', '输入内容 | 数据表t1<M>', 't1', '1', '1001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0002', 'IN@DataTable-t2<M>', '输入内容 | 数据表t2<M>', 't2', '1', '1001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0003', 'IN@DataTable-t2<C>', '输入内容 | 数据表t2<C>', 't2', '1', '1001', '3', '0', '0', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0004', 'IN@DataTable-t3<M>', '输入内容 | 数据表t3<M>', 't3', '1', '1001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0005', 'IN@DataTable-t3<C>', '输入内容 | 数据表t3<C>', 't3', '1', '1001', '3', '0', '0', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0006', 'IN@DataTable-t4<M>', '输入内容 | 数据表t4<M>', 't4', '1', '1001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0007', 'IN@DataTable-t4<C>', '输入内容 | 数据表t4<C>', 't4', '1', '1001', '3', '0', '0', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0008', 'IN@DataTable-t5<M>', '输入内容 | 数据表t5<M>', 't5', '1', '1001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0009', 'IN@DataTable-t5<C>', '输入内容 | 数据表t5<C>', 't5', '1', '1001', '3', '0', '0', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0010', 'IN@DataTable-t6<M>', '输入内容 | 数据表t6<M>', 't6', '1', '1001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0011', 'IN@DataTable-t6<C>', '输入内容 | 数据表t6<C>', 't6', '1', '1001', '3', '0', '0', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0012', 'IN@Algorithm<OneClass-Classification>-a1<M>', '输入内容 | 单分类算法参数a1<M>', 'a1', '1', '4001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0013', 'IN@Algorithm<TwoClass-Classification>-a1<M>', '输入内容 | 二分类算法参数a1<M>', 'a1', '1', '4002', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0014', 'IN@Algorithm<MultipleClass-Classification>-a1<M>', '输入内容 | 多分类算法参数a1<M>', 'a1', '1', '4003', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0015', 'IN@Algorithm<Classification>-a1<M>', '输入内容 | 通配分类算法参数a1<M>', 'a1', '1', '4004', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0016', 'IN@Algorithm<Clustering>-a1<M>', '输入内容 | 聚类算法参数a1<M>', 'a1', '1', '4005', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0017', 'IN@Algorithm<Regression>-a1<M>', '输入内容 | 回归算法参数a1<M>', 'a1', '1', '4006', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0018', 'IN@Algorithm<Classification,Regression>-a1<M>', '输入内容 | 通配分类&回归算法参数a1<M>', 'a1', '1', '4007', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0019', 'IN@Model<OneClass-Classification>-m1<M>', '输入内容 | 单分类模型m1<M>', 'm1', '1', '2001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0020', 'IN@Model<TwoClass-Classification>-m1<M>', '输入内容 | 二分类模型m1<M>', 'm1', '1', '2002', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0021', 'IN@Model<MultipleClass-Classification>-m1<M>', '输入内容 | 多分类模型m1<M>', 'm1', '1', '2003', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0022', 'IN@Model<Classification>-m1<M>', '输入内容 | 通配分类模型m1<M>', 'm1', '1', '2004', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0023', 'IN@Model<Clustering>-m1<M>', '输入内容 | 聚类模型m1<M>', 'm1', '1', '2005', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0024', 'IN@Model<Regression>-m1<M>', '输入内容 | 回归模型m1<M>', 'm1', '1', '2006', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0025', 'IN@Model<Classification,Regression>-m1<M>', '输入内容 | 通配分类&回归模型m1<M>', 'm1', '1', '2007', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0026', 'IN@Model<CollaborativeFiltering>-m1<M>', '输入内容 | 协同过滤模型m1<M>', 'm1', '1', '2008', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OEX@C-0000', 'OEX@#OptimizeExecution', '执行调优 | #执行调优', '', '4', '-1', '-1', '-1', '-1', '-1', null, '', '', '', '', '', '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OEX@C-0001', 'OEX@Spark-Executor-Number', '执行调优 | spark.executor.number', 'spark.executor.number', '4', '3', '3', '0', '0', '0', null, '1', '1', '100', '1', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OEX@C-0002', 'OEX@Spark-Executor-Cores', '执行调优 | spark.executor.cores', 'spark.executor.cores', '4', '3', '3', '0', '0', '0', null, '1', '1', '100', '8', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OEX@C-0003', 'OEX@Spark-Executor-Memory', '执行调优 | spark.executor.memory', 'spark.executor.memory', '4', '3', '3', '0', '0', '0', null, '1', '256', '131072', '2048', '内存单位MB，最多128GB', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OEX@C-0004', 'OEX@Spark-Driver-Cores', '执行调优 | spark.driver.cores', 'spark.driver.cores', '4', '3', '3', '0', '0', '0', null, '1', '1', '100', '8', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OEX@C-0005', 'OEX@Spark-Driver-Memory', '执行调优 | spark.driver.memory', 'spark.driver.memory', '4', '3', '3', '0', '0', '0', null, '1', '256', '262144', '1024', '内存单位MB，最多256GB', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OEX@C-0006', 'OEX@Spark-Extra-Configuration', '执行调优 | spark.extra.configuration（待定）', 'spark.extra.configuration', '4', '7', '3', '0', '0', '0', null, '', '', '', '', '', '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0000', 'OUT@#Output-Content', '输出内容 | #输出内容', '', '2', '-1', '-1', '-1', '-1', '-1', null, '', '', '', '', '', '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0001', 'OUT@DataTable-t1<M>', '输出内容 | 数据表t1<M>', 't1', '2', '1001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0002', 'OUT@DataTable-t2<M>', '输出内容 | 数据表t2<M>', 't2', '2', '1001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0003', 'OUT@DataTable-t2<C>', '输出内容 | 数据表t2<C>', 't2', '2', '1001', '3', '0', '0', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0004', 'OUT@DataTable-t3<M>', '输出内容 | 数据表t3<M>', 't3', '2', '1001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0005', 'OUT@DataTable-t3<C>', '输出内容 | 数据表t3<C>', 't3', '2', '1001', '3', '0', '0', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0006', 'OUT@DataTable-t4<M>', '输出内容 | 数据表t4<M>', 't4', '2', '1001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0007', 'OUT@DataTable-t4<C>', '输出内容 | 数据表t4<C>', 't4', '2', '1001', '3', '0', '0', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0008', 'OUT@DataTable-t5<M>', '输出内容 | 数据表t5<M>', 't5', '2', '1001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0009', 'OUT@DataTable-t5<C>', '输出内容 | 数据表t5<C>', 't5', '2', '1001', '3', '0', '0', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0010', 'OUT@DataTable-t6<M>', '输出内容 | 数据表t6<M>', 't6', '2', '1001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0011', 'OUT@DataTable-t6<C>', '输出内容 | 数据表t6<C>', 't6', '2', '1001', '3', '0', '0', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0012', 'OUT@Algorithm<OneClass-Classification>-a1<M>', '输出内容 | 单分类算法参数a1<M>', 'a1', '2', '4001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0013', 'OUT@Algorithm<TwoClass-Classification>-a1<M>', '输出内容 | 二分类算法参数a1<M>', 'a1', '2', '4002', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0014', 'OUT@Algorithm<MultipleClass-Classification>-a1<M>', '输出内容 | 多分类算法参数a1<M>', 'a1', '2', '4003', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0015', 'OUT@Algorithm<Clustering>-a1<M>', '输出内容 | 聚类算法参数a1<M>', 'a1', '2', '4005', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0016', 'OUT@Algorithm<Regression>-a1<M>', '输出内容 | 回归算法参数a1<M>', 'a1', '2', '4006', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0017', 'OUT@Algorithm<Classification>-a1<M>', '输出内容 | 通配分类算法参数a1<M>', 'a1', '2', '4004', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0018', 'OUT@Algorithm<Classification,Regression>-a1<M>', '输出内容 | 通配分类&回归算法参数a1<M>', 'a1', '2', '4007', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0019', 'OUT@Model<OneClass-Classification>-m1<M>', '输出内容 | 单分类模型m1<M>', 'm1', '2', '2001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0020', 'OUT@Model<TwoClass-Classification>-m1<M>', '输出内容 | 二分类模型m1<M>', 'm1', '2', '2002', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0021', 'OUT@Model<MultipleClass-Classification>-m1<M>', '输出内容 | 多分类模型m1<M>', 'm1', '2', '2003', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0022', 'OUT@Model<Clustering>-m1<M>', '输出内容 | 聚类模型m1<M>', 'm1', '2', '2005', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0023', 'OUT@Model<Regression>-m1<M>', '输出内容 | 回归模型m1<M>', 'm1', '2', '2006', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0024', 'OUT@Model<CollaborativeFiltering>-m1<M>', '输出内容 | 协同过滤模型m1<M>', 'm1', '2', '2008', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0025', 'OUT@Model<Classification>-m1<M>', '输出内容 | 通配分类模型m1<M>', 'm1', '2', '2004', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0026', 'OUT@Model<Classification,Regression>-m1<M>', '输出内容 | 通配分类&回归模型m1<M>', 'm1', '2', '2007', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0027', 'OUT@Report<ModelEvaluation>-r1<M>', '输出内容 | 模型评估报告r1<M>', 'r1', '2', '5001', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0028', 'OUT@Report<StatisticsAnalysis>-r1<M>', '输出内容 | 统计分析报告r1<M>', 'r1', '2', '5002', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0029', 'OUT@Report<CrossValidation>-r1<M>', '输出内容 | 交叉验证报告r1<M>', 'r1', '2', '5003', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0030', 'OUT@Report<TuneParameters>-r1<M>', '输出内容 | 自动调参报告r1<M>', 'r1', '2', '5004', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0031', 'OUT@Report<GenerateRules>-r1<M>', '输出内容 | 生成规则报告r1<M>', 'r1', '2', '5005', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-AA@COM-0000-00', 'SCP@#Special-Component-Parameter', '专用参数 | #专用参数', '', '5', '-1', '-1', '-1', '-1', '-1', null, '', '', '', '', '', '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-01', 'SCP@Import-DataFile@FileType', '专用参数 | 输入输出 | 数据文件导入 | 文件类型', 'fileType', '5', '7', '3', '0', '1', '5', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-02', 'SCP@Import-DataFile@FilePath', '专用参数 | 输入输出 | 数据文件导入 | 文件路径', 'filePath', '5', '7', '3', '0', '1', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-03', 'SCP@Import-DataFile@ColumnDelimiter', '专用参数 | 输入输出 | 数据文件导入 | 列分隔符', 'columnDelimiter', '5', '7', '3', '0', '0', '0', null, '', '', '', '0x2C', '列分隔符，内容填写相应符号的ASCII码十六进制值，例如CSV默认为逗号（0x2C），TSV默认为制表符（0x09），TXT默认为空格（0x20）', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-04', 'SCP@Import-DataFile@LineDelimiter', '专用参数 | 输入输出 | 数据文件导入 | 行分隔符', 'lineDelimiter', '5', '7', '3', '0', '0', '0', null, '', '', '', '0x0A', '行分隔符，内容填写相应符号的ASCII码十六进制值，例如Window默认为回车符换行符（0x0D0x0A），MacOS默认为回车符（0xD），Unix/Linux默认为换行符（0x0A）', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-05', 'SCP@Import-DataFile@CharacterEncoding', '专用参数 | 输入输出 | 数据文件导入 | 字符编码', 'characterEncoding', '5', '7', '3', '0', '1', '5', null, '', '', '', 'UTF-8', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-06', 'SCP@Import-DataFile@ExistHeader', '专用参数 | 输入输出 | 数据文件导入 | 首行是否为字段标题', 'existHeader', '5', '1', '3', '0', '0', '0', null, '', '', '', 'false', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-07', 'SCP@Import-DataFile@Schema', '专用参数 | 输入输出 | 数据文件导入 | 字段描述列表', 'schema', '5', '9001', '3', '0', '0', '0', null, '', '', '', '', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-08', 'SCP@Import-DataFile@DateFormat', '专用参数 | 输入输出 | 数据文件导入 | 日期格式', 'dateFormat', '5', '7', '3', '0', '0', '0', null, '', '', '', 'yyyy-mm-dd', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-09', 'SCP@Import-DataFile@TimeFormat', '专用参数 | 输入输出 | 数据文件导入 | 时间格式', 'timeFormat', '5', '7', '3', '0', '0', '0', null, '', '', '', 'yyyy-mm-dd hh24:mi:ss', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-10', 'SCP@Import-DataFile@TypeException', '专用参数 | 输入输出 | 数据文件导入 | 字段类型异常处理', 'typeException', '5', '7', '3', '0', '0', '5', null, '', '', '', 'missing value', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-11', 'SCP@Import-DataFile@ColumnsException', '专用参数 | 输入输出 | 数据文件导入 | 列数异常处理', 'columnsException', '5', '7', '3', '0', '0', '5', null, '', '', '', 'discard row', '', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');

-- ----------------------------
-- Table structure for cf_cmpt_char_enum
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_char_enum`;
CREATE TABLE `cf_cmpt_char_enum` (
  `CHAR_ID` varchar(64) NOT NULL COMMENT '特征ID',
  `ENUM_NAME` varchar(200) NOT NULL COMMENT '枚举值名称',
  `ENUM_VALUE` varchar(2000) NOT NULL COMMENT '枚举值',
  `ENUM_LABEL` varchar(200) DEFAULT NULL COMMENT '枚举值标签，用于下拉框显示用，NULL时使用ENUM_VALUE填充',
  `SEQUENCE` int(11) NOT NULL COMMENT '排序序号',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CHAR_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件特征枚举表，配置受枚举方式限定的组件特征，其所有预置的枚举项';

-- ----------------------------
-- Records of cf_cmpt_char_enum
-- ----------------------------
INSERT INTO `cf_cmpt_char_enum` VALUES ('40034', '专用参数 | 机器学习 | 正则项类型 | None', 'None', null, '0', '', '0', '2017-05-12 02:06:11', 'admin', '2017-05-12 02:06:11', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40034', '专用参数 | 机器学习 | 正则项类型 | L1', 'L1', null, '1', '', '0', '2017-05-12 02:07:04', 'admin', '2017-05-12 02:07:04', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40034', '专用参数 | 机器学习 | 正则项类型 | L2', 'L2', null, '2', '', '0', '2017-05-12 02:07:39', 'admin', '2017-05-12 02:07:39', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40510001', '专用参数 | 机器学习 | KMeans | 距离度量方式 | Euclidean', 'euclidean', null, '0', '', '0', '2017-05-17 21:03:39', 'admin', '2017-05-17 21:03:48', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40510001', '专用参数 | 机器学习 | KMeans | 距离度量方式 | Cosine', 'cosine', null, '1', '', '0', '2017-05-17 21:04:16', 'admin', '2017-05-17 21:04:16', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40510001', '专用参数 | 机器学习 | KMeans | 距离度量方式 | Cityblock', 'cityblock', null, '2', '', '0', '2017-05-17 21:05:03', 'admin', '2017-05-17 21:05:03', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40510002', '专用参数 | 机器学习 | KMeans | 质心初始化方法 | Random', 'random', null, '0', '', '0', '2017-05-17 21:13:49', 'admin', '2017-05-17 21:13:49', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40510002', '专用参数 | 机器学习 | KMeans | 质心初始化方法 | Top K', 'topk', null, '1', '', '0', '2017-05-17 21:14:51', 'admin', '2017-05-17 21:14:51', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40510002', '专用参数 | 机器学习 | KMeans | 质心初始化方法 | Uniform', 'uniform', null, '2', '', '0', '2017-05-17 21:15:12', 'admin', '2017-05-17 21:15:12', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40510002', '专用参数 | 机器学习 | KMeans | 质心初始化方法 | KMPP', 'kmpp', null, '3', '', '0', '2017-05-17 21:15:55', 'admin', '2017-05-17 21:15:55', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40510002', '专用参数 | 机器学习 | KMeans | 质心初始化方法 | External', 'external', null, '4', '', '0', '2017-05-17 21:16:46', 'admin', '2017-05-17 21:16:46', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('EX@C-0001', '调用执行 | 计算引擎 | spark on yarn', 'spark on yarn', null, '0', '', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('EX@C-0001', '调用执行 | 计算引擎 | spark on mesos', 'spark on mesos', null, '1', '', '0', '2017-05-17 15:25:50', 'admin', '2017-05-17 15:25:50', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | CSV', 'CSV', null, '0', '字段逗号分隔', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | TSV', 'TSV', null, '1', '字段TAB分割', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | TXT', 'TXT', null, '2', '字段空格分隔', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | ARFF', 'ARFF', null, '3', 'weka专用的文件格式', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | COO', 'COO', null, '4', 'Coordinate稀疏矩阵文件格式', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | CSR', 'CSR', null, '5', 'Compressed Sparse Row稀疏矩阵文件格式', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | CSC', 'CSC', null, '6', 'Compressed Sparse Column稀疏矩阵文件格式', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | ELL', 'ELL', null, '7', 'ELLPACK稀疏矩阵文件格式', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | DIA', 'DIA', null, '8', 'Diagonal稀疏矩阵文件格式', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | HYB', 'HYB', null, '9', 'Hybrid ELLPACK + Coordinate稀疏矩阵文件格式', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | Parquet', 'Parquet', null, '10', 'Parquet列式存储文件格式', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-05', '专用参数 | 输入输出 | 数据文件导入 | 字符编码 | UTF-8', 'UTF-8', null, '0', '', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-05', '专用参数 | 输入输出 | 数据文件导入 | 字符编码 | Unicode', 'Unicode', null, '1', '', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-05', '专用参数 | 输入输出 | 数据文件导入 | 字符编码 | GBK', 'GBK', null, '2', '', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-05', '专用参数 | 输入输出 | 数据文件导入 | 字符编码 | GB2312', 'GB2312', null, '3', '', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-05', '专用参数 | 输入输出 | 数据文件导入 | 字符编码 | GB18030', 'GB18030', null, '4', '', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-05', '专用参数 | 输入输出 | 数据文件导入 | 字符编码 | BIG5', 'BIG5', null, '5', '', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-10', '专用参数 | 输入输出 | 数据文件导入 | 字段类型异常处理 | Missing Value', 'missing value', '值设置为缺失', '0', '', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-10', '专用参数 | 输入输出 | 数据文件导入 | 字段类型异常处理 | Discard Row', 'discard row', '丢弃异常行', '1', '', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-10', '专用参数 | 输入输出 | 数据文件导入 | 字段类型异常处理 | Return Failed', 'return failed', '返回失败', '2', '', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-11', '专用参数 | 输入输出 | 数据文件导入 | 字段类型异常处理 | Discard Row', 'discard row', '丢弃异常行', '0', '', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-11', '专用参数 | 输入输出 | 数据文件导入 | 字段类型异常处理 | Return Failed', 'return failed', '返回失败', '1', '', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');

-- ----------------------------
-- Table structure for cf_cmpt_char_type
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_char_type`;
CREATE TABLE `cf_cmpt_char_type` (
  `CHAR_TYPE_ID` int(11) NOT NULL COMMENT '特征类型ID',
  `CHAR_TYPE_CODE` varchar(200) NOT NULL COMMENT '特征类型代码',
  `CHAR_TYPE_NAME` varchar(200) NOT NULL COMMENT '特征类型名称',
  `IS_COMBINE` int(11) NOT NULL DEFAULT '0' COMMENT '是否为组合类型\r\n0：否\r\n1：是',
  `SPEC_TYPE_MASK` int(11) NOT NULL DEFAULT '0' COMMENT '适用规格类型二进制掩码（预留）\r\n\r\n0：不支持作为对应规格的特征类型使用\r\n1：支持作为对应规格的特征类型使用\r\n\r\n第一位，输入内容规格，开关位0x01：数据表、模型、算法参数\r\n第二位，输出内容规格，开关位0x02：数据表、模型、算法参数\r\n第三位，调用执行规格，开关位0x04：基本类型\r\n第四位，执行调优规格，开关位0x08：基本类型\r\n第五位，组件参数规格，开关位0x10：基本类型、调参类型、代码脚本、Json Object、Json Array\r\n',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CHAR_TYPE_ID`),
  UNIQUE KEY `Index_1` (`CHAR_TYPE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件特征类型表（仅查询用），相关定义辅助于数据校验和画布连线输入输出类型匹配校验';

-- ----------------------------
-- Records of cf_cmpt_char_type
-- ----------------------------
INSERT INTO `cf_cmpt_char_type` VALUES ('1', 'Boolean', '布尔值', '0', '28', '特征值为true/false字符串，多值以逗号分隔，最多支持10', '0', '2017-05-12 00:42:11', 'admin', '2017-05-12 00:42:11', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2', 'Short', '16位整数', '0', '28', '', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('3', 'Integer', '32为整数', '0', '28', '', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4', 'Long', '64位整数', '0', '28', '', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('5', 'Float', '单精度浮点数', '0', '28', '', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('6', 'Double', '双精度浮点数', '0', '28', '', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('7', 'String', '字符串', '0', '28', '', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('8', 'Date', '日期', '0', '28', '特征值为“yyyy-mm-dd”格式字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('9', 'Datetime', '日期时间', '0', '28', '特征值为“yyyy-mm-dd hh24:mi:ss”格式字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('102', 'Tuning-Parameter<Integer>', '32位整数调参类型', '0', '16', '特征值格式示例（用户自定义参数不超过10个）：\r\n{\r\n  \"value\": \"100\",\r\n  \"tune_range\": {\r\n    \"start\": \"20\",\r\n    \"end\": \"1000\"\r\n  },\r\n  \"tune_udps\": [10, 80, 200, 600, 1000]\r\n}', '0', '2018-11-16 21:31:15', 'admin', '2018-11-16 21:31:15', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('103', 'Tuning-Parameter<Long>', '64位整数调参类型', '0', '16', '特征值格式示例（用户自定义参数不超过10个）：\r\n{\r\n  \"value\": \"100\",\r\n  \"tune_range\": {\r\n    \"start\": \"20\",\r\n    \"end\": \"1000\"\r\n  },\r\n  \"tune_udps\": [10, 80, 200, 600, 1000]\r\n}', '0', '2018-11-16 21:31:15', 'admin', '2018-11-16 21:31:15', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('104', 'Tuning-Parameter<Float>', '单精度浮点数调参类型', '0', '16', '特征值格式示例（用户自定义参数不超过10个）：\r\n{\r\n  \"value\": \"0.01\",\r\n  \"tune_range\": {\r\n    \"start\": \"0.00001\",\r\n    \"end\": \"0.1\"\r\n  },\r\n  \"tune_udps\": [0.00001, 0.001, 0.01, 0.1]\r\n}', '0', '2018-11-16 21:31:15', 'admin', '2018-11-16 21:31:15', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('105', 'Tuning-Parameter<Double>', '双精度浮点数调参类型', '0', '16', '特征值格式示例（用户自定义参数不超过10个）：\r\n{\r\n  \"value\": \"0.01\",\r\n  \"tune_range\": {\r\n    \"start\": \"0.00001\",\r\n    \"end\": \"0.1\"\r\n  },\r\n  \"tune_udps\": [0.00001, 0.001, 0.01, 0.1]\r\n}', '0', '2018-11-16 21:31:15', 'admin', '2018-11-16 21:31:15', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('1000', 'Data Table<?>', '通配泛型数据表', '0', '3', '特征值为数据表ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('1001', 'Data Table<Parquet>', 'Parquet数据表（预留）', '0', '3', '特征值为数据表ID字符串，暂时不使用', '-1', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2000', 'Trained Model<?>', '通配泛型模型', '1', '3', '特征值为模型ID字符串，用于模型写入、模型文件输出', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2001', 'Trained Model<OneClass-Classification>', '单分类模型', '0', '3', '特征值为模型ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2002', 'Trained Model<TwoClass-Classification>', '二分类模型', '0', '3', '特征值为模型ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2003', 'Trained Model<MultipleClass-Classification>', '多分类模型', '0', '3', '特征值为模型ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2004', 'Trained Model<Classification>', '通配分类模型', '1', '3', '特征值为模型ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2005', 'Trained Model<Clustering>', '聚类模型', '0', '3', '特征值为模型ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2006', 'Trained Model<Regression>', '回归模型', '0', '3', '特征值为模型ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2007', 'Trained Model<Classification,Regression>', '通配分类&回归模型', '1', '3', '特征值为模型ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2008', 'Trained Model<CollaborativeFiltering>', '协同过滤模型', '0', '3', '特征值为模型ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('3001', 'SQL Script', 'SQL脚本', '0', '16', '特征值为脚本ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('3002', 'Python Script', 'Python脚本', '0', '16', '特征值为脚本ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('3003', 'R Script', 'R脚本', '0', '16', '特征值为脚本ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('3004', 'Feature Extraction Script', '特征抽取脚本（不使用，方案待定）', '0', '16', '特征值为脚本ID字符串', '-1', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4000', 'Algorithm Parameters<?>', '通配泛型算法参数（不使用）', '0', '3', null, '-1', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4001', 'Algorithm Parameters<OneClass-Classification>', '单分类算法参数', '0', '3', '特征值为JSON对象ID字符串', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4002', 'Algorithm Parameters<TwoClass-Classification>', '二分类算法参数', '0', '3', '特征值为JSON对象ID字符串', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4003', 'Algorithm Parameters<MultipleClass-Classification>', '多分类算法参数', '0', '3', '特征值为JSON对象ID字符串', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4004', 'Algorithm Parameters<Classification>', '通配分类算法参数', '1', '3', '特征值为JSON对象ID字符串', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4005', 'Algorithm Parameters<Clustering>', '聚类算法参数', '0', '3', '特征值为JSON对象ID字符串', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4006', 'Algorithm Parameters<Regression>', '回归算法参数', '0', '3', '特征值为JSON对象ID字符串', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4007', 'Algorithm Parameters<Classification,Regression>', '通配分类&回归算法参数', '1', '3', '特征值为JSON对象ID字符串', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('5001', 'Model Evaluation Report', '模型评估报告', '0', '2', '特征值为JSON对象ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('5002', 'Statistics Analysis Report', '统计分析报告', '0', '2', '特征值为JSON对象ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('5003', 'Cross Validation Report', '交叉验证报告', '0', '2', '特征值为JSON对象ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('5004', 'Tune Parameters Report', '自动调参报告', '0', '2', '特征值为JSON对象ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('5005', 'Generate Rules Report', '生成规则报告', '0', '2', '特征值为JSON对象ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('9000', 'Json Object', 'json对象', '0', '16', '特征值为JSON对象ID字符串', '0', '2017-05-12 00:31:39', 'admin', '2017-05-12 00:31:39', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('9001', 'Json Array', 'json数组', '0', '16', '特征值为JSON对象ID字符串', '0', '2017-05-12 00:31:39', 'admin', '2017-05-12 00:31:39', 'admin');

-- ----------------------------
-- Table structure for cf_cmpt_char_type_combine
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_char_type_combine`;
CREATE TABLE `cf_cmpt_char_type_combine` (
  `COMBINE_CHAR_TYPE_ID` int(11) NOT NULL COMMENT '组合特征类型ID',
  `MEMEBER_CHAR_TYPE_ID` int(11) NOT NULL COMMENT '成员特征类型ID',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`COMBINE_CHAR_TYPE_ID`,`MEMEBER_CHAR_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件特征类型组合表（仅查询用），配置组合类型和成员类型的关系';

-- ----------------------------
-- Records of cf_cmpt_char_type_combine
-- ----------------------------
INSERT INTO `cf_cmpt_char_type_combine` VALUES ('2000', '2005', 'Trained Model<?>：Trained Model<Clustering>', '0', '2018-11-21 16:44:59', 'admin', '2018-11-21 16:44:59', 'admin');
INSERT INTO `cf_cmpt_char_type_combine` VALUES ('2000', '2007', 'Trained Model<?>：Algorithm Parameters<Classification,Regression>', '0', '2018-11-21 16:44:59', 'admin', '2018-11-21 16:44:59', 'admin');
INSERT INTO `cf_cmpt_char_type_combine` VALUES ('2000', '2008', 'Trained Model<?>：Trained Model<CollaborativeFiltering>', '0', '2018-11-21 16:53:00', 'admin', '2018-11-21 16:53:00', 'admin');
INSERT INTO `cf_cmpt_char_type_combine` VALUES ('2004', '2001', 'Trained Model<Classification>：Trained Model<OneClass-Classification>', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `cf_cmpt_char_type_combine` VALUES ('2004', '2002', 'Trained Model<Classification>：Trained Model<TwoClass-Classification>', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `cf_cmpt_char_type_combine` VALUES ('2004', '2003', 'Trained Model<Classification>：Trained Model<MultipleClass-Classification>', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `cf_cmpt_char_type_combine` VALUES ('2007', '2004', 'Trained Model<Classification,Regression>：Trained Model<Classification>', '0', '2018-11-18 19:14:59', 'admin', '2018-11-18 19:14:59', 'admin');
INSERT INTO `cf_cmpt_char_type_combine` VALUES ('2007', '2006', 'Trained Model<Classification,Regression>：Trained Model<Regression>', '0', '2018-11-18 19:14:59', 'admin', '2018-11-18 19:14:59', 'admin');
INSERT INTO `cf_cmpt_char_type_combine` VALUES ('4004', '4001', 'Algorithm Parameters<Classification>：Algorithm Parameters<OneClass-Classification>', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `cf_cmpt_char_type_combine` VALUES ('4004', '4002', 'Algorithm Parameters<Classification>：Algorithm Parameters<TwoClass-Classification>', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `cf_cmpt_char_type_combine` VALUES ('4004', '4003', 'Algorithm Parameters<Classification>：Algorithm Parameters<MultipleClass-Classification>', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `cf_cmpt_char_type_combine` VALUES ('4007', '4004', 'Algorithm Parameters<Classification,Regression>：Algorithm Parameters<Classification>', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `cf_cmpt_char_type_combine` VALUES ('4007', '4006', 'Algorithm Parameters<Classification,Regression>：Algorithm Parameters<Regression>', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');

-- ----------------------------
-- Table structure for cf_cmpt_char_value
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_char_value`;
CREATE TABLE `cf_cmpt_char_value` (
  `CMPT_ID` varchar(64) NOT NULL COMMENT '组件ID',
  `CHAR_ID` varchar(64) NOT NULL COMMENT '特征ID',
  `IS_SYSTEM_PARAM` int(11) NOT NULL COMMENT '特征值是否为系统参数\r\n            0：否\r\n            1：是',
  `CHAR_VALUE` varchar(2000) DEFAULT NULL COMMENT '特征值',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CMPT_ID`,`CHAR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件配置特征值表，预置在组件上的组件特征值设定';

-- ----------------------------
-- Records of cf_cmpt_char_value
-- ----------------------------

-- ----------------------------
-- Table structure for cf_cmpt_spec
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_spec`;
CREATE TABLE `cf_cmpt_spec` (
  `SPEC_ID` varchar(64) NOT NULL COMMENT '规格ID，长度限制20\r\n            \r\n            输入内容规格ID范围：IN@SPEC-[0000 ~ 9999]\r\n            输出内容规格ID范围：OUT@SPEC-[0000 ~ 9999]\r\n            调用执行规格ID范围：EX@SPEC-[0000 ~ 9999]\r\n            执行调优参规格ID范围：OEX@SPEC-[0000 ~ 9999]\r\n            组件参数规格ID范围：CP@SPEC-${CMPT-ID}',
  `SPEC_CODE` varchar(200) NOT NULL COMMENT '规格代码（预留）',
  `SPEC_NAME` varchar(200) NOT NULL COMMENT '规格名称',
  `SPEC_TYPE` int(11) NOT NULL COMMENT '规格类型\r\n1：input，输入内容规格（无此类规格代表无输入内容，仅供数据流转和连线校验用，不做存储）\r\n2：output，输出内容规格（无此类规格代表无输出内容，在运行时分配存储）\r\n3：execution，调用执行规格（无此类规格代表无需执行，基本是配置数据）\r\n4：optimize execution，执行调优参数规格（无此类规格代表无执行调优参数，在编辑时分配存储）\r\n5：parameter，组件参数规格（无此类规格代表无需组件参数配置，在编辑时分配存储）',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SPEC_ID`),
  UNIQUE KEY `Index_1` (`SPEC_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件规格表，同一组件规格下组件特征别名不能冲突';

-- ----------------------------
-- Records of cf_cmpt_spec
-- ----------------------------
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-AA@COM-0000', 'CP@#Component-Parameter', '组件参数 | #组件参数', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-0001', 'CP@Read-DataTable', '组件参数 | 输入输出 | 数据表读取', '5', '数据表名', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-0002', 'CP@Read-OneClass-Classification-Model', '组件参数 | 输入输出 | 单分类模型读取', '5', '模型ID', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-0003', 'CP@Read-TwoClass-Classification-Model', '组件参数 | 输入输出 | 二分类模型读取', '5', '模型ID', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-0004', 'CP@Read-MultipleClass-Classification-Model', '组件参数 | 输入输出 | 多分类模型读取', '5', '模型ID', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-0005', 'CP@Read-Clustering-Model', '组件参数 | 输入输出 | 聚类模型读取', '5', '模型ID', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-0006', 'CP@Read-Regression-Model', '组件参数 | 输入输出 | 回归模型读取', '5', '模型ID', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-0007', 'CP@Read-CollaborativeFiltering-Model', '组件参数 | 输入输出 | 协同过滤模型读取', '5', '模型ID', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-0008', 'CP@Write-DataTable', '组件参数 | 输入输出 | 数据表写入', '5', '数据表名，表名修改同时联动数据表名更新', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-9999', 'CP@Import-DataFile', '组件参数 | 输入输出 | 数据文件导入', '5', '结合数据文件上传接口，整理组件参数项', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0001', 'CP@LR-TwoClass-Classification', '组件参数 | 机器学习 | 逻辑回归二分类算法', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0002', 'CP@LR-MultipleClass-Classification', '组件参数 | 机器学习 | 逻辑回归多分类算法', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0003', 'CP@RF-TwoClass-Classification', '组件参数 | 机器学习 | 随机森林二分类算法', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0004', 'CP@RF-MultipleClass-Classification', '组件参数 | 机器学习 | 随机森林多分类算法', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0005', 'CP@GBDT-TwoClass-Classification', '组件参数 | 机器学习 | GBDT二分类算法', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0006', 'CP@XGBoost-TwoClass-Classification', '组件参数 | 机器学习 | XGBoost二分类算法（待定）', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0007', 'CP@XGBoost-MultipleClass-Classification', '组件参数 | 机器学习 | XGBoost 多分类算法（待定）', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0008', 'CP@LinearSVM-TwoClass-Classification', '组件参数 | 机器学习 | 线性SVM二分类算法', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0009', 'CP@NaiveBayesian-MultipleClass-Classification', '组件参数 | 机器学习 | 朴素贝叶斯多分类算法', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0010', 'CP@KNN-MultipleClass-Classification', '组件参数 | 机器学习 | K近邻多分类算法', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0011', 'CP@KMeans-Clustering', '组件参数 | 机器学习 | K均值聚类算法', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0012', 'CP@Linear-Regression', '组件参数 | 机器学习 | 线性回归算法', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0013', 'CP@GBDT-Regression', '组件参数 | 机器学习 | GBDT回归算法', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0014', 'CP@XGBoost-Regression', '组件参数 | 机器学习 | XGBoost回归（待定）', '5', '', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0015', 'CP@OneClass-SVM', '组件参数 | 机器学习 | 单分类SVM算法（待定）', '5', '', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0016', 'CP@PCA-Based-AnomalyDetection', '组件参数 | 机器学习 | 基于PCA异常检测算法（待定）', '5', '', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-3001', 'CP@Train-Model', '组件参数 | 机器学习 | 模型训练', '5', '支持回归和分类算法', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-3002', 'CP@Tune-Model-Hyperparameters', '组件参数 | 机器学习 | 模型自动调参', '5', '支持回归和分类算法', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-3003', 'CP@Cross-Validation', '组件参数 | 机器学习 | 交叉验证', '5', '支持回归和分类算法', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-3004', 'CP@Tune-Clustering-Model-Hyperparameters', '组件参数 | 机器学习 | 聚类模型自动调参', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-3005', 'CP@Train-AnomalyDetection-Model', '组件参数 | 机器学习 | 异常检测模型训练（待定）', '5', '', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-3007', 'CP@Train-ALS-CollaborativeFiltering-Model', '组件参数 | 机器学习 | ALS协同过滤模型训练（待定）', '5', '', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-6001', 'CP@Auto-GenerationRules', '组件参数 | 机器学习 | 自动生成规则（待定）', '5', '', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-6002', 'CP@Apriori-AssociationRules', '组件参数 | 机器学习 | Apriori关联规则（待定）', '5', '', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-6003', 'CP@FPG-AssociationRules', '组件参数 | 机器学习 | FP-Growth关联规则（待定）', '5', '', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-8001', 'CP@Prediction', '组件参数 | 机器学习 | 预测', '5', '支持回归和分类模型', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-8002', 'CP@Clustering-Prediction', '组件参数 | 机器学习 | 聚类预测', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-8003', 'CP@CollaborativeFiltering-Prediction', '组件参数 | 机器学习 | 协同过滤预测（待定）', '5', '', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-9001', 'CP@OneClass-Classification-Evaluation', '组件参数 | 机器学习 | 单分类模型评估（异常检测）（待定）', '5', '', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-9002', 'CP@TwoClass-Classification-Evaluation', '组件参数 | 机器学习 | 二分类模型评估', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-9003', 'CP@MultipleClass-Classification-Evaluation', '组件参数 | 机器学习 | 多分类模型评估', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-9004', 'CP@Clustering-Evaluation', '组件参数 | 机器学习 | 聚类模型评估', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-9005', 'CP@Regression-Evaluation', '组件参数 | 机器学习 | 回归模型评估', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-9006', 'CP@CollaborativeFiltering-Evaluation', '组件参数 | 机器学习 | 协同过滤模型评估（待定）', '5', '', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ST@COM-0001', 'CP@Sql-Script', '组件参数 | 脚本工具 | SQL脚本', '5', '', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ST@COM-0002', 'CP@Python-Script', '组件参数 | 脚本工具 | Python脚本（待定）', '5', '', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ST@COM-0003', 'CP@R-Script', '组件参数 | 脚本工具 | R脚本（待定）', '5', '', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-WS@COM-0001', 'CP@Input-DataFile', '组件参数 | 在线服务 | 数据文件输入（待定）', '5', '输入数据文件key', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-WS@COM-0002', 'CP@Output-DataFile', '组件参数 | 在线服务 | 数据文件输出（待定）', '5', '输出数据文件key', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-WS@COM-0003', 'CP@Output-ModelFile', '组件参数 | 在线服务 | 模型文件输出（待定）', '5', '输出模型文件key', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('EX@SPEC-0000', 'EX@#Execution', '调用执行 | #调用执行', '3', '', '-1', '2017-05-17 15:08:09', 'admin', '2017-05-17 15:08:09', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('EX@SPEC-0001', 'EX@Scala-Spark', '调用执行 | Scala Spark', '3', '', '0', '2017-05-17 15:08:09', 'admin', '2017-05-17 15:08:09', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('EX@SPEC-0002', 'EX@Python-Spark', '调用执行 | Python Spark（待定）', '3', '', '-1', '2017-05-17 15:08:09', 'admin', '2017-05-17 15:08:09', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('EX@SPEC-0003', 'EX@R-Spark', '调用执行 | R Spark（待定）', '3', '', '-1', '2017-05-17 15:08:09', 'admin', '2017-05-17 15:08:09', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0000', 'IN@#Input-Content', '输入内容 | #输入内容', '1', '', '-1', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0001', 'IN@One-DataTable-t1<M>', '输入内容 | 一个数据表t1<M>', '1', '', '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0002', 'IN@Two-DataTable-t1<M>,t2<C>', '输入内容 | 二个数据表t1<M>,t2<C>', '1', '', '0', '2017-05-17 14:26:05', 'admin', '2017-05-17 14:26:05', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0003', 'IN@Three-DataTable-t1<M>,t2<C>,t3<C>', '输入内容 | 三个数据表t1<M>,t2<C>,t3<C>', '1', '', '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0004', 'IN@Four-DataTable-t1<M>,t2<C>,t3<C>,t4<C>', '输入内容 | 四个数据表t1<M>,t2<C>,t3<C>,t4<C>', '1', '', '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0005', 'IN@Five-DataTable-t1<M>,t2<C>,t3<C>,t4<C>,t5<C>', '输入内容 | 五个数据表t1<M>,t2<C>,t3<C>,t4<C>,t5<C>', '1', '', '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0006', 'IN@Six-DataTable-t1<M>,t2<C>,t3<C>,t4<C>,t5<C>,t6<C>', '输入内容 | 六个数据表t1<M>,t2<C>,t3<C>,t4<C>,t5<C>,t6<C>', '1', '', '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0007', 'IN@Two-DataTable-t1<M>,t2<M>', '输入内容 | 二个数据表t1<M>,t2<M>', '1', '', '0', '2017-05-17 14:26:05', 'admin', '2017-05-17 14:26:05', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0008', 'IN@Three-DataTable-t1<M>,t2<M>,t3<C>', '输入内容 | 三个数据表t1<M>,t2<M>,t3<C>', '1', '', '0', '2017-05-17 14:26:05', 'admin', '2017-05-17 14:26:05', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0009', 'IN@Four-DataTable-t1<M>,t2<M>,t3<C>,t4<C>', '输入内容 | 四个数据表t1<M>,t2<M>,,t3<C>,t4<C>', '1', '', '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0010', 'IN@Five-DataTable-t1<M>,t2<M>,t3<C>,t4<C>,t5<C>', '输入内容 | 五个数据表t1<M>,t2<M>,t3<C>,t4<C>,t5<C>', '1', '', '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0011', 'IN@Six-DataTable-t1<M>,t2<M>,t3<C>,t4<C>,t5<C>,t6<C>', '输入内容 | 六个数据表t1<M>,t2<M>,t3<C>,t4<C>,t5<C>,t6<C>', '1', '', '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0012', 'IN@Three-DataTable-t1<M>,t2<M>,t3<M>', '输入内容 | 三个数据表t1<M>,t2<M>,t3<M>', '1', '', '0', '2017-05-17 14:26:05', 'admin', '2017-05-17 14:26:05', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0013', 'IN@Four-DataTable-t1<M>,t2<M>,t3<M>,t4<C>', '输入内容 | 四个数据表t1<M>,t2<M>,,t3<M>,t4<C>', '1', '', '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0014', 'IN@Five-DataTable-t1<M>,t2<M>,t3<M>,t4<C>,t5<C>', '输入内容 | 五个数据表t1<M>,t2<M>,t3<M>,t4<C>,t5<C>', '1', '', '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0015', 'IN@Six-DataTable-t1<M>,t2<M>,t3<M>,t4<C>,t5<C>,t6<C>', '输入内容 | 六个数据表t1<M>,t2<M>,t3<M>,t4<C>,t5<C>,t6<C>', '1', '', '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0016', 'IN@Four-DataTable-t1<M>,t2<M>,t3<M>,t4<M>', '输入内容 | 四个数据表t1<M>,t2<M>,,t3<M>,t4<M>', '1', '', '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0017', 'IN@Five-DataTable-t1<M>,t2<M>,t3<M>,t4<M>,t5<C>', '输入内容 | 五个数据表t1<M>,t2<M>,t3<M>,t4<M>,t5<C>', '1', '', '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0018', 'IN@Six-DataTable-t1<M>,t2<M>,t3<M>,t4<M>,t5<C>,t6<C>', '输入内容 | 六个数据表t1<M>,t2<M>,t3<M>,t4<M>,t5<C>,t6<C>', '1', '', '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0019', 'IN@Five-DataTable-t1<M>,t2<M>,t3<M>,t4<M>,t5<M>', '输入内容 | 五个数据表t1<M>,t2<M>,t3<M>,t4<M>,t5<M>', '1', '', '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0020', 'IN@Six-DataTable-t1<M>,t2<M>,t3<M>,t4<M>,t5<M>,t6<C>', '输入内容 | 六个数据表t1<M>,t2<M>,t3<M>,t4<M>,t5<M>,t6<C>', '1', '', '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0021', 'IN@Six-DataTable-t1<M>,t2<M>,t3<M>,t4<M>,t5<M>,t6<M>', '输入内容 | 六个数据表t1<M>,t2<M>,t3<M>,t4<M>,t5<M>,t6<M>', '1', '', '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0022', 'IN@One-Algorithm<OneClass-Classification>-a1<M> + One-DataTable-t1<M>', '输入内容 | 一个单分类算法参数a1<M> + 一个数据表t1<M>', '1', '', '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0023', 'IN@One-Algorithm<Classification,Regression>-a1<M> + One-DataTable-t1<M>', '输入内容 | 一个通配分类和回归算法参数a1<M> + 一个数据表t1<M>', '1', '', '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0024', 'IN@One-Algorithm<Classification,Regression>-a1<M> + Two-DataTable-t1<M>,t2<C>', '输入内容 | 一个通配分类和回归算法参数a1<M> + 两个数据表t1<M>,t2<C>', '1', '', '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0025', 'IN@One-Algorithm<Clustering>-a1<M> + One-DataTable-t1<M>,t2<C>', '输入内容 | 一个聚类算法参数a1<M> + + 两个数据表t1<M>,t2<C>', '1', '', '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0026', 'IN@One-Model<Classification,Regression>-m1<M> + One-DataTable-t1<M>', '输入内容 | 一个通配分类和回归模型m1<M> + 一个数据表t1<M>', '1', '', '0', '2017-05-17 14:44:42', 'admin', '2017-05-17 14:44:42', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0027', 'IN@One-Model<Clustering>-m1<M> + One-DataTable-t1<M>', '输入内容 | 一个聚类模型m1<M> + 一个数据表t1<M>', '1', '', '0', '2017-05-17 14:33:20', 'admin', '2017-05-17 14:33:20', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0028', 'IN@One-Model<CollaborativeFiltering>-m1<M> + Four-DataTable-t1<M>,t2<M>,t3<M>,t4<M>', '输入内容 | 一个协同过滤模型m1<M> +  四个数据表t1<M>,t2<M>,,t3<M>,t4<M>', '1', '协同过滤预测', '0', '2017-05-17 14:44:42', 'admin', '2017-05-17 14:44:42', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OEX@SPEC-0000', 'OEX@#OptimizeExecution', '执行调优 | #执行调优', '4', '', '0', '2017-05-17 15:10:21', 'admin', '2017-05-17 15:10:21', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OEX@SPEC-0001', 'OEX@Spark-Optimization-Configuration', '执行调优 | Spark优化配置', '4', '', '0', '2017-05-17 15:10:21', 'admin', '2017-05-17 15:10:21', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0000', 'OUT@#Output-Content', '输出内容 | #输出内容', '2', '', '-1', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0001', 'OUT@One-DataTable-t1<M>', '输出内容 | 一个数据表t1<M>', '2', '', '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0002', 'OUT@Two-DataTable-t1<M>,t2<M>', '输出内容 | 二个数据表t1<M>,t2<M>', '2', '', '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0003', 'OUT@Three-DataTable-t1<M>,t2<M>,t3<M>', '输出内容 | 三个数据表t1<M>,t2<M>,t3<M>', '2', '', '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0004', 'OUT@Four-DataTable-t1<M>,t2<M>,t3<M>,t4<M>', '输出内容 | 四个数据表t1<M>,t2<M>,t3<M>,t4<M>', '2', '', '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0005', 'OUT@Five-DataTable-t1<M>,t2<M>,t3<M>,t4<M>,t5<M>', '输出内容 | 五个数据表t1<M>,t2<M>,t3<M>,t4<M>,t5<M>', '2', '', '0', '2017-05-17 14:58:17', 'admin', '2017-05-17 14:58:17', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0006', 'OUT@Six-DataTable-t1<M>,t2<M>,t3<M>,t4<M>,t5<M>,t6<M>', '输出内容 | 六个数据表t1<M>,t2<M>,t3<M>,t4<M>,t5<M>,t6<M>', '2', '', '0', '2017-05-17 14:58:17', 'admin', '2017-05-17 14:58:17', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0007', 'OUT@Two-DataTable-t1<M>,t2<C>', '输出内容 | 二个数据表t1<M>,t2<C>', '2', '', '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0008', 'OUT@One-Algorithm<OneClass-Classification>-a1<M>', '输出内容 | 一个单分类算法参数a1<M>', '2', '', '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0009', 'OUT@One-Algorithm<TwoClass-Classification>-a1<M>', '输出内容 | 一个二分类算法参数a1<M>', '2', '', '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0010', 'OUT@One-Algorithm<MultipleClass-Classification>-a1<M>', '输出内容 | 一个多分类算法参数a1<M>', '2', '', '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0011', 'OUT@One-Algorithm<Clustering>-a1<M>', '输出内容 | 一个聚类算法参数a1<M>', '2', '', '0', '2017-05-17 14:33:20', 'admin', '2017-05-17 14:33:20', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0012', 'OUT@One-Algorithm<Regression>-a1<M>', '输出内容 | 一个回归算法参数m1<M>', '2', '', '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0013', 'OUT@One-Model<OneClass-Classification>-m1<M>', '输出内容 | 一个单分类模型m1<M>', '2', '', '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0014', 'OUT@One-Model<TwoClass-Classification>-m1<M>', '输出内容 | 一个二分类模型m1<M>', '2', '', '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0015', 'OUT@One-Model<MultipleClass-Classification>-m1<M>', '输出内容 | 一个多分类模型m1<M>', '2', '', '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0016', 'OUT@One-Model<Clustering>-m1<M>', '输出内容 | 一个聚类模型m1<M>', '2', '', '0', '2017-05-17 14:33:20', 'admin', '2017-05-17 14:33:20', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0017', 'OUT@One-Model<Regression>-m1<M>', '输出内容 | 一个回归模型m1<M>', '2', '', '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0018', 'OUT@One-Model<CollaborativeFiltering>-m1<M>', '输出内容 | 一个协同过滤模型m1<M>', '2', '协同过滤训练', '0', '2017-05-17 14:44:42', 'admin', '2017-05-17 14:44:42', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0019', 'OUT@One-Model<Classification>-m1<M>', '输出内容 | 一个通配分类模型m1<M>', '2', '', '0', '2017-05-17 14:44:42', 'admin', '2017-05-17 14:44:42', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0020', 'OUT@One-Model<Classification,Regression>-m1<M>', '输出内容 | 一个通配分类和回归模型m1<M>', '2', '', '0', '2017-05-17 14:44:42', 'admin', '2017-05-17 14:44:42', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0021', 'OUT@One-Model<Classification,Regression>-m1<M> + One-DataTable-t1<M> +One-Report<TuneParameters>-<r1>', '输出内容 | 一个通配分类和回归模型m1<M> + 一个数据表t1<M> + 调参报告<r1>', '2', '自动调参（最优模型 + 算法参数表 + 调参报告）', '0', '2017-05-17 14:44:42', 'admin', '2017-05-17 14:44:42', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0022', 'OUT@One-Model<Clustering>-m1<M> + One-DataTable-t1<M>', '输出内容 | 一个聚类模型m1<M> + 一个数据表t1<M>', '2', '聚类训练', '0', '2017-05-17 14:33:20', 'admin', '2017-05-17 14:33:20', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0023', 'OUT@One-Model<Clustering>-m1<M> + Two-DataTable-t1<M>,t2<M> + One-Report<TuneParameters>-<r1>', '输出内容 | 一个聚类模型m1<M> + 二个数据表t1<M>,t2<M> + 调参报告<r1>', '2', '聚类自动调参（最优模型 + 算法参数表 + 结果集 + 调参报告）', '0', '2017-05-17 14:33:20', 'admin', '2017-05-17 14:33:20', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0024', 'OUT@One-Report<Model Evaluation>-r1<M> + One-DataTable-t1<M>', '输出内容 | 一个模型评估报告 + 一个数据表t1<M>', '2', '单分类?、多分类、聚类、回归、混淆矩阵、协同过滤等模型评估', '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0025', 'OUT@One-Report<Model Evaluation>-r1<M> + Three-DataTable-t1<M>,t2<M>,t3<M>', '输出内容 | 一个模型评估报告 + 三个数据表t1<M>,t2<M>,t3<M>', '2', '二分类模型评估', '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0026', 'OUT@One-Report<StatisticsAnalysis>-r1<M> + One-DataTable-t1<M>', '输出内容 | 一个统计分析报告 + 一个数据表t1<M>', '2', '', '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0027', 'OUT@One-Report<CrossValidation>-r1<M> + Two-DataTable-t1<M>,t2<M>', '输出内容 | 一个交叉验证报告 + 二个数据表t1<M>,t2<M>', '2', '', '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0028', 'OUT@One-Report<GenerateRules>-r1<M> + One-DataTable-t1<M>', '输出内容 | 一个生成规则报告 + 一个数据表t1<M>', '2', '', '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');

-- ----------------------------
-- Table structure for cf_cmpt_spec_char_rel
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_spec_char_rel`;
CREATE TABLE `cf_cmpt_spec_char_rel` (
  `SPEC_ID` varchar(64) NOT NULL COMMENT '规格ID',
  `CHAR_ID` varchar(64) NOT NULL COMMENT '特征ID',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SPEC_ID`,`CHAR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件规格使用特征表，要求同一规格下特征代码和特征别名唯一';

-- ----------------------------
-- Records of cf_cmpt_spec_char_rel
-- ----------------------------
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-0001', 'CCP@C-IO@COM-0013', '组件参数 | 输入输出 | 数据表读取，数据表名', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-0002', 'CCP@C-IO@COM-0014', '组件参数 | 输入输出 | 单分类模型读取，模型ID', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-0003', 'CCP@C-IO@COM-0014', '组件参数 | 输入输出 | 二分类模型读取，模型ID', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-0004', 'CCP@C-IO@COM-0014', '组件参数 | 输入输出 | 多分类模型读取，模型ID', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-0005', 'CCP@C-IO@COM-0014', '组件参数 | 输入输出 | 聚类模型读取，模型ID', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-0006', 'CCP@C-IO@COM-0014', '组件参数 | 输入输出 | 回归模型读取，模型ID', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-0007', 'CCP@C-IO@COM-0014', '组件参数 | 输入输出 | 协同过滤模型读取，模型ID', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-0008', 'CCP@C-IO@COM-0013', '组件参数 | 输入输出 | 数据表写入，数据表名', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-9999', 'CCP@C-IO@COM-0013', '组件参数 | 输入输出 | 数据文件导入，数据表名', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-9999', 'SCP@C-IO@COM-9999-01', '组件参数 | 输入输出 | 数据文件导入，文件类型', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-9999', 'SCP@C-IO@COM-9999-02', '组件参数 | 输入输出 | 数据文件导入，文件路径', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-9999', 'SCP@C-IO@COM-9999-03', '组件参数 | 输入输出 | 数据文件导入，列分隔符', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-9999', 'SCP@C-IO@COM-9999-04', '组件参数 | 输入输出 | 数据文件导入，行分隔符', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-9999', 'SCP@C-IO@COM-9999-05', '组件参数 | 输入输出 | 数据文件导入，字符编码', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-9999', 'SCP@C-IO@COM-9999-06', '组件参数 | 输入输出 | 数据文件导入，首行是否为字段标题', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-9999', 'SCP@C-IO@COM-9999-07', '组件参数 | 输入输出 | 数据文件导入，字段描述列表', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-9999', 'SCP@C-IO@COM-9999-08', '组件参数 | 输入输出 | 数据文件导入，日期格式', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-9999', 'SCP@C-IO@COM-9999-09', '组件参数 | 输入输出 | 数据文件导入，时间格式', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-9999', 'SCP@C-IO@COM-9999-10', '组件参数 | 输入输出 | 数据文件导入，字段类型异常处理', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-IO@COM-9999', 'SCP@C-IO@COM-9999-11', '组件参数 | 输入输出 | 数据文件导入，列数异常处理', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('EX@SPEC-0001', 'EX@C-0001', '调用执行 | Scala Spark，计算引擎', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('EX@SPEC-0001', 'EX@C-0002', '调用执行 | Scala Spark，spark组件jar库目录', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('EX@SPEC-0001', 'EX@C-0003', '调用执行 | Scala Spark，spark组件jar包文件名', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('EX@SPEC-0001', 'EX@C-0004', '调用执行 | Scala Spark，spark组件class路径', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0001', 'IN@C-0001', '输入内容 | 一个数据表t1<M>，输入数据表t1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0004', 'IN@C-0001', '输入内容 | 四个数据表t1<M>,t2<C>,t3<C>,t4<C>，输入数据表t1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0004', 'IN@C-0003', '输入内容 | 四个数据表t1<M>,t2<C>,t3<C>,t4<C>，输入数据表t2', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0004', 'IN@C-0005', '输入内容 | 四个数据表t1<M>,t2<C>,t3<C>,t4<C>，输入数据表t3', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0004', 'IN@C-0007', '输入内容 | 四个数据表t1<M>,t2<C>,t3<C>,t4<C>，输入数据表t4', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0023', 'IN@C-0001', '输入内容 | 一个通配分类和回归算法参数a1<M> + 一个数据表t1<M>，输入数据表t1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0023', 'IN@C-0018', '输入内容 | 一个通配分类和回归算法参数a1<M> + 一个数据表t1<M>，输入算法a1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0024', 'IN@C-0001', '输入内容 | 一个通配分类和回归算法参数a1<M> + 两个数据表t1<M>,t2<C>，输入数据表t1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0024', 'IN@C-0003', '输入内容 | 一个通配分类和回归算法参数a1<M> + 两个数据表t1<M>,t2<C>，输入数据表t2', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0024', 'IN@C-0018', '输入内容 | 一个通配分类和回归算法参数a1<M> + 两个数据表t1<M>,t2<C>，输入算法a1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0025', 'IN@C-0001', '输入内容 | 一个聚类算法参数a1<M> + + 两个数据表t1<M>,t2<C>，输入数据表t1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0025', 'IN@C-0003', '输入内容 | 一个聚类算法参数a1<M> + + 两个数据表t1<M>,t2<C>，输入数据表t2', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0025', 'IN@C-0016', '输入内容 | 一个聚类算法参数a1<M> + + 两个数据表t1<M>,t2<C>，输入算法a1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0026', 'IN@C-0001', '输入内容 | 一个通配分类和回归模型m1<M> + 一个数据表t1<M>，输入数据表t1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0026', 'IN@C-0025', '输入内容 | 一个通配分类和回归模型m1<M> + 一个数据表t1<M>，输入模型m1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0027', 'IN@C-0001', '输入内容 | 一个聚类模型m1<M> + 一个数据表t1<M>，输入数据表t1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0027', 'IN@C-0023', '输入内容 | 一个聚类模型m1<M> + 一个数据表t1<M>，输入模型m1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OEX@SPEC-0001', 'OEX@C-0001', '执行调优 | Spark优化配置，spark.executor.number', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OEX@SPEC-0001', 'OEX@C-0002', '执行调优 | Spark优化配置，spark.executor.cores', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OEX@SPEC-0001', 'OEX@C-0003', '执行调优 | Spark优化配置，spark.executor.memory', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OEX@SPEC-0001', 'OEX@C-0004', '执行调优 | Spark优化配置，spark.driver.cores', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OEX@SPEC-0001', 'OEX@C-0005', '执行调优 | Spark优化配置，spark.driver.memory', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OEX@SPEC-0001', 'OEX@C-0006', '执行调优 | Spark优化配置，spark.extra.configuration', '-1', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0001', 'OUT@C-0001', '输出内容 | 一个数据表t1<M>，输出数据表t1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0009', 'OUT@C-0013', '输出内容 | 一个二分类算法参数a1<M>，输出算法a1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0010', 'OUT@C-0014', '输出内容 | 一个多分类算法参数a1<M>，输出算法a1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0011', 'OUT@C-0015', '输出内容 | 一个聚类算法参数a1<M>，输出算法a1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0012', 'OUT@C-0016', '输出内容 | 一个回归算法参数a1<M>，输出算法a1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0013', 'OUT@C-0019', '输出内容 | 一个单分类模型m1<M>，输出模型m1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0014', 'OUT@C-0020', '输出内容 | 一个二分类模型m1<M>，输出模型m1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0015', 'OUT@C-0021', '输出内容 | 一个多分类模型m1<M>，输出模型m1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0016', 'OUT@C-0022', '输出内容 | 一个聚类模型m1<M>，输出模型m1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0017', 'OUT@C-0023', '输出内容 | 一个回归模型m1<M>，输出模型m1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0018', 'OUT@C-0024', '输出内容 | 一个协同过滤模型m1<M>，输出模型m1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0020', 'OUT@C-0026', '输出内容 | 一个通配分类和回归模型m1<M>，输出模型m1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0021', 'OUT@C-0001', '输出内容 | 一个通配分类和回归模型m1<M> + 一个数据表t1<M> + 调参报告<r1>，输出数据表t1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0021', 'OUT@C-0026', '输出内容 | 一个通配分类和回归模型m1<M> + 一个数据表t1<M> + 调参报告<r1>，输出模型m1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0021', 'OUT@C-0030', '输出内容 | 一个通配分类和回归模型m1<M> + 一个数据表t1<M> + 调参报告<r1>，输出报告r1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0022', 'OUT@C-0001', '输出内容 | 一个聚类模型m1<M> + 一个数据表t1<M>，输出数据表t1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0022', 'OUT@C-0022', '输出内容 | 一个聚类模型m1<M> + 一个数据表t1<M>，输出模型m1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0023', 'OUT@C-0001', '输出内容 | 一个聚类模型m1<M> + 二个数据表t1<M>,t2<M> + 调参报告<r1>，输出数据表t1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0023', 'OUT@C-0002', '输出内容 | 一个聚类模型m1<M> + 二个数据表t1<M>,t2<M> + 调参报告<r1>，输出数据表t2', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0023', 'OUT@C-0026', '输出内容 | 一个聚类模型m1<M> + 二个数据表t1<M>,t2<M> + 调参报告<r1>，输出模型m1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0023', 'OUT@C-0030', '输出内容 | 一个聚类模型m1<M> + 二个数据表t1<M>,t2<M> + 调参报告<r1>，输出报告r1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0024', 'OUT@C-0001', '输出内容 | 一个模型评估报告 + 一个数据表t1<M>，输出数据表t1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0024', 'OUT@C-0027', '输出内容 | 一个模型评估报告 + 一个数据表t1<M>，输出报告r1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0025', 'OUT@C-0001', '输出内容 | 一个模型评估报告 + 三个数据表t1<M>,t2<M>,t3<M>，输出数据表t1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0025', 'OUT@C-0002', '输出内容 | 一个模型评估报告 + 三个数据表t1<M>,t2<M>,t3<M>，输出数据表t2', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0025', 'OUT@C-0004', '输出内容 | 一个模型评估报告 + 三个数据表t1<M>,t2<M>,t3<M>，输出数据表t3', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0025', 'OUT@C-0027', '输出内容 | 一个模型评估报告 + 三个数据表t1<M>,t2<M>,t3<M>，输出报告r1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0027', 'OUT@C-0001', '输出内容 | 一个交叉验证报告 + 二个数据表t1<M>,t2<M>，输出数据表t1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0027', 'OUT@C-0002', '输出内容 | 一个交叉验证报告 + 二个数据表t1<M>,t2<M>，输出数据表t2', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('OUT@SPEC-0027', 'OUT@C-0029', '输出内容 | 一个交叉验证报告 + 二个数据表t1<M>,t2<M>，输出报告r1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');

-- ----------------------------
-- Table structure for cf_cmpt_spec_char_value
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_spec_char_value`;
CREATE TABLE `cf_cmpt_spec_char_value` (
  `SPEC_ID` varchar(64) NOT NULL COMMENT '规格ID',
  `CHAR_ID` varchar(64) NOT NULL COMMENT '特征ID',
  `IS_SYSTEM_PARAM` int(11) NOT NULL COMMENT '特征值是否为系统参数\r\n            0：否\r\n            1：是',
  `CHAR_VALUE` varchar(2000) DEFAULT NULL COMMENT '特征值',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SPEC_ID`,`CHAR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件规格配置特征值表，预置在组件规格上的组件特征值设定';

-- ----------------------------
-- Records of cf_cmpt_spec_char_value
-- ----------------------------

-- ----------------------------
-- Table structure for cf_cmpt_spec_rel
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_spec_rel`;
CREATE TABLE `cf_cmpt_spec_rel` (
  `CMPT_ID` varchar(64) NOT NULL COMMENT '组件ID',
  `SPEC_ID` varchar(64) NOT NULL COMMENT '规格ID',
  `SPEC_TYPE` int(11) NOT NULL COMMENT '组件规格类型，说明参考CF_CMPT_SPEC.SPEC_TYPE',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CMPT_ID`,`SPEC_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件使用规格表';

-- ----------------------------
-- Records of cf_cmpt_spec_rel
-- ----------------------------
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-0001', 'OUT@SPEC-0001', '2', '输入输出 | 数据表读取，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-0001', 'CP@SPEC-IO@COM-0001', '5', '输入输出 | 数据表读取，组件参数', '0', '2018-11-21 21:30:46', 'admin', '2018-11-21 21:30:46', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-0002', 'OUT@SPEC-0013', '2', '输入输出 | 单分类模型读取，输出内容', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-0002', 'CP@SPEC-IO@COM-0002', '5', '输入输出 | 单分类模型读取，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-0003', 'OUT@SPEC-0014', '2', '输入输出 | 二分类模型读取，输出内容', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-0003', 'CP@SPEC-IO@COM-0003', '5', '输入输出 | 二分类模型读取，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-0004', 'OUT@SPEC-0015', '2', '输入输出 | 多分类模型读取，输出内容', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-0004', 'CP@SPEC-IO@COM-0004', '5', '输入输出 | 多分类模型读取，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-0005', 'OUT@SPEC-0016', '2', '输入输出 | 聚类模型读取，输出内容', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-0005', 'CP@SPEC-IO@COM-0005', '5', '输入输出 | 聚类模型读取，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-0006', 'OUT@SPEC-0017', '2', '输入输出 | 回归模型读取，输出内容', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-0006', 'CP@SPEC-IO@COM-0006', '5', '输入输出 | 回归模型读取，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-0007', 'OUT@SPEC-0018', '2', '输入输出 | 协同过滤模型读取，输出内容', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-0007', 'CP@SPEC-IO@COM-0007', '5', '输入输出 | 协同过滤模型读取，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-0008', 'IN@SPEC-0001', '1', '输入输出 | 数据表写入，输入内容', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-0008', 'CP@SPEC-IO@COM-0008', '5', '输入输出 | 数据表写入，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-9999', 'OUT@SPEC-0001', '2', '输入输出 | 数据文件导入，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('IO@COM-9999', 'CP@SPEC-IO@COM-9999', '5', '输入输出 | 数据文件导入，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0001', 'OUT@SPEC-0009', '2', '机器学习 | 逻辑回归二分类算法，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0001', 'CP@SPEC-ML@COM-0001', '5', '机器学习 | 逻辑回归二分类算法，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0002', 'OUT@SPEC-0010', '2', '机器学习 | 逻辑回归多分类算法，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0002', 'CP@SPEC-ML@COM-0002', '5', '机器学习 | 逻辑回归多分类算法，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0003', 'OUT@SPEC-0009', '2', '机器学习 | 随机森林二分类算法，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0003', 'CP@SPEC-ML@COM-0003', '5', '机器学习 | 随机森林二分类算法，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0004', 'OUT@SPEC-0010', '2', '机器学习 | 随机森林多分类算法，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0004', 'CP@SPEC-ML@COM-0004', '5', '机器学习 | 随机森林多分类算法，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0005', 'OUT@SPEC-0009', '2', '机器学习 | GBDT二分类算法，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0005', 'CP@SPEC-ML@COM-0005', '5', '机器学习 | GBDT二分类算法，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0008', 'OUT@SPEC-0009', '2', '机器学习 | 线性SVM二分类算法，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0008', 'CP@SPEC-ML@COM-0008', '5', '机器学习 | 线性SVM二分类算法，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0009', 'OUT@SPEC-0010', '2', '机器学习 | 朴素贝叶斯多分类算法，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0009', 'CP@SPEC-ML@COM-0009', '5', '机器学习 | 朴素贝叶斯多分类算法，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0010', 'OUT@SPEC-0010', '2', '机器学习 | K近邻多分类算法，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0010', 'CP@SPEC-ML@COM-0010', '5', '机器学习 | K近邻多分类算法，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0011', 'OUT@SPEC-0011', '2', '机器学习 | K均值聚类算法，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0011', 'CP@SPEC-ML@COM-0011', '5', '机器学习 | K均值聚类算法，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0012', 'OUT@SPEC-0012', '2', '机器学习 | 线性回归算法，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0012', 'CP@SPEC-ML@COM-0012', '5', '机器学习 | 线性回归算法，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0013', 'OUT@SPEC-0012', '2', '机器学习 | GBDT回归算法，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-0013', 'CP@SPEC-ML@COM-0013', '5', '机器学习 | GBDT回归算法，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3001', 'IN@SPEC-0023', '1', '机器学习 | 模型训练，输入内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3001', 'OUT@SPEC-0020', '2', '机器学习 | 模型训练，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3001', 'EX@SPEC-0001', '3', '机器学习 | 模型训练，调用执行', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3001', 'OEX@SPEC-0001', '4', '机器学习 | 模型训练，执行调优', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3001', 'CP@SPEC-ML@COM-3001', '5', '机器学习 | 模型训练，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3002', 'IN@SPEC-0024', '1', '机器学习 | 模型自动调参，输入内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3002', 'OUT@SPEC-0021', '2', '机器学习 | 模型自动调参，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3002', 'EX@SPEC-0001', '3', '机器学习 | 模型自动调参，调用执行', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3002', 'OEX@SPEC-0001', '4', '机器学习 | 模型自动调参，执行调优', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3002', 'CP@SPEC-ML@COM-3002', '5', '机器学习 | 模型自动调参，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3003', 'IN@SPEC-0023', '1', '机器学习 | 交叉验证，输入内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3003', 'OUT@SPEC-0027', '2', '机器学习 | 交叉验证，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3003', 'EX@SPEC-0001', '3', '机器学习 | 交叉验证，调用执行', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3003', 'OEX@SPEC-0001', '4', '机器学习 | 交叉验证，执行调优', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3003', 'CP@SPEC-ML@COM-3003', '5', '机器学习 | 交叉验证，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3004', 'IN@SPEC-0025', '1', '机器学习 | 聚类模型训练，输入内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3004', 'OUT@SPEC-0022', '2', '机器学习 | 聚类模型训练，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3004', 'EX@SPEC-0001', '3', '机器学习 | 聚类模型训练，调用执行', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3004', 'OEX@SPEC-0001', '4', '机器学习 | 聚类模型训练，执行调优', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3004', 'CP@SPEC-ML@COM-3004', '5', '机器学习 | 聚类模型训练，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3005', 'IN@SPEC-0025', '1', '机器学习 | 聚类模型自动调参，输入内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3005', 'OUT@SPEC-0023', '2', '机器学习 | 聚类模型自动调参，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3005', 'EX@SPEC-0001', '3', '机器学习 | 聚类模型自动调参，调用执行', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3005', 'OEX@SPEC-0001', '4', '机器学习 | 聚类模型自动调参，执行调优', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-3005', 'CP@SPEC-ML@COM-3005', '5', '机器学习 | 聚类模型自动调参，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-8001', 'IN@SPEC-0026', '1', '机器学习 | 预测，输入内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-8001', 'OUT@SPEC-0001', '2', '机器学习 | 预测，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-8001', 'EX@SPEC-0001', '3', '机器学习 | 预测，调用执行', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-8001', 'OEX@SPEC-0001', '4', '机器学习 | 预测，执行调优', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-8001', 'CP@SPEC-ML@COM-8001', '5', '机器学习 | 预测，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-8002', 'IN@SPEC-0027', '1', '机器学习 | 聚类预测，输入内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-8002', 'OUT@SPEC-0001', '2', '机器学习 | 聚类预测，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-8002', 'EX@SPEC-0001', '3', '机器学习 | 聚类预测，调用执行', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-8002', 'OEX@SPEC-0001', '4', '机器学习 | 聚类预测，执行调优', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-8002', 'CP@SPEC-ML@COM-8002', '5', '机器学习 | 聚类预测，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9002', 'IN@SPEC-0001', '1', '机器学习 | 二分类模型评估，输入内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9002', 'OUT@SPEC-0025', '2', '机器学习 | 二分类模型评估，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9002', 'EX@SPEC-0001', '3', '机器学习 | 二分类模型评估，调用执行', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9002', 'OEX@SPEC-0001', '4', '机器学习 | 二分类模型评估，执行调优', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9002', 'CP@SPEC-ML@COM-9002', '5', '机器学习 | 二分类模型评估，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9003', 'IN@SPEC-0001', '1', '机器学习 | 多分类模型评估，输入内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9003', 'OUT@SPEC-0024', '2', '机器学习 | 多分类模型评估，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9003', 'EX@SPEC-0001', '3', '机器学习 | 多分类模型评估，调用执行', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9003', 'OEX@SPEC-0001', '4', '机器学习 | 多分类模型评估，执行调优', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9003', 'CP@SPEC-ML@COM-9003', '5', '机器学习 | 多分类模型评估，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9004', 'IN@SPEC-0001', '1', '机器学习 | 聚类模型评估，输入内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9004', 'OUT@SPEC-0024', '2', '机器学习 | 聚类模型评估，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9004', 'EX@SPEC-0001', '3', '机器学习 | 聚类模型评估，调用执行', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9004', 'OEX@SPEC-0001', '4', '机器学习 | 聚类模型评估，执行调优', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9004', 'CP@SPEC-ML@COM-9004', '5', '机器学习 | 聚类模型评估，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9005', 'IN@SPEC-0001', '1', '机器学习 | 回归模型评估，输入内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9005', 'OUT@SPEC-0024', '2', '机器学习 | 回归模型评估，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9005', 'EX@SPEC-0001', '3', '机器学习 | 回归模型评估，调用执行', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9005', 'OEX@SPEC-0001', '4', '机器学习 | 回归模型评估，执行调优', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ML@COM-9005', 'CP@SPEC-ML@COM-9005', '5', '机器学习 | 回归模型评估，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ST@COM-0001', 'IN@SPEC-0004', '1', '机器学习 | 回归模型评估，输入内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ST@COM-0001', 'OUT@SPEC-0001', '2', '机器学习 | 回归模型评估，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ST@COM-0001', 'EX@SPEC-0001', '3', '机器学习 | 回归模型评估，调用执行', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ST@COM-0001', 'OEX@SPEC-0001', '4', '机器学习 | 回归模型评估，执行调优', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ST@COM-0001', 'CP@SPEC-ST@COM-0001', '5', '机器学习 | 回归模型评估，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');

-- ----------------------------
-- Table structure for cf_component
-- ----------------------------
DROP TABLE IF EXISTS `cf_component`;
CREATE TABLE `cf_component` (
  `CMPT_ID` varchar(64) NOT NULL COMMENT '组件ID，长度限制20\r\n            \r\n            输入输出组件ID范围：IO@COM-[0000 ~ 9999]\r\n            脚本工具组件ID范围：ST@COM-[0000 ~ 9999]\r\n            数据预处理组件ID范围：DP@COM-[0000 ~ 9999]\r\n            特征工程组件ID范围：FE@COM-[0000 ~ 9999]\r\n            统计分析组件ID范围：SA@COM-[0000 ~ 9999]\r\n            机器学习组件ID范围：ML@COM-[0000 ~ 9999]\r\n            深度学习组件ID范围：DL@COM-[0000 ~ 9999]\r\n            文本分析组件ID范围：TA@COM-[0000 ~ 9999]\r\n            网络分析组件ID范围：NA@COM-[0000 ~ 9999]\r\n            时间序列组件ID范围：TS@COM-[0000 ~ 9999]\r\n            在线服务组件ID范围：OS@COM-[0000 ~ 9999]\r\n            业务场景组件ID范围：BS@COM-[0000 ~ 9999]\r\n            深度学习组件ID范围：DL@COM-[0000 ~ 9999]\r\n            文本分析组件ID范围：TA@COM-[0000 ~ 9999]\r\n            网络分析组件ID范围：NA@COM-[0000 ~ 9999]\r\n            ',
  `CMPT_CODE` varchar(200) NOT NULL COMMENT '组件代码',
  `CMPT_NAME` varchar(200) NOT NULL COMMENT '组件名称',
  `CMPT_TYPE` int(11) NOT NULL COMMENT '组件种类\r\n            0：输入输出组件\r\n            1：脚本工具组件\r\n            2：数据预处理组件\r\n            3：特征工程组件\r\n            4：统计分析组件\r\n            5：机器学习组件\r\n            6：深度学习组件\r\n            7：文本分析组件\r\n            8：网络分析组件\r\n            9：时间序列组件\r\n            10：在线服务组件\r\n            11：业务场景组件',
  `REL_ALGORITHM_ID` bigint(20) NOT NULL COMMENT '关联算法ID，非算法组件设为-1',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CMPT_ID`),
  UNIQUE KEY `Index_1` (`CMPT_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件表';

-- ----------------------------
-- Records of cf_component
-- ----------------------------
INSERT INTO `cf_component` VALUES ('BS@COM-0000', 'BS@#BusinessScenario', '业务场景 | #业务场景', '11', '-1', '', '-1', '2017-05-27 17:47:09', 'admin', '2017-05-27 17:47:09', 'admin');
INSERT INTO `cf_component` VALUES ('DL@COM-0000', 'DL@#DeepLearning', '深度学习 | #深度学习', '6', '-1', '', '-1', '2017-05-27 17:46:41', 'admin', '2017-05-27 17:46:41', 'admin');
INSERT INTO `cf_component` VALUES ('DP@COM-0000', 'DP@#DataPreprocessing', '数据预处理 | #数据预处理', '2', '-1', '', '-1', '2017-05-27 16:28:04', 'admin', '2017-05-27 16:28:04', 'admin');
INSERT INTO `cf_component` VALUES ('FE@COM-0000', 'FE@#FeatureEngineering', '特征工程 | #特征工程', '3', '-1', '', '-1', '2017-05-27 16:28:50', 'admin', '2017-05-27 16:28:50', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0000', 'IO@#InputOutput', '输入输出 | #输入输出', '0', '-1', '', '-1', '2017-05-16 17:52:14', 'admin', '2017-05-16 17:52:14', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0001', 'IO@Read-DataTable', '输入输出 | 数据表读取', '0', '-1', '', '0', '2017-05-16 17:52:14', 'admin', '2017-05-16 17:52:14', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0002', 'IO@Read-OneClass-Classification-Model', '输入输出 | 单分类模型读取', '0', '-1', '', '0', '2017-05-16 17:55:43', 'admin', '2017-05-16 17:55:43', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0003', 'IO@Read-TwoClass-Classification-Model', '输入输出 | 二分类模型读取', '0', '-1', '', '0', '2017-05-16 17:55:43', 'admin', '2017-05-16 17:55:43', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0004', 'IO@Read-MultipleClass-Classification-Model', '输入输出 | 多分类模型读取', '0', '-1', '', '0', '2017-05-16 17:55:43', 'admin', '2017-05-16 17:55:43', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0005', 'IO@Read-Clustering-Model', '输入输出 | 聚类模型读取', '0', '-1', '', '0', '2017-05-16 17:55:43', 'admin', '2017-05-16 17:55:43', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0006', 'IO@Read-Regression-Model', '输入输出 | 回归模型读取', '0', '-1', '', '0', '2017-05-16 17:55:43', 'admin', '2017-05-16 17:55:43', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0007', 'IO@Read-CollaborativeFiltering-Model', '输入输出 | 协同过滤模型读取', '0', '-1', '', '0', '2017-05-16 17:55:43', 'admin', '2017-05-16 17:55:43', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0008', 'IO@Write-DataTable', '输入输出 | 数据表写入', '0', '-1', '更新到指定数据表名，表不存在自动创建', '0', '2017-05-16 17:52:14', 'admin', '2017-05-16 17:52:14', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-9999', 'IO@Import-DataFile', '输入输出 | 数据文件导入（非实验用组件）', '0', '-1', '用于HDFS数据文件和上传数据文件的导入', '0', '2017-05-16 17:52:14', 'admin', '2017-05-16 17:52:14', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0000', 'ML@#MachineLearning', '机器学习 | #机器学习', '5', '-1', '', '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0001', 'ML@LR-TwoClass-Classification', '机器学习 | 逻辑回归二分类算法', '5', '2001', '', '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0002', 'ML@LR-MultipleClass-Classification', '机器学习 | 逻辑回归多分类算法', '5', '3001', '', '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0003', 'ML@RF-TwoClass-Classification', '机器学习 | 随机森林二分类算法', '5', '2002', '', '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0004', 'ML@RF-MultipleClass-Classification', '机器学习 | 随机森林多分类算法', '5', '3002', '', '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0005', 'ML@GBDT-TwoClass-Classification', '机器学习 | GBDT二分类算法', '5', '2003', '', '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0006', 'ML@XGBoost-TwoClass-Classification', '机器学习 | XGBoost二分类算法（待定）', '5', '2005', '', '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0007', 'ML@XGBoost-MultipleClass-Classification', '机器学习 | XGBoost 多分类算法（待定）', '5', '3003', '', '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0008', 'ML@LinearSVM-TwoClass-Classification', '机器学习 | 线性SVM二分类算法', '5', '2004', '', '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0009', 'ML@NaiveBayesian-MultipleClass-Classification', '机器学习 | 朴素贝叶斯多分类算法', '5', '3004', '', '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0010', 'ML@KNN-MultipleClass-Classification', '机器学习 | K近邻多分类算法', '5', '3005', '', '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0011', 'ML@KMeans-Clustering', '机器学习 | K均值聚类算法', '5', '4001', '', '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0012', 'ML@Linear-Regression', '机器学习 | 线性回归算法', '5', '5001', '', '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0013', 'ML@GBDT-Regression', '机器学习 | GBDT回归算法', '5', '5002', '', '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0014', 'ML@XGBoost-Regression', '机器学习 | XGBoost回归（待定）', '5', '5003', '', '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0015', 'ML@OneClass-SVM', '机器学习 | 单分类SVM算法（待定）', '5', '1001', '', '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0016', 'ML@PCA-Based-AnomalyDetection', '机器学习 | 基于PCA异常检测算法（待定）', '5', '1002', '', '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-3001', 'ML@Train-Model', '机器学习 | 模型训练', '5', '-1', '支持回归和分类算法', '0', '2017-05-17 13:48:44', 'admin', '2017-05-17 13:48:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-3002', 'ML@Tune-Model-Hyperparameters', '机器学习 | 模型自动调参', '5', '-1', '支持回归和分类算法', '0', '2017-05-17 13:48:44', 'admin', '2017-05-17 13:48:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-3003', 'ML@Cross-Validation', '机器学习 | 交叉验证', '5', '-1', '支持回归和分类算法', '0', '2017-05-17 13:48:44', 'admin', '2017-05-17 13:48:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-3004', 'ML@Train-Clustering-Model', '机器学习 | 聚类模型训练', '5', '-1', '支持Kmeans', '0', '2017-05-17 13:48:44', 'admin', '2017-05-17 13:48:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-3005', 'ML@Tune-Clustering-Model-Hyperparameters', '机器学习 | 聚类模型自动调参', '5', '-1', '支持Kmeans', '0', '2017-05-17 13:48:44', 'admin', '2017-05-17 13:48:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-3006', 'ML@Train-AnomalyDetection-Model', '机器学习 | 异常检测模型训练（待定）', '5', '-1', '单分类训练集不带标签列', '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-3007', 'ML@Train-ALS-CollaborativeFiltering-Model', '机器学习 | ALS协同过滤模型训练（待定）', '5', '7001', '', '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-6001', 'ML@Auto-GenerationRules', '机器学习 | 自动生成规则（待定）', '5', '-1', '', '-1', '2017-05-17 12:34:44', 'admin', '2017-05-17 12:34:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-6002', 'ML@Apriori-AssociationRules', '机器学习 | Apriori关联规则（待定）', '5', '6001', '', '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-6003', 'ML@FPG-AssociationRules', '机器学习 | FP-Growth关联规则（待定）', '5', '6002', '', '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-8001', 'ML@Prediction', '机器学习 | 预测', '5', '-1', '支持回归和分类算法', '0', '2017-05-17 13:48:44', 'admin', '2017-05-17 13:48:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-8002', 'ML@Clustering-Prediction', '机器学习 | 聚类预测', '5', '-1', '', '0', '2017-05-17 13:48:44', 'admin', '2017-05-17 13:48:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-8003', 'ML@CollaborativeFiltering-Prediction', '机器学习 | 协同过滤预测（待定）', '5', '-1', '', '-1', '2017-05-17 13:48:44', 'admin', '2017-05-17 13:48:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-9001', 'ML@OneClass-Classification-Evaluation', '机器学习 | 单分类模型评估（异常检测）', '5', '-1', '', '-1', '2017-05-17 13:40:58', 'admin', '2017-05-17 13:40:58', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-9002', 'ML@TwoClass-Classification-Evaluation', '机器学习 | 二分类模型评估', '5', '-1', '', '0', '2017-05-17 13:40:58', 'admin', '2017-05-17 13:40:58', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-9003', 'ML@MultipleClass-Classification-Evaluation', '机器学习 | 多分类模型评估', '5', '-1', '', '0', '2017-05-17 13:41:51', 'admin', '2017-05-17 13:41:59', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-9004', 'ML@Clustering-Evaluation', '机器学习 | 聚类模型评估', '5', '-1', '', '0', '2017-05-17 13:42:37', 'admin', '2017-05-17 13:42:37', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-9005', 'ML@Regression-Evaluation', '机器学习 | 回归模型评估', '5', '-1', '', '0', '2017-05-17 13:43:11', 'admin', '2017-05-17 13:43:11', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-9006', 'ML@CollaborativeFiltering-Evaluation', '机器学习 | 协同过滤模型评估（待定）', '5', '-1', '', '-1', '2017-05-17 13:45:07', 'admin', '2017-05-17 13:45:07', 'admin');
INSERT INTO `cf_component` VALUES ('NA@COM-0000', 'NA@#NetworkAnalysis', '网络分析 | #网络分析', '8', '-1', '', '-1', '2017-05-27 17:47:34', 'admin', '2017-05-27 17:47:34', 'admin');
INSERT INTO `cf_component` VALUES ('SA@COM-0000', 'SA@#StatisticalAnalysis', '统计分析 | #统计分析', '4', '-1', '', '-1', '2017-05-27 16:29:34', 'admin', '2017-05-27 16:29:34', 'admin');
INSERT INTO `cf_component` VALUES ('ST@COM-0000', 'ST@#ScriptTools', '脚本工具 | #脚本工具', '1', '-1', '', '-1', '2017-05-16 17:57:49', 'admin', '2017-05-16 17:57:49', 'admin');
INSERT INTO `cf_component` VALUES ('ST@COM-0001', 'ST@Sql-Script', '脚本工具 | SQL脚本', '1', '-1', '', '0', '2017-05-16 17:57:49', 'admin', '2017-05-16 17:57:49', 'admin');
INSERT INTO `cf_component` VALUES ('ST@COM-0002', 'ST@Python-Script', '脚本工具 | Python脚本（待定）', '1', '-1', '', '-1', '2017-05-16 17:57:49', 'admin', '2017-05-16 17:57:49', 'admin');
INSERT INTO `cf_component` VALUES ('ST@COM-0003', 'ST@R-Script', '脚本工具 | R脚本（待定）', '1', '-1', '', '-1', '2017-05-16 17:57:49', 'admin', '2017-05-16 17:57:49', 'admin');
INSERT INTO `cf_component` VALUES ('TA@COM-0000', 'TA@#TextAnalysis', '文本分析 | #文本分析', '7', '-1', '', '-1', '2017-05-27 17:47:09', 'admin', '2017-05-27 17:47:09', 'admin');
INSERT INTO `cf_component` VALUES ('TS@COM-0000', 'TS@#TimeSeries', '时间序列 | #时间序列', '8', '-1', '', '-1', '2017-05-27 17:47:09', 'admin', '2017-05-27 17:47:09', 'admin');
INSERT INTO `cf_component` VALUES ('WS@COM-0000', 'WS@#WebService', 'Web服务 | #Web服务', '10', '-1', '', '-1', '2017-05-27 17:47:34', 'admin', '2017-05-27 17:47:34', 'admin');
INSERT INTO `cf_component` VALUES ('WS@COM-0001', 'WS@Input-DataFile', 'Web服务 | 数据文件输入（待定）', '10', '-1', '暂时仅支持Parquet格式数据文件', '-1', '2017-05-27 17:47:34', 'admin', '2017-05-27 17:47:34', 'admin');
INSERT INTO `cf_component` VALUES ('WS@COM-0002', 'WS@Output-DataFile', 'Web服务 | 数据文件输出（待定）', '10', '-1', '输出Parquet格式数据文件', '-1', '2017-05-27 17:47:34', 'admin', '2017-05-27 17:47:34', 'admin');
INSERT INTO `cf_component` VALUES ('WS@COM-0003', 'WS@Output-ModelFile', 'Web服务 | 模型文件输出（待定）（通配所有模型）', '10', '-1', '输出平台训练的模型文件', '-1', '2017-05-27 17:47:34', 'admin', '2017-05-27 17:47:34', 'admin');

-- ----------------------------
-- Table structure for dw_data_table
-- ----------------------------
DROP TABLE IF EXISTS `dw_data_table`;
CREATE TABLE `dw_data_table` (
  `TABLE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据表ID',
  `TABLE_NAME` varchar(200) NOT NULL COMMENT '数据表名\r\n            \r\n            普通和动态数据表：由英文字符、数字和下划线组成，起始字符不能为下划线\r\n            临时数据表：tmp$<node_id>_<node_port_id>_<job_id>',
  `TABLE_TYPE` int(11) NOT NULL COMMENT '数据表类型\r\n            0：普通数据表\r\n            1：动态数据表，由写数据表组件产生，在编辑过程中创建\r\n            2：临时数据表\r\n            3：外部数据表，由在线服务的数据文件输入组件产生，DATA_FILE关联完整文件路径，作业完成时被立即清理',
  `TABLE_SRC` int(11) NOT NULL DEFAULT '0' COMMENT '数据表来源\r\n            0：内部生成\r\n            1：外部导入',
  `OWNER_DW_ID` bigint(20) NOT NULL COMMENT '所属数据库ID',
  `REL_JOB_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联作业ID，无关联则设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联节点ID，创建数据表的工作流节点，无关联则设为-1',
  `REL_CHAR_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联特征ID，创建数据表的工作流节点输出特征，无关联则设为-1',
  `TABLE_COLUMNS` bigint(20) DEFAULT NULL COMMENT '列数',
  `TABLE_ROWS` bigint(20) DEFAULT NULL COMMENT '行数',
  `DATA_FILE_TYPE` int(11) NOT NULL DEFAULT '0' COMMENT '数据文件类型\r\n            1：Parquet文件格式 ',
  `DATA_FILE_SIZE` bigint(20) DEFAULT NULL COMMENT '文件大小，单位为字节',
  `DATA_FILE` varchar(800) DEFAULT NULL COMMENT '数据文件名，普通数据表存放于数据目录下，临时数据表存放于作业目录下\r\n            \r\n            普通和动态数据表：${DATA_DIR}/table_<table_id>.parquet\r\n            临时数据表：${JOB_DIR}/table_<task_id>_<table_id>.parquet',
  `DATA_SUMMARY_FILE` varchar(800) DEFAULT NULL COMMENT '数据概要文件名，普通数据表存放于数据目录下，临时数据表存放于作业目录下\r\n            \r\n            普通和动态数据表：${DATA_DIR}/table_summary_<table_id>.parquet\r\n            临时数据表：${JOB_DIR}/table_summary_<task_id>_<table_id>.parquet',
  `TABLE_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '数据表状态\r\n            0：空表\r\n            1：正常\r\n            2：仅概要文件',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`TABLE_ID`),
  UNIQUE KEY `Index_1` (`OWNER_DW_ID`,`TABLE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据表';

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
  `DW_TYPE` int(11) NOT NULL COMMENT '数据库类型\r\n            0：公共数据库，暂用于存放实验模版所预置的数据表\r\n            1：项目数据库，随项目创建同时生成，存放项目中产生的数据表',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID，数据库类型为公共数据库时设为-1',
  `DATA_DFS_DIR` varchar(800) NOT NULL COMMENT 'DFS数据目录，存放普通数据表的数据文件和数据概要文件\r\n            \r\n            ${HDFS_SITE}/${DFS_WORK_ROOT}/dw_data/<dw_code>',
  `DATA_LOCAL_DIR` varchar(800) NOT NULL COMMENT '本地数据目录，缓存普通数据表的数据概要文件\r\n            \r\n            ${LOCAL_WORK_ROOT}/dw_data/<dw_code>',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`DW_ID`),
  UNIQUE KEY `Index_1` (`DW_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据库表，对数据表做分组，辅助项目权限隔离';

-- ----------------------------
-- Records of dw_data_warehouse
-- ----------------------------

-- ----------------------------
-- Table structure for em_experiment
-- ----------------------------
DROP TABLE IF EXISTS `em_experiment`;
CREATE TABLE `em_experiment` (
  `EXPERIMENT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '实验ID',
  `EXPERIMENT_NAME` varchar(200) NOT NULL COMMENT '实验名称',
  `EXPERIMENT_TYPE` int(11) NOT NULL DEFAULT '0' COMMENT '实验类型\r\n            0：主实验，正常创建实验\r\n            1：预测实验，通过选择主实验中的已训练模型进行自动创建',
  `MAIN_EXPERIMENT_ID` bigint(20) NOT NULL COMMENT '所属主实验ID，正常创建实验设为-1',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `FLOW_ID` bigint(20) NOT NULL COMMENT '流程图ID',
  `EXPERIMENT_DFS_DIR` varchar(800) NOT NULL COMMENT 'DFS实验目录\r\n            \r\n            ${HDFS_SITE}/${DFS_WORK_ROOT}/exp_data/<project_id>/<experiment_id>',
  `EXPERIMENT_LOCAL_DIR` varchar(800) NOT NULL COMMENT '本地实验目录\r\n            \r\n            ${LOCAL_WORK_ROOT}/exp_data/<project_id>/<experiment_id>',
  `SEQUENCE` int(11) NOT NULL DEFAULT '0' COMMENT '实验序号，用于辅助复制实验时的新名称后缀编号',
  `SUMMARY` varchar(256) DEFAULT NULL COMMENT '摘要，冗余WF_FLOW.SUMMARY信息',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述，冗余WF_FLOW.DESCRIPTION信息',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`EXPERIMENT_ID`),
  UNIQUE KEY `Index_1` (`OWNER_PROJECT_ID`,`EXPERIMENT_NAME`),
  KEY `Index_3` (`OWNER_PROJECT_ID`,`EXPERIMENT_TYPE`,`MAIN_EXPERIMENT_ID`),
  KEY `Index_2` (`OWNER_PROJECT_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实验表，实验是工作流的外壳主体';

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
  `SEQUENCE` int(11) NOT NULL COMMENT '模版序号',
  `TEMPLATE_CONTENT` mediumtext COMMENT '模版内容',
  `TEMPLATE_COUNT` bigint(20) NOT NULL DEFAULT '0' COMMENT '模版计数',
  `SUMMARY` varchar(256) DEFAULT NULL COMMENT '摘要',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`TEMPLATE_ID`),
  UNIQUE KEY `Index_1` (`TEMPLATE_NAME`),
  KEY `Index_2` (`SEQUENCE`)
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
  `MODEL_NAME` varchar(200) NOT NULL COMMENT '模型名称\r\n            \r\n            普通和动态模型：由字符和数字组成，无特殊字符\r\n            临时模型：组件名称 - 同组件节点序号 - Model [ - 评估指标 - 排名序号] - 作业ID',
  `MODEL_TYPE` int(11) NOT NULL COMMENT '模型类型\r\n            0：普通模型\r\n            1：动态模型，由写模型组件产生，在编辑过程中创建\r\n            2：临时模型',
  `MODEL_SRC` int(11) NOT NULL COMMENT '模型来源\r\n            0：内部生成\r\n            1：外部导入',
  `OWNER_MW_ID` bigint(20) NOT NULL COMMENT '所属模型库ID',
  `REL_JOB_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联作业ID，无关联则设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联节点ID，创建模型的工作流节点，无关联则设为-1',
  `REL_CHAR_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联特征ID，创建模型的工作流节点输出特征，无关联则设为-1',
  `REF_ALGORITHM_ID` bigint(20) NOT NULL COMMENT '引用算法ID',
  `MODEL_FILE_SIZE` bigint(20) DEFAULT NULL COMMENT '模型文件大小，单位为字节',
  `MODEL_FILE` varchar(800) DEFAULT NULL COMMENT '模型文件名，普通模型存放于模型目录下，临时模型存放于作业目录下\r\n            \r\n            普通模型和动态：${MODEL_DIR}/model_<model_id>.mdl\r\n            临时模型：${JOB_DIR}/model_<task_id>_<model_id>.mdl',
  `MODEL_SUMMARY_FILE` varchar(800) DEFAULT NULL COMMENT '模型概要文件名，普通模型存放于模型目录下，临时模型存放于作业目录下，记录训练算法参数，训练收敛过程（e.g. LogLoss，AUC），以及其他模型训练相关可以收集到的所有信息\r\n            \r\n            普通和动态模型：${MODEL_DIR}/model_summary_<model_id>.json\r\n            临时模型：${JOB_DIR}/model_summary_<task_id>_<model_id>.json',
  `MODEL_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '模型状态\r\n            0：空模型\r\n            1：正常',
  `TRAIN_TABLE_ID` bigint(20) DEFAULT NULL COMMENT '训练集数据表ID（关联训练集是否需要另外拷贝一份全量数据，待定）',
  `TRAIN_COST_TIME` bigint(20) DEFAULT NULL COMMENT '训练运行时间，单位毫秒',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`MODEL_ID`),
  UNIQUE KEY `Index_1` (`OWNER_MW_ID`,`MODEL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模型表，导入外部模型待暂不考虑';

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
  `MW_TYPE` int(11) NOT NULL COMMENT '数据库类型\r\n            0：公共模型库（预留）\r\n            1：项目模型库，随项目创建同时生成，存放项目中产生的模型',
  `OWNER_PROJECT_ID` bigint(20) DEFAULT NULL COMMENT '所属项目ID，模型库类型为公共模型库时设为-1',
  `MODEL_DFS_DIR` varchar(800) NOT NULL COMMENT 'DFS模型目录，存放普通模型的模型文件和模型概要文件\r\n            \r\n            ${HDFS_SITE}/${DFS_WORK_ROOT}/mw_model/<mw_code>',
  `MODEL_LOCAL_DIR` varchar(800) NOT NULL COMMENT '本地模型目录，缓存普通模型的模型概要文件\r\n            \r\n            ${LOCAL_WORK_ROOT}/mw_model/<mw_code>',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`MW_ID`),
  UNIQUE KEY `Index_1` (`MW_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模型库表，对模型做分组，辅助项目权限隔离';

-- ----------------------------
-- Records of mw_model_warehouse
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
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PROJECT_ID`),
  UNIQUE KEY `Index_1` (`PROJECT_CODE`),
  UNIQUE KEY `Index_2` (`PROJECT_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目表';

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
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PROJECT_ID`,`MEMBER_USER`),
  KEY `Index_1` (`MEMBER_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目成员表';

-- ----------------------------
-- Records of pr_project_member
-- ----------------------------

-- ----------------------------
-- Table structure for sys_parameter
-- ----------------------------
DROP TABLE IF EXISTS `sys_parameter`;
CREATE TABLE `sys_parameter` (
  `PARAM_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '参数ID',
  `PARAM_CODE` varchar(200) NOT NULL COMMENT '参数代码',
  `PARAM_NAME` varchar(200) NOT NULL COMMENT '参数名称',
  `PARAM_CLASS` int(11) NOT NULL COMMENT '参数类别，按系统模块划分',
  `PARAM_SUB_CLASS` int(11) NOT NULL COMMENT '参数子类别，按系统模块下的功能模块划分',
  `PARAM_VALUE` varchar(2000) NOT NULL COMMENT '参数值',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '参数状态\r\n            0：正常\r\n            1：失效',
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

-- ----------------------------
-- Table structure for wf_code_script
-- ----------------------------
DROP TABLE IF EXISTS `wf_code_script`;
CREATE TABLE `wf_code_script` (
  `SCRIPT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '脚本ID',
  `SCRIPT_NAME` varchar(200) NOT NULL COMMENT '脚本名称\r\n            \r\n            由工作流创建：<module_code>_<node_id>_<char_id>_<snapshot_version>',
  `SCRIPT_TYPE` int(11) NOT NULL COMMENT '脚本类型\r\n            0：普通脚本\r\n            1：SQL脚本\r\n            2：Python脚本（预留）\r\n            3：R脚本（预留）\r\n            4：特征抽取脚本（预留）',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `REL_SNAPSHOT_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联快照ID，创建脚本时的工作流快照，无关联则设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联节点ID，创建脚本的工作流节点，无关联则设为-1',
  `REL_CHAR_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联特征ID，创建脚本的工作流节点输出特征，无关联则设为-1',
  `SCRIPT_CONTENT` text COMMENT '脚本内容',
  `SCRIPT_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '脚本状态\r\n            0：正常\r\n            1：空脚本',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SCRIPT_ID`),
  KEY `Index_1` (`OWNER_PROJECT_ID`,`CREATE_TIME`)
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
  `JOB_TYPE` int(11) NOT NULL COMMENT '作业类型\r\n            0：全部运行\r\n            1：从此处开始运行\r\n            2：执行到此处\r\n            3：执行该节点\r\n            10：全部运行（小数据试运行）\r\n            11：从此处开始运行（小数据试运行）\r\n            12：执行到此处（小数据试运行）\r\n            13：执行该节点（小数据试运行）\r\n            20：定时调度运行\r\n            30：在线调度运行\r\n            1001：数据文件上传',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `REL_FLOW_ID` bigint(20) NOT NULL COMMENT '关联工作流ID，无关联工作流设为-1',
  `REL_SNAPSHOT_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联快照ID，无关联则设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL COMMENT '关联节点ID，填写与触发运行相关的节点ID，无关联则设为-1',
  `JOB_CONTEXT` mediumtext COMMENT '作业上下文',
  `JOB_DFS_DIR` varchar(800) NOT NULL COMMENT 'DFS作业目录\r\n            \r\n            实验作业：${HDFS_SITE}/${DFS_WORK_ROOT}/job_data/<project_id>/<experiment_id>/<job_id>\r\n            其他作业：${HDFS_SITE}/${DFS_WORK_ROOT}/job_data/<project_id>/other/<job_id>',
  `JOB_LOCAL_DIR` varchar(800) NOT NULL COMMENT '本地作业目录（预留）\r\n            \r\n            实验作业：${LOCAL_WORK_ROOT}/job_data/<project_id>/<experiment_id>/<job_id>\r\n            其他作业：${LOCAL_WORK_ROOT}/job_data/<project_id>/other/<job_id>',
  `NEXT_TASK_SEQUENCE` bigint(20) NOT NULL DEFAULT '1' COMMENT '下一任务序号',
  `JOB_SUBMIT_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '作业提交时间',
  `JOB_START_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '作业开始时间',
  `JOB_END_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '作业结束时间',
  `JOB_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '作业状态\r\n            0：preparing，准备中\r\n            1：queueing，排队中\r\n            2：running，运行中\r\n            3：finished，运行完成\r\n            4：error terminated，出错终止\r\n            5：user terminated，用户终止',
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`JOB_ID`),
  KEY `Index_1` (`OWNER_PROJECT_ID`,`REL_FLOW_ID`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_PROJECT_ID`,`JOB_TYPE`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流运行作业表，实验粒度的运行任务，由工作流引擎将其分解为以节点为粒度的运行任务';

-- ----------------------------
-- Records of wf_execution_job
-- ----------------------------

-- ----------------------------
-- Table structure for wf_execution_queue
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution_queue`;
CREATE TABLE `wf_execution_queue` (
  `JOB_ID` bigint(20) NOT NULL COMMENT '作业ID',
  `STATE` int(11) NOT NULL DEFAULT '0' COMMENT '处理状态\r\n            0：queueing，排队中\r\n            1：processing，处理中',
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '描述',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`JOB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流运行队列表，结束运行后移除';

-- ----------------------------
-- Records of wf_execution_queue
-- ----------------------------

-- ----------------------------
-- Table structure for wf_execution_task
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution_task`;
CREATE TABLE `wf_execution_task` (
  `TASK_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `TASK_NAME` varchar(200) NOT NULL COMMENT '任务名称，自动生成',
  `OWNER_JOB_ID` bigint(20) NOT NULL COMMENT '所属作业ID',
  `SEQUENCE` int(11) NOT NULL DEFAULT '0' COMMENT '作业中任务序号',
  `REL_NODE_ID` bigint(20) NOT NULL COMMENT '关联节点ID',
  `ENGINE_TYPE` varchar(200) NOT NULL DEFAULT 'unknown' COMMENT '计算引擎类型（预留）',
  `EXTERNAL_ID` varchar(800) NOT NULL DEFAULT 'unknown' COMMENT '外部任务ID，比如yarn的application id，默认unknown',
  `TASK_CONTEXT` mediumtext COMMENT '任务上下文',
  `SUBMIT_FILE` varchar(800) NOT NULL COMMENT '提交文件名，存放在运行目录下\r\n            \r\n            ${JOB_DIR}/submit_<task_id>_<module_code>.json',
  `RETURN_FILE` varchar(800) NOT NULL COMMENT '返回文件名，存放在运行目录下\r\n            \r\n            ${JOB_DIR}/return_<task_id>_<module_code>.json',
  `LOG_FILE` varchar(800) NOT NULL COMMENT '日志文件名，存放在运行目录下\r\n            \r\n            ${JOB_DIR}/log_<task_id>_<module_code>.log',
  `COST_TIME` bigint(20) NOT NULL DEFAULT '-1' COMMENT '运行时间，单位毫秒，默认为-1',
  `TASK_PROGRESS` int(11) NOT NULL DEFAULT '0' COMMENT '任务进度，百分比数值0到100',
  `TASK_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '运行状态\r\n            0：ready，已就绪\r\n            1：queueing，排队中\r\n            2：running，运行中\r\n            3：finished，运行完成\r\n            4：error terminated，出错终止\r\n            5：user terminated，用户中止',
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`TASK_ID`),
  UNIQUE KEY `Index_1` (`OWNER_JOB_ID`,`REL_NODE_ID`),
  KEY `Index_2` (`OWNER_JOB_ID`,`SEQUENCE`),
  KEY `Index_3` (`OWNER_JOB_ID`,`STATUS`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流运行任务表';

-- ----------------------------
-- Records of wf_execution_task
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow`;
CREATE TABLE `wf_flow` (
  `FLOW_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流程图ID',
  `FLOW_NAME` varchar(200) NOT NULL COMMENT '流程图名称，自动生成',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `OWNER_EXPERIMENT_ID` bigint(20) NOT NULL COMMENT '所属实验ID',
  `LOCK_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '加锁状态，实验运行和快照期间加锁，可读不可写\r\n            \r\n            0：未加锁\r\n            1：已加锁',
  `LOCK_MSG` varchar(512) DEFAULT NULL COMMENT '加锁消息',
  `LAST_SNAPSHOT_ID` bigint(20) DEFAULT NULL COMMENT '最后快照ID',
  `NEXT_SNAPSHOT_VERSION` bigint(20) NOT NULL DEFAULT '1' COMMENT '下一快照版本',
  `NEXT_DELETE_SEQUENCE` bigint(20) NOT NULL DEFAULT '1' COMMENT '下一删除序号',
  `LAST_JOB_ID` bigint(20) DEFAULT NULL COMMENT '最后作业ID',
  `FLOW_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '工作流状态\r\n            0：draft，草稿\r\n            1：preparing，准备中\r\n            2：running，运行中\r\n            3：finished running，运行结束',
  `SUMMARY` varchar(256) DEFAULT NULL COMMENT '摘要，实验摘要信息',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述，实验描述信息',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  `VERSION` bigint(20) NOT NULL COMMENT '版本号，解决同一实验多用户编辑问题',
  PRIMARY KEY (`FLOW_ID`),
  UNIQUE KEY `Index_1` (`OWNER_EXPERIMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流表，记录当前的实验状态，由一系列子表记录实验画布上节点和边的图形信息，以及节点参数内容和输出内容';

-- ----------------------------
-- Records of wf_flow
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_global_parameter
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_global_parameter`;
CREATE TABLE `wf_flow_global_parameter` (
  `GLOBAL_PARAM_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '全局参数ID',
  `GLOBAL_PARAM_NAME` varchar(200) NOT NULL COMMENT '全局参数名',
  `REL_FLOW_ID` bigint(20) NOT NULL COMMENT '关联工作流ID',
  `REL_NODE_ID` bigint(20) NOT NULL COMMENT '关联节点ID',
  `REL_CHAR_ID` bigint(20) NOT NULL COMMENT '关联组件特征ID',
  `DEFAULT_VALUE` varchar(2000) NOT NULL COMMENT '默认值',
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`GLOBAL_PARAM_ID`),
  UNIQUE KEY `Index_1` (`REL_FLOW_ID`,`REL_NODE_ID`,`REL_CHAR_ID`),
  UNIQUE KEY `Index_2` (`REL_FLOW_ID`,`GLOBAL_PARAM_NAME`),
  KEY `Index_3` (`REL_FLOW_ID`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流全局参数表，用于定时调度任务和开放服务API，指定哪些参数可以暴露到外部，从而调用方可以根据作业需要动态设置工作流节点参数值。';

-- ----------------------------
-- Records of wf_flow_global_parameter
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_node
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node`;
CREATE TABLE `wf_flow_node` (
  `NODE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '节点ID',
  `NODE_NAME` varchar(200) NOT NULL COMMENT '节点名称，自动生成，可编辑',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `OWNER_FLOW_ID` bigint(20) NOT NULL COMMENT '所属工作流ID，无关联实验设为-1',
  `REF_MODULE_ID` bigint(20) NOT NULL COMMENT '引用工作流组件ID',
  `POSITION_X` bigint(20) NOT NULL DEFAULT '0' COMMENT '流程图节点X轴坐标',
  `POSITION_Y` bigint(20) NOT NULL DEFAULT '0' COMMENT '流程图节点Y轴坐标',
  `SEQUENCE` int(11) NOT NULL DEFAULT '0' COMMENT '节点序号，用于辅助创建新节点时节点名称的自动生成',
  `LAST_TASK_ID` bigint(20) DEFAULT NULL COMMENT '最后任务ID',
  `WARNING_MSG` varchar(256) DEFAULT NULL COMMENT '警告消息',
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '流程图节点描述',
  `NODE_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '节点状态\r\n            0：not ready，未就绪\r\n            1：ready，已就绪\r\n            2：preparing，准备中\r\n            3：running，运行中\r\n            4：success，运行成功\r\n            5：error，运行出错',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_ID`),
  KEY `Index_1` (`OWNER_FLOW_ID`,`REF_MODULE_ID`,`SEQUENCE`),
  KEY `Index_2` (`OWNER_PROJECT_ID`,`REF_MODULE_ID`,`CREATE_TIME`)
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
  `SEQUENCE` int(11) NOT NULL COMMENT '删除序号',
  `NODE_ID` bigint(20) NOT NULL COMMENT '节点ID',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  KEY `Index_1` (`FLOW_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点删除队列表，一次删除序号可以有多个删除节点\r\n\r\n节点删除为逻辑删除，输出内容根据缓存策略';

-- ----------------------------
-- Records of wf_flow_node_delete_queue
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_node_link
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_link`;
CREATE TABLE `wf_flow_node_link` (
  `LINK_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '链路ID',
  `OWNER_FLOW_ID` bigint(20) NOT NULL COMMENT '所属工作流ID',
  `SRC_NODE_PORT_ID` bigint(20) NOT NULL COMMENT '流出节点端口ID',
  `DST_NODE_PORT_ID` bigint(20) NOT NULL COMMENT '流入节点端口ID',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`LINK_ID`),
  KEY `Index_1` (`SRC_NODE_PORT_ID`),
  KEY `Index_3` (`OWNER_FLOW_ID`),
  KEY `Index_2` (`DST_NODE_PORT_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点链路表';

-- ----------------------------
-- Records of wf_flow_node_link
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_node_parameter
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_parameter`;
CREATE TABLE `wf_flow_node_parameter` (
  `NODE_ID` bigint(20) NOT NULL COMMENT '节点ID',
  `CHAR_ID` bigint(20) NOT NULL COMMENT '组件特征ID',
  `CHAR_VALUE` varchar(2000) DEFAULT NULL COMMENT '特征值',
  `IS_GLOBAL_PARAMETER` int(11) NOT NULL DEFAULT '0' COMMENT '是否为全局参数\r\n            0：否\r\n            1：是',
  `IS_DUPLICATED` int(11) NOT NULL DEFAULT '0' COMMENT '是否被复制\r\n            0：否\r\n            1：是\r\n            \r\n            创建副本和运行任务时对象数据类型会以浅拷贝方式复制，同时该标记会被置位，辅助于对象类型组件参数发生更新时，判断是否创建新对象来保存新值',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_ID`,`CHAR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点参数表，记录组件参数和调优参数的特征值';

-- ----------------------------
-- Records of wf_flow_node_parameter
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_node_port
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_port`;
CREATE TABLE `wf_flow_node_port` (
  `NODE_PORT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '节点端口ID',
  `OWNER_NODE_ID` bigint(20) NOT NULL COMMENT '所属节点ID',
  `REF_PORT_ID` bigint(20) NOT NULL COMMENT '引用组件端口ID',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_PORT_ID`),
  UNIQUE KEY `Index_1` (`OWNER_NODE_ID`,`REF_PORT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点端口表';

-- ----------------------------
-- Records of wf_flow_node_port
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_node_schema
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_schema`;
CREATE TABLE `wf_flow_node_schema` (
  `NODE_PORT_ID` bigint(20) NOT NULL COMMENT '所属节点输出端口ID',
  `JSON_OBJECT_ID` bigint(20) DEFAULT NULL COMMENT 'json对象ID',
  `SCHEMA_STATE` int(11) NOT NULL DEFAULT '0' COMMENT 'JSON数据状态\r\n            0：空对象\r\n            1：非空对象',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_PORT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点schema表，缓存节点输出端口内容为数据表的字段结构\r\n\r\n实验发布时，数据读取和数据输';

-- ----------------------------
-- Records of wf_flow_node_schema
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_node_value
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_value`;
CREATE TABLE `wf_flow_node_value` (
  `NODE_ID` bigint(20) NOT NULL COMMENT '节点ID',
  `CHAR_ID` bigint(20) NOT NULL COMMENT '组件特征ID',
  `SPEC_TYPE` int(11) NOT NULL COMMENT '规格类型，说明参考CF_CMPT_SPEC.SPEC_TYPE\r\n            节点上只设置组件参数和调优执行',
  `CHAR_VALUE` varchar(2000) DEFAULT NULL COMMENT '特征值',
  `IS_GLOBAL_PARAMETER` int(11) NOT NULL DEFAULT '0' COMMENT '是否为全局参数\r\n            0：否\r\n            1：是',
  `IS_DUPLICATED` int(11) NOT NULL DEFAULT '0' COMMENT '是否被复制\r\n            0：否\r\n            1：是\r\n            \r\n            创建快照和运行任务时对象数据类型会以浅拷贝方式复制，同时该标记会被置位，辅助于对象类型特征值发生更新时，判断是否创建新对象来保存新值',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_ID`,`CHAR_ID`,`SPEC_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点设置特征值表，记录组件参数和调优参数的特征值';

-- ----------------------------
-- Records of wf_flow_node_value
-- ----------------------------

-- ----------------------------
-- Table structure for wf_json_object
-- ----------------------------
DROP TABLE IF EXISTS `wf_json_object`;
CREATE TABLE `wf_json_object` (
  `OBJECT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '对象ID',
  `OBJECT_NAME` varchar(200) NOT NULL COMMENT '对象名称\r\n            \r\n            普通对象：object_<node_id>_<char_id>_<snapshot_version> \r\n            算法参数：algorithm_parameters_<node_id>_<char_id>_<job_id>\r\n            模型评估报告：model_evaluation_report_<node_id>_<char_id>_<job_id>\r\n            统计分析报告：statisticsl_analysis_report_<node_id>_<char_id>_<job_id>\r\n            自动调参报告：tune_parameters_<node_id>_<char_id>_<job_id>\r\n            生成规则报告：generate_rules_<node_id>_<char_id>_<job_id>\r\n            输出端口schema：outport_schema_<node_id>_<char_id>_<snapshot_version>',
  `OBJECTY_TYPE` int(11) NOT NULL COMMENT '对象类型\r\n            0：普通对象（仅存放于OBJECT_DATA）\r\n            1：算法参数（输出内容，正常存放于OBJECT_DATA）\r\n            2：模型评估报告（输出内容，正常存放于OBJECT_DATA）\r\n            3：统计分析报告（输出内容，正常存放于OBJECT_DATA）\r\n            4：自动调参报告（输出内容，正常存放位置待定）\r\n            5：生成规则报告（输出内容，正常存放位置待定）\r\n            99：输出端口schema（端口信息，字段数量不超过2000存放于OBJECT_DATA）',
  `OBJECT_SRC` int(11) NOT NULL DEFAULT '0' COMMENT '对象来源\r\n            0：作业运行\r\n            1：实验编辑',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `REL_FLOW_ID` bigint(20) NOT NULL COMMENT '关联工作流ID，无关联工作流设为-1',
  `REL_SNAPSHOT_VERSION` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联快照版本，取FLOW表的NEXT_SNAPSHOT_VERSION值，无关联则设为-1',
  `REL_JOB_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联作业ID，无关联则设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联节点ID，创建脚本的工作流节点，无关联则设为-1',
  `REL_CHAR_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联特征ID，创建脚本的工作流节点输出特征，无关联则设为-1',
  `STORAGE_LOCATION` int(11) NOT NULL DEFAULT '0' COMMENT '存储位置\r\n            \r\n            0：OBJECT_DATA字段\r\n            1：文件系统',
  `OBJECT_DATA` mediumtext COMMENT 'JSON数据',
  `OBJECT_FILE` varchar(800) DEFAULT NULL COMMENT '对象文件名\r\n            \r\n            算法参数：${JOB_DIR}/algorithm_parameters_<json_id>.json\r\n            模型评估报告：${JOB_DIR}/model_evaluation_report_<json_id>.json\r\n            统计分析报告：${JOB_DIR}/statistics_analysis_report_<json_id>.json\r\n            自动调参报告：${JOB_DIR}/tune_parameters_report_<json_id>.json\r\n            生成规则报告：${JOB_DIR}/generate_rules_report_<json_id>.json\r\n            输出端口schema：${EXPERIMENT_DIR}/outport_schema_<json_id>.json',
  `OBJECT_STATE` int(11) NOT NULL DEFAULT '0' COMMENT 'JSON数据状态\r\n            0：空对象\r\n            1：非空对象',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`OBJECT_ID`),
  KEY `Index_1` (`OWNER_PROJECT_ID`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='JSON对象表';

-- ----------------------------
-- Records of wf_json_object
-- ----------------------------

-- ----------------------------
-- Table structure for wf_module
-- ----------------------------
DROP TABLE IF EXISTS `wf_module`;
CREATE TABLE `wf_module` (
  `MODULE_ID` bigint(20) NOT NULL COMMENT '组件ID',
  `MODULE_CODE` varchar(200) NOT NULL COMMENT '组件代码',
  `MODULE_NAME` varchar(200) NOT NULL COMMENT '组件名称',
  `CATALOG_ID` bigint(20) NOT NULL COMMENT '所属目录ID，不进目录设为-1',
  `SEQUENCE` int(11) NOT NULL COMMENT '排序序号',
  `CATEGORY` varchar(200) DEFAULT NULL COMMENT '组件类别（预留），自定义类别',
  `ICON_TYPE` int(11) NOT NULL COMMENT '图标类型',
  `CLASS_PATH` varchar(200) NOT NULL COMMENT '组件java类class path',
  `PKG_CMPT_ID` varchar(64) NOT NULL COMMENT '所封装的计算组件ID',
  `IS_EXTENDED` int(11) NOT NULL DEFAULT '0' COMMENT '是否为扩展组件（预留）\r\n            0：否\r\n            1：是',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`MODULE_ID`),
  UNIQUE KEY `Index_1` (`MODULE_CODE`),
  KEY `Index_2` (`CATALOG_ID`,`SEQUENCE`),
  KEY `Index_3` (`PKG_CMPT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流组件表';

-- ----------------------------
-- Records of wf_module
-- ----------------------------

-- ----------------------------
-- Table structure for wf_module_catalog
-- ----------------------------
DROP TABLE IF EXISTS `wf_module_catalog`;
CREATE TABLE `wf_module_catalog` (
  `CATALOG_ID` bigint(20) NOT NULL COMMENT '目录ID',
  `CATALOG_CODE` varchar(200) NOT NULL COMMENT '目录代码',
  `CATALOG_NAME` varchar(200) NOT NULL COMMENT '目录名称',
  `PARENT_CATALOG_ID` bigint(20) NOT NULL COMMENT '上级目录ID，一级目录设为0',
  `SEQUENCE` int(11) NOT NULL COMMENT '排序序号',
  `ICON_TYPE` int(11) NOT NULL COMMENT '图标类型',
  `CATEGORY` varchar(200) DEFAULT NULL COMMENT '组件类别（预留），自定义类别',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CATALOG_ID`),
  UNIQUE KEY `Index_1` (`CATALOG_CODE`),
  KEY `Index_2` (`PARENT_CATALOG_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流组件目录表，用于定义工作流组件目录结构';

-- ----------------------------
-- Records of wf_module_catalog
-- ----------------------------

-- ----------------------------
-- Table structure for wf_module_port
-- ----------------------------
DROP TABLE IF EXISTS `wf_module_port`;
CREATE TABLE `wf_module_port` (
  `PORT_ID` bigint(20) NOT NULL COMMENT '端口ID，组件的同一类型端口数最多6个\r\n            端口ID值组成：工作流组件ID * 100 + 一位节点端口类型 * 10 + 一位端口序号',
  `PORT_NAME` varchar(200) NOT NULL COMMENT '端口名称',
  `PORT_TYPE` int(11) NOT NULL COMMENT '端口类型\r\n            0：输入端口\r\n            1：输出端口',
  `OWNER_MODULE_ID` bigint(20) NOT NULL COMMENT '所属工作流组件ID',
  `BIND_CHAR_ID` varchar(64) NOT NULL COMMENT '绑定计算组件输入输出特征ID，SPEC_TYPE in （0, 1）',
  `SEQUENCE` int(11) NOT NULL COMMENT '端口序号',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '端口状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PORT_ID`),
  UNIQUE KEY `Index_2` (`OWNER_MODULE_ID`,`BIND_CHAR_ID`),
  KEY `Index_1` (`OWNER_MODULE_ID`,`PORT_TYPE`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流组件端口表，映射计算组件输入输出内容到工作流组件端口上';

-- ----------------------------
-- Records of wf_module_port
-- ----------------------------

-- ----------------------------
-- Table structure for wf_oper_favorite_module
-- ----------------------------
DROP TABLE IF EXISTS `wf_oper_favorite_module`;
CREATE TABLE `wf_oper_favorite_module` (
  `PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID，数据库类型为公共数据库时设为-1',
  `OPER_ID` varchar(100) NOT NULL COMMENT '用户ID',
  `MODULE_ID` bigint(20) NOT NULL COMMENT '组件ID',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PROJECT_ID`,`OPER_ID`,`MODULE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户收藏数据表';

-- ----------------------------
-- Records of wf_oper_favorite_module
-- ----------------------------

-- ----------------------------
-- Table structure for wf_oper_favorite_table
-- ----------------------------
DROP TABLE IF EXISTS `wf_oper_favorite_table`;
CREATE TABLE `wf_oper_favorite_table` (
  `PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID，数据库类型为公共数据库时设为-1',
  `OPER_ID` varchar(100) NOT NULL COMMENT '用户ID',
  `TABLE_ID` bigint(20) NOT NULL COMMENT '数据表ID',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PROJECT_ID`,`OPER_ID`,`TABLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户收藏数据表';

-- ----------------------------
-- Records of wf_oper_favorite_table
-- ----------------------------

-- ----------------------------
-- Table structure for wf_snapshot
-- ----------------------------
DROP TABLE IF EXISTS `wf_snapshot`;
CREATE TABLE `wf_snapshot` (
  `SNAPSHOT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '快照ID',
  `SNAPSHOT_NAME` varchar(200) NOT NULL COMMENT '快照名称',
  `SHAPSHOT_SRC` int(11) NOT NULL COMMENT '快照来源\r\n            0：工作流运行\r\n            1：工作流副本',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `OWNER_FLOW_ID` bigint(20) NOT NULL COMMENT '所属流程图ID',
  `SNAPSHOT_CONTENT` longtext COMMENT '快照内容',
  `SNAPSHOT_VERSION` bigint(20) NOT NULL COMMENT '快照版本',
  `SNAPSHOT_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '快照状态\r\n            0：generating，快照生成中\r\n            1：finished，快照完成',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SNAPSHOT_ID`),
  KEY `Index_1` (`OWNER_FLOW_ID`,`SHAPSHOT_SRC`,`SNAPSHOT_VERSION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流快照表，在实验工作台创建副本和运行实验都会触发快照创建，由此实现类似checkpoint功能\r\n\r\n                                -&';

-- ----------------------------
-- Records of wf_snapshot
-- ----------------------------
