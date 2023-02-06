INSERT INTO 顧客.顧客 (顧客番号, 顧客名称, 個人法人区分)
VALUES ('a4162efe-f43a-40fb-85db-3a1032757f6a', '和田　義盛', '個人'),
       ('8bf03626-efa4-40ee-b1dc-c020c549218f', '北条　義時', '個人')
       ;


INSERT INTO 受注.受注 (受注番号, 顧客番号, 受注日)
VALUES ('e6707ec5-d767-42f7-bd45-5ebfb4555be5', 'a4162efe-f43a-40fb-85db-3a1032757f6a', '2023-01-10'),
       ('9be70cad-7fd9-4589-8913-a9d5cf7d128e', '8bf03626-efa4-40ee-b1dc-c020c549218f', '2023-01-10')
;

INSERT INTO 商品.商品 (商品コード, 商品名称, 商品単価)
VALUES ('1118549', 'アルパイン テックグローブ', 19690),
       ('1324503', 'アウトドアサプリメント アミノサミット3500', 194),
       ('1121389', 'ドライ シームレス ダウンハガー900 #1', 69850),
       ('1124310', 'ウォータープルーフマッチ', 825),
       ('1899162', 'フロンティアーズマン ベアスプレー272mL', 11880)
;


INSERT INTO 受注.受注明細 (受注番号, 受注明細番号, 商品コード, 受注数量)
VALUES ('e6707ec5-d767-42f7-bd45-5ebfb4555be5', '590d65c8-31a8-43e3-9469-2d67af1e6a85', '1118549', 2),
       ('e6707ec5-d767-42f7-bd45-5ebfb4555be5', '958cdfab-b6fe-4c60-a82f-a8ac56c9da89', '1121389', 1),
       ('9be70cad-7fd9-4589-8913-a9d5cf7d128e', '9b1facac-fae4-40f3-bc1d-e45c1f7a8a99', '1324503', 3),
       ('9be70cad-7fd9-4589-8913-a9d5cf7d128e', '93ba3c21-5e71-4ee5-a54b-433af662b12c', '1899162', 7),
       ('9be70cad-7fd9-4589-8913-a9d5cf7d128e', '69699ef5-bb61-412a-9f25-cce45ba142c1', '1124310', 5)
;


INSERT INTO 受注.消費税 (受注番号, 消費税率, 消費税計算方式)
VALUES ('e6707ec5-d767-42f7-bd45-5ebfb4555be5', 0.08, '総額計算'),
       ('9be70cad-7fd9-4589-8913-a9d5cf7d128e', 0.08, '積上計算');
