package threads;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerialzation {

    public static void main(String[] args) {
        Employee emp = null;

        try (FileInputStream fileIn = new FileInputStream("employee.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            emp = (Employee) in.readObject();
            System.out.println("Deserialized Employee...");
            System.out.println("Name: " + emp.getName());
            System.out.println("ID: " + emp.getId());
            System.out.println("Salary: " + emp.getSalary());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
