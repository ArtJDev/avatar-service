CREATE TABLE avatar
(
    id       BIGSERIAL PRIMARY KEY NOT NULL,
    username varchar UNIQUE        NOT NULL,
    filename varchar,
    type     varchar,
    size     bigint,
    avatar   bytea
);
