-- -------------------------------------------------------------------------------------
--                                                                                    --
--                  Inserção de dados na tabela ADDRESS                                --
--                                                                                    --
-- -------------------------------------------------------------------------------------

INSERT INTO address (street_name, house_number, zipcode)
VALUES
    ('Main Street', 123, '12345-678'),
    ('Oak Avenue', 456, '98765-422'),
    ('Maple Lane', 789, '54321-876'),
    ('Elm Street', 321, '87654-333'),
    ('Cedar Road', 654, '23456-789'),
    ('Pine Avenue', 987, '76543-210'),
    ('Birch Lane', 246, '65432-987'),
    ('Willow Street', 579, '43210-765'),
    ('Spruce Road', 864, '87654-123'),
    ('Chestnut Avenue', 197, '54321-098'),
    ('Sycamore Lane', 531, '21098-765'),
    ('Juniper Road', 874, '56789-012'),
    ('Ash Street', 209, '10987-654'),
    ('Magnolia Avenue', 467, '76543-218'),
    ('Beech Lane', 832, '32109-876'),
    ('Hickory Road', 175, '98865-432'),
    ('Poplar Street', 324, '54321-998'),
    ('Dogwood Avenue', 769, '21198-765'),
    ('Fir Lane', 923, '56769-012'),
    ('Cypress Road', 658, '11987-654'),
    ('Redwood Avenue', 212, '76543-299'),
    ('Palm Street', 478, '32309-876'),
    ('Bamboo Lane', 731, '98775-432'),
    ('Cactus Road', 267, '54321-198'),
    ('Olive Street', 614, '31098-765'),
    ('Cherry Avenue', 957, '56889-012'),
    ('Pear Lane', 382, '12987-654'),
    ('Linden Road', 529, '76543-211'),
    ('Acacia Avenue', 864, '33109-876'),
    ('Willow Street', 197, '98861-432'),
    ('Rose Lane', 444, '54321-298'),
    ('Vine Road', 777, '21778-765'),
    ('Daisy Avenue', 222, '96789-012'),
    ('Tulip Lane', 555, '19987-654'),
    ('Ivy Street', 888, '76543-310'),
    ('Sunflower Avenue', 333, '42109-876'),
    ('Lilac Lane', 666, '98743-432'),
    ('Meadow Road', 999, '54321-398'),
    ('Orchard Street', 111, '21098-999'),
    ('Gavea Rio Street', 222, '71178-700');

-- -------------------------------------------------------------------------------------
--                                                                                    --
--                  Inserção de dados na tabela CLIENT                                --
--                                                                                    --
-- -------------------------------------------------------------------------------------

INSERT INTO client (name, email, phone, cpf, birth_date, address_id)
VALUES
    ('John Doe', 'johndoe@example.com', '12342567890', '12345678901', '1990-05-10', 1),
    ('Jane Smith', 'janesmith@example.com', '987654003210', '98765432109', '1988-12-15', 2),
    ('Michael Johnson', 'michaeljohnson@example.com', '2345678901', '45678901234', '1995-09-20', 3),
    ('Emily Davis', 'emilydavis@example.com', '8765552109', '56789012345', '1992-03-08', 4),
    ('Daniel Wilson', 'danielwilson@example.com', '7654333098', '92323456789', '1987-07-25', 5),
    ('Sophia Brown', 'sophiabrown@example.com', '6543210988', '22567890123', '1998-11-02', 6),
    ('Oliver Taylor', 'olivertaylor@example.com', '543210999', '78801234567', '1991-01-17', 7),
    ('Ava Miller', 'avamiller@example.com', '4221198765', '234567890232', '1994-06-23', 8),
    ('William Anderson', 'williamanderson@example.com', '1287654321', '678903456', '1989-09-05', 9),
    ('Mia Thomas', 'miathomas@example.com', '3210977657', '01234560017890', '1997-04-12', 10),
    ('Olivia Garcia', 'oliviagarcia@example.com', '1098765482', '88872345678', '1993-08-20', 11),
    ('James Martinez', 'jamesmartinez@example.com', '4109876543', '90123456888', '1996-05-25', 12),
    ('Sophie Robinson', 'sophierobinson@example.com', '1211987688', '23451236789012', '1992-02-03', 13),
    ('Benjamin Clark', 'benjaminclark@example.com', '4521998765', '34447890123', '1988-11-10', 14),
    ('Amelia Walker', 'ameliawalker@example.com', '5437709876', '45888901234', '1997-03-15', 15),
    ('Henry Hall', 'henryhall@example.com', '6133211987', '561119012345', '1995-10-21', 16),
    ('Ella Lewis', 'ellalewis@example.com', '7656621098', '67890123423', '1991-07-28', 17),
    ('Alexander Young', 'alexanderyoung@example.com', '8797432109', '90901234567', '1989-04-04', 18),
    ('Grace Hernandez', 'gracehernandez@example.com', '987654323210', '089012315638', '1994-09-11', 19),
    ('Joseph Moore', 'josephmoore@example.com', '12345678390', '01333456789', '1993-02-16', 20),
    ('Chloe Jackson', 'chloejackson@example.com', '234567890231', '012300234567890', '1998-06-22', 21),
    ('Daniel White', 'danielwhite@example.com', '3456789012', '12300678901', '1987-01-27', 22),
    ('Lily Green', 'lilygreen@example.com', '4567890123', '023456789012312', '1996-04-03', 23),
    ('Samuel King', 'samuelking@example.com', '5678901234', '3456781234123', '1992-09-08', 24),
    ('Mila Perez', 'milaperez@example.com', '6789012345', '45699901234', '1995-12-13', 25),
    ('Gabriel Turner', 'gabrielturner@example.com', '7890123444', '567890131445', '1990-11-19', 26),
    ('Scarlett Scott', 'scarlettscott@example.com', '8901234567', '381790123456', '1997-07-24', 27),
    ('Ryan Hill', 'ryanhill@example.com', '9012345618', '10001234567', '1994-02-28', 28),
    ('Victoria Adams', 'victoriaadams@example.com', '1987654321', '123012345678', '1991-05-07', 29),
    ('Henry Rodriguez', 'henryrodriguez@example.com', '9231876543210', '9055556789', '1988-10-12', 30),
    ('Aria Cook', 'ariacook@example.com', '8765432000', '01234569287890', '1993-03-19', 31),
    ('Ethan Bailey', 'ethanbailey@example.com', '7654320198', '12345678999', '1996-08-25', 32),
    ('Hannah Reed', 'hannahreed@example.com', '6593218987', '234567890100122', '1992-07-02', 33),
    ('Sebastian Ward', 'sebastianward@example.com', '5432199876', '3455890123', '1989-04-08', 34),
    ('Avery Cox', 'averycox@example.com', '4321098778', '45678901111', '1997-09-13', 35),
    ('Aaliyah Brooks', 'aaliyahbrooks@example.com', '9910987654', '06789012345', '1995-06-20', 36),
    ('David Price', 'davidprice@example.com', '3109876543', '678901238916', '1990-03-27', 37),
    ('Sofia Hayes', 'sofiahayes@example.com', '1098765419', '78901234567', '1993-10-02', 38),
    ('Jackson Perry', 'jacksonperry@example.com', '9021345678', '89012345678', '1987-11-09', 39),
    ('Evelyn Rogers', 'evelynrogers@example.com', '7890122450', '90123456789', '1994-06-15', 40);


