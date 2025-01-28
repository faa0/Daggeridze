package com.fara.daggeridze.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.fara.daggeridze.R
import com.fara.daggeridze.data.repository.TestRepository
import com.fara.daggeridze.ui.test.TestViewModel
import com.fara.daggeridze.ui.test.ViewModelFactory
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var testRepository: TestRepository

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initContentView()
        val viewModel = ViewModelProvider(this, viewModelFactory)[TestViewModel::class.java]
        val textView = findViewById<TextView>(R.id.tvMain)
        textView.text = testRepository.getTestString()

        lifecycleScope.launch {
            viewModel.testString.collectLatest {
                delay(2000)
                textView.text = it
            }
        }
    }

    private fun initContentView() {
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}