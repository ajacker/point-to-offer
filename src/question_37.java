/**
 * @author ajacker
 * @date 2019/10/24 18:14
 * @see <a href="数字在排序数组中出现的次数">https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2</a>
 */
public class question_37 {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 8, 8, 8, 8, 9};
//        int[] array = {2,4,5,7,8,9,9,9,11,25,37,45};
        System.out.println(GetNumberOfK(array, 2));
//        System.out.println(BinarySearch(array, 0, array.length, 45));
    }

    /**
     * 连续target的结束点-起始+1就是长度
     *
     * @param array 有序数组
     * @param k     目标数字
     * @return 连续k出现的个数
     */
    static int GetNumberOfK(int[] array, int k) {
        int end = BinarySearch(array, 0, array.length, k, 1);
        int start = BinarySearch(array, 0, array.length, k, -1);
        return end == -1 ? 0 : end - start + 1;
    }

    /**
     * 二分搜索 查找连续target的起始或结束点
     *
     * @param array  有序数组
     * @param start  开始
     * @param end    结束（不包括）
     * @param target 目标数字
     * @param type   1代表结尾，-1代表起始
     * @return 连续target的起始或结束点
     */
    static int BinarySearch(int[] array, int start, int end, int target, int type) {
        if (start < end) {
            int mid = (start + end) / 2;
            if (array[mid] > target) {
                return BinarySearch(array, start, mid, target, type);
            } else if (array[mid] < target) {
                return BinarySearch(array, mid + 1, end, target, type);
            } else {
                if (type == -1) {
                    if (mid + type < 0 || array[mid + type] != target) {
                        return mid;
                    } else {
                        return BinarySearch(array, start, mid, target, type);
                    }
                } else {
                    if (mid + type >= array.length || array[mid + type] != target) {
                        return mid;
                    } else {
                        return BinarySearch(array, mid + 1, end, target, type);
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 因为是排序数组，所以按照顺序查找后，之后在遇到不一样的代表以后再也不会出现k了
     * @param array 有序数组
     * @param k 要查找的数
     * @return k出现的次数
     */
//    static int GetNumberOfK(int [] array , int k) {
//        int count = 0;
//        for (int i : array) {
//            if(i==k){
//                count++;
//            }else if(count!=0){
//                break;
//            }
//        }
//        return count;
//    }


}
