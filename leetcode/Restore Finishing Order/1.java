class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Map<Integer, Void> friendsMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendsMap.put(friends[i], null);
        }

        List result = new ArrayList(friends.length);
        for (int i = 0; i < order.length; i++) {
            if (friendsMap.containsKey(order[i])) {
                result.add(order[i]);
            }
        }

        int[] resultArr = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            resultArr[i] = (int) result.get(i);
        }
        return resultArr;
    }
}