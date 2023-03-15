package com.nikolay.exploreuniverseapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EarthViewModel: ViewModel() {
    private val _isNavigateToMercury = MutableLiveData(false)
    val isNavigateToMercury: LiveData<Boolean>
        get() = _isNavigateToMercury

    private val _isNavigateToVenus = MutableLiveData(false)
    val isNavigateToVenus: LiveData<Boolean>
        get() = _isNavigateToVenus

    fun navigateToMercury() { _isNavigateToMercury.value = true }
    fun navigateToVenus() { _isNavigateToVenus.value = true }

}