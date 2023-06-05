package az.tarlan.medair.deseaseHistory.entity;

import javax.persistence.*;

@Entity
@Table(name = "desease_image")

    public class DeseaseImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //foreign key
    private int id;

    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "desease_image1_desc")
    private String deseaseImage1Desc;
    @Column(name = "desease_image2_desc")
    private String deseaseImage2Desc;
    @Column(name = "desease_image3_desc")
    private String deseaseImage3Desc;
    @Column(name = "desease_image4_desc")
    private String deseaseImage4Desc;
    @Column(name = "desease_image5_desc")
    private String deseaseImage5Desc;

    @Column(name = "desease_image1_data")
    private String deseaseImage1Data;
    @Column(name = "desease_image2_data")
    private String deseaseImage2Data;
    @Column(name = "desease_image3_data")
    private String deseaseImage3Data;
    @Column(name = "desease_image4_data")
    private String deseaseImage4Data;
    @Column(name = "desease_image5_data")
    private String deseaseImage5Data;


    public DeseaseImage() {}

    public DeseaseImage(int id, int patientId, String deseaseImage1Desc, String deseaseImage2Desc, String deseaseImage3Desc, String deseaseImage4Desc, String deseaseImage5Desc, String deseaseImage1Data, String deseaseImage2Data, String deseaseImage3Data, String deseaseImage4Data, String deseaseImage5Data) {
        this.id = id;
        this.patientId = patientId;
        this.deseaseImage1Desc = deseaseImage1Desc;
        this.deseaseImage2Desc = deseaseImage2Desc;
        this.deseaseImage3Desc = deseaseImage3Desc;
        this.deseaseImage4Desc = deseaseImage4Desc;
        this.deseaseImage5Desc = deseaseImage5Desc;
        this.deseaseImage1Data = deseaseImage1Data;
        this.deseaseImage2Data = deseaseImage2Data;
        this.deseaseImage3Data = deseaseImage3Data;
        this.deseaseImage4Data = deseaseImage4Data;
        this.deseaseImage5Data = deseaseImage5Data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getDeseaseImage1Desc() {
        return deseaseImage1Desc;
    }

    public void setDeseaseImage1Desc(String deseaseImage1Desc) {
        this.deseaseImage1Desc = deseaseImage1Desc;
    }

    public String getDeseaseImage2Desc() {
        return deseaseImage2Desc;
    }

    public void setDeseaseImage2Desc(String deseaseImage2Desc) {
        this.deseaseImage2Desc = deseaseImage2Desc;
    }

    public String getDeseaseImage3Desc() {
        return deseaseImage3Desc;
    }

    public void setDeseaseImage3Desc(String deseaseImage3Desc) {
        this.deseaseImage3Desc = deseaseImage3Desc;
    }

    public String getDeseaseImage4Desc() {
        return deseaseImage4Desc;
    }

    public void setDeseaseImage4Desc(String deseaseImage4Desc) {
        this.deseaseImage4Desc = deseaseImage4Desc;
    }

    public String getDeseaseImage5Desc() {
        return deseaseImage5Desc;
    }

    public void setDeseaseImage5Desc(String deseaseImage5Desc) {
        this.deseaseImage5Desc = deseaseImage5Desc;
    }

    public String getDeseaseImage1Data() {
        return deseaseImage1Data;
    }

    public void setDeseaseImage1Data(String deseaseImage1Data) {
        this.deseaseImage1Data = deseaseImage1Data;
    }

    public String getDeseaseImage2Data() {
        return deseaseImage2Data;
    }

    public void setDeseaseImage2Data(String deseaseImage2Data) {
        this.deseaseImage2Data = deseaseImage2Data;
    }

    public String getDeseaseImage3Data() {
        return deseaseImage3Data;
    }

    public void setDeseaseImage3Data(String deseaseImage3Data) {
        this.deseaseImage3Data = deseaseImage3Data;
    }

    public String getDeseaseImage4Data() {
        return deseaseImage4Data;
    }

    public void setDeseaseImage4Data(String deseaseImage4Data) {
        this.deseaseImage4Data = deseaseImage4Data;
    }

    public String getDeseaseImage5Data() {
        return deseaseImage5Data;
    }

    public void setDeseaseImage5Data(String deseaseImage5Data) {
        this.deseaseImage5Data = deseaseImage5Data;
    }

    @Override
    public String toString() {
        return "DeseaseImage{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", deseaseImageDesc='" + deseaseImage1Desc + '\'' +"\n"+
                ", deseaseImage2Desc='" + deseaseImage2Desc + '\'' +"\n"+
                ", deseaseImage3Desc='" + deseaseImage3Desc + '\'' +"\n"+
                ", deseaseImage4Desc='" + deseaseImage4Desc + '\'' +"\n"+
                ", deseaseImage5Desc='" + deseaseImage5Desc + '\'' +"\n"+
                ", deseaseImage1Data='" + deseaseImage1Data + '\'' +"\n"+
                ", deseaseImage2Data='" + deseaseImage2Data + '\'' +"\n"+
                ", deseaseImage3Data='" + deseaseImage3Data + '\'' +"\n"+
                ", deseaseImage4Data='" + deseaseImage4Data + '\'' +"\n"+
                ", deseaseImage5Data='" + deseaseImage5Data + '\'' +"\n"+
                '}';
    }
}
