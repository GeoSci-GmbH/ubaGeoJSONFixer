# ubaGeoJSONFixer

The ubaGeoJSONFixer is a small script, which takes broken GeoJSON from the [Umweltbundesamt (UBA)](https://datahub.uba.de/server/rest/services) as input from STDIN and fixes it, making it valid (Geo)JSON.

## What does it fix?
In GeoJSON responses from the Umweltbundesamt, some doubles have a comma as a decimal separator instead of a point, making it invalid JSON.

Currently, we know of `SHAPE.AREA` and `SHAPE.LEN`.

## Setup

You need the following to execute the script:

- Kotlin (tested with Kotlin 1.4.31)
- Java 8 (Java 11 and above trigger a bug, which pollute the output of the script)

### Setup with [asdf-vm](https://asdf-vm.com/)

1. `asdf plugin add java`
2. `asdf plugin add kotlin`
3. `asdf install java adoptopenjdk-8.0.282+8`
4. `asdf install kotlin latest`
5. `asdf global java adoptopenjdk-8.0.282+8`
6. `asdf global kotlin latest`

### (Optional) Make script available globally

https://askubuntu.com/a/465113

## Usage

`cat brokenFile.geojson | ./fixUbaGeoJSON.kts`

or if installed globally

`cat brokenFile.geojson | fixUbaGeoJSON.kts`
