package com.explore.stackoverflow.ui.answer.question76445761

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Sample2FragmentViewModel @Inject constructor(): ViewModel() {

    val radiusValue = MutableLiveData(0.0)
}