package com.example.library.presentation.activity.books

import android.os.Build
import android.os.Bundle
import android.transition.Visibility
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.library.R
import com.example.library.databinding.FragmentBookListBinding
import com.example.library.databinding.FragmentLoginBinding
import com.example.library.domain.di.repository_modules.RepositoryModule
import com.example.library.domain.di.service_modules.ServiceModule
import com.example.library.domain.di.use_case_modules.UseCaseModule
import com.example.library.domain.model.Book
import com.example.library.domain.viewmodel.BooksViewModel
import com.example.library.domain.viewmodel.LoginViewModel
import com.example.library.domain.viewmodelfactory.LibraryViewModelFactory
import com.example.library.presentation.adapter.CommonDataRecyclerAdapter

class BookListFragment : Fragment() {

    private lateinit var binding: FragmentBookListBinding
    private lateinit var viewModel: BooksViewModel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentBookListBinding.inflate(inflater, container, false)
        viewModel =
            ViewModelProvider(this, LibraryViewModelFactory(
                UseCaseModule(),
                RepositoryModule(),
                ServiceModule(),
                requireActivity().applicationContext)
            )[BooksViewModel::class.java]

        viewModel.getIsNetwork().observe(viewLifecycleOwner) {
            if (it) {
                viewModel.downloadBooks()
            }
        }

        viewModel.getBooks().observe(viewLifecycleOwner) {
            binding.booksRecycler.adapter = CommonDataRecyclerAdapter(it)
        }

        return binding.root
    }
}