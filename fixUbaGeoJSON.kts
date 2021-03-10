#!/usr/bin/env kotlin

val ubaGeoJSONFixRegex = Regex(""""SHAPE\..*": \d*,\d*""")

fun fixUBAGeoJSON(geoJsonString: String): String {
  return geoJsonString.replace(ubaGeoJSONFixRegex) {
    it.value.replace(',', '.')
  }
}

System.`in`.bufferedReader().use { reader ->
  reader.lineSequence()
    .map(::fixUBAGeoJSON)
    .forEach(::println)
}
