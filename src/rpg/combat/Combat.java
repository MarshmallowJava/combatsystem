package rpg.combat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import rpg.combat.unit.Group;
import rpg.combat.unit.Unit;

//戦闘情報
public class Combat {

    //行動値順
    private static final Comparator<Unit> ORDER_ACTVALUE = (u0, u1) -> u0.actValue - u1.actValue;
    private static final Function<Unit, Boolean> CONDITION_CANMOVE = u -> u.canMove();

    //全ユニット
    public List<Unit> units = new ArrayList<>();

    //戦闘を開始します
    public void run(){
        // int turnCount = 0;

        //味方陣営も敵陣営も生き残っている場合
        while(isAlive(Group.ALLY) && isAlive(Group.ENEMY)){

            // Dialogue.print(String.format("-------%dターン目--------", ++turnCount));

            //各ユニットの行動値を速度分加算
            this.units.forEach(u -> u.actValue += u.speed);

            //各ユニットが行動不可になるまで実行
            while(true){

                //行動可能なユニットを取得
                List<Unit> canmoves = this.getUnits(CONDITION_CANMOVE);
                if(canmoves.isEmpty()){
                    break;
                }else{

                    //行動値順にソートして行動
                    canmoves.sort(ORDER_ACTVALUE.reversed());
                    canmoves.forEach(u -> {

                        //行動値を消費
                        u.actValue -= u.actcost;

                        //行動
                        u.act(this);
                    });
                }
            }
        }
    }

    public void print(){
        //敵側表示
        System.out.println("-ENEMY-------");
        this.getUnits(u -> u.group == Group.ENEMY).forEach(u -> u.printOverview());
        System.out.println();

        //味方側表示
        System.out.println("-ALLY--------");
        this.getUnits(u -> u.group == Group.ALLY).forEach(u -> u.printOverview());
        System.out.println();
    }

    //指定陣営が生存しているか判定します
    public boolean isAlive(Group group){

        //各ユニット毎に判定
        for(Unit unit : this.units){

            //指定陣営の生存者がいれば成功
            if(unit.group == group && unit.isAlive()){
                return true;
            }
        }

        return false;
    }

    //条件を満たすすべてのユニットを取得します
    public List<Unit> getUnits(Function<Unit, Boolean> function){
        List<Unit> units = new ArrayList<>();

        for(Unit unit : this.units){
            if(function.apply(unit)){
                units.add(unit);
            }
        }

        return units;
    }
}
