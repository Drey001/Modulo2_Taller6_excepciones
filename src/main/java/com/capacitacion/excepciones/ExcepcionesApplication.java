package com.capacitacion.excepciones;


import java.io.FileNotFoundException;
import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.capacitacion.excepciones.procesos.ProcesarDatos;
import com.capacitacion.excepciones.personalizadas.*;
import static com.capacitacion.excepciones.procesos.ProcesarDatos.imprimirDetallesError;

@SpringBootApplication
public class ExcepcionesApplication {

	public static void main(String[] args) throws Personalizadas {
		SpringApplication.run(ExcepcionesApplication.class, args);
		
		//caso1();
		//caso2();
		//caso3();
		//caso4();
		caso5();
		
			
	}

	public static void caso1() {
		// cree una instancia de la clase ProcesarDatos y use el metodo division.
		ProcesarDatos procesa = new ProcesarDatos();
		//envie   los valores ("48", "0") - division por cero
		procesa.division("48","0");
		//en el metodo division capture e identifique la excepcion que se genera (no la excepcion general de java Exception) e imprima en consola  desde  el catch StackTrace,Cause,Message;
		//Done
		// haga lo mismo para los valores ("15.8", "30") 
		procesa.division("15.8", "30");
	}
	public static void caso2() {
		//cree una instancia de la clase ProcesarDatos y use el metodo division. y use metodo arreglo
		ProcesarDatos procesa = new ProcesarDatos();
		System.out.println("\n" + procesa.division("15","3"));
		//envie al metodo arry de string  de 3 valores para que se genere una excepcion.
		String[] arreglo = {"1","2","3"};
		procesa.arreglo(arreglo);
		//capture e identifique la excepcion que se genera (no la excepcion general de java Exception) e imprima en consola   StackTrace,Cause,Message del error; 
		//Done
	}
	
	public static void caso3() {
		
		//// cree una instancia de la clase ProcesarDatos y use el metodo fecha.
		ProcesarDatos procesa = new ProcesarDatos();
		//envie al metodo una fecha con el formato "yyyy/mm/dd".

		//capture e identifique la excepcion que se genera (no la excepcion general de java Exception) 
	    // Re-lance la excepcion y capturela aqui en el metodo case3 e imprima en consola StackTrace,Cause,Message del error;
		try{
			procesa.fecha("2021/01/20");
		}catch ( Exception e ){
			imprimirDetallesError(e);
		}
	}

	public static void caso4() {
		//manejo de excepciones personalizadas
		ProcesarDatos procesa = new ProcesarDatos();
		try{
			procesa.validarExistenciaArchivo("nacholee.txt");
		}catch (Personalizadas e){
			System.out.println("TIPO: PERSONALIZADA");
			imprimirDetallesError(e);
		}catch (Exception e){
			System.out.println("TIPO: EXCEPCION");
			imprimirDetallesError(e);
		}
	}
	
	public static void caso5() {
		//manejo de cierre de  objetos en lectura y escritura de arhivos
		ProcesarDatos procesa = new ProcesarDatos();
		try{
			procesa.leerArchivo("src/main/java/com/capacitacion/excepciones/datos/data.txt",
					"src/main/java/com/capacitacion/excepciones/datos/data2.txt");
		}catch (Exception e){
			imprimirDetallesError(e);
		}

	}
	

}
