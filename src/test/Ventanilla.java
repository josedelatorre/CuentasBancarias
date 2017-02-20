package test;

import models.*;

public class Ventanilla {
	public static void main (String args[]){
		Persona p = new Persona("1234567Q");
		
		p.nuevaCuenta(0);
		p.nuevaCuenta(700);
		p.nuevaCuenta(700);
		
		//La persona recibe la nomina mensual (1100) en la primera cuenta
		p.recibirDinero(1100, 0);
		
		//La persona paga el alquiler (750) en la segunda cuenta
		p.pagarDinero(750, 1);
		
		if(p.esMorosa())
			System.out.println("La persona es morosa");
		else
			System.out.println("La persona no es morosa");
		
		p.realizarTransferencia(2, 1, 500);
		
		p.imprimirEstadoCuenta(2);
		
		p.imprimirEstadoCuenta();
	}
}
