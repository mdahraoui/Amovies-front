package com.aston_cdnt17.amovies;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;

import androidx.core.content.ContextCompat;

public class LocationUtils {

    public static Location getLastKnownLocation(Context c) {

        //Contrôle de la permission
        if (ContextCompat.checkSelfPermission(c, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_DENIED) {
            return null;
        }

        LocationManager lm = (LocationManager) c.getSystemService(Context.LOCATION_SERVICE);
        Location bestLocation = null;
        //on teste chaque provider(réseau, GPS...) et on garde celui avec la meilleurs précision
        for (String provider : lm.getProviders(true)) {

            Location l = lm.getLastKnownLocation(provider);

            if (l != null && (bestLocation == null
                    || l.getAccuracy() < bestLocation.getAccuracy())) {
                bestLocation = l;
            }
        }

        return bestLocation;
    }
}
