package MatrixSea;

//Поиск количества островов
public class Main {
    private static final int[][] MATRIX = { //дано "море" в виде двумерного массива - матрицы
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}};

    public static void main(String[] args) {
        int[][] matrix = MATRIX;
        printMatrix(matrix);
        matrix = deleteAdjacentLand(matrix); //удаление прилегающих территорий
        System.out.println("Кол-во островов: " + findIslands(matrix)); //поиск и вывод кол-ва островов
    }

    //поиск количества островов
    public static int findIslands(int[][] matrix) {
        int sum = 0;
        for (int y = 1; y < matrix.length - 1; y++)
            for (int x = 1; x < matrix[y].length - 1; x++)
                if (matrix[y][x] == 1) {
                    matrix = deleteLand(matrix, y, x);
                    sum++;
                }
        return sum;
    } //вывод кол-ва "островов" в матрице (море)

    public static int[][] deleteLand(int[][] matrix, int y, int x) {
        matrix[y][x] = 0;
        try {//на случай выхода за пределы массива при поиске прилегающих земель
            if (matrix[y][x + 1] == 1)
                matrix = deleteLand(matrix, y, x + 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            if (matrix[y][x - 1] == 1)
                matrix = deleteLand(matrix, y, x - 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            if (matrix[y + 1][x] == 1)
                matrix = deleteLand(matrix, y + 1, x);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            if (matrix[y - 1][x] == 1)
                matrix = deleteLand(matrix, y - 1, x);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        return matrix;
    } //удалить "землю" по координатам

    public static int[][] deleteAdjacentLand(int[][] matrix) {
        for (int y = 0; y < matrix.length; y += matrix.length - 1) //обход по верху и низу
            for (int x = 0; x < matrix[y].length; x++)
                if (matrix[y][x] == 1)
                    matrix = deleteLand(matrix, y, x);
        for (int y = 0; y < matrix.length; y++) //обход по левой и правой границе матрицы
            for (int x = 0; x < matrix[y].length; x += matrix[y].length - 1)
                if (matrix[y][x] == 1)
                    matrix = deleteLand(matrix, y, x);
        return matrix;

    } //уборка "земли" прилегающей к суше по границам матрицы (моря)

    public static void printMatrix(int[][] matrix) {
        for (int[] line : matrix) {
            for (int num : line) {
                System.out.printf("%-2d", num);
            }
            System.out.println();
        }
        System.out.println();
    } //печать матрицы (моря)
}
