package rpg.combat.skill.effect.condition;

public class ConditionEffect {

    public static final ConditionEffect ONHIT = new ConditionEffect("的中時");
    public static final ConditionEffect ONUSE = new ConditionEffect("使用時");

    //名前
    public String name;

    public ConditionEffect(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
