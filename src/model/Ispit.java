package model;

public class Ispit {
    
    private String naziv;
    private int ocena;
    private int espb;

    public Ispit(String naziv, int ocena, int espb) {
        this.naziv = naziv;
        this.ocena = ocena;
        this.espb = espb;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    @Override
    public String toString() {
        return  naziv +"\t\t" +
                "|"+ocena+"|"+"\t\t " +
                "|"+espb+"|";
    }
}
