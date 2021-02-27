#!/usr/bin/env kotlin

val ubaGeoJSONFixRegex = Regex(""""SHAPE\..*": \d*,\d*""")

fun String.fixUBAGeoJSON(): String {
  return this.replace(ubaGeoJSONFixRegex) {
    it.value.replace(',', '.')
  }
}

System.`in`.bufferedReader().use {
  var line = it.readLine()

  while (line != null) {
    println(line.fixUBAGeoJSON())

    line = it.readLine()
  }
}
