package com.example.library.presentation.activity.registration

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding
    private lateinit var viewModel: RegistrationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
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

        viewModel.getActionDirections().observe(viewLifecycleOwner) { direction ->
            if (direction != null) {
                Toast.makeText(context, resources.getString(R.string.success_registration), Toast.LENGTH_SHORT).show()
                Handler(requireActivity().mainLooper).postDelayed({
                    findNavController().navigate(direction)
                }, 2500)
            }
        }

        binding.buttonRegistration.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.signUp(
                    UserForm(
                        userName = binding.fullName.text.toString(),
                        userLogin = binding.login.text.toString(),
                        userPassword = binding.password.text.toString().hashCode(),
                        reUserPassword = binding.rePassword.text.toString().hashCode()
                    )
                )
            }
        }

        return binding.root
    }
}