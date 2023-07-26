package com.explore.stackoverflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.explore.stackoverflow.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container)

        val ft = this.supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, MainFragment()).commit()
    }
}