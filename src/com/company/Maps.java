package com.company;

import java.awt.geom.Line2D;
import java.io.*;
import java.util.*;

public class Maps extends Thread{
    private final ArrayList<String> edges;
    private BufferedReader brMap, brRoute;
    private String destination;
    public final char[][] map = new char[50][100];
    protected int x1,y1;
    protected String start, CurrLoc;
    protected ArrayList<String> route;

    public Maps(String CurrentLocation, String route, String DesiredRoom) {
        this.destination = DesiredRoom;
        this.CurrLoc = "Maps/" + CurrentLocation;
        this.edges = new ArrayList<>();
        this.start = CurrentLocation.substring(0,2);
        try {
            this.brMap = new BufferedReader(new FileReader(this.CurrLoc));
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
            this.brMap.close();
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
            String edg = this.brRoute.readLine();
            while (edg != null){
                this.edges.add(edg);
                edg = brRoute.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.brRoute.close();
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

    private String pack(int[] xy){
        if(xy[0] < 10) {
            if (xy[1] < 10){
                return "0" + xy[0] + ",0" + xy[1];

            }else{
                return  "0" + xy[0] + "," + xy[1];
            }
        }else{
            if (xy[1] < 10){
                return "" + xy[0] + ",0" + xy[1] ;

            }else{
                return  "" + xy[0] + "," + xy[1] ;
            }
        }
    }
    private int[] unpack(String xy){
        int a = Integer.parseInt(xy.substring(0,2));
        int b =  Integer.parseInt(xy.substring(3,5));
        return new int[]{a,b};

    }



    protected void breadthFS(int x, int y){
        ArrayList<String> explored = new ArrayList<>();
        this.route = new ArrayList<>();
        Hashtable<String, String> my_dict = new Hashtable<>();
        my_dict.put(pack(new int[]{x, y}), pack(new int[]{x, y}));

        Queue<String> next = new LinkedList<>();
        next.add(pack(new int[] {x,y}));
        while(!next.isEmpty()){

            String c = next.remove();
            int[] coordinates = unpack(c).clone();
            if(inEdge(coordinates[0], coordinates[1])){
                //found
                System.out.println("here");
                String current;
                String child;
                current = pack(coordinates);
                this.route.add(current);
               while(true){
                   child = current;
                   current = my_dict.get(current);
                   if(child.equals(current)){
                       break;
                   }
                   this.route.add(current);
               }
                Collections.reverse(this.route);
            }else{
                if(!explored.contains(pack(coordinates))){
                    explored.add(pack(coordinates));


                    //System.out.println("explored: " +coordinates[0] + " " + coordinates[1] + "    curr: " + map[coordinates[1]][coordinates[0]]);
                }else{
                    continue;
                }

                if(!explored.contains(pack(new int[]{coordinates[0] -1,coordinates[1]}))&& !next.contains(pack(new int[]{coordinates[0] -1,coordinates[1]})) && map[coordinates[1]][coordinates[0]-1] != '#'){
                    //System.out.println("1" + map[y][x-1]);
                    next.add(pack(new int[] {coordinates[0] -1 ,coordinates[1]}));
                    my_dict.put(pack(new int[] {coordinates[0] -1 ,coordinates[1]}), pack(coordinates));
                }
                if(!explored.contains(pack(new int[]{coordinates[0] +1,coordinates[1]}))  &&  !next.contains(pack(new int[]{coordinates[0] +1,coordinates[1]})) && map[coordinates[1]][coordinates[0]+1] != '#'){
                   // System.out.println("2" + map[y][x+1]);
                    next.add(pack(new int[] {coordinates[0] +1 ,coordinates[1]}));
                    my_dict.put(pack(new int[] {coordinates[0] +1 ,coordinates[1]}), pack(coordinates));
                }
                if(!explored.contains(pack(new int[]{coordinates[0] -1,coordinates[1] -1 })) && !next.contains(pack(new int[]{coordinates[0] -1,coordinates[1] -1 })) && map[coordinates[1]-1][coordinates[0]-1] != '#'){
                 //   System.out.println("3"+ map[y-1][x-1] + ": "+ y);
                    next.add(pack(new int[] {coordinates[0] -1 ,coordinates[1]-1}));
                    my_dict.put(pack(new int[] {coordinates[0] -1 ,coordinates[1]-1}), pack(coordinates ));
                }
                if(!explored.contains(pack(new int[]{coordinates[0],coordinates[1]-1})) && !next.contains(pack(new int[]{coordinates[0],coordinates[1]-1})) && map[coordinates[1]-1][coordinates[0]] != '#'){
                 //   System.out.println("4"+ map[y-1][x] + ": "+ y);
                    next.add(pack(new int[] {coordinates[0]  ,coordinates[1]-1}));
                    my_dict.put(pack(new int[] {coordinates[0] ,coordinates[1]-1}), pack(coordinates ));
                }
                if(!explored.contains(pack(new int[]{coordinates[0]+1,coordinates[1]-1})) && !next.contains(pack(new int[]{coordinates[0]+1,coordinates[1]-1}))  && map[coordinates[1]-1][coordinates[0]+1] != '#'){
                  //  System.out.println("5"+ map[y-1][x+1] + ": "+ y);
                    next.add(pack(new int[] {coordinates[0] +1 ,coordinates[1]-1}));
                    my_dict.put(pack(new int[] {coordinates[0] +1 ,coordinates[1]-1}), pack(coordinates) );
                }
                if(!explored.contains(pack(new int[]{coordinates[0] -1,coordinates[1]+1 })) && !next.contains(pack(new int[]{coordinates[0] -1,coordinates[1]+1 })) && map[coordinates[1]+1][coordinates[0]-1] != '#'){
                  //  System.out.println("6"+ map[y+1][x-1]);
                    next.add(pack(new int[] {coordinates[0] -1 ,coordinates[1]+1}));
                    my_dict.put(pack(new int[] {coordinates[0] -1 ,coordinates[1]+1}), pack(coordinates ));
                }
                if(!explored.contains(pack(new int[]{coordinates[0] +1,coordinates[1]+1 })) && !next.contains(pack(new int[]{coordinates[0] +1,coordinates[1]+1 }))  && map[coordinates[1]+1][coordinates[0]+1] != '#'){
                   // System.out.println("7"+ map[y+1][x+1]);
                    next.add(pack(new int[] {coordinates[0] +1 ,coordinates[1]+1}));
                    my_dict.put(pack(new int[] {coordinates[0] +1 ,coordinates[1]+1}), pack(coordinates ));
                }
                if(!explored.contains(pack(new int[]{coordinates[0] ,coordinates[1]+1})) && !next.contains(pack(new int[]{coordinates[0] ,coordinates[1]+1})) && map[coordinates[1]+1][coordinates[0]] != '#'){
                    //System.out.println("8"+ map[y+1][x]);
                    next.add(pack(new int[] {coordinates[0] ,coordinates[1]+1}));
                    my_dict.put(pack(new int[] {coordinates[0] ,coordinates[1]+1}), pack(coordinates ));
                }
            }
        }


        System.out.println("not");


    }
    private boolean inEdge(int x, int y){
        double X1, Y1, X2, Y2;
       System.out.println("once " + x + "," + y);
        for ( String i :  this.edges){
            X1 = Integer.parseInt(i.substring(0,2));
            Y1 = Integer.parseInt(i.substring(3,5));
            X2 = Integer.parseInt(i.substring(6,8));
            Y2 = Integer.parseInt(i.substring(9,11));
            Line2D line2D = new Line2D.Double(X1,Y1, X2, Y2);
            //System.out.println("testing : " +X1 + "," + Y1 + "   " + X2 + "," + Y2);
            if(line2D.contains(x,y)){
                System.out.println("true");
                return true;
            }
        }
        return false;
    }
    @Override
    public void run() {
        breadthFS(this.x1,this.y1);
        System.out.println("done");

    }
}
