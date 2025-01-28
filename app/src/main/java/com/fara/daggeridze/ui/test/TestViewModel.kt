package com.fara.daggeridze.ui.test

import androidx.lifecycle.ViewModel
import com.fara.daggeridze.data.repository.TestRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TestViewModel @Inject constructor(
    private val testRepository: TestRepository,
) : ViewModel() {

    private val _testString = MutableStateFlow("")
    val testString: StateFlow<String> = _testString

    init {
        _testString.value = "God blessed"
    }
}