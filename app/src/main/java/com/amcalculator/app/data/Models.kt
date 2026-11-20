package com.amcalculator.app.data

enum class CabinClass(
    val displayName: String,
    val shortName: String,
    val description: String
) {
    ECONOMY("Economy", "Economy", "Kabin Ekonomi standar di semua armada Cathay Pacific"),
    PREMIUM_ECONOMY("Premium Economy", "Prem. Eco", "Tersedia di A350-900, A350-1000, & B777-300ER"),
    BUSINESS("Business", "Business", "Kabin Business Class (Lie-flat pada widebody & regional)"),
    FIRST("First Class", "First", "First Class Suite (6 kursi eksklusif di B777-300ER 4-Class)"),
    SUITE("Aria Suite", "Suite", "Business Class Aria Suite berpintu geser (B777-300ER retrofit, tarif Business Award)")
}

enum class Region(val label: String) {
    ALL("Semua"),
    INDONESIA("Indonesia"),
    SOUTHEAST_ASIA("Asia Tenggara"),
    JAPAN_KOREA("Jepang & Korea"),
    GREATER_CHINA("Tiongkok & Taiwan"),
    SOUTH_ASIA("Asia Selatan"),
    AUSTRALIA_NZ("Australia & NZ"),
    MIDDLE_EAST("Timur Tengah"),
    EUROPE("Eropa"),
    NORTH_AMERICA("Amerika Utara"),
    AFRICA("Afrika"),
    FIFTH_FREEDOM("Fifth Freedom")
}

enum class DistanceBand(
    val title: String,
    val rangeLabel: String,
    val economyMiles: Int,
    val premiumEconomyMiles: Int,
    val businessMiles: Int,
    val firstMiles: Int
) {
    ULTRA_SHORT(
        title = "Ultra-Short",
        rangeLabel = "1 – 750 mi",
        economyMiles = 7000,
        premiumEconomyMiles = 15000,
        businessMiles = 16000,
        firstMiles = 27000
    ),
    SHORT_TYPE_1(
        title = "Short-Haul Type 1",
        rangeLabel = "751 – 2.750 mi (Tipe 1)",
        economyMiles = 9000,
        premiumEconomyMiles = 18000,
        businessMiles = 28000,
        firstMiles = 43000
    ),
    SHORT_TYPE_2(
        title = "Short-Haul Type 2",
        rangeLabel = "751 – 2.750 mi (ID/JP/Asia Selatan)",
        economyMiles = 13000,
        premiumEconomyMiles = 23000,
        businessMiles = 33000,
        firstMiles = 50000
    ),
    MEDIUM(
        title = "Medium-Haul",
        rangeLabel = "2.751 – 5.000 mi",
        economyMiles = 20000,
        premiumEconomyMiles = 40000,
        businessMiles = 58000,
        firstMiles = 85000
    ),
    LONG(
        title = "Long-Haul",
        rangeLabel = "5.001 – 7.500 mi",
        economyMiles = 27000,
        premiumEconomyMiles = 50000,
        businessMiles = 88000,
        firstMiles = 125000
    ),
    ULTRA_LONG(
        title = "Ultra-Long",
        rangeLabel = "7.501+ mi",
        economyMiles = 38000,
        premiumEconomyMiles = 75000,
        businessMiles = 115000,
        firstMiles = 160000
    );

    fun milesForCabin(cabin: CabinClass): Int = when (cabin) {
        CabinClass.ECONOMY -> economyMiles
        CabinClass.PREMIUM_ECONOMY -> premiumEconomyMiles
        CabinClass.BUSINESS -> businessMiles
        CabinClass.FIRST -> firstMiles
        CabinClass.SUITE -> businessMiles // Aria Suite menggunakan tarif Business Award
    }
}

data class Airport(
    val code: String,
    val city: String,
    val country: String,
    val region: Region,
    val isShortHaulType2Market: Boolean = false
)

data class FlightSchedule(
    val flightNumber: String,
    val origin: String,
    val destination: String,
    val departureTime: String,
    val arrivalTime: String,
    val duration: String,
    val aircraft: String,
    val hasPremiumEconomy: Boolean,
    val hasFirstClass: Boolean,
    val hasAriaSuite: Boolean,
    val note: String = ""
) {
    fun supportsCabin(cabin: CabinClass): Boolean = when (cabin) {
        CabinClass.ECONOMY -> true
        CabinClass.PREMIUM_ECONOMY -> hasPremiumEconomy
        CabinClass.BUSINESS -> true
        CabinClass.FIRST -> hasFirstClass
        CabinClass.SUITE -> hasAriaSuite
    }
}

data class RouteInfo(
    val origin: String,
    val destination: String,
    val distanceMiles: Int,
    val region: Region,
    val isFifthFreedom: Boolean = false,
    val outboundSchedules: List<FlightSchedule>,
    val inboundSchedules: List<FlightSchedule>
)

data class LegInput(
    val id: Int,
    val origin: String,
    val destination: String,
    val selectedScheduleIndex: Int = 0
)

data class LegBreakdown(
    val legNumber: Int,
    val origin: String,
    val destination: String,
    val distanceMiles: Int,
    val band: DistanceBand,
    val separateMilesOneWay: Int,
    val schedule: FlightSchedule?,
    val cabinAvailable: Boolean,
    val warningMessage: String?
)

data class CalculationResult(
    val totalDistanceMiles: Int,
    val combinedBand: DistanceBand,
    val combinedMilesOneWay: Int,
    val combinedMilesTotal: Int,
    val separateMilesOneWay: Int,
    val separateMilesTotal: Int,
    val savingsWithOnePnr: Int,
    val isRoundTrip: Boolean,
    val cabin: CabinClass,
    val legBreakdowns: List<LegBreakdown>,
    val warnings: List<String>
)
