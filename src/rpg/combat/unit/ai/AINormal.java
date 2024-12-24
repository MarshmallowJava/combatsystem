package rpg.combat.unit.ai;

import rpg.combat.Combat;
import rpg.combat.skill.Skill;
import rpg.combat.unit.Unit;

public class AINormal extends AI{

    @Override
    public void decide(Unit unit, Combat combat){
        //ランダムなスキルを1つ拾う
        Skill skill = this.pickRandomSkill(unit);
    }
}
