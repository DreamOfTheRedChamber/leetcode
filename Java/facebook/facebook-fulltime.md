1. 给一个 二叉树 ， 求最深节点的最小公共父节点。 (BST LCA with deepest leaf)

     1
  2   3
     5  6    return 3.

       1  
    2   3
4      5 6   retrun 1. 
先用 recursive  ， 很快写出来了， 要求用 iterative 。 时间不够了
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=199739&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
another link-same question: http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=199548&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

// Recursive way 
'Time complexity: O(n), Space complexity: O(h), height of the tree'
public TreeNode findLCARucrsive(TreeNode root) {
    Pair result = findLCA(root);
    return result.node;
}

private Pair findLCA(TreeNode root) {
    if (root == null) {
        return new Pair(null, 0);
    }
    int depth = 0;
    Pair left = findLCA(root.left);
    Pair right = findLCA(root.right);
    depth = Math.max(left.depth, right.depth) + 1;
    if (left.depth == right.depth) {
        return new Pair(root, depth);
    }
    else if (left.depth > right.depth) {
        return new Pair(left.node, depth);
    }
    else {
        return new Pair(right.node, depth);
    }

}

class Pair {
    public TreeNode node;
    public int depth;
    public Pair(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }

}

// Iterative way
// Use a hashmap to record the parent of every node. Do BFS and record the most left node and most right node of every level. 
// Then we have most left and right node of last level.
// Search into the hashmap util we find the same parent which is the lca.
'Time complexity: O(n), space complexity: O(n)--hashmap has all the node'
public TreeNode findLCAIterative(TreeNode root) {
	if (root == null) {
		return null;
	}
    HashMap<TreeNode, TreeNode> childToParent = new HashMap<>();
    Queue<TreeNode> level = new LinkedList<>();
    TreeNode left = null;
    TreeNode right = null;
    level.offer(root);
    while (!level.isEmpty()) {
        int size = level.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = level.poll();
            if (i == 0) {
                left = node;
            }
            if (i == size - 1) {
                right = node;
            }
            if (node.left != null) {
                level.offer(node.left);
                childToParent.put(node.left, node);
            }
            if (node.right != null) {
                level.offer(node.right);
                childToParent.put(node.right, node);
            }
        }
    }

    while (left != right) {
        left = childToParent.get(left);
        right = childToParent.get(right);
    }
    return left;
}


multiple children
public TreeNodeMulti findLca(TreeNodeMulti root) {
    return helper(root).node;
}

private Result helper(TreeNodeMulti root) {
    if (root == null) {
        return new Result(null, 0);
    }
    int depth = 0;
    List<Result> next = new ArrayList<>();
    for (TreeNodeMulti child : root.children) {
        next.add(helper(child));
    }
    Result deepest = new Result(null, 0);
    Result deepest2 = new Result(null, 0);
    for (Result result : next) {
        if (result.depth >= deepest.depth) {
            deepest2.node = deepest.node;
            deepest2.depth = deepest.depth;
            deepest.node = result.node;
            deepest.depth = result.depth;
        }
    }
    depth = 1 + deepest.depth;
    if (deepest.depth == deepest2.depth) {
        return new Result(root, depth);
    }
    return new Result(deepest.node, depth);
}

class Result {
    TreeNodeMulti node;
    int depth;
    public Result(TreeNodeMulti node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

class TreeNodeMulti {
    public int val;
    public List<TreeNodeMulti> children;
    public TreeNodeMulti(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

}




2. 就是按格式打印json，之前用过json不记得了格式细节了，店面小哥说无所谓，就打印就可以了
http://jsonprettyprint.com/
类似这种的， 输入[1,2,3, {"id": 1, "name": "wang", "tag":[1,"home",2], "price":234}]
要求打出来这个
[  1,  2,  3,  {    "id": 1,    "name": "wang",    "tag": [      1,      "home",      2    ],    "price": 234  }]
因为对格式不熟悉，也没敢用recursive就直接iterative写了，感觉不太好，准备了这么久好多高级算法也学了，题也做了好多，可是需要种新题目
还是蒙。求问大家如何用递归比较好，现在直到｛｝是json object就是key value pair, key是string, value是啥都行（数组，数字，json obj,
 ...）[]是json array里面也啥都可以，如何有效的用递归呢？是遇到[递归还是遇到｛递归呢，目测没发现这两种情况在打印上有区别
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=199846&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

class Json {
    private HashMap<Character, Character> parentheses = new HashMap<>();
    public Json() {
        this.parentheses.put('{', '}');
        this.parentheses.put('[', ']');
    }
    public void parser(String json) {
        json = json.trim();
        if (json.charAt(0) == '{') {
            int index = findParenthese(json, '{');
            System.out.println("{");
            parseHelper(json.substring(1, index), true, "    ");
            System.out.print("}\n");
        }
        else if (json.charAt(0) == '[') {
            int index = findParenthese(json, '[');
            System.out.println("[");
            parseHelper(json.substring(1, index), false, "    ");
            System.out.print("]\n");
        }
        else {
            throw new IllegalArgumentException("Invalid json\n");
        }
    }

    private void parseHelper(String json, boolean isObj, String gap) {
        while (json.length() != 0) {
            json = json.trim();
            System.out.print(gap);

            if (isObj) {
                if (json.charAt(0) != '\"') {
                    throw new IllegalArgumentException("Invalid json.\n");
                }
                //find the attribute's name
                int first = findString(json);
                System.out.print(json.substring(0, first + 1));
                // check if the next char is ":"
                json = json.substring(first + 1).trim();
                if (json.charAt(0) != ':') {
                    throw new IllegalArgumentException("Invalid json.\n");
                }
                System.out.print(":");
                json = json.substring(1).trim();
            }
            // parse the value of the attribute
            int lastIndex = parseElement(json, gap);
            // check after the value if there is a "," or it is the end
            json = json.substring(lastIndex + 1).trim();
            if (json.length() > 0) {
                if (json.charAt(0) != ',') {
                    throw new IllegalArgumentException("Invalid json.\n");
                }
                System.out.print(",");
                json = json.substring(1).trim();
            }
            System.out.print("\n");
        }
    }

    private int parseElement(String element, String gap) {
        int lastIndex = -1;
        switch (element.charAt(0)) {
            case '\"': // if it is a string
                lastIndex = findString(element);
                System.out.print(element.substring(0, lastIndex + 1));
                break;
            case '{': // if it is a json object
                lastIndex = findParenthese(element, '{');
                System.out.print("{\n");
                parseHelper(element.substring(1, lastIndex), true, gap + "    ");
                System.out.print(gap + "}");
                break;
            case '[': // if it is a json array
                lastIndex = findParenthese(element, '[');
                System.out.print("[\n");
                parseHelper(element.substring(1, lastIndex), false, gap + "    ");
                System.out.print(gap + "]");
                break;
            default: //if it is a number
                lastIndex = findNumber(element);
                System.out.print(element.substring(0, lastIndex + 1));
                break;
        }
        return lastIndex;
    }

    private int findParenthese(String str, char parenthese) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == parenthese) {
                count++;
            }
            else if (str.charAt(i) == parentheses.get(parenthese)) {
                count--;
            }
            if (count < 0) {
                throw new IllegalArgumentException("Invalid Json\n");
            }
            else if (count == 0) {
                return i;
            }
        }
        if (count != 0) {
            throw new IllegalArgumentException("Invalid Json\n");
        }
        return str.length() - 1;
    }

    private int findString(String element) {
        for (int i = 1; i < element.length(); i++) {
            if (element.charAt(i) == '\"') {
                return i;
            }
        }
        return -1;
    }

    private int findNumber(String element) {
        for (int i = 0; i < element.length(); i++) {
            if (!Character.isDigit(element.charAt(i))) {
                return i - 1;
            }
        }
        return element.length() - 1;
    }
}


3. 第一题: flatten nested list (e.g. [1,2,[3,4[5]]])
第二题: binary tree level order traversal
第三题: 给三个funtions: is_low(), is_mid(), is_high(). 让给一个数组排序, low的放在最前面, mid的放在中间, high的放在最后面.
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=173888&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
'flatten'
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> content;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.content = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            this.content.push(nestedList.get(i));
        } 
    }

    @Override
    public Integer next() {
        return content.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!content.isEmpty()) {
            NestedInteger curNested = content.peek();
            if (curNested.isInteger()) {
                return true;
            }
            content.pop();
            for (int i = curNested.getList().size() - 1; i >= 0; i--) {
                content.push(curNested.getList().get(i));
            }
        }
        return false;
    }
}

no Iterator
'Time complexity: O(n), space complexity: o(n)'
public List<Integer> flatten(List<NestedInteger> nestedList) {
    List<Integer> result = new ArrayList<>();
    if (nestedList == null) {
        return result;
    }
	Stack<NestedInteger> content = new Stack<>();
	for (int i = nestedList.size() - 1; i >= 0; i--) {
		content.push(nestedList.get(i));
	}
	while (!content.isEmpty()) {
		NestedInteger curNested = content.pop();
		if (curNested.isInteger()) {
			result.add(curNested.getInteger());
		}
		else {
			for (int i = curNested.getList().size() - 1; i >= 0; i--) {
				content.push(curNested.getList().get(i));
			}
		}
	}
	return result;

}
class FlattenList {
    public void flattenPrint(ListNodeRecur head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.printf("%d ", head.val);
            if (head.branch != null) {
                flattenPrint(head.branch);
            }
            head = head.next;
        }
    }

    public ListNodeRecur flatten(ListNodeRecur head) {
        if (head == null) {
            return head;
        }
        ListNodeRecur fakeHead = new ListNodeRecur(0);
        helper(head, fakeHead);
        return head;
    }

    private ListNodeRecur helper(ListNodeRecur branch, ListNodeRecur head) {
        head.next = branch;
        ListNodeRecur prev = head;
        while (branch != null) {
            System.out.printf("%d ", branch.val);
            if (branch.branch != null) {
                ListNodeRecur next = branch.next;
                ListNodeRecur tail = helper(branch.branch, branch);
                tail.next = next;
                branch = next;
                prev = tail;
            }
            else {
                prev = prev.next;
                branch = branch.next;
            }
        }
        return prev;
    }
}

class ListNodeRecur {
    public ListNodeRecur next;
    public ListNodeRecur branch;
    public int val;
    public ListNodeRecur(int val) {
        this.val = val;
    }
}


sort color: (is_low, is_mid, is_high)
public void sortColors(int[] nums) {
    int zeroIndex = 0;
    int twoIndex = nums.length - 1;
    int index = 0;
    while (index <= twoIndex && zeroIndex < twoIndex) {
        if (nums[index] == 0) {
            nums[index] = nums[zeroIndex];
            nums[zeroIndex] = 0;
            zeroIndex++;
            index++;
        }
        else if (nums[index] == 2) {
            nums[index] = nums[twoIndex];
            nums[twoIndex] = 2;
            twoIndex--;
        }
        else {
            index++;
        }
    }
}
public void sortKColor(int[] colors, int k) {
    int left = 0;
    int right = colors.length - 1;
    while (k > 0) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, colors[i]);
            max = Math.max(max, colors[i]);
        }
        int index = left;
        int minIndex = left;
        int maxIndex = right;
        while (minIndex < maxIndex && index <= maxIndex) {
            if (colors[index] == min) {
                colors[index] = colors[minIndex];
                colors[minIndex] = min;
                minIndex++;
                index++;
            }
            else if (colors[index] == max) {
                colors[index] = colors[maxIndex];
                colors[maxIndex] = max;
                maxIndex--;
            }
            else {
                index++;
            }
        }
        left = minIndex;
        right = maxIndex;
        k -= 2;
    }
}

public void countingSort(int[] colors) {
    int[] count = new int[3];
    for (int color : colors) {
        count[color]++;
    }
    int[] index = new int[3];
    int total = 0;
    for (int i = 0; i < 3; i++) {
        index[i] = total;
        total += count[i];
    }
    int[] temp = new int[colors.length];
    for (int i = 0; i < colors.length; i++) {
        temp[index[colors[i]]] = colors[i];
        index[colors[i]]++;
    }
    for (int i = 0; i < colors.length; i++) {
        colors[i] = temp[i];
    }
}



4. merge two arrays in-place
例子：
a = [2,4,6,8, _, _, _, _]
b = [1,3,5,7]

Note：_代表空的位置，用以merge。a的actual length与b一样，并且a的空余位置足够放入b。a, b都是sorted array，要求in-place merge两个array。
感受：题目条件明确，简单思路就是从两个数列的尾部（这个例子中对于a是从8开始）比较，哪个更大就放在a的末端。需要注意到当a被遍历完后，要将b剩下的数字照搬到a的前端。
// merge from the tail
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int index = m + n - 1;
    int poi1 = m - 1;
    int poi2 = n - 1;
    while (poi1 >= 0 && poi2 >= 0) {
        if (nums1[poi1] >= nums2[poi2]) {
            nums1[index] = nums1[poi1];
            poi1--;
        }
        else {
            nums1[index] = nums2[poi2];
            poi2--;
        }
        index--;
    }
    while (poi2 >= 0) {
        nums1[index--] = nums2[poi2--];
    }
}

5. balance parentheses in a string
例子：
"(a)()" -> "(a)()"
"((bc)" -> "(bc)"
")))a((" -> "a"
"(a(b)" ->"(ab)" or "a(b)"

Note: balance的意思就是把原来string里unpaired的括号变成paired的形式。如果有多个可能的结果， 比如上述最后一种情况，我们就只需要输出一个对的结果即可，所以这点简化了题目的难度。
感受： 遍历string， 用一个stack存储每个open parenthesis的index，也就是'('的index, 每当遇到closed parenthesis就执行一次pop操作。
注意两种unbalanced的情况：
1. 出现多余的')':
    对应情况就是stack为空，但遇到了一个')'。
2. 出现多余的'(':
    对应情况就是遍历结束，stack未空

解决这两种情况即可。
对于java，我们需要把string转换成char array来做，因为在java中string is immutable.
. 鍥磋鎴戜滑@1point 3 acres
follow-up:.1point3acres缃�
Q：分析复杂度，问怎么不用stack来做？.鏈枃鍘熷垱鑷�1point3acres璁哄潧
A：想了一会儿，感觉用two-pointer可行，一个指头， 一个指尾， 头index找'('， 找到就移动尾index找')'。
面试官虽然没说，但一开始反应有点惊讶，说明他头脑里准备的是另一个解法。这里就请各位大神不吝赐教了，你们的解法是什么
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192179&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

// Use two loop to do this. First loop traverse from left to right, use a counter to count the valid 
// parenthese, meet '(' +1, meet ')' if count > 0 -1, else delete this ')'
// then all the invalid ')' will be deleted
// Second loop traverse from right to left. also use a counter to count valid parenthese
// meet ')' +1....
// Then all the invalid '(' will be deleted.
'Time complexity: O(n), space complexity: O(n)'
class balanceParentheses {
    public String findBalanceParentheses(String input) {
        String result = deleteCloseParenthes(input);
        result = deleteOpenParenthes(result);
        return result;
    }

    private String deleteCloseParenthes(String input) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (char letter : input.toCharArray()) {
            result.append(letter);
            if (letter == '(') {
                count++;
            }
            else if (letter == ')') {
                if (count > 0) {
                    count--;
                }
                else {
                    result.deleteCharAt(result.length() - 1);
                }
            }
        }
        return result.toString();
    }

    private String deleteOpenParenthes(String input) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            char letter = input.charAt(i);
            result.append(letter);
            if (letter == ')') {
                count++;
            }
            else if (letter == '(') {
                if (count > 0) {
                    count--;
                }
                else {
                    result.deleteCharAt(result.length() - 1);
                }
            }
        }
        return result.reverse().toString();
    }
}


#6. nearest k point; 
decode ways, optimize space complexity to O(1)

Nearest Kth
// Use quickSelect to find the kth nearest point to the origin point
'Time complexity: average O(n), worst O(n^2) when always pick the most right one -- the time complexity of quick select'
class NearestKPoint {
    public Point findNearestKthPoint(Point[] points, int k) {
        if (k > points.length || k == 0) {
            throw new IllegalArgumentException("K's value is illegal\n");
        }
        return quickSelect(points, 0, points.length - 1, k - 1);
    }


    private Point quickSelect(Point[] points, int left, int right, int k) {
        Random rand = new Random();
        int pivotIndex = 0;
        if (right != 0) {
            pivotIndex = rand.nextInt(right) % (right - left + 1) + left;
        }
        pivotIndex = partition(pivotIndex, points, left, right);
        if (pivotIndex == k) {
            return points[k];
        }
        else if (pivotIndex > k) {
            return quickSelect(points, left, pivotIndex - 1, k);
        }
        else {
            return quickSelect(points, pivotIndex + 1, right, k);
        }
    }

    private int partition(int pivotIndex, Point[] points, int left, int right) {
        int i = left;
        int j = right;
        Point temp = points[pivotIndex];
        int tempDistance = distance(temp);
        swap(points, left, pivotIndex);
        while (i < j) {
            while (j > i && distance(points[j]) >= tempDistance) {
                j--;
            }
            points[i] = points[j];
            while (j > i && distance(points[i]) <= tempDistance) {
                i++;
            }
            points[j] = points[i];
        }
        points[i] = temp;
        return i;
    }

    private int distance(Point point) {
        return point.x * point.x + point.y * point.y;
    }

    private void swap (Point[] points, int index1, int index2) {
        Point temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }
}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// Use max Heap
// maintain a max heap with size K,
// every time meet a new point, check if its distance is 
// smaller than the heap.peek()
// if yes, pop out the peek, push this point into heap
// in the end we will have K points which are the nearest points
'Time complexity: O(nlgk), space complexity:O(k)'
public List<Point> findNearestKPoints(Point[] points, int k) {
    if (k <= 0 || k > points.length) {
        throw new IllegalArgumentException("K's value is illegal.\n");
    }
    List<Point> result = new ArrayList<>();
    PriorityQueue<Point> maxPoints = new PriorityQueue<>(k, new Comparator<Point>() {
        @Override
        public int compare(Point poi1, Point poi2) {
            return distance(poi2) - distance(poi1);
        }
    });
    for (Point point : points) {
        if (maxPoints.size() < k) {
            maxPoints.add(point);
        }
        else if (distance(maxPoints.peek()) > distance(point)) {
            maxPoints.poll();
            maxPoints.add(point);
        }
    }
    while (!maxPoints.isEmpty()) {
        result.add(maxPoints.poll());
    }
    return result;
}



Decode ways
// Use a array to record how many ways we can decode in this number
// Traverse from the tail to head which could handle the situation "0"
// Always take two digits, if the number <= 26 
// Then count[i] = count[i + 1] + count[i + 2], means we can decode as one letter or two letters
// else count[i] = count[i + 1], means we can only decode as one letter
'space complexity:O(n)'
public int numDecodings(String s) {
    if (s.length() == 0) {
        return 0;
    }
    int[] count = new int[s.length() + 1];
    count[s.length()] = 1;
    if (s.charAt(s.length() - 1) != '0') {
        count[s.length() - 1] = 1;
    }
    for (int i = s.length() - 2; i >= 0; i--) {
        if (s.charAt(i) == '0') {
            continue;
        }
        String numberString = s.substring(i, i + 2);
        int number = Integer.parseInt(numberString);
        if (number <= 26) {
            count[i] = count[i + 1] + count[i + 2];
        }
        else {
            count[i] = count[i + 1];
        }
    }
    return count[0];
}

Inplace way
'space complexity: O(1)'
public int numDecodings(String s) {
	int last = 0;
    int secondLast = 1;
    if (s.length() == 0) {
        return 0;
    }
    if (s.charAt(s.length() - 1) != '0') {
        last = 1;
    }
    for (int i = s.length() - 2; i >= 0; i--) {
        if (s.charAt(i) == '0') {
            secondLast = last;
            last = 0;
            continue;
        }
        int number = Integer.parseInt(s.substring(i, i + 2));
        if (number <= 26) {
            int temp = last;
            last = last + secondLast;
            secondLast = temp;
        }
        else {
            secondLast = last;
        }
    }
    return last;
}

Output the result of all decode string
'Time complexity: O(1.6 ^ n)'
class Decode {
    public List<String> decode(String num) {
        List<String> result = new ArrayList<>();
        helper(result, 0, num, "");
        return result;
    }

