package com.company;

import java.io.*;
import java.util.*;

public class Maps implements Runnable {
    private final ArrayList<String> edges;
    private BufferedReader brMap, brRoute;
    private String destination;
    public final char[][] map = new char[50][100];
    private int x1,y1;
    public String start;

    public Maps(String CurrentLocation, String route, String DesiredRoom) {
        this.destination = DesiredRoom;
        this.edges = new ArrayList<>();
        this.start = CurrentLocation.substring(0,2);
        try {
            this.brMap = new BufferedReader(new FileReader("Maps/" + CurrentLocation));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int y= 0; y<50; y++){
            String line = "";
            try {
                line = brMap.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int x = 0; x< 100; x++){
                this.map[y][x] = line.charAt(x);
            }

        }
        try {
            brMap.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //open and store route for desired location

        try {
            this.brRoute = new BufferedReader(new FileReader("Maps/" + route));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String edg = brRoute.readLine();
            while (edg != null){
                edges.add(edg);
                edg = brRoute.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            brRoute.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean validate(int x, int y){

        return this.map[y][x] != '#';
    }
    public void setXY(int x, int y){
        this.x1 = x;
        this.y1 = y;

    }
    public void setDestination(String d){
        this.destination = d;
    }

    private static void Find_Route(){



    }


    private void breadthFS(int x, int y){
        ArrayList<int[]> explored = new ArrayList<>();
        ArrayList<int[]> route = new ArrayList<>();
        Hashtable<int [], int[]> my_dict = new Hashtable<int[], int[]>();
        Queue<int[]> next = new LinkedList<>();
        next.add(new int[] {x,y});
        
        my_dict.put(new int[]{x, y}, new int[]{-1, -1});
        while(!next.isEmpty()){
            int[] coordinates = next.remove();
            if(inEdge(coordinates[0], coordinates[1])){
                //found
                int[] current = new int[2];
                current = coordinates;
                route.add(current);

               while(true){

                   my_dict.get(current);

               }

            }else{
                explored.add(coordinates);
                if(!explored.contains(new int[] {coordinates[0] -1 ,coordinates[1]}) && map[y][x-1] != '#'){
                    next.add(new int[] {coordinates[0] -1 ,coordinates[1]});
                    my_dict.put(new int[] {coordinates[0] -1 ,coordinates[1]}, coordinates );
                }
                if(!explored.contains(new int[] {coordinates[0] +1 ,coordinates[1]}) && map[y][x+1] != '#'){
                    next.add(new int[] {coordinates[0] +1 ,coordinates[1]});
                    my_dict.put(new int[] {coordinates[0] +1 ,coordinates[1]}, coordinates );
                }
                if(!explored.contains(new int[] {coordinates[0] -1 ,coordinates[1]-1}) && map[y-1][x-1] != '#'){
                    next.add(new int[] {coordinates[0] -1 ,coordinates[1]-1});
                    my_dict.put(new int[] {coordinates[0] -1 ,coordinates[1]-1}, coordinates );
                }
                if(!explored.contains(new int[] {coordinates[0] ,coordinates[1]-1}) && map[y-1][x] != '#'){
                    next.add(new int[] {coordinates[0]  ,coordinates[1]-1});
                    my_dict.put(new int[] {coordinates[0] ,coordinates[1]-1}, coordinates );
                }
                if(!explored.contains(new int[] {coordinates[0] +1 ,coordinates[1]-1}) && map[y-1][x+1] != '#'){
                    next.add(new int[] {coordinates[0] +1 ,coordinates[1]-1});
                    my_dict.put(new int[] {coordinates[0] +1 ,coordinates[1]-1}, coordinates );
                }
                if(!explored.contains(new int[] {coordinates[0] -1 ,coordinates[1]+1}) && map[y+1][x-1] != '#'){
                    next.add(new int[] {coordinates[0] -1 ,coordinates[1]+1});
                    my_dict.put(new int[] {coordinates[0] -1 ,coordinates[1]+1}, coordinates );
                }
                if(!explored.contains(new int[] {coordinates[0] +1 ,coordinates[1]+1}) && map[y+1][x+1] != '#'){
                    next.add(new int[] {coordinates[0] +1 ,coordinates[1]+1});
                    my_dict.put(new int[] {coordinates[0] +1 ,coordinates[1]+1}, coordinates );
                }
                if(!explored.contains(new int[] {coordinates[0] ,coordinates[1]+1}) && map[y+1][x] != '#'){
                    next.add(new int[] {coordinates[0] ,coordinates[1]+1});
                    my_dict.put(new int[] {coordinates[0] ,coordinates[1]+1}, coordinates );
                }


            }

        }


    }
    private double distance(int [] coor){
        return Math.sqrt((coor[0]-coor[1])^2 + (coor[2] - coor[3])^2);
    }

    private boolean inEdge(int x, int y){
        int X1, Y1, X2, Y2;
        for ( String i :  edges){
            X1 = Integer.parseInt(i.substring(0,2));
            Y1 = Integer.parseInt(i.substring(3,5));
            X2 = Integer.parseInt(i.substring(6,8));
            Y2 = Integer.parseInt(i.substring(9,11));
            if (distance(new int[]{X1,x, Y1, y}) + distance(new int[]{X2,x, Y2, y})  == distance(new int[]{X1,X2, Y1, Y2})){
                // point is in edge
                return true;
            }
        }
        return false;
    }



    @Override
    public void run() {

    }
}
