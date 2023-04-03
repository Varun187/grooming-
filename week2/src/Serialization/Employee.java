package Serialization;

import java.io.*;

//Only non-static data members get serialized.
public class Employee implements Serializable {
    String name;
    int id;
    transient int age;

    public Employee(String name, int id, int age) {
        System.out.println("constructor called");
        this.name = name;
        this.id = id;
        this.age = age;
    }
}

//While deserialization, the constructor of the object is not called
class Persist {
    public static void main(String args[]) {

        // Serialization
        try {
            Employee emp = new Employee("Sakthi", 123, 23);

            FileOutputStream fout = new FileOutputStream("file.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);

            out.writeObject(emp);
            out.flush();
            out.close();
            System.out.println("Serialization successful");
        }

        catch (Exception e) {
            System.out.println(e);
        }

        Employee emp1 = null;

        // Deserialization
        try {
            FileInputStream fin = new FileInputStream("file.txt");
            ObjectInputStream in = new ObjectInputStream(fin);

            emp1 = (Employee) in.readObject();
            in.close();

            System.out.println("Deserialization successful");
            System.out.println("Name: " + emp1.name);
            System.out.println("id: " + emp1.id);
            System.out.println("age: " + emp1.age);
        }

        catch (IOException ex) {
            System.out.println("IOException ");
        }

        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException");
        }
    }
}
