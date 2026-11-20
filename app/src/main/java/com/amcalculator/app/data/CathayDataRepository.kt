package com.amcalculator.app.data

object CathayDataRepository {

    val airports: List<Airport> = listOf(
        Airport("HKG", "Hong Kong", "Hong Kong", Region.GREATER_CHINA, false),
        Airport("CGK", "Jakarta", "Indonesia", Region.INDONESIA, true),
        Airport("DPS", "Denpasar (Bali)", "Indonesia", Region.INDONESIA, true),
        Airport("SUB", "Surabaya", "Indonesia", Region.INDONESIA, true),
        Airport("SIN", "Singapore", "Singapura", Region.SOUTHEAST_ASIA, false),
        Airport("BKK", "Bangkok", "Thailand", Region.SOUTHEAST_ASIA, false),
        Airport("HKT", "Phuket", "Thailand", Region.SOUTHEAST_ASIA, false),
        Airport("KUL", "Kuala Lumpur", "Malaysia", Region.SOUTHEAST_ASIA, false),
        Airport("PEN", "Penang", "Malaysia", Region.SOUTHEAST_ASIA, false),
        Airport("MNL", "Manila", "Filipina", Region.SOUTHEAST_ASIA, false),
        Airport("CEB", "Cebu", "Filipina", Region.SOUTHEAST_ASIA, false),
        Airport("SGN", "Ho Chi Minh City", "Vietnam", Region.SOUTHEAST_ASIA, false),
        Airport("HAN", "Hanoi", "Vietnam", Region.SOUTHEAST_ASIA, false),
        Airport("PNH", "Phnom Penh", "Kamboja", Region.SOUTHEAST_ASIA, false),
        Airport("HND", "Tokyo Haneda", "Jepang", Region.JAPAN_KOREA, true),
        Airport("NRT", "Tokyo Narita", "Jepang", Region.JAPAN_KOREA, true),
        Airport("KIX", "Osaka Kansai", "Jepang", Region.JAPAN_KOREA, true),
        Airport("NGO", "Nagoya", "Jepang", Region.JAPAN_KOREA, true),
        Airport("FUK", "Fukuoka", "Jepang", Region.JAPAN_KOREA, true),
        Airport("CTS", "Sapporo Chitose", "Jepang", Region.JAPAN_KOREA, true),
        Airport("ICN", "Seoul Incheon", "Korea Selatan", Region.JAPAN_KOREA, false),
        Airport("TPE", "Taipei Taoyuan", "Taiwan", Region.GREATER_CHINA, false),
        Airport("KHH", "Kaohsiung", "Taiwan", Region.GREATER_CHINA, false),
        Airport("PEK", "Beijing Capital", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("PVG", "Shanghai Pudong", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("SHA", "Shanghai Hongqiao", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("CAN", "Guangzhou", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("CTU", "Chengdu Tianfu", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("CKG", "Chongqing", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("HGH", "Hangzhou", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("NKG", "Nanjing", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("XMN", "Xiamen", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("FOC", "Fuzhou", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("WUH", "Wuhan", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("XIY", "Xi'an", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("TAO", "Qingdao", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("HAK", "Haikou", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("CGO", "Zhengzhou", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("WNZ", "Wenzhou", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("NGB", "Ningbo", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("URC", "Urumqi", "Tiongkok", Region.GREATER_CHINA, false),
        Airport("DEL", "Delhi", "India", Region.SOUTH_ASIA, true),
        Airport("BOM", "Mumbai", "India", Region.SOUTH_ASIA, true),
        Airport("BLR", "Bengaluru", "India", Region.SOUTH_ASIA, true),
        Airport("MAA", "Chennai", "India", Region.SOUTH_ASIA, true),
        Airport("HYD", "Hyderabad", "India", Region.SOUTH_ASIA, true),
        Airport("DAC", "Dhaka", "Bangladesh", Region.SOUTH_ASIA, true),
        Airport("KTM", "Kathmandu", "Nepal", Region.SOUTH_ASIA, true),
        Airport("CMB", "Colombo", "Sri Lanka", Region.SOUTH_ASIA, true),
        Airport("DXB", "Dubai", "UEA", Region.MIDDLE_EAST, false),
        Airport("RUH", "Riyadh", "Arab Saudi", Region.MIDDLE_EAST, false),
        Airport("SYD", "Sydney", "Australia", Region.AUSTRALIA_NZ, false),
        Airport("MEL", "Melbourne", "Australia", Region.AUSTRALIA_NZ, false),
        Airport("BNE", "Brisbane", "Australia", Region.AUSTRALIA_NZ, false),
        Airport("PER", "Perth", "Australia", Region.AUSTRALIA_NZ, false),
        Airport("ADL", "Adelaide", "Australia", Region.AUSTRALIA_NZ, false),
        Airport("CNS", "Cairns", "Australia", Region.AUSTRALIA_NZ, false),
        Airport("AKL", "Auckland", "Selandia Baru", Region.AUSTRALIA_NZ, false),
        Airport("CHC", "Christchurch", "Selandia Baru", Region.AUSTRALIA_NZ, false),
        Airport("LHR", "London Heathrow", "Inggris", Region.EUROPE, false),
        Airport("MAN", "Manchester", "Inggris", Region.EUROPE, false),
        Airport("CDG", "Paris CDG", "Prancis", Region.EUROPE, false),
        Airport("AMS", "Amsterdam", "Belanda", Region.EUROPE, false),
        Airport("FRA", "Frankfurt", "Jerman", Region.EUROPE, false),
        Airport("MUC", "Munich", "Jerman", Region.EUROPE, false),
        Airport("ZRH", "Zurich", "Swiss", Region.EUROPE, false),
        Airport("MXP", "Milan Malpensa", "Italia", Region.EUROPE, false),
        Airport("FCO", "Rome Fiumicino", "Italia", Region.EUROPE, false),
        Airport("MAD", "Madrid", "Spanyol", Region.EUROPE, false),
        Airport("BCN", "Barcelona", "Spanyol", Region.EUROPE, false),
        Airport("BRU", "Brussels", "Belgia", Region.EUROPE, false),
        Airport("LAX", "Los Angeles", "Amerika Serikat", Region.NORTH_AMERICA, false),
        Airport("SFO", "San Francisco", "Amerika Serikat", Region.NORTH_AMERICA, false),
        Airport("JFK", "New York JFK", "Amerika Serikat", Region.NORTH_AMERICA, false),
        Airport("BOS", "Boston", "Amerika Serikat", Region.NORTH_AMERICA, false),
        Airport("ORD", "Chicago O'Hare", "Amerika Serikat", Region.NORTH_AMERICA, false),
        Airport("DFW", "Dallas/Fort Worth", "Amerika Serikat", Region.NORTH_AMERICA, false),
        Airport("YVR", "Vancouver", "Kanada", Region.NORTH_AMERICA, false),
        Airport("YYZ", "Toronto Pearson", "Kanada", Region.NORTH_AMERICA, false),
        Airport("JNB", "Johannesburg", "Afrika Selatan", Region.AFRICA, false),
    )

    private val airportMap: Map<String, Airport> = airports.associateBy { it.code }

    fun getAirport(code: String): Airport? = airportMap[code.uppercase()]

    private fun fs(
        flt: String, orig: String, dest: String, dep: String, arr: String, dur: String,
        ac: String, pe: Boolean, first: Boolean, aria: Boolean, note: String = ""
    ) = FlightSchedule(flt, orig, dest, dep, arr, dur, ac, pe, first, aria, note)

    private fun buildRoutesPart1(): List<RouteInfo> = listOf(
        RouteInfo("HKG", "CGK", 2021, Region.INDONESIA, false,
            outboundSchedules = listOf(
                fs("CX777", "HKG", "CGK", "09:15", "13:15", "5j 00m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Economy"),
                fs("CX719", "HKG", "CGK", "15:45", "19:45", "5j 00m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
                fs("CX797", "HKG", "CGK", "19:05", "23:05", "5j 00m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Economy"),
            ),
            inboundSchedules = listOf(
                fs("CX798", "CGK", "HKG", "00:10", "06:05", "4j 55m", "Airbus A350-900", true, false, false, "Red-eye · Lie-flat Business & Prem. Eco"),
                fs("CX718", "CGK", "HKG", "08:25", "14:25", "5j 00m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
                fs("CX776", "CGK", "HKG", "14:25", "20:25", "5j 00m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Economy"),
            )
        ),
        RouteInfo("HKG", "DPS", 2147, Region.INDONESIA, false,
            outboundSchedules = listOf(
                fs("CX785", "HKG", "DPS", "10:15", "15:10", "4j 55m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
                fs("CX783", "HKG", "DPS", "16:20", "21:15", "4j 55m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Economy"),
            ),
            inboundSchedules = listOf(
                fs("CX784", "DPS", "HKG", "16:15", "21:15", "5j 00m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
                fs("CX782", "DPS", "HKG", "22:25", "03:20+1", "4j 55m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Economy"),
            )
        ),
        RouteInfo("HKG", "SUB", 2027, Region.INDONESIA, false,
            outboundSchedules = listOf(
                fs("CX781", "HKG", "SUB", "14:10", "18:05", "4j 55m", "Airbus A330-300 (Regional)", false, false, false, "Regional Business"),
            ),
            inboundSchedules = listOf(
                fs("CX780", "SUB", "HKG", "08:35", "14:30", "4j 55m", "Airbus A330-300 (Regional)", false, false, false, "Regional Business"),
            )
        ),
        RouteInfo("HKG", "SIN", 1594, Region.SOUTHEAST_ASIA, false,
            outboundSchedules = listOf(
                fs("CX739", "HKG", "SIN", "11:20", "15:20", "4j 00m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX715", "HKG", "SIN", "20:05", "00:05+1", "4j 00m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Economy"),
                fs("CX659", "HKG", "SIN", "01:45", "05:45", "4j 00m", "Airbus A350-900", true, false, false, "Red-eye · A350-900"),
            ),
            inboundSchedules = listOf(
                fs("CX714", "SIN", "HKG", "01:20", "05:25", "4j 05m", "Airbus A350-900", true, false, false, "Red-eye · A350-900"),
                fs("CX736", "SIN", "HKG", "10:05", "14:15", "4j 10m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX734", "SIN", "HKG", "16:35", "20:45", "4j 10m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Economy"),
            )
        ),
        RouteInfo("HKG", "BKK", 1049, Region.SOUTHEAST_ASIA, false,
            outboundSchedules = listOf(
                fs("CX755", "HKG", "BKK", "09:20", "11:20", "3j 00m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
                fs("CX751", "HKG", "BKK", "14:25", "16:25", "3j 00m", "Boeing 777-300 (Regional)", false, false, false, "Regional Business"),
                fs("CX703", "HKG", "BKK", "17:00", "19:00", "3j 00m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX754", "BKK", "HKG", "12:35", "16:30", "2j 55m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
                fs("CX708", "BKK", "HKG", "17:35", "21:30", "2j 55m", "Boeing 777-300 (Regional)", false, false, false, "Regional Business"),
                fs("CX702", "BKK", "HKG", "19:05", "23:00", "2j 55m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "HKT", 1427, Region.SOUTHEAST_ASIA, false,
            outboundSchedules = listOf(
                fs("CX771", "HKG", "HKT", "14:40", "17:20", "3j 40m", "Airbus A321neo", false, false, false, "Narrowbody · Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX770", "HKT", "HKG", "18:20", "22:55", "3j 35m", "Airbus A321neo", false, false, false, "Narrowbody · Economy & Business"),
            )
        ),
        RouteInfo("HKG", "KUL", 1565, Region.SOUTHEAST_ASIA, false,
            outboundSchedules = listOf(
                fs("CX723", "HKG", "KUL", "08:45", "12:45", "4j 00m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
                fs("CX729", "HKG", "KUL", "16:00", "20:00", "4j 00m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX722", "KUL", "HKG", "13:50", "17:55", "4j 05m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
                fs("CX724", "KUL", "HKG", "17:55", "22:00", "4j 05m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "PEN", 1485, Region.SOUTHEAST_ASIA, false,
            outboundSchedules = listOf(
                fs("CX633", "HKG", "PEN", "15:10", "19:00", "3j 50m", "Airbus A321neo", false, false, false, "Narrowbody · Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX634", "PEN", "HKG", "07:55", "11:50", "3j 55m", "Airbus A321neo", false, false, false, "Narrowbody · Economy & Business"),
            )
        ),
        RouteInfo("HKG", "MNL", 711, Region.SOUTHEAST_ASIA, false,
            outboundSchedules = listOf(
                fs("CX907", "HKG", "MNL", "07:45", "10:05", "2j 20m", "Boeing 777-300 (Regional)", false, false, false, "Ultra-Short · Regional Business"),
                fs("CX901", "HKG", "MNL", "09:00", "11:25", "2j 25m", "Airbus A350-900", true, false, false, "Ultra-Short · A350-900"),
                fs("CX919", "HKG", "MNL", "14:45", "17:05", "2j 20m", "Airbus A330-300 (Regional)", false, false, false, "Ultra-Short · Regional"),
            ),
            inboundSchedules = listOf(
                fs("CX906", "MNL", "HKG", "11:15", "13:45", "2j 30m", "Boeing 777-300 (Regional)", false, false, false, "Ultra-Short · Regional Business"),
                fs("CX900", "MNL", "HKG", "12:40", "15:05", "2j 25m", "Airbus A350-900", true, false, false, "Ultra-Short · A350-900"),
                fs("CX918", "MNL", "HKG", "18:10", "20:40", "2j 30m", "Airbus A330-300 (Regional)", false, false, false, "Ultra-Short · Regional"),
            )
        ),
        RouteInfo("HKG", "CEB", 1061, Region.SOUTHEAST_ASIA, false,
            outboundSchedules = listOf(
                fs("CX921", "HKG", "CEB", "08:50", "11:50", "3j 00m", "Airbus A321neo", false, false, false, "Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX922", "CEB", "HKG", "12:50", "15:45", "2j 55m", "Airbus A321neo", false, false, false, "Economy & Business"),
            )
        ),
        RouteInfo("HKG", "SGN", 928, Region.SOUTHEAST_ASIA, false,
            outboundSchedules = listOf(
                fs("CX767", "HKG", "SGN", "08:30", "10:15", "2j 45m", "Airbus A330-300 (Regional)", false, false, false, "Regional Business"),
                fs("CX765", "HKG", "SGN", "16:25", "18:10", "2j 45m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX766", "SGN", "HKG", "11:25", "15:10", "2j 45m", "Airbus A330-300 (Regional)", false, false, false, "Regional Business"),
                fs("CX764", "SGN", "HKG", "19:15", "23:00", "2j 45m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "HAN", 527, Region.SOUTHEAST_ASIA, false,
            outboundSchedules = listOf(
                fs("CX741", "HKG", "HAN", "08:40", "09:50", "2j 10m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
                fs("CX743", "HKG", "HAN", "17:55", "19:05", "2j 10m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX742", "HAN", "HKG", "10:50", "13:55", "2j 05m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
                fs("CX744", "HAN", "HKG", "20:05", "23:10", "2j 05m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            )
        ),
        RouteInfo("HKG", "PNH", 965, Region.SOUTHEAST_ASIA, false,
            outboundSchedules = listOf(
                fs("CX605", "HKG", "PNH", "08:55", "10:45", "2j 50m", "Airbus A321neo", false, false, false, "Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX604", "PNH", "HKG", "11:45", "15:30", "2j 45m", "Airbus A321neo", false, false, false, "Economy & Business"),
            )
        ),
        RouteInfo("HKG", "HND", 1805, Region.JAPAN_KOREA, false,
            outboundSchedules = listOf(
                fs("CX548", "HKG", "HND", "08:45", "13:45", "4j 00m", "Boeing 777-300ER (4-Class First Suite)", true, true, false, "Tersedia First Class Suite (4-Class)"),
                fs("CX542", "HKG", "HND", "16:20", "21:15", "3j 55m", "Boeing 777-300ER (3-Class)", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX543", "HND", "HKG", "10:00", "14:05", "5j 05m", "Boeing 777-300ER (3-Class)", true, false, false, "Lie-flat Business & Prem. Eco"),
                fs("CX549", "HND", "HKG", "16:05", "20:10", "5j 05m", "Boeing 777-300ER (4-Class First Suite)", true, true, false, "Tersedia First Class Suite (4-Class)"),
            )
        ),
        RouteInfo("HKG", "NRT", 1843, Region.JAPAN_KOREA, false,
            outboundSchedules = listOf(
                fs("CX504", "HKG", "NRT", "09:05", "14:20", "4j 15m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX520", "HKG", "NRT", "10:35", "15:50", "4j 15m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
                fs("CX500", "HKG", "NRT", "15:10", "20:25", "4j 15m", "Airbus A350-1000", true, false, false, "A350-1000 · Lie-flat & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX501", "NRT", "HKG", "10:45", "15:05", "5j 20m", "Airbus A350-1000", true, false, false, "A350-1000 · Lie-flat & Prem. Eco"),
                fs("CX505", "NRT", "HKG", "18:00", "22:15", "5j 15m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX521", "NRT", "HKG", "16:55", "21:15", "5j 20m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "KIX", 1545, Region.JAPAN_KOREA, false,
            outboundSchedules = listOf(
                fs("CX596", "HKG", "KIX", "08:10", "12:55", "3j 45m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
                fs("CX506", "HKG", "KIX", "10:25", "15:10", "3j 45m", "Boeing 777-300 (Regional)", false, false, false, "Regional Business"),
                fs("CX502", "HKG", "KIX", "16:35", "21:20", "3j 45m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX597", "KIX", "HKG", "09:20", "12:45", "4j 25m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
                fs("CX507", "KIX", "HKG", "17:55", "21:20", "4j 25m", "Boeing 777-300 (Regional)", false, false, false, "Regional Business"),
                fs("CX503", "KIX", "HKG", "10:00", "13:25", "4j 25m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "NGO", 1630, Region.JAPAN_KOREA, false,
            outboundSchedules = listOf(
                fs("CX536", "HKG", "NGO", "10:20", "15:10", "3j 50m", "Airbus A330-300 (Regional)", false, false, false, "Regional Business"),
            ),
            inboundSchedules = listOf(
                fs("CX539", "NGO", "HKG", "16:15", "20:00", "4j 45m", "Airbus A330-300 (Regional)", false, false, false, "Regional Business"),
            )
        ),
        RouteInfo("HKG", "FUK", 1272, Region.JAPAN_KOREA, false,
            outboundSchedules = listOf(
                fs("CX588", "HKG", "FUK", "11:05", "15:25", "3j 20m", "Airbus A321neo", false, false, false, "Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX589", "FUK", "HKG", "16:30", "19:35", "4j 05m", "Airbus A321neo", false, false, false, "Economy & Business"),
            )
        ),
        RouteInfo("HKG", "CTS", 2131, Region.JAPAN_KOREA, false,
            outboundSchedules = listOf(
                fs("CX580", "HKG", "CTS", "09:15", "15:10", "4j 55m", "Boeing 777-300ER (3-Class)", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX581", "CTS", "HKG", "16:30", "21:20", "5j 50m", "Boeing 777-300ER (3-Class)", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "ICN", 1286, Region.JAPAN_KOREA, false,
            outboundSchedules = listOf(
                fs("CX410", "HKG", "ICN", "09:30", "14:15", "3j 45m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
                fs("CX418", "HKG", "ICN", "14:25", "19:10", "3j 45m", "Boeing 777-300 (Regional)", false, false, false, "Regional Business"),
                fs("CX416", "HKG", "ICN", "16:25", "21:10", "3j 45m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
            ),
            inboundSchedules = listOf(
                fs("CX415", "ICN", "HKG", "08:50", "11:50", "4j 00m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
                fs("CX411", "ICN", "HKG", "15:20", "18:20", "4j 00m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
                fs("CX419", "ICN", "HKG", "20:15", "23:15", "4j 00m", "Boeing 777-300 (Regional)", false, false, false, "Regional Business"),
            )
        ),
    )

    private fun buildRoutesPart2(): List<RouteInfo> = listOf(
        RouteInfo("HKG", "TPE", 501, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX488", "HKG", "TPE", "08:00", "09:50", "1j 50m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Ultra-Short · Aria Suite tersedia"),
                fs("CX494", "HKG", "TPE", "10:40", "12:30", "1j 50m", "Airbus A350-900", true, false, false, "Ultra-Short · A350-900"),
                fs("CX400", "HKG", "TPE", "16:40", "18:30", "1j 50m", "Boeing 777-300 (Regional)", false, false, false, "Ultra-Short · Regional"),
            ),
            inboundSchedules = listOf(
                fs("CX489", "TPE", "HKG", "10:50", "12:50", "2j 00m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Ultra-Short · Aria Suite tersedia"),
                fs("CX495", "TPE", "HKG", "13:30", "15:30", "2j 00m", "Airbus A350-900", true, false, false, "Ultra-Short · A350-900"),
                fs("CX407", "TPE", "HKG", "08:00", "10:00", "2j 00m", "Boeing 777-300 (Regional)", false, false, false, "Ultra-Short · Regional"),
            )
        ),
        RouteInfo("HKG", "KHH", 412, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX432", "HKG", "KHH", "09:00", "10:35", "1j 35m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
                fs("CX424", "HKG", "KHH", "18:20", "19:55", "1j 35m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX431", "KHH", "HKG", "11:25", "13:05", "1j 40m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
                fs("CX423", "KHH", "HKG", "20:50", "22:30", "1j 40m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            )
        ),
        RouteInfo("HKG", "PEK", 1237, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX390", "HKG", "PEK", "09:00", "12:25", "3j 25m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX332", "HKG", "PEK", "12:00", "15:25", "3j 25m", "Boeing 777-300ER (4-Class First Suite)", true, true, false, "Tersedia First Class Suite"),
                fs("CX392", "HKG", "PEK", "16:00", "19:25", "3j 25m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX391", "PEK", "HKG", "13:35", "17:20", "3j 45m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX331", "PEK", "HKG", "16:40", "20:25", "3j 45m", "Boeing 777-300ER (4-Class First Suite)", true, true, false, "Tersedia First Class Suite"),
                fs("CX347", "PEK", "HKG", "10:00", "13:45", "3j 45m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "PVG", 780, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX368", "HKG", "PVG", "08:40", "11:20", "2j 40m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX360", "HKG", "PVG", "14:00", "16:40", "2j 40m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
                fs("CX380", "HKG", "PVG", "19:00", "21:40", "2j 40m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
            ),
            inboundSchedules = listOf(
                fs("CX367", "PVG", "HKG", "12:25", "15:20", "2j 55m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX369", "PVG", "HKG", "17:45", "20:40", "2j 55m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
                fs("CX365", "PVG", "HKG", "09:40", "12:35", "2j 55m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
            )
        ),
        RouteInfo("HKG", "SHA", 760, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX364", "HKG", "SHA", "17:05", "19:45", "2j 40m", "Airbus A330-300 (Regional)", false, false, false, "Regional Business"),
            ),
            inboundSchedules = listOf(
                fs("CX363", "SHA", "HKG", "11:25", "14:15", "2j 50m", "Airbus A330-300 (Regional)", false, false, false, "Regional Business"),
            )
        ),
        RouteInfo("HKG", "CAN", 84, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX982", "HKG", "CAN", "10:15", "11:25", "1j 10m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
                fs("CX988", "HKG", "CAN", "17:30", "18:40", "1j 10m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX983", "CAN", "HKG", "12:25", "13:40", "1j 15m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
                fs("CX989", "CAN", "HKG", "19:45", "21:00", "1j 15m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            )
        ),
        RouteInfo("HKG", "CTU", 848, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX986", "HKG", "CTU", "10:10", "13:10", "3j 00m", "Airbus A330-300 (Regional)", false, false, false, "Regional Business"),
            ),
            inboundSchedules = listOf(
                fs("CX987", "CTU", "HKG", "14:15", "17:05", "2j 50m", "Airbus A330-300 (Regional)", false, false, false, "Regional Business"),
            )
        ),
        RouteInfo("HKG", "CKG", 686, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX928", "HKG", "CKG", "11:30", "14:10", "2j 40m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX929", "CKG", "HKG", "15:10", "17:45", "2j 35m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            )
        ),
        RouteInfo("HKG", "HGH", 679, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX958", "HKG", "HGH", "08:50", "11:15", "2j 25m", "Airbus A330-300 (Regional)", false, false, false, "Ultra-Short · Regional"),
            ),
            inboundSchedules = listOf(
                fs("CX959", "HGH", "HKG", "12:20", "14:55", "2j 35m", "Airbus A330-300 (Regional)", false, false, false, "Ultra-Short · Regional"),
            )
        ),
        RouteInfo("HKG", "NKG", 709, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX356", "HKG", "NKG", "10:35", "13:15", "2j 40m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX357", "NKG", "HKG", "14:20", "17:05", "2j 45m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            )
        ),
        RouteInfo("HKG", "XMN", 300, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX978", "HKG", "XMN", "09:25", "10:55", "1j 30m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX979", "XMN", "HKG", "11:55", "13:30", "1j 35m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            )
        ),
        RouteInfo("HKG", "FOC", 435, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX990", "HKG", "FOC", "10:20", "12:05", "1j 45m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX991", "FOC", "HKG", "13:05", "15:00", "1j 55m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            )
        ),
        RouteInfo("HKG", "WUH", 564, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX936", "HKG", "WUH", "12:30", "14:40", "2j 10m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX937", "WUH", "HKG", "15:40", "17:55", "2j 15m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            )
        ),
        RouteInfo("HKG", "XIY", 904, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX946", "HKG", "XIY", "13:05", "16:15", "3j 10m", "Airbus A321neo", false, false, false, "Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX947", "XIY", "HKG", "17:15", "20:20", "3j 05m", "Airbus A321neo", false, false, false, "Economy & Business"),
            )
        ),
        RouteInfo("HKG", "TAO", 1018, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX954", "HKG", "TAO", "10:40", "13:55", "3j 15m", "Airbus A321neo", false, false, false, "Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX955", "TAO", "HKG", "14:55", "18:35", "3j 40m", "Airbus A321neo", false, false, false, "Economy & Business"),
            )
        ),
        RouteInfo("HKG", "HAK", 295, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX310", "HKG", "HAK", "14:50", "16:20", "1j 30m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX311", "HAK", "HKG", "17:20", "18:55", "1j 35m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            )
        ),
        RouteInfo("HKG", "CGO", 846, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX952", "HKG", "CGO", "11:55", "14:45", "2j 50m", "Airbus A321neo", false, false, false, "Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX953", "CGO", "HKG", "15:45", "18:40", "2j 55m", "Airbus A321neo", false, false, false, "Economy & Business"),
            )
        ),
        RouteInfo("HKG", "WNZ", 554, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX932", "HKG", "WNZ", "13:40", "15:45", "2j 05m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX933", "WNZ", "HKG", "16:45", "18:55", "2j 10m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            )
        ),
        RouteInfo("HKG", "NGB", 698, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX956", "HKG", "NGB", "10:15", "12:35", "2j 20m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            ),
            inboundSchedules = listOf(
                fs("CX957", "NGB", "HKG", "13:35", "16:00", "2j 25m", "Airbus A321neo", false, false, false, "Ultra-Short · Economy & Business"),
            )
        ),
        RouteInfo("HKG", "URC", 2145, Region.GREATER_CHINA, false,
            outboundSchedules = listOf(
                fs("CX998", "HKG", "URC", "01:30", "07:00", "5j 30m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
            ),
            inboundSchedules = listOf(
                fs("CX997", "URC", "HKG", "10:15", "15:20", "5j 05m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
            )
        ),
    )

    private fun buildRoutesPart3(): List<RouteInfo> = listOf(
        RouteInfo("HKG", "DEL", 2331, Region.SOUTH_ASIA, false,
            outboundSchedules = listOf(
                fs("CX695", "HKG", "DEL", "17:45", "21:35", "6j 20m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
                fs("CX679", "HKG", "DEL", "20:10", "00:05+1", "6j 25m", "Boeing 777-300ER (3-Class)", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX694", "DEL", "HKG", "22:45", "06:55+1", "5j 40m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
                fs("CX698", "DEL", "HKG", "01:15", "09:20", "5j 35m", "Boeing 777-300ER (3-Class)", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "BOM", 2663, Region.SOUTH_ASIA, false,
            outboundSchedules = listOf(
                fs("CX663", "HKG", "BOM", "20:15", "00:30+1", "6j 45m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX660", "BOM", "HKG", "01:45", "10:10", "5j 55m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "BLR", 2463, Region.SOUTH_ASIA, false,
            outboundSchedules = listOf(
                fs("CX623", "HKG", "BLR", "20:30", "00:25+1", "6j 25m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX624", "BLR", "HKG", "01:40", "09:50", "5j 40m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "MAA", 2305, Region.SOUTH_ASIA, false,
            outboundSchedules = listOf(
                fs("CX631", "HKG", "MAA", "21:40", "00:55+1", "5j 45m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
            ),
            inboundSchedules = listOf(
                fs("CX632", "MAA", "HKG", "02:05", "09:55", "5j 20m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
            )
        ),
        RouteInfo("HKG", "HYD", 2327, Region.SOUTH_ASIA, false,
            outboundSchedules = listOf(
                fs("CX649", "HKG", "HYD", "21:30", "00:45+1", "5j 45m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
            ),
            inboundSchedules = listOf(
                fs("CX648", "HYD", "HKG", "01:55", "09:40", "5j 15m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
            )
        ),
        RouteInfo("HKG", "DAC", 1508, Region.SOUTH_ASIA, false,
            outboundSchedules = listOf(
                fs("CX667", "HKG", "DAC", "21:55", "00:05+1", "4j 10m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
            ),
            inboundSchedules = listOf(
                fs("CX666", "DAC", "HKG", "01:25", "07:05", "3j 40m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
            )
        ),
        RouteInfo("HKG", "KTM", 1819, Region.SOUTH_ASIA, false,
            outboundSchedules = listOf(
                fs("CX640", "HKG", "KTM", "19:05", "22:15", "5j 25m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
            ),
            inboundSchedules = listOf(
                fs("CX603", "KTM", "HKG", "23:25", "06:15+1", "4j 35m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
            )
        ),
        RouteInfo("HKG", "CMB", 2503, Region.SOUTH_ASIA, false,
            outboundSchedules = listOf(
                fs("CX611", "HKG", "CMB", "20:20", "23:30", "5j 40m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
            ),
            inboundSchedules = listOf(
                fs("CX610", "CMB", "HKG", "00:45", "08:50", "5j 35m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Lie-flat Business"),
            )
        ),
        RouteInfo("HKG", "DXB", 3682, Region.MIDDLE_EAST, false,
            outboundSchedules = listOf(
                fs("CX731", "HKG", "DXB", "16:35", "21:40", "9j 05m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX746", "DXB", "HKG", "23:00", "10:35+1", "7j 35m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "RUH", 4227, Region.MIDDLE_EAST, false,
            outboundSchedules = listOf(
                fs("CX647", "HKG", "RUH", "15:40", "21:35", "10j 55m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX646", "RUH", "HKG", "23:15", "12:15+1", "8j 00m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "SYD", 4581, Region.AUSTRALIA_NZ, false,
            outboundSchedules = listOf(
                fs("CX101", "HKG", "SYD", "23:55", "11:10+1", "9j 15m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX161", "HKG", "SYD", "21:30", "08:45+1", "9j 15m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
                fs("CX111", "HKG", "SYD", "18:55", "06:10+1", "9j 15m", "Airbus A350-1000", true, false, false, "A350-1000 · Lie-flat & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX100", "SYD", "HKG", "14:00", "21:35", "9j 35m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX162", "SYD", "HKG", "10:05", "17:40", "9j 35m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
                fs("CX110", "SYD", "HKG", "07:35", "15:10", "9j 35m", "Airbus A350-1000", true, false, false, "A350-1000 · Lie-flat & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "MEL", 4595, Region.AUSTRALIA_NZ, false,
            outboundSchedules = listOf(
                fs("CX105", "HKG", "MEL", "00:05", "11:25", "9j 20m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX163", "HKG", "MEL", "10:40", "22:00", "9j 20m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
                fs("CX135", "HKG", "MEL", "19:10", "06:30+1", "9j 20m", "Airbus A350-1000", true, false, false, "A350-1000 · Lie-flat & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX104", "MEL", "HKG", "14:25", "21:55", "9j 30m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX178", "MEL", "HKG", "23:45", "07:15+1", "9j 30m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
                fs("CX134", "MEL", "HKG", "07:50", "15:20", "9j 30m", "Airbus A350-1000", true, false, false, "A350-1000 · Lie-flat & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "BNE", 4300, Region.AUSTRALIA_NZ, false,
            outboundSchedules = listOf(
                fs("CX157", "HKG", "BNE", "12:55", "23:40", "8j 45m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX156", "BNE", "HKG", "00:55", "07:50", "8j 55m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "PER", 3741, Region.AUSTRALIA_NZ, false,
            outboundSchedules = listOf(
                fs("CX171", "HKG", "PER", "14:55", "22:45", "7j 50m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX170", "PER", "HKG", "23:55", "07:45+1", "7j 50m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "ADL", 4215, Region.AUSTRALIA_NZ, false,
            outboundSchedules = listOf(
                fs("CX173", "HKG", "ADL", "23:30", "09:45+1", "8j 45m", "Airbus A350-900", true, false, false, "Musiman · Lie-flat & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX174", "ADL", "HKG", "11:20", "18:50", "9j 00m", "Airbus A350-900", true, false, false, "Musiman · Lie-flat & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "CNS", 3452, Region.AUSTRALIA_NZ, false,
            outboundSchedules = listOf(
                fs("CX147", "HKG", "CNS", "21:35", "06:45+1", "7j 10m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Musiman · Lie-flat Business"),
            ),
            inboundSchedules = listOf(
                fs("CX146", "CNS", "HKG", "12:00", "17:20", "7j 20m", "Airbus A330-300 (Lie-Flat)", false, false, false, "Musiman · Lie-flat Business"),
            )
        ),
        RouteInfo("HKG", "AKL", 5684, Region.AUSTRALIA_NZ, false,
            outboundSchedules = listOf(
                fs("CX197", "HKG", "AKL", "21:05", "12:05+1", "11j 00m", "Airbus A350-1000", true, false, false, "Long-Haul · A350-1000"),
            ),
            inboundSchedules = listOf(
                fs("CX198", "AKL", "HKG", "13:35", "21:05", "11j 30m", "Airbus A350-1000", true, false, false, "Long-Haul · A350-1000"),
            )
        ),
        RouteInfo("HKG", "CHC", 5845, Region.AUSTRALIA_NZ, false,
            outboundSchedules = listOf(
                fs("CX123", "HKG", "CHC", "20:55", "12:15+1", "11j 20m", "Airbus A350-900", true, false, false, "Musiman · Long-Haul A350-900"),
            ),
            inboundSchedules = listOf(
                fs("CX124", "CHC", "HKG", "13:55", "21:30", "11j 35m", "Airbus A350-900", true, false, false, "Musiman · Long-Haul A350-900"),
            )
        ),
        RouteInfo("HKG", "LHR", 5994, Region.EUROPE, false,
            outboundSchedules = listOf(
                fs("CX251", "HKG", "LHR", "23:55", "05:40+1", "13j 45m", "Boeing 777-300ER (4-Class First Suite)", true, true, false, "Tersedia First Class Suite (4-Class)"),
                fs("CX255", "HKG", "LHR", "23:15", "04:55+1", "13j 40m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX257", "HKG", "LHR", "09:10", "14:55", "13j 45m", "Airbus A350-1000", true, false, false, "A350-1000 · Lie-flat & Prem. Eco"),
                fs("CX253", "HKG", "LHR", "14:35", "20:20", "13j 45m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
            ),
            inboundSchedules = listOf(
                fs("CX252", "LHR", "HKG", "11:15", "07:05+1", "11j 50m", "Boeing 777-300ER (4-Class First Suite)", true, true, false, "Tersedia First Class Suite (4-Class)"),
                fs("CX250", "LHR", "HKG", "18:05", "13:55+1", "11j 50m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX256", "LHR", "HKG", "20:15", "16:05+1", "11j 50m", "Airbus A350-1000", true, false, false, "A350-1000 · Lie-flat & Prem. Eco"),
                fs("CX254", "LHR", "HKG", "22:10", "18:00+1", "11j 50m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
            )
        ),
        RouteInfo("HKG", "MAN", 5975, Region.EUROPE, false,
            outboundSchedules = listOf(
                fs("CX219", "HKG", "MAN", "00:35", "06:35", "14j 00m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX216", "MAN", "HKG", "11:10", "06:55+1", "11j 45m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
    )

    private fun buildRoutesPart4(): List<RouteInfo> = listOf(
        RouteInfo("HKG", "CDG", 5972, Region.EUROPE, false,
            outboundSchedules = listOf(
                fs("CX261", "HKG", "CDG", "00:05", "06:50", "13j 45m", "Boeing 777-300ER (4-Class First Suite)", true, true, false, "Tersedia First Class Suite (4-Class)"),
            ),
            inboundSchedules = listOf(
                fs("CX260", "CDG", "HKG", "12:15", "06:55+1", "11j 40m", "Boeing 777-300ER (4-Class First Suite)", true, true, false, "Tersedia First Class Suite (4-Class)"),
            )
        ),
        RouteInfo("HKG", "AMS", 5762, Region.EUROPE, false,
            outboundSchedules = listOf(
                fs("CX271", "HKG", "AMS", "00:15", "06:40", "13j 25m", "Airbus A350-1000", true, false, false, "A350-1000 · Lie-flat & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX270", "AMS", "HKG", "12:30", "06:55+1", "11j 25m", "Airbus A350-1000", true, false, false, "A350-1000 · Lie-flat & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "FRA", 5692, Region.EUROPE, false,
            outboundSchedules = listOf(
                fs("CX289", "HKG", "FRA", "00:25", "06:45", "13j 20m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
            ),
            inboundSchedules = listOf(
                fs("CX288", "FRA", "HKG", "12:50", "07:05+1", "11j 15m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
            )
        ),
        RouteInfo("HKG", "MUC", 5610, Region.EUROPE, false,
            outboundSchedules = listOf(
                fs("CX301", "HKG", "MUC", "01:10", "07:15", "13j 05m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX300", "MUC", "HKG", "14:00", "07:55+1", "10j 55m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "ZRH", 5769, Region.EUROPE, false,
            outboundSchedules = listOf(
                fs("CX383", "HKG", "ZRH", "00:05", "06:30", "13j 25m", "Airbus A350-1000", true, false, false, "A350-1000 · Lie-flat & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX382", "ZRH", "HKG", "13:15", "07:35+1", "11j 20m", "Airbus A350-1000", true, false, false, "A350-1000 · Lie-flat & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "MXP", 5810, Region.EUROPE, false,
            outboundSchedules = listOf(
                fs("CX233", "HKG", "MXP", "00:50", "07:20", "13j 30m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
            ),
            inboundSchedules = listOf(
                fs("CX234", "MXP", "HKG", "12:25", "06:40+1", "11j 15m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
            )
        ),
        RouteInfo("HKG", "FCO", 5769, Region.EUROPE, false,
            outboundSchedules = listOf(
                fs("CX293", "HKG", "FCO", "00:45", "07:20", "13j 35m", "Airbus A350-900", true, false, false, "Musiman · Lie-flat & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX292", "FCO", "HKG", "12:10", "06:35+1", "11j 25m", "Airbus A350-900", true, false, false, "Musiman · Lie-flat & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "MAD", 6547, Region.EUROPE, false,
            outboundSchedules = listOf(
                fs("CX315", "HKG", "MAD", "00:35", "08:05", "14j 30m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX320", "MAD", "HKG", "11:20", "06:50+1", "12j 30m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "BCN", 6259, Region.EUROPE, false,
            outboundSchedules = listOf(
                fs("CX321", "HKG", "BCN", "00:25", "07:35", "14j 10m", "Airbus A350-900", true, false, false, "Musiman · Lie-flat & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX318", "BCN", "HKG", "13:20", "08:15+1", "11j 55m", "Airbus A350-900", true, false, false, "Musiman · Lie-flat & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "BRU", 5832, Region.EUROPE, false,
            outboundSchedules = listOf(
                fs("CX291", "HKG", "BRU", "23:50", "06:30+1", "13j 40m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX294", "BRU", "HKG", "13:25", "07:55+1", "11j 30m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "LAX", 7260, Region.NORTH_AMERICA, false,
            outboundSchedules = listOf(
                fs("CX880", "HKG", "LAX", "23:55", "20:55", "13j 00m", "Boeing 777-300ER (4-Class First Suite)", true, true, false, "Tersedia First Class Suite (4-Class)"),
                fs("CX884", "HKG", "LAX", "12:45", "09:45", "13j 00m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
            ),
            inboundSchedules = listOf(
                fs("CX881", "LAX", "HKG", "00:25", "07:20+1", "14j 55m", "Boeing 777-300ER (4-Class First Suite)", true, true, false, "Tersedia First Class Suite (4-Class)"),
                fs("CX885", "LAX", "HKG", "11:30", "18:25+1", "14j 55m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
            )
        ),
        RouteInfo("HKG", "SFO", 6927, Region.NORTH_AMERICA, false,
            outboundSchedules = listOf(
                fs("CX872", "HKG", "SFO", "00:30", "21:00-1", "12j 30m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX870", "HKG", "SFO", "13:30", "10:00", "12j 30m", "Airbus A350-1000", true, false, false, "A350-1000 · Lie-flat & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX873", "SFO", "HKG", "00:15", "06:50+1", "14j 35m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX879", "SFO", "HKG", "12:10", "18:45+1", "14j 35m", "Airbus A350-1000", true, false, false, "A350-1000 · Lie-flat & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "YVR", 6392, Region.NORTH_AMERICA, false,
            outboundSchedules = listOf(
                fs("CX888", "HKG", "YVR", "00:30", "20:20-1", "11j 50m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX865", "HKG", "YVR", "15:10", "11:00", "11j 50m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            ),
            inboundSchedules = listOf(
                fs("CX889", "YVR", "HKG", "01:05", "06:55+1", "13j 50m", "Boeing 777-300ER (Aria Suite)", true, false, true, "Dilengkapi kabin Aria Suite"),
                fs("CX866", "YVR", "HKG", "12:55", "18:45+1", "13j 50m", "Airbus A350-900", true, false, false, "Lie-flat Business & Prem. Eco"),
            )
        ),
        RouteInfo("HKG", "JFK", 8072, Region.NORTH_AMERICA, false,
            outboundSchedules = listOf(
                fs("CX840", "HKG", "JFK", "16:15", "19:20", "15j 05m", "Boeing 777-300ER (4-Class First Suite)", true, true, false, "Ultra-Long · First Class Suite"),
                fs("CX844", "HKG", "JFK", "02:05", "05:10", "15j 05m", "Airbus A350-1000", true, false, false, "Ultra-Long · A350-1000"),
                fs("CX830", "HKG", "JFK", "09:10", "12:15", "15j 05m", "Airbus A350-1000", true, false, false, "Ultra-Long · A350-1000"),
            ),
            inboundSchedules = listOf(
                fs("CX841", "JFK", "HKG", "09:00", "14:00+1", "17j 00m", "Boeing 777-300ER (4-Class First Suite)", true, true, false, "Ultra-Long · First Class Suite"),
                fs("CX845", "JFK", "HKG", "00:55", "05:55+1", "17j 00m", "Airbus A350-1000", true, false, false, "Ultra-Long · A350-1000"),
                fs("CX831", "JFK", "HKG", "14:15", "19:15+1", "17j 00m", "Airbus A350-1000", true, false, false, "Ultra-Long · A350-1000"),
            )
        ),
        RouteInfo("HKG", "BOS", 7970, Region.NORTH_AMERICA, false,
            outboundSchedules = listOf(
                fs("CX812", "HKG", "BOS", "18:10", "21:15", "15j 05m", "Airbus A350-1000", true, false, false, "Ultra-Long · A350-1000"),
            ),
            inboundSchedules = listOf(
                fs("CX811", "BOS", "HKG", "00:45", "05:35+1", "16j 50m", "Airbus A350-1000", true, false, false, "Ultra-Long · A350-1000"),
            )
        ),
        RouteInfo("HKG", "ORD", 7794, Region.NORTH_AMERICA, false,
            outboundSchedules = listOf(
                fs("CX806", "HKG", "ORD", "11:55", "13:55", "15j 00m", "Airbus A350-1000", true, false, false, "Ultra-Long · A350-1000"),
            ),
            inboundSchedules = listOf(
                fs("CX807", "ORD", "HKG", "15:30", "20:55+1", "16j 25m", "Airbus A350-1000", true, false, false, "Ultra-Long · A350-1000"),
            )
        ),
        RouteInfo("HKG", "DFW", 8123, Region.NORTH_AMERICA, false,
            outboundSchedules = listOf(
                fs("CX898", "HKG", "DFW", "16:05", "17:55", "14j 50m", "Airbus A350-1000", true, false, false, "Ultra-Long · A350-1000"),
            ),
            inboundSchedules = listOf(
                fs("CX897", "DFW", "HKG", "23:55", "05:35+2", "16j 40m", "Airbus A350-1000", true, false, false, "Ultra-Long · A350-1000"),
            )
        ),
        RouteInfo("HKG", "YYZ", 7810, Region.NORTH_AMERICA, false,
            outboundSchedules = listOf(
                fs("CX826", "HKG", "YYZ", "17:45", "20:40", "14j 55m", "Airbus A350-1000", true, false, false, "Ultra-Long · A350-1000"),
            ),
            inboundSchedules = listOf(
                fs("CX825", "YYZ", "HKG", "00:50", "05:30+1", "16j 40m", "Airbus A350-1000", true, false, false, "Ultra-Long · A350-1000"),
            )
        ),
        RouteInfo("HKG", "JNB", 6653, Region.AFRICA, false,
            outboundSchedules = listOf(
                fs("CX749", "HKG", "JNB", "00:40", "07:40", "13j 00m", "Airbus A350-900", true, false, false, "Long-Haul · A350-900"),
            ),
            inboundSchedules = listOf(
                fs("CX748", "JNB", "HKG", "11:45", "06:30+1", "12j 45m", "Airbus A350-900", true, false, false, "Long-Haul · A350-900"),
            )
        ),
        RouteInfo("TPE", "NRT", 1356, Region.FIFTH_FREEDOM, true,
            outboundSchedules = listOf(
                fs("CX450", "TPE", "NRT", "13:00", "17:20", "3j 20m", "Boeing 777-300 (Regional)", false, false, false, "Fifth Freedom · Taipei–Tokyo Narita"),
            ),
            inboundSchedules = listOf(
                fs("CX451", "NRT", "TPE", "15:40", "18:35", "3j 55m", "Boeing 777-300 (Regional)", false, false, false, "Fifth Freedom · Tokyo Narita–Taipei"),
            )
        ),
    )

    private fun buildRoutesPart5(): List<RouteInfo> = listOf(
        RouteInfo("TPE", "KIX", 1058, Region.FIFTH_FREEDOM, true,
            outboundSchedules = listOf(
                fs("CX564", "TPE", "KIX", "11:05", "14:55", "2j 50m", "Airbus A350-900", true, false, false, "Fifth Freedom · A350-900"),
            ),
            inboundSchedules = listOf(
                fs("CX565", "KIX", "TPE", "16:15", "18:15", "3j 00m", "Airbus A350-900", true, false, false, "Fifth Freedom · A350-900"),
            )
        ),
        RouteInfo("TPE", "NGO", 1147, Region.FIFTH_FREEDOM, true,
            outboundSchedules = listOf(
                fs("CX530", "TPE", "NGO", "12:00", "15:50", "2j 50m", "Airbus A330-300 (Regional)", false, false, false, "Fifth Freedom · Taipei–Nagoya"),
            ),
            inboundSchedules = listOf(
                fs("CX531", "NGO", "TPE", "16:50", "19:00", "3j 10m", "Airbus A330-300 (Regional)", false, false, false, "Fifth Freedom · Nagoya–Taipei"),
            )
        ),
    )

    val routes: List<RouteInfo> by lazy { buildRoutesPart1() + buildRoutesPart2() + buildRoutesPart3() + buildRoutesPart4() + buildRoutesPart5() }

    fun findRoute(origin: String, destination: String): RouteInfo? {
        val o = origin.uppercase()
        val d = destination.uppercase()
        return routes.firstOrNull {
            (it.origin == o && it.destination == d) || (it.origin == d && it.destination == o)
        }
    }

    fun getSchedules(origin: String, destination: String): List<FlightSchedule> {
        val o = origin.uppercase()
        val d = destination.uppercase()
        val route = findRoute(o, d) ?: return emptyList()
        return if (route.origin == o && route.destination == d) {
            route.outboundSchedules
        } else {
            route.inboundSchedules
        }
    }

    fun getReachableDestinations(origin: String): List<Airport> {
        val o = origin.uppercase()
        val codes = routes.mapNotNull {
            when {
                it.origin == o -> it.destination
                it.destination == o -> it.origin
                else -> null
            }
        }.distinct()
        return codes.mapNotNull { getAirport(it) }.sortedBy { it.code }
    }

    fun buildSmartLegs(origin: String, destination: String): List<LegInput> {
        val o = origin.uppercase()
        val d = destination.uppercase()
        if (o == d) return emptyList()
        // Direct flight exists?
        if (findRoute(o, d) != null) {
            return listOf(LegInput(id = 1, origin = o, destination = d))
        }
        // Connect via HKG hub
        if (o != "HKG" && d != "HKG" && findRoute(o, "HKG") != null && findRoute("HKG", d) != null) {
            return listOf(
                LegInput(id = 1, origin = o, destination = "HKG"),
                LegInput(id = 2, origin = "HKG", destination = d)
            )
        }
        // Connect via TPE if applicable
        if (o != "TPE" && d != "TPE" && findRoute(o, "TPE") != null && findRoute("TPE", d) != null) {
            return listOf(
                LegInput(id = 1, origin = o, destination = "TPE"),
                LegInput(id = 2, origin = "TPE", destination = d)
            )
        }
        return emptyList()
    }
}