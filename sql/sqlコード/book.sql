create table public.book (
  book_number integer not null
  , book_title character varying(255) not null
  , category_id integer not null
  , author character varying(255) not null
  , primary key (book_number)
);
