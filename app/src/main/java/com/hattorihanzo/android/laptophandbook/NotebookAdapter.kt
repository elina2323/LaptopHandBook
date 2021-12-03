package com.hattorihanzo.android.laptophandbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hattorihanzo.android.laptophandbook.databinding.NotebookItemBinding

class NotebookAdapter: RecyclerView.Adapter<NotebookAdapter.NotebookHolder>() {

    private val notebookList = ArrayList<Notebook>()

    class NotebookHolder(item: View): RecyclerView.ViewHolder(item) {

        private val binding = NotebookItemBinding.bind(item)

        fun bind(notebook: Notebook) = with(binding){
            imageView1.setImageResource(notebook.imageId)
            textViewTitle.text = notebook.title

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotebookHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notebook_item, parent, false)
        return NotebookHolder(view)
    }

    override fun onBindViewHolder(holder: NotebookHolder, position: Int) {
        holder.bind(notebookList[position])
    }

    override fun getItemCount(): Int {
        return notebookList.size
    }

    fun addNotebook(notebook: Notebook){
        notebookList.add(notebook)
        notifyDataSetChanged()
    }
}