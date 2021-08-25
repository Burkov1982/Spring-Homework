CREATE TABLE users (
    id uuid NOT NULL PRIMARY KEY,
    first_name VARCHAR(150) NOT NULL,
    last_name VARCHAR(150) NOT NULL,
    email VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    user_role VARCHAR(50) NOT NULL,
    user_status VARCHAR(50) NOT NULL
);

ALTER TABLE users ADD CONSTRAINT email_unique UNIQUE (email);