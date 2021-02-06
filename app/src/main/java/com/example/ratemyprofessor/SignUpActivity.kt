package com.example.ratemyprofessor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        init()
    }

    private fun init() {
        auth = Firebase.auth
        signUpButton.setOnClickListener {
            signUp()
        }
    }

    private fun signUp() {
        auth = Firebase.auth
        val email:String = emailEditText.text.toString()
        val password:String = passwordEditText.text.toString()
        val repeatPassword: String = repeatPasswordEditText.text.toString()

        if (emailEditText.text.toString().isNotEmpty()&&passwordEditText.text.toString().isNotEmpty()
            &&repeatPasswordEditText.text.toString().isNotEmpty()
        ) {
            if (password == repeatPassword) {
                deleteClick(true)
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        deleteClick(false)
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            d("signUp", "createUserWithEmail:success")
                            val user = auth.currentUser
                            openMain()
                        } else {
                            // If sign in fails, display a message to the user.
                            d("signUp", "createUserWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                LENGTH_SHORT
                            ).show()
                        }

                        // ...
                    }
            }
        }
    }


    private fun deleteClick(isStarted: Boolean) {
        signUpButton.isClickable = !isStarted
        if (isStarted)
            progressBar.visibility = View.VISIBLE
        else
            progressBar.visibility = View.GONE


    }

    private fun openMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)


    }

}