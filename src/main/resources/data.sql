-- -------------------------------------------------------------------------------------
--                                                                                    --
--                  Inserção de dados na tabela ADDRESS                               --
--                                                                                    --
-- -------------------------------------------------------------------------------------

INSERT INTO address (street_name, house_number, zipcode)
VALUES
    ('Main Street', 123, '12345-678'),      ('Oak Avenue', 456, '98765-422'),      ('Maple Lane', 789, '54321-876'),
    ('Elm Street', 321, '87654-333'),       ('Cedar Road', 654, '23456-789'),      ('Pine Avenue', 987, '76543-210'),
    ('Birch Lane', 246, '65432-987'),       ('Willow Street', 579, '43210-765'),   ('Spruce Road', 864, '87654-123'),
    ('Chestnut Avenue', 197, '54321-098'),  ('Sycamore Lane', 531, '21098-765'),   ('Juniper Road', 874, '56789-012'),
    ('Ash Street', 209, '10987-654'),       ('Magnolia Avenue', 467, '76543-218'), ('Beech Lane', 832, '32109-876'),
    ('Hickory Road', 175, '98865-432'),     ('Poplar Street', 324, '54321-998'),   ('Dogwood Avenue', 769, '21198-765'),
    ('Fir Lane', 923, '56769-012'),         ('Cypress Road', 658, '11987-654'),    ('Redwood Avenue', 212, '76543-299'),
    ('Palm Street', 478, '32309-876'),      ('Bamboo Lane', 731, '98775-432'),     ('Cactus Road', 267, '54321-198'),
    ('Olive Street', 614, '31098-765'),     ('Cherry Avenue', 957, '56889-012'),   ('Pear Lane', 382, '12987-654'),
    ('Linden Road', 529, '76543-211'),      ('Acacia Avenue', 864, '33109-876'),   ('Willow Street', 197, '98861-432'),
    ('Rose Lane', 444, '54321-298'),        ('Vine Road', 777, '21778-765'),       ('Daisy Avenue', 222, '96789-012'),
    ('Tulip Lane', 555, '19987-654'),       ('Ivy Street', 888, '76543-310'),      ('Sunflower Avenue', 333, '42109-876'),
    ('Lilac Lane', 666, '98743-432'),       ('Meadow Road', 999, '54321-398'),     ('Orchard Street', 111, '21098-999'),
    ('Gavea Rio Street', 222, '71178-700');

-- -------------------------------------------------------------------------------------
--                                                                                    --
--                  Inserção de dados na tabela CLIENT                                --
--                                                                                    --
-- -------------------------------------------------------------------------------------

