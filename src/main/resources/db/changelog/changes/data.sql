create sequence person_sequence;
create table person_tutorial(
    id INTEGER not null default person_sequence.nextval,
    name varchar(255) not null,
    location varchar (255),
    birth_data timestamp ,
    primary key(id)
);

insert into person_tutorial(name,location,birth_data) values('mihai blandu', 'here','1988-12-25');
insert into person_tutorial(name,location,birth_data) values('mihai blandu', 'here','1988-12-25');
insert into person_tutorial(name,location,birth_data) values('mihai blandu', 'here','1988-12-25');
insert into person_tutorial(name,location,birth_data) values('mihai blandu', 'here','1988-12-25');
insert into person_tutorial(name,location,birth_data) values('mihai blandu', 'here','1988-12-25');
insert into person_tutorial(name,location,birth_data) values('mihai blandu', 'here','1988-12-25');
insert into person_tutorial(name,location,birth_data) values('mihai blandu', 'here','1988-12-25');
insert into person_tutorial(name,location,birth_data) values('mihai blandu', 'here','1988-12-25');
insert into person_tutorial(name,location,birth_data) values('mihai blandu', 'here','1988-12-25');
insert into person_tutorial(name,location,birth_data) values('mihai blandu', 'here','1988-12-25');
insert into person_tutorial(name,location,birth_data) values('mihai blandu', 'here','1988-12-25');

create table course(
    id INTEGER not null default person_sequence.nextval,
    name varchar(255) not null,
    lastUpdated TIMESTAMP,
    createdDate TIMESTAMP,
    primary key(id)
);

insert into course values(1,'java','2021-03-29' ,'2021-03-29' );
insert into course values(2,'sql','2021-03-29' ,'2021-03-29');
insert into course values(3,'go','2021-03-29' ,'2021-03-29');

CREATE  TABLE "PASSPORT"(
                            "ID" BIGINT NOT NULL,
                            "NUMBER" VARCHAR(255) NOT NULL,
                            primary key(ID)
);

CREATE  TABLE "STUDENTB"(
    "ID" BIGINT NOT NULL,
    "CITY" VARCHAR(255),
    "LINE1" VARCHAR(255),
    "LINE2" VARCHAR(255),
    "NAME" VARCHAR(255) NOT NULL,
    "PASSPORT_ID" BIGINT,
    lastUpdated TIMESTAMP,
    createdDate TIMESTAMP,
    primary key(ID),
    FOREIGN KEY (PASSPORT_ID) REFERENCES PASSPORT(ID)
);
CREATE  TABLE Review(
    "ID" BIGINT NOT NULL,
    "RATING" VARCHAR(255),
    "DESCRIPTION" VARCHAR(255) NOT NULL,
    "COURSE_ID" BIGINT,
    lastUpdated TIMESTAMP ,
    createdDate TIMESTAMP ,
    primary key(ID),
    FOREIGN KEY (COURSE_ID) REFERENCES course(ID)
);
CREATE TABLE Reviewrating (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         level ENUM('ZERO', 'ONE', 'TWO', 'THREE', 'FOUR', 'FIVE') NOT NULL
);
select * from Reviewrating;
--ALTER TABLE "STUDENTB" ADD CONSTRAINT "FK7AMB2U1KS5DQV5N0W1CT4MA5D" FOREIGN KEY("PASSPORT_ID") REFERENCES PASSPORT("ID") NOCHECK;

insert into Review(id,rating,DESCRIPTION,course_id)
values(1,'FIVE', 'Great Course',1);
insert into Review(id,rating,DESCRIPTION,course_id)
values(2,'FOUR', 'Wonderful Course',1);
insert into Review(id,rating,DESCRIPTION,course_id)
values(3,'FIVE', 'Awesome Course',1);
insert into Review(id,rating,DESCRIPTION,course_id)
values(4,'FIVE', 'Great Course',2);
insert into Review(id,rating,description,course_id)
values(5,'FOUR', 'Wonderful Course',2);
insert into Review(id,rating,description,course_id)
values(6,'FIVE', 'Awesome Course',2);
insert into Review(id,rating,description,course_id)
values(7,'FIVE', 'Great Course',3);
insert into Review(id,rating,description,course_id)
values(8,'FOUR', 'Wonderful Course',3);
insert into Review(id,rating,description,course_id)
values(9,'FIVE', 'Awesome Course',3);

insert into passport(id,number)
values(1,'E123456');
insert into passport(id,number)
values(2,'N123457');
insert into passport(id,number)
values(3,'L123890');
insert into passport(id,number)
values(4,'E123456');
insert into passport(id,number)
values(5,'N123457');
insert into passport(id,number)
values(6,'L123890');
insert into passport(id,number)
values(7,'E123456');
insert into passport(id,number)
values(8,'N123457');
insert into passport(id,number)
values(9,'L123890');
insert into STUDENTB(id,name,passport_id)
values(1,'Mike',1);
insert into STUDENTB(id,name,passport_id)
values(2,'Adam',2);
insert into STUDENTB(id,name,passport_id)
values(3,'Jane',3);
insert into STUDENTB(id,name,passport_id)
values(4,'Mike',4);
insert into STUDENTB(id,name,passport_id)
values(5,'Adam',5);
insert into STUDENTB(id,name,passport_id)
values(6,'Jane',6);
insert into STUDENTB(id,name,passport_id)
values(7,'Mike',7);
insert into STUDENTB(id,name,passport_id)
values(8,'Adam',8);
insert into STUDENTB(id,name,passport_id)
values(9,'Jane',9);

--drop table course_student if exists;
CREATE TABLE COURSE_STUDENT(
        course_id INTEGER NOT NULL,
        student_id INTEGER NOT NULL
);
ALTER TABLE COURSE_STUDENT ADD CONSTRAINT "course_student_FK" FOREIGN KEY(course_id) REFERENCES course(ID) NOCHECK;
ALTER TABLE COURSE_STUDENT ADD CONSTRAINT "student_course_FK" FOREIGN KEY(student_id) REFERENCES STUDENTB(ID) NOCHECK;

insert into COURSE_STUDENT values(1,1);
insert into COURSE_STUDENT values(1,2);
insert into COURSE_STUDENT values(1,3);
insert into COURSE_STUDENT values(2,3);
insert into COURSE_STUDENT values(3,3);