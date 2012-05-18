package org.sample.game.domain;

import org.qi4j.api.entity.EntityBuilder;
import org.qi4j.api.unitofwork.UnitOfWork;
import org.sample.game.domain.units.Medic;
import org.sample.game.domain.units.Warrior;
import org.sample.game.domain.units.Worker;
import org.sample.game.usecases.attack.Attacker;

/**
 * @author Anton Chernetskiy
 */
public class CharacterBuilder {

    private <T> EntityBuilder<T> getBuilderFor(Class<T> type, String name, UnitOfWork unitOfWork) {
        final EntityBuilder<T> builder = unitOfWork.newEntityBuilder(type, name);
        final Unit unit = builder.instanceFor(Unit.class);
        unit.health().set(100);
        unit.name().set(name);
        return builder;
    }

    public Medic buildMedic(String name, UnitOfWork unitOfWork) {
        return getBuilderFor(Medic.class, name, unitOfWork).newInstance();
    }

    public Warrior buildWarrior(String name, UnitOfWork unitOfWork) {
        return getBuilderFor(Warrior.class, name, unitOfWork).newInstance();
    }

    public Worker buildWorker(String name, UnitOfWork unitOfWork) {
        return getBuilderFor(Worker.class, name, unitOfWork).newInstance();
    }
}
