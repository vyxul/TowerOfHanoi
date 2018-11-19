public class TowerOfHanoi {
    public static void main(String args[]){
        System.out.println("Tower of Hanoi");
        //doing a 2 digit number will mess up formatting of display but
        //should still function correctly
        final int disks = 7;
        int A[] = new int[disks];
        int B[] = new int[disks];
        int C[] = new int[disks];
        int diskSize = disks;

        //starts off stack A with correct order of disks
        for (int i = 0; i < A.length; i++, diskSize--)
            A[i] = diskSize;

        //print the beginning
        printStacks(A, B, C);
        move(disks, A, B, C);
        //print the end
        printStacks(A, B, C);

    }

    //method to get the top disk in a stack
    static int top(int array[]) {
        if (array[0] == 0)
            return 0;

        if (array[array.length - 1] != 0)
            return (array.length - 1);

        int top = array.length - 2;
        for (; top >= 0; top--)
            if (array[top] != 0)
                return top;

        return 0;
    }

    //method to find where to place a disk in the stack
    //can't just use top() since it would just overwrite the top
    //of the new stack instead of placing it above the top
    static int place(int array[]) {
        if (array[0] == 0)
            return 0;
        
        else
            return (top(array) + 1);
    }

    //recursive function to move disks to the right stack
    static void move(int n, int start[], int other[], int end[]) {
        if (n == 1) {
            end[place(end)] = start[top(start)];
            start[top(start)] = 0;
        }

        else {
            move(n - 1, start, end, other);
            move(1, start, other, end);
            move(n - 1, other, start, end);
        }
    }

    static void printStacks(int A[], int B[], int C[]) {
        System.out.println();
        System.out.println("------- ------- -------");
        for (int i = A.length - 1; i >= 0; i--)
            System.out.printf("|  %d  | |  %d  | |  %d  |\n", A[i], B[i], C[i]);
        System.out.println("------- ------- -------");
        System.out.println("   A       B       C   ");
        System.out.println();
    }
}
