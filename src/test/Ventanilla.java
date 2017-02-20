package test;
import java.util.Scanner;
import models.*;

public class Ventanilla {
	
	public static Scanner sc=new Scanner(System.in);
	
	public static void main (String args[]){
		
		/**
		 * FALTA IMPLEMENTAR UNA CLASE PARA BASE DE DATOS DE CLIENTES
		 */
		
		// Declaración
		boolean salirPrograma=false;
		boolean salirOperador=false;
		int operador=0, operacion=0, maxOpcion=0;
		int codOrg=-1, codEnt=-1;
		String codigoOperador;
		
		// Proceso
		Persona p = new Persona(getCodigoUsuario("Introduzca del DNI: "));
		
		do{
			salirOperador=false;
			maxOpcion=3;
			operador=getOpcion(maxOpcion, ("¿Como desea identificarse?"
										+"\n(1) Cajero"
										+"\n(2) Cliente"
										+"\n(3) Salir"));
						
			switch (operador){
			case 1:
				// Cajero
				do{
					maxOpcion=3;
					operacion=getOpcion(maxOpcion, ("\n¿Que operación desea realizar?\n"
													+ "(1) Alta cliente\n"
													+ "(2) Baja cliente\n"
													+ "(3) Cambiar operador\n"
													+ "(4) Salir\n"));
					switch (operacion){
					case 1:
						// final Persona p = new Persona(getCodigoUsuario("\nIntroduzca del DNI: "));
						break;
					case 2:
						// codigoOperador=getCodigoUsuario("\nIntroduce el DNI del cliente: ");
						break;
					case 3:
						salirOperador=true;
						break;
					case 4:
						salirOperador=true;
						salirPrograma=true;
						break;
					}
				}while(!salirOperador);
				
				break;
			case 2:
				// Cliente
				
				codigoOperador=getCodigoUsuario("\nIntroduzca su DNI: ");
				do{
					maxOpcion=8;
					operacion=getOpcion(maxOpcion, ("\n¿Que operación desea realizar?\n"
													+ "(1) Ver saldo\n"
													+ "(2) Hacer transferencia\n"
													+ "(3) Ingresar dinero\n"
													+ "(4) Retirar dinero\n"
													+ "(5) Solicitar nueva cuenta\n"
													+ "(6) Dar de baja una cuenta\n"
													+ "(7) Cambiar operador\n"
													+ "(8) Salir\n"));
					switch (operacion){
					case 1:
						p.getSaldo(codigoOperador);
						break;
					case 2:
						System.out.println("\nCuentas");
						maxOpcion=p.getCuentas(codigoOperador);
						codOrg=getOpcion(maxOpcion, "\nSeleccione cuenta origen:");
						
						System.out.println("\nCuentas");
						maxOpcion=p.getCuentas(codigoOperador);
						codEnt=getOpcion(maxOpcion, "\nSeleccione cuenta destino:");
						
						float importe=getImporte("\nIntroduzca el importe:");
						
						p.setTransferencia(codOrg, codEnt, importe);
						break;
					case 3:
						System.out.println("\nCuentas");
						maxOpcion=p.getCuentas(codigoOperador);
						codOrg=getOpcion(maxOpcion, "\nSeleccione cuenta:");
						
						float ingreso=getImporte("\nIntroduzca el importe que desee ingresar:");
						
						p.setIngreso(codOrg, ingreso);
						break;
					case 4:
						System.out.println("\nCuentas");
						maxOpcion=p.getCuentas(codigoOperador);
						codOrg=getOpcion(maxOpcion, "\nSeleccione cuenta:");
						
						float retirar=getImporte("\nIntroduzca el importe que desee retirar:");
						
						p.setRetirar(codOrg, retirar);
						break;
					case 5:
						p.nuevaCuenta();
						break;
					case 6:
						System.out.println("\nCuentas");
						maxOpcion=p.getCuentas(codigoOperador);
						codOrg=getOpcion(maxOpcion, "\nSeleccione la cuenta que desea borrar:");
						
						p.borrarCuenta(codOrg);
						break;
					case 7:
						salirOperador=true;
						break;
					case 8:
						salirOperador=true;
						salirPrograma=true;
						break;
					}
				}while(!salirOperador);
				
				break;
			case 3:
				// Salir
				salirPrograma=!salirPrograma;
				break;
			}
			
		}while(!salirPrograma);
		
	}
		
	public static int getOpcion(int a, String texto){
		
		String aux;
		int numOpcion=0;
		boolean esCorrecto=false;
		
		do{
			System.out.println(texto);
			aux=sc.nextLine();
			
			try{
				numOpcion=Integer.parseInt(aux);
				esCorrecto=true;
			} catch (NumberFormatException e){
				System.out.println("\n¡Error! Formato incorrecto.\n");
				esCorrecto=false;
			}
			
			if(esCorrecto){
				if(numOpcion>=1 && numOpcion<=a)
					esCorrecto=true;
				else{
					System.out.println("\n¡Error! Opción incorrecta, elige una opción válida.");
					esCorrecto=false;
				}
			}
		}while(!esCorrecto);
		
		return numOpcion;
	}

	public static String getCodigoUsuario(String texto){
		
		String aux=null;
		String codigoUsuario;
		boolean esCorrecto=false;
		
		do{
			System.out.print(texto);
			aux=sc.nextLine();
			
			if(aux.length()==9){
				boolean cierreBucle=false;
				for(int i=0; i<aux.length() && !cierreBucle; i++){
					if(i>=0 && i<=7){
						if(aux.charAt(i)<0 && aux.charAt(i)>9){
							System.out.println("\n\nFormato incorrecto. (Ej: 12345678N)");
							esCorrecto=false;
							cierreBucle=true;
						}
						else
							esCorrecto=true;
							continue;
					}
					else if(i==8){
						if(aux.charAt(i)<'A' && aux.charAt(i)>'Z'){
							System.out.println("\n\nFormato incorrecto. (Ej: 12345678N)");
							esCorrecto=false;
							cierreBucle=true;
						}
						else if(aux.charAt(i)<'a' && aux.charAt(i)>'z'){
							System.out.println("\n\nFormato incorrecto. (Ej: 12345678N)");
							esCorrecto=false;
							cierreBucle=true;
						}
						else if(aux.charAt(i)>='a' && aux.charAt(i)<='z'){
							char[] arrayAux=aux.toCharArray();
							arrayAux[i]=aux.toUpperCase().charAt(i);
							aux=arrayAux.toString();
							
							esCorrecto=true;
						}
						else
							esCorrecto=true;
					}
				}
			}
			else{
				if(aux.length()>9)
					System.out.println("\n\nLongitud sobrepasada. (Ej: 12345678N)");
				else if(aux.length()<9)
					System.out.println("\n\nLongitud no alcanzada. (Ej: 12345678N)");
				
				esCorrecto=false;
			}
		}while(!esCorrecto);
		
		codigoUsuario=aux;
		return codigoUsuario;
	}

	public static float getImporte(String texto){
		String aux;
		float importe=0f;
		boolean esCorrecto=false;
		
		do{
			System.out.println(texto);
			aux=sc.nextLine();
			
			try{
				importe=Float.parseFloat(aux);
				esCorrecto=true;
			} catch(NumberFormatException e){
				System.out.println("\n¡Error! Formato incorrecto del importe.");
				esCorrecto=false;
			}
			
			if(esCorrecto && importe<=0){
				System.out.println("\n¡Error! No puede introducir valor igual o menor que 0.");
				esCorrecto=false;
			}
			else
				esCorrecto=true;
		}while(!esCorrecto);
		
		return importe;
	}
}