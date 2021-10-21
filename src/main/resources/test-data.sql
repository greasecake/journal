insert into "group" (name)
values
    ('А'),
    ('Б');

insert into student (first_name, last_name, is_head, group_id)
values
    ('Василий', 'Пупкин', true, 1),
    ('Иван', 'Иванов', true, 2),
    ('Петр', 'Петров', false, 2);

insert into subject (name)
values
    ('Математика'),
    ('Физика'),
    ('Химия'),
    ('Русский язык');

insert into journal (student_id, subject_id, grade)
values
    (1, 1, 5),
    (1, 2, 4),
    (1, 4, 3),
    (2, 3, 2),
    (2, 2, 5),
    (2, 1, 3),
    (2, 4, 4),
    (3, 3, 5),
    (3, 2, 5),
    (3, 1, 4),
    (3, 4, 3),
    (3, 1, 2);

insert into schedule (day_of_week, time, subject_id, group_id, room_number)
values
    ('MONDAY', '10:00', 1, 1, 10),
    ('MONDAY', '12:00', 2, 1, 11),
    ('MONDAY', '14:00', 3, 1, 12),
    ('MONDAY', '16:00', 4, 1, 13),
    ('MONDAY', '10:00', 4, 2, 13),
    ('MONDAY', '12:00', 3, 2, 12),
    ('MONDAY', '14:00', 2, 2, 11),
    ('MONDAY', '16:00', 1, 2, 10),

    ('TUESDAY', '10:00', 1, 1, 10),
    ('TUESDAY', '12:00', 2, 1, 11),
    ('TUESDAY', '14:00', 3, 1, 12),
    ('TUESDAY', '16:00', 4, 1, 13),
    ('TUESDAY', '10:00', 4, 2, 13),
    ('TUESDAY', '12:00', 3, 2, 12),
    ('TUESDAY', '14:00', 2, 2, 11),
    ('TUESDAY', '16:00', 1, 2, 10),

    ('WEDNESDAY', '10:00', 1, 1, 10),
    ('WEDNESDAY', '12:00', 2, 1, 11),
    ('WEDNESDAY', '14:00', 3, 1, 12),
    ('WEDNESDAY', '16:00', 4, 1, 13),
    ('WEDNESDAY', '10:00', 4, 2, 13),
    ('WEDNESDAY', '12:00', 3, 2, 12),
    ('WEDNESDAY', '14:00', 2, 2, 11),
    ('WEDNESDAY', '16:00', 1, 2, 10),

    ('THURSDAY', '10:00', 1, 1, 10),
    ('THURSDAY', '12:00', 2, 1, 11),
    ('THURSDAY', '14:00', 3, 1, 12),
    ('THURSDAY', '16:00', 4, 1, 13),
    ('THURSDAY', '10:00', 4, 2, 13),
    ('THURSDAY', '12:00', 3, 2, 12),
    ('THURSDAY', '14:00', 2, 2, 11),
    ('THURSDAY', '16:00', 1, 2, 10),

    ('FRIDAY', '10:00', 1, 1, 10),
    ('FRIDAY', '12:00', 2, 1, 11),
    ('FRIDAY', '14:00', 3, 1, 12),
    ('FRIDAY', '16:00', 4, 1, 13),
    ('FRIDAY', '10:00', 4, 2, 13),
    ('FRIDAY', '12:00', 3, 2, 12),
    ('FRIDAY', '14:00', 2, 2, 11),
    ('FRIDAY', '16:00', 1, 2, 10);
       