package org.jesperancinha.std.flash213.testing.services;

import org.jesperancinha.std.flash213.testing.model.Cake;

public interface CakeService {

    Cake createCake(Cake cake);

    Cake getCakeById(Long id);

    Cake updateCake(Cake cake);

    boolean deleteCake(Cake cake);
}
