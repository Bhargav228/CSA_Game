public class Player {
    private String playerName;
    private int hp;
    private int ap;
    private int money;
    private int potionCount;
    private int strengthPotionCount;
    private int prayerBeads;
    private double critRate;
    private int firebombCounter;
    private int iceDaggerCounter;

    public Player(String playerName, int hp, int ap, int money) {
        this.playerName = playerName;
        this.hp = hp;
        this.ap = ap;
        this.money = money;
        this.potionCount = 3;
        this.strengthPotionCount = 1;
        this.prayerBeads = 1;
        this.critRate = 0.1; 
        this.firebombCounter = 0;
        this.iceDaggerCounter = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public int getAP() {
        return ap;
    }

    public void setAP(int ap) {
        this.ap = ap;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addPotion(int count) {
        potionCount += count;
    }

    public int getPotion() {
        return potionCount;
    }

    public void resetPotionCount() {
        potionCount = 0;
    }

    public void addStrengthPotion(int count) {
        strengthPotionCount += count;
    }

    public int getStrengthPotion() {
        return strengthPotionCount;
    }

    public void resetStrengthPotionCount() {
        strengthPotionCount = 0;
    }

    public int getPrayerBeads() {
        return prayerBeads;
    }

    public void addPrayerBeads(int count) {
        prayerBeads += count;
    }

    public double getCritRate() {
        return critRate;
    }

    public void setCritRate(double critRate) {
        this.critRate = critRate;
    }

    public int getFirebombCounter() {
        return firebombCounter;
    }

    public void setFirebombCounter(int firebombCounter) {
        this.firebombCounter = firebombCounter;
    }

    public void decrementFirebombCounter() {
        if (firebombCounter > 0) firebombCounter--;
    }

    public int getIceDaggerCounter() {
        return iceDaggerCounter;
    }

    public void setIceDaggerCounter(int iceDaggerCounter) {
        this.iceDaggerCounter = iceDaggerCounter;
    }

    public void decrementIceDaggerCounter() {
        if (iceDaggerCounter > 0) iceDaggerCounter--;
    }
}
