package springconfing.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springconfing.client.entities.Subscription;
import springconfing.client.repos.SubRepo;

import java.util.List;
import java.util.Optional;

@Service
public class SubService {

    @Autowired
    SubRepo subRepo;

    public void save(Subscription subscription){
        subRepo.save(subscription);
    }

    public Subscription get(Long id) {
        Optional<Subscription> optional =  subRepo.findById(id);

        if(optional.isPresent()){
            return optional.get();
        } else {
            return new Subscription();
        }
    }

    public List<Subscription> getall() {
        return subRepo.findAll();
    }


    public void delete(Subscription subscription) {
        subRepo.delete(subscription);

    }

    public void update(Subscription subscription) {
        subRepo.save(subscription);
    }
}
