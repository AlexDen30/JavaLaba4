
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        ArrayList<Worker> workers = ReadCSV.makeList("foreign_names.csv");

        for (Worker w: workers
             ) {
            System.out.println(w.getId() + ";" + w.getName() + ";" + w.getGender()
                    + ";" + w.getSalary() + ";" + w.getBirthDate() + ";" + w.getDivision());
        }


    }
}
