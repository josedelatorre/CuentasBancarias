package models;

public class Cuenta {
	private String numeroCuenta;
	private float saldo;
	
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
		return String.valueOf(Math.round(Math.random()*10000000));
	}

	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + "]";
	}
}
