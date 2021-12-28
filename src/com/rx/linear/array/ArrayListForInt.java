package com.rx.linear.array;


public class ArrayListForInt {
    //CRUD
    private int[] data;
    private int size;
    private int capacity;

    public ArrayListForInt(int capacity){
        this.data = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public ArrayListForInt(int[] array){
        //时间复杂度O(n) 空间复杂度O(n)
        this.data = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }
        this.capacity = array.length;
        this.size = array.length;
    }

    public void add(int index, int e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Given index out of bounds.");
        }
        for (int i = size - 1; i >= index ; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        ++size;
    }

    public void addFirst(int e){
        add(0,e);
    }

    public void addLast(int e){
        add(size,e);
    }

    public int get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Given index out of bounds.");
        }
        return data[index];
    }

    public int getFirst(){
        return get(0);
    }

    public int getLast(){
        return get(size-1);
    }

    /**
     * 将索引为index的位置元素设为e。
     * @param index 要更新的索引值
     * @param e 要替代原元素的新元素
     */
    public void set(int index, int e){
        if (index < 0 || index >=size){
            throw new IllegalArgumentException("given index out of bounds");
        }
        data[index] = e;
    }

    /**
     * 查找元素e所在的索引。如果不存在该元素，返回-1。
     * @param e 被查找的元素
     * @return 元素e的索引
     */
    public int find(int e){
        for (int i = 0; i < size; i++) {
            if(data[i] == e){
                return i;
            }
        }
        return -1;
    }

    public int remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Given index out of bounds.");
        }
        int e = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        --size;

        data[size] = 0;
        return e;
    }

    public int removeFirst(){
        return remove(0);
    }

    public int removeLast(){
        return remove(size - 1);
    }

    /**
     * 删除指定元素e（如果它存在）。
     * @param e 需要被删除的元素
     */
    public void removeElement(int e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Type:ArrayListForInt size=%d capacity=%d\n",size,capacity));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if(i != size - 1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