INSERT INTO client (name, email, phone, cpf, birth_date, address_id, username, password, role)
VALUES
    ('John Doe', 'johndoe@example.com', '12342567890', '12345678901', '1990-05-10', 1, 'johndoe', '12345', 'ADMIN'),
    ('Jane Smith', 'janesmith@example.com', '987654003210', '98765432109', '1988-12-15', 2, 'janesmith', '54321', 'ADMIN'),
    ('Michael Johnson', 'michaeljohnson@example.com', '2345678901', '45678901234', '1995-09-20', 3, 'michaeljohnson', '012345', 'USER'),
    ('Emily Davis', 'emilydavis@example.com', '8765552109', '56789012345', '1992-03-08', 4, 'emilydavis', '012345', 'USER'),
    ('Daniel Wilson', 'danielwilson@example.com', '7654333098', '92323456789', '1987-07-25', 5, 'danielwilson', '012345', 'USER'),
    ('Sophia Brown', 'sophiabrown@example.com', '6543210988', '22567890123', '1998-11-02', 6, 'sophiabrown', '012345', 'USER'),
    ('Oliver Taylor', 'olivertaylor@example.com', '543210999', '78801234567', '1991-01-17', 7, 'olivertaylor', '012345', 'USER'),
    ('Ava Miller', 'avamiller@example.com', '4221198765', '234567890232', '1994-06-23', 8, 'avamiller', '012345', 'USER'),
    ('William Anderson', 'williamanderson@example.com', '1287654321', '678903456', '1989-09-05', 9, 'williamanderson', '012345', 'USER'),
    ('Mia Thomas', 'miathomas@example.com', '3210977657', '01234560017890', '1997-04-12', 10, 'miathomas', '012345', 'USER'),
    ('Olivia Garcia', 'oliviagarcia@example.com', '1098765482', '88872345678', '1993-08-20', 11, 'oliviagarcia', '012345', 'USER'),
    ('James Martinez', 'jamesmartinez@example.com', '4109876543', '90123456888', '1996-05-25', 12, 'jamesmartinez', '012345', 'USER'),
    ('Sophie Robinson', 'sophierobinson@example.com', '1211987688', '23451236789012', '1992-02-03', 13, 'sophierobinson', '012345', 'USER'),
    ('Benjamin Clark', 'benjaminclark@example.com', '4521998765', '34447890123', '1988-11-10', 14, 'benjaminclark', '012345', 'USER'),
    ('Amelia Walker', 'ameliawalker@example.com', '5437709876', '45888901234', '1997-03-15', 15, 'ameliawalker', '012345', 'USER'),
    ('Henry Hall', 'henryhall@example.com', '6133211987', '561119012345', '1995-10-21', 16, 'henryhall', '012345', 'USER'),
    ('Ella Lewis', 'ellalewis@example.com', '7656621098', '67890123423', '1991-07-28', 17, 'ellalewis', '012345', 'USER'),
    ('Alexander Young', 'alexanderyoung@example.com', '8797432109', '90901234567', '1989-04-04', 18, 'alexanderyoung', '012345', 'USER'),
    ('Grace Hernandez', 'gracehernandez@example.com', '987654323210', '089012315638', '1994-09-11', 19, 'gracehernandez', '012345', 'USER'),
    ('Joseph Moore', 'josephmoore@example.com', '12345678390', '01333456789', '1993-02-16', 20, 'josephmoore', '012345', 'USER'),
    ('Chloe Jackson', 'chloejackson@example.com', '234567890231', '012300234567890', '1998-06-22', 21, 'chloejackson', '012345', 'USER'),
    ('Daniel White', 'danielwhite@example.com', '3456789012', '12300678901', '1987-01-27', 22, 'danielwhite', '012345', 'USER'),
    ('Lily Green', 'lilygreen@example.com', '4567890123', '023456789012312', '1996-04-03', 23, 'lilygreen', '012345', 'USER'),
    ('Samuel King', 'samuelking@example.com', '5678901234', '3456781234123', '1992-09-08', 24, 'samuelking', '012345', 'USER'),
    ('Mila Perez', 'milaperez@example.com', '6789012345', '45699901234', '1995-12-13', 25, 'milaperez', '012345', 'USER'),
    ('Gabriel Turner', 'gabrielturner@example.com', '7890123444', '567890131445', '1990-11-19', 26, 'gabrielturner', '012345', 'USER'),
    ('Scarlett Scott', 'scarlettscott@example.com', '8901234567', '381790123456', '1997-07-24', 27, 'scarlettscott', '012345', 'USER'),
    ('Ryan Hill', 'ryanhill@example.com', '9012345618', '10001234567', '1994-02-28', 28, 'ryanhill', '012345', 'USER'),
    ('Victoria Adams', 'victoriaadams@example.com', '1987654321', '123012345678', '1991-05-07', 29, 'victoriaadams', '012345', 'USER'),
    ('Henry Rodriguez', 'henryrodriguez@example.com', '9231876543210', '9055556789', '1988-10-12', 30, 'henryrodriguez', '012345', 'USER'),
    ('Aria Cook', 'ariacook@example.com', '8765432000', '01234569287890', '1993-03-19', 31, 'ariacook', '012345', 'USER'),
    ('Ethan Bailey', 'ethanbailey@example.com', '7654320198', '12345678999', '1996-08-25', 32, 'ethanbailey', '012345', 'USER'),
    ('Hannah Reed', 'hannahreed@example.com', '6593218987', '234567890100122', '1992-07-02', 33, 'hannahreed', '012345', 'USER'),
    ('Sebastian Ward', 'sebastianward@example.com', '5432199876', '3455890123', '1989-04-08', 34, 'sebastianward', '012345', 'USER'),
    ('Avery Cox', 'averycox@example.com', '4321098778', '45678901111', '1997-09-13', 35, 'averycox', '012345', 'USER'),
    ('Aaliyah Brooks', 'aaliyahbrooks@example.com', '9910987654', '06789012345', '1995-06-20', 36, 'aaliyahbrooks', '012345', 'USER'),
    ('David Price', 'davidprice@example.com', '3109876543', '678901238916', '1990-03-27', 37, 'davidprice', '012345', 'USER'),
    ('Sofia Hayes', 'sofiahayes@example.com', '1098765419', '78901234567', '1993-10-02', 38, 'sofiahayes', '012345', 'USER'),
    ('Jackson Perry', 'jacksonperry@example.com', '9021345678', '89012345678', '1987-11-09', 39, 'jacksonperry', '012345', 'USER'),
    ('Evelyn Rogers', 'evelynrogers@example.com', '7890122450', '90123456789', '1994-06-15', 40, 'evelynrogers', '012345', 'USER');

