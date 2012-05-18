package org.sample.game.usecases.heal;

import org.qi4j.api.injection.scope.This;
import org.qi4j.api.mixin.Mixins;
import org.sample.game.domain.Unit;

/**
 * @author Anton Chernetskiy
 */
@Mixins({Healable.HealableUnit.class})
public interface Healable {
       public void recover(int points);

    class HealableUnit implements Healable {

        @This
        Unit unit;

        public void recover(int points) {
            Integer health = unit.health().get();
            unit.health().set(health + points);
        }
    }
}
