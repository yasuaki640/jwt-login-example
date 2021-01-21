BEGIN;

CREATE TABLE users
(
    id         serial
        constraint users_pk
            primary key,
    login_id   varchar(256) unique not null,
    password   text                not null,
    created_at timestamp           not null,
    updated_at timestamp,
    deleted_at timestamp
);

COMMIT;