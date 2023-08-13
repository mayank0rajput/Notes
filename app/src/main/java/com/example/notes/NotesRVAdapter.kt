package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val context: Context, private val listener: INotesRVAdapter) : RecyclerView.Adapter<NotesRVAdapter.NotesViewHolder>() {
    val allNote = ArrayList<Note>()
    inner class NotesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.text)
        val delete = itemView.findViewById<ImageButton>(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val viewHolder = NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        viewHolder.delete.setOnClickListener{
            listener.onItemClicked(allNote[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return allNote.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentNote = getItemId(position)
        holder.textView.text = currentNote.toString()
    }
    fun updateList(newList: List<Note>){
        allNote.clear()
        allNote.addAll(newList)

        notifyDataSetChanged()
    }
}
interface INotesRVAdapter{
    fun onItemClicked(note: Note)
}