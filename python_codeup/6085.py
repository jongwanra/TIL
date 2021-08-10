w, h, b = map(int, input().split())
print("%.2f"%round(w*h*b/8/1024/1024, 2), end=" MB")


