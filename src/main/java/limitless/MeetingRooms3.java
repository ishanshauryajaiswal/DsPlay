package limitless;

import java.util.Arrays;
import java.util.PriorityQueue;

class MeetingRooms3 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Room> minHeap = new PriorityQueue<>((room1, room2) -> {
            if(room1.freeAt != room2.freeAt)
                return Integer.compare(room1.freeAt, room2.freeAt);
            else
                return Integer.compare(room1.id, room2.id);
        });
        int max = 0, ans = 0;
        int size = meetings.length;

        for(int i = 0; i < n; i++){
            minHeap.add(new Room(i, 0, 0));
        }
        for(int i = 0; i < size; i++){
            Room room = minHeap.poll();
            int start = meetings[i][0];
            int end = meetings[i][1];
            int duration = end - start;

            if(start < room.freeAt){
                room.freeAt+=duration;
                room.freq++;
            }
            else{
                Room bestRoom = null;
                for(Room r : minHeap){ // iterate over the heap
                    if(r.freeAt <= start){ // if room's free time is less than or equal to start time
                        if(bestRoom == null || r.id < bestRoom.id){ // if best room is null or room's id is less than best room's id
                            bestRoom = r; // update best room
                        }
                    }
                }
                if(bestRoom != null){ // if best room is found
                    minHeap.remove(bestRoom); // remove it from the heap
                    bestRoom.freeAt = end; // update its free time
                    bestRoom.freq++; // update its frequency
                    minHeap.add(bestRoom); // add it back to the heap
                }
            }
        }

        while(!minHeap.isEmpty()){
            Room r = minHeap.poll();
            if(r.freq > max){
                max = r.freq;
                ans = r.id;
            }
        }

        return ans;

    }

    class Room{
        public int id;
        public int freeAt;
        public int freq;

        public Room(int id, int freeAt, int freq){
            this.id = id;
            this.freeAt = freeAt;
            this.freq = freq;
        }
    }
}