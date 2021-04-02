package youssef.benarbia.mysalamalaykapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();
    }

    //propriétés
    private EditText txtLogin;
    private EditText txtUser_Pass;
    private EditText txtUser_Email;
    private EditText txtUser_NiceName;
    private Controle controle;

    /**
     * initialisation des liens avec les objets graphiques
     */
    private void init() {
        txtLogin = (EditText)findViewById(R.id.txtLogin);
        txtUser_Pass = (EditText)findViewById(R.id.txtUser_Pass);
        txtUser_NiceName = (EditText)findViewById(R.id.txtUser_NiceName);
        txtUser_Email = (EditText)findViewById(R.id.txtUser_Email);
        this.controle = Controle.getInstance(this);
        ecouteCreerCompte();
        //recupProfil();
    }

    /**
     * Ecoute événement sur bouton
     */

    private void ecouteCreerCompte() {
        ((Button) findViewById(R.id.btnCreerCompte)).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(RegistrationActivity.this, "test", Toast.LENGTH_SHORT).show();
                String user_login =  null;
                String user_pass = null;
                String user_nicename = null;
                String user_email = null;
                //récupération des données saisies
                try {
                    user_login = txtLogin.getText().toString();
                    user_pass = txtUser_Pass.getText().toString();
                    user_nicename = txtUser_NiceName.getText().toString();
                    user_email = txtUser_Email.getText().toString();
                }catch (Exception e) {};

                //controle des données saisies :
                if (user_login==null || user_pass==null || user_nicename==null || user_email==null ) {
                    Toast.makeText(RegistrationActivity.this, "Saisie incorrecte", Toast.LENGTH_SHORT).show();
                    Toast.makeText(RegistrationActivity.this, user_email, Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(RegistrationActivity.this, "Saisie correcte", Toast.LENGTH_SHORT).show();
                    Toast.makeText(RegistrationActivity.this, user_login, Toast.LENGTH_SHORT).show();
                    afficheResult(user_login,user_nicename,user_email,user_pass);
                }
            }
        });
    }

    /**
     * Affichage des paramètres : login, pass, nicename et email
     * @param user_login
     * @param user_pass
     * @param user_nicename
     * @param user_email
     */

    private void afficheResult(String user_login, String user_nicename, String user_email,String user_pass) {
        //création du profile et récupération des informations
        this.controle.creerProfil(user_login, user_nicename, user_email, user_pass, this);
        Log.d("serveur", "++++"+user_login);

        Toast.makeText(RegistrationActivity.this, user_nicename, Toast.LENGTH_SHORT).show();
        //String message = this.controle.getMessage();
        //affichage
    }

    /**
     * récupération du profil s'il à été serializé
     */
    private void recupProfil() {
        if(controle.get_email() != null) {
            txtUser_Email.setText(controle.get_email().toString());
            txtLogin.setText(controle.get_login().toString());
        }
        //simule le clic sur le bouton créer un click
        //((Button)findViewById(R.id.btnCreerCompte)).performClick();
    }


}