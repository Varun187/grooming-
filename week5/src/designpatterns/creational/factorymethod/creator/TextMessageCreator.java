package designpatterns.creational.factorymethod.creator;

import designpatterns.creational.factorymethod.product.Message;
import designpatterns.creational.factorymethod.product.TextMessage;

/**
 * Provides implementation for creating Text messages
 */
public class TextMessageCreator extends MessageCreator {

	@Override
	public Message createMessage() {
		return new TextMessage();
	}



}
