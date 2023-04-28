package designpatterns.creational.abstractfactory.aws;

import designpatterns.creational.abstractfactory.Instance;
import designpatterns.creational.abstractfactory.Instance.Capacity;
import designpatterns.creational.abstractfactory.ResourceFactory;
import designpatterns.creational.abstractfactory.Storage;
//Factory implementation for Google cloud platform resources
public class AwsResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance(Capacity capacity) {
		return new Ec2Instance(capacity);
	}

	@Override
	public Storage createStorage(int capMib) {
		return new S3Storage(capMib);
	}


}
