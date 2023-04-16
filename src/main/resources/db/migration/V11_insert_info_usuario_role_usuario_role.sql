insert into usuario (nome, email, password) values ('admin', 'admin@email.com', '$2a$12$M0RLHIBPaoux3wDqgric5eXOewgMKZPKjDiORq/CKB0xzHBKA/7ie');
insert into role (nome) values ('ADMIN');
insert into usuario_role (usuario_id, role_id) values (2, 2);