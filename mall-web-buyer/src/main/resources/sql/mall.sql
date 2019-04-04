DROP TABLE IF EXISTS sys_user_buyer;
CREATE TABLE sys_user (
  id              VARCHAR(32) PRIMARY KEY,
  user_name      VARCHAR(16) NOT NULL COMMENT '账号',
  password       VARCHAR(16)  NOT NULL COMMENT '密码',
  tel             VARCHAR(30)  COMMENT '电话',
  mobile          VARCHAR(11)  NOT NULL UNIQUE COMMENT '手机号',
  email           VARCHAR(30)  UNIQUE COMMENT '邮箱',
  qq               VARCHAR(15)  UNIQUE  COMMENT 'qq',
  head_sculpture VARCHAR(500)  COMMENT '头像',
  account_type   VARCHAR(2) NOT NULL DEFAULT '0' COMMENT '账号类型 0-主账号 1-子账号',
  profile         VARCHAR(255) COMMENT '简介',
  user_state      VARCHAR(255) NOT NULL DEFAULT '1'COMMENT '账号状态 0-停用 1-启用',
  ent_id           VARCHAR(32) COMMENT '企业id',
  create_time     DATETIME DEFAULT CURRENT_TIMESTAMP   COMMENT '创建时间',
  update_time     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)
  ENGINE = INNODB
  COMMENT '账号信息';


DROP TABLE IF EXISTS biz_enterprice;
CREATE TABLE biz_enterprice (
  id                   VARCHAR(32) PRIMARY KEY,
  ent_name            VARCHAR(255) NOT NULL COMMENT '企业名称',
  ent_code            VARCHAR(32)  NOT NULL COMMENT '企业编码',
  integrity_level    VARCHAR(2) DEFAULT '0' COMMENT ' 诚信等级',
  ent_type            VARCHAR(2)  NOT NULL COMMENT '企业类型 0-买方企业 1-卖方企业 3-买卖方企业',
  ent_buyer_state    VARCHAR(1)   NOT NULL DEFAULT '1' COMMENT '买方审核状态 1-待审核 2-审核通过 3-审核驳回',
  ent_seller_state   VARCHAR(1)   NOT NULL DEFAULT '1' COMMENT '卖方审核状态 1-待审核 2-审核通过 3-审核驳回',
  registered_address  VARCHAR(255) NOT NULL COMMENT '注册地址',
  registered_capital  VARCHAR(50)  NOT NULL COMMENT '注册资本',
  legal_person        VARCHAR(100) NOT NULL COMMENT '法人',
  legal_person_mobile VARCHAR(11)  NOT NULL COMMENT '法人电话',
  link_man            VARCHAR(100) NOT NULL COMMENT '联系人',
  link_mobile         VARCHAR(11)  NOT NULL COMMENT '联系电话',
  tax_identify_no     VARCHAR(100) NOT NULL COMMENT '纳税人识别号',
  social_credit_code  VARCHAR(100) NOT NULL COMMENT '社会统一信用代码'
)
  ENGINE = INNODB
  COMMENT '企业信息';

DROP TABLE IF EXISTS biz_receiving_address;
CREATE TABLE biz_receiving_address (
  id               VARCHAR(32) PRIMARY KEY,
  account_id      VARCHAR(32)  NOT NULL  COMMENT '账号id',
  address         VARCHAR(255) NOT NULL COMMENT '收货地址',
  mobile          VARCHAR(11)  NOT NULL COMMENT '收货联系电话',
  man             VARCHAR(100) NOT NULL COMMENT '收货人',
  province       VARCHAR(10) COMMENT '省',
  city           VARCHAR(10) COMMENT '市',
  town           VARCHAR(10) COMMENT '区/县',
  detail_address VARCHAR(255) COMMENT '详细地址',
  zip_code       VARCHAR(30) COMMENT '邮政编码',
  def             VARCHAR(1)         DEFAULT '0'COMMENT '是否默认',
  remark         VARCHAR(255) COMMENT '备注',
  create_time    DATETIME  NOT NULL DEFAULT  now() COMMENT '创建时间',
  update_time    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)
  ENGINE = INNODB
  COMMENT '收货地址';

