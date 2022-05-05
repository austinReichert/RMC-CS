package Lab10;

// Austin Reichert
// 12/6/19
// Collaborators: Tanner Steorts (Tester)

import java.util.Random; //lets me use random

public class Character { //character class

    Random rand = new Random(); //calls random
    //random names for the name (16 names)
    private static final int attack=0;
    private static final int def=1;
    private static final int hpMax=2;
    private static final int manaMax=3;
    private static final int luck=4;
    private static final int mana=5;
    private static final int hp=6;
    private static final int level=7;
    //sets their positions in the array.
    private int[] stats; //stats array.
    private String name;

    public Character(){ stats = new int[8]; //makes a character and randomizes them.
    RandomizeCharacter(); } //constructor

    public void RandomizeCharacter(){
        stats[level] = 1; //makes the character level 1
        stats[attack] = rand.nextInt(7)+1;
        stats[def] = rand.nextInt(5);
        stats[hpMax] = rand.nextInt(10)+2;
        stats[luck] = rand.nextInt(7);
        stats[manaMax] = rand.nextInt(12)+3;
        stats[hp] = stats[hpMax];
        stats[mana] = stats[manaMax]; } //Randomizes all stats.

    public void LevelUp(){ //class used to level up.
        int r = 0; // int used to dictate how much a stat is leveled.
        double f = 0; // int upgrade variable
        int i = 0; // int used for index.
        stats[level]++; //levels up the character

        f = rand.nextInt(9)+1; //rolls for a random number (0-9)
        f = f/10; //makes f a decimal.
        r = (int) Math.floor((rand.nextInt(9)+1)*f); //decides how much that stat gets upgraded.
        System.out.println("Your attack has been increased by " + r + "!");
        stats[0] += r;

        f = rand.nextInt(9)+1; //rolls for a random number (0-9)
        f = f/10; //makes f a decimal.
        r = (int) Math.floor((rand.nextInt(9)+1)*f); //decides how much that stat gets upgraded.
        System.out.println("Your defence has been increased by " + r + "!");
        stats[1] += r;

        f = rand.nextInt(9)+1; //rolls for a random number (0-9)
        f = f/10; //makes f a decimal.
        r = (int) Math.floor((rand.nextInt(9)+1)*f); //decides how much that stat gets upgraded.
        System.out.println("Your max hp has been increased by " + r + "!");
        stats[2] += r;

        f = rand.nextInt(9)+1; //rolls for a random number (0-9)
        f = f/10; //makes f a decimal.
        r = (int) Math.floor((rand.nextInt(9)+1)*f); //decides how much that stat gets upgraded.
        System.out.println("Your max mana has been increased by " + r +"!");
        stats[3] += r;

        f = rand.nextInt(9)+1; //rolls for a random number (0-9)
        f = f/10; //makes f a decimal.
        r = (int) Math.floor((rand.nextInt(9)+1)*f); //decides how much that stat gets upgraded.
        System.out.println("Your luck has been increased by " + r +"!\n");
        stats[4] += r;
        //Prints level up message.

        stats[mana] = stats[manaMax]; //restores mana
        stats[hp] = stats[hpMax]; } //restores hp

    public String toString(){
        String s="";
        s+= name + "'s stats:" + "\n";
        s+= "Level: " + stats[level] + "\n";
        s+= "Attack: " + stats[attack] + "\n";
        s+= "Defence: " + stats[def] + "\n";
        s+= "HP: " + stats[hp] + "\n";
        s+= "Max HP: " + stats[hpMax] + "\n";
        s+= "Mana: " + stats[mana] + "\n";
        s+= "Max Mana: " + stats[manaMax] + "\n";
        s+= "Luck: " + stats[luck] + "\n";
        //Prints all stats.
        return s; }

    public void setName(String n){ this.name = n; } //sets users name
    public String getName(){ return name; } //gets name

    public void setHP(int h){this.stats[hp] = h; } //used to set dmg.
    public int getHP(){return stats[hp]; } //used to get hp (user msg)
    public int getHPMax(){ return stats[hpMax]; } //used to get hp (user msg)

    public int getMana(){return stats[mana];} //gets user mana. (user msg)
    public int getManaMax(){return stats[manaMax];} //gets max mana to make sure user cant gain more mana then they can hold
    public int getDef(){return stats[def];} //gets defence for damage mitigation
    public int getLevel(){ return stats[level];} //gets level for enemy scaling

    public String gameOver(){
        String s = "";
        s+= name + " died!" + "\n \n";
        s+= toString() + "\n";
        return s; }

    public void RegenMana(){ //adds 1 mana if needed
        if(stats[mana] < stats[manaMax]){ stats[mana]++; } }

        //CHARACTER SKILLS

    public void Heal(){
        int hpGained = 0; //stores hp gained
        hpGained = rand.nextInt(11); //finds a random number 0-10
        if(stats[mana] > 0){ //makes sure the user can actually cast the spell
        if((hpGained + stats[hp]) < stats[hpMax]){ //makes sure the hp healed doesnt exceed max.
        if(hpGained == 0){ System.out.println(name + " failed to cast heal!"); } //if random number is zero, does nothing.
        else{ System.out.println(name + " healed for " + hpGained + " HP!");
        stats[hp] = stats[hp] + hpGained; } } //puts mana gained into mana stat.
        else{ System.out.println(name + "'s HP was fully restored!");
        stats[hp] = stats[hpMax]; } //hp is filled fully if above max.
        stats[mana] = stats[mana] - 1; } //COSTS 1 MANA TO CAST
        else{ System.out.println(name + " did not have enough mana to cast heal!"); } }

