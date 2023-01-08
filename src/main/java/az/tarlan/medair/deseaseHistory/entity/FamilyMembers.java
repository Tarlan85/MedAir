package az.tarlan.medair.deseaseHistory.entity;

import javax.persistence.*;

@Entity
@Table(name = "family_members_disease")

public class FamilyMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "family_member_id")
    private int familyMembersId;

    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "family_member")
    private String familyMember;

    @Column(name = "family_member_injury_reason")
    private String familyMemberInjury;

    @Column(name = "family_member_died_reason")
    private String familyMemberDied;

    @Column(name = "family_member_current_cancer")
    private String familyMemberCurrentCancer;

    @Column(name = "family_member_description")
    private String familyMemberDesc;

    public FamilyMembers() {
    }


    public FamilyMembers(int familyMembersId, int patientId, String familyMember, String familyMemberInjury, String familyMemberDied, String familyMemberCurrentCancer, String familyMemberDesc) {
        this.familyMembersId = familyMembersId;
        this.patientId = patientId;
        this.familyMember = familyMember;
        this.familyMemberInjury = familyMemberInjury;
        this.familyMemberDied = familyMemberDied;
        this.familyMemberCurrentCancer = familyMemberCurrentCancer;
        this.familyMemberDesc = familyMemberDesc;
    }

    public int getFamilyMembersId() {
        return familyMembersId;
    }

    public void setFamilyMembersId(int familyMembersId) {
        this.familyMembersId = familyMembersId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(String familyMember) {
        this.familyMember = familyMember;
    }

    public String getFamilyMemberInjury() {
        return familyMemberInjury;
    }

    public void setFamilyMemberInjury(String familyMemberInjury) {
        this.familyMemberInjury = familyMemberInjury;
    }

    public String getFamilyMemberDied() {
        return familyMemberDied;
    }

    public void setFamilyMemberDied(String familyMemberDied) {
        this.familyMemberDied = familyMemberDied;
    }

    public String getFamilyMemberCurrentCancer() {
        return familyMemberCurrentCancer;
    }

    public void setFamilyMemberCurrentCancer(String familyMemberCurrentCancer) {
        this.familyMemberCurrentCancer = familyMemberCurrentCancer;
    }

    public String getFamilyMemberDesc() {
        return familyMemberDesc;
    }

    public void setFamilyMemberDesc(String familyMemberDesc) {
        this.familyMemberDesc = familyMemberDesc;
    }

    @Override
    public String toString() {
        return "FamilyMembers{" +
                "familyMembersId=" + familyMembersId +
                ", patientId=" + patientId +
                ", familyMember='" + familyMember + '\'' +
                ", familyMemberInjury='" + familyMemberInjury + '\'' +
                ", familyMemberDied='" + familyMemberDied + '\'' +
                ", familyMemberCurrentCancer='" + familyMemberCurrentCancer + '\'' +
                ", familyMemberDesc='" + familyMemberDesc + '\'' +
                '}';
    }
}