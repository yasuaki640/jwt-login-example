BEGIN;

CREATE EXTENSION IF NOT EXISTS pgcrypto;

INSERT INTO users(id, login_id, password, created_at, updated_at, deleted_at)
VALUES (1, 'yasuaki', crypt('password', gen_salt('bf')), now(), null, null),
       (2, 'taiyaki', crypt('password', gen_salt('bf')), now(), null, null),
       (3, 'takoyaki', crypt('password', gen_salt('bf')), now(), null, null);

COMMIT;
