package com.explore.stackoverflow.ui.answer.question2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Question2ViewModel @Inject constructor(): ViewModel() {

    val radiusValue = MutableLiveData(0.0)
}