package com.fyp.scord;

public class RoundLocal extends Round {

    private int front9;
    private int back9;
    private int score;



public RoundLocal(){}

    public RoundLocal(int hole1,int hole2,int hole3,int hole4,int hole5,int hole6,int hole7,int hole8,int hole9,
                      int hole10,int hole11,int hole12,int hole13,int hole14,int hole15,int hole16,int hole17,int hole18,String date,String golfCourse,int front9, int back9, int score)
    {
        super(hole1,hole2,hole3,hole4,hole5,hole6,hole7,hole8,hole9,
        hole10,hole11,hole12,hole13,hole14,hole15,hole16,hole17,hole18,date,golfCourse);
        this.front9 = front9;
        this.back9 = back9;
        this.score = score;
    }

   public int getFront9()
   {
       front9 = getHole1() + getHole2() + getHole3() + getHole4() + getHole5() + getHole6() + getHole7() + getHole8() + getHole9();
        return front9;
    }

    public void setFront9( )
    {
        this.front9 = getF9(getHole1(),getHole2(),getHole3(),getHole4(),getHole5(),getHole6(),getHole7(),getHole8(),getHole9());
    }

    public int getBack9()
    {
    back9 = getHole10() + getHole11() + getHole12() + getHole13() + getHole14() + getHole15() + getHole16() + getHole17() + getHole18() ;
    return back9;
    }

    public void setBack9()
    {

        this.back9 = getB9(getHole10(),getHole11(),getHole12(),getHole13(),getHole14(),getHole15(),getHole16(),getHole17(),getHole18());
    }

    public int getScore()
    {
        score = getHole1() + getHole2() + getHole3() + getHole4() + getHole5() + getHole6() + getHole7() + getHole8() + getHole9() +
                getHole10() + getHole11() + getHole12() + getHole13() + getHole14() + getHole15() + getHole16() + getHole17() + getHole18() ;
        return score;
    }

    public void setScore()
    {

        this.score =getS(getHole1(),getHole2(),getHole3(),getHole4(),getHole5(),getHole6(),getHole7(),getHole8(),getHole9(),getHole10(),getHole11(),getHole12(),getHole13(),getHole14(),getHole15(),getHole16(),getHole17(),getHole18());
    }





}
