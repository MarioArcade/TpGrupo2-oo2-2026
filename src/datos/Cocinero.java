package datos;

import java.time.LocalDate;

public class Cocinero extends Staff {

	private String especialidad;
	private String certificado;
	private int bonus;

	public Cocinero() {}

	public Cocinero(String nombre, String apellido, String dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, long sueldoBase, String especialidad, String certificado, int bonus) {
		super(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase);
		this.especialidad = especialidad;
		this.certificado = certificado;
		this.bonus = bonus;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getCertificado() {
		return certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}
	
	

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "Cocinero [" + super.toString() + ", especialidad=" + especialidad + ", certificado=" + certificado
				+ ", bonus=" + bonus + "]";
	}

	
}
