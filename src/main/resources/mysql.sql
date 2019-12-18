CREATE TABLE `dbterm`.`books` (
  `idBooks` int(13) NOT NULL,
  `bookAuthor` VARCHAR(30) NULL,
  `bookName` VARCHAR(30) NULL,
  `bookPublisher` VARCHAR(30) NULL,
  PRIMARY KEY (`idBooks`));

CREATE TABLE `dbterm`.`booklist` (
  `idBooks` INT(13) NOT NULL,
  `numberOfBooks` INT(10) NULL,
  PRIMARY KEY (`idBooks`),
  CONSTRAINT `fk_books`
    FOREIGN KEY (`idBooks`)
    REFERENCES `dbterm`.`books` (`idBooks`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `dbterm`.`user` (
  `userID` VARCHAR(12) NOT NULL,
  `userPwd` VARCHAR(20) NOT NULL,
  `userName` VARCHAR(5) NOT NULL,
  `userEmail` VARCHAR(25) NOT NULL,
  `userPhone` VARCHAR(25) NOT NULL,
  `userType` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`userID`));


CREATE TABLE `dbterm`.`reservation` (
  `idreservation` INT(10) NOT NULL,
  `idBooks` INT(13) NULL,
  `userID` VARCHAR(12) NULL,
  `reservationWait` INT(10) NOT NULL,
  PRIMARY KEY (`idreservation`),
  INDEX `fk_bookList_idx` (`idBooks` ASC) VISIBLE,
  INDEX `fk_user_idx` (`userID` ASC) VISIBLE,
  CONSTRAINT `fk_bookList`
    FOREIGN KEY (`idBooks`)
    REFERENCES `dbterm`.`booklist` (`idBooks`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_user`
    FOREIGN KEY (`userID`)
    REFERENCES `dbterm`.`user` (`userID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


CREATE TABLE `dbterm`.`borrowbooks` (
  `idborrowBooks` INT(10) NOT NULL,
  `idBooks` INT(13) NULL,
  `userID` VARCHAR(12) NULL,
  `borrowedDate` DATE NOT NULL,
  `expectedReturn` DATE NOT NULL,
  `isReturned` INT NOT NULL,
  PRIMARY KEY (`idborrowBooks`),
  INDEX `fk_bookListfromBorrow_idx` (`idBooks` ASC) VISIBLE,
  INDEX `fk_UserfromBorrow_idx` (`userID` ASC) VISIBLE,
  CONSTRAINT `fk_bookListfromBorrow`
    FOREIGN KEY (`idBooks`)
    REFERENCES `dbterm`.`booklist` (`idBooks`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_UserfromBorrow`
    FOREIGN KEY (`userID`)
    REFERENCES `dbterm`.`user` (`userID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `dbterm`.`returnapplication` (
  `idborrowBooks` INT(10) NOT NULL,
  PRIMARY KEY (`idborrowBooks`),
  CONSTRAINT `fk_borrow_book_id`
    FOREIGN KEY (`idborrowBooks`)
    REFERENCES `dbterm`.`borrowbooks` (`idborrowBooks`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
