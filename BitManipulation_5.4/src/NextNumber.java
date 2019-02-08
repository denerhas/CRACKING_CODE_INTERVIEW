public class NextNumber {

    public static void main(String[] args) {

        //int nextNum = getNextNumber(0b11011011111100);
        int prevNum = getPreviousNumber(0b10011110000011);
        System.out.println(Integer.toBinaryString(prevNum));
    }

    public static int getNextNumber(int num) {
        int temp = num;
        int numOfZeros = 0;
        int numOfOnes = 0;

        while (num > 0 && ((num & 1) == 0)) {
            numOfZeros++;

            num = num >> 1;
        }

        while ((num & 1) == 1) {
            numOfOnes++;

            num = num >> 1;
        }

        int p = numOfZeros + numOfOnes;
        int mask = (1 << p);
        int ones = (1 << (numOfOnes-2)) - 1;
        mask = mask | ones;
        temp = temp & ((~0) << (p-1));
        temp = temp | mask;

        return temp;
    }

    public static int getPreviousNumber(int num)
    {
        int temp = num;
        int numOfOnes = 0;
        int numOfZeros = 0;

        while((temp & 1) == 1)
        {
            numOfOnes++;
            temp >>= 1;
        }

        while(((temp & 1) == 0) && temp > 0)
        {
            numOfZeros++;
            temp >>= 1;
        }

        int p = numOfOnes + numOfZeros;
        int mask = 1 << p;
        mask = ~mask;

        int zeroMask = 1 << (numOfZeros-1);
        zeroMask = zeroMask - 1;
        zeroMask = ~zeroMask;

        mask = mask & zeroMask;
        num = num & mask;

        return num;
    }
}