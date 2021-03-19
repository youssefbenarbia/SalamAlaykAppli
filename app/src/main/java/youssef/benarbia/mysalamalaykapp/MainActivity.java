package youssef.benarbia.mysalamalaykapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button log_In;
    private TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.log_In = (Button) findViewById(R.id.log_In);





        log_In.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.text2 = (TextView) findViewById(R.id.text2);

        text2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });



    }
}