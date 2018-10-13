package ar.edu.unlam.pb2;

import java.util.Comparator;

public class CompararPorSaldo implements Comparator<Cliente> {

	@Override
	public int compare(Cliente cliente1, Cliente cliente2) { //orden especifico descendente
		if(cliente1.getSaldo()<cliente2.getSaldo()){
			return 1;
		}
		if(cliente1.getSaldo()>cliente2.getSaldo()){
			return -1;
		}
		else{
			return 0;
		}
		
		
	}
	
	
}
