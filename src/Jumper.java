public class Jumper {
     private static int counterJumper = 0;

     private int jumpCounter = 0;


    public Jumper(int jumpCounter) {
        this.jumpCounter = jumpCounter;


        ////osiem ruchow skoczka
        EightJumpOfJumper eightJumpOfJumper = new EightJumpOfJumper(jumpCounter);

        startJumper(eightJumpOfJumper);

    }



    public void startJumper(EightJumpOfJumper eightJumpOfJumper) {


        eightJumpOfJumper.startJump();

    }


}
