package rpg.combat.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import rpg.combat.Combat;
import rpg.combat.skill.Skill;
import rpg.main.Dialogue;

public abstract class Unit {

    //名前
    public String name;

    //陣営
    public Group group;

    //タグ
    public List<String> tags = new ArrayList<>();

    //ステータス
    public int hp = 10, hp_max = 10;
    public int manaR = 1, manaR_max = 5;
    public int manaG = 1, manaG_max = 5;
    public int manaB = 1, manaB_max = 5;
    public int attack = 10, defence = 5;
    public int speed = 10, actcost = 100;

    //所持スキル
    public List<Skill> skills = new ArrayList<>();

    //戦闘情報
    public int actValue;

    //条件書き換え
    public Function<Unit, Boolean> condition_isAlive;
    public Function<Unit, Boolean> condition_canMove;

    //行動
    public abstract void act(Combat combat);

    //戦闘情報をリセットします
    public void reset(){
        this.actValue = 0;
        this.condition_isAlive = null;
    }

    //タグを保持しているかどうか判定
    public boolean hasTag(String tag){
        return this.tags.contains(tag);
    }

    //本ユニットが生存しているかどうかを判定
    public boolean isAlive(){
        return this.condition_isAlive == null ? this.hp > 0 : this.condition_isAlive.apply(this);
    }

    //行動可能かどうかを判定
    public boolean canMove(){
        return this.condition_canMove == null ? this.actValue >= this.actcost : this.condition_canMove.apply(this);
    }

    //ユニットの概要情報を表示
    public void printOverview(){
        Dialogue.print(true, String.format(
            "%-10s: HP=%3d /%3d RGB=(%2d /%2d|%2d /%2d|%2d /%2d) ACT=%3d + %3d /%3d",
            this.name,
            this.hp, this.hp_max,
            this.manaR, this.manaR_max,
            this.manaG, this.manaG_max,
            this.manaB, this.manaB_max,
            this.actValue, this.speed, this.actcost
        ));
    }
}
