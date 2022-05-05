package Lab10;

// Austin Reichert
// 12/6/19
// Collaborators: Tanner Steorts (Tester)

import java.util.InputMismatchException; //imports that
import java.util.Random; //imports random
import java.util.Scanner; //imports scanner

public class Game { //class

    Random r = new Random(); //lets me use random
    Character c = new Character(); //makes a new character using character constructor (whenever a battle is created.)
    Enemy e = new Enemy(); //makes a new enemy using enemy constructor (whenever a battle is created.)
    Scanner scan = new Scanner(System.in);

    private static String[] skills = {"Heal","Meditate","Strike","Blind Swing","Lucky Strike","Health Spike","Double Edge", "Defensive Strike", "Defend"};
    //holds names of skills.
    private static int[] skillCost = {1,0,0,2,2,3,2,3,3};
    //holds mana cost of skills
    private String[] cSkillSet; //holds what skills a character can do.
    private String[] eSkillSet; //holds what skills an enemy can do.
    private int Scale; //holds scale amount

    public Game(){
    cSkillSet = new String[4];
    eSkillSet = new String[4]; } //constructor. Makes a place to store skillsets.

    public void SetPlayerName(String n){ c.setName(n); } //sets user name (for msgs)

    public void SetScaling(int S){
        System.out.println("Scaling set to " + S + "\n");
        this.Scale = S; } //sets scaling based on 'S'

    public void RandomlyAssignPlayerSkills(){
        int a = 0; int b = 0;
        int c = 0; int d = 0; //variables used to assure no dupes
        a = r.nextInt(9);
        b = r.nextInt(9);
        c = r.nextInt(9);
        d = r.nextInt(9); //randomizes the variables

        cSkillSet[0] = null;
        cSkillSet[1] = null;
        cSkillSet[2] = null;
        cSkillSet[3] = null; //makes these null (in case of rerolling skills)

        //assigns the player skill set random skills without dupes
        while(cSkillSet[0] == null){
            if(a != b && a != c && a != d){ cSkillSet[0] = skills[a]; }
            else{ a = r.nextInt(9); } }
        while(cSkillSet[1] == null){
            if(b != a && b != c && b != d){ cSkillSet[1] = skills[b]; }
            else{ b = r.nextInt(9); } }
        while(cSkillSet[2] == null){
            if(c != a && c != b && a != d){ cSkillSet[2] = skills[c]; }
            else{ c = r.nextInt(9); } }
        while(cSkillSet[3] == null){
            if(d != a && d != b && d != c){ cSkillSet[3] = skills[d]; }
            else{ d = r.nextInt(9); } } }

    public void RandomlyAssignEnemySkills(){
        int a = 0; int b = 0;
        int c = 0; int d = 0; //variables used to assure no dupes
        a = r.nextInt(9);
        b = r.nextInt(9);
        c = r.nextInt(9);
        d = r.nextInt(9); //randomizes the variables

        eSkillSet[0] = null;
        eSkillSet[1] = null;
        eSkillSet[2] = null;
        eSkillSet[3] = null; //makes these null (in case of rerolling skills)

        //while loops below assigns the enemy skill set random skills without dupes
        while(eSkillSet[0] == null){
            if(a != b && a != c && a != d){ eSkillSet[0] = skills[a]; }
            else{ a = r.nextInt(9); } }
        while(eSkillSet[1] == null){
            if(b != a && b != c && b != d){ eSkillSet[1] = skills[b]; }
            else{ b = r.nextInt(9); } }
        while(eSkillSet[2] == null){
            if(c != a && c != b && a != d){ eSkillSet[2] = skills[c]; }
            else{ c = r.nextInt(9); } }
        while(eSkillSet[3] == null){
            if(d != a && d != b && d != c){ eSkillSet[3] = skills[d]; }
            else{ d = r.nextInt(9); } } }

