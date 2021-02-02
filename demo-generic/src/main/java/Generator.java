public interface Generator<T> {
    T create(Class<T> t);
    T getValue();
    T genericMethod(Class<T> tClass);
}