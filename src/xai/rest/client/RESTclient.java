package xai.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
		
		String respuesta = restCall("http://"+address+":"+port+"/cake/sup/"+value1+"/"+value2+"/"+value3, MediaType.TEXT_PLAIN);
		return Double.parseDouble(respuesta);
	}
	
	public double per(String address, int port, float value1, float value2, float value3) {
		LSimLogger.log(Level.INFO, "http://"+address+":"+port+"/cake/per/"+value1+"/"+value2+"/"+value3);
		LSimLogger.log(Level.INFO, "media type: application/json");

		/* COMPLETE CODE */
		
		String respuesta = restCall("http://"+address+":"+port+"/cake/per/"+value1+"/"+value2+"/"+value3, MediaType.APPLICATION_JSON);
		
		JsonObject json = new Gson().fromJson(respuesta, JsonObject.class);
		
		return Double.parseDouble(json.get("per").getAsString());
	}

	public Volum vol(String address, int port, float value1, float value2, float value3) {
		LSimLogger.log(Level.INFO, "http://"+address+":"+port+"/cake/vol/"+value1+"/"+value2+"/"+value3);
		LSimLogger.log(Level.INFO, "media type: application/json");
		
		/* COMPLETE CODE */
		String respuesta = restCall("http://"+address+":"+port+"/cake/vol/"+value1+"/"+value2+"/"+value3, MediaType.APPLICATION_JSON);
		return new Gson().fromJson(respuesta, Volum.class);
	}
	
	
	private String restCall(String url, String mediaType) {
		try {
			Client client = ClientBuilder.newClient();
			Builder invocacion = client.target(url).request(mediaType);
			Response resp = invocacion.get();			
			return resp.readEntity(String.class);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
		

}
