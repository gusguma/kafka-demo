package es.gusguma.kafkademo.consumer;

import es.gusguma.kafkademo.model.PersonDocument;
import es.gusguma.kafkademo.service.PersonServiceI;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

import static java.util.Objects.nonNull;

@Component("input")
public class InputConsumer implements Consumer<PersonDocument> {

    @Autowired
    private Logger logger;

    @Autowired
    private PersonServiceI personService;

    @Override
    public void accept(final PersonDocument message) {
        this.logger.info("Trying to process message: {}", message);
        final PersonDocument person;
        if (nonNull(message)) {
            person = this.personService.save(message);
            this.logger.info("Message processed: {}", person);
        } else {
            this.logger.error("Message was null");
        }

    }
}
