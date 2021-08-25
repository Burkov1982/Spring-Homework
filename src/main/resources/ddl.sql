CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users (
    id     uuid DEFAULT uuid_generate_v4() PRIMARY KEY,
    first_name  VARCHAR(250) NOT NULL,
    last_name   VARCHAR(250) NOT NULL,
    email       VARCHAR(250) NOT NULL UNIQUE,
    password    VARCHAR(250) NOT NULL,
    user_role   VARCHAR(50) NOT NULL,
    user_status   VARCHAR(50) NOT NULL
);

CREATE TABLE manufacturer (
    manufacturer_id uuid DEFAULT uuid_generate_v4() PRIMARY KEY,
    manufacturer_name            VARCHAR(250) NOT NULL
);

CREATE TABLE product (
    product_id      uuid DEFAULT uuid_generate_v4() PRIMARY KEY,
    product_name            VARCHAR(250) NOT NULL,
    product_price           NUMERIC(10,2) NOT NULL,
    manufacturer_id uuid, FOREIGN KEY(manufacturer_id) REFERENCES manufacturers(manufacturer_id)
);
