package models;

import java.util.Random;
import java.util.Scanner;

//Constructor
public class Cuenta {
	private String numeroCuenta;
	private float saldo;

	// Constructor
	public Cuenta(String numeroCuenta, float saldo) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
	}

	/**
	 * Devuelve el número de una cuenta
	 * 
	 * @return número de cuenta
	 */
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	/**
	 * Devuelve el saldo de una cuenta
	 * 
	 * @return saldo cuenta
	 */
	public float getSaldo() {
		return saldo;
	}

	/*
	 * Recibir abono
	 * 
	 */
	public void recibirAbono() {

		float cantidad = cantidadDinero();
		if (cantidad > 0) {
			saldo += cantidad;
		}

		System.out.println("-----------------------------------RECIBO-----------------------------------");
		System.out.println("Ha ingresado " + cantidad + " en la cuenta " + numeroCuenta);
		System.out.println("El saldo de la cuenta actual es " + saldo);
		System.out.println("----------------------------------------------------------------------------");
	}

	/**
	 * Preguntar la cantidad de dinero con la que va a realizar la operación
	 * 
	 * @return Dinero
	 */
	public float cantidadDinero() {
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
					System.out.println("Lo siento no se puede ingresar menos de 0 €");
				} else {
					escorrecto = true;
				}
			} catch (Exception e) {
				escorrecto = false;
			}

		}

		return dinero;
	}

	/*
	 * Pagar un recibo
	 */
	public void pagarRecibo() {
		float cantidad = cantidadDinero();

		if (cantidad > 0) {

			saldo -= cantidad;
		}

		System.out.println("-----------------------------------RECIBO-----------------------------------");
		System.out.println("Ha pagado " + cantidad + " en la cuenta " + numeroCuenta);
		System.out.println("El saldo de la cuenta actual es " + saldo);
		System.out.println("----------------------------------------------------------------------------");
	}

	/**
	 * quitar el dinero de la cuenta desde la que se va a realizar la transferencia
	 * @param cantidad
	 */
	public void obtenerTransferencia(float cantidad) {

		if (saldo < 0) {
			System.out.println("Usted está en números rojos");
		} else {
			if (cantidad > 0.00f) {

				saldo -= cantidad;
			}
		}

	}

	/**
	 * Sumar dinero de la transferencia a una cuenta
	 * @param dinero
	 */
	public void realizarTransferencia(float dinero) {
		if (dinero> 0) {
			saldo += dinero;
		}

	}

	/*
	 * Crea un número aleatorio para las cuenta
	 * 
	 */
	public static String siguienteNumeroCuenta() {
		Random r = new Random();
		int iban = r.nextInt(89) + 10;
		int codigoentidad = r.nextInt(8999) + 1000;
		int codigooficina = r.nextInt(8999) + 1000;
		int codigocontrol = r.nextInt(8999) + 1000;
		int numcuentainterno1 = (r.nextInt(89999) + 10000);
		int numcuentainterno2 = (r.nextInt(89999) + 10000);

		return "ES" + iban + " " + codigoentidad + " " + codigooficina + " " + codigocontrol + " " + numcuentainterno1
				+ "" + numcuentainterno2;
	}

	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + "]";
	}
}
