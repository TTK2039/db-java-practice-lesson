-- Project Name : データベース設計_演習問題
-- Date/Time    : 2020/01/25 16:27:58
-- Author       : 株式会社テクノコア
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

-- 商品ジャンル
create table genres (
  genre_id integer not null
  , genre_name character varying(50)
  , constraint genres_PKC primary key (genre_id)
) ;

-- 商品
create table products (
  product_id integer not null
  , product_name character varying(50)
  , genre_id integer not null
  , constraint products_PKC primary key (product_id)
) ;


-- 制約
alter table products
  add constraint products_FK1 foreign key (genre_id) references genres(genre_id);

-- 論理名
comment on table genres is '商品ジャンル';
comment on column genres.genre_id is 'ジャンルID';
comment on column genres.genre_name is 'ジャンル名';

comment on table products is '商品';
comment on column products.product_id is '商品ID';
comment on column products.product_name is '商品名';
comment on column products.genre_id is 'ジャンルID';