    private void helper(List<String> result, int pos, String num, String way) {
        if (pos == num.length()) {
            result.add(way);
            return;
        }
        String digits = num.substring(pos, pos + 1);
        int number = Integer.parseInt(digits);
        if (number == 0) {
            return;
        }
        helper(result, pos + 1, num, way + (char)(number + 'A' - 1));
        if (pos < num.length() - 1) {
            String digits2 = num.substring(pos, pos + 2);
            int number2 = Integer.parseInt(digits2);
            if (number <= 26) {
                helper(result, pos + 2, num, way + (char)(number2 + 'A' - 1));
            }
        }
    }
}



7. 一骑士在一个无限大的国际象棋棋盘，有障碍. 骑士行走模式:https://en.wikipedia.org/wiki/Knight_(chess)basic: bfs
calculate the shortest path to some target.
basic code: bfs. more info on 1point3acres.com
follow up:
how to optimize: A*, pruning.
edge case: how to end the program? what kinds of target is unreachable and how to avoid?.

class findPath {
    private final static int[] X = {0, 0, 1, -1};
    private final static int[] Y = {1, -1, 0, 0};
    public int minStep(Point2 start, Point2 end, Set<Point2> blocks) {
        Set<Point2> visited = new HashSet<>();
        Queue<Point2> explore = new LinkedList<>();
        int step = 0;
        explore.offer(start);
        visited.add(start);
        while (!explore.isEmpty()) {
            step++;
            int size = explore.size();
            for (int i = 0; i < size; i++) {
                Point2 point = explore.poll();
                for (int k = 0; k < 4; k++) {
                    int nextX = point.x + X[k];
                    int nextY = point.y + Y[k];
                    Point2 next = new Point2(nextX, nextY);
                    if (next.equals(end)) {
                        return step;
                    }
                    if (!visited.contains(next) && !blocks.contains(next)) {
                        explore.offer(next);
                        visited.contains(next);
                    }
                }
            }
        }
        return -1;
    }
    public List<Point2> minPath(Point2 start, Point2 end, Set<Point2> blocks) {
        HashMap<Point2, Point2> visitedToLast = new HashMap<>();
        Queue<Point2> explore = new LinkedList<>();
        List<Point2> path = new ArrayList<>();
        boolean isFound = false;
        explore.offer(start);
        visitedToLast.put(start, null);
        while (!explore.isEmpty() && !isFound) {
            Point2 point = explore.poll();
            for (int k = 0; k < 4; k++) {
                int nextX = point.x + X[k];
                int nextY = point.y + Y[k];
                Point2 next = new Point2(nextX, nextY);
                if (!visitedToLast.containsKey(next) && !blocks.contains(next)) {
                    visitedToLast.put(next, point);
                }
                if (next.equals(end)) {
                    isFound = true;
                    // visitedToLast.put(end, next);
                }
            }
        }
        Point2 mover = end;
        while (mover != null) {
            path.add(0, mover);
            mover = visitedToLast.get(mover);
        }
        return path;
    }
    public int knightPath(Point2 start, Point2 end, Set<Point2> blocks) {
        int[][] nextStep = {{1, -2}, {1, 2}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {-2, -1}, {-2, 1}};
        Queue<Point2> explore = new LinkedList<>();
        Set<Point2> visited = new HashSet<>();
        int step = 0;
        explore.offer(start);
        visited.add(start);
        while (!explore.isEmpty()) {
            step++;
            int size = explore.size();
            for (int i = 0; i < size; i++) {
                Point2 point = explore.poll();
                for (int k = 0; k < 8; k++) {
                    int x = nextStep[k][0];
                    int y = nextStep[k][1];
                    int nextX = point.x + x;
                    int nextY = point.y + y;
                    Point2 next = new Point2(nextX, nextY);
                    boolean canReach1 = true;
                    boolean canReach2 = true;
                    if (Math.abs(y) > Math.abs(x)) {
                        int tempY = y;
                        while (Math.abs(tempY) > 0) {
                            Point2 check = new Point2(point.x, point.y + tempY);
                            Point2 check2 = new Point2(nextX, point.y + tempY - 1);
                            canReach1 = blocks.contains(check) ? false : canReach1;
                            canReach2 = blocks.contains(check2) ? false : canReach2;
                            tempY = tempY > 0 ? tempY - 1 : tempY + 1;
                        }
                    }
                    else {
                        int tempX = x;
                        while (Math.abs(tempX) > 0) {
                            Point2 check = new Point2(point.x + tempX, point.y);
                            Point2 check2 = new Point2(point.x + tempX - 1, nextY);
                            canReach1 = blocks.contains(check) ? false : canReach1;
                            canReach2 = blocks.contains(check2) ? false : canReach2;
                            tempX = tempX > 0 ? tempX - 1 : tempX + 1;
                        }
                    }
                    if ((!canReach1 && !canReach2) || blocks.contains(next)) {
                        continue;
                    }
                    if (next.equals(end)) {
                        return step;
                    }
                    if (!visited.contains(next)) {
                        explore.add(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }
}
class Point2{
    public int x;
    public int y;
    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(new int[]{x, y});
    }
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof Point2)) {
            return false;
        }
        Point2 point = (Point2) other;
        return point.x == x && point.y == y;
    }
}





8. Longest consecutive sequence
// Use a hashMap to record the length of a consecutice sequence
// When meet a new number, lookup into hashMap for the adjcent number
// if exits, then we merge this number into consecutive sequence
// We only need to update the length at the end and start of the sequence
public int longestConsecutive(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int result = 1;
    for (int num : nums) {
        if (map.containsKey(num)) {
            continue;
        }
        int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
        int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
        int len = left + right + 1;
        map.put(num, len);
        map.put(num - left, len);
        map.put(num + right, len);
        result = Math.max(result, len);
    }
    return result;
}

9. reconstruct BST from pre-order sequence. (preorder BST)
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192346&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
'######-need iterative method-#########' T(N) = 2 * T(N /2) + O(N) = 4 T(N / 4) + 2 * O(N) = N + lgN * O(N)
'Time complexity: O(NlgN)'
class construcBST {
    public TreeNode constructFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        return constructorHelper(preorder, 0, preorder.length - 1);
    }
    private TreeNode constructorHelper(int[] preorder, int start, int end) {
        TreeNode root = new TreeNode(preorder[start]);
        if (start == end) {
            return root;
        }
        // find the start of right branch
        start++;
        int rightIndex = start;
        while (rightIndex <= end && preorder[rightIndex] < root.val) {
            rightIndex++;
        }
        TreeNode left = null;
        TreeNode right = null;
        if (rightIndex > start) {
            left = constructorHelper(preorder, start, rightIndex - 1);
        }
        if (rightIndex <= end) {
            right = constructorHelper(preorder, rightIndex, end);
        }
        root.left = left;
        root.right = right;
        return root;
    }
}

10.  给一个字符串和一个输入的字符，要求移走给定的字符， (Move Zero, zeros, zeroes, move char)
	// move zero like
	// traverse the string and put the non-target character into the 
	// char array one by one, and put the target character at the end
	class MoveChar {
	    public String removeChar(char[] input, char k) {
	        int fast = 0;
	        int slow = 0;
	        while (fast < input.length) {
	            while (slow < input.length && input[slow] != k) {
	                slow++;
	            }
	            fast = slow;
	            while (fast < input.length && input[fast] == k) {
	                fast++;
	            }
	            while (fast < input.length && input[fast] != k) {
	                input[slow] = input[fast];
	                input[fast] = k;
	                fast++;
	                slow++;
	            }
	        }
	        StringBuilder result = new StringBuilder();
	        for (int i = 0; i < slow; i++) {
	            result.append(input[i]);
	        }
	        return result.toString();
	    }
	}

给一个数字array , 有正有负数。给一个数， 找array中连续的数字，其和是给定的数。leecode应该有类似的题目，但记不清了。是用hash table做的
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=197490&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

Subarray Equals K (consecutive sequcnce sum equals to k)
// Use hashSet to store the sum, rang[i ~ j] = sum[j] - sum[i] = k
// Set.contains(sum - k), return true
class SubarrayEqualsK {
    public boolean findSubarray(int[] input, int k) {
        Set<Integer> sums = new HashSet<>();
        int sum = 0;
        for (int number : input) {
            sum += number;
            if (sums.contains(sum - k)) {
                return true;
            }
            sums.add(sum);
        }
        return false;
    }
}

11.  LC 28和111
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=186980&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
Strstr
public int strStr(String haystack, String needle) {
    if (needle.length() == 0) {
        return 0;
    } 
    if (haystack.length() == 0 && needle.length() != 0) {
        return -1;
    }
    for (int i = 0; i < haystack.length(); i++) {
        if (haystack.charAt(i) == needle.charAt(0)) {
            int j = 0;
            for (j = 1; j < needle.length() && j + i < haystack.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
            else if (i + j == haystack.length() || i + needle.length() - 1 >= haystack.length()) {
                return -1;
            }
        }
    }
    return -1;
}


min depth of BT
// recursive method
public int minDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    return traverse(root, 0);
}
private int traverse(TreeNode root, int depth) {
    depth++;
    if (root.left == null && root.right == null) {
        return depth;
    }
    int left = Integer.MAX_VALUE;
    int right = Integer.MAX_VALUE;
    if (root.left != null) {
        left = traverse(root.left, depth);
    }
    if (root.right != null) {
        right = traverse(root.right, depth);
    }
    return Math.min(left, right);
}

// iterative method
private int findMinDepth(TreeNode root) {
	if (root == null) {
        return 0;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    int level = 0;
    int result = 0;
    nodes.offer(root);
    while (result == 0) {
        level++;
        int size = nodes.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            if (node.left == null && node.right == null) {
                result = level;
            }
            if (node.left != null) {
                nodes.offer(node.left);
            }
            if (node.right != null) {
                nodes.offer(node.right);
            }
        }
    }
    return result;
}


12.  在一个nonnegative array里找continuous sequence 加起来等于特定值的一道题
Equals k
public boolean minSubArrayLen(int s, int[] nums) {
    int fast = 0;
    int slow = 0;
    int sum = 0;
    while (fast < nums.length) {
        sum += nums[fast];
        while (sum > s) {
            sum -= nums[slow];
            slow++;
        }
        if (sum == s) {
            return true;
        }
        fast++;
    }
    return false;
}
13. 第一题3sum，第二题在一个循环聊表中插入一个新节点，返回新的头节点(第二题那个循环链表是sorted的)
给一个头结点head,与一个要插入的节点，插入之后返回新的头结点。所以什么是头结点？应该在什么位置插入新节点？
根据模糊的信息，作为一个engineer，必须学会问clarify的问题，那么这里没有面试官，那我只能猜了。头结点就是value值最小的节点，插入的新节点应该要找value的值的大小插入
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=144124&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

3sum 
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }
        int target = 0 - nums[i];
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[right] + nums[left] < target) {
                left++;
            }
            else if (nums[right] + nums[left] > target) {
                right--;
            }
            else if (nums[right] + nums[left] == target) {
                result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right])));
                right--;
                left++;
                // in case there are duplicate numbers
                while ( right >= 0 && nums[right] == nums[right + 1]) {
                    right--;
                }
                while (left < nums.length && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
    }
    return result;
}

public List<List<Integer>> threeSum(int[] input, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Set<List<Integer>> visited = new HashSet<>();
    HashMap<Integer, Integer> valueToIndex = new HashMap<>();
    for (int i = 0; i < input.length; i++) {
        valueToIndex.put(input[i], i);
    }
    for (int i = 0; i < input.length - 1; i++) {
        int newTarget = target - input[i];
        for (int j = i + 1; j < input.length; j++) {
            if (valueToIndex.containsKey(newTarget - input[j])) {
                int index = valueToIndex.get(newTarget - input[j]);

                if (index != j && index != i) {
                    List<Integer> pair = new ArrayList<>(Arrays.asList(input[i], input[j], input[index]));
                    Collections.sort(pair);
                    if (!visited.contains(pair)) {
                        result.add(pair);
                        visited.add(pair);
                    }
                }
            }
        }
    }
    return result;
}

insert node to sorted linkedList
class InsertLinkedList {
    public ListNode insert(ListNode head, ListNode node) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode mover = head;
        ListNode previous = fakeHead;
        while (mover != null && mover.val < node.val) {
            mover = mover.next;
            previous = previous.next;
        }
        previous.next = node;
        node.next = mover;
        return fakeHead.next;
    }
}

public ListNode makeList(int[] input) {
    ListNode fakeHead = new ListNode(0);
    ListNode mover = fakeHead;
    for (int num : input) {
        mover.next = new ListNode(num);
        mover = mover.next;
    }
    return fakeHead.next;
}

14.  上来就做题。read4k
// read one time
// 1 byte = 8 bits
public int read(char[] buf, int n) {
    char[] content = new char[4096];
    int count = 0; 
    boolean hasNext = true;
    while (hasNext && count < n) {
        int readLength = read4k(content);
        if (readLength < 4096) {
            hasNext = false;
        }
        for (int i = 0; i < readLength && count < n; i++) {
            buf[count++] = content[i];
        }
    }
    return count;
}

// read many times
// record what previously read
private char[] content = new char[4096];
private int haveRead = 0; // the bit we read by calling read4k
private int index = 0;
public int read(char[] buf, int n) {
    int count = 0;
    boolean hasNext = true;
    while (hasNext && count < n) {
        if (index == 0) {
            haveRead = read4k(content);
        }
        if (haveRead < 4096) {
            hasNext = false;
        }
        while (count < n && index < haveRead) {
            buf[count] = content[index];
            count++;
            index++;
        }
        if (index == haveRead) {
            index = 0;
        }
    }
    return count;
}

15. question1: 

Given predicted stock prices for next n days for a stock e.g : 20, 40, 52, 15, 30, 50, 10, 25
 find the maximum profit that can be made with a single buy-sell transaction. If no profit can 
 be made return 0. In the example buying at 15 and selling at 50 gives maximum profit. Note that the 
 two prices are neither minimum nor maximum in the array..

question2:
For a given a binary tree, print paths from root to all leaf nodes, one path per line. 

For tree:
        A
        / \
       B   C
      /   / \
     D   E   F

ABD
ACE
ACF
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=171687&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
Best time to buy stock 1:
// when traverse the array, find the smallest price for now
// use every days prices minus this
// in the end we will have the max profit
public int maxProfit(int[] prices) {
    int profit = 0;
    int min = Integer.MAX_VALUE;
    for (int price : prices) {
        min = Math.min(price, min);
        profit = Math.max(profit, price - min);
    }
    return profit;
}
Best time to buy stock 2:
// do the transic every day
// when today's prices is higher than yesterday
// if pricse keep increase, the result will be the same as buy at first day and 
// sell at last day
public int maxProfit(int[] prices) {
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
        profit += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
    }
    return profit;
}
Best time to buy stock 3:
// use an array to record the max profit we can make before today
// use another array to record the max profit we can make after today
// So max profit we can make = max(before[i] + after[i]) 0 <= i <= length
public int maxProfit(int[] prices) {
    if (prices.length == 0) {
        return 0;
    }
    int[] first = new int[prices.length];
    int[] second = new int[prices.length];
    int min = prices[0];
    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
        min = Math.min(min, prices[i]);
        maxProfit = Math.max(maxProfit, prices[i] - min);
        first[i] = maxProfit;
    }
    int max = prices[prices.length - 1];
    maxProfit = 0;
    for (int i = prices.length - 1; i >= 0; i--) {
        max = Math.max(max, prices[i]);
        maxProfit = Math.max(max - prices[i], maxProfit);
        second[i] = maxProfit;
    }
    maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
        maxProfit = Math.max(first[i] + second[i], maxProfit);
    }
    return maxProfit;
}
best time to buy stock 4: 
'''
can buy k times
'''
 /**
 * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
 *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
 * dp[0, j] = 0; 0 transactions makes 0 profit
 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
 */
    if (k == 0 || prices.length <= 1) {
        return 0;
    }
    if (k >= prices.length / 2) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = prices[i] > prices[i -1] ? profit + prices[i] - prices[i - 1] : profit;
        }
        return profit;
    }
    int[][] helper = new int[k + 1][prices.length];
    for (int i = 1; i <= k; i++) {
        int localMax = helper[i - 1][0] - prices[0];
        for (int j = 1; j < prices.length; j++) {
            helper[i][j] = Math.max(helper[i][j - 1], prices[j] + localMax);
            localMax = Math.max(localMax, helper[i - 1][j] - prices[j]);
        }
    }
    return helper[k][prices.length - 1];
}

best time to buy stock with cool down:
public int maxProfit(int[] prices) {
    if (prices.length == 0) {
        return 0;
    }
    int[] hold = new int[prices.length]; //Have no stock on hands today(sell it or do not buy)
    int[] buy = new int[prices.length]; //buy stock today or have bought it before today(have stock on hands)
    hold[0] = 0;
    buy[0] = 0 - prices[0];
    for (int i = 1; i < prices.length; i++) {
        hold[i] = Math.max(buy[i - 1] + prices[i], hold[i - 1]);
        if (i == 1) {
            buy[i] = Math.max(buy[0], 0 - prices[i]);
        }
        else {
            buy[i] = Math.max(buy[i - 1], hold[i - 2] - prices[i]);
        }
    }
    return hold[prices.length - 1];
    
}
//--------------------------------------------------------------------//
public int maxProfit(int[] prices) {
    int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
    for (int price : prices) {
        prev_buy = buy;
        buy = Math.max(prev_sell - price, prev_buy);
        prev_sell = sell;
        sell = Math.max(prev_buy + price, prev_sell);
    }
    return sell;
}



print path to leaf (BT path leaf)

iterative method
private List<String> findPath(TreeNode root) {
	List<String> result = new ArrayList<>();
    if (root == null) {
        return result;
    }
    Stack<Pair> stack = new Stack<>();
    stack.push(new Pair(root, ""));
    while (!stack.isEmpty()) {
        Pair pair = stack.pop();
        TreeNode node = pair.node;
        String path = pair.path + "->" + Integer.toString(node.val);
        if (node.left == null && node.right == null) {
            result.add(path.substring(2));
        }
        if (node.left != null) {
            stack.push(new Pair(node.left, path));
        }
        if (node.right != null) {
            stack.push(new Pair(node.right, path));
        }
    }
}
    
class Pair {
    TreeNode node;
    String path;
    public Pair(TreeNode node, String path) {
        this.node = node;
        this.path = path;
    }
}

recursive method
public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    if (root == null) {
        return result;
    }
    explorePath(root, result, new StringBuilder());
    return result;
}
private void explorePath(TreeNode root, List<String> result, StringBuilder path) {
    path.append("->" + Integer.toString(root.val));
    if (root.left == null && root.right == null) {
        result.add(path.substring(2).toString());
        return;
    }
    if (root.left != null) {
        explorePath(root.left, result, new StringBuilder(path.toString()));
    }
    if (root.right != null) {
        explorePath(root.right, result, new StringBuilder(path.toString()));
    }
}

class PrintByColumn {
    private int mostLeft = 0;
    public void print(TreeNode root) {
        List<List<Pair>> paths = new ArrayList<>();
        helper(root, 0, new ArrayList<Pair>(), paths);
        for (List<Pair> path : paths) {
            for (Pair pair : path) {
                int gap = -mostLeft - (-pair.col);
                while (gap > 0) {
                    System.out.print("*");
                    gap--;
                }
                System.out.print(pair.val);
            }
            System.out.println();
        }
    }
    private void helper(TreeNode root, int col, List<Pair> list, List<List<Pair>> paths) {
        list.add(new Pair(root.val, col));
        mostLeft = Math.min(mostLeft, col);
        if (root.left == null && root.right == null) {
            paths.add(new ArrayList<Pair>(list));
        }
        if (root.left != null) {
            helper(root.left, col - 1, list, paths);
        }
        if (root.right != null) {
            helper(root.right, col + 1, list, paths);
        }
        list.remove(list.size() - 1);
    }
    class Pair {
        int col;
        int val;
        public Pair(int val, int col) {
            this.val = val;
            this.col = col;
        }
    }
}


16. 一个中国人面我的，态度很好，是messenger组的，写了2个题。第一个题其实很简单，check consecutive subarray duplicate numbers, 就是用hashset查重复就可以了，关键是窗口的移动。我写的很差，他让optimize到O（n）, 最后他给了个hint, 当时脑子蒙了，没有想到一个key point, 然后我说might work, 他冷嘲热讽了一句“might ? haha ”，我当时心里就哭了。。。. 1point 3acres 璁哄潧
第二题很顺利，就是remove invalid（（））【】什么的，leetcode上做过
大家都在问第一题，大概是这个意思：给一个array, 然后给一个k, 让你check 连续的k个integer是否含有dulplicate, 很简单的，用窗口为K的hashset一直扫一遍就行了，很简单
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=175190&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

