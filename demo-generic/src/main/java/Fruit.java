import lombok.SneakyThrows;

public class Fruit <T> implements Generator<T>{
    private T t;
    @SneakyThrows
    public Fruit(Class<T> t){
        this.t = t.newInstance();
    }
    @Override
    @SneakyThrows
    public T create(Class<T> t) {
        return t.newInstance();
    }

    @Override
    public T getValue(){
        return t;
    }

    @Override
    @SneakyThrows
    public T genericMethod(Class<T> tClass) {
        return tClass.newInstance();
    }
}
