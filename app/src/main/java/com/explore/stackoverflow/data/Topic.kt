package com.explore.stackoverflow.data

import androidx.fragment.app.Fragment
import com.explore.stackoverflow.ui.answer.question76433128.SampleFragment
import com.explore.stackoverflow.ui.answer.question76445761.Sample2Fragment
import com.explore.stackoverflow.ui.answer.question76480901.Sample3Fragment

data class Topic(
    val id: Int,
    val fragment: Fragment,
    val title: String
) {
    companion object {
        val topicList = listOf(
            Topic(
                1,
                SampleFragment(),
                "How to change the text of customize button in a menu file with dataBinding?"
            ),
            Topic(
                2,
                Sample2Fragment(),
                "Android two way databinding with Double and optional radix point causing some trouble"
            ),
            Topic(
                3,
                Sample3Fragment(),
                "Facing issue While making dynamic views using Relative layout"
            )
        )
    }
}
