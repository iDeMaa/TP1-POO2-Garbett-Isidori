package montañaComo;

import java.io.PrintWriter;
import java.util.Scanner;

public class Montaña {

	private int cantCV;
	private int[] cimasYValles;
	private Carrito carrito;

	public int getCantCV() {
		return cantCV;
	}

	public void setCantCV(int cantCV) {
		this.cantCV = cantCV;
	}

	public int[] getCimasYValles() {
		return cimasYValles;
	}

	public void setCimasYValles(int[] cimasYValles) {
		this.cimasYValles = cimasYValles;
	}

	public Montaña(int cantCV) {
		setCantCV(cantCV);
		cimasYValles = new int[getCantCV()];
	}

	public void GenerarMontaña(Scanner s) {
		for (int i = 0; i < this.getCantCV(); i++) {
			cimasYValles[i] = s.nextInt(); //Guardo los valles y cimas en un vector
		}
		int posInicial = s.nextInt();
		carrito = new Carrito(posInicial, cimasYValles[0] - posInicial); //Creo el carrito
		System.out.println(carrito.toString()); 
	}

	public void EstudiarComportamiento(PrintWriter pw) {
		for (int i = 1; i < this.getCantCV(); i++) {
			if (this.esValle(i)) {
				carrito.setSpeed(carrito.getSpeed() + (carrito.getPosY() - this.cimasYValles[i]) - 1); //Le aumento la velocidad al carrito, y le resto 1 por la ley 4
				carrito.setPosX(carrito.getPosX() + (carrito.getPosY() - this.cimasYValles[i])); //Muevo al carrito en el eje X
				carrito.setPosY(carrito.getPosY() - (carrito.getPosY() - this.cimasYValles[i])); //Muevo al carrito en el eje Y
				System.out.println(carrito.toString());
			} else {
				if (carrito.getSpeed() - (this.cimasYValles[i] - carrito.getPosY()) + 1 <= 0) { //Verifico si al subir a la cima la velocidad es menor a 0. Si da true, el carrito no llega
					carrito.setPosX(carrito.getPosX() + carrito.getSpeed()); //Muevo al carrito en el eje X hasta donde le de la velocidad
					carrito.setPosY(carrito.getPosY() + carrito.getSpeed()); //Muevo el carrito en el eje Y hasta donde le de la velocidad
					carrito.setSpeed(0); //Le saco la velocidad al carrito
					System.out.println("RIP Carrito"); //RIP carrito :(
					pw.print(carrito.getPosX() + "\t" + carrito.getPosY()); //Guardo en el archivo
					System.out.println(carrito.toString());
					return; //Termina la función
				} else { //En caso de que llegue a la cima
					carrito.setSpeed(carrito.getSpeed() - (this.cimasYValles[i] - carrito.getPosY())); //Reduzco la velocidad del carrito según la distancia que suba
					carrito.setPosX(carrito.getPosX() + (this.cimasYValles[i] - carrito.getPosY())); //Muevo al carrito en el eje X
					carrito.setPosY(carrito.getPosY() + (this.cimasYValles[i] - carrito.getPosY())); //Muevo al carrito en el eje Y
					System.out.println(carrito.toString());
				}
			}
		}
	}

	private boolean esValle(int num) { //Función para ver si es una cima o un valle. Al estar alternadas, si I es par, es una cima. Si es impar, es un valle.
		if (num % 2 != 0) {
			return true;
		} else {
			return false;
		}
	}

}
