package youssef.benarbia.mysalamalaykapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LocationDeBienImages extends AppCompatActivity {
    private Button thirdContinueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_de_bien_images);



        this.thirdContinueButton = (Button) findViewById(R.id.thirdContinueButton);





        thirdContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), AjoutBienDetails.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}