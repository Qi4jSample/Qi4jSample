package org.sample.game.usecases.build;

import org.qi4j.api.entity.EntityBuilder;
import org.qi4j.api.injection.scope.Structure;
import org.qi4j.api.injection.scope.This;
import org.qi4j.api.mixin.Mixins;
import org.qi4j.api.unitofwork.UnitOfWork;
import org.qi4j.api.unitofwork.UnitOfWorkFactory;
import org.qi4j.api.usecase.UsecaseBuilder;
import org.sample.game.domain.Unit;
import org.sample.game.domain.units.Barn;

/**
 * @author Anton Chernetskiy
 */
@Mixins({Builder.BuilderUnit.class})
public interface Builder {
    public Barn buildBarn();
    public void repair(Repairable repairable);

    /**
     * @author Anton Chernetskiy
     */
    class BuilderUnit implements Builder {

        @This
        Unit unit;

        @Structure
        private UnitOfWorkFactory uowf;

        public Barn buildBarn() {
            UnitOfWork unitOfWork = uowf.newUnitOfWork(UsecaseBuilder.newUsecase("Build new barn"));
            EntityBuilder<Barn> builder = unitOfWork.newEntityBuilder(Barn.class);

            Unit barn = builder.instanceFor(Unit.class);
            barn.health().set(300);
            barn.name().set("Red barn");
            return builder.newInstance();
        }

        public void repair(Repairable repairable) {
            repairable.repair(10);
        }
    }
}
