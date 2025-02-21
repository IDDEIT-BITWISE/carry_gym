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
INSERT INTO events (title, description, time, day, trainer_id)
VALUES
    ('Yoga Class', 'Morning yoga session', '08:00', 1, 1),
    ('Strength Training', 'Weightlifting and cardio', '10:30', 1, 2),
    ('Pilates', 'Core strength and flexibility', '18:00', 1, 3),

    ('Boxing', 'High-intensity boxing workout', '09:00', 2, 1),
    ('CrossFit', 'Strength and conditioning', '11:00', 2, 2),
    ('Zumba', 'Dance fitness class', '19:00', 2, 4),

    ('HIIT', 'High-Intensity Interval Training', '07:30', 3, 3),
    ('Bodybuilding', 'Advanced strength training', '14:00', 3, 1),
    ('Spinning', 'Indoor cycling class', '17:30', 3, 2),

    ('Yoga Class', 'Evening relaxation yoga', '18:00', 4, 4),
    ('Strength Training', 'Advanced weightlifting', '19:30', 4, 3),
    ('Cardio Blast', 'Endurance and stamina training', '20:00', 4, 1),

    ('Boxing', 'Technical boxing session', '12:00', 5, 2),
    ('CrossFit', 'Strength and mobility', '15:00', 5, 3),
    ('Pilates', 'Rehabilitation and flexibility', '17:00', 5, 4),

    ('HIIT', 'Intense circuit training', '08:30', 6, 1),
    ('Zumba', 'Latin dance workout', '10:00', 6, 2),
    ('Spinning', 'Endurance cycling', '19:00', 5, 3),

    ('Yoga Class', 'Deep stretch and balance', '09:30', 7, 4),
    ('Bodybuilding', 'Full-body strength workout', '16:00', 1, 1),
    ('CrossFit', 'Agility and power training', '18:30', 4, 2);



INSERT INTO event_participants (event_id, user_id)
VALUES
    (1, 2), -- Jane (client) участвует в Yoga Class
    (2, 2); -- Jane (client) участвует в Strength Training

INSERT INTO news (publication_date, title, content)
VALUES
    ('2023-10-15 09:00:00', 'БЕСПЛАТНОЕ ЗАНЯТИЕ ПО БРЕЙКДАНСУ', 'Не пропустите мастер-класс от профессионала Артёма Мотошкина'),
    ('2023-10-18 19:00:00', 'БЕСПЛАТНОЕ ЗАНЯТИЕ ПО БРЕЙКДАНСУ', 'Не пропустите мастер-класс от профессионала Артёма Мотошкина'),
    ('2023-10-19 11:00:00', 'БЕСПЛАТНОЕ ЗАНЯТИЕ ПО БРЕЙКДАНСУ', 'Не пропустите мастер-класс от профессионала Артёма Мотошкина');