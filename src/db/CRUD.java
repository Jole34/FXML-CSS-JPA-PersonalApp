package db;

import model.Ispit;

import java.sql.*;
import java.util.ArrayList;

public class CRUD {

    private PreparedStatement pstmt;
    private Statement stmt;
    private Connection con;

    public CRUD(){
        open();
    }

    public void open(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jole?serverTimezone=Europe/Berlin","","");
          stmt=con.createStatement();
        }catch(Exception e){ System.out.println(e);}
    }

    public boolean checkLogin(String korisnicko, String password){
        ResultSet rs = null;
        String sql = "SELECT * FROM User WHERE korisnicko=? AND lozinka=?;";

        try {
        pstmt = con.prepareStatement(sql);

        pstmt.setString(1, korisnicko);
        pstmt.setString(2, password);

        rs = pstmt.executeQuery();

        if (rs.next()){
            con.close();
            return true;
        }

        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public void addPredmet(String nazivа, int ocenaа, int espbа){
        String sql = "INSERT INTO Ispit (naziv, ocena, espb) VALUES (?, ?, ?)";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nazivа);
            pstmt.setInt(2, ocenaа);
            pstmt.setInt(3, espbа);

            pstmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void deletePredmet(String naziv){
        String sql = "DELETE FROM Ispit WHERE naziv =?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, naziv);


            pstmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Ispit> sviIspiti() {
        ArrayList<Ispit> ispits = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT * FROM Ispit";

        try {

            rs = stmt.executeQuery(sql);

            while(rs.next()){

                String naziv = rs.getString("naziv");
                int ocena = rs.getInt("ocena");
                int bodovi = rs.getInt("espb");

                Ispit is = new Ispit(naziv, ocena, bodovi);

                ispits.add(is);

            }
            return ispits;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ispits;
    }


}

