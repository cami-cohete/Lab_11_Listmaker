import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static ArrayList<String>list = new ArrayList<>();

    public static void main(String[] args)
    {
        boolean done = false;
        final String menu = "A - Add, D - Delete, P - Print, & Q - Quit";
        String cmd = "";
        Scanner in = new Scanner(System.in);

	    do {
            // display list
            displayList();
            
            // display menu
            // get menu choice
            cmd = SafeInputCopy.getRegExString(in,menu,"[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            // execute the choice
            switch (cmd)
            {
                case "A":
                    // Prompt user for list item
                    // Use your getRangedInt method to get the item number to delete, etc.
                    // make sure it is not an empty string
                    // add it to the list
                    break;
                case "D":
                    // prompt user for the number of the item to delete
                    // Use your getRangedInt method to get the item number to delete, etc.
                    // Translate the number to an index by subtracting one
                    // remove the item from the list
                    break;
                case "P":
                    displayList();
                    break;
                case "Q":
                    // prompt user if they are sure they want to quit
                    // Use your getYNConfirm method for the quit prompt etc.
                    System.exit(0);
                    break;
            }
            System.out.println("cmd is " + cmd);

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
                    System.out.printf("%3d%35s", x + 1, list.get(x));
                }
            }
            else
            {
                System.out.println("***        List is empty        ***");
            }
        System.out.println("***********************************");
    }
}