check duplicate numbers in window k
HashMap 
public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
            return true;
        }
        else {
            map.put(nums[i], i);
        }
    }
    return false;
}

HashSet
public boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> window = new HashSet<>();
    int low = 0;
    int high = 0;
    while (high < nums.length) {
        if (window.size() >= k) {
            window.remove(nums[low]);
            low++;
        }
        if (window.contains(nums[high])) {
            return true;
        }
        else {
            window.add(nums[high]);
            high++;
        }
        
    }
    return false;
}



17. 字符串匹配，最原始的那种：一个s，一个p，在s里面找p，返回第一个匹配字串的开头下标。如没有返回-1。忘了KMP怎么写的了，只能brute-force。。。。。
follow up：不用写代码，大概描述一下：不是找p，而是找p的permutation。比如s="aabacddccab", p="dadc"，返回3。因为acdd是dadc的permutation。
Strstr permutation
Follow Up : 
// Use HashMap to record the letters in the P
public int strStrPermutation(String haystack, String needle) {
    HashMap<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : needle.toCharArray()) {
        if (letterToCount.containsKey(letter)) {
            letterToCount.put(letter, letterToCount.get(letter) + 1);
        }
        else {
            letterToCount.put(letter, 1);
        }
    }
    for (int i = 0; i < haystack.length(); i++) {
        if (letterToCount.containsKey(haystack.charAt(i))) {
            HashMap<Character, Integer> temp = new HashMap<>(letterToCount);
            int j = i;
            while (j < haystack.length()) {
                char letter = haystack.charAt(j);
                if (temp.containsKey(letter)) {
                    temp.put(letter, temp.get(letter) - 1);
                }
                else {
                    break;
                }
                if (temp.get(letter) == 0) {
                    temp.remove(letter);
                }
                if (temp.size() == 0) {
                    return i;
                }
                j++;
            }
            if (j == haystack.length()) {
                return -1;
            }
        }
    }
    return -1;
}

20. First Bad Version. leetcode 278. 问了时间空间复杂度
public int firstBadVersion(int n) {
    int high = n;
    int low = 0;
    while (low + 1 < high) {
        int mid = low + (high - low) / 2;
        if (isBadVersion(mid)) {
            high = mid;
        }
        else {
            low = mid;
        }
    }
    if (isBadVersion(low)) {
        return low;
    }
    return high;
}
21. Valid Palindrome. leetcode 125. 问了时间空间复杂度。这题要求要in-place， 然后输入是char[]，不过做法跟leetcode一样。做这题居然忘记了Character.toLowerCase()这个method。
public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    s = s.toLowerCase();
    while (left <= right) {
        while (right >= left && !isAlphaNumber(s.charAt(right))) {
            right--;
        }
        while (left <= right && !isAlphaNumber(s.charAt(left))) {
            left++;
        }
        if (left <= right && s.charAt(left) != s.charAt(right)) {
            return false;
        }
        right--;
        left++;
    }
    return true;
}
private boolean isAlphaNumber(char c) {
    if (!('a' <= c && 'z' >= c) && !Character.isDigit(c)) {
        return false;
    }
    return true;
}
22. Dot Product.
   A={a1, a2, a3,...}
   B={b1, b2, b3,...}
   dot_product = a1 * b1 + a2 * b2 + a3 * b3 ＋。。。
   如果数组很稀疏，例如-google 1point3acres
   A={a1, ...., a300, ...., a5000}. more info on 1point3acres.com
   B={...., b100, ..., b300, ..., b1000, ...}
  里面有很多0，用什么数据结构表示能节省空间。我开始说用hashmap，但是hashmap不能做有顺序的iteration。然后改用list和array，两个都可以。后面做题的时用的array。. visit 1point3acres.com for more.
  题目是：
  input A=[[1, a1], [300, a300], [5000, a5000]]
          B=[[100, b100], [300, b300], [1000, b1000]]. 鍥磋鎴戜滑@1point 3 acres
  求 dot product. 问了时间复杂度。
  Follow up:
  如果length(B) >>> length(A)，即B非常长，怎么做能减少时间复杂度。对A里面的每个数，用binary search找B中相对应的值，这样时间复杂度是O(nlogm) (n = len(A), m =len(B)).时间不够没写代码， 就说了一下思路和复杂度。
   
  第三题的输入就是稀疏数组的非0的数列出来了，A=[[1, a1], [300, a300], [5000, a5000]]的意思就是A中第1个数是a1,第300个是a300,第5000个是a5000，其他都是0.

  http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=199709&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
class DotProduct {
    // Pair[1] - value, Pair[0] - index
    public int dotProduct(int[][] A, int[][] B) {
        int sum = 0;
        for (int[] pair : A) {
            int index = pair[0];
            int indexB = binarySearch(B, index);
            if (indexB != -1) {
                sum += pair[1] * B[indexB][1];
            }
        }
        return sum;
    }
    private int binarySearch(int[][] B, int index) {
        int low = 0;
        int high = B.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (B[mid][1] >= index) {
                high = mid;
            }
            else {
                low = mid;
            }
        }
        if (B[low][0] == index) {
            return low;
        }
        else if (B[high][0] == index) {
            return high;
        }
        return -1;
    }
    'Time complexity: O(max(LenA, LenB))'
    public int dotProduc(int[][] A, int[][] B) {
        int indexA = 0;
        int indexB = 0;
        int product = 0;
        while (indexA < A.length && indexB < B.length) {
            if (A[indexA][0] == B[indexB][0]) {
                product += A[indexA][1] * B[indexB][1];
                indexA++;
                indexB++;
            }
            else if (A[indexA][0] > B[indexB][0]) {
                indexB++;
            }
            else {
                indexA++;
            }
        }
        return product;
    }
}



23. Find longest arithmetic subsequence in an unsorted array.
没做过，现场想的思路。
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=199553&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

// The idea is to maintain a 2d array. Called length[input.length][input.length]
// length[i][j] means the length of the arithmetic that ends with input[i] and input[j]
// And a hashMap to record the index of every number
// We traverse the input from index 1 to the end.
// Everytime we meet a number, fix this as the end of sequence
// Then traverse back and try to make every number as second last number
// When we fix one as second last one number, we calculate the gap as input[last] - input[secondLast]
// look into hashmap to find is there a number in the input equals to input[secondLast] - gap. 
// And check its index whether it is smaller than secondLast.
// If it is. Then this is the third last number. And we should already have length[thridLast][secondLast]
// Then length[secondLast][last] = length[thridLast][secondLast] + 1
// If it is not. We make length[secondLast][last] = 2 -- those two number are the only numbers in the arithmetic
'Time complexity: O(n^2), space complexity: O(n^2) -- for only return length'


class LongestArithmeticSequence {
    public int findLongest(int[] input) {
        if (input.length <= 2) {
            return 2;
        }
        int maxLen = 2;
        int[][] length = new int[input.length][input.length];
        HashMap<Integer, List<Integer>> valueToIndex = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (!valueToIndex.containsKey(input[i])) {
                valueToIndex.put(input[i], new ArrayList<Integer>());
            }
            valueToIndex.get(input[i]).add(i);
        }
        for (int index = 1; index < input.length; index++) {
            for (int secondLast = index - 1; secondLast >= 0; secondLast--) {
                int gap = input[index] - input[secondLast];
                int next = input[secondLast] - gap;
                if (valueToIndex.containsKey(next)) {
                    int nextIndex = -1;
                    for (int j = valueToIndex.get(next).size() - 1; j >= 0; j--) {
                        if (valueToIndex.get(next).get(j) < secondLast) {
                            nextIndex = valueToIndex.get(next).get(j);
                            break;
                        }
                    }
                    if (nextIndex != -1) {
                        length[secondLast][index] = length[nextIndex][secondLast] + 1;
                        maxLen = Math.max(maxLen, length[secondLast][index]);
                    }
                }
                if (length[secondLast][index] == 0) {
                    length[secondLast][index] = 2;
                }
            }
        }
        return maxLen;
    }

// if print out the sequence
'Time complexity: O(n^2), space complexity: O(n^2 * m) --m is the average length of all the arithmetic sequence'


    public List<Integer> printLongest(int[] input) {
        List<Integer> result = new ArrayList<>();
        if (input.length <= 2) {
            for (int num : input) {
                result.add(num);
            }
            return result;
        }
        int maxLen = 0;
        List<Integer>[][] length = new ArrayList[input.length][input.length];
        HashMap<Integer, List<Integer>> valueToIndex = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (!valueToIndex.containsKey(input[i])) {
                valueToIndex.put(input[i], new ArrayList<Integer>());
            }
            valueToIndex.get(input[i]).add(i);
        }
        for (int index = 1; index < input.length; index++) {
            for (int secondLast = index - 1; secondLast >= 0; secondLast--) {
                int gap = input[index] - input[secondLast];
                int next = input[secondLast] - gap;
                if (valueToIndex.containsKey(next)) {
                    int nextIndex = -1;
                    for (int j = valueToIndex.get(next).size() - 1; j >= 0; j--) {
                        if (valueToIndex.get(next).get(j) < secondLast) {
                            nextIndex = valueToIndex.get(next).get(j);
                            break;
                        }
                    }
                    if (nextIndex != -1) {
                        length[secondLast][index] = new ArrayList<Integer>(length[nextIndex][secondLast]);
                        length[secondLast][index].add(input[index]);
                        if (maxLen <= length[secondLast][index].size()) {
                            result = length[secondLast][index];
                            maxLen = length[secondLast][index].size();
                        }
                    }
                }
                if (length[secondLast][index] == null) {
                    length[secondLast][index] = new ArrayList<>();
                    length[secondLast][index].add(input[secondLast]);
                    length[secondLast][index].add(input[index]);
                }
            }
        }
        return result;
    }
}



24.  leetcode原题，strstr，唯一区别就是参数是char array，不让用string方法做（当然也包括stringbuilder），返回在hackstack里第一次匹配needle的substring的第一个字符下标，后来想想这哥们写c和c++的，也就make sense了

25. 大意就是把第一个haystack参数变成一个二维数组，然后找needle在haystack第一次出现的位置，同样的不能用string相关方法，还是返回把haystack[][]二维数组看成一维以后的第一次匹配的字符下标，举例：haystack := [[a,b,c,c], [c,b,d]], needle := [c,c,b,d] , return 2; needle := [b, d] return 5 (5是把haystack看成一维的以后的找到第一个bd以后b的下标)
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=181597&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
(Strstr 2d array)
public int strStr(List<List<Character>> haystack, String needle) {
    int total = 0;
    for (int row = 0; row < haystack.size(); row++) {
        for (int col = 0; col < haystack.get(row).size(); col++) {
            int k = 0;
            int posRow = row;
            int posCol = col;
            while ((posRow < haystack.size() && posCol < haystack.get(posRow).size()) && k < needle.length() && haystack.get(posRow).get(posCol) == needle.charAt(k)) {
                k++;
                posCol++;
                if (posCol == haystack.get(posRow).size()) {
                    posCol = 0;
                    posRow++;
                }
            }
            if (k == needle.length()) {
                return total + col - 1;
            }
        }
        total += haystack.get(row).size();
    }
    return -1;
}


27. longest PATH(could be the path from leaf to leaf) in binary tree(BT longest path)
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=199567&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
class LongestPathInBT {
    public int findLongest(TreeNode root) {
        Pair length = checkNode(root);
        return length.longestPath;
    }

    private Pair checkNode(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair left = checkNode(root.left);
        Pair right = checkNode(root.right);
        int across = 1 + left.depth + right.depth;
        int longestPath = Math.max(across, Math.max(left.longestPath, right.longestPath));
        int depth = Math.max(left.depth, right.depth) + 1;
        return new Pair(depth, longestPath);
    }

    class Pair {
        int depth;
        int longestPath;
        public Pair(int depth, int longestPath) {
            this.depth = depth;
            this.longestPath = longestPath;
        }
    }
}


28. word search
面试官一开始怕太难了 就说允许重复使用character 写出来之后 再让我写不允许重复使用的情况
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=199572&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
'Time complexity: O(n^2*len)--len is the average length of the words, Space complexity: O(len)'
word search 1:
public class Solution {
    private static int[] X = {0, 0, 1, -1};
    private static int[] Y = {1, -1, 0, 0};    
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (helper(word, new boolean[board.length][board[0].length], board, 1, row, col)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean helper(String word, boolean[][] visited, char[][] board, int index, int row, int col) {
        if (index == word.length()) {
            return true;
        }
        visited[row][col] = true;
        for (int k = 0; k < 4; k++) {
            int nextX = row + X[k];
            int nextY = col + Y[k];
            if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length || visited[nextX][nextY]
                || word.charAt(index) != board[nextX][nextY]) {
                continue;
            }
            if (helper(word, visited, board, index + 1, nextX, nextY)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}

word search 2:
// Use trie tree to store the words in the dictionary
// So we dont have to look into the array to find the character match any words
// We only need to look into the trieNode root to see children[ch - 'a'] == null
// if not, then we can start search
'Time complexity: O(n^2*len), space complexity:O(len*k) there are k words in the arrays'
public class Solution {
    private static final int[] X = {0, 0, 1, -1};
    private static final int[] Y = {1, -1, 0, 0};
    private TrieNode root = new TrieNode();
    
    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            insert(word);
        }
        List<String> result = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (root.children[board[row][col] - 'a'] != null) {
                    String word = board[row][col];
                    helper(board, new boolean[board.length][board[0].length], root.children[board[row][col] - 'a'], row, col, word, result);
                }
            }
        }
        return result;
    }
    
    private void helper(char[][] board, boolean[][] visited, TrieNode node, int row, int col, String word, 
                        List<String> result) {
        visited[row][col] = true;
        if (node.isEnd && !result.contains(word)) {
            result.add(word);
        }
        for (int k = 0; k < 4; k++) {
            int nextX = row + X[k];
            int nextY = col + Y[k];
            if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length || visited[nextX][nextY]
                || node.children[board[nextX][nextY] - 'a'] == null) {
                continue;
            }
            helper(board, visited, node.children[board[nextX][nextY] - 'a'], nextX, nextY, word + board[nextX][nextY], result);
        }
        visited[row][col] = false;
    }
    
    private void insert(String word) {
        TrieNode mover = root;
        for (char letter : word.toCharArray()) {
            if (mover.children[letter - 'a'] == null) {
                mover.children[letter - 'a'] = new TrieNode();
            }
            mover = mover.children[letter - 'a'];
        }
        mover.isEnd = true;
    }
    
    class TrieNode {
        public TrieNode[] children;
        public boolean isEnd;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
}

30. product of the array   给定一个array，返回里面元素乘积的所有可能值。 例如给定array:[1,2,3,4]   应该返回 [1, 2, 3, 4, 6, 8, 12, 24].
http://www.1point3acres.com/bbs/thread-199253-1-1.html

// Just Like find the subset of the array
'Time complexity: O(2^n)--number of subsets, space complexity: O(Len(input))'
class Product {
    public List<Integer> product(int[] input) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(input);
        helper(set, 1, 0, input, true);
        return new ArrayList<Integer>(set);
    }

    private void helper(Set<Integer> result, int curProduct, int pos, int[] input, boolean first) {
        if (!first) {
            result.add(curProduct);
        }
        first = false;
        for (int i = pos; i < input.length; i++) {
            if (i != pos && input[i] == input[i - 1]) {
                continue;
            }
            if (input[i] == 0) {
                result.add(0);
                continue;
            }
            curProduct *= input[i];
            helper(result, curProduct, i + 1, input, first);
            curProduct /= input[i];

        }
    }
}



31. combination sum 5

32. 题目：
binary tree inorder traversal

class Node {Node left, Node right, Node parent}.鏈枃鍘熷垱鑷�1point3acres璁哄潧

Node getNext (Node current) {
} 

http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=190436&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

// Inorder --visite left -> root -> right
// First check right child, if it's not null, then the most left child of this right child is the answer
// Else check parent, if it is null, return null --because this is the root and it is the last node in inorder
// if not, if node.parent.left = node (node is the left child of its parent), return parent
// if node.parent.right = node(node is the right child of its parent), go up and 
// search ancester if any ancester is the left child of its parent, return parent
// else return null
'Time complexity:O(1) in average, worst O(h), space complexity: O(1)' (BT Inorder parent)
class BTInroder {
    public TreeNodeWithParent findNext(TreeNodeWithParent node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            TreeNodeWithParent result = node.right;
            while (result.left != null) {
                result = result.left;
            }
            return result;
        }
        else if (node.parent == null) {
            return null;
        }
        else if (node.parent.left == node) {
            return node.parent;
        }
        else {
            TreeNodeWithParent result = node.parent;
            while (result.parent != null && result.parent.right == result) {
                result = result.parent;
            }
            return result.parent;
        }
    }
}

