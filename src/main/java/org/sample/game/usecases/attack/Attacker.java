package org.sample.game.usecases.attack;

import org.qi4j.api.injection.scope.This;
import org.qi4j.api.mixin.Mixins;
import org.qi4j.api.property.Property;

/**
 * @author Anton Chernetskiy
 */
@Mixins({Attacker.AttackerUnit.class})
public interface Attacker {
    public void beat(Attackable attackable);

    interface AttackerStats {
        Property<Integer> strength();
    }

    public class AttackerUnit implements Attacker {

        @This
        AttackerStats attackerStats;

        public void beat(Attackable attackable) {
            attackable.receiveDamage(attackerStats.strength().get());
        }
    }
}