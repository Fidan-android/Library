package com.example.library.presentation.activity.login

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.library.R
import com.example.library.databinding.FragmentLoginBinding
import com.example.library.domain.di.repository_modules.RepositoryModule
import com.example.library.domain.di.service_modules.ServiceModule
import com.example.library.domain.di.use_case_modules.UseCaseModule
import com.example.library.domain.model.LoginForm
import com.example.library.domain.viewmodel.LoginViewModel
import com.example.library.domain.viewmodelfactory.LibraryViewModelFactory

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel =
            ViewModelProvider(this, LibraryViewModelFactory(
                UseCaseModule(),
                RepositoryModule(),
                ServiceModule(),
                requireActivity().applicationContext)
            )[LoginViewModel::class.java]

        viewModel.getToken().observe(viewLifecycleOwner) {
            if (it != "") {
                viewModel.saveToken()
            }
        }

        viewModel.wrongText().observe(viewLifecycleOwner) {
            if (it != "") {
                binding.wrongData.text = it
                Handler(requireActivity().mainLooper).postDelayed({
                    binding.wrongData.text = ""
                }, 2000)
            }
        }

        viewModel.getActionDirections().observe(viewLifecycleOwner) { direction ->
            if (direction != null) {
                Handler(requireActivity().mainLooper).postDelayed({
                    findNavController().navigate(direction)
                }, 1500)
            }
        }

        binding.buttonLogin.setOnClickListener {
            viewModel.logIn(LoginForm(
                userLogin = binding.login.toString(),
                userPassword = binding.password.toString().hashCode())
            )
        }

        binding.openRegistration.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}