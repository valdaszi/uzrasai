package lt.bta.valdas.uzrasai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import lt.bta.valdas.uzrasai.entity.Employee;

public class EmployeesListAdapter extends BaseAdapter {

    private List<Employee> employeeList;
    private static LayoutInflater inflater = null;

    public EmployeesListAdapter(Context context, List<Employee> employeeList) {
        this.employeeList = employeeList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return employeeList.size();
    }

    @Override
    public Object getItem(int position) {
        return employeeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return employeeList.get(position).getEmpNo();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null) {
            vi = inflater.inflate(R.layout.activity_listview, parent, false);
        }

        Employee employee = employeeList.get(position);

        TextView labelNr = vi.findViewById(R.id.textViewNr);
        labelNr.setText(String.valueOf(position + 1));

        TextView labelName = vi.findViewById(R.id.textViewName);
        labelName.setText(employee.getFirstName() + " " + employee.getLastName());

        TextView labelBirthDate = vi.findViewById(R.id.textViewBirthDate);
        labelBirthDate.setText(employee.getBirthDate().toString());

        return vi;
    }
}
