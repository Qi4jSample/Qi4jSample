package org.sample.game.usecases.build;

import org.qi4j.api.injection.scope.This;
import org.qi4j.api.mixin.Mixins;
import org.sample.game.domain.Unit;

/**
 * @author Anton Chernetskiy
 */
@Mixins({Repairable.RepairableUnit.class})
public interface Repairable {

    public void repair(int points);

    /**
     * @author Anton Chernetskiy
     */
    class RepairableUnit implements Repairable {

        @This
        Unit unit;

        public void repair(int points) {
            Integer health = unit.health().get();
            unit.health().set(health + points);
        }
    }
}
