package org.sample.game;

import org.qi4j.api.unitofwork.UnitOfWork;
import org.qi4j.bootstrap.AssemblyException;
import org.qi4j.bootstrap.ModuleAssembly;
import org.qi4j.bootstrap.SingletonAssembler;
import org.qi4j.entitystore.memory.MemoryEntityStoreService;
import org.qi4j.spi.uuid.UuidIdentityGeneratorService;
import org.sample.game.domain.CharacterBuilder;
import org.sample.game.domain.units.*;
import org.sample.game.usecases.SampleInteraction;
import org.sample.game.usecases.TavernInteraction;
import org.sample.game.usecases.drink.Drunkard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.qi4j.api.usecase.UsecaseBuilder.newUsecase;

/**
 * @autor Anton Chernetskiy
 */
public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        SingletonAssembler assembler = new SingletonAssembler() {
            public void assemble(ModuleAssembly module) throws AssemblyException {
                module.entities(Medic.class);
                module.entities(Warrior.class);
                module.entities(Worker.class);
                module.entities(Barn.class);

                module.services(MemoryEntityStoreService.class,
                        UuidIdentityGeneratorService.class);
            }
        };

        UnitOfWork unitOfWork = assembler.unitOfWorkFactory().newUnitOfWork(newUsecase("init"));

        CharacterBuilder characterBuilder = new CharacterBuilder();

        Worker bob = characterBuilder.buildWorker("Bob the worker", unitOfWork);
        Medic john = characterBuilder.buildMedic("John the medic", unitOfWork);
        Warrior mike = characterBuilder.buildWarrior("Mike the warrior", unitOfWork);

        System.out.println("Making war!");
        SampleInteraction interaction = new SampleInteraction(bob, mike, john);
        interaction.interact();

        System.out.println("Making party!");
        List<Drunkard> tavernVisitors = new ArrayList<Drunkard>();
        tavernVisitors.add(bob);
        tavernVisitors.add(john);
        tavernVisitors.add(mike);
        TavernInteraction tavernInteraction = new TavernInteraction(tavernVisitors);
        tavernInteraction.makeParty();
    }

}
