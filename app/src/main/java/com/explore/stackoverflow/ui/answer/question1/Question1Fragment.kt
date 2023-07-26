package com.explore.stackoverflow.ui.answer.question1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.explore.stackoverflow.databinding.FragmentQuestion1Binding
import dagger.hilt.android.AndroidEntryPoint


/*
 * Case: https://stackoverflow.com/questions/76433128
 */

@AndroidEntryPoint
class Question1Fragment : Fragment() {
    private lateinit var binding: FragmentQuestion1Binding
    val viewModel: Question1ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestion1Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }
}