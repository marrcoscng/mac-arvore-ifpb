package macifpb;

import exception.ValueNullException;

public class Node<T> {

    private T value;

    private Node<T> left;
    private Node<T> right;

    public Node(T value){
        if( value == null ){
            throw new ValueNullException("Null values not are Accept!");
        }
        this.value = value;
    }

    public void setRight(Node<T> right){
        this.right = right;
    }
    public void setLeft(Node<T> left){
        this.left = left;
    }

    public void setValue(T value){
        this.value = value;
    }
    public T getValue(){
        return value;
    }

    public Node<T> getRight(){
        return right;
    }
    public Node<T> getLeft(){
        return left;
    }
}
