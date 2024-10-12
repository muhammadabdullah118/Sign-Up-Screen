package com.example.secondapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.secondapp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() , View.OnClickListener {

    private var _binding :ActivityMainBinding?=null
    val binding get()= _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding!!.root)

        initiaize()
        registerClicks()

    }

    private fun initiaize() {
        binding!!.textEmail.hint="Email"
        binding!!.textPassword.hint="Password"
        binding!!.textConfirmPass.hint="Confirm Password"
        binding!!.textreCAPTCHA.hint="Enter reCAPTCHA"
        binding!!.reCAPTCHA
    }

    private fun registerClicks() {
       binding!!.buttonSignUp.setOnClickListener(this)
    }

    override fun onClick(view : View?) {
        val textRecaptcha= binding!!.textreCAPTCHA.text.toString()
        val recaptcha = binding!!.reCAPTCHA.text.toString()
        val password= binding!!.textPassword.text.toString()
        val confirmPassword = binding!!.textConfirmPass.text.toString()

        when(view?.id){
            R.id.buttonSignUp -> {
                if(textRecaptcha==recaptcha && password==confirmPassword ){
                   val intent = Intent(this,
                       SuccessActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
                }
                else{
                    val random = Random.nextInt(1000,9999)
                    binding!!.reCAPTCHA.text=random.toString()
                    Toast.makeText(this, " Invalid Input " , Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}