package fr.istic.ccn2.myapplication2;

public class ClientItem {
    private String name;
    private String lastname;
    private String date;
    private String ville;
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
}
