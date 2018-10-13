package ar.edu.unlam.pb2;

import java.util.*;

public class Banco {

	private TreeSet<Cliente> listaClientes;
	
	//CONSTRUCTOR	
	public Banco(){
		listaClientes=new TreeSet<Cliente>();
		
		
	}
	//METODOS SET Y GET
	public TreeSet<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(TreeSet<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	
	
	//METODOS 
	
	public void agregarCliente(Cliente cliente) throws Exception{
		
		if(this.listaClientes.contains(cliente)){
			throw new Exception("El cliente" + " " + cliente.getNombre() + " " + "esta repetido");
		}
		else{
			this.listaClientes.add(cliente);
		}
		
		
		
	}
	
	public void borrarCliente(Cliente cliente) throws Exception{
		
		if(this.listaClientes.contains(cliente)){
			this.listaClientes.remove(cliente);
		}
		else{
			throw new Exception("El cliente" + " " + cliente.getNombre() + " " + "no se encuenta en la base de datos");
		}
	}
	
	public void mostrarClientesOrdenadosPorNombre(){ 
		Iterator<Cliente> itCliente=listaClientes.iterator();
		while(itCliente.hasNext()){
			
			System.out.println(itCliente.next().getNombre()); 
		}
	}
	
	public TreeSet<Cliente> mostrarClientesOrdenadosPorSaldo(){ 
//		CompararPorSaldo comp=new CompararPorSaldo();
//		TreeSet<Cliente> listaPorSaldo=new TreeSet<Cliente>(comp);
		TreeSet<Cliente> listaPorSaldo=new TreeSet<Cliente>(new CompararPorSaldo()); //lo anterior resumido en 1 linea
		listaPorSaldo.addAll(this.listaClientes);
		
		for (Cliente cliente : listaPorSaldo) {
			System.out.println(cliente.getSaldo() + " " + cliente.getNombre());
		}
		return listaPorSaldo;
	}
	
	public void mostrarClientes() throws NoSuchElementException{ 
		Iterator<Cliente> itCliente=listaClientes.iterator();
		for(int i=0;i<=listaClientes.size();i++){
			
			System.out.println(itCliente.next().getNombre()); 
		}
	}
	

}
