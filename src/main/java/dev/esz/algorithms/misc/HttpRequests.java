package dev.esz.algorithms.misc;

import java.util.Arrays;

// Given a set of time periods needed for handling http requests. We have a loadbalancer which should drop exactly 2
// requests and should balance the existing requests for exactly 3 servers as follows:
// - every server should get a set of consecutive requests
// - every server should be able to work a same amount of time working on requests
// Decide if there is a solution to distribute the requests following the above limitations.
public class HttpRequests {
    public boolean solution(int[] A) {
        if (A == null || A.length < 2) {
            return false;
        }

        // Compute the sum of all requests
        int sumOriginal = Arrays.stream(A).sum();

        int sumFirstPart = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (i - 1 >= 0) {
                sumFirstPart += A[i - 1];
            }
            int sumSecondPart = 0;
            for (int j = A.length - 1; j > i; j--) {
                if (j + 1 < A.length) {
                    sumSecondPart += A[j + 1];
                }
                int sumMiddlePart = sumOriginal - sumFirstPart - sumSecondPart;

                if (sumMiddlePart - A[i] - A[j] == sumFirstPart
                        && sumMiddlePart - A[i] - A[j] == sumSecondPart) {
                    return true;
                }
            }
        }
        return false;
    }
}