class TreeNodeWithParent {
    public TreeNodeWithParent parent;
    public TreeNodeWithParent left;
    public TreeNodeWithParent right;
    public int val;
    public TreeNodeWithParent(int val, TreeNodeWithParent parent) {
        this.val = val;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

}




33. LeetCode regular expression matching

public boolean isMatch(String s, String p) {
    boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
    match[0][0] = true;// If s and p are "", isMathch() returns true;
    for (int i = 0; i <= s.length(); i++) {
        for (int j = 1; j <= p.length(); j++) {// j starts from 1, since dp[i][0] is false when i!=0;
            if (p.charAt(j - 1) != '*') {
            // The last character of s and p should match;
            // And, dp[i-1][j-1] is true;
                match[i][j] = i > 0 && match[i - 1][j - 1] && 
                (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.');
            }
            else {
            // Two situations:
            // (1) dp[i][j-2] is true, and there is 0 preceding element of '*';
            // (2) The last character of s should match the preceding element of '*';
            //     And, dp[i-1][j] should be true;
                match[i][j] = match[i][j - 2] ||
                                i > 0 && match[i - 1][j] && 
                                (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.');
            }
        }
    }
    return match[s.length()][p.length()];
}



34. 买股票1，删除在单链表的节点

35. 有一个无限流的interval输入，要找出cover range。这个用什么数据结构比较好呢？

36. 设计一个系统，大概有1b的active user，大家都会post，每个post，都有名字和时间戳。然后还有一个search的功能，输入是一个或多个keyword（words之间是OR关系），要求返回相关的post。这个问题牵扯到如何存，如果做search word。大概的结构是什么样子的，还有要估算出每个function都需要多少机器呢。估算做的不完整，我只算出来了存post需要多少个机器，然后没有时间了。三哥说架构没有问题，good direction，算出来多少机器那一步不错。

37. 工作的调度，是个面经题，有些变种，只要求出给定tasks的工作总时间，在小哥提示下做了优化到O(n). Follow up是如何schedule这些工作，这样最后的工作总时间最少。我说了一种greedy的算法，就是相同task相隔约长约好。但是不太对，小哥说其实是一旦数量最多的task cooldown时间到了，就schedule这个task。问了我大概怎么实现，就结束了。

38. 找出数组中第M大的数。quick sort也可以解决，average run time O(N), worst case O(N^2)。如果数组特别大呢，不想sort呢。可以用一个M size的pq，这样的话就是O(N*logM). 倒叙输出单链表，有两种方法，问了下tradeoff。然后完成单链表反转。
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=198026&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

# task
# mission order , same task cannot be called in a period  (missions, task, cd)
	public static int missionOrder(int[] mission, int N) {
		if (mission.length == 0) {
			return 0;
		} 
		HashMap<Integer, Integer> map = new HashMap<>();
		int time = 0;
		for (int i = 0; i < mission.length; i++) {
			time++;
			if (!map.containsKey(mission[i])) {
				map.put(mission[i], time);
			}
			else {
				if (time - map.get(mission[i]) > N) {
					map.put(mission[i], time);
				}
				else {
					time = N + map.get(mission[i]) + 1;
					map.put(mission[i], time);
				}
			}
		}
		return time;
	}
'''if can change the order of mission, how to minize the time''' (minize missions time)
//
//always arrange the mission with the highest frequence
//if its time interval is smaller than k, find the second highest mission
//if all mission's time interval smaller than k, just add '*'
//using TreeSet to do this
'Time complexity: O(nlgn + n^2) --lgn is the add or remove operation of treeSet, Space complexity: O(n)'
public String minizTime(String input, int k) {
    if (input.length() <= 1) {
        return input;
    }
    StringBuilder result = new StringBuilder();
    TreeSet<Mission> missions = new TreeSet<>(new Comparator<Mission>() {
        @Override
        public int compare(Mission mis1, Mission mis2) {
        	// In treeSet, if the compare return 0 it will consider that they are same elements 
        	// and wont add this into set. So we need to consider the situation as two missions might have
        	// same frequence
            if (mis1.freq == mis2.freq) { 
                return mis1.name - mis2.name;
            }
            return mis2.freq - mis1.freq;
        }
    });
    HashMap<Character, Integer> missionToTime = new HashMap<>();
    HashMap<Character, Integer> missionToFreq = new HashMap<>();
    for (char mission : input.toCharArray()) {
        if (!missionToFreq.containsKey(mission)) {
            missionToFreq.put(mission, 1);
        }
        else {
            missionToFreq.put(mission, missionToFreq.get(mission) + 1);
        }
    }
    for (char mission : missionToFreq.keySet()) {
        missions.add(new Mission(mission, missionToFreq.get(mission)));
    }

    while (!missions.isEmpty()) {
        Mission selected = null;
        for (Mission mission : missions) {
            if (!missionToTime.containsKey(mission.name) || result.length() - missionToTime.get(mission.name) >= k) {
                selected = mission;
                missionToTime.put(mission.name, result.length() + 1);
                break;
            }
        }
        if (selected == null) {
            result.append('*');
        }
        else {
            result.append(selected.name);
            missions.remove(selected);
            selected.freq--;
            if (selected.freq > 0) {
                missions.add(selected);
            }
        }
    }
    return result.toString();
}

class Mission {
    public char name;
    public int freq;
    public Mission(char name, int freq) {
        this.name = name;
        this.freq = freq;
    }
}

#reverse print linked List

public ListNode reverseList(ListNode head) {
    if (head == null) {
        return head;
    }
    ListNode mover = head;
    ListNode last = null;
    while (mover != null) {
        ListNode next = mover.next;
        mover.next =last;
        last = mover;
        mover = next;
    }
    return last;
}

public ListNode reverseListRecursive(ListNode head) {
	if (head == null || head.next == null) {
        return head;
    }
    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
}

# kth largest
class findKthLargest {
    // Use quickSelect
    public int kthLargest(int[] input, int k) {
        if (input.length < k || k == 0) {
            throw new IllegalArgumentException("K's value is illegal.\n");
        }
        return quickSelect(input, 0, input.length - 1, input.length - k);

    }

    private int quickSelect(int[] input, int left, int right, int k) {
        Random rand = new Random();
        int pivotIndex = 0;
        if (right != 0) {
            pivotIndex = rand.nextInt(right) % (right - left + 1) + left;
        }
        pivotIndex = partition(input, left, right, pivotIndex);
        if (pivotIndex == k) {
            return input[k];
        }
        else if (pivotIndex < k) {
            return quickSelect(input, pivotIndex + 1, right, k);
        }
        else {
            return quickSelect(input, left, pivotIndex - 1, k);
        }
    }

    private int partition(int[] input, int left, int right, int pivotIndex) {
        int i = left;
        int j = right;
        int temp = input[pivotIndex];
        swap(input, left, pivotIndex);
        while (i < j) {
            while (i < j && input[j] >= temp) {
                j--;
            }
            input[i] = input[j];
            while (i < j && input[i] <= temp) {
                i++;
            }
            input[j] = input[i];
        }
        input[i] = temp;
        return i;
    }

    private void swap(int[] input, int index1, int index2) {
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }
    // When the input is too big
    // Use priorityQueue
    'Time complexity: O(nlgk), space complexity: O(k)'
    public int kthLargestWithHeap(int[] input, int k) {
        if (input.length < k || k == 0) {
            throw new IllegalArgumentException("K's value is illegal.\n");
        }
        PriorityQueue<Integer> window = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer int1, Integer int2) {
                return int1 - int2;
            }
        });
        for (int num : input) {
            if (window.size() < k) {
                window.add(num);
            }
            else if (num > window.peek()) {
                window.poll();
                window.add(num);
            }

        }
        return window.poll();
    }
}


39. 给一个正数n，打印出所有相加的组合
例如10可以打印出
1+1+1+...1 
1+2+1+...1
9+1
10
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=172675&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

// DFS
'time complexity: O(k) -- k is the number of sums, space complexity: O(k * average Length) k == 2 ^ n'
class AddSum {
    public List<List<Integer>> find(int input) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<Integer>(), 1, input, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> path, int pos, int target, int sum) {
        if (target == sum) {
            System.out.println(path);
            result.add(path);
            return;
        }
        for (int i = pos; i <= target; i++) {
            if (sum + i > target) {
                return;
            }
            sum += i;
            path.add(i);
            helper(result, path, i, target, sum);
            sum -= i;
            path.remove(path.size() - 1);
        }
    }
}



40. 某白人，一半谈career/resume，一半问算法。题目：破解密码，提供了一个函数，isPassword(String str)，如果pass in的是正确的密码，return true。又给定了每个字母可以变形的集合（例如，字母a可以变形为a或者A或者B或者*, 字母b可以变形为B或者F或者&...，需要自己设计一个data structure来存这个mapping），设计并实现一个函数，在给定一个字符串的情况下，对字符串进行变形，最后找到正确的密码。
// Phone number
//Time O(3^n)
//Space O(3^n)		
public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits.length() == 0) {
        return result;
    }
    char[][] chs = {{},{},{'a','b','c'}, {'d','e','f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    StringBuilder path = new StringBuilder();
    helper(result, path, 0, digits, chs);
    return result;
}

private void helper(List<String> result, StringBuilder path, int pos, String digits, char[][] phoneNumber) {
    if (pos == digits.length()) {
        result.add(new StringBuilder(path).toString());
        return;
    }
    int digit = Integer.parseInt(digits.substring(pos, pos + 1));
    for (int i = 0; i < phoneNumber[digit].length; i++) {
        path.append(phoneNumber[digit][i]);
        helper(result, path, pos + 1, digits, phoneNumber);
        path.delete(path.length() - 1, path.length()); 
    }
}
41. 考了valid BST和move zeros两道原题

Move Zero (zero, zeros, zeroes)
//one loop
public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) return;        
    int head = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            swap(nums, head++, i);
        }
    }
    
}
private void swap(int[] nums, int index1, int index2) {
    if (index1 == index2) {
        return;
    }
    int temp = nums[index2];
    nums[index2] = nums[index1];
    nums[index1] = temp;
}

public void moveZeroes(int[] nums) {
    if (nums.length == 0) {
        return;
    }
    int slow = 0;
    int fast = 0;
    while (slow < nums.length) {
        while (slow < nums.length && nums[slow] != 0) {
            slow++;
        }
        fast = slow;
        while (fast < nums.length && nums[fast] == 0) {
            fast++;
        }
        if (fast == nums.length) {
            return;
        }
        while (fast < nums.length && nums[fast] != 0) {
            nums[slow] = nums[fast];
            nums[fast] = 0;
            slow++;
            fast++;
        }
    }
    return;
}

// two loop
// traverse the array, and when meet non-zero number
// put into array one by one
//  then the rest place are for zeroes
public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) return;        
    int insertPoi = 0;
    for (int num : nums) {
        if (num != 0) {
            nums[insertPoi++] = num;
        }
    }
    for (int i = insertPoi; i < nums.length; i++) {
        nums[i] = 0;
    }
}


Valid BST (valid binary search tree) 
// Use inorder traverse the tree,
// if this.val <= previous.val, invalid
class Valid {
    public boolean validBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> inorder = new Stack<>();
        int previous = 0;
        boolean first = true;
        toLeft(inorder, root);
        while (!inorder.isEmpty()) {
            TreeNode curNode = inorder.pop();
            if (first) {
                first = false;
            }
            else if (previous >= curNode.val) {
                return false;
            }
            previous = curNode.val;
            if (curNode.right != null) {
                toLeft(inorder, curNode.right);
            }
        }
        return true;
    }

    private void toLeft(Stack<TreeNode> inorder, TreeNode root) {
        while (root != null) {
            inorder.push(root);
            root = root.left;
        }
    }


    TreeNode prev = null;
    public boolean recursiveWay(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && !recursiveWay(root.left)) {
            return false;
        }
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        if (root.right != null && !recursiveWay(root.right)) {
            return false;
        }
        return true;
    }

}


42. 貌似一个ABC，考了merge k sorted linked list
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=199232&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode fakeHead = new ListNode(0);
        ListNode mover = fakeHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new ComparatorImp());
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            pq.add(node);
        }
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            mover.next = temp;
            mover = mover.next;
            if (temp.next != null) {
                pq.add(temp.next);
            }
            mover.next = null;
        }
        return fakeHead.next;
    }
}
class ComparatorImp implements Comparator<ListNode> {
    @Override
    public int compare(ListNode node1, ListNode node2) {
        return node1.val - node2.val;
    }
}

43. 题目是给定一个list of sorted integer arrays，要求找所有的数的median
e.g. [1,3,6,7,9], [2,4,8], [5], return 5
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=193898&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

// Use a min Head which is priorityQueue to pop out the minimum number
// each time pop one, counter plus one util counter equals to the totalNumber / 2
'Time complexity: O(nlgK) -- lgk for sort in the priotiyqueue and pop out n /2 times, space complexity: O(k)'
class MedianOfKSorted {
    public double findMedian(List<double[]> input) {
        PriorityQueue<Number> minNumber = new PriorityQueue<>(input.size(), new Comparator<Number>() {
            @Override
            public int compare(Number num1, Number num2) {
                if (num1.value > num2.value) {
                    return 1;
                }
                return -1;
            }
        });
        int total = 0;
        for (int i = 0; i < input.size(); i++) {
            minNumber.add(new Number(input.get(i)[0], i, 0));
            total += input.get(i).length;
        }
        double median = 0;
        double previous = 0;
        int count = 0;
        while (count <= total / 2) {
            Number min = minNumber.poll();
            count++;
            previous = median;
            median = min.value;
            if (input.get(min.arrayIndex).length - 1 > min.index ) {
                minNumber.add(new Number(input.get(min.arrayIndex)[min.index + 1], min.arrayIndex, min.index + 1));
            }
        }
        if (total % 2 == 0) {
            return (previous + median) / 2.0;
        }
        return median;
    }

    class Number {
        double value;
        int arrayIndex;
        int index;
        public Number(double value, int arrayIndex, int index) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.index = index;
        }
    }
}


44. leetcode merge intervals

// Sort the intervals by the start time
// Traverse from the head to end
// If the current interval's end time is bigger or euqals to the next start time
// Then merger, new end time is the max(cur.end, next.end)
// else put this interval into result

public List<Interval> merge(List<Interval> intervals) {
    Collections.sort(intervals, new Comparator<Interval>() {
       @Override
       public int compare(Interval inter1, Interval inter2) {
           return inter1.start - inter2.start;
       }
    });
    List<Interval> result = new ArrayList<>();
    if (intervals.size() == 0) {
        return result;
    }
    Interval cur = new Interval(intervals.get(0).start, intervals.get(0).end);
    for (int i = 1; i < intervals.size(); i++) {
        Interval interval = intervals.get(i);
        if (interval.start <= cur.end) {
            cur.end = Math.max(cur.end, interval.end);
        }
        else {
            result.add(new Interval(cur.start, cur.end));
            cur.start = interval.start;
            cur.end = interval.end;
        }
    }
    result.add(cur);
    return result;
}

45. merge Interval from sorted arrays
// Use minHeap to poll out the interval with smallest start time
// Check if it has next interval to push into heap in its list
// Then check heap.peek(), which should always with the smallest start time
// check if heap.peek().start <= curInterval.end
// Then we need to merge. poll out this interval and merge
// curInterval.end = Math.max(curInterval.end, heap.peek().end)
// Keep doing the operation above util heap.peek().start > curInterval.end
// Add curInterval to result.
'Time complexity: O(nlgk) -- k lists of interval, total number of interval is n
 Space complexity: O(k) -- space of min heap'
class MergeKthSortedIntervals {
    public List<Interval> merge(Interval[][] intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals.length == 0) {
            return result;
        }
        PriorityQueue<IntervalContainer> minInterval = new PriorityQueue<>(intervals.length, new Comparator<IntervalContainer>() {
            @Override
            public int compare(IntervalContainer inter1, IntervalContainer inter2) {
                return inter1.interval.start - inter2.interval.start;
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i].length > 0) {
                minInterval.add(new IntervalContainer(intervals[i][0], 0, i));
            }
        }
        while (!minInterval.isEmpty()) {
            IntervalContainer curContainer = minInterval.poll();
            addNextToMinInterval(minInterval, curContainer, intervals);
            while (!minInterval.isEmpty() && minInterval.peek().interval.start <= curContainer.interval.end) {
                IntervalContainer nextContainer = minInterval.poll();
                addNextToMinInterval(minInterval, nextContainer, intervals);
                curContainer.interval.end = Math.max(curContainer.interval.end, nextContainer.interval.end);
            }
            result.add(new Interval(curContainer.interval.start, curContainer.interval.end));
        }
        return result;
    }
    private void addNextToMinInterval(PriorityQueue<IntervalContainer> minInterval, IntervalContainer container, Interval[][] intervals) {
        if (intervals[container.listIndex].length - 1 > container.index) {
            minInterval.add(
                    new IntervalContainer(
                            intervals[container.listIndex][container.index + 1],
                            container.index + 1,
                            container.listIndex));
        }
    }

}

class IntervalContainer {
    public Interval interval;
    public int index;
    public int listIndex;
    public IntervalContainer(Interval interval, int index, int listIndex) {
        this.interval = interval;
        this.index = index;
        this.listIndex = listIndex;
    }
}

class Interval {
    public int start;
    public int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}



46.
	LC search in rotated array, 写了两个binary search的版本，面试官提醒可以一个binary search搞定，然后没时间改了

# Search in rotated array 
// one binary search
// every time we doing binary search, we should make a judgement that
// which sorted part the nums[mid] belongs to
// Then find that if target in this range, if yes, goes in to this range
// else goes to another half

public int search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        else if (nums[start] <= nums[mid]) { // start - mid is sorted
            if (target < nums[mid] && target >= nums[start]) { // if target is between start - mid
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        else { // else mid - end is sorted
            if (target > nums[mid] && target <= nums[end]) { // if target is between mid - end
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
    }
    return -1;
}


47. 老外面试官，给一个String, 如AABACCDCD, 插入'_'使同一个字母间隔为k: 如果k=3: A___AB__AC___CD__CD, 一开始理解有误，认为是要先shuffle字母顺序然后插入'_'，花了不少时间，然后面试官提示字母顺序不变，写出来，然后直接run出来有bug，在coderpad上调了一会才通过
(arrange missions)
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=193411&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

class ArrangeMissions {
    public String arrange(String input, int k) {
        if (input.length() <= 1) {
            return input;
        }
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> missionToTime = new HashMap<>();
        int time = 0;
        char[] missions = input.toCharArray();
        for (int i = 0; i < missions.length; i++) {
            time++;
            if (!missionToTime.containsKey(missions[i]) || time - missionToTime.get(missions[i]) > k) {
                missionToTime.put(missions[i], time);
            }
            else {
                int gap = k - (time - missionToTime.get(missions[i]) - 1);
                while (gap > 0) {
                    result.append('_');
                    gap--;
                }
                time = k + missionToTime.get(missions[i]) + 1;
                missionToTime.put(missions[i], time);
            }
            result.append(missions[i]);
        }
        return result.toString();
    }
}


48. print binary tree vertical

// use a hashmap to record the column
'Time complexity: O(n) - n nodes, Space complexity: O(n)' 
public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
        return result;
    }
    HashMap<Integer, List<Integer>> colToVertical = new HashMap<>();
    HashMap<TreeNode, Integer> nodeToCol = new HashMap<>();
    Queue<TreeNode> level = new LinkedList<>();
    int mostLeft = 0;
    level.offer(root);
    nodeToCol.put(root, 0);
    while (!level.isEmpty()) {
        TreeNode node = level.poll();
        int curCol = nodeToCol.get(node);
        mostLeft = Math.min(mostLeft, curCol);
        if (!colToVertical.containsKey(curCol)) {
            colToVertical.put(curCol, new ArrayList<Integer>());
        }
        colToVertical.get(curCol).add(node.val);
        if (node.left != null) {
            level.offer(node.left);
            nodeToCol.put(node.left, curCol - 1);
        }
        if (node.right != null) {
            level.offer(node.right);
            nodeToCol.put(node.right, curCol + 1);
        }
    }
    while (colToVertical.containsKey(mostLeft)) {
        result.add(colToVertical.get(mostLeft++));
    }
    return result;
}

// No hashMap
private void explore(TreeNode root, List<List<Integer>> result) {
    if (root == null) {
        return;
    }
    List<List<Integer>> pos = new ArrayList<>();
    List<List<Integer>> neg = new ArrayList<>();
    Queue<Pair> level = new LinkedList<>();
    level.offer(new Pair(root, 0));
    while (!level.isEmpty()) {
        Pair pair = level.poll();
        TreeNode node = pair.node;
        if (pair.index >= 0) {
            insert(pos, pair.index, node);
        }
        else {
            insert(neg, -pair.index - 1, node);
        }
        if (node.left != null) {
            level.offer(new Pair(node.left, pair.index - 1));
        }
        if (node.right != null) {
            level.offer(new Pair(node.right, pair.index + 1));
        }
    }
    for (int i = neg.size() - 1; i >= 0; i--) {
        result.add(neg.get(i));
    }
    result.addAll(pos);
}

private void insert(List<List<Integer>> list, int index, TreeNode node) {
    if (index == list.size()) {
        list.add(new ArrayList<Integer>());
    }
    list.get(index).add(node.val);
}
class Pair {
    TreeNode node;
    int index;
    public Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

49. 找出两个给出两个string, leetcode, codyabc和一个数字k = 3,问两个string里面存不存在连续的common substring大于等于k.比如这个例子，两个string都有cod,所以返回true。楼主用dp建了一个m*n的table秒了，然后写test case,发现有个小corner case,改了,pass

// Use a 2d array to record the length, and array[indexA][indexB] means that if 
// A.charAt(indexA) == B.charAt(indexB) the length of substring that ends with A.charAt(indexA)
// else it is 0
// So when we traverse the array, if A.charAt(indexA) == B.charAt(indexB)
// Then array[indexA][indexB] = array[indexA - 1][indexB - 1] + 1

class hasCommonSubstring {
    public boolean hasCommonThanK(String A, String B, int k) {
        if (k <= 1) {
            return true;
        }
        int[][] common = new int[A.length() + 1][B.length() + 1];
        for (int indexA = 1; indexA <= A.length(); indexA++) {
            for (int indexB = 1; indexB <= B.length(); indexB++) {
                if (A.charAt(indexA - 1) == B.charAt(indexB - 1)) {
                    common[indexA][indexB] = common[indexA - 1][indexB - 1] + 1;
                }
                if (common[indexA][indexB] >= k) {
                    return true;
                }
            }
        }
        return false;
    }
}


50. LCA in BST.输入是两个value,不是node.瞬秒，无bug. Follow up是统计问题，如果这两个值是随机从这颗树里面sample,问我的算法平均需要几次比较就可以得出结果
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=176941&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

#LCA BST lowest common Ancester binary Search Tree
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root.val > Math.max(p.val, q.val)) {
        return lowestCommonAncestor(root.left, p, q);
    }
    else if (root.val < Math.min(p.val, q.val)) {
        return lowestCommonAncestor(root.right, p, q);
    }
    return root;
}


51. 
Phone: Leetcode原题。 Add and search word和Minimum window substring
Onsite:
1 二叉树转化成环状Doubly LinkedList
2 颜色排序(LC75)
3 最小公共祖先(LC236)
4 全排列（LC47)
5 在一串带左右括号的string中去掉最少的括号，使括号匹配。例子: )(abc)( -> (abc)

FB很多Behavior，大家多准备most interesting project还有teamwork experience之类的
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=191198&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

#Add and search word
// Use trie tree to do this
'Time complexity: Add - O(len(word)) search: O(len(word)), space complexity: O(number of words * averageLen(word))'
public class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode mover = root;
        for (char letter : word.toCharArray()) {
            int index = letter - 'a';
            if (mover.children[index] == null) {
                mover.children[index] = new TrieNode();
            }
            mover = mover.children[index];
        }
        mover.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return helper(word, root);        
    }
    
    private boolean helper(String word, TrieNode root) {
        TrieNode mover = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (letter == '.') {
                boolean result = false;
                for (TrieNode node : mover.children) {
                    if (node != null) {
                        result = result || helper(word.substring(i + 1), node);
                    }
                }
                return result;
            }
            else {
                if (mover.children[letter - 'a'] != null) {
                    mover = mover.children[letter - 'a'];
                }
                else {
                    return false;
                }
            }
        }
        return mover.isEnd;
    }
    
    class TrieNode {
        public TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
}

