**Aihe:** 
   Toteutetaan Blackjackpeli. Peliä toteutetaan niin että luokat pystyy helposti käyttämään erilaisiin muihin korttipeleihin. Mahdollisesti voidaan peli sitten laajentaa niin että on olemassa myös muita korttipelejä mukana. Alussa ei toteuteta erikoisäänöt kun splittaus ja ei myöskään ole mahdollista panostaa. Näitä toimintoja lisätään sitten tulevaisuudessa.

**Luokkakaaviot**
![Määrittelyvaiheen luokkakaavio](luokkakaavio.png)

**Käyttäjä** pelaaja

**Kaikkien käytäjien toiminnot:**

* Uusi peli
  * onnistuu jos peli ei ole käynissä
* Lopeta peli
  + onnistuu jos peli on käynissä
* Lisää kortti
  * onnistuu jos peli on käynissä ja korttien summa ei ole yli 21
* Jää
  * onnistuu jos peli on käynissä ja korttien summa ei ole yli 21
* Split
  * onnistuu jos peli on käynissä ja on kaksi samanlaista korttia