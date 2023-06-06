import java.util.LinkedList;

public class Tower {
    private LinkedList<Integer> stack = new LinkedList<>();
    private int[] nums;

    public Tower() {

    }

    public Tower(int[] nums) {
        this.nums = nums;
        
        sortArrayDescending();
        createStack();
    }

    /**
     * Classic insertion sort
     */
    private void sortArrayDescending() {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
 
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    /**
     * Create the stack
     */
    private void createStack() {
        for (int i = 0; i < nums.length; i++) {
            stack.add(nums[i]);
        }

        System.out.println(stack.getFirst());
    }

    public int getTop() {
        return stack.getFirst();
    }

    public int pop() {
        return stack.removeLast();
    }

    public void push(int entry) {
        stack.addLast(entry);
    }

    public boolean isAscending() {
        int i = 0;
        for (int j = 1; j < stack.size(); j++) {
            if (stack.get(i) > stack.get(j)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}