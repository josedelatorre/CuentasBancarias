package test;

import models.*;

public class Ventanilla {
	public static void main (String args[]){
				
		
		Persona p = new Persona("1234567Q");
		
		p.nuevaCuenta(700);
		p.nuevaCuenta(-700);
		p.nuevaCuenta(-300);
		
		//Cliente
		System.out.println(("----------------------------------------------------------------------------"));
		System.out.println("Deseo saber Cuantas cuentas tengo");
		System.out.println(p.numeroCuentas());
		
		System.out.println(("----------------------------------------------------------------------------"));
		System.out.println("Deseo saber el número de mi cuenta");
		System.out.println(p.cuentas[p.preguntarCuenta()].getNumeroCuenta());
		
		
		System.out.println(("----------------------------------------------------------------------------"));
		System.out.println("Tengo alguna cuenta en negativo?");
		p.esMorosa();

		
		System.out.println(("----------------------------------------------------------------------------"));
		System.out.println("Quiero saldar la deuda");
		p.cuentas[p.preguntarCuenta()].pagarRecibo();
		
		System.out.println(("----------------------------------------------------------------------------"));
		
	}
}