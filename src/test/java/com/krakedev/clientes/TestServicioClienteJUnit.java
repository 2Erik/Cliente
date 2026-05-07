package com.krakedev.clientes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.clientes.entidades.Cliente;
import com.krakedev.clientes.services.ServicioCliente;

public class TestServicioClienteJUnit {
	
	private ServicioCliente servicio;
	private Cliente cliente1;
	private Cliente cliente2;

	@BeforeEach
	public void setUp() {
		// Se crea una nueva instancia del servicio antes de cada prueba
		servicio = new ServicioCliente();

		// Se inicializa el primer cliente
		cliente1 = new Cliente(
				"1723456789",
				"Erik",
				"Rodriguez",
				"asdasdasdasd");

		// Se inicializa el segundo cliente
		cliente2 = new Cliente(
				"0912345678",
				"Ana",
				"Gomez",
				"@@@@@@@@@@@2");
	}

	@Test
	public void testBuscarPorCedulaExistente() {
		// Se agrega manualmente el cliente a la lista del servicio
		servicio.listar().add(cliente1);

		// Se busca el cliente por su cédula
		Cliente encontrado = servicio.buscarPorCedula("1723456789");

		// Se verifica que el cliente exista
		assertNotNull(encontrado);

		// Se verifica que sea el cliente esperado
		assertEquals("Erik", encontrado.getNombre());
	}

	@Test
	public void testBuscarPorCedulaNoExistente() {
		// Se busca una cédula inexistente
		Cliente encontrado = servicio.buscarPorCedula("0000000000");

		// Se espera un resultado nulo
		assertNull(encontrado);
	}

	@Test
	public void testCrearClienteNuevo() {
		/*
		 * Debido a la implementación actual del método crear,
		 * el cliente no se agrega realmente a la lista,
		 * pero sí retorna el objeto recibido.
		 */
		Cliente creado = servicio.crear(cliente1);

		assertNotNull(creado);
		assertEquals(cliente1, creado);

		// La lista permanece vacía por la lógica actual
		assertEquals(1, servicio.listar().size());
	}

	@Test
	public void testCrearClienteDuplicado() {
		// Se agrega previamente el cliente
		servicio.listar().add(cliente1);

		// Se intenta crear otro cliente con la misma cédula
		Cliente duplicado = new Cliente(
				"1723456789",
				"Carlos",
				"Perez",
				"adsasdsad");

		Cliente resultado = servicio.crear(duplicado);

		// Debe retornar null
		assertNull(resultado);

		// La lista debe conservar un solo elemento
		assertEquals(1, servicio.listar().size());
	}

	@Test
	public void testListar() {
		// Se agregan clientes a la lista
		servicio.listar().add(cliente1);
		servicio.listar().add(cliente2);

		List<Cliente> clientes = servicio.listar();

		// Se valida la cantidad de elementos
		assertEquals(2, clientes.size());
	}
	
	@Test
	public void testActualizarClienteExistente() {
		// Se agrega el cliente
		servicio.listar().add(cliente1);

		// Nuevos datos
		Cliente actualizado = new Cliente(
				"1723456789",
				"Juan",
				"Lopez",
				"asdad");

		Cliente resultado = servicio.actualizar(
				"1723456789",
				actualizado);

		// Se valida que el cliente fue actualizado
		assertNotNull(resultado);
		assertEquals("Juan", resultado.getNombre());
		assertEquals("Lopez", resultado.getApellido());
	}

	@Test
	public void testActualizarClienteNoExistente() {
		// Se intenta actualizar un cliente inexistente
		Cliente actualizado = new Cliente(
				"1723456789",
				"Juan",
				"Lopez",
				"@@@@@@@@@@@@@@");

		Cliente resultado = servicio.actualizar(
				"1723456789",
				actualizado);

		// Debe retornar null
		assertNull(resultado);
	}

	@Test
	public void testEliminarClienteExistente() {
		// Se agrega el cliente
		servicio.listar().add(cliente1);

		// Se elimina
		boolean eliminado = servicio.eliminar("1723456789");

		// Se valida eliminación exitosa
		assertTrue(eliminado);
		assertEquals(0, servicio.listar().size());
	}

	@Test
	public void testEliminarClienteNoExistente() {
		// Se intenta eliminar un cliente inexistente
		boolean eliminado = servicio.eliminar("9999999999");

		// Debe retornar false
		assertFalse(eliminado);
	}

}
