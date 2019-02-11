public class Conversion {

    public static void main(String[] args)
    {
        int bitChangeCount = bitSwapRequired(29, 15);
        System.out.println("Bit change count: " + bitChangeCount);
    }

    public static int bitSwapRequiredCustom(int a, int b)
    {
        int numOfBitChange = 0;
        while(a > 0 || b > 0)
        {
            if((a & 1) != (b & 1))
                numOfBitChange++;
            a = a >> 1;
            b = b >> 1;
        }

        return numOfBitChange;
    }

    public static int bitSwapRequired(int a, int b)
    {
        int count = 0;
        for(int c = a ^ b; c != 0; c = c & (c-1))
        {
            count++;
        }

        return count;
    }
}
