insert into Users (USERID, FIRSTNAME, LASTNAME, USERNAME) VALUES
  (1, 'Max', 'Muster', 'maxi'),
  (2, 'Susi', 'Sonne', 'sunny');

insert into Article (ID, CONTENT, TITLE, AUTHOR_ID) values
  (1, 'First Steps with JPA', 'TODO: Add details how to use JPA', 1),
  (2, 'Create REST-API with Quarkus', 'TODO: Add REST-Tutorial', 2),
  (3, 'Advanced JPA', 'TODO: Add details here... ', 1);


insert into Comment (ID, TEXT, ARTICLE_ID, USER_USERID) values
  (1, 'Forget to mention details about LOB columns', 1, 1),
  (2, 'Hope that´s not too complicated...', 1, 2),
  (3, 'Wow, that´s really easy...', 2, 1);

-- to avoid duplicate numbers for primary keys
drop sequence hibernate_sequence RESTRICT ;
create sequence hibernate_sequence start with 100;