

public class Worker {

    private int id;
    private String name;
    private String gender;
    private String birthDate;
    private Division division;
    private int salary;

    //id get set
    public int getId () {
        return this.id;
    }

    public void setId (int id) {
        this.id = id;
    }

    //salary get set
    public int getSalary () {
        return this.salary;
    }

    public void setSalary (int salary) {
        this.salary = salary;
    }

    //gender get set
    public String getGender () {
        return this.gender;
    }

    public void setGender (String gender) {
        this.gender = gender;
    }

    //name get set
    public String getName () {
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }

    //birth date get set
    public String getBirthDate () {
        return this.birthDate;
    }

    public void setBirthDate (String birthDate) {
        this.birthDate = birthDate;
    }

    //division get set
    public Division getDivision () {
        return this.division;
    }

    public void setDivision (Division division) {
        this.division = division;
    }

}
