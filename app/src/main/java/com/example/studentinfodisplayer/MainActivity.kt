package com.example.studentinfodisplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.studentinfodisplayer.adapter.ItemAdapter
import com.example.studentinfodisplayer.model.StudentModel
import com.example.studentinfodisplayer.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // create binding for easier access
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create a list that holds information of a student
        val lstStudent = mutableListOf<StudentModel>()
        // Generate Student's data
        for (i in 1..1000){
            val studentInfo = StudentModel("Student $i", i)
            lstStudent.add(studentInfo)
        }
        // Create recycler view and use the adapter to make it view the list of student
        val recyclerView = binding.recyclerView
        recyclerView.adapter = ItemAdapter(this, lstStudent)
        recyclerView.setHasFixedSize(true)
    }
}