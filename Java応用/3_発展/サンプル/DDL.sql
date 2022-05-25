-- Project Name : �f�[�^�x�[�X�݌v_���K���
-- Date/Time    : 2020/01/25 16:27:58
-- Author       : ������Ѓe�N�m�R�A
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

-- ���i�W������
create table genres (
  genre_id integer not null
  , genre_name character varying(50)
  , constraint genres_PKC primary key (genre_id)
) ;

-- ���i
create table products (
  product_id integer not null
  , product_name character varying(50)
  , genre_id integer not null
  , constraint products_PKC primary key (product_id)
) ;


-- ����
alter table products
  add constraint products_FK1 foreign key (genre_id) references genres(genre_id);

-- �_����
comment on table genres is '���i�W������';
comment on column genres.genre_id is '�W������ID';
comment on column genres.genre_name is '�W��������';

comment on table products is '���i';
comment on column products.product_id is '���iID';
comment on column products.product_name is '���i��';
comment on column products.genre_id is '�W������ID';

