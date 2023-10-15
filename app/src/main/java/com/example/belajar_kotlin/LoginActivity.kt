package com.example.belajar_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.belajar_kotlin.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnLogin.setOnClickListener {
                val usernameText = username.text.toString()
                val password = password.text.toString()
                if (checkCredentials(usernameText, password)) { // Check credentials
                    val intent = Intent(this@LoginActivity, HomePageActivity::class.java)
                    intent.putExtra("usn", usernameText)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Invalid username or password, please check the input.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun checkCredentials(username: String, password: String): Boolean {
        val userCredentials = listOf(
            Pair("nauval", "12345"),
            Pair("makmurjaya", "888"),
        )
        for ((storedUsername, storedPassword) in userCredentials) {
            if (username == storedUsername && password == storedPassword) {
                return true
            }
        }
        return false
    }
}