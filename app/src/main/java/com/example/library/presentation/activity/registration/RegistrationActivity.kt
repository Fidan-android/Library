package com.example.library.presentation.activity.registration

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.library.R
import com.example.library.databinding.ActivityRegistrationBinding
import com.example.library.domain.di.repository_modules.RepositoryModule
import com.example.library.domain.di.service_modules.ServiceModule
import com.example.library.domain.di.use_case_modules.UseCaseModule
import com.example.library.domain.model.RegistrationForm
import com.example.library.domain.viewmodel.RegistrationViewModel
import com.example.library.domain.viewmodelfactory.LibraryViewModelFactory

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var viewModel: RegistrationViewModel

    private val handler: Handler by lazy {
        Handler(mainLooper)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, LibraryViewModelFactory(
                UseCaseModule(),
                RepositoryModule(),
                ServiceModule(),
                applicationContext)
            ).get(RegistrationViewModel::class.java)

        binding.openLogin.setOnClickListener {
            onBackPressed()
        }

        binding.buttonRegistration.setOnClickListener {
            if (binding.fullName.text.toString() == "" || binding.login.text.toString() == "" ||
                    binding.password.text.toString() == "" || binding.rePassword.text.toString() == "") {
                showWrongMessage(binding.wrongData)
            } else if (binding.password.text.toString() != binding.rePassword.text.toString()) {
                showWrongMessage(binding.wrongPassword)
            } else {

                viewModel.getStatusValidate().observe(this) {
                    when(it) {
                        -1 -> {

                            viewModel.getIsRegistration().observe(this) { response ->
                                when(response) {
                                    "success" -> {
                                        Toast.makeText(applicationContext, resources.getString(R.string.success_registration), Toast.LENGTH_SHORT).show()
                                        handler.postDelayed({
                                            onBackPressed()
                                        }, 1500)
                                    }

                                    "error" -> {
                                        Toast.makeText(applicationContext, resources.getString(R.string.account_has_been), Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }
                        }

                        0 -> {
                            showWrongMessage(binding.wrongPhoneNumber)
                        }
                    }
                }


            }
        }
    }

    private fun showWrongMessage(view: View) {
        view.visibility = View.VISIBLE
        handler.postDelayed({
            view.visibility = View.GONE
        }, 3000)
    }
}