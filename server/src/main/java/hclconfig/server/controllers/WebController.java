package hclconfig.server.controllers;

import hclconfig.server.services.WebService;
import hclconfig.server.utilities.Response;
import hclconfig.server.utilities.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController {

    @Autowired
    WebService webService;

    public String all(){


        return "all";
    }

    @RequestMapping(value ="/server/read" , method = RequestMethod.GET)
    public  Subscription[] read(){
        return webService.getall();
    }

    @RequestMapping(value ="/server/add" , method = RequestMethod.GET)
    public Response add(){
        return webService.postadd();
    }

    @RequestMapping(value ="/server/delete" , method = RequestMethod.GET)
    public Response delete(){
        return webService.delete();
    }


    @RequestMapping(value ="/server/update" , method = RequestMethod.GET)
    public Response update(){
        return webService.update();
    }


}
