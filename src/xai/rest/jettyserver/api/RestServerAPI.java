package xai.rest.jettyserver.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
import lsim.library.api.LSimLogger;

import xai.rest.utils.*;

/**
 * @author Joan-Manuel Marques
 *
 */
@Path("/cake")
public class RestServerAPI {

	private static final double PI = 3.1416;
	
	/**
	 * Calculates cake slice's surface
	 *
	 * @param num_1
	 * @param num_2
	 * @param num_3
	 * @return
	 */
	@GET
	@Path("/sup/{num_1}/{num_2}/{num_3}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sup(@PathParam("num_1") float rad, @PathParam("num_2") float alt, @PathParam("num_3") float ang) {
		LSimLogger.log(Level.INFO, "sup");
		LSimLogger.log(Level.INFO, "rad (num_1): "+rad);
		LSimLogger.log(Level.INFO, "alt (num_2): "+alt);
		LSimLogger.log(Level.INFO, "ang (num_3): "+ang);

		double result = Integer.MIN_VALUE;

		/* COMPLETE CODE */
		result = 2 * Math.PI * rad * (rad + alt) * ang / 360 + 2 * rad * alt;

		LSimLogger.log(Level.INFO, "response: "+(new Double(result)).toString());
		return (new Double(result)).toString();
	}

	/**
	 * Calculates cake slice's perimeter
	 *
	 * @param num_1
	 * @param num_2
	 * @param num_3
	 */
	@GET
	@Path("/per/{num_1}/{num_2}/{num_3}")
	@Produces(MediaType.APPLICATION_JSON)
	public String per(@PathParam("num_1") float rad, @PathParam("num_2") float alt, @PathParam("num_3") float ang) {
		LSimLogger.log(Level.INFO, "per");
		LSimLogger.log(Level.INFO, "rad (num_1): "+rad);
		LSimLogger.log(Level.INFO, "alt (num_2): "+alt);
		LSimLogger.log(Level.INFO, "ang (num_3): "+ang);

		Object obj = null;
		Gson gson = null;

		double result = Integer.MIN_VALUE;

		/* COMPLETE CODE */
		gson = new Gson();
		obj = new JsonObject();

		result = 4 * rad + 3 * alt + 4 * Math.PI * rad * ang / 360;
		((JsonObject)obj).addProperty("rad", rad);
		((JsonObject)obj).addProperty("alt", alt);
		((JsonObject)obj).addProperty("ang", ang);
		((JsonObject)obj).addProperty("per", result);

		LSimLogger.log(Level.INFO, "response: "+gson.toJson(obj));
		return gson.toJson(obj);
	}

	/**
	 * Calculates cake slice's volume
	 *
	 * @param num_1
	 * @param num_2
	 * @param num_3
	 * @return a json object containing the parameters and the result
	 */
	@GET
	@Path("/vol/{num_1}/{num_2}/{num_3}")
	@Produces(MediaType.APPLICATION_JSON)
	public String vol (@PathParam("num_1") float rad, @PathParam("num_2") float alt, @PathParam("num_3") float ang) {
		LSimLogger.log(Level.INFO, "vol");
		LSimLogger.log(Level.INFO, "rad (num_1): "+rad);
		LSimLogger.log(Level.INFO, "alt (num_2): "+alt);
		LSimLogger.log(Level.INFO, "ang (num_3): "+ang);

		Gson gson = null;
		Volum result = null;		

		/* COMPLETE CODE */
		gson = new Gson();
		result = new Volum(rad, alt, ang);
		
		LSimLogger.log(Level.INFO, "response: "+gson.toJson(result));
		return gson.toJson(result);
	}
}
