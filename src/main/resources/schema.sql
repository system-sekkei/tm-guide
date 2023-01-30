CREATE SCHEMA 商品;
CREATE TABLE 商品.商品
(
    商品コード VARCHAR(10) NOT NULL,
    商品名称 VARCHAR(20) NOT NULL,
    商品単価 NUMERIC(9, 3) NOT NULL,
    PRIMARY KEY (商品コード),
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
    顧客番号 UUID NOT NULL,
    顧客名称 VARCHAR(20) NOT NULL,
    個人法人区分 CHARACTER(2) NOT NULL,
    PRIMARY KEY (顧客番号),
    FOREIGN KEY (個人法人区分) REFERENCES 顧客.顧客区分 (個人法人区分),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE SCHEMA 受注;
CREATE TABLE 受注.受注
(
    受注番号 UUID NOT NULL,
    顧客番号 UUID NOT NULL,
    受注日 DATE NOT NULL,
    PRIMARY KEY (受注番号),
    FOREIGN KEY (顧客番号) REFERENCES 顧客.顧客 (顧客番号),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 受注.受注明細
(
    受注番号 UUID NOT NULL,
    受注明細番号 UUID NOT NULL,
    商品コード VARCHAR(10) NOT NULL,
    受注数量 NUMERIC(3) NOT NULL,
    PRIMARY KEY (受注番号, 受注明細番号),
    FOREIGN KEY (受注番号) REFERENCES 受注.受注 (受注番号),
    FOREIGN KEY (商品コード) REFERENCES 商品.商品 (商品コード),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE SCHEMA 引当;
CREATE TABLE 引当.引当
(
    引当番号 UUID NOT NULL,
    受注番号 UUID NOT NULL,
    受注明細番号 UUID NOT NULL,
    引当数量 NUMERIC(3) NOT NULL,
    PRIMARY KEY (引当番号),
    FOREIGN KEY (受注番号, 受注明細番号) REFERENCES 受注.受注明細 (受注番号, 受注明細番号),
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


CREATE SCHEMA 在庫;
CREATE TABLE 在庫.在庫
(
    商品コード VARCHAR(10) NOT NULL,
    倉庫コード VARCHAR(8) NOT NULL,
    在庫数量 NUMERIC(4) NOT NULL,
    PRIMARY KEY (商品コード, 倉庫コード),
    FOREIGN KEY (商品コード) REFERENCES 商品.商品 (商品コード),
    FOREIGN KEY (倉庫コード) REFERENCES 倉庫.倉庫 (倉庫コード),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 在庫.引当済在庫
(
    引当番号 UUID NOT NULL,
    商品コード VARCHAR(10) NOT NULL,
    倉庫コード VARCHAR(8) NOT NULL,
    引当数量 NUMERIC(4) NOT NULL,
    PRIMARY KEY (引当番号, 商品コード, 倉庫コード),
    FOREIGN KEY (商品コード) REFERENCES 商品.商品 (商品コード),
    FOREIGN KEY (倉庫コード) REFERENCES 倉庫.倉庫 (倉庫コード),
    作成日時 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);