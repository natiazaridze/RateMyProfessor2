package com.example.ratemyprofessor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_authentication.*
import kotlinx.android.synthetic.main.list_item.*

class AuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        init()
    }

    private fun init(){
    LogInButton.setOnClickListener {
        val intent = Intent(this,LogInActivity::class.java)
        startActivity(intent)
}

        SignUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }
    }
}