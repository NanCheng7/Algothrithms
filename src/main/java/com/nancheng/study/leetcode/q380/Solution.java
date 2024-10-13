package com.nancheng.study.leetcode.q380;

import java.util.*;

/**
 * @author: NanCheng
 * @email: nanchengqj@gmail.com
 * @date: 2024/10/13
 */
public class Solution {



    class RandomizedSet {

        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list;
        Random random;

        public RandomizedSet() {
            map  = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false;
            }
            list.add(list.size(), val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            }
            Integer i = map.get(val);
            map.remove(val);
            list.remove(i);
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(list.size());
            return list.get(index);
        }
    }
}
