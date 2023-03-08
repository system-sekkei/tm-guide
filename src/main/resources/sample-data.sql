INSERT INTO 顧客.顧客 (顧客番号, 顧客姓, 顧客名, 顧客姓カナ, 顧客名カナ, 個人法人区分)
VALUES ('a4162efe-f43a-40fb-85db-3a1032757f6a', '宮本', '麻衣子', 'ミヤモト', 'マイコ', '個人'),
       ('8bf03626-efa4-40ee-b1dc-c020c549218f', '中山', '洋介', 'ナカヤマ', 'ヨウスケ', '個人'),
       ('a3081bf2-64f5-41bf-a7a6-16c2135856ae', '川田', '匡', 'カワタ', 'タダシ', '個人'),
       ('2802bfed-dc68-4bd1-b5be-d1ca3613fd05', '大坂', '悟', 'オオサカ', 'サトル', '個人'),
       ('7be19df5-fe46-4054-a1b2-9a0214cc6885', '小杉', '洋光', 'コスギ', 'ヒロアキ', '個人'),
       ('7bddd753-c72c-44ee-99b5-f6fd39e6b537', '上杉', '沙織', 'ウエスギ', 'サオリ', '個人'),
       ('af5b9317-6da9-452a-ac1d-9a74a0fb94bd', '井上', '一浩', 'イノウエ', 'カズヒロ', '個人'),
       ('c03dac82-8e3e-4e87-95f6-a2730e09dc26', '阿部', '清子', 'アベ', 'キヨコ', '個人'),
       ('9e27b3dd-cff3-484a-a5f6-a6d5481780ca', '吉野', '大樹', 'ヨシノ', 'タイキ', '個人'),
       ('c7e27889-ee54-4e58-b8ee-7d26802bb7d2', '宮口', '陽子', 'ミヤグチ', 'ヨウコ', '個人'),
       ('bd843ee3-7390-42c9-8873-3e162d248016', '柳川', '茜', 'ヤナガワ', 'アカネ', '個人'),
       ('16f32f0c-763b-4f37-ba2c-b3c8761247f3', '近藤', '功一', 'コンドウ', 'コウイチ', '個人'),
       ('e8b24387-d92c-4cf5-bce1-bb341c4bfcde', '大門', '仁志', 'ダイモン', 'ヒトシ', '個人'),
       ('9acb5cd9-c3e5-4690-a015-71feec8c2229', '鈴木', '大裕', 'スズキ', 'ダイスケ', '個人'),
       ('7964b766-608c-4d30-812f-592f61fac845', '下川', '直樹', 'シモカワ', 'ナオキ', '個人'),
       ('2d134b88-249c-4938-9ba7-654db067ffef', '白石', '隆文', 'シライシ', 'タカフミ', '個人'),
       ('3100409b-4eda-4c75-9e57-3da478d1c0ac', '徳永', '啓太', 'トクナガ', 'ケイタ', '個人'),
       ('fbf45514-60a9-4e50-a93d-66185c2eaa25', '高場', '幸子', 'タカバ', 'サチコ', '個人'),
       ('1231974b-1a71-49e6-91df-281e59a396a5', '小松', '祥子', 'コマツ', 'ショウコ', '個人'),
       ('d149ab58-5a05-4502-911b-48c34df00a1e', '高瀬', '真由', 'タカセ', 'マユキ', '個人')
;



INSERT INTO 顧客.顧客住所 (顧客番号, 都道府県, 住所)
VALUES ('a4162efe-f43a-40fb-85db-3a1032757f6a', '東京都', '足立区千住3-5-15'),
       ('8bf03626-efa4-40ee-b1dc-c020c549218f', '神奈川県', '平塚市真田1-1-8'),
       ('a3081bf2-64f5-41bf-a7a6-16c2135856ae', '広島県', '福山市引野町1-3-9ガーデンズ816'),
       ('2802bfed-dc68-4bd1-b5be-d1ca3613fd05', '茨城県', '龍ケ崎市中根台2-5-106'),
       ('7be19df5-fe46-4054-a1b2-9a0214cc6885', '高知県', '高知市本町2-2-9'),
       ('7bddd753-c72c-44ee-99b5-f6fd39e6b537', '東京都', '世田谷区瀬田2-1-17ハイツ614'),
       ('af5b9317-6da9-452a-ac1d-9a74a0fb94bd', '熊本県', '熊本市東区御領4-3-3'),
       ('c03dac82-8e3e-4e87-95f6-a2730e09dc26', '大阪府', '高石市千代田1-2-4グルーブ410'),
       ('9e27b3dd-cff3-484a-a5f6-a6d5481780ca', '奈良県', '奈良市大安寺3-2-9'),
       ('c7e27889-ee54-4e58-b8ee-7d26802bb7d2', '北海道', '札幌市中央区南十条西2-5-18'),
       ('bd843ee3-7390-42c9-8873-3e162d248016', '東京都', '中央区銀座1-5-409'),
       ('16f32f0c-763b-4f37-ba2c-b3c8761247f3', '石川県', '金沢市畝田西2-1-11'),
       ('e8b24387-d92c-4cf5-bce1-bb341c4bfcde', '大阪府', '大阪市中央区南船場1-4-1107'),
       ('9acb5cd9-c3e5-4690-a015-71feec8c2229', '大阪府', '大阪市北区天満2-1-4'),
       ('7964b766-608c-4d30-812f-592f61fac845', '群馬県', '前橋市西片貝町3-2-21'),
       ('2d134b88-249c-4938-9ba7-654db067ffef', '東京都', '渋谷区千駄ヶ谷3-2-501'),
       ('3100409b-4eda-4c75-9e57-3da478d1c0ac', '埼玉県', '川口市本町1-1-6'),
       ('fbf45514-60a9-4e50-a93d-66185c2eaa25', '兵庫県', '神戸市兵庫区湊町2-2-4'),
       ('1231974b-1a71-49e6-91df-281e59a396a5', '東京都', '台東区蔵前2-2-408'),
       ('d149ab58-5a05-4502-911b-48c34df00a1e', '大阪府', '大阪市中央区備後町3-3-9')
