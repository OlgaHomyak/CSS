import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyHomeworkTests {

    /*
    В случае отказа от посещения мероприятия по причинам, не связанным с отменой/переносом мероприятия, посетитель имеет право при возврате билета:
    1) более 10 дней - получить обратно полную стоимость билетов;
    2) от 6 до 10 дней включительно - получить только 50% стоимости билетов;
    3) от 3 до 6 дней включительно - получить 30% стоимости билетов;
    4) 72 часа и менее до начала концерта - стоимость билетов не возвращается.
     */
    @Test
    @DisplayName("Возрат за 241 час")
    public void  fullСost(){
        var actualResult = getRefundTicketPricePercent(241, false,false);
        Assert.assertEquals(100L, actualResult.longValue());
    }
    @Test
    @DisplayName("Возрат за 145 час")
    public void  halfСost(){
        var actualResult = getRefundTicketPricePercent(145, false,false);
        Assert.assertEquals(50L, actualResult.longValue());
    }
    @Test
    @DisplayName("Возрат за 145 час")
    public void  thirdСost(){
        var actualResult = getRefundTicketPricePercent(73, false,false);
        Assert.assertEquals(30L, actualResult.longValue());
    }
    @Test
    @DisplayName("Возрат за 145 час")
    public void  zeroСost(){
        var actualResult = getRefundTicketPricePercent(72, false,false);
        Assert.assertEquals(0L, actualResult.longValue());
    }
    @Test
    @DisplayName("Отмена концерта")
    public void  cancellationConcert(){
        var actualResult = getRefundTicketPricePercent(241, true,false);
        Assert.assertEquals(100L, actualResult.longValue());
    }
    @Test
    @DisplayName("Перенос концерта")
    public void  reschedulingConcert(){
        var actualResult = getRefundTicketPricePercent(241, false,true);
        Assert.assertEquals(100L, actualResult.longValue());
    }
    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled)
    {
        if(wasConcertCancelled && wasConcertRescheduled) return 100;
        if(hoursBeforeConcert > 240) return 100;
        if(hoursBeforeConcert >= 144 && hoursBeforeConcert <= 240) return 50;
        if(hoursBeforeConcert > 3 && hoursBeforeConcert <= 144) return 30;
        return 0;
    }


    /*
    Всего ученик может заработать максимум 100 баллов, минимум 0.
    Его оценка за экзамен может принимать следующие значения: 2, 3, 4 или 5.

    Если ученик получил за экзамен:
    - от 0 баллов (включительно) до 35 (включительно), его оценка равна 2;
    - от 35 баллов (не включительно) до 56 (включительно), его оценка равна 3;
    - от 56 баллов (не включительно) до 71 (включительно), его оценка равна 4;
    - от 72 баллов (включительно) до 100 баллов (включительно), его оценка равна 5.
     */
    @org.junit.Test
    public void  markTwo1(){
        var actualResult = getMarkResult(0);
        Assert.assertEquals("2", actualResult);
    }
    @org.junit.Test
    public void  markTwo2(){
        var actualResult = getMarkResult(35);
        Assert.assertEquals("2", actualResult);
    }
    @org.junit.Test
    public void  markThree1 (){
        var actualResult = getMarkResult(36);
        Assert.assertEquals("3", actualResult);
    }
    @org.junit.Test
    public void  markThree2 (){
        var actualResult = getMarkResult(56);
        Assert.assertEquals("3", actualResult);
    }
    @org.junit.Test
    public void  markFour1(){
        var actualResult = getMarkResult(70);
        Assert.assertEquals("4", actualResult);
    }
    @org.junit.Test
    public void  markFour2(){
        var actualResult = getMarkResult(57);
        Assert.assertEquals("4", actualResult);
    }
    @org.junit.Test
    public void  markFive1(){
        var actualResult = getMarkResult(72);
        Assert.assertEquals("5", actualResult);
    }
    @org.junit.Test
    public void  markFive2(){
        var actualResult = getMarkResult(73);
        Assert.assertEquals("5", actualResult);
    }
    private String getMarkResult(Integer mark)
    {
        if(mark >= 0 && mark <= 35) return "2";
        if(mark > 35 && mark <= 56) return "3";
        if(mark > 56 && mark < 71) return "4";
        if(mark > 72 && mark < 100) return "5";
        return "no mark result";
    }

}
