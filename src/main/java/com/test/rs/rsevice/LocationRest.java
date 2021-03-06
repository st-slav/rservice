package com.test.rs.rsevice;

import com.test.rs.entity.Loc;
import com.test.rs.log.ProducerLogBean;
import com.test.rs.logic.LocLocal;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/saveloc")
public class LocationRest {
    
    @EJB(beanName = "location")
    private LocLocal locLocal;
    
    @EJB
    private ProducerLogBean producerLog;
    
    @POST
    @Produces("text/html")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response saveClientLocaton(String jPackage){
        locLocal.addLocListFromRestPakage(convertJsonStringToArrayListLoc(jPackage));
        producerLog.sendMessage(new Date() + " [rservice]: " + jPackage);
        return Response.status(200).build();
    }
    
    public ArrayList<Loc> convertJsonStringToArrayListLoc(String jString){
        JsonReader jReader = Json.createReader(new StringReader(jString));
        JsonArray jArray = jReader.readArray();
        ArrayList<Loc> locs = new ArrayList<Loc>();
        for (int i = 0; i < jArray.size(); i++){
            JsonObject jObject = jArray.getJsonObject(i);
            locs.add(new Loc (
                    (float) jObject.getJsonNumber("latitude").doubleValue(),
                    (float) jObject.getJsonNumber("longitude").doubleValue(),
                    (float) jObject.getJsonNumber("horizontalAccuracy").doubleValue(),
                    (float) jObject.getJsonNumber("speed").doubleValue(),
                    (float) jObject.getJsonNumber("course").doubleValue(),
                    (float) jObject.getJsonNumber("altitude").doubleValue(),
                    (float) jObject.getJsonNumber("verticalAccuracy").doubleValue(),
                    jObject.getString("actuality"),
                    jObject.getJsonNumber("timestamp").bigIntegerValue()));
        }
        return locs;
    }
}
