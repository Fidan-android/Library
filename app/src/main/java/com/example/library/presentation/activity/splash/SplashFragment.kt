package com.example.library.presentation.activity.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.library.R
import com.example.library.databinding.FragmentSplashBinding
import com.example.library.domain.di.repository_modules.RepositoryModule
import com.example.library.domain.di.service_modules.ServiceModule
import com.example.library.domain.di.use_case_modules.UseCaseModule
import com.example.library.domain.model.Library
import com.example.library.domain.viewmodel.SplashScreenViewModel
import com.example.library.domain.viewmodelfactory.LibraryViewModelFactory

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SplashScreenViewModel
    private lateinit var libraries: List<Library>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)


        viewModel =
            ViewModelProvider(this, LibraryViewModelFactory(
                UseCaseModule(),
                RepositoryModule(),
                ServiceModule(),
                requireActivity().applicationContext)
            )[SplashScreenViewModel::class.java]

        viewModel.getLibraries().observe(viewLifecycleOwner) {
            libraries = it
        }

        viewModel.getActionDirections().observe(viewLifecycleOwner) {
            if (it != null) {
                findNavController().navigate(it)
            }
        }

        viewModel.getSelectedLibrary().observe(viewLifecycleOwner) { library ->
            if (library != null) {
                Handler(requireActivity().mainLooper).postDelayed({
                   viewModel.checkToken()
                }, 3000)
            } else {
                Handler(requireActivity().mainLooper).postDelayed({
                    val builder = AlertDialog.Builder(requireContext())
                    with(builder) {
                        setTitle("Выберите библиотеку")
                        setItems(libraries.map { it.name }.toTypedArray()) { _, which ->
                            libraries.find { actor ->
                                libraries.map { it.name }.toTypedArray()[which] == actor.name
                            }?.let {
                                viewModel.selectLibrary(it)
                            }
                        }
                        setPositiveButton("OK") { dialogInterface, _ ->
                            dialogInterface.cancel()
                        }
                        show()
                    }
                }, 2000)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}