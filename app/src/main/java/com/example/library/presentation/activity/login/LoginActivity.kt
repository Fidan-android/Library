package com.example.library.presentation.activity.login

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.library.R
import com.example.library.databinding.ActivityLoginBinding
import com.example.library.domain.di.repository_modules.RepositoryModule
import com.example.library.domain.di.service_modules.ServiceModule
import com.example.library.domain.di.use_case_modules.UseCaseModule
import com.example.library.domain.model.LoginForm
import com.example.library.domain.viewmodel.LoginViewModel
import com.example.library.domain.viewmodel.SplashScreenViewModel
import com.example.library.domain.viewmodelfactory.LibraryViewModelFactory
import com.example.library.presentation.activity.books.BooksActivity
import com.example.library.presentation.activity.registration.RegistrationActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    private val handler: Handler by lazy {
        Handler(mainLooper)
    }

    private val editor: SharedPreferences.Editor by lazy {
        this.getSharedPreferences(resources.getString(R.string.app_name), 0).edit()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, LibraryViewModelFactory(
                UseCaseModule(),
                RepositoryModule(),
                ServiceModule(),
                applicationContext)
            ).get(LoginViewModel::class.java)

        viewModel.getToken().observe(this) {
            if (it != "") {
                editor.putString("token", viewModel.getToken().value)
                editor.commit()
            }
        }

        binding.buttonLogin.setOnClickListener {
            if (binding.login.text.toString() == "" || binding.password.text.toString() == "") {
                showWrongMessage()
            } else {
                viewModel.checkLogin(LoginForm(binding.login.toString(),
                    binding.password.toString()))

                viewModel.getIsLogin().observe(this) {
                    if (!it) {
                        showWrongMessage()
                    } else {
                        Toast.makeText(applicationContext, "Login completed successfully", Toast.LENGTH_LONG).show()
                        handler.postDelayed({
                            startActivity(Intent(applicationContext, BooksActivity::class.java))
                            finish()
                        }, 3000)
                    }
                }
            }
        }

        binding.openRegistration.setOnClickListener {
            startActivity(Intent(applicationContext, RegistrationActivity::class.java))
        }
    }

    private fun showWrongMessage() {
        binding.wrongData.visibility = View.VISIBLE
        handler.postDelayed({
            binding.wrongData.visibility = View.GONE
        }, 3000)
    }
}