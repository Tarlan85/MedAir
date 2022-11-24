package az.tarlan.medair.analysis.entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "analyzes_media")

public class AnalyzesMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "analyzes_id")
    private String analyzesId;

    @Column(name = "analyzes_content")
    private Blob analyzesContent;

    public AnalyzesMedia() {}

    public AnalyzesMedia(int id, String analyzesId, Blob analyzesContent) {
        this.id = id;
        this.analyzesId = analyzesId;
        this.analyzesContent = analyzesContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnalyzesId() {
        return analyzesId;
    }

    public void setAnalyzesId(String analyzesId) {
        this.analyzesId = analyzesId;
    }

    public Blob getAnalyzesContent() {
        return analyzesContent;
    }

    public void setAnalyzesContent(Blob analyzesContent) {
        this.analyzesContent = analyzesContent;
    }

    @Override
    public String toString() {
        return "AnalyzesMedia{" +
                "id=" + id +
                ", analyzesId='" + analyzesId + '\'' +
                ", analyzesContent=" + analyzesContent +
                '}';
    }
}
