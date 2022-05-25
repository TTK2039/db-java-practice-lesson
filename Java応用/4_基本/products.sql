/* データベース作成 */
CREATE DATABASE dbconnection;

/* テーブル作成 */
CREATE TABLE products (
  product_id   SERIAL PRIMARY KEY, --自動採番
  product_name VARCHAR(50),
  price        INT
);

/* シーケンス(自動採番)の番号の初期値を設定 */
ALTER SEQUENCE products_product_id_seq RESTART 101;

/* データ登録 */
INSERT INTO products (product_name, price)
VALUES ('鉛筆',50), ('消しゴム',100), ('地球儀',5000);
