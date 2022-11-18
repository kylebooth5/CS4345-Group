# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table positions (
  id                            bigint auto_increment not null,
  course                        varchar(255),
  preference                    varchar(255),
  num_positions                 varchar(255),
  constraint pk_positions primary key (id)
);

create table user (
  dtype                         varchar(31) not null,
  id                            bigint auto_increment not null,
  username                      varchar(255),
  password                      varchar(255),
  firstname                     varchar(255),
  lastname                      varchar(255),
  smu_id                        varchar(255),
  email                         varchar(255),
  role                          varchar(255),
  major                         varchar(255),
  minor                         varchar(255),
  gpa                           varchar(255),
  year                          varchar(255),
  department                    varchar(255),
  courses                       varchar(255),
  constraint pk_user primary key (id)
);


# --- !Downs

drop table if exists positions;

drop table if exists user;

