import java.util.Scanner;
import java.util.*;

public class TrainReservationSystem {
    int charge[] = {1,2,3,4};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalTrains = sc.nextInt();
        ArrayList<String> Trains =new ArrayList<>();
        HashMap<String> trainDetails = new HashMap<>();
        ArrayList<String> trainroute = new ArrayList<>();
        int count = 1;
        for(int i = 0; i < totalTrains; i++){
            String train = sc.nextLine();
            String seats = sc.nextLine();
            int spl[] = train.split(" ");
            trainroute.add(spl[1]);
            trainroute.add(spl[2]);
            Trains.add(train);
            trainDetails.put(count,seats);
            count++;
        } 
        String booking  = sc.nextLine();
        int bookingspl[] = booking.split(" ");
        int sequence = 0;
        for(int i = 0; i < trainroute.length; i++){
            if(i %2 ==0){
                String get = trainroute.get(i).substring(0,trainroute(i).length()-2);
                    if(bookingspl[0] == get){
                    String get1 = trainroute.get(i+1).substring(0,trainroute(i+1).length()-2);
                        if(bookingspl[1] == get1){
                            sequence = i;
                            break;
                        }
                    }
             }
             sequence = sequence/2;
             String space = trainDetails.get(sequence);
             String spacespl[] = space.split(" ");
             String coach = bookingspl[3];
             int coachIndex = 0;
             if(coach == "1A"){
                for(int j = 1; j < spacespl.length; j++){
                    String AvailableCoach = spacespl[i].substring(0,1);
                    if(AvailableCoach = "H"){
                        coachIndex = i;
                        break;
                    }
                }
            }else if(coach == "2A"){
                for(int j = 1; j < spacespl.length; j++){
                    String AvailableCoach = spacespl[i].substring(0,1);
                    if(AvailableCoach = "A"){
                        coachIndex = i;
                        break;
                    }
                }
            }else if(coach == "3A"){
                for(int j = 1; j < spacespl.length; j++){
                    String AvailableCoach = spacespl[i].substring(0,1);
                    if(AvailableCoach = "b"){
                        coachIndex = i;
                        break;
                    }
                }
            }else if(coach == "SL"){
                for(int j = 1; j < spacespl.length; j++){
                    String AvailableCoach = spacespl[i].substring(0,1);
                    if(AvailableCoach = "S"){
                        coachIndex = i;
                        break;
                    }
                }
            }
            int AvailableSeats = Integer.parseInt(spacespl[coachIndex].substring(2,spacespl.length));
            int NeedOfTicket = Integer.parseInt(bookingspl[4]);
            if(NeedOfTicket < AvailableSeats){
                AvailableSeats -= NeedOfTicket;
            }else{
                System.out.println("NO TRAIN AVAILABLE");
            }
            String ASeats = toString(AvailableSeats);
            String forUpdate = spacespl[coachIndex];
            forUpdate.substring(3, forUpdate.length());
            forUpdate += ASeats;
            spacespl[coachIndex] = forUpdate;
            String Updated = "";
            for(int k = 0; k < spacespl.length; k++){

            }

        }
        
    }
}
