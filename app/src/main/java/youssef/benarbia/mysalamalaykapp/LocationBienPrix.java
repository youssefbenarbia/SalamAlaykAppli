package youssef.benarbia.mysalamalaykapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class LocationBienPrix extends AppCompatActivity {
    private Spinner spinner4;
    private Spinner spinner5;
    private Button secondContinueButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_bien_prix);


        //Récupération du Spinner déclaré dans le fichier main.xml de res/layout
        spinner4 = (Spinner) findViewById(R.id.spinner4);

        //Création d'une liste d'élément à mettre dans le Spinner(pour l'exemple)
        List costsCategory = new ArrayList();
        costsCategory.add("Frais unique");
        costsCategory.add("par nuit");
        costsCategory.add("par personne");
        costsCategory.add("par nuit par personne");

        /*Le Spinner a besoin d'un adapter pour sa presentation alors on lui passe le context(this) et
                un fichier de presentation par défaut( android.R.layout.simple_spinner_item)
        Avec la liste des elements (exemple) */
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                costsCategory
        );


        /* On definit une présentation du spinner quand il est déroulé         (android.R.layout.simple_spinner_dropdown_item) */
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Enfin on passe l'adapter au Spinner et c'est tout
        spinner4.setAdapter(adapter);


        //Récupération du Spinner déclaré dans le fichier main.xml de res/layout
        spinner5 = (Spinner) findViewById(R.id.spinner5);

        //Création d'une liste d'élément à mettre dans le Spinner(pour l'exemple)
        List taxCategory = new ArrayList();
        taxCategory.add("Frais unique");
        taxCategory.add("par nuit");
        taxCategory.add("par personne");
        taxCategory.add("par nuit par personne");

        /*Le Spinner a besoin d'un adapter pour sa presentation alors on lui passe le context(this) et
                un fichier de presentation par défaut( android.R.layout.simple_spinner_item)
        Avec la liste des elements (exemple) */
        ArrayAdapter adapter2 = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                taxCategory
        );


        /* On definit une présentation du spinner quand il est déroulé         (android.R.layout.simple_spinner_dropdown_item) */
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Enfin on passe l'adapter au Spinner et c'est tout
        spinner5.setAdapter(adapter2);


        this.secondContinueButton = (Button) findViewById(R.id.secondContinueButton);





        secondContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), LocationDeBienImages.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}