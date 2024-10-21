package servicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelos.Criatura;
import modelos.Criatura.Tipo;
import respositorio.Diario;


public class ManejaFicheroCriaturas {
	private Diario diario;
	public Diario getDiario() {
		return diario;
	}
	public void setDiario(Diario diario) {
		this.diario = diario;
	}
	public List<Criatura> leerCsvCriaturas(File fichero2) throws IOException {
	    final Logger logger = LogManager.getLogger(ManejaFicheroCriaturas.class);
	    Scanner in = null;
	    List<Criatura> criaturitas = new ArrayList<>();
	    Set<String> nombresCriaturas = new HashSet<>(); // Para verificar duplicados
	    try {
	        FileReader fichero = new FileReader(fichero2);
	        in = new Scanner(fichero);
        	in.useDelimiter(",|\\n|\\r");

	        if (in.hasNextLine()) {
	            String encabezado = in.nextLine(); 
	            in.useLocale(Locale.ENGLISH);
	        }

	        while (in.hasNext()) {
	            Criatura crit = new Criatura(); // Crear nueva instancia
	            crit.setNombre(in.next());
	            crit.setInmortal(Boolean.parseBoolean(in.next()));
	            crit.setPeligrosidad(Integer.parseInt(in.next()));
	            crit.setMagia(Integer.parseInt(in.next()));
	            crit.setTipo(Tipo.valueOf(in.next()));

	            if (nombresCriaturas.contains(crit.getNombre())) {
	                logger.error("Criatura " + crit.getNombre() + " está duplicada");
	                File archivoerror = new File("C:\\Users\\pedro\\eclipse-workspace\\FantasticBeasts\\src\\main\\resources\\errors.log");
	                archivoerror.createNewFile();
	                
	                try (FileWriter errorEscr = new FileWriter(archivoerror, true);
	                     PrintWriter out = new PrintWriter(errorEscr)) {
	                	
	                    out.printf("%s: CRIATURA REPETIDA%n", crit.getNombre());
	                    //out.close();
	                }
	                catch (IOException e) {
	                    logger.error("Error al escribir en el archivo de errores: " + e.getMessage());
	                }
	            } else {
	                criaturitas.add(crit);
	                nombresCriaturas.add(crit.getNombre()); // Agregar nombre al conjunto
	            }
	        }

	    } catch (FileNotFoundException e) {
	        logger.error("Excepción al acceder al fichero " + fichero2 + ": " + e.getMessage());
	    } finally {
	        if (in != null) {
	            in.close();
	        }
	    }
	    return criaturitas;
	}
	public void generaFicheroResumen(File fichero, File destino) throws IOException {//hacerlo tomando el Diario ya construido previamente
		Diario diario2 = new Diario();
		diario2 = diario2.construyeDiario(leerCsvCriaturas(fichero));
		this.diario = diario2;//leerCsvCriaturas(rutaFichero)
		List<Criatura> bestias =diario2.obtenerCriaturasDeTipo(Tipo.BESTIA);
		List<Criatura> espiritus = diario2.obtenerCriaturasDeTipo(Tipo.ESPÍRITU);
		List<Criatura> seres = diario2.obtenerCriaturasDeTipo(Tipo.SER);
		PrintWriter out =null;
				try{
					destino.createNewFile();
			FileWriter escritor = new FileWriter(destino);
			 out = new PrintWriter(escritor);

			if(!bestias.isEmpty()) {

			out.printf("%s%n%s%n%s%n","=================================================",
					 "BESTIAS",
					 "================================================="); 
			for(Criatura criat: bestias) {
				out.printf("%s%n",criat.getNombre() + " " + criat.getInmortal() +
				" " + criat.getPeligrosidad() + " " + criat.getMagia() );
				}
			}
		
			if(!espiritus.isEmpty()){

			out.printf("%s%n%s%n%s%n","=================================================",
					 "ESPIRITUS",
					"================================================="); 
			for(Criatura criat: espiritus) {
				out.printf("%s%n",criat.getNombre() + " " + criat.getInmortal() +
				" " + criat.getPeligrosidad() + " " + criat.getMagia());
				}	
			}
			if(!seres.isEmpty()) {

				out.printf("%s%n%s%n%s%n","=================================================",
						"SERES",
						 "================================================="); 
			for(Criatura criat: seres) {
				out.printf("%s%n",criat.getNombre() + " " + criat.getInmortal() +
				" " + criat.getPeligrosidad() + " " + criat.getMagia());
					}
							
				}
		}catch(FileNotFoundException e) {//para no propagarlo al main. EL manejo de excepciones debe hacerse antes del controlador
		
		}
		
	finally		{
		if (out != null) {
			out.close();
		}
	}	



	}
/*Devolver List<Criatura> leoCSVCriatura(String rutaFichero)
 * void escriboFichero(List<Criatura> criaturas, String rutaFichero)*/
}
