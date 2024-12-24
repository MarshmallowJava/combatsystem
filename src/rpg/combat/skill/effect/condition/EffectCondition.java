package rpg.combat.skill.effect.condition;

public class EffectCondition {

    public static final EffectCondition ONHIT = new EffectCondition("的中時");
    public static final EffectCondition ONUSE = new EffectCondition("使用時");

    //名前
    public String name;

    public EffectCondition(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
