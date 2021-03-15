package youssef.benarbia.mysalamalaykapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button mise_en_location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.mise_en_location = (Button) findViewById(R.id.mise_en_location);

        mise_en_location.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), AjouterUnBien.class);
                startActivity(otherActivity);
                finish();
            }
        });

    }
}