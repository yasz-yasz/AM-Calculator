package com.amcalculator.app.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AirplanemodeActive
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CompareArrows
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.FlightLand
import androidx.compose.material.icons.filled.FlightTakeoff
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amcalculator.app.data.Airport
import com.amcalculator.app.data.CabinClass
import com.amcalculator.app.data.CalculationResult
import com.amcalculator.app.data.CathayDataRepository
import com.amcalculator.app.data.FlightSchedule
import com.amcalculator.app.data.LegInput
import com.amcalculator.app.domain.AwardCalculator
import com.amcalculator.app.ui.components.AirportPickerDialog
import com.amcalculator.app.ui.theme.CathayDarkJade
import com.amcalculator.app.ui.theme.CathayDeepJade
import com.amcalculator.app.ui.theme.CathayGold
import com.amcalculator.app.ui.theme.CathayGoldSoft
import com.amcalculator.app.ui.theme.CathayJade
import com.amcalculator.app.ui.theme.SuccessGreen
import com.amcalculator.app.ui.theme.SuccessGreenBg
import com.amcalculator.app.ui.theme.WarningAmber
import com.amcalculator.app.ui.theme.WarningAmberBg

private data class PickerTarget(
    val legIndex: Int,
    val isOrigin: Boolean
)

@Composable
fun CalculatorScreen(
    legs: List<LegInput>,
    selectedCabin: CabinClass,
    isRoundTrip: Boolean,
    onLegsChange: (List<LegInput>) -> Unit,
    onCabinChange: (CabinClass) -> Unit,
    onRoundTripChange: (Boolean) -> Unit
) {
    var pickerTarget by remember { mutableStateOf<PickerTarget?>(null) }
    var showSmartTransitDialog by remember { mutableStateOf(false) }

    val result = remember(legs, selectedCabin, isRoundTrip) {
        AwardCalculator.calculate(legs, selectedCabin, isRoundTrip)
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Quick Presets + Smart Transit Row
        item {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Preset Cepat & Transit",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )
                    TextButton(onClick = { showSmartTransitDialog = true }) {
                        Icon(
                            Icons.Filled.CompareArrows,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Auto-Transit HKG", fontWeight = FontWeight.SemiBold)
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    AssistChip(
                        onClick = { onLegsChange(listOf(LegInput(1, "CGK", "HKG"))) },
                        label = { Text("CGK → HKG") }
                    )
                    AssistChip(
                        onClick = {
                            onLegsChange(
                                listOf(
                                    LegInput(1, "CGK", "HKG"),
                                    LegInput(2, "HKG", "NRT")
                                )
                            )
                        },
                        label = { Text("CGK → HKG → NRT") }
                    )
                    AssistChip(
                        onClick = {
                            onLegsChange(
                                listOf(
                                    LegInput(1, "CGK", "HKG"),
                                    LegInput(2, "HKG", "LHR")
                                )
                            )
                        },
                        label = { Text("CGK → HKG → LHR") }
                    )
                    AssistChip(
                        onClick = { onLegsChange(listOf(LegInput(1, "HKG", "JFK"))) },
                        label = { Text("HKG → JFK (First)") }
                    )
                    AssistChip(
                        onClick = { onLegsChange(listOf(LegInput(1, "TPE", "NRT"))) },
                        label = { Text("TPE → NRT (5th Freedom)") }
                    )
                }
            }
        }

        // Trip Type & Cabin Selector Card
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // One-way / Round-trip segmented buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        val owSelected = !isRoundTrip
                        Button(
                            onClick = { onRoundTripChange(false) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (owSelected) CathayJade else MaterialTheme.colorScheme.surfaceVariant,
                                contentColor = if (owSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        ) {
                            Text("Sekali Jalan (1-Way)", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                        }
                        Button(
                            onClick = { onRoundTripChange(true) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (!owSelected) CathayJade else MaterialTheme.colorScheme.surfaceVariant,
                                contentColor = if (!owSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        ) {
                            Text("Pulang-Pergi (PP)", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                        }
                    }

                    // Cabin Class Selector (5 classes: Economy, Prem Eco, Business, First, Suite)
                    Text(
                        text = "Pilih Kelas Kabin",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        CabinClass.entries.forEach { cabin ->
                            val isSelected = cabin == selectedCabin
                            FilterChip(
                                selected = isSelected,
                                onClick = { onCabinChange(cabin) },
                                label = {
                                    Text(
                                        text = cabin.shortName,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                    )
                                },
                                leadingIcon = if (cabin == CabinClass.FIRST || cabin == CabinClass.SUITE) {
                                    {
                                        Icon(
                                            Icons.Filled.Star,
                                            contentDescription = null,
                                            modifier = Modifier.size(16.dp),
                                            tint = if (isSelected) CathayGold else MaterialTheme.colorScheme.secondary
                                        )
                                    }
                                } else null,
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = CathayJade,
                                    selectedLabelColor = Color.White
                                )
                            )
                        }
                    }
                    Text(
                        text = selectedCabin.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // Leg Input Cards
        itemsIndexed(legs, key = { _, item -> item.id }) { index, leg ->
            LegEditorCard(
                legNumber = index + 1,
                leg = leg,
                selectedCabin = selectedCabin,
                canDelete = legs.size > 1,
                onPickOrigin = { pickerTarget = PickerTarget(index, true) },
                onPickDestination = { pickerTarget = PickerTarget(index, false) },
                onSwap = {
                    val updated = legs.toMutableList()
                    updated[index] = leg.copy(
                        origin = leg.destination,
                        destination = leg.origin,
                        selectedScheduleIndex = 0
                    )
                    onLegsChange(updated)
                },
                onSelectSchedule = { schedIdx ->
                    val updated = legs.toMutableList()
                    updated[index] = leg.copy(selectedScheduleIndex = schedIdx)
                    onLegsChange(updated)
                },
                onDelete = {
                    val updated = legs.toMutableList()
                    updated.removeAt(index)
                    onLegsChange(updated)
                }
            )
        }

        // Add Leg Button (up to 4 legs)
        if (legs.size < 4) {
            item {
                OutlinedButton(
                    onClick = {
                        val lastDest = legs.lastOrNull()?.destination ?: "HKG"
                        val reachable = CathayDataRepository.getReachableDestinations(lastDest)
                        val defaultNext = reachable.firstOrNull { it.code != legs.lastOrNull()?.origin }?.code
                            ?: if (lastDest == "HKG") "NRT" else "HKG"
                        val nextId = (legs.maxOfOrNull { it.id } ?: 0) + 1
                        onLegsChange(legs + LegInput(nextId, lastDest, defaultNext, 0))
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.dp, CathayJade)
                ) {
                    Icon(Icons.Filled.Add, contentDescription = null)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Tambah Leg Penerbangan (Multi-Leg)",
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        // Result Card
        if (result != null) {
            item {
                ResultSummaryCard(result = result)
            }
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }
    }

    // Airport Picker Dialog for Leg Origin/Destination
    pickerTarget?.let { target ->
        val currentLeg = legs.getOrNull(target.legIndex)
        if (currentLeg != null) {
            val airportOptions: List<Airport> = if (target.isOrigin) {
                CathayDataRepository.airports.sortedBy { it.code }
            } else {
                val reachable = CathayDataRepository.getReachableDestinations(currentLeg.origin)
                if (reachable.isNotEmpty()) reachable else CathayDataRepository.airports.sortedBy { it.code }
            }

            AirportPickerDialog(
                title = if (target.isOrigin) "Pilih Bandara Asal (Leg ${target.legIndex + 1})"
                else "Pilih Tujuan Langsung dari ${currentLeg.origin}",
                airports = airportOptions,
                onSelect = { chosen ->
                    val updated = legs.toMutableList()
                    if (target.isOrigin) {
                        val newOrigin = chosen.code
                        val validDests = CathayDataRepository.getReachableDestinations(newOrigin)
                        val keepDest = validDests.any { it.code == currentLeg.destination }
                        val newDest = if (keepDest) currentLeg.destination
                        else validDests.firstOrNull()?.code ?: "HKG"
                        updated[target.legIndex] = currentLeg.copy(
                            origin = newOrigin,
                            destination = newDest,
                            selectedScheduleIndex = 0
                        )
                    } else {
                        updated[target.legIndex] = currentLeg.copy(
                            destination = chosen.code,
                            selectedScheduleIndex = 0
                        )
                    }
                    onLegsChange(updated)
                    pickerTarget = null
                },
                onDismiss = { pickerTarget = null }
            )
        }
    }

    if (showSmartTransitDialog) {
        SmartTransitDialog(
            onBuild = { builtLegs ->
                if (builtLegs.isNotEmpty()) {
                    onLegsChange(builtLegs)
                }
                showSmartTransitDialog = false
            },
            onDismiss = { showSmartTransitDialog = false }
        )
    }
}

@Composable
private fun LegEditorCard(
    legNumber: Int,
    leg: LegInput,
    selectedCabin: CabinClass,
    canDelete: Boolean,
    onPickOrigin: () -> Unit,
    onPickDestination: () -> Unit,
    onSwap: () -> Unit,
    onSelectSchedule: (Int) -> Unit,
    onDelete: () -> Unit
) {
    val route = CathayDataRepository.findRoute(leg.origin, leg.destination)
    val schedules = CathayDataRepository.getSchedules(leg.origin, leg.destination)
    val originAirport = CathayDataRepository.getAirport(leg.origin)
    val destAirport = CathayDataRepository.getAirport(leg.destination)

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        color = CathayJade,
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            text = "LEG $legNumber",
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                            color = Color.White,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    if (route != null) {
                        Text(
                            text = "${AwardCalculator.formatNumber(route.distanceMiles)} mil" +
                                if (route.isFifthFreedom) " · Fifth Freedom" else "",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                if (canDelete) {
                    IconButton(onClick = onDelete, modifier = Modifier.size(32.dp)) {
                        Icon(
                            Icons.Filled.Delete,
                            contentDescription = "Hapus Leg",
                            tint = MaterialTheme.colorScheme.error
                        )
                    }
                }
            }

            // Origin <-> Destination selector
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                AirportBox(
                    label = "Asal",
                    code = leg.origin,
                    city = originAirport?.city ?: "-",
                    icon = Icons.Filled.FlightTakeoff,
                    modifier = Modifier.weight(1f),
                    onClick = onPickOrigin
                )
                IconButton(onClick = onSwap) {
                    Icon(
                        Icons.Filled.SwapHoriz,
                        contentDescription = "Tukar",
                        tint = CathayJade
                    )
                }
                AirportBox(
                    label = "Tujuan",
                    code = leg.destination,
                    city = destAirport?.city ?: "-",
                    icon = Icons.Filled.FlightLand,
                    modifier = Modifier.weight(1f),
                    onClick = onPickDestination
                )
            }

            // Flight schedules selector
            if (schedules.isNotEmpty()) {
                Text(
                    text = "Pilih Jadwal & Armada (${schedules.size} opsi)",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    schedules.forEachIndexed { idx, sched ->
                        ScheduleChipCard(
                            schedule = sched,
                            isSelected = idx == leg.selectedScheduleIndex,
                            cabinAvailable = sched.supportsCabin(selectedCabin),
                            onClick = { onSelectSchedule(idx) }
                        )
                    }
                }
            } else {
                Surface(
                    color = WarningAmberBg,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Filled.Warning,
                            contentDescription = null,
                            tint = WarningAmber,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Tidak ada rute langsung ${leg.origin} → ${leg.destination}. Gunakan tombol Auto-Transit HKG di atas.",
                            style = MaterialTheme.typography.bodySmall,
                            color = WarningAmber
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun AirportBox(
    label: String,
    code: String,
    city: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.65f),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f))
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                    tint = CathayJade
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Text(
                text = code,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = city,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1
            )
        }
    }
}

@Composable
private fun ScheduleChipCard(
    schedule: FlightSchedule,
    isSelected: Boolean,
    cabinAvailable: Boolean,
    onClick: () -> Unit
) {
    val borderColor = if (isSelected) CathayJade else MaterialTheme.colorScheme.outline.copy(alpha = 0.45f)
    val bgColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.65f)
    else MaterialTheme.colorScheme.surface

    Surface(
        modifier = Modifier
            .width(220.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        color = bgColor,
        border = BorderStroke(if (isSelected) 2.dp else 1.dp, borderColor)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = schedule.flightNumber,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = CathayJade
                )
                Text(
                    text = schedule.duration,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Filled.Schedule,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${schedule.departureTime} → ${schedule.arrivalTime}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Filled.AirplanemodeActive,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                    tint = MaterialTheme.colorScheme.secondary
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = schedule.aircraft,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1
                )
            }
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                if (schedule.hasAriaSuite) {
                    SmallTag("ARIA SUITE", CathayGoldSoft, Color(0xFF6B4F1D))
                }
                if (schedule.hasFirstClass) {
                    SmallTag("FIRST SUITE", Color(0xFFEDE9FE), Color(0xFF5B21B6))
                }
                if (!cabinAvailable) {
                    SmallTag("Kabin N/A", WarningAmberBg, WarningAmber)
                }
            }
        }
    }
}

@Composable
private fun SmallTag(text: String, bg: Color, fg: Color) {
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
private fun ResultSummaryCard(result: CalculationResult) {
    val tripLabel = if (result.isRoundTrip) "Pulang-Pergi (PP)" else "Sekali Jalan (One-Way)"

    Card(
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            // Top Gradient Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.linearGradient(listOf(CathayDeepJade, CathayJade, CathayDarkJade))
                    )
                    .padding(18.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "ESTIMASI ASIA MILES (${result.cabin.displayName.uppercase()})",
                            color = CathayGold,
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Surface(
                            color = Color.White.copy(alpha = 0.15f),
                            shape = RoundedCornerShape(6.dp)
                        ) {
                            Text(
                                text = tripLabel,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                                color = Color.White,
                                style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }

                    Text(
                        text = "${AwardCalculator.formatNumber(result.combinedMilesTotal)} Miles",
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Text(
                        text = "1 PNR (Jarak Gabungan ${AwardCalculator.formatNumber(result.totalDistanceMiles)} mil · ${result.combinedBand.title})",
                        color = Color.White.copy(alpha = 0.9f),
                        style = MaterialTheme.typography.bodySmall
                    )

                    if (result.legBreakdowns.size > 1) {
                        Spacer(modifier = Modifier.height(6.dp))
                        Surface(
                            color = Color.White.copy(alpha = 0.14f),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(
                                        text = "Jika Pesan PNR Terpisah (Per-Leg):",
                                        color = Color.White.copy(alpha = 0.85f),
                                        style = MaterialTheme.typography.labelSmall
                                    )
                                    Text(
                                        text = "${AwardCalculator.formatNumber(result.separateMilesTotal)} Miles",
                                        color = Color.White,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                if (result.savingsWithOnePnr > 0) {
                                    Surface(
                                        color = SuccessGreenBg,
                                        shape = RoundedCornerShape(8.dp)
                                    ) {
                                        Text(
                                            text = "Hemat ${AwardCalculator.formatNumber(result.savingsWithOnePnr)}",
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                            color = SuccessGreen,
                                            style = MaterialTheme.typography.labelSmall,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Detailed Flight Breakdown
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Rincian Penerbangan & Armada",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )

                result.legBreakdowns.forEach { leg ->
                    Surface(
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Leg ${leg.legNumber}: ${leg.origin} → ${leg.destination}",
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "${AwardCalculator.formatNumber(leg.separateMilesOneWay)} mi (1-way)",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = CathayJade,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            leg.schedule?.let { s ->
                                Text(
                                    text = "${s.flightNumber} · Berangkat ${s.departureTime} → Tiba ${s.arrivalTime} (${s.duration})",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "Pesawat: ${s.aircraft} · Jarak: ${AwardCalculator.formatNumber(leg.distanceMiles)} mil (${leg.band.title})",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = if (leg.cabinAvailable) Icons.Filled.CheckCircle else Icons.Filled.Warning,
                                    contentDescription = null,
                                    modifier = Modifier.size(14.dp),
                                    tint = if (leg.cabinAvailable) SuccessGreen else WarningAmber
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = if (leg.cabinAvailable) "Kabin ${result.cabin.displayName} tersedia di pesawat ini"
                                    else "Kabin ${result.cabin.displayName} tidak tersedia di nomor penerbangan ini",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = if (leg.cabinAvailable) SuccessGreen else WarningAmber
                                )
                            }
                        }
                    }
                }

                // Warnings & Notes
                if (result.warnings.isNotEmpty()) {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
                    result.warnings.forEach { warn ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.Top
                        ) {
                            Icon(
                                Icons.Filled.Info,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(16.dp)
                                    .padding(top = 2.dp),
                                tint = CathayJade
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = warn,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SmartTransitDialog(
    onBuild: (List<LegInput>) -> Unit,
    onDismiss: () -> Unit
) {
    var origin by remember { mutableStateOf("CGK") }
    var destination by remember { mutableStateOf("LHR") }
    var pickingOrigin by remember { mutableStateOf<Boolean?>(null) }

    val previewLegs = remember(origin, destination) {
        CathayDataRepository.buildSmartLegs(origin, destination)
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Auto-Transit via Hub HKG", fontWeight = FontWeight.Bold) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    text = "Pilih kota asal dan tujuan akhir mana saja di jaringan Cathay Pacific. Aplikasi akan otomatis menyusun rute langsung atau transit via Hong Kong (HKG).",
                    style = MaterialTheme.typography.bodySmall
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    AirportBox(
                        label = "Asal",
                        code = origin,
                        city = CathayDataRepository.getAirport(origin)?.city ?: "-",
                        icon = Icons.Filled.FlightTakeoff,
                        modifier = Modifier.weight(1f),
                        onClick = { pickingOrigin = true }
                    )
                    AirportBox(
                        label = "Tujuan Akhir",
                        code = destination,
                        city = CathayDataRepository.getAirport(destination)?.city ?: "-",
                        icon = Icons.Filled.FlightLand,
                        modifier = Modifier.weight(1f),
                        onClick = { pickingOrigin = false }
                    )
                }
                if (previewLegs.isNotEmpty()) {
                    val routeStr = previewLegs.joinToString(" → ") { it.origin } + " → ${previewLegs.last().destination}"
                    Surface(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Rute terbentuk (${previewLegs.size} Leg): $routeStr",
                            modifier = Modifier.padding(10.dp),
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                } else {
                    Text(
                        text = "Pilih bandara asal dan tujuan yang berbeda.",
                        style = MaterialTheme.typography.bodySmall,
                        color = WarningAmber
                    )
                }
            }
        },
        confirmButton = {
            Button(
                onClick = { onBuild(previewLegs) },
                enabled = previewLegs.isNotEmpty(),
                colors = ButtonDefaults.buttonColors(containerColor = CathayJade)
            ) {
                Text("Terapkan Rute")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Batal") }
        }
    )

    pickingOrigin?.let { isOrig ->
        AirportPickerDialog(
            title = if (isOrig) "Pilih Bandara Asal" else "Pilih Bandara Tujuan Akhir",
            airports = CathayDataRepository.airports.sortedBy { it.code },
            onSelect = { airport ->
                if (isOrig) origin = airport.code else destination = airport.code
                pickingOrigin = null
            },
            onDismiss = { pickingOrigin = null }
        )
    }
}
