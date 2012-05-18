package org.sample.game.domain.units;

import org.qi4j.api.entity.EntityComposite;
import org.sample.game.usecases.attack.Attackable;
import org.sample.game.usecases.attack.Attacker;
import org.sample.game.usecases.build.Builder;
import org.sample.game.usecases.description.Describable;
import org.sample.game.usecases.drink.Drunkard;
import org.sample.game.usecases.heal.Healable;

/**
 * @author Anton Chernetskiy
 */
public interface Worker extends EntityComposite,
        Describable,
        Attackable,
        Healable,
        Builder,
        Drunkard{
}
