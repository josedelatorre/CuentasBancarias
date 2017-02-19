package test;

import models.*;

public class Ventanilla {
	public static void main(String args[]) {
		Persona p = new Persona("1234567Q");
		Persona p2 = new Persona("1234567Q");

		p2.nuevaCuenta(100);
		p2.nuevaCuenta(750);
		p2.nuevaCuenta(1000);

		p2.ingresarEnCuenta(1100, 2);
		p2.pagarRecibo(750, 2);

		if (p2.esMorosa()) {
			System.out.println("Es morosa");
		} else {
			System.out.println("No es morosa");
		}

		p2.transferir(25, 1, 2);
		
		System.out.println(p2.getSaldoCuenta(2));
	}
}
