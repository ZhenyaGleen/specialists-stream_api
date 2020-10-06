import model.Specialists;
import model.Speciality;
import util.StreamAPIUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Specialists> listSpecialist = StreamAPIUtil.getSpecialists();

        List<Specialists> filterBySpecialty = StreamAPIUtil.filterBySpecialty(listSpecialist, Speciality.ENGINEER);
        StreamAPIUtil.printListSpecialist(filterBySpecialty);


        List<Specialists> sortSpecialistsByNameAsc = StreamAPIUtil.sortSpecialistsByNameAsc(listSpecialist);
        StreamAPIUtil.printListSpecialist(sortSpecialistsByNameAsc);

        List<Specialists> sortSpecialistsByNameDesc = StreamAPIUtil.sortSpecialistsByNameDesc(listSpecialist);
        StreamAPIUtil.printListSpecialist(sortSpecialistsByNameDesc);

        boolean matchAllEngineers = StreamAPIUtil.matchAllEngineers(listSpecialist, Speciality.ENGINEER);
        System.out.println(matchAllEngineers);

        boolean matchAnyEngineer = StreamAPIUtil.matchAnyEngineer(listSpecialist, Speciality.ENGINEER);
        System.out.println(matchAnyEngineer);

        boolean matchAllSalaryMoreThen = StreamAPIUtil.matchAllSalaryMoreThen(listSpecialist, new BigDecimal(1));
        System.out.println(matchAllSalaryMoreThen);

        boolean matchNoneSalaryMoreThen = StreamAPIUtil.matchNoneSalaryMoreThen(listSpecialist, new BigDecimal(9000));
        System.out.println(matchNoneSalaryMoreThen);

        Specialists findWithMinSalary = StreamAPIUtil.findWithMinSalary(listSpecialist);
        System.out.println(findWithMinSalary);

        Specialists findWithMaxSalary = StreamAPIUtil.findWithMaxSalary(listSpecialist);
        System.out.println(findWithMaxSalary);

        Map<Speciality, List<Specialists>> groupBySpecialty = StreamAPIUtil.groupBySpecialty(listSpecialist);
        System.out.println(groupBySpecialty);
    }
}
