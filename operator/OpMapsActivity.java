package com.parking.admin.operator;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final String PRODUCT_URL = "http://utile-leaving.000webhostapp.com/ret_latlong.php";
    JSONArray products;
    JSONObject productsObject;
    double lat;
    double lon;
    MarkerOptions markerOptions = new MarkerOptions();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    private void getMarker(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, PRODUCT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            products = new JSONArray(response);
                            for(int i =0;i<products.length();i++) {
                                productsObject = products.getJSONObject(i);
                                String Latitude = productsObject.getString("Latitude");
                                String Longitude = productsObject.getString("Longitude");
                                lat = Double.parseDouble(Latitude);
                                lon = Double.parseDouble(Longitude);
                                addMarker(lat,lon);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(OpMapsActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng surat = new LatLng(21.1702,72.8311);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(surat));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(12));
        getMarker();
    }
    private void addMarker(double lat,double lon)
    {
        LatLng latlng = new LatLng(lat,lon);
        markerOptions.position(latlng);
        markerOptions.title("Traffic Marker");
        mMap.addMarker(markerOptions);

    }

}
