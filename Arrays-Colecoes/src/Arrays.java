public class Arrays {
    public static void main(String[] args) {
        Integer[] array = new Integer[] {2, 6, 9, 1, 14};

        //preenchendo array de uma outra forma:
//        Integer[] array = new Integer[5];
//        array[0] = 2;
//        array[1] = 6;
//        array[2] = 9;
//        array[3] = 1;
//        array[4] = 14;

        System.out.println(array[1]);
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
