package xai.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
import lsim.library.api.LSimLogger;
//import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
//import lsim.library.api.LSimLogger;
import xai.rest.jettyserver.api.Volum;

/**
 * @author Joan-Manuel Marques
 *
 */

public class RESTclient {

	public double sup(String address, int port, float value1, float value2, float value3) {
		LSimLogger.log(Level.INFO, "http://"+address+":"+port+"/cake/sup/"+value1+"/"+value2+"/"+value3);
		LSimLogger.log(Level.INFO, "media type: text/plain");

		/* COMPLETE CODE */
		
		return Double.MIN_VALUE;
	}
	
	public double per(String address, int port, float value1, float value2, float value3) {
		LSimLogger.log(Level.INFO, "http://"+address+":"+port+"/cake/per/"+value1+"/"+value2+"/"+value3);
		LSimLogger.log(Level.INFO, "media type: application/json");

		/* COMPLETE CODE */
		
		return Double.MIN_VALUE;
	}

	public Volum vol(String address, int port, float value1, float value2, float value3) {
		LSimLogger.log(Level.INFO, "http://"+address+":"+port+"/cake/vol/"+value1+"/"+value2+"/"+value3);
		LSimLogger.log(Level.INFO, "media type: application/json");
		
		/* COMPLETE CODE */
		
		return null;
	}

}
