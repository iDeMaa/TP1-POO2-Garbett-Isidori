package reinas;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("conflictos.in"));
			PrintWriter pw = new PrintWriter(new File("conflictos.out"));
			int dimTablero = s.nextInt();
			int cantReinas = s.nextInt();
			if(dimTablero >=1 && dimTablero <= 10000 && cantReinas >= 1 && cantReinas <= 50000) {
				Tablero tablero = new Tablero(dimTablero, cantReinas);
				tablero.GenerarTablero(s);
				//tablero.MostrarTablero();
				tablero.Resolver();
				for (int i = 0; i < tablero.getReinas().size(); i++) {
					pw.print(tablero.getReinas().get(i).getCantConflictos() + "\t");
					tablero.getReinas().get(i).getConflictos().sort(null);
					for (int j = 0; j < tablero.getReinas().get(i).getCantConflictos(); j++) {
						pw.print(tablero.getReinas().get(i).getConflictos().get(j) + "\t");
					}
					pw.println();
				}
			}
			s.close();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}