DROP TABLE IF EXISTS biz_shopping_cart;
CREATE TABLE biz_shopping_cart (
  id                     VARCHAR(32) PRIMARY KEY,
  account_id            VARCHAR(32) NOT NULL COMMENT '账号id',
  product_id            VARCHAR(32) COMMENT '商品id',
  product_type          VARCHAR(2) COMMENT '商品类型（直营、自营）',
  product_no             VARCHAR(30) COMMENT '商品编号',
  product_name           VARCHAR(255) COMMENT '商品名称',
  product_standard       VARCHAR(100) COMMENT '商品规格',
  product_model          VARCHAR(10) COMMENT '商品型号',
  brand_name              VARCHAR(10) COMMENT '品牌',
  product_unit            VARCHAR(2) COMMENT '单位',
  product_category_no    VARCHAR(10) COMMENT '商品分类编号',
  product_category_name  VARCHAR(10) COMMENT '商品分类属性',
  num                      DECIMAL(10,0) COMMENT '数量',
  price                    DECIMAL(15,2) COMMENT '单价',
  total                    DECIMAL(15,2) COMMENT '金额',
  create_time             DATETIME NOT NULL DEFAULT now() COMMENT '添加时间',
  update_time             TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)
  ENGINE = INNODB
  COMMENT '购物车';

DROP TABLE IF EXISTS biz_purch_order_main;
CREATE TABLE biz_purch_order_main (
  id VARCHAR(32) PRIMARY KEY,
  to_system VARCHAR(32) NOT NULL COMMENT '流向系统',
  sale_order_no VARCHAR(32) NOT NULL COMMENT '采购单号',
  plan_arrive_date VARCHAR(32) NOT NULL COMMENT '计划到货日期',
  order_num    DECIMAL(10,0) NOT NULL COMMENT '订单数量',
  order_amount DECIMAL(15,2) NOT NULL COMMENT '订单金额',
  sended_num   DECIMAL(10,0)  DEFAULT  0 COMMENT '已发货数量',
  order_state  DECIMAL(2) NOT NULL DEFAULT 0 COMMENT '订单状态',
  pay_way      VARCHAR(2) COMMENT '付款方式',
  address_id   VARCHAR(32) NOT NULL COMMENT '地址id',
  create_user  VARCHAR(32) NOT NULL COMMENT '创建人',
  create_time  DATETIME NOT NULL DEFAULT now() COMMENT '创建时间'
)
  ENGINE = INNODB
  COMMENT '采购单主表';

DROP TABLE IF EXISTS biz_purch_order_item;
CREATE TABLE biz_purch_order_item (
  id                VARCHAR(32) PRIMARY KEY,
  itemno           VARCHAR(32) COMMENT '行号',
  purch_order_no    VARCHAR(32) COMMENT '单号',
  product_id        VARCHAR(32) COMMENT '商品id',
  product_type      VARCHAR(2) COMMENT '商品类型（直营、自营）',
  product_no        VARCHAR(30) COMMENT '商品编号',
  product_name      VARCHAR(255) COMMENT '商品名称',
  product_standard VARCHAR(100) COMMENT '商品规格',
  product_model     VARCHAR(10) COMMENT '商品型号',
  brand_name              VARCHAR(10) COMMENT '品牌',
  product_unit            VARCHAR(2) COMMENT '单位',
  product_category_no    VARCHAR(10) COMMENT '商品分类编号',
  product_category_name  VARCHAR(10) COMMENT '商品分类属性',
  num          DECIMAL(10,0) COMMENT '数量',
  price        DECIMAL(15,2) COMMENT '单价',
  total        DECIMAL(15,2) COMMENT '金额'
)
  ENGINE = INNODB
  COMMENT '采购单子表';

DROP TABLE IF EXISTS biz_out_order_main;
CREATE TABLE biz_out_order_main (
  id VARCHAR(32) PRIMARY KEY,
  out_no VARCHAR(32) NOT NULL COMMENT '出库单号',
  purch_order_no    VARCHAR(32) COMMENT '采购单号',
  out_num   DECIMAL(10,0)  DEFAULT  0 COMMENT '发货数量',
  out_amount DECIMAL(15,2) NOT NULL COMMENT '发货金额',
  out_state  DECIMAL(2) NOT NULL DEFAULT 0 COMMENT '发货状态',
  address_id   VARCHAR(32) NOT NULL COMMENT '地址id',
  logistics_id VARCHAR(32)  COMMENT '物流id',
  create_user  VARCHAR(32) NOT NULL COMMENT '创建人',
  create_time  DATETIME NOT NULL DEFAULT now() COMMENT '创建时间'
)
  ENGINE = INNODB
  COMMENT '出库单主表';

