import java.util.HashMap;
import java.util.Map;

/* once an object is created, we cannot change its content -> Immutable class */

final class Student {  /* -> class should be final */

    //field should be private and final
    private final String name;
    private final int registerNumber;
    private final Map<String, String> score;

    public Student(String name, int registerNumber,
            Map<String, String> score) {

        this.name = name;
        this.registerNumber = registerNumber;

        Map<String, String> tempMap = new HashMap<>();

        for (Map.Entry<String, String> entry : score.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }

        this.score = tempMap; //deep copy
    }

    public String getName() {
        return name;
    }

    public int getregisterNumber() {
        return registerNumber;
    }

    public Map<String, String> getscore() {
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry : this.score.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap; // returning copy instead of object reference
    }

    // there should not be any setters
}


public class ImmutableClass {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("Maths", "A");
        map.put("Science", "A+");

        Student student = new Student("Sakthi", 5, map);

        System.out.println(student.getName());
        System.out.println(student.getregisterNumber());
        System.out.println(student.getscore());

        // compile error since value cannot be modified for the object
        // s.registerNumber = 6;

        map.put("Language", "A+");
        System.out.println(student.getscore()); // will not update and reflect
       
    }
}
