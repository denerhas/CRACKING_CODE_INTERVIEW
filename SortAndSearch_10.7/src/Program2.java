import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) {
		
	}
	
	public static int findOpenNumber(String fileName) throws FileNotFoundException{
		
		int rangeSize = (1 << 20);
		
		int[] blocks = getCountPerBlock(fileName, rangeSize);
		
		int blockIndex = findBlockWithMissing(blocks, rangeSize);
		if(blockIndex < 0)
			return -1;	
		
		byte[] bitvector = getBitVectorForRange(fileName, blockIndex, rangeSize);
		
		int offset = findZero(bitvector);
		
		if (offset < 0) return -1;
		
		return blockIndex * rangeSize + offset;
	}
	
	static int[] getCountPerBlock(String fileName, int rangeSize) throws FileNotFoundException
	{
		int arraySize = Integer.MAX_VALUE / rangeSize + 1;
		int[] blocks = new int[arraySize];
		
		Scanner in = new Scanner(new FileReader(fileName));
		while(in.hasNext())
		{
			int value = in.nextInt();
			blocks[value / rangeSize]++;
		}
		
		in.close();
		return blocks;
	}
	
	static int findBlockWithMissing(int[] blocks, int rangeSize)
	{
		for(int i = 0; i<blocks.length; i++)
		{
			if(blocks[i] < rangeSize)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	static byte[] getBitVectorForRange(String fileName, int blockIndex, int rangeSize) throws FileNotFoundException
	{
		int startRange = blockIndex * rangeSize;
		int endRange = startRange + rangeSize;
		
		byte[] bitVector = new byte[rangeSize/Byte.SIZE];
		
		Scanner in = new Scanner(new FileReader(fileName));
		while(in.hasNextInt())
		{
			int value = in.nextInt();
			if(startRange <= value && value < endRange)
			{
				int offset = value - startRange;
				int mask = (1 << (offset % Byte.SIZE));
				bitVector[offset/Byte.SIZE] |= mask;
			}
		}
		in.close();
		
		return bitVector;
	}
	
	static int findZero(byte b) {
		for (int i= 0; i < Byte.SIZE; i++) {
			int mask= 1 << i;
			if ((b & mask)== 0) {
				return i;
			}
		}
	return -1;
	}
	static int findZero(byte[] bitVector) {
		for (int i= 0; i < bitVector.length; i++) {
			if (bitVector[i] != -0) {//If not all ls
				int bitindex = findZero(bitVector[i]);
				return i *Byte.SIZE+ bitindex;
			}
		}
		return -1;
	}
}
