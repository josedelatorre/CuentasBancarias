package models;

public class Persona {
	private final int numCuentasMax = 3;
	private String DNI;
	private Cuenta[] cuentas = new Cuenta[numCuentasMax];

	public Persona(String dNI) {
		DNI = dNI;
	}

	public Persona(String dNI, Cuenta[] cuentas) {
		DNI = dNI;
		this.cuentas = cuentas;
	}
	
	public void imprimirEstadoCuenta(){
		for (Cuenta cuenta : cuentas) 
			if(cuenta != null) 
				System.out.println("Cuenta " + cuenta.getNumeroCuenta() + " saldo: " + cuenta.getSaldo());
	}
	
	public void imprimirEstadoCuenta(int numCuenta){
		if(cuentas[numCuenta] != null) 
			System.out.println("Cuenta " + cuentas[numCuenta].getNumeroCuenta() + " saldo: " + cuentas[numCuenta].getSaldo());
	}
	
	
	public void recibirDinero(float cantidad, int numCuenta){
		if(numCuenta < this.numCuentasMax)
			cuentas[numCuenta].recibirAbono(cantidad);
		else
			System.out.println("La cuenta número: " + numCuenta + " no existe.");
	}
	
	public void pagarDinero(float cantidad, int numCuenta){
		if(numCuenta < this.numCuentasMax)
			cuentas[numCuenta].pagarRecibo(cantidad);
		else
			System.out.println("La cuenta número: " + numCuenta + " no existe.");
	}
	
	public void realizarTransferencia(int numCuenta1, int numCuenta2, float cantidad){
		pagarDinero(cantidad, numCuenta1);
		recibirDinero(cantidad, numCuenta2);
	}

	/**
	 * Comprueba si una persona es morosa o no
	 * 
	 * @return true si es morosa, false si no.
	 */
	public boolean esMorosa() {
		boolean esMorosa = false;
		for (Cuenta c : cuentas) {
			if (c != null) {
				if (c.getSaldo() < 0) {
					esMorosa = true;
				}
			}
		}
		return esMorosa;
	}

	public void nuevaCuenta() {
		this.nuevaCuenta(0);
	}
	
	public void nuevaCuenta(float ingresoInicial) {
		String numeroCuenta = Cuenta.siguienteNumeroCuenta();
		int numeroCuentas = this.numeroCuentas();
		
		if (this.numeroCuentas() < this.numCuentasMax) {
			cuentas[numeroCuentas] = new Cuenta(numeroCuenta, ingresoInicial); 
		} 
		else {
			System.out.println("La persona ya tiene el máximo de cuentas");
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

}
