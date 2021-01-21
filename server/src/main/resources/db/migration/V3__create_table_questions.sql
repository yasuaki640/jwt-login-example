BEGIN;

CREATE TABLE questions
(
    id                serial
        constraint questions_pk
            primary key,
    expression        text      not null,
    has_carry         bool,
    has_borrow        bool,
    has_decimal_point bool,
    created_at        timestamp not null,
    updated_at        timestamp,
    deleted_at        timestamp
);

COMMIT;