# BST to Linked list(binary tree,double linked list, BT)
'''Time complexity O(nlgn)'''
public static TreeNode Tree2LinkedList(TreeNode root) {
	if (root == null) {
		return root;
	}
	Connect(root);
	TreeNode head = root;
	TreeNode tail = root;
	while (head.left != null) {
		head = head.left;
	}
	while (tail.right != null) {
		tail = tail.right;
	}
	head.left = tail;
	tail.right = head;
	return head;
}
private static void Connect(TreeNode root) {
	if (root == null) {
		return;
	}
	if (root.left != null) {
		TreeNode left = root.left;
		Connect(left);
		while (left.right != null) {
			left = left.right;
		}
		left.right = root;
		root.left = left;
	}
	if (root.right != null) {
		TreeNode right =root.right;
		Connect(right);
		while (right.left != null) {
			right = right.left;
		}
		right.left = root;
		root.right = right;
	}
}

// ----------------------------------------------------------
Minimum Window substring
"Input two String"
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> letterToCount = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int fast = 0;
        int slow = 0;
        int start = 0;
        int letterCount = 0;
        char[] sLetter = s.toCharArray();
        for (char letter : t.toCharArray()) {
            if (letterToCount.containsKey(letter)) {
                letterToCount.put(letter, letterToCount.get(letter) + 1);
            }
            else {
                letterToCount.put(letter, 1);
            }
        }
        while (fast < s.length()) {
            if (letterToCount.containsKey(sLetter[fast])) {
                if (window.containsKey(sLetter[fast])) {
                    window.put(sLetter[fast], window.get(sLetter[fast]) + 1);
                }
                else {
                    window.put(sLetter[fast], 1);
                }
                if (window.get(sLetter[fast]) <= letterToCount.get(sLetter[fast])) {
                    letterCount++;
                }
            }
            if (letterCount == t.length()) {
                while (!letterToCount.containsKey(sLetter[slow]) ||
                        window.get(sLetter[slow]) > letterToCount.get(sLetter[slow])) {
                    if (window.containsKey(sLetter[slow])) {
                        window.put(sLetter[slow], window.get(sLetter[slow]) - 1);
                    }    
                    slow++;
                }
                if (minLen > fast - slow + 1) {
                    minLen = fast - slow + 1;
                    start = slow;
                }
                window.put(sLetter[slow], window.get(sLetter[slow]) - 1);
                letterCount--;
                slow++;
            }
            fast++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

"Input as Set"
public String miniWindow(String input, Set<Character> dict) {
        HashMap<Character, Integer> window = new HashMap<>();
        int fast = 0;
        int slow = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        char[] letters = input.toCharArray();
        while (fast < input.length()) {
            if (dict.contains(letters[fast])) {
                if (window.containsKey(letters[fast])) {
                    window.put(letters[fast], window.get(letters[fast]) + 1);
                }
                else {
                    window.put(letters[fast], 1);
                }
            }
            if (window.size() == dict.size()) {
                while (!dict.contains(letters[slow]) || window.get(letters[slow]) > 1) {
                    if (window.containsKey(letters[slow])) {
                        window.put(letters[slow], window.get(letters[slow]) - 1);
                    }
                    slow++;
                }
                if (minLen > fast - slow + 1) {
                    minLen = fast - slow + 1;
                    start = slow;
                }
                window.put(letters[slow], window.get(letters[slow]) - 1);
                if (window.get(letters[slow]) == 0) {
                    window.remove(letters[slow]);
                }
                slow++;
            }
            fast++;
        }
        return minLen == Integer.MAX_VALUE ? "" : input.substring(start, start + minLen);
    }
// --------------------------------------------------------------------

public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    findPermutation(result, new ArrayList<Integer>(), new HashSet<Integer>(), nums);
    return result;
}

private void findPermutation(List<List<Integer>> result, List<Integer> permutation, Set<Integer> visited, int[] nums) {
    if (permutation.size() == nums.length) {
        result.add(new ArrayList<Integer>(permutation));
        return;
    }
    for (int i = 0; i < nums.length; i++) {
        if (visited.contains(i) || (i != 0 && nums[i] == nums[i - 1] && !visited.contains(i - 1))) {
            continue;
        }
        permutation.add(nums[i]);
        visited.add(i);
        findPermutation(result, permutation, visited, nums);
        permutation.remove(permutation.size() - 1);
        visited.remove(i);
    }
}

53. LC上的同类题型91(#6 nearest kth point)

54. LC上的同类题型173和252
public class BSTIterator {
    Stack<TreeNode> inorder = new Stack<>();
    public BSTIterator(TreeNode root) {
        toLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !inorder.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = inorder.pop();
        if (node.right != null) {
            toLeft(node.right);
        }
        return node.val;
    }
    
    private void toLeft(TreeNode root) {
        while (root != null) {
            inorder.push(root);
            root = root.left;
        }
    }
}

public boolean canAttendMeetings(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>(){
       @Override
       public int compare(Interval inter1, Interval inter2) {
           return inter1.start - inter2.start;
       }
    });
    for (int i = 0; i < intervals.length - 1; i++) {
        if (intervals[i].end > intervals[i + 1].start) {
            return false;
        }
    }
    return true;
}

55. LC上的同类题型76和43
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=197884&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

#multiple String
// 		123
//  *	 23
// ---------
// 		369
//     246
//     2829
// digits[i + j + 1] = number1[i] * number2[j]
// Then add up with carry : digit: digits[i] + carry % 10
// 							carry = digits[i] + carry / 10
class MultipleString {
    public String multipleString(String number1, String number2) {
        int[] digits = new int[number1.length() + number2.length()];
        for (int i = number1.length() - 1; i >= 0; i--) {
            for (int j = number2.length() - 1; j >= 0; j--) {
                int digit1 = Integer.parseInt(number1.substring(i, i + 1));
                int digit2 = Integer.parseInt(number2.substring(j, j + 1));
                digits[i + j + 1] += digit1 * digit2;
            }
        }
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int number = digits[i] + carry;
            int digit = number % 10;
            carry = number / 10;
            result.append(digit);
        }
        result = result.reverse();
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        if (result.length() == 0) {
            return "0";
        }
        return result.toString();
    }
}

56. design 常见 http://www.1point3acres.com/bbs/thread-191077-1-1.html

57. 
# Tasks: 1, 1, 2, 1. 
# Recovery interva (cooldown): 2
# Output: 7  (order is 1 _ _ 1 2 _ 1). 

# Example 2

# Tasks: 1, 2, 3, 1, 2, 3
# Recovery interval (cooldown): 3
# Output: 7  (order is 1 2 3 _ 1 2 3)

# Example 3

# Tasks: 1, 2, 3 ,4, 5, 6, 2, 4, 6, 1, 2, 4
# Recovery interval (cooldown): 6
# Output: 18  (1 2 3 4 5 6 _ _ 2 _ 4 _ 6 1 _ 2 _ 4)
*/ 
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=188881&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311


60. move zeros 
follow up： 如果只需要把非0的数移到左边，而不care右边是什么数要怎么做。举例 2，0，0，1，3，0，5，输出2，1，3，5，*，*，*，随便*输出什么都可以。



61. 给一个partial sorted的数组比如1，3，5，2，4，6，8，10，20，30，11，12，13，数组有N个数，分为M个segment，N>>>M，要求输出排序后的数组。第一反应就是merge k sorted list，按照那个写了下，问了问time 和space 的complexity
merge k list(use M pointer to record the position of the begin of the sorted segment)
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192644&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

// Use a class Number to record the cur number and index and end index of a segment
// For instance, we have {1, 3, 9, 2, 6, 8}
// Then we have a Number(value = 1, index = 0, endIndex = 2) and Number(value = 2, index = 3, endIndex = 5)
// Traverse through the array find the start and end of every segment
// store the start number of every segment into a min heap.
// So every time we use heap, which pop out the samllest number, and we check its index
// if the index is samller than the endIndex, which means this segment is not over, we 
// need to put the next number of the segment into heap.
'Time complexity: O(nlgm) -n is the number of numbers in array -m is the number of segment
 Space complexity: O(n)'

class SortPartialSortedArray {
    public int[] sortArray(int[] input) {
        if (input.length == 0) {
            return new int[]{};
        }
        int[] sortedResult = new int[input.length];
        int mover = 0;
        int start = 0;
        PriorityQueue<Number> minNumber = new PriorityQueue<>(new Comparator<Number>() {
            @Override
            public int compare(Number num1, Number num2) {
                return num1.value - num2.value;
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (i > 0 && input[i] < input[i - 1]) {
                minNumber.add(new Number(input[start], start, i - 1));
                start = i;
            }
        }
        minNumber.add(new Number(input[start], start, input.length - 1));
        while (!minNumber.isEmpty()) {
            Number min = minNumber.poll();
            sortedResult[mover++] = min.value;
            if (min.index < min.endIndex) {
                minNumber.add(new Number(input[min.index + 1], min.index + 1, min.endIndex));
            }
        }
        return sortedResult;
    }

    class Number {
        int value;
        int index;
        int endIndex;
        public Number(int value, int index, int endIndex) {
            this.value = value;
            this.index = index;
            this.endIndex = endIndex;
        }
    }
}



62. 
1. LC 191 Number of 1 Bits.
2. 给2D平面上的N个点，求离原点最近的K个点

#Number of One Bits(bit, number of 1)
// x & (x - 1) helps to remove the right most 1 of the x
'time complexity: O(k)-- k is the number of 1 bit in x, Space complexity: O(1)'
class NumberOfOneBits {
    public int numberOfOnrBits(int input) {
        int count = 0;
        while (input != 0) {
            input = input & (input - 1);
            count++;
        }
        return count;
    }
}

63. 有一个数组，里面有0和非0元素，要求把所有非0元素移动到数组的前端，并返回非0元素的个数，非零元素顺序随意。非零元素之后数组有什么我们不关心。要求最小化写入次数。
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192313&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

#Move zero no order(Zeros no order)
// Use two pointer, left always find 0, right always find non-zero
// then make input[left] = input[right]
// After left and rigt meet.
// If input[left] == 0, which means input[left - 1] is the last non-zero number, return left
// If input[left] != 0, and if left == right, which means input[left] is the last non-zero number
// because left and right meet by a change, so return left + 1
// Else left > right, which mean they just make a change which makes left > right. So 
// input[left - 1] is last non-zero number, return left 
public int moveZeroNoOrder(int[] input) {
    int left= 0;
    int right = input.length - 1;
    while (left < right) {
        while (left < right && input[left] != 0) {
            left++;
        }
        while (left < right && input[right] == 0) {
            right--;
        }
        if (left != right) {
            input[left] = input[right];
            left++;
            right--;
        }
    }
    if (input[left] == 0 || left > right) {
        return left;
    }
    return left + 1;
}

64. Word break by DP

// helper[i] means that we can break the string.substring(0, j) exclusive j
'Time complexity: O(n^2), space complexity: O(n)'
public boolean wordBreak(String s, Set<String> wordDict) {
    boolean[] helper = new boolean[s.length() + 1];
    helper[0] = true;
    for (int i = 1; i <= s.length(); i++) {
        for (int j = i - 1; j >= 0; j--) {
            if (helper[j] && wordDict.contains(s.substring(j, i))) {
                helper[i] = true;
                break;
            }
        }
    }
    return helper[s.length()];
}

Output only one result
// Use DFS
'Time complexity: O(2^(n/k))'
class WordBreak {
    public String wordBreak(Set<String> dict, String input) {
        List<String> path = new ArrayList<>();
        helper(path, dict, input, 0);
        StringBuilder result = new StringBuilder();
        for (String word : path) {
            result.append(word + " ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private boolean helper(List<String> path, Set<String> dict, String input, int index) {
        if (index == input.length()) {
            return true;
        }
        for (int i = index; i < input.length(); i++) {
            String word = input.substring(index, i + 1);
            if (dict.contains(word)) {
                path.add(word);
                if (helper(path, dict, input, i + 1)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
}

66. 2Sum
class TwoSum {
    public List<List<Integer>> twoSumIndex(int[] input, int target) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> valueToIndex = new HashMap<>();
        Set<List<Integer>> visited = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            if (!valueToIndex.containsKey(input[i])) {
                valueToIndex.put(input[i], new ArrayList<Integer>());
            }
            valueToIndex.get(input[i]).add(i);
        }
        for (int i = 0; i < input.length; i++) {
            if (valueToIndex.containsKey(target - input[i])) {
                for (int index : valueToIndex.get(target - input[i])) {
                    if (index > i) {
                        List<Integer> pair = new ArrayList<>(Arrays.asList(i, index));
                        if (!visited.contains(pair)) {
                            visited.add(pair);
                            result.add(pair);
                        }
                    }
                }
            }
        }
        return result;
    }
    public List<List<Integer>> twoSumValue(int[] input, int target) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> valueToIndex = new HashMap<>();
        Set<List<Integer>> visited = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            if (!valueToIndex.containsKey(input[i])) {
                valueToIndex.put(input[i], new ArrayList<Integer>());
            }
            valueToIndex.get(input[i]).add(i);
        }
        for (int i = 0; i < input.length; i++) {
            if (valueToIndex.containsKey(target - input[i])) {
                int idx = -1;
                for (int index : valueToIndex.get(target - input[i])) {
                    if (index != i) {
                        idx = index;
                        break;
                    }
                }
                if (idx != -1) {
                    List<Integer> pair = new ArrayList<>(Arrays.asList(input[i], input[idx]));
                    Collections.sort(pair);
                    if (!visited.contains(pair)) {
                        result.add(pair);
                        visited.add(pair);
                    }
                }

            }
        }
        return result;
    }
    public List<List<Integer>> twoSumSort(int[] input, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(input);
        int left = 0;
        int right = input.length - 1;
        while (left < right) {
            if (input[left] + input[right] > target) {
                right--;
            }
            else if (input[left] + input[right] < target) {
                left++;
            }
            else {
                result.add(new ArrayList<Integer>(Arrays.asList(input[left], input[right])));
                left++;
                right--;
                while (left < input.length && input[left] == input[left - 1]) {
                    left++;
                }
                while (right >= 0 && input[right] == input[right + 1]) {
                    right--;
                }
            }
        }
        return result;
    }
}


68. 
 LC138 Copy linked list with random pointers. 要求优化到不用extra space。. from: 1point3acres.com/bbs 
 LC75 Sort colors, Group contact
 Behavioral + LC71 Simplify path这题要问清楚要做什么.
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192116&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

#copy linked List with random pointer
public RandomListNode copyRandomList(RandomListNode head) {
    RandomListNode mover = head;
    while (mover != null) {
        RandomListNode copy = new RandomListNode(mover.label);
        RandomListNode next = mover.next;
        mover.next = copy;
        copy.next = next;
        mover = copy.next;
    }
    RandomListNode fakeHead = new RandomListNode(0);
    RandomListNode copyMover = fakeHead;
    mover = head;
    while (mover != null) {
        if (mover.random != null) {
            mover.next.random = mover.random.next;
        }
        mover = mover.next.next;
    }
    mover = head;
    while (mover != null) {
        copyMover.next = mover.next;
        mover.next = mover.next.next;
        mover = mover.next;
        copyMover = copyMover.next;
    }
    return fakeHead.next;
}

#Simplify path
public String simplifyPath(String path) {
   Stack<String> validPath = new Stack<>();
   Set<String> special = new HashSet<>(Arrays.asList("..", ".", ""));
   String[] directories = path.split("/");
   for (String directory : directories) {
       if (directory.equals("..") && !validPath.isEmpty()) {
           validPath.pop();
       }
       else if (!special.contains(directory)) {
           validPath.push(directory);
       }
   }
   StringBuilder result = new StringBuilder();
   while (!validPath.isEmpty()) {
       result.insert(0, "/" + validPath.pop());
   }
   if (result.length() == 0) {
       return "/";
   }
   return result.toString();
}


69. 字母和数字的转换 A = 1 B = 2 AA = 27 基本是26进制的转换， 他要我写了两个边的转换。 我写出来了不过最后我用的是
(char)('a'-1+i) 的方式来转换字母的，不过我用的是i%26，也就是z的时候会变成(char)(-1)。
#letter to number, excel
public int titleToNumber(String s) {
    int result = 0;
    for (char letter : s.toCharArray()) {
        result = result * 26 + letter - 'A' + 1;
    }
    return result;
}

public String convertToTitle(int n) {
    StringBuilder result = new StringBuilder();
    while (n > 0) {
        char letter = (char)((n - 1) % 26 + 'A');
        result.append(letter);
        n = (n - 1) / 26;
    }
    return result.reverse().toString();
}


70. 
找小偷问题，有n个房间，其中一个房间有小偷。早上我们可以打开一个房间的门看小偷在不在里面，晚
上小偷会向左边或者右边的房间走。现在给你一个开门的sequence，你输出这个sequence能不能保证找到小偷。 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
比如：如果只有三个房间那么如果打开房间的sequence是{1，1}那么一定会找到小偷。因为如果小偷在中间那么第一天就会被找到，. visit 1point3acres.com for more.
如果小偷在两边那么第二天一定回来到中间也会被找到。房间数为n，sequence长度为k. 鍥磋鎴戜滑@1point 3 acres
跟着我开始brute force假设小偷在某个房间然后dfs所有路径，大概是O（n*n^k）。 考官说好，如果考虑cut branch呢？跟着我就说可以
拿一个n*k的matrix跟着根据sequence来cut branch，reduce到O（n*n*k）。他说有没有可能同时从所有房间开始呢？我说可以跟着直接
在那个n*kmatrix上做一个类似dp的东西。跟着reduce 到 O（n*k）。他说有没有可能把space reduce呢？我说可以我只要O（n）的space
跟着他就让我再写一个叫nextRow的function来实现O（n）space。 我觉得这题我基本是答得非常漂亮的而且思路很清晰，考官也很开心。

class FindTheaf {
    public boolean findTheaf(int rooms, int[] strategy) {
        boolean[] found = new boolean[rooms];
        found[strategy[0]] = true;
        for (int day = 1; day < strategy.length; day++) {
            boolean[] lastDay = Arrays.copyOf(found, rooms);
            for (int room = 0; room < rooms; room++) {
                if (room == 0) {
                    found[room] = lastDay[room + 1];
                }
                else if (room == rooms - 1) {
                    found[room] = lastDay[room - 1];
                }
                else {
                    found[room] = lastDay[room - 1] || lastDay[room + 1];
                }
            }
            found[strategy[day]] = true;
        }
        boolean result = true;
        for (int i = 0; i < rooms; i++) {
            result = result && found[i];
        }
        return result;
    }
}


71. word ladder变型，叫我随便找一个可以的path出来，基本我写的每一步她都要我说这样写的理由，跟着做笔记。我用dfs+hashset写完之后，
被她发现了一个bug，就是在找到path之后我没有完全return导致答案没有了最后一个word，跟着我马上改了。之后她问我能不能cut branch
我看不出来。。。。她提示其实放进hashset的可以不再remove，因为如果走过一个word发现这个word不行那么以后就没有必要再走这个word了。
跟着问我如果word可以从abc变道abcd 就是变一个或者加一个letter我应该怎么改。我就说加点东西就好，跟着就写出来了。跟着这轮就大概没了。
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=109284&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

class WordLadder {
    public List<String> findLadder(String start, String end, Set<String> dict) {
        Queue<String> explore = new LinkedList<>();
        HashMap<String, String> path = new HashMap<>();
        List<String> result = new ArrayList<>();
        explore.offer(start);
        path.put(start, "");
        boolean found = false;
        while (!explore.isEmpty() && !found) {
            String word = explore.poll();
            for (int i = 0; i < word.length(); i++) {
                for (char k = 'a'; k <= 'z'; k++) {
                    if (word.charAt(i) == k) {
                        continue;
                    }
                    String newWord = word.substring(0, i) + k + word.substring(i + 1);
                    if (newWord.equals(end)) {
                        path.put(end, word);
                        found = true;
                        break;
                    }
                    if (dict.contains(newWord) && !path.containsKey(newWord)) {
                        path.put(newWord, word);
                        explore.offer(newWord);
                    }
                }
            }
        }
        if (!path.containsKey(end)) {
            return result;
        }
        String mover = end;
        while (!path.get(mover).equals("")) {
            result.add(0, mover);
            mover = path.get(mover);
        }
        result.add(0, start);
        return result;
    }
}

72. 自然string comparator。不知道的搜下。就是string 比较的时候考虑里面数字的大小，比如 abc9 < abc123 abc > ab9  因为char比digit重要。
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=179527&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

class CompareString implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < str1.length() && index2 < str2.length()) {
            char letter1 = str1.charAt(index1);
            char letter2 = str2.charAt(index2);
            if (letter1 == letter2 &&  !Character.isDigit(letter2)) { // both are char and equals
                index1++;
                index2++;
            }
            else if (Character.isDigit(letter1) && Character.isDigit(letter2)){ //both are number
                int number1 = 0;
                int number2 = 0;
                while (index1 < str1.length() && Character.isDigit(str1.charAt(index1))) {
                    number1 = number1 * 10 + str1.charAt(index1) - '0';
                    index1++;
                }
                while (index2 < str2.length() && Character.isDigit(str2.charAt(index2))) {
                    number2 = number2 * 10 + str2.charAt(index2) - '0';
                    index2++;
                }
                if (number1 > number2) {
                    return 1;
                }
                else if (number1 < number2) {
                    return -1;
                }
            }
            else { // not equals or one is number
                if (Character.isDigit(letter2)) {
                    return 1;
                }
                else if (Character.isDigit(letter1)) {
                    return -1;
                }
                if (letter1 > letter2) {
                    return 1;
                }
                return -1;
            }
        }
        if (index1 == str1.length() && index2 == str2.length()) { //check all the char already
            return 0;
        }
        else if (index1 < str1.length()) {
            return 1;
        }
        return -1;
    }
}


74. 第一题lc弱智题，合并两个有序数组，很简单，lz第一次店面写代码，有点紧张，居然用了接近14分钟才写完。面试官看了会儿，说looks good，时间复杂度也没问，就直接出下一题。

75. merge K sort array

76. 因为他问第三题的时候只是嘴上说如果给的不是lists，而是每个list的iterator，how do you modify your code? 
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=190561&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
#Merge Lists
class Merge {
    public List<Integer> mergeTwoList(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < list1.size() && index2 < list2.size()) {
            int number1 = list1.get(index1);
            int number2 = list2.get(index2);
            if (number1 <= number2) {
                result.add(number1);
                index1++;
            }
            else {
                result.add(number2);
                index2++;
            }
        }
        while (index1 < list1.size()) {
            result.add(list1.get(index1++));
        }
        while (index2 < list2.size()) {
            result.add(list2.get(index2++));
        }
        return result;
    }

