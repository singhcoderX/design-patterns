package com.aryan.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannelSubject {
    private final String channelName;
    private final List<Subscriber> subscribers = new ArrayList<>();

    public YouTubeChannelSubject(String channelName) {
        this.channelName = channelName;
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println(subscriber.getName() + " subscribed to " + channelName);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
        System.out.println(subscriber.getName() + " unsubscribed from " + channelName);
    }

    public void notifySubscribers(String videoTitle) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(videoTitle);
        }
    }

    public void uploadVideo(String videoTitle) {
        System.out.println(channelName + "Uploading video: " + videoTitle);
        notifySubscribers(videoTitle);
    }
}
