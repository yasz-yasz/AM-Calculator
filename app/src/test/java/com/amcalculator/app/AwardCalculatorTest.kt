package com.amcalculator.app

import com.amcalculator.app.data.CabinClass
import com.amcalculator.app.data.CathayDataRepository
import com.amcalculator.app.data.DistanceBand
import com.amcalculator.app.data.LegInput
import com.amcalculator.app.domain.AwardCalculator
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class AwardCalculatorTest {

    @Test
    fun testCgkToHkgBusinessOneWayAndRoundTrip() {
        val ow = AwardCalculator.calculate(
            legs = listOf(LegInput(1, "CGK", "HKG")),
            cabin = CabinClass.BUSINESS,
            isRoundTrip = false
        )
        assertNotNull(ow)
        assertEquals(DistanceBand.SHORT_TYPE_2, ow!!.combinedBand)
        assertEquals(33000, ow.combinedMilesTotal)

        val rt = AwardCalculator.calculate(
            legs = listOf(LegInput(1, "CGK", "HKG")),
            cabin = CabinClass.BUSINESS,
            isRoundTrip = true
        )
        assertEquals(66000, rt!!.combinedMilesTotal)
    }

    @Test
    fun testMultiLegCgkHkgNrtSavesMilesWithOnePnr() {
        val result = AwardCalculator.calculate(
            legs = listOf(
                LegInput(1, "CGK", "HKG"),
                LegInput(2, "HKG", "NRT")
            ),
            cabin = CabinClass.BUSINESS,
            isRoundTrip = false
        )
        assertNotNull(result)
        // 2021 + 1843 = 3864 mi -> MEDIUM (58,000) vs separate 33,000 + 33,000 = 66,000
        assertEquals(3864, result!!.totalDistanceMiles)
        assertEquals(DistanceBand.MEDIUM, result.combinedBand)
        assertEquals(58000, result.combinedMilesTotal)
        assertEquals(66000, result.separateMilesTotal)
        assertEquals(8000, result.savingsWithOnePnr)
    }

    @Test
    fun testHkgToLhrFirstAndAriaSuite() {
        val first = AwardCalculator.calculate(
            legs = listOf(LegInput(1, "HKG", "LHR", selectedScheduleIndex = 0)),
            cabin = CabinClass.FIRST,
            isRoundTrip = false
        )
        assertNotNull(first)
        assertEquals(125000, first!!.combinedMilesTotal)
        assertTrue(first.legBreakdowns.first().cabinAvailable)

        val aria = AwardCalculator.calculate(
            legs = listOf(LegInput(1, "HKG", "LHR", selectedScheduleIndex = 1)),
            cabin = CabinClass.SUITE,
            isRoundTrip = false
        )
        assertNotNull(aria)
        assertEquals(88000, aria!!.combinedMilesTotal)
        assertTrue(aria.legBreakdowns.first().cabinAvailable)
    }

    @Test
    fun testSmartTransitBuilderAndFifthFreedom() {
        val legs = CathayDataRepository.buildSmartLegs("CGK", "LHR")
        assertEquals(2, legs.size)
        assertEquals("HKG", legs[0].destination)
        assertEquals("LHR", legs[1].destination)

        val fifth = AwardCalculator.calculate(
            legs = listOf(LegInput(1, "TPE", "NRT")),
            cabin = CabinClass.ECONOMY,
            isRoundTrip = false
        )
        assertNotNull(fifth)
        assertEquals(13000, fifth!!.combinedMilesTotal)
    }
}
