package az.tarlan.medair.managers.entity;


import javax.persistence.*;

@Entity
@Table(name = "visit_places")

public class VisitPlaces {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_place_id")
    private int visitPlaceId;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "place_city")
    private String placeCity;

    @Column(name = "place_country")
    private String placeCountry;

    public VisitPlaces() {}

    public VisitPlaces(int visitPlaceId, String placeName, String placeCity, String placeCountry) {
        this.visitPlaceId = visitPlaceId;
        this.placeName = placeName;
        this.placeCity = placeCity;
        this.placeCountry = placeCountry;
    }

    public int getVisitPlaceId() {
        return visitPlaceId;
    }

    public void setVisitPlaceId(int visitPlaceId) {
        this.visitPlaceId = visitPlaceId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceCity() {
        return placeCity;
    }

    public void setPlaceCity(String placeCity) {
        this.placeCity = placeCity;
    }

    public String getPlaceCountry() {
        return placeCountry;
    }

    public void setPlaceCountry(String placeCountry) {
        this.placeCountry = placeCountry;
    }

    @Override
    public String toString() {
        return "VisitPlaces{" +
                "visitPlaceId=" + visitPlaceId +
                ", placeName='" + placeName + '\'' +
                ", placeCity='" + placeCity + '\'' +
                ", placeCountry='" + placeCountry + '\'' +
                '}';
    }
}
