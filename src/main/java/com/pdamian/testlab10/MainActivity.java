package com.pdamian.testlab10;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener
{

    Spinner spinnerIlosc;
    Spinner spinnerKolor;
    TextView textViewResult;
    static public String pkolor ="#000000";
    static public String pilosc ="0";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerIlosc = (Spinner) findViewById(R.id.spinnerIlosc);
        spinnerKolor = (Spinner) findViewById(R.id.spinnerKolor);

       
        ArrayAdapter<CharSequence> adapterTime = ArrayAdapter.createFromResource(this, R.array.iloscT, android.R.layout.simple_spinner_item);
        adapterTime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      
        spinnerIlosc.setAdapter(adapterTime);

        
        ArrayAdapter<CharSequence> adapterPriority = ArrayAdapter.createFromResource(this, R.array.koloryT, android.R.layout.simple_spinner_item);
        adapterPriority.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      
        spinnerKolor.setAdapter(adapterPriority);

      
        spinnerIlosc.setOnItemSelectedListener(this);
        spinnerKolor.setOnItemSelectedListener(this);
    }

   
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        Toast.makeText(getApplicationContext(), "START", Toast.LENGTH_SHORT).show();
       
        pilosc = spinnerIlosc.getSelectedItem().toString();
        String kolor = spinnerKolor.getSelectedItem().toString();

        
        switch (kolor)
        {
            case "Nibieski":
                pkolor = "#0000FF";
                break;
            case "Czerwony":
                pkolor = "#FF0000";
                break;
            case "Zielony":
                pkolor = "#00ff00";
                break;
            case "Czarny":
                pkolor = "#000000";
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

}