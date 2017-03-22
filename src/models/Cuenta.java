package models;

public class Cuenta {
	private String numeroCuenta;
	private float saldo;
	
	/**
	 * Crea un nuevo objeto de tipo Cuenta con los parámetros especificados.
	 * @param numeroCuenta el número de cuenta identificativo que tendrá la cuenta.
	 * @param saldo el saldo inicial con el que contará la cuenta.
	 */
	public Cuenta(String numeroCuenta, float saldo) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
	}

	/**
	 * Devuelve el número de cuenta identificativo de la cuenta.
	 * @return el número de cuenta.
	 */
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	/**
	 * Devuelve el saldo actual de la cuenta.
	 * @return el saldo actual.
	 */
	public float getSaldo() {
		return saldo;
	}
	
	/**
	 * Ingresa una cantidad de dinero especificada en la cuenta.
	 * @param cantidad la cantidad de dinero a ingresar.
	 */
	public void recibirAbono(float cantidad){
		if(cantidad > 0){
			saldo += cantidad;
		}
	}
	
	/**
	 * Retira una cantidad de dinero especificada de la cuenta.
	 * @param cantidad la cantidad de dinero a retirar.
	 */
	public void pagarRecibo(float cantidad){
		if(cantidad > 0){
			saldo -= cantidad;
		}
	}	
	
	/**
	 * Devuelve un número de cuenta aleatorio convertido a String.
	 * @return número de cuenta aleatorio, como String.
	 */
	public static String siguienteNumeroCuenta(){
		return String.valueOf(Math.round(Math.random()*10000000));
	}

	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + "]";
	}
}
