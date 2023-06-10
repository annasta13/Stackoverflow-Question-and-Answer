package com.explore.stackoverflow.ui.answer.question76445761

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.explore.stackoverflow.databinding.FragmentSample2Binding
import dagger.hilt.android.AndroidEntryPoint

/*
 * Case: https://stackoverflow.com/questions/76445761
 * */

@AndroidEntryPoint
class Sample2Fragment : Fragment() {
    private lateinit var binding: FragmentSample2Binding
    private val viewModel: Sample2FragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSample2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }
}