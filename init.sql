-- Check if the database 'to_pomodoro' exists
SELECT datname FROM pg_database WHERE datname = 'to_pomodoro';

-- If the database doesn't exist, create it
DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'to_pomodoro') THEN
        CREATE DATABASE to_pomodoro;
END IF;
END $$;

CREATE TABLE items (
                       id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       title VARCHAR(255),
                       completed BOOLEAN DEFAULT false,
                       created DATE DEFAULT now(),
                       updated DATE DEFAULT now()


);
CREATE TABLE sub_items (
                           id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                           title VARCHAR(255),
                           completed BOOLEAN,
                           item_id INTEGER REFERENCES items(id) ON DELETE CASCADE
);



INSERT INTO items (title, completed, created, updated)
VALUES
    ('Item 1', false, '2023-10-30', '2023-10-30'),
    ('Item 2', false, '2023-10-29', '2023-10-29'),
    ('Item 3', false, '2023-10-28', '2023-10-28'),
    ('Item 4', false, '2023-10-27', '2023-10-27'),
    ('Item 5', false, '2023-10-26', '2023-10-26');

INSERT INTO sub_items (title, completed, item_id)
VALUES
    ('SubItem 1', false, 1),
    ('SubItem 2', false, 1),
    ('SubItem 3', false, 2),
    ('SubItem 4', false, 2),
    ('SubItem 5', false, 3),
    ('SubItem 6', false, 3),
    ('SubItem 7', false, 4),
    ('SubItem 8', false, 4),
    ('SubItem 9', false, 5),
    ('SubItem 10', false, 5);
