create table public."admin" (
  admin_id serial not null
  , admin_name character varying(255) not null
  , address character varying(255) not null
  , tel character varying not null
  , mail character varying(255) not null
  , birthday character varying not null
  , admission_day timestamp(6) without time zone not null
  , leave_day timestamp(6) without time zone
  , password character varying not null
  , primary key (admin_id)
);
