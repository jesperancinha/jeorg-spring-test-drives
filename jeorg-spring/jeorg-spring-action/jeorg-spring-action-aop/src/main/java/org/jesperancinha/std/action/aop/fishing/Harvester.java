package org.jesperancinha.std.action.aop.fishing;

import org.jesperancinha.std.action.aop.model.Harverst;
import org.springframework.stereotype.Service;

@Service
public interface Harvester {

    <T extends Harverst> T harvest();
}
