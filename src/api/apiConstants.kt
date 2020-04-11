package api

const val hostName = "http://localhost:8080";
const val worldDataApi = "$hostName/getWorldData"

val stateData = { stateName: String -> "$hostName/getLatestByState/${stateName}" }
val countryData = { countryName: String -> "$hostName/getLatestByCountry/${countryName}" }