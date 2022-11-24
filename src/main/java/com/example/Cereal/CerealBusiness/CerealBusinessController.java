package com.example.Cereal.CerealBusiness;

import com.example.Cereal.CerealBusiness.Services.CerealServices;
import com.example.Cereal.CerealBusiness.entity.Cereal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CerealBusinessController {
    @Autowired
    private CerealServices cerealServices;


    ControllerHelper SatansLittleHelper = new ControllerHelper(cerealServices);
    //I use this to keep the logic away from my Controller.


    @RequestMapping(value = "/")

    public String testToSeeIfIcanGoHome() {

        return "index";
    }
// GET commands

    @RequestMapping(value = "/findCereals/", params = {"id", "mfr", "name", "type", "sugars", "calories", "carbo", ""}, method = RequestMethod.GET)
//get all cereals or singular.
    @ResponseBody
    public ResponseEntity getAllCerealsByID(@RequestParam(required = false) Integer id, @RequestParam(required = false) HashMap<String, String> parameters) {
        if (id != null) {

            return ResponseEntity.ok(cerealServices.getCerealById((id)));
        } else {
            return ResponseEntity.ok(cerealServices.getCerealList());
        }


        //Avoid a controller with logic - all it does is send your request to backend.
        //Replace with parameterised Query. For now, a single variable or paramem is fine.

    }







    @GetMapping(value = "/cerealParams/") //attempt with 2 parameters for between.
    public ResponseEntity<List<Cereal>> getCerealsByCalorieParameters(@RequestBody Cereal cereal, @RequestParam(required = false) Integer exactCalories, @RequestParam(required = false) Integer lowerCalories, @RequestParam(required = false) Integer upperCalories) {
//For more than 1 parameter, test with between for calories

        try {
            return ResponseEntity.ok(cerealServices.findCerealsByCalories(cereal.getCalories()));

            //could be made into helper classes.
        } catch (NullPointerException nullPointerException) {
            System.out.println("Fuck, no cereal object, trying with intervals..");

            try {
                return ResponseEntity.ok(cerealServices.findCerealsByCaloriesIsBetweeen(lowerCalories, upperCalories));

            } catch (NullPointerException noIntervalDefined) {
                System.out.println("No interval defined.");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }


//search between.

    }


    @GetMapping("/paramCereals/")
    public ResponseEntity<List<Cereal>> getCerealsByParam(@RequestParam Map<String, String> parameters) {

        return ResponseEntity.ok(cerealServices.getCerealList());
        //Todo: Make something smart out of the parameters.

        //doesn't explode yet. //Tweak the parameters so we can hav ethe query be most excellent.

    }
    //POST commands



    @PostMapping("/createCereals/")
    public ResponseEntity createCerealOrReplaceExistingWithParams(@RequestBody(required = false) Cereal cerealToBeCreatedOrModified) {

//Todo - Add authentication.




        return SatansLittleHelper.determineResponseForPOSTRequestToCreateCereal(cerealToBeCreatedOrModified,cerealServices);

    }
    //PUT commands

    //DELETE commands
    @DeleteMapping(value = "/deleteCereals/")
    public ResponseEntity DeleteMuhCereal(@RequestBody(required = false) Cereal cerealToBeDeleted,@RequestParam(required = false) Integer id) {

        //Works now with an ID AND cereal object. Seems clunky but it works.
        try{
            return SatansLittleHelper.determineResponseForDELETERequestByCerealObject(cerealToBeDeleted,cerealServices);

        }catch (Exception exception){
            cerealServices.deleteCerealsByID(id);
            //System.out.println(cerealServices.getCerealById(deleteId).getId()+" Has been found in base.");
            System.out.println(id+"has the ID");//!null
            return ResponseEntity.ok("Cereal with ID"+id+" has been deleted");
        }





        //return SatansLittleHelper.determineResponseForDELETERequestByCerealObject(cerealToBeDeleted,cerealServices);
    }

         /*else {
            return ResponseEntity.ok(cerealServices.deleteCerealsByIdBetween(lower, upper));
            //Can be circumvented by not giving upper or lower.

        }


    }*/


}


//Map construction in proces



