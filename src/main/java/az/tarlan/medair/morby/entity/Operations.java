package az.tarlan.medair.morby.entity;

import javax.persistence.*;

@Entity
@Table(name = "operations")

    public class Operations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id") //foreign key
    private int issueId;

    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "issue_desc")
    private int issueDesc;

    @Column(name = "point_type")
    private int pointType;

    @Column(name = "point_x")
    private int pointX;

    @Column(name = "point_y")
    private int pointY;

    @Column(name = "image_id")
    private int imageId;

    public Operations() {}

    public Operations(int issueId, int patientId, int issueDesc, int pointType, int pointX, int pointY, int imageId) {
        this.issueId = issueId;
        this.patientId = patientId;
        this.issueDesc = issueDesc;
        this.pointType = pointType;
        this.pointX = pointX;
        this.pointY = pointY;
        this.imageId = imageId;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getIssueDesc() {
        return issueDesc;
    }

    public void setIssueDesc(int issueDesc) {
        this.issueDesc = issueDesc;
    }

    public int getPointType() {
        return pointType;
    }

    public void setPointType(int pointType) {
        this.pointType = pointType;
    }

    public int getPointX() {
        return pointX;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "Operations{" +
                "issueId=" + issueId +
                ", patientId=" + patientId +
                ", issueDesc=" + issueDesc +
                ", pointType=" + pointType +
                ", pointX=" + pointX +
                ", pointY=" + pointY +
                ", imageId=" + imageId +
                '}';
    }
}
