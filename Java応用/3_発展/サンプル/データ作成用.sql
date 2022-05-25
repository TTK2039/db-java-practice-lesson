/* データ作成用SQL */

-- ジャンル
INSERT INTO "public".genres(genre_id,genre_name) VALUES (1,'日用品');
INSERT INTO "public".genres(genre_id,genre_name) VALUES (2,'飲料');

-- 商品
INSERT INTO "public".products(product_id,product_name,genre_id) VALUES (1,'トイレットペーパー',1);
INSERT INTO "public".products(product_id,product_name,genre_id) VALUES (2,'ティッシュペーパー',1);
INSERT INTO "public".products(product_id,product_name,genre_id) VALUES (3,'天然水',2);

