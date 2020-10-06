package util;

import model.Specialists;
import model.Speciality;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPIUtil {

    public static List<Specialists> getSpecialists() {
        return List.of(
                new Specialists("Ivan Ivanov", new BigDecimal(5000), Speciality.ENGINEER),
                new Specialists("Alexander Alexandrov", new BigDecimal(4000), Speciality.ENGINEER),
                new Specialists("Sergey Sergeev", new BigDecimal(3000), Speciality.DEVOPS),
                new Specialists("Fedor Fedorov", new BigDecimal(2000), Speciality.DEVOPS),
                new Specialists("Kirill Kirillov", new BigDecimal(10000), Speciality.MANAGER),
                new Specialists("Petr Petrov", new BigDecimal(10000), Speciality.MANAGER)
        );
    }

    public static List<Specialists> printListSpecialist(List<Specialists> specialists) {
        specialists.forEach(System.out::println);
        return specialists;
    }

    public static List<Specialists> filterBySpecialty(List<Specialists> specialists, Speciality speciality) {
        return specialists.stream().filter(specialists1 -> specialists1.getSpeciality()
                .equals(speciality))
                .collect(Collectors.toList());
    }

    public static List<Specialists> sortSpecialistsByNameAsc(List<Specialists> specialists) {
        return specialists.stream().sorted(Comparator.comparing(Specialists::getName))
                .collect(Collectors.toList());
    }

    public static List<Specialists> sortSpecialistsByNameDesc(List<Specialists> specialists) {
        return specialists.stream().sorted(Comparator.comparing(Specialists::getName).reversed())
                .collect(Collectors.toList());
    }

    public static boolean matchAllEngineers(List<Specialists> specialists, Speciality speciality) {
        return specialists.stream().allMatch(specialists1 -> specialists1.getSpeciality()
                .equals(speciality));
    }

    public static boolean matchAnyEngineer(List<Specialists> specialists, Speciality speciality) {
        return specialists.stream().anyMatch(specialists1 -> specialists1.getSpeciality().equals(speciality));

    }

    public static boolean matchAllSalaryMoreThen(List<Specialists> specialists, BigDecimal salary) {
        return specialists.stream().allMatch(specialists1 -> specialists1.getSalary().compareTo(salary) > 0);
    }

    public static boolean matchNoneSalaryMoreThen(List<Specialists> specialists, BigDecimal salary) {
        return specialists.stream().noneMatch(specialists1 -> specialists1.getSalary().compareTo(salary) > 0);
    }

    public static Specialists findWithMaxSalary(List<Specialists> specialists) {
        return specialists.stream().max(Comparator.comparing(Specialists::getSalary)).orElse(null);
    }

    public static Specialists findWithMinSalary(List<Specialists> specialists) {
        return specialists.stream().min(Comparator.comparing(Specialists::getSalary)).orElse(null);
    }

    public static Map<Speciality, List<Specialists>> groupBySpecialty(List<Specialists> specialists) {
        return specialists.stream()
                .collect(Collectors.groupingBy(Specialists::getSpeciality));
    }
}
