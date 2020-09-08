package dev.esz.algorithms.misc;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MedianOfAStreamTest {

    @Test
    @DisplayName("should return the medians in the stream")
    void findMedianTest() {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        assertThat(medianOfAStream.findMedian()).isCloseTo(2.0, Offset.offset(0.0001));
        medianOfAStream.insertNum(5);
        assertThat(medianOfAStream.findMedian()).isCloseTo(3.0, Offset.offset(0.0001));
        medianOfAStream.insertNum(4);
        assertThat(medianOfAStream.findMedian()).isCloseTo(3.5, Offset.offset(0.0001));
    }
}
