-- Добавление начальных пользователей
INSERT INTO users (id, email, password, first_name, last_name, role)
VALUES
    (1,'admin@fitzal.com', 'admin123', 'Admin', 'User', 'MODERATOR_ROLE'),
    (2,'trainer@fitzal.com', 'trainer123', 'John', 'Doe', 'TRAINER_ROLE'),
    (3,'client@fitzal.com', 'client123', 'Jane', 'Smith', 'CLIENT_ROLE');

-- Добавление начальных событий
INSERT INTO events (id, title, description, date, trainer_id)
VALUES
    (1,'Yoga Class', 'Morning yoga session', '2023-10-15 09:00:00', 2),
    (2,'Strength Training', 'Weightlifting and cardio', '2023-10-16 18:00:00', 2);

-- Добавление участников в события
INSERT INTO event_participants (event_id, user_id)
VALUES
    (1, 3), -- Jane (client) участвует в Yoga Class
    (2, 3); -- Jane (client) участвует в Strength Training