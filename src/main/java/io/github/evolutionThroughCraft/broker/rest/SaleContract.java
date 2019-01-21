/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.broker.rest;

import io.github.evolutionThroughCraft.broker.model.OfferForm;
import io.github.evolutionThroughCraft.common.arch.contracts.Contract;
import io.github.evolutionThroughCraft.common.service.main.utils.ResourceUtility;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Component("saleContract")
public class SaleContract implements Contract<OfferForm> {
    
    @Override
    public void validate(OfferForm form) {

        ResourceUtility.ensureResource(form, "SaleForm Missing");
        ResourceUtility.ensureResource(form.getTriviaId(), "Sale TriviaId Missing");
        ResourceUtility.ensureResource(form.getQuestion(), "Sale Question Missing");
        ResourceUtility.ensureResource(form.getAnswer(), "Sale Answer Missing");
        ResourceUtility.ensureResource(form.getCreditorId(), "Sale Creditor Missing");
        ResourceUtility.ensureResource(form.getDebitorId(), "Sale Debitor Missing");  
        ResourceUtility.ensureResource(form.getAmount(), "Sale Amount Missing");  
        ResourceUtility.ensureResource(form.getCreateUser(), "Create User Missing");  
        ResourceUtility.ensureResource(form.getUpdateUser(), "Update User Missing");         
    }
}
