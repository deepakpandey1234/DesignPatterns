package com.deepak.behavioural.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panded4 on 9/8/2016.
 * Example:
 * java.util.Timer (all scheduleXXX() methods)
 * java.util.concurrent.Executor#execute()
 * java.util.concurrent.ExecutorService (the invokeXXX() and submit() methods)
 * java.util.concurrent.ScheduledExecutorService (all scheduleXXX() methods)
 * java.lang.reflect.Method#invoke()
 */
interface ChatMediator {
    void sendMessage(String msg, User user);

    void addUser(User user);
}

abstract class User {
    String name;
    ChatMediator chatMediator;

    public User(ChatMediator chatMediator, String name) {
        this.chatMediator = chatMediator;
        this.name = name;
    }

    abstract void recieve(String msg);

    abstract void send(String msg);
}

class UserImpl extends User {
    public UserImpl(ChatMediator chatMediator, String name) {
        super(chatMediator, name);
    }

    @Override
    void recieve(String msg) {
        System.out.println("UserImpl.recieve");
        System.out.println("msg = " + msg);
        System.out.println("::::::::::::MEDIATOR:::::::::::::");
        chatMediator.sendMessage(msg, this);
    }

    @Override
    void send(String msg) {
        System.out.println("Reciever = " + name + " ::: " + msg);
    }
}

class ChatMediatorImpl implements ChatMediator {
    List<User> users;

    public ChatMediatorImpl() {
        users=new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String msg, User user) {
        for (User u : users) {
            if (u != user) {
                u.recieve(msg);
            }
        }
    }
}

public class MediatorDemo {
    public static void main(String[] args) {
        ChatMediatorImpl chatMediator=new ChatMediatorImpl();

        User u1=new UserImpl(chatMediator,"Deepak");
        User u2=new UserImpl(chatMediator,"Ramesh");
        User u3=new UserImpl(chatMediator,"YOYO");

        chatMediator.addUser(u1);
        chatMediator.addUser(u2);
        chatMediator.addUser(u3);

        u1.send("hi");
        u2.send("hi Deepak !");
        u1.send("hello");
    }
}
