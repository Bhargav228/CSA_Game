public class Main {

    //main method
    public static void main(String[] args) throws InterruptedException {

        //player stats
        Player player = new Player("", 100, 10, 100);
        System.out.println(player);

        //launch the game UI
        GamePath gamePath = new GamePath(null);
        GameUI gameUI = new GameUI(player, gamePath);
    }
}
