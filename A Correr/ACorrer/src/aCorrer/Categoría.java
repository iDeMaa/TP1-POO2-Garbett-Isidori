package aCorrer;

public class Categoría {

	private int edadMin, edadMax;
	private char sexo;
	private Competidor oro, plata, bronce;

	public int getEdadMin() {
		return edadMin;
	}

	public void setEdadMin(int edadMin) {
		this.edadMin = edadMin;
	}

	public int getEdadMax() {
		return edadMax;
	}

	public void setEdadMax(int edadMax) {
		this.edadMax = edadMax;
	}
	
	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Competidor getOro() {
		return oro;
	}

	public void setOro(Competidor oro) {
		this.oro = oro;
	}

	public Competidor getPlata() {
		return plata;
	}

	public void setPlata(Competidor plata) {
		this.plata = plata;
	}

	public Competidor getBronce() {
		return bronce;
	}

	public void setBronce(Competidor bronce) {
		this.bronce = bronce;
	}

	public Categoría(int edadMin, int edadMax, char sexo) {
		setEdadMin(edadMin);
		setEdadMax(edadMax);
		setSexo(sexo);
	}
}
