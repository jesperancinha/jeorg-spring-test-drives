package org.jesperancinha.std.action.aop.pickers;

import org.jesperancinha.std.action.aop.model.Oyster;

public class OysterPicker implements Picker<Oyster>{
    @Override
    public Oyster pickup(Oyster oyster) {
        return oyster;
    }


}
