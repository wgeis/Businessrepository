package com.example.Cereal.CerealBusiness.Services;


import com.example.Cereal.CerealBusiness.Repositories.CerealRepository;
import com.example.Cereal.CerealBusiness.entity.Cereal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CerealServices {

    @Autowired
    private CerealRepository cerealRepository;


    // ----------------------GET methods---------


    public List<Cereal> getCerealList(){
        return cerealRepository.findAll();
        //makes sense that it extends the repository from the Spring library.

    }
    public Cereal getCerealById(int id){
        return cerealRepository.findById(id).orElse((null));

    }



    //Add this https://websparrow.org/spring/how-to-fetch-data-from-database-in-spring-mvc mapper.
    public List<Cereal> findCerealsByCaloriesIsBetweeen(int lower,int upper) {
//Atemmpt a list and re
      return cerealRepository.findCerealsByCaloriesIsBetween(lower,upper);
    }

    public List<Cereal> findCerealsByCalories(int calories){
        return cerealRepository.findCerealsByCalories(calories);
    }



    public List<Cereal> findCerealsByBrandname(String columnname) {
        return null;
    }

    List<Cereal> findCerealsByCups(int cups) {
        return null;
    }

    public List<Cereal> findCerealsByRating(String rating) {
        return null;
    }

    public List<Cereal> findCerealsByWeight(int weight) {
        return null;
    }

    public List<Cereal> findCerealsByFat(int fat) {
        return null;
    }

    public List<Cereal> findCerealsByFiber(int fiber) {
        return null;
    }

    public List<Cereal> findCerealsBySugars(int sugars) {
        return null;
    }

    public List<Cereal> findCerealsBySodium(int sodium) {
        return null;
    }

    public List<Cereal> findCerealsByProtein(int protein) {
        return null;
    }

    public List<Cereal> findCerealsByType(String type) {
        return null;
    }

    public List<Cereal> findCerealsByMfr(String mfr) {
        return null;
    }

    //manufacturer
    public  List<Cereal> findCerealsByPotass(int potass) {
        return null;
    }

    public  List<Cereal> findCerealsByCups(float cups) {
        return null;
    }

    //--------------POST methods

    public Cereal createCereal(Cereal cereal){
        //basic variant of making a cereal, just to test if it works with creating simple stuff.
        return cerealRepository.save(cereal); //Fuck it can make ANY sort of cereal and leave columns empty.
    }


//---------PUT methods
    public Cereal updateCerealById(Cereal cereal){

        Optional<Cereal> foundit= cerealRepository.findById(cereal.getId());
        if(foundit.isPresent()){
            Cereal updatedCereal = foundit.get();
            updatedCereal.setBrandname(cereal.getBrandname());
            //extend as necessary, right now I just need to make sure it can work before I customize it.
        return cerealRepository.save(cereal);
        }
        else{
            return null;
        }
    }


    public List<Cereal> deleteCerealsByIdBetween(int lower, int upper){

        return cerealRepository.deleteCerealsByIdBetween(lower,upper);
    }


    public List<Cereal> deleteCerealsByID(int id){
       return  cerealRepository.deleteCerealsById(id);
    }

    /*public List<Cereal> deleteCerealByID(int id){
        return cerealRepository.deleteCerealById(id);
    }*/

    public int findIdMax(){
        return cerealRepository.findNumberOfCerealEntries();
    }



   // @Query(value = "select column from Person where column =:keyvalue")
    /*public List<Cereal> getCerealsByParams(@Param("map")Map<String,String> parameters) {

        String key, value;

        for (Map.Entry<String, String> pair : parameters.entrySet()) {
            System.out.println(String.format("Key (name) is: %s, Value is : %s", pair.getKey(), pair.getValue()));
            key=pair.getKey();pair.getValue();
//todo - Make something smart for implementing the cereal parameterized.
        }

        String sqlConcatenated = "Select %s from Cereals where %s = %";

       // @Query("select %s from Person where %s = :valuefrommap");


        return cerealRepository.findCereal();
    }*/


}
