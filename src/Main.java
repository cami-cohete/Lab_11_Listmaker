import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static ArrayList<String>list = new ArrayList<>();

    public static void main(String[] args)
    {
        final String menu = "A - Add, D - Delete, P - Print, & Q - Quit";
        String cmd = "";
        Scanner in = new Scanner(System.in);
        String userInput = "";
        boolean userAddYN = false;
        boolean userYN = false;
        boolean done = false;
        int numToDelete = 0;
        int numToAdd = 0;

        // display list
        displayList();
        do {
            // display menu and Get menu choice
            cmd = SafeInputCopy.getRegExString(in,menu,"[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            // execute the choice
            switch (cmd)
            {
                case "A":
                    // Prompt user for list item &  make sure it is not an empty string
                    userInput = SafeInputCopy.getNonZeroLenString(in,"Type the item you wish to add");

                    // Use your getRangedInt method to get the item number to delete, etc. & add it to the list
                    if (list.size() >= 2) {
                        userAddYN = SafeInputCopy.getYNConfirm(in, "Do you want to add the item at a specific index?");
                        if (userAddYN) {
                            numToAdd = SafeInputCopy.getRangedInt(in, "At what index do you want it added at", 1, list.size());
                            numToAdd = numToAdd - 1;
                            list.add(numToAdd, userInput);
                        }
                        else
                        {
                            list.add(userInput);
                        }
                    }
                    else
                    {
                        list.add(userInput);
                    }
                    break;

                case "D":
                    // prompt user for the number of the item to delete & Use your getRangedInt method to get the item number to delete, etc.
                    numToDelete = SafeInputCopy.getRangedInt(in, "Which item do you wish to delete", 1, list.size());

                    // Translate the number to an index by subtracting one
                    numToDelete = numToDelete - 1;

                    // remove the item from the list
                    list.remove(numToDelete);
                    break;

                case "P":
                    // display list
                    displayList();
                    break;

                case "Q":
                    // prompt user if they are sure they want to quit & Use your getYNConfirm method for the quit prompt etc.
                    userYN = SafeInputCopy.getYNConfirm(in,"Are you sure you wish to quit?");
                    if (userYN)
                    {
                        done = true;
                    }
                    break;
            }

         } while (!done);
    }

    // helper methods
    private static void displayList()
    {
        System.out.println("***********************************");
            if (list.size() != 0)
            {
                for (int x = 0; x < list.size(); x++)
                {
                    System.out.printf(" %-3d%-31s\n", x + 1, list.get(x));
                }
            }
            else
            {
                System.out.println("***        List is empty        ***");
            }
        System.out.println("***********************************");
    }
}
