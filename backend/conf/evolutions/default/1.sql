# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table applications (
  id                            bigint auto_increment not null,
  first_name                    varchar(255),
  last_name                     varchar(255),
  email                         varchar(255),
  phone                         varchar(255),
  gpa                           varchar(255),
  major                         varchar(255),
  year                          varchar(255),
  student_id                    varchar(255),
  constraint pk_applications primary key (id)
);

create table positions (
  id                            bigint auto_increment not null,
  course                        varchar(255),
  preference                    varchar(255),
  num_positions                 varchar(255),
  constraint pk_positions primary key (id)
);

create table user (
  id                            bigint auto_increment not null,
  username                      varchar(255),
  password                      varchar(255),
  firstname                     varchar(255),
  lastname                      varchar(255),
  constraint pk_user primary key (id)
);


# --- !Downs

drop table if exists applications;

drop table if exists positions;

drop table if exists user;

