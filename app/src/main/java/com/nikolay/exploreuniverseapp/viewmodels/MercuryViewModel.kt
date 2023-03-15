package com.nikolay.exploreuniverseapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MercuryViewModel: ViewModel() {
    private val _isNavigateToVenus = MutableLiveData(false)
    val isNavigateToVenus: LiveData<Boolean>
        get() = _isNavigateToVenus

    private val _isNavigateToEarth = MutableLiveData(false)
    val isNavigateToEarth: LiveData<Boolean>
        get() = _isNavigateToEarth

    fun navigateToVenus() { _isNavigateToVenus.value = true }
    fun navigateToEarth() { _isNavigateToEarth.value = true }

}