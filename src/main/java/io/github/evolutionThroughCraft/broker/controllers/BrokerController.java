/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.broker.controllers;

import io.github.evolutionThroughCraft.broker.model.OfferForm;
import io.github.evolutionThroughCraft.broker.rest.OfferOperation;
import io.github.evolutionThroughCraft.broker.rest.SaleOperation;
import io.github.evolutionThroughCraft.common.service.main.routes.BrokerRoutes;
import javax.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dwin
 */
@RestController
@RequestMapping
@Getter
public class BrokerController implements BrokerRoutes {
        
    @Autowired
    private OfferOperation offer;
    
    @Autowired
    private SaleOperation sale;
    
    @PostMapping(SALE_ROUTE)
    @ResponseStatus(HttpStatus.CREATED)
    public OfferForm makeSale(@Valid @RequestBody OfferForm form) {
        return getSale().run(form);
    }
    
    @PostMapping(OFFER_ROUTE)
    @ResponseStatus(HttpStatus.CREATED)
    public OfferForm makeOffer(@Valid @RequestBody OfferForm form) {
        return getOffer().run(form);
    }
}
