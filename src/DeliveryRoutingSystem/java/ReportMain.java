package DeliveryRoutingSystem.java;

public class ReportMain {
    public static void main(String[] args) {
        OrderList<String> orderList = new OrderList<>();
        orderList.add("AA");
        orderList.add("BB");
        orderList.add("CC");

        System.out.println("Orders:");
        for (String order : orderList) {
            System.out.println(order);
        }

        String remOrder = orderList.remove(1);
        System.out.println("Removed Order: " + remOrder);

        System.out.println("Updated Order:");
        for (String order : orderList) {
            System.out.println(order);
        }

        DeliveryRoute<String> delRoute = new DeliveryRoute<>();
        delRoute.add("thane");
        delRoute.add("pune");
        delRoute.add("mumbai");

        System.out.println("Delivery Route:");
        for (String location : delRoute) {
            System.out.println(location);
        }

        String remLocation = delRoute.remove(1);
        System.out.println("Rem Location: " + remLocation);

        System.out.println("Updated Deli Route:");
        for (String location : delRoute) {
            System.out.println(location);
        }

        // LRU Cache 
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "manju");
        cache.put(2, "rani");
        cache.put(3, "nishu");

        System.out.println("Cache:");
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));

        cache.put(4, "Manisha"); // remove 1

        System.out.println("After removing:");
        System.out.println(cache.get(1)); // null
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
