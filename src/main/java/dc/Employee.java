package dc;

/**
 * Klasa pracownika, ktora implementuje interfejs Comparable (co pozwala porownywac pracownikow)
 */
public class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private double salary;
    private String job;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public String getJob() {
        return job;
    }

    /**
     * Konstruktor klasy Employee
     * @param firstName imie pracownika
     * @param lastName nazwisko pracownika
     * @param salary pensja pracownika w PLN
     * @param job zawod pracownika
     */
    public Employee(String firstName, String lastName, double salary, String job) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.job = job;
    }

    /**
     * Metoda sluzaca do wyznaczenia ktory pracownik jest 'mniejszy' (decyduje nazwisko a jak jest takie samo, to decyduje imie)
     * @param o porownywany drugi pracownik
     * @return -1 jesli pracownik jest alfabetycznie mniejszy od porownywanego pracownika, 1 jak jest wiekszy i 0 jak sa rowni
     */
    @Override
    public int compareTo(Employee o) {
        int res = this.lastName.compareTo(o.lastName);
        if (res != 0)
            return res;
        else
            return this.firstName.compareTo(o.firstName);
    }
    @Override
    public String toString() {
        return firstName + "." + lastName + " " + job;
    }
}
