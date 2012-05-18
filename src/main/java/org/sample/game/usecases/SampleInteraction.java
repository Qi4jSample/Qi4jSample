package org.sample.game.usecases;

import org.sample.game.domain.units.Barn;
import org.sample.game.domain.units.Medic;
import org.sample.game.domain.units.Warrior;
import org.sample.game.domain.units.Worker;
import org.sample.game.usecases.attack.AttackEnemiesContext;
import org.sample.game.usecases.build.RepairBuildingsContext;
import org.sample.game.usecases.description.Describable;
import org.sample.game.usecases.heal.HealAlliesContext;

import java.util.Arrays;

/**
 * @autor Anton Chernetskiy
 */
public class SampleInteraction {

    /*
     * Team one
     */
    private final Warrior warrior;

    /*
     * Team two
     */
    private final Worker worker;
    private final Medic medic;
    private Barn barn;

    public SampleInteraction(Worker worker, Warrior warrior, Medic medic) {
        this.worker = worker;
        this.warrior = warrior;
        this.medic = medic;
    }

    public void interact() {
        barn = worker.buildBarn();
        logAll();

        System.out.println("Warrior beats everyone.");
        AttackEnemiesContext attackEnemiesContext = new AttackEnemiesContext(warrior, Arrays.asList(worker, medic, barn));
        attackEnemiesContext.fight();
        logAll();

        System.out.println("Medic heals worker and himself.");
        HealAlliesContext healAlliesContext = new HealAlliesContext(medic, Arrays.asList(medic, worker));
        healAlliesContext.healAll();

        System.out.println("Worker repairs barn.");
        RepairBuildingsContext repairBuildingsContext = new RepairBuildingsContext(worker, Arrays.asList(barn));
        repairBuildingsContext.repair();
        logAll();

        System.out.println("Workers revenge.");
        attackEnemiesContext = new AttackEnemiesContext(worker, Arrays.asList(warrior));
        attackEnemiesContext.fight();
        logAll();
    }

    private void logAll() {
        log(worker);
        log(warrior);
        log(medic);
        log(barn);
        System.out.println();
    }

    private void log(Describable describable) {
        System.out.println(describable.getDescription());
    }
}