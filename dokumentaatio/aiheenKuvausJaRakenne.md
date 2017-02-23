**Aihe:** 
   Toteutetaan Blackjackpeli. Tarkoitus on toteuttaa peliä niin että se vastaa mahdollisimman tarkasti peliä oikeassa casinossa. Simuluidaan oikea korttipakka jolloin kehittynyt pelaaja pärjää paremmin jos hän muistaa mitä kortteja on jo tullut. Myöhemin on tarkoitus toteuttaa korttien jakaaminen ja mahdollisuus käyttää useampi korttipakka pelissä.


**Käyttäjä** pelaaja

* Uusi peli
  * onnistuu jos peli ei ole käynissä
* Lisää kortti
  * onnistuu jos peli on käynissä ja korttien summa ei ole yli 21
* Jää
  * onnistuu jos peli on käynissä ja korttien summa ei ole yli 21
* Nosta panos
  * onnistuu jos peli ei ole käynissä ja pelaajan rahat riittää
* Laske panos
  * onnistuu jos peli ei ole käynissä ja panos on suurempi kun 0
* Split (toteutetaan myöhemmin)
  * onnistuu jos peli on käynissä ja on kaksi samanlaista korttia
* Double down (toteutetaan myöhemmin)
  * onnistuu jos peli on käynissä ja pelaajalla on kaksi korttia jonka yhtenlaskettu summa on 9,10 tai 11

**Luokkakaaviot**
  
![luokkakaavio](luokkakaavio.png)

**Sekvenssikaaviot**
  
![Panos Nostetaan](plusButtonPressed.png)
  
![Pelaaja jää](stayButton.png)
