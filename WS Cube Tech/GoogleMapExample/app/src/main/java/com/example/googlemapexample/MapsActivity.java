package com.example.googlemapexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

import java.io.IOException;
import java.util.ArrayList;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Get the SupportMapFragment and request notification when the map is ready to be used
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker to the map
        LatLng collegeLatLng = new LatLng(21.491757523860446, 86.9346453935008);
        MarkerOptions markerOptions = new MarkerOptions().position(collegeLatLng).title("Fakir Mohan Autonomous College East Block, Balasore");
        mMap.addMarker(markerOptions);

        // Move the camera to the marker position and animate the zoom level
        mMap.moveCamera(CameraUpdateFactory.newLatLng(collegeLatLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(collegeLatLng, 16f));

        // Add a circle to the map
        mMap.addCircle(new CircleOptions()
                .center(collegeLatLng)
                .radius(500)
                .fillColor(Color.GRAY)
                .strokeColor(Color.DKGRAY));

        // Add a polygon to the map
        mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(21.491692, 86.934608))
                .add(new LatLng(21.491519, 86.935189))
                .add(new LatLng(21.491605, 86.935221))
                .add(new LatLng(21.491781, 86.934645))
                .fillColor(Color.YELLOW)
                .strokeColor(Color.BLUE));

        // Add an image overlay to the map
        mMap.addGroundOverlay(new GroundOverlayOptions()
                .position(collegeLatLng, 100f, 100f)
                .image(BitmapDescriptorFactory.fromResource(R.drawable.avatar))
                .clickable(true));


        // Set the map type to satellite
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        // Add a click listener to the map to handle map clicks
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                // Add a marker at the clicked location with a title
                mMap.addMarker(new MarkerOptions().position(latLng).title("Clicked here"));

                // Use Geocoder to get the address of the clicked location
                Geocoder geocoder = new Geocoder(MapsActivity.this);
                try {
                    // Get the list of addresses for the clicked location
                    ArrayList<Address> arrAdr = (ArrayList<Address>) geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);

                    // Log the first address line
                    Log.d("Addr", arrAdr.get(0).getAddressLine(0));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}