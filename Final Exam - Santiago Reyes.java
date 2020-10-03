import java.util.Scanner;

class sortme{
	//Constructor que ordena el arreglo
	void sort(int arr[]) {
    int largodelarreglo = arr.length;

    for (int i = 0; i < largodelarreglo-1; i++)
    {

        int minimo = i;
        for (int j = i+1; j < largodelarreglo; j++)
            if (arr[j] < arr[minimo])
                minimo = j;

        int cambio = arr[minimo];
        arr[minimo] = arr[i];
        arr[i] = cambio;
    }
}

//Print del arreglo
void printArray(int arr[])
{
    int largodelarreglo = arr.length;
    for (int i=0; i<largodelarreglo; ++i)
        System.out.print(arr[i]+" ");
    System.out.println();
}
}


public class ExamenFinal {
public static void main(String[] args) {
	//Santiago Reyes 27/05/20149
	//Programa para el final de programacion
	//Ordenamiento por seleccion
	int numerodenumeros;
	int addtoarray;
	
	
	//Define la cantidad de numeros del arreglo
	Scanner in = new Scanner(System.in);
    System.out.println("Cuantos numeros quieres ordenar?");
	numerodenumeros=in.nextInt();
	
	//Crea el arreglo
	int arreglo[]=new int[numerodenumeros];
	 
	//Llena el arreglo con los numeros elejidos
	for(int numeroextra=0;numeroextra<numerodenumeros;numeroextra++) {
		Scanner add =new Scanner(System.in);
		System.out.println("Cual va a ser tu numero "+(numeroextra+1));
		addtoarray=add.nextInt();
		
		arreglo[numeroextra]=addtoarray;
		
	}
	
	//Creacion del objeto
	sortme objetillo=new sortme();
	
	//Llama las funciones de la clase "sortme"
	objetillo.sort(arreglo);
	System.out.println("Arreglo ordenado:");
	objetillo.printArray(arreglo);
}
}
