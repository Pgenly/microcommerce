package com.ecommerce.microcommerce.response;

import java.net.URI;

import com.ecommerce.microcommerce.interfaceentity.EntityInterface;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class BuildResponseEntity {

    private BuildResponseEntity () {
    }

    /**
     * Build a response Entity according to value of parameters "newProduct"
     * @param newProduct is a product on which we build a the answer
     * @return response a response entity code ("201 Created" Or "204 No Content")
     */
    public static ResponseEntity<Void> createdResponseEntity(EntityInterface object) {
        // Return response when the object is null (Error 204 Not Content)
        if(object == null) {
            return ResponseEntity.noContent().build();
        } 

        // Construct a response "201 created" if the object is not null
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()                   // Get a current request (http:localhost:8080)
            .path("/{id}")                          // The id of a new object created
            .buildAndExpand(object.getId())         // Assign a value to parameter on the previous line
            .toUri();                               // Convert to URI with parameter define on the previous lines 
        
        // Return response API "201 created"
        return ResponseEntity.created(location).build();
    }

}