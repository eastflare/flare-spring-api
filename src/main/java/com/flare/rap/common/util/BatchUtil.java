package com.flare.rap.common.util;

import java.util.List;

import lombok.experimental.UtilityClass;

@UtilityClass

public class BatchUtil {
    private static final int BUFFER_SIZE = 10;
    public static int getBatchLoopCount(int listTotalSize){
        return (listTotalSize + BUFFER_SIZE - 1) / BUFFER_SIZE;
    }

    public static <T> List<T> getSubList(List<T> list, int index){
        int fromIndex = index * BUFFER_SIZE;
        int toIndex = Math.min((index + 1) * BUFFER_SIZE, list.size());

        return list.subList(fromIndex, toIndex);
    }
}