package com.sourav.healthtracker.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "health_metrics")
data class HealthMetric(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: String,
    val steps: Int = 0,
    val waterIntake: Float = 0f,
    val sleepHours: Float = 0f,
    val timestamp: Long = System.currentTimeMillis()
)