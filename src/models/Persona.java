package models;

import java.util.Scanner;

public class Persona {
	private final int numCuentasMax = 3;
	private String DNI;
	private Cuenta[] cuentas = new Cuenta[numCuentasMax];
	@SuppressWarnings("unused")
	private Cuenta[] alias = new Cuenta[numCuentasMax];

	/**
	 * constructor persona sin cuentas
	 * 
	 * @param dNI
	 *            DNI persona
	 */
	public Persona(String dNI) {
		this.DNI = dNI;
	}

	/**
	 * constructor persona con cuentas
	 * 
	 * @param dNI
	 *            DNI persona
	 * @param cuentas
	 *            cuentas persona
	 */
	public Persona(String dNI, Cuenta[] cuentas) {
		this.DNI = dNI;
		this.cuentas = cuentas;
	}

	/**
	 * constructor con cuentas y alias de cuentas
	 * 
	 * @param dNI
	 *            DNI
	 * @param cuentas
	 *            numeros cuentas
	 * @param alias
	 *            alias cuentas
	 */
	public Persona(String dNI, Cuenta[] cuentas, Cuenta[] alias) {
		this.DNI = dNI;
		this.cuentas = cuentas;
		this.alias = alias;
	}

	/**
	 * Comprueba si una persona es morosa o no
	 * 
	 * @return true si es morosa, false si no.
	 */
	public void esMorosa() {
		@SuppressWarnings("unused")
		boolean esMorosa = false;
		for (Cuenta c : cuentas) {
			if (c != null) {
				if (c.getSaldo() < 0) {
					esMorosa = true;
					System.out.println("En la cuenta numero " + c + 1 + " con IBAN " + c.getNumeroCuenta() + " y alias "
							+ c.getAliasCuenta() + " tiene un saldo de " + c.getSaldo() + " pokemonedas.");
				}
			}
		}
	}

	/**
	 * Devuelve el numero de cuenta deseai
	 */
	public void numCuenta() {
		int entrada = 0;
		String repetir = "s";
		@SuppressWarnings("resource")
		Scanner aux = new Scanner(System.in);
		do {
			repetir = "";
			System.out.println("Tiene usted " + this.numeroCuentas() + " cuentas, ¿cual desea ver?");
			entrada = aux.nextInt();
			this.numCuenta(entrada);
			System.out.println("¿Desea ver otra cuenta? (s/n)");
			repetir = aux.next();
		} while (repetir == "s");
	}

	public void numCuenta(int num) {

		// System.out.println("La " + entrada + "ª " + cuentas[entrada -
		// 1]); Casi que me gusta mas esta impresion, pero es mas tosca.
		System.out.println("La " + num + "ª cuenta tiene numero " + cuentas[num - 1].getNumeroCuenta() + " y saldo de "
				+ cuentas[num - 1].getSaldo());
	}

	/**
	 * crea una cuenta nueva si tiene menos de 3
	 */
	public void nuevaCuenta() {
		this.nuevaCuenta(0);
	}

	/**
	 * crea una nueva cuenta con un ingreso inicial de pokemonedas
	 * 
	 * @param ingresoInicial
	 */
	public void nuevaCuenta(float ingresoInicial) {
		String numeroCuenta = Cuenta.siguienteNumeroCuenta();
		String aliasCuenta = Cuenta.siguienteAliasCuenta();
		int numeroCuentas = this.numeroCuentas();

		if (this.numeroCuentas() < this.numCuentasMax) {
			cuentas[numeroCuentas] = new Cuenta(numeroCuenta, ingresoInicial, aliasCuenta);
		} else {
			System.out.println("La persona ya tiene el maximo de cuentas");
		}
	}

	public void nuevaCuenta(float ingresoInicial, String Alias) {
		String numeroCuenta = Cuenta.siguienteNumeroCuenta();
		int numeroCuentas = this.numeroCuentas();

		if (this.numeroCuentas() < this.numCuentasMax) {
			cuentas[numeroCuentas] = new Cuenta(numeroCuenta, ingresoInicial, Alias);

		} else {
			System.out.println("La persona ya tiene el maximo de cuentas");
		}
	}

	/**
	 * Calcula el numero de cuentas creadas de la persona
	 * 
	 * @return Numero de cuentas creadas.
	 */
	private int numeroCuentas() {
		int cuentasCreadas = 0;
		for (Cuenta cuenta : this.cuentas) {
			if (cuenta != null) {
				cuentasCreadas++;
			}
		}
		return cuentasCreadas;
	}

