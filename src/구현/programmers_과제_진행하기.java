package 구현;

import java.util.*;

public class programmers_과제_진행하기 {


    class Task {
        public String name;
        public Integer startTime;
        public Integer playTime;

        public Task(String name, Integer startTime, Integer playTime) {
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }

        public Integer getEndTime() {
            return startTime + playTime;
        }

        public void reducePlayTime(Integer time) {
            playTime -= time;
        }

    }

    public String[] solution(String[][] plans) {
        String[] answer = {};

        PriorityQueue<Task> pq = new PriorityQueue<Task>(Comparator.comparing(o -> o.startTime));

        for(String[] plan : plans) {
            String time = plan[1];
            String timeSplit[] = time.split(":");
            int startTime = Integer.parseInt(timeSplit[0]) * 60;
            int playTime = startTime + Integer.parseInt(timeSplit[1]);
            Task task = new Task(plan[0], startTime, playTime);
            pq.add(task);
        }

        List<String> ans = new ArrayList<>();

        Task curTask = pq.poll();
        Stack<Task> st = new Stack<Task>();

        while(!pq.isEmpty()) {
            Task nextTask = pq.poll();

            if(curTask.startTime + curTask.playTime == nextTask.startTime) {
                ans.add(curTask.name);
                continue;
            }

            // 새로운 과제가 시작할 시간 됐을 경우
            if(curTask.getEndTime() > nextTask.startTime) {
                curTask.reducePlayTime(curTask.getEndTime() - nextTask.startTime);
                st.add(curTask);
                curTask = nextTask;
            }
            System.out.println(Arrays.toString(pq.toArray()));


            //완료했을때
            if(curTask.getEndTime() < nextTask.startTime) {
                ans.add(curTask.name);
                if(!st.empty()) {
                    curTask = st.pop();
                }else{
                    curTask = nextTask;
                }
            }

        }
        return  ans.toArray(new String[0]);
    }

}
