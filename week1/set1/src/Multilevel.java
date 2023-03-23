/* 3.	Write a java program to implement multilevel inheritance with 4 levels of hierarchy. */

class ASDE {
    public void basicFunctionality() {
        System.out.println("can code and design");
    }
}

class SDE1 extends ASDE {
    public void ownership() {
        System.out.println("has ownership of modules and components");
    }
}

class SDE2 extends SDE1 {
    public void ownership() {
        System.out.println("has ownership of modules and components and subsystem integration");
    }

    public void carrierPath() {
        System.out.println("carrier progression alternatives are possible for SDE2. Either can become SDE3 or SDM");
    }

}

class SDE3 extends SDE2 {
    public void ownership() {
        System.out.println("has ownership of modules and components and End to end integration");
    }

    public void carrierPath() {
        System.out.println("Has to follow developer path since SDE3 is chosen");
    }
}


public class Multilevel {
    public static void main(String[] args) {

        ASDE asde = new ASDE();
        asde.basicFunctionality();

        SDE2 sde2 = new SDE2();
        sde2.ownership();
        sde2.carrierPath();

    }
}
