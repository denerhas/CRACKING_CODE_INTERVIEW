public class BinaryToString {

    public static void main(String[] args) throws Exception {
        double num = 0.625;

        System.out.println(Print(num));
    }

    public static String Print(double num) throws Exception {
        if(num >= 1 || num <= 0)
            throw new Exception("Number is not between the specified ranges");

        StringBuilder binaryNumber = new StringBuilder();
        binaryNumber.append("0.");

        while(num > 0)
        {
            num = num * 2;

            if(num >= 1)
            {
                binaryNumber.append("1");
                num = num - 1;
            }
            else
            {
                binaryNumber.append("0");
            }
        }

        return binaryNumber.toString();
    }
}
