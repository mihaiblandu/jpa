CREATE TABLE IF NOT EXISTS `employee` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(20),
`email` varchar(50),
`date_of_birth` timestamp
    )ENGINE=InnoDB DEFAULT CHARSET=UTF8;
CREATE TABLE IF NOT EXISTS `department` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(20))ENGINE=InnoDB DEFAULT CHARSET=UTF8;
ALTER TABLE `employee` ADD `dept_id` int AFTER `email`;