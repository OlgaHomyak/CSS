import org.junit.Assert;
import org.junit.Test;


public class MyHomeworkTests {

    /*
    В случае отказа от посещения мероприятия по причинам, не связанным с отменой/переносом мероприятия, посетитель имеет право при возврате билета:
    1) более 10 дней - получить обратно полную стоимость билетов;
    2) от 6 до 10 дней включительно - получить только 50% стоимости билетов;
    3) от 3 до 6 дней включительно - получить 30% стоимости билетов;
    4) 72 часа и менее до начала концерта - стоимость билетов не возвращается.
     */
    @Test

    public void  fullСost(){
        var actualResult = getRefundTicketPricePercent(241, false,false);
        Assert.assertEquals(100L, actualResult.longValue());
    }
    @Test

    public void  halfСost(){
        var actualResult = getRefundTicketPricePercent(145, false,false);
        Assert.assertEquals(50L, actualResult.longValue());
    }
    @Test

    public void  thirdСost(){
        var actualResult = getRefundTicketPricePercent(73, false,false);
        Assert.assertEquals(30L, actualResult.longValue());
    }
    @Test

    public void  zeroСost(){
        var actualResult = getRefundTicketPricePercent(72, false,false);
        Assert.assertEquals(0L, actualResult.longValue());
    }
    @Test

    public void  cancellationConcert(){
        var actualResult = getRefundTicketPricePercent(241, true,false);
        Assert.assertEquals(100L, actualResult.longValue());
    }
    @Test

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

}
