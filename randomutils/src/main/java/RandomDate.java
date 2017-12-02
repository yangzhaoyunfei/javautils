import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomDate {


    /**
     * 获取指定日期之间的随机日期含ms
     *Usage:
     * invoke getRandomDate(String beginDate, String endDate),return a standard Date object
     * @param beginDate 起始日期，格式为：yyyyMMdd
     * @param endDate   结束日期，格式为：yyyyMMdd
     * @return
     */
    public Date getRandomDate(String beginDate, String endDate) {
        return this.randomDate(beginDate, endDate);
    }

    private static Date randomDate(String beginDate, String endDate) {

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);

/*getTime()返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。 */
            if (start.getTime() >= end.getTime()) {
                System.out.println("illegal date: startdate later than enddate");
                return null;
            }
            long date = random(start.getTime(), end.getTime());

/*用随机生成的毫秒差来生成时间*/
            return new Date(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    /*自带随机数生成器*/
    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }


}

