package com.explore.stackoverflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.explore.stackoverflow.ui.answer.question76445761.Sample2Fragment
import com.explore.stackoverflow.ui.main.MainFragment
import com.explore.stackoverflow.ui.theme.StackoverflowTheme
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StackoverflowTheme {
        Greeting("Android")
    }
}