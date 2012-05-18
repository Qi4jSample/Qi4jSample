package org.sample.game.usecases;

import org.sample.game.usecases.drink.TavernContext;
import org.sample.game.usecases.drink.Drunkard;

import java.util.List;

/**
 * @autor Anton Chernetskiy
 */
public class TavernInteraction {
    private final List<? extends Drunkard> tavernVisitors;

    public TavernInteraction(List<? extends Drunkard> tavernVisitors) {
        this.tavernVisitors = tavernVisitors;
    }

    public void makeParty(){
        for(int i = 0; i < 10; i++){
            TavernContext tavern = new TavernContext(tavernVisitors);
            tavern.drink();
        }
    }
}
