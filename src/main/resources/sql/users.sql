--String id, String name, String surname, String login, Boolean isAccepted, UserRole role

INSERT INTO user(NAME, SURNAME, LOGIN, ACCEPTED, ROLE) VALUES
('Tomek', 'Gutowski', 'tomek@o2.pl', true, 'ADMIN'),
('Marta', 'Prosniak', 'marta@o2.pl', true, 'USER');


INSERT INTO products(NAME, DESCRIPTION, PRICE, AVAILABLE) VALUES
('produkt1', 'opis', 10, true),
('produkt2', 'opis', 10, true),
('produkt3', 'opis', 10, true);