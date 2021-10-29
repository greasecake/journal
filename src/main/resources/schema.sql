drop schema student_journal cascade;
create schema student_journal;
set search_path to student_journal;

create type DAY_OF_WEEK as enum (
    'Понедельник',
    'Вторник',
    'Среда',
    'Четверг',
    'Пятница',
    'Суббота',
    'Воскресенье'
);

create table "group" (
                         group_id bigint primary key generated always as identity,
                         group_name varchar(20) not null
);

create table student (
    student_id bigint primary key generated always as identity,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    group_id bigint references "group"(group_id) not null,
    is_head bool default false not null
);

create table subject (
    subject_id bigint primary key generated always as identity,
    subject_name varchar(40) not null
);

create table schedule (
    day_of_week DAY_OF_WEEK not null,
    time time not null,
    subject_id bigint references subject(subject_id) not null,
    group_id bigint references "group"(group_id) not null,
    room_number bigint
);

create table journal (
    date date not null,
    student_id bigint references student(student_id) not null,
    subject_id bigint references subject(subject_id) not null,
    grade int not null
);