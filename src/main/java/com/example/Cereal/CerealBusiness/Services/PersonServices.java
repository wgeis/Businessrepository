package com.example.Cereal.CerealBusiness.Services;


import com.example.Cereal.CerealBusiness.Repositories.PersonRepository;
import com.example.Cereal.CerealBusiness.entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {


    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }
    //a Purrrrson?

    public List<Person> getPersonList(){

        return personRepository.findAll();
    }

    public Person getPersonByID(int id){
        return personRepository.findById(id).orElse(null);

    }
    public Person getPersonByShoeSize(int shoesize){
        return personRepository.findPersonByShoesizeEu(shoesize);
    }


    public List<Person> getPersonsByShoeSizeBetween(int upper,int lower){
        //System.out.printf(upper+"aaaand"+lower);
        return personRepository.findPersonByShoesizeEuBetween(upper,lower);
    }



  /*  public Person getPersonByParams(List<String> params){

        return null;
       // return personRepository.findPersonByParams(params);
    }*/



    public List<Person> createPersonList(List<Person> list) {
        return personRepository.saveAll(list);
    }

    public String deletePersonById(int id) {
        personRepository.deleteById(id);
        return "User "+ id +" deleted";
    }
}
