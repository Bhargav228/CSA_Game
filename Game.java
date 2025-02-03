public class Game{
    final static String Black = "\u001b[30m";
    final static String Red = "\u001b[31m";
    final static String Green = "\u001b[32m";
    final static String Yellow = "\u001b[33m";
    final static String Blue = "\u001b[34m";
    final static String Magenta = "\u001b[35m";
    final static String Cyan = "\u001b[36m";
    final static String White = "\u001b[37m";
    final static String BrightBlack = "\u001b[30;1m";
    final static String BrightRed = "\u001b[31;1m";
    final static String BrightGreen = "\u001b[32;1m";
    final static String BrightYellow = "\u001b[33;1m";
    final static String BrightBlue = "\u001b[34;1m";
    final static String BrightMagenta = "\u001b[35;1m";
    final static String BrightCyan = "\u001b[36;1m";
    final static String BrightWhite = "\u001b[37;1m";
    final static String Reset = "\u001b[0m";

    public void IntoMono() throws InterruptedException {

        //intro monlouge
        System.out.println("\n\n");
        System.out.println("In the heart of a land where the sun has long abandoned its throne, shadows writhe and coil like serpents in the suffocating gloom.");
        Thread.sleep(2000);
        System.out.println("The air is thick with the stench of decay, and the distant toll of a bell, cracked and ancient, reverberates through the desolate expanse, a dirge for the damned.");
        Thread.sleep(2000);
        System.out.println("Before you, a figure descends from the murky heavens, their wings a stark contrast to the oppressive darkness.\n");
        Thread.sleep(2000);
        System.out.print("This is your guide, an angel of the Four Paragons:");
        Thread.sleep(1500);
        System.out.println("\tgods whose presence is as palpable as the very air you breathe." + BrightWhite);
        Thread.sleep(2000);
        System.out.println(Reset+"They are powerul ... their influence is woven into the fabric of existence, their virtues twisted by the world's corruption: ");
        Thread.sleep(3000);
        System.out.println(Red+"Valor, has now become a thirst for blood");
        Thread.sleep(3000);
        System.out.println(Green+"Wisdom, now a cunning deceit");
        Thread.sleep(3000);
        System.out.println(Magenta+"Compassion, a cruel mercy of endless pain");
        Thread.sleep(3000);
        System.out.println(Blue+"Justice, a relentless vengeance \n\n");
        Thread.sleep(3000);
        System.out.println(Reset+"The angel's voice, a haunting melody of sorrow and command, slices through the silence.");
        Thread.sleep(2000);
        System.out.println(BrightYellow+"\"Chosen warrior, the Paragons have marked you as their successor. Your path will be one of blood and shadow, where you must crush your enemies and grow in power to prove your worth.\nOnly through relentless struggle and sacrifice will you earn the favor of the Paragons and ascend to your destined place.\"");
        Thread.sleep(2000);
        System.out.println(Reset+"The angel glides closer, their eyes reflecting the abyssal weight of your quest."+ BrightYellow + "\n" + "\"But despair not, for I shall walk this cursed path with you, offering what guidance and solace I can. Now, tell me, brave soul, what name shall I call you by?\""+ Reset);
        Thread.sleep(2000);
    }


}
