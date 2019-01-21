/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.service.main.routes;

/**
 *
 * @author dwin
 */
public interface BrokerRoutes extends HttpsRoutes {
    
    //// paths
    public static final String BROKER_ROOT = "/broker";
    
    public static final String SALE_PATH = BROKER_ROOT + "/sale";
    public static final String OFFER_PATH = BROKER_ROOT + "/offer";
    
    //// routes
    public static final String BROKER_PORT = ":8085";
    public static final String BROKER_ROOT_ROUTE = WEB_ROOT_ROUTE + BROKER_ROOT;
    
    public static final String OFFER_ROUTE = BROKER_ROOT_ROUTE+OFFER_PATH;
    public static final String SALE_ROUTE = BROKER_ROOT_ROUTE+SALE_PATH;
}
