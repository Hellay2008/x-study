package com.example.demoasync;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class CompletableFutureTests {
    @Test
    void contextLoads() {
    }

    /**
     * CompletableFuture类实现了CompletionStage和Future接口。Future是Java 5添加的类，用来描述一个异步计算的结果，但是获取一个结果时方法较少,
     * 要么通过轮询isDone，确认完成后，调用get()获取值，要么调用get()设置一个超时时间。但是这个get()方法会阻塞住调用线程，这种阻塞的方式显然和我们的异步编程的初衷相违背。
     * 为了解决这个问题，JDK吸收了guava的设计思想，加入了Future的诸多扩展功能形成了CompletableFuture。
     * CompletionStage是一个接口，从命名上看得知是一个完成的阶段，它里面的方法也标明是在某个运行阶段得到了结果之后要做的事情。
     * 作者：数齐
     * 链接：https://www.jianshu.com/p/6f3ee90ab7d3/
     * 1 转换
     * public <U> CompletionStage<U> thenApply(Function<? super T,? extends U> fn);
     * public <U> CompletionStage<U> thenApplyAsync(Function<? super T,? extends U> fn);
     * public <U> CompletionStage<U> thenApplyAsync(Function<? super T,? extends U> fn,Executor executor);
     * 首先说明一下已Async结尾的方法都是可以异步执行的，如果指定了线程池，会在指定的线程池中执行，如果没有指定，默认会在ForkJoinPool.commonPool()中执行，
     * 下文中将会有好多类似的，都不详细解释了。关键的入参只有一个Function，它是函数式接口，所以使用Lambda表示起来会更加优雅。它的入参是上一个阶段计算后的结果，
     * 返回值是经过转化后结果。
     */
    @Test
    public void thenApply() {
        String result = CompletableFuture.supplyAsync(() -> "hello").thenApply(s -> s + " world").join();
        System.out.println(result);
    }

    /** 2 上一步结果进行消费
     * public CompletionStage<Void> thenAccept(Consumer<? super T> action);
     * public CompletionStage<Void> thenAcceptAsync(Consumer<? super T> action);
     * public CompletionStage<Void> thenAcceptAsync(Consumer<? super T> action,Executor executor);
     * thenAccept是针对结果进行消费，因为他的入参是Consumer，有入参无返回值。
     */

    @Test
    public void thenAccept(){
        CompletableFuture.supplyAsync(() -> "hello").thenAccept(s -> System.out.println(s+" world"));
    }

    /** 3 对上一步的计算结果不关心，执行下一个操作
     * thenRun它的入参是一个Runnable的实例，表示当得到上一步的结果时的操作。
     * public CompletionStage<Void> thenRun(Runnable action);
     * public CompletionStage<Void> thenRunAsync(Runnable action);
     * public CompletionStage<Void> thenRunAsync(Runnable action,Executor executor);
     */
    @Test
    public void thenRun(){
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenRun(() -> System.out.println("hello world")).join();
    }

    /**
     * 4.结合两个CompletionStage的结果，进行转化后返回
     * public <U,V> CompletionStage<V> thenCombine(CompletionStage<? extends U> other,BiFunction<? super T,? super U,? extends V> fn);
     * public <U,V> CompletionStage<V> thenCombineAsync(CompletionStage<? extends U> other,BiFunction<? super T,? super U,? extends V> fn);
     * public <U,V> CompletionStage<V> thenCombineAsync(CompletionStage<? extends U> other,BiFunction<? super T,? super U,? extends V> fn,Executor executor);
     */
    @Test
    public void thenCombine(){
        String result = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return " world";
        }), (s1, s2) -> s1 + s2).join();
        System.out.println(result);
    }

    /**
     * 5 结合两个CompletionStage的结果，进行消耗
     * public <U> CompletionStage<Void> thenAcceptBoth(CompletionStage<? extends U> other,BiConsumer<? super T, ? super U> action);
     * public <U> CompletionStage<Void> thenAcceptBothAsync(CompletionStage<? extends U> other,BiConsumer<? super T, ? super U> action);
     * public <U> CompletionStage<Void> thenAcceptBothAsync(CompletionStage<? extends U> other,BiConsumer<? super T, ? super U> action,     Executor executor);
     * 它需要原来的处理返回值，并且other代表的CompletionStage也要返回值之后，利用这两个返回值，进行消耗。
     */

    @Test
    public void thenAcceptBoth(){
        CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenAcceptBoth(CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return " world";
        }), (s1, s2) -> System.out.println(s1+s2)).join();
    }

    /**
     * 6 在两个CompletionStage都运行完执行。
     * public CompletionStage<Void> runAfterBoth(CompletionStage<?> other,Runnable action);
     * public CompletionStage<Void> runAfterBothAsync(CompletionStage<?> other,Runnable action);
     * public CompletionStage<Void> runAfterBothAsync(CompletionStage<?> other,Runnable action,Executor executor);
     * 不关心这两个CompletionStage的结果，只关心这两个CompletionStage执行完毕，之后在进行操作（Runnable）。
     */
    @Test
    public void testRunAfterBoth(){
        CompletableFuture.supplyAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s1";
        }).runAfterBoth(CompletableFuture.supplyAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s2";
        }),() -> System.out.println("hello world")).join();
    }

    /**
     * 7 两个CompletionStage，谁计算的快，我就用那个CompletionStage的结果进行下一步的转化操作。
     * public <U> CompletionStage<U> applyToEither(CompletionStage<? extends T> other,Function<? super T, U> fn);
     * public <U> CompletionStage<U> applyToEitherAsync(CompletionStage<? extends T> other,Function<? super T, U> fn);
     * public <U> CompletionStage<U> applyToEitherAsync(CompletionStage<? extends T> other,Function<? super T, U> fn,Executor executor);
     */
    @Test
    public void applyToEither(){
        String result = CompletableFuture.supplyAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s1";
        }).applyToEither(CompletableFuture.supplyAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s2";
        }), (s) -> s).join();
        System.out.println(result);
    }

    /**
     * 8 两个CompletionStage，谁计算的快，我就用那个CompletionStage的结果进行下一步的消耗操作。
     * public CompletionStage<Void> acceptEither(CompletionStage<? extends T> other,Consumer<? super T> action);
     * public CompletionStage<Void> acceptEitherAsync(CompletionStage<? extends T> other,Consumer<? super T> action);
     * public CompletionStage<Void> acceptEitherAsync(CompletionStage<? extends T> other,Consumer<? super T> action,Executor executor);
     */
    @Test
    public void acceptEither(){
        CompletableFuture.supplyAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s1";
        }).acceptEither(CompletableFuture.supplyAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s2";
        }), System.out::println).join();
    }

    /**
     * 9 两个CompletionStage，任何一个完成了都会执行下一步的操作（Runnable）。
     * public CompletionStage<Void> runAfterEither(CompletionStage<?> other,Runnable action);
     * public CompletionStage<Void> runAfterEitherAsync(CompletionStage<?> other,Runnable action);
     * public CompletionStage<Void> runAfterEitherAsync(CompletionStage<?> other,Runnable action,Executor executor);
     */
    @Test
    public void runAfterEither() {
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s1";
        }).runAfterEither(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s2";
        }), () -> System.out.println("hello world")).join();
    }

    /**
     * 10 当运行时出现了异常，可以通过exceptionally进行补偿
     * public CompletionStage<T> exceptionally(Function<Throwable, ? extends T> fn);
     */
    @Test
    public void exceptionally() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (1 == 1) {
                throw new RuntimeException("测试一下异常情况");
            }
            return "s1";
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "hello world";
        }).join();
        System.out.println(result);
    }

    /**
     * 11 当运行完成时，对结果的记录。这里的完成时有两种情况，一种是正常执行，返回值。另外一种是遇到异常抛出造成程序的中断。这里为什么要说成记录，因为这几个方法都会返回CompletableFuture，
     * 当Action执行完毕后它的结果返回原始的CompletableFuture的计算结果或者返回异常。所以不会对结果产生任何的作用。
     * public CompletionStage<T> whenComplete(BiConsumer<? super T, ? super Throwable> action);
     * public CompletionStage<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action);
     * public CompletionStage<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action,Executor executor);
     * 这里也可以看出，如果使用了exceptionally，就会对最终的结果产生影响，它没有口子返回如果没有异常时的正确的值，这也就引出下面我们要介绍的handle。
     */
    @Test
    public void whenComplete() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (1 == 1) {
                throw new RuntimeException("测试一下异常情况");
            }
            return "s1";
        }).whenComplete((s, t) -> {
            System.out.println(s);
            System.out.println(t.getMessage());
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "hello world";
        }).join();
        System.out.println(result);
    }

    /**
     * 12 运行完成时，对结果的处理。这里的完成时有两种情况，一种是正常执行，返回值。另外一种是遇到异常抛出造成程序的中断。
     * public <U> CompletionStage<U> handle(BiFunction<? super T, Throwable, ? extends U> fn);
     * public <U> CompletionStage<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn);
     * public <U> CompletionStage<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn,Executor executor);
     */
    @Test
    public void handle() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //出现异常
            if (1 == 1) {
                throw new RuntimeException("测试一下异常情况");
            }
            return "s1";
        }).handle((s, t) -> {
            if (t != null) {
                return "hello world";
            }
            return s;
        }).join();
        System.out.println(result);
    }

    @Test
    public void handle1() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s1";
        }).handle((s, t) -> {
            if (t != null) {
                return "hello world";
            }
            return s;
        }).join();
        System.out.println(result);
    }


}
