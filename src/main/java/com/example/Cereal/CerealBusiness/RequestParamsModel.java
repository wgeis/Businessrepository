package com.example.Cereal.CerealBusiness;

import javax.validation.constraints.NotNull;
import java.util.List;

public class RequestParamsModel {
    public RequestParamsModel(){
    }

    private List<List<String>> params;
    @NotNull
    public List<List<String>> getParams() {
        return params;
    }

    public void setParams(List<List<String>> params) {
        this.params = params;
    }
    //A list of lists of params.



}
