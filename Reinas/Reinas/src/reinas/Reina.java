package reinas;

import java.util.ArrayList;
import java.util.List;

public class Reina {
	private int posY, posX, cantConflictos;
	private List<Integer> conflictos;

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getCantConflictos() {
		return cantConflictos;
	}

	public void setCantConflictos(int cantConflictos) {
		this.cantConflictos = cantConflictos;
	}

	public List<Integer> getConflictos() {
		return conflictos;
	}

	public void setConflictos(List<Integer> conflictos) {
		this.conflictos = conflictos;
	}

	public Reina(int posY, int posX) {
		this.posY = posY;
		this.posX = posX;
		conflictos = new ArrayList<Integer>();
	}
}
