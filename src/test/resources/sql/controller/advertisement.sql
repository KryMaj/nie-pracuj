INSERT INTO seniorities (id, name) VALUES
    (1, 'JUNIOR');


INSERT INTO technologies (id, name) VALUES
    (1, 'JAVA');



INSERT INTO companies (id, address, email, name, size) VALUES
    (1, 'Krucza 1 00-000 Miasto', 'company.co@company.com','Company Co', 250 );

INSERT INTO states (id, name) VALUES
                                  (2, 'DOLNOŚLĄSKIE'),
                                  (4, 'KUJAWSKO-POMORSKIE'),
                                  (6, 'LUBELSKIE'),
                                  (8, 'LUBUSKIE'),
                                  (10, 'ŁÓDZKIE'),
                                  (12, 'MAŁOPOLSKIE'),
                                  (14, 'MAZOWIECKIE'),
                                  (16, 'OPOLSKIE'),
                                  (18, 'PODKARPACKIE'),
                                  (20, 'PODLASKIE'),
                                  (22, 'POMORSKIE'),
                                  (24, 'ŚLĄSKIE'),
                                  (26, 'ŚWIĘTOKRZYSKIE'),
                                  (28, 'WARMIŃSKO-MAZURSKIE'),
                                  (30, 'WIELKOPOLSKIE'),
                                  (32, 'ZACHODNIOPOMORSKIE');

INSERT INTO cities (id, state_id, name) VALUES
                                            (1, 2, 'Bolesławiec'),
                                            (2, 2, 'Nowogrodziec');

INSERT INTO levels (id, name, score) VALUES
                                         (1, 'INTERN', 1),
                                         (2, 'JUNIOR', 2);

INSERT INTO advertisements (id, description, expireDate, name, publishDate, salaryFrom, salaryTo, city_id, company_id, seniority_id, technology_id) VALUES
    (1, 'Description', '2023-12-29T23:00:00', 'Ogłoszenie na java', '2022-12-29T23:00:00', 1000, 10000, 1, 1, 1, 1);

INSERT INTO skills (id, name, level_id) VALUES
    (1, 'Programming', 1);

INSERT INTO advSkills (skill_id, adv_id) VALUES

    (1, 1);

