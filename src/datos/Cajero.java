package datos;

import java.time.LocalDate;

public class Cajero extends Staff {

	private String turno;
	private int numeroCaja;

	public Cajero() {}

	public Cajero(String nombre, String apellido, String dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, long sueldoBase, String turno, int numeroCaja) {
		super(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase);
		this.turno = turno;
		this.numeroCaja = numeroCaja;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public int getNumeroCaja() {
		return numeroCaja;
	}

	public void setNumeroCaja(int numeroCaja) {
		this.numeroCaja = numeroCaja;
	}

	@Override
	public String toString() {
		return "Cajero [" + super.toString() + ", turno=" + turno + ", numeroCaja=" + numeroCaja + "]";
	}
}
