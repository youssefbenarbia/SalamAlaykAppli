package youssef.benarbia.mysalamalaykapp;

import android.os.Bundle;
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
    private EditText txtPass;
    private EditText txtEmail;
    private EditText txtUser_NiceName;
    private Controle controle;
    private Button btnCreerCompte;

    /**
     * initialisation des liens avec les objets graphiques
     */
    private void init() {
        txtLogin = (EditText)findViewById(R.id.txtUser_Login);
        txtPass = (EditText)findViewById(R.id.txtUser_Pass);
        txtUser_NiceName = (EditText)findViewById(R.id.txtUser_NiceName);
        txtEmail = (EditText)findViewById(R.id.txtUser_Email);
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
                //Toast.makeText(RegistrationActivity.this, "test", Toast.LENGTH_SHORT).show();

                Integer user_login =  null;
                Integer user_pass = null;
                Integer user_nicename = null;
                Integer user_email = null;
                //récupération des données saisies
                try {
                    user_login = Integer.parseInt(txtLogin.getText().toString());
                    user_pass = Integer.parseInt(txtPass.getText().toString());
                    user_nicename = Integer.parseInt(txtUser_NiceName.getText().toString());
                    user_email = Integer.parseInt(txtEmail.getText().toString());
                }catch (Exception e) {};

                //controle des données saisies :
                if (user_login==null || user_pass==null || user_nicename==null || user_email==null ) {
                    Toast.makeText(RegistrationActivity.this, "Saisie incorrecte", Toast.LENGTH_SHORT).show();
                }else{
                    afficheResult(user_login,user_pass,user_nicename,user_email);
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

    private void afficheResult(Integer user_login, Integer user_pass, Integer user_nicename, Integer user_email) {
        //création du profile et récupération des informations
        this.controle.creerProfil(user_login, user_pass, user_nicename, user_email,this);
        //String message = this.controle.getMessage();
        //affichage
    }

    /**
     * récupération du profil s'il à été serializé
     */
    private void recupProfil() {
        if(controle.get_email() != null) {
            txtEmail.setText(controle.get_email().toString());
            txtLogin.setText(controle.get_Login().toString());
        }
        //simule le clic sur le bouton créer un click
        ((Button)findViewById(R.id.btnCreerCompte)).performClick();
    }


}