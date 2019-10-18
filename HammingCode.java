import java.util.*;

class HammingCode {

	public static void main(String arg[]) {
		// TODO Auto-generated method stub

		// Initialising Scanner variables.
		Scanner keyboard = new Scanner(System.in);

		Scanner input = new Scanner(System.in);

		System.out.println("Which number would you like converted into its binary representation?");
		System.out.println();
		System.out.println("You must press enter after each separate number is entered.");
		System.out.println();

		// Start of conversion into odd = 1 and even = 0 binary.
		int convert[] = new int[7];

		// Taking user's inputs and putting them in an array.
		for (int a = 0; a < 7; a++) {
			convert[a] = keyboard.nextInt();
		}

		String numberarray[] = new String[7];

		System.out.println();
		System.out.println("The binary representation of your number is:");
		System.out.println();
		System.out.println("READ FROM LEFT TO RIGHT");
		System.out.println();

		// Makes the even numbers in the array to 0 and the odd to 1 in a separate
		// array.
		for (int b = 0; b < 7; b++) {
			if (convert[b] % 2 == 0)
				numberarray[b] = "0";
			else
				numberarray[b] = "1";

		}

		// Displays the binary representation.
		for (int i = 0; i < 7; i++) {
			System.out.print(numberarray[i]);
		}

		System.out.println();
		System.out.println("_______________________________________________");
		System.out.println();

		System.out.println("Now enter a 7-bit binary codeword to add parity bits.");
		System.out.println("WRITTEN FROM RIGHT TO LEFT");
		System.out.println();
		System.out.println("You must press enter after each separate bit is entered.");

		System.out.println();

		// Start of hamming code simulator
		int binary[] = new int[7];

		// Getting user inputs and putting them in an array.
		for (int c = 0; c < 7; c++) {
			binary[c] = input.nextInt();
		}

		int paritycreate[] = new int[4];

		// Uses binary XOR operator to check whether the parity bit should be 1 or a 0
		// using even-parity.
		paritycreate[0] = binary[0] ^ binary[1] ^ binary[3] ^ binary[4] ^ binary[6];
		paritycreate[1] = binary[0] ^ binary[2] ^ binary[3] ^ binary[5] ^ binary[6];
		paritycreate[2] = binary[1] ^ binary[2] ^ binary[3];
		paritycreate[3] = binary[4] ^ binary[5] ^ binary[6];

		int finalcode[] = new int[11];

		System.out.println();
		System.out.println("The new codeword with parity bits added is:");

		// Arranges the parity bits with the binary bits in the codeword that the user
		// entered in an array.
		finalcode[0] = paritycreate[0];
		finalcode[1] = paritycreate[1];
		finalcode[2] = binary[0];
		finalcode[3] = paritycreate[2];
		finalcode[4] = binary[1];
		finalcode[5] = binary[2];
		finalcode[6] = binary[3];
		finalcode[7] = paritycreate[3];
		finalcode[8] = binary[4];
		finalcode[9] = binary[5];
		finalcode[10] = binary[6];

		// Uses a for loop to print the new codeword with the parity bits added.
		for (int i = 0; i < 11; i++) {
			System.out.print(finalcode[i]);
		}

		System.out.println();
		System.out.println("READ FROM RIGHT TO LEFT");

		System.out.println();

		System.out.println("Enter the codeword for error detection:");
		System.out.println();
		System.out.println("WRITTEN FROM RIGHT TO LEFT");
		System.out.println();

		int codereceived[] = new int[11];

		for (int i = 0; i < 11; i++) {
			codereceived[i] = input.nextInt();
		}

		int parity[] = new int[4];

		int data[] = new int[7];

		// The codeword for error detection that the user input is being put into the
		// "parity" and "data" bit arrays one by one.
		parity[0] = codereceived[0];
		parity[1] = codereceived[1];
		data[0] = codereceived[2];
		parity[2] = codereceived[3];
		data[1] = codereceived[4];
		data[2] = codereceived[5];
		data[3] = codereceived[6];
		parity[3] = codereceived[7];
		data[4] = codereceived[8];
		data[5] = codereceived[9];
		data[6] = codereceived[10];

		int x[] = new int[4];

		// Uses binary XOR operator to check for an error by getting 1 or 0 to check if
		// it is odd or even. In this case an odd number which would be 1 would indicate
		// that an error has occurred.
		x[0] = parity[0] ^ data[0] ^ data[1] ^ data[3] ^ data[4] ^ data[6];
		x[1] = parity[1] ^ data[0] ^ data[2] ^ data[3] ^ data[5] ^ data[6];
		x[2] = parity[2] ^ data[1] ^ data[2] ^ data[3];
		x[3] = parity[3] ^ data[4] ^ data[5] ^ data[6];

		// Calculates where the location of the error is.
		int binarybit = (x[0] * 1) + (x[1] * 2) + (x[2] * 4) + (x[3] * 8);

		System.out.println();
		if (binarybit == 0) // If it is even then there is no error.
			System.out.println("No error has been found.");
		else {
			System.out.println("The error in the codeword is at bit number " + binarybit + "."); // Prints at what bit
																									// the error is in.
			// Corrects it by changing the bit that is in error from 1 to a 0 or from 0 to a
			// 1.
			if (codereceived[binarybit - 1] == 0)

				codereceived[binarybit - 1] = 1;
			else
				codereceived[binarybit - 1] = 0;
		}

		System.out.println();
		System.out.println("The corrected codeword should be: ");
		System.out.println();

		for (int i = 0; i < 11; i++)
			System.out.print(codereceived[i]);
		System.out.println();
		System.out.println("READ FROM RIGHT TO LEFT");
	}
}
