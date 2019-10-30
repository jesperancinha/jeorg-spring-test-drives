package org.jesperancinha.b2b2java8.serviceloader;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class PersonManager {

    public static List<AbstractPerson> getDefault() {
        final List<AbstractPerson> abstractPersonList = new ArrayList<>();
        ServiceLoader<AbstractPerson> serviceLoader =
                ServiceLoader.load(AbstractPerson.class);

        for (AbstractPerson provider : serviceLoader) {
            abstractPersonList.add(provider);
        }
        return abstractPersonList;
    }

}
