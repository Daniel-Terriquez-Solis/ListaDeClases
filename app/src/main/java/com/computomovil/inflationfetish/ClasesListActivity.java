package com.computomovil.inflationfetish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ClasesListActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clases_list);

        lv = (ListView) findViewById(R.id.idListView);

        List<Clase> clases = new ArrayList<>();
        clases.add(new Clase(0, "Clase 1", 7, 8, true, true));
        clases.add(new Clase(1, "Clase 2", 8, 9, true, true));
        clases.add(new Clase(2, "Clase 3", 9, 10, false, true));
        clases.add(new Clase(3, "Clase 4", 10, 11, true, true));
        clases.add(new Clase(4, "Clase 5", 11, 12, false, false));
        clases.add(new Clase(5, "Clase 6", 12, 13, false, false));
        clases.add(new Clase(6, "Clase 7", 13, 14, false, false));

        BaseAdapter adapter = new AdapterClase(clases, this);

        lv.setAdapter(adapter);
    }
}