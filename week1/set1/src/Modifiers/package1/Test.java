package Modifiers.package1;

public class Test {
    public static void main(String[] args) {
        Parent parent = new Parent("Software developer", "Mysecret");
        parent.getOccupation();
        parent.getSecret();
        parent.show();
        /* System.out.println(parent.secret); -> private variable*/
    }
}
