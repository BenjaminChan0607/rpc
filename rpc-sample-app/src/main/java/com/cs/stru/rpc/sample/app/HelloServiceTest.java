package com.cs.stru.rpc.sample.app;

import com.cs.stru.rpc.client.RpcClient;
import com.cs.stru.rpc.sample.client.HelloService;
import com.cs.stru.rpc.sample.client.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-client.xml")
public class HelloServiceTest {

    @Autowired
    private RpcClient rpcClient;

    @Test
    public void helloTest1() {
        try {
            // 调用代理的create方法，代理HelloService接口
            HelloService helloService = rpcClient.create(HelloService.class);
            // 调用代理的方法，执行invoke
            String result = helloService.hello("World");
            System.out.println("服务端返回结果：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void helloTest2() {
        HelloService helloService = rpcClient.create(HelloService.class);
        String result = helloService.hello(new Person("Yong", "Huang"));
        System.out.println("服务端返回结果：" + result);
    }
}
