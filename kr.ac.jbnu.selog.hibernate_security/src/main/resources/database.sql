--- create database and set previledge to root account

create database simpleweb;
use simpleweb;
grant all privileges on simpleweb.* to root@localhost ;

/*All User's gets stored in APP_USER table*/
create table APP_USER (
   id BIGINT NOT NULL AUTO_INCREMENT,
   sso_id VARCHAR(30) NOT NULL,
   password VARCHAR(100) NOT NULL,
   first_name VARCHAR(30) NOT NULL,
   last_name  VARCHAR(30) NOT NULL,
   email VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (sso_id)
);
   
/* USER_PROFILE table contains all possible roles */ 
create table USER_PROFILE(
   id BIGINT NOT NULL AUTO_INCREMENT,
   type VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (type)
);
   
/* JOIN TABLE for MANY-TO-MANY relationship*/  
CREATE TABLE APP_USER_USER_PROFILE (
    user_id BIGINT NOT NULL,
    user_profile_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, user_profile_id),
    CONSTRAINT FK_APP_USER FOREIGN KEY (user_id) REFERENCES APP_USER (id),
    CONSTRAINT FK_USER_PROFILE FOREIGN KEY (user_profile_id) REFERENCES USER_PROFILE (id)
);

CREATE TABLE Post (
	post_key int not null AUTO_INCREMENT,
	post_title varchar(200) not null,
	post_content varchar(5000) not null,
	post_visible int not null,
	post_owner varchar(30) not null,
	primary key(post_key)
);

  
/* Populate USER_PROFILE Table */
INSERT INTO USER_PROFILE(type)
VALUES ('USER');
  
INSERT INTO USER_PROFILE(type)
VALUES ('ADMIN');
  
INSERT INTO USER_PROFILE(type)
VALUES ('DBA');
  
/* post table testing */
INSERT INTO Post (post_title, post_content, post_visible, post_owner)
VALUES("test title", "test content", 1, "song");  
INSERT INTO Post (post_title, post_content, post_visible, post_owner)
VALUES("test title", "test content", 1, "song");  
INSERT INTO Post (post_title, post_content, post_visible, post_owner)
VALUES("test title", "test content", 1, "song");  
  
/* Populate one Admin User which will further create other users for the application using GUI */
INSERT INTO APP_USER(sso_id, password, first_name, last_name, email)
VALUES ('song','$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'Seounghan','Song','shak5643@gmail.com');
  
  
/* Populate JOIN Table */
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user user, user_profile profile
  where user.sso_id='song' and profile.type='ADMIN';
 
/* Create persistent_logins Table used to store rememberme related stuff*/
CREATE TABLE persistent_logins (
    username VARCHAR(64) NOT NULL,
    series VARCHAR(64) NOT NULL,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP NOT NULL,
    PRIMARY KEY (series)
);