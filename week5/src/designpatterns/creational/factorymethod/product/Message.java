package designpatterns.creational.factorymethod.product;

/**
 * This class represents interface for our "product" which is a message
 * Implementations will be specific to content type.
 *
 */
public abstract class Message {

	public abstract String getContent();
	
	public void addDefaultHeaders() {
		//some default headers
	}
	
	public void encrypt() {
		//some code to encrypt the content
	}
	
}
