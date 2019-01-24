package animpack;

import java.applet.*;
import java.awt.*;

public class Scroll1 extends Applet
  implements Runnable
{
  Thread timerThread = null;
  String szScrolledText = 
    "Welcome to Java applets!";
  int nStrLength;
  int nPosition;
  int nTitleHeight;
  
  // ============================================
  // init
  // ============================================
  public void init()
  {
    Graphics g = getGraphics();
    nPosition = getSize().width;
    
    g.setFont(new Font(
      "Helvetica", Font.BOLD, 50));
    
    FontMetrics fm = getFontMetrics(g.getFont());
    nStrLength = fm.stringWidth(szScrolledText);
    nTitleHeight = fm.getHeight();
    
    setBackground(Color.yellow);
  }

  // ============================================
  // paint
  // ============================================
  public void paint(Graphics g)
  {
    g.setFont(new Font(
      "Helvetica", Font.BOLD, 50));
    
    g.drawString(szScrolledText, nPosition, 
      nTitleHeight + 10);
      
    nPosition--;
    if(nPosition < -nStrLength)
       nPosition = getSize().width;
  }

  // ============================================
  // start
  // ============================================
  public void start()
  {
    if (timerThread == null)
    {
      timerThread = new Thread(this);
      timerThread.start();
    }
  }
  
  // ============================================
  // stop
  // ============================================
  public void stop()
  {
    if (timerThread != null)
    {
      timerThread.stop();
      timerThread = null;
    }
  }

  // ============================================
  // run
  // ============================================
  public void run()
  {
    while (true)
    {
      try
      {
        repaint();
        Thread.sleep(30);
      }
      catch (InterruptedException ie)
      {
        stop();
      }
    }
  }
  
  // ============================================
  // getAppletInfo
  // ============================================
  public String getAppletInfo()
  {
    return "Name: Scroll1";
  }
}
