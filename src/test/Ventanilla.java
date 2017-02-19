package test;

import models.*;

public class Ventanilla {
	public static void main(String args[]) {
		Persona p = new Persona("1234567Q");

		p.nuevaCuenta(700); // creamos la primera cuenta
		p.esMorosa(); // no devuelve nada al no ser moroso aun
		p.todosLosDatos(); // muestra los datos introducidos hasta ahora

		// p.numCuenta(); //pide datos por teclado

		p.nuevaCuenta(700, "primera"); // la segunda cuenta con alias
		p.todasLasCuentas(); // nos muestra las dos cuentas creadas hasta ahora
		p.nuevaCuenta(-100, "morosa"); // tercera cuenta con saldo negativo y alias
		p.numCuenta(3); // nos muestra los datos de la tercera cuenta

		// p.numCuenta(); //pide datos por teclado

		p.esMorosa(); // control morosidad

		// p.ingreso(200); //pide datos por teclado

		p.ingreso(200, 3); // ingreso de 200 en la cuenta numero 3
		p.cambiarAlias("Ahorros", 3); //cambio de alias de la cuenta numero 3
		// p.esMorosa();

		p.nuevaCuenta(700); // intento de abrir una cuarta cuenta con alias aleatorio
		p.todasLasCuentas();

		// p.pago(300); //pide datos por teclado

		p.pago(300, 2, "123"); // intento fallido de retirar efectivo
		p.pago(300, 2, "1234567Q"); // retirada de efectivo o pago de recibo

		// p.transferencia(500); //pide datos por teclado

		p.transferencia(500, 2, 3); // trasferencia entre cuenta 2 y cuenta 3 de
									// 500 pokemonedas
		p.esMorosa(); // control de morosidad
		p.todasLasCuentas(); // muestra todas las cuentas creadas

	}
}
