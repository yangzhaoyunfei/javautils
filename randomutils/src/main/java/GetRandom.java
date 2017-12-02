import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * reference http://www.cnblogs.com/tomyLi/p/JAVA-sui-ji-shu-sheng-chengIntLongFloatDouble.html
 * dependencies:
 * java.util.Random;
 * org.apache.commons.math3.random.RandomDataGenerator;
 * 单线程中使用java.util.Random类
 * 多线程中使用java.util.concurrent.ThreadLocalRandom类。
 */


public class GetRandom {
    /*-------------------------------------------------------int---------------------------------------------------------------*/

    /**
     * 生成无边界的Int
     */
    public int unrangIntRandom() {
        return (new Random().nextInt());
    }

    /**
     * 生成有边界的Int
     * [min,max)
     */
    public int rangIntRandom(int min, int max) {
        return (min + ((int) (new Random().nextFloat() * (max - min))));
    }

    /**
     * 使用Apache Common Math来生成有边界的Int
     * [min,max]
     */
    public int rangIntRandom_withApcheMath(int min, int max) {
        return (new RandomDataGenerator().nextInt(min, max));
    }

    /**
     * 使用Apache Common Lang的工具类来生成有边界的Int
     * [min,max)
     */
    public int rangIntRandom_withApacheLangInclusive(int min, int max) {

        return (new RandomUtils().nextInt(max));
    }

    /**
     * 使用TreadLocalRandom来生成有边界的Int
     * [min,max)
     */
   /* public int rangIntRandom_withThreadLocalRandom(int min, int max) {
        return new ThreadLocalRandom().current().nextInt(min, max);
    }*/
    /*--------------------------------------------------------long----------------------------------------------------------------*/

    /**
     * 生成无边界的Long
     */
    public long unrangLongRandom() {
        return new Random().nextLong();
    }

    /**
     * 生成有边界的Long,[min,max)
     */
    public long rangLongRandom(long min, long max) {
        return (min + (((long) (new Random().nextDouble() * (max - min)))));
    }

    /**
     * 使用Apache Commons Math来生成有边界的Long
     */
    public long rangLongRandom_withApacheMath(long min, long max) {
        return (new RandomDataGenerator().nextLong(min, max));
    }

    /**
     * 使用Apache Commons Lang的工具类来生成有边界的Long
     */
   /* public long rangLongRandom_withApacheLangInclusive(long min, long max) {
        return (new RandomUtils().nextLong(min, max));
    }*/

    /**
     * 使用ThreadLocalRandom生成有边界的Long
     */
    public long rangLongRandom_withThreadLocalRandom(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }
    /*--------------------------------------------------------float------------------------------------------------------------*/

    /**
     * 生成有边界的Float随机数
     */
    public float rangFloatRandom(float min, float max) {
        return (min + new Random().nextFloat() * (max - min));
    }

    /**
     * 使用Apache Common Math来生成有边界的Float随机数
     */
   /* public float rangFloatRandom_withApacheMath(float min, float max) {
        float randomFloat = new RandomDataGenerator().getRandomGenerator().nextFloat();
        float generatedFloat = min + randomFloat * (max - min);
        return generatedFloat;
    }*/

    /**
     * 使用Apache Common Lang来生成有边界的Float随机数
     */
   /* public float rangFloatRandom_withApacheLang(float min, float max) {
        return RandomUtils.nextFloat(min, max);
    }*/
    /*----------------------------------------------------------double------------------------------------------------------------*/

    /**
     * 生成带有边界的Double随机数
     */
    public double angDoubleRandom(double min, double max) {
        return (min + new Random().nextDouble() * (max - min));
    }

    /**
     * 使用Apache Common Math来生成有边界的Double随机数
     */
 /*   public double angDoubleRandom_withApacheMath(double min, double max) {
        double boundedDouble = new RandomDataGenerator().getRandomGenerator().nextDouble();
        double generatorDouble = min + boundedDouble * (max - min);
        return generatorDouble;
    }*/

    /**
     * 使用Apache Common Lang生成有边界的Double随机数
     */
/*    public double angDoubleRandom_withApacheLang(double min, double max) {
        return RandomUtils.nextDouble(min, max);
    }*/

    /**
     * 使用ThreadLocalRandom生成有边界的Double随机数
     */
    public double angDoubleRandom_withThreadLocalRandom(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }


}

