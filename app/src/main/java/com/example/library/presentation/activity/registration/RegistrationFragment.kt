package com.example.library.presentation.activity.registration

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.library.R
import com.example.library.databinding.FragmentLoginBinding
import com.example.library.databinding.FragmentRegistrationBinding
import com.example.library.domain.di.repository_modules.RepositoryModule
import com.example.library.domain.di.service_modules.ServiceModule
import com.example.library.domain.di.use_case_modules.UseCaseModule
import com.example.library.domain.model.RegistrationForm
import com.example.library.domain.model.UserForm
import com.example.library.domain.viewmodel.LoginViewModel
import com.example.library.domain.viewmodel.RegistrationViewModel
import com.example.library.domain.viewmodelfactory.LibraryViewModelFactory

class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RegistrationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        viewModel =
            ViewModelProvider(this, LibraryViewModelFactory(
                UseCaseModule(),
                RepositoryModule(),
                ServiceModule(),
                requireActivity().applicationContext)
            )[RegistrationViewModel::class.java]

        viewModel.wrongText().observe(viewLifecycleOwner) {
            if (it != "") {
                binding.wrongData.text = it
                Handler(requireActivity().mainLooper).postDelayed({
                    binding.wrongData.text = ""
                }, 3000)
            }
        }

        binding.openLogin.setOnClickListener {
            findNavController().navigate(RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment())
        }

        binding.buttonRegistration.setOnClickListener {
            viewModel.signUp(UserForm(
                userName = binding.fullName.text.toString(),
                userLogin = binding.login.text.toString(),
                userPassword = binding.password.text.toString().hashCode(),
                reUserPassword = binding.rePassword.text.toString().hashCode()
            ))
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}