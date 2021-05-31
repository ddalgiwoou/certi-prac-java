static void rotate(int[][] arr)
{
	rotate(arr, true);
}

static void rotate(int[][] arr, boolean isLeft)
{
	int[][] temp = new int[arr.length][arr[0].length];

	int xMAX = arr.length;
	int yMax = arr[0].length;

	if (isLeft)
	{
		for (int x = 0; x < xMAX; x++)
		{
			for (int y = 0; y < yMax;  y++)
			{
				temp[yMax - 1 - y][x] = arr[x][y];
			}
		}
	}
	else
	{
		for (int x = 0; x < xMAX; x++)
		{
			for (int y = 0; y < yMax;  y++)
			{
				temp[y][xMAX - 1 - x] = arr[x][y];
			}
		}
	}		

	for (int x = 0; x < xMAX; x++)
	{
		for (int y = 0; y < yMax;  y++)
		{
			arr[x][y] = temp[x][y];
		}
	}
}
