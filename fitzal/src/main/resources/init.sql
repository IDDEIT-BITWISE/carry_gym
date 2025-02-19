-- Добавление начальных пользователей
INSERT INTO users (email, password, first_name, last_name, role)
VALUES
    ('admin@fitzal.com', '{noop}admin123', 'Admin', 'User', 'MODERATOR_ROLE'),
    ('client@fitzal.com', '{noop}client123', 'Jane', 'Smith', 'CLIENT_ROLE');

INSERT INTO trainers (bio, specialization, first_name, last_name)
VALUES
    ('сидел по 105', 'алкаш', 'Фить-Фить', 'Пкрлоь'),
    ('пацан из белореченска', 'баксёр', 'Андрей', 'Алексеев');
-- Добавление начальных событий
INSERT INTO events (title, description, date, trainer_id)
VALUES
    ('Yoga Class', 'Morning yoga session', '2023-10-15 09:00:00', 1),
    ('Strength Training', 'Weightlifting and cardio', '2023-10-16 18:00:00', 1);

INSERT INTO feedbacks (client_id, event_id, rating, comment)
VALUES
    (1,1,5,'это пиздец'),
    (2,1,1,'это ахуенно');
-- Добавление участников в события
INSERT INTO event_participants (event_id, user_id)
VALUES
    (1, 2), -- Jane (client) участвует в Yoga Class
    (2, 2); -- Jane (client) участвует в Strength Training