DROP TABLE IF EXISTS biz_out_item;
CREATE TABLE biz_out_item (
  id                 VARCHAR(32) PRIMARY KEY,
  product_id        VARCHAR(32) COMMENT '商品id',
  product_type      VARCHAR(2) COMMENT '商品类型（直营、自营）',
  product_no        VARCHAR(30) COMMENT '商品编号',
  product_name      VARCHAR(255) COMMENT '商品名称',
  product_standard VARCHAR(100) COMMENT '商品规格',
  product_model     VARCHAR(10) COMMENT '商品型号',
  brand_name         VARCHAR(10) COMMENT '品牌',
  product_unit       VARCHAR(2) COMMENT '单位',
  product_category_no    VARCHAR(10) COMMENT '商品分类编号',
  product_category_name  VARCHAR(10) COMMENT '商品分类属性',
  num          DECIMAL(10,0) COMMENT '数量',
  price        DECIMAL(15,2) COMMENT '单价',
  total        DECIMAL(15,2) COMMENT '金额'
)
  ENGINE = INNODB
  COMMENT '出库单子表';

DROP TABLE IF EXISTS biz_logistics_info;
CREATE TABLE biz_logistics_info (
  id VARCHAR(32) PRIMARY KEY,
  customer VARCHAR(32) COMMENT '客户',
  logistics_no VARCHAR(32) NOT NULL COMMENT '物流单号',
  logistics_code VARCHAR(32) NOT NULL COMMENT '物流公司编号',
  logistics_name   VARCHAR(30) COMMENT '物流名称',
  logistics_state   VARCHAR(30) COMMENT '物流状态',
  out_order_no VARCHAR(32) NOT NULL COMMENT '出库单号',
  sale_order_no VARCHAR(32) NOT NULL COMMENT '采购单号',
  logistics_detail   VARCHAR(1000) COMMENT '物流详情'
)
  ENGINE = INNODB
  COMMENT '物流信息';

DROP TABLE IF EXISTS biz_payment;
CREATE TABLE biz_payment (
  id VARCHAR(32) PRIMARY KEY,
  pay_no VARCHAR(30) NOT NULL COMMENT '付款单号',
  payer VARCHAR(32) COMMENT '付款方',
  receiving_party VARCHAR(32) COMMENT '收款方',
  receiving_account VARCHAR(30) COMMENT '收款账号',
  pay_way VARCHAR(2) COMMENT '付款方式',
  pay_bank VARCHAR(100) COMMENT '付款方银行',
  pay_ammount DECIMAL(15,2) COMMENT '付款金额',
  pay_date DATE  NOT NULL COMMENT '付款日期',
  trade_no VARCHAR(50) COMMENT '交易流水号',
  pay_summary VARCHAR(100) COMMENT '付款摘要',
  pay_state VARCHAR(2) COMMENT '付款状态',
  sale_order_no VARCHAR(30) COMMENT '关联销售单号',
  money_nature VARCHAR(2) COMMENT '款项类型',
  remark VARCHAR(100)COMMENT '备注',
  create_time  DATETIME NOT NULL DEFAULT now() COMMENT '创建时间'
)
  ENGINE = INNODB
  COMMENT '付款单';

DROP TABLE IF EXISTS biz_invoice;
CREATE TABLE biz_invoice (
  id VARCHAR(32) PRIMARY KEY,
  register_no VARCHAR(30) COMMENT '发票登记号',
  invoice_no VARCHAR(30) COMMENT '发票号',
  invoice_head VARCHAR(255)COMMENT '发票抬头',
  customer_name VARCHAR(100)COMMENT '客户名称',
  invoice_amount DECIMAL(15,2) COMMENT '开票金额',
  tax_rate DECIMAL(10,2) COMMENT '税率',
  tax_amount DECIMAL(15,2) COMMENT '税额',
  invoice_num DECIMAL(10,0) COMMENT '开票数量',
  invoice_nature VARCHAR(2) COMMENT '发票性质',
  invoice_type VARCHAR(2) COMMENT '发票类型',
  invoice_state VARCHAR(2) COMMENT '发票状态',
  sale_order_no VARCHAR(30) COMMENT '关联销售单号',
  create_time  DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  create_user VARCHAR(32) COMMENT '开票人'
)
  ENGINE = INNODB
  COMMENT '发票信息';


CREATE TABLE sys_dict_type(
  id VARCHAR(32) PRIMARY KEY,
  name VARCHAR(100) NOT NULL UNIQUE COMMENT '字典名称',
  code VARCHAR(30) NOT NULL UNIQUE COMMENT '字典编码'
)
  ENGINE = INNODB
  COMMENT '字典类型表';

CREATE TABLE sys_dict(
  id VARCHAR(32) PRIMARY KEY,
  dict_code VARCHAR(30) NOT NULL COMMENT '字典编码',
  dict_value VARCHAR(20) NOT NULL COMMENT  '字典值',
  dict_desc VARCHAR(100) COMMENT '字典描述'
)
  ENGINE = INNODB
  COMMENT '字典表';





