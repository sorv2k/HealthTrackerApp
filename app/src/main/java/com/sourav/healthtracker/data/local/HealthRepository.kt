package com.sourav.healthtracker.data.repository

import com.sourav.healthtracker.data.local.HealthMetric
import com.sourav.healthtracker.data.local.HealthMetricDao
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.*

class HealthRepository(private val dao: HealthMetricDao) {

    fun getAllMetrics(): Flow<List<HealthMetric>> = dao.getAllMetrics()

    suspend fun getTodayMetric(): HealthMetric {
        val today = getTodayDate()
        return dao.getMetricByDate(today) ?: HealthMetric(
            date = today,
            steps = 0,
            waterIntake = 0f,
            sleepHours = 0f
        ).also { dao.insertMetric(it) }
    }

    suspend fun updateSteps(steps: Int) {
        val metric = getTodayMetric()
        dao.updateMetric(metric.copy(steps = steps))
    }

    suspend fun updateWaterIntake(liters: Float) {
        val metric = getTodayMetric()
        dao.updateMetric(metric.copy(waterIntake = liters))
    }

    suspend fun updateSleepHours(hours: Float) {
        val metric = getTodayMetric()
        dao.updateMetric(metric.copy(sleepHours = hours))
    }

    private fun getTodayDate(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.format(Date())
    }
}