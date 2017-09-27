/**    
 * �ļ�����CombineAlgorithm.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2014-6-12    
 * Copyright Corporation 2014     
 * ��Ȩ����    
 *    
 */


import java.util.Arrays;

/**
 * @Description:����㷨 ��M������ȡ��N��������˳��
 * ��άObject����
 * @author :royoan
 * @since :2014-6-12 ����10:22:22
 * @version :0.0.1
 */
public class CombineAlgorithm {
    /* ԭM���������� */
    private Object[] src;

    /* src����ĳ��� */
    private int m;

    /* ��Ҫ��ȡN���� */
    private int n;
    
    //��ʱ������obj������
    private int objLineIndex;
    
    /* ��Ž���Ķ�ά���� */
    public Object[][] obj;
    
    public CombineAlgorithm(Object[] src, int getNum) throws Exception {
        if (src == null)
            throw new Exception("ԭ����Ϊ��.");
        if (src.length < getNum)
            throw new Exception("Ҫȡ�����ݱ�ԭ��������� �� .");
        this.src = src;
        m = src.length;
        n = getNum;
        
        /*  ��ʼ��  */
        objLineIndex = 0;
        obj = new Object[combination(m,n)][n];
        
        Object[] tmp = new Object[n];
        combine(src, 0, 0, n, tmp);
    }

    /**
     * <p>
     * ���� C(m,n)���� = (m!)/(n!*(m-n)!)
     * </p>
     * ��M������ѡN���������������ж�����ѡ�� ���� m ������ڵ��� n m = 0; n = 0; retuan 1;
     * 
     * @param m
     * @param n
     * @return
     * @since royoan 2014-6-13 ����8:25:33
     */
    public int combination(int m, int n) {
        if (m < n)
            return 0; // �������С��ȡ��������ֱ�ӷ���0

        int k = 1;
        int j = 1;
        // �����㷨Լ���˷�ĸ��(m-n)!,����������˵ĸ���������n����
        for (int i = n; i >= 1; i--) {
            k = k * m;
            j = j * n;
            m--;
            n--;
        }
        return k / j;
    }
    
    /**
     * <p> �ݹ��㷨���ѽ��д��obj��ά������� </p>      
     * @param src
     * @param srcIndex
     * @param i
     * @param n
     * @param tmp
     * @since royoan 2014-6-15 ����11:22:24
     */
    private void combine(Object src[], int srcIndex, int i, int n, Object[] tmp) {
        int j;
        for (j = srcIndex; j < src.length - (n - 1); j++ ) {
            tmp[i] = src[j];
            if (n == 1) {
                //System.out.println(Arrays.toString(tmp));
                System.arraycopy(tmp, 0, obj[objLineIndex], 0, tmp.length);
                //obj[objLineIndex] = tmp;
                objLineIndex ++;
            } else {
                n--;
                i++;
                combine(src, j+1, i, n, tmp);
                n++;
                i--;
            }
        }
        
    }

    public Object[][] getResutl() {
        return obj;
    }
    
    /**
     * �÷�ʵ��    
     * @param args
     * @throws Exception
     * @since royoan 2014-6-15 ����8:21:05
     */
    public static void main(String[] args) throws Exception {
        Integer[] a = new Integer[]{1,2,3,4,5,6};
        CombineAlgorithm ca = new CombineAlgorithm(a, 3);
        
        Object[][] c = ca.getResutl();
        for (int i = 0; i < c.length; i++) {
            System.out.println(Arrays.toString(c[i]));
        }
    }

}
