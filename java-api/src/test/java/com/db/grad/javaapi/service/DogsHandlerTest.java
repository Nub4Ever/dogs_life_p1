package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DogsHandlerTest {
    private DogsRepository itsDogRepo = new DogsRepositoryStub();
    @BeforeEach
    public void makeSureRepoIsEmpty() {
        itsDogRepo.deleteAll();
    }

    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );

        int expectedResult = 1;
        long actualResult = cut.getNoOfDogs();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void add_several_dogs_return_number_of_dogs_match_number_added() {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );

        Dog theDog2 = new Dog();
        theDog2.setName("Max");
        cut.addDog( theDog2 );

        Dog theDog3 = new Dog();
        theDog3.setName("Luna");
        cut.addDog( theDog3 );

        int expectedResult = 3;
        long actualResult = cut.getNoOfDogs();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void find_only_one_dog_by_name_return_the_dog() {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );

        Dog theDog2 = new Dog();
        theDog2.setName("Max");
        cut.addDog( theDog2 );

        Dog theDog3 = new Dog();
        theDog3.setName("Luna");
        cut.addDog( theDog3 );

        Dog expectedResult = theDog2;
        Dog actualResult = cut.getDogByName("Max");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void find_no_dog_by_name_return_null() {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );

        Dog theDog2 = new Dog();
        theDog2.setName("Max");
        cut.addDog( theDog2 );

        Dog theDog3 = new Dog();
        theDog3.setName("Luna");
        cut.addDog( theDog3 );

        Dog expectedResult = null;

        Dog actualResult = cut.getDogByName("Milo");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void find_more_than_one_dog_by_name_return_null() {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );

        Dog theDog2 = new Dog();
        theDog2.setName("Max");
        cut.addDog( theDog2 );

        Dog theDog3 = new Dog();
        theDog3.setName("Bruno");
        cut.addDog( theDog3 );

        Dog expectedResult = null;
        Dog actualResult = cut.getDogByName("Bruno");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void get_one_dog_by_id_return_the_dog() {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog1 = new Dog();
        cut.addDog(theDog1);

        Dog theDog2 = new Dog();
        cut.addDog(theDog2);

        Dog theDog3 = new Dog();
        cut.addDog(theDog3);

        Dog expectedResult = theDog2;
        Dog actualResult = cut.getDogById(2);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void get_no_dog_by_id_return_null() {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog1 = new Dog();
        cut.addDog(theDog1);

        Dog theDog2 = new Dog();
        cut.addDog(theDog2);

        Dog theDog3 = new Dog();
        cut.addDog(theDog3);

        Dog expectedResult = null;
        Dog actualResult = cut.getDogById(4);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void update_dog_details_return_id() {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog1 = new Dog();
        cut.addDog(theDog1);

        Dog theDog2 = new Dog();
        cut.addDog(theDog2);

        Dog theDog3 = new Dog();
        cut.addDog(theDog3);

        long expectedResult = 3;
        long actualResult = cut.updateDogDetails(theDog3);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void update_no_dog_details_return_minus_one() {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog1 = new Dog();
        cut.addDog(theDog1);

        Dog theDog2 = new Dog();
        cut.addDog(theDog2);

        Dog theDog3 = new Dog();
        cut.addDog(theDog3);

        long expectedResult = -1;
        long actualResult = cut.updateDogDetails(new Dog());

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void remove_dog_succes_return_true() {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog1 = new Dog();
        cut.addDog(theDog1);

        Dog theDog2 = new Dog();
        cut.addDog(theDog2);

        Dog theDog3 = new Dog();
        cut.addDog(theDog3);

        boolean expectedResult = true;
        boolean actualResult = cut.removeDog(2);

        assertEquals(expectedResult, actualResult);
        assertTrue(!itsDogRepo.existsById(2));
    }

    @Test
    public void remove_dog_fail_return_false() {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog1 = new Dog();
        cut.addDog(theDog1);

        Dog theDog2 = new Dog();
        cut.addDog(theDog2);

        Dog theDog3 = new Dog();
        cut.addDog(theDog3);

        boolean expectedResult = false;
        boolean actualResult = cut.removeDog(4);

        assertEquals(expectedResult, actualResult);
    }
}
