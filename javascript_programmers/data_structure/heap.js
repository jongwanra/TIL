class Heap {
    heap;

    constructor() {
        this.heap = [ null ];
    }

    size() {
        return this.heap.length - 1;
    }

    getMin() {
        return this.heap?.[1] || null;
    }

    swap(a, b) {
        [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]];
    }

    heappush(value) {
        this.heap.push(value);
        let currentIdx = this.size();
        let parentIdx = (currentIdx / 2) >> 0;

        while (currentIdx > 1 && this.heap[parentIdx] > this.heap[currentIdx]) {
            this.swap(parentIdx, currentIdx);
            currentIdx = parentIdx;
            parentIdx = (currentIdx / 2) >> 0;
        }
    }

    heappop() {
        const min = this.heap[1];
        if(this.heap.length <= 2) {
            this.heap = [ null];
        }else {
            this.heap[1] = this.heap.pop();
        }

        let currentIdx = 1;
        let leftIdx = currentIdx * 2;
        let rightIdx = curr
    }
}