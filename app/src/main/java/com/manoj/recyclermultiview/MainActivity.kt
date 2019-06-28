package com.manoj.recyclermultiview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manoj.recyclermultiview.adapter.MainListAdapter
import com.manoj.recyclermultiview.listeners.RecyclerViewClickListener
import com.manoj.recyclermultiview.models.ClassMember
import com.manoj.recyclermultiview.models.CreateViewLists
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerViewClickListener {
    private var classList: MutableList<ClassMember> = mutableListOf()
    private lateinit var adapter: MainListAdapter
    override fun onItemClickListener(position: Int) {
        classList.addAll(position, CreateViewLists.getTeachersList())
        adapter.notifyItemRangeInserted(position, 10)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val d: Double = 23.345
        val fs = String.format("%.2f", d)
        Log.d("formatted string", fs)
        classList = CreateViewLists.getTeachersList()
        classList.add(0, CreateViewLists.createHeaderType("Teachers of Class 7"))
        classList.add(classList.size - 1, CreateViewLists.createFooterType("Load more"))
        classList.add(classList.size - 1, CreateViewLists.createHeaderType("Students of Class 7"))
        classList.addAll(CreateViewLists.getStudentsList())
        adapter = MainListAdapter(classList, this)
        rv_main.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_main.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))
        rv_main.adapter = adapter
    }

}
