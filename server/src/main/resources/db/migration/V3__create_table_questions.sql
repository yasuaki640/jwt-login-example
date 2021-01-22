BEGIN;

CREATE TABLE questions
(
    id                 serial
        constraint questions_pk
            primary key,
    expression         text      not null,
    has_add            bool,
    has_subtraction    bool,
    has_carry          bool,
    has_borrow         bool,
    has_multiplication bool,
    has_division       bool,
    has_decimal_point  bool,
    created_at         timestamp not null,
    updated_at         timestamp,
    deleted_at         timestamp
);

COMMIT;
