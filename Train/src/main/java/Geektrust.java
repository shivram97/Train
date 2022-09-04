import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Geektrust {

    public static void main(String[] args) {

        String filePath = args[0];

        try
        {
            FileInputStream fis=new FileInputStream(filePath);
            Scanner sc=new Scanner(fis);    //file to be scanned
                // fill hyderabad arrival details in Trains A and B
                String[] trainA= sc.nextLine().split(" ");
                String[] trainB= sc.nextLine().split(" ");
                LinkedList<String> arrivalA= new LinkedList<>();
                arrivalA.add("ARRIVAL");
                arrivalA.addAll(Arrays.asList(trainA));
                LinkedList<String> arrivalB= new LinkedList<>();
                arrivalB.add("ARRIVAL");
                arrivalB.addAll(Arrays.asList(trainB));


                //arrival details to train A and B
                arrival(arrivalA,arrivalB);

                //print the details of arraival
                for(String stop:arrivalA){
                    System.out.print(stop+" ");
                }System.out.print("\n");
                for(String stop:arrivalB){
                    System.out.print(stop+" ");
                }System.out.print("\n");

                ArrayList<String> trainAB = new ArrayList<>();
                // incase no bogies after arrival at Hyderabad
                if(arrivalA.size()==3 &&arrivalB.size()==3){
                    System.out.println("JOURNEY_ENDED");
                    return;
                }

                //departure details of train AB
                departure(arrivalA,arrivalB,trainAB);
                for(String stop:trainAB){
                    System.out.print(stop+" ");
                }System.out.print("\n");




            sc.close();     //closes the scanner
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }



    public static void arrival( LinkedList arrivalA,LinkedList arrivalB){



        List<String> previousA= new ArrayList<String>();
        previousA.add("CHN");
        previousA.add("SLM");
        previousA.add("BLR");
        previousA.add("KRN");
        List<String> previousB= new ArrayList<String>();
        previousB.add("TVC");
        previousB.add("SRR");
        previousB.add("MAQ");
        previousB.add("MAO");
        previousB.add("PNE");

        //remove stations before hyderabad from train A
        for(String station: previousA){
            while(arrivalA.contains(station)){
                arrivalA.remove(station);
            }
        }

        //remove stations before hyderabad from train B
        for(String station: previousB){
            while(arrivalB.contains(station)){
                arrivalB.remove(station);
            }
        }


    }


    public static void departure(LinkedList arrivalA,LinkedList arrivalB,ArrayList<String> trainAB){
//         fill hyderabad departure details in Trains AB

        // stations after hyderabad in descending order
        List<String> stations = new ArrayList<>();
        stations.add("GHY");
        stations.add("NJP");
        stations.add("PTA");
        stations.add("NDL");
        stations.add("AGA");
        stations.add("BPL");
        stations.add("ITJ");
        stations.add("NGP");


        trainAB.add("DEPARTURE");
        trainAB.add("TRAIN_AB");



        if(arrivalA.size()>3){
            trainAB.add("ENGINE");
        }
        if(arrivalB.size()>3){
            trainAB.add("ENGINE");
        }


        for(String station:stations){
            while(arrivalA.contains(station)){
                arrivalA.remove(station);
                trainAB.add(station);
            }
            while(arrivalB.contains(station)){
                arrivalB.remove(station);
                trainAB.add(station);
            }
        }
    }
}
