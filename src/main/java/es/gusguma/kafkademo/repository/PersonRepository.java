package es.gusguma.kafkademo.repository;

import es.gusguma.kafkademo.model.PersonDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<PersonDocument, String> {

}
