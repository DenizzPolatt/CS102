public class IntegerArray implements Comparable<IntegerArray> {
    
    //instance data members
    String digits = "";
    int[] integerArray;
    
    // IntegerArray integerArray = new IntegerArray(digits);

    //Constructor
    /**
     * Constructor takes a String input and creates an int array with the numeric chars.
     * @param digits
     */
    public IntegerArray(String digits)
    {
        this.digits = digits;

        if(digits.charAt(0) == '0') digits.replaceFirst("^0+(?!$)", ""); //deletes all the 0 chars at the beginning until a different char is detected.

        this.integerArray = new int[digits.length()]; //creates an int array with the length of the string input

        for(int i = 0; i < digits.length() - 1; i++)
        {
            integerArray[i] = Integer.parseInt(digits.substring(i, i + 1)); //fills the elements of the int array with the chars of the string
        }
    }

    /**
     * This method gives the number of digits of the given number
     * @return the length of the string 
     */
    public int numberOfDigits()
    {
        return this.integerArray.length;
    }

    /**
     * Gives the most important digit of a number (left most digit)
     * @return the first digit
     */
    public int MID()
    {
        return this.integerArray[0]; 
    }

    /**
     * Gives the least important digit of a number (right most digit)
     * @return the last digit
     */
    public int LID()
    {
        return this.integerArray[this.numberOfDigits() - 1];
    }
    
    /**
     * Returns the digit at the given index
     * @param index
     * @return the digit at the index
     */
    public int getDigit(int index)
    {
        return this.integerArray[index];
    }

    //last element of the array is erased
    public void reduceArray()
    {
        int[] reducedArray = new int[this.integerArray.length - 1];

        for(int i = 0; i < reducedArray.length; i++)
        {
            reducedArray[i] = integerArray[i];
        }

        this.integerArray = reducedArray;
    }

    public IntegerArray add(IntegerArray other)
    {
        IntegerArray addedArray;
        int[] newIntArray;

        if(this.numberOfDigits() > other.numberOfDigits())
        {
            newIntArray = new int[this.numberOfDigits() + 1];

            String str = "";
            for(int i = 0; i < (this.numberOfDigits() - other.numberOfDigits()); i++)
            {
                str += '0';
            }
            other.digits = str + other.digits;

            int carry = 0;
            for(int i = this.numberOfDigits()-1; i >= 0; i--)
            {
                int sumOfDigits = this.digits.charAt(i) - '0' + other.digits.charAt(i) - '0';

                newIntArray[newIntArray.length - 1 - i] = sumOfDigits % 10 + carry;
                carry = sumOfDigits / 10;
            }

            String stringArray = "";
            for(int i = newIntArray.length - 1; i > 0; i--)
            {
                stringArray += newIntArray[i];
            }
            if(newIntArray[0] != 0) stringArray += newIntArray[0];
            addedArray = new IntegerArray(stringArray);
        } 
    
        else
        {
            newIntArray = new int[this.numberOfDigits() + 1];
            String str = "";
            for(int i = 0; i < (other.numberOfDigits() - this.numberOfDigits()); i++)
            {
                str += '0';
            }
            this.digits = str + this.digits;

            int carry = 0;
            for(int i = other.numberOfDigits() - 1; i >= 0; i--)
            {
                int sumOfDigits = this.digits.charAt(i) - '0' + other.digits.charAt(i) - '0';

                newIntArray[newIntArray.length - 1 - i] = sumOfDigits%10 + carry;
                carry = sumOfDigits/10;
            }

            String stringArray = "";
            for(int i = newIntArray.length - 1; i > 0; i--)
            {
                stringArray += newIntArray[i];
            }
            if(newIntArray[0] != 0) stringArray += newIntArray[0];
            addedArray = new IntegerArray(stringArray);
        }
        return addedArray;
    }

    public IntegerArray subtract(IntegerArray other)
    {
        IntegerArray subtractedArray;
        int[] newIntArray;

        if(this.numberOfDigits() > other.numberOfDigits())
        {
            newIntArray = new int[this.numberOfDigits()];

            String str = "";
            for(int i = 0; i < (this.numberOfDigits() - other.numberOfDigits()); i++)
            {
                str += '0';
            }
            other.digits = str + other.digits;

            for(int i = this.numberOfDigits() - 1; i >= 0; i--)
            {
                int subtractionOfDigits = (this.digits.charAt(i) - '0') - (other.digits.charAt(i) - '0');

                int carry = 0;
                if(subtractionOfDigits < 0)
                {
                    newIntArray[newIntArray.length - 1 - i] = subtractionOfDigits + 10 + carry;
                    carry = -1;
                }
                else{
                    newIntArray[newIntArray.length - 1 - i] = subtractionOfDigits % 10 + carry;
                    carry = 0;
                }
                
                
            }

            String stringArray = "";
            for(int i = newIntArray.length - 1; i >= 0; i--)
            {
                stringArray += newIntArray[i];
            }
            if(newIntArray[0] != 0) stringArray += newIntArray[0];

            System.out.println(stringArray);
            subtractedArray = new IntegerArray(stringArray);
        }
        else
        {
            newIntArray = new int[other.numberOfDigits()];

            String str = "";
            for(int i = 0; i < (other.numberOfDigits() - this.numberOfDigits()); i++)
            {
                str += '0';
            }
            this.digits = str + this.digits;

            for(int i = this.numberOfDigits() - 1; i >= 0; i--)
            {
                int subtractionOfDigits = (other.digits.charAt(i) - '0') - (this.digits.charAt(i) - '0');

                int carry = 0;
                if(subtractionOfDigits < 0)
                {
                    newIntArray[newIntArray.length - 1 - i] = subtractionOfDigits + 10 + carry;
                    carry = -1;
                }
                else{
                    newIntArray[newIntArray.length - 1 - i] = subtractionOfDigits % 10 + carry;
                    carry = 0;
                }
            }

            String stringArray = "";
            for(int i = newIntArray.length - 1; i >= 0; i--)
            {
                stringArray += newIntArray[i];
            }
            if(newIntArray[0] != 0) stringArray += newIntArray[0];

            subtractedArray = new IntegerArray(stringArray);
        }

        return subtractedArray;
    }

    @Override
    public int compareTo(IntegerArray other) {
        if(this.numberOfDigits() > other.numberOfDigits()) return 1;
        else if(this.numberOfDigits() < other.numberOfDigits()) return -1;
        else if(this.numberOfDigits() == other.numberOfDigits() && this.getDigit(0) > other.getDigit(0)) return 1;
        else if(this.numberOfDigits() == other.numberOfDigits() && this.getDigit(0) < other.getDigit(0)) return -1;
        return 0;
    }

    public String toString()
    {
        return digits;
    }
}
