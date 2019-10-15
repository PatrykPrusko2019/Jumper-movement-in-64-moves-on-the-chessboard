public class Jumper {
     private int count;
     private int[] horizontal;
     private int[] vertical;
     private int[][] accessibility;

    public Jumper() {
         this.count = 1;
         this.horizontal = new int[8];
         this.vertical = new int[8];
         this.accessibility = new int[8][8]; // Heuristics of accessibility

         createValueFOrEightJumperMovements();
         fillTheBoardAccessibility();

    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count += count;
    }
    public int[] getHorizontal() {
        return horizontal;
    }

    public int[] getVertical() {
        return vertical;
    }

    public int[][] getAccessibility() {
        return accessibility;
    }

    public void startJumper(Jumper jumper) {

        //eight jumper moves
        EightJumpOfJumper eightJumpOfJumper = new EightJumpOfJumper( jumper );

        eightJumpOfJumper.startJump();

    }

    private void createValueFOrEightJumperMovements() {
        for (int i = 0; i < vertical.length; i++) {//rows
            for (int j = i; j == i ; j++) { //columns
                {
                    switch (i) {
                        case 0: {
                            horizontal[j] = 2;
                            vertical[i] = -1;
                            break;
                        }
                        case 1: {
                            horizontal[j] = 1;
                            vertical[i] = -2;
                            break;
                        }
                        case 2: {
                            horizontal[j] = -1;
                            vertical[i] = -2;
                            break;
                        }
                        case 3: {
                            horizontal[j] = -2;
                            vertical[i] = -1;
                            break;
                        }
                        case 4: {
                            horizontal[j] = -2;
                            vertical[i] = 1;
                            break;
                        }
                        case 5: {
                            horizontal[j] = -1;
                            vertical[i] = 2;
                            break;
                        }
                        case 6: {
                            horizontal[j] = 1;
                            vertical[i] = 2;
                            break;
                        }
                        case 7: {
                            horizontal[j] = 2;
                            vertical[i] = 1;
                            break;
                        }
                    }
                }
            }

        }
    }

    //fill the array difficulty level
    private void fillTheBoardAccessibility() {
        int zero_seven[] = {2, 3 ,4, 4, 4, 4, 3, 2}; // 2 , 3, 4 ,6, 8
        int six_one[] = {3, 4, 6, 6, 6, 6, 4, 3};
        int two_three_four_five[] = {4, 6, 8, 8, 8, 8, 6, 4};
        for(int i = 0; i < accessibility.length; i++) {
            switch (i) {
                case 0: case 7:
                    accessibility[i] = zero_seven;
                    break;

                case 2: case 3: case 4: case 5:
                    accessibility[i] = two_three_four_five;
                    break;
                case 1: case 6:
                    accessibility[i] = six_one;
                    break;
            }
        }
    }


}
