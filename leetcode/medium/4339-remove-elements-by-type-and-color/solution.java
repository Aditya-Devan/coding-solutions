class Solution {
    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {

        int n = types.length;

        int[] stackType = new int[n];
        int[] stackColor = new int[n];
        int[] stackCount = new int[n];

        int top = -1;

        for (int i = 0; i < n; i++) {

            int type = types[i];
            int color = colors[i];

            if (top >= 0 &&
                stackType[top] == type &&
                stackColor[top] == color) {

                stackCount[top]++;

            } else {

                top++;

                stackType[top] = type;
                stackColor[top] = color;
                stackCount[top] = 1;
            }

            // Check after BOTH push and increment
            if (stackCount[top] == groupSize[type]) {
                top--;
            }
        }

        return top == -1;
    }
}