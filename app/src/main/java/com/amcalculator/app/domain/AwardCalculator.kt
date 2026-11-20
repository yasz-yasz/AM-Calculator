package com.amcalculator.app.domain

import com.amcalculator.app.data.CabinClass
import com.amcalculator.app.data.CathayDataRepository
import com.amcalculator.app.data.CalculationResult
import com.amcalculator.app.data.DistanceBand
import com.amcalculator.app.data.LegBreakdown
import com.amcalculator.app.data.LegInput

object AwardCalculator {

    fun determineBand(distanceMiles: Int, touchesType2Market: Boolean): DistanceBand {
        return when {
            distanceMiles <= 750 -> DistanceBand.ULTRA_SHORT
            distanceMiles <= 2750 -> if (touchesType2Market) DistanceBand.SHORT_TYPE_2 else DistanceBand.SHORT_TYPE_1
            distanceMiles <= 5000 -> DistanceBand.MEDIUM
            distanceMiles <= 7500 -> DistanceBand.LONG
            else -> DistanceBand.ULTRA_LONG
        }
    }

    fun calculate(
        legs: List<LegInput>,
        cabin: CabinClass,
        isRoundTrip: Boolean
    ): CalculationResult? {
        if (legs.isEmpty()) return null

        val breakdowns = mutableListOf<LegBreakdown>()
        val warnings = mutableListOf<String>()
        var totalDistance = 0
        var touchesType2 = false
        var separateOneWaySum = 0

        legs.forEachIndexed { idx, leg ->
            val route = CathayDataRepository.findRoute(leg.origin, leg.destination)
            if (route == null) {
                warnings.add("Leg ${idx + 1} (${leg.origin} → ${leg.destination}): Tidak ada penerbangan langsung Cathay Pacific. Coba transit via HKG atau TPE.")
                return@forEachIndexed
            }

            val schedules = CathayDataRepository.getSchedules(leg.origin, leg.destination)
            val chosenSchedule = schedules.getOrNull(leg.selectedScheduleIndex) ?: schedules.firstOrNull()

            val originAirport = CathayDataRepository.getAirport(leg.origin)
            val destAirport = CathayDataRepository.getAirport(leg.destination)
            val legTouchesType2 = (originAirport?.isShortHaulType2Market == true) ||
                (destAirport?.isShortHaulType2Market == true)

            if (legTouchesType2) touchesType2 = true

            val legBand = determineBand(route.distanceMiles, legTouchesType2)
            val legMiles = legBand.milesForCabin(cabin)
            separateOneWaySum += legMiles
            totalDistance += route.distanceMiles

            val available = chosenSchedule?.supportsCabin(cabin) ?: true
            val legWarning = if (!available && chosenSchedule != null) {
                when (cabin) {
                    CabinClass.FIRST -> "Penerbangan ${chosenSchedule.flightNumber} (${chosenSchedule.aircraft}) tidak memiliki First Class. First Class Suite hanya tersedia di rute B777-300ER 4-Class (LHR, CDG, LAX, JFK, HND, PEK)."
                    CabinClass.SUITE -> "Penerbangan ${chosenSchedule.flightNumber} (${chosenSchedule.aircraft}) belum menggunakan kabin Aria Suite (tersedia Business Class standar dengan tarif Asia Miles yang sama)."
                    CabinClass.PREMIUM_ECONOMY -> "Penerbangan ${chosenSchedule.flightNumber} (${chosenSchedule.aircraft}) tidak menyediakan Premium Economy (hanya Economy & Business)."
                    else -> null
                }
            } else null

            if (legWarning != null) {
                warnings.add("Leg ${idx + 1}: $legWarning")
            }

            breakdowns.add(
                LegBreakdown(
                    legNumber = idx + 1,
                    origin = leg.origin,
                    destination = leg.destination,
                    distanceMiles = route.distanceMiles,
                    band = legBand,
                    separateMilesOneWay = legMiles,
                    schedule = chosenSchedule,
                    cabinAvailable = available,
                    warningMessage = legWarning
                )
            )
        }

        if (breakdowns.isEmpty()) return null

        val combinedBand = determineBand(totalDistance, touchesType2)
        val combinedOneWay = combinedBand.milesForCabin(cabin)
        val multiplier = if (isRoundTrip) 2 else 1

        val combinedTotal = combinedOneWay * multiplier
        val separateTotal = separateOneWaySum * multiplier
        val savings = separateTotal - combinedTotal

        if (cabin == CabinClass.SUITE) {
            warnings.add("Catatan Aria Suite: Cathay Pacific mengenakan tarif Business Class Standard Award untuk kursi Aria Suite (B777-300ER retrofit).")
        } else if (cabin == CabinClass.FIRST) {
            warnings.add("Catatan First Class Suite: Tarif berlaku untuk kabin First Class 6-Suite (B777-300ER 4-Class) dan tidak tersedia di seluruh rute.")
        }

        return CalculationResult(
            totalDistanceMiles = totalDistance,
            combinedBand = combinedBand,
            combinedMilesOneWay = combinedOneWay,
            combinedMilesTotal = combinedTotal,
            separateMilesOneWay = separateOneWaySum,
            separateMilesTotal = separateTotal,
            savingsWithOnePnr = savings,
            isRoundTrip = isRoundTrip,
            cabin = cabin,
            legBreakdowns = breakdowns,
            warnings = warnings
        )
    }

    fun formatNumber(value: Int): String {
        return "%,d".format(value).replace(',', '.')
    }
}
