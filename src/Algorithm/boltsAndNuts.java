package Algorithm;

public class boltsAndNuts {

    static int bolt[];
    static int nut[];
    static int counter;

    public static void main(String[] args) {

        starter();
    }

    public static void starter(){
        bolt = new int[]{6,5,1,3,2,7,4};
        nut = new int[]{7,3,4,1,6,2,5};
        counter = 0;
        printoutArray("Blots", bolt);
        printoutArray("nuts ", nut);
        BoltandNut(bolt, nut, 0 ,6);
        printoutArray("Bolts", bolt);
        printoutArray("nuts ", nut);
    }

    public static void BoltandNut(int[] bolts, int[] nuts, int begin, int end){
        counter = counter + 1;
        System.out.println("This is the " + String.valueOf(counter) + " time invoking BoltandNut");
        if(begin < end){
            int index = pisition(bolts, nuts, begin, end);
            BoltandNut(bolts, nuts, begin, index - 1);
            BoltandNut(bolts, nuts, index + 1, end);
        }

    }

    public static int pisition(int[] Bolts, int[] nuts, int begin, int end){
        int i = begin;
        int j = end;
        int index = 0;
        do{
            while (nuts[i] <= Bolts[begin] && i <= end){
                if(nuts[i] == Bolts[begin]){
                    details(i, j, index);
                    System.out.println("nuts[i]与bolts[begin]相等，交换");
                    printoutArray("(Nuts) Swap before", nuts);
                    swap(nuts, begin, i);
                    printoutArray("(Nuts) Swap after ", nuts);

                }
                i++;
            }
            while (nuts[j] >= Bolts[begin] && j >= begin){
                if(nuts[j] == Bolts[begin]){
                    details(i, j, index);
                    System.out.println("nuts[j]与bolts[begin]相等");
                    printoutArray("(Nuts) Swap before", nuts);
                    swap(nuts, j, end);
                    printoutArray("(Nuts) Swap after ", nuts);
                }
                j--;
                if(j < 0) break;
            }
            if(i <= end && j >= begin){
                details(i, j, index);
                System.out.println("i<=end && j >=begin");
                printoutArray("(Nuts) Swap before", nuts);
                swap(nuts, i, j);
                printoutArray("(Nuts) Swap after ", nuts);
            }
        } while(i <= j);

        if(i > end) i--;
        if(j < begin) j++;
        details(i, j, index);
        System.out.println("???，交换");
        printoutArray("(Nuts) Swap before", nuts);
        swap(nuts, i, j);
        printoutArray("(Nuts) Swap after ", nuts);

        if (Bolts[begin] == nuts[begin])
        {
            index = j;
            details(i, j, index);
            System.out.println("Bolts[begin]与nuts[begin]相等，交换");
            printoutArray("(Nuts) Swap before", nuts);
            swap(nuts,j,begin);
            printoutArray("(Nuts) Swap after ", nuts);
        }
        if (Bolts[begin] == nuts[end])
        {
            index= i;
            details(i, j, index);
            System.out.println("Bolts[begin]与nuts[end]相等，交换");
            printoutArray("(Nuts) Swap before", nuts);
            swap(nuts,end,i);
            printoutArray("(Nuts) Swap after ", nuts);
        }
        i = begin + 1;
        j = end;
        while (i <= j)
        {
            while (i <= end && Bolts[i] < nuts[index]) i++;
            while (j > begin && Bolts[j] > nuts[index]) j--;
            details(i, j, index);
            System.out.println("Bolts[i]>=nuts[index] &&  Bolts[j] <= nuts[index]，交换");
            printoutArray("(Bolts) Swap before", Bolts);
            swap(Bolts, i, j);
            printoutArray("(Bolts) Swap after ", Bolts);
        }
        details(i, j, index);
        System.out.println("i,j交换");
        printoutArray("(Bolts) Swap before", Bolts);
        swap(Bolts,i,j);
        printoutArray("(Bolts) Swap after ", Bolts);
        details(i, j, index);
        System.out.println("j,begin交换");
        printoutArray("(Bolts) Swap before", Bolts);
        swap(Bolts, j, begin);
        printoutArray("(Bolts) Swap after ", Bolts);
        return index;
    }

    public static int[] swap(int[] array, int item1, int item2){
        int t =  array[item2];
        array[item2] = array[item1];
        array[item1] = t;
        return array;
    }

    public static void details(int i, int j, int index){
        System.out.println("i的值为" + String.valueOf(i) + " j的值为" + String.valueOf(j) + " index的值为"+ String.valueOf(index));
    }

    public static void printoutArray(String message, int[] array){
        System.out.print(message + " : [  ");
        for(int i:array){
            System.out.print(String.valueOf(i) + "  ");
        }
        System.out.println("]");
    }


}