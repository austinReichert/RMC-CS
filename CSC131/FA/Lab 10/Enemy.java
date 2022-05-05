package Lab10;

// Austin Reichert
// 12/6/19
// Collaborators: Tanner Steorts (Tester)

import java.util.Random; //lets me use random

public class Enemy { //makes enemy class

    Random rand = new Random(); //calls random

    private String name = ""; //used for msgs
    private static String[] names = {"Kevin","Cryptpaw","Shadepest","Hauntsoul","Cloud-Crackle","Rotwing","Moldtaur","Shadevine","Spiteling","Mornflayer","Frostpaw","Terrorclaw","Wraith","Blazeling","Rotclaw","Umbrasoul","Goblin"};
    //random names out of 17
    private static final int attack=0;
    private static final int def=1;
    private static final int hpMax=2;
    private static final int manaMax=3;
    private static final int luck=4;
    private static final int mana=5;
    private static final int hp=6;
    //sets their positions in the array.
    private int[] stats; //stats array.
    private int scale; //stores scale number
    private int lvl; //stores lvl scale num.

    public Enemy(){
    stats = new int[7];
    RandomizeEnemy(); } //constructor

    public void RandomizeEnemy(){
        name = names[rand.nextInt(17)];
        stats[attack] = rand.nextInt(7)+1;
        stats[def] = rand.nextInt(5);
        stats[hpMax] = rand.nextInt(15)+1;
        stats[luck] = rand.nextInt(7);
        stats[manaMax] = rand.nextInt(12)+3;
        stats[hp] = stats[hpMax];
        stats[mana] = stats[manaMax]; } //Randomizes all stats.

    public void RandomizeEnemyWithScale(){
        int s = this.scale;
        int l = this.lvl; //characters lvl (scales with lvl)
        int r = 0; //random variable
        double f = 0; //stores decimal

        name = names[rand.nextInt(17)]; //generates random name
        stats[attack] = (rand.nextInt(9)+1); //randomizes initial stat
        r = rand.nextInt(9)+1;
        f = r*.1;
        stats[attack] = stats[attack] + ((int)Math.round((s+l)*f));

        stats[def] = rand.nextInt(5); //randomizes initial stat
        r = rand.nextInt(9);
        f = r*.1;
        stats[def] = stats[def] + ((int)Math.round((s+l)*f));

        stats[hpMax] = rand.nextInt(10)+2; //randomizes initial stat
        r = rand.nextInt(9);
        f = r*.1;
        stats[hpMax] = stats[hpMax] + ((int)Math.round((s+l)*f)); //randomizes initial stat

        stats[luck] = rand.nextInt(7); //randomizes initial stat
        r = rand.nextInt(9);
        f = r*.1;
        stats[luck] = stats[luck] + ((int)Math.round((s+l)*f));

        stats[manaMax] = rand.nextInt(12)+3; //randomizes initial stat
        r = rand.nextInt(9);
        f = r*.1;
        stats[manaMax] = stats[manaMax] + ((int)Math.round((s+l)*f));

        stats[hp] = stats[hpMax];
        stats[mana] = stats[manaMax];
        System.out.println("New enemy is scaled!"); }

    public void RandomizeEnemyWithoutScale(){
        int l = this.lvl; //characters lvl (scales with lvl)
        int r = 0; //random variable
        double f = 0; //stores decimal

        name = names[rand.nextInt(17)]; //generates random name
        stats[attack] = (rand.nextInt(9)+1); //randomizes initial stat
        r = rand.nextInt(9)+1;
        f = r*.1;
        stats[attack] = stats[attack] + ((int)Math.round(l*f));

        stats[def] = rand.nextInt(5); //randomizes initial stat
        r = rand.nextInt(9);
        f = r*.1;
        stats[def] = stats[def] + ((int)Math.round(l*f));

        stats[hpMax] = rand.nextInt(10)+2; //randomizes initial stat
        r = rand.nextInt(9);
        f = r*.1;
        stats[hpMax] = stats[hpMax] + ((int)Math.round(l*f)); //randomizes initial stat

        stats[luck] = rand.nextInt(7); //randomizes initial stat
        r = rand.nextInt(9);
        f = r*.1;
        stats[luck] = stats[luck] + ((int)Math.round(l*f));

        stats[manaMax] = rand.nextInt(12)+3; //randomizes initial stat
        r = rand.nextInt(9);
        f = r*.1;
        stats[manaMax] = stats[manaMax] + ((int)Math.round(l*f));

        //l*f finds a random number under the players lvl, using percentages (f is a random decimal).

        stats[hp] = stats[hpMax];
        stats[mana] = stats[manaMax]; }

    public String toString(){
        String s="";
        s+= "Attack: " + stats[attack] + "\n";
        s+= "Defence: " + stats[def] + "\n";
        s+= "HP: " + stats[hp] + "\n";
        s+= "Max HP: " + stats[hpMax] + "\n";
        s+= "Luck: " + stats[luck] + "\n";
        s+= "Mana: " + stats[mana] + "\n";
        s+= "Max Mana: " + stats[manaMax] + "\n";
        //Prints all stats.
        return s; }

