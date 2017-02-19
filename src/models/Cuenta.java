package models;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Cuenta {
	private String numeroCuenta;
	private String aliasCuenta;
	private float saldo;

	/**
	 * constructor cuenta con saldo inicial
	 * 
	 * @param numeroCuenta
	 *            numero de cuenta
	 * @param saldo
	 *            saldo inical
	 */
	public Cuenta(String numeroCuenta, float saldo) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
	}

	/**
	 * cuenta con saldo y alias
	 * 
	 * @param numeroCuenta
	 *            numero de cuenta
	 * @param saldo
	 *            saldo inicial
	 * @param aliasCuenta
	 *            alias de la cuenta
	 */
	public Cuenta(String numeroCuenta, float saldo, String aliasCuenta) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.aliasCuenta = aliasCuenta;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public float getSaldo() {
		return saldo;
	}

	/**
	 * ingreso en cuenta
	 * 
	 * @param cantidad
	 *            cantidad de pokemonedas a ingresar
	 */
	public void recibirAbono(float cantidad) {
		if (cantidad > 0) {
			saldo += cantidad;
		}
	}

	/**
	 * retirada de cuenta
	 * 
	 * @param cantidad
	 *            cantidad de pokemonedas a retirar
	 */
	public void pagarRecibo(float cantidad) {
		if (cantidad > 0) {
			saldo -= cantidad;
		}
	}

	/**
	 * generador numeros de cuenta aleatorios
	 * 
	 * @return numero de cuenta generado entre
	 */
	public static String siguienteNumeroCuenta() {

		return String.valueOf(ThreadLocalRandom.current().nextInt(100000000, 999999999));

	}
	
	
	public static String siguienteAliasCuenta(){
		
		char n; 
		Random rnd = new Random(); 
		String cadena = new String(); 
		for (int i=0; i < 10 ; i++) { 
		n = (char)(rnd.nextDouble() * 26.0 + 65.0 ); 
		cadena += n; } 
		
		return cadena;
	}

	public String getAliasCuenta() {
		return aliasCuenta;
	}

	public void setAliasCuenta(String aliasCuenta) {
		this.aliasCuenta = aliasCuenta;
	}

	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + " con alias " + aliasCuenta + "]";
	}
}
