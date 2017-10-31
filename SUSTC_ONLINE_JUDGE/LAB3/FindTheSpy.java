package LAB3;

import java.util.LinkedList;
import java.util.Scanner;

public class FindTheSpy {
    public static void main(String[] args)
    {
        Scanner input =new Scanner(System.in);
        int t =input.nextInt();
        for (int i=1;i<=t;i++)
        {
            int n=input.nextInt();
            int k=input.nextInt();
            LinkedList<Integer> list =new LinkedList<>();
            for (int j=0;j<n;j++)
            {
                list.add(j);
            }
            int index=0;
            while(list.size()!=1)
            {
                index+=k-1;
                while (index>=list.size())
                {
                    index=index-list.size();
                }
                if (index+1>=list.size())
                    index=index-list.size();
                list.remove(index+1);
                index++;
            }
            System.out.println(list.get(0));
        }
    }
}
