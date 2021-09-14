package ViewController;

import Resource.Car;
import Resource.ResourceSelection;
import Resource.ResourceService;

import java.math.BigDecimal;

public class ResourceController implements CommandController{
    private String label;
    private BigDecimal price;
    private Boolean availability;
    private ResourceSelection resource;
    private ResourceSelection combination;

    public ResourceController(ResourceSelection resource) {
        this.resource = resource;
    }

    @Override
    public void execute(String command) {
        switch (command){
            case "selectResourceChildSeat":{
                ResourceService resourceService = new ResourceService();
                resourceService.getSelectedResource("ChildSeat",new BigDecimal("20"),true, resource);
                this.combination = resourceService.getResource();
                break;
            }
            case "selectResourceSetTopBox":{
                ResourceService resourceService = new ResourceService();
                resourceService.getSelectedResource("SetTopBox",new BigDecimal("30"),true, resource);
                this.combination = resourceService.getResource();
                break;
            }
        }

    }
    public ResourceSelection getCombination(){
        return combination;
    }
}
