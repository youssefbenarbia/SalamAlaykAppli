package youssef.benarbia.mysalamalaykapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AjoutBienEquipements extends AppCompatActivity {
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_bien_equipements);


        this.continueButton = (Button) findViewById(R.id.continueButton);





        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), AjoutBienCalendrier.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}