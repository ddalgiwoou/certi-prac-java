

static void permutation(int[] arr, int depth, int total, int count)
{
	if (depth >= count)
	{
		// do something
		for(int i = 0; i < count; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return;
	}

	for (int i = depth; i < total; i++)
	{
		swap(arr, depth, i);
		permutation(arr, depth + 1, total, count);
		swap(arr, depth, i);
	}
}

static void swap(int[] arr, int i, int j)
{
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}
