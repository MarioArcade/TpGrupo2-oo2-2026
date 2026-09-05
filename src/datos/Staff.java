package datos;

import java.time.LocalDate;

public abstract class Staff {

	protected long idStaff;
	protected String nombre;
	protected String apellido;
	protected String dni;
	protected int edad;
	protected LocalDate fechaNacimiento;
	protected LocalDate fechaIngreso;
	protected long sueldoBase;
	protected boolean encargado;
	public Staff() {}

	public Staff(String nombre, String apellido, String dni,LocalDate fechaNacimiento,
			LocalDate fechaIngreso, long sueldoBase) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = validarEdad(fechaNacimiento);
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.sueldoBase = sueldoBase;
		this.encargado = false;
	}

	public long getIdStaff() {
		return idStaff;
	}

	protected void setIdStaff(long idStaff) {
		this.idStaff = idStaff;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public long getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(long sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	

	public boolean isEncargado() {
		return encargado;
	}

	public void setEncargado(boolean encargado) {
		this.encargado = encargado;
	}

	
	public Long antiguedad() {
		LocalDate fecha = LocalDate.now();
		long tiempo = 0;
		int aI,mI,dI,aA,mA,dA;
	    aI = this.getFechaIngreso().getYear();
		mI = this.getFechaIngreso().getMonthValue();
		dI = this.getFechaIngreso().getDayOfMonth();
		aA = fecha.getYear();
		mA = fecha.getMonthValue();
		dA = fecha.getDayOfMonth();
		tiempo = aA - aI;
		if(tiempo !=0) {
			if(mI>mA){
				tiempo--;
		}else {
			if(mI==mA && dI>dA) {
				tiempo--;
		  }
		 }
		}
		
		return tiempo;
	}
		
	public int validarEdad(LocalDate fechaNacimiento) {
		int edad = 0;
		int aN,mN,dN,aA,mA,dA;
		LocalDate fecha = LocalDate.now();
		aN = fechaNacimiento.getYear();
		mN = fechaNacimiento.getMonthValue();
		dN = fechaNacimiento.getDayOfMonth();
		aA = fecha.getYear();
		mA = fecha.getMonthValue();
		dA = fecha.getDayOfMonth();
		edad= aA - aN;
		
		if(mN>mA) {
			edad--;
		}else {
			if(mN==mA && dN>dA) {
				edad--;
			}
		}
		
		if(edad<18) {
			throw new UnsupportedOperationException("La persona es menor de edad");
		}
		
		return edad;
	}
	
	@Override
	public String toString() {
		return "Staff [idStaff=" + idStaff + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", edad=" + edad + ", fechaNacimiento=" + fechaNacimiento + ", fechaIngreso=" + fechaIngreso
				+ ", sueldoBase=" + sueldoBase + "]";
	}
}