    public void PlayGame(){
        e.setScale(Scale);
        int playerDMG = 0; //stores dmg player does
        int enemyDMG = 0; //stores dmg enemy does
        int i = 0; //variable used to create infinite loop game is played in.
        int KeepRound = 0;

        while( i > -1){ //infinite until the player looses
        RandomlyAssignEnemySkills(); //rerolls skill set
        RandomlyAssignPlayerSkills(); //rerolls skill set
        KeepRound = 0; //Stores amount of rounds played.

        while(c.getHP() > 0 && e.getHP() > 0){ //infinite until someone dies

        int ran = r.nextInt(4); //generates random number
        playerDMG = Menu(); //menu dictates the dmg the player does
        enemyDMG = EnemyTurn(); //enemyturn dictates the dmg the enemy does
        playerDMG = playerDMG - e.getDef(); //calculates how much dmg is mitigated by def
        enemyDMG = enemyDMG - c.getDef(); //calculates how much dmg is mitigated by def

        if(playerDMG <= 0){ playerDMG = 0; }
        else{ e.setHP(e.getHP()-playerDMG); //alters enemy hp if player gets through their def
        System.out.println(c.getName() + " dealt " + playerDMG + " damage to " + e.getName() + "!"); }
        if(enemyDMG <= 0){ enemyDMG = 0; }
        else{ c.setHP(c.getHP()-enemyDMG); //alters player hp if enemy gets through their def
        System.out.println(e.getName() + " dealt " + enemyDMG + " damage to " + c.getName() +"!"); }
        if(ran == 0){ RegenManaCE(); } //random chance for enemy and player to gain mana.

        if(KeepRound > 25){
        c.setHP(c.getHP()-1);
        e.setHP(e.getHP()-1); } //makes sure players dont play 1 battle for too long.

        if(c.getHP() <= 0 || e.getHP() <= 0){ break; } //makes sure that if someones hp is zero then it breaks
        KeepRound++; }

        if(c.getHP() <= 0){ System.out.println(c.gameOver()); //Game over screen.
        i = -2; } //make sure the infinite loop ends.
        else if(e.getHP() <= 0){
        System.out.println("Enemy defeated!");
        c.LevelUp(); //levels up player
        e.setCharalvl(c.getLevel());

        if(Scale == 0){ e.RandomizeEnemyWithoutScale(); }
        else{ e.RandomizeEnemyWithScale(); } //scales enemy by scaling + user lvl.

        } } }

    public String PrintSkill(){
        String s = "";
        int i = 0;
        s += c.getName()+"'s skill set \n";
        while(i<4){
        s+=cSkillSet[i] + "\n";
        if(cSkillSet[i].equals("Heal")){ s+= "- Heals you to regen HP. [COSTS " + skillCost[0] + " MANA]\n"; }
        else if(cSkillSet[i].equals("Meditate")){ s+= "- Meditates to gain mana. [COSTS " + skillCost[1] + " MANA]\n"; }
        else if(cSkillSet[i].equals("Strike")){ s+= "- Swings at the enemy. [COSTS " + skillCost[2] + " MANA]\n"; }
        else if(cSkillSet[i].equals("Blind Swing")){ s+= "- Swings blindly at the enemy. Has a chance to miss. [COSTS " + skillCost[3] + " MANA]\n"; }
        else if(cSkillSet[i].equals("Lucky Strike")){ s+= "- Strikes the enemy (boosted by your luck stat). Has a chance to miss. [COSTS " + skillCost[4] + " MANA]\n"; }
        else if(cSkillSet[i].equals("Health Spike")){ s+= "- Expends half of your HP to do extra damage. [COSTS " + skillCost[5] + " MANA]\n"; }
        else if(cSkillSet[i].equals("Double Edge")){ s+= "- Slams the enemy full power. Inflicts recoil. [COSTS " + skillCost[6] + " MANA]\n"; }
        else if(cSkillSet[i].equals("Defensive Strike")){ s+= "- Strikes and increases defence. [COSTS " + skillCost[7] + " MANA]\n"; }
        else if(cSkillSet[i].equals("Defend")){ s+= "- Increases your defence. Has a chance to falter. [COSTS " + skillCost[8] + " MANA]\n"; }
        i++; } return s; }  //goes through and prints both the name and description of the skills the player has.

    public int Menu(){
        int input = 0; //stores user input
        int i = 1; //creates infinite for menu
        int dmg = 0; //stores dmg from 'playerturn'

        while(i == 1){
            System.out.println("");
            System.out.println(c.getName()+ "'s Mana: " + c.getMana()+"/"+c.getManaMax());
            System.out.println(c.getName()+ "'s HP: " + c.getHP()+"/"+c.getHPMax());
            System.out.println(e.getName()+ "'s HP: " + e.getHP()+"/"+e.getHPMax() + "\n");
            //prints players hp and mana. Prints enemies hp.

            System.out.println("Type in the corresponding number to do an action:");
            System.out.println("1: Fight.");
            System.out.println("2: View your current stats.");
            System.out.println("3: View the descriptions of your current skill set. \n");
            try{input = scan.nextInt(); }
            catch(InputMismatchException ff){ input = 4; } //if user enters a bad input, goes to error msg.
            if(input == 1){
                dmg = PlayerTurn();
                i--; } //i makes this loop break.
            else if(input == 2){ System.out.println(c.toString()); } //prints characters stats
            else if(input == 3){ System.out.println(PrintSkill()); } //prints skill set
            else{ System.out.println("Invalid input!"); //any other input is considered invalid.
                scan.nextLine();} }
        return dmg; }

