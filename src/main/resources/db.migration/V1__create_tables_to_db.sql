create table if not exists brands
(
    id         integer generated always as identity (maxvalue 5000)
        primary key,
    brand_name varchar(20)
);

alter table brands
    owner to postgres;

create table if not exists models
(
    id         integer generated always as identity (maxvalue 50000)
        primary key,
    "ID_brand" integer     not null
        constraint "ID_brand"
            references brands
            on update cascade on delete cascade,
    model_name varchar(40) not null
);

alter table models
    owner to postgres;

create table if not exists brand_model_year
(
    id         integer generated always as identity
        constraint "BrandModelYear_pkey"
            primary key,
    "ID_model" integer not null
        constraint "ID_model"
            references models
            on update cascade on delete cascade,
    "Year"     integer not null
);

alter table brand_model_year
    owner to postgres;

create table if not exists car_owners
(
    id           integer generated always as identity
        primary key,
    name         varchar(50) not null,
    phone_number varchar(15),
    email        varchar(30)
);

alter table car_owners
    owner to postgres;

create table if not exists cars
(
    vin_code      varchar(17) not null
        primary key,
    license_plate varchar(9)  not null,
    engine_model  varchar     not null,
    engine_number integer     not null,
    body_number   varchar     not null,
    colour        varchar,
    owner_id      integer     not null
        constraint owner_id
            references car_owners,
    model_year_id integer     not null
        constraint model_year_id
            references brand_model_year
            on update cascade on delete cascade
);

alter table cars
    owner to postgres;

create table if not exists units
(
    id           integer generated always as identity
        primary key,
    decipher     varchar(20) not null,
    abbreviation varchar(7)  not null
);

alter table units
    owner to postgres;

create table if not exists work_types
(
    id   integer generated always as identity
        primary key,
    name varchar(15) not null
);

alter table work_types
    owner to postgres;

create table if not exists requests
(
    id               integer generated always as identity
        primary key,
    application_date varchar(30) not null,
    status           varchar(20) not null,
    car_vin_code     varchar(17) not null
        constraint vin_code
            references cars,
    consumables      varchar(100)
);

alter table requests
    owner to postgres;

create table if not exists details
(
    id            integer generated always as identity
        primary key,
    number        integer    not null,
    type          varchar    not null,
    quantity      integer    not null,
    model_year_id integer    not null
        constraint model_year_id
            references brand_model_year,
    "OEM"         varchar(7) not null,
    units_id      integer    not null
        constraint units_id
            references units,
    work_type_id  integer    not null
        constraint work_type_id
            references work_types
);

alter table details
    owner to postgres;

create table if not exists details_for_requests
(
    request_id integer
        constraint request_id
            references requests,
    detail_id  integer[] not null
        primary key
);

alter table details_for_requests
    owner to postgres;

create table if not exists positions
(
    id       integer generated always as identity
        primary key,
    position varchar(20) not null
);

alter table positions
    owner to postgres;

create table if not exists employee_schedules
(
    id                  integer generated always as identity
        constraint schedules_pkey
            primary key,
    vacation_start_date varchar(10),
    vacation_end_date   varchar(10),
    shift_duration      integer    not null,
    work_day_start_time varchar(5) not null
);

alter table employee_schedules
    owner to postgres;

create table if not exists employees
(
    id           integer generated always as identity
        constraint employee_id
            primary key,
    phone_number varchar(15) not null,
    name         varchar     not null,
    position_id  integer     not null
        constraint position_id
            references positions,
    schedule_id  integer     not null
        constraint schedule_id
            references employee_schedules
);

alter table employees
    owner to postgres;

create table if not exists work_schedules
(
    id                   integer not null
        primary key,
    creation_date        varchar not null,
    status               varchar not null,
    estimated_start_date varchar not null,
    estimated_end_date   varchar not null,
    employee_id          integer not null
        constraint employee_id
            references employees
);

alter table work_schedules
    owner to postgres;

create table if not exists planned_work
(
    id               integer     not null
        primary key,
    workload         integer,
    date_start       varchar(10) not null,
    date_end         varchar(10),
    request_id       integer     not null
        constraint request
            references requests,
    work_type_id     integer     not null
        constraint work_type
            references work_types,
    work_schedule_id integer     not null
        constraint work_schedule
            references work_schedules
);

alter table planned_work
    owner to postgres;

create table if not exists employees_work
(
    employee_id     integer not null
        constraint employee_id
            references employees,
    planned_work_id integer not null
        constraint planned_work_id
            references planned_work,
    constraint requests_employees
        primary key (employee_id, planned_work_id)
);

alter table employees_work
    owner to postgres;