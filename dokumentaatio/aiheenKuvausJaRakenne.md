**Aihe:** 
   Toteutetaan Blackjackpeli. Tarkoitus on toteuttaa peli� niin ett� se vastaa mahdollisimman tarkasti peli� oikeassa casinossa. Simuluidaan oikea korttipakka jolloin kehittynyt pelaaja p�rj�� paremmin jos h�n muistaa mit� kortteja on jo tullut. My�hemin on tarkoitus toteuttaa korttien jakaaminen ja mahdollisuus k�ytt�� useampi korttipakka peliss�.


**K�ytt�j�** pelaaja

* Uusi peli
  * onnistuu jos peli ei ole k�yniss�
* Lis�� kortti
  * onnistuu jos peli on k�yniss� ja korttien summa ei ole yli 21
* J��
  * onnistuu jos peli on k�yniss� ja korttien summa ei ole yli 21
* Nosta panos
  * onnistuu jos peli ei ole k�yniss� ja pelaajan rahat riitt��
* Laske panos
  * onnistuu jos peli ei ole k�yniss� ja panos on suurempi kun 0
* Split (toteutetaan my�hemmin)
  * onnistuu jos peli on k�yniss� ja on kaksi samanlaista korttia
* Double down (toteutetaan my�hemmin)
  * onnistuu jos peli on k�yniss� ja pelaajalla on kaksi korttia jonka yhtenlaskettu summa on 9,10 tai 11

**Luokkakaaviot**
  
![luokkakaavio](luokkakaavio.png)

**Sekvenssikaaviot**
  
![Panos Nostetaan](plusButtonPressed.png)
  
![Pelaaja j��](stayButton.png)
