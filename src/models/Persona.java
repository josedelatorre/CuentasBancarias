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
					break;
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
		} else {
			System.out.println("La persona ya tiene el m�ximo de cuentas");
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

	public void ingresarEnCuenta(float ingreso, int numeroCuenta) {
		numeroCuenta--;
		if(ingreso < 0.0f || numeroCuenta < 0 || numeroCuenta > this.numCuentasMax)
			return;
		
		cuentas[numeroCuenta].recibirAbono(ingreso);
	}

	public void pagarRecibo(float cantidadEnviar, int numeroCuenta) {
		numeroCuenta--;
		if(cantidadEnviar < 0.0f || numeroCuenta < 0 || numeroCuenta > this.numCuentasMax)
		{
			System.out.println("Error");
			return;
		}
		cuentas[numeroCuenta].pagarRecibo(cantidadEnviar);
	}
	
	public void transferir(float cantidad, int scr, int dst){
		scr--;
		dst--;
		if(cantidad < 0 || cantidad > cuentas[scr].getSaldo())
		{
			System.out.println("No es posible la transferencia");
			return;
		}
		
		cuentas[scr].pagarRecibo(cantidad);
		cuentas[dst].recibirAbono(cantidad);
		
	}
	
	public float getSaldoCuenta(int numCuenta) {
		numCuenta--;
		if(numCuenta < 0 || numCuenta > this.numCuentasMax)
		{
			System.out.println("Numero de cuenta no existente");
			return 0.0f;
		}
		return cuentas[numCuenta].getSaldo();
	}
}
