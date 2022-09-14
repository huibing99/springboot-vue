/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80030
Source Host           : localhost:3306
Source Database       : vrtrain

Target Server Type    : MYSQL
Target Server Version : 80030
File Encoding         : 65001

Date: 2022-09-08 12:45:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '类型',
  `scene` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '所在场景',
  `question` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '问题',
  `answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '答案',
  `op1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '选项1',
  `op2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '选项2',
  `op3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '选项3',
  `op4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '选项4',
  `op5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '选项5',
  `op6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '选项6',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', '单选', '煎药室门', '医疗机构应建立煎药人员体检档案，患（  ）者不得上岗', 'B', '慢性胃炎', '传染病', '神经性头痛', '关节炎', null, null);
INSERT INTO `question` VALUES ('2', '单选', '煎药室门', '急煎药物应在（  ）小时内完成', 'B', '1小时', '2小时', '3小时', '4小时', null, null);
INSERT INTO `question` VALUES ('3', '单选', '煎药室门', '以下哪种材质的容器不宜作为煎药容器', 'C', '陶瓷', '不锈钢', '铁质', '铜质', null, null);
INSERT INTO `question` VALUES ('4', '单选', '煎药室门', '药剂科负责人对煎药工作进行质量评估检查的频次不得低于（  ）', 'B', '每月一次', '每季度一次', '每半年一次', '每年一次', null, null);
INSERT INTO `question` VALUES ('5', '多选', '煎药室门', '煎药收发记录应包括哪些基本内容（  ）', 'ABCDE', '领药', '煎药', '装药', '送药', '发药', null);
INSERT INTO `question` VALUES ('6', '多选', '煎药室门', '煎药室工作区应设有哪些功能区？（   ）', 'ABCD', '储藏', '准备', '煎煮', '清洗', null, null);
INSERT INTO `question` VALUES ('7', '判断', '煎药室门', '煎药人员煎药前应进行手清洁并穿戴专用的工作服。（  ）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('8', '判断', '煎药室门', '煎药室应区分工作区和生活区，原则上两区物品不可混放，但是一些常用的私人物品（如水杯）等可放置在工作区内。（  ）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('9', '判断', '煎药室门', '煎药的药渣应按照医疗废物相关规定进行处置。（  ）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('10', '判断', '煎药室门', '煎药设备设施、容器应每煎一付药一清洁并建立清洁记录。（  ）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('11', '单选', '消毒间内浸泡桶', '医疗卫生机构使用的进入人体组织或无菌器官的医疗用品必须达到（）要求。', 'B', '消毒', '灭菌', '杀菌', null, null, null);
INSERT INTO `question` VALUES ('12', '单选', '消毒间内浸泡桶', '凡接触完整皮肤、粘膜的器械和用品必须达到（）要求。', 'A', '消毒', '灭菌', '杀菌', null, null, null);
INSERT INTO `question` VALUES ('13', '单选', '消毒间内浸泡桶', '在医疗诊疗活动中高度危险性物品，必须选用（  ）处理方法。', 'B', '消毒法', '灭菌法', '一般消毒', '清洗处置', null, null);
INSERT INTO `question` VALUES ('14', '单选', '消毒间内浸泡桶', '控制医院感染最简单、最有效、最方便、最经济的方法是（  ）', 'C', '环境消毒', '合理使用抗菌素', '洗手', '隔离传染病人', null, null);
INSERT INTO `question` VALUES ('15', '单选', '消毒间内浸泡桶', '《消毒管理办法》于（  ）修订并实施。', 'C', '2002年1月1日', '2002年7月1日', '2017年12月5日', '', null, null);
INSERT INTO `question` VALUES ('16', '多选', '消毒间内浸泡桶', '《消毒管理办法》适用范围是（  ）', 'ABC', '医疗卫生机构', '消毒服务机构', '从事消毒生产、经营活动的单位和个人', null, null, null);
INSERT INTO `question` VALUES ('17', '多选', '消毒间内浸泡桶', '《消毒管理办法》规定（   ）', 'ABCD', '医疗卫生机构应当建立消毒管理组织', '制定消毒管理制度', '执行国家有关规范、标准和规定', '定期开展消毒与灭菌效果检测工作', null, null);
INSERT INTO `question` VALUES ('18', '多选', '消毒间内浸泡桶', '县级以上卫生计生行政部门对消毒工作行使的监督管理职权包括（  ）', 'ABC', '对有关机构、场所和物品的消毒工作进行监督检查', '对消毒产品的卫生质量进行监督检查', '对消毒服务机构的消毒服务质量进行监督检查', '对消毒剂、消毒器械和卫生用品生产企业受理审批发放卫生许可证件', null, null);
INSERT INTO `question` VALUES ('19', '判断', '消毒间内浸泡桶', '医疗卫生机构购进消毒产品必须建立并执行进货检查验收制度。（  ）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('20', '判断', '消毒间内浸泡桶', '拔罐器、刮痧板等重复性使用中医诊疗器具必须执行“一人一用一清洁一消毒”原则。（  ）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('21', '判断', '诊所大门进出口', '新冠肺炎疫情期间，诊所无论有几个进口，设置一个预检分诊处就行。（）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('22', '判断', '诊所大门进出口', '新冠肺炎疫情期间，患者可以从出口进入诊所。（）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('23', '多选', '诊所大门进出口', '新冠肺炎疫情期间，预检分诊处应更新（）名单。', 'ABC', '高风险区', '中风险区', '低风险区', '无风险区', null, null);
INSERT INTO `question` VALUES ('24', '多选', '诊所大门进出口', '新冠肺炎疫情期间，（）承担预检分诊工作。', 'AB', '医师', '护士', '物业', '保安', null, null);
INSERT INTO `question` VALUES ('25', '多选', '诊所大门进出口', '新冠肺炎疫情期间，进入诊所的患者及陪同人员都应该（）。', 'ABCD', '扫码', '测温', '流调', '佩戴口罩', null, null);
INSERT INTO `question` VALUES ('26', '单选', '诊所大门进出口', '新冠肺炎疫情期间，对于来自低风险区人员，抵津不足（）日且无相关症状的，要查看其（）小时核酸检测报告。', 'B', '3  72', '3  48', '7  72', '7  48', null, null);
INSERT INTO `question` VALUES ('27', '多选', '诊所大门进出口', '新冠肺炎相关症状包括（）', 'ABCD', '发热', '干咳', '乏力', '嗅觉味觉减退', null, null);
INSERT INTO `question` VALUES ('28', '判断', '诊所大门进出口', '非疫情期间的日常情况下，诊所门口也需要设立独立的预检分诊处。（）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('29', '判断', '诊所大门进出口', '新冠肺炎疫情期间，预检分诊处医务人员可以短暂离岗。（）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('30', '判断', '诊所大门进出口', '新冠肺炎疫情期间，诊所发现发热患者后应告知其自行前往最近的发热门诊就诊。（）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('31', '判断', '预检分诊处桌子', '新冠肺炎疫情期间，高中低风险区的名单必须是全部打印出来的纸质版。（）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('32', '判断', '预检分诊处桌子', '新冠肺炎疫情期间，诊所应当给未佩戴口罩的就诊患者或其陪同人员提供外科口罩。（）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('33', '判断', '预检分诊处桌子', '新冠肺炎疫情期间，诊所体温枪应定期校准，保证测量准确。（）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('34', '判断', '预检分诊处桌子', '一般情况下，使用含氯消毒剂做物表消毒，使用浓度达500mg/L即可。（）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('35', '判断', '预检分诊处桌子', '抗菌凝胶、抑菌凝胶、消毒凝胶都可以用于手部消毒。（）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('36', '简答', '预检分诊处桌子', '请至少列举出4个在新冠肺炎疫情期间诊所预检分诊处应该配备的物品。', '扫码终端（包括用于扫码的手机），传染病预检分诊登记表，体温枪或体温表，消毒剂或消毒湿巾，外科口罩，高中低风险区名单，医疗废物包装袋、桶。', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('37', '判断', '预检分诊处护士', '新冠疫情期间，预检分诊人员必须是医务人员。（）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('38', '判断', '预检分诊处护士', '新冠疫情期间，预检分诊人员必须穿防护服。（）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('39', '判断', '预检分诊处护士', '新冠疫情期间，预检分诊人员必须穿隔离衣。（）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('40', '判断', '预检分诊处护士', '新冠疫情期间，预检分诊人员必须戴护目镜或面屏。（）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('41', '判断', '预检分诊处护士', '新冠疫情期间，预检分诊人员必须佩戴医用防护口罩。（）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('42', '判断', '预检分诊处护士', '新冠疫情期间，预检分诊人员必须执行扫码、测温、流调、登记工作。（）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('43', '判断', '预检分诊处护士', '新冠疫情期间，预检分诊人员应指导患者及陪同人员规范佩戴口罩。（）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('44', '简答', '预检分诊处护士', '请至少列举出5个新冠肺炎的症状。', '发热、干咳、乏力、咽痛、嗅觉味觉减退、腹泻、鼻塞、流涕、结膜炎、肌痛。', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('45', '判断', '治疗室内垃圾桶', '使用后的输液器是感染性废物。（）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('46', '判断', '治疗室内垃圾桶', '使用后的安瓿瓶是损伤性废物。（）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('47', '多选', '治疗室内垃圾桶', '以下不是医疗废物的是（）。', 'CD', '棉签', '针头', '中草药煎制后的残渣', '输液瓶（袋）', null, null);
INSERT INTO `question` VALUES ('48', '判断', '治疗室内垃圾桶', '密封药瓶、安瓿瓶等玻璃药瓶在收集环节，如果盛装容器满足防渗漏、防刺破要求，并外加一层医疗废物包装袋，标签为损伤性废物，并注明密封药瓶或者安瓿瓶，则可以不放入专门的利器盒中。（）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('49', '判断', '治疗室内垃圾桶', '针头放入医疗废物包装袋的情形违法，应当受到处罚。（）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('50', '判断', '治疗室内垃圾桶', '生活垃圾放入医疗废物包装袋的情形违法，应当受到处罚。（）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('51', '判断', '治疗室内垃圾桶', '医疗废物放入生活垃圾袋的情形违法，应当受到处罚。（）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('52', '判断', '医疗废物暂存间门', '医疗废物暂存间的门不使用时应上锁，避免非工作人员进出。（）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('53', '判断', '医疗废物暂存间门', '医疗废物暂存间的门应设置防鼠板、沙门等防鼠、防蚊蝇的措施。（）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('54', '多选', '医疗废物暂存间门上张贴的图片', '医疗废物暂存间的门上应张贴（）', 'ABC', '医疗废物警示标识', '禁止吸烟', '禁止饮食', '联系电话', null, null);
INSERT INTO `question` VALUES ('55', '判断', '医疗废物暂存间内紫外线灯', '使用中的紫外线灯辐射照度值应≥70Μw/cm2。（）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('56', '判断', '医疗废物暂存间内紫外线灯', '紫外线灯累计使用超过1000小时必须更换。（）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('57', '多选', '医疗废物暂存间内人员防护用品', '从事医疗废物收集、运送、贮存的工作人员应当配备的职业防护措施有（）。', 'ABCD', '手套', '口罩', '工作服', '靴', null, null);
INSERT INTO `question` VALUES ('58', '单选', '诊所入口牌匾', '对于违法发布医疗广告的医疗机构，卫生健康行政部门享有的行政处罚权正确的是（  ）', 'A', '吊销《医疗机构执业许可证》', '10000万以下的罚款', '没收与医疗广告相关的违法所得', '处以广告费用一倍以上五倍以下的罚款', null, null);
INSERT INTO `question` VALUES ('59', '单选', '诊所入口牌匾', '医疗机构因违法发布医疗广告可以处以停业整顿处罚的情形有：', 'A', '医疗机构发布违法医疗广告受到两次以上警告处罚仍拒不改正的', '医疗机构发布违法医疗广告受到警告处罚仍拒不改正的', '医疗机构发布违法医疗广告受到两次以上责令整改处理仍拒不改正的', '受到罚款处罚的', null, null);
INSERT INTO `question` VALUES ('60', '单选', '诊所入口牌匾', '省级卫生健康行政部门应对已审查的医疗广告成品样件和审查意见予以备案保存，保存时间自《医疗广告审查证明》生效之日起至少（  ）年。', 'C', '五年', '三年', '两年', '一年', null, null);
INSERT INTO `question` VALUES ('61', '单选', '诊所入口牌匾', '某区卫健委查获其辖区内一家三级医院违法发布妇科医疗广告，且情节严重，该区卫健委依据《医疗广告管理办法》规定，予以该医院吊销妇科诊疗科目的行政处罚。结合案例和《医疗广告管理办法》的规定，下列表述正确的是：', 'B', '《医疗广告管理办法》未设定吊销诊疗科目的处罚', '本案中的该区卫健委没有处罚权限', '该区卫健委所做的处罚得当', '吊销诊疗科目的处罚应由省级卫生行政部门作出', null, null);
INSERT INTO `question` VALUES ('62', '单选', '诊所入口牌匾', '医疗机构被依法撤销《医疗广告审查证明》后，（）内不受理该医疗机构的广告审查申请。', 'D', '四年', '三年', '两年', '一年', null, null);
INSERT INTO `question` VALUES ('63', '单选', '诊所入口牌匾', '根据《医疗广告管理办法》规定，负责医疗广告监督管理的部门为', 'C', '卫生行致部门', '新闻出版广电部门', '工商行政管理机关', '党委宣传部门', null, null);
INSERT INTO `question` VALUES ('64', '单选', '诊所入口牌匾', '对于题为“祖传秘方，专治三叉神经痛”的医疗广告，以下说法正确的是（  ）', 'C', '涉及药物', '涉及诊疗方法', '隐含保证治愈', '涉及宣传医疗技术', null, null);
INSERT INTO `question` VALUES ('65', '判断', '诊所入口牌匾', '申请互联网医疗保健信息服务的单位必须是医疗卫生机构。（  ）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('66', '判断', '诊所入口牌匾', '未取得《医疗广告审查证明》不得在任何媒介发布医疗广告。（ ）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('67', '判断', '诊所入口牌匾', '《医疗广告管理办法》调整的是商业广告。（  ）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('68', '判断', '诊所入口牌匾', '未取得《医疗机构执业许可证》发布医疗广告或提供互联网医疗保健信息服务的，按非法行医处罚。（ ）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('69', '判断', '诊所入口牌匾', '医疗广告中登载的医疗机构即为发布该则广告的广告主。（ ）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('70', '判断', '诊所入口牌匾', '医疗机构在本机构门诊病历登载本机构简介、专科特单、疾病防治知识以及专家门诊安排等内容不需要申请办理《医疗广告审查证明》。（ ）', '正确', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('71', '单选', '证件材料的公示位置', '中医诊所被责令停止执业活动的，其直接负责的主管人员自处罚决定作出之日起(        )年内不得在医疗机构内从事管理工作。', 'D', '二', '三', '四', '五', null, null);
INSERT INTO `question` VALUES ('72', '单选', '证件材料的公示位置', '违反中医诊所备案管理暂行办法第十条规定，中医诊所擅自更改设置未经备案或者实际设置与取得的《中医诊所备案证》记载事项不一致的，不得开展诊疗活动。擅自开展诊疗活动的，由县级中医药主管部门责令改正，给予警告，并处（       ）罚款；情节严重的，应当责令其停止执业活动，注销《中医诊所备案证》。', 'B', '一万元以上二万元以下', '一万元以上三万元以下', '一万元以上四万元以下', '一万元以上五万元以下', null, null);
INSERT INTO `question` VALUES ('73', '单选', '证件材料的公示位置', '违反中医诊所备案管理暂行办法规定，未经县级中医药主管部门备案擅自执业的，由县级中医药主管部门责令改正，没收违法所得，并处三万元以下罚款，向社会公告相关信息；拒不改正的，责令其停止执业活动，其直接责任人员自处罚决定作出之日起（       ）年内不得从事中医药相关活动。', 'D', '2', '3', '4', '5', null, null);
INSERT INTO `question` VALUES ('74', '多选', '证件材料的公示位置', '中医诊所应当将本诊所的(      )在诊所的明显位置公示，不得超出备案范围开展医疗活动。', 'ABC', '诊疗范围', '中医医师的姓名', '中医医师执业范围', '注册资金', null, null);
INSERT INTO `question` VALUES ('75', '多选', '证件材料的公示位置', '中医药法规定下列哪些项目采取备案制进行管理（   ）', 'ABCD', '举办中医诊所', '委托配制中药制剂', '医疗机构配制仅应用传统工艺配制的中药制剂品种', '在本医疗机构内炮制、使用市场上没有供应的中药饮片', null, null);
INSERT INTO `question` VALUES ('76', '多选', '证件材料的公示位置', '违反《中医诊所备案管理暂行办法规定》，未经县级中医药主管部门备案擅自执业的额，县级中医药主管部门如何处理？（  ）', 'AC', '县级中医药主管部门责令改正，没收违法所得，并处三万元以下罚款，向社会公告相关信息', '县级中医药主管部门责令改正，没收违法所得，并处五万元以下罚款，向社会公告相关信息', '拒不改正的，责令其停止执业活动，其直接责任人员自处罚决定作出之日起五年内不得从事中医药相关活动', '拒不改正的，责令其停止执业活动，其直接责任人员自处罚决定作出之日起三年内不得从事中医药相关活动', null, null);
INSERT INTO `question` VALUES ('77', '判断', '证件材料的公示位置', '县级以上中医药主管部门具体负责本行政区域内中医诊所的备案工作。（   ）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('78', '判断', '证件材料的公示位置', '举办中医诊所的，将诊所的名称、地址、诊疗范围、人员配备等情况报所在地县级人民政府中医药主管部门审批后即可开展执业活动（ ）', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('79', '判断', '证件材料的公示位置', '中医诊所名称、场所、诊疗科目发生变动的，应到原备案机关对变动事项进行备案。', '错误', null, null, null, null, null, null);
INSERT INTO `question` VALUES ('80', '简答', '证件材料的公示位置', '举办中医诊所应同时具备哪些条件？', '(一)个人举办中医诊所的，应当具有中医类别《医师资格证书》并经注册后在医疗、预防、保健机构中执业满三年，或者具有《中医(专长)医师资格证书》;法人或者其他组织举办中医诊所的，诊所主要负责人应当符合上述要求;\r\n(二)符合《中医诊所基本标准》;\r\n(三)中医诊所名称符合《医疗机构管理条例实施细则》的相关规定;\r\n(四)符合环保、消防的相关规定;\r\n(五)能够独立承担民事责任。', null, null, null, null, null, null);
