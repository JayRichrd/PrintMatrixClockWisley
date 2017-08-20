package com.jy;

public class Main {

	public static void main(String[] args) {
		// 构造矩阵
		int[][] matrix = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 } };
		// 行数
		int rows = matrix.length;
		// 列数
		int columns = matrix[0].length;
		System.out.println("按照顺序打印出数组：");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++)
				// 对齐输出
				System.out.printf("%-4s", matrix[i][j] + " ");
			System.out.println();
		}
		System.out.println("按照顺时针打印出数组：");
		printMatrixClockWisely(matrix);

	}

	/**
	 * 顺时针打印二维数组
	 * 
	 * @param matrix
	 *            待打印的二维数组
	 */
	public static void printMatrixClockWisely(int[][] matrix) {
		// 行数
		int rows = matrix.length;
		// 列数
		int columns = matrix[0].length;
		if (matrix == null || rows == 0 || columns == 0)
			return;
		// 每一圈都是沿着对角线，从左上角开始顺时针
		int start = 0;
		// 循环遍历没一圈
		while (rows > 2 * start && columns > 2 * start) {
			System.out.print("第" + (start + 1) + "圈：");
			printMatrixCircle(matrix, start, rows, columns);
			System.out.println();
			start++;
		}
	}

	/**
	 * 打印顺时针数组的某一圈
	 * 
	 * @param matrix
	 *            待打印的数组
	 * @param start
	 *            某一圈开始的x、y坐标
	 * @param rows
	 *            待打印数组的行数
	 * @param columns
	 *            待打印数组的列数
	 */
	public static void printMatrixCircle(int[][] matrix, int start, int rows, int columns) {
		// X、Y方向结束的索引
		int endX = columns - start - 1;
		int endY = rows - start - 1;
		// 从左向右打印一行
		for (int i = start; i <= endX; i++)
			System.out.print(matrix[start][i] + " ");
		// 接着从上向下打印一列
		if (start < endY)
			for (int i = start + 1; i <= endY; i++)
				System.out.print(matrix[i][endX] + " ");
		// 接着从右往左打印一行
		if (start < endY && start < endX)
			for (int i = endX - 1; i >= start; i--)
				System.out.print(matrix[endY][i] + " ");
		// 接着从下往上打印一列
		if (start < endX - 1 && start < endY - 1)
			for (int i = endY - 1; i > start; i--)
				System.out.print(matrix[i][start] + " ");

	}

}
