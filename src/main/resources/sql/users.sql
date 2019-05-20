--Long id, String name, String surname, String login, String password, Boolean accepted, LocalUserRole role
--Ppassword for users is: password1 for Tomek password2 for Marta etc.
INSERT INTO user(NAME, SURNAME, LOGIN, PASSWORD, ACCEPTED, ROLE) VALUES
('Tomek', 'Gutowski', 'tomekg@o2.pl', '$2a$12$gPxV3FqqE1Evg2m1rh.8.ugCUYdmED/qZM8b8WT6n/V95NH900l.W',true, 'ADMIN'),
('Marta', 'Prosniak', 'martap@o2.pl', '$2a$12$HrN7UPEzS4etoosf6mzadeA2/Uk0faXkpWJZweCgfImZ2pfFeZl0K',true, 'ADMIN'),
('Mateusz', 'Kalwaj', 'mateuszk@o2.pl', '$2a$12$fPwznvDQ00RYCEASR22FLOCTfG6Pr8LY91vNCnVWuKIGj683Jp//S',true, 'USER'),
('Damian', 'Strzemien', 'damians@o2.pl', '$2a$12$GzlHi8XCDdvPEiYn9rRQtOW08VnnTagyDGrchO.Onzg4uOi02GWty',true, 'USER');
