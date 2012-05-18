package org.sample.game.domain.units;

import org.qi4j.api.entity.EntityComposite;
import org.sample.game.usecases.attack.Attackable;
import org.sample.game.usecases.build.Repairable;
import org.sample.game.usecases.description.Describable;

/**
 * @author Anton Chernetskiy
 */
public interface Barn extends EntityComposite,
        Describable,
        Attackable,
        Repairable {
}
