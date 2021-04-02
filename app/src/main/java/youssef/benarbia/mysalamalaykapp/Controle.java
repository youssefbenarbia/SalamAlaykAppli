package youssef.benarbia.mysalamalaykapp;

import android.content.Context;
import android.util.Log;

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
    public void creerProfil(String user_login, String user_nicename, String user_email, String user_pass, Context contexte) {
        profil = new Profil(new Date(), user_login, user_nicename, user_email, user_pass);
        // accesLocal.ajout(profil);
        accesDistant.envoi("enreg", profil.convertToJSONArray());
        Log.d("serveur", "++++"+user_nicename);
        // Serializer.serialize(nomFic, profil, contexte);
    }

    public String get_login() {
        if(profil == null) {
            return null;
        }else{
            return profil.getUser_login();
        }
    }

    public String get_pass() {
        if(profil == null) {
            return null;
        }else{
            return profil.getUser_pass();
        }
    }

    public String get_nicename() {
        if(profil == null) {
            return null;
        }else{
            return profil.getUser_niceName();
        }
    }

    public String get_email() {
        if(profil == null) {
            return null;
        }else{
            return profil.getUser_email();
        }
    }

    /**
     * récupération de l'objet sérializé
     * @param contexte
     */
    private static void recupSerialize(Context contexte) {
        profil = (Profil)Serializer.deSerialize(nomFic, contexte);
    }

    public static final Controle getInstanceConnection(String user_login, String user_pass,Context contexte) {

        profil = new Profil(new Date(), user_login,"","",user_pass);

        if(Controle.instance == null) {
            Controle.instance = new Controle();
            //accesLocal = new AccessLocal(context);
            accesDistant = new AccesDistant();
            //profil = accesLocal.recupDernier();
            accesDistant.envoi("recupLogs", profil.convertToJSONArray());
            //recupSeriealize(context);
        }

        Log.d("serveur", "++++"+user_pass);
        return Controle.instance;
    }
}
