package org.jesperancinha.std.action.aop.methods;

import org.jesperancinha.std.action.aop.model.Cod;
import org.springframework.stereotype.Service;

@Service
public class CodCatcher implements SeaFoodCatcher<Cod> {
    @Override
    public Cod catchWithNet() {
        return null;
    }

    @Override
    public Cod catchWithFishingPole() {
        return null;
    }

    @Override
    public Cod catchByHand() {
        return null;
    }

    @Override
    public void catchByHandExtra() {

    }

    @Override
    public Cod catchWithClaws() {
        return null;
    }

    @Override
    public Cod catchWithSuperSonicWaves() {
        return null;
    }

    @Override
    public Cod catchWithABucket() {
        return null;
    }

    @Override
    public Cod catchWithLove() {
        return null;
    }
}
