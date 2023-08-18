
public class EnumDemo
{
    enum WorkDay {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY};
    enum PezColor {Yellow, Pink, Orange};

    public static void main(String[] args)
    {
        WorkDay startDay = WorkDay.MONDAY;
        WorkDay endDay = WorkDay.FRIDAY;

        System.out.println("Work starts on " + startDay);
        System.out.println("Work ends on " + endDay);
        System.out.println(WorkDay.MONDAY.toString());
        System.out.println(WorkDay.MONDAY.ordinal());
        System.out.println(endDay.ordinal());
        System.out.println(WorkDay.MONDAY.compareTo(endDay));
        System.out.println(WorkDay.valueOf("MONDAY")); // a static method
        System.out.println(WorkDay.valueOf("monday")); // this will not work     
        System.out.println(WorkDay.valueOf("MONDAY")); // a static method
    }
}
