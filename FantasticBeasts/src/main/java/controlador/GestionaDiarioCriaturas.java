package controlador;
//cosas5
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.CriaturaFantasticasException;
import modelos.Criatura;
import modelos.Criatura.Tipo;
import servicio.ManejaFicheroCriaturas;

public class GestionaDiarioCriaturas {

public static void main(String[]args) throws FileNotFoundException {
	final Logger logger = LogManager.getLogger(ManejaFicheroCriaturas.class);

	/*Leo csv y devuelve mapa
	 * genero objeto diario con el mapa*/
	  //escriboFichero(List<Criatura> criaturas, String rutafichero)
	File fichero = new File("C:\\Users\\pedro\\eclipse-workspace\\FantasticBeasts\\src\\main\\resources\\criaturasfantasticas.csv");
	File results = new File ("C:\\Users\\pedro\\eclipse-workspace\\FantasticBeasts\\src\\main\\resources\\resultados.txt");
	ManejaFicheroCriaturas manejo = new ManejaFicheroCriaturas();
	try {
		manejo.leerCsvCriaturas(fichero);
		manejo.generaFicheroResumen(fichero, results);
		for(Criatura c:manejo.getDiario().obtenerCriaturasDeTipo(Tipo.SER)) {
			logger.debug(c.getNombre());
		
		}

			logger.debug(manejo.getDiario().obtenerDetalleCriatura("Kelpie", Tipo.BESTIA));
			Criatura crit = new Criatura("Goblin",false,30,40,Tipo.SER);
			manejo.getDiario().eliminarEntrada(crit);
		
	} catch (IOException | CriaturaFantasticasException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}

	
}

