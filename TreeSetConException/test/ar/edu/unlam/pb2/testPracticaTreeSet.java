package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

import org.junit.Test;

public class testPracticaTreeSet {

	@Test
	public void testParaProbarQueNoSeAgreganClientesRepetidos(){
		System.out.println("Test No se Agregan Clientes Repetidos");
		
		Banco banco1=new Banco();
		
		try {
			banco1.agregarCliente(new Cliente("florencia",300));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			banco1.agregarCliente(new Cliente("alejandra",400));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			banco1.agregarCliente(new Cliente("alejo",180));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			banco1.agregarCliente(new Cliente("alejandra",200));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
						
		banco1.mostrarClientesOrdenadosPorNombre();
		assertEquals(3, banco1.getListaClientes().size());
	}
	@Test
	public void testBorraClientesQueNoSeEncuentranEnLaLista(){
		Banco banco1=new Banco();
		Cliente cliente1= new Cliente("ale",400);
		System.out.println("Test que borra clientes");
		try {
			banco1.agregarCliente(new Cliente("florencia",300));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			banco1.borrarCliente(cliente1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	@Test
	public void testQuePruebaMostrarClientesOrdenadorPorSaldo() { //orden especifico descendente
		Banco banco1=new Banco();
		try {
			banco1.agregarCliente(new Cliente("florencia",300));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			banco1.agregarCliente(new Cliente("alejandra",400));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			banco1.agregarCliente(new Cliente("alejo",180));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Test Clientes Ordenados Por Saldo");
		
		TreeSet<Cliente> listaOrdenadaPorSaldo= banco1.mostrarClientesOrdenadosPorSaldo();
		
		assertTrue(listaOrdenadaPorSaldo.first().getSaldo().equals(400));
		assertTrue(listaOrdenadaPorSaldo.last().getSaldo().equals(180));
		
		//otra forma de hacer el test
		int i=0; 
		for(Iterator<Cliente> it=listaOrdenadaPorSaldo.iterator();it.hasNext();){
			Cliente unCliente=it.next();
			switch(i){
			case 0:
				assertTrue(unCliente.getSaldo().equals(400));
				break;
			
			case 1:
				assertTrue(unCliente.getSaldo().equals(300));
				break;
			case 2:
				assertTrue(unCliente.getSaldo().equals(180));
				break;
			}
			i++;
			
		}
				
		
	}
	
	@Test
	public void testQuePruebaMostrarClientesOrdenadorPorNombre() {
		Banco banco1=new Banco();
		try {
			banco1.agregarCliente(new Cliente("florencia",300));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			banco1.agregarCliente(new Cliente("alejandra",400));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			banco1.agregarCliente(new Cliente("alejo",180));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Test Clientes Ordenados por Nombre");
		banco1.mostrarClientesOrdenadosPorNombre();
		assertTrue(banco1.getListaClientes().first().getNombre().equals("alejandra"));
		assertTrue(banco1.getListaClientes().last().getNombre().equals("florencia"));
	
		
	}
	
	
	@Test (expected=NoSuchElementException.class)
	public void testQuePruebaQueNextLanzaExcepcion() throws NoSuchElementException{
			Banco banco1=new Banco();
			try {
				banco1.agregarCliente(new Cliente("florencia",300));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				banco1.agregarCliente(new Cliente("alejandra",400));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				banco1.agregarCliente(new Cliente("alejo",180));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Test de Excepcion");
			banco1.mostrarClientes(); //este metodo puede devolver exception
		}

	
	@Test
	public void testRecorrerConForEach(){ //flor
			
		
			TreeSet<Cliente> lista= new TreeSet<Cliente>();
			lista.add(new Cliente("b",100));
			lista.add(new Cliente("c",100));
			lista.add(new Cliente("a",100));
			
			for (Cliente cliente : lista) {
				System.out.println(cliente.getNombre());
			}
	}
	
	@Test
	public void testRecorrerConIterator(){ //flor
				
		TreeSet<Cliente> lista= new TreeSet<Cliente>();
		lista.add(new Cliente("b",100));
		lista.add(new Cliente("c",100));
		lista.add(new Cliente("a",100));
		
		Iterator<Cliente> itCliente= lista.iterator();
		while(itCliente.hasNext()){
			System.out.println(itCliente.next().getNombre());
		}
	}
		

}
