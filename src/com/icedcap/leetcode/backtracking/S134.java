package com.icedcap.leetcode.backtracking;

/**
 * 134. Gas Station(M)
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *
 * Note:
 * The solution is guaranteed to be unique.
 *
 */
public class S134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=gas.length, end=0, sum=0;
        do sum+= sum>0? gas[end]-cost[end++]: gas[--start]-cost[start]; while (start!=end);
        return sum>=0? start: -1;
    }
}
