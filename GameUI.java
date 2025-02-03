import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameUI extends JFrame {
    private Player player;
    private Enemy currentEnemy;
    private GamePath gamePath;
    private int currentEnemyIndex;
    private JLabel areaNameLabel;
    private JTextArea messageArea;

    // Panels to display player and enemy stats
    private JLabel playerHealthLabel;
    private JLabel enemyHealthLabel;
    private JLabel playerAPLabel;
    private JLabel playerMoneyLabel;
    private JLabel enemyNameLabel;
    private JLabel enemyAPLabel;
    private JTextArea enemyLoreTextArea;

    public GameUI(Player player, GamePath gamePath) {
        this.player = player;
        this.gamePath = gamePath;
        this.currentEnemyIndex = 0;

        // Set up the main window
        setTitle("Epic Battle Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Show title screen
        showTitleScreen();
        setVisible(true);
    }

    // Method to show the title screen
    private void showTitleScreen() {
        JLabel titleLabel = new JLabel("Fourfold Shadows");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // Start button
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Serif", Font.BOLD, 24));
        startButton.setBackground(Color.GREEN);
        startButton.setForeground(Color.BLACK);

        // Start the game when the button is clicked
        startButton.addActionListener((ActionEvent e) -> {
            getContentPane().removeAll();
            showIntroMonologue();
            revalidate();
            repaint();
        });

        // Title panel
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(Color.DARK_GRAY);
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        titlePanel.add(startButton, BorderLayout.SOUTH);

        getContentPane().add(titlePanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    // Method to show the intro monologue
    private void showIntroMonologue() {
        JTextArea monologueArea = new JTextArea(
            "In the heart of a land where the sun has long abandoned its throne, " +
            "shadows writhe and coil like serpents in the suffocating gloom...\n\n" + 
            "Before you, a figure descends from the murky heavens...\n\n" + 
            "\"Chosen warrior, the Paragons have marked you as their successor. " +
            "Your path will be one of blood and shadow...\"\n\n" +
            "Now, tell me, brave soul, what name shall I call you by?");
        monologueArea.setFont(new Font("Serif", Font.PLAIN, 18));
        monologueArea.setForeground(Color.WHITE);
        monologueArea.setBackground(Color.DARK_GRAY);
        monologueArea.setMargin(new Insets(20, 20, 20, 20));
        monologueArea.setLineWrap(true);
        monologueArea.setWrapStyleWord(true);
        monologueArea.setEditable(false);

        // Radio buttons for character selection
        JRadioButton algerButton = new JRadioButton("Alger Whitlock");
        algerButton.setFont(new Font("Serif", Font.PLAIN, 18));
        algerButton.setForeground(Color.WHITE);
        algerButton.setBackground(Color.DARK_GRAY);

        // Updated to include Guinevere as a character choice
        JRadioButton guinevereButton = new JRadioButton("Guinevere Whitlock");
        guinevereButton.setFont(new Font("Serif", Font.PLAIN, 18));
        guinevereButton.setForeground(Color.WHITE);
        guinevereButton.setBackground(Color.DARK_GRAY);

        // Group the radio buttons
        ButtonGroup characterGroup = new ButtonGroup();
        characterGroup.add(algerButton);
        characterGroup.add(guinevereButton);

        // Panel for radio buttons and continue button
        JPanel radioPanel = new JPanel(new FlowLayout());
        radioPanel.setBackground(Color.DARK_GRAY);
        radioPanel.add(algerButton);
        radioPanel.add(guinevereButton);

        // Continue button
        JButton continueButton = new JButton("Continue");
        continueButton.setFont(new Font("Serif", Font.BOLD, 24));
        continueButton.setBackground(Color.GREEN);
        continueButton.setForeground(Color.BLACK);

        // Set the player name based on the selected radio button
        continueButton.addActionListener((ActionEvent e) -> {
            if (algerButton.isSelected()) {
                player.setPlayerName("Alger Whitlock");
            } else if (guinevereButton.isSelected()) {
                player.setPlayerName("Guinevere Whitlock");
            }
            getContentPane().removeAll();
            setUpGameUI();
            revalidate();
            repaint();
        });

        // Input panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(Color.DARK_GRAY);
        inputPanel.add(radioPanel, BorderLayout.CENTER);
        inputPanel.add(continueButton, BorderLayout.SOUTH);

        // Intro panel
        JPanel introPanel = new JPanel(new BorderLayout());
        introPanel.setBackground(Color.DARK_GRAY);
        introPanel.add(monologueArea, BorderLayout.CENTER);
        introPanel.add(inputPanel, BorderLayout.SOUTH);

        getContentPane().add(introPanel, BorderLayout.CENTER);

        // Fade-in effect
        Timer timer = new Timer(50, new ActionListener() {
            private int alpha = 0;

            // Updated to include fade-in effect for radio buttons and continue button
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha += 5;
                if (alpha > 255) {
                    alpha = 255;
                    monologueArea.setForeground(new Color(255, 255, 255, alpha));
                    ((Timer) e.getSource()).stop();
                } else {
                    monologueArea.setForeground(new Color(255, 255, 255, alpha));
                }
            }
        });
        timer.start();

        revalidate();
        repaint();
    }

    // Method to set up the game UI
    private void setUpGameUI() {
        if (gamePath.getEnemies().size() > 0) {
            currentEnemy = gamePath.getEnemies().get(currentEnemyIndex);
        }

        // Main game UI layout
        getContentPane().setBackground(Color.DARK_GRAY);
        add(createPlayerPanel(), BorderLayout.WEST);
        add(createEnemyPanel(), BorderLayout.EAST);
        add(createActionPanel(), BorderLayout.SOUTH);

        // Display area name
        areaNameLabel = new JLabel(gamePath.getCurrentAreaName());
        areaNameLabel.setFont(new Font("Serif", Font.BOLD, 36));
        areaNameLabel.setForeground(Color.YELLOW);
        areaNameLabel.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(areaNameLabel, BorderLayout.NORTH);

        // Text area for displaying messages
        messageArea = new JTextArea();
        messageArea.setFont(new Font("Serif", Font.PLAIN, 18));
        messageArea.setForeground(Color.WHITE);
        messageArea.setBackground(Color.DARK_GRAY);
        messageArea.setMargin(new Insets(20, 20, 20, 20));
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        messageArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Start the fight and display enemy introduction
        gamePath.startNextEnemyBattle(player);
        updatePanels();
    }

    private JPanel createPlayerPanel() {
        // Panel to display player stats
        JPanel playerPanel = new JPanel(new GridBagLayout());
        playerPanel.setBackground(Color.BLACK);
        playerPanel.setForeground(Color.WHITE);

        // Set up constraints for GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Set font for labels
        Font labelFont = new Font("Serif", Font.BOLD, 20);  // Set font size

        // Display player name, health, attack power, and money
        JLabel playerNameLabel = new JLabel("Player: " + player.getPlayerName());
        playerNameLabel.setForeground(Color.WHITE);
        playerNameLabel.setFont(labelFont);  // Set font size
        gbc.gridy = 0;
        playerPanel.add(playerNameLabel, gbc);

        playerHealthLabel = new JLabel("Health: " + player.getHP());
        playerHealthLabel.setForeground(Color.WHITE);
        playerHealthLabel.setFont(labelFont);  // Set font size
        gbc.gridy = 1;
        playerPanel.add(playerHealthLabel, gbc);

        playerAPLabel = new JLabel("Attack Power: " + player.getAP());
        playerAPLabel.setForeground(Color.WHITE);
        playerAPLabel.setFont(labelFont);  // Set font size
        gbc.gridy = 2;
        playerPanel.add(playerAPLabel, gbc);

        playerMoneyLabel = new JLabel("Money: " + player.getMoney());
        playerMoneyLabel.setForeground(Color.WHITE);
        gbc.gridy = 3;
        playerPanel.add(playerMoneyLabel, gbc);

        return playerPanel;
    }

    private JPanel createEnemyPanel() {
        // Panel to display enemy stats
        JPanel enemyPanel = new JPanel(new GridBagLayout());
        enemyPanel.setBackground(Color.BLACK);
        enemyPanel.setForeground(Color.WHITE);

        // Set up constraints for GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        Font labelFont = new Font("Serif", Font.BOLD, 20);

        // Display enemy name, health, attack power, and lore
        enemyNameLabel = new JLabel("Enemy: " + currentEnemy.getName());
        enemyNameLabel.setForeground(Color.RED);
        enemyNameLabel.setFont(labelFont);
        gbc.gridy = 0;
        enemyPanel.add(enemyNameLabel, gbc);

        enemyHealthLabel = new JLabel("Health: " + currentEnemy.getHP());
        enemyHealthLabel.setForeground(Color.RED);
        enemyHealthLabel.setFont(labelFont);
        gbc.gridy = 1;
        enemyPanel.add(enemyHealthLabel, gbc);

        enemyAPLabel = new JLabel("Attack Power: " + currentEnemy.getAP());
        enemyAPLabel.setForeground(Color.RED);
        enemyAPLabel.setFont(labelFont);
        gbc.gridy = 2;
        enemyPanel.add(enemyAPLabel, gbc);

        enemyLoreTextArea = new JTextArea("Lore: " + currentEnemy.getLore());
        enemyLoreTextArea.setWrapStyleWord(true);
        enemyLoreTextArea.setLineWrap(true);
        enemyLoreTextArea.setFont(labelFont);
        enemyLoreTextArea.setForeground(Color.RED);
        enemyLoreTextArea.setBackground(Color.BLACK);
        enemyLoreTextArea.setEditable(false);
        enemyLoreTextArea.setColumns(20);
        gbc.gridy = 3;
        enemyPanel.add(enemyLoreTextArea, gbc);

        return enemyPanel;
    }

    private JPanel createActionPanel() {
        // Panel for player actions
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new GridBagLayout());
        actionPanel.setBackground(Color.GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Buttons for player actions
        JButton attackButton = new JButton("Attack");
        attackButton.setBackground(Color.RED);
        attackButton.setForeground(Color.WHITE);

        JButton defendButton = new JButton("Defend");
        defendButton.setBackground(Color.BLUE);
        defendButton.setForeground(Color.WHITE);

        JButton useItemButton = new JButton("Use Item");
        useItemButton.setBackground(Color.GREEN);
        useItemButton.setForeground(Color.BLACK);

        JButton runButton = new JButton("Run");
        runButton.setBackground(Color.YELLOW);
        runButton.setForeground(Color.BLACK);

        // Set up action listeners for buttons
        attackButton.addActionListener((ActionEvent e) -> {
            gamePath.attackPlayer(player, currentEnemy);
            if (currentEnemy.getHP() <= 0) {
                player.setHP(100);  // Reset player health after defeating an enemy
                player.setMoney(player.getMoney() + currentEnemy.getReward()); // Add enemy reward to player's money
                currentEnemyIndex++;
                if (currentEnemyIndex < gamePath.getEnemies().size()) {
                    currentEnemy = gamePath.getEnemies().get(currentEnemyIndex);
                    String approachMessage = "A " + currentEnemy.getName() + " approaches.\n" + currentEnemy.getDialogue();
                    appendMessage(approachMessage);  // Display the new enemy approach message
                } else {
                    // All enemies are defeated
                    showShopAndTrainMenu();
                    return;
                }
                updatePanels();
            } else {
                enemyTurn();
            }
        });

        defendButton.addActionListener((ActionEvent e) -> {
            gamePath.defendPlayer();
            enemyTurn(); // End the player's turn by invoking the enemy's turn
        });

        useItemButton.addActionListener((ActionEvent e) -> {
            gamePath.useItems(player, currentEnemy);
            updatePanels();
        });

        runButton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Player runs away!");
            showEndingScreen(); // Show the ending screen
        });

        // Add buttons to the action panel
        gbc.gridx = 0;
        actionPanel.add(attackButton, gbc);
        gbc.gridx = 1;
        actionPanel.add(defendButton, gbc);
        gbc.gridx = 2;
        actionPanel.add(useItemButton, gbc);
        gbc.gridx = 3;
        actionPanel.add(runButton, gbc);

        return actionPanel;
    }

    private void updatePanels() {
        // Update player and enemy stats
        playerHealthLabel.setText("Health: " + player.getHP());
        playerAPLabel.setText("Attack Power: " + player.getAP());
        playerMoneyLabel.setText("Money: " + player.getMoney());

        if (currentEnemy != null) {
            enemyNameLabel.setText("Enemy: " + currentEnemy.getName());
            enemyHealthLabel.setText("Health: " + currentEnemy.getHP());
            enemyAPLabel.setText("Attack Power: " + currentEnemy.getAP());
            enemyLoreTextArea.setText("Lore: " + currentEnemy.getLore());
        } else {
            enemyHealthLabel.setText("No enemy left");
        }

        revalidate();
        repaint();
    }

    private void enemyTurn() {
        // Enemy attacks the player
        if (currentEnemy != null && currentEnemy.getHP() > 0) {
            int damage = currentEnemy.getAP();
            player.setHP(player.getHP() - damage);
            appendMessage(currentEnemy.getName() + " attacks player for " + damage + " damage.");
            
            if (player.getHP() <= 0) {
                appendMessage("Player is defeated! Game Over.");
                showEndingScreen();
                return;
            }
            updatePanels();
        }
    }

    private void showShopAndTrainMenu() {
        // Show shop/train menu between fights
        Object[] options = {"Shop", "Train", "Continue"};
        int choice = JOptionPane.showOptionDialog(null, "Choose your next action:", "Between Battles",
                                                  JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                                  null, options, options[0]);

        switch (choice) {
            case 0:
                showShopMenu();
                break;
            case 1:
                showTrainMenu();
                break;
            case 2:
                if (currentEnemyIndex < gamePath.getEnemies().size()) {
                    currentEnemy = gamePath.getEnemies().get(currentEnemyIndex);
                    String approachMessage = "A " + currentEnemy.getName() + " approaches.\n" + currentEnemy.getDialogue();
                    appendMessage(approachMessage);  // Display the new enemy approach message
                } else {
                    showEndingScreen();  // Show the ending screen if all enemies are defeated
                }
                break;
            default:
                showEndingScreen();
                break;
        }
    }

    private void showShopMenu() {
        Object[] items = {"Healing Potion (20 money)", "Strength Potion (30 money)", "Prayer Beads (50 money)", "Exit"};
        int choice = JOptionPane.showOptionDialog(null, "Welcome to the shop! What would you like to buy?", "Shop",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
        null, items, items[0]);

        switch (choice) {
            case 0:
                buyItem(20, "Healing Potion", () -> player.addPotion(1));
                break;
            case 1:
                buyItem(30, "Strength Potion", () -> player.addStrengthPotion(1));
                break;
            case 2:
                buyItem(50, "Prayer Beads", () -> player.addPrayerBeads(1));
                break;
            case 3:
                showShopAndTrainMenu();
                break;
            default:
                appendMessage("Invalid option.");
                showShopAndTrainMenu();
                break;
        }
    }

    private void showTrainMenu() {
        Object[] trainings = {"Increase Attack Power (50 money)", "Increase Health (40 money)", "Exit"};
        int choice = JOptionPane.showOptionDialog(null, "What would you like to train?", "Train",
                                                  JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                                  null, trainings, trainings[0]);

        switch (choice) {
            case 0:
                trainAttribute(50, "Attack Power", () -> player.setAP(player.getAP() + 5));
                break;
            case 1:
                trainAttribute(40, "Health", () -> player.setHP(player.getHP() + 10));
                break;
            case 2:
                showShopAndTrainMenu();
                break;
            default:
                appendMessage("Invalid option.");
                showShopAndTrainMenu();
                break;
        }
    }

    private void buyItem(int cost, String itemName, Runnable purchaseAction) {
        if (player.getMoney() >= cost) {
            player.setMoney(player.getMoney() - cost);
            purchaseAction.run();
            appendMessage("You bought a " + itemName + ".");
        } else {
            appendMessage("You don't have enough money to buy a " + itemName + ".");
        }
        showShopMenu();
    }

    private void trainAttribute(int cost, String attribute, Runnable trainAction) {
        if (player.getMoney() >= cost) {
            player.setMoney(player.getMoney() - cost);
            trainAction.run();
            appendMessage("Your " + attribute + " has increased.");
        } else {
            appendMessage("You don't have enough money to train your " + attribute + ".");
        }
        showTrainMenu();
    }

    private void showEndingScreen() {
        // Remove all components from the content pane
        getContentPane().removeAll();
        JLabel endingLabel = new JLabel("2 paragons defeated, 2 more to slay\nIn part 2");
        endingLabel.setFont(new Font("Serif", Font.BOLD, 36));
        endingLabel.setForeground(Color.YELLOW);
        endingLabel.setHorizontalAlignment(JLabel.CENTER);

        getContentPane().add(endingLabel, BorderLayout.CENTER);

        // Fade-in effect
        Timer timer = new Timer(50, new ActionListener() {
            private int alpha = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                alpha += 5;
                if (alpha > 255) {
                    alpha = 255;
                    endingLabel.setForeground(new Color(255, 255, 255, alpha));
                    ((Timer) e.getSource()).stop();
                } else {
                    endingLabel.setForeground(new Color(255, 255, 255, alpha));
                }
            }
        });
        timer.start();

        revalidate();
        repaint();
    }
    
    // Method to append messages to the message area
    public void appendMessage(String message) {
        messageArea.append(message + "\n");
        messageArea.setCaretPosition(messageArea.getDocument().getLength());
    }
}
