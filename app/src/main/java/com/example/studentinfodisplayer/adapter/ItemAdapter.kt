package com.example.studentinfodisplayer.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.studentinfodisplayer.R
import com.example.studentinfodisplayer.model.StudentModel
class ItemAdapter(
    private val context:Context,
    private val dataset : List<StudentModel>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
        class ItemViewHolder(private val view: View): ViewHolder(view){
            // Find the text view
            val studentNameTextView : TextView = view.findViewById(R.id.studentName)
            val studentIdTextView : TextView = view.findViewById(R.id.studentId)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // get adapter layout for the list item
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        /* Here we set the student's name and id to each corresponding data line
         * I also formatted a type of user id that is input into the student id text view
         */
        holder.studentNameTextView.text = item.studentName
        holder.studentIdTextView.text = context.resources.getString(R.string.student_id_123, "HUST" + item.studentId)
    }
}