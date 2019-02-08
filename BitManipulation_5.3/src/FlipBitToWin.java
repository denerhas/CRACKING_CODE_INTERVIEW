public class FlipBitToWin {

    public static void main(String[] args)
    {
        System.out.println(findLongestSequence(0b11011101111));
    }

    static int findLongestSequence(int n)
    {
        int currentOnesCount = 0;
        int previousOnesCount = 0;
        int maxOnesSequenceCount = 0;

        while(n > 0)
        {
            if((n & 1) == 1)
            {
                currentOnesCount++;
            }
            else
            {
                if(!((n & 2) == 0))
                {
                    previousOnesCount = currentOnesCount; }
                else
                {
                    previousOnesCount = 0;
                }

                currentOnesCount = 0;
            }

            n = n >> 1;

            if((currentOnesCount + previousOnesCount) > maxOnesSequenceCount)
                maxOnesSequenceCount = (currentOnesCount + previousOnesCount);
        }

        return maxOnesSequenceCount;
    }
}
