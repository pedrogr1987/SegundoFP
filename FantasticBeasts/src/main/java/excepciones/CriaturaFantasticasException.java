package excepciones;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CriaturaFantasticasException extends Exception {
	private static final Logger logger = LogManager.getLogger(CriaturaFantasticasException.class);

	//private static final long serialVersionUID = 123456789;
	public CriaturaFantasticasException(String message) {
		super(message);
		logger.error(message);
	}
	 

}
