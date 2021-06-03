import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Solution
{
	public static void dfs(int[][] map, boolean[] visited, int v)
	{
		int n = map.length - 1;
		
		visited[v] = true;
		
		System.out.print(v + " ");
		
		for(int i = 1; i <= n; i++)
		{
			if (map[v][i] == 1 && visited[i] != true)
			{
				dfs(map, visited, i);
			}
		}
	}
	
	public static void bfs(int[][] map, boolean[] visited, int v) 
	{
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
		visited[v] = true;
		
		while(q.isEmpty() != true) 
		{
			v = q.poll();
			System.out.print(v + " ");
			
			for (int i = 1; i < map.length; i++) 
			{
				if (map[v][i] == 1 && visited[i] != true)
				{
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		System.setIn(new FileInputStream("src/example01/input.txt"));
		
		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		
//		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] st = sc.nextLine().split(" ");
			int vertexCnt = Integer.parseInt(st[0]);
			int lineCnt = Integer.parseInt(st[1]);
			int startV = Integer.parseInt(st[2]);
			
			int[][] vMap = new int[vertexCnt + 1][vertexCnt + 1];
			boolean[] visited = new boolean[vertexCnt + 1];
			for(int i = 0; i < lineCnt; i++)
			{
				st = sc.nextLine().split(" ");
				
				int v1 = Integer.parseInt(st[0]);
				int v2 = Integer.parseInt(st[1]);
				vMap[v1][v2] = vMap[v2][v1] = 1;
			}
			
			dfs(vMap, visited, startV);
			
			System.out.println();
			
			for(int i = 0; i < visited.length; i++)
			{
				visited[i] = false;
			}
			
			bfs(vMap, visited, startV);
		}	
	}	
}
