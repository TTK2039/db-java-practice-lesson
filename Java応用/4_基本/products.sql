/* �f�[�^�x�[�X�쐬 */
CREATE DATABASE dbconnection;

/* �e�[�u���쐬 */
CREATE TABLE products (
  product_id   SERIAL PRIMARY KEY, --�����̔�
  product_name VARCHAR(50),
  price        INT
);

/* �V�[�P���X(�����̔�)�̔ԍ��̏����l��ݒ� */
ALTER SEQUENCE products_product_id_seq RESTART 101;

/* �f�[�^�o�^ */
INSERT INTO products (product_name, price)
VALUES ('���M',50), ('�����S��',100), ('�n���V',5000);
