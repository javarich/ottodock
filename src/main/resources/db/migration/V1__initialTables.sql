-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE otto_user (
   user_Id       INTEGER PRIMARY KEY,
   email         VARCHAR (100),
   password      VARCHAR (100),
   admin         boolean DEFAULT FALSE,
   first_name    VARCHAR (20)   NOT NULL,
   last_name     VARCHAR (20)   NOT NULL,
   address       VARCHAR (100),
   address2      VARCHAR (100),
   city          VARCHAR (100),
   state         VARCHAR (20),
   zip           VARCHAR (10),
   createdTS     TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
   modifiedTS    TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE dock_metric (
   dock_id       INTEGER NOT NULL,
   north         FLOAT NOT NULL,
   east          FLOAT NOT NULL,
   down          FLOAT NOT NULL,
   temperature   FLOAT NOT NULL,
   wind_speed    FLOAT NOT NULL,
   measurementTS TIMESTAMP,
   createdTS     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE SEQUENCE user_id_seq
AS INTEGER  MINVALUE 100
OWNED BY otto_user.user_Id;

insert into otto_user (user_Id, email, password, admin, first_name, last_name)
values (1, 'otto@ottodock.com', 'ptl', true, 'Otto','Admin');
insert into otto_user (user_Id, email, password, admin, first_name, last_name)
values (2, 'rich@ottodock.com', 'ptl', true, 'Rich','Admin');
insert into otto_user (user_Id, email, password, admin, first_name, last_name)
values (3, 'tom@ottodock.com', 'ptl', true, 'Tom','Admin');


-- Lake Table
-- Lake Name, lakeId, any other lake specific meta data


-- Dock Ref Table
-- dockId, dockName, lakeId, user_Id, lat, long, bearingOfCenterLine, any other Dock meta data, installDate, ...

-- Dock Condition Table -- Last 30 Days of detail data

-- Dock Condition Archive -- Older / Avg / Hourly or Daily Readings