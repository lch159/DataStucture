import java.util.*;

public class ComputeCombatValuesofSoldiers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();

            Map<Integer, Integer> a = new HashMap<>();
            for (int j = 0; j < n; j++) {
                Integer coefficients = input.nextInt();
                Integer exponents = input.nextInt();
                a.put(exponents, coefficients);
            }

            int m = input.nextInt();
            Map<Integer, Integer> b = new HashMap<>();
            for (int j = 0; j < m; j++) {
                Integer coefficients = input.nextInt();
                Integer exponents = input.nextInt();
                b.put(exponents, coefficients);
            }

            Map<Integer, Integer> result = new HashMap<>();
            for (Map.Entry<Integer, Integer> elem : a.entrySet()) {
                if (b.containsKey(elem.getKey())) {
                    result.put(elem.getKey(), elem.getValue() + b.get(elem.getKey()));
                    b.remove(elem.getKey());
                } else {
                    result.put(elem.getKey(), elem.getValue());
                }
            }
            if (b.size() != 0)
                for (Map.Entry<Integer, Integer> elem : b.entrySet()) {
                    result.put(elem.getKey(), elem.getValue());
                }


            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(result.entrySet());
            Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getKey().compareTo(o2.getKey());
                }
            });

            int index = 1;
            int sum=0;
            for (Map.Entry<Integer, Integer> elem : list) {

                sum+=elem.getValue();
                if (elem.getValue().equals(0)) {
                    continue;
                }

                if (elem.getValue() >= 1 && index > 1) {
                    System.out.print("+");
                } else if (elem.getValue() <= -1) {
                    System.out.print("-");
                }

                if (elem.getKey().equals(0)) {
                    System.out.print(Math.abs(elem.getValue()));
                } else {
                    if (elem.getValue() < -1 || elem.getValue() > 1)
                        System.out.print(Math.abs(elem.getValue()));
                    System.out.print("x");
                    if (!elem.getKey().equals(1))
                        System.out.print("^" + elem.getKey());
                }
                index++;
            }
            if (sum==0)
                System.out.print(0);
            System.out.println();

        }
    }
}