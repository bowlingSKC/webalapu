package webalapu.backing;

import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean(name = "mapBacking")
public class GMapBacking implements Serializable {
    private MapModel contactMapModel;
    private MapModel cinemaMapModel;

    public String cinemaMapCenter;

    @PostConstruct
    public void init() {
        contactMapModel = new DefaultMapModel();
        LatLng coordinates = new LatLng(47.085166, 17.900768);
        contactMapModel.addOverlay(new Marker(coordinates, "MoziÉlmény HQ"));

        cinemaMapModel = new DefaultMapModel();
    }

    public void setCinemaLocationOnMap(String address, String cinemaName){
        LatLng coordinates = geocode(address);
        setCinemaMapCenterFromLatLng(coordinates);
        cinemaMapModel.addOverlay(new Marker(coordinates, cinemaName));
    }

    private LatLng geocode(String address){
        LatLng coordinates = new LatLng(47.085166, 17.900768);

        //TODO: implement geocoding here

        return coordinates;
    }

    private void setCinemaMapCenterFromLatLng(LatLng coordinates){
        String position = coordinates.getLat() + ", " + coordinates.getLng();
        cinemaMapCenter = position;
    }

    public MapModel getContactMapModel() {
        return contactMapModel;
    }

    public MapModel getCinemaMapModel(){
        return cinemaMapModel;
    }


    public String getCinemaMapCenter() {
        return cinemaMapCenter;
    }

    public void setCinemaMapCenter(String cinemaMapCenter) {
        this.cinemaMapCenter = cinemaMapCenter;
    }
}
