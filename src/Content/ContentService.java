package Content;


/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public class ContentService {

	public ContentService(){

	}

	/**
	 *
	 * @param content
	 */
	public boolean addContent(Content content, Folder folder){
		folder.addContent(content);

		return true;
	}
}//end ContentService