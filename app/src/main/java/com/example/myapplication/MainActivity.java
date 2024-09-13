package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ListView lv1;
    TextView tv1;
    String proyectos[] = {"Proyecto 1", "Proyecto 2", "Proyecto 3", "Proyecto 4"};
    String presupuesto[] = {"100000", "500000", "180000", "200000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            lv1 =  findViewById(R.id.tvListado);
            tv1 = findViewById(R.id.tvInfo);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, proyectos);
            lv1.setAdapter(adapter);

            Intent i = new Intent(this, InfoActivity.class);


            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    tv1.setText("Presupuesto: $"+presupuesto[position]);
                    i.putExtra("proy", proyectos[position]);
                    i.putExtra("pres", presupuesto[position]);
                    startActivity(i);
                }
            });


            return insets;
        });
    }
}