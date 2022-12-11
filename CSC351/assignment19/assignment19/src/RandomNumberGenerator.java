public class RandomNumberGenerator {

    // https://docs.google.com/document/d/1xy6xpgmoiFbkjFQ2A6Q6CK18lKndyRjwyDLpIPV6fLk/edit?usp=sharing
    // essay

    private long multiplier = 75;
    private long increment = 74;
    private long modulus = 65537;
    private int nThSeed = 10;
    private long seed;

    public RandomNumberGenerator(){}

    public RandomNumberGenerator(long multiplier, long increment, long modulus) {
        this.multiplier = multiplier;
        this.increment = increment;
        this.modulus = modulus;
        // constructing seed isn't in here because that is optional
    }

    public Long getRandomNumber() {
        long currentSeed = makeSeed();
        for (int i = 0; i < nThSeed; i++) {
            currentSeed = ((multiplier * currentSeed) + increment) % modulus;
        }
        return currentSeed;
    }

    private Long makeSeed() {
        if (this.seed != 0) {
            return this.seed;
        }
        return (System.nanoTime() - System.currentTimeMillis()) % 1_000;
    }

    public void setnThSeed(int value) {
        nThSeed = value;
    }

    public void setSeed(long value) {
        seed = value;
    }
}