	/**
	 * realiza un ingreso en una cuenta
	 * 
	 * @param cantidad
	 *            la cantidad a ingresar
	 */
	public void ingreso(float cantidad) {
		int num = 0;
		@SuppressWarnings("resource")
		Scanner aux = new Scanner(System.in);

		System.out.println("Tiene usted " + this.numeroCuentas() + " ¿en cual desea hacer el ingreso?");
		num = aux.nextInt();
		this.ingreso(500, num);
	}

	/**
	 * ingreso de pokemonedas en una cuenta
	 * 
	 * @param cantidad
	 *            cantidad a ingresar
	 * @param num
	 *            numero de orden de la cuenta
	 */
	public void ingreso(float cantidad, int num) {
		cuentas[num - 1].recibirAbono(cantidad);
		System.out.println("Se ha efectuado un abono de " + cantidad + " en la " + num + "ª cuenta.");

	}

	/**
	 * realiza una retirada previo control de dni
	 * 
	 * @param cantidad
	 *            cantidad a retirar
	 */
	public void pago(float cantidad) {
		int num = 0;
		String DNIcontrol = null;
		@SuppressWarnings("resource")
		Scanner aux = new Scanner(System.in);

		System.out.println("Para pagos de recibos se requiere el numero de DNI del propietario de la cuenta");
		do {
			System.out.println("Introduzca el DNI");
			DNIcontrol = aux.next();
		} while (!DNIcontrol.equals(this.DNI));

		System.out.println("Tiene usted " + this.numeroCuentas() + " cuentas,  ¿de cual desea emitir el pago?");
		num = aux.nextInt();
		this.pago(cantidad, num, DNIcontrol);
	}

	/**
	 * retirada de dinero de la cuenta
	 * 
	 * @param cantidad
	 *            cantidad a retirar
	 * @param num
	 *            numero de orden de la cuenta (1, 2 o 3)
	 * @param DNIcontrol
	 *            control de seguridad con DNI
	 */
	public void pago(float cantidad, int num, String DNIcontrol) {

		if (DNIcontrol.equals(this.DNI)) {
			cuentas[num - 1].pagarRecibo(cantidad);
		} else {
			System.out.println("ERROR, DNI no valido.");
		}
	}

	/**
	 * Transferencia entre cuentas
	 * 
	 * @param cantidad
	 *            cantidad a transferir
	 */
	public void transferencia(float cantidad) {
		int num1 = 0;
		int num2 = 0;
		@SuppressWarnings("resource")
		Scanner aux = new Scanner(System.in);

		System.out.println("Tiene usted " + this.numeroCuentas() + " cuentas, ¿cual es la cuenta de origen?");
		num1 = aux.nextInt();
		System.out.println("¿Cual es la cuenta de destino?");
		// cuentas[num1 - 1].pagarRecibo(cantidad);
		num2 = aux.nextInt();
		// cuentas[num2 - 1].recibirAbono(cantidad);
		this.transferencia(cantidad, num1, num2);
		System.out.println(
				"De la cuenta " + num1 + " a la cuenta " + num2 + " se han traspasado " + cantidad + " pokemonedas");
 
	}

	/**
	 * transferencia entre cuentas
	 * 
	 * @param cantidad
	 *            cantidad a traspasar
	 * @param num1
	 *            cuenta de origen
	 * @param num2
	 *            cuenta de destino
	 */
	public void transferencia(float cantidad, int num1, int num2) {

		cuentas[num1 - 1].pagarRecibo(cantidad);
		cuentas[num2 - 1].recibirAbono(cantidad);
		System.out.println(
				"De la cuenta " + num1 + " a la cuenta " + num2 + "se han traspasado " + cantidad + " pokemonedas");
	}

	/**
	 * Imprime todos los datos de la persona
	 */
	public void todosLosDatos() {
		System.out.println("DNI " + this.DNI);
		System.out.println("Cuentas " + this.numeroCuentas());
		for (Cuenta c : cuentas) {
			if (c != null) {
				System.out.println(c);

			}
		}
	}

	/**
	 * cambiar el alias de alguna cuenta por medio del orden
	 * 
	 * @param alias
	 *            nuevo alias
	 * @param ordenCuenta
	 *            numero de orden de la cuenta
	 */
	public void cambiarAlias(String alias, int ordenCuenta) {
		cuentas[ordenCuenta - 1].setAliasCuenta(alias);
		System.out.println("La cuenta numero " + cuentas[ordenCuenta - 1] + " ha cambiado su alias a " + alias + ".");
	}

	/**
	 * muestra todas las cuentas creadas de la persona
	 */
	public void todasLasCuentas() {
		for (Cuenta c : cuentas) {
			if (c != null) {
				System.out.println(c);

			}
		}
	}
}
