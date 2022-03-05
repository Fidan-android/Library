package com.example.library.presentation.activity.books

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.library.databinding.ActivityBooksBinding
import com.example.library.domain.di.repository_modules.RepositoryModule
import com.example.library.domain.di.service_modules.ServiceModule
import com.example.library.domain.di.use_case_modules.UseCaseModule
import com.example.library.domain.viewmodel.BooksViewModel
import com.example.library.domain.viewmodel.RegistrationViewModel
import com.example.library.domain.viewmodelfactory.LibraryViewModelFactory
import com.example.library.presentation.adapter.CommonDataRecyclerAdapter

class BooksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBooksBinding
    private lateinit var viewModel: BooksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, LibraryViewModelFactory(
                UseCaseModule(),
                RepositoryModule(),
                ServiceModule(),
                applicationContext)
            ).get(BooksViewModel::class.java)

        viewModel.downloadBooks()

        viewModel.getBooks().observe(this) {
            binding.booksRecycler.adapter = CommonDataRecyclerAdapter<Int>(it)
        }
    }
}