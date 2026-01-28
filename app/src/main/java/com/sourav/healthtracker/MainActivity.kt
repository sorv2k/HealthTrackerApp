package com.sourav.healthtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.sourav.healthtracker.data.local.HealthDatabase
import com.sourav.healthtracker.data.repository.HealthRepository
import com.sourav.healthtracker.ui.navigation.NavGraph
import com.sourav.healthtracker.ui.theme.HealthTrackerAppTheme
import com.sourav.healthtracker.ui.viewmodel.HealthViewModel
import com.sourav.healthtracker.ui.viewmodel.HealthViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = HealthDatabase.getDatabase(applicationContext)
        val repository = HealthRepository(database.healthMetricDao())
        val viewModelFactory = HealthViewModelFactory(repository)

        setContent {
            HealthTrackerAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val viewModel: HealthViewModel = viewModel(factory = viewModelFactory)

                    NavGraph(
                        navController = navController,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}