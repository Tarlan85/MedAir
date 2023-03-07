package az.tarlan.medair.managers.entity;


import javax.persistence.*;

@Entity
@Table(name = "pathologists_list")


public class PathologistsList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pathologist_id")
    private int pathologistId;

    @Column(name = "pathologist_name")
    private String pathologistName;

    @Column(name = "pathologist_place")
    private String pathologistPlace;



    public PathologistsList() {}

    public PathologistsList(int pathologistId, String pathologistName, String pathologistPlace) {
        this.pathologistId = pathologistId;
        this.pathologistName = pathologistName;
        this.pathologistPlace = pathologistPlace;
    }

    @Override
    public String toString() {
        return "PathologistsList{" +
                "pathologistId=" + pathologistId +"\n"+
                ", pathologistName='" + pathologistName + '\'' +"\n"+
                ", pathologistPlace='" + pathologistPlace + '\'' +"\n"+
                '}';
    }

    public String getPathologistPlace() {
        return pathologistPlace;
    }

    public void setPathologistPlace(String pathologistPlace) {
        this.pathologistPlace = pathologistPlace;
    }

    public int getPathologistId() {
        return pathologistId;
    }

    public void setPathologistId(int pathologistId) {
        this.pathologistId = pathologistId;
    }

    public String getPathologistName() {
        return pathologistName;
    }

    public void setPathologistName(String pathologistName) {
        this.pathologistName = pathologistName;
    }
}
