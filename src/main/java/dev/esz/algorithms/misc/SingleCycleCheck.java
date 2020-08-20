package dev.esz.algorithms.misc;

public interface SingleCycleCheck {
    private static boolean isEverythingTouched(boolean[] touched) {
        for (boolean t : touched) {
            if (!t) {
                return false;
            }
        }
        return true;
    }

    static boolean hasSingleCycle(int[] array) {
        boolean[] touched = new boolean[array.length];
        int position = 0;
        touched[position] = true;
        while (true) {
            position += array[position];
            if (position >= array.length) {
                position = (position % array.length);
            }
            if (position < 0) {
                position = array.length - ((-position) % array.length);
                if (position >= array.length) {
                    position -= array.length;
                }
            }
            if (position == 0 && isEverythingTouched(touched)) {
                return true;
            }
            if (touched[position]) {
                return false;
            }
            touched[position] = true;
        }
    }
}
