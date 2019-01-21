/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.arch.composible;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dwin
 */
public abstract class ComposibleClass {
    
   private final Map<Class<?>, Object> modules;
   
   public ComposibleClass() {
       super();
       modules = new HashMap<>();
   }
   
    protected final <T> void injectModule(Class<T> klass, T instance) {
        modules.put(klass, instance);
    }
    
    protected <T> T lookupModule(Class<T> klass) {
        Object inst = modules.get(klass);
        return inst == null ? null : klass.cast(inst);
    }   
}
