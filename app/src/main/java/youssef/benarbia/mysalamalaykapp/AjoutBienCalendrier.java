package youssef.benarbia.mysalamalaykapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AjoutBienCalendrier extends AppCompatActivity {
    private Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_bien_calendrier);








        this.saveButton = (Button) findViewById(R.id.saveButton);





        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}