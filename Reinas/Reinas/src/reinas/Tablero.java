package reinas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tablero {

	private int dimTablero;
	private Reina[][] tablero;
	private int cantReinas;
	private List<Reina> reinas;

	public int getDimTablero() {
		return dimTablero;
	}

	public void setDimTablero(int dimTablero) {
		this.dimTablero = dimTablero;
	}

	public Reina[][] getTablero() {
		return tablero;
	}

	public void setTablero(Reina[][] tablero) {
		this.tablero = tablero;
	}

	public void setCantReinas(int cantReinas) {
		this.cantReinas = cantReinas;
	}

	public int getCantReinas() {
		return cantReinas;
	}

	public List<Reina> getReinas() {
		return reinas;
	}

	public void setReinas(List<Reina> reinas) {
		this.reinas = reinas;
	}

	public Tablero(int dimTablero, int cantReinas) {
		setDimTablero(dimTablero);
		setCantReinas(cantReinas);
		tablero = new Reina[getDimTablero()][getDimTablero()]; //Genero el tablero de NxN
		reinas = new ArrayList<Reina>(); //Inicializo un ArrayList que va a contener las Reinas del tablero
	}

	public void GenerarTablero(Scanner s) {
		try {
			while (s.hasNextLine()) { //Leo las reinas del archivo

				int posY = s.nextInt() - 1;
				int posX = s.nextInt() - 1;
				Reina reina = new Reina(posY, posX); //Por cada reina creo un objeto
				reinas.add(reina); //Y lo guardo en el ArrayList para tenerlas ordenadas

				if (tablero[posY][posX] != null) { //En el caso en el que hayan reinas repetidas (en la misma posición) mando un error y finalizo el programa
					System.out.println("No pueden haber reinas repetidas");
					s.close();
					System.exit(-1);
				} else if (tablero[posY][posX] == null) {
					tablero[posY][posX] = reina; //Si no, pongo una Reina en la posición del tablero
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
	}

	//Método para comprobar si el tablero se genera correctamente. No tiene funcionalidad a la hora de resolver.
	/*public void MostrarTablero() { 
		System.out.println(this.getCantReinas());
		for (int i = 0; i < getDimTablero(); i++) {
			for (int j = 0; j < getDimTablero(); j++) {
				if (tablero[i][j] == null) {
					System.out.print("o\t");
				} else if (tablero[i][j] != null) {
					for (int k = 0; k < reinas.size(); k++) {
						if (tablero[i][j].equals(reinas.get(k))) {
							System.out.print(k + 1 + "\t");
						}
					}
				}
			}
			System.out.println();
		}
	} */

	public void Resolver() {
		for (int r = 0; r < reinas.size(); r++) { //Por cada reina:
			int posY = reinas.get(r).getPosY();
			int posX = reinas.get(r).getPosX();
			
			//Verifico sus lados y diagonales para encontrar conflictos

			// DIAGONALES
			// Diagonal abajo derecha
			for (int i = posY + 1, j = posX + 1; i < this.getDimTablero() && j < this.getDimTablero(); i++, j++) {
				if (tablero[i][j] != null) { //Si en toda la diagonal encuentra una posición del tablero que NO sea nula, significa que hay otra reina, y existe un conflicto
					reinas.get(r).setCantConflictos(reinas.get(r).getCantConflictos() + 1); //Aumento la cantidad de conflictos que tiene esa Reina
					reinas.get(r).getConflictos().add(this.verificarReina(i, j)); //Añado al ArrayList de Conflictos de la Reina a la otra Reina con el método "verificar Reina" (ver abajo)
					break;
				}
			}

			// Diagonal abajo izquierda
			for (int i = posY + 1, j = posX - 1; i < this.getDimTablero() && j >= 0; i++, j--) {
				if (tablero[i][j] != null) { //Si en toda la diagonal encuentra una posición del tablero que NO sea nula, significa que hay otra reina, y existe un conflicto
					reinas.get(r).setCantConflictos(reinas.get(r).getCantConflictos() + 1); //Aumento la cantidad de conflictos que tiene esa Reina
					reinas.get(r).getConflictos().add(this.verificarReina(i, j)); //Añado al ArrayList de Conflictos de la Reina a la otra Reina con el método "verificar Reina" (ver abajo)
					break;
				}
			}

			// Diagonal arriba derecha
			for (int i = posY - 1, j = posX + 1; i >= 0 && j < this.getDimTablero(); i--, j++) {
				if (tablero[i][j] != null) { //Si en toda la diagonal encuentra una posición del tablero que NO sea nula, significa que hay otra reina, y existe un conflicto
					reinas.get(r).setCantConflictos(reinas.get(r).getCantConflictos() + 1); //Aumento la cantidad de conflictos que tiene esa Reina
					reinas.get(r).getConflictos().add(this.verificarReina(i, j)); //Añado al ArrayList de Conflictos de la Reina a la otra Reina con el método "verificar Reina" (ver abajo)
					break;
				}
			}
			// Diagonal arriba izquierda
			for (int i = posY - 1, j = posX - 1; i >= 0 && j >= 0; i--, j--) {
				if (tablero[i][j] != null) { //Si en toda la diagonal encuentra una posición del tablero que NO sea nula, significa que hay otra reina, y existe un conflicto
					reinas.get(r).setCantConflictos(reinas.get(r).getCantConflictos() + 1); //Aumento la cantidad de conflictos que tiene esa Reina
					reinas.get(r).getConflictos().add(this.verificarReina(i, j)); //Añado al ArrayList de Conflictos de la Reina a la otra Reina con el método "verificar Reina" (ver abajo)
					break;
				}
			}

			// LADOS
			// Derecha
			for (int i = posX + 1; i < this.getDimTablero(); i++) {
				if (tablero[posY][i] != null) { //Si en todo el lado encuentra una posición del tablero que NO sea nula, significa que hay otra reina, y existe un conflicto
					reinas.get(r).setCantConflictos(reinas.get(r).getCantConflictos() + 1); //Aumento la cantidad de conflictos que tiene esa Reina
					reinas.get(r).getConflictos().add(this.verificarReina(posY, i)); //Añado al ArrayList de Conflictos de la Reina a la otra Reina con el método "verificar Reina" (ver abajo)
					break;
				}
			}
			// Izquierda
			for (int i = posX - 1; i >= 0; i--) {
				if (tablero[posY][i] != null) { //Si en todo el lado encuentra una posición del tablero que NO sea nula, significa que hay otra reina, y existe un conflicto
					reinas.get(r).setCantConflictos(reinas.get(r).getCantConflictos() + 1); //Aumento la cantidad de conflictos que tiene esa Reina
					reinas.get(r).getConflictos().add(this.verificarReina(posY, i)); //Añado al ArrayList de Conflictos de la Reina a la otra Reina con el método "verificar Reina" (ver abajo)
					break;
				}
			}
			// Abajo
			for (int i = posY + 1; i < this.getDimTablero(); i++) {
				if (tablero[i][posX] != null) { //Si en todo el lado encuentra una posición del tablero que NO sea nula, significa que hay otra reina, y existe un conflicto
					reinas.get(r).setCantConflictos(reinas.get(r).getCantConflictos() + 1); //Aumento la cantidad de conflictos que tiene esa Reina
					reinas.get(r).getConflictos().add(this.verificarReina(i, posX)); //Añado al ArrayList de Conflictos de la Reina a la otra Reina con el método "verificar Reina" (ver abajo)
					break;
				}
			}
			// Arriba
			for (int i = posY - 1; i >= 0; i--) {
				if (tablero[i][posX] != null) { //Si en todo el lado encuentra una posición del tablero que NO sea nula, significa que hay otra reina, y existe un conflicto
					reinas.get(r).setCantConflictos(reinas.get(r).getCantConflictos() + 1); //Aumento la cantidad de conflictos que tiene esa Reina
					reinas.get(r).getConflictos().add(this.verificarReina(i, posX)); //Añado al ArrayList de Conflictos de la Reina a la otra Reina con el método "verificar Reina" (ver abajo)
					break;
				}
			}
		}
	}

	//Método privado para verificar a la reina que está en (X;Y) posición del tablero
	private int verificarReina(int posY, int posX) { //Recibe como parámetro a la posición del tablero
		for (int i = 0; i < reinas.size() + 1; i++) { //Y verifica en todo el ArrayList de Reinas
			if (reinas.get(i).equals(tablero[posY][posX])) { //Si la Reina es la misma que está en esa posición del tablero
				return i + 1; //Y devuelve el número de la Reina (por orden de entrada)
			}
		}
		return -1; //Devuelvo -1 en caso de no encontrar
	}
}
