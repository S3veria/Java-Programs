//Programa para el examen final de programacion
//Santiago Reyes y Adan Galindo
//30/11/2018
//Cajero que te deja crear una cuenta y utilizar sus funciones despues


import java.util.Scanner;

class account {
	//Variables requeridas para la creacion de la cuenta y para las 6 funciones que contiene
	String owner;
	//La variable "money" es la que se manipula atraves de todo el programa
	double money;
	//Se necesitan muchas variables de "NIP" debido a que se tiene que utilizar en string por si fuera a ser algo como "0001"
	//Estas variables tambien se utilizan para comprobar el valor del nip y poderlo compararlo cuando sea necesario
	String nipp, NIP;
	int lengthofnip, nip, nipi;
	String message;
	int answer;
	
	//Constructor en el que se crea la cuenta
	account(String own, double cantini, String nipini){
		//establecer las variables
		owner=own;
		money=cantini;
		NIP=nipini;
	}
	
	//Las siguientes funciones son "String" debido a que lo que regresa es "Message", en caso de un error, manda un mensaje y te regresa al menu
	
	//Funcion para deposito
	String deposito(double cantidad) {
		//Revisar que la variable no sea negativa
		if (cantidad<0) {
			message="No puedes depositar cantidades negativas, intentalo de nuevo o selecciona otra opcion \n";
		}
		else {
			money=money+cantidad;
			message="Transaccion completada";
		}
		System.out.println(message);
		return message;
	}
	
	//Funcion para retiro
	String retiro(double cantidad) {
		//Revisar que no estes haciendo un retiro mayor al saldo que tiene la cuenta
		if((money-cantidad)<0) {
			message="No puedes retirar mas que el saldo de la cuenta, intentalo de nuevo o selecciona otra opcion \n";
		}
		
		//Revisar que la cantidad del retiro no sea negativa
		else if(cantidad<0) {
			message="No puedes retirar cantidades negativas, intentalo de nuevo o selecciona otra opcion\n";
		}
		
		//Si el input no tiene errores, se ejecuta el retiro
		else {
			money=money-cantidad;
			message="Transaccion completada \n";
		}
		System.out.println(message);
		return message;

	}
	
	
	//Funcion cambio de NIP
	String cambiodenip(String INT) {
		
		//Esto es en caso de que el cambio de nip sea exitoso, este remplaza al nip previo en persona.money
		message="Has cambiado tu NIP con exito \n";
		NIP=INT;
		System.out.println(message);
		return message;
	}
		
	
	
	//Funcion de consultar el saldo
	String consultarsaldo() {
		//Esta funcion no tiene excepciones
		message=("Tu saldo actual es de "+money+ "\n");
		System.out.println(message);
		return message;
	}

	
	
	//Funcion para salir del cajero
	String salir() {
		message="Gracias por tu visita, "+owner;
		System.out.println(message);
		return message;
	}
	
