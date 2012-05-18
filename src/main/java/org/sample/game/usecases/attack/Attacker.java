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

    public class AttackerUnit implements Attacker {

        private static final int STRENGTH = 10;

        public void beat(Attackable attackable) {
            attackable.receiveDamage(STRENGTH);
        }
    }
}
