package webalapu.util;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderStatus;
import org.primefaces.model.map.LatLng;

import java.io.IOException;

public class GeoCoder {

    public static void getCoordinatesFromAddress(String address){
        try{
            Geocoder geocoder = new Geocoder();
            System.out.println(address);
            GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress("100 N. Garfield Ave., Pasadena, CA 91109").setLanguage("en").getGeocoderRequest();
            GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);

            if (geocoderResponse.getStatus().equals(GeocoderStatus.OK)){
                System.out.println(geocoderResponse.getResults());
            }

        } catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