	//Funcion para la tranferecia de dinero a otra cuenta, lo cual sirve similar al retiro (restando una cantidad a la cuenta)
	String transferencia(String numcuenta, double cantidaddetrans, String nombrecillo) {
		
		//Revisar que no se intente transferir cantidades negativas
		if (cantidaddetrans<0) {
			message="No se puede transefir cantidades negativas, intentalo de nuevo o selecciona otra opcion \n";
		}
		//Revisar que no se transfiera una cantidad mayor a la del saldo de la cuenta
		else if(cantidaddetrans>money) {
			message="La cantidad de tranferencia no puede ser mayor al saldo de la cuenta, intentalo de nuevo o selecciona otra opcion \n";
		}
		//En este else se ejecuta la transferencia
		else {
			message="La transferencia se completo con exito a la cuenta "+numcuenta+", preteneciendo a "+nombrecillo+"\n";
			money=money-cantidaddetrans;
		}
		System.out.println(message);
		return message;
				
	}
	
public static class FinaldeProgramacion {
	public static void main(String[] args) {
		
	//Inicio del metodo en si
	
		//WOW, CUANTAS VARIABLES
		//Estas se utilizas mayormente para los inputs del teclado, para que se puedan interpretar
		//Aqui tambien tenemos variable para revisar el largo del nip, forzando que tenga cuatro digitos
		int opcion, inicio;
		String nombre, nombredetrans, nombretittrans;
		double credito, cant, cantidaddetrans;
		int largodelnip, triesfornip, largonipnuevo;
		int checkfor4, checkforfour, trynip, NIPI;
		String NIP, variable, nuevonip ;
		
		//Input para crear la cuenta, si no se presona "1", el programa se termina
		Scanner creation= new Scanner(System.in);
		System.out.println("Presiona '1' para crear una cuenta e inicializar el cajero");
		inicio=creation.nextInt();
		
		//Todo el prigrama yace dentro de este if, si no se crea la cuenta, no se ejecuta el cajero
		if (inicio==1) {
		
		//Datos para la cuenta
		//Nombre del titular de la tarjeta
		Scanner cosa= new Scanner(System.in);
		System.out.println("Dame el nombre del titular de la tarjeta");
		nombre=cosa.nextLine();
		
		//Saldo inicial de la tarjeta
		Scanner cosa2= new Scanner(System.in);
		System.out.println("Cual es el saldo inicial de la tarjeta");
		credito=cosa2.nextDouble();
		
		//Se establece un string vacio para poderlo llamar y cambiar mas tarde
		NIP="";
		
		checkfor4=1;
		
		//Este while esta hecho para forzar que el NIP tenga cuatro digitos
		while(checkfor4==1) {
			Scanner cosa3=new Scanner(System.in);
			System.out.println("Crea un NIP de 4 digitos");
			variable=cosa3.nextLine();
			largodelnip=String.valueOf(variable).length();
			
			if(largodelnip!=4) {
				System.out.println("El NIP tiene que tener 4 digitos, intentalo de nuevo");
				checkfor4=1;
			}
			else {
				NIP=variable;
				checkfor4=2;
			}
			
		}
		
		
		//finalmente se crea el objeto basado en los inputs del usuario
		account persona=new account(nombre, credito, NIP);
		
		
		
		
		cant=0;
		opcion=0;
		
		//En este while esta ubicado el resto del programa, haciendo que te exponga el menu despues de cada input
		//"Opcion 6" es el de salida, siempre y cuando el input no sea 6, el menu se expone
		while(opcion!=6) {
			Scanner cosa4=new Scanner(System.in);
			//Menu
			System.out.println("\nPara hacer un deposito, presione '1' \n"
					+ "Para hacer un retiro, presione '2' \n"
					+ "Para cambiar su NIP, presione '3' \n"
					+ "Para consultar su saldo, presione '4 \n"
					+ "Para hacer una transferencia, presione '5' \n"
					+ "Para salir, presione '6'\n");
			opcion=cosa4.nextInt();
			//Se establecen variables vacias para poderlas llamar
			triesfornip=0;
			nuevonip="";
			switch(opcion) {
				//Case 1 es el de deposito
				case 1:
					Scanner cosa11=new Scanner(System.in);
					System.out.println("Cuanto quieres depositar?");
					cant=cosa11.nextDouble();
					persona.deposito(cant);
					break;
				//Case 2 es el de retiro
				case 2:
					Scanner cosa12=new Scanner(System.in);
					System.out.println("Cuanto quieres retirar?");
					cant=cosa12.nextDouble();
					persona.retiro(cant);
					break;
				//Case 3 es el mas complejo, siendo el de cambio de NIP
				//En este caso, te pide tu nip original y si fallas tres veces te retiene la tarjeta y el programa finaliza	
				case 3:
					NIP=persona.NIP;
					checkforfour=1;
					NIPI=Integer.parseInt(NIP);
					Scanner cosa13=new Scanner(System.in);
					System.out.println("Cual es tu NIP actual?");
					trynip=cosa13.nextInt();
					triesfornip=0;
					//NIPI es la version INT del NIP, facilitando su comparacion con el input
					while (trynip!=NIPI) {
						System.out.println("Ese NIP es incorrecto");
						if(triesfornip<=1) {
							//En caso de fallar el NIP la primera vez, se ejecuta esto
							Scanner cosa14=new Scanner(System.in);
							System.out.println("Cual es tu NIP actual?");
							trynip=cosa14.nextInt();
							triesfornip=triesfornip+1;

					}
						//Este else se ejecuta cuando el usuario falla el NIP tres veces
						else  {
							System.out.println("No has podido cambiar tu NIP con exito");
							System.out.println("Tu tarjeta ha sido retenida por fraude, contactenos para areglarlo");
							//Haciendo que "checkforfour" sea 2, no se ejecuta el siguiente while, haciendo que tu NIP no cambie
							checkforfour=2;
							//Haciendo que opcion sea igual a 6, finaliza el while en el que se contiene el metodo
							opcion=6;
					break;

						}
						
					}

					//Si el input coincide con el de la cuenta, te permite cambiarlo
					while(checkforfour==1) {
						Scanner cosa15=new Scanner(System.in);
						System.out.println("Cual quieres que sea tu nuevo NIP?");
						nuevonip=cosa15.nextLine();
						largonipnuevo=String.valueOf(nuevonip).length();
						
						if(largonipnuevo!=4) {
							System.out.println("El NIP tiene que tener 4 digitos, intentalo de nuevo");
							checkforfour=1;
						}
						else {
							persona.cambiodenip(nuevonip);
							checkforfour=2;
						}
						
					}
					break;
					
				//Case para la consulta de saldo 
				case 4:
					persona.consultarsaldo();
					break;
				
				//Case para hacer una transferencia, en realidad no hay forma de que este truene, ya que no se especifio como tiene que ser le numero de cuenta
				case 5:
					Scanner cosa16=new Scanner(System.in);
					System.out.println("Cual es el numero de la cuenta a la que quieres hacer la transferencia?");
					nombredetrans=cosa16.nextLine();
					
					Scanner cosa18=new Scanner(System.in);
					System.out.println("Dame el nombre y apellido del titular de la cuenta?");
					nombretittrans=cosa18.nextLine();
					
					Scanner cosa17=new Scanner(System.in);
					System.out.println("Cuanto dinero deseas transferir a esta cuenta?");
					cantidaddetrans=cosa17.nextDouble();
					
					persona.transferencia(nombredetrans, cantidaddetrans, nombretittrans);
					break;
				
				//Case para la salida
				case 6:
					persona.salir();
					break;
				
				//El default es la excepcion, si el usuario utiliza un input que no sea un numero del 1 al 6, manda que la opcion es invalida
				default:
					System.out.println("Esta opcion no es valida, intentalo de nuevo");
					break;
					
			}


		}
				
		}
		//Este es el else que va con el if del inicio, si no se presiona '1', manda este mensaje y termina el programa
		else {
			System.out.println("Esa no es una opcion, vuelve a iniciar el cajero para crear una cuenta");
		}
			
					
	}
	}

}
