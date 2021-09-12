package Content;


import java.util.ArrayList;
import java.util.List;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public class Folder extends Content {

	private String name;
	private List<Content> folderContentList;

	public Folder(String name){
		this.name = name;
		this.folderContentList = new ArrayList<>();
	}

	public void addContent(Content content) {
		folderContentList.add(content);
	}

	public void removeContent(Content content) {
		folderContentList.remove(content);
	}


	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return super.name;
	}
}//end Folder