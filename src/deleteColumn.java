import java.util.Arrays;


public class deleteColumn {
        static String[] sorted = new String []{"abcdef", "uvwxyz"};
        static String[]  unsorted = new String []{"zyx", "wvu", "tsr"};
        static String[]  alsoUnsorted = new String [] {"cbd", "amn", "kgz"};
        static String[]  error = new String []{"Hello", "Universe"};
        static int [] delIndices = new int[1];
        static final int [] EMPTY = {};
        static int totalChars;

    /**
     * Function checks if all strings in array are same length
      * @param array
     * @return boolean if same length or not
     */
    public boolean checkLength(String [] array){
        totalChars = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length(); j++) {
                totalChars++;
            }
        }if (totalChars % array.length == 0) {
            return true;

        }
        return false;
    }

    /**
     * loops through each character then loop through each element in array
     * check if current character is greater than next character
     * add 1 to index if greater because it is not sorted and therfore is an index to be deleted
     * @param array
     * @return delIndices array indicating which indices can be deleted
     */
    public int [] minDeletionSize(String [] array) {
        int index = 0;
        for (int i = 0; i < array[0].length(); i++) {
            for (int j = 0; j < array.length - 1; j++)
                if (array[j].charAt(i) > array[j + 1].charAt(i)) {
                    delIndices[0] = ++index;
                    break;
                }
        }
        //conditional statements to check for cases when string lengths are not the same
        if(!checkLength(array)) {
            delIndices[0] = -1;
         //checks if columns are already sorted
        }else if(index == 0){
            return EMPTY;
        }
        return delIndices;
    }

    public static void main(String[] args) {
        deleteColumn test = new deleteColumn();
        System.out.println(Arrays.toString(test.minDeletionSize(sorted)));
        System.out.println(Arrays.toString(test.minDeletionSize(alsoUnsorted)));
        System.out.println(Arrays.toString(test.minDeletionSize(unsorted)));
        System.out.println(Arrays.toString(test.minDeletionSize(error)));

    }

    }
