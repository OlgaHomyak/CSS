import org.junit.Assert;

public class MyHomeWorkTwo {


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
