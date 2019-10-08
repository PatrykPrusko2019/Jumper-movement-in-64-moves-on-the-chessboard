public class EightJumpOfJumper {

    private int[] horizontal;
    private int[] vertical;
    private int[][] board;
    private int[][] accessibility;
    private int currentRow, currentColumn; //ustawiamy
    //osiem ruchow skoczka
    private int[] difficultyLevel;
    private int[] movementsOfJumper;
    private int jumpCounter;
    private int counterJumper;

    public EightJumpOfJumper(int jumpCounter) {
        this.jumpCounter = jumpCounter;
        this.horizontal = new int[8];//poziomo
        this.vertical = new int[8];//pionowo
        this.board = new int[8][8];
        this.accessibility = new int[8][8];//poziom trudnosci -> najmniejsza dostepnosc pol heudestyka
        this.currentRow = 0;
        this.currentColumn = 0;
        this.difficultyLevel = new int[8]; // poziom trudnosci numer
        this.movementsOfJumper = new int[8]; //dane ruchy skoczka dostepne
        this.counterJumper = 0;

        createValueFOrEightJumperMovements();

        fillTheBoardAccessibility();
        fillTheBoardsWithZeros();
        fillTheTabWithZeros(difficultyLevel);
        fillTheTabWithZeros(movementsOfJumper);


    }

    public int[] getHorizontal() {
        return horizontal;
    }
    public void setHorizontal(int[] horizontal) {
        this.horizontal = horizontal;
    }
    public int[] getVertical() {
        return vertical;
    }
    public void setVertical(int[] vertical) {
        this.vertical = vertical;
    }
    public int[][] getBoard() {
        return board;
    }
    public void setBoard(int[][] board) {
        this.board = board;
    }
    public int[][] getAccessibility() {
        return accessibility;
    }
    public void setAccessibility(int[][] accessibility) {
        this.accessibility = accessibility;
    }
    public int getCurrentRow() {
        return currentRow;
    }
    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }
    public int getCurrentColumn() {
        return currentColumn;
    }
    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }
    public int[] getDifficultyLevel() {
        return difficultyLevel;
    }
    public void setDifficultyLevel(int[] difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
    public int[] getMovementsOfJumper() {
        return movementsOfJumper;
    }
    public void setMovementsOfJumper(int[] movementsOfJumper) {
        this.movementsOfJumper = movementsOfJumper;
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

    public void nextJumpInArray () {
        int i = 0;
        while(jumpCounter < 65) {
            checkJumperMovements();
            i++;
        }
        System.out.println("\n\n**************\nthe last array :\nmovements found is -> " + i);
        showArray();

        if(i == 64) {
            counterJumper++;
        }

    }


    public void checkJumperMovements() {
        boolean foundAnEmptyField = false, exit = false, searchEmptyField = false;
        int row = 0, column = 0;

        while(! exit) {
            for (int i = 0; i < 8; i++) { // 8 movements
                switch (i) {
                    case 0: {
                        row = currentRow + vertical[i];
                        column = currentColumn + horizontal[i];
                        foundAnEmptyField = calculateResult(row, column);
                        break;
                    }
                    case 1: {
                        row = currentRow + vertical[i];
                        column = currentColumn + horizontal[i];
                        foundAnEmptyField = calculateResult(row, column);
                        break;
                    }
                    case 2: {
                        row = currentRow + vertical[i];
                        column = currentColumn + horizontal[i];
                        foundAnEmptyField = calculateResult(row, column);
                        break;
                    }
                    case 3: {
                        row = currentRow + vertical[i];
                        column = currentColumn + horizontal[i];
                        foundAnEmptyField = calculateResult(row, column);
                        break;
                    }
                    case 4: {
                        row = currentRow + vertical[i];
                        column = currentColumn + horizontal[i];
                        foundAnEmptyField = calculateResult(row, column);
                        break;
                    }
                    case 5: {
                        row = currentRow + vertical[i];
                        column = currentColumn + horizontal[i];
                        foundAnEmptyField = calculateResult(row, column);
                        break;
                    }
                    case 6: {
                        row = currentRow + vertical[i];
                        column = currentColumn + horizontal[i];
                        foundAnEmptyField = calculateResult(row, column);
                        break;
                    }
                    case 7: {
                        row = currentRow + vertical[i];
                        column = currentColumn + horizontal[i];
                        foundAnEmptyField = calculateResult(row, column);
                        break;
                    }

                }
                if(foundAnEmptyField) { //found movement
                    checkDifficultyLevel(i , row, column);
                    searchEmptyField = true;
                }


            }
            if(searchEmptyField) { //jesli sa jakies wolne pola dostepne to rusz sie skoczkiem !!!!
                //gdy zakonczy to znajdz najlepsze pole do ruszenia sie skoczkiem
                int minValue = foundMinValueInTabdifficultyLevel(difficultyLevel); //mamy min wartosc poziomu trudnosci
                for (int j = 0; j < difficultyLevel.length; j++) {
                    if (difficultyLevel[j] == minValue) {
                        int actuallMovements = movementsOfJumper[j];
                        //przypisujemy dany wybrany najlepszy ruch 0 - 7 !!!!!
                        row = currentRow + vertical[actuallMovements]; // dany najlepszy ruch skoczka wybrany ustawiamy
                        column = currentColumn + horizontal[actuallMovements];

                        fillTheTabWithZeros(movementsOfJumper); //zerujemy tablice dwie
                        fillTheTabWithZeros(difficultyLevel);

                        currentRow = row; //zmieniamy pozycje skoczka
                        currentColumn = column;
                        board[currentRow][currentColumn] = ++jumpCounter;
                        exit = true;


                    }
                }
            } else { // jesli nie to zakoncz program
                System.out.println("finish search new movements !!!");
                exit = true;
                jumpCounter = 65;
            }

        }//koniec petli while

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

    //sprawdzamy dany poziom trudnosci
    private void checkDifficultyLevel(int numberMovements,int row, int column) {
        //todo tablica z poziomami, potem przypisac do nowej tablicy
        //static int[][] availableFieldsTab = new int[8][8]; //numer poziom trudnosci, numer ruchu 0-7
        for(int i = 0; i < difficultyLevel.length; i++) {
            if(difficultyLevel[i] == 0) {
                difficultyLevel[i] = accessibility[row][column]; //przypisuje poziom trudnosci
                movementsOfJumper[i] = numberMovements; //dany ruch skoczka wolny
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
        System.out.println("\n**********************");
        for (int[] row : board) {
            for (int column : row) {
                System.out.printf("%4d", column);
            }
            System.out.println();
        }
        System.out.println("**********************\n");
    }


    public void startJump() {
        //dodaje petle dla skoczka
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                currentRow = i;
                currentColumn = j;
                board[currentRow][currentColumn] = jumpCounter; //ustawiamy skoczka w nowym miejscu

                nextJumpInArray();

                fillTheBoardsWithZeros();//zerujemy
                fillTheTabWithZeros(getDifficultyLevel());
                fillTheTabWithZeros(getMovementsOfJumper());
                jumpCounter = 1; //ustawiamy od nowa skoczka
            }
        }
        System.out.println("64 jumper is " + counterJumper);
    }
}
