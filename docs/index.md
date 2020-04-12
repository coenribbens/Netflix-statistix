#Netflix Statistix
#Coen Ribbens(2151482)
#Marcello Haddeman(2152991)
#Thomas Meeusen(2151718)


Class Diagram
=========
![Class Diagram](img/Class_Diagram.png)


ERD 
=====
![ERD](img/ERD.jpeg)



Relationeel Databaseontwerp
====
![RDB](img/RDD.jpeg)

#Normalisatie
![Normalisatie](img/Normalisatie%203e%20normaalvorm.png)


#Handleiding opzetten applicatie


###Database
Deze handleiding gaat uit van een paar dingen:
De gebruiker heeft Microsoft Management Studio geinstalleerd, indien dit niet het geval is kan de handleiding hieronder gevonden worden:
https://www.sqlshack.com/sql-server-management-studio-step-step-installation-guide/

De gebruiker heeft IntelliJ geinstalleerd en klaar gemaakt voor gebruik, indien dit niet het geval is kan de handleiding hier gevonden worden.
https://www.jetbrains.com/help/idea/installation-guide.html#

Voor het opzetten van de database is een sql bestand aanwezig binnen het project genaamd
[scripts.sql](https://github.com/coenribbens/Netflix-statistix/blob/master/script.sql).
1. Open Microsoft Server Management Studio
2. Open een nieuw queryscherm
3. Kopieer de bestanden van het script bestand naar het queryscherm binnen SMSS
4. Klik nu op de "Execute" knop binnen SMSS
5. De database zal nu automatisch geinstalleerd worden op de huidige server.

Hierna kan de applicatie opgezet worden

#Applicatie
1. Navigeer naar de github pagina van de applicatie, deze is te vinden door op deze knop te drukken 
[![Badge](https://img.shields.io/badge/Netflix%20Statistix-View%20Repo-blue?style=for-the-badge&logo=github)](https://github.com/coenribbens/netflix-statistix)
2. Druk op de "Clone or Download" knop, deze knop zal nu uitvouwen en meerde opties laten zien
3. Selecteer de optie "Download ZIP"
4. Nu zal er een ZIP bestand gedownload worden die het project bevat
5. Maak een lege map aan de desktop van de PC
6. Open het ZIP bestand en verplaats alle bestanden naar de lege map op de desktop
7. Open de gewenste IDE (Het gebruik van intelliJ is aangeraden)
8. In IntelliJ, selecteer de "File" optie en druk vervolgens op "Open"
9. Selecteer vervolgens de map waarin de applicatie zich bevindt.
(Nu zal de applicatie inladen in de IDE).
10. Druk op de groene pijl linksboven in de desbetreffende IDE
(Nu zal de applicatie de applicatie klaarmaken voor gebruik en deze openen wanneer gereed).


#Git repository
[![Badge](https://img.shields.io/badge/Netflix%20Statistix-View%20Repo-blue?style=for-the-badge&logo=github)](https://github.com/coenribbens/netflix-statistix)

#Reflectie

#Reflectie Coen Ribbens
Ik had hiervoor al enige kennis over het bouwen van een applicatie en de processen die hierachten liepen.
Het concept van de applicatie was al vrij interessant,
hiernaast was het eindelijk schrijven van code weer een goede rede om hier aan te beginnen.
De ontwerpfase was niet uitzonderlijk moeilijk aangezien ik voorkennis heb kunnen gebruiken van mijn vorige opleiding.
Het deel het meest tegenviel bij de ontwerpfase was de onzekerheid van de koppeltabllen die nodig zouden zijn.
Het schrijven van de code ging zonder te veel moeite en was snel te doen, hier heb ik eigenlijk weinig tot geen problemen mee gehad.
Het schrijven van de documentatie viel iets meer tegen aangezien ik in een redelijk
lange tijd geen handleidingen had geschreven, en al zeker niet in markup.
Een interessant project met een redelijk goede uitkomst.

#Reflectie Marcello Haddeman
Dit is de eerste keer dat ik mee heb gedaan aan een softwareproject. Ik moet zeggen dat het samenwerken toch wel veel moeilijker is dan gedacht. Ervoor zorgen dat iedereen op de hetzelfde spoor zit van gedachtegang is toch wel een klus. Anders dan dat ging het in het algemeen wel redelijk goed, de voorkennis van Coen heeft ook geholpen met het structureren van de applicatie. Ik heb vooral gefocust op de views van de applicatie, hierbij deed ik beide werken aan de front-end en de back-end. Dit is de eerste keer dat ik met JavaFX heb gewerkt en dus heb ik heel veel informatie online moeten opzoeken hoe je bepaalde dingen doet.
Terwijl het werk origineel was afgekeurd was heel veel werk al gedaan en koste het niet al te veel tijd om het af te ronden. Dit kwam uiteindelijk goed uit sinds we hierdoor ons compleet konden concentreren op andere projecten. De rede waarom het origineel was afgekeurd wat omdat we veel te weinig tijd hadden om alles goed te implementeren, daarom wil ik voor toekomstige projecten eerder beginnen. Ook wil ik projecten waarbij databases bij komen eerst aan de database werken voordat er wordt gewerkt aan de applicatie, hierdoor hoeven we niet later SQL query’s aanpassen om het te laten werken met aanpassingen in de database, iets wat we met dit project wel moesten doen.

#Samenwerkingscontract
Het samenwerkingscontract is verder te vinden in de Docs map
