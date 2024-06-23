CREATE DATABASE OpenXavaProjectdb
CREATE LOGIN Usuario WITH PASSWORD = '1234'
USE OpenXavaProjectdb
CREATE USER UsuarioBD FOR LOGIN Usuario
ALTER ROLE [db_owner] ADD MEMBER UsuarioBD
CREATE TABLE Recepcionista (idRecepcionista VARCHAR(50), Cedula VARCHAR(50), name VARCHAR(50), password VARCHAR(50))
INSERT INTO [OpenXavaProjectdb].[dbo].[Recepcionista] (idRecepcionista, Cedula, name, password)
VALUES ('1', '1', 'sol', '1');