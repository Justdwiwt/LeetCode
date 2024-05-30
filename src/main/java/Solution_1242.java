package main.java;

import main.utils.HtmlParser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Solution_1242 {
    static class Solution {
        class Task extends Thread {
            String url;

            public Task(String url) {
                this.url = url;
            }

            @Override
            public void run() {
                List<Task> subtasks = new ArrayList<>();
                List<String> nextUrls = htmlParser.getUrls(url);
                nextUrls
                        .stream()
                        .filter(nextUrl -> M.putIfAbsent(nextUrl, Boolean.FALSE) == null)
                        .filter(nextUrl -> rootHostname.equals(getHostName(nextUrl)))
                        .forEach(nextUrl -> {
                            M.put(nextUrl, Boolean.TRUE);
                            ans.add(nextUrl);
                            Task subTask = new Task(nextUrl);
                            subtasks.add(subTask);
                            subTask.start();
                        });
                subtasks.forEach(task -> {
                    try {
                        task.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        ConcurrentHashMap<String, Boolean> M = new ConcurrentHashMap<>();
        String rootHostname;
        List<String> ans = new ArrayList<>();
        HtmlParser htmlParser;

        String getHostName(String url) {
            final int start = 7;
            int end = url.indexOf('/', start);
            if (end == -1) end = url.length();
            return url.substring(start, end);
        }

        public List<String> crawl(String startUrl, HtmlParser htmlParser) {
            this.htmlParser = htmlParser;
            this.rootHostname = getHostName(startUrl);
            M.put(startUrl, Boolean.TRUE);
            ans.add(startUrl);
            Thread work = new Task(startUrl);
            work.start();
            try {
                work.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return ans;
        }
    }
}
