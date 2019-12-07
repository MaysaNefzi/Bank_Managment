package DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import Entities.Compte;

public interface CompteRepository extends JpaRepository <Compte,String>{

}
