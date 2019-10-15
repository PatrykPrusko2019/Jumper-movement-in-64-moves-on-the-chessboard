public class EightJumpOfJumper {

    private Jumper jumper;
    private int[][] board;
    private int currentRow, currentColumn;
    private int[] difficultyLevel;
    private int[] movementsOfJumper;
    private int jumpCounter;
    private int counterJumper;

    public EightJumpOfJumper(Jumper jumper) {
        this.jumper = jumper;
        this.jumpCounter = 1;
        this.board = new int[8][8];
        this.currentRow = 0;
        this.currentColumn = 0;
        this.difficultyLevel = new int[8];
        this.movementsOfJumper = new int[8]; //jumper moves available
        this.counterJumper = 0;

        fillTheBoardsWithZeros();
        fillTheTabWithZeros(difficultyLevel);
        fillTheTabWithZeros(movementsOfJumper);
    }

    public int[] getDifficultyLevel() {
        return difficultyLevel;
    }

    public int[] getMovementsOfJumper() {
        return movementsOfJumper;
    }
    public void fillTheBoardsWithZeros() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
    }

    public static void fillTheTabWithZeros(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            tab[i] = 0;
        }
    }


    public void nextJumpInArray() {
        int i = 0;
        while(jumpCounter < 65) {
            checkJumperMovements();
            i++;
        }
        System.out.println("\nthe number of jumps found is " + i + " from 64 !!!");
        showArray();

        if(i == 64) {
            counterJumper++;
        }

    }

    public void checkJumperMovements() {
        boolean foundAnEmptyField = false, exit = false, foundEmptyField = false;
        int row = 0, column = 0;

        while(! exit) {
            for (int i = 0; i < 8; i++) { // 8 movements
                switch (i) {
                    case 0: {
                        row = currentRow + jumper.getVertical()[i];
                        column = currentColumn + jumper.getHorizontal()[i];
                        foundAnEmptyField = calculateResult(row, column);
                        break;
                    }
                    case 1: {
                        row = currentRow + jumper.getVertical()[i];
                        column = currentColumn + jumper.getHorizontal()[i];
                        foundAnEmptyField = calculateResult(row, column);
                        break;
                    }
                    case 2: {
                        row = currentRow + jumper.getVertical()[i];
                        column = currentColumn + jumper.getHorizontal()[i];
                        foundAnEmptyField = calculateResult(row, column);
                        break;
                    }
                    case 3: {
                        row = currentRow + jumper.getVertical()[i];
                        column = currentColumn + jumper.getHorizontal()[i];
                        foundAnEmptyField = calculateResult(row, column);
                        break;
                    }
                    case 4: {
                        row = currentRow + jumper.getVertical()[i];
                        column = currentColumn + jumper.getHorizontal()[i];
                        foundAnEmptyField = calculateResult(row, column);
                        break;
                    }
                    case 5: {
                        row = currentRow + jumper.getVertical()[i];
                        column = currentColumn + jumper.getHorizontal()[i];
                        foundAnEmptyField = calculateResult(row, column);
                        break;
                    }
                    case 6: {
                        row = currentRow + jumper.getVertical()[i];
                        column = currentColumn + jumper.getHorizontal()[i];
                        foundAnEmptyField = calculateResult(row, column);
                        break;
                    }
                    case 7: {
                        row = currentRow + jumper.getVertical()[i];
                        column = currentColumn + jumper.getHorizontal()[i];
                        foundAnEmptyField = calculateResult(row, column);
                        break;
                    }

                }
                if(foundAnEmptyField) { //found movement
                    checkDifficultyLevel(i , row, column);
                    foundEmptyField = true;
                }


            }

            exit = searchEmptyField(row, column, foundEmptyField, exit);

        }

    }


     //if there are any free fields available then move the jumper
    // when it finishes, find the best field to move with a jumper
    private boolean searchEmptyField(int row, int column, boolean foundEmptyField, boolean exit) {

        if(foundEmptyField) {
            int minValue = foundMinValueInTabdifficultyLevel(difficultyLevel);
            for (int j = 0; j < difficultyLevel.length; j++) {
                if (difficultyLevel[j] == minValue) {
                    int actuallMovements = movementsOfJumper[j];

                    row = currentRow + jumper.getVertical()[actuallMovements]; // attributes the selected best move to the selected move 0 - 7
                    column = currentColumn + jumper.getHorizontal()[actuallMovements];

                    fillTheTabWithZeros(movementsOfJumper); //resets two arrays
                    fillTheTabWithZeros(difficultyLevel);

                    currentRow = row; //changes the jumper's position
                    currentColumn = column;
                    board[currentRow][currentColumn] = ++jumpCounter;
                    exit = true;


                }
            }
        } else {
            System.out.println("\n**************************************\n" + jumper.getCount() + " <- full jump of the jumper !!!");
            exit = true;
            jumpCounter = 65;
        }
        return exit;
    }


    private int foundMinValueInTabdifficultyLevel(int[] difficultyLevel) {
        int min = difficultyLevel[0];
        for(int i = 0; i < difficultyLevel.length; i++) {
            if(min > difficultyLevel[i] && (! (0 == difficultyLevel[i])) ) {
                min = difficultyLevel[i];
            }
        }
        return min;
    }

    //checks the given difficulty level
    private void checkDifficultyLevel(int numberMovements,int row, int column) {
        for(int i = 0; i < difficultyLevel.length; i++) {
            if(difficultyLevel[i] == 0) {
                difficultyLevel[i] = jumper.getAccessibility()[row][column];
                movementsOfJumper[i] = numberMovements;
                break;
            }
        }


    }

    private boolean calculateResult(int row, int column) {
        if(row >= 0 && row < board.length) {
            if(column >= 0 && column < board.length) {
                if( checkValueBoard(row, column) ) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }



    private boolean checkValueBoard(int row, int column) {
        if(board[row][column] == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void showArray () {
        for (int[] row : board) {
            for (int column : row) {
                System.out.printf("%4d", column);
            }
            System.out.println();
        }
        System.out.println("**************************************\n");
    }


    public void startJump() {
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                currentRow = i;
                currentColumn = j;
                board[currentRow][currentColumn] = jumpCounter; //sets the jumper in a new place

                nextJumpInArray();

                fillTheBoardsWithZeros();
                fillTheTabWithZeros(getDifficultyLevel());
                fillTheTabWithZeros(getMovementsOfJumper());
                jumpCounter = 1; // sets the jumper over again
                jumper.setCount(1);
            }
        }
        System.out.println("\n\n\n64 jumps found -> " + counterJumper + " !!!!!");
    }
}