-- -------------------------------------------------------------------------------------
--                                                                                    --
--                  Inserção de dados na tabela PET                                   --
--                                                                                    --
-- -------------------------------------------------------------------------------------

INSERT INTO pet (name, type, owner_id)
VALUES
    ('Max', 'CANINE', 1), ('Silvestre', 'FELINE', 1),
    ('Bella', 'FELINE', 2), ('Paolo', 'EQUINE', 2),
    ('Charlie', 'EQUINE', 3), ('Julia', 'EQUINE', 3),
    ('Luna', 'FELINE', 4), ('Sol', 'FELINE', 4),
    ('Rocky', 'CANINE', 5), ('K-9', 'CANINE', 5),
    ('Daisy', 'EQUINE', 6), ('Donald', 'CANINE', 6),
    ('Oliver', 'CANINE', 7), ('Olivia', 'FELINE', 7),
    ('Lucy', 'CANINE', 8), ('Caramelo', 'CANINE', 8),
    ('Leo', 'EQUINE', 9), ('Ferdinandis', 'EQUINE', 9),
    ('Milo', 'CANINE', 10), ('Gal', 'CANINE', 10),
    ('Mia', 'FELINE', 11), ('Simba', 'FELINE', 11),
    ('Cooper', 'CANINE', 12), ('Lily', 'CANINE', 12),
    ('Oscar', 'CANINE', 13), ('Lola', 'FELINE', 13),
    ('Maximus', 'EQUINE', 14), ('Molly', 'FELINE', 14),
    ('Buddy', 'CANINE', 15), ('Sophie', 'FELINE', 15),
    ('Toby', 'CANINE', 16), ('Chloe', 'FELINE', 16),
    ('Bailey', 'CANINE', 17), ('Luna', 'FELINE', 17),
    ('Rocky', 'CANINE', 18), ('Cleo', 'FELINE', 18),
    ('Bear', 'CANINE', 19), ('Zoe', 'FELINE', 19),
    ('Bentley', 'CANINE', 20), ('Mia', 'CANINE', 20),
    ('Harley', 'CANINE', 21), ('Lily', 'FELINE', 21),
    ('Zeus', 'CANINE', 22), ('Nala', 'FELINE', 22),
    ('Duke', 'CANINE', 23), ('Milo', 'FELINE', 23),
    ('Jackson', 'CANINE', 24), ('Lucy', 'FELINE', 24),
    ('Henry', 'CANINE', 25), ('Coco', 'FELINE', 25),
    ('Charlie', 'CANINE', 26), ('Luna', 'FELINE', 26),
    ('Rocky', 'CANINE', 27), ('Mia', 'FELINE', 27),
    ('Buddy', 'CANINE', 28), ('Bruce', 'EQUINE', 28),
    ('Lucy', 'FELINE', 29),  ('Max', 'CANINE', 29),
    ('Milo', 'CANINE', 30),  ('Lily', 'FELINE', 30),
    ('Rocky', 'CANINE', 31), ('Chloe', 'FELINE', 31),
    ('Cooper', 'CANINE', 32), ('Sophie', 'FELINE', 32),
    ('Bentley', 'CANINE', 33), ('Mia', 'FELINE', 33),
    ('Jackson', 'CANINE', 34), ('Luna', 'FELINE', 34),
    ('Oliver', 'CANINE', 35),  ('Lola', 'FELINE', 35),
    ('Leo', 'CANINE', 36), ('Mia', 'FELINE', 36),
    ('Charlie', 'CANINE', 37), ('Sophie', 'FELINE', 37),
    ('Rocky', 'CANINE', 38), ('Chloe', 'FELINE', 38),
    ('Max', 'CANINE', 39),  ('Luna', 'FELINE', 39),
    ('Cooper', 'CANINE', 40), ('Bella', 'FELINE', 40);