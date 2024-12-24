package rpg.main;

import rpg.combat.Combat;
import rpg.combat.skill.SkillFactory;
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
            unit.skills.add(SkillFactory.createSkillFromString("通常攻撃/0/0/0/deal_dmg,on_hit,100"));

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