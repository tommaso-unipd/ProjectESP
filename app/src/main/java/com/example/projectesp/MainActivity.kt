package com.example.projectesp

import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.activity.ComponentActivity



class MainActivity : ComponentActivity() {
    //stringa per tenre in memoria la sequenza di lettere
    private var currentSeq = ""

    //lista per memorizzare le sequenze giocate
    private var partite = ArrayList<String>()

    //sequenza nella casella di testo sullo schermo
    private lateinit var textSeq: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //collego il layout xml
        setContentView(R.layout.activity_main)

        //trovo il TextView tramite il suo id
        textSeq = findViewById(R.id.sequence)

        //per la rotazione dello schermo andiamo a riprenderci la stringa salvate se esiste per
        //recuperare lo stato
        if (savedInstanceState != null) {
            currentSeq = savedInstanceState.getString("seq_saved", "")
            //qua mi riprendo la lista di partite salvate se esiste
            val partiteSaved = savedInstanceState.getStringArrayList("partite_saved")
            if(partiteSaved != null){
                partite = partiteSaved
            }
            textSeq.text = getString(R.string.sequence) + "$currentSeq"
        }

        //gestione dei bottoni: li metto in una lista
        val ColorButtons = listOf(
            findViewById<Button>(R.id.red),
            findViewById<Button>(R.id.green),
            findViewById<Button>(R.id.blue),
            findViewById<Button>(R.id.magenta),
            findViewById<Button>(R.id.yellow),
            findViewById<Button>(R.id.cyan),
        )

        //per ogni bottone imposto il listener e aggiungo la lettera con la virgola se serve
        for (button in ColorButtons) {
            button.setOnClickListener { view ->
                val letter = view.tag.toString()
                if (currentSeq.isEmpty()){
                    currentSeq = letter
                }else { currentSeq += ", $letter"}
                textSeq.text = getString(R.string.sequence) + "$currentSeq"
            }
        }

        //gestisco il bottone per cancellare
        val btnCancel = findViewById<Button>(R.id.cancel)
        btnCancel.setOnClickListener {
            currentSeq = ""
            textSeq.text = getString(R.string.sequence) + "$currentSeq"
        }

        //gestisco il bottone per finire la partita, salvare la partita nella lista, svuotare lo
        //schermo e aprire la schermata2 coon un Intent
        val btnEndGame = findViewById<Button>(R.id.end_game)
        btnEndGame.setOnClickListener {
            partite.add(currentSeq)
            currentSeq = ""
            textSeq.text = getString(R.string.sequence) + "$currentSeq"
            val intent = android.content.Intent(this, Schermata_2::class.java)
            intent.putStringArrayListExtra("partiteSeq", partite)
            startActivity(intent)
        }


    }
    //salvo lo stato dell'istanza memorizzando la stringa nel bundle
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("seq_saved", currentSeq)
        // aggiungiamo anche la memorizzazione delle partite
        outState.putStringArrayList("partite_saved", partite)
    }

}


