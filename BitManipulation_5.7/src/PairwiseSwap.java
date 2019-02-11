public class PairwiseSwap {

    public static void main(String[] args)
    {

    }

    public static int swapOddEventBits(int x)
    {
        return ((0xAAAAAAAA & x) >>> 1) | ((0x55555555 & x) << 1);
    }
}
