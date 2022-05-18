create table public.buy (
  user_id integer not null
  , stock_id integer not null
  , selesday timestamp(6) without time zone not null
  , price integer not null
  , remarks character varying
);
