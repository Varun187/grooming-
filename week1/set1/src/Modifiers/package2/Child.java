package Modifiers.package2;

import Modifiers.package1.Parent;

public class Child extends Parent{
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.getOccupation();
        
        /* parent.getSecret(); compile error*/
        /* new Child().show; compile error - default method*/
        
        new Child().getSecret();
    }
}
