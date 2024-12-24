package rpg.combat.skill.effect;

public class SkillEffectDealDamage extends SkillEffect{

    public int rate;

    public SkillEffectDealDamage(int rate){
        this.rate = rate;
    }

    @Override
    public String getExplain(){
        return String.format("攻撃力の%d%%のダメージを与える", this.rate);
    }
}
