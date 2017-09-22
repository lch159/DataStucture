import java.util.*;

public class SortingDoudizhu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] defined = {"RJ", "WJ", "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        final List<String> definedOrder = Arrays.asList(defined);
        while (input.hasNext()) {
            int cardNum = 0;
            String name = input.next();
            switch (name) {
                case "Farmer":
                    cardNum = 17;
                    break;
                case "Dizhu":
                    cardNum = 20;
                    break;
            }
            String[] cards = new String[cardNum];
            for (int i = 0; i < cardNum; i++)
                cards[i] = input.next();

            Map<String, Integer> map = new HashMap<>();
            for (String obj : cards) {
                if (map.containsKey(obj))
                    map.put(obj, map.get(obj) + 1);
                else if (obj.equals("RJ"))
                    map.put(obj, 6);
                else if (obj.equals("WJ"))
                    map.put(obj, 5);
                else
                    map.put(obj, 1);

            }

            Map<String, List> mapList = new HashMap<>();
            for (int i = 1; i <= 6; i++)
                mapList.put(("list" + i), new ArrayList());

            for (Map.Entry<String, Integer> mapping : map.entrySet())
                switch (mapping.getValue()) {
                    case 1:
                        mapList.get("list1").add(mapping.getKey());
                        break;
                    case 2:
                        mapList.get("list2").add(mapping.getKey());
                        break;
                    case 3:
                        mapList.get("list3").add(mapping.getKey());
                        break;
                    case 4:
                        mapList.get("list4").add(mapping.getKey());
                        break;
                    case 5:
                        mapList.get("list5").add("WJ");
                        break;
                    case 6:
                        mapList.get("list6").add("RJ");
                        break;
                }

            for (int i = 6; i >= 1; i--) {
                Collections.sort(mapList.get("list" + i), new Comparator<String>() {
                    public int compare(String o1, String o2) {
                        int io1 = definedOrder.indexOf(o1);
                        int io2 = definedOrder.indexOf(o2);
                        return io1 - io2;
                    }
                });

                for (Object elem : mapList.get("list" + i)) {
                    if (i < 5) {
                        for (int j = 1; j <= i; j++) {
                            if (i == 1 && elem.equals(mapList.get("list" + i).get((mapList.get("list" + i).size() - 1)))) {
                                System.out.println(elem.toString());
                            } else
                                System.out.print(elem.toString() + " ");

                        }
                    } else
                        System.out.print(elem.toString() + " ");
                }
            }
        }
    }
}