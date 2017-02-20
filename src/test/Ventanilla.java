package test;

import java.util.Scanner;

import models.*;

public class Ventanilla {
	public static void main (String args[]){
				
		float dinero;
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
		p.cuentas[p.preguntarCuenta()].recibirAbono();
		
		System.out.println(("----------------------------------------------------------------------------"));
		System.out.println("Quiero realizar una transferencia");
		dinero=DineroVentanilla();
		p.cuentas[p.preguntarCuenta("De que cuenta quiere obtener el dinero")].obtenerTransferencia(dinero);	
		p.cuentas[p.preguntarCuenta("A que cuenta quiere ingresar el dinero")].realizarTransferencia(dinero);
	
	
		System.out.println(("----------------------------------------------------------------------------"));
		p.GetSaldoAllAcc();
		
	}
	
	
	
	
	/**
	 * Pregunta el dinero con el que realizar las operaciones en la ventanilla
	 * @return dinero
	 */
	public static float DineroVentanilla() {
		Scanner sc = new Scanner(System.in);
		boolean escorrecto = false;
		String aux;
		float dinero = 0.00f;

		while (escorrecto == false) {
			System.out.println("Con cuanto dinero desea realizar la operación");
			aux = sc.nextLine();

			try {

				dinero = Float.parseFloat(aux);
				if (dinero < 0) {
					System.out.println("Lo siento no se puede realizar operaciones con menos de 0 €");
				} else {
					escorrecto = true;
				}
			} catch (Exception e) {
				escorrecto = false;
			}

		}

		return dinero;
	}
}