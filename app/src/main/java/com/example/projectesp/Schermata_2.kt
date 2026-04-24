package com.example.projectesp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Schermata_2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schermata2)
        
        //recupero la lista inviata dalla mainactivity tramite l'intent
        val cronologia = intent.getStringArrayListExtra("partiteSeq") ?:arrayListOf()
        //trovo la recycler view nel layout
        val recyclerView = findViewById<RecyclerView>(R.id.history)
        //imposto il layout manager che dice alla lista di andare dall'alto in basso
        recyclerView.layoutManager = LinearLayoutManager(this)
        //collego l'adapter con i dati
        val adapter = Adapter(cronologia)
        recyclerView.adapter = adapter


    }

}