package com.example.ratemyprofessor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast

class RateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate)
        val rate=findViewById<View>(R.id.ratingBar)as RatingBar
        val submit=findViewById<View>(R.id.button)as Button
        submit.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"თქვენი შეფასებაა:"+rate.rating.toString(),Toast.LENGTH_LONG).show()
        })

    }
}