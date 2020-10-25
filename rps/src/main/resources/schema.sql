    drop table if exists email_meta_data CASCADE;

create table email_meta_data (
       id integer not null,
        email_sent_on timestamp,
        name varchar(255),
        primary key (id)
    );