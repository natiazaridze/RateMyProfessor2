package com.example.ratemyprofessor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.*

class MainActivity : AppCompatActivity() {
    private val img = arrayOf(R.drawable.programmerr,R.drawable.programmersecond,R.drawable.programmerthird,R.drawable.programmerfourth,R.drawable.calculustwo,R.drawable.programmerfive,R.drawable.programmersix,R.drawable.programmerseven,R.drawable.programmereight,R.drawable.calculusone)
    private val texts = arrayOf("ნიკა ტაბატაძე","სერგო კვიჟინაძე","ჯანო ბოკუჩავა","გიორგი ჩუგოშვილი","შოთა ზაზაშვილი","მიხეილ სამხარაძე","ლიკა სვანაძე","მაია სვანიძე","ვახტანგ როდონაია","რევაზ ციცქიშვილი")
    private val desc = arrayOf("Mobile Applications/მობილური აპლიკაციები-მოწვეული სპეციალისტი BTU-ში","Programming Essentials(Python)/პროგრამირების საწყისები(Python)-მოწვეული სპეციალისტი BTU-ში","Mobile Applications/მობილური აპლიკაციები-მოწვეული სპეციალისტი BTU-ში",
    "Introduction to Entrepreneurship/შესავალი მეწარმეობაში-მოწვეული სპეციალისტი BTU-ში",
    "Calculus/კალკულუსი-მოწვეული ლექტორი BTU-ში","Introduction to Computer Networks/კომპიუტერული ქსელების საწყისები-მოწვეული სპეციალისტი BTU-ში",
    "Programming Essentials(Python)/პროგრამირების საწყისები(Python)-ასისტენტ-პროფესორი","Digital Technology Principles/ციფრული ტექნოლოგიების პრინციპები-მოწვეული ლექტორი BTU-ში",
    "Introduction to Computer Networks/კომპიუტერული ქსელების საწყისები-ასოცირებული პროფესორი BTU-ში","Calculus/კალკულუსი-ასოცირებული პროფესორი BTU-ში ")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        val recyclerView =  findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomAdapter(img,texts,desc)
    }
    private fun init(){
        rateit.setOnClickListener{
            val intent = Intent(this,RateActivity::class.java)
            startActivity(intent)
        }
    }

}