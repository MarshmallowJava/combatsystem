package rpg.combat.skill;

import rpg.combat.skill.effect.SkillEffect;

public class SkillFactory {

    public static Skill createSkillFromString(String data){
        String[] array = data.split("/");

        //基礎情報すら不足しているなら中断
        if(array.length < 4) 
            throw new IllegalArgumentException();

        //スキルインスタンスを生成
        Skill skill = new Skill();

        //基礎情報の取り出し
        skill.name = array[0];
        skill.costR = Integer.parseInt(array[1]);
        skill.costG = Integer.parseInt(array[2]);
        skill.costB = Integer.parseInt(array[3]);

        //追加効果を取得
        for(int i = 4;i < array.length;i++){
            skill.effects.add(createEffectFromString(array[i]));
        }

        return skill;
    }

    public static SkillEffect createEffectFromString(String data){
        String[] array = data.split(",");

        //基礎情報すら不足しているなら中断
        if(array.length < 2)
            throw new IllegalArgumentException();

        //インスタンス生成
        SkillEffect effect;

        return null;
    }
}
