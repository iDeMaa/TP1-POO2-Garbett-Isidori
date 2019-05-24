package aCorrer;

import java.io.PrintWriter;
import java.util.Scanner;

public class Competencia {
	private int cantCompetidores, cantCategF, cantCategM, cantFinalistas;
	private Competidor[] competidores;
	private Categoría[] categorías;

	public Competidor[] getCompetidores() {
		return competidores;
	}

	public void setCompetidores(Competidor[] competidores) {
		this.competidores = competidores;
	}

	public Categoría[] getCategorías() {
		return categorías;
	}

	public void setCategorías(Categoría[] categorías) {
		this.categorías = categorías;
	}

	public int getCantCompetidores() {
		return cantCompetidores;
	}

	public void setCantCompetidores(int cantCompetidores) {
		this.cantCompetidores = cantCompetidores;
	}

	public int getCantCategF() {
		return cantCategF;
	}

	public void setCantCategF(int cantCategF) {
		this.cantCategF = cantCategF;
	}

	public int getCantCategM() {
		return cantCategM;
	}

	public void setCantCategM(int cantCategM) {
		this.cantCategM = cantCategM;
	}

	public int getCantFinalistas() {
		return cantFinalistas;
	}

	public void setCantFinalistas(int cantFinalistas) {
		this.cantFinalistas = cantFinalistas;
	}

	public Competencia(int cantCompetidores, int cantCategF, int cantCategM, int cantFinalistas) {
		setCantCompetidores(cantCompetidores);
		setCantCategF(cantCategF);
		setCantCategM(cantCategM);
		setCantFinalistas(cantFinalistas);
		competidores = new Competidor[cantCompetidores]; //Vector que contiene cada competidor
		categorías = new Categoría[cantCategF + cantCategM]; //Vector que contiene la cantidad total de categorías (F+M)
	}

	//Método que crea las categorías según la edad y sexo
	public void crearCategorías(Scanner s) {
		for (int i = 0; i < getCantCategF() + getCantCategM(); i++) {
			if (i < getCantCategF()) { //Las primeras getCantCategF() son las categorías femeninas
				categorías[i] = new Categoría(s.nextInt(), s.nextInt(), 'F'); //Y creo la categoría dentro del vector
			} else { //Las otras son las categorías masculinas
				categorías[i] = new Categoría(s.nextInt(), s.nextInt(), 'M'); //Y creo la categoría dentro del vector
			}
		}
	}

	//Método para inscribir a los competidores y meterlos en la categoría correspondiente
	public void inscribirCompetidores(Scanner s) { 
		for (int i = 0; i < getCantCompetidores(); i++) {
			int edad = s.nextInt();
			char sexo = s.next().charAt(0);
			for (int j = 0; j < getCantCategF() + getCantCategM(); j++) {
				if (sexo == categorías[j].getSexo() && edad >= categorías[j].getEdadMin()
						&& edad <= categorías[j].getEdadMax()) { //Por cada copetidor, y por cada categoría, verifico si el sexo y la edad coincide
					competidores[i] = new Competidor(edad, i + 1, sexo, categorías[j]); //Y creo al Competidor con su edad, su número de competidor, su sexo y categoría correspondiente
				}
			}
		}
	}

	//Método para registrar a los finalistas y ganadores
	public void registrarLlegados(Scanner s, PrintWriter pw) {
		for (int i = 0; i < this.getCantFinalistas(); i++) {
			int numCompetidor = s.nextInt() - 1;
			if (competidores[numCompetidor].getCategoría().getOro() == null) { //Si la categoría del competidor NO tiene un competidor que ganó la medalla de Oro
				competidores[numCompetidor].getCategoría().setOro(competidores[numCompetidor]); //Asigno a éste competidor como ganador de la medalla de Oro
			} else if (competidores[numCompetidor].getCategoría().getPlata() == null) { //Si la categoría del competidor NO tiene un competidor que ganó la medalla de Plata
				competidores[numCompetidor].getCategoría().setPlata(competidores[numCompetidor]); //Asigno a éste competidor como ganador de la medalla de Plata
			} else if (competidores[numCompetidor].getCategoría().getBronce() == null) { //Si la categoría del competidor NO tiene un competidor que ganó la medalla de Bronce
				competidores[numCompetidor].getCategoría().setBronce(competidores[numCompetidor]); //Asigno a éste competidor como ganador de la medalla de Bronce
			}
		}
		//Una vez que termina de registrar a los llegados guardo a los ganadores de medallas
		for (int i = 0; i < this.getCantCategF() + this.getCantCategM(); i++) { //Por cada categoría:
			if(i < this.getCantCategF()) { //Si i < getCantCategF() entonces la categoría es femenina
				pw.print((i+1) + "\t"); //Escribo el número de categoría
				if(categorías[i].getOro() != null) { //Si el ganador de Oro existe
					pw.print(categorías[i].getOro().getNumCompetidor() + "\t"); //Escribo el número del competidor
				} else { //Si no:
					pw.print("0\t"); //Escribo un 0
				}
				if(categorías[i].getPlata() != null) { //Si el ganador de Oro existe
					pw.print(categorías[i].getPlata().getNumCompetidor() + "\t"); //Escribo el número del competidor
				} else { //Si no:
					pw.print("0\t"); //Escribo un 0
				}
				if(categorías[i].getBronce() != null) { //Si el ganador de Oro existe
					pw.print(categorías[i].getBronce().getNumCompetidor() + "\n"); //Escribo el número del competidor
				} else { //Si no:
					pw.print("0\n"); //Escribo un 0
				}
			} else { //Si i>getCantCategF() entonces la categoría es masculina
				pw.print((i-this.getCantCategF()+1) + "\t");  //Escribo el número de categoría (i-getCantCategF()+1 para empezar a contar desde 1 de nuevo, porque es la primera categoría masculina)
				if(categorías[i].getOro() != null) { //Si el ganador de Oro existe
					pw.print(categorías[i].getOro().getNumCompetidor() + "\t"); //Escribo el número del competidor
				} else { //Si no:
					pw.print("0\t"); //Escribo un 0
				}
				if(categorías[i].getPlata() != null) { //Si el ganador de Oro existe
					pw.print(categorías[i].getPlata().getNumCompetidor() + "\t"); //Escribo el número del competidor
				} else { //Si no:
					pw.print("0\t"); //Escribo un 0
				}
				if(categorías[i].getBronce() != null) { //Si el ganador de Oro existe
					pw.print(categorías[i].getBronce().getNumCompetidor() + "\n"); //Escribo el número del competidor
				} else { //Si no:
					pw.print("0\n"); //Escribo un 0
				}
			}
		}
	}

}
