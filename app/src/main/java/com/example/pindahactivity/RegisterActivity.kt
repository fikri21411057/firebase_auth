package com.example.pindahactivity

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pindahactivity.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    private fun registerUser(email: String, password: String) {

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                Intent(this, MainActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            } else {
                Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnReg.setOnClickListener{

            val email : String = binding.editEmail.text.toString().trim()
            val password: String = binding.editPassword.text.toString().trim()
            val repassword: String = binding.editPassword2.text.toString().trim()

            if (email.isEmpty()){
                binding.editEmail.error = "Input Email"
                binding.editEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.editEmail.error = "Invalid Email"
                binding.editEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6){
                binding.editPassword.error = "password must be more than 6 characters"
                binding.editPassword.requestFocus()
                return@setOnClickListener
            }

            if (password != repassword){
                binding.editPassword2.error = "password must be match"
                binding.editPassword2.requestFocus()
                return@setOnClickListener
            }
            registerUser(email, password)
        }

        binding.textLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}