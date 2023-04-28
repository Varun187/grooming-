package designpatterns.creational.factorymethod;

import designpatterns.creational.factorymethod.creator.JSONMessageCreator;
import designpatterns.creational.factorymethod.creator.MessageCreator;
import designpatterns.creational.factorymethod.creator.TextMessageCreator;
import designpatterns.creational.factorymethod.product.Message;

public class Client {

	public static void main(String[] args) {
		printMessage(new JSONMessageCreator());
		
		printMessage(new TextMessageCreator());
	}
	
	public static void printMessage(MessageCreator creator) {
		Message msg = creator.getMessage();
		System.out.println(msg);
	}
}
