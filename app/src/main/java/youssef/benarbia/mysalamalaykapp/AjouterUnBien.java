package youssef.benarbia.mysalamalaykapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AjouterUnBien extends AppCompatActivity {
    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;
    private Button continueButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_un_bien);

        //Récupération du Spinner déclaré dans le fichier main.xml de res/layout
        spinner = (Spinner) findViewById(R.id.spinner);

        //Création d'une liste d'élément à mettre dans le Spinner(pour l'exemple)
        List firstCategory = new ArrayList();
        firstCategory.add("Aucun");
        firstCategory.add("Villa");
        firstCategory.add("Maison");
        firstCategory.add("Appartement");
        firstCategory.add("Dortoir");
        firstCategory.add("Cabine");
        firstCategory.add("Condos");
        firstCategory.add("B & B");


        /*Le Spinner a besoin d'un adapter pour sa presentation alors on lui passe le context(this) et
                un fichier de presentation par défaut( android.R.layout.simple_spinner_item)
        Avec la liste des elements (exemple) */
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                firstCategory
        );


        /* On definit une présentation du spinner quand il est déroulé         (android.R.layout.simple_spinner_dropdown_item) */
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Enfin on passe l'adapter au Spinner et c'est tout
        spinner.setAdapter(adapter);



        //Récupération du Spinner déclaré dans le fichier main.xml de res/layout
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        //Création d'une liste d'élément à mettre dans le Spinner(pour l'exemple)
        List secondCategory = new ArrayList();
        secondCategory.add("Aucun");
        secondCategory.add("Chambre Privée");
        secondCategory.add("Entire Home");
        secondCategory.add("Pièce partagée");
        secondCategory.add("Private Room");
        secondCategory.add("Shared Room");

        /*Le Spinner a besoin d'un adapter pour sa presentation alors on lui passe le context(this) et
                un fichier de presentation par défaut( android.R.layout.simple_spinner_item)
        Avec la liste des elements (exemple) */
        ArrayAdapter adapter2 = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                secondCategory
        );


        /* On definit une présentation du spinner quand il est déroulé         (android.R.layout.simple_spinner_dropdown_item) */
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Enfin on passe l'adapter au Spinner et c'est tout
        spinner2.setAdapter(adapter2);





        //Récupération du Spinner déclaré dans le fichier main.xml de res/layout
        spinner3 = (Spinner) findViewById(R.id.spinner3);

        //Création d'une liste d'élément à mettre dans le Spinner(pour l'exemple)
        List totalCapacity = new ArrayList();
        totalCapacity.add("0");
        totalCapacity.add("1");
        totalCapacity.add("1");
        totalCapacity.add("2");
        totalCapacity.add("3");
        totalCapacity.add("4");

        /*Le Spinner a besoin d'un adapter pour sa presentation alors on lui passe le context(this) et
                un fichier de presentation par défaut( android.R.layout.simple_spinner_item)
        Avec la liste des elements (exemple) */
        ArrayAdapter adapter3 = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                totalCapacity
        );


        /* On definit une présentation du spinner quand il est déroulé         (android.R.layout.simple_spinner_dropdown_item) */
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Enfin on passe l'adapter au Spinner et c'est tout
        spinner3.setAdapter(adapter3);

        this.continueButton = (Button) findViewById(R.id.continueButton);





        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), LocationBienPrix.class);
                startActivity(otherActivity);
                finish();
            }
        });


    }
}