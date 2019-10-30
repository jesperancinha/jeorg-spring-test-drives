package org.jesperancinha.b2b2java8.serviceloader;

/**
 * Created by joao on 15-5-16.
 */
public final class PersonOne extends AbstractPerson implements PersonInterface {

    @Override
    public String getPersonName() {
        return "PersonOne";
    }

}
