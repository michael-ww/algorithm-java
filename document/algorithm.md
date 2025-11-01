### 滑动窗口算法框架伪码
```java
int left = 0, right = 0;

while (right < nums.size()) {
    // 增大窗口
    window.addLast(nums[right]);
    right++;
    // 进行窗口内数据的一系列更新
    ...
    
    // 判断左侧窗口是否要收缩
    while (window needs shrink) {
        // 缩小窗口
        window.removeFirst(nums[left]);
        left++;
        // 进行窗口内数据的一系列更新
        ...
    }
}
```
left 指针在后，right 指针在前，两个指针中间的部分就是「窗口」，算法通过扩大和缩小「窗口」来解决某些问题
主要用来解决子数组问题，比如让你寻找符合某个条件的最长/最短子数组

### 二分查找算法框架伪码
```java
int binarySearch(int[] nums, int target) {
    // 一左一右两个指针相向而行
    int left = 0, right = nums.length - 1;
    while(left <= right) {
        int mid = (right + left) / 2;
        if(nums[mid] == target)
            return mid; 
        else if (nums[mid] < target)
            left = mid + 1; 
        else if (nums[mid] > target)
            right = mid - 1;
    }
    return -1;
}
```
### 二叉树的递归遍历框架
```java
void traverse(TreeNode node){
    if(node==null){
        return;
    }

    // 前序遍历
    traverse(node.left);
    // 中序遍历
    traverse(node.right);
    // 后序遍历
}

// 二叉树遍历本质上和数据遍历链表遍历没有区别

// 迭代遍历数组
void traverse(int[] arr) {
    for (int i = 0; i < arr.length; i++) {

    }
}

// 递归遍历数组
void traverse(int[] arr, int i) {
    if (i == arr.length) {
        return;
    }
    // 前序位置
    traverse(arr, i + 1);
    // 后序位置
}

// 迭代遍历单链表
void traverse(ListNode head) {
    for (ListNode p = head; p != null; p = p.next) {

    }
}

// 递归遍历单链表
void traverse(ListNode head) {
    if (head == null) {
        return;
    }
    // 前序位置
    traverse(head.next);
    // 后序位置
}
```
二叉树结构无非就是二叉链表，它没办法简单改写成 for 循环的迭代形式，所以遍历二叉树一般都使用递归形式

二叉树的所有问题，就是让你在前中后序位置注入巧妙的代码逻辑，去达到自己的目的，你只需要单独思考每一个节点应该做什么，其他的不用你管，抛给二叉树遍历框架，递归会在所有节点上做相同的操作。

二叉树题目的递归解法可以分两类思路，第一类是遍历一遍二叉树得出答案，第二类是通过分解问题计算出答案，这两类思路分别对应着回溯算法核心框架和动态规划核心框架。

```java
// DFS 算法把「做选择」「撤销选择」的逻辑放在 for 循环外面
void dfs(Node root) {
    if (root == null) return;
    // 做选择
    print("enter node %s", root);
    for (Node child : root.children) {
        dfs(child);
    }
    // 撤销选择
    print("leave node %s", root);
}

// 回溯算法把「做选择」「撤销选择」的逻辑放在 for 循环里面
void backtrack(Node root) {
    if (root == null) return;
    for (Node child : root.children) {
        // 做选择
        print("I'm on the branch from %s to %s", root, child);
        backtrack(child);
        // 撤销选择
        print("I'll leave the branch from %s to %s", child, root);
    }
}

// 层序遍历
void levelTraverse(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    // 从上到下遍历二叉树的每一层
    while (!q.isEmpty()) {
        int sz = q.size();
        // 从左到右遍历每一层的每个节点
        for (int i = 0; i < sz; i++) {
            TreeNode cur = q.poll();

            // 将下一层节点放入队列
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
    }
}
```
写递归算法：
1、首先，这个问题是否可以抽象成一棵树结构？如果可以，那么就要用递归算法了。
2、如果要用递归算法，那么就思考「遍历」和「分解问题」这两种思维模式，看看哪种更适合这个问题。
3、如果用「分解问题」的思维模式，那么一定要写清楚这个递归函数的定义是什么，然后利用这个定义来分解问题，利用子问题的答案推导原问题的答案；如果用「遍历」的思维模式，那么要用一个无返回值的递归函数，单纯起到遍历递归树，收集目标结果的作用。

其实，「分解问题」的思维模式就对应着后面要讲解的动态规划算法和分治算法，「遍历」的思维模式就对应着后面要讲解的 DFS/回溯算法。


### 动态规划
重叠子问题、最优子结构、状态转移方程就是动态规划三要素，要符合「最优子结构」，子问题间必须互相独立

思维框架，辅助思考状态转移方程：明确「状态」-> 明确「选择」 -> 定义 dp 数组/函数的含义
```python
# 自顶向下递归的动态规划
def dp(状态1, 状态2, ...):
    for 选择 in 所有可能的选择:
        # 此时的状态已经因为做了选择而改变
        result = 求最值(result, dp(状态1, 状态2, ...))
    return result

# 自底向上迭代的动态规划
# 初始化 base case
dp[0][0][...] = base case
# 进行状态转移
for 状态1 in 状态1的所有取值：
    for 状态2 in 状态2的所有取值：
        for ...
            dp[状态1][状态2][...] = 求最值(选择1，选择2...)
```

### 回溯算法
抽象地说，解决一个回溯问题，实际上就是遍历一棵决策树的过程，树的每个叶子节点存放着一个合法答案。你把整棵树遍历一遍，把叶子节点上的答案都收集起来，就能得到所有的合法答案
站在回溯树的一个节点上，你只需要思考 3 个问题：

1、路径：也就是已经做出的选择。

2、选择列表：也就是你当前可以做的选择。

3、结束条件：也就是到达决策树底层，无法再做选择的条件。
```python
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
```

### 链表
什么时候需要用虚拟头结点？当需要创造一条新链表的时候，可以使用虚拟头结点简化边界情况的处理。
