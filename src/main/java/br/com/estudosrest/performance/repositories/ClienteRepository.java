package br.com.estudosrest.performance.repositories;

import br.com.estudosrest.performance.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT id, nome, email FROM cliente")
    List<Cliente> getClientes(String fields);
}
