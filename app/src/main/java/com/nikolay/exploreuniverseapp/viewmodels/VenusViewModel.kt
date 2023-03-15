package com.nikolay.exploreuniverseapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VenusViewModel: ViewModel() {
    private val _isNavigateToMercury = MutableLiveData(false)
    val isNavigateToMercury: LiveData<Boolean>
        get() = _isNavigateToMercury

    private val _isNavigateToEarth = MutableLiveData(false)
    val isNavigateToEarth: LiveData<Boolean>
        get() = _isNavigateToEarth

    fun navigateToMercury() { _isNavigateToMercury.value = true }
    fun navigateToEarth() { _isNavigateToEarth.value = true }
}