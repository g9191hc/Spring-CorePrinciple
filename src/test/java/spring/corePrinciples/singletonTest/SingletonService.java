package spring.corePrinciples.singletonTest;

public class SingletonService {
    private static final SingletonService singletonService = new SingletonService();

    public static SingletonService getSingletonService(){
        return singletonService;
    }
    private SingletonService(){};
}
