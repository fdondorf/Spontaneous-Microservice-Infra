INSERT INTO USERS (id, email, password, firstname, lastname, gender) VALUES
  (1, 'test@test.de', 'test', 'Florian', 'Dondorf', 'MALE'),
  (2, 'test@test.com', 'test', 'Mia', 'Waltke-Dondorf', 'FEMALE');
  
INSERT INTO ROLE (id, name) VALUES
  (1, 'ROLE_USER'),
  (2, 'ROLE_ADMIN');
  
INSERT INTO USERS_ROLES (user_entity_id, roles_id) VALUES
  (1, 1),
  (2, 1);