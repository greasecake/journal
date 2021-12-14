drop schema if exists school_journal cascade;
create schema school_journal;
set search_path to school_journal;

create type DAY_OF_WEEK as enum (
    'Понедельник',
    'Вторник',
    'Среда',
    'Четверг',
    'Пятница',
    'Суббота',
    'Воскресенье'
);

create table groups (
    id bigint primary key generated always as identity,
    group_name varchar(20) not null
);

create table students (
    id bigint primary key generated always as identity,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    group_id bigint references groups(id) not null,
    is_head bool default false not null
);

create table subjects (
    id bigint primary key generated always as identity,
    subject_name varchar(40) not null
);

create table schedule (
    id bigint primary key generated always as identity,
    day_of_week DAY_OF_WEEK not null,
    time time not null,
    subject_id bigint references subjects(id) not null,
    group_id bigint references groups(id) not null,
    room_number bigint
);

create table journal (
    id bigint primary key generated always as identity,
    date date not null,
    student_id bigint references students(id) not null,
    subject_id bigint references subjects(id) not null,
    grade int not null
);