package org.sample.game.usecases.attack;

import org.qi4j.api.injection.scope.This;
import org.qi4j.api.mixin.Mixins;
import org.sample.game.domain.Unit;

/**
 * @author Anton Chernetskiy
 */
@Mixins({Attackable.AttackableUnit.class})
public interface Attackable {
    public void receiveDamage(int damageAmount);

    class AttackableUnit implements Attackable {

        @This
        Unit unit;

        public void receiveDamage(int damageAmount) {
            Integer health = unit.health().get();
            unit.health().set(health - damageAmount);
        }
    }
}
