import util.BaseUtil;

import java.util.Arrays;

public class MergeSortSearch {
    public static void main(String[] args) {
        int[] disorder = BaseUtil.randomIntArray(100, 10);
        System.out.println(Arrays.toString(disorder));
        MergeSortSearch mergeSortTest = new MergeSortSearch();
        mergeSortTest.mergeSort(disorder);
        System.out.println(Arrays.toString(disorder));
    }

    private void mergeSort(int[] disorder) {
        mergeSortInternally(disorder, 0 , disorder.length - 1);
    }

    private void mergeSortInternally(int[] disorder, int start, int end) {
        // 确定终止条件
        if (start >= end) return;
        int middle = start  + (end - start) / 2;
        mergeSortInternally(disorder,start,middle);
        mergeSortInternally(disorder,middle + 1,end);
        merge(disorder, start, middle, end);
    }

    private void merge(int[] disorder, int start, int middle, int end) {
        int s = start;
        int m = middle + 1;
        int l = 0;
        int[] tmp = new int[end - start + 1];
        while (s <= middle && m <= end){
            if (disorder[s] <= disorder[m]){
                tmp[l++] = disorder[s++];
            }else {
                tmp[l++] = disorder[m++];
            }
        }
        int p = s;
        int n = end;
        if (p <= middle){
            n = middle;
        }else {
            p = m;
        }
        while (p <= n){
            tmp[l++] = disorder[p++];
        }
        if (end - start + 1 > 0) System.arraycopy(tmp,0, disorder,start, end - start + 1);
    }
}
