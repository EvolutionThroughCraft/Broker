/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.broker.model;

import io.github.evolutionThroughCraft.common.service.main.api.Transaction;
import io.github.evolutionThroughCraft.common.service.main.api.Trivia;
import io.github.evolutionThroughCraft.common.arch.composible.ComposibleClass;
import io.github.evolutionThroughCraft.common.service.main.api.Knowledge;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.KnowledgePojo;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.TransactionPojo;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.TriviaPojo;
import java.util.Date;

/**
 *
 * @author dwin
 */
public class OfferForm extends ComposibleClass implements Trivia, Knowledge, Transaction {
    
    public OfferForm() {
        super();
        injectModule(TriviaPojo.class, new TriviaPojo());
        injectModule(TransactionPojo.class, new TransactionPojo());
        injectModule(KnowledgePojo.class, new KnowledgePojo());      
    }

    ////  trivia
    @Override
    public Long getTriviaId() {
        return lookupModule(TriviaPojo.class).getTriviaId();
    }
    
    public void setTriviaId(Long triviaId) {
        lookupModule(TriviaPojo.class).setTriviaId(triviaId);
    }
    
    @Override
    public Date getCreateTime() {
        return lookupModule(TriviaPojo.class).getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        lookupModule(TriviaPojo.class).setCreateTime(createTime);
    }
    
    @Override
    public String getCreateUser() {
        return lookupModule(TriviaPojo.class).getCreateUser();
    }

    public void setCreateUser(String createUser) {
        lookupModule(TriviaPojo.class).setCreateUser(createUser);
    }
    
    @Override
    public Date getUpdateTime() {
        return lookupModule(TriviaPojo.class).getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        lookupModule(TriviaPojo.class).setUpdateTime(updateTime);
    }
    
    @Override
    public String getUpdateUser() {
        return lookupModule(TriviaPojo.class).getUpdateUser();
    }
    
    public void setUpdateUser(String updateUser) {
        lookupModule(TriviaPojo.class).setUpdateUser(updateUser);
    }    

    @Override
    public String getQuestion() {
        return lookupModule(TriviaPojo.class).getQuestion();
    }

    public void setQuestion(String question) {
        lookupModule(TriviaPojo.class).setQuestion(question);
    }
    
    @Override
    public String getAnswer() {
        return lookupModule(TriviaPojo.class).getAnswer();
    }

    public void setAnswer(String answer) {
        lookupModule(TriviaPojo.class).setAnswer(answer);
    }    

    ////  transactions
    
    @Override
    public Long getTransactionId() {
        return lookupModule(TransactionPojo.class).getTransactionId();
    }

    public void setTransactionId(Long transactionId) {
        lookupModule(TransactionPojo.class).setTransactionId(transactionId);
    }    

    @Override
    public Integer getAmount() {
        return lookupModule(TransactionPojo.class).getAmount();
    }

    public void setAmount(Integer amount) {
        lookupModule(TransactionPojo.class).setAmount(amount);
    }    

    @Override
    public Long getCreditorId() {
        return lookupModule(TransactionPojo.class).getCreditorId();
    }

    public void setCreditorId(Long creditorId) {
        lookupModule(TransactionPojo.class).setCreditorId(creditorId);
    }    

    @Override
    public Long getDebitorId() {
        return lookupModule(TransactionPojo.class).getDebitorId();
    }

    public void setDebitorId(Long debitorId) {
        lookupModule(TransactionPojo.class).setDebitorId(debitorId);
    }    
    
    /////   knowledge
    
    @Override
    public Long getAccountId() {
        return lookupModule(KnowledgePojo.class).getAccountId();
    }

    public void setAccountId(Long accountId) {
        lookupModule(KnowledgePojo.class).setAccountId(accountId);
    }
    
    @Override
    public Long getKnowledgeId() {
        return lookupModule(KnowledgePojo.class).getKnowledgeId();
    }

    public void setKnowledgeId(Long knowledgeId) {
        lookupModule(KnowledgePojo.class).setKnowledgeId(knowledgeId);
    }   
}
