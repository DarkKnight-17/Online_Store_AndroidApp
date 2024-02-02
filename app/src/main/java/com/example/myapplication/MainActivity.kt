package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin = findViewById<EditText>(R.id.user_login)
        val userEmail = findViewById<EditText>(R.id.user_email)
        val userPassword = findViewById<EditText>(R.id.user_password)
        val button = findViewById<Button>(R.id.button_reg)
        val linkToAuth = findViewById<TextView>(R.id.link_to_auth)

        linkToAuth.setOnClickListener{
            val intent  = Intent(this,AuthActivity::class.java)
            startActivity(intent)
        }


        button.setOnClickListener{
            val user_login = userLogin.text.toString().trim()
            val user_email = userEmail.text.toString().trim()
            val user_pass = userPassword.text.toString().trim()

            if(user_login == "" || user_email == "" || user_pass == ""){
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
            }else{
                val user = User(user_login, user_email, user_pass)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this,"Пользователь $user_login добавлен", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()
            }
        }
    }
}