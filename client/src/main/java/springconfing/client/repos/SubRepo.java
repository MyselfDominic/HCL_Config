package springconfing.client.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import springconfing.client.entities.Subscription;

public interface SubRepo extends JpaRepository<Subscription, Long> {

    void deleteByEmail(String email);

}
