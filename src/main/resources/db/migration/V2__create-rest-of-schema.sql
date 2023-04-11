-- user TABLE
create table AppUser (
    id bigint not null auto_increment,
    email varchar(200) not null,
    password varchar(255) not null,
    name varchar(100) not null,
    status varchar(1) not null default 'A',
    primary key (id)
);

-- Task table
create table Task (
    id bigint not null auto_increment,
    description varchar(200) not null,
    created_by bigint not null,
    created_date datetime not null default current_timestamp,
    modified_date datetime not null default current_timestamp on update current_timestamp,
    status varchar(20) not null default 'DOING',
    primary key (id),
    foreign key (created_by) references AppUser (id)
);

-- TaskTag
create table TaskTag (
    task_id bigint not null,
    tag_id bigint not null,
    primary key (task_id, tag_id),
    foreign key (task_id) references Task (id),
    foreign key (tag_id) references Tag (id)
);
