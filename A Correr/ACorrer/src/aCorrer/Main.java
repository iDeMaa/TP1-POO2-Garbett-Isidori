package aCorrer;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("carrera2.in"));
			PrintWriter pw = new PrintWriter(new File("carrera2.out"));
			int cantCompetidores = s.nextInt();
			int cantCategF = s.nextInt();
			int cantCategM = s.nextInt();
			int cantFinalistas = s.nextInt();

			if (cantCompetidores >= 1 && cantCompetidores <= 1000000 && cantCategF >= 1 && cantCategF <= 60
					&& cantCategM >= 1 && cantCategM <= 60 && cantFinalistas >= 0
					&& cantFinalistas <= cantCompetidores) {
				Competencia competencia = new Competencia(cantCompetidores, cantCategF, cantCategM, cantFinalistas);
				competencia.crearCategorías(s);
				competencia.inscribirCompetidores(s);
				competencia.registrarLlegados(s, pw);
				s.close();
				pw.close();
			} else {
				System.out.println("Error de entrada");
				System.exit(-1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
