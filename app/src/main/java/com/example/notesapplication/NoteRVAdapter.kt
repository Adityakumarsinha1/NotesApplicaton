package com.example.notesapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoteRVAdapter(
    val context: Context
    , val noteClickInterface: NoteClickInterface
    , val noteDeleteInterface: NoteDeleteInterface
    ) : RecyclerView.Adapter<NoteRVAdapter.ViewHolder>() {

    private val allNotes = ArrayList<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_rv_item,parent,false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.noteTv.text = allNotes[position].noteTitle
        holder.noteTime.text = "Last Updated"+allNotes[position].noteTimeStamp
        holder.noteDelete.setOnClickListener {
            noteDeleteInterface.onDeleteIconClick(allNotes[position])
        }

        holder.itemView.setOnClickListener {
            noteClickInterface.onNoteClick(allNotes[position])
        }
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    class ViewHolder(itemView: View ):RecyclerView.ViewHolder(itemView) {
        val noteTv = itemView.findViewById<TextView>(R.id.idTVNoteTitle)
        val noteTime = itemView.findViewById<TextView>(R.id.idTVNoteTime)
        val noteDelete = itemView.findViewById<ImageView>(R.id.idDeleteNotes)
    }

    fun updateList(newList: List<Note>)
    {
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

}

interface NoteClickInterface{
    fun onNoteClick(note: Note)
}
interface NoteDeleteInterface{
    fun onDeleteIconClick(note: Note)
}
