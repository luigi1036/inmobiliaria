package com.tucasa.service;

import com.tucasa.dto.RentDto;
import com.tucasa.model.Rent;
import org.springframework.http.ResponseEntity;

public interface IRentService {

    ResponseEntity<Rent> save(RentDto rentDto);
    ResponseEntity<Rent> getById(String id);
    ResponseEntity<Rent> getByUserId(String userId);
    ResponseEntity<Rent> getByPropertyId(String propertyId);
    ResponseEntity<Rent> getByIdPropertyAndIdUser(int propertyId, int userId);
    ResponseEntity<Rent> update(RentDto rentDto, String id);
    ResponseEntity<Rent> delete(String id);

}
