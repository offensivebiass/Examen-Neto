package com.alexfrias.examenneto.MapView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexfrias.examenneto.ProgressDialog
import com.alexfrias.examenneto.R
import com.alexfrias.examenneto.model.LocationModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapsActivity : AppCompatActivity(), OnMapReadyCallback, MapContract.View {

    private lateinit var mMap: GoogleMap
    lateinit var mapFragment: SupportMapFragment
    lateinit var presenter: MapContract.Presenter
    var progress = ProgressDialog()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        presenter = MapPresenter(this, this)
        presenter.getLocation("703021")
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }

    override fun showProgress() {
        progress.showDialog(this)
    }

    override fun hideProgress() {
        progress.dismissDialog()
    }

    override fun returnData(location: LocationModel) {

        var locationSorted = location.reversed()

        mapFragment.getMapAsync { googleMap ->
            mMap = googleMap

            val latLng = LatLng(locationSorted[0].latitud, locationSorted[0].longitud)
            mMap.addMarker(
                MarkerOptions()
                    .position(latLng)
            )

            val cameraPosition = CameraPosition.Builder()
                .target(latLng)
                .zoom(15f).build()

            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
        }
    }
}