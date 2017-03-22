package models;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	private String DNI;
	private List<Cuenta> cuentas = new ArrayList<Cuenta>();

	/**
	 * Crea un nuevo objeto tipo Persona
	 * @param dNI El DNI con el que se identificará a la persona.
	 */
	public Persona(String dNI) {
		DNI = dNI;
	}

	//Eliminado segundo constructor
	
	/**
	 * Muestra por consola el estado actual de las cuentas.
	 */
	public void imprimirEstadoCuenta(){
		for (Cuenta cuenta : cuentas) 
			if(cuenta != null) 
				System.out.println("Cuenta " + cuenta.getNumeroCuenta() + " saldo: " + cuenta.getSaldo());
	}
	
	/**
	 * Muestra por consola el estado actual de la cuenta pasada por parámetro.
	 * @param numCuenta El número de cuenta de la que queremos información.
	 */
	public void imprimirEstadoCuenta(int numCuenta){
		if(cuentas.get(numCuenta) != null) 
			System.out.println("Cuenta " + cuentas.get(numCuenta).getNumeroCuenta() + " saldo: " + cuentas.get(numCuenta).getSaldo());
	}
	
	/**
	 * Ingresa una cantidad de dinero en una cuenta bancaria especificada.
	 * @param cantidad la cantidad de dinero a ingresar.
	 * @param numCuenta el numero de cuenta destino.
	 */
	public void recibirDinero(float cantidad, int numCuenta, String DNI){
		if(this.DNI.equals(DNI))
			cuentas.get(numCuenta).recibirAbono(cantidad);
		else
			System.out.println("La acreditación no es válida.");
	}
	
	/**
	 * Retira una cantidad de dinero en una cuenta bancaria especificada.
	 * @param cantidad cantidad de dinero a retirar.
	 * @param numCuenta el numero de cuenta afectada.
	 */
	public void pagarDinero(float cantidad, int numCuenta){
		if(this.DNI.equals(DNI))
			cuentas.get(numCuenta).pagarRecibo(cantidad);
		else
			System.out.println("La acreditación no es válida.");
	}
	
	/**
	 * Realiza un traspaso de dinero entre la primera cuenta especificada y la segunda.
	 * @param numCuenta1 la cuenta de la que se quiere extraer el dinero.
	 * @param numCuenta2 la cuenta en la que se quiere recibir el dinero.
	 * @param cantidad la cantidad de dinero que se quiere traspasar.
	 */
	public void realizarTransferencia(int numCuenta1, int numCuenta2, float cantidad,String DNI){
		pagarDinero(cantidad, numCuenta1);
		recibirDinero(cantidad, numCuenta2,DNI);
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

	/**
	 * Crea una nueva cuenta sin ingreso inicial.
	 */
	public void nuevaCuenta() {
		this.nuevaCuenta(0);
	}
	
	/**
	 * Crea una nueva cuenta con un ingreso inicial especificado.
	 * @param ingresoInicial la cantidad de dinero a ingresar.
	 */
	public void nuevaCuenta(float ingresoInicial) {
		String numeroCuenta = Cuenta.siguienteNumeroCuenta();
		cuentas.add(new Cuenta(numeroCuenta,ingresoInicial));
	}
}