    public List<Integer> mergeKList(List<List<Integer>> input) {
        PriorityQueue<Number> minNumber = new PriorityQueue<>(input.size(), new Comparator<Number>() {
            @Override
            public int compare(Number num1, Number num2) {
                return num1.value - num2.value;
            }
        });
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).size() == 0) {
                continue;
            }
            minNumber.add(new Number(input.get(i).get(0), 0, i));
        }
        while (!minNumber.isEmpty()) {
            Number min = minNumber.poll();
            result.add(min.value);
            if (min.index < input.get(min.listIndex).size() - 1) {
                minNumber.add(new Number(input.get(min.listIndex).get(min.index + 1), min.index + 1, min.listIndex));
            }
        }
        return result;

    }

    class Number {
        int value;
        int index;
        int listIndex;
        public Number(int value, int index, int listIndex) {
            this.value = value;
            this.index = index;
            this.listIndex = listIndex;
        }
    }

    public List<Integer> mergeKListWithIterator(List<Iterator<Integer>> input) {
        PriorityQueue<Number> minNumber = new PriorityQueue<>(input.size(), new Comparator<Number>() {
            @Override
            public int compare(Number num1, Number num2) {
                return num1.value - num2.value;
            }
        });
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).hasNext()) {
                minNumber.add(new Number(input.get(i).next(), 0, i));
            }
        }
        while (!minNumber.isEmpty()) {
            Number min = minNumber.poll();
            if (input.get(min.listIndex).hasNext()) {
                minNumber.add(new Number(input.get(min.listIndex).next(), 0, min.listIndex));
            }
            result.add(min.value);
        }
        return result;
    }
}

86. Given k sorted lists of O(n) integers each, implement an iterator that will yield all elements in sorted order。
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=190778&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

class MergeToIterator implements Iterator<Integer>{
    PriorityQueue<Number> minNumber;
    List<List<Integer>> lists;
    public MergeToIterator(List<List<Integer>> input) {
        this.minNumber = new PriorityQueue<>(input.size(), new Comparator<Number>() {
            @Override
            public int compare(Number num1, Number num2) {
                return num1.value - num2.value;
            }
        });
        this.lists = input;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).size() == 0) {
                continue;
            }
            minNumber.add(new Number(input.get(i).get(0), 0, i));
        }
    }

    @Override
    public boolean hasNext() {
        return !minNumber.isEmpty();
    }

    @Override
    public Integer next() {
        Number min = minNumber.poll();
        if (lists.get(min.listIndex).size() - 1 > min.index) {
            minNumber.add(new Number(lists.get(min.listIndex).get(min.index + 1), min.index + 1, min.listIndex));
        }
        return min.value;
    }

    class Number {
        int value;
        int index;
        int listIndex;
        public Number(int value, int index, int listIndex) {
            this.value = value;
            this.index = index;
            this.listIndex = listIndex;
        }
    }
}




77. 1. behavior question。 最后问了道dot product的老题
	2. given a list of words, find whether a given target word exists. Should support “.” which matches any character. Follow up: support “*” which matchs 0 or more characters. 1point3acres.com/bbs
	3. a. Minimum Size Subarray Sum
    b. Check whether a string is Palindrom 
    c. 忘了。。。
	4. Design autocomplete in a search engine. 
	5. behavior question. 最后的coding是给一个数组和一个数N， 随机返回该数组中任意一个不大于N的数。
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=194306&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

Wildcard
class WildCard {
    public boolean compare(String input, String pattern) { //only has '.'
        int poiIn = 0;
        int poiP = 0;
        while (poiIn < input.length() && poiP < pattern.length()) {
            char letter1 = input.charAt(poiIn);
            char letter2 = pattern.charAt(poiP);
            if (letter1 == letter2 || letter2 == '.') {
                poiIn++;
                poiP++;
            }
            else {
                return false;
            }
        }
        return poiIn == input.length() && poiP == pattern.length();
    }

    public boolean wildCard(String input, String pattern) { // has '.' and '*'
        int poiIn = 0;
        int poiP = 0;
        int lastIn = -1;
        int lastP = -1;
        while (poiIn < input.length()) {
            if (poiP < pattern.length() && (input.charAt(poiIn) == pattern.charAt(poiP) || pattern.charAt(poiP) == '.')) {
                poiP++;
                poiIn++;
            }
            else if (poiP < pattern.length() && pattern.charAt(poiP) == '*') {
                lastP = poiP + 1;
                poiP++;
                lastIn = poiIn;
            }
            else if (lastP != -1) {
                lastIn++;
                poiIn = lastIn;
                poiP = lastP;
            }
            else {
                return false;
            }
        }
        while (poiP < pattern.length() && pattern.charAt(poiP) == '*') {
            poiP++;
        }
        return poiP == pattern.length();
    }
}

#minimum size of subarray //only positive number
public int minSubArrayLen(int s, int[] nums) {
    int minLen = Integer.MAX_VALUE;
    int fast = 0;
    int slow = 0;
    int sum = 0;
    while (fast < nums.length) {
        sum += nums[fast];
        while (sum >= s) {
            minLen = Math.min(minLen, fast - slow + 1);
            sum -= nums[slow];
            slow++;
        }
        fast++;
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
}

extends to 2d and find if rectangle sum = k
class FindSubRect {
    public boolean find(int[][] matrix, int target) {
        for (int right = 0; right < matrix[0].length; right++) {
            int[] rowSum = new int[matrix.length];
            for (int left = right; left >= 0; left--) {
                Set<Integer> sum = new HashSet<>();
                int curSum = 0;
                sum.add(0);
                for (int row = 0; row < matrix.length; row++) {
                    rowSum[row] += matrix[row][left];
                    curSum += rowSum[row];
                    if (sum.contains(curSum - target)) {
                        return true;
                    }
                    sum.add(curSum);
                }
            }
        }
        return false;
    }
}


#Maximum size of subarray
// [1, -1, 5, -2, 3] => sum [1, 0, 5, 3, 6]
// Note k = Sum1 - Sum2, which is a subarray
// use hashmap record the sum to index, every time we meet a sum, if sum - k appears in the hashmap
// then there is a subarray sum equals to k. find the length
// if this sum is already in the hashmap, skip it. otherwise put in
// because we always use the index most left, so if a some sum comes later, we dont put it in hashmap
public int maxSubArrayLen(int[] nums, int k) {
    int maxLen = 0;
    HashMap<Integer, Integer> sumToIndex = new HashMap<>();
    sumToIndex.put(0, -1);
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (sumToIndex.containsKey(sum - k)) {
            maxLen = Math.max(maxLen, i - sumToIndex.get(sum - k));
        }
        if (!sumToIndex.containsKey(sum)) {
            sumToIndex.put(sum, i);
        }
    }
    return maxLen;
}


79. 
这个题想不起来具体的例子了，大概是A和B分别代表两个不同的字符串。字符串由A,a,B,b组成。给定一个初始字符串（也是由A,a,B,b组成），遍历这个初始字符串，如果遇到A或B，就用相应的字符串替代，这样就得到一个新字符串，然后对新字符串做替换操作。问替代n次后第k项是什么字母。题目不难，但是不断要求优化，比如新字符串只需要保持size k。这个字符串具体例子很巧妙但记不起来了，会形成一个repreated pattern，最后经面试官提示可以用binary search优化。这个面试官非常nice，好像是个东南亚裔的，基本上一步步给提示。

class Replace {
    public char replace(String A, String B, String input, int n, int k) {
        HashMap<String, Integer> strToIndex = new HashMap<>();
        List<String> path = new ArrayList<>();
        if (input.length() >= k + 1) {
            input = input.substring(0, k + 1);
        }
        strToIndex.put(input, 0);
        path.add(input);
        String last = input;
        int count = 0;
        int circle = 0;
        while (count < n && circle == 0) {
            count++;
            StringBuilder curStr = new StringBuilder();
            for (char letter : last.toCharArray()) {
                if (letter == 'A') {
                    curStr.append(A);
                }
                else if (letter == 'B') {
                    curStr.append(B);
                }
                else {
                    curStr.append(letter);
                }
                if (curStr.length() >= k + 1) {
                    curStr = curStr.delete(k + 1, curStr.length());
                    break;
                }
            }
            last = curStr.toString();
            if (strToIndex.containsKey(last)) {
                circle = count - strToIndex.get(last);
            }
            else {
                strToIndex.put(last, count);
                path.add(last);
            }
        }
        if (count == n) {
            return last.charAt(k);
        }
        int nonCircle = path.size() - circle - 1;
        int index = (n - nonCircle) % circle + nonCircle;
        System.out.println(path);
        if (index == nonCircle) {
            return path.get(path.size() - 1).charAt(k);
        }
        else {
            return path.get(index).charAt(k);
        }
    }
}


设计News feed system， backend的设计或者api设计两者选一。选了backend，虽然能准备的都准备了，但总感觉答的有点乱？大致讲了push/pull model, data怎么存，算算data量，怎么shard, 会问得很细，比如consistent hashing具体算法是怎么实现的，这个没有答上来。

Binary Tree convert to double linked list, 要求最后list首尾相连返回头。应该可以用dfs inorder traversal recursion加上track previous node。

http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=194987&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311


82. 
(1) Contact group, 输入是这样的:数字是用户，字母是邮箱，有很多人有多个邮箱，找出相同的用户
  1- {x,y,z},  
  2-{x} . more info on 1point3acres.com
  3-{a,b}. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
  4-{y, z}
  5-{b}
  6-{m}
  7-{t,b}

这样输出就是 [1,2,4] [3,5,7], [6] 这三组。. 
可以用UnionFind或者Connected Components的方法做，

#Contact group
// Use a hashmap to map the email to person called emailToPerson.
// Use another hashmap to map the person to root, called personToRoot
// the root is a person in this group, everyone in this group will map to this root
// root will map to root itself
// So we traverse through the input,
// When we meet a person, we check the hashmap emailToPerson
// if it does not contains this email, then we map this email to this person
// if it does, which means this email maps to other people. lets call him A
// So we go to check personToRoot, if A maps to another root,
// which means the person we meet should also maps to this root
// then we check aother mails of this person, if other mail maps to another person B
// this person should also maps to B's root, which means A's root should also be B's root,
// So we change A's root's root to B's root(Other people in A's group still point to A's root, but A's root point to B's root)
// For example, 1 - {x, y, z} 2 - {a, b}, 3 - {x} 4 - {x, a}
// first we map x -> 1, y -> 1, z -> 1 and 1 - > 1
// we meet 2, then map a -> 2, b -> 2, and 2 -> 2
// Then meet 3, find out that x -> 1, so 3 -> 1
// Then meet 4, find out that x -> 1, so 4 -> 1
// and find out that a -> 2, so  4's root 1's root should be 2,
// that is 1 -> 2
// in the end we have 1 -> 2, 2 -> 2, 3 -> 1, 4 -> 2
// So the gourp is [1, 2, 3, 4]
'Time complexity: O(nklgn) - n person and k emails in average, 
 findRoot, act like find node in a tree - O(lgn)
 Space complexity: O(nk)'

class Contact {
    public List<List<Integer>> contactGroup(HashMap<Integer, String[]> contact) {
        HashMap<String, Integer> emailToPerson = new HashMap<>();
        HashMap<Integer, Integer> personToRoot = new HashMap<>();
        for (int person : contact.keySet()) {
            personToRoot.put(person, person);
            int curRoot = person;
            for (String email : contact.get(person)) {
                if (!emailToPerson.containsKey(email)) {
                    emailToPerson.put(email, person);
                    continue;
                }
                int newRoot = emailToPerson.get(email);
                newRoot = findRoot(personToRoot, newRoot);
                if (newRoot != curRoot) {
                    personToRoot.put(curRoot, newRoot);
                    curRoot = newRoot;
                }
            }
        }
        HashMap<Integer, List<Integer>> groups = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int person : personToRoot.keySet()) {
            int root = findRoot(personToRoot, person);
            if (!groups.containsKey(root)) {
                groups.put(root, new ArrayList<Integer>());
            }
            groups.get(root).add(person);
        }
        for (int group : groups.keySet()) {
            result.add(groups.get(group));
        }
        return result;
    }
    private int findRoot(HashMap<Integer, Integer> personToRoot, int root) {
        while (personToRoot.get(root) != root) {
            root = personToRoot.get(root);
        }
        return root;
    }
}


（2） Behaviour Questions. 
light coding写了Clone Graph
（3） 单链表反转
大数相乘，写了brute force，跑test case花了太久时间，没来的及写优化，简单聊了聊Divide Conquer的办法

（4）TinyURL，这个题准备到了，后来HR说这一轮答的最惨，MB被烙印黑惨了
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192328&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311




83. first bad version 以及变种。 变种是如果不知道一共有多少版本的情况下应该怎么找。


// Unknow numbr of version

public int badVersion {
    int prev = 0;
    int cur = 0;
    while (isBadVersioin(cur)) {
        prev = cur;
        cur = cur * cur;
    }
    int start = prev;
    int end = cur;
    while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (isBadVersioin(mid)) {
            end = mid;
        }
        else {
            start = mid;
        }
    }
    if (isBadVersioin(start)) {
        return start;
    }
    return end;
}

84. Min Queue, 跟Min Stack类似， 实现一个Queue， 然后O（1）复杂度获得这个Queue里最小的元素。
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=193703&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

#Min Queue
//Use queue to save the minimum number
// Every time add a new number, traverse the queue, remove the number 
// bigger than it, so in the deque there will leave the numbers that smaller than it
// add this number to the end of the deque
// by doing this, the minimum number will always at the head of the deque
'Time complexity of offer : O(len), space complexity: O(n)'

class MinQueue {
    private Queue<Integer> queue = new LinkedList<>();
    private Deque<Integer> min = new ArrayDeque<>();
    public void offer(int val) {
        while (!min.isEmpty() && min.peekLast() > val) {
            min.pollLast();
        }
        queue.offer(val);
        min.offer(val);
    }
    public int poll() {
        int result = queue.poll();
        if (result == min.peek()) {
            min.poll();
        }
        return result;
    }
    public int getMin() {
        return min.peek();
    }
}

85. Tri-node的题
求String B是不是String A的substring
找sorted array中的某个数，用divide & conquer做
一道多个pc之间发送和请求数据的设计题. 
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=193545&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311



87. 第一题：

     3
   /
1         
   \ 
    2
一棵树，返回一个list的头结点：
1《——》2《——》3（一三相连）
意思是返回一个递增list，1的right是2，left是3， 2的left是1，right是3,3的left是2，right是 1.
我用inorder获得递增序列然后设置left与right的node。返回1这个结点。. from: 1point3acres.com/bbs 
follow up如何不先获得序列，直接在traverse的时候获得结果。follow up没回答出来。

Tree To Double linked list:

class TreeToDoubleLinkedList {
    public DoubleLinkedList toDoubleLinkedList(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> inorder = new Stack<>();
        DoubleLinkedList fakeHead = new DoubleLinkedList(0);
        DoubleLinkedList previous = fakeHead;
        toLeft(inorder, root);
        while (!inorder.isEmpty()) {
            TreeNode node = inorder.pop();
            DoubleLinkedList curNode = new DoubleLinkedList(node.val);
            curNode.pre = previous;
            previous.next = curNode;
            previous = curNode;
            if (node.right != null) {
                toLeft(inorder, node.right);
            }
        }
        DoubleLinkedList head = fakeHead.next;
        head.pre = previous;
        previous.next = head;
        return head;
    }

    private void toLeft(Stack<TreeNode> inorder, TreeNode root) {
        while (root != null) {
            inorder.push(root);
            root = root.left;
        }
    }
}

class DoubleLinkedList {
    DoubleLinkedList pre;
    DoubleLinkedList next;
    int val;
    public DoubleLinkedList(int val) {
        this.val = val;
    }
}

#add operation
class AddOperator {
    public List<String> addOperator(String number) {
        List<String> result = new ArrayList<>();
        helper(result, 0, "", number);
        return result;
    }

    private void helper(List<String> result, int pos, String path, String number) {
        if (pos == number.length()) {
            if (path.charAt(0) == '+') {
                result.add(path.substring(1));
            }
            else {
                result.add(path);
            }
            return;
        }
        for (int i = pos; i < number.length(); i++) {
            if (i != pos && number.charAt(pos) == '0') {
                return;
            }
            String num = number.substring(pos, i + 1);
            helper(result, i + 1, path + "+" + num, number);
            helper(result, i + 1, path + "-" + num, number);
        }
    }
}

class MaxNumberStream {
    private int cap;
    Deque<Integer> deque;
    Queue<Integer> queue;
    public MaxNumberStream(int k) {
        this.cap = k;
        this.deque = new ArrayDeque<>();
        this.queue = new LinkedList<>();
    }
    public void add(int x) {
        while (queue.size() >= cap) {
            int temp = queue.poll();
            if (temp == deque.peek()) {
                deque.poll();
            }
        }
        while (!deque.isEmpty() && deque.peekLast() < x) {
            deque.pollLast();
        }
        queue.offer(x);
        deque.offer(x);
    }

    public int getMax() {
        if (!deque.isEmpty()) {
            return deque.peek();
        }
        return -1;
    }
}

# 给定一个array 返回一个partition point可以返回该index左边的和和右边的和一样，没有就返回-1
往右扫一遍求所有的和,再往左扫,求当前扫过的和,二者相减得左边的和.

class PartitionSum {
    public int findPivot(int[] input) {
        int sum = 0;
        for (int number : input) {
            sum += number;
        }
        int rightSum = 0;
        for (int i = input.length - 1; i >= 0; i--) {
            sum -= input[i];
            rightSum += input[i];
            if (rightSum == sum) {
                return i;
            }
        }
        return -1;
    }
}

