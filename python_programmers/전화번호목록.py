def solution(phone_book):
    phone_book.sort()
    for i,j in zip(phone_book, phone_book[1:]):
        if j.startswith(i) is True:
            return False
    return True