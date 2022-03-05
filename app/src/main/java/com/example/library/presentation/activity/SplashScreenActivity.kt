package com.example.library.presentation.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.library.R
import com.example.library.databinding.ActivitySplashScreenBinding
import com.example.library.domain.di.repository_modules.RepositoryModule
import com.example.library.domain.di.service_modules.ServiceModule
import com.example.library.domain.di.use_case_modules.UseCaseModule
import com.example.library.domain.model.Library
import com.example.library.domain.viewmodel.SplashScreenViewModel
import com.example.library.domain.viewmodelfactory.LibraryViewModelFactory
import com.example.library.presentation.activity.login.LoginActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var viewModel: SplashScreenViewModel
    private var libraries: List<Library> = emptyList()
    private val editor: SharedPreferences.Editor by lazy {
        this.getSharedPreferences(resources.getString(R.string.app_name), 0).edit()
    }
    private val idLibrary by lazy {
        this.getSharedPreferences(resources.getString(R.string.app_name), 0).getInt("idLibrary", -1)
    }

    private val tokenUser by lazy {
        this.getSharedPreferences(resources.getString(R.string.app_name), 0).getString("tokeUser", "")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, LibraryViewModelFactory(
                UseCaseModule(),
                RepositoryModule(),
                ServiceModule(),
                applicationContext)).get(SplashScreenViewModel::class.java)

        viewModel.getSelectedLibrary().observe(this) {
            editor.putInt("idLibrary", it.id)
            editor.commit()
            Handler(mainLooper).postDelayed({
                showPage(LoginActivity::class.java)
            }, 3000)
        }

        if (idLibrary == -1) {
            viewModel.setLibraries()
            viewModel.getLibraries().observe(this) { list ->
                list?.let {
                    libraries = it
                    Handler(mainLooper).postDelayed({
                        this.showLibraries()
                    }, 2000)
                }
            }
        } else if (!tokenUser.equals("")) {
            print("vsdvsdv")
        } else {
            Handler(mainLooper).postDelayed({
                showPage(LoginActivity::class.java)
            }, 3000)
        }
    }

    private fun showLibraries() {
        binding.splashIcon.visibility = View.GONE
        binding.splashText.visibility = View.GONE
        //show modal window for library selection
        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle("Выберите библиотеку")
            setItems(libraries.map { it.name }.toTypedArray()) { _, which ->
                libraries.find { actor ->
                    libraries.map { it.name }.toTypedArray()[which] == actor.name
                }?.let { viewModel.selectLibrary(it) }
            }
            setPositiveButton("OK") { dialogInterface, _ ->
                dialogInterface.cancel()
            }
            show()
        }
    }

    private fun showPage(cl: Class<*>) {
        val intent = Intent(applicationContext, cl)
        startActivity(intent)
        this.finish()
    }
}