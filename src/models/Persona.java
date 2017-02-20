package models;

public class Persona {
	private final int numCuentasMax = 3;
	private String DNI;
	private Cuenta[] cuentas = new Cuenta[numCuentasMax];

	public Persona(String dNI) {
		this.DNI = dNI;
	}

	public Persona(String dNI, Cuenta[] cuentas) {
		this.DNI = dNI;
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
				}
			}
		}
		return esMorosa;
	}
	
	public void nuevaCuenta(float ingresoInicial) {
		String numeroCuenta = Cuenta.siguienteNumeroCuenta();
		boolean end=false;
		
		if (this.numeroCuentas() < this.numCuentasMax) {
			for (int i=0; i<this.cuentas.length && !end; i++) {
				if (this.cuentas[i] == null) {
					cuentas[i] = new Cuenta(numeroCuenta, ingresoInicial);
					System.out.println("\nCuenta creada.");
					end=true;
				}
			}
		} 
		else {
			System.out.println("La persona ya tiene el máximo de cuentas");
		}
	}
	
	public void nuevaCuenta() {
		this.nuevaCuenta(0);
	}
	
	/**
	 * Muestra el numero de cuenta junto con el saldo de la misma.
	 * 
	 * @return Cuenta - Saldo.
	 */
	public void getSaldo(String cliente){
		System.out.println("\nCuentas:");
		for(int i=0; i<this.cuentas.length; i++){
			if(this.cuentas[i]!=null){
				System.out.printf("%s\t%s€\n", this.cuentas[i].getNumeroCuenta(), this.cuentas[i].getSaldo());
			}
		}
	}
	
	public void setTransferencia(int a, int b, float c){
		this.cuentas[a-1].pagarRecibo(c);
		this.cuentas[b-1].recibirAbono(c);
	}
	
	public int getCuentas(String cliente){
		int j=0;
		for(int i=0; i<this.cuentas.length; i++){
			if(this.cuentas[i]!=null){
				System.out.printf("Código: (%s)\tCuenta: %s\n", (i+1), this.cuentas[i].getNumeroCuenta());
				j++;
			}
		}
		return j;
	}
	
	public void setIngreso(int a, float b){
		this.cuentas[a-1].recibirAbono(b);
	}
	
	public void setRetirar(int a, float b){
		this.cuentas[a-1].pagarRecibo(b);
	}
	
	/**
	 * Borra cuenta asociada
	 * 
	 * @return Borrar cuenta
	 */
	public void borrarCuenta(int a){
		boolean end=false;
		for(int i=0; i<this.cuentas.length; i++){
			if(i==(a-1)){
				this.cuentas[i]=null;
			}
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
