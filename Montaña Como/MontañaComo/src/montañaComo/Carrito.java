package montañaComo;

public class Carrito {
	
	private int posX, posY, speed;

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Carrito(int posX, int posY) {
		setPosX(posX);
		setPosY(posY);
		setSpeed(0);
	}
	
	public String toString() {
		return ("X= " + this.getPosX() + " // Y= " + this.getPosY() + " // Speed= " + this.getSpeed());
	}
	

}
