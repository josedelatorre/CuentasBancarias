package models;

import java.util.Scanner;

public class Persona {
	private final int numCuentasMax = 3;
	private String DNI;
	public Cuenta[] cuentas = new Cuenta[numCuentasMax];

	
//Constructor
	public Persona(String dNI) {
		DNI = dNI;
	}

	
	//Constructor
	public Persona(String dNI, Cuenta[] cuentas) {
		DNI = dNI;
		this.cuentas = cuentas;
	}

	/**
	 * Pregunta la cuenta en la que realizar las operaciones
	 * @return devuelve el número de cuenta
	 */
	public int preguntarCuenta() {
		
		Scanner sc= new Scanner (System.in);
		boolean escorrecto=false;
		String aux;
		int cuenta=0;
		
		while (escorrecto==false){
		System.out.println("En que cuenta desea realizar la operación");
		aux=sc.nextLine();
		
		try
		{

		cuenta=Integer.parseInt(aux);
		if(cuenta<=0 || cuenta>3){
			System.out.println("Lo siento la cuenta tiene que estar entre el 1 y el 3");
		}else{
		escorrecto=true;
		}
		}catch(Exception e){
			escorrecto=false;
		}
		
		}
		
		return cuenta-1;	
	}
	
	
	/**
	 * Pregunta la cuenta en la que realizar las operaciones
	 * @return devuelve el número de cuenta
	 */
	public int preguntarCuenta(String Mensaje) {
		
		Scanner sc= new Scanner (System.in);
		boolean escorrecto=false;
		String aux;
		int cuenta=0;
		
		while (escorrecto==false){
		System.out.println(Mensaje);
		aux=sc.nextLine();
		
		try
		{

		cuenta=Integer.parseInt(aux);
		if(cuenta<=0 || cuenta>3){
			System.out.println("Lo siento la cuenta tiene que estar entre el 1 y el 3");
		}else{
		escorrecto=true;
		}
		}catch(Exception e){
			escorrecto=false;
		}
		
		}
		
		return cuenta-1;	
	}
	
	
	/**
	 * Comprobación rápida de si es morosa
	 * @return booleano si es moroso
	 */
	public boolean comprobacionEsMorosa() {
		
		boolean esMorosa = false;
		Cuenta[] cuentasmorosas= new Cuenta[3];;
		int i=0;
		for (Cuenta c : cuentas) {
			if (c != null) {
				if (c.getSaldo() < 0) {
					esMorosa = true;
					cuentasmorosas[i]=c;
					i++;
				}

			}
		}
			return esMorosa;
		}
		

	
	/**
	 * Comprueba si una persona es morosa o no y muestra que cuentas son morosas
	 * 
	 */
	public void esMorosa() {
		
		boolean esMorosa = false;
		Cuenta[] cuentasmorosas= new Cuenta[3];;
		int i=0;
		for (Cuenta c : cuentas) {
			if (c != null) {
				if (c.getSaldo() < 0) {
					esMorosa = true;
					cuentasmorosas[i]=c;
					i++;
				}

			}
		}
		
		if(esMorosa==false)
		{
			System.out.println("Usted no debe dinero, todo está en orden");
		}

		if (i==1){
			System.out.println("Usted debe " +cuentasmorosas[0].getSaldo() + " € en la cuenta " + cuentasmorosas[0].getNumeroCuenta());
		}
		
		if (i>1)
		{		
				for (int x=0;x<cuentasmorosas.length-1;x++)
				{

				System.out.println("Usted debe " +cuentasmorosas[x].getSaldo() + " € en la cuenta " + cuentasmorosas[x].getNumeroCuenta() );
				}
		}

	}
	
	
	
	/**
	 * Nueva cuenta
	 */
	public void nuevaCuenta() {
		this.nuevaCuenta(0);
	}
	
	public void GetSaldoAllAcc()
	{
		
		for (Cuenta cuenta : this.cuentas) {
			if (cuenta != null){
				System.out.println(("-----------------------------SALDO---------------------------"));
				System.out.println(cuenta);
				}
		}
	}
	
	
	
	/**
	 * Nueva cuenta con saldo inicial
	 */
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
	public int numeroCuentas() {
		int cuentasCreadas = 0;
		for (Cuenta cuenta : this.cuentas) {
			if (cuenta != null) {
				cuentasCreadas++;
			}
		}
		return cuentasCreadas;
	}

}

