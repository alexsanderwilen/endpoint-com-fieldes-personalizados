package br.com.estudosrest.performance.resources;

import br.com.estudosrest.performance.model.Cliente;
import br.com.estudosrest.performance.services.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteResource {

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping("/{id}")
    public Cliente getClientes(@PathVariable Long id) {
       return clienteService.getClientes(id);
    }


    @GetMapping
    public List<Cliente> getClientes(@RequestParam(name = "fields", required = false) String[] fields) {

        if (fields == null) {
            return clienteService.getClientes();
        }
	    else {
            return clienteService.getClientes(fields);
        }
    }
}