-- -------------------------------------------------------------------------------------
--                                                                                    --
--                  Inserção de dados na tabela PET                                   --
--                                                                                    --
-- -------------------------------------------------------------------------------------

INSERT INTO pet (name, type, client_id)
VALUES
    ('Max', 'CANINE', 1), ('Silvestre', 'FELINE', 1),   ('Bella', 'FELINE', 2), ('Paolo', 'EQUINE', 2),
    ('Charlie', 'EQUINE', 3), ('Julia', 'EQUINE', 3),   ('Luna', 'FELINE', 4), ('Sol', 'FELINE', 4),
    ('Rocky', 'CANINE', 5), ('K-9', 'CANINE', 5),       ('Daisy', 'EQUINE', 6), ('Donald', 'CANINE', 6),
    ('Oliver', 'CANINE', 7), ('Olivia', 'FELINE', 7),   ('Lucy', 'CANINE', 8), ('Caramelo', 'CANINE', 8),
    ('Leo', 'EQUINE', 9), ('Ferdinandis', 'EQUINE', 9), ('Milo', 'CANINE', 10), ('Gal', 'CANINE', 10),
    ('Mia', 'FELINE', 11), ('Simba', 'FELINE', 11),     ('Cooper', 'CANINE', 13), ('Lily', 'CANINE', 12),
    ('Oscar', 'CANINE', 13), ('Lola', 'FELINE', 13),    ('Maximus', 'EQUINE', 14), ('Molly', 'FELINE', 14),
    ('Buddy', 'CANINE', 15), ('Sophie', 'FELINE', 15),  ('Toby', 'CANINE', 16), ('Chloe', 'FELINE', 16),
    ('Bailey', 'CANINE', 17), ('Luna', 'FELINE', 17),   ('Cooper', 'CANINE', 18), ('Bella', 'FELINE', 18),
    ('Rocky', 'CANINE', 19), ('Cleo', 'FELINE', 19),    ('Bear', 'CANINE', 20), ('Zoe', 'FELINE', 20),
    ('Bentley', 'CANINE', 21), ('Mia', 'CANINE', 21),   ('Harley', 'CANINE', 22), ('Lily', 'FELINE', 22),
    ('Zeus', 'CANINE', 23), ('Nala', 'FELINE', 23),     ('Duke', 'CANINE', 24), ('Milo', 'FELINE', 24),
    ('Jackson', 'CANINE', 25), ('Lucy', 'FELINE', 25),  ('Henry', 'CANINE', 26), ('Coco', 'FELINE', 26),
    ('Charlie', 'CANINE', 27), ('Luna', 'FELINE', 27),  ('Rocky', 'CANINE', 28), ('Mia', 'FELINE', 28),
    ('Buddy', 'CANINE', 29), ('Bruce', 'EQUINE', 29),   ('Lucy', 'FELINE', 30), ('Max', 'CANINE', 30),
    ('Milo', 'CANINE', 31), ('Lily', 'FELINE', 31),     ('Rocky', 'CANINE', 32), ('Chloe', 'FELINE', 32),
    ('Cooper', 'CANINE', 33), ('Sophie', 'FELINE', 33), ('Bentley', 'CANINE', 34), ('Mia', 'FELINE', 34),
    ('Jackson', 'CANINE', 35), ('Luna', 'FELINE', 35),  ('Oliver', 'CANINE', 36), ('Lola', 'FELINE', 36),
    ('Leo', 'CANINE', 37), ('Mia', 'FELINE', 37),       ('Charlie', 'CANINE', 38), ('Sophie', 'FELINE', 38),
    ('Rocky', 'CANINE', 39), ('Chloe', 'FELINE', 39),   ('Max', 'CANINE', 40), ('Luna', 'FELINE', 40);