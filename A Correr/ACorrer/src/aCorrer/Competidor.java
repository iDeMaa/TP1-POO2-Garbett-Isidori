package aCorrer;

public class Competidor {

	private int edad, numCompetidor;
	private char sexo;
	private Categor�a categor�a;

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

	public Categor�a getCategor�a() {
		return categor�a;
	}

	public void setCategor�a(Categor�a categor�a) {
		this.categor�a = categor�a;
	}

	public Competidor(int edad, int numCompetidor, char sexo, Categor�a categor�a) {
		setEdad(edad);
		setNumCompetidor(numCompetidor);
		setSexo(sexo);
		setCategor�a(categor�a);
	}
}
