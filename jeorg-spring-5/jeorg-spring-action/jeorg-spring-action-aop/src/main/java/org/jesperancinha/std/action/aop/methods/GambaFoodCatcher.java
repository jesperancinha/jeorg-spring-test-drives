package org.jesperancinha.std.action.aop.methods;

import org.jesperancinha.std.action.aop.model.Gamba;
import org.springframework.stereotype.Service;

@Service
public class GambaFoodCatcher implements SeaFoodCatcher<Gamba> {
    @Override
    public Gamba catchWithNet() {
        return null;
    }

    @Override
    public Gamba catchWithFishingPole() {
        return null;
    }

    @Override
    public Gamba catchByHand() {
        return null;
    }

    @Override
    public void catchByHandExtra() {

    }

    @Override
    public Gamba catchWithClaws() {
        return null;
    }

    @Override
    public Gamba catchWithSuperSonicWaves() {
        return null;
    }

    @Override
    public Gamba catchWithABucket() {
        return null;
    }

    @Override
    public Gamba catchWithLove() {
        return null;
    }
}
