package org.sample.game.domain.units;

import org.qi4j.api.entity.EntityComposite;
import org.sample.game.usecases.attack.Attackable;
import org.sample.game.usecases.description.Describable;
import org.sample.game.usecases.drink.Drunkard;
import org.sample.game.usecases.heal.Healable;
import org.sample.game.usecases.heal.Healer;

/**
 * @author Anton Chernetskiy
 */
public interface Medic extends EntityComposite,
        Describable,
        Attackable,
        Healable,
        Healer,
        Drunkard{
}
