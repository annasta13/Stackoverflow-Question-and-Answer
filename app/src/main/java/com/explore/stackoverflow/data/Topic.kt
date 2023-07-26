package com.explore.stackoverflow.data

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.explore.stackoverflow.ui.answer.question1.Question1Fragment
import com.explore.stackoverflow.ui.answer.question2.Question2Fragment
import com.explore.stackoverflow.ui.answer.question3.Question3Fragment

data class Topic(
    val id: Int,
    val fragment: Fragment? = null,
    val activity: Class<out AppCompatActivity>? = null,
    val title: String,
    val url: String
) {
    companion object {
        val topicList = listOf(
            Topic(
                id = 1,
                fragment = Question1Fragment(),
                title = "How to change the text of customize button in a menu file with dataBinding?",
                url = "https://stackoverflow.com/a/76433606/12445365"
            ),
            Topic(
                id = 2,
                fragment = Question2Fragment(),
                title = "Android two way databinding with Double and optional radix point causing some trouble",
                url = "https://stackoverflow.com/questions/76445761"
            ),
            Topic(
                id = 3,
                fragment = Question3Fragment(),
                title = "On Android, how can I access my app settings from the App Info page?",
                url = "https://stackoverflow.com/questions/76772921"
            )
        )
    }
}
