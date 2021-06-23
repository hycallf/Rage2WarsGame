package tcg_osom;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import tcg_osom.BannerGacha;
import tcg_osom.Pool;
import tcg_osom.PoolModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;


public class Gacha {

    public static List<PoolModel> characters = new ArrayList<>();
    private static Integer counter = 0;

    public static void main(String[] args) {
    }

    public static List<PoolModel> huntMenu(){
        Pool gacha = new Pool();
        List<PoolModel> characterList = gacha.pickTen();
        characters.addAll(characterList);
        counterResult();
        increaseCounter();
        
        return characterList;
    }
     public static List<PoolModel> huntMenu1(){
        Pool gacha = new Pool();
        List<PoolModel> characterList = gacha.pickSatu();
        characters.addAll(characterList);
        counterResult();
        increaseCounter();
        
        return characterList;
    }

    private static void increaseCounter(){
    	counter++;
    }

    public static String counterResult(){
        return ("You have retried " + counter + " time(s).");
    }


}




