package rpg.combat.skill.effect;

import rpg.combat.skill.effect.condition.ConditionEffect;
import rpg.main.Dialogue;

public abstract class Effect {

    //名前
    public String name;

    //条件
    public ConditionEffect condition;

    //テンプレート出力
    public void print(){
        Dialogue.print(true, String.format(
            "[%s] %s",
            condition.getName(),
            this.getExplain()
        ));
    }

    //説明
    public abstract String getExplain();
}
