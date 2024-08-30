--liquibase formatted sql
--changeset chursinov:create-table-users

CREATE TABLE IF NOT EXISTS users (
                            id SERIAL PRIMARY KEY,
                            first_name VARCHAR(255) NOT NULL,
                            last_name VARCHAR(255) NOT NULL,
                            preferred_categories VARCHAR(255)[]
);
