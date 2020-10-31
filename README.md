# ProjetSoap
Le projet ne contient que la partie WEBService et connexion à la base de donnée. 

Vous pouvez vous connectez à votre base ayant un schema d'objet suivant :
CREATE TABLE LIVRE
(
ID INT PRIMARY KEY AUTO_INCREMENTATION,
TITLE VARCHAR(MAX),
ISBN INT,
IDAUTEUR VARCHAR(MAX)
)

CREATE TABLE AUTEUR
(
ID INT PRIMARY KEY AUTO_INCREMENTATION,
PRENOM VARCHAR(MAX),
NOM VARCHAR(MAX)
)

Les identifiants de connection sont à modifier dans la class H2JDBCUtils au niveau des paramètre static.


Le webService est à lancer en executant le main de BiblioEndPoint 
et peut être testé en executant le main de TestClient 

Je n'ai pas d'interface clients car après plusieurs essaye via différents éléments (PostMan, React , etc)
il y a toujours eu des problèmes qui m'on empêché d'avoir une interface.

Je ne pouvais donc que tester le bon fonctionnement de mon WebService et du SOAP via des println.
