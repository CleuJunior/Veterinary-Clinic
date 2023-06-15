-- -------------------------------------------------------------------------------------
--                                                                                    --
--                  Inserção de dados na tabela ADDRESS                                --
--                                                                                    --
-- -------------------------------------------------------------------------------------

INSERT INTO address (street_name, house_number, zipcode)
VALUES ('Main Street', 123, '12345-678');

INSERT INTO address (street_name, house_number, zipcode)
VALUES ('Oak Avenue', 456, '98765-432');

INSERT INTO address (street_name, house_number, zipcode)
VALUES ('Maple Lane', 789, '54321-876');

INSERT INTO address (street_name, house_number, zipcode)
VALUES ('Elm Street', 321, '87654-321');

INSERT INTO address (street_name, house_number, zipcode)
VALUES ('Cedar Road', 654, '23456-789');

INSERT INTO address (street_name, house_number, zipcode)
VALUES ('Pine Avenue', 987, '76543-210');

INSERT INTO address (street_name, house_number, zipcode)
VALUES ('Birch Lane', 246, '65432-987');

INSERT INTO address (street_name, house_number, zipcode)
VALUES ('Willow Street', 579, '43210-765');

INSERT INTO address (street_name, house_number, zipcode)
VALUES ('Spruce Road', 864, '87654-321');

INSERT INTO address (street_name, house_number, zipcode)
VALUES ('Chestnut Avenue', 197, '54321-098');

-- -------------------------------------------------------------------------------------
--                                                                                    --
--                  Inserção de dados na tabela CLIENT                                --
--                                                                                    --
-- -------------------------------------------------------------------------------------

INSERT INTO client (name, email, cpf, birth_date, address_id)
VALUES ('John Doe', 'johndoe@example.com', '12345678901', '1990-05-10', 1);

INSERT INTO client (name, email, cpf, birth_date, address_id)
VALUES ('Jane Smith', 'janesmith@example.com', '98765432109', '1988-12-15', 2);

INSERT INTO client (name, email, cpf, birth_date, address_id)
VALUES ('Michael Johnson', 'michaeljohnson@example.com', '45678901234', '1995-09-20', 3);

INSERT INTO client (name, email, cpf, birth_date, address_id)
VALUES ('Emily Davis', 'emilydavis@example.com', '56789012345', '1992-03-08', 4);

INSERT INTO client (name, email, cpf, birth_date, address_id)
VALUES ('Daniel Wilson', 'danielwilson@example.com', '90123456789', '1987-07-25', 5);

INSERT INTO client (name, email, cpf, birth_date, address_id)
VALUES ('Sophia Brown', 'sophiabrown@example.com', '34567890123', '1998-11-02', 6);

INSERT INTO client (name, email, cpf, birth_date, address_id)
VALUES ('Oliver Taylor', 'olivertaylor@example.com', '78901234567', '1991-01-17', 7);

INSERT INTO client (name, email, cpf, birth_date, address_id)
VALUES ('Ava Miller', 'avamiller@example.com', '23456789012', '1994-06-23', 8);

INSERT INTO client (name, email, cpf, birth_date, address_id)
VALUES ('William Anderson', 'williamanderson@example.com', '67890123456', '1989-09-05', 9);

INSERT INTO client (name, email, cpf, birth_date, address_id)
VALUES ('Mia Thomas', 'miathomas@example.com', '01234567890', '1997-04-12', 10);

-- -------------------------------------------------------------------------------------
--                                                                                    --
--                  Inserção de dados na tabela PET                                   --
--                                                                                    --
-- -------------------------------------------------------------------------------------

INSERT INTO pet (name, type, owner_id)
VALUES ('Max', 'CANINE', 1), ('Silvestre', 'FELINE', 1);

INSERT INTO pet (name, type, owner_id)
VALUES ('Bella', 'FELINE', 2), ('Paolo', 'EQUINE', 2);

INSERT INTO pet (name, type, owner_id)
VALUES ('Charlie', 'EQUINE', 3), ('Julia', 'EQUINE', 3);

INSERT INTO pet (name, type, owner_id)
VALUES ('Luna', 'FELINE', 4), ('Sol', 'FELINE', 4);

INSERT INTO pet (name, type, owner_id)
VALUES ('Rocky', 'CANINE', 5), ('K-9', 'CANINE', 5);

INSERT INTO pet (name, type, owner_id)
VALUES ('Daisy', 'EQUINE', 6), ('Donald', 'CANINE', 6);

INSERT INTO pet (name, type, owner_id)
VALUES ('Oliver', 'CANINE', 7), ('Olivia', 'FELINE', 7);

INSERT INTO pet (name, type, owner_id)
VALUES ('Lucy', 'CANINE', 8), ('Caramelo', 'CANINE', 6);

INSERT INTO pet (name, type, owner_id)
VALUES ('Leo', 'EQUINE', 9), ('Ferdinandis', 'EQUINE', 9);

INSERT INTO pet (name, type, owner_id)
VALUES ('Milo', 'CANINE', 10), ('Gal', 'CANINE', 10);