;


INSERT INTO 受注.受注 (受注番号, 顧客番号, 受注日, 都道府県, 住所)
VALUES ('e6707ec5-d767-42f7-bd45-5ebfb4555be5', 'a4162efe-f43a-40fb-85db-3a1032757f6a', '2023-01-10', '東京都', '千代田区1-1-1'),
       ('9be70cad-7fd9-4589-8913-a9d5cf7d128e', '8bf03626-efa4-40ee-b1dc-c020c549218f', '2023-01-10', '埼玉県', 'さいたまし1-1-1')
;

INSERT INTO 商品.商品 (商品コード, 商品名称, 商品単価, 税率区分)
VALUES ('1118549', 'アルパイン テックグローブ', 19690, '通常税率'),
       ('1324503', 'アウトドアサプリメント アミノサミット3500', 194, '軽減税率'),
       ('1121389', 'ドライ シームレス ダウンハガー900 #1', 69850, '通常税率'),
       ('1124310', 'ウォータープルーフマッチ', 825, '通常税率'),
       ('1899162', 'フロンティアーズマン ベアスプレー272mL', 11880, '通常税率'),
       ('1124576', 'アルパインスノーショベル', 6600, '通常税率'),
       ('1124786', 'アバランチゾンデ 240', 6490, '通常税率'),
       ('1124787', 'アバランチ BEACON', 34500, '通常税率'),
       ('1124306', 'エマージェンシーシート', 429, '通常税率'),
       ('1124247', 'エマージェンシーコール', 770, '通常税率'),
       ('1150109', 'トイレキット セット', 715, '軽減税率'),
       ('1150101', 'ロールペーパーキット', 1980, '軽減税率')
;


INSERT INTO 商品.セット商品 (商品コード, 商品名称, 商品単価, 税率区分)
VALUES ('2145346', 'アバランチセット', 39890, '通常税率'),
       ('2191829', 'エマージェンシーキット', 2480, '通常税率')
;

INSERT INTO 商品.セット商品組合せ (セット商品コード, 商品コード)
VALUES ('2145346', '1124576'),
       ('2145346', '1124786'),
       ('2145346', '1124787'),
       ('2191829', '1124306'),
       ('2191829', '1124247'),
       ('2191829', '1150109'),
       ('2191829', '1150101')
       ;


INSERT INTO 受注.受注明細 (受注番号, 受注明細番号, 商品コード, 受注数量)
VALUES ('e6707ec5-d767-42f7-bd45-5ebfb4555be5', '590d65c8-31a8-43e3-9469-2d67af1e6a85', '1118549', 2),
       ('e6707ec5-d767-42f7-bd45-5ebfb4555be5', '958cdfab-b6fe-4c60-a82f-a8ac56c9da89', '1121389', 1),
       ('9be70cad-7fd9-4589-8913-a9d5cf7d128e', '9b1facac-fae4-40f3-bc1d-e45c1f7a8a99', '1324503', 3),
       ('9be70cad-7fd9-4589-8913-a9d5cf7d128e', '93ba3c21-5e71-4ee5-a54b-433af662b12c', '1899162', 7),
       ('9be70cad-7fd9-4589-8913-a9d5cf7d128e', '69699ef5-bb61-412a-9f25-cce45ba142c1', '1124310', 5)
;


INSERT INTO 受注.消費税計算方式 (受注番号, 計算方式)
VALUES ('e6707ec5-d767-42f7-bd45-5ebfb4555be5', '総額計算'),
       ('9be70cad-7fd9-4589-8913-a9d5cf7d128e', '積上計算');


INSERT INTO 倉庫.倉庫 (倉庫コード, 倉庫名称, 倉庫住所)
VALUES ('754321', '東日本倉庫', '千葉県'),
       ('987650', '西日本倉庫', '奈良県'),
       ('254i63', '中日本倉庫', '静岡県')
;

INSERT INTO 在庫._在庫 (商品コード, 倉庫コード, 在庫数量)
VALUES ('1118549', '754321', 1),
       ('1118549', '987650', 0),
       ('1118549', '254i63', 0),
       ('1324503', '754321', 9),
       ('1324503', '987650', 91),
       ('1324503', '254i63', 19),
       ('1121389', '754321', 9),
       ('1121389', '987650', 91),
       ('1121389', '254i63', 19),
       ('1124310', '754321', 9),
       ('1124310', '987650', 91),
       ('1124310', '254i63', 19),
       ('1899162', '754321', 9),
       ('1899162', '987650', 91),
       ('1899162', '254i63', 19),
       ('1124576', '754321', 9),
       ('1124576', '987650', 91),
       ('1124576', '254i63', 19),
       ('1124786', '754321', 11),
       ('1124786', '987650', 21),
       ('1124786', '254i63', 9),
       ('1124787', '754321', 9),
       ('1124787', '987650', 91),
       ('1124787', '254i63', 19),
       ('1124306', '754321', 9),
       ('1124306', '987650', 91),
       ('1124306', '254i63', 19),
       ('1124247', '754321', 9),
       ('1124247', '987650', 91),
       ('1124247', '254i63', 19),
       ('1150109', '754321', 9),
       ('1150109', '987650', 91),
       ('1150109', '254i63', 19),
       ('1150101', '754321', 9),
       ('1150101', '987650', 91),
       ('1150101', '254i63', 19)
;
