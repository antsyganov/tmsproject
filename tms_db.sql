-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema tms_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tms_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tms_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `tms_db` ;

-- -----------------------------------------------------
-- Table `tms_db`.`wagon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tms_db`.`wagon` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `reg_number` VARCHAR(7) NOT NULL,
  `number_of_driver` INT NOT NULL,
  `class_capacity` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `regNumber_UNIQUE` (`reg_number` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tms_db`.`driver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tms_db`.`driver` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(20) NOT NULL,
  `patronymic` VARCHAR(20) NOT NULL,
  `license_number` VARCHAR(45) NOT NULL,
  `status` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tms_db`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tms_db`.`order` (
  `unique_number` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(20) NOT NULL,
  `gps_coordinates` VARCHAR(25) NULL,
  `load` VARCHAR(45) NULL,
  `weight` INT NULL,
  `delivery_status` TINYINT(1) NULL,
  `wagon_id` INT NOT NULL,
  PRIMARY KEY (`unique_number`),
  UNIQUE INDEX `uniqueNumber_UNIQUE` (`unique_number` ASC),
  INDEX `fk_order_wagon1_idx` (`wagon_id` ASC),
  CONSTRAINT `fk_order_wagon1`
    FOREIGN KEY (`wagon_id`)
    REFERENCES `tms_db`.`wagon` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tms_db`.`wagon_has_driver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tms_db`.`wagon_has_driver` (
  `wagon_id` INT NOT NULL,
  `driver_id` INT NOT NULL,
  PRIMARY KEY (`wagon_id`, `driver_id`),
  INDEX `fk_wagon_has_driver_driver1_idx` (`driver_id` ASC),
  INDEX `fk_wagon_has_driver_wagon1_idx` (`wagon_id` ASC),
  CONSTRAINT `fk_wagon_has_driver_wagon1`
    FOREIGN KEY (`wagon_id`)
    REFERENCES `tms_db`.`wagon` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_wagon_has_driver_driver1`
    FOREIGN KEY (`driver_id`)
    REFERENCES `tms_db`.`driver` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
