DROP DATABASE  IF EXISTS `library_web_bcrypt`;

CREATE DATABASE  IF NOT EXISTS `library_web_bcrypt`;
USE `library_web_bcrypt`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--

--
-- Default passwords here are: user123 manager123
--

INSERT INTO `users` 
VALUES 
('user','{bcrypt}$2a$10$kQAtKqXkYzWI2NjN3OYLZO4rQyUWskbYv.cEwIqwSPor9l/2.ceOa',1),
('manager','{bcrypt}$2a$10$iKe0OPfdxQ3B4lRiQRwMTu/wVZVWwnsoHuVI6uwKjtnVKrb0FLKQG',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('user','ROLE_EMPLOYEE'),
('manager','ROLE_MANAGER');

