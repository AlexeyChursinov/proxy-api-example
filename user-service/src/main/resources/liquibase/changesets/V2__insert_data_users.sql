--liquibase formatted sql
--changeset chursinov:insert-data-users

INSERT INTO users (first_name, last_name, preferred_categories)
VALUES
    ('John', 'Doe', ARRAY['Конференция', 'Выставка']),
    ('Jane', 'Smith', ARRAY['Концерт', 'Форум']),
    ('Alice', 'Johnson', ARRAY['Фестиваль', 'Встреча']),
    ('Bob', 'Brown', ARRAY['Семинар', 'Мода']),
    ('Charlie', 'Davis', ARRAY['Презентация', 'Саммит']),
    ('Emily', 'Wilson', ARRAY['Конференция', 'Концерт']),
    ('Frank', 'Garcia', ARRAY['Выставка', 'Форум']),
    ('Grace', 'Martinez', ARRAY['Фестиваль', 'Семинар']),
    ('Henry', 'Anderson', ARRAY['Мода', 'Презентация']),
    ('Ivy', 'Thomas', ARRAY['Саммит', 'Конференция']),
    ('Jack', 'Moore', ARRAY['Концерт', 'Фестиваль']),
    ('Kara', 'Martin', ARRAY['Выставка', 'Форум', 'Мода']),
    ('Leo', 'Jackson', ARRAY['Семинар', 'Саммит']),
    ('Mia', 'White', ARRAY['Презентация', 'Встреча']),
    ('Noah', 'Harris', ARRAY['Конференция', 'Форум']),
    ('Olivia', 'Clark', ARRAY['Концерт', 'Фестиваль', 'Мода']),
    ('Paul', 'Lewis', ARRAY['Выставка', 'Презентация']),
    ('Quinn', 'Walker', ARRAY['Семинар', 'Конференция']),
    ('Rachel', 'Hall', ARRAY['Форум', 'Саммит']),
    ('Steve', 'Allen', ARRAY['Фестиваль', 'Концерт']);
