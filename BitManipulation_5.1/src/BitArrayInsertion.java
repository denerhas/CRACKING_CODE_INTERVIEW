public class BitArrayInsertion {

    public static void main(String[] args)
    {
        int firstNum = 0b10000000000;
        int secondNum = 0b10011;

        System.out.println(Integer.toBinaryString(updateBits(firstNum, secondNum, 2, 6)));
    }

    static int updateBits(int n, int m, int i, int j)
    {
        int allOnes = ~0;
        int left = allOnes << j;
        int right = (1 << i) - 1;
        int mask = left | right;

        n = n & mask;

        int shiftedM = m << i;
        int result = n | shiftedM;
        return result;
    }
}
