package rpg.combat.unit;

import rpg.combat.Combat;
import rpg.combat.unit.ai.AI;

public class UnitEnemy extends Unit{
    
    protected AI ai;

    public void setAI(AI ai){
        this.ai = ai;
    }

    @Override
    public void act(Combat combat){
        this.ai.decide(this, combat);
    }
}
