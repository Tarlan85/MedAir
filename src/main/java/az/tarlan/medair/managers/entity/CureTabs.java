package az.tarlan.medair.managers.entity;


import javax.persistence.*;

@Entity
@Table(name = "cure_tabs")


public class CureTabs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cure_tab_id")
    private int cureTabId;

    @Column(name = "cure_tab_name")
    private String cureTabName;

    @Column(name = "cure_tab_type")
    private String cureTabType;

    @Column(name = "cure_tab_size")
    private String cureTabSize;

    public CureTabs() {}

    public CureTabs(int cureTabId, String cureTabName, String cureTabType, String cureTabSize) {
        this.cureTabId = cureTabId;
        this.cureTabName = cureTabName;
        this.cureTabType = cureTabType;
        this.cureTabSize = cureTabSize;
    }

    public int getCureTabId() {
        return cureTabId;
    }

    public void setCureTabId(int cureTabId) {
        this.cureTabId = cureTabId;
    }

    public String getCureTabName() {
        return cureTabName;
    }

    public void setCureTabName(String cureTabName) {
        this.cureTabName = cureTabName;
    }

    public String getCureTabType() {
        return cureTabType;
    }

    public void setCureTabType(String cureTabType) {
        this.cureTabType = cureTabType;
    }

    public String getCureTabSize() {
        return cureTabSize;
    }

    public void setCureTabSize(String cureTabSize) {
        this.cureTabSize = cureTabSize;
    }

    @Override
    public String toString() {
        return "CureTabs{" +
                "cureTabId=" + cureTabId +
                ", cureTabName='" + cureTabName + '\'' +
                ", cureTabType='" + cureTabType + '\'' +
                ", cureTabSize='" + cureTabSize + '\'' +
                '}';
    }
}
