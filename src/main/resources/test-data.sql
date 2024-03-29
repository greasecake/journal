set search_path to student_journal;

insert into "group" (group_name)
values
    ('А'),
    ('Б');

insert into student (first_name, last_name, is_head, group_id)
values
    ('Василий', 'Пупкин', true, 1),
    ('Иван', 'Иванов', true, 2),
    ('Петр', 'Петров', false, 2);

insert into subject (subject_name)
values
    ('Математика'),
    ('Физика'),
    ('Химия'),
    ('Русский язык');

insert into journal (date, student_id, subject_id, grade)
values
    (now(), 1, 1, 5),
    (now(), 1, 2, 4),
    (now(), 1, 4, 5),
    (now(), 2, 3, 2),
    (now(), 2, 2, 5),
    (now(), 2, 1, 3),
    (now(), 2, 4, 4),
    (now(), 3, 3, 5),
    (now(), 3, 2, 5),
    (now(), 3, 1, 4),
    (now(), 3, 4, 3),
    (now(), 3, 1, 2);

insert into schedule (day_of_week, time, subject_id, group_id, room_number)
values
    ('Понедельник', '10:00', 1, 1, 10),
    ('Понедельник', '12:00', 2, 1, 11),
    ('Понедельник', '14:00', 3, 1, 12),
    ('Понедельник', '16:00', 4, 1, 13),
    ('Понедельник', '10:00', 4, 2, 13),
    ('Понедельник', '12:00', 3, 2, 12),
    ('Понедельник', '14:00', 2, 2, 11),
    ('Понедельник', '16:00', 1, 2, 10),

    ('Вторник', '10:00', 1, 1, 10),
    ('Вторник', '12:00', 2, 1, 11),
    ('Вторник', '14:00', 3, 1, 12),
    ('Вторник', '16:00', 4, 1, 13),
    ('Вторник', '10:00', 4, 2, 13),
    ('Вторник', '12:00', 3, 2, 12),
    ('Вторник', '14:00', 2, 2, 11),
    ('Вторник', '16:00', 1, 2, 10),

    ('Среда', '10:00', 1, 1, 10),
    ('Среда', '12:00', 2, 1, 11),
    ('Среда', '14:00', 3, 1, 12),
    ('Среда', '16:00', 4, 1, 13),
    ('Среда', '10:00', 4, 2, 13),
    ('Среда', '12:00', 3, 2, 12),
    ('Среда', '14:00', 2, 2, 11),
    ('Среда', '16:00', 1, 2, 10),

    ('Четверг', '10:00', 1, 1, 10),
    ('Четверг', '12:00', 2, 1, 11),
    ('Четверг', '14:00', 3, 1, 12),
    ('Четверг', '16:00', 4, 1, 13),
    ('Четверг', '10:00', 4, 2, 13),
    ('Четверг', '12:00', 3, 2, 12),
    ('Четверг', '14:00', 2, 2, 11),
    ('Четверг', '16:00', 1, 2, 10),

    ('Пятница', '10:00', 1, 1, 10),
    ('Пятница', '12:00', 2, 1, 11),
    ('Пятница', '14:00', 3, 1, 12),
    ('Пятница', '16:00', 4, 1, 13),
    ('Пятница', '10:00', 4, 2, 13),
    ('Пятница', '12:00', 3, 2, 12),
    ('Пятница', '14:00', 2, 2, 11),
    ('Пятница', '16:00', 1, 2, 10);
       