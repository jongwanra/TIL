# 트리 순회(1991)
# https://www.acmicpc.net/problem/1991

def left_child(idx):
    return 2* idx
def right_child(idx):
    return 2* idx + 1

# 전위 순회(root-> left -> right)
def pre_order_traversal(tree, idx):
    if len(tree) < idx or tree[idx] == 0:
        return
    
    print(tree[idx], end="")
    pre_order_traversal(tree, left_child(idx))
    pre_order_traversal(tree, right_child(idx))
    

# 중위 순회(left-> root -> right)
def in_order_traversal(tree, idx):
    if len(tree) < idx or tree[idx] == 0:
        return
    in_order_traversal(tree, left_child(idx))
    print(tree[idx], end="")
    in_order_traversal(tree, right_child(idx))

# 후위 순회(left-> right -> root)
def post_order_traversal(tree, idx):
    if len(tree) < idx or tree[idx] == 0:
        return
    
    post_order_traversal(tree, left_child(idx))
    post_order_traversal(tree, right_child(idx))
    print(tree[idx], end="")

n = int(input())

# 배열 기반 트리를 입력에 맞게끔 생성
tree = [0] * (n + 1) * (n + 1)
tree[1] = 'A'
for _ in range(n):
    node = input().split()
    if node[0] in tree:
        idx = tree.index(node[0])
        if node[1] != '.':
            tree[left_child(idx)] = node[1]
        if node[2] != '.':
            tree[right_child(idx)] = node[2]


pre_order_traversal(tree, 1)
print()
in_order_traversal(tree, 1)
print()
post_order_traversal(tree, 1)