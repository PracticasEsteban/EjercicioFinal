INSERT INTO `user` (`name`,`surnames`,`email`,`description`,`image`,`date`) VALUES
('Esteban','Jimenez','loquesea@gmail.com','Informático que le gustan las motos', 'https://cdn.pixabay.com/photo/2020/07/01/12/58/icon-5359553_960_720.png', '2022-04-27'),
('Raul','Flores','loquesea@gmail.com','Futbolista e ingeniero', 'https://pbs.twimg.com/media/D6uc2kBX4AAv3xV?format=jpg&name=900x900', '2022-04-27'),
('Victor','Banyeres','loquesea@gmail.com','Motorista cualificado', 'https://cdn.pixabay.com/photo/2020/07/01/12/58/icon-5359553_960_720.png', '2022-04-27'),
('Carla','Calatayud','loquesea@gmail.com','Amante de las mariposas', 'https://cdn.pixabay.com/photo/2020/07/01/12/58/icon-5359553_960_720.png', '2022-04-27'),
('Maria','Rispa','loquesea@gmail.com','Que lokee lokillos', 'https://pbs.twimg.com/media/D6uc2kBX4AAv3xV?format=jpg&name=900x900', '2022-04-27');


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

INSERT INTO `evento` (`name`,`description`,`image`,`date`) VALUES
('Quedada','Quedada entre coleguitas. !Apuntarse!','FfFfFf', '2022-04-28'),
('QuedadaMAYOR','FINDE DE FIESTA. !Apuntarse!','FfFfFf', '2022-04-29');


INSERT INTO `evento_user` (`evento_id`,`user_id`,`date`) VALUES
(1,2,'2022-04-29');
