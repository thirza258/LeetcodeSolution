public class Leetcode641 {
    private int[] deque;
    private int front;
    private int rear;
    private int size;

    public Leetcode641(int k) {
        deque = new int[k];
        front = -1;
        rear = -1;
        size = k;
    }
    
    public boolean insertFront(int value) {
        // jika deque penuh mengembalikan false karena tidak bisa menambahkan elemen
        if(isFull()) {
            return false;
        }
        // Jika deque kosong, front dan rear akan menjadi 0 karena elemen pertama
        if(front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        }
        // Jika front sudah 0, maka front akan menjadi size - 1 karena langsung di depan elemen terakhir
        else if(front == 0) {
            front = size - 1;
        }
        // jika front bukan 0, maka front akan dikurangi 1 karena elemen sebelumnya
        else {
            front--;
        }
        deque[front] = value;

        return true;
    }
    
    public boolean insertLast(int value) {
        // Jika array penuh, maka tidak bisa menambahkan elemen
        if(isFull()) {
            return false;
        }
        // Jika deque kosong, front dan rear akan menjadi 0 karena elemen pertama
        if(front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        }
        // Jika deque sudah diisi maka rear akan mencari posisi elemen selanjutnya setelah front
        else {
            rear = (rear + 1) % size;
        }
        deque[rear] = value;

        return true;
    }
    
    public boolean deleteFront() {
        // Jika deque kosong, maka tidak bisa menghapus elemen
        if(isEmpty()) {
            return false;
        }
        // Jika deque hanya memiliki 1 elemen, maka front dan rear akan menjadi -1 karena deque kosong
        int temp = deque[front];
        deque[front] = 0;

        if(front == rear) {
            front = -1;
            rear = -1;
        }
        // Jika deque ada isinya maka front akan mencari posisi elemen selanjutnya setelah front
        else {
            front = (front + 1) % size;
        }
        return true;
    }
    
    public boolean deleteLast() {
        // Jika deque kosong, maka tidak bisa menghapus elemen
        if(isEmpty()) {
            return false;
        }

        // Jika deque hanya memiliki 1 elemen, maka front dan rear akan menjadi -1 karena deque kosong
        int temp = deque[rear];
        deque[rear] = 0;

        if(front == rear) {
            front = -1;
            rear = -1;
        }
        // Jika deque ada isinya maka rear akan mencari posisi elemen sebelumnya dari rear
        else if(rear == 0) {
            rear = size - 1;
        }
        // Jika deque ada isinya maka rear akan mencari posisi elemen sebelumnya dari rear
        else {
            rear--;
        }
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) {
            return -1;
        }
        else {
            return deque[front];
        }
    }
    
    public int getRear() {
        if(isEmpty()) {
            return -1;
        }
        else {
            return deque[rear];
        }
    }
    
    public boolean isEmpty() {
        if(front == -1 && rear == -1) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isFull() {
        if((rear + 1) % size == front) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        Leetcode641 leetcode641 = new Leetcode641(3);
        System.out.println(leetcode641.insertLast(1));
        System.out.println(leetcode641.insertLast(2));
        System.out.println(leetcode641.insertFront(3));
        System.out.println(leetcode641.insertFront(4));
        System.out.println(leetcode641.getRear());
        System.out.println(leetcode641.isFull());
        System.out.println(leetcode641.deleteLast());
        System.out.println(leetcode641.insertFront(4));
        System.out.println(leetcode641.getFront());
    }
}
