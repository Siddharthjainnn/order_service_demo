package order.service;

import order.entity.Person;
import order.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    public Person createPerson(Person person){
        return personRepository.save(person);
    }

}
