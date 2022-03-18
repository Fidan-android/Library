package com.example.library.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.library.R
import com.example.library.databinding.ActivityGlobalBinding

class GlobalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGlobalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGlobalBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}