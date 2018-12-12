package fr.istic.ccn2.myapplication2;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ClientItem {
    @PrimaryKey(autoGenerate = true)
    private int cid;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "lastname")
    private String lastname;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "ville")
    private String ville;
    @ColumnInfo(name = "departement")
    private  String departement;



    public ClientItem (String name, String lastname, String date, String ville, String departement) {

        this.name = name;
        this.lastname = lastname;
        this.date = date;
        this.ville = ville;
        this.departement = departement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
   public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
