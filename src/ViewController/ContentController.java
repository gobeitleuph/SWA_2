package ViewController;

import Content.Folder;
import Content.Content;
import Content.ContentService;



public class ContentController implements CommandController{
    private Content content;
    private Folder folder;
    private Folder folderReturn;

    public ContentController(Content content, Folder folder) {
        this.content = content;
        this.folder = folder;
    }

    @Override
    public void execute(String command) {
        switch (command){
            case "addContentToFolder":{
                ContentService contentService = new ContentService();
                contentService.addContent(content, folder);
                this.folderReturn = contentService.getFolder();
                break;
            }
        }

    }
    public Folder getFolder(){
        return folderReturn;
    }

}
