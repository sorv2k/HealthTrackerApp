package com.sourav.healthtracker.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface HealthMetricDao {
    @Query("SELECT * FROM health_metrics ORDER BY timestamp DESC")
    fun getAllMetrics(): Flow<List<HealthMetric>>

    @Query("SELECT * FROM health_metrics WHERE date = :date LIMIT 1")
    suspend fun getMetricByDate(date: String): HealthMetric?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMetric(metric: HealthMetric)

    @Update
    suspend fun updateMetric(metric: HealthMetric)

    @Delete
    suspend fun deleteMetric(metric: HealthMetric)
}