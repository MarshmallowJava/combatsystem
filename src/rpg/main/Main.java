package rpg.main;

import rpg.combat.Combat;
import rpg.combat.skill.Skill;
import rpg.combat.skill.effect.EffectDealDamage;
import rpg.combat.skill.effect.condition.ConditionEffect;
import rpg.combat.unit.Group;
import rpg.combat.unit.Unit;
import rpg.combat.unit.UnitPlayer;

public class Main{

    public static void main(String[] args){
        //戦闘開始
        Combat combat = new Combat();

        {
            //ユニットの生成
            Unit unit = new UnitPlayer();
            unit.name = "Hero";
            unit.group = Group.ALLY;
            unit.speed = 50;
            unit.actcost = 100;

            Skill skill = new Skill();
            skill.name = "通常攻撃";
            skill.costR = skill.costG = skill.costR = 0;
            skill.effects.add(new EffectDealDamage(100, ConditionEffect.ONHIT));
            unit.skills.add(skill);

            combat.units.add(unit);
        }
        {
            //ユニットの生成
            Unit unit = new Unit() {
                public void act(Combat combat){
                    Dialogue.print(this.name + "はゆらゆらしている...");
                }
            };
            unit.name = "Slime";
            unit.group = Group.ENEMY;
            unit.speed = 50;
            unit.actcost = 200;

            combat.units.add(unit);
        }

        combat.run();
    }
}