    public void setHP(int h){stats[hp] = h; } //used to alter hp of enemy
    public int getHP(){return stats[hp]; } //used to get hp (user msg)
    public int getHPMax(){ return stats[hpMax];} //used to get hp max (user msg)
    public int getDef(){return stats[def];} //dictates damage mitigated
    public String getName(){ return name; } //gets name

    public void setCharalvl(int l){ this.lvl = l; } //gets the characters current lvl
    public void setScale(int s){ this.scale = s;} //gets the users input for scale.

    public void RegenMana(){ //adds 1 mana if needed
        if(stats[mana] < stats[manaMax]){ stats[mana]++; } }

    //ENEMY SKILLS

    public void Heal(){
        int hpGained = 0; //stores hp gained
        hpGained = rand.nextInt(11); //finds a random number 0-10
        if(stats[mana] > 0){ //makes sure the user can actually cast the spell
            if((hpGained + stats[hp]) < stats[hpMax]){ //makes sure the hp healed doesnt exceed max.
                if(hpGained == 0){ System.out.println(name + " failed to cast heal!"); } //if random number is zero, does nothing.
                else{ System.out.println(name + " healed for " + hpGained + " HP!");
                    stats[hp] = stats[hp] + hpGained; } } //puts mana gained into mana stat.
            else{ System.out.println(name+ "'s HP is restored fully!");
                stats[hp] = stats[hpMax]; } //hp is filled fully if above max.
            stats[mana] = stats[mana] - 1; } //COSTS 1 MANA TO CAST
        else{ System.out.println(name + " doesn't have enough mana to cast heal!"); } }

    public void Meditate(){
        int manaGained = 0; //stores mana gained
        manaGained = rand.nextInt(11); //finds a random number 0-10
        if((manaGained + stats[mana]) < stats[manaMax]){ //makes sure the mana gained cannot excede max mana.
        if(manaGained == 0){ System.out.println(name + " failed to cast meditate!"); } //if random number is zero, does nothing.
        else{ System.out.println(name + " meditated for " + manaGained + " mana!");
        stats[mana] = stats[mana] + manaGained; } } //puts mana gained into mana stat.
        else{ System.out.println(name + "'s mana was restored fully!");
        stats[mana] = stats[manaMax]; } } //mana is filled fully if above max.

    public int Strike(){
        int dmg = 0; //stores dmg dealt.
        dmg = (int) Math.ceil((stats[attack]*.55)); //rounds up and casts as int. (only deals 55%)
        System.out.println(name + " used Strike!");
        return dmg; } //takes 45% of the users attack and returns that.

    public int BlindSwing(){
        int dmg = 0; //stores dmg dealt.
        int r = 0; //dictates if the move hits.
        r = rand.nextInt(2); //Generates a 1 or a zero.

        if(stats[mana] > 1) {
        if (r == 1){ dmg = (int) Math.ceil((stats[attack]*1.45)); //uses the random number to dictate if it hit
        System.out.println(name + " used Blind Swing!"); }
        else { System.out.println(name + "'s Blind Swing missed!"); } //if r isnt 1 then the atk misses.
        stats[mana] = stats[mana] - 2; } //COSTS 2 MANA TO CAST.
        else{ System.out.println(name + " did not have enough mana to use Blind Swing!"); }
        return dmg; }

    public int LuckyStrike(){
        int dmg=0; //stores dmg dealt.
        int r = 0; //dictates if the move hits.
        r = rand.nextInt(3); //generates a 0, 1 or 2.
        if(stats[mana] > 1){ //if r is 1 then the strike misses.
        if(r == 1){ System.out.println(name + "'s Lucky Strike missed!"); }
        else{ dmg = stats[luck]*2;
        System.out.println(name + " used Lucky Strike!"); } //if r is 0 or 2 it hits.
        stats[mana] = stats[mana] - 2; } //COSTS 2 MANA TO CAST.
        else { System.out.println(name + " did not have enough mana to use Lucky Strike!"); }
        return dmg; }

    public int HealthSpike(){
        int dmg = 0; //stores dmg dealt.
        if(stats[mana] > 2){ //makes sure user has enough mana to cast.
        if(stats[hp] == 1){ //if the user has one hp they die.
        stats[hp] = 0;
        System.out.println(name+ " died attempting to cast Health Spike!"); }
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
            if(stats[hp] == 1){ //makes sure the user dies if they are at 1 hp
            System.out.println(name + " died from Double Edge!");
            stats[hp] = 0;
            dmg = 0; }
            else{
            stats[hp] = stats[hp] - ((int)Math.ceil((stats[hp]*.40))); //takes 40% of the users hp.
            System.out.println(name + " used Double Edge!");
            stats[mana] = stats[mana] - 2; } } //COSTS 2 MANA TO CAST.
        else{ System.out.println(name + " did not have enough mana to use Double Edge!"); }
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
        else{ System.out.println(name + " did not have enough mana to use Defensive Strike!"); }
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
        if(d == 0){ System.out.println(name + " defended, but fell!"); }
        else{
        System.out.println(name + " defended and gained " + d + " defence!"); }}
        stats[mana] = stats[mana] - 3; } //COSTS 3 MANA TO CAST.
        else{ System.out.println(name + " did not have enough mana to defend!"); } }

}