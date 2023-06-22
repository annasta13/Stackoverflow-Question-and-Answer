package com.explore.stackoverflow.ui.answer.question76433128

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.explore.stackoverflow.databinding.FragmentSampleBinding
import dagger.hilt.android.AndroidEntryPoint


/*
 * Case: https://stackoverflow.com/questions/76433128
 */

@AndroidEntryPoint
class SampleFragment : Fragment() {
    private lateinit var binding: FragmentSampleBinding
    val viewModel: SampleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSampleBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }
}