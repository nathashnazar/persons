package com.example.person.person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonInitializer {

    private final PersonRepository personRepository;

    @EventListener
    public void on(ContextRefreshedEvent e){
        if (personRepository.count() == 0){
            Person natash = new Person(1, "nathash", "6379929942", "nathashnazar16@gmail.com");
            natash = personRepository.save(natash);
            Person fahad = new Person(2,"fahad","9988776655","fahadfasil@gmail.com");
            fahad = personRepository.save(fahad);
            Person sinan = new Person(3,"sinan","1122334455" ,"sinanmuhd@gmail.com");
            sinan = personRepository.save(sinan);
            Person fahadf = new Person(4,"fahadf","9988776678","fahadffasil@gmail.com");
            fahadf = personRepository.save(fahadf);
        }
    }
}
