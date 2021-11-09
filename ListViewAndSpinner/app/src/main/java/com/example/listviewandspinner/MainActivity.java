package com.example.listviewandspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    private ListView citiesList;
    ArrayList<String> cities;
    ArrayAdapter<String> citiesAdapter;

    private Spinner spinnerStudents;
    ArrayList<String> students;
    /*ArrayAdapter<String> studentsAdapter;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        citiesList = findViewById(R.id.listView01);

        addCities();
        citiesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cities);

        //pass the adapter to  the listView
        citiesList.setAdapter(citiesAdapter);

        citiesList.setOnItemClickListener(this);

        spinnerStudents = findViewById(R.id.spinner01);
        students = new ArrayList<String>();

        //dont need to pass it like this i already pass it on the strings.xml file
        /*addStudents();
        studentsAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_dropdown_item, students);
        spinnerStudents.setAdapter(studentsAdapter);*/

        spinnerStudents.setOnItemSelectedListener(this);
    }

    private void addCities() {

        cities = new ArrayList<String>();
        cities.add("Vigo");
        cities.add("Coruña");
        cities.add("Ourense");
        cities.add("Lugo");

    }

    /*private void addStudents() {

        students = new ArrayList<String>();
        students.add("Samuel");
        students.add("Max");
        students.add("Yari");
        students.add("Martin");
       }*/

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, spinnerStudents.getSelectedItem().toString()
                + " selected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}