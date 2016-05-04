package com.lnho.leetcode.common;

import java.util.List;

/**
 * Created by Administrator on 2016-05-04.
 */

public class TestUtil {
    public static void print(Object o) {
        if (o instanceof Integer || o instanceof String) {
            System.out.print(o);
        } else if (o instanceof List) {
            List list = (List) o;
            System.out.print("[");
            for (int i = 0; i < list.size(); i++) {
                Object e = list.get(i);
                print(e);
                if (i != list.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        } else if (o instanceof int[]) {
            int[] list = (int[]) o;
            System.out.print("[");
            for (int i = 0; i < list.length; i++) {
                Object e = list[i];
                print(e);
                if (i != list.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        } else if (o instanceof Object[]) {
            Object[] list = (Object[]) o;
            System.out.print("[");
            for (int i = 0; i < list.length; i++) {
                Object e = list[i];
                print(e);
                if (i != list.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
    }
}
