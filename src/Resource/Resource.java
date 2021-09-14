package Resource;


/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public abstract class Resource implements ResourceSelection {

	protected ResourceSelection resource;

	public Resource(ResourceSelection resource){
		this.resource = resource;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end Resource