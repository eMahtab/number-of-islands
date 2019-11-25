package net.mahtabalam.v1;

public class App {
	public static void main(String[] args) {
		char[][] arr = {
				         {'1', '0', '1'},
				         {'0', '1', '0'},
				         {'1', '0', '1'}
	                  };
		int res = NumberOfIslands.numIslands(arr);
		System.out.println("Islands : "+res);
	}	
}
