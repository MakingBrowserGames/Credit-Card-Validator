package me.chrisp;


public class CreditCard
{
    private String creditCardNumber = "";

    // Make default constructor private so it cannot be used (required to input credit card)
    private CreditCard()
    {
    }

    public CreditCard(String cardNumber)
    {
        // Get rid of spaces and hyphens
        creditCardNumber = cardNumber.replace(" ", "").replace("-", "");
    }

    public CreditCard(long cardNumber)
    {
        // Keep the card number as a string
        creditCardNumber += cardNumber;
    }

    public boolean isValid()
    {
        // Check if between 13 and 16 numbers (inclusive)
        if (creditCardNumber.length() < 13 || creditCardNumber.length() > 16)
        {
            return false;
        }

        // The sum of the numbers that then gets moded by 10
        // The name is slightly redundant because the word "sum" already implies it's the total. Whatever.
        int totalSum = 0;

        // Start at length - 2. Length - 1 is the last number and - 2 is the 2nd to last number.
        // Since this sums every even number from right to left, we start at the 2nd to last number and then
        // decrement by 2 each loop (again, even numbers) until the beginning of the card number is reached
        for (int i = creditCardNumber.length() - 2; i >= 0; i -= 2)
        {
            // Get the current number from the string
            int currentNumber = Character.getNumericValue(creditCardNumber.charAt(i));

            // Check if the character is not actually a number
            if (currentNumber > 9 || currentNumber < 0)
            {
                return false;
            }

            // Multiply the number by two
            currentNumber *= 2;

            // If the doubled number is two digits, add the digits together
            if (currentNumber >= 10)
            {
                // Add them to the sum
                // currentNumber % 10 is the ones place, currentNumber / 10 is the tens place
                totalSum += currentNumber % 10 + currentNumber / 10;
            }
            else
            {
                // Not two digits, just add it to the current total
                totalSum += currentNumber;
            }
        }

        // Start at the last digit (length - 1) and go through every odd number (decrement by 2 each iteration)
        for (int i = creditCardNumber.length() - 1; i >= 0; i -= 2)
        {
            // Get the current number from the string
            int currentNumber = Character.getNumericValue(creditCardNumber.charAt(i));

            // Check if the character is not actually a number
            if (currentNumber > 9 || currentNumber < 0)
            {
                return false;
            }

            // Add the number to the total sum
            totalSum += currentNumber;
        }

        // Return true if divisible by 10
        return totalSum % 10 == 0;
    }
}
