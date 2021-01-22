BEGIN;

INSERT INTO questions(id, expression, has_add, has_subtraction, has_carry, has_borrow, has_multiplication, has_division,
                      has_decimal_point, created_at, updated_at, deleted_at)
VALUES (1, '1 + 1', true, false, false, false, false, false, false, now(), null, null),
       (2, '9 + 5', true, false, true, false, false, false, false, now(), null, null),
       (3, '12 - 3', false, true, false, true, false, false, false, now(), null, null),
       (4, '156 + 87', true, false, true, false, false, false, false, now(), null, null),
       (5, '12 * 5', false, false, false, false, true, false, false, now(), null, null),
       (6, '6 * 2 / 3', false, false, false, false, true, true, false, now(), null, null),
       (7, '15.6 - 0.7', false, true, false, false, false, false, true, now(), null, null);

COMMIT;
