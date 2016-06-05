import java.io.*;
import java.util.concurrent.TimeUnit.*;
import com.sun.speech.freetts.*;

public class facialExercises{

   private static final String VOICENAME="kevin";
   private Voice voice;
   private VoiceManager vm;
   
   public static void main(String []args){
      facialExercises facial = new facialExercises();
   }

   public facialExercises(){
      vm = VoiceManager.getInstance();
      voice = vm.getVoice(VOICENAME);
      
      voice.allocate();
      
      try{
         int exercise = 1;
         while(exercise != 0){
            switch(exercise){
               case 1:
                  voice.speak("Exercise 1 - smile eye loose");
                  facialCounter();
                  exercise = 2;
                  break;
                  
               case 2:
                  voice.speak("Exercise 2 - snarl");
                  facialCounter();
                  exercise = 3;
                  break;
                  
               case 3:
                  voice.speak("Exercise 3 - lip press");
                  facialCounter();
                  exercise = 4;
                  break;
                  
               case 4:
                  voice.speak("Exercise 4 - kiss");
                  facialCounter();
                  exercise = 0;
                  break;
            }
         }
      }
      catch(Exception e){
         
      }
   }
   
   public void facialCounter(){
      String[] numToWord = {
         "","one"," two"," three"," four"," five"," six"," seven"," eight"," nine","ten","eleven","twelve"," thirteen","fourteen","fiveteen","sixteen","seventeen","eighteen","nineteen","twenty"
      };
      
      for(int i=1;i<=20;i++){
         for(int j=1;j<=15;j++){
            try {
               //TimeUnit.MILLISECONDS.sleep(100);
               Thread.sleep(600);
               voice.speak(numToWord[j]);
            } catch (InterruptedException e) {
                //Handle exception
            }
         }
         voice.speak("Rest - "+numToWord[i]); 
         System.out.println("rest - "+i);
         try{
            Thread.sleep(2000);
         }
         catch (InterruptedException e) {
                //Handle exception
         }
      }
   }
}