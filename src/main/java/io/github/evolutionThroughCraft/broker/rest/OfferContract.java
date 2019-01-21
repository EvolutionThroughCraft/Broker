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
@Component("offerContract")
public class OfferContract implements Contract<OfferForm>{
    
    @Override
    public void validate(OfferForm form) {
        
        ResourceUtility.ensureResource(form, "OfferForm Missing");
        ResourceUtility.ensureResource(form.getAccountId(), "Offering AccountId Missing");
        ResourceUtility.ensureResource(form.getQuestion(), "Offering Question Missing");  
        ResourceUtility.ensureResource(form.getCreateUser(), "Create User Missing");  
        ResourceUtility.ensureResource(form.getUpdateUser(), "Update User Missing");  
        
    }
}
