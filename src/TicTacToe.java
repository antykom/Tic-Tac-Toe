import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int xOrO = 1;
        char[][] ticTacToeArray = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ticTacToeArray[i][j] = ' ';
            }
        }

        arrayWrite(ticTacToeArray);

        /** do-while loop - main logic of the game. Game end with player got line or there is no more moves
         */
        do {
            char sign = xOrO % 2 == 1 ? 'X' : 'O';
            System.out.print("Enter the coordinates: ");

            int x = sc.nextInt() - 1;
            int y = Math.abs(sc.nextInt() - 3);

            if (x != (int) x || y != (int) y) {
                System.out.println("You should enter numbers!");
            } else if (x > 2 || x < 0 || y < 0 || y > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (ticTacToeArray[y][x] == 88 || ticTacToeArray[y][x] == 79) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                ticTacToeArray[y][x] = sign;
                xOrO++;
            }
            arrayWrite(ticTacToeArray);


        } while (checkGame(ticTacToeArray));


    }

    /**
     * arrayWrite - prints the game table
     *
     * @param Array - two dimensional char tables with so far X or O
     */
    static void arrayWrite(char[][] Array) {
        System.out.println("---------");
        System.out.println("| " + Array[0][0] + " " + Array[0][1] + " " + Array[0][2] + " |");
        System.out.println("| " + Array[1][0] + " " + Array[1][1] + " " + Array[1][2] + " |");
        System.out.println("| " + Array[2][0] + " " + Array[2][1] + " " + Array[2][2] + " |");
        System.out.println("---------");
    }

    /**
     * @param Array - two dimensional char tables with so far X or O
     * @return - return "false" if one of the players will finish game
     */
    static boolean checkGame(char[][] Array) {
        boolean check = true;
        int sum1 = 0;
        int sum2 = 0;

        int xCount = 0;
        int oCount = 0;
        int emptyCount = 0;
        int xWin = 0;
        int oWin = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum1 += Array[i][j];
                if (Array[i][j] == 88) {
                    xCount = xCount + 1;
                } else if (Array[i][j] == 79) {
                    oCount = oCount + 1;
                } else {
                    emptyCount++;
                }
            }
            if (sum1 == 264) {
                xWin = xWin + 1;

            } else if (sum1 == 237) {
                oWin = oWin + 1;
            }
            sum1 = 0;
        }

        for (int c = 0; c < 3; c++) {
            for (int b = 0; b < 3; b++) {
                sum1 += Array[b][c];
            }
            if (sum1 == 264) {
                xWin = xWin + 1;

            } else if (sum1 == 237) {
                oWin = oWin + 1;
            }
            sum1 = 0;
        }

        for (int d = 0; d < 3; d++) {
            sum1 += Array[d][d];
            sum2 += Array[d][2 - d];
        }

        if (sum1 == 264) {
            xWin = xWin + 1;
        } else if (sum1 == 237) {
            oWin = oWin + 1;
        }

        if (sum2 == 264) {
            xWin = xWin + 1;
        } else if (sum2 == 237) {
            oWin = oWin + 1;
        }

        if (emptyCount == 0) {
            if (xWin == 0 && oWin == 0) {
                System.out.println("Draw");
            } else if (xWin != 0 && oWin == 0) {
                System.out.println("X wins");
            } else if (xWin == 0 && oWin != 0) {
                System.out.println("O wins");
            }
            check = false;
        } else if (emptyCount != 0) {
            if (xWin != 0 && oWin == 0) {
                System.out.println("X wins");
                check = false;
            } else if (xWin == 0 && oWin != 0) {
                System.out.println("O wins");
                check = false;
            }
        }

        return check;
    }
}
