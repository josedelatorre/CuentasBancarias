package models;
import java.util.Random;

public class Cuenta {
	private String numeroCuenta;
	private float saldo;
	private static Random rnd = new Random();
	
	public Cuenta(String numeroCuenta, float saldo) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public float getSaldo() {
		return saldo;
	}
	
	public void recibirAbono(float cantidad){
		if(cantidad > 0){
			saldo += cantidad;
		}
	}
	
	public void pagarRecibo(float cantidad){
		if(cantidad > 0){
			saldo -= cantidad;
		}
	}	
	
	public static String siguienteNumeroCuenta(){
		String nuevaCuenta=String.valueOf(rnd.nextLong());
		// Pendiente: Hacer que el numero de cuenta sea entero.
		
		return nuevaCuenta;
	}

	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + "]";
	}
}