# Sudoku Solver



# 给两个file，分别存有key和value，目标就是把相同的key合并在一起输出，比如file1里面有 ben 2， file2里有 ben SB，那就合并成ben 2 SB, 两个file很大，不许用Map
个人觉得第一题的应该是：如果关键字已经排序，就用two pointers搞定；如果关键字是乱序的，那么如果为了节省空间而不允许用hashmap的话，则自己定义一个Trie，
Trie的节点存三个值：子节点集合（长度为26的指针数组）、是否为单词结尾的标志位、关键字对应的值。其中关键字对应的值只有在该节点为单词结尾的时候有效。
把第一个文件中的关键字全部加入到Trie中，再把第二个文件中的单词拿到Trie中查找就好了。Trie比hashmap更省空间是因为，Trie合并了大量前缀相同的条目，hashmap做不到这点。


#check if a binary tree is mirrored

//Recursive way
private boolean helper(TreeNode left, TreeNode right) {
    if ((left == null && right != null) || (left != null && right == null)) {
        return false;
    }
    if (left == null && right == null) {
        return true;
    }
    if (left.val != right.val) {
        return false;
    }
    boolean subResult = helper(left.right, right.left) && helper(left.left, right.right);
    return subResult;
}

//iterative way
public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        left.push(root.left);
        right.push(root.right);
        while(!left.isEmpty() && !right.isEmpty()) {
            TreeNode leftTemp = left.pop();
            TreeNode rightTemp = right.pop();
            if (leftTemp == null ^ rightTemp == null 
            || (leftTemp != null && rightTemp != null && leftTemp.val != rightTemp.val)) {
                return false;
            }
            if (leftTemp == null && rightTemp == null) {
                continue;
            }
            left.push(leftTemp.left);
            right.push(rightTemp.right);
            left.push(leftTemp.right);
            right.push(rightTemp.left);
        }
        return true;
    }
#

Binary Tree求and操作。(BST and)例如：
        *                  *                    *
      /   \              /   \                /    \
     1    *   and    *     0  =              *      0
         /  \          / \                 /  \.
        0   1        1   0              1   0
     Follow up: deepCopy(tree)
     Follow up2: 如何合并结果中出现的情况？. 
          * 
        /   \    =>      0
       0    0


class TreeAnd {
    public TreeNode and(TreeNode root1, TreeNode root2) {
        if (isLeaf(root1) && !isLeaf(root2)) {
            return handleAnd(root1, root2);
        }
        if (isLeaf(root2) && !isLeaf(root1)) {
            return handleAnd(root2, root1);
        }
        if (isLeaf(root2) && isLeaf(root1)) {
            if (root2.val == 0 || root1.val == 0) {
                return new TreeNode(0);
            }
            return new TreeNode(1);
        }
        TreeNode root = new TreeNode(2);
        root.left = and(root1.left, root2.left);
        root.right = and(root1.right, root2.right);
        return root;
    }

    private TreeNode copyTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode copyRoot = new TreeNode(root.val);
        copyRoot.left = copyTree(root.left);
        copyRoot.right = copyTree(root.right);
        return copyRoot;
    }

    private TreeNode handleAnd(TreeNode leaf, TreeNode root) {
        if (leaf.val == 0) {
            return new TreeNode(0);
        }
        return copyTree(root);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}


输入：一个文件夹
输出：文件夹下面的所有相同文件对
// MD5 hash
例子：
给你一个文件夹路径，/foo/bar，要求找出这个文件夹下面的所有相同的文件，比如a和c是相同的，d和e是相同的，就输出(a, c)，(d, e)。

我看到路径还以为是Simplify Path呢！心中一阵窃喜，结果怎么发现后面的没见过！好吧，先通过dfs获取所有的文件，然后计算MD5，然后比较是不是一样。
. more info on 1point3acres.com
follow up1，要是MD5不够强壮怎么办？答：上另一个hash啊！比完一个，再比另一个，两个都一样才认为一样。然后又写了一遍……小哥说能提升么？我说可以啊！第二个hash可以在真正需要的时候再计算，不用每个文件都计算两个hash存起来。然后又写了一遍……

follow up2，以上代码里最花时间的是哪部分？答：dfs。小哥说再想想，要是文件都是video呢？我醒悟了，说是计算hash的部分。小哥问，怎么提升呢？我想了一会儿说，我们不用给每个文件计算hash 啊！先用size比嘛！绝大部分的文件size都是不一样的嘛。小哥说好，你能把你算法再实现一次吗？…………………………


第二道题是 给个Tree 不一定是平衡的， 要求 把所有路径排序后  按字符串那样的比较大小方法 找出最小的路径  时间要求线性的。 比如  
          5
       /     \
    10      3
   /   \   /
1    7  8
路径有  5 10 1 ； 5 10 7 ； 5 3 8
排序后  1 5 10 ； 5 7 10 ； 3 5 8；
所以按字符串类型排序 为  1 5 10 < 3 5 8 < 5 7 10；

class FindSmallPath {
    public List<Integer> find(TreeNode root) {
        Result result = helper(root);
        return result.path;
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            Result result = new Result();
            result.path.add(Integer.MAX_VALUE);
            return result;
        }
        if (root.left == null && root.right == null) {
            Result result = new Result();
            result.min = root.val;
            result.path.add(root.val);
            return result;
        }
        Result left = helper(root.left);
        Result right = helper(root.right);
        Result result = new Result();
        result.path.add(root.val);
        if (left.min > right.min) {
            result.path.addAll(right.path);
        }
        else {
            result.path.addAll(left.path);
        }
        result.min = Math.min(root.val, Math.min(left.min, right.min));
        return result;
    }
    class Result {
        public int min = Integer.MAX_VALUE;
        public List<Integer> path = new ArrayList<>();
        public Result() {
        }
    }
}


#Paint House
paint house大变种. n houses, k colors. neighboring houses cannot be painted with the same color.
NOTICE: neighboring relationship is given by adjacent list which means a house may have multiple neighbors.
class PaintHouseGraph {
    public int paint(int[] cost, HashMap<Integer, List<Integer>> houses) {
        List<Set<Integer>> groups = new ArrayList<>();
        Set<Integer> group = new HashSet<>();
        for (int house : houses.keySet()) {
            group.add(house);
        }
        while (group.size() != 0) {
            Iterator<Integer> iter = group.iterator();
            Set<Integer> next = new HashSet<>();
            while (iter.hasNext()) {
                int house = iter.next();
                if (next.contains(house)) {
                    iter.remove();
                    continue;
                }
                for (int neighbor : houses.get(house)) {
                    if (!group.contains(neighbor)) {
                        continue;
                    }
                    next.add(neighbor);
                }
            }
            groups.add(group);
            group = next;
        }
        Collections.sort(groups, new Comparator<Set<Integer>>() {
            @Override
            public int compare(Set<Integer> set1, Set<Integer> set2) {
                return set2.size() - set1.size();
            }
        });
        int totalCost = 0;
        int index = 0;
        for (Set<Integer> set : groups) {
            totalCost += set.size() * cost[index++];
        }
        return totalCost;
    }
}


逆序输出一个单链表，要求空间复杂度为O(lgn)，不能修改链表结构（也就是不可以reverse链表，然后再reverse回去）
最后做的大概就是每次走到终点，递归右半段，然后再递归左半段，最后给他画颗递归树证明下复杂度就行了，他也认可了。
不过看起来这个做法相对奇葩一点，他看我画的还想了一会，似乎这不是他原来设想的方案吧，但也确实没毛病。
'Time complexity: O(nlgn) space complexity: O(lgn)'
class ReversePrint {
    public void print(ListNode head) {
        ListNode mover = head;
        int length = 0;
        while (mover != null) {
            mover = mover.next;
            length++;
        }
        helper(head, length);
    }

    private void helper(ListNode head, int length) {
        if (head == null) {
            return;
        }
        if (length == 1) {
            System.out.println(head.val);
            return;
        }
        int count = 0;
        ListNode mover = head;
        while (count < length / 2) {
            mover = mover.next;
            count++;
        }
        helper(mover, length - length / 2);
        helper(head, length / 2);
    }
}

第二题有点像有序双链表合并，不过给的是两个iterator，让实现一个类，生成下一个.
class SortedIterator{
    public SortedIterator(Iterator a, Iterator b);
    public boolean hasNext();
    public int next();
}


class SortedIterator {
    private Pair pairA;
    private Pair pairB;
    public SortedIterator(Iterator<Integer> a, Iterator<Integer> b) {
        if (a.hasNext()) {
            pairA = new Pair(a.next(), a);
        }
        else {
            pairA = new Pair(null, a);
        }
        if (b.hasNext()) {
            pairB = new Pair(b.next(), b);
        }
        else {
            pairB = new Pair(null, b);
        }
    }
    public boolean hasNext() {
        return pairA.value != null || pairB.value != null;
    }

    public int next() {
        if (pairA.value == null) {
            return helper(pairB);
        }
        else if (pairB.value == null) {
            return helper(pairA);
        }
        Integer result = null;
        if (pairA.value > pairB.value) {
            result = helper(pairB);
        }
        else {
            result = helper(pairA);
        }
        return result;
    }

    private Integer helper(Pair pair) {
        int result = pair.value;
        if (pair.iterator.hasNext()) {
            pair.value = pair.iterator.next();
        }
        else {
            pair.value = null;
        }
        return result;
    }

    private class Pair {
        public Integer value;
        public Iterator<Integer> iterator;
        public Pair(Integer val, Iterator<Integer> iterator) {
            this.value = val;
            this.iterator = iterator;
        }
    }
}

可以随便交易很多次，可以同时买很多股票，但是一旦卖就要把手里的股票全部卖了，问怎样最大化收益。比如[1, 2,3], 前2天都买，第三天全部卖，收益就是(3-1)+(3-2).
stock sell all
public int maxProfit(int[] prices) {
    int max = 0;
    int profit = 0;
    for (int i = prices.length - 1; i >= 0; i--) {
        if (max > prices[i]) {
            profit += max - prices[i];
            System.out.println(profit);
        }
        else {
            max = prices[i];
        }
    }
    return profit;
}

给一个l*w的矩阵，要随机取k个点。一个披着easy题的，蓄水池抽样。到最后也没解释清蓄水池原理。
大叔深深怀疑我的概率问题（其实我也怀疑），给我张白纸就好了- -
// Use reversior smaple to do this.
// Use a array to store the points we fetch out
// For the first k points in matrix, put into array,
// For the k + 1 ~ end points, 
// we creat a random number j which range [0, index]
// if this j is smaller than k, then we chooes this point instead the points[j]
// Prove the possibility: 
// For points index after k, if we eventually choose this point, which means after this point, 
// No point can replace this point in the points array, the random number can be any number but not this point's index
// which means their possibility is (index - 1 / index)
// So the posibility is: (k / index) * (index / index + 1) * (index + 1 / index + 2)....*(n - 1 / n) = (k / n)
// For points index smaller k, if we eventually choose this point, 
// no points can replace it, so the possibility is (k / k + 1) * (k + 1 / k + 2) * ......* (n - 1 / n) = (k / n)
class Sample {
    public void sample(int[][] input, int k) {
        Point[] points = new Point[k];
        Random rand = new Random();
        int width = input[0].length;
        int height = input.length;
        int index = 0;
        while (index < width * height && index < k) {
            points[index] = new Point(index / width, index % width);
            input[index / width][index & width] = 1;
            index++;
        }
        if (index < k) {
            return;
        }
        index = k;
        while (index < width * height) {
            int newIndex = rand.nextInt(index);
            if (newIndex < k) {
                input[points[newIndex].x][points[newIndex].y] = 0;
                int row = index / width;
                int col = index % width;
                input[row][col] = 1;
                points[newIndex] = new Point(row, col);
            }
            index++;
        }
    }
}


就是lc next permutation的反着来的previous permutation，做法一样
// The idea is that find the last two adjacent number that the first one is beigger than the second one
// Then the question come to that find the previous permutation of the nums[first-end]
// Then sequence after second must be acending, so the previous permutation must comes from 
// the number that is samller than the nums[first] at the position first with a decending sequence after it
// Exp: 5, 4, 1, 2, 3 previous -> 5, 3, 4, 2, 1 
// the num[first] = 4, nums[second] = 1, nums[smaller] = 3 
class PreviousPermutation {
    public int[] previous(int[] input) {
        if (input.length <= 1) {
            return input;
        }
        int first = 0;
        int second = 0;
        for (int i = input.length - 1; i >= 1; i--) {
            if (input[i] < input[i - 1]) {
                first = i - 1;
                second = i;
                break;
            }
        }
        int smaller = 0;
        for (int i = input.length - 1; i >= second; i--) {
            if (input[i] < input[first]) {
                smaller = i;
                break;
            }
        }
        swap(input, first, smaller);
        reverse(input, second, input.length - 1);
        return input;
    }
    private void swap(int[] input, int index1, int index2) {
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }
    private void reverse(int[] input, int start, int end) {
        while (start <= end) {
            swap(input, start++, end--);
        }
    }
}

longest palindrome

两个词的最短距离变体，follow up词很多怎么省空间

一个矩阵斜着走的list例子如下：
123
456
789
输出：{1}{42}{753}{86}{9}

class WalkMatrix {
    public void print(int[][] matrix) {
        int height = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            helper(i, 0, matrix);
        }
        for (int i = 1; i < matrix[0].length; i++) {
            helper(height - 1, i, matrix);
        }
    }

    private void helper(int row, int col, int[][] matrix) {
        while (row >= 0 && col < matrix[0].length) {
            System.out.printf("%d ", matrix[row--][col++]);
        }
        System.out.println();
    }
}



Find path from one node to another node in a binary tree
node has parent pointer

class PathToNode {
    public List<Integer> findPath(TreeNodeWithParent node1, TreeNodeWithParent node2) {
        List<Integer> result = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        if (node1 == null || node2 == null) {
            return result;
        }
        TreeNodeWithParent mover1 = node1;
        TreeNodeWithParent mover2 = node2;
        int len1 = findLength(mover1);
        int len2 = findLength(mover2);
        while (len1 > len2) {
            left.add(mover1.val);
            mover1 = mover1.parent;
            len1--;
        }
        while (len2 > len1) {
            right.add(mover2.val);
            mover2 = mover2.parent;
            len2--;
        }
        while (mover1 != mover2) {
            left.add(mover1.val);
            right.add(mover2.val);
            mover1 = mover1.parent;
            mover2 = mover2.parent;
        }
        left.add(mover1.val);
        result.addAll(left);
        for (int i = right.size() - 1; i >= 0; i--) {
            result.add(right.get(i));
        }
        return result;
    }

    private int findLength(TreeNodeWithParent node) {
        int len = 0;
        while (node != null) {
            node = node.parent;
            len++;
        }
        return len;
    }
}

interval [startTime, stoptime)   ----integral  time stamps. more info on 1point3acres.com
给这样的一串区间 I1, I2......In  
找出 一个 time stamp  出现在interval的次数最多。
startTime <= t< stopTime 代表这个数在区间里面出现过。

example：  [1,3),  [2, 7),   [4,  8),   [5, 9)
5和6各出现了三次， 所以答案返回5，6。

class MaxOverpal {
    public List<Integer> findMaxOverLapTime (Interval[] intervals) {
        List<Integer> result = new ArrayList<>();
        if (intervals.length == 0) {
            return result;
        }
        List<Point> points = new ArrayList<>();
        for (Interval interval : intervals) {
            points.add(new Point(interval.start, true));
            points.add(new Point(interval.end, false));
        }
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.time == p2.time) {
                    return p1.isStart ? 1 : 0;
                }
                return p1.time - p2.time;
            }
        });
        int max = 0;
        int number = 0;
        int start = 0;
        int end = 0;
        for (Point point : points) {
            if (point.isStart) {
                number++;
                if (number > max) {
                    max = number;
                    start = point.time;
                    end = point.time;
                }
            }
            else {
                if (number == max) {
                    end = point.time;
                }
                number--;
            }
        }
        for (int i = start; i < end; i++) {
            result.add(i);
        }
        return result;
    }

    private class Point {
        public int time;
        public boolean isStart;
        public Point(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }
}

Remove comments

class RemoveComment {
    public String remove(String code) {
        StringBuilder result = new StringBuilder();
        boolean singleLine = false;
        boolean multiLine = false;
        for (int i = 0; i < code.length(); i++) {
            if (singleLine && code.charAt(i) == '\n') {
                singleLine = false;
            }
            else if (multiLine && code.charAt(i) == '*' && code.charAt(i + 1) == '/') {
                multiLine = false;
                i++;
            }
            else if (multiLine || singleLine) {
                continue;
            }
            else if (code.charAt(i) == '/' && code.charAt(i + 1) == '/') {
                singleLine = true;
                i++;
            }
            else if (code.charAt(i) == '/' && code.charAt(i + 1) == '*') {
                multiLine = true;
                i++;
            }
            else {
                result.append(code.charAt(i));
            }
        }
        return result.toString();
    }
}

 keyValueStore 有四个method，add(key, value), remove(key), get(key), lastestKey() implement keyValueStore
前三个就和hashmap一样，最后一个返回最近访问的key

class KeyValueStore {
    private HashMap<Integer, DoubleLinkList> keyToNode;
    private DoubleLinkList head;
    private DoubleLinkList tail;
    public KeyValueStore() {
        this.keyToNode = new HashMap<>();
        this.head = new DoubleLinkList(0, 0);
        this.tail = new DoubleLinkList(0, 0);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public void add(int key, int value) {
        if (keyToNode.containsKey(key)) {
            DoubleLinkList node = keyToNode.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }
        else {
            DoubleLinkList node = new DoubleLinkList(key, value);
            keyToNode.put(key, node);
            addToHead(node);
        }
    }

    public boolean remove(int key) {
        if (!keyToNode.containsKey(key)) {
            return false;
        }
        DoubleLinkList node = keyToNode.get(key);
        keyToNode.remove(key);
        deleteNode(node);
        return true;
    }

    public Integer get(int key) {
        if (!keyToNode.containsKey(key)) {
            return null;
        }
        DoubleLinkList node = keyToNode.get(key);
        deleteNode(node);
        addToHead(node);
        return node.value;
    }

    public Integer latestKey() {
        if (head.next != tail) {
            return head.next.value;
        }
        return null;
    }

    private void addToHead(DoubleLinkList node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void deleteNode(DoubleLinkList node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = null;
        node.prev = null;
    }

    class DoubleLinkList {
        public int key;
        public int value;
        public DoubleLinkList next;
        public DoubleLinkList prev;
        public DoubleLinkList(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
}


这个稍微难， 说有一堆task，每个有不同时间完成， 然后有一堆worker， 说如何分配 task to worker，完成时间最短， task是独立的。. 涓€浜�-涓夊垎-鍦帮紝鐙鍙戝竷
看起来像背包， DP 
task：  2，2，3，7， 1
worker： 2

解（2，2，3） （1， 7）



Island Shape
class IslandShape {
    private static int[] X = {0, 0, 1, -1};
    private static int[] Y = {1, -1, 0, 0};
    public int uniqueShape(int[][] matrix) {
        Set<Long> shapes = new HashSet<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 1) {
                    Long shape = explore(matrix, row, col);
                    if (!shapes.contains(shape)) {
                        shapes.add(shape);
                    }
                }
            }
        }
        return shapes.size();
    }

    private long explore(int[][] matrix, int row, int col) {
        long shape = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        matrix[row][col] = 2;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int k = 0; k < 4; k++) {
                int[] next = new int[]{point[0] + X[k], point[1] + Y[k]};
                if (next[0] < 0 || next[0] >= matrix.length || next[1] < 0 || next[1] >= matrix[0].length
                        || matrix[next[0]][next[1]] != 1) {
                    continue;
                }
                shape = shape * 10 + k;
                queue.offer(next);
                matrix[next[0]][next[1]] = 2;
            }
        }
        return shape;
    }
}


几何算法问题。如果给你一堆的矩形， 求重合矩形重合最多的坐标位置。我上过一个算法课，大概思路就是做一个二维的meeting room II.

