package main.java.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Negocio {
	private List<Cliente> lista;
	private List<Pedido> listaPedidos;
	private List<Catalogo> listaCatalogo;

	public Negocio() {
		this.lista= new ArrayList<Cliente>();
		this.listaCatalogo= new ArrayList<Catalogo>();
		this.listaPedidos = new ArrayList<Pedido>();
	}
	
	public void addPedido(Pedido p) {
		listaPedidos.add(p);
	}
	public boolean addCliente(Cliente c1) {
		boolean resultado=false;

		if (!lista.contains(c1) && LocalDate.now().getYear()-c1.getFechaNacimiento().getYear()>=18) {
				resultado=true;
				lista.add(c1);
		}
		
		
		return resultado;
	}
	public boolean eliminarCliente(String dni) {
		boolean resultado=false;
		for (Cliente c:lista) {
			if (c.getDni().equals(dni)) {
				lista.remove(c);
				resultado=true;
			}
		}
		
		return resultado;
	}
		public Map<Pedido,Integer> contarProductosPorPedido() {
		Map<Pedido, Integer> mapaCantidad = new HashMap<Pedido, Integer>();
		for (Pedido p: listaPedidos) {
			Integer contador=0;
			
			for (Linea l : p.getListaLineas()) {
				contador=l.getCantidad();
				
			}
			
			mapaCantidad.put(p, contador);
			
			
		}
		return mapaCantidad;
		
		}
		
		public Pedido mayorCantidadDeProductos() {
			Map<Pedido,Integer> mapaCantidad = contarProductosPorPedido();
			Integer mayorProducto=0;
			Pedido p1 = new Pedido();
			for (Pedido p: mapaCantidad.keySet()) {
				if(mapaCantidad.get(p)>mayorProducto) {
					mayorProducto=mapaCantidad.get(p);
					p1=p;
				}
			}
			return p1;
		}
		
		public Map<Pedido,Double> obtenerMapaMediaPorPedido() {
			Map<Pedido,Double> mapaCantidad= new HashMap<>();
			Double resultado=0.0;
			for (Pedido p: listaPedidos) {
				resultado=p.getCostePedido()/ p.getNumeroProductos();
				mapaCantidad.put(p, resultado);
			}
			return mapaCantidad;
		}
		
		public Pedido obtenerPedidoConUnitarioMedioMasAlto() {
			Map<Pedido,Double> mapaCantidad = obtenerMapaMediaPorPedido();
			Double mayorUnitario=0.0;
			Pedido p1 = new Pedido();
			
			for (Pedido p: mapaCantidad.keySet()) {
				if(mapaCantidad.get(p)>mayorUnitario) {
					mayorUnitario= mapaCantidad.get(p);
					p1=p;
				}
			}
			
			return p1;
		}
		public Pedido obtenerPedidoConUnitarioMedioMasBajo() {
			Map<Pedido,Double> mapaCantidad = obtenerMapaMediaPorPedido();
			Double mayorUnitario=999999.0;
			Pedido p1 = new Pedido();
			
			for (Pedido p: mapaCantidad.keySet()) {
				if(mapaCantidad.get(p)<mayorUnitario) {
					mayorUnitario= mapaCantidad.get(p);
					p1=p;
				}
			}
			
			return p1;
		}
		
		public Map<Cliente,Double> obtenerMapaClienteVip(){
			Map<Cliente,Double> mapaVip = new HashMap<>();
			listaPedidos.sort(new Comparator<Pedido>() {

				@Override
				public int compare(Pedido o1, Pedido o2) {
					// TODO Auto-generated method stub
					return o2.getCostePedido().compareTo(o1.getCostePedido());
				}
				
			});
			for(Pedido p: listaPedidos) {
				if (mapaVip.keySet().contains(p.getCliente())) {
					mapaVip.put(p.getCliente(), p.getCostePedido()+ mapaVip.get(p.getCliente()));
				}else {
					mapaVip.put(p.getCliente(), p.getCostePedido());
					
				}
			}
			
			return mapaVip;
		}
		
		public List<Cliente> obtenerClienteVip() {
			Map<Cliente,Double> mapaVip = obtenerMapaClienteVip();
			List<Cliente> listaClientesVip = new ArrayList<Cliente>();
			Double resultado =0.0;
			boolean encontrado=false;
			Integer contador=0;
			Cliente c1 = new Cliente();
			Iterator<Cliente> iterador = mapaVip.keySet().iterator();
			
			
			while(!encontrado && iterador.hasNext()) {
				c1=iterador.next();
					resultado= mapaVip.get(c1);
					listaClientesVip.add(c1);
					contador++;
					if(contador==3) {
						encontrado=true;

					}
					
				}
			
			
			return listaClientesVip;
		}
		
		public Map<Producto,Integer> obtenerMapaProductoEstrella(){
			Map<Producto,Integer> mapaProductoVip = new HashMap<>();
			
			for (Pedido p: listaPedidos) {
				for (Linea l: p.getListaLineas()) {
					if (mapaProductoVip.keySet().contains(l.getProducto())) {
						mapaProductoVip.put(l.getProducto(), l.getCantidad()+mapaProductoVip.get(l.getProducto()));
					}else {
						mapaProductoVip.put(l.getProducto(), l.getCantidad());
						
					}
				}
			}
			
			return mapaProductoVip;
		}
		
		public Producto obtenerProductoEstrella() {
			Map<Producto,Integer> mapaProductoVip = obtenerMapaProductoEstrella();
			Integer resultado=0;
			Producto p1 = new Producto();
			for (Producto p: mapaProductoVip.keySet()) {
				if (mapaProductoVip.get(p)>resultado) {
					resultado= mapaProductoVip.get(p);
					p1=p;
				}
			}
			return p1;
		}
		
		public Map<Pedido,Double> obtenerMapaConPreciosUnitarios(){
			Map<Pedido,Double> mapaCantidad= new HashMap<>();
			for (Pedido p: listaPedidos) {
				for (Linea l: p.getListaLineas()) {
					mapaCantidad.put(p, l.getProducto().getPrecioUnitario());
				}
			}
			return mapaCantidad;
			
		}
		
		public Map<Cliente,Integer> obtenerMapaConProductosPorCliente(){
			Map<Cliente,Integer> mapaClientes = new HashMap<>();
				for (Pedido p: listaPedidos) {
					if (!mapaClientes.containsKey(p.getCliente())) {
						mapaClientes.put(p.getCliente(), p.getNumeroProductos());
					}else if (mapaClientes.containsKey(p.getCliente())) {
						mapaClientes.put(p.getCliente(), p.getNumeroProductos()+mapaClientes.get(p.getCliente()));
					}
				}
			
			return mapaClientes;
		}
		
		public Cliente obtenerClienteConMasPedidos() {
			Map<Cliente,Integer> mapaClientes= obtenerMapaConProductosPorCliente();
			Integer mayorNumero=0;
			Cliente c1 = new Cliente();
			
			for (Cliente c: mapaClientes.keySet()) {
				if(mapaClientes.get(c)>mayorNumero) {
					mayorNumero=mapaClientes.get(c);
					c1=c;
				}
			}
			
			return c1;
		}
		
		public Pedido obtenerPedidoConUnitarioMasAlto() {
			Map<Pedido,Double> mapaCantidad = obtenerMapaConPreciosUnitarios();
			Double mayorUnitario=0.0;
			Pedido p1= new Pedido();
			
			for (Pedido p: mapaCantidad.keySet()) {
				if(mapaCantidad.get(p)>mayorUnitario) {
					mayorUnitario=mapaCantidad.get(p);
					p1=p;
				}
			}
			
			return p1;
		}
		
		
	public String listarClientesPorImporteVenta() {
		StringBuilder sb = new StringBuilder();
		listaPedidos.sort(new Comparator<Pedido>() {

			@Override
			public int compare(Pedido o1, Pedido o2) {
				
				return o2.getCostePedido().compareTo(o1.getCostePedido());
			}
		});
		for (Pedido p:listaPedidos) {
			
			sb.append(p.getCliente() +"\n");
			sb.append(p.getCostePedido()+"\n");
		}
		return sb.toString();
	}
	
	public String mostrarClientesPorEdad() {
		lista.sort(new ComparadorEdad());
		return lista.toString();
	}
	
	public Map<Cliente,Set<Producto>> mostrarProductosPorCliente() {
		Map<Cliente,Set<Producto>> productosPorCliente = new HashMap<>();
		for (Pedido p : listaPedidos) {
			for (Linea l: p.getListaLineas()) {
				if (!productosPorCliente.containsKey(p.getCliente())) {
					productosPorCliente.put(p.getCliente(), new HashSet<>());
					productosPorCliente.get(p.getCliente()).add(l.getProducto());
				}else {
					productosPorCliente.get(p.getCliente()).add(l.getProducto());
					
				}
			}
			
			
			
		}
		return productosPorCliente;
	}
	
	public String mostrarPedidosYLineasPorId() {
		StringBuilder sb = new StringBuilder();
		listaPedidos.sort(new ComparadorPorID());
		for (Pedido p: listaPedidos) {
			sb.append(p);
			sb.append("---");
		}
		return sb.toString();
	}
	
	public String mostrarPedidosYLineasPorPrecio() {
		listaPedidos.sort(new ComparadorPorPrecio());
		StringBuilder sb = new StringBuilder();
		for (Pedido p: listaPedidos) {
			sb.append(p);
			sb.append("---");
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return "Negocio [lista=" + lista + ", listaPedidos=" + listaPedidos + ", listaCatalogo=" + listaCatalogo + "]";
	}
}
