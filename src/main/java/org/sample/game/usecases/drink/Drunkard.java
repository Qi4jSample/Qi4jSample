package org.sample.game.usecases.drink;

import org.qi4j.api.injection.scope.This;
import org.qi4j.api.mixin.Mixins;
import org.sample.game.domain.Unit;

/**
 * @author Anton Chernetskiy
 */
@Mixins({Drunkard.DrunkardImpl.class})
public interface Drunkard {

    public void drink();

    public void sayToast();

    public class DrunkardImpl implements Drunkard{

        @This
        Unit unit;

        @Override
        public void drink() {
            System.out.println(unit.name() + " drinks");
            Integer health = unit.health().get();
            unit.health().set(health - 10);
        }

        @Override
        public void sayToast() {
            System.out.println();
            System.out.println(unit.name() + " says \"For the King!\"");
        }
    }
}
