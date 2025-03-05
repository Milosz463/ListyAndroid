package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
private ListView listViewProdukty;
private ArrayList<String>produkty=new ArrayList<>();
private ArrayAdapter<String>arrayAdapter;
private Button button;
private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        produkty.add("Marchewka");
        produkty.add("Buraki");
        produkty.add("Ziemniaki");
        produkty.add("Kapusta");

        arrayAdapter=new ArrayAdapter<>(MainActivity2.this, android.R.layout.simple_list_item_1,produkty);

        listViewProdukty=findViewById(R.id.listView2);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editTextProdukt);

        listViewProdukty.setAdapter(arrayAdapter);

        listViewProdukty.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        produkty.remove(i);
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
        );
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        produkty.add(editText.getText().toString());
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
        );
    }
