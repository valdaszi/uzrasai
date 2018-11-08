package lt.bta.valdas.uzrasai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SarasasAdapter extends BaseAdapter {

    private List<Irasas> duomenys;
    private static LayoutInflater inflater = null;

    public SarasasAdapter(Context context, List<Irasas> duomenys) {
        this.duomenys = duomenys;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return duomenys.size();
    }

    @Override
    public Object getItem(int position) {
        return duomenys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null) {
            vi = inflater.inflate(R.layout.activity_listview, null);
        }
        TextView label = vi.findViewById(R.id.irasasPavadinimas);
        label.setText(duomenys.get(position).getPavadinimas());
        return vi;
    }
}
