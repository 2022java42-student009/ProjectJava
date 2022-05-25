create table public.stock (
  stock_id serial not null
  , book_number integer not null
  , stock_state character varying(255) not null
  , price integer not null
  , remarks character varying not null
  , primary key (stock_id)
);
