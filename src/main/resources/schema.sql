CREATE SCHEMA 消費税;
CREATE TABLE 消費税.計算方式区分
(
    消費税計算方式 CHAR(4) NOT NULL,
    PRIMARY KEY (消費税計算方式),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 消費税.税率区分
(
    税率区分 CHAR(4) NOT NULL,
    PRIMARY KEY (税率区分),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE SCHEMA 商品;
CREATE TABLE 商品.商品
(
    商品コード VARCHAR(10) NOT NULL,
    商品名称 VARCHAR(40) NOT NULL,
    商品単価 NUMERIC(9, 3) NOT NULL,
    税率区分 CHAR(4) NOT NULL,
    PRIMARY KEY (商品コード),
    FOREIGN KEY (税率区分) REFERENCES 消費税.税率区分 (税率区分),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 商品.セット商品
(
    商品コード VARCHAR(10) NOT NULL,
    商品名称 VARCHAR(40) NOT NULL,
    商品単価 NUMERIC(9, 3) NOT NULL,
    税率区分 CHAR(4) NOT NULL,
    PRIMARY KEY (商品コード),
    FOREIGN KEY (税率区分) REFERENCES 消費税.税率区分 (税率区分),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 商品.セット商品組合せ
(
    セット商品コード VARCHAR(10) NOT NULL,
    商品コード VARCHAR(10) NOT NULL,
    PRIMARY KEY (セット商品コード, 商品コード),
    FOREIGN KEY (セット商品コード) REFERENCES 商品.セット商品 (商品コード),
    FOREIGN KEY (商品コード) REFERENCES 商品.商品 (商品コード),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE SCHEMA 顧客;
CREATE TABLE 顧客.顧客区分
(
    個人法人区分 VARCHAR(2) NOT NULL PRIMARY KEY,
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 顧客.顧客
(
    顧客ID UUID NOT NULL,
    顧客姓 VARCHAR(20) NOT NULL,
    顧客名 VARCHAR(20) NOT NULL,
    顧客姓カナ VARCHAR(20) NOT NULL,
    顧客名カナ VARCHAR(20) NOT NULL,
    個人法人区分 CHARACTER(2) NOT NULL,
    PRIMARY KEY (顧客ID),
    FOREIGN KEY (個人法人区分) REFERENCES 顧客.顧客区分 (個人法人区分),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 顧客.顧客住所
(
    顧客番号 UUID NOT NULL,
    都道府県 VARCHAR(20) NOT NULL,
    住所 VARCHAR(40) NOT NULL,
    PRIMARY KEY (顧客番号),
    FOREIGN KEY (顧客番号) REFERENCES 顧客.顧客 (顧客ID),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE SCHEMA 受注;
CREATE TABLE 受注.受注
(
    受注ID UUID NOT NULL,
    顧客ID UUID NOT NULL,
    受注日 DATE NOT NULL,
    都道府県 VARCHAR(5) NOT NULL,
    住所 VARCHAR(50) NOT NULL,
    PRIMARY KEY (受注ID),
    FOREIGN KEY (顧客ID) REFERENCES 顧客.顧客 (顧客ID),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 受注.受注明細
(
    受注ID UUID NOT NULL,
    受注明細番号 UUID NOT NULL,
    商品コード VARCHAR(10) NOT NULL,
    受注数量 NUMERIC(3) NOT NULL,
    PRIMARY KEY (受注ID, 受注明細番号),
    FOREIGN KEY (受注ID) REFERENCES 受注.受注 (受注ID),
    FOREIGN KEY (商品コード) REFERENCES 商品.商品 (商品コード),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 受注.セット商品受注明細
(
    受注番号 UUID NOT NULL,
    受注明細番号 UUID NOT NULL,
    商品コード VARCHAR(10) NOT NULL,
    受注数量 NUMERIC(3) NOT NULL,
    PRIMARY KEY (受注番号, 受注明細番号),
    FOREIGN KEY (受注番号) REFERENCES 受注.受注 (受注ID),
    FOREIGN KEY (商品コード) REFERENCES 商品.セット商品 (商品コード),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 受注.消費税計算方式
(
    受注番号 UUID NOT NULL,
    計算方式 CHAR(4) NOT NULL,
    FOREIGN KEY (受注番号) REFERENCES 受注.受注 (受注ID),
    FOREIGN KEY (計算方式) REFERENCES 消費税.計算方式区分 (消費税計算方式),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE SCHEMA 倉庫;
CREATE TABLE 倉庫.倉庫
(
    倉庫コード VARCHAR(8) NOT NULL,
    倉庫名称 VARCHAR(20) NOT NULL,
    倉庫住所 VARCHAR(40) NOT NULL,
    PRIMARY KEY (倉庫コード),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE SCHEMA 引当;

CREATE TABLE 引当.個別商品引当
(
    引当番号 UUID NOT NULL,
    受注番号 UUID NOT NULL,
    受注明細番号 UUID NOT NULL,
    商品コード VARCHAR(10) NOT NULL,
    PRIMARY KEY (引当番号),
    FOREIGN KEY (受注番号, 受注明細番号) REFERENCES 受注.受注明細 (受注ID, 受注明細番号),
    FOREIGN KEY (商品コード) REFERENCES 商品.商品 (商品コード),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 引当.個別商品引当明細
(
    引当番号 UUID NOT NULL,
    倉庫コード VARCHAR(8) NOT NULL,
    引当数量 NUMERIC(3) NOT NULL,
    PRIMARY KEY (引当番号, 倉庫コード),
    FOREIGN KEY (引当番号) REFERENCES 引当.個別商品引当 (引当番号),
    FOREIGN KEY (倉庫コード) REFERENCES 倉庫.倉庫 (倉庫コード),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 引当.セット商品引当
(
    引当番号 UUID NOT NULL,
    受注番号 UUID NOT NULL,
    受注明細番号 UUID NOT NULL,
    商品コード VARCHAR(10) NOT NULL,
    PRIMARY KEY (引当番号),
    FOREIGN KEY (受注番号, 受注明細番号) REFERENCES 受注.セット商品受注明細 (受注番号, 受注明細番号),
    FOREIGN KEY (商品コード) REFERENCES 商品.セット商品 (商品コード),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 引当.セット商品引当明細
(
    引当番号 UUID NOT NULL,
    商品コード VARCHAR(10) NOT NULL,
    倉庫コード VARCHAR(8) NOT NULL,
    引当数量 NUMERIC(3) NOT NULL,
    PRIMARY KEY (引当番号, 商品コード, 倉庫コード),
    FOREIGN KEY (引当番号) REFERENCES 引当.セット商品引当 (引当番号),
    FOREIGN KEY (商品コード) REFERENCES 商品.商品 (商品コード),
    FOREIGN KEY (倉庫コード) REFERENCES 倉庫.倉庫 (倉庫コード),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE SCHEMA 在庫;
CREATE TABLE 在庫._在庫
(
    商品コード VARCHAR(10) NOT NULL,
    倉庫コード VARCHAR(8) NOT NULL,
    在庫数量 NUMERIC(4) NOT NULL,
    PRIMARY KEY (商品コード, 倉庫コード),
    FOREIGN KEY (商品コード) REFERENCES 商品.商品 (商品コード),
    FOREIGN KEY (倉庫コード) REFERENCES 倉庫.倉庫 (倉庫コード),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE SCHEMA 出荷指示;
CREATE TABLE 出荷指示.出荷指示
(
    出荷番号 UUID NOT NULL,
    出荷日 DATE NOT NULL,
    受注番号 UUID NOT NULL,
    PRIMARY KEY (出荷番号),
    FOREIGN KEY (受注番号) REFERENCES 受注.受注 (受注ID),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 出荷指示.出荷指示済引当
(
    出荷番号 UUID NOT NULL,
    引当番号 UUID NOT NULL,
    PRIMARY KEY (出荷番号, 引当番号),
    FOREIGN KEY (出荷番号) REFERENCES 出荷指示.出荷指示 (出荷番号),
    FOREIGN KEY (引当番号) REFERENCES 引当.個別商品引当 (引当番号),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 出荷指示.出荷指示済セット商品引当
(
    出荷番号 UUID NOT NULL,
    引当番号 UUID NOT NULL,
    PRIMARY KEY (出荷番号, 引当番号),
    FOREIGN KEY (出荷番号) REFERENCES 出荷指示.出荷指示 (出荷番号),
    FOREIGN KEY (引当番号) REFERENCES 引当.セット商品引当 (引当番号),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 出荷指示._未出荷
(
    出荷番号 UUID NOT NULL,
    PRIMARY KEY (出荷番号),
    FOREIGN KEY (出荷番号) REFERENCES 出荷指示.出荷指示 (出荷番号),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 出荷指示.出荷済
(
    出荷番号 UUID NOT NULL,
    PRIMARY KEY (出荷番号),
    FOREIGN KEY (出荷番号) REFERENCES 出荷指示.出荷指示 (出荷番号),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);