package rpg.combat.skill.effect;

import rpg.combat.skill.effect.condition.EffectCondition;
import rpg.main.Dialogue;

public abstract class SkillEffect {

    //条件
    public EffectCondition condition;

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
