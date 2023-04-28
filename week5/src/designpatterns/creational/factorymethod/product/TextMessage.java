package designpatterns.creational.factorymethod.product;

public class TextMessage extends Message {
	
	@Override
	public String getContent() {
		return "Text";
	}
	
}
