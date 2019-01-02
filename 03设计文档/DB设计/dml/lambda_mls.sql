/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50724
Source Host           : 127.0.0.1:3306
Source Database       : lambda_mls

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-02 22:49:33
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
INSERT INTO `cf_cmpt_algorithm` VALUES ('1001', 'OneClass-SVM', '单分类支持向量机', '1', null, '2', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('1002', 'PCA-Based-AnomalyDetection', '基于PCA异常检测', '1', null, '2', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('2001', 'LR-TwoClassClassification', '逻辑回归二分类', '2', null, '1', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('2002', 'RF-TwoClassClassification', '随机森林二分类', '2', null, '1', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('2003', 'GBDT-TwoClassClassification', 'GBDT二分类', '2', null, '1', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('2004', 'LinearSVM-TwoClassClassification', '线性支持向量机二分类', '2', null, '1', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('2005', 'XGBoost-TwoClassClassification', 'XGBoost二分类', '2', null, '1', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('3001', 'LR-MultipleClassClassification', '逻辑回归多分类', '3', null, '1', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('3002', 'RF-MultipleClassClassification', '随机森林多分类', '3', null, '1', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('3003', 'XGBoost-MultipleClassClassification', 'XGBoost多分类', '3', null, '1', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('3004', 'NaiveBayesian-MultipleClassClassification', '朴素贝叶斯多分类', '3', null, '1', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('3005', 'KNN-MultipleClassClassification', 'K近邻多分类', '3', null, '1', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('4001', 'KMeans-Clustering', 'K均值聚类', '4', null, '2', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('5001', 'Linear-Regression', '线性回归', '5', null, '1', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('5002', 'GBDT-Regression', 'GBDT回归', '5', null, '1', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('5003', 'XGBoost-Regression', 'XGBoost回归', '5', null, '1', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('6001', 'Apriori-AssociationRules', 'Apriori关联规则', '6', null, '2', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('6002', 'FPG-AssociationRules', 'FP-Growth关联规则', '6', null, '2', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');
INSERT INTO `cf_cmpt_algorithm` VALUES ('7001', 'ALS-CollaborativeFiltering', 'ALS协同过滤', '7', null, '2', '0', '0', null, '0', '2017-05-12 14:56:52', 'admin', '2017-05-12 14:56:52', 'admin');

-- ----------------------------
-- Table structure for cf_cmpt_char
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_char`;
CREATE TABLE `cf_cmpt_char` (
  `CHAR_ID` varchar(64) NOT NULL COMMENT '特征ID\r\n\r\n输入内容规格类型\r\n特征ID范围：IN@C-[0000 ~ 9999]\r\n\r\n输出内容规格类型\r\n特征ID范围：OUT@C[0000 ~ 9999]\r\n\r\n调用执行规格类型\r\n特征ID范围：EX@C-[0000 ~ 9999]\r\n\r\n执行调优参数规格类型\r\n特征ID范围：OEX@C-[0000 ~ 9999]\r\n\r\n组件参数规格类型\r\n所有组件通用特征ID范围：CCP@C-ALL@COM-[0000 ~ 9999]\r\n同类组件通用特征ID范围：CCP@C-[XX]@COM-[0000 ~ 9999]\r\n单个组件专用特征ID值组成：SCP@C-${CMPT-ID}-[00~99]',
  `CHAR_CODE` varchar(200) NOT NULL COMMENT '特征代码',
  `CHAR_NAME` varchar(200) NOT NULL COMMENT '特征名称',
  `CHAR_ALIAS` varchar(200) DEFAULT NULL COMMENT '特征别名，非空时，使用特征别名替代特征代码作为参数名',
  `SPEC_TYPE` int(11) NOT NULL COMMENT '适用规格类型',
  `CHAR_TYPE` int(11) NOT NULL COMMENT '特征类型ID',
  `SRC_LEVEL` int(11) NOT NULL COMMENT '特征值来源级别\r\n1：计算组件规格\r\n2：计算组件\r\n3：工作流节点（仅限组件参数、执行调优、输入输出）\r\n\r\n注意，仅限在小于来源级别的地方做特征值设置有效，否则无效\r\n说明，特征值选用次序工作流节点 > 计算组件 > 计算组件规格 > 特征默认值',
  `IS_ALLOW_GLOBAL` int(11) NOT NULL DEFAULT '0' COMMENT '允许设置为全局变量\r\n            0：否\r\n            1：是',
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
  UNIQUE KEY `Index_1` (`CHAR_CODE`) USING BTREE,
  UNIQUE KEY `Index_2` (`CHAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件特征表，配置组件相关的一系列特征参数项\r\n\r\n特征别名为空时，自动采用特征代码来填充\r\n后期可以考虑给每个特征配置特征Class，用于自定义特征值校验';

-- ----------------------------
-- Records of cf_cmpt_char
-- ----------------------------
INSERT INTO `cf_cmpt_char` VALUES ('10030', 'maxIteration', '通用参数 | 机器学习 | 最大iter迭代次数', null, '5', '3', '3', '0', '1', '2', null, '1', '1', '10000', '1', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('10031', 'eta', '通用参数 | 机器学习 | 学习速率eta', null, '5', '5', '3', '0', '1', '1', null, '0.01', '0', '1.0', '0.05', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('10032', 'epsilon', '通用参数 | 机器学习 | 收敛系数eplison（最小收敛误差）', null, '5', '5', '3', '0', '0', '0', null, '0.01', null, null, '0.000001', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('10034', 'regularizedType', '通用参数 | 机器学习 | 正则项类型', null, '5', '7', '3', '0', '0', '5', null, null, null, null, 'None', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('10035', 'regularizedCoef', '通用参数 | 机器学习 | 正则系数', null, '5', '5', '3', '0', '0', '0', null, '0.1', null, null, '1', '可选，正则类型为None时此值无效', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500300', 'treeNumber', '专用参数 | 机器学习 | 随机森林 | 森林中树的数目', null, '5', '3', '3', '0', '1', '2', null, '1', '1', '1000', '100', null, '0', '2017-05-17 18:00:30', 'admin', '2017-05-17 18:00:30', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500301', 'algorithmDistribution', '专用参数 | 机器学习 | 随机森林 | 森林中树的算法分布', null, '5', '7', '3', '0', '0', '0', null, null, null, null, null, '如果有则长度为2.比如有n棵树，algorithmTypes=a,b  则[0,a) 是 id3, [a,b) 是cart， [b,n) 是c4.5。例如：在一个拥有5棵树的森林中，[2, 4]表示0，1为id3算法，2, 3为cart算法，4为c4.5算法。如果输入为None，则算法在森林中均分。', '0', '2017-05-17 19:07:52', 'admin', '2017-05-17 19:08:01', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500302', 'randomFeatureNumber', '专用参数 | 机器学习 | 随机森林 | 单颗树输入随机特征的个数', null, '5', '3', '3', '0', '0', '2', null, '1', '1', null, null, '范围 [1, N]，N为feature数，默认log2N', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500303', 'minInstsPerNode', '专用参数 | 机器学习 | 随机森林 | 叶节点数据的最小个数', null, '5', '3', '3', '0', '0', '2', null, '1', '1', null, '2', null, '0', '2017-05-17 19:28:46', 'admin', '2017-05-17 19:28:46', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500304', 'maxDepth1', '专用参数 | 机器学习 | 随机森林 | 单颗树的最大深度', null, '5', '3', '3', '0', '0', '2', null, '1', '1', null, null, '默认无穷大', '0', '2017-05-17 19:45:05', 'admin', '2017-05-17 19:45:05', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500305', 'randomInstsNumber', '专用参数 | 机器学习 | 随机森林 | 单颗树输入随机数据的个数（待定）', null, '5', '3', '3', '0', '0', '2', null, '1', '1000', '1000000', '100000', null, '0', '2017-05-17 19:57:08', 'admin', '2017-05-17 19:57:08', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500400', 'treeNumber1', '专用参数 | 机器学习 | GBDT二分类 | 树的数目', null, '5', '3', '3', '0', '1', '2', null, '1', '1', '10000', '500', null, '0', '2017-05-17 20:05:17', 'admin', '2017-05-17 20:05:17', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500401', 'featureRatio', '专用参数 | 机器学习 | GBDT二分类 | 训练特征采样比', null, '5', '5', '3', '0', '0', '1', null, '0.01', '0', '1.0', '0.6', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500402', 'sampleRatio', '专用参数 | 机器学习 | GBDT二分类 | 训练样本采样比', null, '5', '5', '3', '0', '0', '1', null, '0.01', '0', '1.0', '0.6', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500403', 'testRatio', '专用参数 | 机器学习 | GBDT二分类 | 测试样本采样比', null, '5', '5', '3', '0', '0', '1', null, '0.01', '0', '1.0', '0.6', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500404', 'maxLeafCount', '专用参数 | 机器学习 | GBDT二分类 | 最大叶子节点数', null, '5', '3', '3', '0', '0', '2', null, '1', '1', '1000', '32', null, '0', '2017-05-17 20:11:09', 'admin', '2017-05-17 20:11:09', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500405', 'maxDepth', '专用参数 | 机器学习 | GBDT二分类 | 树的最大深度', null, '5', '3', '3', '0', '0', '2', null, '1', '1', '100', '10', null, '0', '2017-05-17 20:14:25', 'admin', '2017-05-17 20:14:25', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500406', 'metricType1', '专用参数 | 机器学习 | GBDT二分类 | 指标类型', null, '5', '3', '3', '0', '1', '5', null, null, null, null, '0', null, '0', '2017-05-18 11:33:43', 'admin', '2017-05-18 11:33:43', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500407', 'shrinkage', '专用参数 | 机器学习 | GBDT二分类 | 学习速率', null, '5', '3', '3', '0', '1', '1', null, '0.01', '0', '1', '0.05', null, '0', '2017-05-18 12:56:41', 'admin', '2017-05-18 12:56:41', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500408', 'minLeafSampleCount', '专用参数 | 机器学习 | GBDT二分类 | 叶子节点最少样本数', null, '5', '3', '3', '0', '0', '2', null, '1', '1', '1000', '500', null, '0', '2017-05-18 13:05:35', 'admin', '2017-05-18 13:05:35', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500409', 'featureSplitValueMaxSize', '专用参数 | 机器学习 | GBDT二分类 | 一个特征分裂的最大数量', null, '5', '3', '3', '0', '0', '2', null, '1', '1', '1000', '500', null, '0', '2017-05-18 13:07:24', 'admin', '2017-05-18 13:07:24', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500500', 'positiveCost', '专用参数 | 机器学习 | 线性支持向量机 | 正例惩罚因子', null, '5', '5', '3', '0', '0', '1', null, null, '0', null, '1.0', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500501', 'negativeCost', '专用参数 | 机器学习 | 线性支持向量机 | 负例惩罚因子', null, '5', '5', '3', '0', '0', '1', null, null, '0', null, '1.0', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40500700', 'kNumber', '专用参数 | 机器学习 | KNN | 近邻个数', null, '5', '3', '3', '0', '1', '2', null, '1', '1', '1000', '100', null, '0', '2017-05-17 20:41:30', 'admin', '2017-05-17 20:41:30', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40510000', 'centerNumber', '专用参数 | 机器学习 | KMeans | 聚类数', null, '5', '3', '3', '0', '1', '2', null, '1', '1', '1000', '10', null, '0', '2017-05-17 21:00:00', 'admin', '2017-05-17 21:00:00', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40510001', 'distanceMeasureType', '专用参数 | 机器学习 | KMeans | 距离度量方式', null, '5', '7', '3', '0', '1', '5', null, null, null, null, 'euclidean', null, '0', '2017-05-17 21:02:55', 'admin', '2017-05-17 21:02:55', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40510002', 'centerInitMethod', '专用参数 | 机器学习 | KMeans | 质心初始化方法', null, '5', '7', '3', '0', '1', '5', null, null, null, null, 'random', null, '0', '2017-05-17 21:11:06', 'admin', '2017-05-17 21:11:06', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40520100', 'lossFunctionType', '专用参数 | 机器学习 | GBDT回归 | 损失函数类型', null, '5', '3', '3', '0', '1', '5', null, null, null, null, '0', null, '0', '2017-05-18 11:49:55', 'admin', '2017-05-18 11:50:03', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40520101', 'gbrankLossTau', '专用参数 | 机器学习 | GBDT回归 | gbrank loss中的Tau参数', null, '5', '5', '3', '0', '0', '2', null, '0.1', '0', '1', '0.6', null, '0', '2017-05-18 11:57:20', 'admin', '2017-05-18 11:57:20', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40520102', 'bottomNumber', '专用参数 | 机器学习 | GBDT回归 | gbrank loss/regression loss中的指数底数', null, '5', '3', '3', '0', '0', '2', null, '1', '1', '10', '1', null, '0', '2017-05-18 12:36:25', 'admin', '2017-05-18 12:36:25', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40520113', 'useNewtonStep', '专用参数 | 机器学习 | GBDT回归 | 是否使用牛顿迭代方法', null, '5', '3', '3', '0', '0', '5', null, null, null, null, '1', null, '0', '2017-05-18 13:12:31', 'admin', '2017-05-18 13:12:31', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('40590100', 'binCount', '专用参数 | 机器学习 | 预测 | 计算评价指标时阈值按等频/等宽分成多少个桶', null, '5', '3', '3', '0', '1', '2', null, '1000', '1000', null, '1000', null, '0', '2017-05-18 17:20:21', 'admin', '2017-05-18 17:20:21', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0000', 'CCP@#Common-Component-Parameter', '通用参数 | #通用参数', null, '5', '-1', '-1', '-1', '-1', '-1', null, null, null, null, null, null, '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0001', 'CCP@LabelColumnName', '通用参数 | 标签列的列名', 'labelColumnName', '5', '7', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0002', 'CCP@PositiveLabel', '通用参数 | 正样本标签（二分类）', 'positiveLabel', '5', '7', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0003', 'CCP@WeightColumnName', '通用参数 | 权重列的列名', 'weightColumnName', '5', '7', '3', '0', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0004', 'CCP@GroupColumnName', '通用参数 | 分组列的列名', 'groupColumnName', '5', '7', '3', '0', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0005', 'CCP@PredicationResultlColumnName', '通用参数 | 预测输出结果列的列名', 'predicationResultColumnName', '5', '7', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0006', 'CCP@PredicationScoreColumnName', '通用参数 | 预测输出分数列的列名', 'predicationScoreColumnName', '5', '7', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0007', 'CCP@PredicationDetailColumnName', '通用参数 | 预测输出详情列的列名', 'predicationDetailColumnName', '5', '7', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0008', 'CCP@FeatureColumnNames', '通用参数 | 特征列的列名列表（选择特征）（不建议）', 'featureColumnNames', '5', '9001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0009', 'CCP@ForceDiscreteColumnNames', '通用参数 | 离散列的列名列表（强制转换）（不建议）', 'forceDiscreteColumnNames', '5', '9000', '3', '0', '0', '0', null, null, null, null, null, 'feature默认解析规则： string、boolean、date、datetime类型的列解析为离散类型。 整数和浮点数类型的列解析为连续类型，若有将bigint解析为categorical/nominal的情况，通过参数cmptParam_ml_forceDiscreteColumnNames指定。', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0010', 'CCP@ReverseColumnNames', '通用参数 | 保留列的列名列表（附加特征）（不建议）', 'reverseColumnNames', '5', '9000', '3', '0', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-0011', 'CCP@ExcludedColumnNames', '通用参数 | 排除列的列名列表（排除特征）（不建议）', 'excludedColumnNames', '5', '9000', '3', '0', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-IO@COM-0013', 'CCP@IO-TableName', '通用参数 | 输入输出 | 数据表名', 'tableName', '5', '7', '3', '0', '1', '0', null, null, null, null, null, '用于数据表读取系列的表名值存放', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-IO@COM-0014', 'CCP@IO-ModelID', '通用参数 | 输入输出 | 模型ID', 'modelID', '5', '4', '3', '0', '1', '0', null, null, null, null, null, '用于模型读取系列组件的模型ID值存放', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('CCP@C-ML@COM-0001', 'CCP@ML-RandSeed', '通用参数 | 机器学习 | 随机数种子', 'randomSeed', '5', '3', '3', '0', '0', '2', null, '1', '0', '10', '0', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-0000', 'EX@#Execution', '调用执行 | #调用执行', null, '3', '-1', '-1', '-1', '-1', '-1', null, null, null, null, null, null, '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-0001', 'EX@Engine-Type', '调用执行 | 计算引擎', 'engineType', '3', '7', '1', '0', '1', '5', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-0002', 'EX@Spark-Cmpt-Jar-Dir', '调用执行 | spark组件jar库目录', 'jarDir', '3', '7', '2', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-0003', 'EX@Spark-Cmpt-Jar-File', '调用执行 | spark组件jar包文件名', 'jarFile', '3', '7', '2', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-0004', 'EX@Spark-Cmpt-Class-Path', '调用执行 | spark组件class路径', 'class', '3', '7', '2', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-9996', 'EX@Spark-Python-Cmpt-Pkg-Dir（待定）', '调用执行 | spark python组件包目录', 'pythonPkgDir', '3', '7', '2', '0', '1', '0', null, null, null, null, null, null, '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-9997', 'EX@Spark-Python-Cmpt-File（待定）', '调用执行 | spark python组件文件名', 'pythonFile', '3', '7', '2', '0', '1', '0', null, null, null, null, null, null, '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-9998', 'EX@Spark-R-Cmpt-Pkg-Dir（待定）', '调用执行 | spark R组件包目录', 'rPkgDir', '3', '7', '2', '0', '1', '0', null, null, null, null, null, null, '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('EX@C-9999', 'EX@Spark-R-Cmpt-File（待定）', '调用执行 | spark R组件文件名', 'rFile', '3', '7', '2', '0', '1', '0', null, null, null, null, null, null, '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0000', 'IN@#Input-Content', '输入内容 | #输入内容', null, '1', '-1', '-1', '-1', '-1', '-1', null, null, null, null, null, null, '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0001', 'IN@DataTable-t1<M>', '输入内容 | 数据表t1<M>', 't1', '1', '1001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0002', 'IN@DataTable-t2<M>', '输入内容 | 数据表t2<M>', 't2', '1', '1001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0003', 'IN@DataTable-t2<C>', '输入内容 | 数据表t2<C>', 't2', '1', '1001', '3', '0', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0004', 'IN@DataTable-t3<M>', '输入内容 | 数据表t3<M>', 't3', '1', '1001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0005', 'IN@DataTable-t3<C>', '输入内容 | 数据表t3<C>', 't3', '1', '1001', '3', '0', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0006', 'IN@DataTable-t4<M>', '输入内容 | 数据表t4<M>', 't4', '1', '1001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0007', 'IN@DataTable-t4<C>', '输入内容 | 数据表t4<C>', 't4', '1', '1001', '3', '0', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0008', 'IN@DataTable-t5<M>', '输入内容 | 数据表t5<M>', 't5', '1', '1001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0009', 'IN@DataTable-t5<C>', '输入内容 | 数据表t5<C>', 't5', '1', '1001', '3', '0', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0010', 'IN@DataTable-t6<M>', '输入内容 | 数据表t6<M>', 't6', '1', '1001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0011', 'IN@DataTable-t6<C>', '输入内容 | 数据表t6<C>', 't6', '1', '1001', '3', '0', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0012', 'IN@Algorithm<OneClass-Classification>-a1<M>', '输入内容 | 单分类算法参数a1<M>', 'a1', '1', '4001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0013', 'IN@Algorithm<TwoClass-Classification>-a1<M>', '输入内容 | 二分类算法参数a1<M>', 'a1', '1', '4002', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0014', 'IN@Algorithm<MultipleClass-Classification>-a1<M>', '输入内容 | 多分类算法参数a1<M>', 'a1', '1', '4003', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0015', 'IN@Algorithm<Classification>-a1<M>', '输入内容 | 通配分类算法参数a1<M>', 'a1', '1', '4004', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0016', 'IN@Algorithm<Clustering>-a1<M>', '输入内容 | 聚类算法参数a1<M>', 'a1', '1', '4005', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0017', 'IN@Algorithm<Regression>-a1<M>', '输入内容 | 回归算法参数a1<M>', 'a1', '1', '4006', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0018', 'IN@Algorithm<Classification,Regression>-a1<M>', '输入内容 | 通配分类&回归算法参数a1<M>', 'a1', '1', '4007', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0019', 'IN@Model<OneClass-Classification>-m1<M>', '输入内容 | 单分类模型m1<M>', 'm1', '1', '2001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0020', 'IN@Model<TwoClass-Classification>-m1<M>', '输入内容 | 二分类模型m1<M>', 'm1', '1', '2002', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0021', 'IN@Model<MultipleClass-Classification>-m1<M>', '输入内容 | 多分类模型m1<M>', 'm1', '1', '2003', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0022', 'IN@Model<Classification>-m1<M>', '输入内容 | 通配分类模型m1<M>', 'm1', '1', '2004', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0023', 'IN@Model<Clustering>-m1<M>', '输入内容 | 聚类模型m1<M>', 'm1', '1', '2005', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0024', 'IN@Model<Regression>-m1<M>', '输入内容 | 回归模型m1<M>', 'm1', '1', '2006', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0025', 'IN@Model<Classification,Regression>-m1<M>', '输入内容 | 通配分类&回归模型m1<M>', 'm1', '1', '2007', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('IN@C-0026', 'IN@Model<CollaborativeFiltering>-m1<M>', '输入内容 | 协同过滤模型m1<M>', 'm1', '1', '2008', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OEX@C-0000', 'OEX@#OptimizeExecution', '执行调优 | #执行调优', null, '4', '-1', '-1', '-1', '-1', '-1', null, null, null, null, null, null, '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OEX@C-0001', 'OEX@Spark-Executor-Number', '执行调优 | spark.executor.number', 'spark.executor.number', '4', '3', '3', '0', '0', '0', null, '1', '1', '100', '2', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OEX@C-0002', 'OEX@Spark-Executor-Cores', '执行调优 | spark.executor.cores', 'spark.executor.cores', '4', '3', '3', '0', '0', '0', null, '1', '1', '100', '8', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OEX@C-0003', 'OEX@Spark-Executor-Memory', '执行调优 | spark.executor.memory', 'spark.executor.memory', '4', '3', '3', '0', '0', '0', null, '1', '256', '131072', '2048', '内存单位MB，最多128GB', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OEX@C-0004', 'OEX@Spark-Driver-Cores', '执行调优 | spark.driver.cores', 'spark.driver.cores', '4', '3', '3', '0', '0', '0', null, '1', '1', '100', '8', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OEX@C-0005', 'OEX@Spark-Driver-Memory', '执行调优 | spark.driver.memory', 'spark.driver.memory', '4', '3', '3', '0', '0', '0', null, '1', '256', '262144', '1024', '内存单位MB，最多256GB', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OEX@C-0006', 'OEX@Spark-Extra-Configuration', '执行调优 | spark.extra.configuration（待定）', 'spark.extra.configuration', '4', '7', '3', '0', '0', '0', null, null, null, null, null, null, '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0000', 'OUT@#Output-Content', '输出内容 | #输出内容', null, '2', '-1', '-1', '-1', '-1', '-1', null, null, null, null, null, null, '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0001', 'OUT@DataTable-t1<M>', '输出内容 | 数据表t1<M>', 't1', '2', '1001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0002', 'OUT@DataTable-t2<M>', '输出内容 | 数据表t2<M>', 't2', '2', '1001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0003', 'OUT@DataTable-t2<C>', '输出内容 | 数据表t2<C>', 't2', '2', '1001', '3', '0', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0004', 'OUT@DataTable-t3<M>', '输出内容 | 数据表t3<M>', 't3', '2', '1001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0005', 'OUT@DataTable-t3<C>', '输出内容 | 数据表t3<C>', 't3', '2', '1001', '3', '0', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0006', 'OUT@DataTable-t4<M>', '输出内容 | 数据表t4<M>', 't4', '2', '1001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0007', 'OUT@DataTable-t4<C>', '输出内容 | 数据表t4<C>', 't4', '2', '1001', '3', '0', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0008', 'OUT@DataTable-t5<M>', '输出内容 | 数据表t5<M>', 't5', '2', '1001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0009', 'OUT@DataTable-t5<C>', '输出内容 | 数据表t5<C>', 't5', '2', '1001', '3', '0', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0010', 'OUT@DataTable-t6<M>', '输出内容 | 数据表t6<M>', 't6', '2', '1001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0011', 'OUT@DataTable-t6<C>', '输出内容 | 数据表t6<C>', 't6', '2', '1001', '3', '0', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0012', 'OUT@Algorithm<OneClass-Classification>-a1<M>', '输出内容 | 单分类算法参数a1<M>', 'a1', '2', '4001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0013', 'OUT@Algorithm<TwoClass-Classification>-a1<M>', '输出内容 | 二分类算法参数a1<M>', 'a1', '2', '4002', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0014', 'OUT@Algorithm<MultipleClass-Classification>-a1<M>', '输出内容 | 多分类算法参数a1<M>', 'a1', '2', '4003', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0015', 'OUT@Algorithm<Clustering>-a1<M>', '输出内容 | 聚类算法参数a1<M>', 'a1', '2', '4005', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0016', 'OUT@Algorithm<Regression>-a1<M>', '输出内容 | 回归算法参数a1<M>', 'a1', '2', '4006', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0017', 'OUT@Algorithm<Classification>-a1<M>', '输出内容 | 通配分类算法参数a1<M>', 'a1', '2', '4004', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0018', 'OUT@Algorithm<Classification,Regression>-a1<M>', '输出内容 | 通配分类&回归算法参数a1<M>', 'a1', '2', '4007', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0019', 'OUT@Model<OneClass-Classification>-m1<M>', '输出内容 | 单分类模型m1<M>', 'm1', '2', '2001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0020', 'OUT@Model<TwoClass-Classification>-m1<M>', '输出内容 | 二分类模型m1<M>', 'm1', '2', '2002', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0021', 'OUT@Model<MultipleClass-Classification>-m1<M>', '输出内容 | 多分类模型m1<M>', 'm1', '2', '2003', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0022', 'OUT@Model<Clustering>-m1<M>', '输出内容 | 聚类模型m1<M>', 'm1', '2', '2005', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0023', 'OUT@Model<Regression>-m1<M>', '输出内容 | 回归模型m1<M>', 'm1', '2', '2006', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0024', 'OUT@Model<CollaborativeFiltering>-m1<M>', '输出内容 | 协同过滤模型m1<M>', 'm1', '2', '2008', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0025', 'OUT@Model<Classification>-m1<M>', '输出内容 | 通配分类模型m1<M>', 'm1', '2', '2004', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0026', 'OUT@Model<Classification,Regression>-m1<M>', '输出内容 | 通配分类&回归模型m1<M>', 'm1', '2', '2007', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0027', 'OUT@Report<ModelEvaluation>-r1<M>', '输出内容 | 模型评估报告r1<M>', 'r1', '2', '5001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0028', 'OUT@Report<StatisticsAnalysis>-r1<M>', '输出内容 | 统计分析报告r1<M>', 'r1', '2', '5002', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0029', 'OUT@Report<CrossValidation>-r1<M>', '输出内容 | 交叉验证报告r1<M>', 'r1', '2', '5003', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0030', 'OUT@Report<TuneParameters>-r1<M>', '输出内容 | 自动调参报告r1<M>', 'r1', '2', '5004', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('OUT@C-0031', 'OUT@Report<GenerateRules>-r1<M>', '输出内容 | 生成规则报告r1<M>', 'r1', '2', '5005', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-AA@COM-0000-00', 'SCP@#Special-Component-Parameter', '专用参数 | #专用参数', null, '5', '-1', '-1', '-1', '-1', '-1', null, null, null, null, null, null, '-1', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-01', 'SCP@Import-DataFile@FileType', '专用参数 | 输入输出 | 数据文件导入 | 文件类型', 'fileType', '5', '7', '3', '0', '1', '5', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-02', 'SCP@Import-DataFile@FilePath', '专用参数 | 输入输出 | 数据文件导入 | 文件路径', 'filePath', '5', '7', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-03', 'SCP@Import-DataFile@ColumnDelimiter', '专用参数 | 输入输出 | 数据文件导入 | 列分隔符', 'columnDelimiter', '5', '7', '3', '0', '0', '0', null, null, null, null, '0x2C', '列分隔符，内容填写相应符号的ASCII码十六进制值，例如CSV默认为逗号（0x2C），TSV默认为制表符（0x09），TXT默认为空格（0x20）', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-04', 'SCP@Import-DataFile@LineDelimiter', '专用参数 | 输入输出 | 数据文件导入 | 行分隔符', 'lineDelimiter', '5', '7', '3', '0', '0', '0', null, null, null, null, '0x0A', '行分隔符，内容填写相应符号的ASCII码十六进制值，例如Window默认为回车符换行符（0x0D0x0A），MacOS默认为回车符（0xD），Unix/Linux默认为换行符（0x0A）', '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-05', 'SCP@Import-DataFile@CharacterEncoding', '专用参数 | 输入输出 | 数据文件导入 | 字符编码', 'characterEncoding', '5', '7', '3', '0', '1', '5', null, null, null, null, 'UTF-8', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-06', 'SCP@Import-DataFile@ExistHeader', '专用参数 | 输入输出 | 数据文件导入 | 首行是否为字段标题', 'existHeader', '5', '1', '3', '0', '0', '0', null, null, null, null, 'false', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-07', 'SCP@Import-DataFile@Schema', '专用参数 | 输入输出 | 数据文件导入 | 字段描述列表', 'schema', '5', '9001', '3', '0', '0', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-08', 'SCP@Import-DataFile@DateFormat', '专用参数 | 输入输出 | 数据文件导入 | 日期格式', 'dateFormat', '5', '7', '3', '0', '0', '0', null, null, null, null, 'yyyy-mm-dd', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-09', 'SCP@Import-DataFile@TimeFormat', '专用参数 | 输入输出 | 数据文件导入 | 时间格式', 'timeFormat', '5', '7', '3', '0', '0', '0', null, null, null, null, 'yyyy-mm-dd hh24:mi:ss', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-10', 'SCP@Import-DataFile@TypeException', '专用参数 | 输入输出 | 数据文件导入 | 字段类型异常处理', 'typeException', '5', '7', '3', '0', '0', '5', null, null, null, null, 'missing value', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-IO@COM-9999-11', 'SCP@Import-DataFile@ColumnsException', '专用参数 | 输入输出 | 数据文件导入 | 列数异常处理', 'columnsException', '5', '7', '3', '0', '0', '5', null, null, null, null, 'discard row', null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-ST@COM-0001-01', 'SCP@Sql-Script@sqlScript', '专用参数 | 脚本工具 | SQL脚本 | SQL脚本', 'sqlScript', '5', '3001', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-ST@COM-0002-01', 'SCP@Python-Script@pythonScript', '专用参数 | 脚本工具 | Python脚本 | Python脚本', 'pythonScript', '5', '3002', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');
INSERT INTO `cf_cmpt_char` VALUES ('SCP@C-ST@COM-0003-01', 'SCP@R-Script@rScript', '专用参数 | 脚本工具 | R脚本 | R脚本', 'rScript', '5', '3003', '3', '0', '1', '0', null, null, null, null, null, null, '0', '2017-05-10 23:32:28', 'admin', '2017-05-10 23:32:28', 'admin');

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
  PRIMARY KEY (`CHAR_ID`,`ENUM_NAME`),
  UNIQUE KEY `Index_1` (`CHAR_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件特征枚举表，配置受枚举方式限定的组件特征，其所有预置的枚举项';

-- ----------------------------
-- Records of cf_cmpt_char_enum
-- ----------------------------
INSERT INTO `cf_cmpt_char_enum` VALUES ('40034', '专用参数 | 机器学习 | 正则项类型 | L1', 'L1', null, '1', null, '0', '2017-05-12 02:07:04', 'admin', '2017-05-12 02:07:04', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40034', '专用参数 | 机器学习 | 正则项类型 | L2', 'L2', null, '2', null, '0', '2017-05-12 02:07:39', 'admin', '2017-05-12 02:07:39', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40034', '专用参数 | 机器学习 | 正则项类型 | None', 'None', null, '0', null, '0', '2017-05-12 02:06:11', 'admin', '2017-05-12 02:06:11', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40510001', '专用参数 | 机器学习 | KMeans | 距离度量方式 | Cityblock', 'cityblock', null, '2', null, '0', '2017-05-17 21:05:03', 'admin', '2017-05-17 21:05:03', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40510001', '专用参数 | 机器学习 | KMeans | 距离度量方式 | Cosine', 'cosine', null, '1', null, '0', '2017-05-17 21:04:16', 'admin', '2017-05-17 21:04:16', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40510001', '专用参数 | 机器学习 | KMeans | 距离度量方式 | Euclidean', 'euclidean', null, '0', null, '0', '2017-05-17 21:03:39', 'admin', '2017-05-17 21:03:48', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40510002', '专用参数 | 机器学习 | KMeans | 质心初始化方法 | External', 'external', null, '4', null, '0', '2017-05-17 21:16:46', 'admin', '2017-05-17 21:16:46', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40510002', '专用参数 | 机器学习 | KMeans | 质心初始化方法 | KMPP', 'kmpp', null, '3', null, '0', '2017-05-17 21:15:55', 'admin', '2017-05-17 21:15:55', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40510002', '专用参数 | 机器学习 | KMeans | 质心初始化方法 | Random', 'random', null, '0', null, '0', '2017-05-17 21:13:49', 'admin', '2017-05-17 21:13:49', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40510002', '专用参数 | 机器学习 | KMeans | 质心初始化方法 | Top K', 'topk', null, '1', null, '0', '2017-05-17 21:14:51', 'admin', '2017-05-17 21:14:51', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('40510002', '专用参数 | 机器学习 | KMeans | 质心初始化方法 | Uniform', 'uniform', null, '2', null, '0', '2017-05-17 21:15:12', 'admin', '2017-05-17 21:15:12', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('EX@C-0001', '调用执行 | 计算引擎 | spark on mesos', 'spark on mesos', null, '1', null, '0', '2017-05-17 15:25:50', 'admin', '2017-05-17 15:25:50', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('EX@C-0001', '调用执行 | 计算引擎 | spark on yarn', 'spark on yarn', null, '0', null, '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | ARFF', 'ARFF', null, '3', 'weka专用的文件格式', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | COO', 'COO', null, '4', 'Coordinate稀疏矩阵文件格式', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | CSC', 'CSC', null, '6', 'Compressed Sparse Column稀疏矩阵文件格式', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | CSR', 'CSR', null, '5', 'Compressed Sparse Row稀疏矩阵文件格式', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | CSV', 'CSV', null, '0', '字段逗号分隔', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | DIA', 'DIA', null, '8', 'Diagonal稀疏矩阵文件格式', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | ELL', 'ELL', null, '7', 'ELLPACK稀疏矩阵文件格式', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | HYB', 'HYB', null, '9', 'Hybrid ELLPACK + Coordinate稀疏矩阵文件格式', '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | Parquet', 'Parquet', null, '10', 'Parquet列式存储文件格式', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | TSV', 'TSV', null, '1', '字段TAB分割', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-01', '专用参数 | 输入输出 | 数据文件导入 | 文件类型 | TXT', 'TXT', null, '2', '字段空格分隔', '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-05', '专用参数 | 输入输出 | 数据文件导入 | 字符编码 | BIG5', 'BIG5', null, '5', null, '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-05', '专用参数 | 输入输出 | 数据文件导入 | 字符编码 | GB18030', 'GB18030', null, '4', null, '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-05', '专用参数 | 输入输出 | 数据文件导入 | 字符编码 | GB2312', 'GB2312', null, '3', null, '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-05', '专用参数 | 输入输出 | 数据文件导入 | 字符编码 | GBK', 'GBK', null, '2', null, '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-05', '专用参数 | 输入输出 | 数据文件导入 | 字符编码 | Unicode', 'Unicode', null, '1', null, '-1', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-05', '专用参数 | 输入输出 | 数据文件导入 | 字符编码 | UTF-8', 'UTF-8', null, '0', null, '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-10', '专用参数 | 输入输出 | 数据文件导入 | 字段类型异常处理 | Discard Row', 'discard row', '丢弃异常行', '1', null, '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-10', '专用参数 | 输入输出 | 数据文件导入 | 字段类型异常处理 | Missing Value', 'missing value', '值设置为缺失', '0', null, '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-10', '专用参数 | 输入输出 | 数据文件导入 | 字段类型异常处理 | Return Failed', 'return failed', '返回失败', '2', null, '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-11', '专用参数 | 输入输出 | 数据文件导入 | 列数异常处理 | Discard Row', 'discard row', '丢弃异常行', '0', null, '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');
INSERT INTO `cf_cmpt_char_enum` VALUES ('SCP@C-IO@COM-9999-11', '专用参数 | 输入输出 | 数据文件导入 | 列数异常处理 | Return Failed', 'return failed', '返回失败', '1', null, '0', '2017-05-11 00:26:27', 'admin', '2017-05-11 00:26:27', 'admin');

-- ----------------------------
-- Table structure for cf_cmpt_char_type
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_char_type`;
CREATE TABLE `cf_cmpt_char_type` (
  `CHAR_TYPE_ID` int(11) NOT NULL COMMENT '特征类型ID',
  `CHAR_TYPE_CODE` varchar(200) NOT NULL COMMENT '特征类型代码',
  `CHAR_TYPE_NAME` varchar(200) NOT NULL COMMENT '特征类型名称',
  `IS_WILDTYPE` int(11) NOT NULL DEFAULT '0' COMMENT '是否为通配类型\r\n0：否\r\n1：是',
  `SPEC_MASK` int(11) NOT NULL DEFAULT '0' COMMENT '适用规格类型二进制掩码（预留）\r\n\r\n0：不支持作为对应规格的特征类型使用\r\n1：支持作为对应规格的特征类型使用\r\n\r\n第一位，输入内容规格，开关位0x01：数据表、模型、算法参数\r\n第二位，输出内容规格，开关位0x02：数据表、模型、算法参数\r\n第三位，调用执行规格，开关位0x04：基本类型\r\n第四位，执行调优规格，开关位0x08：基本类型\r\n第五位，组件参数规格，开关位0x10：基本类型、调参类型、代码脚本、Json Object、Json Array\r\n',
  `CLASS_PATH` varchar(200) NOT NULL DEFAULT 'unkown' COMMENT '特征类型java类class path',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CHAR_TYPE_ID`),
  UNIQUE KEY `Index_1` (`CHAR_TYPE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件特征类型表（仅查询用），相关定义辅助于数据校验和画布连线输入输出类型匹配校验\r\n\r\n特征值的读写行为由特征类型控制';

-- ----------------------------
-- Records of cf_cmpt_char_type
-- ----------------------------
INSERT INTO `cf_cmpt_char_type` VALUES ('1', 'Boolean', '布尔值', '0', '28', 'unkown', '特征值为true/false字符串', '0', '2017-05-12 00:42:11', 'admin', '2017-05-12 00:42:11', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2', 'Short', '16位整数', '0', '28', 'unkown', null, '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('3', 'Integer', '32为整数', '0', '28', 'unkown', null, '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4', 'Long', '64位整数', '0', '28', 'unkown', null, '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('5', 'Float', '单精度浮点数', '0', '28', 'unkown', null, '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('6', 'Double', '双精度浮点数', '0', '28', 'unkown', null, '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('7', 'String', '字符串', '0', '28', 'unkown', null, '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('8', 'Date', '日期', '0', '28', 'unkown', '特征值为“yyyy-mm-dd”格式字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('9', 'Datetime', '日期时间', '0', '28', 'unkown', '特征值为“yyyy-mm-dd hh24:mi:ss”格式字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('103', 'Tuning-Parameter<Integer>', '32位整数调参类型', '0', '16', 'unkown', '特征值格式示例（用户自定义参数不超过10个）：\r\n{\r\n  \"value\": \"100\",\r\n  \"tune_range\": {\r\n    \"start\": \"20\",\r\n    \"end\": \"1000\"\r\n  },\r\n  \"tune_udps\": [10, 80, 200, 600, 1000]\r\n}', '0', '2018-11-16 21:31:15', 'admin', '2018-11-16 21:31:15', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('104', 'Tuning-Parameter<Long>', '64位整数调参类型', '0', '16', 'unkown', '特征值格式示例（用户自定义参数不超过10个）：\r\n{\r\n  \"value\": \"100\",\r\n  \"tune_range\": {\r\n    \"start\": \"20\",\r\n    \"end\": \"1000\"\r\n  },\r\n  \"tune_udps\": [10, 80, 200, 600, 1000]\r\n}', '0', '2018-11-16 21:31:15', 'admin', '2018-11-16 21:31:15', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('105', 'Tuning-Parameter<Float>', '单精度浮点数调参类型', '0', '16', 'unkown', '特征值格式示例（用户自定义参数不超过10个）：\r\n{\r\n  \"value\": \"0.01\",\r\n  \"tune_range\": {\r\n    \"start\": \"0.00001\",\r\n    \"end\": \"0.1\"\r\n  },\r\n  \"tune_udps\": [0.00001, 0.001, 0.01, 0.1]\r\n}', '0', '2018-11-16 21:31:15', 'admin', '2018-11-16 21:31:15', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('106', 'Tuning-Parameter<Double>', '双精度浮点数调参类型', '0', '16', 'unkown', '特征值格式示例（用户自定义参数不超过10个）：\r\n{\r\n  \"value\": \"0.01\",\r\n  \"tune_range\": {\r\n    \"start\": \"0.00001\",\r\n    \"end\": \"0.1\"\r\n  },\r\n  \"tune_udps\": [0.00001, 0.001, 0.01, 0.1]\r\n}', '0', '2018-11-16 21:31:15', 'admin', '2018-11-16 21:31:15', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('1000', 'Data Table<?>', '通配泛型数据表', '0', '3', 'unkown', '特征值为数据表ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('1001', 'Data Table<Parquet>', 'Parquet数据表（预留）', '0', '3', 'unkown', '特征值为数据表ID字符串，暂时不使用', '-1', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2000', 'Trained Model<?>', '通配泛型模型', '1', '3', 'unkown', '特征值为模型ID字符串，用于模型写入、模型文件输出', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2001', 'Trained Model<OneClass-Classification>', '单分类模型', '0', '3', 'unkown', '特征值为模型ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2002', 'Trained Model<TwoClass-Classification>', '二分类模型', '0', '3', 'unkown', '特征值为模型ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2003', 'Trained Model<MultipleClass-Classification>', '多分类模型', '0', '3', 'unkown', '特征值为模型ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2004', 'Trained Model<Classification>', '通配分类模型', '1', '3', 'unkown', '特征值为模型ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2005', 'Trained Model<Clustering>', '聚类模型', '0', '3', 'unkown', '特征值为模型ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2006', 'Trained Model<Regression>', '回归模型', '0', '3', 'unkown', '特征值为模型ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2007', 'Trained Model<Classification,Regression>', '通配分类&回归模型', '1', '3', 'unkown', '特征值为模型ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('2008', 'Trained Model<CollaborativeFiltering>', '协同过滤模型', '0', '3', 'unkown', '特征值为模型ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('3001', 'SQL Script', 'SQL脚本', '0', '16', 'unkown', '特征值为脚本ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('3002', 'Python Script', 'Python脚本', '0', '16', 'unkown', '特征值为脚本ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('3003', 'R Script', 'R脚本', '0', '16', 'unkown', '特征值为脚本ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('3004', 'Feature Extraction Script', '特征抽取脚本（不使用，方案待定）', '0', '16', 'unkown', '特征值为脚本ID字符串', '-1', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4000', 'Algorithm Parameters<?>', '通配泛型算法参数（不使用）', '0', '3', 'unkown', null, '-1', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4001', 'Algorithm Parameters<OneClass-Classification>', '单分类算法参数', '0', '3', 'unkown', '特征值为JSON对象ID字符串', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4002', 'Algorithm Parameters<TwoClass-Classification>', '二分类算法参数', '0', '3', 'unkown', '特征值为JSON对象ID字符串', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4003', 'Algorithm Parameters<MultipleClass-Classification>', '多分类算法参数', '0', '3', 'unkown', '特征值为JSON对象ID字符串', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4004', 'Algorithm Parameters<Classification>', '通配分类算法参数', '1', '3', 'unkown', '特征值为JSON对象ID字符串', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4005', 'Algorithm Parameters<Clustering>', '聚类算法参数', '0', '3', 'unkown', '特征值为JSON对象ID字符串', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4006', 'Algorithm Parameters<Regression>', '回归算法参数', '0', '3', 'unkown', '特征值为JSON对象ID字符串', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('4007', 'Algorithm Parameters<Classification,Regression>', '通配分类&回归算法参数', '1', '3', 'unkown', '特征值为JSON对象ID字符串', '0', '2018-11-18 18:42:00', 'admin', '2018-11-18 18:42:00', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('5001', 'Model Evaluation Report', '模型评估报告', '0', '2', 'unkown', '特征值为JSON对象ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('5002', 'Statistical Analysis Report', '统计分析报告', '0', '2', 'unkown', '特征值为JSON对象ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('5003', 'Cross Validation Report', '交叉验证报告', '0', '2', 'unkown', '特征值为JSON对象ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('5004', 'Tune Parameters Report', '自动调参报告', '0', '2', 'unkown', '特征值为JSON对象ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('5005', 'Generate Rules Report', '生成规则报告', '0', '2', 'unkown', '特征值为JSON对象ID字符串', '0', '2017-05-10 23:18:13', 'admin', '2017-05-10 23:18:13', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('9000', 'Json Object', 'json对象', '0', '16', 'unkown', '特征值为JSON对象ID字符串', '0', '2017-05-12 00:31:39', 'admin', '2017-05-12 00:31:39', 'admin');
INSERT INTO `cf_cmpt_char_type` VALUES ('9001', 'Json Array', 'json数组', '0', '16', 'unkown', '特征值为JSON对象ID字符串', '0', '2017-05-12 00:31:39', 'admin', '2017-05-12 00:31:39', 'admin');

-- ----------------------------
-- Table structure for cf_cmpt_char_type_wild
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_char_type_wild`;
CREATE TABLE `cf_cmpt_char_type_wild` (
  `DST_CHAR_TYPE_ID` int(11) NOT NULL COMMENT '目标特征类型ID',
  `SRC_CHAR_TYPE_ID` int(11) NOT NULL COMMENT '来源特征类型ID',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`DST_CHAR_TYPE_ID`,`SRC_CHAR_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件端口特征类型通配表（仅查询用），配置目标端口特征类型和来源端口特征类型的匹配关系';

-- ----------------------------
-- Records of cf_cmpt_char_type_wild
-- ----------------------------
INSERT INTO `cf_cmpt_char_type_wild` VALUES ('2000', '2005', '通配泛型模型，聚类模型', '0', '2018-11-21 16:44:59', 'admin', '2018-11-21 16:44:59', 'admin');
INSERT INTO `cf_cmpt_char_type_wild` VALUES ('2000', '2007', '通配泛型模型，通配分类&回归模型', '0', '2018-11-21 16:44:59', 'admin', '2018-11-21 16:44:59', 'admin');
INSERT INTO `cf_cmpt_char_type_wild` VALUES ('2000', '2008', '通配泛型模型，协同过滤模型', '0', '2018-11-21 16:53:00', 'admin', '2018-11-21 16:53:00', 'admin');
INSERT INTO `cf_cmpt_char_type_wild` VALUES ('2004', '2001', '通配分类模型，单分类模型', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `cf_cmpt_char_type_wild` VALUES ('2004', '2002', '通配分类模型，二分类模型', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `cf_cmpt_char_type_wild` VALUES ('2004', '2003', '通配分类模型，多分类模型', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `cf_cmpt_char_type_wild` VALUES ('2007', '2004', '通配分类&回归模型，通配分类模型', '0', '2018-11-18 19:14:59', 'admin', '2018-11-18 19:14:59', 'admin');
INSERT INTO `cf_cmpt_char_type_wild` VALUES ('2007', '2006', '通配分类&回归模型，回归模型', '0', '2018-11-18 19:14:59', 'admin', '2018-11-18 19:14:59', 'admin');
INSERT INTO `cf_cmpt_char_type_wild` VALUES ('4004', '4001', '通配分类算法参数，单分类算法参数', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `cf_cmpt_char_type_wild` VALUES ('4004', '4002', '通配分类算法参数，二分类算法参数', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `cf_cmpt_char_type_wild` VALUES ('4004', '4003', '通配分类算法参数，多分类算法参数', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `cf_cmpt_char_type_wild` VALUES ('4007', '4004', '通配分类&回归算法参数，通配分类算法参数', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');
INSERT INTO `cf_cmpt_char_type_wild` VALUES ('4007', '4006', '通配分类&回归算法参数，回归算法参数', '0', '2018-11-18 19:17:03', 'admin', '2018-11-18 19:17:03', 'admin');

-- ----------------------------
-- Table structure for cf_cmpt_char_value
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_char_value`;
CREATE TABLE `cf_cmpt_char_value` (
  `CMPT_ID` varchar(64) NOT NULL COMMENT '组件ID',
  `CHAR_ID` varchar(64) NOT NULL COMMENT '特征ID',
  `IS_SYSTEM_PARAM` int(11) NOT NULL COMMENT '特征值是否为系统参数\r\n            0：否\r\n            1：是',
  `CHAR_VALUE` varchar(2000) DEFAULT NULL COMMENT '特征值',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
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
INSERT INTO `cf_cmpt_char_value` VALUES ('5001', '20102', '0', 'com.yatop.lambda.xxxCmpt.LogisticRegressionBinaryClassification', null, '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `cf_cmpt_char_value` VALUES ('5002', '20102', '0', 'com.yatop.lambda.xxxCmpt.LogisticRegressionMultipleClassification', null, '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `cf_cmpt_char_value` VALUES ('5003', '20102', '0', 'com.yatop.lambda.xxxCmpt.RandomForestClassification', null, '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `cf_cmpt_char_value` VALUES ('5004', '20102', '0', 'com.yatop.lambda.xxxCmpt.GradientBoostingDecisionTreeBinaryClassification', null, '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `cf_cmpt_char_value` VALUES ('5005', '20102', '0', 'com.yatop.lambda.xxxCmpt.LinearSupportVectorMachineBinaryClassification', null, '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `cf_cmpt_char_value` VALUES ('5006', '20102', '0', 'com.yatop.lambda.xxxCmpt.NaiveBayesianMultipleClassification', null, '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `cf_cmpt_char_value` VALUES ('5007', '20102', '0', 'com.yatop.lambda.xxxCmpt.KNearestNeighborsMultipleClassification', null, '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `cf_cmpt_char_value` VALUES ('5100', '20102', '0', 'com.yatop.lambda.xxxCmpt.KMeansClustering', null, '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `cf_cmpt_char_value` VALUES ('5200', '20102', '0', 'com.yatop.lambda.xxxCmpt.LinearRegression', null, '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `cf_cmpt_char_value` VALUES ('5201', '20102', '0', 'com.yatop.lambda.xxxCmpt.GradientBoostingDecisionTreeRegression', null, '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `cf_cmpt_char_value` VALUES ('5900', '20102', '0', 'com.yatop.lambda.xxxCmpt.Prediction', null, '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `cf_cmpt_char_value` VALUES ('5901', '20102', '0', 'com.yatop.lambda.xxxCmpt.BinaryClassificationEvaluation', null, '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `cf_cmpt_char_value` VALUES ('5902', '20102', '0', 'com.yatop.lambda.xxxCmpt.MultipleClassificationEvaluation', null, '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `cf_cmpt_char_value` VALUES ('5903', '20102', '0', 'com.yatop.lambda.xxxCmpt.ClusteringEvaluation', null, '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `cf_cmpt_char_value` VALUES ('5904', '20102', '0', 'com.yatop.lambda.xxxCmpt.RegressionEvaluation', null, '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');
INSERT INTO `cf_cmpt_char_value` VALUES ('5998', '20102', '0', 'com.yatop.lambda.xxxCmpt.TuneModelHyperparameter', null, '0', '2017-05-25 19:05:34', 'admin', '2017-05-25 19:05:34', 'admin');

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
  UNIQUE KEY `Index_1` (`SPEC_CODE`),
  UNIQUE KEY `Index_2` (`SPEC_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件规格表，同一组件规格下组件特征别名不能冲突';

-- ----------------------------
-- Records of cf_cmpt_spec
-- ----------------------------
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-AA@COM-0000', 'CP@#Component-Parameter', '组件参数 | #组件参数', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-0001', 'CP@Read-DataTable', '组件参数 | 输入输出 | 数据表读取', '5', '数据表名', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-0002', 'CP@Read-OneClass-Classification-Model', '组件参数 | 输入输出 | 单分类模型读取', '5', '模型ID', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-0003', 'CP@Read-TwoClass-Classification-Model', '组件参数 | 输入输出 | 二分类模型读取', '5', '模型ID', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-0004', 'CP@Read-MultipleClass-Classification-Model', '组件参数 | 输入输出 | 多分类模型读取', '5', '模型ID', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-0005', 'CP@Read-Clustering-Model', '组件参数 | 输入输出 | 聚类模型读取', '5', '模型ID', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-0006', 'CP@Read-Regression-Model', '组件参数 | 输入输出 | 回归模型读取', '5', '模型ID', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-0007', 'CP@Read-CollaborativeFiltering-Model', '组件参数 | 输入输出 | 协同过滤模型读取', '5', '模型ID', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-0008', 'CP@Write-DataTable', '组件参数 | 输入输出 | 数据表写入', '5', '数据表名，表名修改同时联动数据表名更新', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-IO@COM-9999', 'CP@Import-DataFile', '组件参数 | 输入输出 | 数据文件导入', '5', '结合数据文件上传接口，整理组件参数项', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0001', 'CP@LR-TwoClass-Classification', '组件参数 | 机器学习 | 逻辑回归二分类算法', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0002', 'CP@LR-MultipleClass-Classification', '组件参数 | 机器学习 | 逻辑回归多分类算法', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0003', 'CP@RF-TwoClass-Classification', '组件参数 | 机器学习 | 随机森林二分类算法', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0004', 'CP@RF-MultipleClass-Classification', '组件参数 | 机器学习 | 随机森林多分类算法', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0005', 'CP@GBDT-TwoClass-Classification', '组件参数 | 机器学习 | GBDT二分类算法', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0006', 'CP@XGBoost-TwoClass-Classification', '组件参数 | 机器学习 | XGBoost二分类算法（待定）', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0007', 'CP@XGBoost-MultipleClass-Classification', '组件参数 | 机器学习 | XGBoost 多分类算法（待定）', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0008', 'CP@LinearSVM-TwoClass-Classification', '组件参数 | 机器学习 | 线性SVM二分类算法', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0009', 'CP@NaiveBayesian-MultipleClass-Classification', '组件参数 | 机器学习 | 朴素贝叶斯多分类算法', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0010', 'CP@KNN-MultipleClass-Classification', '组件参数 | 机器学习 | K近邻多分类算法', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0011', 'CP@KMeans-Clustering', '组件参数 | 机器学习 | K均值聚类算法', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0012', 'CP@Linear-Regression', '组件参数 | 机器学习 | 线性回归算法', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0013', 'CP@GBDT-Regression', '组件参数 | 机器学习 | GBDT回归算法', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0014', 'CP@XGBoost-Regression', '组件参数 | 机器学习 | XGBoost回归（待定）', '5', null, '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0015', 'CP@OneClass-SVM', '组件参数 | 机器学习 | 单分类SVM算法（待定）', '5', null, '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-0016', 'CP@PCA-Based-AnomalyDetection', '组件参数 | 机器学习 | 基于PCA异常检测算法（待定）', '5', null, '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-3001', 'CP@Train-Model', '组件参数 | 机器学习 | 模型训练', '5', '支持回归和分类算法', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-3002', 'CP@Tune-Model-Hyperparameters', '组件参数 | 机器学习 | 模型自动调参', '5', '支持回归和分类算法', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-3003', 'CP@Cross-Validation', '组件参数 | 机器学习 | 交叉验证', '5', '支持回归和分类算法', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-3004', 'CP@Tune-Clustering-Model-Hyperparameters', '组件参数 | 机器学习 | 聚类模型自动调参', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-3005', 'CP@Train-AnomalyDetection-Model', '组件参数 | 机器学习 | 异常检测模型训练（待定）', '5', null, '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-3007', 'CP@Train-ALS-CollaborativeFiltering-Model', '组件参数 | 机器学习 | ALS协同过滤模型训练（待定）', '5', null, '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-6001', 'CP@Auto-GenerationRules', '组件参数 | 机器学习 | 自动生成规则（待定）', '5', null, '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-6002', 'CP@Apriori-AssociationRules', '组件参数 | 机器学习 | Apriori关联规则（待定）', '5', null, '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-6003', 'CP@FPG-AssociationRules', '组件参数 | 机器学习 | FP-Growth关联规则（待定）', '5', null, '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-8001', 'CP@Prediction', '组件参数 | 机器学习 | 预测', '5', '支持回归和分类模型', '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-8002', 'CP@Clustering-Prediction', '组件参数 | 机器学习 | 聚类预测', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-8003', 'CP@CollaborativeFiltering-Prediction', '组件参数 | 机器学习 | 协同过滤预测（待定）', '5', null, '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-9001', 'CP@OneClass-Classification-Evaluation', '组件参数 | 机器学习 | 单分类模型评估（异常检测）（待定）', '5', null, '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-9002', 'CP@TwoClass-Classification-Evaluation', '组件参数 | 机器学习 | 二分类模型评估', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-9003', 'CP@MultipleClass-Classification-Evaluation', '组件参数 | 机器学习 | 多分类模型评估', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-9004', 'CP@Clustering-Evaluation', '组件参数 | 机器学习 | 聚类模型评估', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-9005', 'CP@Regression-Evaluation', '组件参数 | 机器学习 | 回归模型评估', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ML@COM-9006', 'CP@CollaborativeFiltering-Evaluation', '组件参数 | 机器学习 | 协同过滤模型评估（待定）', '5', null, '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ST@COM-0001', 'CP@Sql-Script', '组件参数 | 脚本工具 | SQL脚本', '5', null, '0', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ST@COM-0002', 'CP@Python-Script', '组件参数 | 脚本工具 | Python脚本（待定）', '5', null, '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-ST@COM-0003', 'CP@R-Script', '组件参数 | 脚本工具 | R脚本（待定）', '5', null, '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-WS@COM-0001', 'CP@Input-DataFile', '组件参数 | 在线服务 | 数据文件输入（待定）', '5', '输入数据文件key', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-WS@COM-0002', 'CP@Output-DataFile', '组件参数 | 在线服务 | 数据文件输出（待定）', '5', '输出数据文件key', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('CP@SPEC-WS@COM-0003', 'CP@Output-ModelFile', '组件参数 | 在线服务 | 模型文件输出（待定）', '5', '输出模型文件key', '-1', '2017-05-17 16:40:23', 'admin', '2017-05-17 16:40:23', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('EX@SPEC-0000', 'EX@#Execution', '调用执行 | #调用执行', '3', null, '-1', '2017-05-17 15:08:09', 'admin', '2017-05-17 15:08:09', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('EX@SPEC-0001', 'EX@Spark', '调用执行 | Spark', '3', 'Scala和Java组件的调用执行规格', '0', '2017-05-17 15:08:09', 'admin', '2017-05-17 15:08:09', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('EX@SPEC-0002', 'EX@Spark-Python', '调用执行 | Spark Python（待定）', '3', null, '-1', '2017-05-17 15:08:09', 'admin', '2017-05-17 15:08:09', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('EX@SPEC-0003', 'EX@Spark-R', '调用执行 | Spark R待定）', '3', null, '-1', '2017-05-17 15:08:09', 'admin', '2017-05-17 15:08:09', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0000', 'IN@#Input-Content', '输入内容 | #输入内容', '1', null, '-1', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0001', 'IN@One-DataTable-t1<M>', '输入内容 | 一个数据表t1<M>', '1', null, '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0002', 'IN@Two-DataTable-t1<M>,t2<C>', '输入内容 | 二个数据表t1<M>,t2<C>', '1', null, '0', '2017-05-17 14:26:05', 'admin', '2017-05-17 14:26:05', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0003', 'IN@Three-DataTable-t1<M>,t2<C>,t3<C>', '输入内容 | 三个数据表t1<M>,t2<C>,t3<C>', '1', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0004', 'IN@Four-DataTable-t1<M>,t2<C>,t3<C>,t4<C>', '输入内容 | 四个数据表t1<M>,t2<C>,t3<C>,t4<C>', '1', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0005', 'IN@Five-DataTable-t1<M>,t2<C>,t3<C>,t4<C>,t5<C>', '输入内容 | 五个数据表t1<M>,t2<C>,t3<C>,t4<C>,t5<C>', '1', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0006', 'IN@Six-DataTable-t1<M>,t2<C>,t3<C>,t4<C>,t5<C>,t6<C>', '输入内容 | 六个数据表t1<M>,t2<C>,t3<C>,t4<C>,t5<C>,t6<C>', '1', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0007', 'IN@Two-DataTable-t1<M>,t2<M>', '输入内容 | 二个数据表t1<M>,t2<M>', '1', null, '0', '2017-05-17 14:26:05', 'admin', '2017-05-17 14:26:05', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0008', 'IN@Three-DataTable-t1<M>,t2<M>,t3<C>', '输入内容 | 三个数据表t1<M>,t2<M>,t3<C>', '1', null, '0', '2017-05-17 14:26:05', 'admin', '2017-05-17 14:26:05', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0009', 'IN@Four-DataTable-t1<M>,t2<M>,t3<C>,t4<C>', '输入内容 | 四个数据表t1<M>,t2<M>,,t3<C>,t4<C>', '1', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0010', 'IN@Five-DataTable-t1<M>,t2<M>,t3<C>,t4<C>,t5<C>', '输入内容 | 五个数据表t1<M>,t2<M>,t3<C>,t4<C>,t5<C>', '1', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0011', 'IN@Six-DataTable-t1<M>,t2<M>,t3<C>,t4<C>,t5<C>,t6<C>', '输入内容 | 六个数据表t1<M>,t2<M>,t3<C>,t4<C>,t5<C>,t6<C>', '1', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0012', 'IN@Three-DataTable-t1<M>,t2<M>,t3<M>', '输入内容 | 三个数据表t1<M>,t2<M>,t3<M>', '1', null, '0', '2017-05-17 14:26:05', 'admin', '2017-05-17 14:26:05', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0013', 'IN@Four-DataTable-t1<M>,t2<M>,t3<M>,t4<C>', '输入内容 | 四个数据表t1<M>,t2<M>,,t3<M>,t4<C>', '1', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0014', 'IN@Five-DataTable-t1<M>,t2<M>,t3<M>,t4<C>,t5<C>', '输入内容 | 五个数据表t1<M>,t2<M>,t3<M>,t4<C>,t5<C>', '1', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0015', 'IN@Six-DataTable-t1<M>,t2<M>,t3<M>,t4<C>,t5<C>,t6<C>', '输入内容 | 六个数据表t1<M>,t2<M>,t3<M>,t4<C>,t5<C>,t6<C>', '1', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0016', 'IN@Four-DataTable-t1<M>,t2<M>,t3<M>,t4<M>', '输入内容 | 四个数据表t1<M>,t2<M>,,t3<M>,t4<M>', '1', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0017', 'IN@Five-DataTable-t1<M>,t2<M>,t3<M>,t4<M>,t5<C>', '输入内容 | 五个数据表t1<M>,t2<M>,t3<M>,t4<M>,t5<C>', '1', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0018', 'IN@Six-DataTable-t1<M>,t2<M>,t3<M>,t4<M>,t5<C>,t6<C>', '输入内容 | 六个数据表t1<M>,t2<M>,t3<M>,t4<M>,t5<C>,t6<C>', '1', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0019', 'IN@Five-DataTable-t1<M>,t2<M>,t3<M>,t4<M>,t5<M>', '输入内容 | 五个数据表t1<M>,t2<M>,t3<M>,t4<M>,t5<M>', '1', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0020', 'IN@Six-DataTable-t1<M>,t2<M>,t3<M>,t4<M>,t5<M>,t6<C>', '输入内容 | 六个数据表t1<M>,t2<M>,t3<M>,t4<M>,t5<M>,t6<C>', '1', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0021', 'IN@Six-DataTable-t1<M>,t2<M>,t3<M>,t4<M>,t5<M>,t6<M>', '输入内容 | 六个数据表t1<M>,t2<M>,t3<M>,t4<M>,t5<M>,t6<M>', '1', null, '0', '2017-05-17 14:27:11', 'admin', '2017-05-17 14:27:11', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0022', 'IN@One-Algorithm<OneClass-Classification>-a1<M> + One-DataTable-t1<M>', '输入内容 | 一个单分类算法参数a1<M> + 一个数据表t1<M>', '1', null, '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0023', 'IN@One-Algorithm<Classification,Regression>-a1<M> + One-DataTable-t1<M>', '输入内容 | 一个通配分类和回归算法参数a1<M> + 一个数据表t1<M>', '1', null, '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0024', 'IN@One-Algorithm<Classification,Regression>-a1<M> + Two-DataTable-t1<M>,t2<C>', '输入内容 | 一个通配分类和回归算法参数a1<M> + 两个数据表t1<M>,t2<C>', '1', null, '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0025', 'IN@One-Algorithm<Clustering>-a1<M> + One-DataTable-t1<M>,t2<C>', '输入内容 | 一个聚类算法参数a1<M> + + 两个数据表t1<M>,t2<C>', '1', null, '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0026', 'IN@One-Model<Classification,Regression>-m1<M> + One-DataTable-t1<M>', '输入内容 | 一个通配分类和回归模型m1<M> + 一个数据表t1<M>', '1', null, '0', '2017-05-17 14:44:42', 'admin', '2017-05-17 14:44:42', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0027', 'IN@One-Model<Clustering>-m1<M> + One-DataTable-t1<M>', '输入内容 | 一个聚类模型m1<M> + 一个数据表t1<M>', '1', null, '0', '2017-05-17 14:33:20', 'admin', '2017-05-17 14:33:20', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('IN@SPEC-0028', 'IN@One-Model<CollaborativeFiltering>-m1<M> + Four-DataTable-t1<M>,t2<M>,t3<M>,t4<M>', '输入内容 | 一个协同过滤模型m1<M> +  四个数据表t1<M>,t2<M>,,t3<M>,t4<M>', '1', '协同过滤预测', '0', '2017-05-17 14:44:42', 'admin', '2017-05-17 14:44:42', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OEX@SPEC-0000', 'OEX@#OptimizeExecution', '执行调优 | #执行调优', '4', null, '0', '2017-05-17 15:10:21', 'admin', '2017-05-17 15:10:21', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OEX@SPEC-0001', 'OEX@Spark-Optimization-Configuration', '执行调优 | Spark优化配置', '4', null, '0', '2017-05-17 15:10:21', 'admin', '2017-05-17 15:10:21', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0000', 'OUT@#Output-Content', '输出内容 | #输出内容', '2', null, '-1', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0001', 'OUT@One-DataTable-t1<M>', '输出内容 | 一个数据表t1<M>', '2', null, '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0002', 'OUT@Two-DataTable-t1<M>,t2<M>', '输出内容 | 二个数据表t1<M>,t2<M>', '2', null, '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0003', 'OUT@Three-DataTable-t1<M>,t2<M>,t3<M>', '输出内容 | 三个数据表t1<M>,t2<M>,t3<M>', '2', null, '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0004', 'OUT@Four-DataTable-t1<M>,t2<M>,t3<M>,t4<M>', '输出内容 | 四个数据表t1<M>,t2<M>,t3<M>,t4<M>', '2', null, '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0005', 'OUT@Five-DataTable-t1<M>,t2<M>,t3<M>,t4<M>,t5<M>', '输出内容 | 五个数据表t1<M>,t2<M>,t3<M>,t4<M>,t5<M>', '2', null, '0', '2017-05-17 14:58:17', 'admin', '2017-05-17 14:58:17', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0006', 'OUT@Six-DataTable-t1<M>,t2<M>,t3<M>,t4<M>,t5<M>,t6<M>', '输出内容 | 六个数据表t1<M>,t2<M>,t3<M>,t4<M>,t5<M>,t6<M>', '2', null, '0', '2017-05-17 14:58:17', 'admin', '2017-05-17 14:58:17', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0007', 'OUT@Two-DataTable-t1<M>,t2<C>', '输出内容 | 二个数据表t1<M>,t2<C>', '2', null, '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0008', 'OUT@One-Algorithm<OneClass-Classification>-a1<M>', '输出内容 | 一个单分类算法参数a1<M>', '2', null, '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0009', 'OUT@One-Algorithm<TwoClass-Classification>-a1<M>', '输出内容 | 一个二分类算法参数a1<M>', '2', null, '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0010', 'OUT@One-Algorithm<MultipleClass-Classification>-a1<M>', '输出内容 | 一个多分类算法参数a1<M>', '2', null, '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0011', 'OUT@One-Algorithm<Clustering>-a1<M>', '输出内容 | 一个聚类算法参数a1<M>', '2', null, '0', '2017-05-17 14:33:20', 'admin', '2017-05-17 14:33:20', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0012', 'OUT@One-Algorithm<Regression>-a1<M>', '输出内容 | 一个回归算法参数m1<M>', '2', null, '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0013', 'OUT@One-Model<OneClass-Classification>-m1<M>', '输出内容 | 一个单分类模型m1<M>', '2', null, '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0014', 'OUT@One-Model<TwoClass-Classification>-m1<M>', '输出内容 | 一个二分类模型m1<M>', '2', null, '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0015', 'OUT@One-Model<MultipleClass-Classification>-m1<M>', '输出内容 | 一个多分类模型m1<M>', '2', null, '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0016', 'OUT@One-Model<Clustering>-m1<M>', '输出内容 | 一个聚类模型m1<M>', '2', null, '0', '2017-05-17 14:33:20', 'admin', '2017-05-17 14:33:20', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0017', 'OUT@One-Model<Regression>-m1<M>', '输出内容 | 一个回归模型m1<M>', '2', null, '0', '2017-05-17 14:24:10', 'admin', '2017-05-17 14:24:10', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0018', 'OUT@One-Model<CollaborativeFiltering>-m1<M>', '输出内容 | 一个协同过滤模型m1<M>', '2', '协同过滤训练', '0', '2017-05-17 14:44:42', 'admin', '2017-05-17 14:44:42', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0019', 'OUT@One-Model<Classification>-m1<M>', '输出内容 | 一个通配分类模型m1<M>', '2', null, '0', '2017-05-17 14:44:42', 'admin', '2017-05-17 14:44:42', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0020', 'OUT@One-Model<Classification,Regression>-m1<M>', '输出内容 | 一个通配分类和回归模型m1<M>', '2', null, '0', '2017-05-17 14:44:42', 'admin', '2017-05-17 14:44:42', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0021', 'OUT@One-Model<Classification,Regression>-m1<M> + One-DataTable-t1<M> +One-Report<TuneParameters>-<r1>', '输出内容 | 一个通配分类和回归模型m1<M> + 一个数据表t1<M> + 调参报告<r1>', '2', '自动调参（最优模型 + 算法参数表 + 调参报告）', '0', '2017-05-17 14:44:42', 'admin', '2017-05-17 14:44:42', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0022', 'OUT@One-Model<Clustering>-m1<M> + One-DataTable-t1<M>', '输出内容 | 一个聚类模型m1<M> + 一个数据表t1<M>', '2', '聚类训练', '0', '2017-05-17 14:33:20', 'admin', '2017-05-17 14:33:20', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0023', 'OUT@One-Model<Clustering>-m1<M> + Two-DataTable-t1<M>,t2<M> + One-Report<TuneParameters>-<r1>', '输出内容 | 一个聚类模型m1<M> + 二个数据表t1<M>,t2<M> + 调参报告<r1>', '2', '聚类自动调参（最优模型 + 算法参数表 + 结果集 + 调参报告）', '0', '2017-05-17 14:33:20', 'admin', '2017-05-17 14:33:20', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0024', 'OUT@One-Report<Model Evaluation>-r1<M> + One-DataTable-t1<M>', '输出内容 | 一个模型评估报告 + 一个数据表t1<M>', '2', '单分类?、多分类、聚类、回归、混淆矩阵、协同过滤等模型评估', '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0025', 'OUT@One-Report<Model Evaluation>-r1<M> + Three-DataTable-t1<M>,t2<M>,t3<M>', '输出内容 | 一个模型评估报告 + 三个数据表t1<M>,t2<M>,t3<M>', '2', '二分类模型评估', '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0026', 'OUT@One-Report<StatisticsAnalysis>-r1<M> + One-DataTable-t1<M>', '输出内容 | 一个统计分析报告 + 一个数据表t1<M>', '2', null, '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0027', 'OUT@One-Report<CrossValidation>-r1<M> + Two-DataTable-t1<M>,t2<M>', '输出内容 | 一个交叉验证报告 + 二个数据表t1<M>,t2<M>', '2', null, '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');
INSERT INTO `cf_cmpt_spec` VALUES ('OUT@SPEC-0028', 'OUT@One-Report<GenerateRules>-r1<M> + One-DataTable-t1<M>', '输出内容 | 一个生成规则报告 + 一个数据表t1<M>', '2', null, '0', '2017-05-17 14:35:15', 'admin', '2017-05-17 14:35:15', 'admin');

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
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-ST@COM-0001', 'SCP@C-ST@COM-0001-01', '组件参数 | 脚本工具 | SQL脚本，sql脚本', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-ST@COM-0002', 'SCP@C-ST@COM-0002-01', '组件参数 | 脚本工具 | Python脚本，python脚本', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('CP@SPEC-ST@COM-0003', 'SCP@C-ST@COM-0003-01', '组件参数 | 脚本工具 | R脚本，r脚本', '0', '2018-11-21 21:32:32', 'admin', '2018-11-21 21:32:32', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('EX@SPEC-0001', 'EX@C-0001', '调用执行 | Spark，计算引擎', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('EX@SPEC-0001', 'EX@C-0002', '调用执行 | Spark，spark组件jar库目录', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('EX@SPEC-0001', 'EX@C-0003', '调用执行 | Spark，spark组件jar包文件名', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('EX@SPEC-0001', 'EX@C-0004', '调用执行 | Spark，spark组件class路径', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0001', 'IN@C-0001', '输入内容 | 一个数据表t1<M>，输入数据表t1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0005', 'IN@C-0001', '输入内容 | 五个数据表t1<M>,t2<C>,t3<C>,t4<C>,t5<C>，输入数据表t1', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0005', 'IN@C-0003', '输入内容 | 五个数据表t1<M>,t2<C>,t3<C>,t4<C>,t5<C>，输入数据表t2', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0005', 'IN@C-0005', '输入内容 | 五个数据表t1<M>,t2<C>,t3<C>,t4<C>,t5<C>，输入数据表t3', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0005', 'IN@C-0007', '输入内容 | 五个数据表t1<M>,t2<C>,t3<C>,t4<C>,t5<C>，输入数据表t4', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
INSERT INTO `cf_cmpt_spec_char_rel` VALUES ('IN@SPEC-0005', 'IN@C-0009', '输入内容 | 五个数据表t1<M>,t2<C>,t3<C>,t4<C>,t5<C>，输入数据表t5', '0', '2018-11-21 21:36:55', 'admin', '2018-11-21 21:36:55', 'admin');
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
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
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
INSERT INTO `cf_cmpt_spec_char_value` VALUES ('EX@SPEC-0001', 'EX@C-0001', '0', 'spark on yarn', 'e.g. spark on yarn', '0', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `cf_cmpt_spec_char_value` VALUES ('EX@SPEC-0001', 'EX@C-0002', '1', 'CF_HDFS_COMPONENT_JAR_DIR', 'e.g. /user/lambda_mls/lib/scala', '0', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `cf_cmpt_spec_char_value` VALUES ('EX@SPEC-0001', 'EX@C-0003', '1', 'CF_HDFS_COMPONENTT_JAR_FILE', 'e.g. lambda-component-1.0.0.jar', '0', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `cf_cmpt_spec_char_value` VALUES ('OEX@SPEC-0001', 'OEX@C-0001', '1', 'CF_SPARK_EXECUTOR_NUMBER', 'e.g. 2', '0', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `cf_cmpt_spec_char_value` VALUES ('OEX@SPEC-0001', 'OEX@C-0002', '1', 'CF_SPARK_EXECUTOR_CORES', 'e.g. 8', '0', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `cf_cmpt_spec_char_value` VALUES ('OEX@SPEC-0001', 'OEX@C-0003', '1', 'CF_SPARK_EXECUTOR_MEMORY', 'e.g. 2048', '0', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `cf_cmpt_spec_char_value` VALUES ('OEX@SPEC-0001', 'OEX@C-0004', '1', 'CF_SPARK_DRIVER_CORES', 'e.g. 8', '0', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `cf_cmpt_spec_char_value` VALUES ('OEX@SPEC-0001', 'OEX@C-0005', '1', 'CF_SPARK_DRIVER_MEMORY', 'e.g. 1024', '0', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');
INSERT INTO `cf_cmpt_spec_char_value` VALUES ('OEX@SPEC-0001', 'OEX@C-0006', '1', 'CC_SPARK_EXTRA_CONFIGURATION', '预留', '-1', '2017-05-19 14:39:46', 'admin', '2017-05-19 14:39:46', 'admin');

-- ----------------------------
-- Table structure for cf_cmpt_spec_rel
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_spec_rel`;
CREATE TABLE `cf_cmpt_spec_rel` (
  `CMPT_ID` varchar(64) NOT NULL COMMENT '组件ID',
  `SPEC_ID` varchar(64) NOT NULL COMMENT '规格ID',
  `SPEC_TYPE` int(11) NOT NULL COMMENT '组件规格类型',
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
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ST@COM-0001', 'IN@SPEC-0005', '1', '机器学习 | SQL脚本，输入内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ST@COM-0001', 'OUT@SPEC-0001', '2', '机器学习 | SQL脚本，输出内容', '0', '2018-11-21 21:33:52', 'admin', '2018-11-21 21:33:52', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ST@COM-0001', 'EX@SPEC-0001', '3', '机器学习 | SQL脚本，调用执行', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ST@COM-0001', 'OEX@SPEC-0001', '4', '机器学习 | SQL脚本，执行调优', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');
INSERT INTO `cf_cmpt_spec_rel` VALUES ('ST@COM-0001', 'CP@SPEC-ST@COM-0001', '5', '机器学习 | SQL脚本，组件参数', '0', '2018-11-23 17:32:57', 'admin', '2018-11-23 17:32:57', 'admin');

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
  UNIQUE KEY `Index_1` (`CMPT_CODE`),
  UNIQUE KEY `Index_2` (`CMPT_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件表';

-- ----------------------------
-- Records of cf_component
-- ----------------------------
INSERT INTO `cf_component` VALUES ('BS@COM-0000', 'BS@#BusinessScenario', '业务场景 | #业务场景', '11', '-1', null, '-1', '2017-05-27 17:47:09', 'admin', '2017-05-27 17:47:09', 'admin');
INSERT INTO `cf_component` VALUES ('DL@COM-0000', 'DL@#DeepLearning', '深度学习 | #深度学习', '6', '-1', null, '-1', '2017-05-27 17:46:41', 'admin', '2017-05-27 17:46:41', 'admin');
INSERT INTO `cf_component` VALUES ('DP@COM-0000', 'DP@#DataPreprocessing', '数据预处理 | #数据预处理', '2', '-1', null, '-1', '2017-05-27 16:28:04', 'admin', '2017-05-27 16:28:04', 'admin');
INSERT INTO `cf_component` VALUES ('FE@COM-0000', 'FE@#FeatureEngineering', '特征工程 | #特征工程', '3', '-1', null, '-1', '2017-05-27 16:28:50', 'admin', '2017-05-27 16:28:50', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0000', 'IO@#InputOutput', '输入输出 | #输入输出', '0', '-1', null, '-1', '2017-05-16 17:52:14', 'admin', '2017-05-16 17:52:14', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0001', 'IO@Read-DataTable', '输入输出 | 数据表读取', '0', '-1', null, '0', '2017-05-16 17:52:14', 'admin', '2017-05-16 17:52:14', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0002', 'IO@Read-OneClass-Classification-Model', '输入输出 | 单分类模型读取', '0', '-1', null, '0', '2017-05-16 17:55:43', 'admin', '2017-05-16 17:55:43', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0003', 'IO@Read-TwoClass-Classification-Model', '输入输出 | 二分类模型读取', '0', '-1', null, '0', '2017-05-16 17:55:43', 'admin', '2017-05-16 17:55:43', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0004', 'IO@Read-MultipleClass-Classification-Model', '输入输出 | 多分类模型读取', '0', '-1', null, '0', '2017-05-16 17:55:43', 'admin', '2017-05-16 17:55:43', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0005', 'IO@Read-Clustering-Model', '输入输出 | 聚类模型读取', '0', '-1', null, '0', '2017-05-16 17:55:43', 'admin', '2017-05-16 17:55:43', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0006', 'IO@Read-Regression-Model', '输入输出 | 回归模型读取', '0', '-1', null, '0', '2017-05-16 17:55:43', 'admin', '2017-05-16 17:55:43', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0007', 'IO@Read-CollaborativeFiltering-Model', '输入输出 | 协同过滤模型读取', '0', '-1', null, '0', '2017-05-16 17:55:43', 'admin', '2017-05-16 17:55:43', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-0008', 'IO@Write-DataTable', '输入输出 | 数据表写入', '0', '-1', '更新到指定数据表名，表不存在自动创建', '0', '2017-05-16 17:52:14', 'admin', '2017-05-16 17:52:14', 'admin');
INSERT INTO `cf_component` VALUES ('IO@COM-9999', 'IO@Import-DataFile', '输入输出 | 数据文件导入（非实验用组件）', '0', '-1', '用于HDFS数据文件和上传数据文件的导入', '0', '2017-05-16 17:52:14', 'admin', '2017-05-16 17:52:14', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0000', 'ML@#MachineLearning', '机器学习 | #机器学习', '5', '-1', null, '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0001', 'ML@LR-TwoClass-Classification', '机器学习 | 逻辑回归二分类算法', '5', '2001', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0002', 'ML@LR-MultipleClass-Classification', '机器学习 | 逻辑回归多分类算法', '5', '3001', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0003', 'ML@RF-TwoClass-Classification', '机器学习 | 随机森林二分类算法', '5', '2002', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0004', 'ML@RF-MultipleClass-Classification', '机器学习 | 随机森林多分类算法', '5', '3002', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0005', 'ML@GBDT-TwoClass-Classification', '机器学习 | GBDT二分类算法', '5', '2003', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0006', 'ML@XGBoost-TwoClass-Classification', '机器学习 | XGBoost二分类算法（待定）', '5', '2005', null, '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0007', 'ML@XGBoost-MultipleClass-Classification', '机器学习 | XGBoost 多分类算法（待定）', '5', '3003', null, '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0008', 'ML@LinearSVM-TwoClass-Classification', '机器学习 | 线性SVM二分类算法', '5', '2004', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0009', 'ML@NaiveBayesian-MultipleClass-Classification', '机器学习 | 朴素贝叶斯多分类算法', '5', '3004', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0010', 'ML@KNN-MultipleClass-Classification', '机器学习 | K近邻多分类算法', '5', '3005', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0011', 'ML@KMeans-Clustering', '机器学习 | K均值聚类算法', '5', '4001', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0012', 'ML@Linear-Regression', '机器学习 | 线性回归算法', '5', '5001', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0013', 'ML@GBDT-Regression', '机器学习 | GBDT回归算法', '5', '5002', null, '0', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0014', 'ML@XGBoost-Regression', '机器学习 | XGBoost回归（待定）', '5', '5003', null, '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0015', 'ML@OneClass-SVM', '机器学习 | 单分类SVM算法（待定）', '5', '1001', null, '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-0016', 'ML@PCA-Based-AnomalyDetection', '机器学习 | 基于PCA异常检测算法（待定）', '5', '1002', null, '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-3001', 'ML@Train-Model', '机器学习 | 模型训练', '5', '-1', '支持回归和分类算法', '0', '2017-05-17 13:48:44', 'admin', '2017-05-17 13:48:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-3002', 'ML@Tune-Model-Hyperparameters', '机器学习 | 模型自动调参', '5', '-1', '支持回归和分类算法', '0', '2017-05-17 13:48:44', 'admin', '2017-05-17 13:48:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-3003', 'ML@Cross-Validation', '机器学习 | 交叉验证', '5', '-1', '支持回归和分类算法', '0', '2017-05-17 13:48:44', 'admin', '2017-05-17 13:48:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-3004', 'ML@Train-Clustering-Model', '机器学习 | 聚类模型训练', '5', '-1', '支持Kmeans', '0', '2017-05-17 13:48:44', 'admin', '2017-05-17 13:48:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-3005', 'ML@Tune-Clustering-Model-Hyperparameters', '机器学习 | 聚类模型自动调参', '5', '-1', '支持Kmeans', '0', '2017-05-17 13:48:44', 'admin', '2017-05-17 13:48:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-3006', 'ML@Train-AnomalyDetection-Model', '机器学习 | 异常检测模型训练（待定）', '5', '-1', '单分类训练集不带标签列', '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-3007', 'ML@Train-ALS-CollaborativeFiltering-Model', '机器学习 | ALS协同过滤模型训练（待定）', '5', '7001', null, '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-6001', 'ML@Auto-GenerationRules', '机器学习 | 自动生成规则（待定）', '5', '-1', null, '-1', '2017-05-17 12:34:44', 'admin', '2017-05-17 12:34:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-6002', 'ML@Apriori-AssociationRules', '机器学习 | Apriori关联规则（待定）', '5', '6001', null, '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-6003', 'ML@FPG-AssociationRules', '机器学习 | FP-Growth关联规则（待定）', '5', '6002', null, '-1', '2017-05-17 13:13:53', 'admin', '2017-05-17 13:13:53', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-8001', 'ML@Prediction', '机器学习 | 预测', '5', '-1', '支持回归和分类算法', '0', '2017-05-17 13:48:44', 'admin', '2017-05-17 13:48:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-8002', 'ML@Clustering-Prediction', '机器学习 | 聚类预测', '5', '-1', null, '0', '2017-05-17 13:48:44', 'admin', '2017-05-17 13:48:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-8003', 'ML@CollaborativeFiltering-Prediction', '机器学习 | 协同过滤预测（待定）', '5', '-1', null, '-1', '2017-05-17 13:48:44', 'admin', '2017-05-17 13:48:44', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-9001', 'ML@OneClass-Classification-Evaluation', '机器学习 | 单分类模型评估（异常检测）', '5', '-1', null, '-1', '2017-05-17 13:40:58', 'admin', '2017-05-17 13:40:58', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-9002', 'ML@TwoClass-Classification-Evaluation', '机器学习 | 二分类模型评估', '5', '-1', null, '0', '2017-05-17 13:40:58', 'admin', '2017-05-17 13:40:58', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-9003', 'ML@MultipleClass-Classification-Evaluation', '机器学习 | 多分类模型评估', '5', '-1', null, '0', '2017-05-17 13:41:51', 'admin', '2017-05-17 13:41:59', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-9004', 'ML@Clustering-Evaluation', '机器学习 | 聚类模型评估', '5', '-1', null, '0', '2017-05-17 13:42:37', 'admin', '2017-05-17 13:42:37', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-9005', 'ML@Regression-Evaluation', '机器学习 | 回归模型评估', '5', '-1', null, '0', '2017-05-17 13:43:11', 'admin', '2017-05-17 13:43:11', 'admin');
INSERT INTO `cf_component` VALUES ('ML@COM-9006', 'ML@CollaborativeFiltering-Evaluation', '机器学习 | 协同过滤模型评估（待定）', '5', '-1', null, '-1', '2017-05-17 13:45:07', 'admin', '2017-05-17 13:45:07', 'admin');
INSERT INTO `cf_component` VALUES ('NA@COM-0000', 'NA@#NetworkAnalysis', '网络分析 | #网络分析', '8', '-1', null, '-1', '2017-05-27 17:47:34', 'admin', '2017-05-27 17:47:34', 'admin');
INSERT INTO `cf_component` VALUES ('SA@COM-0000', 'SA@#StatisticalAnalysis', '统计分析 | #统计分析', '4', '-1', null, '-1', '2017-05-27 16:29:34', 'admin', '2017-05-27 16:29:34', 'admin');
INSERT INTO `cf_component` VALUES ('ST@COM-0000', 'ST@#ScriptTools', '脚本工具 | #脚本工具', '1', '-1', null, '-1', '2017-05-16 17:57:49', 'admin', '2017-05-16 17:57:49', 'admin');
INSERT INTO `cf_component` VALUES ('ST@COM-0001', 'ST@Sql-Script', '脚本工具 | SQL脚本', '1', '-1', null, '0', '2017-05-16 17:57:49', 'admin', '2017-05-16 17:57:49', 'admin');
INSERT INTO `cf_component` VALUES ('ST@COM-0002', 'ST@Python-Script', '脚本工具 | Python脚本（待定）', '1', '-1', null, '-1', '2017-05-16 17:57:49', 'admin', '2017-05-16 17:57:49', 'admin');
INSERT INTO `cf_component` VALUES ('ST@COM-0003', 'ST@R-Script', '脚本工具 | R脚本（待定）', '1', '-1', null, '-1', '2017-05-16 17:57:49', 'admin', '2017-05-16 17:57:49', 'admin');
INSERT INTO `cf_component` VALUES ('TA@COM-0000', 'TA@#TextAnalysis', '文本分析 | #文本分析', '7', '-1', null, '-1', '2017-05-27 17:47:09', 'admin', '2017-05-27 17:47:09', 'admin');
INSERT INTO `cf_component` VALUES ('TS@COM-0000', 'TS@#TimeSeries', '时间序列 | #时间序列', '8', '-1', null, '-1', '2017-05-27 17:47:09', 'admin', '2017-05-27 17:47:09', 'admin');
INSERT INTO `cf_component` VALUES ('WS@COM-0000', 'WS@#WebService', 'Web服务 | #Web服务', '10', '-1', null, '-1', '2017-05-27 17:47:34', 'admin', '2017-05-27 17:47:34', 'admin');
INSERT INTO `cf_component` VALUES ('WS@COM-0001', 'WS@Input-DataFile', 'Web服务 | 数据文件输入（待定）', '10', '-1', '暂时仅支持Parquet格式数据文件', '-1', '2017-05-27 17:47:34', 'admin', '2017-05-27 17:47:34', 'admin');
INSERT INTO `cf_component` VALUES ('WS@COM-0002', 'WS@Output-DataFile', 'Web服务 | 数据文件输出（待定）', '10', '-1', '输出Parquet格式数据文件', '-1', '2017-05-27 17:47:34', 'admin', '2017-05-27 17:47:34', 'admin');
INSERT INTO `cf_component` VALUES ('WS@COM-0003', 'WS@Output-ModelFile', 'Web服务 | 模型文件输出（待定）（通配所有模型）', '10', '-1', '输出平台训练的模型文件', '-1', '2017-05-27 17:47:34', 'admin', '2017-05-27 17:47:34', 'admin');

-- ----------------------------
-- Table structure for dw_data_table
-- ----------------------------
DROP TABLE IF EXISTS `dw_data_table`;
CREATE TABLE `dw_data_table` (
  `TABLE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据表ID',
  `TABLE_NAME` varchar(200) NOT NULL COMMENT '数据表名\r\n            \r\n            普通数据表：由英文字符、数字和下划线组成，起始字符不能为下划线\r\n            临时数据表：tmp$<node_id>_<node_port_id>_<job_id>',
  `TABLE_TYPE` int(11) NOT NULL COMMENT '数据表类型\r\n            0：普通数据表\r\n            1：临时数据表\r\n            2：外部数据表，由在线服务的数据文件输入组件产生，DATA_FILE关联完整文件路径，作业完成时被立即清理',
  `TABLE_SRC` int(11) NOT NULL DEFAULT '0' COMMENT '数据表来源\r\n            0：上传导入数据表\r\n            1：保存临时数据表\r\n            2：任务运行输出',
  `OWNER_DW_ID` bigint(20) NOT NULL COMMENT '所属数据库ID',
  `REL_FLOW_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联工作流ID，无关联实验设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联节点ID，创建数据表的工作流节点，无关联则设为-1',
  `REL_CHAR_ID` varchar(64) NOT NULL DEFAULT '-1' COMMENT '关联特征ID，创建数据表的工作流节点输出特征，无关联则设为-1',
  `REL_TASK_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联任务ID，无关联则设为-1',
  `TABLE_COLUMNS` bigint(20) DEFAULT NULL COMMENT '列数',
  `TABLE_ROWS` bigint(20) DEFAULT NULL COMMENT '行数',
  `DATA_FILE_TYPE` int(11) NOT NULL DEFAULT '1' COMMENT '数据文件类型\r\n            1：Parquet文件格式 ',
  `DATA_FILE_SIZE` bigint(20) DEFAULT NULL COMMENT '文件大小，单位为字节',
  `DATA_FILE` varchar(800) DEFAULT NULL COMMENT '数据文件名，普通数据表存放于数据目录下，临时数据表存放于作业目录下\r\n            \r\n            普通数据表：${DATA_DIR}/table_<table_id>.parquet\r\n            临时数据表：${JOB_DIR}/table_<task_id>_<table_id>.parquet',
  `DATA_SUMMARY_FILE` varchar(800) DEFAULT NULL COMMENT '数据概要文件名，普通数据表存放于数据目录下，临时数据表存放于作业目录下\r\n            \r\n            普通数据表：${DATA_DIR}/table_summary_<table_id>.parquet\r\n            临时数据表：${JOB_DIR}/table_summary_<task_id>_<table_id>.parquet',
  `TABLE_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '数据表状态\r\n            0：空表\r\n            1：正常\r\n            2：仅概要文件',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`TABLE_ID`),
  KEY `Index_1` (`OWNER_DW_ID`,`TABLE_TYPE`,`TABLE_NAME`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_DW_ID`,`TABLE_TYPE`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`OWNER_DW_ID`,`REL_TASK_ID`,`TABLE_STATE`,`STATUS`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8 COMMENT='数据表\r\n\r\n逻辑删除，同一库下正常状态的表名唯一';

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
  `DATA_DFS_DIR` varchar(800) NOT NULL COMMENT 'DFS数据目录，存放普通数据表的数据文件和数据概要文件\r\n            \r\n            ${HDFS_SITE}/${DFS_WORK_ROOT}/dw_data/<dw_code>',
  `DATA_LOCAL_DIR` varchar(800) NOT NULL COMMENT '本地数据目录，缓存普通数据表的数据概要文件\r\n            \r\n            ${LOCAL_WORK_ROOT}/dw_data/<dw_code>',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`DW_ID`),
  KEY `Index_1` (`DW_CODE`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`DW_TYPE`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`DW_NAME`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='数据库表，对数据表做分组，辅助项目权限隔离\r\n\r\n逻辑删除，正常状态的代码唯一和名称唯一';

-- ----------------------------
-- Records of dw_data_warehouse
-- ----------------------------
INSERT INTO `dw_data_warehouse` VALUES ('10000', 'lambda_pub_db', '公共数据库', '0', '-1', '${HDFS_SITE}/${DFS_WORK_ROOT}/dw_data/lambda_pub_db', '${LOCAL_WORK_ROOT}/dw_data/lambda_pub_db', '平台内置公共数据库，唯一', '0', '2018-11-25 18:16:40', 'admin', '2018-11-25 18:16:40', 'admin');

-- ----------------------------
-- Table structure for em_experiment
-- ----------------------------
DROP TABLE IF EXISTS `em_experiment`;
CREATE TABLE `em_experiment` (
  `EXPERIMENT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '实验ID',
  `EXPERIMENT_NAME` varchar(200) NOT NULL COMMENT '实验名称',
  `EXPERIMENT_TYPE` int(11) NOT NULL DEFAULT '0' COMMENT '实验类型\r\n            0：主实验，正常创建实验\r\n            1：预测实验（预留），通过选择主实验中的已训练模型进行自动创建',
  `MAIN_EXPERIMENT_ID` bigint(20) DEFAULT NULL COMMENT '所属主实验ID，主实验设为自身ID',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `SUMMARY` varchar(256) DEFAULT NULL COMMENT '摘要',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`EXPERIMENT_ID`),
  KEY `Index_1` (`OWNER_PROJECT_ID`,`EXPERIMENT_TYPE`,`EXPERIMENT_NAME`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_PROJECT_ID`,`EXPERIMENT_TYPE`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`OWNER_PROJECT_ID`,`EXPERIMENT_TYPE`,`MAIN_EXPERIMENT_ID`,`STATUS`,`CREATE_TIME`)
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
  `TEMPLATE_CONTENT` mediumtext COMMENT '模版内容',
  `TEMPLATE_COUNT` bigint(20) NOT NULL DEFAULT '1000' COMMENT '模版使用计数',
  `SUMMARY` varchar(256) DEFAULT NULL COMMENT '摘要',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
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
  `MODEL_TYPE` int(11) NOT NULL COMMENT '模型类型\r\n            0：普通模型\r\n            1：临时模型\r\n            2：外部模型（预留）',
  `MODEL_SRC` int(11) NOT NULL DEFAULT '0' COMMENT '模型来源\r\n            0：上传导入模型\r\n            1：保存临时模型\r\n            2：任务运行输出',
  `OWNER_MW_ID` bigint(20) NOT NULL COMMENT '所属模型库ID',
  `REL_FLOW_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联工作流ID，无关联实验设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联节点ID，创建模型的工作流节点，无关联则设为-1',
  `REL_CHAR_ID` varchar(64) NOT NULL DEFAULT '-1' COMMENT '关联特征ID，创建模型的工作流节点输出特征，无关联则设为-1',
  `REL_TASK_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联任务ID，无关联则设为-1',
  `REF_ALGORITHM_ID` bigint(20) NOT NULL COMMENT '引用算法ID',
  `MODEL_FILE_SIZE` bigint(20) DEFAULT NULL COMMENT '模型文件大小，单位为字节',
  `MODEL_FILE` varchar(800) DEFAULT NULL COMMENT '模型文件名，普通模型存放于模型目录下，临时模型存放于作业目录下\r\n            \r\n            普通模型：${MODEL_DIR}/model_<model_id>.mdl\r\n            临时模型：${JOB_DIR}/model_<task_id>_<model_id>.mdl',
  `MODEL_SUMMARY_FILE` varchar(800) DEFAULT NULL COMMENT '模型概要文件名，普通模型存放于模型目录下，临时模型存放于作业目录下，记录训练算法参数，训练收敛过程（e.g. LogLoss，AUC），以及其他模型训练相关可以收集到的所有信息\r\n            \r\n            普通模型：${MODEL_DIR}/model_summary_<model_id>.json\r\n            临时模型：${JOB_DIR}/model_summary_<task_id>_<model_id>.json',
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
  KEY `Index_1` (`OWNER_MW_ID`,`MODEL_TYPE`,`MODEL_NAME`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_MW_ID`,`MODEL_TYPE`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`OWNER_MW_ID`,`REL_TASK_ID`,`MODEL_STATE`,`STATUS`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8 COMMENT='模型表，导入外部模型待暂不考虑\r\n\r\n逻辑删除';

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
  `MODEL_DFS_DIR` varchar(800) NOT NULL COMMENT 'DFS模型目录，存放普通模型的模型文件和模型概要文件\r\n            \r\n            ${HDFS_SITE}/${DFS_WORK_ROOT}/mw_model/<mw_code>',
  `MODEL_LOCAL_DIR` varchar(800) NOT NULL COMMENT '本地模型目录，缓存普通模型的模型概要文件\r\n            \r\n            ${LOCAL_WORK_ROOT}/mw_model/<mw_code>',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`MW_ID`),
  UNIQUE KEY `Index_1` (`MW_NAME`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`MW_TYPE`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`MW_CODE`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模型库表，对模型做分组，辅助项目权限隔离\r\n\r\n逻辑删除，正常状态的代码唯一和名称唯一';

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
  `CACHE_EXPIRE_DAYS` int(11) NOT NULL DEFAULT '14' COMMENT '临时数据表过期天数，每天2点扫描清理，另外提供主动清理接口，不做自动清理可配置为-1',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PROJECT_ID`),
  KEY `Index_1` (`PROJECT_CODE`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`PROJECT_NAME`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB AUTO_INCREMENT=100092 DEFAULT CHARSET=utf8 COMMENT='项目表\r\n\r\n逻辑删除，正常状态的代码唯一和名称唯一';

-- ----------------------------
-- Records of pr_project
-- ----------------------------
INSERT INTO `pr_project` VALUES ('10002', 'XXOO', 'Alpha', '999', '999', '21', null, '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project` VALUES ('10003', 'XXOO1', 'Alpha1', '9992', '9991', '21', 'lock', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project` VALUES ('10004', 'XXOO2', 'Alpha2', '9992', '9992', '21', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project` VALUES ('10005', 'XXOO3', 'Alpha3', '9993', '9993', '21', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project` VALUES ('10006', 'XXOO4', 'Alpha4', '999', '999', '21', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project` VALUES ('10007', 'XXOO5', 'Alpha5', '9991', '9991', '21', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project` VALUES ('10008', 'XXOO6', 'Alpha6', '9992', '9992', '21', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project` VALUES ('10009', 'XXOO7', 'Alpha7', '9993', '9993', '21', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project` VALUES ('100021', 'XXOO1', 'Alpha1', '999', '999', '21', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project` VALUES ('100031', 'XXOO11', 'Alpha11', '9991', '9991', '21', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project` VALUES ('100041', 'XXOO21', 'Alpha21', '9992', '9992', '21', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project` VALUES ('100051', 'XXOO31', 'Alpha31', '9993', '9993', '21', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project` VALUES ('100061', 'XXOO41', 'Alpha41', '999', '999', '21', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project` VALUES ('100071', 'XXOO51', 'Alpha51', '9991', '9991', '21', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project` VALUES ('100081', 'XXOO61', 'Alpha61', '9992', '9992', '21', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project` VALUES ('100091', 'XXOO71', 'Alpha71', '9993', '9993', '21', '是龙卷风萨拉大坑副将哎算了废旧塑料', '0', '2018-12-03 15:26:58', 'admin', '2018-12-03 14:37:19', 'admin');

-- ----------------------------
-- Table structure for pr_project_member
-- ----------------------------
DROP TABLE IF EXISTS `pr_project_member`;
CREATE TABLE `pr_project_member` (
  `PROJECT_ID` bigint(20) NOT NULL COMMENT '项目ID',
  `PROJECT_ROLE` int(11) DEFAULT '0' COMMENT '是否为项目所有者\r\n            0：一般成员（multiple）\r\n            1：项目所有者（only one）\r\n            2：项目维护者（multiple）',
  `MEMBER_USER` varchar(100) NOT NULL COMMENT '项目成员用户名',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  KEY `Index_1` (`MEMBER_USER`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`PROJECT_ID`,`MEMBER_USER`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目成员表\r\n\r\n逻辑删除，正常状态的项目和用户唯一';

-- ----------------------------
-- Records of pr_project_member
-- ----------------------------
INSERT INTO `pr_project_member` VALUES ('10002', '0', 'admin', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project_member` VALUES ('10003', '0', 'admin', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project_member` VALUES ('10004', '0', 'admin', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project_member` VALUES ('10005', '0', 'admin', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project_member` VALUES ('10006', '0', 'admin', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project_member` VALUES ('10007', '0', 'admin', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project_member` VALUES ('10008', '0', 'admin', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project_member` VALUES ('10009', '0', 'admin', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project_member` VALUES ('100021', '0', 'admin', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project_member` VALUES ('100031', '0', 'admin', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project_member` VALUES ('100041', '0', 'admin', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project_member` VALUES ('100051', '0', 'admin', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project_member` VALUES ('100061', '0', 'admin', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project_member` VALUES ('100071', '0', 'admin', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project_member` VALUES ('100081', '0', 'admin', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');
INSERT INTO `pr_project_member` VALUES ('100091', '0', 'admin', '', '0', '2018-12-03 14:37:19', 'admin', '2018-12-03 14:37:19', 'admin');

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
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PARAM_ID`),
  UNIQUE KEY `Index_1` (`PARAM_CODE`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB AUTO_INCREMENT=7018 DEFAULT CHARSET=utf8 COMMENT='系统参数表\r\n\r\n逻辑删除，正常状态的代码唯一';

-- ----------------------------
-- Records of sys_parameter
-- ----------------------------
INSERT INTO `sys_parameter` VALUES ('2001', 'PR_CACHE_DATA_EXPIRE_DAYS', '项目管理 | 临时缓存数据表过期天数', '2', '-1', '21', '系统级默认过期天数配置，不做自动清理可配置为-1', '0', '2017-05-19 15:09:42', 'admin', '2017-05-19 15:09:42', 'admin');
INSERT INTO `sys_parameter` VALUES ('6001', 'WK_FLOW_MAX_NODES', '工作流引擎 | 工作流正常节点最大数量', '6', '-1', '512', '超过上限，限制新增节点', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('6002', 'WK_FLOW_SCHEMA_MAX_FIELDS', '工作流引擎 | 数据输出端口最大字段数量', '6', '-1', '512', '超过上限，中断schema分析', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('6003', 'WK_FLOW_MAX_GLOBAL_PARAMETERS', '工作流引擎 | 工作流最大全局参数数量', '6', '-1', '16', '超过上限，限制新增全局参数', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7001', 'CF_HDFS_SITE_defaultFS', '计算框架 | HDFS默认文件系统', '7', '-1', 'hdfs://127.0.0.1:9000', 'namenode单点部署设为hdfs://IP:PORT，HA部署设为hdfs://CLUSTER_NAME', '0', '2017-05-19 15:09:42', 'admin', '2017-05-19 15:09:42', 'admin');
INSERT INTO `sys_parameter` VALUES ('7002', 'CF_HDFS_WORK_ROOT', '计算框架 | HDFS工作根目录', '7', '-1', '/user/lambda_mls', '根据hdfs用户名调整，完整拼接路径 e.g. ${HDFS_SITE}/user/lambda_mls', '0', '2017-05-19 15:26:23', 'admin', '2017-05-19 15:26:23', 'admin');
INSERT INTO `sys_parameter` VALUES ('7003', 'CF_LOCAL_WORK_ROOT', '计算框架 | 本地工作根目录', '7', '-1', '/opt/lambda_mls', '根据实际磁盘挂载调整', '0', '2017-05-19 15:26:23', 'admin', '2017-05-19 15:26:23', 'admin');
INSERT INTO `sys_parameter` VALUES ('7004', 'CF_JOB_FILE_DIR_NAME', '计算框架 | 作业文件存放目录名', '7', '-1', 'proc', '切勿随意调整，完整拼接路径e.g. ${WORK_ROOT}/proc', '0', '2017-05-19 15:42:06', 'admin', '2017-05-19 15:42:06', 'admin');
INSERT INTO `sys_parameter` VALUES ('7005', 'CF_DATA_FILE_DIR_NAME', '计算框架 | 数据文件存放目录名', '7', '-1', 'dw_data', '切勿随意调整，完整拼接路径e.g. ${WORK_ROOT}/dw_data', '0', '2017-05-19 15:48:43', 'admin', '2017-05-19 15:48:43', 'admin');
INSERT INTO `sys_parameter` VALUES ('7006', 'CF_MODEL_FILE_DIR_NAME', '计算框架 | 模型文件存放目录名', '7', '-1', 'mw_data', '切勿随意调整，完整拼接路径e.g. ${WORK_ROOT}/mw_data', '0', '2017-05-19 15:49:41', 'admin', '2017-05-19 15:49:41', 'admin');
INSERT INTO `sys_parameter` VALUES ('7007', 'CF_FLOW_FILE_DIR_NAME', '计算框架 | 工作流文件存放目录名', '7', '-1', 'flow_data', '切勿随意调整，完整拼接路径e.g. ${WORK_ROOT}/flow_data，目前仅本地', '0', '2017-05-19 15:46:12', 'admin', '2017-05-19 15:46:12', 'admin');
INSERT INTO `sys_parameter` VALUES ('7008', 'CF_LIB_FILE_DIR_NAME', '计算框架 | 库文件存放目录名', '7', '-1', 'lib', '切勿随意调整，完整拼接路径e.g. ${WORK_ROOT}/lib，启动时自动同步本地到hdfs上，先清理再上传', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7010', 'CF_HDFS_COMPONENT_JAR_DIR', '计算框架 | hdfs scala组件jar包目录', '7', '-1', '/user/lambda_mls/lib/spark', '根据hdfs用户名调整，完整拼接路径 e.g. ${HDFS_SITE}/user/lambda/lib/scala', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7011', 'CF_HDFS_COMPONENTT_JAR_FILE', '计算框架 | hdfs scala组件jar包文件名', '7', '-1', 'lambda-component-1.0.0.jar', 'scala组件暂时只打成一个jar包，后续有需要再拆分', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7012', 'CF_SPARK_EXECUTOR_NUMBER', '计算框架 | spark executor数量', '7', '-1', '2', '灵活调整组件规格默认配置，覆盖组件特征上的默认值', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7013', 'CF_SPARK_EXECUTOR_CORES', '计算框架 | spark executor线程数量', '7', '-1', '8', '灵活调整组件规格默认配置，覆盖组件特征上的默认值', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7014', 'CF_SPARK_EXECUTOR_MEMORY', '计算框架 | spark executor内存大小', '7', '-1', '2048', '灵活调整组件规格默认配置，覆盖组件特征上的默认值', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7015', 'CF_SPARK_DRIVER_CORES', '计算框架 | spark driver线程数量', '7', '-1', '8', '灵活调整组件规格默认配置，覆盖组件特征上的默认值', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7016', 'CF_SPARK_DRIVER_MEMORY', '计算框架 | spark driver内存大小', '7', '-1', '2048', '灵活调整组件规格默认配置，覆盖组件特征上的默认值', '0', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');
INSERT INTO `sys_parameter` VALUES ('7017', 'CF_SPARK_EXTRA_CONFIGURATION', '计算框架 | spark 额外配置', '7', '-1', '预留', '灵活调整组件规格默认配置，覆盖组件特征上的默认值', '-1', '2017-05-19 15:22:08', 'admin', '2017-05-19 15:22:08', 'admin');

-- ----------------------------
-- Table structure for wf_code_script
-- ----------------------------
DROP TABLE IF EXISTS `wf_code_script`;
CREATE TABLE `wf_code_script` (
  `SCRIPT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '脚本ID',
  `SCRIPT_NAME` varchar(200) NOT NULL COMMENT '脚本名称\r\n            \r\n            由工作流创建：<module_code>_<node_id>_<char_id>_<snapshot_version>',
  `SCRIPT_TYPE` int(11) NOT NULL COMMENT '脚本类型\r\n            1：SQL脚本\r\n            2：Python脚本（预留）\r\n            3：R脚本（预留）\r\n            4：特征抽取脚本（预留）',
  `SCRIPT_SRC` int(11) NOT NULL DEFAULT '0' COMMENT '脚本来源\r\n            0：作业运行\r\n            1：实验编辑',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `REL_FLOW_ID` bigint(20) NOT NULL COMMENT '关联工作流ID，无关联工作流设为-1',
  `REL_SNAPSHOT_VERSION` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联快照版本，取FLOW表的NEXT_SNAPSHOT_VERSION值，无关联则设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联节点ID，创建脚本的工作流节点，无关联则设为-1',
  `REL_CHAR_ID` varchar(64) NOT NULL DEFAULT '-1' COMMENT '关联特征ID，创建脚本的工作流节点输出特征，无关联则设为-1',
  `REL_TASK_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联任务ID，无关联则设为-1',
  `SCRIPT_CONTENT` mediumtext COMMENT '脚本内容',
  `SCRIPT_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '脚本状态\r\n            0：空脚本\r\n            1：正常',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SCRIPT_ID`),
  KEY `Index_1` (`OWNER_PROJECT_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_PROJECT_ID`,`SCRIPT_TYPE`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8 COMMENT='代码脚本表';

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
  `REL_FLOW_ID` bigint(20) NOT NULL COMMENT '关联工作流ID，无关联工作流设为-1',
  `REL_SNAPSHOT_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联快照ID，无关联则设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL COMMENT '关联节点ID，填写与触发运行相关的节点ID，无关联则设为-1',
  `JOB_CONTENT` mediumtext COMMENT '作业内容',
  `JOB_DFS_DIR` varchar(800) DEFAULT NULL COMMENT 'DFS作业目录\r\n            \r\n            实验作业：${HDFS_SITE}/${DFS_WORK_ROOT}/proc/<project_id>/<experiment_id>/<job_id>\r\n            其他作业：${HDFS_SITE}/${DFS_WORK_ROOT}/proc<project_id>/other/<job_id>',
  `JOB_LOCAL_DIR` varchar(800) DEFAULT NULL COMMENT '本地作业目录（预留）\r\n            \r\n            实验作业：${LOCAL_WORK_ROOT}/proc/<project_id>/<experiment_id>/<job_id>\r\n            其他作业：${LOCAL_WORK_ROOT}/proc/<project_id>/other/<job_id>',
  `NEXT_TASK_SEQUENCE` bigint(20) NOT NULL DEFAULT '1' COMMENT '下一任务序号',
  `JOB_SUBMIT_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '作业提交时间（提交队列）',
  `JOB_START_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '作业开始时间',
  `JOB_END_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '作业结束时间',
  `JOB_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '作业状态\r\n            0：preparing，准备中\r\n            1：queueing，排队中\r\n            2：running，运行中\r\n            3：finished，运行完成\r\n            4：error terminated，出错终止\r\n            5：user terminated，用户终止',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`JOB_ID`),
  KEY `Index_1` (`OWNER_PROJECT_ID`,`REL_FLOW_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_PROJECT_ID`,`JOB_TYPE`,`STATUS`,`CREATE_TIME`)
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
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `JOB_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作业时间\r\n            \r\n            指定作业的开始处理时间，值来自进入队列时和继续执行时',
  `JOB_SIGNAL` int(11) NOT NULL DEFAULT '0' COMMENT '作业信号\r\n            0：SIG_NORMAL，正常作业信号\r\n            1：SIG_KILL，终止作业信号\r\n            2：SIG_PAUSE，暂停执行信号\r\n            3：SIG_CONT，继续执行信号',
  `JOB_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '作业状态\r\n            1：queueing，排队中\r\n            2：processing，处理中',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`JOB_ID`),
  KEY `Index_1` (`JOB_STATE`,`JOB_SIGNAL`,`JOB_TIME`),
  KEY `Index_2` (`OWNER_PROJECT_ID`,`JOB_STATE`,`CREATE_TIME`),
  KEY `Index_3` (`JOB_STATE`,`JOB_TIME`)
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
  `ENGINE_TYPE` varchar(200) DEFAULT 'unknown' COMMENT '计算引擎',
  `EXTERNAL_ID` varchar(800) DEFAULT NULL COMMENT '外部任务ID，比如yarn的application id',
  `TASK_CONTENT` mediumtext COMMENT '任务内容',
  `SUBMIT_FILE` varchar(800) DEFAULT NULL COMMENT '提交文件名，存放在运行目录下\r\n            \r\n            ${JOB_DIR}/submit_<task_id>_<module_code>.json',
  `RETURN_FILE` varchar(800) DEFAULT NULL COMMENT '返回文件名，存放在运行目录下\r\n            \r\n            ${JOB_DIR}/return_<task_id>_<module_code>.json',
  `LOG_FILE` varchar(800) DEFAULT NULL COMMENT '日志文件名，存放在运行目录下\r\n            \r\n            ${JOB_DIR}/log_<task_id>_<module_code>.log',
  `COST_TIME` bigint(20) DEFAULT NULL COMMENT '运行耗时，单位毫秒',
  `TASK_START_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '任务开始时间',
  `TASK_END_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '任务结束时间',
  `TASK_PROGRESS` int(11) NOT NULL DEFAULT '0' COMMENT '任务进度，百分比数值0到100',
  `WARNING_MSG` varchar(512) DEFAULT NULL COMMENT '警告消息',
  `TASK_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '任务状态\r\n            0：preparing，准备中\r\n            1：ready，已就绪\r\n            2：running，运行中\r\n            3：finished，运行完成\r\n            4：error terminated，出错终止\r\n            5：user terminated，用户终止',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`TASK_ID`),
  UNIQUE KEY `Index_1` (`OWNER_JOB_ID`,`REL_NODE_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_JOB_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`OWNER_JOB_ID`,`TASK_STATE`,`SEQUENCE`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8 COMMENT='工作流运行任务表';

-- ----------------------------
-- Records of wf_execution_task
-- ----------------------------

-- ----------------------------
-- Table structure for wf_execution_task_output
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution_task_output`;
CREATE TABLE `wf_execution_task_output` (
  `TASK_ID` bigint(20) NOT NULL COMMENT '节点ID',
  `CHAR_ID` varchar(64) NOT NULL COMMENT '组件特征ID',
  `CHAR_VALUE` varchar(2000) DEFAULT NULL COMMENT '特征值',
  `OUTPUT_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '输出状态\r\n            0：空输出\r\n            1：正常',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  KEY `Index_1` (`TASK_ID`,`CHAR_ID`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流运行任务输出表，记录输出内容的特征值';

-- ----------------------------
-- Records of wf_execution_task_output
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow`;
CREATE TABLE `wf_flow` (
  `FLOW_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '工作流ID，同实验ID值',
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
  `FLOW_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '工作流状态\r\n            0：draft，草稿\r\n            1：preparing，准备中\r\n            2：running，运行中\r\n            3：finished running，运行结束',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
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
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  KEY `Index_1` (`FLOW_ID`,`MODULE_ID`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流累计表，记录每个flow使用过的module计数';

-- ----------------------------
-- Records of wf_flow_accumulate
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
  `REL_CHAR_ID` varchar(64) NOT NULL COMMENT '关联组件特征ID',
  `DEFAULT_VALUE` varchar(2000) NOT NULL COMMENT '默认值',
  `WARNING_MSG` varchar(256) DEFAULT NULL COMMENT '警告消息',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`GLOBAL_PARAM_ID`),
  KEY `Index_1` (`REL_NODE_ID`,`REL_CHAR_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`REL_NODE_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`REL_FLOW_ID`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流全局参数表，用于定时调度任务和开放服务API，指定哪些参数可以暴露到外部，从而调用方可以根据作业需要动态设置工作流';

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
  `OWNER_FLOW_ID` bigint(20) NOT NULL COMMENT '所属工作流ID',
  `REF_MODULE_ID` bigint(20) NOT NULL COMMENT '引用工作流组件ID',
  `SEQUENCE` bigint(20) NOT NULL DEFAULT '0' COMMENT '序号',
  `POSITION_X` bigint(20) NOT NULL DEFAULT '0' COMMENT '流程图节点X轴坐标',
  `POSITION_Y` bigint(20) NOT NULL DEFAULT '0' COMMENT '流程图节点Y轴坐标',
  `LAST_TASK_ID` bigint(20) DEFAULT NULL COMMENT '最后任务ID',
  `WARNING_MSG` varchar(512) DEFAULT NULL COMMENT '警告消息',
  `NODE_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '节点状态\r\n            0：not ready，未就绪\r\n            1：ready，已就绪\r\n            2：preparing，准备中\r\n            3：running，运行中\r\n            4：success，运行成功\r\n            5：error，运行出错',
  `COMMENT` varchar(800) DEFAULT NULL COMMENT '备注，人工编辑',
  `SUMMARY` varchar(800) DEFAULT NULL COMMENT '概要，自动生成',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_ID`),
  KEY `Index_1` (`OWNER_PROJECT_ID`,`REF_MODULE_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_FLOW_ID`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8 COMMENT='工作流节点表';

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
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
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
  `IS_WEB_LINK` int(11) NOT NULL DEFAULT '0' COMMENT '是否为web组件的流出链接\r\n            0：否\r\n            1：是',
  `SRC_NODE_ID` bigint(20) NOT NULL COMMENT '流出节点ID',
  `SRC_PORT_ID` bigint(20) NOT NULL COMMENT '流出节点端口ID',
  `DST_NODE_ID` bigint(20) NOT NULL COMMENT '流入节点ID',
  `DST_PORT_ID` bigint(20) NOT NULL COMMENT '流入节点端口ID',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`LINK_ID`),
  KEY `Index_1` (`OWNER_FLOW_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`SRC_NODE_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_3` (`DST_NODE_ID`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8 COMMENT='工作流节点链接表\r\n\r\n逻辑删除，同一节点流入端口下正常状态的普通组件流出节点端口唯一和web服务组';

-- ----------------------------
-- Records of wf_flow_node_link
-- ----------------------------

-- ----------------------------
-- Table structure for wf_flow_node_parameter
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_parameter`;
CREATE TABLE `wf_flow_node_parameter` (
  `NODE_ID` bigint(20) NOT NULL COMMENT '节点ID',
  `SPEC_TYPE` int(11) NOT NULL COMMENT '规格类型，说明参考CF_CMPT_SPEC.SPEC_TYPE\r\n            节点上只设置组件参数和调优执行',
  `CHAR_ID` varchar(64) NOT NULL COMMENT '组件特征ID',
  `CHAR_VALUE` varchar(2000) DEFAULT NULL COMMENT '特征值',
  `IS_GLOBAL_PARAMETER` int(11) NOT NULL DEFAULT '0' COMMENT '是否为全局参数\r\n            0：否\r\n            1：是',
  `LAST_GLOBAL_PARAMETER_ID` bigint(20) DEFAULT NULL COMMENT '最后全局参数ID',
  `IS_DUPLICATED` int(11) NOT NULL DEFAULT '0' COMMENT '是否被复制\r\n            0：否\r\n            1：是\r\n            \r\n            创建快照和运行任务时对象数据类型会以浅拷贝方式复制，同时该标记会被置位，辅助于对象类型特征值发生更新时，判断是否创建新对象来保存新值',
  `WARNING_MSG` varchar(256) DEFAULT NULL COMMENT '警告消息',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
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
  `REF_CHAR_ID` varchar(64) NOT NULL COMMENT '引用组件端口ID',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
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
  `SCHEMA_NAME` varchar(200) NOT NULL COMMENT 'Schema名称，自动生成',
  `OWNER_NODE_ID` bigint(20) NOT NULL COMMENT '所属节点ID',
  `OBJECT_ID` bigint(20) DEFAULT NULL COMMENT 'json对象ID',
  `SCHEMA_STATE` int(11) NOT NULL DEFAULT '0' COMMENT 'schema状态\r\n            0：空schema\r\n            1：正常\r\n            2：不支持\r\n            3：超限中断',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
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
  `OBJECT_NAME` varchar(200) NOT NULL COMMENT '对象名称\r\n            \r\n            普通对象：object_<node_id>_<char_id>_<snapshot_version> \r\n            算法参数：algorithm_parameters_<node_id>_<char_id>_<job_id>\r\n            模型评估报告：model_evaluation_report_<node_id>_<char_id>_<job_id>\r\n            统计分析报告：statisticsl_analysis_report_<node_id>_<char_id>_<job_id>\r\n            自动调参报告：tune_parameters_<node_id>_<char_id>_<job_id>\r\n            生成规则报告：generate_rules_<node_id>_<char_id>_<job_id>\r\n            输出端口schema：output_port_schema_<node_id>_<char_id>',
  `OBJECT_TYPE` int(11) NOT NULL COMMENT '对象类型\r\n            0：JsonObject&JsonArray（组件参数，仅存放于OBJECT_DATA）\r\n            1：算法参数（输出内容，仅存放于OBJECT_DATA）\r\n            2：模型评估报告（输出内容，存放于文件系统）\r\n            3：交叉验证报告（输出内容，存放于文件系统）\r\n            4：统计分析报告（输出内容，存放于文件系统）\r\n            5：自动调参报告（输出内容，存放于文件系统）\r\n            6：生成规则报告（输出内容，存放于文件系统）\r\n            99：输出端口schema（端口信息，仅存放于OBJECT_DATA）',
  `OBJECT_SRC` int(11) NOT NULL DEFAULT '0' COMMENT '对象来源\r\n            0：作业运行\r\n            1：实验编辑',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `REL_FLOW_ID` bigint(20) NOT NULL COMMENT '关联工作流ID，无关联工作流设为-1',
  `REL_SNAPSHOT_VERSION` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联快照版本，取FLOW表的NEXT_SNAPSHOT_VERSION值，无关联则设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联节点ID，创建脚本的工作流节点，无关联则设为-1',
  `REL_CHAR_ID` varchar(64) NOT NULL DEFAULT '-1' COMMENT '关联特征ID，创建脚本的工作流节点输出特征，无关联则设为-1',
  `REL_TASK_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联任务ID，无关联则设为-1',
  `STORAGE_LOCATION` int(11) NOT NULL DEFAULT '0' COMMENT '存储位置\r\n            \r\n            0：OBJECT_DATA字段\r\n            1：文件系统',
  `OBJECT_DATA` mediumtext COMMENT 'JSON数据',
  `OBJECT_FILE` varchar(800) DEFAULT NULL COMMENT '对象文件名\r\n            \r\n            算法参数：${JOB_DIR}/algorithm_parameters_<json_id>.json（预留）\r\n            模型评估报告：${JOB_DIR}/model_evaluation_report_<json_id>.json\r\n            统计分析报告：${JOB_DIR}/statistics_analysis_report_<json_id>.json\r\n            自动调参报告：${JOB_DIR}/tune_parameters_report_<json_id>.json\r\n            生成规则报告：${JOB_DIR}/generate_rules_report_<json_id>.json\r\n            输出端口schema：${FLOW_DIR}/outport_schema_<json_id>.json（预留）',
  `OBJECT_STATE` int(11) NOT NULL DEFAULT '0' COMMENT 'JSON数据状态\r\n            0：空对象\r\n            1：正常',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`OBJECT_ID`),
  KEY `Index_1` (`OWNER_PROJECT_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_PROJECT_ID`,`OBJECT_TYPE`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8 COMMENT='JSON对象表';

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
  `MODULE_TYPE` int(11) NOT NULL COMMENT '组件类型\r\n0：普通工作流组件（可拖拽到画布中）\r\n1：不进工作流组件（不可托到画布中，封装的计算组件无输入内容，无输出端口）',
  `CATALOG_ID` bigint(20) NOT NULL DEFAULT '0' COMMENT '所属目录ID，不进目录设为-1',
  `SEQUENCE` int(11) NOT NULL COMMENT '排序序号',
  `CATEGORY` varchar(200) DEFAULT NULL COMMENT '组件类别（预留），自定义类别',
  `ICON_TYPE` int(11) NOT NULL COMMENT '图标类型',
  `CLASS_PATH` varchar(200) NOT NULL COMMENT '组件java类class path',
  `PKG_CMPT_ID` varchar(64) NOT NULL COMMENT '所封装的计算组件ID',
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
INSERT INTO `wf_module` VALUES ('1', 'ReadDataTable', '读数据表', '0', '1', '0', 'source', '0', 'ReadDataTable.class', '1', null, '0', '2017-05-27 16:11:04', 'admin', '2017-05-27 16:11:04', 'admin');
INSERT INTO `wf_module` VALUES ('2', 'ReadModel', '读模型', '0', '1', '1', 'source', '0', 'ReadModel.class', '2', null, '0', '2017-05-27 16:13:58', 'admin', '2017-05-27 16:13:58', 'admin');
INSERT INTO `wf_module` VALUES ('3', 'WriteDataTable', '写数据表', '0', '1', '2', 'destination', '0', 'WriteDataTable.class', '3', null, '0', '2017-05-27 16:11:04', 'admin', '2017-05-27 16:11:04', 'admin');
INSERT INTO `wf_module` VALUES ('4', 'SqlScript', 'SQL脚本', '0', '2', '0', 'user_code', '0', 'SqlScript.class', '1000', null, '0', '2017-05-27 16:18:13', 'admin', '2017-05-27 16:18:13', 'admin');
INSERT INTO `wf_module` VALUES ('5', 'LogisticRegression_Binary', '逻辑回归二分类', '0', '11', '0', 'training', '0', 'LogisticRegressionBinaryClassification.class', '5001', null, '0', '2017-05-27 16:43:05', 'admin', '2017-05-27 16:43:05', 'admin');
INSERT INTO `wf_module` VALUES ('6', 'RandomForest_Binary', '随机森林二分类', '0', '11', '1', 'training', '0', 'RandomForestClassification.class', '5003', null, '0', '2017-05-27 16:49:30', 'admin', '2017-05-27 16:49:30', 'admin');
INSERT INTO `wf_module` VALUES ('7', 'GBDT_Binary', 'GBDT二分类', '0', '11', '2', 'training', '0', 'GradientBoostingDecisionTreeBinaryClassification.class', '5004', null, '0', '2017-05-27 16:50:15', 'admin', '2017-05-27 16:50:15', 'admin');
INSERT INTO `wf_module` VALUES ('8', 'LinearSVM', '线性支持向量机', '0', '11', '3', 'training', '0', 'LinearSupportVectorMachineBinaryClassification.class', '5005', null, '0', '2017-05-27 16:51:14', 'admin', '2017-05-27 16:51:14', 'admin');
INSERT INTO `wf_module` VALUES ('9', 'LogisticRegression_Multiple', '逻辑回归多分类', '0', '12', '4', 'training', '0', 'LogisticRegressionMultipleClassification.class', '5002', null, '0', '2017-05-27 16:44:06', 'admin', '2017-05-27 16:44:06', 'admin');
INSERT INTO `wf_module` VALUES ('10', 'RandomForest_Multiple', '随机森林多分类', '0', '12', '1', 'training', '0', 'RandomForestClassification.class', '5003', null, '0', '2017-05-27 16:49:30', 'admin', '2017-05-27 16:49:30', 'admin');
INSERT INTO `wf_module` VALUES ('11', 'NaiveBayesian', '朴素贝叶斯', '0', '12', '2', 'training', '0', 'NaiveBayesianMultipleClassification.class', '5006', null, '0', '2017-05-27 16:52:06', 'admin', '2017-05-27 16:52:06', 'admin');
INSERT INTO `wf_module` VALUES ('12', 'KNN', 'K近邻（无模型保存，直接预测）', '0', '12', '3', 'training', '0', 'KNearestNeighborsMultipleClassification.class', '5007', null, '-1', '2017-05-27 16:53:28', 'admin', '2017-05-27 16:53:28', 'admin');
INSERT INTO `wf_module` VALUES ('13', 'KMeans', 'K均值（输入输出项待定）', '0', '13', '0', 'training', '0', 'KMeansClustering.class', '5100', null, '-1', '2017-05-27 17:25:18', 'admin', '2017-05-27 17:25:18', 'admin');
INSERT INTO `wf_module` VALUES ('14', 'Linear_Regression', '线性回归', '0', '14', '0', 'training', '0', 'LinearRegression.class', '5200', null, '0', '2017-05-27 17:26:08', 'admin', '2017-05-27 17:26:08', 'admin');
INSERT INTO `wf_module` VALUES ('15', 'GBDT_Regression', 'GBDT回归', '0', '14', '1', 'training', '0', 'GradientBoostingDecisionTreeRegression.class', '5201', null, '0', '2017-05-27 17:27:30', 'admin', '2017-05-27 17:27:30', 'admin');
INSERT INTO `wf_module` VALUES ('16', 'BinaryClassificationEvaluation', '二分类评估', '0', '17', '0', 'evaluation', '0', 'BinaryClassificationEvaluation', '5901', null, '0', '2017-05-27 17:38:00', 'admin', '2017-05-27 17:38:00', 'admin');
INSERT INTO `wf_module` VALUES ('17', 'MultipleClassificationEvaluation', '多分类评估', '0', '17', '1', 'evaluation', '0', 'MultipleClassificationEvaluation', '5902', null, '0', '2017-05-27 17:38:38', 'admin', '2017-05-27 17:38:38', 'admin');
INSERT INTO `wf_module` VALUES ('18', 'ClusteringEvaluation', '聚类模型评估', '0', '17', '2', 'evaluation', '0', 'ClusteringEvaluation', '5903', null, '0', '2017-05-27 17:39:13', 'admin', '2017-05-27 17:39:13', 'admin');
INSERT INTO `wf_module` VALUES ('19', 'RegressionEvaluation', '回归模型评估', '0', '17', '3', 'evaluation', '0', 'RegressionEvaluation', '5904', null, '0', '2017-05-27 17:39:48', 'admin', '2017-05-27 17:39:48', 'admin');
INSERT INTO `wf_module` VALUES ('20', 'Prediction', '预测', '0', '6', '0', 'prediction', '0', 'Prediction', '5900', null, '0', '2017-05-27 17:37:12', 'admin', '2017-05-27 17:37:12', 'admin');
INSERT INTO `wf_module` VALUES ('21', 'SmartRules', '智能规则', '0', '6', '1', '0', '0', 'SmartRules', '5999', null, '0', '2017-05-27 17:42:51', 'admin', '2017-05-27 17:42:51', 'admin');

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
INSERT INTO `wf_module_catalog` VALUES ('0', 'RootCategory', '根目录', '-1', '0', '0', 'menu', '节点目录根目录', '0', '2017-06-06 16:09:16', 'admin', '2017-06-06 16:09:16', 'admin');
INSERT INTO `wf_module_catalog` VALUES ('1', 'SourceDestination', '源 / 目标', '0', '0', '0', 'source_destination', '数据表的输入源和输出目标', '0', '2017-05-27 15:08:17', 'admin', '2017-05-27 15:08:17', 'admin');
INSERT INTO `wf_module_catalog` VALUES ('2', 'UserCode', '脚本工具', '0', '1', '0', 'user_code', 'SQL、Python、R等多种脚本支持', '0', '2017-05-27 15:18:10', 'admin', '2017-05-27 15:18:03', 'admin');
INSERT INTO `wf_module_catalog` VALUES ('3', 'DataPreprocessing', '数据预处理', '0', '2', '0', 'process', '数据预处理', '-1', '2017-05-27 15:25:40', 'admin', '2017-05-27 15:25:40', 'admin');
INSERT INTO `wf_module_catalog` VALUES ('4', 'FeatureEngineering', '特征工程', '0', '3', '0', 'process', '特征工程', '-1', '2017-05-27 15:27:10', 'admin', '2017-05-27 15:27:10', 'admin');
INSERT INTO `wf_module_catalog` VALUES ('5', 'Analytics', '统计分析', '0', '4', '0', 'analytics', '统计分析', '-1', '2017-05-27 15:28:10', 'admin', '2017-05-27 15:28:10', 'admin');
INSERT INTO `wf_module_catalog` VALUES ('6', 'MachineLearning', '机器学习', '0', '5', '0', 'training', '算法建模', '0', '2017-05-27 17:55:44', 'admin', '2017-05-27 17:55:41', 'admin');
INSERT INTO `wf_module_catalog` VALUES ('7', 'DeepLearning', '深度学习', '0', '6', '0', 'process', '深度学习', '-1', '2017-05-27 17:56:16', 'admin', '2017-05-27 17:56:16', 'admin');
INSERT INTO `wf_module_catalog` VALUES ('8', 'NaturalLanguageProcessing', '文本分析', '0', '7', '0', 'process', '文本分析', '-1', '2017-05-27 17:56:55', 'admin', '2017-05-27 17:56:55', 'admin');
INSERT INTO `wf_module_catalog` VALUES ('9', 'NetworkAnalysis', '网络分析', '0', '8', '0', 'process', '网络分析', '-1', '2017-05-27 17:57:23', 'admin', '2017-05-27 17:57:23', 'admin');
INSERT INTO `wf_module_catalog` VALUES ('10', 'StreamProcessing', '流式处理', '0', '9', '0', 'process', '流式处理', '-1', '2017-05-27 17:57:53', 'admin', '2017-05-27 17:57:53', 'admin');
INSERT INTO `wf_module_catalog` VALUES ('11', 'BinaryClassification', '二分类', '6', '0', '0', 'training', '二分类算法', '0', '2017-05-31 14:32:08', 'admin', '2017-05-31 14:32:08', 'admin');
INSERT INTO `wf_module_catalog` VALUES ('12', 'MultipleClassification', '多分类', '6', '1', '0', 'training', '多分类算法', '0', '2017-05-31 14:33:41', 'admin', '2017-05-31 14:33:41', 'admin');
INSERT INTO `wf_module_catalog` VALUES ('13', 'Clustering', '聚类', '6', '2', '0', 'training', '聚类算法', '0', '2017-05-31 14:34:41', 'admin', '2017-05-31 14:34:41', 'admin');
INSERT INTO `wf_module_catalog` VALUES ('14', 'Regression', '回归', '6', '3', '0', 'training', '回归算法', '0', '2017-05-31 14:58:30', 'admin', '2017-05-31 14:58:30', 'admin');
INSERT INTO `wf_module_catalog` VALUES ('15', 'AssociationRules', '关联规则', '6', '4', '0', 'process', '关联规则算法', '0', '2017-05-31 15:05:25', 'admin', '2017-05-31 15:05:25', 'admin');
INSERT INTO `wf_module_catalog` VALUES ('16', 'CollaborativeFiltering', '协同过滤', '6', '5', '0', 'training', '协同过滤算法', '0', '2017-05-31 15:06:19', 'admin', '2017-05-31 15:06:19', 'admin');
INSERT INTO `wf_module_catalog` VALUES ('17', 'Evaluation', '评估', '6', '6', '0', 'evaluation', '评估模型效果', '0', '2017-05-31 15:14:49', 'admin', '2017-05-31 15:14:49', 'admin');

-- ----------------------------
-- Table structure for wf_module_port
-- ----------------------------
DROP TABLE IF EXISTS `wf_module_port`;
CREATE TABLE `wf_module_port` (
  `PORT_ID` bigint(20) NOT NULL COMMENT '端口ID，组件的同一类型端口数最多6个\r\n            端口ID值组成：工作流组件ID * 100 + 一位节点端口类型 * 10 + 一位端口序号',
  `PORT_NAME` varchar(200) NOT NULL COMMENT '端口名称',
  `PORT_TYPE` int(11) NOT NULL COMMENT '端口类型\r\n            1：输入端口\r\n            2：输出端口',
  `OWNER_MODULE_ID` bigint(20) NOT NULL COMMENT '所属工作流组件ID',
  `BIND_CHAR_ID` varchar(64) NOT NULL COMMENT '绑定计算组件输入输出特征ID',
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
INSERT INTO `wf_module_port` VALUES ('110', '读数据表的输出', '1', '1', '10001', '0', '数据输出', '0', '2017-05-27 20:12:15', 'admin', '2017-05-27 20:12:15', 'admin');
INSERT INTO `wf_module_port` VALUES ('210', '读模型的输出', '1', '2', '10011', '0', '模型输出', '0', '2017-05-27 20:21:59', 'admin', '2017-05-27 20:21:59', 'admin');
INSERT INTO `wf_module_port` VALUES ('300', '写数据表的输入', '0', '3', '1', '0', '数据输入', '0', '2017-06-06 17:53:42', 'admin', '2017-06-06 17:53:42', 'admin');
INSERT INTO `wf_module_port` VALUES ('310', '写数据表的输出', '1', '3', '10001', '0', '数据输出', '0', '2017-06-06 17:53:42', 'admin', '2017-06-06 17:53:42', 'admin');
INSERT INTO `wf_module_port` VALUES ('400', 'SQL脚本的输入t1', '0', '4', '1', '0', 'SQL脚本的输入', '0', '2017-05-27 20:44:40', 'admin', '2017-05-27 20:44:40', 'admin');
INSERT INTO `wf_module_port` VALUES ('401', 'SQL脚本的输入t2', '0', '4', '2', '1', 'SQL脚本的输入', '0', '2017-05-27 20:48:13', 'admin', '2017-05-27 20:48:13', 'admin');
INSERT INTO `wf_module_port` VALUES ('402', 'SQL脚本的输入t3', '0', '4', '3', '2', 'SQL脚本的输入', '0', '2017-05-27 20:48:51', 'admin', '2017-05-27 20:48:51', 'admin');
INSERT INTO `wf_module_port` VALUES ('403', 'SQL脚本的输入t4', '0', '4', '4', '3', 'SQL脚本的输入', '0', '2017-05-27 20:49:21', 'admin', '2017-05-27 20:49:21', 'admin');
INSERT INTO `wf_module_port` VALUES ('404', 'SQL脚本的输入t5', '0', '4', '5', '4', 'SQL脚本的输入', '0', '2017-05-27 20:49:51', 'admin', '2017-05-27 20:49:51', 'admin');
INSERT INTO `wf_module_port` VALUES ('405', 'SQL脚本的输入t6', '0', '4', '6', '5', 'SQL脚本的输入', '0', '2017-05-27 20:50:12', 'admin', '2017-05-27 20:50:12', 'admin');
INSERT INTO `wf_module_port` VALUES ('410', 'SQL脚本的输出', '1', '4', '10001', '0', 'SQL脚本的输出', '0', '2017-05-27 20:55:27', 'admin', '2017-05-27 20:55:27', 'admin');
INSERT INTO `wf_module_port` VALUES ('500', '逻辑回归二分类的输入', '0', '5', '1', '0', '训练数据输入', '0', '2017-05-31 15:03:21', 'admin', '2017-05-31 15:03:21', 'admin');
INSERT INTO `wf_module_port` VALUES ('510', '逻辑回归二分类的输出', '1', '5', '10011', '0', '模型输出', '0', '2017-05-31 15:09:31', 'admin', '2017-05-31 15:09:31', 'admin');
INSERT INTO `wf_module_port` VALUES ('600', '随机森林二分类的输入', '0', '6', '1', '0', '训练数据输入', '0', '2017-05-31 15:27:23', 'admin', '2017-05-31 15:27:23', 'admin');
INSERT INTO `wf_module_port` VALUES ('610', '随机森林二分类的输出', '1', '6', '10011', '0', '模型输出', '0', '2017-05-31 15:28:16', 'admin', '2017-05-31 15:28:16', 'admin');
INSERT INTO `wf_module_port` VALUES ('700', 'GBDT二分类的输入', '0', '7', '1', '0', '训练数据输入', '0', '2017-05-31 15:28:49', 'admin', '2017-05-31 15:28:49', 'admin');
INSERT INTO `wf_module_port` VALUES ('710', 'GBDT二分类的输出', '1', '7', '10011', '0', '模型输出', '0', '2017-05-31 15:29:46', 'admin', '2017-05-31 15:29:46', 'admin');
INSERT INTO `wf_module_port` VALUES ('800', '线性支持向量机二分类的输入', '0', '8', '1', '0', '训练数据输入', '0', '2017-05-31 15:30:14', 'admin', '2017-05-31 15:30:14', 'admin');
INSERT INTO `wf_module_port` VALUES ('810', '线性支持向量机二分类的输出', '1', '8', '10011', '0', '模型输出', '0', '2017-05-31 15:30:46', 'admin', '2017-05-31 15:30:46', 'admin');
INSERT INTO `wf_module_port` VALUES ('900', '逻辑回归多分类的输入', '0', '9', '1', '0', '训练数据输入', '0', '2017-05-31 15:21:20', 'admin', '2017-05-31 15:21:20', 'admin');
INSERT INTO `wf_module_port` VALUES ('910', '逻辑回归多分类的输出', '1', '9', '10011', '0', '模型输出', '0', '2017-05-31 15:22:14', 'admin', '2017-05-31 15:22:14', 'admin');
INSERT INTO `wf_module_port` VALUES ('1000', '随机森林多分类的输入', '0', '10', '1', '0', '训练数据输入', '0', '2017-05-31 15:27:23', 'admin', '2017-05-31 15:27:23', 'admin');
INSERT INTO `wf_module_port` VALUES ('1010', '随机森林多分类的输出', '1', '10', '10011', '0', '模型输出', '0', '2017-05-31 15:28:16', 'admin', '2017-05-31 15:28:16', 'admin');
INSERT INTO `wf_module_port` VALUES ('1100', '朴素贝叶斯多分类的输入', '0', '11', '1', '0', '训练数据输入', '0', '2017-05-31 15:31:54', 'admin', '2017-05-31 15:31:54', 'admin');
INSERT INTO `wf_module_port` VALUES ('1110', '朴素贝叶斯多分类的输出', '1', '11', '10011', '0', '模型输出', '0', '2017-05-31 15:32:40', 'admin', '2017-05-31 15:32:40', 'admin');
INSERT INTO `wf_module_port` VALUES ('1200', 'K近邻多分类的输入（*）', '0', '12', '1', '0', '训练数据输入', '0', '2017-05-31 15:33:42', 'admin', '2017-05-31 15:33:42', 'admin');
INSERT INTO `wf_module_port` VALUES ('1210', 'K近邻多分类的输出（*）', '1', '12', '10011', '0', '模型输出', '0', '2017-05-31 15:34:12', 'admin', '2017-05-31 15:34:12', 'admin');
INSERT INTO `wf_module_port` VALUES ('1300', 'K均值聚类的输入（*）', '0', '13', '1', '0', '训练数据输入', '0', '2017-05-31 15:34:48', 'admin', '2017-05-31 15:34:48', 'admin');
INSERT INTO `wf_module_port` VALUES ('1310', 'K均值聚类的输出（*）', '1', '13', '10011', '0', '模型输出', '0', '2017-05-31 15:35:54', 'admin', '2017-05-31 15:35:54', 'admin');
INSERT INTO `wf_module_port` VALUES ('1400', '线性回归的输入', '0', '14', '1', '0', '训练数据输入', '0', '2017-05-31 15:36:24', 'admin', '2017-05-31 15:36:24', 'admin');
INSERT INTO `wf_module_port` VALUES ('1410', '线性回归的输出', '1', '14', '10011', '0', '模型输出', '0', '2017-05-31 15:36:48', 'admin', '2017-05-31 15:36:48', 'admin');
INSERT INTO `wf_module_port` VALUES ('1500', 'GBDT回归的输入', '0', '15', '1', '0', '训练数据输入', '0', '2017-05-31 15:37:43', 'admin', '2017-05-31 15:37:43', 'admin');
INSERT INTO `wf_module_port` VALUES ('1510', 'GBDT回归的输出', '1', '15', '10011', '0', '模型输出', '0', '2017-05-31 15:38:08', 'admin', '2017-05-31 15:38:08', 'admin');
INSERT INTO `wf_module_port` VALUES ('1600', '二分类评估的输入', '0', '16', '1', '0', '预测结果输入', '0', '2017-05-31 15:39:42', 'admin', '2017-05-31 15:39:42', 'admin');
INSERT INTO `wf_module_port` VALUES ('1610', '二分类评估的输出', '1', '16', '10011', '1', '评估输出', '0', '2017-06-21 12:01:30', 'admin', '2017-06-21 12:01:30', 'admin');
INSERT INTO `wf_module_port` VALUES ('1700', '多分类评估的输入', '0', '17', '1', '0', '预测结果输入', '0', '2017-05-31 15:49:06', 'admin', '2017-05-31 15:49:06', 'admin');
INSERT INTO `wf_module_port` VALUES ('1800', '聚类模型评估的输入', '0', '18', '1', '0', '预测结果输入', '0', '2017-05-31 15:54:04', 'admin', '2017-05-31 15:54:04', 'admin');
INSERT INTO `wf_module_port` VALUES ('1900', '回归模型评估的输入', '0', '19', '1', '0', '预测结果输入', '0', '2017-05-31 15:55:05', 'admin', '2017-05-31 15:55:05', 'admin');
INSERT INTO `wf_module_port` VALUES ('2000', '预测的输入m1', '0', '20', '11', '0', '模型输入', '0', '2017-05-31 15:38:49', 'admin', '2017-05-31 15:38:49', 'admin');
INSERT INTO `wf_module_port` VALUES ('2001', '预测的输入t1', '0', '20', '1', '1', '测试数据输入', '0', '2017-05-31 15:38:49', 'admin', '2017-05-31 15:38:49', 'admin');
INSERT INTO `wf_module_port` VALUES ('2010', '预测的输出', '1', '20', '10001', '0', '预测结果输出', '0', '2017-05-31 15:39:14', 'admin', '2017-05-31 15:39:14', 'admin');
INSERT INTO `wf_module_port` VALUES ('2100', '智能规则的输入（*）', '0', '21', '1', '0', '训练数据输入', '0', '2017-05-31 15:57:35', 'admin', '2017-05-31 15:57:35', 'admin');

-- ----------------------------
-- Table structure for wf_snapshot
-- ----------------------------
DROP TABLE IF EXISTS `wf_snapshot`;
CREATE TABLE `wf_snapshot` (
  `SNAPSHOT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '快照ID',
  `SNAPSHOT_NAME` varchar(200) NOT NULL COMMENT '快照名称',
  `SNAPSHOT_TYPE` int(11) NOT NULL COMMENT '快照类型\r\n            0：运行快照\r\n            1：副本快照\r\n            2：删除快照',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `OWNER_FLOW_ID` bigint(20) NOT NULL COMMENT '所属流程图ID',
  `SNAPSHOT_CONTENT` mediumtext COMMENT '快照内容',
  `SNAPSHOT_VERSION` bigint(20) NOT NULL COMMENT '快照版本',
  `SNAPSHOT_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '快照状态\r\n            0：generating，快照生成中\r\n            1：finished，快照完成',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SNAPSHOT_ID`),
  KEY `Index_1` (`OWNER_PROJECT_ID`,`OWNER_FLOW_ID`,`SNAPSHOT_TYPE`,`SNAPSHOT_VERSION`),
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
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
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
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  KEY `Index_1` (`PROJECT_ID`,`OPER_ID`,`TABLE_ID`,`STATUS`,`CREATE_TIME`),
  KEY `Index_2` (`PROJECT_ID`,`OPER_ID`,`STATUS`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户收藏数据表\r\n\r\n逻辑删除，同一项目和用户下正常状态的数据表唯一';

-- ----------------------------
-- Records of wf_user_favorite_table
-- ----------------------------
