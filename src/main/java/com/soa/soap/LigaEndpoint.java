/**
 * 
 */
package com.soa.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.google.gson.Gson;
import com.soa.MaximoGoleadorVelasco;
import com.soa.MarcadoresLizbeth;
import com.soa.business.LigaBusiness;

/**
 * Clase que publica un servicio web tipo SOAP. Capa Boundary
 */
@Endpoint
public class LigaEndpoint {
    /** Objeto inyectado de la capa de negocio. */
    //private ConcatenarBusiness business;

    /** Targetnamespace. */
    private static final String NAMESPACE_URI = "http://soa.com";

    /**
     * Operación SOAP expuesta en http.
     * @param request Objeto con datos de entrada. (Capa de Modelo).
     * @return objeto con datos de salida (Capa de modelo)
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "marcadoresLizbeth")
    @ResponsePayload
    public MaximoGoleadorVelasco ligaOperation(
            @RequestPayload MarcadoresLizbeth request) {
        
        /*
         * Sirve para cuando hago un request desde el SOAP, muestra los datos ingresados
         * Gson gson = new Gson(); System.out.println("Request recibido " +
         * gson.toJson(request));
         */
        
        MaximoGoleadorVelasco out = new MaximoGoleadorVelasco();

        List<String> equipoList = out.getEquipo();
        equipoList.add("Barcelona");
        equipoList.add("Real Madrid");
        
        return out;
    }
}