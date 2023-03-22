## 画面展開名

| 画面名       | パターン名                                      |
|-----------|--------------------------------------------|
| メニュー      | -                                          |
| 受注登録      | [E 展開]()                                   |
| 受注一覧      | [RM 展開]()                                  |
| 顧客検索      | [RM 展開](https://www.sociomedia.co.jp/1676) |
| 受注明細登録    | [VE 展開](https://www.sociomedia.co.jp/1671) |
| 引当/出荷指示状況 | [ME 展開](https://www.sociomedia.co.jp/1671) |
| 出荷状況      | [ME 展開](https://www.sociomedia.co.jp/1671) |


| 操作名  | Operation   |
|------|-------------|
| 検索   | Retriever   | 
| 閲覧   | Viewer      | 
| 編集   | Editor      |
| 一覧操作 | Manipulator |
| 画面遷移 | - (hyphen)  |


## コンポーネント
### 受注登録
| 項目名      | BootStrap                                                                   | Kintone |
|----------|-----------------------------------------------------------------------------|---------|
| 顧客名称     | [Form controls](https://getbootstrap.com/docs/5.2/forms/form-control/)      | 文字列（1行） |
| 顧客選択モーダル | [Modal](https://getbootstrap.com/docs/5.2/components/modal/)                | ルックアップ  |
| 顧客検索ボタン  | [Button](https://getbootstrap.com/docs/5.2/components/buttons/)             | ルックアップ  |
| 受注日      | [Form controls](https://getbootstrap.com/docs/5.2/forms/form-control/)      | 日付      |
| 届け先都道府県  | [Form controls](https://getbootstrap.com/docs/5.2/forms/form-control/)      | ドロップダウン |
| 届け先住所    | [Form controls](https://getbootstrap.com/docs/5.2/forms/form-control/)      | 文字列（1行） |
| 消費税計算方式  | [Checks and radios](https://getbootstrap.com/docs/5.2/forms/checks-radios/) | ラジオボタン  |

### 受注一覧
| 項目名      | BootStrap                                                                                | Kintone |
|----------|------------------------------------------------------------------------------------------|---------|
| 受注日From  | [Form controls](https://getbootstrap.com/docs/5.2/forms/form-control/)                   | 日付      |
| 受注日To    | [Form controls](https://getbootstrap.com/docs/5.2/forms/form-control/)                   | 日付      |
| 顧客名称     | [Form controls](https://getbootstrap.com/docs/5.2/forms/form-control/)                   | 文字列（1行） |
| 顧客検索ボタン  | [Button](https://getbootstrap.com/docs/5.2/components/buttons/)                          | -       |
| 受注一覧     | [Tables](https://getbootstrap.com/docs/5.2/content/tables/)                              | -       |
| 受注日      | [Tables](https://getbootstrap.com/docs/5.2/content/tables/)                              | -       |
| 顧客名称     | [Tables](https://getbootstrap.com/docs/5.2/content/tables/)                              | -       |
| 引当状況     | [Outline buttons](https://getbootstrap.com/docs/5.2/components/buttons/#outline-buttons) | -       |
| 受注登録へボタン | [Outline buttons](https://getbootstrap.com/docs/5.2/components/buttons/#outline-buttons) | -       |

### 受注詳細
| 項目名   | BootStrap                                                              | Kintone |
|-------|------------------------------------------------------------------------|---------|
| 顧客名   | [List group](https://getbootstrap.com/docs/5.2/components/list-group/) | -       |
| 受注日   | [List group](https://getbootstrap.com/docs/5.2/components/list-group/) | -       |
| 明細    | [Tables](https://getbootstrap.com/docs/5.2/content/tables/)            | -       |
| 引当ボタン | [Button](https://getbootstrap.com/docs/5.2/components/buttons/)        | -       |
