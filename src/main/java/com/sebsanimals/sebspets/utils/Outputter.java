package com.sebsanimals.sebspets.utils;

import com.sebsanimals.sebspets.entities.Pet;
import com.sebsanimals.sebspets.repository.PetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Outputter implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger("Wilder");

    @Autowired
    private PetRepository petRepository;

    @Override
    public void run(String... args) throws Exception {

        logger.info(String.format("Nombre d'animaux chez Seb : %d", petRepository.count()));

        Pet tommy = new Pet("Tommy", "chien", 2);
        logger.info(tommy + "has been created !");
        petRepository.save(tommy);
        logger.info(tommy + "has been saved !");

        Pet louna = new Pet("Louna","chat", 1);
        logger.info(louna + " has been created !");
        petRepository.save(louna);
        logger.info(louna + " has been saved !");

        Pet noubi = new Pet("Noubi", "chat", 2);
        logger.info(noubi + " has been created !");
        petRepository.save(noubi);
        logger.info(noubi + " has been saved !");

        Pet marsu = new Pet("Marsu", "chat", 4);
        logger.info(marsu + " has been created");
        petRepository.save(marsu);
        logger.info(marsu + " has been saved !");

        Pet tempPet = petRepository.findById(3L).get();

        logger.info("4th pet's name is : " + tempPet.getName());
        logger.info("4th pet is a : " + tempPet.getType());
        logger.info("4th pet is : " + tempPet.getAge() + " years old.");

        logger.info("My pets are : ");
        for (Pet myPets : petRepository.findAll()) {
            logger.info(myPets.toString());
        }

        petRepository.deleteById(4L);
        logger.info("Noubi has been runover and so was deleted from DB !");

        logger.info("Seb's remaining pet are : ");
        for (Pet myPet : petRepository.findAll()) {
            logger.info(myPet.toString());
        }
    }
}
