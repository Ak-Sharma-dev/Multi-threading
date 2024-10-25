import java.util.*;
import java.util.stream.Collectors;

public class FunctionProgramming {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("a", "ab", "abc", "abcd");
        List<String> result = strings.stream().filter(str -> str.length() <= 3).collect(Collectors.toList());
                System.out.println(result); // Output: [a, ab, abc]

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().mapToInt(val -> val * 2).sum();
                System.out.println(sum); // Output: 30

        List<String> strs = Arrays.asList("apple", "banana", "cherry", "date");
        String res = strs.stream().filter(str -> str.endsWith("e")).findFirst().orElse("Not available");
                System.out.println(res); // Output: apple

        List<String> list = Arrays.asList("apple", "banana", "cherry", "apricot", "blueberry");
        Map<Character, List<String>> groupedByStartLetter = list.stream().collect(Collectors.groupingBy(str -> str.charAt(0)));
                System.out.println(groupedByStartLetter);
        // Output: {a=[apple, apricot], b=[banana, blueberry], c=[cherry]}

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        long count = listOfLists.stream().flatMap(Collection::stream).filter(num -> num % 2 == 0).count();
                System.out.println(count); // Output: 4

        List<Employee> employees = Arrays.asList(
                new Employee("John", 25, 30000),
                new Employee("Jane", 35, 50000),
                new Employee("Jack", 40, 70000),
                new Employee("Jill", 28, 25000),
                new Employee("Jerry", 32, 45000)
        );

        List<String> employeeNames = employees.stream().filter(emp -> emp.getAge() >= 30).sorted((e1, e2) -> (int) (e2.salary - e1.salary)).map(Employee::getName).collect(Collectors.toList());

        System.out.println(employeeNames); // Output: [Jack, Jane, Jerry]

    }
}
