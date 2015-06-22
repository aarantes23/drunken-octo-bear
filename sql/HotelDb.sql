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
-- Table `HotelDb`.`Quarto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelDb`.`Quarto` (
  `id` INT NOT NULL,
  `numero` INT NOT NULL,
  `andar` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `valorDiaria` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelDb`.`Cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `rg` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NULL,
  `sexo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelDb`.`Usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(45) NOT NULL,
  `rg` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(45) NOT NULL,
  `data_nascimento` VARCHAR(45) NOT NULL,
  `tipo` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDb`.`Check_out`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelDb`.`Check_out` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDb`.`Reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelDb`.`Reserva` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data_check_in` VARCHAR(45) NOT NULL,
  `Cliente_id` INT NOT NULL,
  `Usuario_id` INT NOT NULL,
  `Check_out_id` INT NOT NULL,
  `Quarto_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Cliente_id`, `Usuario_id`, `Check_out_id`, `Quarto_id`),
  INDEX `fk_Reserva_Cliente1_idx` (`Cliente_id` ASC),
  INDEX `fk_Reserva_Usuario1_idx` (`Usuario_id` ASC),
  INDEX `fk_Reserva_Check_out1_idx` (`Check_out_id` ASC),
  INDEX `fk_Reserva_Quarto1_idx` (`Quarto_id` ASC),
  CONSTRAINT `fk_Reserva_Cliente1`
    FOREIGN KEY (`Cliente_id`)
    REFERENCES `HotelDb`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Usuario1`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `HotelDb`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Check_out1`
    FOREIGN KEY (`Check_out_id`)
    REFERENCES `HotelDb`.`Check_out` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Quarto1`
    FOREIGN KEY (`Quarto_id`)
    REFERENCES `HotelDb`.`Quarto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDb`.`Item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelDb`.`Item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(200) NOT NULL,
  `valor` DOUBLE NOT NULL,
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
