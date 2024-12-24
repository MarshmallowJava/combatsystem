package rpg.combat.unit.ai;

import rpg.combat.Combat;
import rpg.combat.skill.Skill;
import rpg.combat.unit.Unit;

public abstract class AI {

    //使用ユニットと戦闘状況から行動を決定
    public abstract void decide(Unit unit, Combat combat);

    protected final Skill pickRandomSkill(Unit unit){
        return unit.skills.get((int)(Math.random() * unit.skills.size()));
    }
}
