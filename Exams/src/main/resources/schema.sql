CREATE TABLE PERSON (
  id number auto_increment,   
  name VARCHAR(250),
  surname VARCHAR(250),
  person_type	VARCHAR(50),
  user_name VARCHAR(250),
  password VARCHAR(250),
  update_date TIMESTAMP default CURRENT_TIMESTAMP 
);

CREATE TABLE EXAMS (
  exam_id VARCHAR(100),
  start_date date,
  end_date date,
  question VARCHAR(1000),
  choice_1 VARCHAR(1000),
  choice_2 VARCHAR(1000),
  choice_3 VARCHAR(1000),
  choice_4 VARCHAR(1000),
  exams_link VARCHAR(1000)
);

CREATE TABLE ANSWER (
  answer_id VARCHAR(100),
  exam_id VARCHAR(100),
  question VARCHAR(1000),
  answer VARCHAR(1000),
  user_name VARCHAR(250),
  answer_date TIMESTAMP default CURRENT_TIMESTAMP
);


