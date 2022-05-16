/*
 * データベース(webtext)と
 * ユーザ(webtextuser)の作成
 */
DROP DATABASE IF EXISTS webtext;
DROP USER IF EXISTS webtextuser;
CREATE USER webtextuser WITH PASSWORD 'himitu';
CREATE DATABASE webtext OWNER webtextuser ENCODING 'UTF8';
\c webtext

-- 会員テーブルの作成
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

-- テーブルの所有者設定
ALTER TABLE member OWNER TO webtextuser;

-- 会員テーブルのサンプルデータ
INSERT INTO member VALUES(1, '阿井', '太郎', '1000000', '東京都', '090-1111-1111', 'ai@dd.co.jp', '1984-10-01', DEFAULT);
INSERT INTO member VALUES(2, '伊田', '次郎', '1100000', '千葉県', '090-2222-2222', 'ida@dd.co.jp', '1954-10-2', DEFAULT);
INSERT INTO member VALUES(3, '宇田', '三郎', '1200000', '滋賀県', '090-3333-3333', 'uda@dd.co.jp', '1939-10-3', DEFAULT);
