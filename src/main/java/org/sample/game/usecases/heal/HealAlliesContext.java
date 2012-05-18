package org.sample.game.usecases.heal;

import java.util.List;

/**
 * @author Lev Sivashov <a href="mailto:Lev.Sivashov@exigenservices.com">Lev.Sivashov@exigenservices.com</a>
 * @since 5/17/12
 */
public class HealAlliesContext {
    private final Healer doctor;
    private final List<? extends Healable> healables;

    public HealAlliesContext(Healer doctor, List<? extends Healable> healables) {
        this.doctor = doctor;
        this.healables = healables;
    }

    public void healAll() {
        for (Healable healable : healables) {
            doctor.heal(healable);
        }
    }
}