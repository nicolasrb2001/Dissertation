package com.company;

import java.awt.geom.Line2D;
import java.io.*;
import java.util.*;

public class Maps extends Thread{
    private final ArrayList<String> edges;
    private BufferedReader brMap, brRoute, brRooms;
    private String destination;
    public final char[][] map = new char[50][100];
    protected int x1,y1;
    private String end, building, floor;
    protected String start, CurrentLocation, routetxt;
    protected ArrayList<String> route;
    private ArrayList<String> stairs;
    protected ArrayList<String> rooms;
    private boolean st = false;
    private boolean first = false;
    private double X1, Y1, X2, Y2;
    private String d;


    public Maps(String c, String r, String d) {
        this.destination = d;
        this.d = d;
        this.route = new ArrayList<>();

        this.CurrentLocation = c;
        this.routetxt = r;
        this.stairs = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.edges = new ArrayList<>();

        try {
            this.brMap = new BufferedReader(new FileReader(this.CurrentLocation));
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
            this.brRoute = new BufferedReader(new FileReader(this.routetxt));
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
        try {
            this.brRooms = new BufferedReader(new FileReader( CurrentLocation.substring(0, CurrentLocation.lastIndexOf("/")) + "/Rooms.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String room;
        try {
            room = this.brRooms.readLine();
            while(room != null){
                this.rooms.add(room);
                room = this.brRooms.readLine();
            }
            this.brRooms.close();
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
    public void setStart(String s){
        this.start = s;
    }
    public void setST(){
        this.st = true;
    }
    public void setFloor(String f){
        this.floor = f;
    }
    public String getEnd(){
        return this.end;
    }
    public String getBuilding(){
        return this.building;
    }
    public String getFloor(){
        return this.floor;
    }
    public void setBuilding(String b){
        this.building = b;
    }

    public String pack(int[] xy){
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
    public static int[] unpack(String xy){
        int a = Integer.parseInt(xy.substring(0,2));
        int b =  Integer.parseInt(xy.substring(3,5));
        return new int[]{a,b};

    }
    private void findEnd(String i){
        for(String r : this.rooms){
            if(r.contains(i)){
                this.end = r.replace(i, "").replace(": ", "");
            }
        }
    }
    public void findRoute(){
        if(this.destination.equals("Stairs")){

            for(String room : this.rooms){
                if(room.contains("airs")){
                    this.stairs.add(room.substring(9,14));

                }
            }
        }else{
            for (String room : this.rooms){
                if(room.contains(this.destination)){


                    this.end = this.destination;
                    this.destination = room.replace(this.destination, "");
                    this.destination = this.destination.replace(": ", "");

                    break;
                }
            }

        }


        ArrayList<String> explored = new ArrayList<>();
        Hashtable<String, String> my_dict = new Hashtable<>();
        Stack<String> next = new Stack<>();
        next.push(this.start);
        String current;
        String child;
        String result;
        while(true){
            if(first){
                next.pop();
                first = false;
                next.push(pack(new int[]{( int)this.X1,(int) this.Y1}));
                next.push(pack(new int[]{( int)this.X2,(int) this.Y2}));
                my_dict.put(pack(new int[]{( int)this.X1,(int) this.Y1}), this.start);
                my_dict.put(pack(new int[]{( int)this.X2,(int) this.Y2}), this.start);
                continue;
            }
            current = next.pop();
            for(String edg : this.edges){
                if (edg.contains(current)){
                    result = edg.replace(current, "");
                    result = result.replace(" ", "");
                    if (!explored.contains(result) && !my_dict.containsKey(result)){
                        next.push(result);
                        my_dict.put(result, current);
                        if(result.equals(this.destination) ||  this.stairs.contains(result)  ){
                            if(this.stairs.contains(result)){
                                findEnd(result);
                            }
                            explored.clear();
                            explored.add(result);
                            while(true){
                                child = my_dict.get(result);
                                if(child.equals(this.start)){
                                    explored.add(child);
                                    break;
                                }
                                explored.add(child);

                                result = child;
                            }
                            Collections.reverse(explored);
                            this.route.addAll(explored);
                            return;
                        }

                    }
                }
            }
            explored.add(current);
        }
    }



    protected void breadthFS(int x, int y){
        ArrayList<String> explored = new ArrayList<>();

        Hashtable<String, String> my_dict = new Hashtable<>();
        my_dict.put(pack(new int[]{x, y}), pack(new int[]{x, y}));

        Queue<String> next = new LinkedList<>();
        next.add(pack(new int[] {x,y}));
        while(!next.isEmpty()){

            String c = next.remove();
            int[] coordinates = unpack(c).clone();

            if(inEdge(coordinates[0], coordinates[1])){
                //found
                this.start = pack(coordinates);
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
               return;
            }else{
                if(!explored.contains(pack(coordinates))){
                    explored.add(pack(coordinates));
                }else{
                    continue;
                }

                if(!explored.contains(pack(new int[]{coordinates[0] -1,coordinates[1]}))&& !next.contains(pack(new int[]{coordinates[0] -1,coordinates[1]})) && map[coordinates[1]][coordinates[0]-1] != '#'){

                    next.add(pack(new int[] {coordinates[0] -1 ,coordinates[1]}));
                    my_dict.put(pack(new int[] {coordinates[0] -1 ,coordinates[1]}), pack(coordinates));
                }
                if(!explored.contains(pack(new int[]{coordinates[0] +1,coordinates[1]}))  &&  !next.contains(pack(new int[]{coordinates[0] +1,coordinates[1]})) && map[coordinates[1]][coordinates[0]+1] != '#'){

                    next.add(pack(new int[] {coordinates[0] +1 ,coordinates[1]}));
                    my_dict.put(pack(new int[] {coordinates[0] +1 ,coordinates[1]}), pack(coordinates));
                }
                if(!explored.contains(pack(new int[]{coordinates[0] -1,coordinates[1] -1 })) && !next.contains(pack(new int[]{coordinates[0] -1,coordinates[1] -1 })) && map[coordinates[1]-1][coordinates[0]-1] != '#'){

                    next.add(pack(new int[] {coordinates[0] -1 ,coordinates[1]-1}));
                    my_dict.put(pack(new int[] {coordinates[0] -1 ,coordinates[1]-1}), pack(coordinates ));
                }
                if(!explored.contains(pack(new int[]{coordinates[0],coordinates[1]-1})) && !next.contains(pack(new int[]{coordinates[0],coordinates[1]-1})) && map[coordinates[1]-1][coordinates[0]] != '#'){

                    next.add(pack(new int[] {coordinates[0]  ,coordinates[1]-1}));
                    my_dict.put(pack(new int[] {coordinates[0] ,coordinates[1]-1}), pack(coordinates ));
                }
                if(!explored.contains(pack(new int[]{coordinates[0]+1,coordinates[1]-1})) && !next.contains(pack(new int[]{coordinates[0]+1,coordinates[1]-1}))  && map[coordinates[1]-1][coordinates[0]+1] != '#'){

                    next.add(pack(new int[] {coordinates[0] +1 ,coordinates[1]-1}));
                    my_dict.put(pack(new int[] {coordinates[0] +1 ,coordinates[1]-1}), pack(coordinates) );
                }
                if(!explored.contains(pack(new int[]{coordinates[0] -1,coordinates[1]+1 })) && !next.contains(pack(new int[]{coordinates[0] -1,coordinates[1]+1 })) && map[coordinates[1]+1][coordinates[0]-1] != '#'){

                    next.add(pack(new int[] {coordinates[0] -1 ,coordinates[1]+1}));
                    my_dict.put(pack(new int[] {coordinates[0] -1 ,coordinates[1]+1}), pack(coordinates ));
                }
                if(!explored.contains(pack(new int[]{coordinates[0] +1,coordinates[1]+1 })) && !next.contains(pack(new int[]{coordinates[0] +1,coordinates[1]+1 }))  && map[coordinates[1]+1][coordinates[0]+1] != '#'){

                    next.add(pack(new int[] {coordinates[0] +1 ,coordinates[1]+1}));
                    my_dict.put(pack(new int[] {coordinates[0] +1 ,coordinates[1]+1}), pack(coordinates ));
                }
                if(!explored.contains(pack(new int[]{coordinates[0] ,coordinates[1]+1})) && !next.contains(pack(new int[]{coordinates[0] ,coordinates[1]+1})) && map[coordinates[1]+1][coordinates[0]] != '#'){

                    next.add(pack(new int[] {coordinates[0] ,coordinates[1]+1}));
                    my_dict.put(pack(new int[] {coordinates[0] ,coordinates[1]+1}), pack(coordinates ));
                }
            }
        }
    }
    protected void findstart(String s){
        for(String i : this.rooms){
            if(i.contains(s)){
                this.setStart(i.replace(s,"").replace(": ", ""));
                break;
            }
        }
    }
    private boolean inEdge(int x, int y){


        for ( String i :  this.edges){
            this.X1 = Integer.parseInt(i.substring(0,2));
            this.Y1 = Integer.parseInt(i.substring(3,5));
            this.X2 = Integer.parseInt(i.substring(6,8));
            this.Y2 = Integer.parseInt(i.substring(9,11));
            if(Line2D.ptSegDist(X1,Y1, X2, Y2, x, y) == 0){

                return true;
            }
        }
        return false;
    }
    @Override
    public void run() {
        if(!this.st){
            breadthFS(this.x1,this.y1);
            System.out.println("route start is: ");
            for(String i : this.route){
                System.out.println(i);
            }

            this.first = true;
        }

        while(!this.st){
            try {

                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        findRoute();
        System.out.println("route final is: ");
        for(String i : this.route){
            System.out.println(i);
        }

    }
}
