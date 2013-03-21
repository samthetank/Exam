Use `residenceCarrefourBD`;

DELETE FROM `inscriptions`;
DELETE FROM `appartements`;


ALTER TABLE `inscriptions` AUTO_INCREMENT = 12;
INSERT INTO `inscriptions` (`id_Inscription`, `nom_Personne_Inscrite`, `prenom_Personne_Inscrite`, 
	`telephone_Personne_Inscrite`, `date_Inscription`, `commentaire_Personne_Inscrite`, `commentaire_Administrateur`,
	`commentaire_refus`, `preference_Appartement`, `preference_Etage`, `est_Confirme`, `courriel`) VALUES
	(1,  'Gouvier', 	'Marthe', 		'450-876-1722', 	'2013-01-08', 'J\'aimerais avoir un logement au premier étage.', 	'Avait l\'air éssouflé à monter les escaliers...',  	'commentaire refus', 		'aucune', 'aucune', 0, 'marthe.gouvier@hotmail.com'),
	(2,  'Jaillet', 	'Pierre', 		'450-719-5678', 	'2012-12-11', 'Je veux avoir deux places de stationnement.', 		'Très inscitant sur les places de stationnements',  	'commentaire refus', 		'3', 'aucune', 1, 'pierre.jaillet@gmail.com'),
	(3,  'Boyer',   	'Rémi', 		'450-900-9000', 	'2013-01-18', 'Il faudrait me confirmer le nombre de repas semaine.','Avait l\'air éssouflé à monter les escaliers...',  	'commentaire refus', 		'aucune', 'aucune', 1, ''),
	(4,  'Piatel',  	'Chris', 		'450-176-4598', 	'2012-12-18', 'Je suis très sympatique.', 							'N\'est pas sympatique c\'est un mensonge.',  			'commentaire refus', 		'aucune', 'aucune', 0, 'chris.piatel@hotmail.com'),
	(5,  'Willy', 		'Yann',		 	'514-176-6597', 	'2013-01-19', 'J\'habite en Abitibi.', 							    'Nos résidence sont très populaire.',  						'commentaire refus', 		'aucune', 'aucune', 0, 'yann.willy@live.com'),
	(6,  'Dion', 		'Céline', 		'514-898-1645', 	'2012-12-18', '', 													'Ce n\'est pas la vrai Céline.',  							'commentaire refus', 		'3', '1',  1, 'celine.dion@hotmail.com'),
	(7,  'Duduche', 	'Paul', 		'1-800-911-1645', 	'2012-12-11', 'J\'aime vraiment votre formulaire en ligne', 		'',  													'commentaire refus', 		'4', '2', 0, 'paul.duduche@hotmail.com'),
	(8,  'Colin', 		'Pauline', 		'450-176-4794', 	'2013-01-18', 'J\'aimerais un appartement côté Nord.', 				'',   														'commentaire refus', 		'3', '2',  1, 'pauline.colin@hotmail.com'),
	(9,  'Henriot', 	'Guillaume', 	'450-176-4593', 	'2012-12-18', 'Pas de remarque.', 									'Handicapé Unijambiste',  								'commentaire refus', 		'4', 'aucune', 1, ''),
	(10, 'Crouchet', 	'Kevin', 		'514-446-4592', 	'2013-01-18', ' ', 													'Il est un grand fan de Raoul Duguay',  					'commentaire refus', 		'3', '2',  1, ''),
	(11, 'Peultier', 	'Maxime', 		'450-176-4591', 	'2012-12-11', 'J\'aimerais un appartement où les chiens sont autorisés.', 'Pas de remarque.',  								'commentaire refus', 		'3', '1',  1, '');

ALTER TABLE `residents` AUTO_INCREMENT = 12;
INSERT INTO `residents` (`id_Resident`, `nom_Resident`, `prenom_Resident`, `telephone_Resident`, 
	`telephone_secondaire_Resident`, `titre_Resident`, `date_Naissance_Resident`,`date_Arrivee_Resident`, `commentaire_Resident`, 
	`couleur_Intervention`, `commentaire_Intervention`, `commentaire_plainte`, `nom_Véhicule`, `plaque_Immatriculation`) 
VALUES 
(1, 'Beaupré', 	'Charles', 		'438-281-2940', '', 			'M.', 	'1960-01-01',
	'2011-04-09', 'Joli', 		'J', 'Attention',	'Bruyant',			'Honda Accord', 	'JSG 594'),
(2, 'Beaulac', 	'Simon', 		'450-829-1128', '514-122-6341', 'M.', 	'1959-05-26',
	'2010-11-21', '', 	  		'V',	'',				'',				'Peugeot RCZ', 		'FCY 947'),
(3, 'Riopel', 	'Ulysse', 		'450-364-0712', '514-721-9476', 'M.', 	'1963-04-23',
	'1960-05-03', 'Nom rigolo', 'R',	'Aveulge',		'',				'Alfa Romeo R4', 	'084 MKL'),
