package dev.esz.algorithms.misc;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Meeting {
    private final int start;
    private final int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

// Given an array of meeting time intervals consisting of start and end times find the minimum number of conference rooms required.
public class MinimumMeetingRooms {
    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        meetings.sort(Comparator.comparingInt(Meeting::getStart));
        int maxNumberOfRooms = 1;
        int meetingEnd = meetings.get(0).getEnd();
        List<Meeting> meetingsInProgress = new LinkedList<>();
        meetingsInProgress.add(meetings.get(0));
        for (int i = 1; i < meetings.size(); i++) {
            Meeting meeting = meetings.get(i);
            if (meetingEnd > meeting.getStart()) {
                meetingsInProgress.removeIf(m -> m.getEnd() <= meeting.getStart());
                meetingsInProgress.add(meeting);
                meetingEnd = Math.max(meetingEnd, meeting.getEnd());
            } else {
                maxNumberOfRooms = Math.max(meetingsInProgress.size(), maxNumberOfRooms);
            }
        }
        maxNumberOfRooms = Math.max(meetingsInProgress.size(), maxNumberOfRooms);
        return maxNumberOfRooms;
    }
}
