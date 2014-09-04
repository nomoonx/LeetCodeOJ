/**
 * Created by noMoon on 2014-08-29.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class maxPoints {
    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public static void main(String[] args) {
        Point a = new Point(2,3);
        Point b = new Point(3,3);
        Point c = new Point(-5,3);
        Point[] points = {a, b, c};
        System.out.println(
                aaa(points));
    }

    public static int aaa(Point[] points){
        int length=points.length;
        if(0==length) return 0;
        if(1==length) return 1;
        int max=-1;
        for (int i=0;i<length;i++){
            int tempMax=0;
            int samePoint=0;
            Map<Double, Integer> result = new HashMap<Double, Integer>();
            for (int j=i+1;j<length;j++){

                int width = points[i].x - points[j].x;
                int height = points[i].y - points[j].y;
                if(0==width&&0==height){
                    samePoint++;
                }else if (0==width){
                    tempMax++;
                }else{
                    double slope=(double)height/(double)width;
                    if(0==height)slope=0.0;
                    if (null == result.get(slope)) {
                        result.put(slope, 1);
                    } else {
                        result.put(slope, result.get(slope) + 1);
                    }
                }

            }
            for (int value : result.values()) {
                if (tempMax < value) tempMax = value;
            }
            if(max<tempMax+samePoint+1) max=tempMax+samePoint+1;
        }
        return max;
    }

    public static int maxPoints(Point[] points) {
        int length = points.length;
        Map<Integer, Integer> pointValue = new HashMap<Integer, Integer>();
        List<Point> pointsList = new ArrayList<Point>();
        pointsList.add(points[0]);
        pointValue.put(0, 1);
        for (int i = 1; i < length; i++) {
            boolean flag = false;
            int j = 0;
            for (; j < pointsList.size(); j++) {
                if (points[i].x == pointsList.get(j).x && points[i].y == pointsList.get(j).y) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                pointValue.put(j, pointValue.get(j) + 1);
            } else {
                pointValue.put(pointsList.size(), 1);
                pointsList.add(points[i]);
            }
        }
        length = pointsList.size();
        if (1 == length) return pointValue.get(0);
        Map<Double, Integer> result = new HashMap<Double, Integer>();
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int width = pointsList.get(i).x - pointsList.get(j).x;
                int height = pointsList.get(i).y - pointsList.get(j).y;
                if (0 == width)
                    max += pointValue.get(i);
                else {
                    Double slope;
                    if(0==height) {
                        slope=0.0;
                    }
                    else{
                        slope = (double) height / (double) width;
                    }

                    if (null == result.get(slope)) {
                        result.put(slope, pointValue.get(i));
                    } else {
                        result.put(slope, result.get(slope) + pointValue.get(i));
                    }
                }
            }
        }

        for (int value : result.values()) {
            if (max < value) max = value;
        }
        return (int) (1 + Math.round(Math.sqrt(1 + 8 * max))) / 2;
    }

}
