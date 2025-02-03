public class Enemy {
    private String name;
    private int ap;
    private int hp;
    private int critRate;
    private String dialogue;
    private String death;
    private int reward;
    private String lore;

    public Enemy(String name, int ap, int hp, int critRate, String dialogue, String death, int reward, String lore) {
        this.name = name;
        this.ap = ap;
        this.hp = hp;
        this.critRate = critRate;
        this.dialogue = dialogue;
        this.death = death;
        this.reward = reward;
        this.lore = lore;
    }

    public String getName() {
        return name;
    }

    public int getAP() {
        return ap;
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public int getCritRate() {
        return critRate;
    }

    public String getDialogue() {
        return dialogue;
    }

    public String getDeath() {
        return death;
    }

    public int getReward() {
        return reward;
    }

    public String getLore() {
        return lore;
    }
}
