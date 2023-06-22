package com.explore.stackoverflow.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.explore.stackoverflow.R
import com.explore.stackoverflow.data.Topic
import com.explore.stackoverflow.databinding.FragmentMainBinding

class MainFragment : Fragment(), MainAdapter.OnItemClick {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.topicList.adapter = MainAdapter(Topic.topicList, this)
    }

    override fun onClick(item: Topic) {
        val ft = requireActivity().supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, item.fragment)
            .addToBackStack(null)
            .commit()
    }
}