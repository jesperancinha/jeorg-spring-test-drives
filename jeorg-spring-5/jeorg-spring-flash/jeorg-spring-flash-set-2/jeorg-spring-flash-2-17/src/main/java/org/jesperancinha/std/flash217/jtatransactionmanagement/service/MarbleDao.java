package org.jesperancinha.std.flash217.jtatransactionmanagement.service;

import org.jesperancinha.std.flash217.jtatransactionmanagement.domain.Marble;

import java.time.LocalDateTime;
import java.util.List;

public interface MarbleDao {

    void createTables();

    void resetDatabase();

    Marble create(String name, String color);

    Marble createRollback(String name, String color);

    Marble createFailRollback(String name, String color);

    Marble createNoTransaction(String name, String color);

    List<Marble> listMarbles();


}
