/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.broker.rest.component;

import io.github.evolutionThroughCraft.broker.model.OfferForm;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.KnowledgePojo;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.TransactionPojo;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.TriviaPojo;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Component
public class FormParser {
    
    public TriviaPojo parseTrivia(OfferForm form) {
        TriviaPojo pojo = new TriviaPojo();
        pojo.setTriviaId(form.getTriviaId());
        pojo.setQuestion(form.getQuestion());
        pojo.setAnswer(form.getAnswer());
        pojo.setCreateTime(form.getCreateTime());
        pojo.setCreateUser(form.getCreateUser());
        pojo.setUpdateTime(form.getUpdateTime());
        pojo.setUpdateUser(form.getUpdateUser());
        return pojo;
    }
    
    public KnowledgePojo parseKnowledge(OfferForm form, Long accountId) {
        KnowledgePojo pojo = new KnowledgePojo();
        pojo.setAccountId(accountId);
        pojo.setTriviaId(form.getTriviaId());
        pojo.setCreateTime(form.getCreateTime());
        pojo.setCreateUser(form.getCreateUser());
        pojo.setUpdateTime(form.getUpdateTime());
        pojo.setUpdateUser(form.getUpdateUser());
        return pojo;
    }
    
    public TransactionPojo parseTransaction(OfferForm form) {
        TransactionPojo pojo = new TransactionPojo();
        pojo.setTransactionId(form.getTransactionId());
        pojo.setAmount(form.getAmount());
        pojo.setDebitorId(form.getDebitorId());
        pojo.setCreditorId(form.getCreditorId());
        pojo.setCreateTime(form.getCreateTime());
        pojo.setCreateUser(form.getCreateUser());
        pojo.setUpdateTime(form.getUpdateTime());
        pojo.setUpdateUser(form.getUpdateUser());
        return pojo;
    }
}
