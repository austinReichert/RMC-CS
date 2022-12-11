import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomNumberGeneratorTest {
    // some examples on the wikipedia website are considered to have 'bad parameters'!
    // parameters are taken from https://en.wikipedia.org/wiki/Linear_congruential_generator unless indicated otherwise
    // expectedResults were taken from https://asecuritysite.com/random/linear?val=2175143%2C3553%2C10653%2C1000000
    // ^ and python code
    long[] testArray = new long[30];
    long seed = 5;

    @Test
    void ZX81() {
        RandomNumberGenerator r = new RandomNumberGenerator();
        long[] expectedResult = {
                449, 33749, 40843, 48597, 40314, 8922, 13854, 56069, 10881, 29705,
                65228, 42436, 36998, 22370, 39399, 5834, 44402, 53374, 5367, 9377,
                47979, 59501, 6133, 1290, 31287, 52804, 28154, 14440, 34482, 30281
        };
        r.setSeed(seed);
        fillArrayWithNthSeedIteration(testArray, r);
        Assertions.assertArrayEquals(expectedResult, testArray);
    }

    @Test
    void microsoftVisualBasic() {
        RandomNumberGenerator r = new RandomNumberGenerator(1140671485, 12820163, 16777216L);
        long[] expectedResult = {
                11924148, 16619175, 14300878, 5878361, 732088, 1506203, 8574962, 12672749, 15693308, 5778639,
                3478614, 8993217, 3945856, 12910147, 3502074, 15972053, 16387652, 13861879, 7450334, 4688425,
                2417736, 2101739, 6608130, 2336701, 11525004, 6372383, 3876454, 1262481, 13195280, 10213011
        };
        r.setSeed(seed);
        fillArrayWithNthSeedIteration(testArray, r);
        Assertions.assertArrayEquals(expectedResult, testArray);
    }

    @Test
    void MTH$RANDOM() {
        RandomNumberGenerator r = new RandomNumberGenerator(69069, 1, 4294967296L);
        long[] expectedResult = {
                345346, 2377866395L, 1599604512, 3640284321L, 3412259310L, 3597848983L, 1613594860, 3571988733L, 2178382746L, 1718537299,
                1936512376, 3396733209L, 672435718, 2981234895L, 1590857924, 817619189, 1909757234, 2281767691L, 4177657552L, 2136579217,
                608615710, 1633548039, 3033607068L, 2522011629L, 1832579530, 1749344451, 3746882344L, 162197257, 1527635766, 2108128319
        };
        r.setSeed(seed);
        fillArrayWithNthSeedIteration(testArray, r);
        Assertions.assertArrayEquals(expectedResult, testArray);
    }

    @Test
    void RANDU() {
        RandomNumberGenerator r = new RandomNumberGenerator(65539, 0, 2147483648L);
        long[] expectedResult = {
                327695, 1966125, 8847495, 35389845, 132711615, 477761085, 1672161975, 1438154789, 21921903, 73040205,
                240944103, 788302773, 413836063, 1830742365, 817478679, 1313092677, 521247951, 2047071853, 1148748615, 1353746901,
                2078711167, 288544893, 202738039, 767007845, 629921071, 1171423117, 1359249063, 1907653621, 1360163807, 1729518493
        };
        r.setSeed(seed);
        fillArrayWithNthSeedIteration(testArray, r);
        Assertions.assertArrayEquals(expectedResult, testArray);
    }

    @Test
    void borland() {
        long[] expectedResults = {
                113477386, 2099511571, 1417020144, 1773386673, 1386203558, 1424053087, 3899864236L, 1784565661, 1543131522, 2036104171,
                3380953512L, 262653897, 1648728734, 2266048183L, 2209269220L, 4188172341L, 3564331258L, 894648259, 2503449952L, 2318849249L,
                173056150, 3193631503L, 2703811612L, 550486477, 119641458, 2979048603L, 554235416, 776356601, 2172500878L, 2618890343L
        };

        RandomNumberGenerator r = new RandomNumberGenerator(22695477, 1, 4294967296L);
        r.setSeed(seed);
        fillArrayWithNthSeedIteration(testArray, r);
        Assertions.assertArrayEquals(expectedResults, testArray);
    }

    @Test
    void microsoftVisualQuick() {
        long[] expectedResults = {
                3601076, 1880463015, 803157710, 1602335321, 1812736952, 2059860891, 1568135154, 1156669165, 1800435196, 2139106511,
                335156310, 1856059841, 886912384, 3292855875L, 27947002, 2429794005L, 2931494468L, 3465249783L, 796307166, 80710185,
                2967856200L, 2867859947L, 4191802626L, 1848879037, 1699797900, 3710467103L, 285222502, 1250640785, 3911866384L, 2352731795L
        };

        RandomNumberGenerator r = new RandomNumberGenerator(214013, 2531011, 4294967296L);
        r.setSeed(seed);
        fillArrayWithNthSeedIteration(testArray, r);
        Assertions.assertArrayEquals(expectedResults, testArray);
    }

    private void fillArrayWithNthSeedIteration(long[] array, RandomNumberGenerator r) {
        Random rand = new Random(5);
        for (int i = 0; i < array.length; i++) {
            r.setnThSeed(i + 1);
            array[i] = r.getRandomNumber();
            System.out.println(array[i] + " array i");
            System.out.println(rand.nextLong());
        }
    }
}
