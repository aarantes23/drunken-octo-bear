-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hoteldb2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hoteldb2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hoteldb2` DEFAULT CHARACTER SET utf8 ;
USE `hoteldb2` ;

-- -----------------------------------------------------
-- Table `hoteldb2`.`check_in`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb2`.`check_in` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `date` VARCHAR(45) NOT NULL,
  `status` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hoteldb2`.`check_out`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb2`.`check_out` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `date` VARCHAR(45) NOT NULL,
  `status` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hoteldb2`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb2`.`item` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hoteldb2`.`check_out_has_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb2`.`check_out_has_item` (
  `Check_out_id` INT(11) NOT NULL,
  `Item_id` INT(11) NOT NULL,
  PRIMARY KEY (`Check_out_id`, `Item_id`),
  INDEX `fk_Check_out_has_Item_Item1_idx` (`Item_id` ASC),
  INDEX `fk_Check_out_has_Item_Check_out1_idx` (`Check_out_id` ASC),
  CONSTRAINT `fk_Check_out_has_Item_Check_out1`
    FOREIGN KEY (`Check_out_id`)
    REFERENCES `hoteldb2`.`check_out` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Check_out_has_Item_Item1`
    FOREIGN KEY (`Item_id`)
    REFERENCES `hoteldb2`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hoteldb2`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb2`.`client` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `rg` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `sex` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hoteldb2`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb2`.`room` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `number` INT(11) NOT NULL,
  `floot` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `dailyValue` DECIMAL NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hoteldb2`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb2`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `rg` VARCHAR(45) NOT NULL,
  `sex` VARCHAR(45) NOT NULL,
  `birthday` VARCHAR(45) NOT NULL,
  `userType` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hoteldb2`.`reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb2`.`reservation` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `Room_id` INT(11) NOT NULL,
  `Client_id` INT(11) NOT NULL,
  `User_id` INT(11) NOT NULL,
  `Check_out_id` INT(11) NOT NULL,
  `Check_In_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `Room_id`, `Client_id`, `User_id`, `Check_out_id`, `Check_In_id`),
  INDEX `fk_Reserva_Quartos1_idx` (`Room_id` ASC),
  INDEX `fk_Reserva_Cliente1_idx` (`Client_id` ASC),
  INDEX `fk_Reserva_Check_out1_idx` (`Check_out_id` ASC),
  INDEX `fk_Reserva_Usuario1_idx` (`User_id` ASC),
  INDEX `fk_Reserva_Check_In1_idx` (`Check_In_id` ASC),
  CONSTRAINT `fk_Reserva_Check_In1`
    FOREIGN KEY (`Check_In_id`)
    REFERENCES `hoteldb2`.`check_in` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Check_out1`
    FOREIGN KEY (`Check_out_id`)
    REFERENCES `hoteldb2`.`check_out` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Cliente1`
    FOREIGN KEY (`Client_id`)
    REFERENCES `hoteldb2`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Quartos1`
    FOREIGN KEY (`Room_id`)
    REFERENCES `hoteldb2`.`room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Usuario1`
    FOREIGN KEY (`User_id`)
    REFERENCES `hoteldb2`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
