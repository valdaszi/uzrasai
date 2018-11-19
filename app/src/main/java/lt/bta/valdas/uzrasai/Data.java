package lt.bta.valdas.uzrasai;

import java.util.ArrayList;
import java.util.List;

import lt.bta.valdas.uzrasai.entity.Employee;

public final class Data {

    private List<Employee> employeesList;

    private static Data data;

    public static Data getInstance() {
        if (data == null) {
            data = new Data();
            data.employeesList = new ArrayList<>();
        }
        return data;
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }
}
