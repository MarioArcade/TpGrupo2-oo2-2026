package datos;


import java.util.Set;


public abstract class UnidadVenta {

	protected long idUnidadVenta;
	protected String nombre;
	protected String lugar;
	protected long superficie;
	protected Staff encargado;
	protected String codigo;
	protected Set<Staff> staff;
	protected Set<Plato> platos;
	protected Festival festival;

	public UnidadVenta() {}

	

	public UnidadVenta(String nombre, String lugar, long superficie, Staff encargado, String codigo, Festival festival) {
		super();
		this.nombre = nombre;
		this.lugar = lugar;
		this.superficie = superficie;
		this.encargado = encargado;
		this.codigo = codigo;
		this.festival = festival;
	}
	



	public long getIdUnidadVenta() {
		return idUnidadVenta;
	}



	protected void setIdUnidadVenta(long idUnidadVenta) {
		this.idUnidadVenta = idUnidadVenta;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getLugar() {
		return lugar;
	}



	public void setLugar(String lugar) {
		this.lugar = lugar;
	}



	public long getSuperficie() {
		return superficie;
	}



	public void setSuperficie(long superficie) {
		this.superficie = superficie;
	}



	public Staff getEncargado() {
		return encargado;
	}



	public void setEncargado(Staff encargado) {
		this.encargado = encargado;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public Set<Staff> getStaff() {
		return staff;
	}



	public void setStaff(Set<Staff> staff) {
		this.staff = staff;
	}



	public Set<Plato> getPlatos() {
		return platos;
	}



	public void setPlatos(Set<Plato> platos) {
		this.platos = platos;
	}



	public Festival getFestival() {
		return festival;
	}



	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	/*
	public String generarCodigo(UnidadVenta u, String extra) {
		String codigo;
		String foodTrack = "FT";
		String Desarmable = "Des";
				
		if(u instanceof FoodTrack) {
			
			codigo = foodTrack + extra;
		}
		codigo = Desarmable + extra;
		
		return codigo;
	}
*/
	// Pendiente implementar lógica de negocio (validación propia del código de 10 caracteres)
	public boolean validarCodigo(String codigo) {
		throw new UnsupportedOperationException("Pendiente de implementar");
	}

	@Override
	public String toString() {
		return "UnidadVenta [idUnidadVenta=" + idUnidadVenta + ", nombre=" + nombre + ", lugar=" + lugar
				+ ", superficie=" + superficie + ", codigo=" + codigo + "]";
	}
}
