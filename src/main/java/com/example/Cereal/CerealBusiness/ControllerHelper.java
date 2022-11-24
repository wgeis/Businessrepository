package com.example.Cereal.CerealBusiness;

import com.example.Cereal.CerealBusiness.Services.CerealServices;
import com.example.Cereal.CerealBusiness.entity.Cereal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ControllerHelper {
    //Helper class to very


    public ControllerHelper(CerealServices services){
        //this.cerealServices=services;
    }

    public ResponseEntity determineResponseForPOSTRequestToCreateCereal(Cereal cerealToBeCreatedOrModified, CerealServices cerealServices){


        try {
            boolean existsInDatabase = cerealServices.getCerealById(cerealToBeCreatedOrModified.getId()).getId() == cerealToBeCreatedOrModified.getId();
            //check if it exists already:
            System.out.println(cerealToBeCreatedOrModified.getId()+"entered");
            if (existsInDatabase ) {
                //update
                cerealServices.createCereal(cerealToBeCreatedOrModified);
                System.out.printf("cereal with id %s modified", cerealToBeCreatedOrModified.getId());
                return ResponseEntity.ok().body("Cereal with id "+cerealToBeCreatedOrModified.getId()+" modified");
            }
            else{ //if it doesn't exist

                return ResponseEntity.badRequest().body("Not found in database, but you can't make a cereal with your own ID");
                //Tested and works.
            }

        } catch (NullPointerException npe) {
            //what if there is no id?

            cerealToBeCreatedOrModified.setId(cerealServices.findIdMax()+1); //set the ID to max possible. R
            cerealServices.createCereal(cerealToBeCreatedOrModified);
            System.out.printf("Cereal with id %d created ", cerealToBeCreatedOrModified.getId());
            return ResponseEntity.ok(("Cereal with ID" + cerealToBeCreatedOrModified.getId() + " has been created"));
        }
    }


    public ResponseEntity determineResponseForDELETERequestByCerealObject(Cereal cerealToBeDeleted,CerealServices cerealServices) {
        //We COULD try to just have an ID, but I think it also makes sense here. Alternatively, we COUlD have a helper method for just an ID


        try{
            int deleteId= cerealToBeDeleted.getId();;
            boolean existsInDatabase = cerealServices.getCerealById(deleteId)!=null;

            //System.out.println(cerealServices.getCerealById(deleteId).getId()+" Has been found in base.");

            if(existsInDatabase){


                return ResponseEntity.ok((cerealServices.deleteCerealsByID(deleteId)));

            }
        }catch (NullPointerException npe){
            return new ResponseEntity("I couldn't find a Cereal with the ID:"+cerealToBeDeleted.getId(),HttpStatus.NOT_FOUND);
        }



        return null;
    }

    public ResponseEntity determineResponseForDELETERequestByIDOnly(Integer cerealID,CerealServices cerealServices) {
        try{
            cerealServices.deleteCerealsByID(cerealID);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }
}
