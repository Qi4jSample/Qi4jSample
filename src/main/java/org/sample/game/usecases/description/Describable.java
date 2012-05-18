package org.sample.game.usecases.description;

import org.qi4j.api.injection.scope.This;
import org.qi4j.api.mixin.Mixins;
import org.sample.game.domain.Unit;

/**
 * @author Anton Chernetskiy
 */
@Mixins({Describable.DescribableUnit.class})
public interface Describable {

    public String getDescription();

    class DescribableUnit implements Describable {

        @This
        Unit unit;

        public String getDescription() {
            return String.format("%20s  health:%4s",
                    unit.name().get(), unit.health().get());
        }
    }
}
