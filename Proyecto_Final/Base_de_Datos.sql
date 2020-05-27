DROP TABLE Libro;
DROP TABLE Prestamo;

CREATE TABLE Libro (
  IDLibro int NOT NULL,
  ISBN varchar(20) NOT NULL,
  precio numeric (5,2) NOT NULL,
  UnidadesDisponibles INT NOT NULL,
  NumeroImagenes INT NOT NULL,
  NumeroVideos INT NOT NULL,
  PRIMARY KEY (IDLibro)
  );
  
CREATE TABLE Prestamo(
 IDPrestamo INT NOT NULL,
 LocalDateTime DATE NOT NULL,
 numero INT NOT NULL,
PRIMARY KEY (IDPrestamo)
 );
