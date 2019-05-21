public class APCalendar {

    /** Returns true if year is a leap year and false otherwise. */
    private static boolean isLeapYear(int year) {
        return(year%400 == 0 || year%4 == 0 && year%100 !=0);}

    /** Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
     */
    public static int numberOfLeapYears(int year1, int year2){
        int count = 0;
        for(int i = year1; i <= year2;i++){
            if(isLeapYear(i)){
                count++;
            }
        }
        return count;
    }

    /** Returns the value representing the day of the week for the first day of year,
     * where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
     */
    private static int firstDayOfYear(int year){
        return dayOfYear(1,1,year);
    }

    /** Returns n, where month, day, and year specify the nth day of the year.
     * Returns 1 for January 1 (month = 1, day = 1) of any year.
     * Precondition: The date represented by month, day, year is a valid date.
     */
    private static int dayOfYear(int inMonth, int inDay, int inYear) {
        int month, day, year, c;
        year = inYear;
        day = inDay;

        if (inMonth < 3) {
            year--;
            inMonth = inMonth + 10;
        } else {
            inMonth = inMonth - 2;
        }

        month=inMonth;

        c=year/100;
        year=year%100;

        int A = (int) (day+((2.6*month)-0.2) +year+(year/4)+(c/4)-(2*c));
        int x = A%7;
        if(x<0){
            x+=7;
        }

        return x;
    }

    /** Returns the value representing the day of the week for the given date
     * (month, day, year), where 0 denotes Sunday, 1 denotes Monday, ...,
     * and 6 denotes Saturday.
     * Precondition: The date represented by month, day, year is a valid date.
     */
    public static int dayOfWeek(int month, int day, int year){
        int firstDay = firstDayOfYear(year);
        int dayYear = dayOfYear(month,day,year);
        return(firstDay + dayYear -1)%7;
    }
    // There may be instance variables, constructors, and other methods not shown.
}