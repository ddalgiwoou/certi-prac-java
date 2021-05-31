class MergeSort
{
	static int[] temp;

	public static void sort(int[] arr) 
	{
		temp = new int[arr.length];
		sort(arr, 0, arr.length - 1);
        temp = null;
    }

    private static void merge_sort(int[] arr, int left, int right) 
    {	
    	if(left == right) return;
		
		int mid = (left + right) / 2;
		
		sort(arr, left, mid);
		sort(arr, mid + 1, right);
		
		merge(arr, left, mid, right);
    	
//        for(int size = left + 1; size <= right; size += size) 
//        {
//			for(int l = left; l <= right - size; l += (2 * size)) 
//			{
//				int low = l;
//				int mid = l + size - 1;
//				int high = Math.min(l + (2 * size) - 1, right);
//				
//				merge(arr, low, mid, high);		// 병합작업
//			}
//		}
    }

    private static void merge(int[] arr, int left, int mid, int right) 
    {
        int idx = left, l = left, r = mid + 1;

        while (l <= mid && r <= right) 
        {
            if (arr[l] <= arr[r]) 
            {
            	temp[idx++] = arr[l++];
            }
            else
            {
            	temp[idx++] = arr[r++];
            }
        }

        while (l <= mid) 	temp[idx++] = arr[l++];
        while (r <= right) 	temp[idx++] = arr[r++];
        
        for (int i = left; i <= right; i++) 
        {
            arr[i] = temp[i];
        }
    }
}
