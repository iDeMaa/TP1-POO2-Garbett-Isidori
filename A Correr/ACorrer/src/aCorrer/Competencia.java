package aCorrer;

import java.io.PrintWriter;
import java.util.Scanner;

public class Competencia {
	private int cantCompetidores, cantCategF, cantCategM, cantFinalistas;
	private Competidor[] competidores;
	private Categor�a[] categor�as;

	public Competidor[] getCompetidores() {
		return competidores;
	}

	public void setCompetidores(Competidor[] competidores) {
		this.competidores = competidores;
	}

	public Categor�a[] getCategor�as() {
		return categor�as;
	}

	public void setCategor�as(Categor�a[] categor�as) {
		this.categor�as = categor�as;
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
		categor�as = new Categor�a[cantCategF + cantCategM]; //Vector que contiene la cantidad total de categor�as (F+M)
	}

	//M�todo que crea las categor�as seg�n la edad y sexo
	public void crearCategor�as(Scanner s) {
		for (int i = 0; i < getCantCategF() + getCantCategM(); i++) {
			if (i < getCantCategF()) { //Las primeras getCantCategF() son las categor�as femeninas
				categor�as[i] = new Categor�a(s.nextInt(), s.nextInt(), 'F'); //Y creo la categor�a dentro del vector
			} else { //Las otras son las categor�as masculinas
				categor�as[i] = new Categor�a(s.nextInt(), s.nextInt(), 'M'); //Y creo la categor�a dentro del vector
			}
		}
	}

	//M�todo para inscribir a los competidores y meterlos en la categor�a correspondiente
	public void inscribirCompetidores(Scanner s) { 
		for (int i = 0; i < getCantCompetidores(); i++) {
			int edad = s.nextInt();
			char sexo = s.next().charAt(0);
			for (int j = 0; j < getCantCategF() + getCantCategM(); j++) {
				if (sexo == categor�as[j].getSexo() && edad >= categor�as[j].getEdadMin()
						&& edad <= categor�as[j].getEdadMax()) { //Por cada copetidor, y por cada categor�a, verifico si el sexo y la edad coincide
					competidores[i] = new Competidor(edad, i + 1, sexo, categor�as[j]); //Y creo al Competidor con su edad, su n�mero de competidor, su sexo y categor�a correspondiente
				}
			}
		}
	}

	//M�todo para registrar a los finalistas y ganadores
	public void registrarLlegados(Scanner s, PrintWriter pw) {
		for (int i = 0; i < this.getCantFinalistas(); i++) {
			int numCompetidor = s.nextInt() - 1;
			if (competidores[numCompetidor].getCategor�a().getOro() == null) { //Si la categor�a del competidor NO tiene un competidor que gan� la medalla de Oro
				competidores[numCompetidor].getCategor�a().setOro(competidores[numCompetidor]); //Asigno a �ste competidor como ganador de la medalla de Oro
			} else if (competidores[numCompetidor].getCategor�a().getPlata() == null) { //Si la categor�a del competidor NO tiene un competidor que gan� la medalla de Plata
				competidores[numCompetidor].getCategor�a().setPlata(competidores[numCompetidor]); //Asigno a �ste competidor como ganador de la medalla de Plata
			} else if (competidores[numCompetidor].getCategor�a().getBronce() == null) { //Si la categor�a del competidor NO tiene un competidor que gan� la medalla de Bronce
				competidores[numCompetidor].getCategor�a().setBronce(competidores[numCompetidor]); //Asigno a �ste competidor como ganador de la medalla de Bronce
			}
		}
		//Una vez que termina de registrar a los llegados guardo a los ganadores de medallas
		for (int i = 0; i < this.getCantCategF() + this.getCantCategM(); i++) { //Por cada categor�a:
			if(i < this.getCantCategF()) { //Si i < getCantCategF() entonces la categor�a es femenina
				pw.print((i+1) + "\t"); //Escribo el n�mero de categor�a
				if(categor�as[i].getOro() != null) { //Si el ganador de Oro existe
					pw.print(categor�as[i].getOro().getNumCompetidor() + "\t"); //Escribo el n�mero del competidor
				} else { //Si no:
					pw.print("0\t"); //Escribo un 0
				}
				if(categor�as[i].getPlata() != null) { //Si el ganador de Oro existe
					pw.print(categor�as[i].getPlata().getNumCompetidor() + "\t"); //Escribo el n�mero del competidor
				} else { //Si no:
					pw.print("0\t"); //Escribo un 0
				}
				if(categor�as[i].getBronce() != null) { //Si el ganador de Oro existe
					pw.print(categor�as[i].getBronce().getNumCompetidor() + "\n"); //Escribo el n�mero del competidor
				} else { //Si no:
					pw.print("0\n"); //Escribo un 0
				}
			} else { //Si i>getCantCategF() entonces la categor�a es masculina
				pw.print((i-this.getCantCategF()+1) + "\t");  //Escribo el n�mero de categor�a (i-getCantCategF()+1 para empezar a contar desde 1 de nuevo, porque es la primera categor�a masculina)
				if(categor�as[i].getOro() != null) { //Si el ganador de Oro existe
					pw.print(categor�as[i].getOro().getNumCompetidor() + "\t"); //Escribo el n�mero del competidor
				} else { //Si no:
					pw.print("0\t"); //Escribo un 0
				}
				if(categor�as[i].getPlata() != null) { //Si el ganador de Oro existe
					pw.print(categor�as[i].getPlata().getNumCompetidor() + "\t"); //Escribo el n�mero del competidor
				} else { //Si no:
					pw.print("0\t"); //Escribo un 0
				}
				if(categor�as[i].getBronce() != null) { //Si el ganador de Oro existe
					pw.print(categor�as[i].getBronce().getNumCompetidor() + "\n"); //Escribo el n�mero del competidor
				} else { //Si no:
					pw.print("0\n"); //Escribo un 0
				}
			}
		}
	}

}
