package youssef.benarbia.mysalamalaykapp;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Profil implements Serializable {

    //propriétés
    private String user_login;
    private String user_pass;
    private String user_niceName;
    private String user_email;
    private Date user_registered;
    private int user_status;
    private String display_name;
    private String message;

    public Profil(Date user_registered, String user_login, String user_niceName, String user_email, String user_pass) {
        this.user_registered = user_registered;
        this.user_login = user_login;
        this.user_pass = user_pass;
        this.user_niceName = user_niceName;
        this.user_email = user_email;
    }

    public String getUser_login() {
        return user_login;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public String getUser_niceName() {
        return user_niceName;
    }

    public String getUser_email() {
        return user_email;
    }

    public Date getUser_registered() {
        return user_registered;
    }

    public int getUser_status() {
        return user_status;
    }

    public String getUser_displayName() {
        return display_name;
    }



    //message correspondant


    /**
     *
     * Conversion du profil au format JSONArray
     * @return
     *
     */
    public JSONArray convertToJSONArray() {
        List laListe = new ArrayList();

        laListe.add(user_registered);
        laListe.add(user_login);
        laListe.add(user_niceName);
        laListe.add(user_email);
        laListe.add(user_pass);

        return new JSONArray(laListe);
    }
}
