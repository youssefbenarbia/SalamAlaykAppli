package youssef.benarbia.mysalamalaykapp;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Profil implements Serializable {

    //propriétés
    private Integer user_login;
    private Integer user_pass;
    private Integer user_niceName;
    private Integer user_email;
    private Date user_registered;
    private int user_status;
    private Integer display_name;
    private Integer message;

    public Profil(Date user_registered, Integer user_login, Integer user_pass, Integer user_niceName, Integer user_email) {
        this.user_registered = user_registered;
        this.user_login = user_login;
        this.user_pass = user_pass;
        this.user_niceName = user_niceName;
        this.user_email = user_email;
    }

    public Integer getUser_login() {
        return user_login;
    }

    public Integer getUser_pass() {
        return user_pass;
    }

    public Integer getUser_niceName() {
        return user_niceName;
    }

    public Integer getUser_email() {
        return user_email;
    }

    public Date getUser_registered() {
        return user_registered;
    }

    public int getUser_status() {
        return user_status;
    }

    public Integer getUser_displayName() {
        return display_name;
    }



    //message correspondant


    /**
     * Conversion du profil au format JSONArray
     * @return
     */
    public JSONArray convertToJSONArray() {
        List laListe = new ArrayList();
        laListe.add(user_login);
        laListe.add(user_pass);
        laListe.add(user_niceName);
        laListe.add(user_email);
        laListe.add(user_registered);

        return new JSONArray(laListe);
    }
}
