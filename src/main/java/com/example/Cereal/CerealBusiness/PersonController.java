package com.example.Cereal.CerealBusiness;

import com.example.Cereal.CerealBusiness.Services.PersonServices;
import com.example.Cereal.CerealBusiness.entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    private PersonServices personServices;
//Hestenet
    @GetMapping("/persons/")
    public ResponseEntity<List<Person>> getAllPersons(){
//For all persons without id.
        return ok(personServices.getPersonList());
    }

   /* @RequestMapping(value="/params/", method = RequestMethod.GET)
    //Modify this to be with POST eventually - now we can make requests of the GET type and modify it!
    public ResponseEntity<String> getParams(@RequestParam Map<String,String> params){
        System.out.println(params.keySet());
        System.out.println(params.values());
        return new ResponseEntity<>("ok",HttpStatus.OK);

    }*/

    //ToDo - overfør parametre som en
    @RequestMapping(value="/params/", method = RequestMethod.GET)
    //Modify this to be with POST eventually - now we can make requests of the GET type and modify it!
    public ResponseEntity<List<Person>> getParams(@RequestParam HashMap<String,Integer> params,@RequestParam int shoesizeUpper,@RequestParam int shoesizeLower){
        //sprinkle some code for locating the limits.
        /*
        Learning stuff: Request params map is for multiples, if we're doing just a specific few, then its fine with a few named ones
         */
        //int upper=0, lower = 0;

        for(Map.Entry<String,Integer> pair: params.entrySet()){
            System.out.printf("Key name is %s, value is : %s \n ",pair.getKey(), pair.getValue());
            //I can now get the params and keys out to give as input for services.
            //
            try{

            }catch (NumberFormatException nfe){

            }
        }


        return ok(personServices.getPersonsByShoeSizeBetween(shoesizeUpper,shoesizeLower));
        //return new ResponseEntity<>(personServices.getPersonsByShoeSizeBetween(0,66),HttpStatus.OK);
        //finds a list if its between.

    }


    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getSpecificPerson(@PathVariable int id){

        return ok().body(this.personServices.getPersonByID(id));

    }




   /* @PostMapping("/addPerson/")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        return ok(this.personServices.createPerson(person));
//Old version where it was specific Post, not a request mapping.
    }*/
    @RequestMapping(value = "/addPerson/",method = RequestMethod.POST)
    public ResponseEntity<Person> addPerson(@RequestBody Person person){

        return ok(this.personServices.createPerson(person));
    }
//lists not necessary.

    @PostMapping("/addPersons/")
    public ResponseEntity<List<Person>> addPersons(@RequestBody List<Person> list) {
        return ok(this.personServices.createPersonList(list));
    }

    @DeleteMapping("deletePersons/{id}")
    public HttpStatus deletePersonFromBackend(@PathVariable int id){

        this.personServices.deletePersonById(id);
        return HttpStatus.OK;
    }


}
