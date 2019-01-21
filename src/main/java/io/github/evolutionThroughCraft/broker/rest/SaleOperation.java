/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.broker.rest;

import io.github.evolutionThroughCraft.broker.BrokerConstants;
import io.github.evolutionThroughCraft.broker.model.OfferForm;
import io.github.evolutionThroughCraft.broker.rest.component.BrokerKnowledgeClient;
import io.github.evolutionThroughCraft.broker.rest.component.BrokerTransactionClient;
import io.github.evolutionThroughCraft.broker.rest.component.BrokerTriviaClient;
import io.github.evolutionThroughCraft.broker.rest.component.FormParser;
import io.github.evolutionThroughCraft.common.arch.orchestrators.ContractOperation;
import io.github.evolutionThroughCraft.common.service.main.api.Knowledge;
import io.github.evolutionThroughCraft.common.service.main.api.Transaction;
import io.github.evolutionThroughCraft.common.service.main.api.Trivia;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Component
@Getter @Setter
public class SaleOperation extends ContractOperation<OfferForm, OfferForm, SaleContract> implements BrokerConstants {
    
    @Autowired
    private SaleContract contract;
    
    @Autowired
    private BrokerTransactionClient transactionClient;
    
    @Autowired
    private BrokerKnowledgeClient knowledgeClient;
    
    @Autowired
    private BrokerTriviaClient triviaClient; 
    
    @Autowired
    private FormParser parser;
    
    @Override
    public OfferForm perform(OfferForm form) {
        updateAnswer(form);
        Long knowledgeId = informBuyer(form);
        Long transactionId = transferFunds(form);
        form.setTransactionId(transactionId);
        return form;
    }
    
    private void updateAnswer(OfferForm form) {
        Trivia toSave = getParser().parseTrivia(form);
        getTriviaClient().putTrivia(toSave);
    }
    
    private Long informBuyer(OfferForm form) {
        Knowledge toSave = getParser().parseKnowledge(form, BROKER_ID);
        Knowledge saved = getKnowledgeClient().postKnowledge(toSave);
        return saved.getKnowledgeId();
    }
    
    private Long transferFunds(OfferForm form) {
        Transaction toSave = getParser().parseTransaction(form);
        Transaction saved = getTransactionClient().postTransaction(toSave);
        return saved.getTransactionId();
    }
}
