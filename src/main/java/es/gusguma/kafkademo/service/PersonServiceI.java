package es.gusguma.kafkademo.service;

import es.gusguma.kafkademo.model.PersonDocument;

public interface PersonServiceI {

    PersonDocument save(PersonDocument person);

}
