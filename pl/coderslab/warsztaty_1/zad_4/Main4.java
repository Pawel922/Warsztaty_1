package pl.coderslab.warsztaty_1.zad_4;

public class Main4 {

    public static void main(String[] args) {

        int score = rollDice("5D20-1");
        System.out.println("Your score: " + score);

    }

    public static int rollDice(String dice){

        int dIndex = dice.indexOf("D");
        String xStr = dice.substring(0,dIndex);
        int x;
        if(xStr.equals("")){
            x = 1;
        } else {
            x = Integer.parseInt(xStr);
        }

        int y,z;
        int signIndex;

        if(dice.contains("+")){
            signIndex = dice.indexOf("+");
            String yStr = dice.substring(dIndex + 1,signIndex);
            String zStr = dice.substring(signIndex + 1,dice.length());
            y = Integer.parseInt(yStr);
            z = Integer.parseInt(zStr);
        } else if (dice.contains("-")) {
            signIndex = dice.indexOf("-");
            String yStr = dice.substring(dIndex + 1,signIndex);
            String zStr = dice.substring(signIndex,dice.length());
            y = Integer.parseInt(yStr);
            z = Integer.parseInt(zStr);
        } else {
            String yStr = dice.substring(dIndex + 1, dice.length());
            y = Integer.parseInt(yStr);
            z = 0;
        }

        int totalScore = 0;

        for(int i = 0; i < x; i++){
            int singleScore = (int)(1 + Math.random() * y);
            totalScore += singleScore;
        }
        return (totalScore + z);
    }
}