(4, 'Nguyen', 	'Hoa', 			'450-228-6012', '', 			'M.', 	'1966-01-12',
	'1999-07-17', '', 			'V',		'Lourd',		'',			'Hyundai Accent', 	'162 XRS'),
(5, 'Croteau', 	'Evelyne', 		'450-206-6040', '514-291-8323', 'Mme.', '1952-03-20',
	'2001-12-15', '',			'V',	'Fatiguant',	'Nourrit chats','Chrystler C300',	'797 CLH'),
(6, 'Duteau', 	'Marie-Pier', 	'450-349-0924', '', 			'Mme.', '1945-08-03',
	'2006-01-26', 'Nom composé','R','Dangereux',	'',				'Mini Cooper',		'GBR 822'),
(7, 'D\'antan', 'Céline', 		'438-125-8871', '', 			'Mme.', '1961-02-05',
	'2006-02-11', 'surpoids', 	'V',	'Lent',			'',				'Toyota Tercel',	'ZME 753'),
(8, 'Fontaine', 'Olivier', 		'450-631-2421', '', 			'M.', 	'1947-01-12',
	'2000-01-16', '',			'V',		'',				'',				'Ford F150',		'390 ADD'),
(9, 'Racicot', 	'Julie', 		'438-349-3038', '', 			'Mme.', '1941-11-21',
	'2002-05-01', '',			'J',		'',				'',				'Nissan Altima',	'FEN 579'),
(10, 'Prairie', 'Elizabeth', 	'438-609-8901', '', 			'Mme.', '1958-10-19',
	'2013-01-02', '',			'J',		'Fumeuse',		'',				'',					''),
(11, 'Piedalue','Sarah', 		'438-741-9172', '', 			'Mme.', '1968-10-15',
	'2003-08-01', '',			'V',		'',				'',				'',					'');

ALTER TABLE `appartements` AUTO_INCREMENT = 4;
INSERT INTO `appartements` (`id_Appartement`, `no_Appartement`, `etage_appartement`, `phase_appartement`, `dimension_Appartement`, `nb_Pieces_Appartement`, `description_Appartement`) 
VALUES 
('1', '81', '2', '3', 'G', '4', 'un grand 4½'),
('2', '23', '1', '2', 'M', '3', 'un moyen 3½'),
('3', '17', '1', '1', 'M', '3', 'un moyen 3½'),
('4', '101', '3', '2', 'P', '4', 'un petit 4½'),
('5', '121', '3', '2', 'P', '4', 'un petit 4½');

INSERT INTO `roles` (`id_Role`, `nom_Role`, `description_Role`) 
VALUES ('6', 'Dieu', 'Le dieu absolut dont rêve Francis.');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '1');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '2');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '3');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '4');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '5');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '6');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '7');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '8');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '9');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '10');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '11');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '12');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '13');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '14');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '15');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '16');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '17');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '18');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '19');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '20');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '21');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '22');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '23');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '24');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '25');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '26');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '27');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '28');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '29');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '30');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '31');

INSERT INTO `residencecarrefourbd`.`roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES ('6', '32');

INSERT INTO `utilisateurs` (`id_Utilisateur`, `id_Role`, `nom_Utilisateur`, `nom`, `prenom`, `mot_De_Passe`, `courriel`) VALUES
	(3, 3, 'gestionM', 		'De Confiance', 'Personne', 'sesame', 'residence.noreply@gmail.com'),
	(4, 4, 'surveilP', 		'Qui Voit', 'Personne', 'sesame', 'residence.noreply@gmail.com'),
	(5, 5, 'surveil', 		'Qui Afficher', 'Personne', 'sesame', 'residence.noreply@gmail.com'),
	(6, 6, 'fran', 			'Qui fait tout', 'Réincarnation de dieu', 'patate', 'residence.noreply@gmail.com');

INSERT INTO `baux` (`id_Bail`, `id_Appartement`, `date_Debut`, `date_Fin`, `dernier_Mois`, `montant_Loyer`, `commentaire`) VALUES
	(1, 1, '2013-01-20', '2014-01-19', 'complet', 325.00, 'Lorem ipsum'),
	(2, 2, '2013-01-12', '2014-01-11', 'aucun'	, 450.00, 'Lorem ipsum'),
	(3, 5, '2013-01-09', '2014-01-08', 'mars'	, 529.00, 'Lorem ipsum'),
	(4, 1, '2011-01-14', '2012-01-13', 'complet', 359.00, 'Lorem ipsum'),
	(5, 1, '2010-01-14', '2011-01-13', 'complet', 329.00, 'Lorem ipsum'),
	(6, 2, '2011-01-14', '2012-01-13', 'complet', 329.00, 'Lorem ipsum');
	
INSERT INTO `residents_baux` (`id_Resident`, `id_Bail`, `est_Responsable`, `est_Locataire`) VALUES
	(1, 1, 1, 1),
	(2, 1, 0, 0),
	(3, 2, 1, 1),
	(4, 2, 0, 0),
	(5, 3, 1, 1),
	(6, 4, 1, 1),
	(7, 5, 1, 1),
	(8, 6, 1, 1),
	(9, 6, 0, 0);