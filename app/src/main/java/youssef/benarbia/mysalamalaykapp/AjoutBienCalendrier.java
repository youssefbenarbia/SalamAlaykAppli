package youssef.benarbia.mysalamalaykapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;

public class AjoutBienCalendrier extends AppCompatActivity {
    private Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_bien_calendrier);

        Date today = new Date();
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        CalendarPickerView datePicker = findViewById(R.id.calendar);
        datePicker.init(today, nextYear.getTime())
                .inMode(CalendarPickerView.SelectionMode.RANGE)
                .withSelectedDate(today);

        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                //String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(date);
                Calendar calSelected = Calendar.getInstance();
                calSelected.setTime(date);
                String selectedDate = "" + calSelected.get(Calendar.DAY_OF_MONTH)
                        + " " + (calSelected.get(Calendar.MONTH) + 1)
                        + " " + calSelected.get(Calendar.YEAR);
                Toast.makeText(AjoutBienCalendrier.this, selectedDate, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onDateUnselected(Date date) {
            }
        });


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