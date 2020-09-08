package dev.esz.algorithms.misc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumMeetingRoomsTest {
    @Test
    @DisplayName("should return the minimum number of meeting rooms required")
    void maxNumberOfMeetingRoomsTest1() {
        List<Meeting> meetings = new ArrayList<>(List.of(
                new Meeting(1, 4),
                new Meeting(2, 3),
                new Meeting(3, 6)
        ));
        assertThat(MinimumMeetingRooms.findMinimumMeetingRooms(meetings)).isEqualTo(2);
    }

    @Test
    @DisplayName("should return the minimum number of meeting rooms required")
    void maxNumberOfMeetingRoomsTest2() {
        List<Meeting> meetings = new ArrayList<>(List.of(
                new Meeting(4, 5),
                new Meeting(2, 3),
                new Meeting(2, 4),
                new Meeting(3, 5)
        ));
        assertThat(MinimumMeetingRooms.findMinimumMeetingRooms(meetings)).isEqualTo(2);
    }
}
