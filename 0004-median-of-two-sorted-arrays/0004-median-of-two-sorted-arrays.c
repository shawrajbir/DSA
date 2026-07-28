double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    if (nums1Size > nums2Size)
        return findMedianSortedArrays(nums2, nums2Size, nums1, nums1Size);

    int x = nums1Size, y = nums2Size;
    int low = 0, high = x;

    while (low <= high) {
        int partX = (low + high) / 2;
        int partY = (x + y + 1) / 2 - partX;

        int maxLeftX = (partX == 0) ? -1000001 : nums1[partX - 1];
        int minRightX = (partX == x) ? 1000001 : nums1[partX];

        int maxLeftY = (partY == 0) ? -1000001 : nums2[partY - 1];
        int minRightY = (partY == y) ? 1000001 : nums2[partY];

        if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
            if ((x + y) % 2 == 0) {
                int leftMax = (maxLeftX > maxLeftY) ? maxLeftX : maxLeftY;
                int rightMin = (minRightX < minRightY) ? minRightX : minRightY;
                return (leftMax + rightMin) / 2.0;
            } else {
                return (maxLeftX > maxLeftY) ? maxLeftX : maxLeftY;
            }
        } else if (maxLeftX > minRightY) {
            high = partX - 1;
        } else {
            low = partX + 1;
        }
    }

    return 0.0;

}