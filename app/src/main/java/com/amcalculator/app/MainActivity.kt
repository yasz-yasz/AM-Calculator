package com.amcalculator.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.TableChart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.amcalculator.app.data.CabinClass
import com.amcalculator.app.data.LegInput
import com.amcalculator.app.ui.screens.AwardChartScreen
import com.amcalculator.app.ui.screens.CalculatorScreen
import com.amcalculator.app.ui.screens.RoutesDirectoryScreen
import com.amcalculator.app.ui.theme.AMCalculatorTheme
import com.amcalculator.app.ui.theme.CathayJade

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AMCalculatorTheme {
                AMCalculatorApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AMCalculatorApp() {
    var selectedTab by remember { mutableIntStateOf(0) }
    var legs by remember {
        mutableStateOf(listOf(LegInput(id = 1, origin = "CGK", destination = "HKG", selectedScheduleIndex = 0)))
    }
    var selectedCabin by remember { mutableStateOf(CabinClass.BUSINESS) }
    var isRoundTrip by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "AM Calculator",
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                        Text(
                            text = "Cathay Pacific Asia Miles & Fleet Guide",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White.copy(alpha = 0.85f)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = CathayJade)
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Icon(Icons.Filled.Calculate, contentDescription = "Kalkulator") },
                    label = { Text("Kalkulator") }
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = { Icon(Icons.Filled.Public, contentDescription = "Rute & Jadwal") },
                    label = { Text("Rute & Jadwal") }
                )
                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    icon = { Icon(Icons.Filled.TableChart, contentDescription = "Award Chart") },
                    label = { Text("Award Chart") }
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (selectedTab) {
                0 -> CalculatorScreen(
                    legs = legs,
                    selectedCabin = selectedCabin,
                    isRoundTrip = isRoundTrip,
                    onLegsChange = { legs = it },
                    onCabinChange = { selectedCabin = it },
                    onRoundTripChange = { isRoundTrip = it }
                )
                1 -> RoutesDirectoryScreen(
                    onOpenInCalculator = { origin, dest ->
                        legs = listOf(LegInput(id = 1, origin = origin, destination = dest, selectedScheduleIndex = 0))
                        selectedTab = 0
                    }
                )
                2 -> AwardChartScreen()
            }
        }
    }
}
