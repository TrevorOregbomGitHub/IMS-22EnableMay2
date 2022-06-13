CREATE DATABASE ims;

USE ims;

--  drop schema IF EXISTS ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

-- USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customer` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`item` (
    `item_id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `price` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`item_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    fk_id INT NOT NULL,
    order_id INT NOT NULL,
    PRIMARY KEY (order_id, fk_id),
    FOREIGN KEY (fk_id) REFERENCES customer(id)
);

CREATE TABLE IF NOT EXISTS `ims`.`order_item` (
    fk_order_id INT NOT NULL,
    fk_item_id INT NOT NULL,
    order_item_id INT NOT NULL,

    PRIMARY KEY (fk_order_id, fk_item_id, order_item_id),
    FOREIGN KEY (fk_order_id) REFERENCES orders(order_id),
    FOREIGN KEY (fk_item_id) REFERENCES item(item_id)
);
