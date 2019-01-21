/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.broker.rest;

import io.github.evolutionThroughCraft.broker.BrokerConstants;
import io.github.evolutionThroughCraft.broker.model.OfferForm;
import io.github.evolutionThroughCraft.broker.rest.component.BrokerKnowledgeClient;
import io.github.evolutionThroughCraft.broker.rest.component.BrokerTriviaClient;
import io.github.evolutionThroughCraft.broker.rest.component.FormParser;
import io.github.evolutionThroughCraft.broker.rest.component.QuestionValuer;
import io.github.evolutionThroughCraft.common.arch.orchestrators.ContractOperation;
import io.github.evolutionThroughCraft.common.service.main.api.Knowledge;
import io.github.evolutionThroughCraft.common.service.main.api.Trivia;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Component
@Getter @Setter
public class OfferOperation extends ContractOperation<OfferForm, OfferForm, OfferContract> implements BrokerConstants {


    
    @Autowired
    private BrokerKnowledgeClient knowledgeClient;
    
    @Autowired
    private BrokerTriviaClient triviaClient;
    
    @Autowired
    private FormParser parser;
    
    @Autowired
    private QuestionValuer valuer;
    
    @Autowired @Qualifier("offerContract")
    private OfferContract contract;

    @Override
    public OfferForm perform(OfferForm form) {
        // offer needs to happen before trivia save bc price is based on uniqueness of Q
        Integer offer = getValuer().getQuestionValue(form);
        form.setAmount(offer);
        form.setCreditorId(form.getAccountId());
        form.setDebitorId(BROKER_ID);
        
        // trivia-save needs to happen before knowledge-save b/c trivia id needed for knowledge save 
        Long triviaId = saveTrivia(form);
        form.setTriviaId(triviaId);
        
        Long knowledgeId = saveKnowledge(form);
        form.setKnowledgeId(knowledgeId);
        
        return form;
    }
    
    private Long saveTrivia(OfferForm form) {
        Trivia toSave = getParser().parseTrivia(form);
        Trivia saved = getTriviaClient().postTrivia(toSave);
        return saved.getTriviaId();        
    }
    
    private Long saveKnowledge(OfferForm form) {
        Knowledge toSave = getParser().parseKnowledge(form, form.getAccountId());
        Knowledge saved = getKnowledgeClient().postKnowledge(toSave);
        return saved.getKnowledgeId();
    }

}
