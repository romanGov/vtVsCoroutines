
create schema if not exists demo;

SET search_path TO demo;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


create table if not exists table_one(
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    description varchar(100) not null
    );

insert into table_one(id,description) values (uuid_generate_v4(),'test');