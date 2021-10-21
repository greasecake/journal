create type DAY_OF_WEEK as enum (
    'MONDAY',
    'TUESDAY',
    'WEDNESDAY',
    'THURSDAY',
    'FRIDAY',
    'SATURDAY',
    'SUNDAY'
);

create table student (
    id bigint primary key generated always as identity,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    group_id bigint references "group"(id),
    is_head bool
);

create table subject (
    id bigint primary key generated always as identity,
    name varchar(40) not null
);

create table "group" (
    id bigint primary key generated always as identity,
    name varchar(20) not null
);

create table schedule (
    day_of_week DAY_OF_WEEK,
    time time,
    subject_id bigint references subject(id),
    group_id bigint references "group"(id),
    room_number bigint
);

create table journal (
    student_id bigint references student(id),
    subject_id bigint references subject(id),
    grade int not null
);