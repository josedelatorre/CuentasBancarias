package test;

import models.*;

public class Ventanilla {
	public static void main (String args[]){
		Persona p = new Persona("1234567Q");
		
		p.nuevaCuenta(700);
		p.nuevaCuenta(700);
		p.nuevaCuenta(700);
		for(String valor:p.verNumerosDeCuetas()){
			System.out.println(valor);
		}
		
		
		
	}
}
