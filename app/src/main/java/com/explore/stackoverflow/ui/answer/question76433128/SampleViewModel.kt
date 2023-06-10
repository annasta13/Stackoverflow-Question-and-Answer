package com.explore.stackoverflow.ui.answer.question76433128

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class SampleViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow("default")
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000)
            _state.update { "changing" }
            Timber.d("check state ${state.value}")
        }
    }
}