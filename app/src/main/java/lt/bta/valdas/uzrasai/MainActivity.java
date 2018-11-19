package lt.bta.valdas.uzrasai;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lt.bta.valdas.uzrasai.reponse.ListOfEmployeesResponse;
import lt.bta.valdas.uzrasai.tasks.RetrieveEmployeesPageTask;

public class MainActivity extends AppCompatActivity {

    BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.adapter = new EmployeesListAdapter(this, Data.getInstance().getEmployeesList());

        final ListView listView = findViewById(R.id.musuListas);
        listView.setAdapter(adapter);

        FloatingActionButton addButton = findViewById(R.id.floatingActionButtonAdd);
        addButton.setOnClickListener(this::onAdd);

        newPage();
    }

    void onAdd(View view) {
//        Client client = ClientBuilder.newClient();
//
//        WebTarget apiBase = client.target("http://localhost:8080/kokinori/api");
//        WebTarget apiEmployee = apiBase.path("employee");
//        WebTarget apiEmployeeList = apiEmployee.path("list?skip={skip}&size={size}");
//
//        Response response = apiEmployeeList
//                .resolveTemplate( "skip", 0)
//                .resolveTemplate( "size", 10)
//                .request(MediaType.APPLICATION_JSON)
//                .get();
//
//        if (response.getStatus() != 200) {
//
//        }
//
//        ListOfEmployeesResponse employeesResponse = response.readEntity(ListOfEmployeesResponse.class);
//        System.out.println("Employees received: " + employeesResponse.size());

        newPage();
    }

    int size = 10;
    int skip = 0;

    void newPage() {
        new RetrieveEmployeesPageTask(this.adapter, this.skip, this.size).execute();
        this.skip = this.skip + this.size;
    }
}
