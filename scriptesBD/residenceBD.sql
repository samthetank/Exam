DELIMITER /
DROP DATABASE IF EXISTS `residenceCarrefourBD`/
CREATE DATABASE IF NOT EXISTS `residenceCarrefourBD`/

USE `residenceCarrefourBD`/

DROP TABLE IF EXISTS `appartements`/
CREATE TABLE IF NOT EXISTS `appartements` (
  `id_Appartement`          INT(11)     NOT NULL AUTO_INCREMENT,
  `no_Appartement`          SMALLINT    NOT NULL,
  `etage_appartement`       ENUM ('1', '2', '3', '4') 	NOT NULL,
  `phase_appartement`       ENUM ('1', '2', '3')     NOT NULL,
  `dimension_Appartement`   ENUM ('P', 'M', 'G') NOT NULL,
  `nb_Pieces_Appartement`   ENUM ('3','4')      NOT NULL,
  `description_Appartement` VARCHAR(250) DEFAULT NULL,
  PRIMARY KEY `pk_appartement` (`id_Appartement`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8/

DROP TABLE IF EXISTS `droits_utilisateur`/
CREATE TABLE IF NOT EXISTS `droits_utilisateur` (
  `id_Droit_Utilisateur`    INT(11)         NOT NULL AUTO_INCREMENT,
  `nom_Droit_Utilisateur`   VARCHAR(50)     NOT NULL,
  PRIMARY KEY `pk_droits_utilisateur` (`id_Droit_Utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8/

DROP TABLE IF EXISTS `inscriptions`/
CREATE TABLE IF NOT EXISTS `inscriptions` (
  `id_Inscription` 				INT(11) 		NOT NULL AUTO_INCREMENT,
  `nom_Personne_Inscrite` 		VARCHAR(50) 	NOT NULL,
  `prenom_Personne_Inscrite` 	VARCHAR(50) 	NOT NULL,
  `telephone_Personne_Inscrite` VARCHAR(15) 	NOT NULL,
  `date_Inscription` 			DATE	 		NOT NULL,
  `commentaire_Personne_Inscrite`  VARCHAR(2500) 	DEFAULT NULL,
  `commentaire_Administrateur`     VARCHAR(2500) 	DEFAULT NULL,
  `commentaire_refus`              VARCHAR(2500)    DEFAULT NULL,
  `preference_Appartement`		ENUM('aucune', '3', '4'),
  `preference_Etage`            ENUM('aucune', '1', '2', '3', '4', 'RC'),
  `est_Confirme` 				TINYINT(1) 		NOT NULL,
  `courriel` 					VARCHAR(250) 	DEFAULT NULL,
  PRIMARY KEY `pk_inscriptions` (`id_Inscription`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8/

DROP TABLE IF EXISTS `roles`/
CREATE TABLE IF NOT EXISTS `roles` (
  `id_Role`          INT(11)         NOT NULL AUTO_INCREMENT,
  `nom_Role`         VARCHAR(50)     NOT NULL,
  `description_Role` VARCHAR(250)    DEFAULT NULL,
  PRIMARY KEY `pk_roles` (`id_Role`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8/

DROP TABLE IF EXISTS `utilisateurs`/
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `id_Utilisateur`  INT(11)     NOT NULL AUTO_INCREMENT,
  `id_Role`         INT(11)     NOT NULL,
  `nom_Utilisateur` VARCHAR(50) NOT NULL,
  `nom`             VARCHAR(50) NOT NULL,
  `prenom`          VARCHAR(50) NOT NULL,
  `mot_De_Passe`    VARCHAR(50) NOT NULL,
  `courriel`    	VARCHAR(50) NOT NULL,
  PRIMARY KEY `pk_utilisateurs` (`id_Utilisateur`),
  KEY `fk_utilisateurs_roles_idx` (`id_Role`),
  CONSTRAINT `fk_utilisateurs_roles`
        FOREIGN KEY (`id_Role`)
        REFERENCES `roles` (`id_Role`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8/

DROP TABLE IF EXISTS `residents`/
CREATE TABLE IF NOT EXISTS `residents` (
  `id_Resident`              INT(11)     NOT NULL AUTO_INCREMENT,
  `nom_Resident`             VARCHAR(50) NOT NULL,
  `prenom_Resident`          VARCHAR(50) NOT NULL,
  `telephone_Resident`       		  VARCHAR(15) NOT NULL,
  `telephone_Secondaire_Resident`     VARCHAR(15) NOT NULL,
  `titre_Resident`           ENUM('M.', 'Mme.'),

  `date_Naissance_Resident`  DATE        NOT NULL,
  `date_Arrivee_Resident`    DATE        NOT NULL,
  `commentaire_Resident`     VARCHAR(2500) DEFAULT NULL,

  `couleur_Intervention`     ENUM('R', 'J', 'V'),
  `commentaire_Intervention` VARCHAR(2500)  DEFAULT NULL,

  `commentaire_plainte`      VARCHAR(2500)  DEFAULT NULL,

  `nom_Véhicule`			 VARCHAR(50)	DEFAULT NULL,
  `plaque_Immatriculation`	 VARCHAR(10)	DEFAULT NULL,
  PRIMARY KEY `pk_residents` (`id_Resident`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8/

DROP TABLE IF EXISTS `repondants`/
CREATE TABLE IF NOT EXISTS `repondants` (
  `id_Repondant`             INT(11)        NOT NULL AUTO_INCREMENT,
  `id_Resident`			     INT(11)		NOT NULL,
  `nom_Repondant`            VARCHAR(100)   DEFAULT NULL,
  `telephone_Repondant`      VARCHAR(15)    DEFAULT NULL,
  `remarque_Repondant`       VARCHAR(250)   DEFAULT NULL,
  PRIMARY KEY `pk_repondants` (`id_Repondant`),
  KEY `fk_residents_repondants_idx` (`id_Repondant`),
  CONSTRAINT `fk_residents_repondants_1`
        FOREIGN KEY (`id_Resident`)
        REFERENCES `residents` (`id_Resident`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8/

DROP TABLE IF EXISTS `baux`/
CREATE TABLE IF NOT EXISTS `baux` (
  `id_Bail`         INT(11)         NOT NULL AUTO_INCREMENT,
  `id_Appartement`  INT(11)         NOT NULL,
  `date_Debut`      DATE            NOT NULL,
  `date_Fin`        DATE            NOT NULL,
  `dernier_Mois`	ENUM ('aucun', 'complet', 'janvier', 'février', 'mars',
						  'avril', 'mai', 'juin', 'juillet', 
						  'août', 'septembre', 'octobre', 
						  'novembre', 'décembre'),
  `montant_Loyer`   decimal(6,2)    NOT NULL,
  `commentaire`      VARCHAR(2500)   NOT NULL,
  PRIMARY KEY (`id_Bail`),
  KEY `fk_baux_appartements_idx` (`id_Appartement`),
  CONSTRAINT `fk_baux_appartements_1`
        FOREIGN KEY (`id_Appartement`)
        REFERENCES `appartements` (`id_Appartement`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8/

DROP TABLE IF EXISTS `residents_baux`/
CREATE TABLE IF NOT EXISTS `residents_baux` (
  `id_Resident`     INT(11)     NOT NULL,
  `id_Bail`         INT(11)     NOT NULL,
  `est_Responsable` TINYINT(1)  DEFAULT NULL,
  `est_Locataire`	TINYINT(1)  NOT NULL,
  PRIMARY KEY (`id_Resident`,`id_Bail`),
  KEY `fk_residents_has_baux_bail_idx` (`id_Bail`),
  KEY `fk_residents_has_baux_resident_idx` (`id_Resident`),
  CONSTRAINT `fk_resident_has_baux_bail_1`
        FOREIGN KEY (`id_Bail`)
        REFERENCES `baux` (`id_Bail`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION,
  CONSTRAINT `fk_residents_has_baux_resident_1`
        FOREIGN KEY (`id_Resident`)
        REFERENCES `residents` (`id_Resident`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8/

DROP TABLE IF EXISTS `roles_droits_utilisateur`/
CREATE TABLE IF NOT EXISTS `roles_droits_utilisateur` (
  `id_Role`                  INT(11) NOT NULL AUTO_INCREMENT,
  `id_Droits_Utilisateur`    INT(11) NOT NULL,
  PRIMARY KEY (`id_Role`,`id_Droits_Utilisateur`),
  KEY `fk_role_has_droits_utilisateur_droit_utilisateur_idx` (`id_Droits_Utilisateur`),
  KEY `fk_role_has_droits_utilisateur_roles_idx` (`id_Role`),
  CONSTRAINT `fk_role_has_droits_utilisateur_droits_utilisateur_1`
        FOREIGN KEY (`id_Droits_Utilisateur`)
        REFERENCES `droits_utilisateur` (`id_Droit_Utilisateur`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
  CONSTRAINT `fk_roles_has_droits_utilisateur_role_1`
        FOREIGN KEY (`id_Role`)
        REFERENCES `roles` (`id_Role`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8/

DROP TABLE IF EXISTS `logs`/
CREATE TABLE IF NOT EXISTS `logs` (
  `id_log`          INT(11)     NOT NULL AUTO_INCREMENT,
  `nom_table`          	VARCHAR(50)     NOT NULL,
  `action`          VARCHAR(50)     NOT NULL,
  `nom_utilisateur` VARCHAR(50)     NOT NULL,
  `date_log`      	DATETIME,
  `valeur` 			VARCHAR(2500) NOT NULL,
  `ancienne_valeur` 		VARCHAR(2500) DEFAULT NULL,
  PRIMARY KEY `pk_log` (`id_log`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8/

CREATE TRIGGER check_contrainte_log 
BEFORE INSERT ON `logs` 
FOR EACH ROW
BEGIN 
	declare msg varchar(255);
	IF new.id_log < 0 then
		set new.id_log = 0;
	END IF;
	set new.date_log = NOW();
END/

CREATE TRIGGER check_contrainte_appartement 
BEFORE INSERT ON `appartements` 
FOR EACH ROW
BEGIN 
	declare msg varchar(255);
	IF new.id_Appartement < 0 then
		set new.id_Appartement = 0;
	END IF;
	IF new.no_appartement < 1 || new.no_appartement > 450 then
		set msg = 'Erreur check appartement : Le numéro d\'appartement doit être entre 1 et 450.';
		signal sqlstate '45000' set message_text = msg;
	END IF;
END/

CREATE TRIGGER check_contrainte_droits_utilisateur
BEFORE INSERT ON `droits_utilisateur`
FOR EACH ROW  
BEGIN 
	IF new.id_Droit_Utilisateur < 0 then
		set new.id_Droit_Utilisateur = 0;
	END IF;
END/

CREATE TRIGGER check_contrainte_inscriptions
BEFORE INSERT ON `inscriptions`
FOR EACH ROW 
BEGIN
	declare msg varchar(255);
	IF new.date_Inscription > NOW() then
		set msg = 'Erreur check inscription : La date d\'inscription ne doit pas être supérieur à la date du jour.';
		signal sqlstate '45000' set message_text = msg;
	END IF;
END/

CREATE TRIGGER check_contrainte_roles
BEFORE INSERT ON `roles`
FOR EACH ROW  
BEGIN 
	IF new.id_Role < 0 then 
	set new.id_Role = 0;
	END IF;
END/

CREATE TRIGGER check_contrainte_utilisateurs
BEFORE INSERT ON `utilisateurs`
FOR EACH ROW  
BEGIN 
	IF new.id_Utilisateur < 0 then 
	set new.id_Utilisateur = 0;
	END IF;
END/

CREATE TRIGGER check_contrainte_residents
BEFORE INSERT ON `residents`
FOR EACH ROW  
BEGIN 
	IF new.id_Resident < 0 then
	set new.id_Resident = 0;
	END IF;
END/

CREATE TRIGGER check_contrainte_repondants 
BEFORE INSERT ON `repondants` 
FOR EACH ROW
BEGIN
	IF new.id_Repondant < 0 then
	set new.id_Repondant = 0;
	END IF;
END/

CREATE TRIGGER check_contrainte_baux
BEFORE INSERT ON `baux` 
FOR EACH ROW  
BEGIN 
	declare msg varchar(255);
	IF new.date_Debut > new.date_Fin then
		set msg = 'Erreur check baux : La date de fin doit être après la date de début.';
		signal sqlstate '45000' set message_text = msg;
	ELSEIF new.montant_Loyer < 0 then 
		set msg = 'Erreur check baux : Le montant du loyer doit être supérieur à 0.';
		signal sqlstate '45000' set message_text = msg;
	END IF;
END/

CREATE TRIGGER check_contrainte_residents_baux
BEFORE INSERT ON `residents_baux` 
FOR EACH ROW 
BEGIN
	declare msg varchar(255);
	IF new.est_Responsable != 0 && new.est_Responsable != 1 then
		set msg = 'Erreur check residents baux : Le champs est responsable accepte seulement 1 ou 0';
		signal sqlstate '45000' set message_text = msg;
	END IF;
END/

INSERT INTO `droits_utilisateur` (`id_Droit_Utilisateur`, `nom_Droit_Utilisateur`) VALUES
	(1,  'connexion_Application'), 					(2,  'connexion_Modifier_Mot_Passe'),
	(3,  'appartements_Afficher'),					(4,  'appartements_Ajout'),							(5, 'appartements_Effacer'),
	(6,  'appartements_Mettre_A_Jour'),				(7,  'appartements_Voir'),						
	(8,  'baux_Afficher'),							(9,  'baux_Ajout'),									(10, 'baux_Effacer'),
	(11, 'baux_Mettre_A_Jour'),						(12, 'baux_Voir'),								
	(13, 'factures_Paiements_Afficher'),			(14, 'factures_Paiements_Ajout'),				    (15, 'factures_Paiements_Effacer'),	
	(16, 'factures_Paiements_MettreAJour'),			(17, 'factures_Paiements_Voir'),
	(18, 'inscriptions_Afficher'),			(19, 'inscriptions_Ajout'),				    (20, 'inscriptions_Effacer'),
	(21, 'inscriptions_Mettre_A_Jour'),		(22, 'inscriptions_Voir'),
	(23, 'residents_Afficher'),						(24, 'residents_Ajout'),							(25, 'residents_Effacer'),
	(26, 'residents_Mettre_A_Jour'),				(27, 'residents_Voir'),						
	(28, 'utilisateurs_Afficher'),					(29, 'utilisateurs_Ajout'),							(30, 'utilisateurs_Effacer'),
	(31, 'utilisateurs_Mettre_A_Jour'),				(32, 'utilisateurs_Voir'), 							(33, 'logs_Afficher'),
	(34, 'logs_Voir')/

INSERT INTO `roles` (`id_Role`, `nom_Role`, `description_Role`) VALUES
	(1, 'Administrateur',   'L\'administrateur du système à tous les droits sauf ceux reliés au communication privé et peut s\'occuper de l\'application au niveau technique'),
	(2, 'Gestionnaire +', 	'Le gestionnaire à tous les droits incluant la lecture des communiqués privés.'),
	(3, 'Gestionnaire',  'Le gestionnaire -- peut voir et modifier les toutes les données sauf les données concernant les baux et les paiements peut par contre les voirs.'),
	(4, 'Surveillant +', 	'Le surveillant ++ peut voir toute les informations dans le système mais ne peut pas modifier les valeurs dans les tables n\'a pas accès au données concernant les baux et paiements'),
	(5, 'Surveillant',  	'Le surveillant à seulement le droit de voir les tables de bases et non d\'afficher, mettre a jour ou effacer les informations confidentiels dans l\'application.')/

INSERT INTO `utilisateurs` (`id_Utilisateur`, `id_Role`, `nom_Utilisateur`, `nom`, `prenom`, `mot_De_Passe`, `courriel`) VALUES
	(1, 1, 'admin', 		'Paga', 'Hall', 'sesame', 'residence.noreply@gmail.com'),
    (2, 2, 'iDube',			'Dubé', 'Isabelle', 'sesame', 'residence.noreply@gmail.com')/

INSERT INTO `roles_droits_utilisateur` (`id_Role`, `id_Droits_Utilisateur`) VALUES
	(1, 1), (2, 1), (3, 1), (4, 1), (5, 1), # Connexion à lapplication.
	(1, 2), (2, 2), (3, 2), (4, 2), (5, 2), # Changer le mot de passe.
	
#   Affich  Ajout   Effacer MàJour  Voir	APPARTEMENTS
	(2, 3), (2, 4), (2, 5), (2, 6), (2, 7), # Gestionnaire
	(3, 3), (3, 4), (3, 5), (3, 6), (3, 7), # Gestionnaire -- 
	(4, 4),						    (4, 7), # Surveillant ++
	(5, 5),									# Surveillant
	(1, 3), (1, 4), (1, 5), (1, 6), (1, 7), # Administrateur

#   Affich   Ajout    Effacer  MàJour   Voir     BAUX
	(2, 8),  (2, 9),  (2, 10), (2, 11), (2, 12), # Gestionnaire
	(3, 8),  						    (3, 12), # Gestionnaire --

#   Affich   Ajout    Effacer  MàJour   Voir     FACTURES ET PAIEMENTS
	(2, 13), (2, 14), (2, 15), (2, 16), (2, 17), # Gestionnaire
	(3, 13),  						    (3, 17), # Gestionnaire --

#   Affich   Ajout    Effacer  MàJour   Voir     INSCRIPTIONS
	(2, 18), (2, 19), (2, 20), (2, 21), (2, 22), # Gestionnaire
	(3, 18), (3, 19), (3, 20), (3, 21), (3, 22), # Gestionnaire --
	(4, 18),						    (4, 22), # Surveillant ++
	(5, 18),									 # Surveillant

#   Affich   Ajout    Effacer  MàJour   Voir     RESIDENTS
	(2, 23), (2, 24), (2, 25), (2, 26), (2, 27), # Gestionnaire
	(3, 23), (3, 24), (3, 25), (3, 26), (3, 27), # Gestionnaire --
	(4, 23),						    (4, 27), # Surveillant ++
	(5, 23),									 # Surveillant

#   Affich   Ajout    Effacer  MàJour   Voir     UTILISATEURS
	(2, 28), 									 # Gestionnaire
	(1, 28), (1, 29), (1, 30), (1, 31), (1, 32), # Administrateur

#   Affich     Voir		LOGS
	(1, 33), (1, 34)/ # Administrateur
