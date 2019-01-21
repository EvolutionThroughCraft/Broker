/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.broker.rest.component;

import io.github.evolutionThroughCraft.broker.model.OfferForm;
import io.github.evolutionThroughCraft.common.service.main.api.Trivia;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.TriviaPojo;
import java.util.List;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Component
@Getter
public class QuestionValuer {

    private static final Integer UNIQUE_QUESTION_VALUE = 100;
    private static final Integer NON_UNIQUE_VALUE = 5;
            
    @Autowired
    private BrokerTriviaClient triviaClient;    
    
    @Autowired
    private FormParser parser;
    
    public Integer getQuestionValue(OfferForm form) {
        Trivia request = getParser().parseTrivia(form);
        List<Trivia> existing = getTriviaClient().getMatchingTrivia(request);

        if(existing.isEmpty()) {
            return UNIQUE_QUESTION_VALUE;
        } else {
            return NON_UNIQUE_VALUE;
        }
    }

    
}
