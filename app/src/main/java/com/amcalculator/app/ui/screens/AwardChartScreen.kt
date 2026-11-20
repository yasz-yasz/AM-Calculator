package com.amcalculator.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amcalculator.app.data.DistanceBand
import com.amcalculator.app.domain.AwardCalculator
import com.amcalculator.app.ui.theme.CathayDeepJade
import com.amcalculator.app.ui.theme.CathayJade

@Composable
fun AwardChartScreen() {
    var showRoundTrip by remember { mutableStateOf(false) }
    val mult = if (showRoundTrip) 2 else 1

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Text(
                text = "Cathay Pacific Asia Miles Standard Award Chart",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Tarif Standard Award berbasis total jarak tempuh (distance-based). Untuk rute multi-leg dalam 1 PNR, total jarak setiap segmen dijumlahkan.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { showRoundTrip = false },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (!showRoundTrip) CathayJade else MaterialTheme.colorScheme.surfaceVariant,
                        contentColor = if (!showRoundTrip) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                ) {
                    Text("Sekali Jalan (1-Way)", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                }
                Button(
                    onClick = { showRoundTrip = true },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (showRoundTrip) CathayJade else MaterialTheme.colorScheme.surfaceVariant,
                        contentColor = if (showRoundTrip) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                ) {
                    Text("Pulang-Pergi (PP)", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        }

        // Award Chart Table Card
        item {
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(CathayDeepJade)
                            .padding(vertical = 10.dp, horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Zona Jarak",
                            modifier = Modifier.weight(1.7f),
                            color = Color.White,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                        TableHeaderCell("Eco", Modifier.weight(1f))
                        TableHeaderCell("P.Eco", Modifier.weight(1f))
                        TableHeaderCell("Biz /\nAria", Modifier.weight(1f))
                        TableHeaderCell("First\nSuite", Modifier.weight(1f))
                    }

                    DistanceBand.entries.forEachIndexed { idx, band ->
                        val bg = if (idx % 2 == 0) MaterialTheme.colorScheme.surface
                        else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f)

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(bg)
                                .padding(vertical = 10.dp, horizontal = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1.7f)) {
                                Text(
                                    text = band.title,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = band.rangeLabel,
                                    fontSize = 10.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            TableDataCell(band.economyMiles * mult, Modifier.weight(1f))
                            TableDataCell(band.premiumEconomyMiles * mult, Modifier.weight(1f))
                            TableDataCell(band.businessMiles * mult, Modifier.weight(1f), highlight = true)
                            TableDataCell(band.firstMiles * mult, Modifier.weight(1f))
                        }
                        if (idx < DistanceBand.entries.lastIndex) {
                            HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.25f))
                        }
                    }
                }
            }
        }

        // Short-Haul Type 1 vs Type 2 Explanation
        item {
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Perbedaan Short-Haul Type 1 vs Type 2",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = CathayJade
                    )
                    Text(
                        text = "• Short-Haul Type 1 (751–2.750 mil): Singapura, Thailand, Malaysia, Vietnam, Kamboja, Filipina (Cebu), Korea Selatan, serta kota-kota Tiongkok Daratan (Beijing, Shanghai, Chengdu, dll).",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "• Short-Haul Type 2 (751–2.750 mil): Rute dari/ke Indonesia (CGK, DPS, SUB), Jepang (HND, NRT, KIX, NGO, FUK, CTS), dan Asia Selatan (India, Nepal, Bangladesh, Sri Lanka).",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }

        // Fleet & Suite Guide
        item {
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Panduan Armada & Kelas Suite Cathay Pacific",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = CathayJade
                    )
                    FleetItem(
                        "Boeing 777-300ER (Aria Suite · 3-Class)",
                        "Kabin Business Class generasi terbaru dengan pintu geser privat (sliding door), layar 4K 24-inci, & wireless charging. Penukaran memakai tarif Business Class Award. Beroperasi di rute LHR, SYD, MEL, FRA, MXP, SFO, YVR, LAX, NRT, PEK, PVG, SIN, TPE."
                    )
                    FleetItem(
                        "Boeing 777-300ER (First Suite · 4-Class)",
                        "Hanya memiliki 6 First Class Suite super luas (konfigurasi 1-1-1). Beroperasi di rute flagship seperti LHR, CDG, LAX, JFK, HND, dan PEK."
                    )
                    FleetItem(
                        "Airbus A350-900 & A350-1000",
                        "Armada long-haul dan regional utama (termasuk rute Jakarta CGK & Denpasar DPS). Konfigurasi 3 kelas: Business (1-2-1 reverse herringbone lie-flat), Premium Economy, & Economy."
                    )
                    FleetItem(
                        "Airbus A330-300 & Boeing 777-300 (Regional)",
                        "Digunakan untuk rute Asia & Indonesia (CGK, DPS, SUB). Tersedia Business (Lie-flat pada varian long-haul atau kursi recliner 2-2-2 pada varian regional) dan Economy (tanpa Premium Economy)."
                    )
                    FleetItem(
                        "Airbus A321neo",
                        "Pesawat narrowbody modern untuk rute jarak pendek/menengah (Tiongkok, Hanoi, Penang, Phuket, Fukuoka, Cebu). Konfigurasi 2 kelas: Regional Business (2-2) & Economy."
                    )
                }
            }
        }
    }
}

@Composable
private fun TableHeaderCell(text: String, modifier: Modifier) {
    Text(
        text = text,
        modifier = modifier,
        color = Color.White,
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.End
    )
}

@Composable
private fun TableDataCell(value: Int, modifier: Modifier, highlight: Boolean = false) {
    Text(
        text = AwardCalculator.formatNumber(value),
        modifier = modifier,
        fontSize = 11.sp,
        fontWeight = if (highlight) FontWeight.ExtraBold else FontWeight.Medium,
        color = if (highlight) CathayJade else MaterialTheme.colorScheme.onSurface,
        textAlign = TextAlign.End
    )
}

@Composable
private fun FleetItem(title: String, desc: String) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Text(text = title, style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
            Text(
                text = desc,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
