
import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {

        ArrayList<Integer> sumOfRows = new ArrayList();

        for (int row = 0; row < square.length; row++) {
            int sum = 0; // sum back to 0 when new entering new row
            for (int col = 0; col < square.length; col++) {
                 sum+= square[row][col];
            }
            sumOfRows.add(sum);
        }

        return sumOfRows;
    }

    public ArrayList<Integer> sumsOfColumns() {

        ArrayList<Integer> sumOfCol = new ArrayList();
        for (int col = 0; col < square.length; col++) {
            int sum = 0; // sum back to 0 when new entering new col
            for (int row = 0; row < square.length; row++) {
                sum += square[row][col];
            }
            sumOfCol.add(sum);
        }

        return sumOfCol;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> sumOfDiags = new ArrayList<>();
        
        int leftSum = 0;
        int rightSum = 0;
        
           // 0,0/0,1/0,2
           // 1,0/1,1/1,2
           // 2,0/2,1/2,2
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                if(i == j){ //e.g 3x3 array:    0,0 / 1,1/ 2,2
                    leftSum +=square[i][j];
                }
                if(i + j == square.length - 1){ // e.g3x3 2,0 = 2 array length is 3-1 = 2;
                    rightSum += square[i][j];
                }
            }
       
            
        }
         sumOfDiags.add(leftSum);
         sumOfDiags.add(rightSum);
        
        
        
        
        return sumOfDiags;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
