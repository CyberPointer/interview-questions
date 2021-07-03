import java.util.*;
import java.util.stream.Collectors;

public class InterViewQuestions {

    private final HashMap<String, String[]> hobbies = new HashMap<>();

    public void add(String hobbyist, String... hobbies) {
        this.hobbies.put(hobbyist, hobbies);
    }

    public List<String> findAllHobbyistsImperative(String hobby) {
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, String[]> entry : hobbies.entrySet()) {
            String keyHobbyist = entry.getKey();
            String[] valueHobbies = entry.getValue();

            for (String value : valueHobbies) {
                if (value.equals(hobby)) {
                    if (!result.contains(keyHobbyist)) {
                        result.add(keyHobbyist);
                        break;
                    }
                }
            }
        }
        return result;
    }

    public List<String> findAllHobbyistsLambda(String hobby) {

        List<String> result = hobbies.entrySet()
                .stream()
                .map(map -> {
                    long found = Arrays.stream(map.getValue())
                            .filter(searchedHobby -> searchedHobby.equals(hobby))
                            .count();
                    if (found == 0) return null;
                    else return map.getKey();
                })
                .filter(x -> (x != null))
                .collect(Collectors.toList());

        return result;
    }


    public static String reverseMethod(String toBeReversed) {
        StringBuilder result = new StringBuilder();

        for (int i = toBeReversed.length() - 1; i >= 0; i--) {
            result.append(toBeReversed.charAt(i));
        }
        return result.toString();
    }

    public static int findMaxSum(List<Integer> list) {
        Map<Integer, Integer> biggestValues = new HashMap<>();
        biggestValues.put(0, 0);
        biggestValues.put(1, 0);

        for (Integer i = 0; i < list.size(); i++) {
            if (biggestValues.get(0) <= list.get(i)) {
                biggestValues.put(1, biggestValues.get(0));
                biggestValues.put(0, list.get(i));
            }
        }
        return biggestValues.get(0) + biggestValues.get(1);
    }


    public static void main(String[] args) {

        System.out.println(reverseMethod("abcdefg"));
        System.out.println(findMaxSum(List.of(5, 7, 9, 11)));
        System.out.println(findMaxSum(List.of(1, 1, 1, 1)));
        System.out.println(findMaxSum(List.of(0, 1)));
        System.out.println(findMaxSum(List.of(1)));

        InterViewQuestions interViewQuestions = new InterViewQuestions();

        interViewQuestions.add("Steve", "Fashion", "Piano", "Reading");
        interViewQuestions.add("Patty", "Drama", "Magic", "Pets");
        interViewQuestions.add("Chad", "Puzzles", "Pets", "Yoga");

        System.out.println(interViewQuestions.findAllHobbyistsImperative("Yoga"));
        System.out.println(interViewQuestions.findAllHobbyistsLambda("Reading"));
        System.out.println(interViewQuestions.findAllHobbyistsLambda("Yoga"));
        System.out.println(interViewQuestions.findAllHobbyistsLambda("Drama"));
        
    }
}
