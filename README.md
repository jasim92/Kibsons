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

