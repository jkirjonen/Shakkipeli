package com.company.JADev;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Intro {

    public static void alku(){
        System.out.println("                                                     _:_");
        System.out.println("                                                    '-.-'");
        System.out.println("                                           ()      __.'.__");
        System.out.println("                                        .-:--:-.  |_______|");
        System.out.println("                                 ()     \\ ___ _/   \\=====/");
        System.out.println("                                /  \\     {====}     )___(");
        System.out.println("                     (  =,     / /\\ \\     )__(     /___ _\\_ ");
        System.out.println("      __    |'-'-'|  /   . \\   (    )    /____\\     |   |");
        System.out.println("     /  \\   |_____| ((  \\   \\_  )  (      |  |      |   |");
        System.out.println("     \\__/    |===|  ))    \\_ ) /__ _\\     |  |      |   |");
        System.out.println("    /____\\   |   |  (/     \\    |  |      |  |      |   |");
        System.out.println("     |  |    |   |   | _.-'|    |  |      |  |      |   |");
        System.out.println("     |__|    )___(    )___(    /___ \\    /_ __\\     /____\\");
        System.out.println("    (====)  (=====)  (=====)  (======)  (======)  (=======)");
        System.out.println("    }===={  }====={  }====={  }======{  }======{  }======={");
        System.out.println("   (______)(_______)(_______)(________)(________)(_________)");
        System.out.println("");
        System.out.println("                 Tervetuloa pelaamaan shakkia!                ");
        System.out.println("");
        System.out.println("      Ladataksesi aiemmin tallennetun pelin paina l ja enter  ");
        System.out.println("              Aloittaaksesi uuden pelin paina   enter");


    }
    private static AudioInputStream audioIn;
    private static Clip clip;

    public static void soita(String soundFile) {
        try {

            File f = new File("./" + soundFile);
            audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(100);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void lopeta(){
        clip.close();
    }
}