    public void Meditate(){
        int manaGained = 0; //stores mana gained
        manaGained = rand.nextInt(11); //finds a random number 0-10
        if((manaGained + stats[mana]) < stats[manaMax]){ //makes sure the mana gained cannot excede max mana.
        if(manaGained == 0){ System.out.println( name + " failed to cast meditate!"); } //if random number is zero, does nothing.
        else{ System.out.println(name + " meditated for " + manaGained + " mana!");
        stats[mana] = stats[mana] + manaGained; } } //puts mana gained into mana stat.
        else{ System.out.println(name + " restored their mana to max!");
        stats[mana] = stats[manaMax]; } //mana is filled fully if above max.
    }

    public int Strike(){
        int dmg = 0; //stores dmg dealt.
        dmg = (int) Math.ceil((stats[attack]*.45)); //rounds up and casts as int. (only deals 55%)
        System.out.println(name + " used Strike!");
        //takes 45% of the users attack and returns that.
        return dmg; }

    public int BlindSwing(){
        int dmg = 0; //stores dmg dealt.
        int r = 0; //dictates if the move hits.
        r = rand.nextInt(2); //Generates a 1 or a zero.

        if(stats[mana] > 1) {
        if (r == 1){ dmg = (int) Math.ceil((stats[attack]*1.45)); //uses the random number to dictate if it hit
        System.out.println(name + " used Blind Swing!"); }
        else { System.out.println(name+"'s Blind Swing missed!"); } //if r isnt 1 then the atk misses.
        stats[mana] = stats[mana] - 2; } //COSTS 2 MANA TO CAST.
        else{ System.out.println(name + " did not have enough mana to use Blind Swing!"); }
        return dmg; }

    public int LuckyStrike(){
        int dmg=0; //stores dmg dealt.
        int r = 0; //dictates if the move hits.
        r = rand.nextInt(3); //generates a 0, 1 or 2.
        if(stats[mana] > 1){ //if r is 1 then the strike misses.
        if(r == 1){ System.out.println(name+ "'s Lucky Strike missed!"); }
        else{ dmg = stats[luck]*2;
        System.out.println(name + " used Lucky Strike!"); }//if r is 0 or 2 it hits.
        stats[mana] = stats[mana] - 2; } //COSTS 2 MANA TO CAST.
        else { System.out.println(name + " did not have enough mana to use Lucky Strike!"); }
        return dmg; }

    public int HealthSpike(){
        int dmg = 0; //stores dmg dealt.
        if(stats[mana] > 2){ //makes sure user has enough mana to cast.
        if(stats[hp] == 1){ //if the user has one hp they die.
        stats[hp] = 0;
        System.out.println(name + " died attempting to cast Health Spike!"); }
        else{ stats[hp] = stats[hp]/2; //Halves the users hp.
        dmg = (int)Math.round(stats[hp]*(1.63)); //Times the remaining half by 1.63 and adds to dmg.
        System.out.println(name + " used Health Spike!");
        stats[mana] = stats[mana] - 3; } } //COSTS 3 MANA TO CAST.
        else{ System.out.println(name + " did not have enough mana to use Health Spike!"); }
        return dmg; }

    public int DoubleEdge(){
        int dmg = 0; //stores dmg dealt.
        if(stats[mana] > 1){ //makes sure user has enough mana to cast.
        dmg = ((int)Math.floor(stats[attack]*1.45)); //adds 1.45 * attack stat to dmg.
        if(stats[hp] == 1){ //makes sure the user dies if at 1 hp
        System.out.println(name + " died from Double Edge!");
        stats[hp] = 0;
        dmg = 0; }
        else{
        stats[hp] = stats[hp] - ((int)Math.ceil((stats[hp]*.40))); //takes 40% of the users hp.
        System.out.println(name + " used Double Edge!");
        stats[mana] = stats[mana] - 2; } } //COSTS 2 MANA TO CAST.
        else{ System.out.println(name +" did not have enough mana to use Double Edge!"); }
        return dmg; }

    public int DefensiveStrike(){
        int dmg = 0; //stores dmg dealt
        int r = 0; //stores def gained
        r= rand.nextInt(1);

        if(stats[mana] > 2){ //makes sure user has enough mana to cast.
        dmg = (int)Math.ceil(stats[def]*.45); //adds 45% of defense to dmg.
        stats[def]+=r; //increases defence stat by r
        System.out.println(name + " used Defensive Strike!");
        System.out.println(name + " gained " + r + " defence from Defensive Strike!");
        stats[mana] = stats[mana] - 3; } //COSTS 3 MANA TO CAST.
        else{ System.out.println(name+" did not have enough mana to use Defensive Strike!"); }
        return dmg; }

    public void Defend(){
        int r = 0; //dictates if the move hits.
        int d = 0; //saves a random number.
        r = rand.nextInt(3); //generates a number 0-3 (25% chance to fail)
        d = rand.nextInt(2); //generates 1-2 to gain in def

        if(stats[mana] > 2){ //makes sure they have enough mana to cast.
        if(r == 2){ //this is the 25% chance to fail.
        System.out.println(name + " failed to defend!"); }
        else{ stats[def] = stats[def] + d;
        System.out.println(name + " defended and gained " + d + " defence!"); }
        stats[mana] = stats[mana] - 3; } //COSTS 3 MANA TO CAST.
        else{ System.out.println(name+" did not have enough mana to defend!"); } } }