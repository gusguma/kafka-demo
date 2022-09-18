package es.gusguma.kafkademo.service;

import es.gusguma.kafkademo.model.PersonDocument;
import es.gusguma.kafkademo.repository.PersonRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class PersonServiceImpl implements PersonServiceI {

    @Autowired
    private Logger logger;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonDocument save(final PersonDocument person) {
        this.logger.info("Trying to save person: {}", person);
        PersonDocument personDb = null;
        if (nonNull(person)) {
            personDb = this.personRepository.save(person);
        }
        this.logger.info("Person has been saved: {}", personDb);
        return personDb;
    }
}
