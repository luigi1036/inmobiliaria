package com.tucasa.repositories;

import com.tucasa.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RentRepository extends JpaRepository<Rent, String>{


    Optional<Rent> getByIdPropertyAndIdUser(int idProperty, int idUser);
}
