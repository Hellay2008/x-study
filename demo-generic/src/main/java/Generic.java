import lombok.SneakyThrows;

public  class Generic<T, S> {

    private T t;

    public Generic(T t){
        this.t = t;
    }

    public T getObject(){
        return this.t;
    }

    public S map(T t){
        return null;
    }


}
