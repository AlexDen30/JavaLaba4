
import java.util.ArrayList;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadCSV {



    /**
     * Создает Worker по значениям, считанным из очередной строки
     * @param parsedStr - распарсенная строка из файла
     * @param divisions - список подразделений
     * @return Worker
     */
    static private Worker createWorker(String[] parsedStr, ArrayList<Division> divisions){

        Worker worker = new Worker();

        worker.setId(Integer.parseInt(parsedStr[0]));
        worker.setName(parsedStr[1]);
        worker.setGender(parsedStr[2]);
        worker.setBirthDate(parsedStr[3]);
        worker.setDivision(findDivision(divisions, parsedStr[4]));
        worker.setSalary(Integer.parseInt(parsedStr[5]));

        return worker;
    }


    //для генерации id
    static private int id = 0;
    /**
     * Ищет в текущих подразделениях, если такого нет, создает новое
     * @param currentDivisions - список подразделений
     * @param division - искомое подразделение
     * @return объект с искомым подразделением
     */
    static private Division findDivision(List<Division> currentDivisions, String division){

        Division found = currentDivisions
                .stream()
                .filter(a -> division.equals(a.getDivisionName())).findFirst()
                .orElse(null);

        if (found == null) {
            found = new Division();
            found.setDivisionName(division);
            found.setId(id);
            currentDivisions.add(found);
            id++;
        }
        return found;
    }

    /**
     * Считывание из файла и формирование списка
     * @param FilePath - путь к файлу
     * @return список Worker
     */

    static public ArrayList<Worker> makeList(String FilePath) {

        ArrayList<Worker> workers = new ArrayList<Worker>();
        ArrayList<Division> divisions = new ArrayList<Division>();

        try (InputStream in = Main.class.getClassLoader().getResourceAsStream("foreign_names.csv");
             CSVReader reader = in == null ? null : new CSVReader(new InputStreamReader(in), ';')) {
            if (reader == null) {
                throw new FileNotFoundException("foreign_names.csv");
            }
            String[] nextLine;
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                workers.add(createWorker(nextLine, divisions));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return workers;
    }


}
