class Parameterized {
    int id;
    String studentName;

    Parameterized(String name, int id) {
        this.id = id;
        this.studentName = name;
    }
}

class NoArgument {
    int id;
    String studentName;

    NoArgument() {
    }
}

class DefaultConstructor {
    int id;
    String studentName;
    // default constructor is provided by java
}

class ConstructorOverloading {
    int id;
    String studentName;

    ConstructorOverloading(String name) {
        this.studentName = name;
    }
   

    ConstructorOverloading(String name, int id) {
        this.id = id;
        this.studentName = name;
    }
}

public class Constructor {
    public static void main(String[] args) {
        // This would invoke the parameterized constructor.
        Parameterized student = new Parameterized("Sakthi", 1);
        System.out.println("StudentName :" + student.studentName + " and StudentId :" + student.id);
    }
}

