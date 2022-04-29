INSERT INTO `user` (`name`,`surnames`,`description`,`image`,`date`) VALUES
('Esteban','Jimenez','Informático que le gustan las motos', 'FfFfFf', '2022-04-27'),
('Raul','Flores','Futbolista e ingeniero', 'FfFfFf', '2022-04-27'),
('Victor','Banyeres','Motorista cualificado', 'FfFfFf', '2022-04-27'),
('Carla','Calatayud','Amante de las mariposas', 'FfFfFf', '2022-04-27'),
('Maria','Rispa','Que lokee lokillos', 'FfFfFf', '2022-04-27');


INSERT INTO `historieta` (`user_id`,`text`,`date`) VALUES
(1, 'Me presento soy Esteban', '2022-04-28'),
(1, 'Que buen dia', '2022-04-27'),
(2, 'HappyFlower to day', '2022-04-27'),
(2, 'Conteentissimoooooooo', '2022-04-27'),
(3, 'Aburrido en la casa', '2022-04-28'),
(4, 'Hoy quedamos chicas', '2022-04-27'),
(4, 'La gente hoy sale?', '2022-04-28');


INSERT INTO `historieta_estado` (`historieta_id`, `estado`, `user_id`,`date`) VALUES
(1, 'MOLA',2,'2022-04-28'),
(1, 'MOLA',3,'2022-04-28'),
(2, 'PSSST',2,'2022-04-28'),
(2, 'MOLA',1,'2022-04-28'),
(2, 'PSSST',3,'2022-04-28'),
(2, 'PSSST',3,'2022-04-28'),
(3, 'PUFFF ',4,'2022-04-28'),
(4, 'PUFFF ',4,'2022-04-28');





INSERT INTO `friend` (`user_send_id`,`user_recive_id`,`accept`,`date`) VALUES
(2,1,TRUE, '2022-04-28'),
(1,3,FALSE, '2022-04-28'),
(2,3,TRUE, '2022-04-28'),
(1,4,TRUE, '2022-04-28');


