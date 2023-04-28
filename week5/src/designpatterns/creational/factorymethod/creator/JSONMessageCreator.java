package designpatterns.creational.factorymethod.creator;

import designpatterns.creational.factorymethod.product.JSONMessage;
import designpatterns.creational.factorymethod.product.Message;

/**
 * Provides implementation for creating JSON messages
 */
public class JSONMessageCreator extends MessageCreator {

	@Override
	public Message createMessage() {
		return new JSONMessage();
	}

	
}
