package com.tucasa.service.impl;

import com.tucasa.dto.RentDto;
import com.tucasa.model.Rent;
import com.tucasa.repositories.RentRepository;
import com.tucasa.service.IRentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
@AllArgsConstructor
public class RentServiceImpl implements IRentService {

    private final RentRepository rentRepository;

    @Override
    public ResponseEntity<Rent> save(RentDto rentDto) {

        Rent rent = Rent.builder().id(UUID.randomUUID().toString())
                .idUser(rentDto.getIdUser()).idProperty(rentDto.getIdProperty())
                .date(LocalDateTime.now())
                .status(true).build();

        return ResponseEntity.status(HttpStatus.CREATED).body(rentRepository.save(rent));
    }

    @Override
    public ResponseEntity<Rent> getById(String id) {
        var rent = rentRepository.findById(id);
        return rent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @Override
    public ResponseEntity<Rent> getByUserId(String userId) {
        var rent = rentRepository.findById(userId);
        return rent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @Override
    public ResponseEntity<Rent> getByPropertyId(String propertyId) {
        var rent = rentRepository.findById(propertyId);
        return rent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @Override
    public ResponseEntity<Rent> getByIdPropertyAndIdUser(int propertyId, int userId) {
        var rent = rentRepository.getByIdPropertyAndIdUser(propertyId, userId);
        return rent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @Override
    public ResponseEntity<Rent> update(RentDto rentDto, String id) {
        var rent = rentRepository.findById(id);
        if(rent.isPresent()){
            Rent rentUpdate = rent.get();
            rentUpdate.setIdProperty(rentDto.getIdProperty());
            rentUpdate.setIdUser(rentDto.getIdUser());
            rentUpdate.setDate(LocalDateTime.now());
            rentUpdate.setStatus(rentDto.isStatus());
            return ResponseEntity.ok(rentRepository.save(rentUpdate));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Override
    public ResponseEntity<Rent> delete(String id) {
        var rent = rentRepository.findById(id);
        if(rent.isPresent()){
            rentRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
