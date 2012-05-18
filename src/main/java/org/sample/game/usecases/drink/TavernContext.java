package org.sample.game.usecases.drink;

import java.util.List;
import java.util.Random;

/**
 * @autor Anton Chernetskiy
 */
public class TavernContext {
    private final List<? extends Drunkard> drunkards;
    private final Random random = new Random();

    public TavernContext(List<? extends Drunkard> drunkards) {
        this.drunkards = drunkards;
    }

    public void drink(){
        Drunkard randomDrunkard = drunkards.get(random.nextInt(drunkards.size() - 1));
        randomDrunkard.sayToast();
        for(Drunkard drunkard: drunkards){
            drunkard.drink();
        }
    }
}
