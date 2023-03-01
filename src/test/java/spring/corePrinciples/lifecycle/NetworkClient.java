package spring.corePrinciples.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;

public class NetworkClient {
    @Setter
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + ", message : " + message);
    }

    public void connect() {
        System.out.println("connect : " + url);
    }

    @PostConstruct
    public void init() {
        connect();
        call("초기화 연결 메시지");
    }
    @PreDestroy
    public void disconnect() {
        System.out.println("disconnect : " + url);
    }
}
