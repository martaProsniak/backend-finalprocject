--String id, String name, String surname, String login, Boolean isAccepted, UserRole role

INSERT INTO user(NAME, SURNAME, LOGIN, ACCEPTED, ROLE) VALUES
('Tomek', 'Gutowski', 'tomek@o2.pl', true, 'ADMIN'),
('Marta', 'Prosniak', 'marta@o2.pl', true, 'USER');
--
-- String name, String description, double price, boolean available
INSERT INTO products(NAME, DESCRIPTION, PRICE, AVAILABLE, URL) VALUES
('produkt1', 'opis', 10, true, 'ojowej.pl'),
('produkt2', 'opis', 10, true,'ojowej.pl'),
('produkt3', 'opis', 10, true,'ojowej.pl');