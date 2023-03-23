package Modifiers.package1;

public class Parent {
    private String occupation;
    private String secret;

    public Parent() {
    }

    public Parent(String occupation, String secret) {
        this.occupation = occupation;
        this.secret = secret;
    }

    void show(){
        System.out.println("default method");
    }

    protected String getSecret(){
        System.out.println("protected method");
        return this.secret;
    }
    
    public String getOccupation(){
        System.out.println("public method");
        return this.occupation;
    }
}
