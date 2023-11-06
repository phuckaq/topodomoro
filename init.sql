-- Check if the database 'to_pomodoro' exists
SELECT datname FROM pg_database WHERE datname = 'to_pomodoro';

-- If the database doesn't exist, create it
DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'to_pomodoro') THEN
        CREATE DATABASE to_pomodoro;
END IF;
END $$;

CREATE TABLE IF NOT EXISTS sub_items (
                                         id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                         title VARCHAR(255),
                                         completed BOOLEAN DEFAULT false
    );

CREATE TABLE IF NOT EXISTS items (
                       id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       title VARCHAR(255),
                       completed BOOLEAN DEFAULT false,
                       created DATE DEFAULT now(),
                       updated DATE DEFAULT now(),
                       sub_item_id INTEGER REFERENCES sub_items(id) ON DELETE CASCADE


);


-- Create the 'pomodoro' table if it doesn't exist
CREATE TABLE IF NOT EXISTS pomodoros (
                                        id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                        start_time TIMESTAMP,
                                        end_time TIMESTAMP,
                                        item_id INTEGER REFERENCES items(id)
);

-- Create the 'pomodoro_config' table if it doesn't exist
CREATE TABLE IF NOT EXISTS pomodoro_configs (
                                               id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                               work_duration INTEGER,
                                               break_duration INTEGER
);

-- Insert sample data into the 'pomodoro_config' table
INSERT INTO pomodoro_configs (work_duration, break_duration)
VALUES
    (25, 5);

INSERT INTO sub_items (title, completed) VALUES
    ('Sub Item 1', false),
    ('Sub Item 2', false),
    ('Sub Item 3', false);


INSERT INTO items (title, completed, created, updated, sub_item_id) VALUES
    ('Sub Item 1', false, '2023-10-04', '2023-10-04', 1),
    ('Sub Item 2', false, '2023-10-04', '2023-10-04', 2),
    ('Sub Item 3', false, '2023-10-04', '2023-10-04', 3);


-- Insert sample data into the 'pomodoro' table
INSERT INTO pomodoros (start_time, end_time, item_id)
VALUES
    ('2023-11-01 08:00:00', '2023-11-01 08:25:00', 1),
    ('2023-11-02 09:00:00', '2023-11-02 09:25:00', 2),
    ('2023-11-03 10:00:00', '2023-11-03 10:25:00', 3);