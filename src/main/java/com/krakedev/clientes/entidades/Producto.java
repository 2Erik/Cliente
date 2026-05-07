package com.krakedev.clientes.entidades;

public class Producto {
	
		private String nombre;
		private int codigo;
		private double precio;
		private int stock;
		
		public Producto() {
		}
	
	public Producto(String nombre, int codigo, double precio, int stock) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", precio=" + precio + ", stock=" + stock + "]";
	}
}
