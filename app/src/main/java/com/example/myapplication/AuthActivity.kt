package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val userLogin = findViewById<EditText>(R.id.user_login_auth)
        val userPassword = findViewById<EditText>(R.id.user_password_auth)
        val button = findViewById<Button>(R.id.button_auth)
        val linkToReg = findViewById<TextView>(R.id.link_to_reg)


        button.setOnClickListener {
             val user_login = userLogin.text.toString().trim()
            val user_pass = userPassword.text.toString().trim()

            if(user_login == "" || user_pass == ""){
                Toast.makeText(this, "Заполните все поля" , Toast.LENGTH_LONG).show()
            }else{

                val db = DbHelper(this, null)
                val isRegistered = db.getUser(user_login, user_pass)

            if(isRegistered){
                Toast.makeText(this, "Пользователь $user_login авторизован", Toast.LENGTH_LONG).show()
                userLogin.text.clear()
                userPassword.text.clear()

                val intent = Intent(this, ItemsActivity::class.java)
                startActivity(intent)

            }else{
                Toast.makeText(this, "Пользователь $user_login НЕ зарегистрирован", Toast.LENGTH_LONG).show()

            }

            }
        }
        linkToReg.setOnClickListener{
            val intent  = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}