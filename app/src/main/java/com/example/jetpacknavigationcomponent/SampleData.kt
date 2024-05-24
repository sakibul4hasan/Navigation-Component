package com.example.jetpacknavigationcomponent

import androidx.lifecycle.MutableLiveData

class SampleData {
    companion object {
        @JvmStatic
        var defaultAmount = MutableLiveData<Long>(500L)
    }
}