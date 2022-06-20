package main.java.main;

import java.time.LocalDate;

import main.java.model.Cliente;
import main.java.model.Genero;
import main.java.model.Linea;
import main.java.model.Negocio;
import main.java.model.Pedido;
import main.java.model.Producto;
import main.java.model.Status;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Negocio n1 = new Negocio();
		Cliente c1 = new Cliente("Jose Juan", "Carmona", "josejose@gmail.com",LocalDate.of(2003, 12, 12), Genero.HOMBRE);
		Cliente c2 = new Cliente("Juan Antonio", "Cespedes", "juanjuan@gmail.com",LocalDate.of(2003, 11, 11), Genero.HOMBRE);
		Cliente c3 = new Cliente("Mario", "COnde", "mariomario@gmail.com",LocalDate.of(2003, 11, 11), Genero.HOMBRE);

		Pedido p1 = new Pedido("AAA", Status.PROCESADO, c1);
		Pedido p2 = new Pedido("CCC", Status.PROCESADO, c1);
		Pedido p3 = new Pedido("XXX", Status.PROCESADO, c3);

		Producto pr1 = new Producto("Macarrones", 12.00);
		Producto pr2 = new Producto("Tomates", 15.00);
		Producto pr3 = new Producto("Acelgas", LocalDate.of(2012, 1, 2), LocalDate.of(2020, 1, 1), 3.00);
		Linea l1 = new Linea("BBB", pr1, 9, 12);
		Linea l2 = new Linea("zzz", pr2, 9, 14);
		Linea l3 = new Linea("LLL", pr3, 9, 200);

		n1.addCliente(c1);
		n1.addCliente(c2);
		n1.addCliente(c3);
		p3.addLinea(l3);
		n1.addPedido(p3);
		n1.addPedido(p1);
		n1.addPedido(p2);
		p1.addLinea(l1);
		p1.addLinea(l2);
		p2.addLinea(l2);
		//System.out.println(l1.addProducto(pr3));
		//System.out.println(pr3.isActivo());
		//System.out.println(n1.listarClientesPorImporteVenta());
		//System.out.println(n1.mostrarPedidosYLineasPorId());
		//System.out.println(n1.mostrarPedidosYLineasPorPrecio());
		//System.out.println(n1.mostrarClientesPorEdad());
		//System.out.println(n1.obtenerMapaConProductosPorCliente());
		//System.out.println(n1.mayorCantidadDeProductos());
		//System.out.println(n1.obtenerMapaConProductosPorCliente());
		//System.out.println(n1.obtenerClienteConMasPedidos());
		//System.out.println(n1.obtenerMapaConPreciosUnitarios());
		//System.out.println(n1.obtenerPedidoConUnitarioMasAlto());
		//System.out.println(n1.obtenerMapaProductoEstrella());
		//System.out.println(n1.obtenerProductoEstrella());
		//System.out.println(n1.obtenerMapaClienteVip());
		//System.out.println(n1.obtenerClienteVip());
		//System.out.println(p1.mostrarLineasPorIDAscendente());
		//System.out.println(p1.mostrarLineasPorPrecioDescendente());
		//System.out.println(l1.VaciarLinea());
		//System.out.println(l1);
		//System.out.println(n1.obtenerMapaMediaPorPedido());
		//System.out.println(n1.obtenerPedidoConUnitarioMedioMasAlto());
		//System.out.println(n1.obtenerPedidoConUnitarioMedioMasBajo());
		//System.out.println(n1.obtenerMapaClienteVip());
		//System.out.println(n1.obtenerClienteVip());
		System.out.println(n1.mostrarProductosPorCliente());
	}

}
