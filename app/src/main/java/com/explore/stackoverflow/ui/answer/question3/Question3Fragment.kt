package com.explore.stackoverflow.ui.answer.question3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.explore.stackoverflow.databinding.FragmentQuestion3Binding


/*
* Question: On Android, how can I access my app settings from the App Info page?
* Source: https://stackoverflow.com/questions/76772921*/

class Question3Fragment : Fragment() {
    private lateinit var binding: FragmentQuestion3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestion3Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSetting.setOnClickListener {
            openSetting()
        }
    }

    private fun openSetting() {
        val intent = Intent()
        val packageName = requireContext().packageName
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        val uri = Uri.fromParts("package", packageName, null)
        intent.data = uri
        requireContext().startActivity(intent)
    }
}