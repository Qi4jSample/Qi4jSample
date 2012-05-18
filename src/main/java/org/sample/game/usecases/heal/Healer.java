package org.sample.game.usecases.heal;

import org.qi4j.api.mixin.Mixins;

/**
 * @author Anton Chernetskiy
 */
@Mixins({Healer.HealerUnit.class})
public interface Healer {
    public void heal(Healable healable);

    class HealerUnit implements Healer {

        public void heal(Healable healable) {
            healable.recover(10);
        }
    }
}
