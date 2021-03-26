package youssef.benarbia.mysalamalaykapp;

import android.content.Context;

import org.json.JSONArray;

import java.util.Date;

public final class Controle {

    private static Controle instance = null;
    private static Profil profil;
    private static String nomFic = "saveprofil";
    //private static AccesLocal accesLocal;
    private static AccesDistant accesDistant;
    /**
     * Constructeur private
     */
    private Controle() {
        super();
    }

    /**
     * Création de l'instance
     * @return instance
     */
    public static final Controle getInstance(Context contexte) {
        if(Controle.instance == null) {
            Controle.instance = new Controle();
            //accesLocal = new AccessLocal(context);
            accesDistant = new AccesDistant();
            //profil = accesLocal.recupDernier();
            accesDistant.envoi("dernier", new JSONArray());
            //recupSeriealize(context);
        }
        return Controle.instance;
    }
    /**
     * Création du profil
     * @param user_login
     * @param user_pass
     * @param user_nicename
     * @param user_email
     */
    public void creerProfil(Integer user_login, Integer user_pass, Integer user_nicename, Integer user_email, Context contexte) {
        profil = new Profil(new Date(), user_login, user_pass, user_nicename, user_email);
        // accesLocal.ajout(profil);
        accesDistant.envoi("enreg", profil.convertToJSONArray());
        // Serializer.serialize(nomFic, profil, contexte);
    }

    public Integer get_Login() {
        if(profil == null) {
            return null;
        }else{
            return profil.getUser_login();
        }
    }

    public Integer get_pass() {
        if(profil == null) {
            return null;
        }else{
            return profil.getUser_pass();
        }
    }

    public Integer get_nicename() {
        if(profil == null) {
            return null;
        }else{
            return profil.getUser_niceName();
        }
    }

    public Integer get_email() {
        if(profil == null) {
            return null;
        }else{
            return profil.getUser_email();
        }
    }

}
