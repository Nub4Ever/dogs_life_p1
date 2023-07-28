package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.List;

public class DogHandler {
    private DogsRepository itsDogRepo;

    public DogHandler(DogsRepository itsDogRepo) {
        this.itsDogRepo = itsDogRepo;
    }

    public long addDog(Dog theDog) {
        return itsDogRepo.save(theDog);
    }

    public long getNoOfDogs(){
        return itsDogRepo.count();
    }

    public Dog getDogByName(String name) {
        Dog dog = new Dog();
        dog.setName(name);
        List<Dog> dogs = itsDogRepo.findByName(dog);


        if (dogs.size() != 1) {
            return null;
        }

        // return dog
        return dogs.get(0);
    }

    public Dog getDogById(long id) {
        return itsDogRepo.findById(id);
    }

    public long updateDogDetails(Dog dog) {
        if (itsDogRepo.existsById(dog.getId())) {
            return dog.getId();
        } else {
            return -1;
        }
    }

    public boolean removeDog(long id) {
        Dog dog = itsDogRepo.findById(id);

        if (dog != null) {
            return itsDogRepo.delete(dog);
        } else {
            return false;
        }
    }
}