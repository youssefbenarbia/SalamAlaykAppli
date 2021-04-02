package youssef.benarbia.mysalamalaykapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    // propriétés
    private Button signIn_Button;
    private EditText password_Login;
    private EditText user_Login;
    private TextView registration;
    private Controle controle;
    private AccesDistant accesDistant;
    /**
     * initialisation des liens avec les objets graphiques
     */
    private void init() {
        this.signIn_Button = (Button) findViewById(R.id.log_In);
        this.user_Login = (EditText) findViewById(R.id.userLogin);
        this.password_Login = (EditText) findViewById(R.id.userPassConnexion);
        this.registration = (TextView) findViewById(R.id.text2);
        ecouteConnexionCompte();
        ecouteRegister();
    }


    /**
     * ecoute evenement de connexion
     */
    private void ecouteConnexionCompte() {
        signIn_Button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                Intent otherActivity = new Intent(getApplicationContext(), MenuActivity.class);

                String user_login =  null;
                String user_pass = null;


                //récupération des données saisies
                try {
                    user_login = user_Login.getText().toString();
                    user_pass = password_Login.getText().toString();
                }catch (Exception e) {};

                RecupLogs(user_login, user_pass);




                //controle des données saisies
                if (user_login.equals("admin") && user_pass.equals("admin")) {
                    Toast.makeText(MainActivity.this, "Saisie correcte", Toast.LENGTH_SHORT).show();
                    startActivity(otherActivity);
                    finish();
                }
                //correct password
                else {
                    Toast.makeText(MainActivity.this, "nom d'utilisateur ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    /**
     * ecoute evenement de création compte
     */

    private void ecouteRegister() {
        registration.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }

    /**
     * récupère les logs de l'utilisateur
     * @param user_login
     * @param user_pass
     */
    private void RecupLogs(String user_login, String user_pass) {
        this.controle.getInstanceConnection(user_login, user_pass, this);

        Log.d("serveur", "++++"+user_login);
    }


    public JSONArray logsBDD() {
        List laListe = new ArrayList();

        laListe.add(user_login);
        laListe.add(user_pass);

        return new JSONArray(laListe);
    }
}