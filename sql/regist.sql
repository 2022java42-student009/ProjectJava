create table public.regist (
  user_id serial not null
  , book_number integer not null
  , regist_day timestamp(6) without time zone not null
  , price integer not null
  , remarks character varying
);
