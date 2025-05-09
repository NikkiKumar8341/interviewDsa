package threads;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerailZationClass {

    public static void main(String[] args) {
        Employee emp = new Employee("John Doe", 101, 50000.0);

        try (FileOutputStream fileOut = new FileOutputStream("employee.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(emp);
            System.out.println("Serialized data is saved in employee.ser");

        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
