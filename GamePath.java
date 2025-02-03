import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class GamePath {
    private Random random = new Random();
    private JFrame parentFrame;
    private List<Enemy> area1Enemies;
    private List<Enemy> area2Enemies;
    private int currentEnemyIndex;
    private String currentAreaName;
    private static final int INITIAL_HEALTH = 100;

    public GamePath(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        initializeEnemies();
    }

    private void initializeEnemies() {
        // Initialize enemies for each area
        area1Enemies = new ArrayList<>();
        area1Enemies.add(new Enemy("Corrupt Politician", 5, 50, 5, "Don't get in my way!", "Who do you think you are?...", 10, "Once a respected leader, the Corrupt Politician is now a shadow of his former self, driven by greed and deceit. He manipulates the remnants of society for personal gain, his lies poisoning the minds of the desperate."));
        area1Enemies.add(new Enemy("Corrupt Politician", 5, 50, 5, "Don't get in my way!", "Who do you think you are?...", 10, "Once a respected leader, the Corrupt Politician is now a shadow of his former self, driven by greed and deceit. He manipulates the remnants of society for personal gain, his lies poisoning the minds of the desperate."));
        area1Enemies.add(new Enemy("Corrupt Politician", 5, 50, 5, "Don't get in my way!", "Who do you think you are?...", 10, "Once a respected leader, the Corrupt Politician is now a shadow of his former self, driven by greed and deceit. He manipulates the remnants of society for personal gain, his lies poisoning the minds of the desperate."));
        area1Enemies.add(new Enemy("Judge", 25, 80, 10, "I will bring justice!", "I have failed...", 20, "A once noble figure tasked with upholding justice, the Judge now serves as a ruthless enforcer of Justice's oppressive regime. Blinded by his skewed sense of order, he metes out harsh punishment to any who defy his will."));
        area1Enemies.add(new Enemy("Enforcer of Law", 15, 70, 15, "You are too dangerous, you must be removed.", "You can't beat Justice...", 100, "These robotic sentinels, remnants of the advanced technology that once ruled the world, now blindly enforce Justice's twisted laws. Their cold, unyielding nature makes them formidable opponents to those seeking freedom."));
        area1Enemies.add(new Enemy("Enforcer of Law", 15, 70, 15, "You are too dangerous, you must be removed.", "You can't beat Justice...", 50, "These robotic sentinels, remnants of the advanced technology that once ruled the world, now blindly enforce Justice's twisted laws. Their cold, unyielding nature makes them formidable opponents to those seeking freedom."));
        area1Enemies.add(new Enemy("Enforcer of Law", 15, 70, 15, "You are too dangerous, you must be removed.", "You can't beat Justice...", 50, "These robotic sentinels, remnants of the advanced technology that once ruled the world, now blindly enforce Justice's twisted laws. Their cold, unyielding nature makes them formidable opponents to those seeking freedom."));
        area1Enemies.add(new Enemy("UNFORGIVING JUSTICE", 40, 100, 25, "You are guilty and thy punishment is DEATH.", "Maybe my verdict was wrong...", 200, "Justice was a wise and fair judge, known for his unwavering commitment to the law. He dedicated his life to upholding order and fairness, believing that a just society was the foundation of peace. His deeds were respected, and his judgments were seen as infallible. However, his journey was filled with trials. He faced corruption, deceit, and the complexities of human nature. Each case tested his principles and his ability to remain impartial. As the world around him grew more chaotic, he became increasingly authoritarian, imposing harsh punishments to maintain order. The Whisper saw his desperation and offered him the power to create a perfectly ordered society. Believing it was the only way to achieve true justice, he accepted, not realizing the oppressive nature of the Whisper's vision. His once fair judgments became tools of control, and he lost sight of the very principles he once upheld."));

        area2Enemies = new ArrayList<>();
        area2Enemies.add(new Enemy("Withered Spirit", 40, 110, 5, "Help me please! A morsel of your soul would work!", "Have you no sympathy?...", 20, "These tormented souls, trapped between life and death, are driven by a relentless desire to escape their suffering. Their whispers of despair echo through the desolate lands, haunting those who dare to venture near."));
        area2Enemies.add(new Enemy("Withered Spirit", 40, 110, 5, "Help me please! A morsel of your soul would work!", "Have you no sympathy?...", 20, "These tormented souls, trapped between life and death, are driven by a relentless desire to escape their suffering. Their whispers of despair echo through the desolate lands, haunting those who dare to venture near."));
        area2Enemies.add(new Enemy("Withered Spirit", 40, 110, 5, "Help me please! A morsel of your soul would work!", "Have you no sympathy?...", 20, "These tormented souls, trapped between life and death, are driven by a relentless desire to escape their suffering. Their whispers of despair echo through the desolate lands, haunting those who dare to venture near."));
        area2Enemies.add(new Enemy("Wailing Willow", 60, 140, 10, "I will bring poison!", "I have failed...", 40, "An ancient tree that now wails in anguish..."));
        area2Enemies.add(new Enemy("Guardian Treant", 50, 130, 15, "You shall not reach Mother.", "Mother Compassion--Help...", 100, "Once a guardian of the forest, the Wailing Willow has become a vessel of despair and decay. Its mournful cries and toxic presence make it a formidable miniboss, challenging the knight's resolve."));
        area2Enemies.add(new Enemy("Guardian Treant", 50, 130, 15, "You shall not reach Mother.", "Mother Compassion--Help...", 100, "Once a guardian of the forest, the Wailing Willow has become a vessel of despair and decay. Its mournful cries and toxic presence make it a formidable miniboss, challenging the knight's resolve."));
        area2Enemies.add(new Enemy("Guardian Treant", 50, 130, 15, "You shall not reach Mother.", "Mother Compassion--Help...", 100, "Once a guardian of the forest, the Wailing Willow has become a vessel of despair and decay. Its mournful cries and toxic presence make it a formidable miniboss, challenging the knight's resolve."));
        area2Enemies.add(new Enemy("INDISCRIMINATE COMPASSION", 70, 160, 25, "You look tired, let me embrace you...", "Find it in your heart to forgive me...", 400, "Compassion was once a revered healer, known for her boundless empathy and dedication to alleviating suffering. She traveled across the land, healing the sick and comforting the dying. Her deeds were legendary, and she was beloved by all who knew her. However, her journey was fraught with obstacles. She faced plagues, wars, and natural disasters, each one testing her resolve and strength. Despite the overwhelming odds, she never wavered in her mission to bring relief to those in need. But as she absorbed more and more pain, her own spirit began to wither. The Whisper saw her vulnerability and whispered promises of a world without suffering. Desperate to end the pain, she accepted his offer, not realizing the cost of her decision. The Whisper's twisted vision consumed her once pure heart, and she became a shadow of her former self."));

        currentEnemyIndex = 0;
        currentAreaName = "Justice's Tribunal";
    }

    // Get the current area name
    public String getCurrentAreaName() {
        return currentAreaName;
    }

    // Get the list of enemies based on the current area
    public List<Enemy> getEnemies() {
        if (currentAreaName.equals("Justice's Tribunal")) {
            return area1Enemies;
        } else {
            return area2Enemies;
        }
    }

    // Start the next enemy battle
    public void startNextEnemyBattle(Player player) {
        if (currentEnemyIndex < getEnemies().size()) {
            Enemy enemy = getEnemies().get(currentEnemyIndex);
            String approachMessage = "A " + enemy.getName() + " approaches.\n" + enemy.getDialogue();
            showMessageDialog("Battle Start", approachMessage);
        } else {
            if (currentAreaName.equals("Justice's Tribunal")) {
                currentAreaName = "Compassion's Sanctuary";
                currentEnemyIndex = 0; // Reset the enemy index for the new area
                startNextEnemyBattle(player);
            } else {
                showMessageDialog("Victory", "All enemies defeated! You are victorious!");
            }
        }
    }

    // Player actions during battle
    public void attackPlayer(Player player, Enemy enemy) {
        boolean isCrit = random.nextDouble() < player.getCritRate();
        int damage = (int) (player.getAP() * player.getPrayerBeads());
        if (isCrit) {
            showMessageDialog("Critical Hit!", "Player lands a critical hit!");
            damage *= 2;
        }
        enemy.setHP(enemy.getHP() - damage);
        showMessageDialog("Attack", "Player attacks " + enemy.getName() + " for " + damage + " damage.");
    
        if (enemy.getHP() > 0) {
            enemyTurn(player, enemy);
        } else {
            showMessageDialog("Defeat", enemy.getDeath());
            player.setHP(INITIAL_HEALTH);  // Reset player health
            player.resetPotionCount();  // Reset potion counts
            player.resetStrengthPotionCount();
            player.setMoney(player.getMoney() + enemy.getReward());  // Add money reward to player
            currentEnemyIndex++;
            checkEnemyIndexAndStartBattle(player);
        }
    }
    
    public void defendPlayer() {
        showMessageDialog("Defend", "Player defends.");
    }
    
    public void useItems(Player player, Enemy enemy) {
        String[] options = {
            "Healing Potion (" + player.getPotion() + ")",
            "Strength Potion (" + player.getStrengthPotion() + ")",
            "Firebomb",
            "Ice Dagger",
            "Cancel"
        };
        int choice = JOptionPane.showOptionDialog(null, "Choose an item to use:", "Use Item", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    
        switch (choice) {
            case 0:
                useHealingPotion(player);
                break;
            case 1:
                useStrengthPotion(player);
                break;
            case 2:
                applyFirebombEffect(player, enemy);
                break;
            case 3:
                applyIceDaggerEffect(player);
                break;
            case 4:
                return;  // Cancel
            default:
                showMessageDialog("Invalid Option", "Invalid option.");
                break;
        }
    
        if (enemy.getHP() > 0) {
            enemyTurn(player, enemy);
        }
    }
    
    private void useHealingPotion(Player player) {
        if (player.getPotion() > 0) {
            player.setHP((int) (player.getHP() + player.getHP() * 0.2));
            player.addPotion(-1);
            showMessageDialog("Healing Potion", "Player uses a healing potion and gains 20% HP.");
        } else {
            showMessageDialog("No Healing Potions", "You don't have any healing potions!");
        }
    }
    
    private void useStrengthPotion(Player player) {
        if (player.getStrengthPotion() > 0) {
            player.setAP((int) (player.getAP() + player.getAP() * 0.1));
            player.addStrengthPotion(-1);
            showMessageDialog("Strength Potion", "Player uses a strength potion and gains 10% increase in strength.");
        } else {
            showMessageDialog("No Strength Potions", "You don't have any strength potions!");
        }
    }
    
    private void applyFirebombEffect(Player player, Enemy enemy) {
        player.setFirebombCounter(2); // Set Firebomb effect to last for 2 enemies
        showMessageDialog("Firebomb", "Player uses a firebomb. The current and next 2 enemies will be instakilled.");
        
        // Instakill current enemy
        instakillCurrentEnemy(player, enemy);
    }
    
    private void applyIceDaggerEffect(Player player) {
        player.setIceDaggerCounter(2); // Set Ice Dagger effect to last for 2 turns
        showMessageDialog("Ice Dagger", "Player uses an ice dagger. The next 2 enemy turns will be skipped.");
    }
    
    private void instakillCurrentEnemy(Player player, Enemy enemy) {
        showMessageDialog("Instant Kill", enemy.getDeath());
        enemy.setHP(0);
        player.setMoney(player.getMoney() + enemy.getReward());
        currentEnemyIndex++;
        checkEnemyIndexAndStartBattle(player);
    }
    
    private void checkEnemyIndexAndStartBattle(Player player) {
        if (currentEnemyIndex < getEnemies().size()) {
            startNextEnemyBattle(player);
        } else {
            if (currentAreaName.equals("Justice's Tribunal")) {
                currentAreaName = "Compassion's Sanctuary";
                currentEnemyIndex = 0;
                startNextEnemyBattle(player);
            } else {
                showMessageDialog("Victory", "All enemies defeated! You are victorious!");
            }
        }
    }
    
    public void enemyTurn(Player player, Enemy enemy) {
        if (player.getFirebombCounter() > 0) {
            player.decrementFirebombCounter();
            showMessageDialog("Firebomb Effect", enemy.getName() + " is instakilled due to the firebomb effect.");
            instakillCurrentEnemy(player, enemy);
            return;
        }
    
        if (player.getIceDaggerCounter() > 0) {
            player.decrementIceDaggerCounter();
            showMessageDialog("Ice Dagger Effect", enemy.getName() + "'s turn is skipped due to the ice dagger effect.");
            return;
        }
    
        int damage = enemy.getAP();
        player.setHP(player.getHP() - damage);
        showMessageDialog("Enemy Attack", enemy.getName() + " attacks for " + damage + " damage.");
    
        if (player.getHP() <= 0) {
            showMessageDialog("Defeat", "You have been defeated. Game over.");
            System.exit(0);
        }
    }
    
    // Player actions between battles
    private void betweenBattles(Player player) {
        player.setHP(100);  // Reset player health to initial value
        player.resetPotionCount();  // Reset potion counts
        player.resetStrengthPotionCount();
        showShopMenu(player);
    }
    
    // Player actions between battles
    private void showShopMenu(Player player) {
        Object[] options = {"Shop", "Train", "Continue"};
        int choice = JOptionPane.showOptionDialog(parentFrame, "Choose your next action:", "Between Battles", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    
        switch (choice) {
            case 0:
                openShop(player);
                break;
            case 1:
                openTrainMenu(player);
                break;
            case 2:
                startNextEnemyBattle(player);
                break;
            default:
                showMessageDialog("Invalid Option", "Invalid option.");
                break;
        }
    }
    
    // Player actions between battles
    private void openShop(Player player) {
        Object[] items = {"Healing Potion (20 money)", "Strength Potion (50 money)", "Prayer Beads (50 money)", "Exit"};
        int choice = JOptionPane.showOptionDialog(parentFrame, "Welcome to the shop! What would you like to buy?", "Shop", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, items, items[0]);
    
        switch (choice) {
            case 0:
                buyItem(player, 20, "Healing Potion", () -> player.addPotion(1));
                break;
            case 1:
                buyItem(player, 50, "Strength Potion", () -> player.addStrengthPotion(1));
                break;
            case 2:
                buyItem(player, 50, "Prayer Beads", () -> player.addPrayerBeads(1));
                break;
            case 3:
                showShopMenu(player);
                break;
            default:
                showMessageDialog("Invalid Option", "Invalid option.");
                break;
        }
    }
    
    // Player actions between battles
    private void buyItem(Player player, int cost, String itemName, Runnable purchaseAction) {
        if (player.getMoney() >= cost) {
            player.setMoney(player.getMoney() - cost);
            purchaseAction.run();
            showMessageDialog("Purchase", "You bought a " + itemName + ".");
        } else {
            showMessageDialog("Insufficient Funds", "You don't have enough money to buy a " + itemName + ".");
        }
        openShop(player);
    }
    
    // Player actions between battles
    private void openTrainMenu(Player player) {
        Object[] trainings = {"Increase Attack Power (50 money)", "Increase Health (40 money)", "Exit"};
        int choice = JOptionPane.showOptionDialog(parentFrame, "What would you like to train?", "Train", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, trainings, trainings[0]);
    
        switch (choice) {
            case 0:
                trainAttribute(player, 50, "Attack Power", () -> player.setAP(player.getAP() + 10));
                break;
            case 1:
                trainAttribute(player, 40, "Health", () -> player.setHP(player.getHP() + 20));
                break;
            case 2:
                showShopMenu(player);
                break;
            default:
                showMessageDialog("Invalid Option", "Invalid option.");
                break;
        }
    }
    
    // Player actions between battles
    private void trainAttribute(Player player, int cost, String attribute, Runnable trainAction) {
        if (player.getMoney() >= cost) {
            player.setMoney(player.getMoney() - cost);
            trainAction.run();
            showMessageDialog("Training", "Your " + attribute + " has increased.");
        } else {
            showMessageDialog("Insufficient Funds", "You don't have enough money to train your " + attribute + ".");
        }
        openTrainMenu(player);
    }
    
    // Helper method to show a message dialog
    private void showMessageDialog(String title, String message) {
        JOptionPane.showMessageDialog(parentFrame, message, title, JOptionPane.PLAIN_MESSAGE);
    }
    
    // Helper method to append message to the game UI
    private void appendMessage(String message) {
        if (parentFrame instanceof GameUI) {
            ((GameUI) parentFrame).appendMessage(message);
        }
    }
}
