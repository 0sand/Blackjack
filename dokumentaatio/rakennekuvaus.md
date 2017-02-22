
## Rakennekuvaus

  Ensin on rakennettu korttipakka (deck) joka sisältää 52 korttia (card). Kortteilla on arvo ja väri. Korttipakka osaa sekoitua itsensä ja se voi jakaa kortteja. Korttipakassa on aina 52 korttia vaikka niitä jaetaan. Korttipakka tietää mikä kortti pitää jakaa seuraavaksi mutta käytetyt kortit ei ikinä poistu.
Lisäksi on olemassa pelaaja (Player). Pelaajalla voi olla kortteja rajaton määrä. Alussa pelaajalla ei ole yhtään korttia mutta hän voi saada niitä lisää tarvittaessa. Pelaaja tietää korttiensa yhteenlaskettu summa, kun ässä on joko 10 tai 11 ja kuvakortin arvo on aina 10. Pelaajalla on myös rahaa ja pelaaja tietää kuinka monta peliä hän on voittanut ja kuinka monta peliä on pelattu yhteensä.
Tärkein osuus pelissä on itse peli (game). Pelillä on pelaaja (Player) ja jakaja (Player). Lisäksi pelissä on korttipakka (Deck) ja pankki (BetManager). Pankki hoitaa voitonmaksun pelaajalle ja tietää kuinka suuri panos on.
  Peli tietää, jos jakajan pitää ottaa uuden kortin ja tietää jos pelaaja on voittanut. Lisäksi peli tietää, jos jonkun pelaajan korttien yhteenlaskettu summa on yli 21 tai jos on saatu Blackjack. Lisääksi peli päivittää voittolaskurit ja pyytää pankin maksamaan, mikäli pelaaja on voittanut. 

  Ohjelmassa on graafinen käyttöliittymä. Käyttöliittymällä on peli (game). Käyttöliittymässä on nappeja, hit, stay, deal, +, -. Jokaisella napilla on oma tapahtuma kuuntelija. Tapahtuma kuuntelijat päivittä pelin statuksen. Lisäksi käyttöliittymässä on infopaletti missä näkyy pelaajan voittojen määrä, kaikkien pelattujen pelien määrä, pelin panoksen, pelaajan rahamäärän ja lisäksi kuka on voittanut pelin. 
Lisääksi käyttöliittymässä on tilaa sekä jakajan kortille, että pelaajan kortille.
