package Content;


/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public class File implements Content {

	private String name;

	public File(){

	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}//end File