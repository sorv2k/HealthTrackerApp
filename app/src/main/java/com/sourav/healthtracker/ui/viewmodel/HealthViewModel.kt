package com.sourav.healthtracker.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sourav.healthtracker.data.local.HealthMetric
import com.sourav.healthtracker.data.repository.HealthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HealthViewModel(private val repository: HealthRepository) : ViewModel() {

    private val _todayMetric = MutableStateFlow<HealthMetric?>(null)
    val todayMetric: StateFlow<HealthMetric?> = _todayMetric.asStateFlow()

    init {
        loadTodayMetric()
    }

    private fun loadTodayMetric() {
        viewModelScope.launch {
            _todayMetric.value = repository.getTodayMetric()
        }
    }

    fun updateSteps(steps: Int) {
        viewModelScope.launch {
            repository.updateSteps(steps)
            loadTodayMetric()
        }
    }

    fun updateWaterIntake(liters: Float) {
        viewModelScope.launch {
            repository.updateWaterIntake(liters)
            loadTodayMetric()
        }
    }

    fun updateSleepHours(hours: Float) {
        viewModelScope.launch {
            repository.updateSleepHours(hours)
            loadTodayMetric()
        }
    }
}

class HealthViewModelFactory(
    private val repository: HealthRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HealthViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HealthViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}