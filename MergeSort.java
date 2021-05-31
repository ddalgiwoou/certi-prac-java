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
		
		int mid = (left + right) / 2;	// 절반 위치 
		
		sort(arr, left, mid);		// 절반 중 왼쪽 부분리스트(left ~ mid)
		sort(arr, mid + 1, right);	// 절반 중 오른쪽 부분리스트(mid+1 ~ right)
		
		merge(arr, left, mid, right);		// 병합작업
    	
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

        while (l <= mid) temp[idx++] = arr[l++];
        while (r <= right) temp[idx++] = arr[r++];
        
        for (int i = left; i <= right; i++) 
        {
            arr[i] = temp[i];
        }
    }
}
