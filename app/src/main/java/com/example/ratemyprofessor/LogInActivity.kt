package com.example.ratemyprofessor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class LogInActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        init()
    }

    private fun init() {
        auth = Firebase.auth
        logInButton.setOnClickListener {
            logIn()
        }
    }

    private fun logIn() {
        auth = Firebase.auth
        val email: String = emailText.text.toString()
        val password: String = passwordText.text.toString()
        if (emailText.text.toString().isNotEmpty() && passwordText.text.toString().isNotEmpty()
        ) {

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        d("TAG", "signInWithEmail:success")
                        val user = auth.currentUser
                        openMain()
                    } else {
                        // If sign in fails, display a message to the user.
                        d("TAG", "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                        // ...
                    }

                    // ...
                }
        }
    }

    private fun openMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}


