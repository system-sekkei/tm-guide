INSERT INTO 顧客.顧客区分 (個人法人区分)
VALUES ('個人'),
       ('法人')
;

INSERT INTO 消費税.計算方式区分 (消費税計算方式)
VALUES ('総額計算'),
       ('積上計算')
;

INSERT INTO 消費税.税率区分 (税率区分)
VALUES ('軽減税率'),
       ('通常税率')
;