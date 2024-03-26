package com.example.kibsons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.kibsons.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends AppCompatActivity {


    private ActivityMapsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //-----------------------------------------
        List<Coordinate> coordinates = new ArrayList<>();
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


        // Pair coordinates into groups of five based on proximity
        List<List<Coordinate>> pairedCoordinates = pairCoordinates(coordinates);

        // Display paired coordinates
        for (int i = 0; i < pairedCoordinates.size(); i++) {
            Log.e("Group: ", "Group " + (i + 1) + ":");
            TextView groupLabelTextView = new TextView(this);
            groupLabelTextView.setText("Group " + (i + 1) + ":");
            binding.groupedItemsLayout.addView(groupLabelTextView);
            List<Coordinate> group = pairedCoordinates.get(i);
            for (Coordinate coordinate : group) {
                Log.e("Mydata: ", coordinate.toString() + "\n");
                TextView coordinateTextView = new TextView(this);
                coordinateTextView.setText(coordinate.toString());
                binding.groupedItemsLayout.addView(coordinateTextView);
            }

        }
    }

        // Pair coordinates into groups of five based on distances
        private static List<List<Coordinate>> pairCoordinates (List < Coordinate > coordinates) {
            List<List<Coordinate>> pairedCoordinates = new ArrayList<>();
            List<Coordinate> remainingCoordinates = new ArrayList<>(coordinates);

            while (!remainingCoordinates.isEmpty()) {
                List<Coordinate> currentGroup = new ArrayList<>();
                Coordinate baseCoordinate = remainingCoordinates.remove(0);
                currentGroup.add(baseCoordinate);

                // Find four closest coordinates to the base coordinate
                for (int i = 0; i < 4 && !remainingCoordinates.isEmpty(); i++) {
                    Coordinate closestCoordinate = findClosestCoordinate(baseCoordinate, remainingCoordinates);
                    currentGroup.add(closestCoordinate);
                    remainingCoordinates.remove(closestCoordinate);
                }

                pairedCoordinates.add(currentGroup);
            }

            return pairedCoordinates;
        }

        // Find the closest coordinate to the base coordinate
        private static Coordinate findClosestCoordinate (Coordinate
        baseCoordinate, List < Coordinate > coordinates){
            Coordinate closestCoordinate = null;
            double minDistance = Double.MAX_VALUE;

            for (Coordinate coordinate : coordinates) {
                double distance = calculateDistance(baseCoordinate, coordinate);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestCoordinate = coordinate;
                }
            }

            return closestCoordinate;
        }

        // Calculate the distance between two coordinates
        private static double calculateDistance (Coordinate coordinate1, Coordinate coordinate2){

            double lat1 = Math.toRadians(coordinate1.latitude);
            double lon1 = Math.toRadians(coordinate1.longitude);
            double lat2 = Math.toRadians(coordinate2.latitude);
            double lon2 = Math.toRadians(coordinate2.longitude);

            double dlon = lon2 - lon1;
            double dlat = lat2 - lat1;
            double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = 6371 * c; // Radius of the Earth in kilometers

            return distance;
        }


}
