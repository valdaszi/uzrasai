package lt.bta.valdas.uzrasai.tasks;

import android.os.AsyncTask;
import android.widget.BaseAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import lt.bta.valdas.uzrasai.Data;
import lt.bta.valdas.uzrasai.reponse.ListOfEmployeesResponse;

public class RetrieveEmployeesPageTask extends AsyncTask<Void, Void, ListOfEmployeesResponse> {

    private Exception exception;

    private BaseAdapter adapter;
    private int skip;
    private int size;

    public RetrieveEmployeesPageTask(BaseAdapter adapter, int skip, int size) {
        this.adapter = adapter;
        this.skip = skip;
        this.size = size;
    }

    @Override
    protected ListOfEmployeesResponse doInBackground(Void... voids) {
        try {
            URI uri = new URI(
                    "http",
                    null,
                    "172.24.4.16", //"192.168.88.253",
                    8080,
                    "/kokinori/api/employee/list",
                    "skip=" + this.skip + "&size=" + this.size,
                    null
            );
            URL url = uri.toURL();
            System.out.println(url.toString());

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            ListOfEmployeesResponse employeesResponse = null;
//            StringBuilder sb = new StringBuilder();
            try {
//                Reader in = new InputStreamReader(new BufferedInputStream(urlConnection.getInputStream()), "utf-8");
//
//                int b;
//                while ((b = in.read()) != -1) sb.append((char) b);
//                System.out.println("response json: " + sb);

                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());
                employeesResponse = objectMapper.readValue(urlConnection.getInputStream(),
                        ListOfEmployeesResponse.class);

            } finally {
                urlConnection.disconnect();
            }

//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.registerModule(new JavaTimeModule());
//            employeesResponse = objectMapper.readValue(sb.toString(), ListOfEmployeesResponse.class);

            return employeesResponse;

        } catch (Exception e) {
            e.printStackTrace();
            this.exception = e;

            return null;
        }
    }

    @Override
    protected void onPostExecute(ListOfEmployeesResponse employees) {
        if (employees == null) return;

        Data.getInstance().getEmployeesList().addAll(employees);
        this.adapter.notifyDataSetChanged();
    }
}
