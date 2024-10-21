package modelos;

import java.util.Objects;

public class Criatura {
	public enum Tipo {
		BESTIA,
		ESPÍRITU,
		SER
	}
	private String nombre;
	private Boolean inmortal;
	private Integer peligrosidad;
	private Integer magia;
	private Tipo tipo;
	public Criatura() {}

	public Criatura(String nombre, Boolean inmortal, Integer peligrosidad, Integer magia, Tipo tipo) {
		super();
		this.nombre = nombre;
		this.inmortal = inmortal;
		this.peligrosidad = peligrosidad;
		this.magia = magia;
		this.tipo = tipo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getInmortal() {
		return inmortal;
	}

	public void setInmortal(Boolean inmortal) {
		this.inmortal = inmortal;
	}

	public Integer getPeligrosidad() {
		return peligrosidad;
	}

	public void setPeligrosidad(Integer peligrosidad) {
		this.peligrosidad = peligrosidad;
	}

	public Integer getMagia() {
		return magia;
	}

	public void setMagia(Integer magia) {
		this.magia = magia;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criatura other = (Criatura) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals( tipo, other.tipo);
	
	}
	
}
