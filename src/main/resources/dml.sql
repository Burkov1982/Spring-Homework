
insert into users (id, first_name, last_name, email, password, user_role, user_status)
values ('ea638d79-1242-4845-8d52-93ae31a276e6', 'Admin', 'Admin', 'admin@gmail.com', '$2a$10$DDgjpgEBJFmNJMd4oMKUeuGTEug.OdgqslNH7uGC2XF8/6yNZ3HXm', 'ROLE_ADMIN', 'ACTIVE');

insert into users (id, first_name, last_name, email, password, user_role, user_status)
values ('6b429b50-07b7-41e5-af0a-deee32311379', 'User', 'User', 'user@gmail.com', '$2a$10$BpS7YQfCuiBg1aYgmOfuP.r94kMJKpJRyg2GMQ7daOtILjsraElfu', 'ROLE_USER', 'ACTIVE');

insert into manufacturers (manufacturer_name) values ('samsung');
insert into products (product_name, product_price, manufacturer_id) values ('m30s', '250', '13b22122-6bd1-499a-8bf9-493c18a2fb86');
insert into products (product_name, product_price, manufacturer_id) values ('m21', '249.99', '13b22122-6bd1-499a-8bf9-493c18a2fb86');