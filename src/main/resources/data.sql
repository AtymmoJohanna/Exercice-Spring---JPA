-- Initialisation des tables
-- Ce fichier ne peut pas être vide

INSERT INTO Projet(code, nom, debut, fin) VALUES
                    ( 10548, 'ISIS', '1995-05-22', null),
                    ( 10348, 'IUT', '1995-05-22', '1996-06-12'),
                    ( 10248, 'LYCEE', '1995-05-12', null);

INSERT INTO Personne(matricule, nom, prenom, poste) VALUES
                    ( 48, 'James', 'Kamga', 'technicien');

INSERT INTO Personne(matricule, nom, prenom, poste, superieur_matricule) VALUES
    ( 49, 'fdfdf', 'sdsf', 'rh', 48);

INSERT INTO Participation(id, contributeur_matricule, affectation_code, role, pourcentage) VALUES
                    ( 01, 48, 10248, 'secretaire',10.9);