    public int EnemyTurn(){
        int dmg = 0; //stores damage value.
        int rand = 0; //stores random choice

        rand = r.nextInt(4); //selects a number 0-3

        if(eSkillSet[rand].equals("Heal")){ e.Heal(); }
        else if(eSkillSet[rand].equals("Meditate")){ e.Meditate(); }
        else if(eSkillSet[rand].equals("Blind Swing")){ dmg = e.BlindSwing(); }
        else if(eSkillSet[rand].equals("Lucky Strike")){ dmg = e.LuckyStrike(); }
        else if(eSkillSet[rand].equals("Strike")){ dmg = e.Strike(); }
        else if(eSkillSet[rand].equals("Health Spike")){ dmg = e.HealthSpike(); }
        else if(eSkillSet[rand].equals("Double Edge")){ dmg = e.DoubleEdge(); }
        else if(eSkillSet[rand].equals("Defensive Strike")){ dmg = e.DefensiveStrike(); }
        else if(eSkillSet[rand].equals("Defend")){ e.Defend(); }
        //does corresponding move from the enemys generated number.
        // EX: 0: Heal  1: Meditate  2: Strike  3: Lucky Strike --> random number is 3 --> Lucky Strike is performed (dmg stored).
        return dmg; }

    public int PlayerTurn(){
        int dmg = 0; //stores damage value.
        int input = 0; //stores input of user.
        int i = 0; //counter variable.
        int j = 0; //infinite variable.

        scan.nextLine(); //clears last user input
        while(j == 0){
        System.out.println("Enter a number to use the corresponding skill. (#: Skill [Mana Cost])");
        for(i=0; i < 4;){

        if(cSkillSet[i].equals("Heal")){
        System.out.println(i+ ": " + cSkillSet[i] + "  [" + skillCost[0] + "]"); }
        else if(cSkillSet[i].equals("Meditate")){
        System.out.println(i+ ": " + cSkillSet[i] + "  [" + skillCost[1] + "]"); }
        else if(cSkillSet[i].equals("Strike")){
        System.out.println(i+ ": " + cSkillSet[i] + "  [" + skillCost[2] + "]"); }
        else if(cSkillSet[i].equals("Blind Swing")){
        System.out.println(i+ ": " + cSkillSet[i] + "  [" + skillCost[3] + "]"); }
        else if(cSkillSet[i].equals("Lucky Strike")){
        System.out.println(i+ ": " + cSkillSet[i] + "  [" + skillCost[4] + "]"); }
        else if(cSkillSet[i].equals("Health Spike")){
        System.out.println(i+ ": " + cSkillSet[i] + "  [" + skillCost[5] + "]"); }
        else if(cSkillSet[i].equals("Double Edge")){
        System.out.println(i+ ": " + cSkillSet[i] + "  [" + skillCost[6] + "]"); }
        else if(cSkillSet[i].equals("Defensive Strike")){
        System.out.println(i+ ": " + cSkillSet[i] + "  [" + skillCost[7] + "]"); }
        else if(cSkillSet[i].equals("Defend")){
        System.out.println(i+ ": " + cSkillSet[i] + "  [" + skillCost[8] + "]"); }
        i++; } //prints characters current skill set.

        try{ input = scan.nextInt(); }
        catch(InputMismatchException ef){
        input = 4; }
        if(input == 0 || input == 1 || input == 2 || input == 3 ){ j = 1; }
        else{ System.out.println("Invalid input! \n");
        scan.nextLine(); } } //makes sure user entered a viable input. else, gives error msg and tries again.

        if(cSkillSet[input].equals("Heal")){ c.Heal(); }
        else if(cSkillSet[input].equals("Meditate")){ c.Meditate(); }
        else if(cSkillSet[input].equals("Blind Swing")){ dmg = c.BlindSwing(); }
        else if(cSkillSet[input].equals("Lucky Strike")){ dmg = c.LuckyStrike(); }
        else if(cSkillSet[input].equals("Strike")){ dmg = c.Strike(); }
        else if(cSkillSet[input].equals("Health Spike")){ dmg = c.HealthSpike(); }
        else if(cSkillSet[input].equals("Double Edge")){ dmg = c.DoubleEdge(); }
        else if(cSkillSet[input].equals("Defensive Strike")){ dmg = c.DefensiveStrike(); }
        else if(cSkillSet[input].equals("Defend")){ c.Defend(); }
        //does corresponding move from the users input.
        // EX: 0: Heal  1: Meditate  2: Strike  3: Lucky Strike --> user input is 2 --> Strike is performed (dmg stored).
        return dmg; }

    public void RegenManaCE(){
        c.RegenMana();
        e.RegenMana();
        //makes sure that game is not stalemated due to lack of mana.
    }

}
