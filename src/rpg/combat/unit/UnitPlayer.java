package rpg.combat.unit;

import rpg.combat.Combat;
import rpg.combat.skill.Skill;
import rpg.main.Dialogue;

public class UnitPlayer extends Unit{

    @Override
    public void act(Combat combat){
        //状況表示
        combat.print();

        //表示
        Dialogue.print(true, this.name + "はどうする?");
        Dialogue.nextLine();
        Dialogue.nextLine();

        for(int i = 0;i < this.skills.size();i++){
            Dialogue.print(true, String.format("%d ", i));
            this.skills.forEach(s -> s.print(this));
            Dialogue.nextLine();
        }

        //スキルを選択
        while(true){
            int command = Integer.parseInt(Dialogue.input(">", "\\d+"));
            if(command < this.skills.size()){
                Skill skill = this.skills.get(command);
                if(skill.canCast(this)){
                    break;
                }
            }
        }
    }
}
