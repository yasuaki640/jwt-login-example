BEGIN;

CREATE EXTENSION IF NOT EXISTS pgcrypto;

INSERT INTO users
VALUES (1, 'yasuaki', crypt('password', gen_salt('bf')), now(), null, null),
       (2, 'taiyaki', crypt('password', gen_salt('bf')), now(), null, null),
       (3, 'takoyaki', crypt('password', gen_salt('bf')), now(), null, null);

COMMIT;
