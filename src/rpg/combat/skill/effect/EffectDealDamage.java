package rpg.combat.skill.effect;

import rpg.combat.skill.effect.condition.ConditionEffect;

public class EffectDealDamage extends Effect{

    public int rate;

    public EffectDealDamage(int rate, ConditionEffect condition){
        this.rate = rate;
        this.condition = condition;
    }

    @Override
    public String getExplain(){
        return String.format("攻撃力の%d%%の物理ダメージを与える", this.rate);
    }
}
