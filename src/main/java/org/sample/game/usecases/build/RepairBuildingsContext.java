package org.sample.game.usecases.build;

import java.util.List;

/**
 * @author Lev Sivashov <a href="mailto:Lev.Sivashov@exigenservices.com">Lev.Sivashov@exigenservices.com</a>
 * @since 5/17/12
 */
public class RepairBuildingsContext {
    private final Builder builder;
    private final List<? extends Repairable> buildings;

    public RepairBuildingsContext(Builder builder, List<? extends Repairable> buildings) {
        this.builder = builder;
        this.buildings = buildings;
    }

    public void repair() {
        for (Repairable building : buildings) {
            builder.repair(building);
        }
    }
}