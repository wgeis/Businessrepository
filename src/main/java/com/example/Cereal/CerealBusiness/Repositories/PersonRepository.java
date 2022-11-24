package com.example.Cereal.CerealBusiness.Repositories;

import com.example.Cereal.CerealBusiness.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    //let's try interfaceing stuff.,

  @Query("select fname from Person where fname = :fname ")
  //brug dit map som input - og erstat Column(fname) med dit parameter
   List<Person> findPersonsByFname(@Param("fname")String fname);

  //public Person findPersonByName (@Param("fname") String fname);


    //Use param fname, the Colon : refers to the passed parameter.
  //define the interface as what it takes in
  //public Person findPersonByParams(@Param("parametersTobeRead)") List<String> parametersToBeFedToTheBackend);

  //public Person findPersonByAge(int age);
     Person findPersonByShoesizeEu(int shoesize);
     List<Person> findPersonByShoesizeEuIs(int shoesize);

     //@Query("select person0_.id as id1_1_, person0_.age as age2_1_, person0_.fname as fname3_1_, person0_.lname as lname4_1_, person0_.shoesizeeu as shoesize5_1_ from persons person0_ where person0_.shoesizeeu between :upper and :lower")
   // @Query("from Person  where shoesizeEu between :lower and :upper")
     //List<Person> findPersonByShoesizeEuBetween(@Param("upper") int lower, @Param("lower") int upper);
    List<Person> findPersonByShoesizeEuBetween(int upper, int lower);






  //Todo: Make a smart way of concatenating the parameters compared to the amount of parameters passed.

}
