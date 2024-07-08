package com.tucasa.controller;


import com.tucasa.dto.RentDto;
import com.tucasa.model.Rent;
import com.tucasa.service.IRentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/rent")
public class RentController {

    private final IRentService rentService;

    @PostMapping
    public ResponseEntity<Rent> saveRent(@Valid @RequestBody RentDto rent){
        return rentService.save(rent);

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Rent> getById(@PathVariable String id){
        return rentService.getById(id);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Rent> getByUserId(@PathVariable String userId){
        return rentService.getByUserId(userId);
    }

    @GetMapping("/property/{propertyId}")
    public ResponseEntity<Rent> getByPropertyId(@PathVariable String propertyId){
        return rentService.getByPropertyId(propertyId);
    }

    @GetMapping("/property/{propertyId}/user/{userId}")
    public ResponseEntity<Rent> getByIdPropertyAndIdUser(@PathVariable int idProperty, @PathVariable int idUser){
        return rentService.getByIdPropertyAndIdUser(idProperty, idUser);
    }

    @PutMapping
    public ResponseEntity<Rent> updateRent(@Valid @RequestBody RentDto rent, @PathVariable String id){
        return rentService.update(rent, id);
    }

    @DeleteMapping("/rent/{id}")
    public ResponseEntity<Rent> deleteRent(@PathVariable String id){
        return rentService.delete(id);
    }
}
