/* StringBuilder class differs from the StringBuffer class on the basis of synchronization. 
The StringBuilder  -> no synchronization whereas the StringBuffer -> provides synchronization */

public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Real");
        stringBuffer.append("world");
        stringBuffer.replace(0, 3, "Hello");
        System.out.println(stringBuffer.toString());
    }
}
