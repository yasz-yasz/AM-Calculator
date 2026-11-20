package com.amcalculator.app.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AirplanemodeActive
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amcalculator.app.data.CathayDataRepository
import com.amcalculator.app.data.FlightSchedule
import com.amcalculator.app.data.Region
import com.amcalculator.app.data.RouteInfo
import com.amcalculator.app.domain.AwardCalculator
import com.amcalculator.app.ui.theme.CathayGoldSoft
import com.amcalculator.app.ui.theme.CathayJade

@Composable
fun RoutesDirectoryScreen(
    onOpenInCalculator: (origin: String, destination: String) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedRegion by remember { mutableStateOf(Region.ALL) }
    var expandedRouteKey by remember { mutableStateOf<String?>(null) }

    val filteredRoutes = remember(searchQuery, selectedRegion) {
        val q = searchQuery.trim().lowercase()
        CathayDataRepository.routes.filter { route ->
            val regionMatch = selectedRegion == Region.ALL || route.region == selectedRegion
            if (!regionMatch) return@filter false
            if (q.isEmpty()) return@filter true

            val origAirport = CathayDataRepository.getAirport(route.origin)
            val destAirport = CathayDataRepository.getAirport(route.destination)
            val allScheds = route.outboundSchedules + route.inboundSchedules

            route.origin.lowercase().contains(q) ||
                route.destination.lowercase().contains(q) ||
                (origAirport?.city?.lowercase()?.contains(q) == true) ||
                (destAirport?.city?.lowercase()?.contains(q) == true) ||
                (destAirport?.country?.lowercase()?.contains(q) == true) ||
                allScheds.any {
                    it.flightNumber.lowercase().contains(q) ||
                        it.aircraft.lowercase().contains(q) ||
                        (q.contains("aria") && it.hasAriaSuite) ||
                        (q.contains("first") && it.hasFirstClass) ||
                        (q.contains("suite") && (it.hasAriaSuite || it.hasFirstClass))
                }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            placeholder = { Text("Cari rute, kota, pesawat (A350, Aria, First, CX776)") },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { searchQuery = "" }) {
                        Icon(Icons.Filled.Close, contentDescription = "Hapus")
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(14.dp)
        )

        // Region Filter Chips
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Region.entries.forEach { reg ->
                FilterChip(
                    selected = reg == selectedRegion,
                    onClick = { selectedRegion = reg },
                    label = { Text(reg.label, fontSize = 12.sp) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = CathayJade,
                        selectedLabelColor = Color.White
                    )
                )
            }
        }

        Text(
            text = "Menampilkan ${filteredRoutes.size} rute Cathay Pacific (${filteredRoutes.size * 2} arah penerbangan)",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(filteredRoutes, key = { "${it.origin}-${it.destination}" }) { route ->
                val routeKey = "${route.origin}-${route.destination}"
                RouteDirectoryCard(
                    route = route,
                    isExpanded = expandedRouteKey == routeKey,
                    onToggleExpand = {
                        expandedRouteKey = if (expandedRouteKey == routeKey) null else routeKey
                    },
                    onCalculateClick = { onOpenInCalculator(route.destination, route.origin) }
                )
            }
        }
    }
}

@Composable
private fun RouteDirectoryCard(
    route: RouteInfo,
    isExpanded: Boolean,
    onToggleExpand: () -> Unit,
    onCalculateClick: () -> Unit
) {
    val origAirport = CathayDataRepository.getAirport(route.origin)
    val destAirport = CathayDataRepository.getAirport(route.destination)
    val isType2 = (origAirport?.isShortHaulType2Market == true) || (destAirport?.isShortHaulType2Market == true)
    val band = AwardCalculator.determineBand(route.distanceMiles, isType2)

    val allScheds = route.outboundSchedules + route.inboundSchedules
    val hasAria = allScheds.any { it.hasAriaSuite }
    val hasFirst = allScheds.any { it.hasFirstClass }

    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onToggleExpand)
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "${route.origin} ⇄ ${route.destination}",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = CathayJade
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        if (hasAria) {
                            BadgePill("ARIA SUITE", CathayGoldSoft, Color(0xFF6B4F1D))
                            Spacer(modifier = Modifier.width(4.dp))
                        }
                        if (hasFirst) {
                            BadgePill("FIRST", Color(0xFFEDE9FE), Color(0xFF5B21B6))
                        }
                        if (route.isFifthFreedom) {
                            BadgePill("5TH FREEDOM", MaterialTheme.colorScheme.primaryContainer, MaterialTheme.colorScheme.onPrimaryContainer)
                        }
                    }
                    Text(
                        text = "${origAirport?.city ?: route.origin} ⇄ ${destAirport?.city ?: route.destination} · ${AwardCalculator.formatNumber(route.distanceMiles)} mil (${band.title})",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Icon(
                    imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Quick 1-way Asia Miles strip
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MiniMilesCol("Eco", band.economyMiles)
                MiniMilesCol("Prem.Eco", band.premiumEconomyMiles)
                MiniMilesCol("Business", band.businessMiles)
                MiniMilesCol("Aria Suite", band.businessMiles)
                MiniMilesCol("First", band.firstMiles)
            }

            if (isExpanded) {
                HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))

                Text(
                    text = "Jadwal ${route.origin} → ${route.destination}",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
                route.outboundSchedules.forEach { sched ->
                    ScheduleLine(sched)
                }

                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Jadwal ${route.destination} → ${route.origin}",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
                route.inboundSchedules.forEach { sched ->
                    ScheduleLine(sched)
                }

                Spacer(modifier = Modifier.height(4.dp))
                Button(
                    onClick = onCalculateClick,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = CathayJade)
                ) {
                    Icon(Icons.Filled.Calculate, contentDescription = null, modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Hitung Rute Ini di Kalkulator", fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}

@Composable
private fun BadgePill(text: String, bg: Color, fg: Color) {
    Surface(color = bg, shape = RoundedCornerShape(4.dp)) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp),
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = fg
        )
    }
}

@Composable
private fun MiniMilesCol(label: String, miles: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = label,
            fontSize = 10.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = "${miles / 1000}k",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
private fun ScheduleLine(sched: FlightSchedule) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = sched.flightNumber,
                        fontWeight = FontWeight.ExtraBold,
                        color = CathayJade,
                        style = MaterialTheme.typography.labelMedium
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(Icons.Filled.Schedule, contentDescription = null, modifier = Modifier.size(13.dp))
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                        text = "${sched.departureTime} → ${sched.arrivalTime}",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = sched.duration,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Filled.AirplanemodeActive,
                    contentDescription = null,
                    modifier = Modifier.size(13.dp),
                    tint = MaterialTheme.colorScheme.secondary
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = sched.aircraft + if (sched.note.isNotEmpty()) " · ${sched.note}" else "",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
