import java.io.Serializable;

public class Athlete implements Serializable {

    public int athleteNumber;
    public String athleteName;
    public String countryCode;
    public double skiTimeResult;
    public String shootRange1;
    public String shootRange2;
    public String shootRange3;

    public Athlete(int athleteNumber, String athleteName, String countryCode, double skiTimeResult, String shootRange1, String shootRange2, String shootRange3) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.shootRange1 = shootRange1;
        this.shootRange2 = shootRange2;
        this.shootRange3 = shootRange3;
    }

    public double penalty() {
        double penalty = 0;
        String sumShoot = shootRange1 + shootRange2 + shootRange3;
        for (int i = 0; i < sumShoot.length(); i++) {
            if (sumShoot.charAt(i) == 'o') {
                penalty = penalty + 0.10;
            }
        }
        return penalty;
    }

    public double getFinalTime() {
        return skiTimeResult + penalty();
    }

    @Override
    public String toString() {
        return athleteNumber + " " + athleteName + " " + getFinalTime() + " (" + skiTimeResult + "+" + penalty() + ")";
    }

}