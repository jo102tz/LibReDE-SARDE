package algorithms;

import net.sf.javaml.core.Instance;

public class InstanceWrapper {
	
	private final Instance instance;
	private final int id;
	
	public InstanceWrapper(Instance instance, int id) {
		this.instance = instance;
		this.id = id;
	}

	public Instance getInstance() {
		return instance;
	}

	public int getId() {
		return id;
	}

}
