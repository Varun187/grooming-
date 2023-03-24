//used in single threaded environment since it is not thread safe

public class StringBuilderExample {

    public static void main(String[] arg) throws Exception {
        StringBuilder str = new StringBuilder();

        str.append("Sakthi");
        str.append("kumar");
        str.insert(1, "-");
        System.out.println("String = " + str.toString() + " length = " + str.length());
        str.reverse();

        StringBuilder str1 = new StringBuilder("Testing");
        System.out.println("String1 = " + str1.toString());

        StringBuilder str2 = new StringBuilder(10);
        System.out.println("String2 capacity = "+ str2.capacity());

        StringBuilder str3 = new StringBuilder(str1.toString());
        System.out.println("String3 = " + str3.toString());
    }
}
