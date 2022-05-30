package springconfing.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springconfing.client.entities.Subscription;
import springconfing.client.services.SubService;
import springconfing.client.utilities.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {

    @Autowired
    SubService subService;

    @ResponseBody
    @PostMapping("/api/add")
    public Response add(@RequestBody Subscription subscription){
        subService.save(subscription);
        return new Response("success" , "thank you");
    }

    @GetMapping("/api/read")
    public Subscription read(@RequestParam("id") Long id ) {
//        subService.save(subscription);

        Subscription subscription =  subService.get(id);

        return subscription;
    }

    @GetMapping("/api/readall")
    public List<Subscription> readall() {
//        subService.save(subscription);

        return subService.getall();
    }

    @GetMapping(value = { "/read" , "/read/{id}" })
    public List<Subscription> myread(@PathVariable("id") Optional<Long> id ) {
        if(id.isPresent()) {
            Subscription subscription =  subService.get(id.get());
            List<Subscription> list = new ArrayList<>();
            list.add(subscription);
            return list;
        } else {
            return subService.getall();
        }
    }




    @ResponseBody
    @DeleteMapping("/api/delete")
    public Response delete(@RequestBody Subscription subscription) {
//        subService.save(subscription);

        subService.delete(subscription);

        return new Response("success" , "DELETED");
    }

    @ResponseBody
    @PutMapping("/api/update")
    public Response update(@RequestBody Subscription subscription) {
//        subService.save(subscription);

        subService.update(subscription);

        return new Response("success" , "Updated");
    }
}
