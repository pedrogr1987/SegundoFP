package respositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.CriaturaFantasticasException;
import modelos.Criatura;
import modelos.Criatura.Tipo;

public class Diario {
	private static final Logger logger = LogManager.getLogger(Diario.class);

	private Map<LocalDate,Criatura> criaturas;
	private LocalDate hoy; 

	public Diario() {
		this.criaturas = new HashMap<>();
		this.hoy = LocalDate.now();	

		}
	
	public Diario construyeDiario(List<Criatura> lista){
		
	 for(Criatura c: lista){
		 this.criaturas.put(hoy, c);
		 hoy = hoy.plusDays(1);
	 
	 //Genero objeto diario con mi mapa
	 }
	 return this;
	}
	
	public void addEntrada(LocalDate fecha, Criatura criatura) throws CriaturaFantasticasException {
		if (criaturas.containsKey(fecha) && criaturas.get(fecha).equals(criatura)){
			throw new CriaturaFantasticasException("Ya existe registro para esta criatura");}
		else {
			criaturas.put(fecha, criatura);
			logger.debug("Criatura" + criatura.getNombre() +" añadida con fecha " + fecha);
		}
	}
	public void eliminarEntrada(LocalDate fecha) throws CriaturaFantasticasException {
		if (criaturas.containsKey(fecha)){
			criaturas.remove(fecha);
			logger.debug("Se eliminó la entrada con fecha " + fecha);
		}
		else {
			throw new CriaturaFantasticasException("No existe registro para esta fecha");}
		}
	public void eliminarEntrada(Criatura cri) throws CriaturaFantasticasException {
		if (criaturas.containsValue(cri)){
			criaturas.remove(cri);
			logger.debug("Se eliminó la entrada de la criatura " + cri.getNombre());
		}
		else {
			throw new CriaturaFantasticasException("No existe registro para esta criatura");}
		}
	public List<Criatura> obtenerCriaturasDeTipo( Tipo tipo)  {
		List<Criatura> listaTipo = new ArrayList<>();
		for(Criatura c:criaturas.values()) {
			if(c.getTipo().equals(tipo)) {
				listaTipo.add(c);
			}
		}
		return listaTipo;
	}
	public String obtenerDetalleCriatura(String nombre, Tipo tipo) throws CriaturaFantasticasException {
		Criatura criaturaBuscada = new Criatura();
		for(Criatura c:criaturas.values()) {
			if(c.getNombre().equals(nombre)&&c.getTipo().equals(tipo)) {
				criaturaBuscada =c;
				return "La criatura " + criaturaBuscada.getNombre() + " es de tipo " + criaturaBuscada.getTipo() 
				+ " y peligrosidad " + criaturaBuscada.getPeligrosidad();
			}
	}
		if(criaturaBuscada==null) {
			throw new CriaturaFantasticasException("No existe registro para esta criatura");}
		return"";

		}
	}



