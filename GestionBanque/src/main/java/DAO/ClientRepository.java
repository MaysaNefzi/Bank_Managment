 package DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import Entities.Client;

public interface ClientRepository extends JpaRepository <Client,Long> {

}
