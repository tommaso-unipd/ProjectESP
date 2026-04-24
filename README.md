DISPOSITIVO UTILIZZATO
ho utilizzato l'emulatore del Pixel 2 Android 16.0


RIASSUNTO SVOLGIMENTO 

Per prima cosa ho creato le Risorse (colori e testi) in 3 file xml; 2 file per le stringhe(it e eng)
e uno per i 6 colori oltre al bianco e il nero.

poi ho creato i due file xml activity_main per la schermata 1 (uno per la visione verticale e uno
per quella orizzontale rispettivamente in Layout e in Layout-land)

adesso collego i pulsanti nel file MainActivity per far si che che scrivano le lettere dei colori
e i pulsanti per cancellare la sequenza e finire la partita.
per far si che l'app gestisca lo stato dell'istanza utilizzo la funzione onSaveInstanceState.

ora creo la schermata2 ma prima modifico la main activity per creare la lista che conterrà tutte le sequenze
da inserire e anche queste vanno poi aggiunte alla funzione di SaveInstance. Poi collego il bottone 
di fine partita alla seconda activity

ora disegno il layout della seconda schermata con la recyclerView e creo il modello item in xml

ora per far funzionare la recycler view creo l'adapter che conterrà le funzioni che userà la seconda activity
per mostrare la seconda schermata

Per ultima cosa programmo la seconda activity affinchè utilizzi l'adapter appena creato per mostrare i dati
inviati dalla main activity.

