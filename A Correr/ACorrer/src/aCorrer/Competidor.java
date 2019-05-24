package aCorrer;

public class Competidor {

	private int edad, numCompetidor;
	private char sexo;
	private Categoría categoría;

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getNumCompetidor() {
		return numCompetidor;
	}

	public void setNumCompetidor(int numCompetidor) {
		this.numCompetidor = numCompetidor;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Categoría getCategoría() {
		return categoría;
	}

	public void setCategoría(Categoría categoría) {
		this.categoría = categoría;
	}

	public Competidor(int edad, int numCompetidor, char sexo, Categoría categoría) {
		setEdad(edad);
		setNumCompetidor(numCompetidor);
		setSexo(sexo);
		setCategoría(categoría);
	}
}
