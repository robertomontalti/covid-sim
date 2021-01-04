package Simulation;

import java.util.Random;
import java.util.function.Function;
/**
 *
 * @author simon
 */
public class InfectionImpl implements Function<Person, Boolean> {
    //vedere uso
    private static int INF_RADIUS = 5;
    @Override

    public Boolean apply(Person p) {
        return infection(p);
    }

    public boolean infection(Person p) {
        if(!p.isInfected()){
            int param = checkTrasmissibility(p);
            if(param == 100){
                return true;
            }else{
                // se trasm piu di 60 generi numero random da 0 a 100 e se num > complementare, infetti
                //else se trasm meno di 60% generi numero random da 0 a 100 e se num > complementare, infetti
                Random rand = new Random();
                final int upperbound = 101;
                if(rand.nextInt(upperbound) >= (100 - param)){
                    return true;
                }
            }
        }
        return false;
    }
    //infection depends from Mask status
    // mask status 70% mask type 30%
    private int checkTrasmissibility(Person p){
        //percentage of trasmissibility
        int perc = 0;
        //Migliorabile
        //check maskStatus (if Down is 70%)
        perc += 70 - (70 * p.getMask().getProtection().ordinal() / 2);
        //check maskProtection (if FFP1 perc is 30%)        
        perc += 30 - 10 * (p.getMask().getProtection().ordinal());
        return perc;
    }
    //calcolare indice di trasmissibilita attraverso parametri : mask, protMask, MaskStat from 0 to 10
    //es: se mascherina down e FFP1 = 100%
}