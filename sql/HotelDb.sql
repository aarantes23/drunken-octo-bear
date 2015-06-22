-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema HotelDb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema HotelDb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `HotelDb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `HotelDb` ;

-- -----------------------------------------------------
-- Table `HotelDb`.`Room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelDb`.`Room` (
  `id` INT NOT NULL,
  `number` INT NOT NULL,
  `floot` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `dailyValue` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDb`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelDb`.`Client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `rg` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `sex` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDb`.`Check_out`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelDb`.`Check_out` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelDb`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `rg` VARCHAR(45) NOT NULL,
  `sex` VARCHAR(45) NOT NULL,
  `birthday` VARCHAR(45) NOT NULL,
  `userType` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDb`.`Check_In`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelDb`.`Check_In` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDb`.`Reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelDb`.`Reservation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Room_id` INT NOT NULL,
  `Client_id` INT NOT NULL,
  `User_id` INT NOT NULL,
  `Check_out_id` INT NOT NULL,
  `Check_In_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Room_id`, `Client_id`, `User_id`, `Check_out_id`, `Check_In_id`),
  INDEX `fk_Reserva_Quartos1_idx` (`Room_id` ASC),
  INDEX `fk_Reserva_Cliente1_idx` (`Client_id` ASC),
  INDEX `fk_Reserva_Check_out1_idx` (`Check_out_id` ASC),
  INDEX `fk_Reserva_Usuario1_idx` (`User_id` ASC),
  INDEX `fk_Reserva_Check_In1_idx` (`Check_In_id` ASC),
  CONSTRAINT `fk_Reserva_Quartos1`
    FOREIGN KEY (`Room_id`)
    REFERENCES `HotelDb`.`Room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Cliente1`
    FOREIGN KEY (`Client_id`)
    REFERENCES `HotelDb`.`Client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Check_out1`
    FOREIGN KEY (`Check_out_id`)
    REFERENCES `HotelDb`.`Check_out` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Usuario1`
    FOREIGN KEY (`User_id`)
    REFERENCES `HotelDb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Check_In1`
    FOREIGN KEY (`Check_In_id`)
    REFERENCES `HotelDb`.`Check_In` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDb`.`Item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelDb`.`Item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDb`.`Check_out_has_Item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelDb`.`Check_out_has_Item` (
  `Check_out_id` INT NOT NULL,
  `Item_id` INT NOT NULL,
  PRIMARY KEY (`Check_out_id`, `Item_id`),
  INDEX `fk_Check_out_has_Item_Item1_idx` (`Item_id` ASC),
  INDEX `fk_Check_out_has_Item_Check_out1_idx` (`Check_out_id` ASC),
  CONSTRAINT `fk_Check_out_has_Item_Check_out1`
    FOREIGN KEY (`Check_out_id`)
    REFERENCES `HotelDb`.`Check_out` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Check_out_has_Item_Item1`
    FOREIGN KEY (`Item_id`)
    REFERENCES `HotelDb`.`Item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
