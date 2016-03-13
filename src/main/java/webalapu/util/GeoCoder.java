package webalapu.util;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderStatus;
import org.primefaces.model.map.LatLng;

import java.io.IOException;

public class GeoCoder {

    public static LatLng getCoordinatesFromAddress(String address){
        try{
            Geocoder geocoder = new Geocoder();
            GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(address).setLanguage("en").getGeocoderRequest();
            GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);

            if (geocoderResponse.getStatus().equals(GeocoderStatus.OK)){
                for (GeocoderResult result : geocoderResponse.getResults()){
                    if (result.getGeometry() != null){
                        return new LatLng(result.getGeometry().getLocation().getLat().doubleValue(), result.getGeometry().getLocation().getLng().doubleValue());
                    }
                }
            }

        } catch (IOException ex){
            ex.printStackTrace();

        }

        return new LatLng(0.0, 0.0);
    }
}
