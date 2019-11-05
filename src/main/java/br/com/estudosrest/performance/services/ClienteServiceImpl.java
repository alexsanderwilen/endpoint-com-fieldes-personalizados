package br.com.estudosrest.performance.services;

import br.com.estudosrest.performance.model.Cliente;
import br.com.estudosrest.performance.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente getClientes(Long id){

        Cliente cliente = clienteRepository.getOne(id);
        return cliente;
    }

    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }

    public List<Cliente> getClientes(String[] fields){

        List<Cliente> clientes = clienteRepository.findAll();

        return   clientes.stream().map(x -> {
            Cliente cliente = new Cliente();

            for (int i = 0; i < fields.length; i++) {
                try {
                    //Field[] fl = x.getClass().getDeclaredFields();
                    //if (Arrays.asList(fl).stream().filter(a -> a.getName().equals(fields[finalI])).findFirst().isPresent())
                    {
                        Field fx = x.getClass().getDeclaredField(fields[i]);
                        fx.setAccessible(true);
                        Field fCliente = cliente.getClass().getDeclaredField(fields[i]);
                        fCliente.setAccessible(true);
                        fCliente.set(cliente, fx.get(x));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    System.out.println("campo: "+fields[i] + " inexistente.");
                }
            }
            return cliente;
        }).collect(Collectors.toList());
    }
}
