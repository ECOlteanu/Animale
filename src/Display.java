import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.io.File;

public class Display implements ActionListener {

    private JFrame frame;

    Display() {
        frame = new JFrame();

        createAnimalButton("PAPAGAL", "african-grey-parrot.png", "african-grey-parrot.wav", 30, 30);
        createAnimalButton("CROCODIL", "alligator.png", "alligator.wav", 30, 200);
        createAnimalButton("MAIMUTA", "ape.png", "ape.wav", 30, 370);
        createAnimalButton("ALBINA", "bee.png", "bee.wav", 30, 540);
        createAnimalButton("LILIAC", "bat.png", "bat.wav", 30, 710);
        createAnimalButton("CAMILA", "camel.png", "camel.wav", 200, 30);
        createAnimalButton("PISICA", "cat.png", "cat.wav", 200, 200);
        createAnimalButton("GAINA", "chicken.png", "chicken.wav", 200, 370);
        createAnimalButton("VACA", "cow.png", "cow.wav", 200, 540);
        createAnimalButton("CIOARA", "crow.png", "crow.wav", 200, 710);
        createAnimalButton("CAINE", "dog.png", "dog.wav", 370, 30);
        createAnimalButton("PORUMBEL", "dove.png", "dove.wav", 370, 200);
        createAnimalButton("RATA", "duck.png", "duck.wav", 370, 370);
        createAnimalButton("ELEFANT", "elephant.png", "elephant.wav", 370, 540);
        createAnimalButton("BROASCA", "frog.png", "frog.wav", 370, 710);
        createAnimalButton("CAL", "horse.png", "horse.wav", 540, 30);
        createAnimalButton("LEU", "lion.png", "lion.wav", 540, 200);
        createAnimalButton("BUFNITA", "owl.png", "owl.wav", 540, 370);
        createAnimalButton("PORC", "pig.png", "pig.wav", 540, 540);
        createAnimalButton("SOARECE", "rat.png", "rat.wav", 540, 710);
        createAnimalButton("SARPE", "rattlesnake.png", "rattlesnake.wav", 710, 30);
        createAnimalButton("CURCAN", "turkey.png", "turkey.wav", 710, 200);
        createAnimalButton("LUP", "wolf.png", "wolf.wav", 710, 370);
        createAnimalButton("COCOS", "rooster.png", "rooster.wav", 710, 540);
        createAnimalButton("RINOCER", "rhinoceros.png", "rhinoceros.wav", 710, 710);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 905, 930);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setForeground(SystemColor.window);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Cristi Olteanu\\eclipse-workspace\\Stockmanagement\\src\\PngItem_215083.png"));
        frame.setTitle("Eva Anastasia's Animal Sounds Game");
    }

    private void createAnimalButton(String toolTip, String imageName, String soundFileName, int x, int y) {
        JButton animalButton = new JButton();
        Image animalImg = new ImageIcon(imageName).getImage();
        Image newAnimal = animalImg.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon newAnimalIcon = new ImageIcon(newAnimal);
        animalButton.setIcon(newAnimalIcon);
        animalButton.setBounds(x, y, 150, 150);
        animalButton.setFocusable(false);
        animalButton.setToolTipText(toolTip);
        animalButton.addActionListener(this);
        animalButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        frame.add(animalButton);
        animalButton.setActionCommand(soundFileName);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String soundFileName = e.getActionCommand();

        Thread soundThread = new Thread(() -> {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFileName).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        soundThread.start();
    }

    public static void main(String[] args) {
        new Display();
    }
}