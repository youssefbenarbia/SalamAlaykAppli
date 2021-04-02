package youssef.benarbia.mysalamalaykapp;

import android.util.Log;

import org.json.JSONArray;

public class AccesDistant implements AsyncResponse{

    //constante
    private static final String SERVERADDR = "http://192.168.0.17/salamalaykapp/serveurSalamAleykappbdd.php";
    private MainActivity mainActivity;

    public AccesDistant() {
        super();
    }
    /**
     * retour du serveur distant
     * @param output
     */

    @Override
    public void processFinish(String output) {
        Log.d("serveur", "***************************" + output);
        // découpage du message reçu avec %
        String[] message = output.split("%");
        //dans message[0] : "enreg", "dernier", "Erreur !"
        //dans message[1] : reste du message

        // s'l y a 2 cases
        if (message.length > 1) {
            if (message[0].equals("enreg")) {
                Log.d("enreg", "********************************" + message[1]);
            } else {
                if (message[0].equals("dernier")) {
                    Log.d("dernier", "********************************" + message[1]);
                } else {
                    if (message[0].equals("Erreur !")) {
                        Log.d("Erreur !", "********************************" + message[1]);
                    } else {
                        if (message[0].equals("recupLogs")) {
                            Log.d("recupLogs", "********************************" + message[1]);
                            message[1].convert
                        }
                    }
                }
            }
        }
    }
    public void envoi(String operation, JSONArray lesDonneesJSON) {
        AccessHTTP accesDonnees = new AccessHTTP();
        //lien de délégation
        accesDonnees.delegate = this;
        //ajout paramètres
        accesDonnees.addParam("operation", operation);
        accesDonnees.addParam("lesdonnees", lesDonneesJSON.toString());
        //appel au serveur
        accesDonnees.execute(SERVERADDR);
        Log.d("serveur", "++++"+ lesDonneesJSON);
    }
}