package org.sample.game.usecases.attack;

import java.util.List;

/**
 * @author Lev Sivashov <a href="mailto:Lev.Sivashov@exigenservices.com">Lev.Sivashov@exigenservices.com</a>
 * @since 5/17/12
 */
public class AttackEnemiesContext {
    private final List<? extends Attackable> enemies;
    private final Attacker attacker;

    public AttackEnemiesContext(Attacker attacker, List<? extends Attackable> enemies) {
        this.enemies = enemies;
        this.attacker = attacker;
    }

    public void fight() {
        for (Attackable enemy : enemies) {
            attacker.beat(enemy);
        }
    }
}