class Overlap {
    public Square findMostOverlap (Square[] squares) {
        HashMap<Integer, List<Pair>> indexToLine = new HashMap<>();
        for (Square square : squares) {
            if (!indexToLine.containsKey(square.x0)) {
                indexToLine.put(square.x0, new ArrayList<Pair>());
            }
            indexToLine.get(square.x0).add(new Pair(square.y0, true, true));
            indexToLine.get(square.x0).add(new Pair(square.y1, false, true));
            if (!indexToLine.containsKey(square.x1)) {
                indexToLine.put(square.x1, new ArrayList<Pair>());
            }
            indexToLine.get(square.x1).add(new Pair(square.y0, true, false));
            indexToLine.get(square.x1).add(new Pair(square.y1, false, false));
        }
        for (Square square : squares) {
            for (int index  = square.x0 + 1; index < square.x1; index++) {
                if (indexToLine.containsKey(index)) {
                    indexToLine.get(index).add(new Pair(square.y0, true, null));
                    indexToLine.get(index).add(new Pair(square.y1, false, null));
                }
            }
        }
        for (int index : indexToLine.keySet()) {
            Collections.sort(indexToLine.get(index), new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    if (p1.index == p2.index) {
                        if (p2.isUp) {
                            return -1;
                        }
                        else if (p1.isUp) {
                            return 1;
                        }
                        return 0;
                    }
                    return p2.index - p1.index;
                }
            });
        }

        Square overlap = new Square(0, 0, 0, 0);
        int maxOverlap = 0;
        for (int index : indexToLine.keySet()) {
            List<Pair> line = indexToLine.get(index);
            int right = 0;
            int left = 0;
            for (Pair pair : line) {
                if (pair.isUp) {
                    if (pair.isLeft == null || (pair.isLeft != null && pair.isLeft)) {
                        right++;
                        if (right > maxOverlap) {
                            overlap.x0 = index;
                            overlap.y0 = pair.index;
                            maxOverlap = right;
                        }
                    }
                    if (pair.isLeft == null || (pair.isLeft != null && !pair.isLeft)) {
                        left++;
                    }
                }
                else {
                    if (pair.isLeft == null || (pair.isLeft != null && !pair.isLeft)) {
                        if (left == maxOverlap) {
                            overlap.x1 = index;
                            overlap.y1 = pair.index;
                        }
                        left--;
                    }
                    if (pair.isLeft == null || (pair.isLeft != null && pair.isLeft)) {
                        right--;
                    }
                }
            }
        }
        return overlap;
    }
    class Pair {
        public Boolean isUp;
        public Boolean isLeft;
        public int index;
        public Pair(int index, Boolean isUp, Boolean isLeft) {
            this.index = index;
            this.isUp= isUp;
            this.isLeft = isLeft;
        }

        @Override
        public String toString() {
            return "index: " + Integer.toString(index) + ", isUp: " + isUp + ", isLeft: " + isLeft + "\n";
        }
    }
}
class Square {
    int x0;
    int x1;
    int y0;
    int y1;
    public Square (int x0, int x1, int y0, int y1) {
        this.x0 = x0;
        this.x1 = x1;
        this.y0 = y0;
        this.y1 = y1;
    }
    @Override
    public String toString() {
        return "x0: " + Integer.toString(x0) + "\n" +
                "y0: " + Integer.toString(y0) + "\n" +
                "x1: " + Integer.toString(x1) + "\n" +
                "y1: " + Integer.toString(y1) + "\n";
    }
}


input是一个array，要求生成一个树，有以下三个属性
1）二叉树
2）Min Heap，表示node的每个子节点的值都大于或者等于这个node的值
3）做inorder traversal的时候要保持array的顺序

举个例子input是 5, 2, 10, 7
       2
      / \
    5   7
        /
        10

follow up 是一个addNode的函数，输入是root node，还有个int value，保持原有的属性，返回root
// Find the smallest value in the array and make it as root
// left part as left branch, right part as right brandh
'Time complexity: O(nlgn), Space complexity: O(lgn)'
class BuildMinHeap {
    public TreeNode build(int[] input) {
        return helper(input, 0, input.length - 1);
    }

    public TreeNode helper(int[] input, int start, int end) {
        if (start > end) {
            return null;
        }
        int index = -1;
        int val = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (input[i] <= val) {
                index = i;
                val = input[i];
            }
        }
        TreeNode root = new TreeNode(val);
        root.left = helper(input, start, index - 1);
        root.right = helper(input, index + 1, end);
        return root;
    }
    // check the root's value, if it is bigger than input
    // we should input it as current node's parent 
    // to maintain the inorder traverse order, the current node
    // should be the left child of input node
    // else go into the right child
    'Time complexity: O(lgn)'
    public TreeNode addOne(TreeNode root, int value) {
        TreeNode mover = root;
        TreeNode prev = null;
        while (true) {
            if (value > mover.val) {
                if (mover.right == null) {
                    TreeNode node = new TreeNode(value);
                    mover.right = node;
                    break;
                }
                prev = mover;
                mover = mover.right;
            }
            else {
                TreeNode node = new TreeNode(value);
                if (prev != null) {
                    prev.right = node;
                }
                else {
                    root = node;
                }
                node.left = mover;
                break;
            }
        }
        return root;
    }
}


Stock with charge/fee:
// maintain a veriable which is the profit we make 
// when the prices is continuously acending,
// when today's prices is lower than yesterday,
// which means we finish one transaction, 
// calculate the final profit with charge, if > 0 add to result
public int maxProfitWithCharge(int[] prices, int charge) {
    int profit = 0;
    int localProfit = 0;
    boolean yesterdaySold = false;
    for (int i = 1; i < prices.length; i++) {
        if (prices[i] > prices[i - 1]) {
            localProfit += prices[i] - prices[i - 1];
            if (!yesterdaySold) {
                localProfit -= charge;
            }
            yesterdaySold = true;
        }
        else if (yesterdaySold) {
            profit += localProfit > 0 ? localProfit : 0;
            localProfit = 0;
            yesterdaySold = false;
        }
    }
    if (localProfit > 0) {
        profit += localProfit;
    }
    return profit;
}


find if a tree is subtree of another:

'Time complexity: O(nk) -k nodes in subtree'

class FindSubTree {
    public boolean isValid(TreeNode root, TreeNode node) {
        if (root == null && node == null) {
            return true;
        }
        boolean result = false;
        if (root != null && node != null) {
            if (root.val == node.val) {
                result = helper(root, node);
            }
            if (!result) {
                result = isValid(root.right, node);
            }
            if (!result) {
                result = isValid(root.left, node);
            }
        }
        return result;
    }

    private boolean helper(TreeNode root, TreeNode node) {
        if (root == null && node == null) {
            return true;
        }
        if ((root == null && node != null) || (root != null && node == null)) {
            return false;
        }
        if (root.val == node.val) {
            return helper(root.right, node.right) && helper(root.left, node.left);
        }
        return false;
    }
}

write/lock


1. remove duplicate characters in a string. ex "abcba", return "c". 

class RemoveDuplicate {
    public String remove(String input) {
        HashMap<Character, Integer> charToIndex = new HashMap<>();
        Character[] result = new Character[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (charToIndex.containsKey(letter)) {
                int index = charToIndex.get(letter);
                if (index >= 0) {
                    result[index] = null;
                    charToIndex.put(letter, -1);
                }
            }
            else {
                result[i] = letter;
                charToIndex.put(letter, i);
            }
        }
        StringBuilder output = new StringBuilder();
        for (Character letter : result) {
            if (letter != null) {
                output.append(letter);
            }
        }
        return output.toString();
    }
}


2. 在一个post里面找出所有的name分别出现的位置, post会很长。 unordered_map<string, vector<int>>   findPosition (vector<string> names, string post) {}. names如果很多很多怎么办。

// Use TrieTree, 
// word.length = k, post.length = n
'Time complexity: O(nk), space complexity: total number of the node in trie tree'

class FindIndex {
    TrieNode root = new TrieNode();
    public HashMap<String, List<Integer>> find(List<String> input, String post) {
        HashMap<String, List<Integer>> result = new HashMap<>();
        if (input.size() == 0) {
            return result;
        }
        for (String word : input) {
            insert(word);
        }
        for (int i = 0; i < post.length(); i++) {
            if (i == 3) {
                System.out.print("s");
            }
            List<String> words = search(post, i);
            for (String word : words) {
                if (!result.containsKey(word)) {
                    result.put(word, new ArrayList<>());
                }
                result.get(word).add(i);
            }
        }
        return result;
    }

    private void insert(String word) {
        TrieNode mover = root;
        for (char letter : word.toCharArray()) {
            if (mover.children[letter - 'a'] == null) {
                mover.children[letter - 'a'] = new TrieNode();
            }
            mover = mover.children[letter - 'a'];
        }
        mover.isEnd = true;
    }
    private List<String> search(String post, int index) {
        List<String> result = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        TrieNode mover = root;
        while (index < post.length()) {
            if (mover.isEnd) {
                result.add(word.toString());
            }
            char letter = post.charAt(index);
            if (mover.children[letter - 'a'] == null) {
                return result;
            }
            mover = mover.children[letter - 'a'];
            word.append(letter);
            index++;
        }
        if (mover.isEnd) {
            result.add(word.toString());
        }
        return result;
    }
}

矩阵中大小为m的正方形覆盖范围最大值不超过k的值。记得刷过相似的，动态规划，每个cell记一下左上方的所有和，简单解决。
class MaxSumOfSquareNoLargerThanK {
    public int sum(int[][] matrix, int m, int k) {
        if (m > matrix.length || m > matrix[0].length) {
            return 0;
        }
        int maxSum = 0;
        int[][] sum = new int[matrix.length][matrix[0].length];
        for (int col = 0; col < matrix[0].length; col++) {
            int rectSum = 0;
            for (int row = 0; row < m; row++) {
                rectSum += matrix[row][col];
            }
            sum[0][col] = rectSum;
            for (int row = 1; row < matrix.length - m + 1; row++) {
                rectSum += matrix[row + m - 1][col] - matrix[row - 1][col];
                sum[row][col] = rectSum;
            }
        }
        for (int row = 0; row < matrix.length - m + 1; row++) {
            int squareSum = 0;
            for (int col = 0; col < m; col++) {
                squareSum += sum[row][col];
            }
            if (squareSum < k) {
                maxSum = Math.max(squareSum, maxSum);
            }
            for (int col = 1; col < matrix[0].length - m + 1; col++) {
                squareSum += sum[row][col + m - 1] - sum[row][col - 1];
                if (squareSum < k) {
                    maxSum = Math.max(squareSum, maxSum);
                }
            }
        }
        return maxSum;
    }
}
//--------------------------------------------------------------------------------------------//
//--------------------------------------------------------------------------------------------//
//--------------------------------------------------------------------------------------------//
// every cell store the sum of the sub-matrix from 0,0 to this cell.
// then we can get the sum of square on O(1)
public int findSum(int[][] matrix, int m, int k) {
    if (m > matrix.length || m > matrix[0].length) {
        return 0;
    }
    int maxSum = 0;
    int[][] sum = new int[matrix.length][matrix[0].length];
    buildSum(sum, matrix);
    for (int row = m - 1; row < matrix.length; row++) {
        for (int col = m - 1; col < matrix[0].length; col++) {
            int curSum = getSum(sum, row - m + 1, col - m + 1, row, col);
            if (curSum < k) {
                maxSum = Math.max(maxSum, curSum);
            }
        }
    }
    return maxSum;
}

public boolean findSquareEqualsK(int[][] matrix, int k) {
    int[][] sum = new int[matrix.length][matrix[0].length];
    buildSum(sum , matrix);
    for (int row = 0; row < matrix.length; row++) {
        for (int col = 0; col < matrix[0].length; col++) {
            int maxLen = Math.min(row, col);
            if (search(maxLen, sum, row, col, k)) {
                return true;
            }
        }
    }
    return false;
}

private boolean search(int maxLen, int[][] sum, int row, int col, int k) {
    int start = 0;
    int end = maxLen;
    while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        int curSum = getSum(sum, row - mid, col - mid, row, col);
        if (curSum >= k) {
            end = mid;
        }
        else {
            start = mid;
        }
    }
    if (getSum(sum, row - end, col - end, row, col) == k ||
            getSum(sum, row - start, col - end, row, col) == k) {
        return true;
    }
    return false;
}

private int getSum(int[][] sum, int row1, int col1, int row2, int col2) {
    if (row1 == 0 && col1 == 0) {
        return sum[row2][col2];
    }
    else if (row1 == 0) {
        return sum[row2][col2] - sum[row2][col1 - 1];
    }
    else if (col1 == 0) {
        return sum[row2][col2] - sum[row1 - 1][col2];
    }
    else {
        return sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1];
    }
}   

//--------------------------------------------------------------------------------------------//
//--------------------------------------------------------------------------------------------//


Find least number of intervals from A that can fully cover B
For example:
Given A=[[0,3],[3,4],[4,6],[2,7]] B=[0,6] return 2 since we can use [0,3] [2,7] to cover the B
Given A=[[0,3],[4,7]] B=[0,6] return 0 since we cannot find any interval combination from A to cover the B

// make sure every time we choose one interval we cover more time
// every time we chooes one, make the start time as its end time
// Always choose the interval that whose end time is the biggest
// and start time is smaller or equal to current start time
// util we got the end time bigger than input.end

'time complexity: O(nlgn)'

class MinimumCoverInterval {
    public int findCover(Interval[] intervals, Interval interval) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval inter1, Interval inter2) {
                if (inter1.start == inter2.start) {
                    return inter1.end - inter2.end;
                }
                return inter1.start - inter2.start;
            }
        });
        int count = 0;
        int start = interval.start;
        int end = -1;
        int index = 0;
        while (index < intervals.length && end < interval.end) {
            if (intervals[index].end <= start) {
                index++;
                continue;
            }
            if (intervals[index].start > start) {
                break;
            }
            while (index < intervals.length && end < interval.end && intervals[index].start <= start) {
                end = Math.max(intervals[index].end, end);
                index++;
            }
            if (start != end) {
                count++;
                start = end;
            }
        }
        if (end < interval.end) {
            return 0;
        }
        return count;
    }
}

find all equivalent pairs
Given an array A of integers, find the index of values that satisfy A + B =C + D, where A,B,C & D are integers values in the array. Find all combinations of quadruples.

'Time complexity: O(n^2)'


class FindPair {
    public List<List<int[]>> find(int[] input) {
        HashMap<Integer, Indexs> sumToPair = new HashMap<>();
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                int sum = input[i] + input[j];
                if (!sumToPair.containsKey(sum)) {
                    sumToPair.put(sum, new Indexs());
                }
                int[] newPair = new int[]{i, j};
                Set<Integer> index = sumToPair.get(sum).index;
                if (!index.contains(i) && !index.contains(j)) {
                    sumToPair.get(sum).pairs.add(newPair);
                    sumToPair.get(sum).index.add(i);
                    sumToPair.get(sum).index.add(j);
                }
            }
        }
        List<List<int[]>> result = new ArrayList<>();
        for (int sum : sumToPair.keySet()) {
            List<int[]> pairs = sumToPair.get(sum).pairs;
            if (pairs.size() >= 2) {
                List<int[]> list = new ArrayList<>();
                for (int i = 0; i < pairs.size() - 1; i++) {
                    for (int j = i + 1; j < pairs.size(); j++) {
                        int[] pair1 = pairs.get(i);
                        int[] pair2 = pairs.get(j);
                        list.add(new int[]{input[pair1[0]], input[pair1[1]]});
                        list.add(new int[]{input[pair2[0]], input[pair2[1]]});
                    }
                }
                if (list.size() != 0) {
                    result.add(list);
                }
            }
        }
        return result;
    }
    class Indexs{
        public List<int[]> pairs = new ArrayList<>();
        public Set<Integer> index = new HashSet<>();
        public Indexs() {

        }
    }
}

input could include ":(" frown or ":)" smileys
check if the input is parenthese balance
class CheckBalanced {
    public boolean check(String message) {
        int closeParenth = 0;
        int openParenth = 0;
        int smileys = 0;
        int frowns = 0;
        boolean isPotentialEmotion = false;
        for (char letter : message.toCharArray()) {
            if (letter == '(') {
                if (isPotentialEmotion) {
                    frowns++;
                }
                openParenth++;
            }
            else if (letter == ')') {
                if (isPotentialEmotion) {
                    smileys++;
                }
                closeParenth++;
            }
            if (closeParenth > openParenth) {
                if (closeParenth - smileys > openParenth) {
                    return false;
                }
                closeParenth = openParenth;
                smileys = smileys - (closeParenth - openParenth);
            }
            if (letter == ':') {
                isPotentialEmotion = true;
            }
            else {
                isPotentialEmotion = false;
            }
        }
        if (openParenth - frowns > closeParenth) {
            return false;
        }
        return true;
    }
}

find 2nd mutal friend

class MutalFriend {
    public List<GraphNode> findMutalFriends(GraphNode me) {
        Queue<GraphNode> explore = new LinkedList<>();
        Set<GraphNode> friends = new HashSet<>();
        HashMap<GraphNode, Integer> mutalToCount = new HashMap<>();
        int level = 0;
        explore.offer(me);
        friends.add(me);
        while (!explore.isEmpty() && level <= 2) {
            level++;
            int size = explore.size();
            for (int i = 0; i < size; i++) {
                GraphNode node = explore.poll();
                for (GraphNode friend : node.friend) {
                    if (level == 1) {
                        friends.add(node);
                        explore.offer(node);
                        continue;
                    }
                    if (friends.contains(friend)) {
                        continue;
                    }
                    if (!mutalToCount.containsKey(friend)) {
                        mutalToCount.put(friend, 1);
                    }
                    else {
                        mutalToCount.put(friend, mutalToCount.get(friend) + 1);
                    }
                }

            }
        }
        List<GraphNode> result = new ArrayList<>();
        for (GraphNode node : mutalToCount.keySet()) {
            result.add(node);
        }
        Collections.sort(result, new NodeComparator(mutalToCount));
        return result;
    }
    class NodeComparator implements Comparator<GraphNode> {
        private HashMap<GraphNode, Integer> map;
        public NodeComparator(HashMap<GraphNode, Integer> map) {
            this.map = map;
        }
        @Override
        public int compare(GraphNode node1, GraphNode node2) {
            return map.get(node2) - map.get(node1);
        }
    }
}

class GraphNode {
    String name;
    List<GraphNode> friend;
    public GraphNode(String name) {
        this.name = name;
        this.friend = new ArrayList<>();
    }
}


Serialize and deserialized Tree into LinkedList
class CodeTree {
    public ListNodeStr serialized(TreeNode root) {
        ListNodeStr head = helper(root).head;
        return head;
    }

    private Pair helper(TreeNode root) {
        if (root == null) {
            ListNodeStr node = new ListNodeStr("#");
            return new Pair(node, node);
        }
        ListNodeStr head = new ListNodeStr(Integer.toString(root.val));
        ListNodeStr tail = head;

        Pair left = helper(root.left);
        tail.next = left.head;
        tail = left.tail;

        Pair right = helper(root.right);
        tail.next = right.head;
        tail = right.tail;

        return new Pair(head, tail);
    }

    private ListNodeStr mover;
    public TreeNode deserialized(ListNodeStr head) {
        ListNodeStr fakeHead = new ListNodeStr("");
        fakeHead.next = head;
        mover = fakeHead;
        return helper();
    }
    private TreeNode helper() {
        mover = mover.next;
        if (mover.val.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(mover.val));
        root.left = helper();
        root.right = helper();
        return root;
    }

    class Pair {
        ListNodeStr head;
        ListNodeStr tail;
        public Pair(ListNodeStr h, ListNodeStr t) {
            this.head = h;
            this.tail = t;
        }
    }

}
class ListNodeStr {
    public String val;
    public ListNodeStr next;
    public ListNodeStr(String val) {
        this.val = val;
    }
}


'######################################################################'
'######################################################################'
'##########################---BEHAVIOR QUESTION----####################'
'######################################################################'

'#Tell me about urself'

My name is Heng Wu. Comes from New York University. 

'#Why facebook'



'#How do you see yourself in the five years'




#What do u expect to earn from company:


#What would u do if u have different opinion with ur colleague:



＃What is your most challenging project:



＃Describe a situation where you exceeded expectations/did more than required



#Which team of product u wanna go?


#Have u ever had a impossible prject which has a every short deadline?


#Have u ever do sth creative?


#Have u ever simplify something?
Same as my intern project

#What are ur weakness? How do u improve that?



#What feature of facebook do u like?




My Question:
1. Have you ever use those algorithm or complex data structure like heap, treeSet in real work?

2. Do you have standup in the team every day for reporting to other group members what you did yesterday and your work progress?

3. What is your favorite part of the fb as an engineer?

4. How often do people move around between teams?

5. How quickly does the company move on ideas.


















