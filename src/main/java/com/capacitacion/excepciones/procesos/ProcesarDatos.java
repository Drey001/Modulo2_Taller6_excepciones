package com.capacitacion.excepciones.procesos;

import com.capacitacion.excepciones.personalizadas.Personalizadas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ProcesarDatos {
	
	public int division(String numero1,String numero2) {
		int resultado = 0;
		try{
			resultado=Integer.valueOf(numero1)/Integer.valueOf(numero2);
		} catch (ArithmeticException e) {
			imprimirDetallesError(e);
		} catch (NumberFormatException e) {
			imprimirDetallesError(e);
		}
		return resultado;
		
	}
	
	
	public void arreglo(String[] lista) {

		try{
			for(int i=0;i<=5;i++) {
				System.out.println(lista[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e){
			imprimirDetallesError(e);
		}
	}
	
	public void fecha(String input) throws ParseException{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date   date  = format.parse (input );
			date.toString();
		} catch (ParseException e) {
			throw e;
		}
	}


	public static void imprimirDetallesError (Exception e){
		System.out.println("\nCause: " + e.getCause() + "\nMensaje: " + e.getMessage()
				+ "\nStack Trace: ");
		e.printStackTrace(System.out);
	}

	public void validarExistenciaArchivo(String nombre) throws Personalizadas {
		try{
			Scanner scan = new Scanner(new File(nombre));
		} catch (FileNotFoundException e){
			throw new Personalizadas("ARCHIVO NO ENCONTRADO", "EXCEPTION");
		}
	}

	public void leerArchivo(String input, String output) throws Personalizadas{
		String tempo = null;
		try{
			Scanner scan = new Scanner(new File(input));
			FileWriter salida = new FileWriter(output);
			while (scan.hasNextLine()){
				tempo = scan.nextLine();
				//String[] data = scan.nextLine().split(";");
				String[] data = tempo.split(";");
				String newReg = data[0] + ";" + data[2];
				System.out.println(newReg);
				salida.write(newReg +"\n");
			}
			salida.close();
			scan.close();
		} catch (FileNotFoundException e){
			e.printStackTrace(System.out);
			throw new Personalizadas("ARCHIVO NO ENCONTRADO", "EXCEPTION");
		} catch (IOException e) {
			throw new Personalizadas("ERROR ARCHIVO SALIDA", "ESCRITURA");
		} catch (ArrayIndexOutOfBoundsException e){
			throw new Personalizadas("Registro no valido: " + tempo, "Estructura");
		}
	}
}
