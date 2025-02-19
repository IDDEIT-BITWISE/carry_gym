-- Добавление начальных пользователей
INSERT INTO users (email, password, first_name, last_name, role)
VALUES
    ('admin@fitzal.com', '{noop}admin123', 'Admin', 'User', 'MODERATOR_ROLE'),
    ('client@fitzal.com', '{noop}client123', 'Jane', 'Smith', 'CLIENT_ROLE');

INSERT INTO trainers (bio, specialization, first_name, last_name, photo_path)
VALUES
    ('сидел по 105', 'алкаш', 'Фить-Фить', 'Пкрлоь', '/img/coach_1.png'),
    ('пацан из белореченска', 'баксёр', 'Андрей', 'Алексеев', '/img/coach_2.png'),
    ('пахахахахаха нахуй он взял тему приложение хэлпер для врачей анестезиологов', 'Зам по нихуям', 'Сергей', 'Ковальчук', '/img/coach_3.png'),
    ('Две в сырном', 'шаурмэн', 'Самвел', 'Погосян', '/img/coach_4.png');
-- Добавление начальных событий
INSERT INTO events (title, description, date, trainer_id)
VALUES
    ('Yoga Class', 'Morning yoga session', '2023-10-15 09:00:00', 1),
    ('Strength Training', 'Weightlifting and cardio', '2023-10-16 18:00:00', 1);


INSERT INTO event_participants (event_id, user_id)
VALUES
    (1, 2), -- Jane (client) участвует в Yoga Class
    (2, 2); -- Jane (client) участвует в Strength Training