package com.rx.linear.array;

/**
 * 自己实现的ArrayList类（动态数组），可存储任意类型。
 */
public class ArrayList<E> {
    private E[] data;
    private int size; //动态数组实际存储元素个数
    private int capacity; //动态数组可存储长度，与内置静态数组长度有关

    public ArrayList(int capacity){
        this.data = (E[]) new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public ArrayList(E[] array){
        //时间复杂度O(n) 空间复杂度O(n)
        this.data = (E[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }
        this.capacity = array.length;
        this.size = array.length;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * 新增：向索引位置index处添加元素e。
     * @param index 添加新元素的索引位置
     * @param e 即将被添加的新元素
     */
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Given index out of bounds.");
        }
        for (int i = size - 1; i >= index ; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        ++size;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    /**
     * 查询：返回指定索引位置的元素
     * @param index 指定索引位置
     * @return 指定索引位置的元素
     */
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Given index out of bounds.");
        }
        return data[index];
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    //时间复杂度O(n)
    private boolean contains(E e){
        for (E datum : data) {
            if(datum.equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 更改：将索引为index的位置元素设为e。
     * @param index 要更新的索引值
     * @param e 要替代原元素的新元素
     */
    public void set(int index, E e){
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
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除：删除指定索引位置的元素，并返回被删除的元素。
     * @param index 指定索引位置
     * @return 被删除的元素
     */
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Given index out of bounds.");
        }
        E e = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        --size;

        // 把原来最后一个元素的指针指向null，而不是和前一个索引指针指向同一个对象，方便GC
        data[size] = null;
        return e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 删除指定元素e（如果它存在）。
     * @param e 需要被删除的元素
     */
    public void removeElement(E e){
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

