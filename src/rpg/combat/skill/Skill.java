package rpg.combat.skill;

import java.util.ArrayList;
import java.util.List;

import rpg.combat.skill.effect.Effect;
import rpg.combat.unit.Unit;
import rpg.main.Dialogue;

public class Skill {

    //名前
    public String name;

    //コスト
    public int costR, costG, costB;

    //スキル効果
    public List<Effect> effects = new ArrayList<>();

    public void print(Unit unit){
        Dialogue.print(true, String.format(
            "%10s: COST=(%2d /%2d|%2d /%2d|%2d /%2d) :: %s",
            this.name, 
            this.costR, unit.manaR,
            this.costG, unit.manaG,
            this.costB, unit.manaB,
            this.canCast(unit) ? "発動可能" : "コスト不足"
        ));
        Dialogue.nextLine();
        
        this.effects.forEach(e -> {
            e.print();
            Dialogue.nextLine();
        });
    }

    public boolean canCast(Unit unit){
        return this.costR <= unit.manaR && this.costG <= unit.manaG && this.costB <= unit.manaB;
    }
}
