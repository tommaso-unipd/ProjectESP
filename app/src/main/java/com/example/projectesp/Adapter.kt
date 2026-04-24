package com.example.projectesp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// qui creo l'adapter per le funzioni che poi userò nella schermata 2 per mostrare i dati
//che arrivano dalla schermata 1
class Adapter(private val ListPartite: List<String>) :
    RecyclerView.Adapter<Adapter.PartiteViewHolder>() {

    // con il viewholder memorizzo gli id della riga
    class PartiteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val Count: TextView = view.findViewById(R.id.conto_partite)
        val Sequence: TextView = view.findViewById(R.id.sequenza_partite)
    }

    // qui dico all'Adapter di prendere il file item xml e trasformarlo in un oggetto vero
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartiteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_partite, parent, false)
        return PartiteViewHolder(view)
    }


    override fun onBindViewHolder(holder: PartiteViewHolder, position: Int) {
        //prendo la sequenza corrispondente alla posizione
        val currentMatch = ListPartite[position]
        // calcolo il numero di colori
        // se la stringa è vuota il conteggio è 0 altrimenti conto gli elementi separati da virgola
        val itemsCount = if (currentMatch.isEmpty()) 0 else currentMatch.split(",").size
        //inserisco i dati nelle TextView salvate nel PartiteViewHolder
        holder.Count.text = itemsCount.toString()
        holder.Sequence.text = currentMatch
    }

    // questa funzione mi dirà quanto è lunga la lista
    override fun getItemCount(): Int = ListPartite.size
}