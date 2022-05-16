/*
 * �f�[�^�x�[�X(webtext)��
 * ���[�U(webtextuser)�̍쐬
 */
DROP DATABASE IF EXISTS webtext;
DROP USER IF EXISTS webtextuser;
CREATE USER webtextuser WITH PASSWORD 'himitu';
CREATE DATABASE webtext OWNER webtextuser ENCODING 'UTF8';
\c webtext

-- ����e�[�u���̍쐬
CREATE TABLE member (
	id SERIAL PRIMARY KEY,
	family_name VARCHAR(10) NOT NULL,
	first_name VARCHAR(10) NOT NULL,
	postal CHAR(7) NOT NULL,
	address VARCHAR(100) NOT NULL,
	tel VARCHAR(20) NOT NULL,
	email VARCHAR(100) NOT NULL,
	birthday DATE NOT NULL,
	password VARCHAR(12) DEFAULT 'himitu' NOT NULL
);

-- �e�[�u���̏��L�Ґݒ�
ALTER TABLE member OWNER TO webtextuser;

-- ����e�[�u���̃T���v���f�[�^
INSERT INTO member VALUES(1, '����', '���Y', '1000000', '�����s', '090-1111-1111', 'ai@dd.co.jp', '1984-10-01', DEFAULT);
INSERT INTO member VALUES(2, '�ɓc', '���Y', '1100000', '��t��', '090-2222-2222', 'ida@dd.co.jp', '1954-10-2', DEFAULT);
INSERT INTO member VALUES(3, '�F�c', '�O�Y', '1200000', '���ꌧ', '090-3333-3333', 'uda@dd.co.jp', '1939-10-3', DEFAULT);
