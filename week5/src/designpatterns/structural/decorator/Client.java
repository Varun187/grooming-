package designpatterns.structural.decorator;

public class Client {

	public static void main(String[] args) {
		Message m = new TextMessage("This is decorator pattern!");
		System.out.println(m.getContent());
		
		Message decorator = new Base64EncodedMessage(m);
		System.out.println(decorator.getContent());
	}
}
