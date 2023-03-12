import java.util.Scanner;
import java.util.*;


public class TrainReservationSystem {
    static int charge[] = {1,2,3,4};

    public static void main(String[] args) {
    ArrayList<ArrayList<String>> Booked = new ArrayList<>();
     String pnr = "100000001";
     Integer totalcharge = 0;
        Scanner sc = new Scanner(System.in);
        int totalTrains = sc.nextInt();
         sc.nextLine();
        ArrayList<String> Trains =new ArrayList<>();
        HashMap<Integer,String> trainDetails = new HashMap<>();
        ArrayList<String> trainroute = new ArrayList<>();
        int count = 1;
        for(int i = 0; i < totalTrains; i++){
            String train = sc.nextLine();
            String seats = sc.nextLine();
            String[] spl1 = train.split(" "); 
            trainroute.add(spl1[1]);
            trainroute.add(spl1[2]);
            Trains.add(train);
            trainDetails.put(count,seats);
            count++;
        } 

        String booking  = sc.nextLine();
        String bookingspl[] = booking.split(" ");
        int sequence = 0;
        for(int i = 0; i < trainroute.size(); i++){
            if(i %2 ==0){
                 String getspl[] = trainroute.get(i).split("-");//.substring(0,trainroute.size()-2);

                    if(bookingspl[0] == getspl[0]){
                        String getspl2[] = trainroute.get(i).split("-");
                        if(bookingspl[1] == getspl2[0]){
                            sequence = i;
                            break;
                        }
                    }
             }
             sequence = sequence/2;
             String space = "";
             space += trainDetails.get(sequence);
             String spacespl[] = space.split(" ");
             String coach = bookingspl[3];
             int coachIndex = 0;
             if(coach == "1A"){
                for(int j = 1; j < spacespl.length; j++){
                    String AvailableCoach = spacespl[i].substring(0,1);
                    if(AvailableCoach == "H"){
                        coachIndex = i;
                        ArrayList<String> data = new ArrayList<>();
                        data.add(booking);
                        data.add(pnr);
                        Integer updatePNR = Integer.parseInt(pnr);
                        updatePNR++;
                        pnr = updatePNR.toString();
                        String Traindata = Trains.get(sequence);
                        String spl[] = Traindata.split(" ");
                        String chargespl[] = spl[2].split("-");
                        totalcharge += Integer.parseInt(chargespl[1]);
                        totalcharge *= Integer.parseInt(bookingspl[4]);
                        totalcharge *= charge[3];
                        String StringCharge = totalcharge.toString();
                        data.add(StringCharge);
                        System.out.println(data.get(1) + " " + data.get(2));
                        Booked.add(data);
                        break;
                    }
                }
            }else if(coach == "2A"){
                for(int j = 1; j < spacespl.length; j++){
                    String AvailableCoach = spacespl[i].substring(0,1);
                    if(AvailableCoach == "A"){
                        coachIndex = i;
                        ArrayList<String> data = new ArrayList<>();
                        data.add(booking);
                        data.add(pnr);
                        Integer updatePNR = Integer.parseInt(pnr);
                        updatePNR++;
                        pnr = updatePNR.toString();
                        String Traindata = Trains.get(sequence);
                        String spl[] = Traindata.split(" ");
                        String chargespl[] = spl[2].split("-");
                        totalcharge += Integer.parseInt(chargespl[1]);
                        totalcharge *= Integer.parseInt(bookingspl[4]);
                        totalcharge *= charge[2];
                        String StringCharge = totalcharge.toString();
                        data.add(StringCharge);
                        System.out.println(data.get(1) + " " + data.get(2));
                        Booked.add(data);
                        break;
                    }
                }
            }else if(coach == "3A"){
                for(int j = 1; j < spacespl.length; j++){
                    String AvailableCoach = spacespl[i].substring(0,1);
                    if(AvailableCoach == "B"){
                        coachIndex = i;
                        ArrayList<String> data = new ArrayList<>();
                        data.add(booking);
                        data.add(pnr);
                        Integer updatePNR = Integer.parseInt(pnr);
                        updatePNR++;
                        pnr = updatePNR.toString();
                        String Traindata = Trains.get(sequence);
                        String spl[] = Traindata.split(" ");
                        String chargespl[] = spl[2].split("-");
                        totalcharge += Integer.parseInt(chargespl[1]);
                        totalcharge *= Integer.parseInt(bookingspl[4]);
                        totalcharge *= charge[1];
                        String StringCharge = totalcharge.toString();
                        data.add(StringCharge);
                        System.out.println(data.get(1) + " " + data.get(2));
                        Booked.add(data);
                        break;
                    }
                }
            }else if(coach == "SL"){
                for(int j = 1; j < spacespl.length; j++){
                    String AvailableCoach = spacespl[i].substring(0,1);
                    if(AvailableCoach == "S"){
                        coachIndex = i;
                        ArrayList<String> data = new ArrayList<>();
                        data.add(booking);
                        data.add(pnr);
                        Integer updatePNR = Integer.parseInt(pnr);
                        updatePNR++;
                        pnr = updatePNR.toString();
                        String Traindata = Trains.get(sequence);
                        String spl[] = Traindata.split(" ");
                        String chargespl[] = spl[2].split("-");
                        totalcharge += Integer.parseInt(chargespl[1]);
                        totalcharge *= Integer.parseInt(bookingspl[4]);
                        totalcharge *= charge[0];
                        String StringCharge = totalcharge.toString();
                        data.add(StringCharge);
                        System.out.println(data.get(1) + " " + data.get(2));
                        Booked.add(data);
                        break;
                    }
                }
            }
            String newone[] = spacespl[coachIndex].split("-");
            Integer AvailableSeats = Integer.parseInt(newone[1]);
            int NeedOfTicket = Integer.parseInt(bookingspl[4]);
            if(NeedOfTicket < AvailableSeats){
                AvailableSeats -= NeedOfTicket;
            }else{
                System.out.println("NO TRAIN AVAILABLE");
            }
            
            //updating seats
            String ASeats = AvailableSeats.toString();
            String forUpdate = spacespl[coachIndex];
            forUpdate.substring(3, forUpdate.length());
            forUpdate += ASeats;
            spacespl[coachIndex] = forUpdate;
            String Updated = "";
                for(int k = 0; k < spacespl.length; k++){
                    if(k == spacespl.length-1){
                    Updated += spacespl[0];
                    break;
                    }else{
                        Updated += " ";
                    }
                }
            trainDetails.put(sequence,Updated);

        }
        
    }
}
