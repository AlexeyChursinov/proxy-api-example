--liquibase formatted sql
--changeset chursinov:create-table-events

CREATE TABLE IF NOT EXISTS events (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            description TEXT,
                            date DATE NOT NULL,
                            location VARCHAR(255),
                            category VARCHAR(50)
);
