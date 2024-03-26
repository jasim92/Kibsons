# Maps Activity

This `MapsActivity` class is responsible for displaying paired coordinates on a map.

## Overview

The `MapsActivity` class performs the following tasks:

1. Initializes the layout using `ActivityMapsBinding`.
2. Creates a list of coordinates.
3. Pairs the coordinates into groups of five based on their proximity.
4. Displays the paired coordinates on the layout.

## Methods

### onCreate()

This method is called when the activity is created. It initializes the layout, creates a list of coordinates, pairs them into groups of five, and displays them on the layout.

### pairCoordinates(List<Coordinate> coordinates)

Pairs the given list of coordinates into groups of five based on their distances from each other.

### findClosestCoordinate(Coordinate baseCoordinate, List<Coordinate> coordinates)

Finds the closest coordinate to the given base coordinate from a list of coordinates.

### calculateDistance(Coordinate coordinate1, Coordinate coordinate2)

Calculates the distance between two coordinates using the Haversine formula.

## Usage

To use this you can give some coordinates to test it. some of coordinates I already hardcoded in onCreate()

## Example

```java
// Create a list of coordinates
        coordinates.add(new Coordinate(25.20853916401394, 55.29268839428475));
        coordinates.add(new Coordinate(25.21319790733209, 55.28873936559216));
        coordinates.add(new Coordinate(25.205431961587514, 55.28599428696021));
        coordinates.add(new Coordinate(25.243326880387652, 55.27877405644816));
        coordinates.add(new Coordinate(25.216295423197224, 55.25526146736478));
        coordinates.add(new Coordinate(25.25637546285896, 55.289074145607465));
        coordinates.add(new Coordinate(25.24208746873887, 55.31208594358086));
        coordinates.add(new Coordinate(25.212101721948024, 55.36770645600403));
        coordinates.add(new Coordinate(25.21833613939193, 55.2824847660799));
        coordinates.add(new Coordinate(25.238974105141313, 55.359648751500835));
        coordinates.add(new Coordinate(25.251714804080823, 55.34007701687604));
        coordinates.add(new Coordinate(25.26585148224263, 55.32136041270365));
        coordinates.add(new Coordinate(25.206965233406113, 55.391396731859736));
        coordinates.add(new Coordinate(25.224827944712583, 55.39003491057411));
        coordinates.add(new Coordinate(25.222666782904422, 55.35672303096034));
        coordinates.add(new Coordinate(25.19345763831275, 55.38125947792324));
        coordinates.add(new Coordinate(25.221605348950373, 55.29390983262925));
        coordinates.add(new Coordinate(25.255023556872935, 55.33431818093398));
        coordinates.add(new Coordinate(25.25108026961028, 55.344543477941016));
        coordinates.add(new Coordinate(25.21319790733209, 55.28873936559216));
// Add more coordinates...
```

### Output
## Output

Group 1:
(25.20853916401394, 55.29268839428475)
(25.21319790733209, 55.28873936559216)
(25.205431961587514, 55.28599428696021)
(25.221605348950373, 55.29390983262925)
(25.21833613939193, 55.2824847660799)
Group 2:
(25.243326880387652, 55.27877405644816)
(25.25637546285896, 55.289074145607465)
(25.24208746873887, 55.31208594358086)
(25.216295423197224, 55.25526146736478)
(25.26585148224263, 55.32136041270365)
Group 3:
(25.212101721948024, 55.36770645600403)
(25.222666782904422, 55.35672303096034)
(25.206965233406113, 55.391396731859736)
(25.19345763831275, 55.38125947792324)
(25.224827944712583, 55.39003491057411)
Group 4:
(25.238974105141313, 55.359648751500835)
(25.25108026961028, 55.344543477941016)
(25.251714804080823, 55.34007701687604)
(25.255023556872935, 55.33431818093398)

