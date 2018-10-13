package ar.edu.unlam.pb2;

public class Cliente implements Comparable<Cliente> {

	private String nombre;
	private Integer saldo;
	
	//CONSTRUCTOR
	public Cliente(String nombre, Integer saldo){
		this.nombre=nombre;
		this.saldo=saldo;
	}
	
	//METODS SET Y GET
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getSaldo() {
		return saldo;
	}
	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}
	
		
	//METODOS EQUALS Y HASHCODE
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	//SOBREESCRITURA DE METODDO compareTo
	@Override
	public int compareTo(Cliente otroCliente) {
		return this.nombre.compareTo(otroCliente.nombre);
	}
	
	
	
}
