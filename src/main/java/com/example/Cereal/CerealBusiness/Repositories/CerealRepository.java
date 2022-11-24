package com.example.Cereal.CerealBusiness.Repositories;

import com.example.Cereal.CerealBusiness.entity.Cereal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CerealRepository extends JpaRepository<Cereal, Integer> {

   //Repository is for making variants not ingrained in the existing area.

 //Find cereals where ==
    List<Cereal> findCerealsByCalories(int calories);
    List<Cereal> findCerealsByBrandname(String columnname);
    List<Cereal> findCerealsByCups(int cups);
    List<Cereal> findCerealsByRating(String rating);
    List<Cereal> findCerealsByWeight(int weight);
    List<Cereal> findCerealsByFat(int fat);
    List<Cereal> findCerealsByFiber(int fiber);
    List<Cereal> findCerealsBySugars(int sugars);
    List<Cereal> findCerealsBySodium(int sodium);
    List<Cereal> findCerealsByProtein(int protein);
    List<Cereal> findCerealsByType(String type);
    List<Cereal> findCerealsByMfr(String mfr);
    List<Cereal> findCerealsByPotass(int potass);
    List<Cereal> findCerealsByCups(float cups);
    List<Cereal> findCerealById(int id);
 //Between two

    //Aint working.
    List<Cereal> findCerealsByCaloriesIsBetween(int upper,int lower);
    List<Cereal> findCerealsByCupsIsBetween(int upper,int lower);
    List<Cereal> findCerealsByPotassBetween(int upper,int lower);
    List<Cereal> findCerealsByWeightIsBetween(int upper,int lower);
    List<Cereal> findCerealsByFatIsBetween(int upper,int lower);
    List<Cereal> findCerealsBySodiumIsBetween(int upper,int lower);
    List<Cereal> findCerealsByPotassIsBetween(int upper,int lower);
    List<Cereal> findCerealsBySugarsIsBetween(int upper,int lower);
    List<Cereal> findCerealsByFiberIsBetween(int upper,int lower);
    List<Cereal> findCerealsByProteinBetween(int upper,int lower);
   // List<Cereal> findCerealsByRatingIsBetween(int upper,int lower); //Varchar, be vary

 //less than or equal to - takes single param, more causes it to crash
 List<Cereal> findCerealsByCaloriesLessThanEqual(int lower);
 List<Cereal> findCerealsByProteinLessThanEqual(int lower);
 List<Cereal> findCerealsByFatLessThanEqual(int lower);


 //more than or equal to



 //DELETE request




 //List<Cereal> deleteCerealById(int id);


    @Transactional
 List<Cereal> deleteCerealsById(int id);


@Query("select MAX(id) from Cereal")
 int findNumberOfCerealEntries();

 List<Cereal> deleteAllByIdBetween(int lower, int upper);
 List<Cereal> deleteCerealsByIdBetween(int lower,int upper);
    List<Cereal> deleteCerealsByCaloriesBetween(int lower,int upper);
    List<Cereal> deleteCerealsByProteinBetween(int lower,int upper);



}
