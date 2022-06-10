// Stream 예제
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class chap20_02 {
    public static void main(String[] args) {
        List<Score> list = new ArrayList<Score>();
        list.add(new Score(95, GENDER.MALE, "Lee"));
        list.add(new Score(90, GENDER.FEMALE, "Kim"));
        list.add(new Score(70, GENDER.MALE, "Park"));
        list.add(new Score(100, GENDER.MALE, "Seo"));

        Stream<Score> stream = list.stream();
        List<String> rList = stream.filter(score->score.getGender()==GENDER.MALE)
        .sorted()
        .map(score->score.getName())
        .collect(Collectors.toList());

        System.out.println(list);
        System.out.println(rList);
    }
    enum GENDER {
        MALE, FEMALE
    }

    static public class Score implements Comparable<Score> {
        private int score;
        private GENDER gender;
        private String name;

        Score(int score, GENDER gender, String name) {
            this.score = score;
            this.gender = gender;
            this.name = name;
        }

        public int getScore(){
            return score;
        }
        public void setScore(int score){
            this.score = score;
        }
        public GENDER getGender(){
            return gender;
        }
        public void setGender(GENDER gender){
            this.gender = gender;
        }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
        @Override
        public int compareTo(Score target){
           return score - target.score;
        }

        @Override 
        public String toString(){
            return "Score [score="+ score + ", gender=" +gender+", name ="+name+"]";
        }
    }
}
