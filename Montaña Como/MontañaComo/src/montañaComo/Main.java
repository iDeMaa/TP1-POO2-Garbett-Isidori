package monta�aComo;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		try {
			Scanner s = new Scanner(new File("como.in"));
			PrintWriter pw = new PrintWriter(new File("como.out"));
			int cantCV = s.nextInt();
			if(cantCV >= 1 && cantCV <= 2000000) {
				Monta�a monta�a = new Monta�a(cantCV);
				monta�a.GenerarMonta�a(s);
				monta�a.EstudiarComportamiento(pw);
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
