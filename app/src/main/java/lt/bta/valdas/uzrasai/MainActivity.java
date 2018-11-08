package lt.bta.valdas.uzrasai;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final ArrayAdapter adapter = new ArrayAdapter<Irasas>(this,
//                R.layout.activity_listview, Duomenys.getInstance().getSarasas());

        final BaseAdapter adapter = new SarasasAdapter(this, Duomenys.getInstance().getSarasas());

        final ListView listView = findViewById(R.id.musuListas);
        listView.setAdapter(adapter);

        FloatingActionButton addButton = findViewById(R.id.floatingActionButtonAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Irasas naujas = new Irasas();
                naujas.setPavadinimas("Abrikosas" + Duomenys.getInstance().getSarasas().size());
                Duomenys.getInstance().getSarasas().add(naujas);

                adapter.notifyDataSetChanged();
            }
        });
    }

    void onAdd(View view) {
        //TODO
    }
}
