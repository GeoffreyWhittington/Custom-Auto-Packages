package sportsauto;

/**
 *
 * @author geoff_000
 */
public class SportsAuto {

    /**
     * @param args the command line arguments
     * @throws sportsauto.Blank_Exception
     */
//    public static void main(String[] args) throws Blank_Exception
//    {
//     Frame1 g = new Frame1(new Sale());
//    }
    
    public void BusinessStartsHere() throws Blank_Exception
    {
        
        Frame1 f = new Frame1(new Sale());
        f.setVisible(true);
        
        
       // double test = sale.ComputeFeaturesCost();
        // sale.setCdChanger(true);
       // boolean CatchersMitt = sale.getCDChanger();
     }
    
    
    
}

