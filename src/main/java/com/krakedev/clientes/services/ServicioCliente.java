package com.krakedev.clientes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.krakedev.clientes.entidades.Cliente;


@Service
public class ServicioCliente {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public Cliente buscarPorCedula(String cedula) {
		for (Cliente c : clientes) {
			if (c.getCedula().equals(cedula)) {
				return c;
			}
		}
		return null;
	}
	
	public Cliente crear(Cliente cliente) {
		Cliente existe = buscarPorCedula(cliente.getCedula());
		
		if(existe != null) {
			return null;
		}else {
			clientes.add(cliente);
			return cliente;
		}
	}
	
	public List<Cliente> listar(){
		return clientes;
	}
	
	public Cliente actualizar(String cedula, Cliente clienteActualizar) {
		Cliente cliente = buscarPorCedula(cedula);
		
		if(cliente != null) {
			cliente.setNombre(clienteActualizar.getNombre());
			cliente.setApellido(clienteActualizar.getApellido());
		}
		return cliente;
	}
	
	public boolean eliminar(String cedula) {
		Cliente cliente = buscarPorCedula(cedula);
		
		if(cliente != null) {
			clientes.remove(cliente);
			return true;
		}
		return false;
	}
}
