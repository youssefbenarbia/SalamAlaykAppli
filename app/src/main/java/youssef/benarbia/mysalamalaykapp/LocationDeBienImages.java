package youssef.benarbia.mysalamalaykapp;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Gallery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LocationDeBienImages extends AppCompatActivity {
    //déclaration des champs privé de la classe
    private Button thirdContinueButton;
    private ImageView inseredImage;
    private Button insertionButton;
    private int GALLERY_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_de_bien_images);

        //initialisation des vues
        this.inseredImage = findViewById(R.id.imageView2);
        this.insertionButton = findViewById(R.id.button3);


        //si on clique sur le bouton d'insertion :
        insertionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "pick an image"), GALLERY_REQUEST_CODE);


            }
        });




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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data !=null) {
            Uri imageData = data.getData();

            inseredImage.setImageURI(imageData);
        }
    }
}