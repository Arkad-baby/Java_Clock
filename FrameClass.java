
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;


public class FrameClass extends JFrame {
 LocalTime currentTime ;
 DayOfWeek  currentDay ;
 LocalDate currentDate ;
 
  DateTimeFormatter time_formatter;
  DateTimeFormatter dateFormatter;
  DateTimeFormatter dayFormatter;

    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    public FrameClass() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock Program");
        this.setLayout(new FlowLayout());
        this.setSize(350, 200);
        this.setResizable(false);

        time_formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dayFormatter = DateTimeFormatter.ofPattern("EEEE");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);
        
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free",Font.PLAIN,35));
        
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free",Font.PLAIN,25));
        

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        timer.start();
        this.add(timeLabel);  
        this.add(dayLabel);  
        this.add(dateLabel);  

        this.setVisible(true);

    }
    private void updateTime(){
        currentTime=LocalTime.now();
        timeLabel.setText(currentTime.format(time_formatter));

        
        currentDate=LocalDate.now();
        dateLabel.setText(currentDate.format(dateFormatter));
        
        currentDay=currentDate.getDayOfWeek();
        dayLabel.setText(currentDate.format(dayFormatter));
    
    }
}
